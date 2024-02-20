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

    public void insert(Connection connect) throws Exception {
        boolean connexionOuvert=false;
        if (connect == null) {
            connexionOuvert=true;
            Connect myConnect=new Connect();
            connect=myConnect.getConnectionPostgresql();
        }

        String sql="INSERT INTO ? VALUES(NULL,?,?,?,?,?) ";
        PreparedStatement ppstate= connect.prepareStatement(sql);
        ppstate.setString(1,"commande");
        ppstate.setInt(2,this.getIdPlat());
        ppstate.setInt(3,this.getIdEmployer());
        ppstate.setInt(4,this.getIdTable());
        ppstate.setTimestamp(5,this.getDateT());
        ppstate.setDouble(6,this.getMontant());

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

    public static Vector<Commande> getAll(Connection connect)throws Exception{
        boolean connexionOuvert=false;
        if (connect == null) {
            connexionOuvert=true;
            Connect myConnect=new Connect();
            connect=myConnect.getConnectionPostgresql();
        }

        String sql="SELECT * FROM ? ";
        PreparedStatement ppstate= connect.prepareStatement(sql);
        ppstate.setString(1,"commande");

        try {

            ResultSet result= ppstate.executeQuery(sql);
            Vector<Commande> val=new Vector<Commande>();

            while (result.next()) {
                Commande t = new Commande(result.getInt("idcommande"), result.getInt("idplat"), result.getInt("idemployer"), result.getInt("idtable"), result.getTimestamp("dateT"),result.getDouble("montant"));
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

        String sql="DELETE FROM ? WHERE idcommande=?";
        PreparedStatement ppstate= connect.prepareStatement(sql);
        ppstate.setString(1,"Commande");
        ppstate.setInt(2,this.getIdCommande());


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

        String sql="UPDATE ? SET idplat=?, idemployer=?, idtable=?, dateT=?, montant=? WHERE idtable=?";
        PreparedStatement ppstate= connect.prepareStatement(sql);
        ppstate.setString(1,"Commande");
        ppstate.setInt(2,this.getIdPlat());
        ppstate.setInt(3,this.getIdEmployer());
        ppstate.setInt(4,this.getIdTable());
        ppstate.setTimestamp(5,this.getDateT());
        ppstate.setDouble(6,this.getMontant());

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
