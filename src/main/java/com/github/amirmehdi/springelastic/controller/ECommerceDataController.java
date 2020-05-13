package com.github.amirmehdi.springelastic.controller;

import com.github.amirmehdi.springelastic.model.Order;
import com.github.amirmehdi.springelastic.repository.ECommerceDataRepository;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(value = "ecommerce")
public class ECommerceDataController {
    private final ECommerceDataRepository repository;

    public ECommerceDataController(ECommerceDataRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Order> getData(@PathVariable String id) {
        Optional<Order> eCommerceData = repository.findById(id);
        if (!eCommerceData.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(eCommerceData.get());
    }

    @GetMapping(value = "by-user/{search}")
    public ResponseEntity<Page<Order>> searchData(@PathVariable String search) {
        Page<Order> eCommerceData = repository.search(new NativeSearchQueryBuilder().
                withQuery(
                        new MatchQueryBuilder("customer_full_name", search)
                                .operator(Operator.AND)
                                .fuzziness(Fuzziness.ONE)
                                .prefixLength(2))
                .build());

        return ResponseEntity.ok(eCommerceData);
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        order = repository.save(order);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity removeOrder(@PathVariable String id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
