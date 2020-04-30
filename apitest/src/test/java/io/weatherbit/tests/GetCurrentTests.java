package io.weatherbit.tests;

import io.restassured.response.Response;
import io.weatherbit.base.SetUp;
import io.weatherbit.pojomodels.current.CurrentResponse;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetCurrentTests {
    private HashMap<String,Object> params = new HashMap<>();

    @Test
    public void getCurrent(){
    	SetUp a_key=new SetUp(); 	
        String uri = "https://api.weatherbit.io/v2.0/current";
//        params.put("lat",40.730610);
//        params.put("lon", -73.935242);
        params.put("city","London");
     params.put("country","UK");

        params.put("key",a_key.getApiKey());
        Response respone = given().params(params).when().get(uri);
        Assert.assertTrue(respone.statusCode()==200);
        CurrentResponse currentResponse = respone.as(CurrentResponse.class);
     //   Assert.assertEquals(currentResponse.getData().get(0).getStateCode(),"NY");
        Assert.assertEquals(currentResponse.getData().get(0).getStateCode(),"ENG");
        Reporter.log("The Current weather at location is :"  ,true);

    }

}