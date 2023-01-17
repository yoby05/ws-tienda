package com.tienda.response;

import com.tienda.dto.PricesDto;

import lombok.Data;

/**
 * @author Yoan Hernandez
 * @date 17 ene 2023
 */
@Data
public class PricesResponse {
    private String codigo;
    private String mensaje;
    private PricesDto price;

    /**
     * Crea una nueva instancia de la clase PricesResponse
     */
    public PricesResponse() {
        super();
    }

    /**
     * Crea una nueva instancia de la clase PricesResponse
     * @param codigo
     * @param mensaje
     */
    public PricesResponse(String codigo, String mensaje) {
        super();
        this.codigo = codigo;
        this.mensaje = mensaje;
    }
}
