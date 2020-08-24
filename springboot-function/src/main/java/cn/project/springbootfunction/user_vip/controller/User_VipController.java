package cn.project.springbootfunction.user_vip.controller;

import cn.project.springbootcurrency.vo.ResponseData;
import cn.project.springbootcurrency.vo.Rise;
import cn.project.springbootfunction.user_vip.service.User_VipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(value = "会员管理控制器类")
public class User_VipController {
    @Resource
    private User_VipService user_vipService;
    @RequestMapping(value="/selectUpHuiYuan")
    @ApiOperation(value="查询当天新增会员人数",httpMethod = "GET",protocols = "HTTP",produces = "applicaion/json",notes = "根据当前时间查询会员人数")
    public ResponseData<Object> selectUpHuiYuan(){
        ResponseData<Object> responseData=new ResponseData<Object>();
        try{

            int type =1;
            Rise rise = new Rise();
            int count = user_vipService.getCountUserVipByDate(type);
            type=2;
            int count2 = user_vipService.getCountUserVipByDate(type);
            rise.setCount(count);
            rise.setName("新增会员");
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
