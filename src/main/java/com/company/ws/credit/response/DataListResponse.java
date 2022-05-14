/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ws.credit.response;

import com.company.ws.credit.utils.CommonResponse;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author luis
 */
@Setter
@Getter
public class DataListResponse<T> extends CommonResponse{
    private List<T> data;
}
