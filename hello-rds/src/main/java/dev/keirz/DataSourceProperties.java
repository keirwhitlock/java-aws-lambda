package dev.keirz;

public class DataSourceProperties {

    private final String host;
    private final int port;
    private final String db;
    private final String username;
    private final String password;

    public DataSourceProperties() {
        this.host = System.getenv("RDS_HOSTNAME");
        this.port = Integer.parseInt(System.getenv("RDS_PORT"));
        this.db = System.getenv("RDS_DB_NAME");
        this.username = System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public DataSourceProperties(String host, int port, String db, String username, String password) {
        this.host = host;
        this.port = port;
        this.db = db;
        this.username = username;
        this.password = password;
    }

    public String getJdbcUrl() {
        return String.format("jdbc:postgresql://%s:%s/%s", this.host, this.port, this.db);
    }

    public int getPort() {
        return port;
    }

    public String getDb() {
        return db;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
