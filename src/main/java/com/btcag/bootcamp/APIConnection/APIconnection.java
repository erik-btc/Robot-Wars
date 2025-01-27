package com.btcag.bootcamp.APIConnection;
//import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import com.btcag.bootcamp.views.AskForRobotNameView;
import com.btcag.bootcamp.views.BotSkillpointsView;
import com.btcag.bootcamp.views.ShowOptionsView;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class APIconnection {
    protected static String baseURL = "https://eumth8x973.execute-api.eu-central-1.amazonaws.com/prod/";
    protected static String getBotURL = "api/robots";
    protected static String getMapURL = "api/maps";
    protected static String createRobotURL = "api/robots/robot";
    protected static String createGameURL = "api/games/game";
    protected static String joinGameURL = "api/games/game/";
    protected static String movingPlayerURL = "api/games/game/";
    protected static String getAllMovesURL = "api/games/game/";
    protected static String mapId = "d2d0b803-955d-4367-8fdd-c8c3f94fecbb";
    protected static String gameId = "";
    protected static String robot1Id = "";
    protected static String robot2Id = "";
    protected static String player1Id = "";
    protected static String player2Id = "";
    protected static String mapIndex = "";
    public static Bot bot = new Bot("", 1, 1, 1, 1);

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int userInput;
        do {
            ShowOptionsView.display();
            System.out.println("Input: ");
            userInput = scanner.nextInt();
            if (userInput == 1) {
                getAllBots();
            } else if (userInput == 2) {
                getSpecificBot();
            } else if (userInput == 3) {
                getAllMaps();
            } else if(userInput == 4) {
                getSpecificMap();
            }
            else if(userInput == 5) {
                bot.setName(AskForRobotNameView.display());
                BotSkillpointsView.allocationOfSkillPoints(bot);
                System.out.println(BotSkillpointsView.showPlayerStats(bot));
                createBot(bot);
            }
            else if(userInput == 6) {
                createGame();
            }
            else if(userInput == 7) {
                joinGame(gameId);
            }
            else if (userInput == 8) {
                getSpecificGame();
            }
            else if (userInput == 9) {
                getAllGames();
            }
            else if (userInput == 10) {
                makeAMove();
            }
            else if (userInput == 11) {
                getMovementRateFromRobot(robot1Id);
            }
            else if (userInput == 0){
                System.out.println("exiting the program");
            }
            else {
                System.out.println("Invalid user input");
            }
        }while(userInput != 0);
    }

    public static void getSpecificGame() throws IOException {
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

    public static void getAllGames() throws IOException {
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

    public static void getAllBots() throws IOException {
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

    public static void getSpecificBot() throws IOException {
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

    public static void getAllMaps()throws IOException {
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

    public static void getSpecificMap() throws IOException {
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

    public static String createBot(Bot bot) throws IOException {
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
            robot1Id = responseObject.getString("id");
            System.out.println("robotId: " + robot1Id);
            return robot1Id;
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
        return "error";
    }

    public static String createGame() throws IOException {
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
            return gameId;
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
        return "error";
    }

    public static String joinGame(String gameId) throws IOException{
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
        jsonObject.put("robotId", robot1Id);

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
            player1Id = responseObject.getString("playerId");
            System.out.println("PlayerId: " + player1Id);
            return player1Id;
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
        return "error";
    }

    public static void makeAMove()throws IOException{
        URL url = new URL(baseURL + movingPlayerURL + gameId + "/move/player/" + player1Id);
        System.out.println(url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("playerId", player1Id);
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


    private static void getAllMovesAfter() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter MoveId: ");
        String moveId = scanner.nextLine();
        URL url = new URL(baseURL + getAllMovesURL + gameId + "/move/" + moveId + "/after");
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

    public static void getMapIndex() throws IOException {
        URL url = new URL(baseURL + "api/games/game/" + gameId);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        String contentString = content.toString();
        Pattern pattern = Pattern.compile("\"mapIndex\":\\s*(\\d+)");
        Matcher matcher = pattern.matcher(contentString);
        if (matcher.find()) {
            String mapIndex = matcher.group(1);
            System.out.println("Index: " + mapIndex);
        } else {
            System.out.println("Index nicht gefunden.");
        }
    }

    public static int getMovementRateFromRobot(String robotId) throws IOException {
        URL url = new URL(baseURL + getBotURL + "/robot/" + robotId);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();

        System.out.println("Response content: " + content);

        JSONObject responseObject = new JSONObject(content.toString());
        int movementRate = responseObject.getInt("movementRate");
        System.out.println("movementRate: " + movementRate);

        return movementRate;
    }

    public static String getGameStatus(String gameId) throws IOException {
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
        connection.disconnect();

        System.out.println("Response content: " + content);

        JSONObject responseObject = new JSONObject(content.toString());
        String gameStatus = responseObject.getString("status");
        System.out.println("Game status: " + gameStatus);

        return gameStatus;
    }

    public static String getPlayer2Id(String gameId, String player1Id) throws IOException {
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
        connection.disconnect();

        System.out.println("Response content: " + content);

        JSONObject responseObject = new JSONObject(content.toString());
        JSONArray players = responseObject.getJSONArray("players");

        String player2Id = null;

        for (int i = 0; i < players.length(); i++) {
            JSONObject player = players.getJSONObject(i);
            String currentPlayerId = player.getString("playerId");
            if (!currentPlayerId.equals(player1Id)) {
                player2Id = currentPlayerId;
                break;
            }
        }

        if (player2Id == null) {
            throw new IOException("No valid player2Id found in the response.");
        }

        System.out.println("Player 2 Id: " + player2Id);
        return player2Id;
    }

    public static String getRobot2Id(String gameId, String robot1Id) throws IOException {
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
        connection.disconnect();

        System.out.println("Response content: " + content);

        JSONObject responseObject = new JSONObject(content.toString());
        JSONArray playersArray = responseObject.getJSONArray("players");

        String robot2Id = null;

        for (int i = 0; i < playersArray.length(); i++) {
            JSONObject player = playersArray.getJSONObject(i);
            String currentRobotId = player.getString("robotId");
            if (!currentRobotId.equals(robot1Id)) {
                robot2Id = currentRobotId;
                break;
            }
        }

        if (robot2Id == null) {
            throw new IOException("No valid robot2Id found in the response for gameId: " + gameId);
        }

        System.out.println("Robot 2 Id: " + robot2Id);
        return robot2Id;
    }

    public static int[] statsFromPlayer2(String robot2Id) throws IOException {
        URL url = new URL(baseURL + "/api/robots/" + robot2Id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();

        System.out.println("Response content: " + content);

        JSONObject robotObject = new JSONObject(content.toString());

        int health = robotObject.getInt("health");
        int attackDamage = robotObject.getInt("attackDamage");
        int attackRange = robotObject.getInt("attackRange");
        int movementRate = robotObject.getInt("movementRate");

        return new int[] { health, attackDamage, attackRange, movementRate };
    }


}

