package cn.project.lesson12.dao;

import cn.project.lesson12.pojo.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;


@Component
public interface ProductRepository extends ElasticsearchRepository<Product,Long> {
    Product findById(long id);
    Product findByName(String name);
}
