package org.bordeauxjug.mapstruct.simpler;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Christophe Labouisse on 10/04/2015.
 */
@Mapper
public interface CarMapper {
    CarDto carToCarDto(Car car);

    Car carDtoToCar(CarDto carDto);
}
