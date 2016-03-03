package my.actions;

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
        System.out.println("must override this method to specify your own connection string");
        // return
        return super.getConnectionString();
    }

    @Override
    protected String getUserName() {
        System.out.println("must override this method to specify your own user name");
        // return "UserName";
        return super.getUserName();
    }

    @Override
    protected String getPassword() {
        System.out.println("must override this method to specify your own password");
        // return "Password";
        return super.getPassword();
    }

    @Override
    public String getQuery() {
        System.out.println("my Query " + super.getQuery());
        return super.getQuery();
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        System.out.println("must override this method to specify your own connection");
        boolean overrideByConnectionString = getConnectionString() != null
                && getConnectionString().equals(StiAbstractAdapter.OVERRIDE_CONNECTION_STRING);
        boolean overrideByDataSource = getDataSourceName() != null
                && getDataSourceName().equals("DataSourceOverride");
        if (overrideByConnectionString || overrideByDataSource) {
            Class.forName("com.mysql.jdbc.Driver");
            Properties info = new Properties();
            info.setProperty("driver", "com.mysql.jdbc.Driver");
            info.setProperty("user", "root");
            info.setProperty("password", "password");
            String connectionString = "jdbc:mysql://localhost/sakila";
            return DriverManager.getConnection(connectionString, info);
            // Class.forName("com.mysql.jdbc.Driver");
            // String connectionString =
            // "jdbc:mysql://localhost/work_dict?user=root&password=forrest";
            // return DriverManager.getConnection(connectionString);
        } else {
            return super.getConnection();
        }
    }

}
