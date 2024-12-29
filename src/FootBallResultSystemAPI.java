import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class FootBallResultSystemAPI {
	
	/**
	 * @param CountryName
	 * @return
	 */
	  public static JSONArray getLeageData(String CountryName){
	 
	        String urlString = " https://api.football-data.org/v4/competitions/" + CountryName + "/matches";

	        try{
	            
	            HttpURLConnection conn = fetchApiResponse(urlString);

	            if(conn.getResponseCode() != 200){
	                System.out.println("Error: Could not connect to API");
	                return null;
	            }

	           
	            StringBuilder resultJson = new StringBuilder();
	            Scanner scanner = new Scanner(conn.getInputStream());
	            while(scanner.hasNext()){
	                
	                resultJson.append(scanner.nextLine());
	            }
	            
	            
	            scanner.close();
	            
	            conn.disconnect();
	            
	            JSONParser parser = new JSONParser();
	            JSONObject resultJsonObj = (JSONObject) parser.parse(String.valueOf(resultJson));
	            
	            JSONArray matches = (JSONArray) resultJsonObj.get("matches");
	            return matches;
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }

	            return null;
	    }
	  
	  
	  private static HttpURLConnection fetchApiResponse(String urlString){
	        try{
	            
	            URL url = new URL(urlString);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestProperty("X-Auth-Token", "XXXX");
	        
	            conn.setRequestMethod("GET");
	          
	            conn.connect();
	            return conn;
	        }catch(IOException e){
	            e.printStackTrace();
	        }

	        return null;
	    }
	}