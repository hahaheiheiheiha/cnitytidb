package cn.project.lesson12;

import cn.project.lesson12.dao.ProductRepository;
import cn.project.lesson12.pojo.Product;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Lesson12ApplicationTests {

    private Integer PAGESIZE =10;
    @Autowired
    private ProductRepository productRepository;
    private String 我觉得红富士很好吃;

    @Test
    public void save(){
        long id=System.currentTimeMillis();
        System.out.println(id);
        Product product = new Product(id,"红富士","水果",7.88,"/img/p1.jpg","这是一个测试数据");
        productRepository.save(product);
    }
    @Test
    public void getProduct(){
        Iterable<Product> list = (Iterable<Product>) productRepository.findByName("红富士");
        for(Product p : list){
            System.out.println(p.toString());
        }
    }
    @Test
    public void updateProduct(){
        long id=1596850450775L;
        Product product = new Product(id,"红富士","非水果",7.88,"/img/p1.jpg","这是一个测试数据");
        productRepository.save(product);
    }
    @Test
    public void getProductById(){
        Product product = productRepository.findById(0);
        System.out.println(product.toString());
    }
    @Test
    public void delete(){
        long id = 1596850450775L;
        productRepository.deleteById(id);
    }
    @Test
    public void getAll()
    {
        Iterable<Product> list = productRepository.findAll();
        for(Product p : list){
            System.out.println(p.toString());
        }
    }
    @Test
    public void  termQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.termQuery("name","富"));
        Page<Product> products = productRepository.search(nativeSearchQueryBuilder.build());
        for (Product p : products){
            System.out.println(p.toString());
        }
    }
    @Test
    public void termsQuerys(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.termsQuery("name","富","湖"));
        Page<Product> pr = productRepository.search(nativeSearchQueryBuilder.build());
        for (Product p : pr){
            System.out.println(p.toString());
        }
    }
    @Test
    public void matachQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("name","红士"));
        Page<Product> pr = productRepository.search(nativeSearchQueryBuilder.build());
        for (Product p : pr){
            System.out.println(p.toString());
        }
    }
    @Test
    public void multiMatchQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilde = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilde.withQuery(QueryBuilders.multiMatchQuery("红富士金帅","name","body"));
        Page<Product> pr = productRepository.search(nativeSearchQueryBuilde.build());
        for (Product p : pr){
            System.out.println(p.toString());
        }
    }
    @Test
    public void queryStringQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.queryStringQuery("我觉得红富士很好吃").field("name"));
        Page<Product> pr = productRepository.search(nativeSearchQueryBuilder.build());
        for (Product p : pr){
            System.out.println(p.toString());
        }

    }
    @Test
    public void prefixQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.prefixQuery("name","士"));
        Page<Product> pr = productRepository.search(nativeSearchQueryBuilder.build());
        for (Product p : pr){
            System.out.println(p.toString());
        }
    }
    @Test
    public void wildcardQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.wildcardQuery("name","红*"));
        Page<Product> pr = productRepository.search(nativeSearchQueryBuilder.build());
        for (Product p : pr){
            System.out.println(p.toString());
        }
    }
    @Test
    public void wildcardQuery2(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.wildcardQuery("name","红?"));
        Page<Product> pr = productRepository.search(nativeSearchQueryBuilder.build());
        for (Product p : pr){
            System.out.println(p.toString());
        }
    }
    @Test
    public void fuzzyQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.fuzzyQuery("name","士").fuzziness(Fuzziness.ONE));
        Page<Product> pr = productRepository.search(nativeSearchQueryBuilder.build());
        for (Product p : pr){
            System.out.println(p.toString());
        }
    }
    @Test
    public void termQuery3(){
        int page=0;
        int size=5;
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.termsQuery("name","富"));
        nativeSearchQueryBuilder.withPageable(PageRequest.of(page,size));
        Page<Product> pr = productRepository.search(nativeSearchQueryBuilder.build());
        for (Product p : pr){
            System.out.println(p.toString());
        }
    }
    @Test
    public void searchByPageAndSort(){
        int page=0;
        int size=5;
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.termsQuery("name","富"));
        nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC));
        nativeSearchQueryBuilder.withPageable(PageRequest.of(page,size));
        Page<Product> pr = productRepository.search(nativeSearchQueryBuilder.build());
        for (Product p : pr){
            System.out.println(p.toString());
        }
    }
    @Test
    public void searchBybucket(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""},null));
        nativeSearchQueryBuilder.withSearchType(SearchType.QUERY_THEN_FETCH);
        nativeSearchQueryBuilder.withIndices("goods").withTypes("goods");
        nativeSearchQueryBuilder.addAggregation(AggregationBuilders.terms("brands").field("brand"));
        AggregatedPage<Product> addPage =(AggregatedPage<Product>)productRepository.search(nativeSearchQueryBuilder.build());
        StringTerms agg = (StringTerms) addPage.getAggregation("brands");
        List<StringTerms.Bucket> list = agg.getBuckets();
        for(StringTerms.Bucket bucket : list){
            System.out.println(bucket.getKeyAsString());
            System.out.println(bucket.getDocCount());
        }
    }
    @Test
   public void contextLoads()
    {
        System.out.println("12");
    }

}
