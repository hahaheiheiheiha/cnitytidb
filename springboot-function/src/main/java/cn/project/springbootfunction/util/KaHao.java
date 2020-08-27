package cn.project.springbootfunction.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
@Configuration
public class KaHao {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    @Autowired
    private RedisTemplate redisTemplate;
    public String dinDan(String name){
        String ka = "";
        String date =simpleDateFormat.format(new Date());
        int s = Integer.parseInt(date);
        s = s-1;
        String count = "10001";
        String dd = (String)redisTemplate.opsForHash().get(name+date,date);
        if(dd==null){
            String ss =(String)redisTemplate.opsForHash().get(name+s,s);
            if(ss!=null && !ss.equals("")){
                redisTemplate.delete(name+ss);
            }
            redisTemplate.opsForHash().put(name+date,date,count);
           
        }else{
            System.out.println(dd);
            String ssa = dd;
            int css = Integer.parseInt(ssa)+1;
            count =String.valueOf(css);
            System.out.println(css);
            redisTemplate.opsForHash().put(name+date,date,count);
        }
        ka=date+count;
        return ka;
    }
    public String kaHao(){
        String a = "0202020202";
        String dd = (String)redisTemplate.opsForHash().get("kahao","kahao");
        if(dd==null){
            redisTemplate.opsForHash().put("kahao","kahao",a);
        }else{
            //生成随机数
            Random random = new Random();
            String sum = random.nextInt(10)+"";
            System.out.println(sum);
            int sums = Integer.parseInt(sum);


            String ssa = dd;
            int css = Integer.parseInt(ssa)+sums;
            a =String.valueOf(css);
            System.out.println(css);
            redisTemplate.opsForHash().put("kahao","kahao",a);
        }
        return a;
    }
}
