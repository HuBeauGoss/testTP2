/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umons.fpms.ig19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author noffa
 */
public class Prof {
    private String name;
            String firstname;
            String dateNaiss;
            String lieuNaiss;

    public Prof(String name, String firstname, String dateNaiss, String lieuNaiss) {
        this.name = name;
        this.firstname = firstname;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
    }

    Prof() {
        name = firstname = dateNaiss = lieuNaiss = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getLieuNaiss() {
        return lieuNaiss;
    }

    public void setLieuNaiss(String lieuNaiss) {
        this.lieuNaiss = lieuNaiss;
    }
    
    public void add() {
        Connection conn = DataAccess.connect();
        try {
            PreparedStatement prstm =  conn.prepareStatement("INSERT INTO prof(nomprof, prenomprof, datenaiss, lieunaiss) values(?,?,?,?);");
            prstm.setString(1, this.getName());
            prstm.setString(2, this.getFirstname());
            prstm.setString(3, this.getDateNaiss());
            prstm.setString(4, this.getLieuNaiss());
            if(prstm.execute()){
                System.out.println("Insertion DONE !!!");
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void update(int id) {
        Connection conn = DataAccess.connect();
        PreparedStatement prstm;
        try {
            prstm = conn.prepareStatement("UPDATE prof SET nomprof = ?, prenomprof = ?, datenaiss = ?, lieunaiss = ? WHERE idprof = ?;");
            prstm.setString(1, this.getName());
            prstm.setString(2, this.getFirstname());
            prstm.setString(3, this.getDateNaiss());
            prstm.setString(4, this.getLieuNaiss());
            prstm.setInt(5, id);
            prstm.executeUpdate();
            System.out.println("Update DONE !!!");
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void delete(int id) {
        Connection conn = DataAccess.connect();
        PreparedStatement prstm;
        try {
            prstm = conn.prepareStatement("DELETE FROM prof WHERE idprof = ?;");
            prstm.setInt(1, id);
            if(prstm.execute()){
                System.out.println("Delete DONE !!!");
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static ArrayList<Prof> select() {
        Connection conn = DataAccess.connect();
        Statement stm;
        String sql = "SELECT * FROM prof;";
        ArrayList<Prof> result = new ArrayList<Prof>();
        try {
            stm = conn.createStatement();
            try (ResultSet rs = stm.executeQuery(sql)) {
                while(rs.next()) {
                    Prof prof = new Prof(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                    result.add(prof);
                }
                stm.close();
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }
    
    public static Prof select(int id) {
        Connection conn = DataAccess.connect();
        PreparedStatement prstm;
        String sql = "SELECT * FROM prof WHERE idprof = ?;";
        Prof result = null;
        try {
            prstm = conn.prepareStatement(sql);
            prstm.setInt(1, id);
            try (ResultSet rs = prstm.executeQuery()) {
                if(rs.next()){
                    result = new Prof(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                }
                prstm.close();
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }
    
    public static ArrayList<Prof> select(String name) {
        Connection conn = DataAccess.connect();
        PreparedStatement prstm;
        ArrayList<Prof> result = new ArrayList<Prof>();
        try {
            prstm = conn.prepareStatement("SELECT * FROM prof WHERE nomprof = ?;");
            prstm.setString(1, name);
            try (ResultSet rs = prstm.executeQuery()) {
                while(rs.next()){
                    Prof prof = new Prof(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                    result.add(prof);
                }
                prstm.close();
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }
    
    public ArrayList<Cours> getListCours() {
        Connection conn = DataAccess.connect();
        PreparedStatement prstm;
        ArrayList<Cours> result = new ArrayList<Cours>();
        try {
            prstm = conn.prepareStatement("SELECT c.* FROM cours c INNER JOIN prof p ON c.idprof = p.idprof AND p.nomprof = ? AND p.prenomprof = ?;");
            prstm.setString(1, this.getName());
            prstm.setString(2, this.getFirstname());
            try (ResultSet rs = prstm.executeQuery()) {
                while(rs.next()) {
                    Cours cours = new Cours(rs.getString(2), rs.getString(3), rs.getInt(4));
                    result.add(cours);
                }
                prstm.close();
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }
    
    @Override
    public String toString() {
        return "Prof{" + "name=" + name + ", firstname=" + firstname + ", dateNaiss=" + dateNaiss + ", lieuNaiss=" + lieuNaiss + '}';
    }
    
    
}
