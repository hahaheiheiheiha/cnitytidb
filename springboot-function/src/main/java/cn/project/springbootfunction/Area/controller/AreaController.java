package cn.project.springbootfunction.Area.controller;

import cn.project.springbootcurrency.pojo.Area;
import cn.project.springbootcurrency.vo.ResponseData;
import cn.project.springbootfunction.Area.service.AreaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AreaController {
    @Resource
    private AreaService areaService;
    @RequestMapping(value = "/selectAreaSheng")
    @ApiOperation(value = "查询所有省份和直辖市",produces = "application/json",protocols = "HTTP",httpMethod = "GET",notes ="查询所有省份和直辖市" )
    public ResponseData<Object> selectAreaSheng(){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            int parent = 0;
            List<Area> areas = areaService.getAreaListByParent(parent);
            if(areas.size()>0){
                responseData.setStatus(200);
                responseData.setMessage("查询成功");
                responseData.setData(areas);
            }else{
                responseData.setStatus(400);
                responseData.setMessage("查询失败");
                responseData.setData("");
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("发生异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }
        return responseData;

    }
    @RequestMapping(value = "/selectAreaShi")
    @ApiOperation(value = "查询省下面的市",produces = "application/json",protocols = "HTTP",httpMethod = "GET",notes ="查询省下面的市" )
    public ResponseData<Object> selectAreaShi(
            @ApiParam(value = "父级ID",name="parent",required = true)
            @RequestParam int parent
    ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{

            List<Area> areas = areaService.getAreaListByParent(parent);
            if(areas.size()>0){
                responseData.setStatus(200);
                responseData.setMessage("查询成功");
                responseData.setData(areas);
            }else{
                responseData.setStatus(400);
                responseData.setMessage("查询失败");
                responseData.setData("");
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("发生异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }
        return responseData;

    }
}
