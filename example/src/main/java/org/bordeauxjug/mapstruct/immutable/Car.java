package org.bordeauxjug.mapstruct.immutable;

import org.bordeauxjug.mapstruct.CarType;

/**
 * @author Christophe Labouisse on 10/04/2015.
 */
public class Car {
    private final String make;
    private final int numberOfSeats;
    private final CarType type;

    public Car(String make, int numberOfSeats, CarType type) {
        this.make = make;
        this.numberOfSeats = numberOfSeats;
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public CarType getType() {
        return type;
    }
}
