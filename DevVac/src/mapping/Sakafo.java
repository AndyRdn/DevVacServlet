package mapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import Connection.Connect;


public class Sakafo {
    int idSakafo;
    String nom;
    double prix;

    public int getIdSakafo() {
        return idSakafo;
    }

    public void setIdSakafo(int idSakafo) {
        this.idSakafo = idSakafo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Sakafo(int idSakafo, String nom, double prix) {
        this.idSakafo = idSakafo;
        this.nom = nom;
        this.prix = prix;
    }

    public void insert(Connection connect) throws Exception {
        boolean connexionOuvert=false;
        if (connect == null) {
            connexionOuvert=true;
            Connect myConnect=new Connect();
            connect=myConnect.getConnectionPostgresql();
        }

        String sql="INSERT INTO ? VALUES(NULL,?,?) ";
        PreparedStatement ppstate= connect.prepareStatement(sql);
        ppstate.setString(1,"sakafo");
        ppstate.setString(2,this.getNom());
        ppstate.setDouble(2,this.getPrix());

        try {

            ppstate.executeUpdate(sql);
        } catch (Exception e) {
            throw e;
        }finally{
            ppstate.close();
            if (connexionOuvert) {
                connect.close();
            }
        }
    }

    public static Vector<Sakafo> getAll(Connection connect)throws Exception{
        boolean connexionOuvert=false;
        if (connect == null) {
            connexionOuvert=true;
            Connect myConnect=new Connect();
            connect=myConnect.getConnectionPostgresql();
        }

        String sql="SELECT * FROM ? ";
        PreparedStatement ppstate= connect.prepareStatement(sql);
        ppstate.setString(1,"sakafo");

        try {

            ResultSet result= ppstate.executeQuery(sql);
            Vector<Sakafo> val=new Vector<Sakafo>();

            while (result.next()) {
                Sakafo t = new Sakafo(result.getInt("idsakafo"),result.getString("nom"),result.getDouble("Prix"));
                val.add(t);
            }

            return val;
        } catch (Exception e) {
            throw e;
        }finally{
            ppstate.close();
            if (connexionOuvert) {
                connect.close();
            }
        }

    }

    public void del(Connection connect) throws Exception {
        boolean connexionOuvert=false;
        if (connect == null) {
            connexionOuvert=true;
            Connect myConnect=new Connect();
            connect=myConnect.getConnectionPostgresql();
        }

        String sql="DELETE FROM ? WHERE idtable=?";
        PreparedStatement ppstate= connect.prepareStatement(sql);
        ppstate.setString(1,"Sakafo");
        ppstate.setInt(2,this.getIdSakafo());


        try {

            ppstate.executeUpdate(sql);
        } catch (Exception e) {
            throw e;
        }finally{
            ppstate.close();
            if (connexionOuvert) {
                connect.close();
            }
        }
    }

    public void update(Connection connect) throws Exception {
        boolean connexionOuvert=false;
        if (connect == null) {
            connexionOuvert=true;
            Connect myConnect=new Connect();
            connect=myConnect.getConnectionPostgresql();
        }

        String sql="UPDATE ? SET nom=?,prix=? WHERE idtable=?";
        PreparedStatement ppstate= connect.prepareStatement(sql);
        ppstate.setString(1,"Sakafo");
        ppstate.setString(2,this.getNom());
        ppstate.setDouble(2,this.getPrix());
        ppstate.setInt(3,this.getIdSakafo());

        try {

            ppstate.executeUpdate(sql);
        } catch (Exception e) {
            throw e;
        }finally{
            ppstate.close();
            if (connexionOuvert) {
                connect.close();
            }
        }
    }
}
