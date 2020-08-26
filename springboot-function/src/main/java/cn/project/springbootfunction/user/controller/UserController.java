package cn.project.springbootfunction.user.controller;

import cn.project.springbootcurrency.pojo.Register;
import cn.project.springbootcurrency.pojo.User;
import cn.project.springbootcurrency.vo.MyMD5Util;
import cn.project.springbootcurrency.vo.ResponseData;
import cn.project.springbootfunction.user.service.SmsService;
import cn.project.springbootfunction.user.service.UserService;
import cn.project.springbootfunction.user.token.TokenProccessor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@Api(value = "用户管理控制器类")
public class UserController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private TokenProccessor tokenProccessor;
    @Autowired
    private UserService userService;
    @Autowired
    private SmsService smsService;
//    public ResponseData<List<qwe>> getqwe(){
//        ResponseData<List<qwe>> responseData=new ResponseData<List<qwe>>();
//        try {
//            List<qwe> qweList=null;//null可以是业务类的结果
//            responseData.setStatus(200);
//            responseData.setMessage("查询成功");
//            responseData.setData(qweList);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            return responseData;
//        }
//    }
    @RequestMapping(value="/logout")
    @ApiOperation(value="用户注销",httpMethod = "GET",protocols = "HTTP",produces = "applicaion/json",notes = "根据token令牌删除用户登录信息")
    public ResponseData<Object> logout(@ApiParam(name="token",value="token令牌",required = true)
                                       @RequestParam
                                       String token){
        ResponseData<Object> responseData=new ResponseData<Object>();
        try{
            User user = (User)redisTemplate.boundHashOps("user:"+token).get(token);
            if(user!=null){
                redisTemplate.boundHashOps("1:"+token).delete(token);
                responseData.setStatus(200);
                responseData.setMessage("注销成功");
                responseData.setData("");
            }else{
                responseData.setStatus(400);
                responseData.setMessage("注销失败");
                responseData.setData("token令牌不正确！！！");
            }

        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }

       return responseData;
    }

    @RequestMapping(value = "/login")//,method = RequestMethod.POST
    @ApiOperation(value = "用户登录",httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            notes="根据、密码进行统一认证")
    public ResponseData<Object> login(@ApiParam(name="phone",value="手机号码",required=true,defaultValue = "17261305041")
                                    @RequestParam
                                    String phone,
                                      @ApiParam(name="password",value = "登录密码",required = true) @RequestParam String password,

                                      HttpServletResponse response){
        ResponseData<Object> responseData=new ResponseData<Object>();
        try {
            password = MyMD5Util.MD5(password);
            User user =new User();
            user.setPassword(password);
            user.setPhone(phone);
            User user2 = userService.login(user);

            if(user2!=null){
                //String accessToken = jwtHelper.createJWT(phone,device);
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("companyId", user2.getId());

                dataMap.put("companyName", user.getName());
                String token = tokenProccessor.makeToken(user2.getPhone());;
                System.out.println(token);
                responseData.setStatus(200);
                responseData.setMessage("登录成功");
                Map<String ,Object> map = new HashMap<>();
                map.put("token",token);
                redisTemplate.boundHashOps("user:"+token).put(token,user2);

                responseData.setData(map);
            }else{
                responseData.setStatus(400);
                responseData.setMessage("登录失败");
                responseData.setData("");
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("发送异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }finally {
            return responseData;
        }

    }
    @RequestMapping("/updateUserPassword")
    @ApiOperation(value="修改当前用户登录密码",httpMethod = "POST",produces = "application/json",protocols = "HTTP",notes = "修改当前用户登录密码")
    public ResponseData<Object> updateUserPassword(
            @ApiParam(value="token令牌",name="token",required = true)
            @RequestParam
                    String token,
            @ApiParam(value="确认当前用户密码",name="password",required = true)
            @RequestParam
                    String password,
            @ApiParam(value="新的用户密码",name="newPassword",required = true)
            @RequestParam
                    String newPassword,
            @ApiParam(value="确认新的用户密码",name="newPasswords",required = true)
            @RequestParam
                    String newPasswords
    ){
        ResponseData<Object> responseData = new ResponseData<Object>();
        try{
            password = MyMD5Util.MD5(password);
            System.out.println(password);
            User user =  (User) redisTemplate.boundHashOps("user:"+token).get(token);
            if(user !=null){
                if(user.getPassword().equals(password)){
                    if(newPassword.equals(newPasswords)){
                        newPassword=MyMD5Util.MD5(newPassword);
                        System.out.println(newPassword);
                        int id = user.getId();
                        int count =  userService.updateUserPassword(id,newPassword);
                        responseData.setStatus(200);
                        responseData.setMessage("修改成功");
                        responseData.setData(count);
                    }else{
                        responseData.setStatus(401);
                        responseData.setMessage("密码输入不一致");
                        responseData.setData("");
                    }
                }else{
                    responseData.setStatus(400);
                    responseData.setMessage("密码不正确");
                    responseData.setData("");
                }
            }else{
                responseData.setStatus(402);
                responseData.setMessage("token令牌不正确");
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
    @RequestMapping("/SendVerificationCode")
    @ApiOperation(value="发送验证码",httpMethod = "POST",produces = "application/json",protocols = "HTTP",notes = "发送验证码")
    public ResponseData<Object> register(
            @ApiParam(value="号码",name="phone",required = true,defaultValue = "18674909214")
            @RequestParam
                    String phone
    ){
        ResponseData<Object> responseData = new ResponseData<Object>();
        try{
            int count=phone.length();
            if(count==11){
                Random random = new Random();
                String code =random.nextInt(10000)+"";
                System.out.println(code);
                smsService.sms(phone,code);
                redisTemplate.boundHashOps("yzm:"+phone).put(phone,code);
                responseData.setStatus(200);
                responseData.setMessage("发送成功");
                responseData.setData(null);
            }else{
                responseData.setStatus(400);
                responseData.setMessage("发送失败，号码不为11位");
                responseData.setData(null);
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }
        return responseData;
    }
    @RequestMapping("/register")
    @ApiOperation(value="申请诊所试用账号",httpMethod = "POST",produces = "application/json",protocols = "HTTP",notes = "申请诊所试用账号")
    public ResponseData<Object> register(
            @ApiParam(name="Register",value="诊所实体",required=true)
            @RequestBody Register register
    ){
        ResponseData<Object> responseData = new ResponseData<Object>();
        try{
            String verification2=String.valueOf(redisTemplate.boundHashOps("yzm:"+register.getPhone()).get(register.getPhone()));
            if (register.getVerification().equals(verification2)){
                int count=userService.register(register);
                if(count>0){
                    responseData.setStatus(200);
                    responseData.setMessage("注册成功");
                    responseData.setData(count);
                }else{
                    responseData.setStatus(400);
                    responseData.setMessage("注册失败");
                    responseData.setData(count);
                }
            }else{
                responseData.setStatus(400);
                responseData.setMessage("注册失败");
                responseData.setData(null);
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
            e.printStackTrace();
        }
        return responseData;
    }

    @RequestMapping("/updateUserAndRole")
    @ApiOperation(value="修改个人信息",httpMethod = "POST",produces = "application/json",protocols = "HTTP",notes = "修改个人信息")
    public ResponseData<Object> updateUserAndRole(
            @ApiParam(name="User",value="用户实体",required=true)
            @RequestBody User user
    ){
        ResponseData<Object> responseData = new ResponseData<Object>();
        try{
            int count=userService.updateUser(user);
            int count2=userService.updateRole(user);
            if (count>0 && count2>0){
                responseData.setStatus(200);
                responseData.setMessage("保存成功");
                responseData.setData(count+"_"+count2);
            }else{
                responseData.setStatus(400);
                responseData.setMessage("保存失败");
                responseData.setData(count+"_"+count2);
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
        }
        return responseData;
    }
    @RequestMapping("/getUserAndRole")
    @ApiOperation(value="查看个人信息",httpMethod = "POST",produces = "application/json",protocols = "HTTP",notes = "查看个人信息")
    public ResponseData<Object> getUserAndRole(
            @ApiParam(value="用户Id",name="id",required = true,defaultValue = "100010")
            @RequestParam
                    int id
    ){
        ResponseData<Object> responseData = new ResponseData<Object>();
        try{
            User user=userService.getUserById(id);
            String roleName=userService.getRole_NameByUser_Id(id);
            user.setRoleName(roleName);
            if(user!=null && !roleName.equals("")){
                responseData.setStatus(200);
                responseData.setMessage("查询成功");
                responseData.setData(user);
            }else{
                responseData.setStatus(400);
                responseData.setMessage("查询失败");
                responseData.setData(null);
            }
        }catch (Exception e){
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
        }
        return responseData;
    }
}
