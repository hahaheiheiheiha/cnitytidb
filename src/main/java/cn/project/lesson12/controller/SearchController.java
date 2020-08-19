package cn.project.lesson12.controller;

import cn.project.lesson12.dao.ProductRepository;
import cn.project.lesson12.pojo.Product;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("search")
    public ModelAndView searchByPageAndSort(Integer start,String key){
        if(start == null){
            start =0;
        }
        int size = 2;
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.multiMatchQuery(key,"name","body"));
        nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC));
        nativeSearchQueryBuilder.withPageable(PageRequest.of(start,size));
        Page<Product> pr = productRepository.search(nativeSearchQueryBuilder.build());
        for (Product p : pr){
            System.out.println(p.toString());
        }
        ModelAndView view = new ModelAndView();
        view.addObject("page",productRepository);
        view.addObject("keys",key);
        view.setViewName("product");
        return view;

    }
}
