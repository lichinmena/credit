/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ws.credit.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author luis
 */
@Getter
@Setter
@AllArgsConstructor
public class Input {
    @JsonProperty(value = "amount")
    @ApiModelProperty(value = "amount", dataType = "Double", example = "1000.00", required = true)
    @NotNull(message = "amount is required")
    private Double amount;
    
    @JsonProperty(value = "terms")
    @ApiModelProperty(value = "terms", dataType = "Integer", example = "52", required = true)
    @NotNull(message = "terms is required")
    private Integer terms;
    
    @JsonProperty(value = "rate")
    @ApiModelProperty(value = "rate", dataType = "Double", example = "50.00", required = true)
    @NotNull(message = "rate is required")
    private Double rate;
    
}
