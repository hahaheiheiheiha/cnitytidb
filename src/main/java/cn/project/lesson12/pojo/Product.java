package cn.project.lesson12.pojo;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName="ec",type = "product",replicas = 0,shards = 5)
@Data
public class Product implements Serializable {
    @Id
    private Long id;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String name;
    @Field(type=FieldType.Keyword)
    private String category;
    @Field(type=FieldType.Double)
    private Double price;
    @Field(index = false,type=FieldType.Keyword)
    private String images;
    private String body;

    public  Product(){

    }
    public String toString(){
        return "id:"+id+" name:"+name+" category:"+category+" price:"+price+"" +
                " images:"+images+" body:"+body;
    }
    public Product(Long id, String name, String category, Double price, String images, String body) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.images = images;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
