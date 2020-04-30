# RevIT
NSW-UI + API

Folder-->apitest (TestNG framework)

Test Cases path--> /apitest/src/test/java/io/weatherbit/tests--> Run as TestNG

ApiKey Configuration file-->/apitest/src/test/java/io/weatherbit/base/CSVReader.java

1) GetCurrentTests (GET /current?lat={lat}&lon={lon} -Data is hard coded 
/apitest/src/test/java/io/weatherbit/tests/GetCurrentTests.java

2) GET /forecast/daily?postal_code={postal_code}- Data is hard coded
/apitest/src/test/java/io/weatherbit/tests/GetForecastDailyTests.java

3) Performance Test 
/apitest/src/test/java/io/weatherbit/tests/PerformanceTests.java
DATA:
data sheet CSV--> /apitest/src/test/java/io/weatherbit/base/CSVReader.java
Test Cases:
1-Hits 2 URI 10 Times in 1 Min. Note the Response Time
2-Ramp up from 2 Hits per second .Note response Time
3-Reach peak 20 hits in 30 seconds continue for a minute.Nore Response time for each API


