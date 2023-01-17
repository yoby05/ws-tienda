package com.tienda.utils;

/**
 * @author Yoan Hernandez
 * @date 17 ene 2023
 */
public class StringUtil {
    /**
     * Verificar si cadena es null o vacia
     * @param cadena
     * @return Boolean
     */
    public static Boolean cadenaDiffNullVacia(String cadena) {
        return cadena != null && !cadena.trim().isEmpty();
    }

    /**
     * Reemplazar caracteres especiales
     * @param cadena
     * @return String
     */
    public static String reemplazarCaracteresEspecialesHtml(String cadena) {
        return cadena.replace("á", "&aacute;")
                .replace("é", "&eacute;")
                .replace("í", "&iacute;")
                .replace("ó", "&oacute;")
                .replace("ú", "&uacute;")
                .replace("ñ", "&ntilde;")
                .replace("Á", "&Aacute;")
                .replace("É", "&Eacute;")
                .replace("Í", "&Iacute;")
                .replace("Ó", "&Oacute;")
                .replace("Ú", "&Uacute;")
                .replace("Ñ", "&Ntilde;");
    }

    /**
     * Obtener Array String separador coma
     * @param cadena
     * @return Arreglo
     */
    public static String[] arrayString(String cadena) {
        if (cadena.contains(",")) {
            return cadena.split(",");
        } else {
            return new String[] { cadena };
        }
    }
}
