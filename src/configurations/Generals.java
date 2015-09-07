/*
 */
package configurations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Duku
 */
public class Generals {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    /**
    * Regresando la fecha actual, puede servir para inserciones en la bd o para obtener la fecha actual
    * con formato [año]/[mes]/[dia] [hora]:[minutos]:[segundos]
    * 
    * @return a date in string format
    */
    public String getActualDate () {
        Date date = new Date();

        return dateFormat.format(date);
    }
}
