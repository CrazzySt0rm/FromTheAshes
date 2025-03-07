package org.example.dbreader;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DbReader {

    public static final String MAGE_SELECT_QUERY = "SELECT name, power FROM mage ORDER BY power DESC LIMIT 1";
    public static final String ARCHER_SELECT_QUERY = "SELECT name, power FROM archer ORDER BY power DESC LIMIT 1";

    // Запросы для получения последней записи
    public static final String LAST_MAGE_SELECT_QUERY = "SELECT name, power FROM mage ORDER BY id DESC LIMIT 1";
    public static final String LAST_ARCHER_SELECT_QUERY = "SELECT name, power FROM archer ORDER BY id DESC LIMIT 1";

//    private static final String SELECT_QUERY = "(SELECT name, power FROM mage) UNION (SELECT name, power from archer) ORDER BY power DESC LIMIT 1";
    //ORDER BY id DESC LIMIT 1
    private final String url;
    private final String username;
    private final String password;

    public DbReader() {
        this.url = System.getenv("MY_DATASOURCE_URL");     // Получаем URL из переменной среды
        this.username = System.getenv("MY_DB_USERNAME");   // Получаем имя пользователя из переменной среды
        this.password = System.getenv("MY_DB_PASSWORD");   // Получаем пароль из переменной среды
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public Map<String, Object> getCharacterData(String query) {
        Map<String, Object> result = new HashMap<>();
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                result.put("name", resultSet.getString("name"));
                result.put("power", resultSet.getInt("power"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
