package com.example.calculator_7_webProgram.controller;

import com.example.calculator_7_webProgram.model.StrCalculatorModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.example.calculator_7_webProgram.utility.CheckValueCorrect;
import com.example.calculator_7_webProgram.utility.CheckDelimiter;

@Controller
public class StrCalculatorController {
    @GetMapping("/")
    public String startPage(){
        return "index";
    }

    @RequestMapping("/strCalculator")
    public String strCalculator(@RequestParam(name = "inputString") String inputValue, Model model) {
        System.out.println("입력 값: "+inputValue);

        double sum = 0.0;

        try{
            CheckDelimiter cd = new CheckDelimiter();
            String[] delimiterAndSplitStr = cd.delimiter_strToSplit(inputValue);

            for(String value : delimiterAndSplitStr[1].split(delimiterAndSplitStr[0])){
                if(!value.isEmpty()) {
                    CheckValueCorrect cvc = new CheckValueCorrect();
                    sum += ((Number) cvc.strToNum(value)).doubleValue();
                }
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage()+"-".repeat(58)+"\n다시 입력해 주세요.\n");
            return "index";
        }

        StrCalculatorModel res = new StrCalculatorModel();
        if(sum == (int)sum){
            res.setSumInt((int)sum);
            model.addAttribute("result", res.getSumInt());
        }else{
            res.setSumDouble(sum);
            model.addAttribute("result", res.getSumDouble());
        }

        return "result/result"; // templates/index.html 반환
    }


}