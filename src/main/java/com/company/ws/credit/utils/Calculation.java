/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ws.credit.utils;

import com.company.ws.credit.entity.ConditionEntity;
import com.company.ws.credit.entity.PaymentEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import static com.company.ws.credit.utils.Constants.WEEKS_OF_A_YEAR;
import static com.company.ws.credit.utils.Constants.DAYS_OF_A_WEEK;
import java.util.Calendar;

/**
 *
 * @author luis
 */
@Slf4j
public class Calculation {
    static private Calculation instance = null;
    static public Calculation getInstance()
    {
        if (instance == null)
        {
            instance = new Calculation();
        }
        return instance;
    }
    
    public List<PaymentEntity> getPayments(ConditionEntity condition){
        List<PaymentEntity> list = new ArrayList<>();
        Double rate = condition.getRate();
        Integer terms = condition.getTerms();
        Double amount = condition.getAmount();
        
        log.info("    annual rate :: {}", rate);
        log.info("    terms :: {}", terms);
        log.info("    amount :: {}", amount);
       
        double totalRate = (terms*rate)/WEEKS_OF_A_YEAR;
        log.info("       totalRate :: {} ", totalRate);
        
        double totalAmount = ((totalRate/100)*amount) + amount;
        log.info("       totalAmount :: {} ", totalAmount);
        
        Calendar calendar = Calendar.getInstance();
        Double weeklyPayment = totalAmount/terms;
        log.info("       weeklyPayment :: {} ", weeklyPayment);
        
        for(int i = 1 ; i <= terms ; i++) {
            PaymentEntity payment = new PaymentEntity(i, weeklyPayment, calendar.getTime(), condition);
            //log.info("payment :: {} ", payment);
            list.add(payment);
            calendar.add(Calendar.DATE, DAYS_OF_A_WEEK);
        }
        return list;
    }
}
