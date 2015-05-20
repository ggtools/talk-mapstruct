package org.bordeauxjug.mapstruct.simpler;

/**
 * @author Christophe Labouisse on 10/04/2015.
 */
public class CarDto {
    private String make;
    private int numberOfSeats;
    private String type;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
