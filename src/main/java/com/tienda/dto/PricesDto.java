package com.tienda.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

/**
 * @author Yoan Hernandez
 * @date 17 ene 2023
 */
@Data
public class PricesDto implements Serializable {
    private static final long serialVersionUID = -5960803209866631205L;
    @NotNull(message = "El campo es obligatorio")
    private Long idProduct;
    @NotNull(message = "El campo es obligatorio")
    private Long idBrand;
    private String rate;
    private BigDecimal price;
    @NotEmpty(message = "El campo es obligatorio")
    private String dateAplication;
    private String startAplication;
    private String endAplication;

    /**
     *
     */
    public PricesDto() {
        super();
    }

    /**
     * @param idProduct
     * @param idBrand
     * @param dateAplication
     */
    public PricesDto(@NotNull(message = "El campo es obligatorio") Long idProduct,
            @NotNull(message = "El campo es obligatorio") Long idBrand,
            @NotEmpty(message = "El campo es obligatorio") @Pattern(
                    regexp = "^(0[1-9]|1\\d|2[0-8]|29(?=-\\d\\d-(?!1[01345789]00|2[1235679]00)\\d\\d(?:[02468][048]|[13579][26]))|30(?!-02)|31(?=-0[13578]|-1[02]))-(0[1-9]|1[0-2])-([12]\\d{3}) ([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$",
                    message = "La fecha no es válida. Formato permitido dd-MM-yyyy HH:mm:ss") String dateAplication) {
        this.idProduct = idProduct;
        this.idBrand = idBrand;
        this.dateAplication = dateAplication;
    }
}
