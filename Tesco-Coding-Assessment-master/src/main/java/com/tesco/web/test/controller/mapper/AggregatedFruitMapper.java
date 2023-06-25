package com.tesco.web.test.controller.mapper;

import com.tesco.web.test.controller.dto.AggregatedFruitResponse;
import com.tesco.web.test.service.model.AggregatedFruitDetail;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AggregatedFruitMapper {
    AggregatedFruitResponse convert(AggregatedFruitDetail aggregatedFruitDetail);
}
