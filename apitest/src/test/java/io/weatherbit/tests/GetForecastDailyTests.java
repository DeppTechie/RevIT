package io.weatherbit.tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.weatherbit.base.SetUp;
import io.weatherbit.pojomodels.current.CurrentResponse;

public class GetForecastDailyTests {
	
	
	 protected HashMap<String,Object> params = new HashMap<>();

	//    @Test
	    public void getForecast(){
	    	SetUp a_key=new SetUp();

	        String uri = "https://api.weatherbit.io/v2.0/forecast/daily";

	        params.put("postal_code","11101-2032");
	        params.put("key",a_key.getApiKey());
	        Response respone = given().params(params).when().get(uri);
	        Assert.assertTrue(respone.statusCode()==200);
	        
	        System.out.println(respone.getBody().asString());        
	        CurrentResponse currentResponse = respone.as(CurrentResponse.class);
	        for(int i=0; i<currentResponse.getData().size(); i++) {
	        	System.out.println("Timestamp : " + currentResponse.getData().get(i).getDatetime());
	        	System.out.println("Weather : " + currentResponse.getData().get(i).getWeather().getCode() + ", " + currentResponse.getData().get(i).getWeather().getDescription() + ", " + currentResponse.getData().get(i).getWeather().getIcon());
	        	System.out.println("--------------------------------------------------------------");
	        }

	    }
	
}
