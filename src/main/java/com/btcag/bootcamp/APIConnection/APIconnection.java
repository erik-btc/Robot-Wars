package com.btcag.bootcamp.APIConnection;
import com.btcag.bootcamp.models.Robot;
//import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIconnection {
    protected static String baseURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/";
    protected static String getBotURL = "api/robots";
    protected static String getMapURL = "/api/maps";
    protected static String createRobotURL = "api/robots/robot";
    protected static String createGameURL = "/api/games/game";
    public static void main(String[] args) throws IOException {
        //Bot bot = new Bot("jannik", 5, 2,5,1);
        //createBot(bot);
        createGame();
    }

    private static void getAllBots() throws IOException {
        URL url = new URL(baseURL + getBotURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        //Schreiben in Content, hat nix mit HTTP zu tun
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        //
        System.out.println(content);
        connection.disconnect();
    }

    private static void getSpecificBot() throws IOException {
        System.out.println("UserID: ");
        Scanner scanner = new Scanner(System.in);
        String userID = scanner.nextLine();
        URL url = new URL(baseURL + getBotURL + "/robot/" + userID);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        //Schreiben in Content, hat nix mit HTTP zu tun
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        //
        System.out.println(content);
        connection.disconnect();
    }
    private static void getAllMaps()throws IOException {
        URL url = new URL(baseURL + getMapURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        //Schreiben in Content, hat nix mit HTTP zu tun
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        //
        System.out.println(content);
        connection.disconnect();
    }

    private static void createBot(Bot bot) throws IOException {
        URL url = new URL(baseURL + createRobotURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");

        // JSON-Daten des Roboters erstellen
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", bot.name);
        jsonObject.put("health", bot.health);
        jsonObject.put("attackDamage", bot.attackDamage);
        jsonObject.put("attackRange", bot.attackRange);
        jsonObject.put("movementRate", bot.movementRate);

        String jsonInputString = jsonObject.toString();

        // JSON-Daten an die Verbindung senden
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        System.out.println(jsonInputString);
        // Antwort der API lesen
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }

    private static void createGame() throws IOException {
        String mapId = "d2d0b803-955d-4367-8fdd-c8c3f94fecbb";
        URL url = new URL(baseURL + createGameURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");

        // JSON-Daten des Roboters erstellen
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mapId", mapId);


        String jsonInputString = jsonObject.toString();

        // JSON-Daten an die Verbindung senden
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        System.out.println(jsonInputString);
        // Antwort der API lesen
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }
}

class Bot{
    String name;
    int health;
    int attackDamage;
    int attackRange;
    int movementRate;

    public Bot(String name, int health, int attackDamage, int attackRange, int movementRate) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackRange = attackRange;
        this.movementRate = movementRate;
    }
}