package cn.project.springbootfunction.drug.controller;

import cn.project.springbootcurrency.pojo.*;
import cn.project.springbootcurrency.vo.ResponseData;
import cn.project.springbootfunction.drug.service.DrugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
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
    @RequestMapping(value="/insertPrescription_drug")
    @ApiOperation(value = "增加处方(里面有药品)",produces = "application/json",protocols = "HTTP",httpMethod = "POST",notes ="增加处方(里面有药品)" )
    public ResponseData<Object> insertPrescription(
            @ApiParam(name="patient_id",value="患者id",required = true)
            @RequestParam(value="patient_id",defaultValue="1") int patient_id,
            @ApiParam(name="drugList",value="药品集合",required = true)
            @RequestBody List<Drug> drugList
    ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            Patient patient=new Patient();
            patient.setId(patient_id);
            int count=drugService.insertPrescription(patient);
            Boolean flag=false;
            if (count>0){
                for (Drug drug:drugList) {
                    System.out.println(drug.getId());
                    drugService.insertPrescription_drug(drug.getDrug_c_w(),drug.getId(),patient.getId());
                    drugService.updateDrugById(drug.getId());
                }
                flag=true;
            }
            if(flag){
                responseData.setStatus(202);
                responseData.setMessage("保存成功");
                responseData.setData("");
            }else{
                responseData.setStatus(402);
                responseData.setMessage("保存失败");
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
    @RequestMapping(value="/getPatientAndVip")
    @ApiOperation(value = "查询患者人员和接诊信息",produces = "application/json",protocols = "HTTP",httpMethod = "POST",notes ="查询患者人员和接诊信息" )
    public ResponseData<Object> getPatientAndVip(
            @ApiParam(name="patient_id",value="患者id",required = true)
            @RequestParam(value="patient_id",defaultValue="1") int patient_id
    ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            Patient patient=drugService.getPatientAndVip(patient_id);
            if(patient!=null){
                responseData.setStatus(202);
                responseData.setMessage("查询成功");
                responseData.setData(patient);
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
    @RequestMapping(value="/getPatient")
    @ApiOperation(value = "查询出患者信息（有个下拉框）",produces = "application/json",protocols = "HTTP",httpMethod = "GET",notes ="查询出患者信息（有个下拉框）" )
    public ResponseData<Object> getPatient(){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            List<Patient> patient=drugService.getPatient();
            if(patient!=null){
                responseData.setStatus(202);
                responseData.setMessage("查询成功");
                responseData.setData(patient);
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
    @RequestMapping(value="/getDrugDescSalesVolumes")
    @ApiOperation(value = "查询药品销售排行",produces = "application/json",protocols = "HTTP",httpMethod = "GET",notes ="查询药品销售排行" )
    public ResponseData<Object> getDrugDescSalesVolumes(){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            List<Drug> drug=drugService.getDrugDescSalesVolumes();
            if(drug!=null){
                responseData.setStatus(202);
                responseData.setMessage("查询成功");
                responseData.setData(drug);
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
    @RequestMapping(value="/getUserById")
    @ApiOperation(value = "查询出够权限的操作员只能(管理员、医生、护士、专家)",produces = "application/json",protocols = "GET",httpMethod = "POST",notes ="查询出够权限的操作员只能(管理员、医生、护士、专家)" )
    public ResponseData<Object> getUserById(){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            List<User> user=drugService.getUserById();
            if(user!=null){
                responseData.setStatus(202);
                responseData.setMessage("查询成功");
                responseData.setData(user);
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
    @RequestMapping(value="/getDrugByDrug_c_wAndIdAndCommon_name")
    @ApiOperation(value = "根据药品类型、输入的药品编码和药品名称进行查询",produces = "application/json",protocols = "HTTP",httpMethod = "POST",notes ="根据药品类型、输入的药品编码和药品名称进行查询" )
    public ResponseData<Object> getDrugByDrug_c_wAndIdAndCommon_name(
            @ApiParam(name="drug_c_w",value="药品类型(1.中药,2.西药)",required = true)
            @RequestParam(value="drug_c_w",defaultValue="1") int drug_c_w,
            @ApiParam(name="id",value="药品id",required = true)
            @RequestParam(value="id",defaultValue="100031") int id,
            @ApiParam(name="common_name",value="药品名称",required = true)
            @RequestParam(value="common_name",defaultValue="青皮") String common_name
    ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            System.out.println(common_name);
            List<Drug> drugs=drugService.getDrugByDrug_c_wAndIdAndCommon_name(drug_c_w,id,common_name);
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
    @RequestMapping(value="/getDrug")
    @ApiOperation(value = "查询药品信息维护页面",produces = "application/json",protocols = "HTTP",httpMethod = "POST",notes ="查询药品信息维护页面" )
    public ResponseData<Object> getDrug(
            @ApiParam(name="drug_c_w",value="药品类型(1.中药,2.西药)",required = false)
            @RequestParam(value="drug_c_w",defaultValue="1") Integer drug_c_w,
            @ApiParam(name="state",value="药品状态",required = false)
            @RequestParam(value="state",defaultValue="1") Integer state,
            @ApiParam(name="CreationTime1",value="创建时间大于的时间",required = false)
            @RequestParam(value="CreationTime1") Date CreationTime1,
            @ApiParam(name="CreationTime2",value="创建时间小于的时间",required = false)
            @RequestParam(value="CreationTime2") Date CreationTime2,
            @ApiParam(name="information",value="药品名称/编码/生产厂家",required = false)
            @RequestParam(value="information",defaultValue="青皮") String information,
            @ApiParam(name="page",value="当前页数",required = false)
            @RequestParam(value="page",defaultValue="1") Integer page,
            @ApiParam(name="pageSize",value="每页多少条数据",required = false)
            @RequestParam(value="pageSize",defaultValue="2") Integer pageSize
    ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            page = (page-1)*pageSize;
            System.out.println(page);
            List<Drug> drugs=drugService.getDrug(drug_c_w,state,CreationTime1,CreationTime2,information,information,information,page,pageSize);
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
    @RequestMapping("/insertDrug")
    @ApiOperation(value="增加药品信息",httpMethod = "POST",produces = "application/json",protocols = "HTTP",notes = "增加药品信息")
    public ResponseData<Object> insertDrug(
            @ApiParam(name="Drug",value="药品实体",required=true)
            @RequestBody Drug drug
    ){
        ResponseData<Object> responseData = new ResponseData<Object>();
        try{
            drug.setCreationTime(new java.util.Date());
            int count=drugService.insertDrug(drug);
            if (count>0){
                responseData.setStatus(200);
                responseData.setMessage("保存成功");
                responseData.setData(count);
            }else{
                responseData.setStatus(400);
                responseData.setMessage("保存失败");
                responseData.setData(count);
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
        }
        return responseData;
    }
    @RequestMapping("/updateDrug")
    @ApiOperation(value="修改药品",httpMethod = "POST",produces = "application/json",protocols = "HTTP",notes = "修改药品")
    public ResponseData<Object> updateDrug(
            @ApiParam(name="Drug",value="药品实体",required=true)
            @RequestBody Drug drug
    ){
        ResponseData<Object> responseData = new ResponseData<Object>();
        try{
            int count=drugService.updateDrug(drug);
            if (count>0){
                responseData.setStatus(200);
                responseData.setMessage("保存成功");
                responseData.setData(count);
            }else{
                responseData.setStatus(400);
                responseData.setMessage("保存失败");
                responseData.setData(count);
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
        }
        return responseData;
    }
    @RequestMapping(value="/updateDrug_state")
    @ApiOperation(value = "修改药品状态（停用或者启用）",produces = "application/json",protocols = "HTTP",httpMethod = "POST",notes ="修改药品状态（停用或者启用）" )
    public ResponseData<Object> updateDrug_state(
            @ApiParam(name="id",value="药品id",required = true)
            @RequestParam(value="drug_c_w",defaultValue="100031") Integer id,
            @ApiParam(name="state",value="药品状态",required = true)
            @RequestParam(value="state",defaultValue="1") Integer state
    ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            int count=drugService.updateDrug_state(id,state);
            if(count>0){
                responseData.setStatus(202);
                responseData.setMessage("保存成功");
                responseData.setData(count);
            }else{
                responseData.setStatus(402);
                responseData.setMessage("保存失败");
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
