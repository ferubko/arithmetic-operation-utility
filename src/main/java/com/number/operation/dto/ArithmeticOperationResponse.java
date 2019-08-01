package com.number.operation.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by stepanferubko
 */
public class ArithmeticOperationResponse implements Serializable {
    private BigDecimal result;

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArithmeticOperationResponse response = (ArithmeticOperationResponse) o;

        return result != null ? result.equals(response.result) : response.result == null;

    }

    @Override
    public int hashCode() {
        return result != null ? result.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ArithmeticOperationResponse{" +
                "result=" + result +
                '}';
    }
}
