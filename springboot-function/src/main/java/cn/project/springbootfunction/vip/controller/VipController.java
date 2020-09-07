package cn.project.springbootfunction.vip.controller;

import cn.project.springbootcurrency.pojo.Vip;
import cn.project.springbootcurrency.vo.ResponseData;
import cn.project.springbootcurrency.vo.VipPatientListVo;
import cn.project.springbootcurrency.vo.VipPatientVo;
import cn.project.springbootfunction.vip.service.VipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api("vip管理控制器")
public class VipController {
    @Resource
    private VipService vipService;
    @RequestMapping("/selectVipPatientListVo")
    @ApiOperation(value = "根据条件查询vip会员列表",httpMethod = "POST",produces = "application/json",protocols = "HTTP",notes = "selectVipPatientListVo")
    public ResponseData<Object> selectVipPatientListVo(
            @ApiParam(value = "条件查询",name = "vipPatientVo",required = true)
            @RequestBody VipPatientVo vipPatientVo
            ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            List<VipPatientListVo> vipPatientListVoList = vipService.getVipPatientListVoByVipPatientVo(vipPatientVo);
            Map<String,Object> map = new HashMap<>();
            int count = vipService.countGetVipPatientListVoByVipPatientVo(vipPatientVo);
            map.put("data",vipPatientListVoList);
            map.put("count",count);
            responseData.setStatus(200);
            responseData.setMessage("查询成功");
            responseData.setData(map);
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }
        return responseData;
    }
    @RequestMapping("/selectVipList")
    @ApiOperation(value = "查询所有vip等级信息",httpMethod = "GET",produces = "application/json",protocols = "HTTP",notes = "查询所有vip等级信息")
    public ResponseData<Object> selectVipList(
            @ApiParam(value = "页数",name="page",required = true)
            @RequestParam Integer page,
            @ApiParam(value = "每页显示条数",name="pageSize",required = true)
            @RequestParam Integer pageSize
    ){
        ResponseData<Object> responseData = new ResponseData<>();
       try{
           page = (page-1)*pageSize;
           List<Vip> vipPatientListVoList = vipService.getVipList(page,pageSize);
           Map<String,Object> map = new HashMap<>();
           int count = vipService.countGetVipList();
           map.put("data",vipPatientListVoList);
           map.put("count",count);
           responseData.setStatus(200);
           responseData.setMessage("查询成功");
           responseData.setData(map);
       }catch (Exception e){
           e.printStackTrace();
           responseData.setStatus(500);
           responseData.setMessage("出现异常");
           responseData.setData(e.getMessage());
       }
       return responseData;
    }
}
