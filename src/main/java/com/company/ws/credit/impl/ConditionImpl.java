/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ws.credit.impl;

import com.company.ws.credit.entity.ConditionEntity;
import com.company.ws.credit.entity.PaymentEntity;
import com.company.ws.credit.repository.ConditionRepository;
import com.company.ws.credit.repository.PaymentRepository;
import com.company.ws.credit.request.Input;
import com.company.ws.credit.response.AnalysisResponse;
import com.company.ws.credit.response.DataResponse;
import com.company.ws.credit.service.ConditionService;
import com.company.ws.credit.utils.Calculation;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luis
 */
@Slf4j
@Service
public class ConditionImpl implements ConditionService {

    @Autowired
    private ConditionRepository conditionRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public DataResponse<?> saveAndRetrieveData(Input input) {
        log.info(":::: Step 1 :::: Initialize condition");
        ConditionEntity condition = new ConditionEntity(input.getAmount(), input.getTerms(), input.getRate());
        
        log.info(":::: Step 2 :::: Save condition");
        conditionRepository.save(condition);
         log.info("    condition Id :: {}", condition.getId());
        
        log.info(":::: Step 3 :::: Calculate payments");
        List<PaymentEntity> payments = Calculation.getInstance().getPayments(condition);
        
        log.info(":::: Step 4 :::: Save payments");
        paymentRepository.saveAll(payments);

        log.info(":::: Step 5 :::: Recover data");
        List<PaymentEntity> paymentsFound = paymentRepository.findByConditionOrderByPaymentNumber(condition);
        
        log.info(":::: Step 6 :::: Build response");
        AnalysisResponse data = AnalysisResponse.builder().input(condition).output(paymentsFound).build();
        
        DataResponse response = new DataResponse();
        response.setStatus("Success");
        response.setMessage("Saved and retrieved data");
        response.setData(data);

        return response;
    }

    @Override
    public DataResponse<?> deleteData() {
        paymentRepository.deleteAll();
        conditionRepository.deleteAll();
        DataResponse response = new DataResponse();
        response.setStatus("Success");
        response.setMessage("Deleted data");
        return response;
    }

    @Override
    public DataResponse<?> getPaymentsByCondition(Integer idCondition) {
        ConditionEntity conditionFound = conditionRepository.findById(idCondition.longValue()).orElse(null);
        DataResponse response = new DataResponse();
        if (conditionFound == null) {
            response.setStatus("Success");
            response.setMessage("Data not found");
        } else {
            response.setStatus("Success");
            response.setMessage("Found data");
            List<PaymentEntity> paymentsFound = paymentRepository.findByConditionOrderByPaymentNumber(conditionFound);
            AnalysisResponse data = AnalysisResponse.builder().input(conditionFound).output(paymentsFound).build();
            response.setData(data);
        }
        return response;
    }

}
