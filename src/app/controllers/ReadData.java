package app.controllers;

import app.models.Fruit;
import app.utils.Constants;
import app.utils.DbConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadData {

    public List<Fruit> selectALl() {

        List<Fruit> fruitList = new ArrayList<>();
        String sql = "SELECT name, description FROM " + Constants.TABLE_NAME;

        try (Statement stmt = DbConn.connect().createStatement()) {
            try (ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()) {
                    fruitList.add(new Fruit(
                            rs.getString("name"),
                            rs.getString("description")
                            )
                    );
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return Collections.emptyList();
        }
        return fruitList;
    }
}