package org.bordeauxjug.mapstruct.simple;

/**
 * @author Christophe Labouisse on 10/04/2015.
 */
public class CarDto {
    private String manufacturer;
    private int seatCount;
    private String type;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
