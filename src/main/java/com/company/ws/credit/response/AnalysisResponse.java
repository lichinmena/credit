/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ws.credit.response;


import com.company.ws.credit.entity.ConditionEntity;
import com.company.ws.credit.entity.PaymentEntity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author luis
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class AnalysisResponse {
    
    private ConditionEntity input;
    private List<PaymentEntity> output;
    
}
