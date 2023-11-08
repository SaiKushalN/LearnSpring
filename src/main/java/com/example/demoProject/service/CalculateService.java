package com.example.demoProject.service;

import com.example.demoProject.controller.CalculateController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CalculateService {

    public double add(int firstNumber,int secondNumber){
        return firstNumber+secondNumber;
    }

    public double sub(int firstNumber,int secondNumber){
        return firstNumber-secondNumber;
    }

    public double mul(int firstNumber,int secondNumber){
        return firstNumber*secondNumber;
    }

    public double div(int firstNumber,int secondNumber){
        return (double) firstNumber /secondNumber;
    }

    public double SI(double principal,int time, int rate){
        return ((double) (principal * time * rate) /100);
    }

    public double circle(double radius){
        return (CalculateController.pi *Math.pow(radius,2));
    }


}
