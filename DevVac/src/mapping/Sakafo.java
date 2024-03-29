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

    public Sakafo() {

    }

    public Sakafo(int id) {
        this.setIdSakafo(id);
    }

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

    public void insert() throws Exception {

        Connect myConnect=new Connect();
        Connection connect=null;
        PreparedStatement ppstate=null;

        try {
            connect=myConnect.getConnectionPostgresql();
            String sql="INSERT INTO sakafo VALUES(default,?,?) ";
            ppstate= connect.prepareStatement(sql);
            ppstate.setString(1,this.getNom());
            ppstate.setDouble(2,this.getPrix());
            ppstate.executeUpdate();
            connect.commit();
        } catch (Exception e) {
            connect.rollback();
            throw e;
        }finally{
            ppstate.close();
            connect.close();

        }
    }

    public static Vector<Sakafo> getAll()throws Exception{


        Connect myConnect=new Connect();
        Connection connect=null;
        PreparedStatement ppstate=null;
        ResultSet result=null;

        try {
            connect=myConnect.getConnectionPostgresql();

            String sql="SELECT * FROM sakafo ";
            ppstate= connect.prepareStatement(sql);

            result= ppstate.executeQuery();
            Vector<Sakafo> val=new Vector<Sakafo>();

            while (result.next()) {
                Sakafo t = new Sakafo(result.getInt("idsakafo"),result.getString("nomSakafo"),result.getDouble("Prix"));
                val.add(t);
            }

            return val;
        } catch (Exception e) {
            throw e;
        }finally{
            ppstate.close();
            connect.close();

        }

    }

    public void del() throws Exception {

        Connect myConnect=new Connect();
        Connection connect=null;
        PreparedStatement ppstate=null;

        try {
            connect=myConnect.getConnectionPostgresql();
            String sql="DELETE FROM sakafo WHERE idsakafo=?";
            ppstate= connect.prepareStatement(sql);
            ppstate.setInt(1,this.getIdSakafo());
            ppstate.executeUpdate();
            connect.commit();
        } catch (Exception e) {
            connect.rollback();
            throw e;
        }finally{
            ppstate.close();
            connect.close();
        }
    }

    public void update() throws Exception {




        Connect myConnect=new Connect();
        Connection connect=null;
        PreparedStatement ppstate=null;

        try {
            connect=myConnect.getConnectionPostgresql();
            String sql="UPDATE sakafo SET nomsakafo=?,prix=? WHERE idsakafo=?";
            ppstate= connect.prepareStatement(sql);
            ppstate.setString(1,this.getNom());
            ppstate.setDouble(2,this.getPrix());
            ppstate.setInt(3,this.getIdSakafo());
            ppstate.executeUpdate();
            connect.commit();
        } catch (Exception e) {
            connect.rollback();
            throw e;
        }finally{
            ppstate.close();
            connect.close();

        }
    }

    public void getById() throws Exception {

        Connect myConnect=new Connect();
        Connection connect=null;
        PreparedStatement ppstate=null;
        ResultSet result=null;

        try {
            connect=myConnect.getConnectionPostgresql();
            String sql="SELECT * FROM sakafo WHERE idsakafo = ?";
            ppstate= connect.prepareStatement(sql);
            ppstate.setInt(1,this.getIdSakafo());
            result= ppstate.executeQuery();
            Employer t=null;
            while (result.next()) {
                this.setNom(result.getString("nomSakafo"));
                this.setPrix(result.getDouble("prix"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            ppstate.close();
            connect.close();

        }
    }

    public Vector<Sakafo> search(String nom,double prixmin,double prixmax)throws Exception{
        Connect myConnect=new Connect();
        Connection connect=null;
        PreparedStatement ppstate=null;
        ResultSet result=null;

        try {
            connect=myConnect.getConnectionPostgresql();

            String sql="SELECT * FROM sakafo WHERE nomsakafo LIKE ? AND prix>? AND prix<?";
            ppstate= connect.prepareStatement(sql);
            ppstate.setString(1,"%"+nom+"%");
            ppstate.setDouble(2,prixmin);
            ppstate.setDouble(3,prixmax);
            result= ppstate.executeQuery();
            Vector<Sakafo> val=new Vector<Sakafo>();

            while (result.next()) {
                Sakafo t = new Sakafo(result.getInt("idsakafo"),result.getString("nomSakafo"),result.getDouble("Prix"));
                val.add(t);
            }

            return val;
        } catch (Exception e) {
            throw e;
        }finally{
            ppstate.close();
            connect.close();

        }
    }
}
