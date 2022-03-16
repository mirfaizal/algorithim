package com.restapi;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class GetTotalGoals {


    public static void main(String[] args) throws IOException, ScriptException {
        System.out.println(getTotalGoals("Chelsea",2011));
        System.out.println(getTotalGoals("Barcelona",2011));
        System.out.println(getTotalGoals("AS Roma",2012));
        System.out.println(getTotalGoals("Borussia Dortmund",2013));
        System.out.println(getTotalGoals("As Monaco",2013));
        System.out.println(getTotalGoals("Borussia Dortmund",2013));
        System.out.println(getTotalGoals("Tottenham Hotspur",2014));
    }
    public static int getTotalGoals(String team, int year) throws IOException, ScriptException {
        String url = "https://jsonmock.hackerrank.com/api/football_matches";
        String homeURL = String.format(url + "?year=%d&team1=%s", year, URLEncoder.encode(team,"UTF-8"));
        String awayURL = String.format(url + "?year=%d&team2=%s", year, URLEncoder.encode(team,"UTF-8"));
        int totalGoalsAtHome = getPageTotalGoals( homeURL,"team1",1,0);
        int totalGoalsAtVisiting = getPageTotalGoals( awayURL,"team2",1,0);
        return totalGoalsAtHome + totalGoalsAtVisiting;
    }

    private static int getPageTotalGoals(String request, String team, int page, int totalGoals) throws IOException, ScriptException {
        URL url = new URL(request + "&page=" + page);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.addRequestProperty("Content-Type","application/json");
        int status = httpURLConnection.getResponseCode();
        InputStream is = (status <200 || status>299) ? httpURLConnection.getErrorStream():httpURLConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String responseLine;
        StringBuilder responseContent = new StringBuilder();
        while((responseLine = br.readLine()) !=null){
            responseContent.append(responseLine);
        }
        br.close();
        is.close();
        httpURLConnection.disconnect();

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        StringBuilder script = new StringBuilder();

        script.append("var obj = JSON.parse('" + responseContent + "');");
        script.append("var total_pages = obj.total_pages;");
        script.append("var total_goals = obj.data.reduce(function(accumulator,current) { return accumulator + parseInt(current."+team+"goals);},0);");

        engine.eval(String.valueOf(script));

        if(engine.get("total_pages") == null){
            throw new RuntimeException("Can not retrieve data from server");
        }
        int totalPages = (int) engine.get("total_pages");
        totalGoals += (int) Double.parseDouble(engine.get("total_goals").toString());

        return (page < totalPages) ? getPageTotalGoals(request,team,page+1,totalGoals):totalGoals;
    }
}
