package cn.project.springbootfunction.drug.controller;

import cn.project.springbootcurrency.pojo.*;
import cn.project.springbootcurrency.vo.ResponseData;
import cn.project.springbootfunction.drug.service.DrugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value="药品新开就诊类")
public class DrugController {
    @Autowired
    private DrugService drugService;

    @RequestMapping(value="/getDrugById")
    @ApiOperation(value = "查询所有中/西药",produces = "application/json",protocols = "HTTP",httpMethod = "POST",notes ="查询所有中/西药" )
    public ResponseData<Object> getDrugById(
            @ApiParam(name="drug_c_w",value="中西药（1、中药；2、西药）",required = true)
            @RequestParam int drug_c_w

    ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            List<Drug> drugs=drugService.getDrugById(drug_c_w);
            if(drugs!=null){
                responseData.setStatus(202);
                responseData.setMessage("查询成功");
                responseData.setData(drugs);
            }else{
                responseData.setStatus(402);
                responseData.setMessage("查询失败，没有数据");
                responseData.setData("");
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }
        return responseData;
    }
    @RequestMapping(value="/getLabelByParentId")
    @ApiOperation(value = "查询所有科室和药品所有分类",produces = "application/json",protocols = "HTTP",httpMethod = "POST",notes ="查询所有科室" )
    public ResponseData<Object> getLabelByParentId(
            @ApiParam(name="parentId",value="父类Id（科室3，药品42）",required = true)
            @RequestParam int parentId
    ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            List<Label> labels=drugService.getLabelByParentId(3);
            if(labels!=null){
                responseData.setStatus(202);
                responseData.setMessage("查询成功");
                responseData.setData(labels);
            }else{
                responseData.setStatus(402);
                responseData.setMessage("查询失败，没有数据");
                responseData.setData("");
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }
        return responseData;
    }
    @RequestMapping(value="/getUser_YiSheng")
    @ApiOperation(value = "查询所有医生",produces = "application/json",protocols = "HTTP",httpMethod = "GET",notes ="查询所有医生" )
    public ResponseData<Object> getUser_YiSheng(){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            List<User> users=drugService.getUser_YiSheng();
            if(users!=null){
                responseData.setStatus(202);
                responseData.setMessage("查询成功");
                responseData.setData(users);
            }else{
                responseData.setStatus(402);
                responseData.setMessage("查询失败，没有数据");
                responseData.setData("");
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }
        return responseData;
    }
    @RequestMapping(value="/getDrugByDrug_c_wAndCommon_nameAndPinyincode")
    @ApiOperation(value = "根据药品分类和输入的药品中文或拼音进行查询",produces = "application/json",protocols = "HTTP",httpMethod = "POST",notes ="根据药品分类和输入的药品中文或拼音进行查询" )
    public ResponseData<Object> getDrugByDrug_c_wAndCommon_nameAndPinyincode(
            @ApiParam(name="drug_c_w",value="中西药（1、中药；2、西药）",required = true)
            @RequestParam(value="drug_c_w",defaultValue="1") int drug_c_w,
            @ApiParam(name="common_name",value="输入的药品中文或拼音",required = true)
            @RequestParam(value="common_name",defaultValue="qingpi") String common_name
    ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            List<Drug> drugs=drugService.getDrugByDrug_c_wAndCommon_nameAndPinyincode(drug_c_w,common_name,common_name);
            if(drugs!=null){
                responseData.setStatus(202);
                responseData.setMessage("查询成功");
                responseData.setData(drugs);
            }else{
                responseData.setStatus(402);
                responseData.setMessage("查询失败，没有数据");
                responseData.setData("");
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }
        return responseData;
    }
}
