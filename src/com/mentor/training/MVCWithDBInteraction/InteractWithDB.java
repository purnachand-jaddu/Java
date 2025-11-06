package com.mentor.training.mvcwithdbinteraction;

import java.sql.*;
import java.util.Arrays;

@SuppressWarnings("WeakerAccess")
class InteractWithDB
{

    private Statement statement;
    private Connection connection;

    public InteractWithDB()
    {
        try
        {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/mvctest", "postgres", "admin");
            System.out.println("Java JDBC PostgreSQL mvctest");
            System.out.println("Connected to PostgreSQL database!");
            statement = connection.createStatement();
            assert statement!=null;

        }
        catch (SQLException e)
        {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("SuspiciousNameCombination")
    public void addEntryToDB(String x, String y)
    {
        String query = "INSERT INTO firsttable(namee,price) VALUES(";
        StringBuilder builder = new StringBuilder(query);
        addWithQuotes(builder, x);
        builder.append(",");
        addWithQuotes(builder, y);
        builder.append(")");
        try
        {
            getStatement().execute(builder.toString());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Statement getStatement()
    {
        return statement;
    }

    private static void addWithQuotes(StringBuilder builder, String x)
    {
        builder.append("\'");
        builder.append(x);
        builder.append("\'");
    }

    public boolean hasUserAlready(String newUSer)
    {
        try
        {

            ResultSet resultSet = getStatement().executeQuery("select * from firsttable");
            while(resultSet.next())
            {
                if(resultSet.getString("namee").equalsIgnoreCase(newUSer))
                {
                    return true;
                }
            }
            return false;

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public Connection getConnection()
    {
        return connection;
    }
}
