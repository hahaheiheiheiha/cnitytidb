package cn.project.springbootfunction.order.controller;

import cn.project.springbootcurrency.vo.ResponseData;
import cn.project.springbootcurrency.vo.Rise;
import cn.project.springbootfunction.order.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class    OrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping(value="/selectUpShouQian")
    @ApiOperation(value="查询当天新增接诊人数",httpMethod = "GET",protocols = "HTTP",produces = "applicaion/json",notes = "根据当前时间查询就诊人数")
    public ResponseData<Object> selectUpJiuJen(){
        ResponseData<Object> responseData=new ResponseData<Object>();
        try{
            Float floatss ;

            Rise rise = new Rise();
            int status =1 ;
            int type =1;
            //收款
            String count = orderService.getShouQianByDate(status,type);
            System.out.println(count);
            if(count==""||count==null){
                count = "0";
            }
            float fcount =Float.parseFloat(count);
            //退款
            status=2;
            String count2 =  orderService.getShouQianByDate(status,type);
            if(count2==""||count2==null){
                count2 = "0";
            }
            float fcount2 =Float.parseFloat(count2);
            //当天的盈利
            fcount = fcount-fcount2;
            //昨天的入账
            status =1;
            type =2;
            String count3 = orderService.getShouQianByDate(status,type);
            if(count3==""||count3==null){
                count3 = "0";
            }
            float fcount3 =Float.parseFloat(count2);
            //昨天的退款
            status =2;
            String count4 = orderService.getShouQianByDate(status,type);
            if(count4==""||count4==null){
                count4 = "0";
            }
            float fcount4 =Float.parseFloat(count2);
            //昨天的盈利
            fcount3 = fcount3-fcount4;
            floatss = Float.valueOf(count);
            rise.setCount(floatss.intValue());
            rise.setName("新增就诊");
            rise.setType("元");
            floatss = Float.valueOf(fcount-fcount3);
            rise.setUp(floatss.intValue());
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
