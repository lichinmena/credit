/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ws.credit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author luis
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "conditions")
public class ConditionEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    
    private Double amount;
    
    private Integer terms;
    
    private Double rate;

    public ConditionEntity(Double amount, Integer terms, Double rate) {
        this.amount = amount;
        this.terms = terms;
        this.rate = rate;
    }
    
    
}
