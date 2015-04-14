package org.bordeauxjug.mapstruct.simple;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Christophe Labouisse on 10/04/2015.
 */
@Mapper(componentModel = "default")
public interface CarMapper {
    @Mappings({
            @Mapping(source = "make", target = "manufacturer"),
            @Mapping(source = "numberOfSeats", target = "seatCount")
    })
    CarDto carToCarDto(Car car);

    @Mappings({
            @Mapping(source = "manufacturer", target = "make"),
            @Mapping(source = "seatCount", target = "numberOfSeats")
    })
    Car carDtoToCar(CarDto carDto);
}
