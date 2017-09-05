/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import strategy.ServiceStrategy;
import strategy.StrategyContext;

/**
 *
 * @author Mate
 */
public class VoziloDB {
    private Connection connection;
 
    public VoziloDB() {
        connection = Database.getConnection();
    }
    
    public void addVozilo(Vozilo vozilo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into vozilo(broj_sasije, tip, model, godina, status) values (?, ?, ?, ?, ? )");
            preparedStatement.setInt(1, vozilo.getBroj_sasije());
            preparedStatement.setString(2, vozilo.getTip());
            preparedStatement.setString(3, vozilo.getModel());            
            preparedStatement.setString(4, vozilo.getGodina());
            preparedStatement.setString(5, "lager");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkVozilo(Vozilo vozilo) {
        boolean check;
        check = false;
        try {
            PreparedStatement ps = connection.prepareStatement("select broj_sasije from vozilo where broj_sasije = ?");
            ps.setInt(1, vozilo.getBroj_sasije());
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                check = true;
            } else {
                check = false;
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return check;
    }
 
    public List<Vozilo> getAllVozila() {
        List<Vozilo> vozila = new ArrayList<Vozilo>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from vozilo");
            while (rs.next()) {
                Vozilo vozilo = new Vozilo();
                vozilo.setBroj_sasije(rs.getInt("broj_sasije"));
                vozilo.setTip(rs.getString("tip"));
                vozilo.setModel(rs.getString("model"));
                vozilo.setGodina(rs.getString("godina"));
                vozilo.setStatus(rs.getString("status"));
                vozila.add(vozilo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return vozila;
    }

    public void changeStatus(Vozilo vozilo, String status) {
        StrategyContext cont = new StrategyContext();
        cont.setStrategy(new ServiceStrategy());
        cont.promjeniStatusVozila(vozilo, status);
    }
    
    public List<String> dohvatiStatuse() {
        StrategyContext cont = new StrategyContext();
        cont.setStrategy(new ServiceStrategy());
        return cont.dohvatiListuStatusa();
    }

    public Vozilo getVoziloByBrojSasije(String broj_sasije) {
        Vozilo vozilo = new Vozilo();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from vozilo where broj_sasije=?");
            preparedStatement.setString(1, broj_sasije);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                vozilo.setBroj_sasije(rs.getInt("broj_sasije"));
                vozilo.setTip(rs.getString("tip"));
                vozilo.setModel(rs.getString("model"));
                vozilo.setGodina(rs.getString("godina"));
                vozilo.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vozilo;
    }

    public void editVozilo(Vozilo vozilo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update vozilo set tip=?, model=?, godina=?, status=?"
                    + "where broj_sasije=?");
            preparedStatement.setString(1, vozilo.getTip());
            preparedStatement.setString(2, vozilo.getModel());            
            preparedStatement.setString(3, vozilo.getGodina());
            preparedStatement.setString(4, vozilo.getStatus());
            preparedStatement.setInt(5, vozilo.getBroj_sasije());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void izbrisiVozilo(Integer broj_sasije) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from vozilo where broj_sasije=?");
            preparedStatement.setInt(1, broj_sasije);
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
