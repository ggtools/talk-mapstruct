package org.bordeauxjug.mapstruct.combined;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Christophe Labouisse on 10/04/2015.
 */
public class CarPrice {
    private BigDecimal value;
    private LocalDateTime validity;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getValidity() {
        return validity;
    }

    public void setValidity(LocalDateTime validity) {
        this.validity = validity;
    }
}
