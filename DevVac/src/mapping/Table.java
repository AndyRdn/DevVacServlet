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

    public void insert(Connection connect) throws Exception {
        boolean connexionOuvert=false;
        if (connect == null) {
            connexionOuvert=true;
            Connect myConnect=new Connect();
            connect=myConnect.getConnectionPostgresql();
        }

        String sql="INSERT INTO ? VALUES(NULL,?) ";
        PreparedStatement ppstate= connect.prepareStatement(sql);
        ppstate.setString(1,"restotable");
        ppstate.setString(2,this.getNom());

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

    public static Vector<Table> getAll(Connection connect)throws Exception{
        boolean connexionOuvert=false;
        if (connect == null) {
            connexionOuvert=true;
            Connect myConnect=new Connect();
            connect=myConnect.getConnectionPostgresql();
        }

        String sql="SELECT * FROM ? ";
        PreparedStatement ppstate= connect.prepareStatement(sql);
        ppstate.setString(1,"restotable");

        try {

            ResultSet result= ppstate.executeQuery(sql);
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
        ppstate.setString(1,"restotable");
        ppstate.setInt(2,this.getIdtable());

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

        String sql="UPDATE ? SET NOM=? WHERE idtable=?";
        PreparedStatement ppstate= connect.prepareStatement(sql);
        ppstate.setString(1,"restotable");
        ppstate.setString(2,this.getNom());
        ppstate.setInt(3,this.getIdtable());

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


