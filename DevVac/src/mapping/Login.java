package mapping;

import Connection.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    public static boolean checkUser(String email,String mdp){
        Connect myConnect=new Connect();
        Connection connect=null;
        PreparedStatement ppstate=null;
        ResultSet result=null;

        try {
            connect=myConnect.getConnectionPostgresql();

            String sql="SELECT * FROM login WHERE email= ? AND mdp= ?";
            ppstate= connect.prepareStatement(sql);
            ppstate.setString(1,email);
            ppstate.setString(2,mdp);

            result=ppstate.executeQuery();

            return result.next();

    } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
