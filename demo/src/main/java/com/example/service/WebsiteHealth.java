package com.example.service;


import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


public class WebsiteHealth implements HealthIndicator {


	@Override
	
	public Health health() {
		try {
			
			URL siteURL = new URL("https://www.abhishekpal1814.com");
			HttpURLConnection connection = (HttpURLConnection)siteURL.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int code = connection.getResponseCode();
			if(code == 200)
			{
				return Health.up().build();
			}
			else {
				return Health.down().withDetail("error", "status is down").build();
			}
	}
		catch(Exception e){
			
			return Health.down().withDetail("error","Service Unavailable").build();
			}
		
		}

}

