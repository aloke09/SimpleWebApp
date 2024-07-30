package com.bridgelabz.SpringWebApp.repository;

import com.bridgelabz.SpringWebApp.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUD_Operation_using_JDBC
{

    public static void getAllProduct()
    {
        try
        {
            Connection con =DB_Connection.getCon();
            PreparedStatement ps = con.prepareStatement("select * from product");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"   "+
                rs.getString(2)+"   "+
                rs.getInt(3));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void getByID(int pID)
    {
        try
        {
            Connection con =DB_Connection.getCon();
            PreparedStatement ps = con.prepareStatement("select * from product where productid=?");
            ps.setInt(1,pID);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                if(rs.getInt(1)==pID)
                {
                    System.out.println(rs.getInt(1)+"   "+
                            rs.getString(2)+"   "+
                            rs.getInt(3));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void InsertProduct(Product product)
    {
        try
        {
            Connection con =DB_Connection.getCon();
            PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?)");
            ps.setInt(1,product.getProductId());
            ps.setString(2,product.getProductName());
            ps.setInt(3,product.getPrice());
            int r = ps.executeUpdate();
            if(r>0)
            {
                System.out.println("product data inserted successfully!!!");
            }
            else
            {
                System.err.println("product data not inserted successfully!!!");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
