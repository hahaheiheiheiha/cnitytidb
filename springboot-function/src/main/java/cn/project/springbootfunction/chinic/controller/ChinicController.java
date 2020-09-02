package cn.project.springbootfunction.chinic.controller;

import cn.project.springbootcurrency.pojo.Chinic;
import cn.project.springbootcurrency.vo.ResponseData;
import cn.project.springbootfunction.chinic.service.ChinicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(value = "诊所管理控制器")
public class ChinicController {
    @Resource
    private ChinicService chinicService;
    @RequestMapping("/selectChinic")
    @ApiOperation(value = "查询诊所信息",httpMethod = "GET",protocols = "HTTP",produces = "application/json",notes = "查询诊所信息")
    public ResponseData<Object> selectChinic(){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            Chinic chinic=chinicService.getChinic();
            responseData.setData(chinic);
            responseData.setMessage("查询成功！");
            responseData.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            responseData.setData(e.getMessage());
            responseData.setMessage("发生异常！");
            responseData.setStatus(500);
        }
        return responseData;
    }
    @RequestMapping("/updateChinic")
    @ApiOperation(value = "修改诊所信息",httpMethod = "POST",protocols = "HTTP",produces = "application/json",notes = "修改诊所信息")
    public ResponseData<Object> updateChinic(
            @ApiParam(value = "诊所实体类",name = "chinic",required = true)
            @RequestBody Chinic chinic
    ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            int count = chinicService.UpdateChinic(chinic);
            if(count>0){
                responseData.setData(count);
                responseData.setMessage("修改成功！");
                responseData.setStatus(200);
            }else{
                responseData.setData(count);
                responseData.setMessage("修改失败！");
                responseData.setStatus(401);
            }

        }catch (Exception e){
            e.printStackTrace();
            responseData.setData(e.getMessage());
            responseData.setMessage("发生异常！");
            responseData.setStatus(500);
        }
        return responseData;
    }

}
