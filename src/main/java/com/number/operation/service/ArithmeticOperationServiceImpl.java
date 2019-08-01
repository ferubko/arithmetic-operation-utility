package com.number.operation.service;

import com.number.operation.dto.ArithmeticOperationRequest;
import com.number.operation.dto.ArithmeticOperationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by stepanferubko
 */

@Service("arithmeticOperationService")
public class ArithmeticOperationServiceImpl implements ArithmeticOperationService {
    private static final Logger logger = LoggerFactory.getLogger(ArithmeticOperationServiceImpl.class);

    @Override
    public ArithmeticOperationResponse plusOperation(ArithmeticOperationRequest inputData) {
        logger.info("Started plus operation with {}", inputData.toString());
        BigDecimal firstElement = inputData.getFirstElement();
        BigDecimal secondElement = inputData.getSecondElement();
        BigDecimal sumResult = firstElement.add(secondElement);
        logger.info("Result: {}", sumResult);
        ArithmeticOperationResponse response = new ArithmeticOperationResponse();
        response.setResult(sumResult);
        return response;
    }

    @Override
    public ArithmeticOperationResponse minusOperation(ArithmeticOperationRequest inputData) {
        logger.info("Started subtract operation with {}", inputData.toString());
        BigDecimal firstElement = inputData.getFirstElement();
        BigDecimal secondElement = inputData.getSecondElement();
        BigDecimal minusResult = firstElement.subtract(secondElement);
        logger.info("Result: {}", minusResult);
        ArithmeticOperationResponse response = new ArithmeticOperationResponse();
        response.setResult(minusResult);
        return response;
    }

    @Override
    public ArithmeticOperationResponse multiplyOperation(ArithmeticOperationRequest inputData) {
        logger.info("Started multiply operation with {}", inputData.toString());
        BigDecimal firstElement = inputData.getFirstElement();
        BigDecimal secondElement = inputData.getSecondElement();
        BigDecimal multiplyResult = firstElement.multiply(secondElement);
        logger.info("Result: {}", multiplyResult);
        ArithmeticOperationResponse response = new ArithmeticOperationResponse();
        response.setResult(multiplyResult);
        return response;
    }

    @Override
    public ArithmeticOperationResponse divideOperation(ArithmeticOperationRequest inputData) {
        logger.info("Started divide operation with {}", inputData.toString());
        BigDecimal firstElement = inputData.getFirstElement();
        BigDecimal secondElement = inputData.getSecondElement();
        BigDecimal divideesult = firstElement.divide(secondElement);
        logger.info("Result: {}", divideesult);
        ArithmeticOperationResponse response = new ArithmeticOperationResponse();
        response.setResult(divideesult);
        return response;
    }
}
