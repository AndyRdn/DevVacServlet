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

    public Employer() {

    }

    public Employer(int id) {
        this.setIdEmployer(id);
    }

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

    public void insert() throws Exception {
        Connect myConnect=new Connect();
        Connection connect=null;
        PreparedStatement ppstate=null;



        try {
            connect=myConnect.getConnectionPostgresql();
            String sql="INSERT INTO employer VALUES(default,?,?) ";
            ppstate= connect.prepareStatement(sql);
            ppstate.setString(1,this.getNom());
            ppstate.setInt(2,this.getAge());
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

    public static Vector<Employer> getAll()throws Exception{


        Connect myConnect=new Connect();
        Connection connect=null;
        PreparedStatement ppstate=null;
        ResultSet result=null;

        try {
            connect=myConnect.getConnectionPostgresql();
            String sql="SELECT * FROM employer ";
            ppstate= connect.prepareStatement(sql);

            result= ppstate.executeQuery();
            Vector<Employer> val=new Vector<Employer>();

            while (result.next()) {
                Employer t = new Employer(result.getInt("idemployer"),result.getString("nom"),result.getInt("age"));
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
            String sql="DELETE FROM employer WHERE idemployer=?";
            ppstate= connect.prepareStatement(sql);
            ppstate.setInt(1,this.getIdEmployer());
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
            String sql="UPDATE employer SET nom=?,prix=? WHERE idtable=?";
            ppstate= connect.prepareStatement(sql);
            ppstate.setString(1,this.getNom());
            ppstate.setDouble(2,this.getAge());
            ppstate.setInt(3,this.getIdEmployer());
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
            String sql="SELECT * FROM employer WHERE idemployer = ?";
            ppstate= connect.prepareStatement(sql);
            ppstate.setInt(1,this.getIdEmployer());
            result= ppstate.executeQuery();
            Employer t=null;
            while (result.next()) {
                this.setNom(result.getString("nom"));
                this.setAge(result.getInt("age"));
            }

        } catch (Exception e) {
            throw e;
        }finally{
            ppstate.close();
            connect.close();

        }
    }
}
