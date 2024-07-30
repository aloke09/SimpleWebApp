package com.bridgelabz.SpringWebApp.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection
{
    static Connection con=null;
    public DB_Connection(){}
    static
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con= DriverManager.getConnection(Cred.URL,Cred.UNAME,Cred.PWD);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static Connection getCon()
    {
        return  con;

    }
}
