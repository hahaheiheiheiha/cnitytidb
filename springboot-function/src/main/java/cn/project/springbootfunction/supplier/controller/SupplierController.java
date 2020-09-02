package cn.project.springbootfunction.supplier.controller;

import cn.project.springbootcurrency.pojo.Supplier;
import cn.project.springbootcurrency.vo.ResponseData;
import cn.project.springbootfunction.supplier.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "供应商管理控制器")
public class SupplierController {
    @Resource
    private SupplierService supplierService;
    @RequestMapping("/selectSupplierList")
    @ApiOperation(value = "查询供应商列表",httpMethod = "POST",produces = "application/json",protocols = "HTTP",notes ="查询供应商列表" )
    public ResponseData<Object> selectSupplierList(
            @ApiParam(value = "供应商名称",name="name",required = true)
            @RequestParam String name,
            @ApiParam(value = "页数",name="page",required = true)
            @RequestParam Integer page,
            @ApiParam(value = "每页显示条数",name="pageSize",required = true)
            @RequestParam Integer pageSize
    ){
        ResponseData responseData = new ResponseData();
        try{
            page = (page-1)*pageSize;
            List<Supplier> supplierList = supplierService.getSupplierList(name,page,pageSize);
            responseData.setStatus(200);
            responseData.setMessage("查询成功");
            responseData.setData(supplierList);
        }catch (Exception e){
            e.printStackTrace();
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
        }
        return responseData;
    }
    @RequestMapping("/addSupplier")
    @ApiOperation(value = "新增供应商",httpMethod = "POST",protocols = "HTTP",produces = "application/json",notes = "新增供应商")
    public ResponseData<Object> addSupplier(
            @ApiParam(value = "供应商实体类",required = true,name ="supplier")
            @RequestBody Supplier supplier
    ){
        ResponseData responseData = new ResponseData();
        try{
            int count = supplierService.addSupplier(supplier);
            if(count>0){
                responseData.setData(count);
                responseData.setMessage("新增成功！");
                responseData.setStatus(200);
            }else{
                responseData.setData(count);
                responseData.setMessage("新增失败！");
                responseData.setStatus(401);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  responseData;
    }
    @RequestMapping("/deleteSupplier")
    @ApiOperation(value = "删除供应商",httpMethod = "GET",produces = "application/json",protocols = "HTTP",notes ="删除供应商" )
    public ResponseData<Object> deleteSupplier(
            @ApiParam(value = "供应商编号",name="id",required = true)
            @RequestParam Integer id
    ){
        ResponseData<Object> responseData = new ResponseData<>();
        try{
            int count =supplierService.delSupplierById(id);
            if(count>0){
                responseData.setData(count);
                responseData.setMessage("删除成功！");
                responseData.setStatus(200);
            }else{
                responseData.setData(count);
                responseData.setMessage("删除失败！");
                responseData.setStatus(401);
            }
        }catch (Exception e){
            e.printStackTrace();
            responseData.setStatus(500);
            responseData.setMessage("出现异常");
            responseData.setData(e.getMessage());
        }
        return responseData;
    }

}
