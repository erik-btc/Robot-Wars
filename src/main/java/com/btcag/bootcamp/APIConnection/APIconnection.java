package com.btcag.bootcamp.APIConnection;
import com.btcag.bootcamp.models.Robot;
//import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIconnection {
    protected static String baseURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/";
    protected static String getBotURL = "api/robots";
    protected static String getMapURL = "api/maps";
    protected static String createRobotURL = "api/robots/robot";
    protected static String createGameURL = "/api/games/game";
    protected static String joinGameURL = "api/games/game/";
    protected static String movingPlayerURL = "api/games/game/";
    protected static String mapId = "d2d0b803-955d-4367-8fdd-c8c3f94fecbb";
    protected static String gameId = "";
    protected static String robotId = "";
    protected static String playerId = "";

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        do {
            System.out.println("""
                    1. Show all robots
                    2. Get a specific robot
                    3. Get all maps
                    4. Get a specific map
                    5. Create a robot
                    6. Create a game
                    7. Join a game
                    8. Get a specific game
                    9. Get all games
                    10. Make a move
                    0. Exit
                    """);
            System.out.println("Input: ");
            userInput = scanner.nextInt();
            if (userInput == 1) {
                GetAllBots();
            } else if (userInput == 2) {
                GetSpecificBot();
            } else if (userInput == 3) {
                GetAllMaps();
            } else if(userInput == 4) {
                GetSpecificMap();
            }
            else if(userInput == 5) {
                System.out.println("name:");
                String name = "yannik";//scanner.nextLine();
                System.out.println("health: ");
                int health = scanner.nextInt();
                System.out.println("attackDamage: ");
                int attackDamage = scanner.nextInt();
                System.out.println("attackRange: ");
                int attackRange = scanner.nextInt();
                System.out.println("movementRate: ");
                int movementRate = scanner.nextInt();
                Bot bot = new Bot(name, health, attackDamage, attackRange, movementRate);
                CreateBot(bot);
            }
            else if(userInput == 6) {
                CreateGame();
            }
            else if(userInput == 7) {
                JoinGame();
            }
            else if (userInput == 8) {
                GetSpecificGame();
            }
            else if (userInput == 9) {
                GetAllGames();
            }
            else if (userInput == 10) {
                MakeAMove();
            }
            else if (userInput == 0){
                System.out.println("exiting the program");
            }
            else {
                System.out.println("Invalid user input");
            }
        }while(userInput != 0);
    }

    private static void GetSpecificGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("GameId: ");
        String gameId = scanner.nextLine();
        URL url = new URL(baseURL + "/api/games/game/" + gameId);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println(content);
        connection.disconnect();
    }

    private static void GetAllGames() throws IOException {
        URL url = new URL(baseURL + "/api/games");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println(content);
        connection.disconnect();
    }

    private static void GetAllBots() throws IOException {
        URL url = new URL(baseURL + getBotURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println(content);
        connection.disconnect();
    }

    private static void GetSpecificBot() throws IOException {
        System.out.println("UserID: ");
        Scanner scanner = new Scanner(System.in);
        String userID = scanner.nextLine();
        URL url = new URL(baseURL + getBotURL + "/robot/" + userID);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println(content);
        connection.disconnect();
    }

    private static void GetAllMaps()throws IOException {
        URL url = new URL(baseURL + getMapURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println(content);
        connection.disconnect();
    }

    private static void GetSpecificMap() throws IOException {
        System.out.println("MapID: ");
        Scanner scanner = new Scanner(System.in);
        String mapID = scanner.nextLine();
        URL url = new URL(baseURL + getMapURL + "/map/" + mapID);
        System.out.println(url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println(content);
        connection.disconnect();
    }

    private static void CreateBot(Bot bot) throws IOException {
        URL url = new URL(baseURL + createRobotURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", bot.name);
        jsonObject.put("health", bot.health);
        jsonObject.put("attackDamage", bot.attackDamage);
        jsonObject.put("attackRange", bot.attackRange);
        jsonObject.put("movementRate", bot.movementRate);

        String jsonInputString = jsonObject.toString();

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        System.out.println(jsonInputString);

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            JSONObject responseObject = new JSONObject(response.toString());
            robotId = responseObject.getString("id");
            System.out.println("robotId: " + robotId);
        } catch (IOException e) {
            try (BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(connection.getErrorStream(), "utf-8"))) {
                StringBuilder errorResponse = new StringBuilder();
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    errorResponse.append(errorLine.trim());
                }
                System.err.println("Error Response Body: " + errorResponse.toString());
            }
        }
    }

    private static void CreateGame() throws IOException {
        URL url = new URL(baseURL + createGameURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mapId", mapId);

        String jsonInputString = jsonObject.toString();

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        System.out.println(jsonInputString);

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            JSONObject responseObject = new JSONObject(response.toString());
            gameId = responseObject.getString("id");
            System.out.println("gameId: " + gameId);
        } catch (IOException e) {
            try (BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(connection.getErrorStream(), "utf-8"))) {
                StringBuilder errorResponse = new StringBuilder();
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    errorResponse.append(errorLine.trim());
                }
                System.err.println("Error Response Body: " + errorResponse.toString());
            }
        }
    }

    public static void JoinGame() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter gameId: ");
        String gameId = scanner.nextLine();
        URL url = new URL(baseURL + joinGameURL + gameId + "/join");
        System.out.println(url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotId", robotId);

        String jsonInputString = jsonObject.toString();

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        System.out.println(jsonInputString);
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            JSONObject responseObject = new JSONObject(response.toString());
            playerId = responseObject.getString("playerId");
            System.out.println("PlayerId: " + playerId);
        } catch (IOException e) {
            try (BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(connection.getErrorStream(), StandardCharsets.UTF_8))) {
                StringBuilder errorResponse = new StringBuilder();
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    errorResponse.append(errorLine.trim());
                }
                System.err.println("Error Response Body: " + errorResponse.toString());
            }
        }
    }

    public static void MakeAMove()throws IOException{
        URL url = new URL(baseURL + movingPlayerURL + gameId + "/move/player/" + playerId);
        System.out.println(url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("playerId", playerId);
        jsonObject.put("movementType", "ATTACK");
        jsonObject.put("mapIndex", 44);
        jsonObject.put("align", "W");

        String jsonInputString = jsonObject.toString();

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        System.out.println(jsonInputString);
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