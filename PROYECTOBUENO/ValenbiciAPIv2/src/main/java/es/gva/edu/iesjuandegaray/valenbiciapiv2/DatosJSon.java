package es.gva.edu.iesjuandegaray.valenbiciapiv2;
 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 *
 * @author Eva G.
 */

public class DatosJSon {
    private static String API_URL;// = "https://valencia.opendatasoft.com/api/explore/v2.1/catalog/datasets/valenbisi-disponibilitat-valenbisi-dsiponibilidad/records?f=json&location=39.46447,-0.39308&distance=10&limit="+nE;
    private  String datos="";
    
    private String [] values;//={"","",""};
    private int numEst;
    
    public DatosJSon(int nE){
          numEst = nE;
          datos = "";
          API_URL ="https://valencia.opendatasoft.com/api/explore/v2.1/catalog/datasets/valenbisi-disponibilitat-valenbisi-dsiponibilidad/records?f=json&location=39.46447,-0.39308&distance=10&limit=" + nE;
          
          values = new String [numEst];
          
          for (int i = 0; i < numEst; i++ )
              values[i] = "";
    }
    
    /*public String calcularFechaActual(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date); //16/03/2025 12:08:43
    }*/
    
    
    public void mostrarDatos(int nE){
        
        numEst = nE;
        datos="";
        API_URL ="https://valencia.opendatasoft.com/api/explore/v2.1/catalog/datasets/valenbisi-disponibilitat-valenbisi-dsiponibilidad/records?f=json&location=39.46447,-0.39308&distance=10&limit=" + nE;
        values = new String [numEst];
        for (int i = 0; i < numEst; i++ )
              values[i] = "";

        double lon,lat;
      
        if (API_URL.isEmpty()) {
            //System.err.println("La URL de la API no está especificada.");
            setDatos(getDatos().concat("La URL de la API no está especificada."));
            return;
        }

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(API_URL);
            HttpResponse response = httpClient.execute(request);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
             

                // Intentamos procesar la respuesta como JSON
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray resultsArray = jsonObject.getJSONArray("results");

                    for (int i = 0; i < resultsArray.length(); i++) {
                        JSONObject station = resultsArray.getJSONObject(i);
                        setDatos(getDatos().concat("Estación: " + station.getString("address")+ "\n"));
                        setDatos(getDatos().concat("Bicicletas disponibles: " + station.getInt("available")+ "\n"));
                        setDatos(getDatos().concat("Espacios disponibles: " + station.getInt("free")+ "\n"));
                        JSONObject point2d = station.getJSONObject("geo_point_2d");
                                
                        lon =  point2d.getDouble("lon");
                        lat =  point2d.getDouble("lat");
                        setDatos(getDatos().concat("Ubicacion_lon: " + lon+"\n"));
                        setDatos(getDatos().concat("Ubicacion_lat: " + lat+"\n"));
                        setDatos(getDatos().concat("--------------------------\n"));
                       
                        getValues()[i] = getValues()[i].concat("("+ station.getInt("number")+ ",'"+station.getString("address")+"',"+station.getInt("available")+","+station.getInt("free")+","+1+"," +  "ST_GeomFromText('POINT(" + lon + " "+ lat +")'))");
                    
                    }
                } catch (org.json.JSONException e) {
                    // Si la respuesta no es un array JSON, imprimimos el mensaje de error
                    //System.err.println("Error al procesar los datos JSON: " + e.getMessage());
                    setDatos(getDatos().concat("Error al procesar los datos JSON: "));

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
}

    /**
     * @return the datos
     */
    public String getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(String datos) {
        this.datos = datos;
    }

    /**
     * @return the values
     */
    public String[] getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(String[] values) {
        this.values = values;
    }

    /**
     * @return the numEst
     */
    public int getNumEst() {
        return numEst;
    }

    /**
     * @param numEst the numEst to set
     */
    public void setNumEst(int numEst) {
        this.numEst = numEst;
    }
}


