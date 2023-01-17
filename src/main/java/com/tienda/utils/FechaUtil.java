package com.tienda.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;

import com.tienda.enumApp.EnumFormatDate;

/**
 * @author Yoan Hernandez.
 * @version 0.0.1
 */
public final class FechaUtil {
    /**
     * Obtiene la zona horaria.
     * @return Zona horaria.
     */
    public static TimeZone timeZone() {
        return Calendar.getInstance().getTimeZone();
    }

    /**
     * Obtiene la fecha completa del instante cuando es invocado (annio, mes, dia, hora, minuto, segundo, etc.).
     * @return Fecha completa (annio, mes, dia, hora, minuto, segundo, etc.).
     */
    public static Date ahora() {
        return Calendar.getInstance().getTime();
    }

    /**
     * Obtiene la fecha completa del instante cuando es invocado (annio, mes, dia, hora, minuto, segundo, etc.). la fecha es
     * devuelta con la hora y minutos especificados
     * @param hora
     * @param minutos
     * @return Fecha completa (annio, mes, dia, hora, minuto, segundo, etc.).
     */
    public static Date ahora(Integer hora, Integer minutos) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hora);
        cal.set(Calendar.MINUTE, minutos);
        return cal.getTime();
    }

    /**
     * Obtiene la fecha del dia cuando es invocado (annio, mes y dia).
     * @return Fecha del dia con valores del annio, mes y dia, el resto de componentes de la fecha redondeados a cero (Hora,
     *         minuto, segundo, etc.).
     */
    public static Date hoy() {
        return DateUtils.truncate(Calendar.getInstance().getTime(), Calendar.DAY_OF_MONTH);
    }

    /**
     * Obtiene el year actual (annio, mes y dia).
     * @return el year actual
     */
    public static int yearActual() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    /**
     * Convierte una fecha a un string segun un formato especificado
     * @param fecha
     * @param mascara
     * @return la fecha convertida al formato especificado en la mascara
     */
    public static String convertirFechaString(Date fecha, EnumFormatDate... mascara) {
        if (fecha != null) {
            DateFormat fechaHora;
            if (mascara != null && mascara.length > 0) {
                fechaHora = new SimpleDateFormat(mascara[0].formato());
            } else {
                fechaHora = new SimpleDateFormat(EnumFormatDate.FECHA.formato());
            }
            return fechaHora.format(fecha);
        } else {
            return null;
        }
    }

    /**
     * Convierte una fecha a un string segun un formato especificado
     * @param fecha
     * @param mascara
     * @return la fecha convertida al formato especificado en la mascara
     */
    public static String convertirFechaString(Date fecha, String mascara) {
        if (fecha != null) {
            DateFormat fechaHora;
            if (mascara != null && !mascara.isEmpty()) {
                fechaHora = new SimpleDateFormat(mascara);
            } else {
                fechaHora = new SimpleDateFormat(EnumFormatDate.FECHA.formato());
            }
            return fechaHora.format(fecha);
        }
        return null;
    }

    /**
     * Convierte una fecha a un string segun un formato especificado
     * @param fechaString
     * @param mascara
     * @return la fecha convertida al formato especificado en la mascara
     * @throws RuntimeException error en la conversion de fecha
     */
    public static Date convertirStringFecha(String fechaString, EnumFormatDate... mascara) throws RuntimeException {
        Date fechaResultado = null;
        if (StringUtil.cadenaDiffNullVacia(fechaString)) {
            String formato = EnumFormatDate.FECHA.formato();
            if (mascara != null && mascara.length > 0) {
                formato = mascara[0].formato();
            }
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(formato);
                fechaResultado = formatter.parse(fechaString);
            } catch (ParseException e) {
                throw new RuntimeException("El valor de fecha  " + fechaString
                        + " no puede ser convertido a una fecha v�lida acorde al formato: " + formato, e);
            }
        }
        return fechaResultado;
    }

    /**
     * Convierte una fecha a un string segun un formato especificado
     * @param fechaString
     * @param mascara
     * @return la fecha convertida al formato especificado en la mascara
     * @throws RuntimeException error en la conversion de fecha
     */
    public static Date convertirStringFecha(String fechaString, String mascara) throws RuntimeException {
        Date fechaResultado = null;
        if (StringUtil.cadenaDiffNullVacia(fechaString)) {
            String formato = EnumFormatDate.FECHA.formato();
            if (mascara != null && !mascara.isEmpty()) {
                formato = mascara;
            }
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(formato, Locale.ENGLISH);
                fechaResultado = formatter.parse(fechaString);
            } catch (ParseException e) {
                throw new RuntimeException("El valor de fecha  " + fechaString
                        + " no puede ser convertido a una fecha correcta acorde al formato: " + formato, e);
            }
        }
        return fechaResultado;
    }

    /**
     * Obtiene el ultimo dia del mes a la que pertenece una fecha determinada(<code>fechaBase</code>).
     * @param fechaBase Fecha base para la busqueda del ultimo dia del mes a la que pertenece.
     * @return Fecha del ultimo dia del mes a la que pertenece la fechaBase.
     */
    public static Date obtenerFechaUltimoDiaMes(Date fechaBase) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaBase);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * Obtiene el primer dia del mes a la que pertenece una fecha determinada(<code>fechaBase</code>).
     * @param fechaBase Fecha base para la busqueda del primer dia del mes a la que pertenece.
     * @return Fecha del primer dia del mes a la que pertenece la fechaBase.
     */
    public static Date obtenerFechaPrimerDiaMes(Date fechaBase) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaBase);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * Si la fecha que se compara es anterior a la fecha base
     * @param fechaCompara fecha que se desea comparar
     * @param fechaBase fecha base de la comparacion
     * @return Si la fecha que se compara es anterior a la fecha base
     */
    public static boolean anterior(Date fechaCompara, Date fechaBase) {
        return fechaCompara.before(fechaBase);
    }

    /**
     * Si la fecha que se compara es anterior/igual a la fecha base
     * @param fechaCompara fecha que se desea comparar
     * @param fechaBase fecha base de la comparacion
     * @return Si la fecha que se compara es anterior/igual a la fecha base
     */
    public static boolean anteriorIgual(Date fechaCompara, Date fechaBase) {
        return !fechaCompara.after(fechaBase);
    }

    /**
     * Si la fecha que se compara es igual a la fecha base
     * @param fechaCompara fecha que se desea comparar
     * @param fechaBase fecha base de la comparacion
     * @return Si la fecha que se compara es igual a la fecha base
     */
    public static boolean igual(Date fechaCompara, Date fechaBase) {
        return fechaCompara.equals(fechaBase);
    }

    /**
     * Si la fecha que se compara es posterior a la fecha base
     * @param fechaCompara fecha que se desea comparar
     * @param fechaBase fecha base de la comparacion
     * @return Si la fecha que se compara es posterior a la fecha base
     */
    public static boolean posterior(Date fechaCompara, Date fechaBase) {
        return fechaCompara.after(fechaBase);
    }

    /**
     * Si la fecha que se compara es posterior/igual a la fecha base
     * @param fechaCompara fecha que se desea comparar
     * @param fechaBase fecha base de la comparacion
     * @return Si la fecha que se compara es posterior/igual a la fecha base
     */
    public static boolean posteriorIgual(Date fechaCompara, Date fechaBase) {
        return !fechaCompara.before(fechaBase);
    }

    /**
     * Agregar dias a una fecha
     * @param fecha
     * @param cantidadAgregar
     * @return nueva fecha
     */
    public static Date agregarDia(Date fecha, int cantidadAgregar) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        c.add(Calendar.DAY_OF_YEAR, cantidadAgregar);
        return c.getTime();
    }

    /**
     * Retorna una nueva fecha donde se incrementa/resta un numero de meses a una fecha (fechaOriginal).
     * @param fechaOriginal Fecha sobre la cual se opera la adicion/resta de meses.
     * @param cantidadMeses La cantidad de meses por incrementar/restar; no debe ser nulo.
     * @return Nueva fecha con el incremento/resta de meses a la fechaOriginal.
     */
    public static Date agregarMeses(Date fechaOriginal, int cantidadMeses) {
        return DateUtils.addMonths(fechaOriginal, cantidadMeses);
    }

    /**
     * Retorna una nueva fecha donde se incrementa numero de annos a una fecha (fechaOriginal).
     * @param fechaOriginal Fecha sobre la cual se opera la adicion/resta de meses.
     * @param cantidadAnnos La cantidad de meses por incrementar/restar; no debe ser nulo.
     * @return Nueva fecha con el incremento/resta de meses a la fechaOriginal.
     */
    public static Date agregarAnnos(Date fechaOriginal, int cantidadAnnos) {
        return DateUtils.addYears(fechaOriginal, cantidadAnnos);
    }

    /**
     * Retorna una nueva fecha donde se incrementa/resta un numero de minutos a la fecha (fechaOriginal).
     * @param fechaOriginal
     * @param cantidadMinutos
     * @return la nueva fecha con la adicion de minutos realizada
     */
    public static Date agregarMinutos(Date fechaOriginal, int cantidadMinutos) {
        return DateUtils.addMinutes(fechaOriginal, cantidadMinutos);
    }

    /**
     * Obtiene el numero de dias que existen entre un rango de fechas(fechaDesde, fechaHasta).
     * @param fechaInicio Fecha inicial del rango.
     * @param fechaFin Fecha final del rango.
     * @return Numero de dias entre el rango de fechas
     */
    public static int diasEntreFechas(Date fechaInicio, Date fechaFin) {
        Date resultado = new Date(
                obtenerCalendario(fechaFin).getTimeInMillis() - FechaUtil.obtenerCalendario(fechaInicio).getTimeInMillis());
        long dia = 24 * 60 * 60 * 1000;
        long resultadoL = resultado.getTime() / dia;
        return (int) resultadoL;
    }

    /**
     * Convierte un tipo de dato <code>Date</code> al tipo de dato <code>Calendar</code>.
     * @param fecha Fecha que se requiere convertir a Calendar.
     * @return Calendar instanciado con la fecha.
     */
    public static Calendar obtenerCalendario(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        return calendar;
    }

    /**
     * Get age in letters EN_en
     * @param fechaDesde
     * @param fechaHasta
     * @return String
     */
    public static String getYearLettersEN_en(Date fechaDesde, Date fechaHasta) {
        int year = aniosCumplidos(fechaDesde, fechaHasta);
        return year + " years ";
    }

    /**
     * Get age in letters ES_es
     * @param fechaDesde
     * @param fechaHasta
     * @return String
     */
    public static String getYearLettersES_es(Date fechaDesde, Date fechaHasta) {
        int year = aniosCumplidos(fechaDesde, fechaHasta);
        return year + " años ";
    }

    /**
     * Meses Cumplidos
     * @param fechaDesde
     * @param fechaHasta
     * @return int
     */
    public static int mesesCumplidos(Date fechaDesde, Date fechaHasta) {
        int anios = aniosCumplidos(fechaDesde, fechaHasta);
        int meses = dateDiff(fechaDesde, fechaHasta).get(Calendar.MONTH);
        return anios * 12 + meses;
    }

    /**
     * Anios cumplidos
     * @param fechaDesde
     * @param fechaHasta
     * @return int
     */
    public static int aniosCumplidos(Date fechaDesde, Date fechaHasta) {
        return dateDiff(fechaDesde, fechaHasta).get(Calendar.YEAR) - 1970;
    }

    /**
     * Diferencia de Fechas
     * @param fechaDesde
     * @param fechaHasta
     * @return Calendar
     */
    public static Calendar dateDiff(Date fechaDesde, Date fechaHasta) {
        Calendar dateDiff = new GregorianCalendar();
        dateDiff.setTimeInMillis(fechaHasta.getTime() - fechaDesde.getTime());
        return dateDiff;
    }

    /**
     * Verifica la fecha por parametro si cumple con algunos de los patrones establecido y convierte la fecha a un nuevo patron
     * especificado por parametro
     * @param fecha
     * @param patronSalida
     * @return Date
     */
    public static Date castDateAllFormatterToDateEn(String fecha, String patronSalida) {
        Date nuevaFecha = null;
        try {
            nuevaFecha = DateUtils.parseDate(fecha, Locale.ENGLISH,
                    new String[] { "MM/dd/yyyy", "MM/dd/yyyy HH:mm:ss", "EEE MMM dd HH:mm:ss z yyyy" });
        } catch (ParseException e) {
            throw new RuntimeException("El valor de fecha  " + fecha
                    + " no puede ser convertido a una fecha correcta acorde al formato: " + patronSalida, e);
        }
        return nuevaFecha;
    }

    /**
     * Verifica la fecha por parametro si cumple con algunos de los patrones establecido y convierte la fecha a un nuevo patron
     * especificado por parametro
     * @param fecha
     * @param patronSalida
     * @return String
     */
    public static String castDateAllFormatterToStringEn(String fecha, String patronSalida) {
        String nuevaFecha = null;
        try {
            Date fechaParse = DateUtils.parseDate(fecha, Locale.ENGLISH,
                    new String[] { "MM/dd/yyyy", "MM/dd/yyyy HH:mm:ss", "EEE MMM dd HH:mm:ss z yyyy" });
            nuevaFecha = convertirFechaString(fechaParse, patronSalida);
        } catch (ParseException e) {
            throw new RuntimeException("El valor de fecha  " + fecha
                    + " no puede ser convertido a una fecha correcta acorde al formato: " + patronSalida, e);
        }
        return nuevaFecha;
    }
}
