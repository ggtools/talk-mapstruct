package org.bordeauxjug.mapstruct.immutable;

public class CarDtoBuilder {
    private String manufacturer;
    private int seatCount;
    private String type;

    public CarDtoBuilder setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public CarDtoBuilder setSeatCount(int seatCount) {
        this.seatCount = seatCount;
        return this;
    }

    public CarDtoBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public CarDto createCarDto() {
        return new CarDto(manufacturer, seatCount, type);
    }
}
