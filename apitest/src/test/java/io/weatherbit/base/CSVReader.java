package io.weatherbit.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
	BufferedReader csvReader = null;
	String row = "";
	
	List<List<String>> records = new ArrayList<>();

	public List<List<String>>  readCSV() {
		try {	
			
			String path = System.getProperty("user.dir");
			csvReader = new BufferedReader(new FileReader(path+"/resources/samplefile.csv"));
		
			while ((row = csvReader.readLine()) != null) {
				String[] values=row.split(",");
				//System.out.println("Coordinates [code= " + data[0] + " , name=" + data[1] + "]");
				records.add(Arrays.asList(values));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (csvReader != null) {
				try {
					csvReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println();
			}
		}
		return records;
	}
}
