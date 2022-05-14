/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ws.credit.repository;

import com.company.ws.credit.entity.ConditionEntity;
import com.company.ws.credit.entity.PaymentEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author luis
 */
@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{
    List<PaymentEntity> findByConditionOrderByPaymentNumber(ConditionEntity conditionEntity);
}
