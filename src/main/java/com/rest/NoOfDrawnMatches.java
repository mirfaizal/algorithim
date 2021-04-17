package com.rest;

import com.google.gson.Gson;

import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class NoOfDrawnMatches {

    class Result{
        public String competition;
        public int year;
        public String round;
        public String team1;
        public String team2;
        public String team1goals;
        public String team2goals;
    }

    class Matches{
        public int page;
        public int per_page;
        public int total;
        public int total_pages;
        public List<Result> data;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getNumDraws(2011));
    }
    public static int getNumDraws(int year) throws IOException {
        int totalDraws = 0;
        String URL = "https://jsonmock.hackerrank.com/api/football_matches";
        for(int i=1;i<=10;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(URL);
            sb.append("?year=");
            sb.append(year);
            sb.append("&team1goals=");
            sb.append(i);
            sb.append("&team2goals=");
            sb.append(i);
            totalDraws += countDraws(sb.toString());
        }
        return totalDraws;
    }

    private static int countDraws(String request) throws IOException {
        URL url = new URL(request );
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setRequestProperty("Content-Type","application/json");
        int status = httpURLConnection.getResponseCode();
        InputStream is = (status < 200 || status>299 ) ?httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String readLine;
        StringBuilder sb = new StringBuilder();
        while((readLine = br.readLine()) != null){
            sb.append(readLine);
        }
        br.close();
        is.close();
        httpURLConnection.disconnect();
        Gson gson = new Gson();
        Matches matches = gson.fromJson(sb.toString(),Matches.class);


        return matches.total;
    }
}
