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
public class Cours {
    private String intitule;
        String duree;
        int prof;

    public Cours(String intitule, String duree, int prof) {
        this.intitule = intitule;
        this.duree = duree;
        this.prof = prof;
    }

    public Cours(String intitule, String duree) {
        this.intitule = intitule;
        this.duree = duree;
        this.prof = 1;
    }

    public Cours() {
        intitule = duree = null;
    }
    
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int getProf() {
        return prof;
    }

    public void setProf(int prof) {
        this.prof = prof;
    }
    
    public void add() {
        Connection conn = DataAccess.connect();
        try {
            PreparedStatement prstm =  conn.prepareStatement("INSERT INTO cours(intitule, duree, idprof) values(?,?,?);");
            prstm.setString(1, this.getIntitule());
            prstm.setString(2, this.getDuree());
            prstm.setInt(3, this.getProf());
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
            prstm = conn.prepareStatement("UPDATE cours SET intitule = ?, duree = ? WHERE idcours = ?;");
            prstm.setString(1, this.getIntitule());
            prstm.setString(2, this.getDuree());
            prstm.setInt(3, id);
            prstm.executeUpdate();
            System.out.println("Updated DONE !!!");
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void delete(int id) {
        Connection conn = DataAccess.connect();
        PreparedStatement prstm;
        try {
            prstm = conn.prepareStatement("DELETE FROM cours WHERE idcours = ?;");
            prstm.setInt(1, id);
            if(prstm.execute()){
                System.out.println("Deletion DONE !!!");
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static ArrayList<Cours> select() {
        Connection conn = DataAccess.connect();
        Statement prstm;
        ArrayList<Cours> result = new ArrayList<Cours>();
        try {
            prstm = conn.createStatement();
            ResultSet rs = prstm.executeQuery("SELECT * FROM cours;");
            while(rs.next()){
                Cours cours = new Cours(rs.getString(2), rs.getString(3), rs.getInt(4));
                result.add(cours);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }
    
    public static Cours select(int id) {
        Connection conn = DataAccess.connect();
        PreparedStatement prstm;
        Cours cours = null;
        try {
            prstm = conn.prepareStatement("SELECT * FROM cours WHERE idcours = ?;");
            prstm.setInt(1, id);
            try (ResultSet rs = prstm.executeQuery()) {
                if(rs.next()) {
                    cours = new Cours(rs.getString(2), rs.getString(3));
                }
                prstm.close();
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return cours;
    }
    
    public static Cours select(String intitule) {
        Connection conn = DataAccess.connect();
        PreparedStatement prstm;
        Cours cours = null;
        try {
            prstm = conn.prepareStatement("SELECT * FROM cours WHERE intitule = ?;");
            prstm.setString(1, intitule);
            try (ResultSet rs = prstm.executeQuery()) {
                if(rs.next()){
                    cours = new Cours(rs.getNString(2), rs.getString(3), rs.getInt(4));
                }
                prstm.close();
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return cours;
    }

    @Override
    public String toString() {
        return "Cours{" + "intitule=" + intitule + ", duree=" + duree + ", prof=" + prof + '}';
    }
    
    
}
