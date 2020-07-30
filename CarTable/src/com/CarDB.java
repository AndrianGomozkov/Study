package com;

import java.sql.*;
import java.util.ArrayList;
 
public class CarDB {
 
    private static String url = "jdbc:mysql://127.0.0.1:3306/cars?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "157953";
    
    public static ArrayList<Car> select() {
         
        ArrayList<Car> cars = new ArrayList<Car>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM car");
                while(resultSet.next()){
                      
                    int idcar = resultSet.getInt(1);
                    String model = resultSet.getString(2);
                    String color = resultSet.getString(3);
                    String complect = resultSet.getString(4);
                    Car car = new Car(idcar, model, color, complect);
                    cars.add(car);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return cars;
    }
    public static Car selectOne(int id) {
         
        Car car = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM car WHERE idcar=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
 
                    	int idcar = resultSet.getInt(1);
                        String model = resultSet.getString(2);
                        String color = resultSet.getString(3);
                        String complect = resultSet.getString(4);
                        car = new Car(idcar, model, color, complect);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return car;
    }
    public static int insert(Car car) {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO car (model, color, complect) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setString(1, car.getModel());
                    preparedStatement.setString(2, car.getColor());
                    preparedStatement.setString(3, car.getComplect());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int update(Car car) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE car SET model = ?, color = ?, comlect = ? WHERE idcar = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, car.getModel());
                    preparedStatement.setString(2, car.getColor());
                    preparedStatement.setString(3, car.getComplect());
                    preparedStatement.setInt(4, car.getIdcar());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "DELETE FROM car WHERE idcar = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}