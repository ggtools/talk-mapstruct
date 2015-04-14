package org.bordeauxjug.mapstruct.immutable;

/**
 * @author Christophe Labouisse on 10/04/2015.
 */
public class CarDto {
    private final String manufacturer;
    private final int seatCount;
    private final String type;

    public CarDto(String manufacturer, int seatCount, String type) {
        this.manufacturer = manufacturer;
        this.seatCount = seatCount;
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public String getType() {
        return type;
    }
}
