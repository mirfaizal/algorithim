package com.rest;

import javax.net.ssl.HttpsURLConnection;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;

public class WinnersGoal {
    public static void main(String[] args) throws IOException {
        System.out.println(getWinnerTotalGoals("UEFA Champions League",2011));
    }
    private static int getWinnerTotalGoals(String competition, int year) throws IOException {
        String footballCompetitionURL = "https://jsonmock.hackerrank.com/api/football_competitions";
        String footballMatchesURL = "https://jsonmock.hackerrank.com/api/football_matches";
        String winnerURL = String.format(footballCompetitionURL + "?name=%s&year=%d", URLEncoder.encode(competition,"UTF-8"),year);
        String winnerTeamName = getWinnerTeamName(winnerURL);
        String totalWinnerHomeGoalURL = String.format(footballMatchesURL + "?competition=%s&team1=%s&year=%d",URLEncoder.encode(competition,"UTF-8"), URLEncoder.encode(winnerTeamName, "UTF-8"),year);
        String totalWinnerAwayGoalURL = String.format(footballMatchesURL + "?competition=%s&team2=%s&year=%d",URLEncoder.encode(competition,"UTF-8"), URLEncoder.encode(winnerTeamName, "UTF-8"),year);
        int homeGoal = getTotalGoals(totalWinnerHomeGoalURL,"team1",1,0);
        int awayGoal = getTotalGoals(totalWinnerAwayGoalURL,"team2",1,0);
        return homeGoal + awayGoal;
    }

    private static int getTotalGoals(String request, String team, int page, int score) throws IOException {
        URL url = new URL(request + "&page=" +page);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.setConnectTimeout(5000);
        httpsURLConnection.setReadTimeout(5000);
        httpsURLConnection.setRequestProperty("Content-Type","application/json");
        int status = httpsURLConnection.getResponseCode();
        InputStream is = (status < 200 || status > 299) ?httpsURLConnection.getErrorStream() : httpsURLConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String readLine;
        StringBuilder sb = new StringBuilder();
        while((readLine = br.readLine()) != null){
            sb.append(readLine);
        }
        br.close();
        is.close();
        httpsURLConnection.disconnect();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        StringBuilder script = new StringBuilder();
        script.append("var obj = JSON.parse('"+sb+"');");
        script.append("var total_pages = obj.total_pages;");
        script.append("var total_goal = obj.data.reduce(function(result,item){return result + parseInt(item."+team+"goals)},0);");
        try {
            engine.eval(script.toString());
        } catch (ScriptException ex){
            ex.printStackTrace();
            throw new RuntimeException("Invalid");
        }
        int totalPages = (int) engine.get("total_pages");
        score += (int) Double.parseDouble(engine.get("total_goal").toString());
        return (page < totalPages)?getTotalGoals(request,team,page+1,score):score;
    }

    private static String getWinnerTeamName(String winnerURL) throws IOException {
        URL url = new URL(winnerURL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setRequestProperty("Content-Type","application/json");
        int status = httpURLConnection.getResponseCode();
        InputStream is = (status <200 || status>299) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String readLine;
        StringBuilder sb = new StringBuilder();
        while((readLine = br.readLine())!=null){
            sb.append(readLine);
        }
        br.close();
        is.close();
        httpURLConnection.disconnect();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        StringBuilder script = new StringBuilder();
        script.append("var obj = JSON.parse('"+sb+"');");
        script.append("var winner = obj.data[0].winner");
        try {
            engine.eval(script.toString());
        } catch (ScriptException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid");
        }
        return engine.get("winner").toString();
    }
}
