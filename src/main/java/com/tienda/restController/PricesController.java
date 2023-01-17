package com.tienda.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import com.tienda.dto.PricesDto;
import com.tienda.response.PricesResponse;
import com.tienda.service.PricesService;

/**
 * @author Yoan Hernandez
 * @date 17 ene 2023
 */
@RestController
@SessionScope
@RequestMapping(value = "/prices")
public class PricesController {
    @Autowired
    private PricesService pricesService;

    /**
     * Get sale Price
     * @param entry
     * @return PricesResponse
     */
    @PostMapping(value = "/sale", consumes = { "application/json" }, produces = { "application/json" + ";charset=utf-8" })
    public @ResponseBody PricesResponse salePrice(@RequestBody @Valid PricesDto entry) {
        return this.pricesService.salePrice(entry);
    }
}
