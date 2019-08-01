package com.number.operation.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by stepanferubko
 */
public class ArithmeticOperationRequest implements Serializable {
    @NotNull(message = "firstElement is null")
    private BigDecimal firstElement;
    @NotNull(message = "secondElement is null")
    private BigDecimal secondElement;

    public BigDecimal getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(BigDecimal firstElement) {
        this.firstElement = firstElement;
    }

    public BigDecimal getSecondElement() {
        return secondElement;
    }

    public void setSecondElement(BigDecimal secondElement) {
        this.secondElement = secondElement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArithmeticOperationRequest that = (ArithmeticOperationRequest) o;

        if (firstElement != null ? !firstElement.equals(that.firstElement) : that.firstElement != null) return false;
        return secondElement != null ? secondElement.equals(that.secondElement) : that.secondElement == null;

    }

    @Override
    public int hashCode() {
        int result = firstElement != null ? firstElement.hashCode() : 0;
        result = 31 * result + (secondElement != null ? secondElement.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "firstElement=" + firstElement +
                ", secondElement=" + secondElement +
                '}';
    }
}
