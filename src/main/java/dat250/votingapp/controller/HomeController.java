package dat250.votingapp.controller;

import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;

@RestController
public class HomeController {

    @GetMapping("/")
    public ArrayList<String> home() {

        ArrayList<String> theList = new ArrayList<>();
        theList.add("Rashaad");
        theList.add("Aneisha");
        return theList;
    }

    private static ArrayList<String> inspectTheDatabase(){

        ArrayList<String> theList = new ArrayList<>();
        try {
            // Load the H2 driver class
            Class.forName("org.h2.Driver");

            // Connect to the H2 database
            Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/DB"); //"jdbc:h2:file:./DB;DB_CLOSE_DELAY=-1");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute query to show tables
            ResultSet resultSet = statement.executeQuery("SHOW TABLES");


            // Print the names of the tables
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                theList.add("Table: " + tableName);


                Statement contentStatement = connection.createStatement();
                ResultSet contentResultSet = contentStatement.executeQuery("SELECT * FROM " + tableName);

                ResultSetMetaData metaData = contentResultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                // Print column names
                for (int i = 1; i <= columnCount; i++) {
                    theList.add(metaData.getColumnName(i) + "\t");
                }
                theList.add("\n");

                // Print rows
                while (contentResultSet.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        theList.add(contentResultSet.getString(i) + "\t");
                    }
                    theList.add("\n");
                }

                theList.add("-----------------------------");
                contentResultSet.close();
                contentStatement.close();

            }

            // Close all resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return theList;
    }

}
