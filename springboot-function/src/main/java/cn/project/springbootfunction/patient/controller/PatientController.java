package cn.project.springbootfunction.patient.controller;

import cn.project.springbootcurrency.pojo.Patient;
import cn.project.springbootcurrency.pojo.User;
import cn.project.springbootcurrency.vo.MyMD5Util;
import cn.project.springbootcurrency.vo.ResponseData;
import cn.project.springbootcurrency.vo.Rise;
import cn.project.springbootfunction.patient.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
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
    private PatientService patientService;
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
            }
            if(pageSize<1){
                responseData.setStatus(401);
                responseData.setMessage("查询失败");
                responseData.setData("页面显示条数不能小于1");
            }
            if(status!=0 || status!=null){
                statuss = status;
            }
            if(!name.equals("")||name != null){
                names = name;
            }

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
    @RequestMapping("/updatePatient")
    @ApiOperation(value="修改病原基本信息",httpMethod = "POST",produces = "application/json",protocols = "HTTP",notes = "修改病原基本信息")
    public ResponseData<Object> updateUserAndRole(
            @ApiParam(name="Patient",value="病原实体",required=true)
            @RequestBody Patient patient
    ){
        ResponseData<Object> responseData = new ResponseData<Object>();
        try{
            int count=patientService.updatePatient(patient);
            if (count>0){
                responseData.setStatus(200);
                responseData.setMessage("保存成功");
                responseData.setData(patient);
            }else{
                responseData.setStatus(400);
                responseData.setMessage("保存失败");
                responseData.setData(patient);
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
        }
        return responseData;
    }
}
