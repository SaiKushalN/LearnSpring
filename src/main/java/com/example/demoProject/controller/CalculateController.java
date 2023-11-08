package com.example.demoProject.controller;

import com.example.demoProject.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

    public static double pi = 3.14;

    @Autowired
    CalculateService calculateService;

    @GetMapping("/add/{firstNumber}/{secondNumber}")
    public double add(@PathVariable("firstNumber") int firstNumber,@PathVariable("secondNumber") int secondNumber){
        return calculateService.add(firstNumber,secondNumber);
    }

    @GetMapping("/sub/{firstNumber}/{secondNumber}")
    public double sub(@PathVariable("firstNumber") int firstNumber,@PathVariable("secondNumber") int secondNumber){
        return calculateService.sub(firstNumber,secondNumber);
    }

    @GetMapping("/mul/{firstNumber}/{secondNumber}")
    public double mul(@PathVariable("firstNumber") int firstNumber,@PathVariable("secondNumber") int secondNumber){
        return calculateService.mul(firstNumber,secondNumber);
    }

    @GetMapping("/div/{firstNumber}/{secondNumber}")
    public ResponseEntity<Object> div(@PathVariable("firstNumber") int firstNumber, @PathVariable("secondNumber") int secondNumber){
        if(secondNumber == 0)
            return new ResponseEntity<>("Cant divide by 0, check your inputs",HttpStatus.BAD_REQUEST);
        double result = calculateService.div(firstNumber,secondNumber);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/SI/{principal}/{time}/{rate}")
    public double SI(@PathVariable("principal") double principal, @PathVariable("time") int time, @PathVariable("rate") int rate){
        return calculateService.SI(principal,time,rate);
    }

    @GetMapping("/circle/{radius}")
    public double circle(@PathVariable("radius") double radius){
        return calculateService.circle(radius);
    }
}
