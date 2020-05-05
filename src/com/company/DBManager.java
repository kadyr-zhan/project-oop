package com.company;


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/users?useUnicode=true&serverTimezone=UTC", "root", ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUserToDB(User user) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO usersinfo (id, name, login, password, bodytype) " +
                    "VALUES (NULL, ?, ?, ?, ?)"
            );
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, String.valueOf(user.getPassword()));
            statement.setString(4, user.getBodyType());
            int rows = statement.executeUpdate();// Insert, Delete, Update

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String train(User user, String s){
        String bt="";
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT exercise FROM training WHERE bodytype=? and musclegroup=?"
            );

            statement.setString(1, Main.users.get(0).getBodyType());
            statement.setString(2,s);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                bt = resultSet.getString("exercise");
                statement.close();
                resultSet.close();

            }

        }
        catch (Exception et) {
            et.printStackTrace();
        }
        return bt;
    }
    public String nutrition(User user){
        String bt="";
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT nutrition FROM nutrition WHERE bodytype=?"
            );

            statement.setString(1, Main.users.get(0).getBodyType());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                bt = resultSet.getString("nutrition");
                statement.close();
                resultSet.close();

            }

        }
        catch (Exception et) {
            et.printStackTrace();
        }
        return bt;
    }
    public String BodyType(User user){
        String s="";
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT bodytype FROM usersinfo WHERE login=? and password=?"
            );


            statement.setString(1, user.getLogin());

            statement.setString(2, user.getPassword());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                s = resultSet.getString("bodytype");
                statement.close();
                resultSet.close();

            }

        }
        catch (Exception et) {
            et.printStackTrace();
    }
        return s;
    }
    public boolean login(User user) {
        boolean b=true;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usersinfo WHERE login=? and password=?"
            );


            statement.setString(1, user.getLogin());

            statement.setString(2, user.getPassword());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                resultSet.close();

                statement.close();

                b= true;

            } else {
                b= false;


            }
        } catch (Exception et) {
            et.printStackTrace();
        }
     return b;
    }


    public void deleteStudent(Integer id){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM usersinfo WHERE id = ?"
            );
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
