package com.stimulsoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.stimulsoft.flex.StiLoadDataAction;
import com.stimulsoft.report.dictionary.adapters.StiAbstractAdapter;

/**
 * MyLoadDataAction.
 * 
 * Copyright Stimulsoft
 * 
 */
public class MyLoadDataAction extends StiLoadDataAction {

    @Override
    protected String getConnectionString() {
        return super.getConnectionString();
    }

    @Override
    protected String getUserName() {
        return super.getUserName();
    }

    @Override
    protected String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getQuery() {
        return super.getQuery();
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        boolean overrideByConnectionString = getConnectionString() != null && getConnectionString().equals(StiAbstractAdapter.OVERRIDE_CONNECTION_STRING);
        boolean overrideByDataSource = getDataSourceName() != null && getDataSourceName().equals("DataSourceOverride");
        if (overrideByConnectionString || overrideByDataSource) {
            Class.forName("com.mysql.jdbc.Driver");
            Properties info = new Properties();
            info.setProperty("driver", "com.mysql.jdbc.Driver");
            info.setProperty("user", "root");
            info.setProperty("password", "password");
            String connectionString = "jdbc:mysql://localhost/sakila";
            return DriverManager.getConnection(connectionString, info);
        } else {
            return super.getConnection();
        }
    }

}
