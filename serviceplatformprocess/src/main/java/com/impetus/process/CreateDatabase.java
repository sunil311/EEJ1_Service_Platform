package com.impetus.process;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.impetus.process.dto.DBResponse;
import com.impetus.process.dto.InputData;

public class CreateDatabase {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();

		rt.getMessageConverters().add(new StringHttpMessageConverter());

		String uri = new String(
				"http://localhost:8080/webservice/createDatabase");

		InputData input = new InputData();

		input.setDbName("mun");
		input.setDbPassword("Impetus123#");	
		input.setDbURL("jdbc:jtds:sqlserver://192.168.219.51:1433");
		input.setDbUserName("sa");
		DBResponse response = rt.postForObject(uri, input,
				DBResponse.class);
		System.out.println(response.getResult());

	}

}
