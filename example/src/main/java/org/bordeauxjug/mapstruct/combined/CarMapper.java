package org.bordeauxjug.mapstruct.combined;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Christophe Labouisse on 10/04/2015.
 */
@Mapper(componentModel = "default")
public interface CarMapper {
    @Mappings({
            @Mapping(source = "car.make", target = "manufacturer"),
            @Mapping(source = "car.numberOfSeats", target = "seatCount"),
            @Mapping(source = "price.value", target = "price")
    })
    CarDto carToCarDto(Car car, CarPrice price);
}
