package cn.project.springbootfunction.label.controller;

import cn.project.springbootcurrency.pojo.Label;
import cn.project.springbootcurrency.vo.ResponseData;
import cn.project.springbootfunction.label.service.LabelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "词典管理控制器")
public class LabelController {
    @Resource
    private LabelService labelService;
    @RequestMapping(value = "/selectCiDianByFuJi")
    @ApiOperation(value = "查询所有父级词",produces = "application/json",protocols = "HTTP",httpMethod = "GET",notes = "查询所有父级词")
    public ResponseData<Object> selectCiDianByFuJi(){
        ResponseData<Object> responseData = new ResponseData<Object>();
        try{
            int parentId = 0;
            List<Label> labels = labelService.getLabelByParentId(parentId);
            if(labels.size()>0){
                responseData.setStatus(200);
                responseData.setMessage("查询成功");
                responseData.setData(labels);
            }else{
                responseData.setStatus(400);
                responseData.setMessage("查询失败");
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
    @RequestMapping(value = "/selectCiDianByZiJi")
    @ApiOperation(value = "查询父级下的子级词",produces = "application/json",protocols = "HTTP",httpMethod = "GET",notes = "查询父级下的子级词")
    public ResponseData<Object> selectCiDianByZiJi(
            @ApiParam(value = "父级ID",name="parentId",required = true)
            @RequestParam int parentId
    ) {
        ResponseData<Object> responseData = new ResponseData<Object>();
        try {
            List<Label> labels = labelService.getLabelByParentId(parentId);

            if (labels.size() > 0) {
                responseData.setStatus(200);
                responseData.setMessage("查询成功");
                responseData.setData(labels);
            } else {
                responseData.setStatus(400);
                responseData.setMessage("查询失败");
                responseData.setData("");
            }
        } catch (Exception e) {
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }
        return responseData;

    }
}
