package com.github.amirmehdi.springelastic.repository;

import com.github.amirmehdi.springelastic.model.Order;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ECommerceDataRepository extends ElasticsearchRepository<Order, String> {
}
