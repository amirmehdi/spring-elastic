package com.github.amirmehdi.springelastic.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "category",
        "currency",
        "customer_first_name",
        "customer_full_name",
        "customer_gender",
        "customer_id",
        "customer_last_name",
        "customer_phone",
        "day_of_week",
        "day_of_week_i",
        "email",
        "manufacturer",
        "order_date",
        "order_id",
        "products",
        "sku",
        "taxful_total_price",
        "taxless_total_price",
        "total_quantity",
        "total_unique_products",
        "type",
        "user",
        "geoip"
})
@Data
@Document(indexName = "kibana_sample_data_ecommerce", type = "_doc")
public class Order {
    @Id
    @JsonProperty("_id")
    private String id;

    @JsonProperty("category")
    private List<String> category = null;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("customer_first_name")
    private String customerFirstName;
    @JsonProperty("customer_full_name")
    private String customerFullName;
    @JsonProperty("customer_gender")
    private String customerGender;
    @JsonProperty("customer_id")
    private long customerId;
    @JsonProperty("customer_last_name")
    private String customerLastName;
    @JsonProperty("customer_phone")
    private String customerPhone;
    @JsonProperty("day_of_week")
    private String dayOfWeek;
    @JsonProperty("day_of_week_i")
    private long dayOfWeekI;
    @JsonProperty("email")
    private String email;
    @JsonProperty("manufacturer")
    private List<String> manufacturer = null;
    @JsonProperty("order_date")
    private String orderDate;
    @JsonProperty("order_id")
    private long orderId;
    @JsonProperty("products")
    private List<Product> products = null;
    @JsonProperty("sku")
    private List<String> sku = null;
    @JsonProperty("taxful_total_price")
    private double taxfulTotalPrice;
    @JsonProperty("taxless_total_price")
    private double taxlessTotalPrice;
    @JsonProperty("total_quantity")
    private long totalQuantity;
    @JsonProperty("total_unique_products")
    private long totalUniqueProducts;
    @JsonProperty("type")
    private String type;
    @JsonProperty("user")
    private String user;
    @JsonProperty("geoip")
    private Geoip geoip;

}
