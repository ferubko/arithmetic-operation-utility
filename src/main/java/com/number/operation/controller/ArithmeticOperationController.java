package com.number.operation.controller;

import com.number.operation.dto.ArithmeticOperationRequest;
import com.number.operation.dto.ArithmeticOperationResponse;
import com.number.operation.service.ArithmeticOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Created by stepanferubko
 */
@RestController
@RequestMapping("/api")
public class ArithmeticOperationController {
    @Autowired
    @Qualifier(value = "arithmeticOperationService")
    private ArithmeticOperationService arithmeticOperationService;


    @RequestMapping(path = "/build", method = RequestMethod.GET)
    private String buildInfo() {
        return "test-build";
    }

    @RequestMapping(path = "/plus", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    private ArithmeticOperationResponse sumTwoNumbers(@Valid @RequestBody ArithmeticOperationRequest request) {
        return arithmeticOperationService.plusOperation(request);
    }

    @RequestMapping(path = "/minus", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    private ArithmeticOperationResponse subtractTwoNumbers(@Valid @RequestBody ArithmeticOperationRequest request) {
        return arithmeticOperationService.minusOperation(request);
    }

    @RequestMapping(path = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    private ArithmeticOperationResponse multiplyTwoNumbers(@Valid @RequestBody ArithmeticOperationRequest request) {
        return arithmeticOperationService.multiplyOperation(request);
    }

    @RequestMapping(path = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    private ArithmeticOperationResponse divideTwoNumbers(@Valid @RequestBody ArithmeticOperationRequest request) {
        return arithmeticOperationService.divideOperation(request);
    }
}
