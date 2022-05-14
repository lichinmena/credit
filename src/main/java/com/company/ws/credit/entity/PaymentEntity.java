/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ws.credit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author luis
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class PaymentEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    
    @JsonProperty(value = "payment_number")
    private Integer paymentNumber;
    
    private Double amount;
    
    @JsonProperty(value = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "condition_id", nullable = false)
    private ConditionEntity condition;

    public PaymentEntity(Integer paymentNumber, Double amount, Date paymentDate, ConditionEntity condition) {
        this.paymentNumber = paymentNumber;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.condition = condition;
    }
    
    

    @Override
    public String toString() {
        return "Payment{" + "paymentNumber=" + paymentNumber + ", amount=" + amount + ", paymentDate=" + paymentDate + '}';
    }
    
    
    
}
