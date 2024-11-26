package com.btcag.bootcamp;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Scanner;

public class ConnectorDB {
    private static final String URL = "jdbc:sqlite:C:/Users/ERPETERS/OneDrive - BTC AG/Desktop/sqlite-tools-win-x64-3470000/Bootcamp2024.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Verbindung zur SQLite-Datenbank hergestellt.");
        } catch (SQLException e) {
            System.out.println("Verbindung zur SQLite-Datenbank fehlgeschlagen.");
            e.printStackTrace();
        }
        return conn;
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS User (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "username TEXT NOT NULL, " + "password TEXT NOT NULL);";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabelle 'User' wurde erfolgreich erstellt.");
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen der Tabelle 'User'.");
            e.printStackTrace();
        }
    }

    public static void insertUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        String sql = "INSERT INTO User(username, password) VALUES(?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("User erfolgreich eingefügt.");
        } catch (SQLException e) {
            System.out.println("Fehler beim Einfügen des Users.");
            e.printStackTrace();
        }
    }

    public static void checkUserExists() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        String sql = "SELECT Username, Password FROM user WHERE Username = ? AND Password = ?";
        try (Connection conn = connect();){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.isBeforeFirst()){
                System.out.println("User exists.");
            }
            else {
                System.out.println("Username or password is wrong.");
            }
        } catch (SQLException e) {
            System.out.println("Ein Fehler ist aufgetreten.");
            e.printStackTrace();
        }
    }

    public static void selectAllUsers() {
        String sql = "SELECT * FROM User";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + "\t" +
                        "Username: " + rs.getString("username") + "\t" +
                        "Password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen der Users.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        connect();
        //createTable();
        //insertUser();
        selectAllUsers();
        checkUserExists();
    }
}