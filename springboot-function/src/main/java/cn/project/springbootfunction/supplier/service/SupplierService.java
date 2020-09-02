package cn.project.springbootfunction.supplier.service;

import cn.project.springbootcurrency.pojo.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierService {
    public List<Supplier> getSupplierList(@Param("name") String name, @Param("page") int page, @Param("pageSize") int pageSize);
    public int addSupplier(Supplier supplier);
    public int delSupplierById(@Param("id") int id);
}
