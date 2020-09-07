package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SupplierMapper {
    public List<Supplier> getSupplierList(@Param("name") String name,@Param("page") int page,@Param("pageSize") int pageSize);
    public int addSupplier(Supplier supplier);
    public int delSupplierById(@Param("id") int id);
    public int countGetSupplierList(@Param("name") String name);
}
