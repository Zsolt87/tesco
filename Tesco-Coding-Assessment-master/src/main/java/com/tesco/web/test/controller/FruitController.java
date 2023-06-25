package com.tesco.web.test.controller;

import com.tesco.web.test.controller.dto.AggregatedFruitResponse;
import com.tesco.web.test.controller.mapper.AggregatedFruitMapper;
import com.tesco.web.test.service.FruitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController {

    private final FruitService fruitService;
    private final AggregatedFruitMapper aggregatedFruitMapper;

    public FruitController(FruitService fruitService, AggregatedFruitMapper aggregatedFruitMapper) {
        this.fruitService = fruitService;
        this.aggregatedFruitMapper = aggregatedFruitMapper;
    }

    @GetMapping("/fruits/{name}")
    public AggregatedFruitResponse getFruitInfo(@PathVariable("name") String name) {
        return aggregatedFruitMapper.convert(fruitService.getAggregatedFruitResponse(name));
    }
}
