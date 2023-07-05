package com.example.SpringHelloWorld;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseUtils
{
    public static Connection createConnection(String driver, String url, String username, String password)
    {
        Connection conn;
        try {
            Class.forName(driver);

            if ((username == null) || (password == null) || (username.trim().length() == 0) || (password.trim().length() == 0)) {
                conn =  DriverManager.getConnection(url);
            } else {
                conn =  DriverManager.getConnection(url, username, password);
            }
            return conn;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection)
    {
        try
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public static void close(Statement st)
    {
        try
        {
            if (st != null)
            {
                st.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs)
    {
        try
        {
            if (rs != null)
            {
                rs.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void rollback(Connection connection)
    {
        try
        {
            if (connection != null)
            {
                connection.rollback();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static List<Map<String, Object>> map(ResultSet rs) throws SQLException
    {
        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

        try
        {
            if (rs != null)
            {
                ResultSetMetaData meta = rs.getMetaData();
                int numColumns = meta.getColumnCount();
                while (rs.next())
                {
                    Map<String, Object> row = new HashMap<String, Object>();
                    for (int i = 1; i <= numColumns; ++i)
                    {
                        String name = meta.getColumnName(i);
                        Object value = rs.getObject(i);
                        row.put(name, value);
                    }
                    results.add(row);
                }
            }
        }
        finally
        {
            close(rs);
        }

        return results;
    }
}