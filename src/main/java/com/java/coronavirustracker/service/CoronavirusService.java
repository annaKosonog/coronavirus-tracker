package com.java.coronavirustracker.service;


import com.java.coronavirustracker.model.LocationStat;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronavirusService {
    private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    @PostConstruct
    public void fetchVirusData() {
        List<LocationStat> newStats = new ArrayList<>();

        HttpGet httpGet = new HttpGet(VIRUS_DATA_URL);
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse httpResponse = null;
        String responseBody= null;
        try {
            httpResponse = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (InputStream inputStream = httpResponse.getEntity().getContent()) {
            responseBody = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(responseBody);
        }
    }

}
