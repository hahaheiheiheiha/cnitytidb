package cn.project.springbootfunction.patient.controller;

import cn.project.springbootcurrency.pojo.*;
import cn.project.springbootcurrency.vo.*;
import cn.project.springbootfunction.label.service.LabelService;
import cn.project.springbootfunction.order.service.OrderService;
import cn.project.springbootfunction.p_vip.service.Patient_VipService;
import cn.project.springbootfunction.patient.service.PatientService;
import cn.project.springbootfunction.util.KaHao;
import cn.project.springbootfunction.vip.service.VipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "病员管理控制器类")
public class PatientController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private VipService vipService;
    @Resource
    private KaHao kaHao;
    @Resource
    private PatientService patientService;
    @Resource
    private Patient_VipService patient_vipService;
    @Resource
    private OrderService orderService;
    @Resource
    private LabelService labelService;
    @RequestMapping(value="/selectHuanZheXinXi")
    @ApiOperation(value="根据患者id查询患者详情信息",httpMethod = "GET",produces = "application/json",protocols = "HTTP",notes = "根据患者id查询患者详情信息")
    public ResponseData<Object> selectHuanZheXinXi(
            @ApiParam(value="患者ID",name="id",required = true)
            @RequestParam int id
    ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            Patient patient = patientService.getPatientById(id);
            if(patient!=null){
                responseData.setStatus(200);
                responseData.setMessage("查询成功！");
                responseData.setData(patient);
            }else{
                responseData.setStatus(400);
                responseData.setMessage("查询失败");
                responseData.setData("输入的患者id不存在");
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }
        return responseData;

    }
    @RequestMapping(value="/selectHuanZheDindan")
    @ApiOperation(value="根据患者id查询患者订单信息",httpMethod = "GET",produces = "application/json",protocols = "HTTP",notes = "根据患者id查询患者订单信息")
    public ResponseData<Object> selectHuanZheDindan(
            @ApiParam(value="患者ID",name="id",required = true)
            @RequestParam int id
    ){
        float price = 0f;
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            Patient patient = patientService.getPatientOrderById(id);
            if(patient!=null){
               List<Order> orders= patient.getOrderList();
               for(Order order : orders){
                   price += order.getReal_price();
               }
               patient.setPrice(price);
                responseData.setStatus(200);
                responseData.setMessage("查询成功！");
                responseData.setData(patient);
            }else{
                responseData.setStatus(400);
                responseData.setMessage("查询失败");
                responseData.setData("输入的患者id不存在");
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }
        return responseData;

    }
    @RequestMapping("/addPatient")
    @ApiOperation(value="新增挂号信息",httpMethod = "POST",produces = "application/json",protocols = "HTTP",notes = "对病员表新增数据")
    public ResponseData<Object> addPatient(
            @ApiParam(value = "病员表",name = "patient",required = true)
            @RequestBody PatientVO patient,
            @ApiParam(value="挂号人员Token令牌",name = "token" ,required = true)
            @RequestParam String token
    ){

        ResponseData<Object> responseData = new ResponseData<>();
        try{
            User user = (User) redisTemplate.opsForHash().get("user:"+token,token);
            if(user ==null){
                responseData.setStatus(400);
                responseData.setMessage("");
                responseData.setData("token令牌有误");
            }else{
                if(patient.getIdentity()== null || patient.getIdentity().equals("")){
                    responseData.setStatus(402);
                    responseData.setMessage("新增失败");
                    responseData.setData("请输入身份证号！！");
                }else{
                    int countByIdentity = patientService.getPatientByIdentity(patient.getIdentity());
                    if(countByIdentity>0){

                        responseData.setStatus(403);
                        responseData.setMessage("新增失败");
                        responseData.setData("已存在该患者信息！！");
                        return responseData;

                    }
                    patient.setCardnumber(kaHao.kaHao());
                    patient.setGuadandanhao(kaHao.dinDan("dindan"));
                    patient.setDoctor_id(user.getId());
                    patient.setJiezhenyishen_id(user.getId());
                    int count = patientService.addPatient(patient);
                    if(count>0){
                        Patient_Vip patient_vip = new Patient_Vip();
                        patient_vip.setP_id(patient.getId());
                        int count2 =  patient_vipService.addPatientByPatient_id(patient_vip);
                        patientService.updatePatientVipByV_Id(patient_vip.getId(),patient.getId());
                        Order order = new Order();
                        order.setOrder_state(0);
                        order.setOrder_type(51);
                        order.setOrder_id(patient.getGuadandanhao());
                        order.setName_id(patient.getId());
                        order.setDepartment(patient.getDepartment_id());
                        order.setDoctor_id(patient.getJiezhenyishen_id());
                        float a  =Float.valueOf(labelService.getLabelById(patient.getGuahaoleixing()).getValue());
                        float b  =Float.valueOf(labelService.getLabelById(patient.getZhenliaofei()).getValue());
                        float c = a+b;
                        order.setCount_price(c);
                        float discount=  vipService.getVipByP_id(patient.getId()).getDiscount();
                        order.setReal_price(c*discount);
                        order.setMedical_insurance(c*discount);
                        order.setZhifujine(order.getReal_price()-order.getMedical_insurance());
                        int d = orderService.addOrderByPatient(order);
                        if(d>0){
                            responseData.setStatus(200);
                            responseData.setMessage("新增成功");
                            responseData.setData(count);
                        }else{
                            responseData.setStatus(200);
                            responseData.setMessage("新增失败");
                            responseData.setData("追加订单失败！");
                        }

                    }else{
                        responseData.setStatus(401);
                        responseData.setMessage("新增失败");
                        responseData.setData("发送异常");
                    }
                }

            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }
        return responseData;
    }
    @RequestMapping(value="/selectTiaoJianPaitent")
    @ApiOperation(value="根据条件查询病员信息",httpMethod = "POST",produces = "application/json",protocols = "HTTP",notes = "根据条件查询病员信息")
    public ResponseData<Object> selectTiaoJianPaitent(
            @ApiParam(value="最早创建时间",name="maxDate",required = true)
            @RequestParam Date maxDate,
            @ApiParam(value="最晚创建时间",name="minDate",required = true)
            @RequestParam Date minDate,
            @ApiParam(value="接诊状态",required = false,name="status")
            @RequestParam Integer status,
            @ApiParam(value="患者姓名",required = false,name="name")
            @RequestParam String name,
            @ApiParam(value="第几页",name="page",required = true)
            @RequestParam Integer page,
            @ApiParam(value="每页显示条数",name="pageSize",required = true)
            @RequestParam Integer pageSize
    ){
        ResponseData<Object> responseData = new ResponseData<Object>();
        int statuss = 0;
        String names ="";
        try{
            if(page<1){
                responseData.setStatus(400);
                responseData.setMessage("查询失败");
                responseData.setData("当前页数不能小于1");
                return responseData;
            }
            if(pageSize<1){
                responseData.setStatus(401);
                responseData.setMessage("查询失败");
                responseData.setData("页面显示条数不能小于1");
                return responseData;
            }
            if(status!=0 || status!=null){
                statuss = status;
            }
            if(!name.equals("")||name != null){
                names = name;
            }
            page = (page-1)*pageSize;
            Map<String,Object> map = new HashMap<>();
            map.put("page",page);
            map.put("pageSize",pageSize);
            map.put("maxCreationtime",minDate);
            map.put("minCreationtime",maxDate);
            map.put("name",names);
            map.put("status_id",statuss);
            map.put("type",2);
            List<Patient> patientList = patientService.getPatientList(map);
            responseData.setStatus(200);
            responseData.setMessage("查询成功");
            responseData.setData(patientList);
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }

        return responseData;
    }
    @RequestMapping(value = "/selectPatientListVo")
    @ApiOperation(value = "根据条件查询挂号记录",httpMethod = "POST",protocols = "HTTP",produces = "application/json",notes = "根据条件查询挂号记")
    public ResponseData<Object> selectPatientListVo(
            @ApiParam(value = "条件查询实体类",name = "patientsVO",required = true)
            @RequestBody PatientsVO patientsVO
            ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            List<PatientListVO> patientListVOS = patientService.getPatientListVoByPatientsVo(patientsVO);
            responseData.setStatus(200);
            responseData.setMessage("查询成功");
            responseData.setData(patientListVOS);
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }
        return responseData;
    }
    @RequestMapping(value="/selectListPatient")
    @ApiOperation(value="查询单天待门诊记录",httpMethod = "GET",produces = "application/json",protocols = "HTTP",notes = "查询单天待门诊记录")
    public ResponseData<Object> selectListPatient(
            @ApiParam(value="第几页",name="page",required = true)
            @RequestParam
            Integer page,
            @ApiParam(value="每页显示条数",name="pageSize",required = true)
            @RequestParam
            Integer pageSize
    ){
       ResponseData<Object> responseData = new ResponseData<Object>();
       try{
           Map<String,Object> map = new HashMap<>();
           map.put("page",page);
           map.put("pageSize",pageSize);
           map.put("maxCreationtime","");
           map.put("minCreationtime","");
           map.put("status_id",0);
           map.put("name","");
           map.put("type",1);
           List<Patient> patientList = patientService.getPatientList(map);
           responseData.setStatus(200);
           responseData.setMessage("查询成功");
           responseData.setData(patientList);
       }catch (Exception e){
           responseData.setStatus(500);
           responseData.setMessage("出现异常");
           responseData.setData(e.getMessage());
           e.printStackTrace();
       }

        return responseData;

    }

    @RequestMapping(value="/selectUpGuaHao")
    @ApiOperation(value="查询当天新增挂号人数",httpMethod = "GET",protocols = "HTTP",produces = "applicaion/json",notes = "根据当前时间查询挂号人数")
    public ResponseData<Object> selectUpGuaHao(){
        ResponseData<Object> responseData=new ResponseData<Object>();
        try{
            int status =1 ;
            int type =1;
            Rise rise = new Rise();
            int count = patientService.getGuaHaoByDate(status,type);
            type=2;
            int count2 = patientService.getGuaHaoByDate(status,type);
            rise.setCount(count);
            rise.setName("新增挂号");
            rise.setType("人");
            rise.setUp(count-count2);
            responseData.setStatus(200);
            responseData.setMessage("查询成功");
            responseData.setData(rise);
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }

        return responseData;
    }
    @RequestMapping(value="/selectUpJiuJen")
    @ApiOperation(value="查询当天新增接诊人数",httpMethod = "GET",protocols = "HTTP",produces = "applicaion/json",notes = "根据当前时间查询就诊人数")
    public ResponseData<Object> selectUpJiuJen(){
        ResponseData<Object> responseData=new ResponseData<Object>();
        try{
            int status =2 ;
            int type =1;
            Rise rise = new Rise();
            int count = patientService.getGuaHaoByDate(status,type);
            type=2;
            int count2 = patientService.getGuaHaoByDate(status,type);
            rise.setCount(count);
            rise.setName("新增就诊");
            rise.setType("人");
            rise.setUp(count-count2);
            responseData.setStatus(200);
            responseData.setMessage("查询成功");
            responseData.setData(rise);
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }

        return responseData;
    }
}