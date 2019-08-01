package com.number.operation.service;

import com.number.operation.dto.ArithmeticOperationRequest;
import com.number.operation.dto.ArithmeticOperationResponse;

/**
 * Created by stepanferubko
 */
public interface ArithmeticOperationService {
    ArithmeticOperationResponse plusOperation(ArithmeticOperationRequest inputData);

    ArithmeticOperationResponse minusOperation(ArithmeticOperationRequest inputData);

    ArithmeticOperationResponse multiplyOperation(ArithmeticOperationRequest inputData);

    ArithmeticOperationResponse divideOperation(ArithmeticOperationRequest inputData);

}
