package co.ao.bd;



import com.mysql.cj.jdbc.MysqlDataSource;


import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Arrays;

public class Mysql {
    static String db ;
    static String url;
    static String driver;
    static String porta_Servidor ;
    static String ipServer ;
    static String BD_user;
    static String BD_pass;
    static String ServerTimeZone="UTC";
    static boolean SSL;
    static MysqlDataSource data_Source;
    private static Connection Conect;
    public Statement statement;
    public ResultSet resultset;

    public  Mysql (){}

    public  Mysql(String db, String url, String driver, String porta_Servidor, String ipServer, String user, String pass){
        Mysql.db = db;
        Mysql.url = url;
        Mysql.driver = driver;
        Mysql.porta_Servidor = porta_Servidor;
        Mysql.ipServer = ipServer;
        Mysql.BD_user = user;
        Mysql.BD_pass = pass;
        Mysql.ServerTimeZone = ServerTimeZone;
        Mysql.SSL = SSL;
    }

    public static String getIpServer() {
        return ipServer;
    }
    public static void setIpServer(String ipServer) {
        Mysql.ipServer = ipServer;
    }

    public static String getPorta_Servidor() {
        return porta_Servidor;
    }
    public static void setPorta_Servidor(String porta_Servidor) {
        Mysql.porta_Servidor = porta_Servidor;
    }

    public static String getDb() {
        return db;
    }
    public static void setDb(String db) {
        Mysql.db = db;
    }

    public static String getBD_User() {
        return BD_user;
    }
    public static void setBD_user(String user) {
        Mysql.BD_user = user;
    }

    public static String getBD_pass() {
        return BD_pass;
    }
    public static void setBD_Pass(String pass) {
        Mysql.BD_pass = pass;
    }

    public static String getUrl() {
        return url;
    }
    public static void setUrl(String url) {
        Mysql.url = url;
    }

    public static String getDriver() {return driver;}
    public static void setDriver(String driver) {
        Mysql.driver = driver;
    }

    public static String getServerTimeZone(){return ServerTimeZone;}
    public static void setServerTimeZone(String timeZone ){Mysql.ServerTimeZone = timeZone;}

    public static boolean isSSL() {return SSL;}
    public static void setSSL(boolean SSL) {Mysql.SSL = SSL;}

    public static Connection getConnection() throws SQLException {
        try {

      data_Source = new MysqlDataSource();

        data_Source.setUseSSL(false);
        data_Source.setServerTimezone(getServerTimeZone());
        data_Source.setServerName("localhost");
        data_Source.setDatabaseName(getDb());
        data_Source.setUrl(getUrl());
        data_Source.setUser(getBD_User());
        data_Source.setPortNumber(Integer.parseInt(getPorta_Servidor()));
        data_Source.setPassword(getBD_pass());


          Conect = DriverManager.getConnection(data_Source.getUrl(),BD_user,BD_pass);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errror na conecao com base de dados_n1: " +ex.getMessage());
            System.out.println("Errror na conecao com base de dados_n1: " +ex.getMessage() +getUrl());
        }
        return data_Source.getConnection();
    }
    public void executaSQL(String sql) {
        try {
            statement = Conect.createStatement();
            resultset = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errror na conecao com base de dados_n2: " +ex.getMessage());
            System.out.println("Errror na conecao com base de dados_n3: " +ex.getErrorCode());
        }

    }
    public void leitura_config() throws IOException {
        Path caminho_Arquivo = Paths.get("src/main/resources/ficheiros/config.txt");
        Charset utf_8 = StandardCharsets.UTF_8;
        try (BufferedReader read = Files.newBufferedReader(caminho_Arquivo, utf_8)) {
            String[] lista_conect = new String[7];

            @SuppressWarnings("UnusedAssignment")
            String linha = null;
            while((linha = read.readLine())!=null){
                for(int i =0; i >linha.length(); ++i){
                    lista_conect[i]= linha;
                }
                System.out.println(Arrays.toString(lista_conect));
            }
        }
    }
}
