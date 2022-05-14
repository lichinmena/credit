/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ws.credit.controller;

import com.company.ws.credit.impl.ConditionImpl;
import com.company.ws.credit.request.Input;
import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis
 */
@CrossOrigin
@Slf4j
@RestController
@RequestMapping(value = "v1/ws-credit/analysis/")
public class CreditController {
    
    @Autowired
    private ConditionImpl conditionService;
    
    @Operation(summary = "Create payments",
		description = "Service to create payments")
    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@Valid @RequestBody Input input){
        log.info("==> path: /create <==");
        return ResponseEntity.ok(conditionService.saveAndRetrieveData(input));
    } 
    
     @Operation(summary = "Delete payments",
		description = "Service to delete payment information")
    @GetMapping(value = "/health")
    public ResponseEntity<?> health() {
        log.info("==> path: /health <==");
        return ResponseEntity.ok(conditionService.deleteData());
    }
    
    
      @Operation(summary = "Get payments by id",
		description = "Service to get payments by condition id")
    @GetMapping(value = "/condition/{conditionId}")
    public ResponseEntity<?> getPaymentsByCondition(@PathVariable(value = "conditionId")Integer conditionId) {
        log.info("==> path: /getPaymentsByCondition <==");
        return ResponseEntity.ok(conditionService.getPaymentsByCondition(conditionId));
    }  
    
}
