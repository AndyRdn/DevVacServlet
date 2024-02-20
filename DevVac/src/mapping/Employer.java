package mapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import Connection.Connect;

public class Employer {
    int idEmployer;
    String nom;
    int age;

    public int getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(int idEmployer) {
        this.idEmployer = idEmployer;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employer(int idEmployer, String nom, int age) {
        this.idEmployer = idEmployer;
        this.nom = nom;
        this.age = age;
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
        ppstate.setString(1,"employer");
        ppstate.setString(2,this.getNom());
        ppstate.setDouble(2,this.getAge());

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

    public static Vector<Employer> getAll(Connection connect)throws Exception{
        boolean connexionOuvert=false;
        if (connect == null) {
            connexionOuvert=true;
            Connect myConnect=new Connect();
            connect=myConnect.getConnectionPostgresql();
        }

        String sql="SELECT * FROM ? ";
        PreparedStatement ppstate= connect.prepareStatement(sql);
        ppstate.setString(1,"employer");

        try {

            ResultSet result= ppstate.executeQuery(sql);
            Vector<Employer> val=new Vector<Employer>();

            while (result.next()) {
                Employer t = new Employer(result.getInt("idsakafo"),result.getString("nom"),result.getDouble("Prix"));
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

        String sql="DELETE FROM ? WHERE idemployer=?";
        PreparedStatement ppstate= connect.prepareStatement(sql);
        ppstate.setString(1,"Employer");
        ppstate.setInt(2,this.getIdEmployer());


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
        ppstate.setString(1,"Employer");
        ppstate.setString(2,this.getNom());
        ppstate.setDouble(2,this.getAge());
        ppstate.setInt(3,this.getIdEmployer());

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
