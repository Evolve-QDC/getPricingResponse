package com.fopers.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.annotations.SourceType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import com.fopers.business.FopersServiceBP;
import com.fopers.business.CryptoLibrary;
import com.fopers.business.FopersServiceBP;
import com.fopers.model.AdminDashboard;
import com.fopers.model.ApiResponse;
import com.fopers.repository.FopersServiceRepository;

import io.jsonwebtoken.Jwt;

@RestController
@EnableAsync
@CrossOrigin
@RequestMapping("/api/v1/fopers")
public class FopersServiceController {

	@Autowired
	FopersServiceBP fopersServiceBP;

	@Autowired
	private FopersServiceRepository fopersServiceRepository;


	@PostMapping(path = "/getPricingResponse", produces = "application/json")
	public String getPricingResponse(@RequestBody String pricingBody) {
		JSONArray returnArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		String resBody = "";
		try {
			MediaType JSON = MediaType.parse("application/json");
			String content = "{\"JSONString\":\"" + pricingBody
					+ "\",\"ClientID\":3347,\"ClientMargin\":3.0000,\"Portal\":\"ADMIN\",\"PriceRange\":\"\",\"IncludingNoStock\":true}";
			okhttp3.RequestBody body = okhttp3.RequestBody.create(JSON, pricingBody);
			OkHttpClient client = new OkHttpClient.Builder()
			        .connectTimeout(40, TimeUnit.SECONDS)
			        .writeTimeout(40, TimeUnit.SECONDS)
			        .readTimeout(40, TimeUnit.SECONDS)
			        .build();
			System.out.println("first");
			Request request = new Request.Builder()
					.url("https://q2020adminapi-dev2dot1.azurewebsites.net/api/QPCSearchFilter").method("POST", body)
					.addHeader("Content-Type", "application/json")
					.addHeader("api-key", "A0ADF9E8DC41E77F3F037DC56081069D").build();
			Response response = client.newCall(request).execute();
			resBody = response.body().string();
			System.out.println("last");
		} catch (Exception e) {
			e.printStackTrace();
			JSONObject obj = new JSONObject();
			obj.put("status", 0);
			returnArray.add(obj);
		}
		return resBody;
	}

	// Mobile App API Ends

}
