package org.bordeauxjug.mapstruct.immutable;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Christophe Labouisse on 10/04/2015.
 */
@Mapper
public abstract class CarMapper {

    public CarDto carToCarDto(Car car) {
        return carToCarDtoBuilder(car).createCarDto();
    }

    @Mappings({
            @Mapping(source = "make", target = "manufacturer"),
            @Mapping(source = "numberOfSeats", target = "seatCount")
    })
    protected abstract CarDtoBuilder carToCarDtoBuilder(Car car);
}
