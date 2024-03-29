package mapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import Connection.Connect;

public class Table {
    int idtable;
    String nom;

    public int getIdtable() {
        return idtable;
    }

    public void setIdtable(int idtable) {
        this.idtable = idtable;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Table(int idtable, String nom) {
        this.idtable = idtable;
        this.nom = nom;
    }

    public void insert() throws Exception {
        Connect myConnect=new Connect();
        Connection connect=null;
        PreparedStatement ppstate=null;

        try {
            connect=myConnect.getConnectionPostgresql();
            String sql="INSERT INTO restotable VALUES(default,?) ";
            ppstate= connect.prepareStatement(sql);
            ppstate.setString(1,this.getNom());
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

    public static Vector<Table> getAll()throws Exception{



        Connect myConnect=new Connect();
        Connection connect=null;
        PreparedStatement ppstate=null;
        ResultSet result=null;

        try {
            connect=myConnect.getConnectionPostgresql();
            String sql="SELECT * FROM restotable ";
            ppstate= connect.prepareStatement(sql);
            result= ppstate.executeQuery();
            Vector<Table> val=new Vector<Table>();

            while (result.next()) {
                Table t = new Table(result.getInt("idtable"),result.getString("nom"));
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
            String sql="DELETE FROM restotable WHERE idtable=?";
            ppstate= connect.prepareStatement(sql);
            ppstate.setInt(1,this.getIdtable());
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
            String sql="UPDATE restotable SET NOM=? WHERE idtable=?";
            ppstate= connect.prepareStatement(sql);
            ppstate.setString(1,this.getNom());
            ppstate.setInt(2,this.getIdtable());
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
            String sql="SELECT * FROM restotable WHERE idtable = ?";
            ppstate= connect.prepareStatement(sql);
            ppstate.setInt(1,this.getIdtable());
            result= ppstate.executeQuery();
            Employer t=null;
            while (result.next()) {
                this.setNom(result.getString("nom"));
            }

        } catch (Exception e) {
            throw e;
        }finally{
            ppstate.close();
            connect.close();

        }
    }
}


