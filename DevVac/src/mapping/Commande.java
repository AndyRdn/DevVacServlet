package mapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Vector;
import Connection.Connect;

public class Commande {
    int idCommande;
    int idPlat;
    int idEmployer;
    int idTable;
    Timestamp dateT;
    double montant;

    public Commande(int id) {
        this.setIdCommande(id);
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(int idPlat) {
        this.idPlat = idPlat;
    }

    public int getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(int idEmployer) {
        this.idEmployer = idEmployer;
    }
    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public Timestamp getDateT() {
        return dateT;
    }

    public void setDateT(Timestamp dateT) {
        this.dateT = dateT;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }


    public Commande(int idCommande, int idPlat, int idEmployer, int idTable, Timestamp dateT, double montant) {
        this.idCommande = idCommande;
        this.idPlat = idPlat;
        this.idEmployer = idEmployer;
        this.idTable = idTable;
        this.dateT = dateT;
        this.montant = montant;
    }

    public void insert() throws Exception {




        Connect myConnect=new Connect();
        Connection connect=null;
        PreparedStatement ppstate=null;

        try {
            connect=myConnect.getConnectionPostgresql();
            String sql="INSERT INTO commande VALUES(default,?,?,?,?,?) ";
            ppstate= connect.prepareStatement(sql);
            ppstate.setInt(1,this.getIdPlat());
            ppstate.setInt(2,this.getIdEmployer());
            ppstate.setInt(3,this.getIdTable());
            ppstate.setTimestamp(4,this.getDateT());
            ppstate.setDouble(5,this.getMontant());
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

    public static Vector<Commande> getAll()throws Exception{





        Connect myConnect=new Connect();
        Connection connect=null;
        PreparedStatement ppstate=null;
        ResultSet result=null;

        try {
            connect=myConnect.getConnectionPostgresql();
            String sql="SELECT * FROM commande ";
            ppstate= connect.prepareStatement(sql);
            result= ppstate.executeQuery();
            Vector<Commande> val=new Vector<Commande>();

            while (result.next()) {
                Commande t = new Commande(result.getInt("idcommande"), result.getInt("idsakafo"), result.getInt("idemployer"), result.getInt("idtable"), result.getTimestamp("dateT"),result.getDouble("montant"));
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
            String sql="DELETE FROM commande WHERE idcommande=?";
            ppstate= connect.prepareStatement(sql);
            ppstate.setInt(1,this.getIdCommande());
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
            String sql="UPDATE commande SET idsakafo=?, idemployer=?, idtable=?, dateT=?, montant=? WHERE idcommande=?";
            ppstate= connect.prepareStatement(sql);
            ppstate.setInt(1,this.getIdPlat());
            ppstate.setInt(2,this.getIdEmployer());
            ppstate.setInt(3,this.getIdTable());
            ppstate.setTimestamp(4,this.getDateT());
            ppstate.setDouble(5,this.getMontant());
            ppstate.setDouble(6,this.getIdCommande());
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
            String sql="SELECT * FROM commande WHERE idcommande = ?";
            ppstate= connect.prepareStatement(sql);
            ppstate.setInt(1,this.getIdCommande());
            result= ppstate.executeQuery();
            Employer t=null;
            while (result.next()) {
            this.setIdPlat(result.getInt("idsakafo"));
            this.setIdEmployer(result.getInt("idemployer"));
            this.setIdTable(result.getInt("idtable"));
            this.setDateT(result.getTimestamp("datet"));
            this.setMontant(result.getDouble("montant"));
            }
            } catch (Exception e) {
            throw e;
            }finally{
            ppstate.close();
            connect.close();

        }
    }
}
