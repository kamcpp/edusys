package org.labcrypto.edusys.domain.pg.dao.gheyas;

public class GheyasConfiguration {

  private String server;
  private String port;
  private String databaseName;
  private String username;
  private String password;

  public String getServer () {
    return server;
  }

  public void setServer (String server) {
    this.server = server;
  }

  public String getPort () {
    return port;
  }

  public void setPort (String port) {
    this.port = port;
  }

  public String getDatabaseName () {
    return databaseName;
  }

  public void setDatabaseName (String databaseName) {
    this.databaseName = databaseName;
  }

  public String getUsername () {
    return username;
  }

  public void setUsername (String username) {
    this.username = username;
  }

  public String getPassword () {
    return password;
  }

  public void setPassword (String password) {
    this.password = password;
  }

  public String getConnectionUrl () {
    return "jdbc:sqlserver://" + server + ":" + port + ";databaseName=" + databaseName + ";user=" + username
        + ";password=" + password;
  }
}
