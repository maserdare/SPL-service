/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mate
 */
public class Database {
    public static Connection getConnection() {
          try  {
              Class.forName("com.mysql.jdbc.Driver");
              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spl_retail",
                      "root","kiwi");
              return conn;
          }
          catch(Exception ex) {
              System.out.println("Error occured " + ex.getMessage());
              return null;
          }
      }
 
       public static void close(Connection conn) {
          try  {
              conn.close();
          }
          catch(Exception ex) {
          }
      }
}
