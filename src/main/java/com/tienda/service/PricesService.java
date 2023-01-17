package com.tienda.service;

import com.tienda.dto.PricesDto;
import com.tienda.response.PricesResponse;

/**
 * @author Yoan Hernandez
 * @date 17 ene 2023
 */
public interface PricesService {
    /**
     * sale price
     * @param entry
     * @return PricesResponse
     */
    PricesResponse salePrice(PricesDto entry);
}
