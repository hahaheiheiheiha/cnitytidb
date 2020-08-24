package cn.project.springbootfunction.family.controller;

import cn.project.springbootcurrency.pojo.Family;
import cn.project.springbootcurrency.pojo.P_F;
import cn.project.springbootcurrency.pojo.User;
import cn.project.springbootcurrency.vo.ResponseData;
import cn.project.springbootfunction.family.service.FamilyService;
import cn.project.springbootfunction.p_f.service.P_FService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Date;

@RestController
@Api(value="家属信息管理控制器类")
public class FamilyController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private FamilyService familyService;
    @Resource
    private P_FService p_fService;
    @RequestMapping(value="/addFamily")
    @ApiOperation(value = "新增患者家属质料",produces = "application/json",protocols = "HTTP",httpMethod = "POST",notes ="新增患者家属质料" )
    public ResponseData<Object> addFamily(
            @ApiParam(name="token",value="token令牌",required = true)
            @RequestParam String token,
            @ApiParam(name="name",value = "家属姓名",required = true)
            @RequestParam String name,
            @ApiParam(name="family_relations",value = "家庭关系",required = true)
            @RequestParam int family_relations,
            @ApiParam(name="age",value = "家属年龄",required = true)
            @RequestParam int age,
            @ApiParam(name="birth",value = "家属年龄",required = true)
            @RequestParam Date birth,
            @ApiParam(name="sex",value = "家属性别",required = true)
            @RequestParam char sex,
            @ApiParam(name="phone",value = "家属电话",required = true)
            @RequestParam String phone,
            @ApiParam(name="id",value = "患者id",required = true)
            @RequestParam int id

    ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            User user = (User)redisTemplate.boundHashOps("user:"+token).get(token);
            if(user!=null){
                int uid = user.getId();
                Family family = new Family();
                family.setAge(age);
                family.setBirth(birth);
                family.setCreatedBy(uid);
                family.setFamily_relations(family_relations);
                family.setName(name);
                family.setPhone(phone);
                family.setSex(sex);
                familyService.insertFamily(family);
                P_F p_f = new P_F();
                p_f.setF_id(family.getId());
                p_f.setP_id(id);
                int count = p_fService.addNewPF(p_f);
                if(family.getId()>0 && count>0){
                    responseData.setStatus(200);
                    responseData.setMessage("新增成功！");
                    responseData.setData(family.getId()+""+count);
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
}
