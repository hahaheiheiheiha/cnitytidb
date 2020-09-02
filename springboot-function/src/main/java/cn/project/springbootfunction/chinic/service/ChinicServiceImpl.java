package cn.project.springbootfunction.chinic.service;

import cn.project.springbootcurrency.mapper.ChinicMapper;
import cn.project.springbootcurrency.pojo.Chinic;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ChinicServiceImpl implements ChinicService{
    @Resource
    private ChinicMapper  chinicMapper;
    @Override
    public Chinic getChinic() {
        return chinicMapper.getChinic();
    }

    @Override
    public int UpdateChinic(Chinic chinic) {
        return chinicMapper.UpdateChinic(chinic);
    }
}
