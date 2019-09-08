package io.weatherbit.base;

import org.testng.annotations.BeforeClass;


public class SetUp {

    private static String apiKey="f5cac90602b041bbbb06bbd8da24915b";

    @BeforeClass
    public void setUp(){

        apiKey = System.getenv("apikey");
    }
    
    @BeforeClass
    public String getApiKey() {
    	
    	return apiKey;
    	
    }

}
