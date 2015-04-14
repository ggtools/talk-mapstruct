package org.bordeauxjug.mapstruct.combined;

import org.bordeauxjug.mapstruct.CarType;

/**
 * @author Christophe Labouisse on 10/04/2015.
 */
public class Car {
    private String make;
    private int numberOfSeats;
    private CarType type;

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

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }
}
