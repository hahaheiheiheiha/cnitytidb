package cn.project.springbootfunction.user.token;

import cn.project.springbootcurrency.vo.MyMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
@Component
public class TokenProccessor {
    private TokenProccessor(){};
    private static final TokenProccessor instance = new TokenProccessor();

    public static TokenProccessor getInstance() {
        return instance;
    }

    /**
     * 生成Token
     * @return
     */
    public String makeToken(String phone) {
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        try {
          StringBuilder sb = new StringBuilder();
          sb.append("PC-");
          sb.append(phone+"-");
          sb.append(MyMD5Util.MD5(phone));
          sb.append(System.currentTimeMillis());
          return sb.toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
