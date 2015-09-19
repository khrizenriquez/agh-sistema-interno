/*
 */
package configurations;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Conexion;
import org.json.simple.*;

/**
 * @author Duku
 */
public class Generals {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private ResultSet rs = null;
    
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
    
    /**
    * 
    * 
    * @return a object in json notation
    */
    public JSONObject genericQuery (String tableName, String fieldName, String userName) {
        JSONObject result           = new JSONObject();
        JSONArray tmpArrayResult    = new JSONArray();
        JSONObject tmpObjResult     = new JSONObject();
        String rawQuery = "SELECT " + fieldName + " FROM " + tableName + " where "+ tableName +".user_name = '" 
                    + userName + "'";
        try {
            rs = Conexion.getInstance().doQuery(rawQuery);
            result.put("Result", "OK");
            int count = 0;
            while (rs.next()) {
                tmpObjResult.put(fieldName, rs.getString(fieldName));
                count++;
            }
            
            if (count == 0) 
                result.put("Data", null);
            else 
                result.put("Data", tmpObjResult);

            return result;
        } catch (Exception e) {
           e.printStackTrace();
            System.err.println(e.getMessage());
            result.put("Data", null);
            return result;
        }
    }
}
