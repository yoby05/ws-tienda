package com.tienda.enumApp;

/**
 * @author Yoan Hernandez
 * @date 17 ene 2023
 */
public enum EnumFormatDate {
    /**
     * El elemento FECHA_TIME_ENGLISH cuyo formato es "dd-MM-yyyy".
     */
    FECHA_TIME_ENGLISH("yyyy-MM-dd HH:mm:ss"),
    /**
     * El elemento FECHA_TIME cuyo formato es "dd-MM-yyyy".
     */
    FECHA_TIME("dd-MM-yyyy HH:mm:ss"),
    /**
     * El elemento FECHA cuyo formato es "dd-MM-yyyy".
     */
    FECHA("dd-MM-yyyy"),
    /**
     * El elemento FECHA_SLACH cuyo formato es "dd/MM/yyyy".
     */
    FECHA_SLACH("dd/MM/yyyy"),
    /**
     * El elemento FECHA_FICHERO cuyo formato es "ddMMyyyy".
     */
    FECHA_FICHERO("ddMMyyyy"),
    /**
     * El elemento FECHA cuyo formato es "yyyy-MM-dd"
     */
    FECHA_GUION_POSTGRES("yyyy-MM-dd"),
    /**
     * El elemento FECHA cuyo formato es "MM/yyyy"
     */
    FECHA_MES_ANNO("MM/yyyy");

    /**
     * Propiedad que contiene el formato para la fecha.
     */
    private final String formato;

    /**
     * Constructor por defecto de la enumeracion.
     * @param formato Formato para desplegar la fecha.
     */
    EnumFormatDate(String formato) {
        this.formato = formato;
    }

    /**
     * Retorna el formato asociado al elemento de la enumeracion.
     * @return formato asociado al elemento de la enumeracion.
     */
    public String formato() {
        return this.formato;
    }

    /**
     * Devuele el separador de fechas utilizado en el formato actual.
     * @return el separador de fechas del formato
     */
    public char separadorFecha() {
        return this.formato.charAt(2);
    }
}
