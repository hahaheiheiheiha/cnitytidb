package cn.project.springbootfunction.supplier.service;

import cn.project.springbootcurrency.mapper.SupplierMapper;
import cn.project.springbootcurrency.pojo.Supplier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SupplierServiceImpl implements SupplierService{
    @Resource
    private SupplierMapper supplierMapper;
    @Override
    public List<Supplier> getSupplierList(String name, int page, int pageSize) {
        return supplierMapper.getSupplierList(name,page,pageSize);
    }

    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.addSupplier(supplier);
    }

    @Override
    public int delSupplierById(int id) {
        return supplierMapper.delSupplierById(id);
    }
}
