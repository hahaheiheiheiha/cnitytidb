package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.Chinic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChinicMapper {
    public Chinic getChinic();
    public int UpdateChinic(Chinic chinic);
}
