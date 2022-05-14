/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ws.credit.service;

import com.company.ws.credit.entity.ConditionEntity;
import com.company.ws.credit.request.Input;
import com.company.ws.credit.response.DataResponse;

/**
 *
 * @author luis
 */
public interface ConditionService {
     DataResponse<?> saveAndRetrieveData(Input input);
     DataResponse<?> deleteData();
     DataResponse<?> getPaymentsByCondition(Integer idCondition);
}
