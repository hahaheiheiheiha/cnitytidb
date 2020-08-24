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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @RequestMapping(value="/selectListPaitent")
    @ApiOperation(value="查询单天待接诊人信息",httpMethod = "GET",produces = "application/json",protocols = "HTTP",notes = "查询单天待接诊人信息")
    public ResponseData<Object> selectListPaitent(
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
           map.put("status_id","0");
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
