package Connection;

import java.sql.*;

public class Connect {
  public Connection getConnectionPostgresql() throws Exception {
  
    Connection connect = null;
    try {
      Class.forName("org.postgresql.Driver");
      connect =
        DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/restovac",
          "postgres",
          "root"
        );
        connect.setAutoCommit(false);
    } catch (Exception e) {
      throw e;
    }
    return connect;
  }
}
