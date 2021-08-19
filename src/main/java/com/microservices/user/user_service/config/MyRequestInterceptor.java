package com.microservices.user.user_service.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class MyRequestInterceptor implements ClientHttpRequestInterceptor{

	private Logger logger = LoggerFactory.getLogger(MyRequestInterceptor.class);
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		logger.info("*********************  Request Details  **********************");
		logger.info(" URI - {}", request.getURI());
		logger.info("Headers - {}", request.getHeaders());
		logger.info("Method - {}" , request.getMethod());
		
		ClientHttpResponse response = execution.execute(request, body);
		
		MyClientHttpResponse myClientHttpResponse = new MyClientHttpResponse(response);
		
		logger.info("************************ Response Details ************************");
		logger.info("Response status - {}", myClientHttpResponse.getStatusCode());
		logger.info("Body - {}", getResponseBody(myClientHttpResponse.getBody()));
		
		return myClientHttpResponse;
	}
	
	
	private String getResponseBody(InputStream inputStream) throws IOException {
		StringBuilder inputStringBuilder = new StringBuilder();

        try  (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)))
        {
            String line = bufferedReader.readLine();
            while (line != null) {
                inputStringBuilder.append(line);
                inputStringBuilder.append('\n');
                line = bufferedReader.readLine();
            }
            return inputStringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}

}
