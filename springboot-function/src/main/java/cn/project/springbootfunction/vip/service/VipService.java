package cn.project.springbootfunction.vip.service;

import cn.project.springbootcurrency.pojo.Vip;
import org.apache.ibatis.annotations.Param;

public interface VipService {
    public Vip getVipByP_id(@Param("p_id") int p_id);
}
