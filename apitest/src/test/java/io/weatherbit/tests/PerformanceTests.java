package io.weatherbit.tests;

import static io.restassured.RestAssured.given;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.weatherbit.base.SetUp;
import io.weatherbit.pojomodels.current.CurrentResponse;
import io.weatherbit.base.CSVReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

public class PerformanceTests {

	HashMap<String, Object> params = new HashMap<>();

	final Logger LOGGER = Logger.getLogger(PerformanceTests.class.getName());
	SetUp a_key = new SetUp();
	CSVReader csvread = new CSVReader();

	public void getForecast(String data) {
		String uri = "https://api.weatherbit.io/v2.0/forecast/daily";
	
		params.put("postal_code", data);
		params.put("key", a_key.getApiKey());

		long timeInMSec = given().params(params).when().get(uri).time();
		System.out.println("Forecast API---- Response Time is : " + timeInMSec);

	}

	public void getGeoDetails(String lat, String lon)

	{
		String geo_uri = "https://api.weatherbit.io/v2.0/current";
		// params.put("lat",40.730610);
		params.put("lat", lat);
		params.put("lon", lon);
		params.put("key", a_key.getApiKey());
		Response respone = given().params(params).when().get(geo_uri);
		CurrentResponse currentResponse = respone.as(CurrentResponse.class);
		System.out.println("The State Code for First Trigger  :" + (currentResponse.getData().get(0).getStateCode()));
		long timeInMinSec = given().params(params).when().get(geo_uri).time();
		System.out.println("Current API---- Response Time is : " + timeInMinSec);

	}

	public void TrigTime()

	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		System.out.println("Record The Firing Time :" + (dtf.format(now)));
	}

//	@Test
	public void Performance() throws InterruptedException {
		List<List<String>> records = csvread.readCSV();

		System.out.println("Total Number of Data Sets = " + records.size());

		// System.out.println(records);
		for (List<String> row : records) {
			TrigTime();
			getGeoDetails(row.get(0), row.get(1));
			getForecast(row.get(2));
			Thread.sleep(6000);
		}
		
	}
}
