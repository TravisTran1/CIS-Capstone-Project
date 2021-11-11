package Data;

import java.sql.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class Database
 * This static class uses interface runQuery to run a provided query in the form of a string and returns
 * a data structure with the results of that query
 * To use the database, import Data.Database and then call runQuery() passing in your desired query.
 * If your query contains parameters, pass a String[] containing the args into runQuery() alongside your query
 * It will return the results in the form of an ArrayList&lt;HashMap&gt;
 * @author Josh Farrell, Jesus Sandoval and Cara Tang
 * @version 11/16/20
 * JF: Added argument sanitization
 * JF: Added Exception Handling
 * JF: Class now accepts queries with no SELECT clause
 */

public class Database {
    private static final String ourDataBaseURL = "jdbc:jtds:sqlserver://cisdbss.pcc.edu/234a_MissingSemiColons";
    private static final String USERNAME = "234a_MissingSemiColons";
    private static final String PASSWORD = "MissingSemiColons_FA20_$#%";

    /**
     * Runs the query provided in the parameters and returns a list of map objects containing the results
     * @param query The query to be run
     * @param queryArgs An optional array of strings containing the arguments to be sanitized and passed into the sql query
     * @return an ArrayList&lt;HashMap&gt; containing the query results
     */
    public static ArrayList<HashMap<String, String>> runQuery(String query, String[] queryArgs) throws Exception{
        String exceptionCheck = "";
        ArrayList<HashMap<String, String>> results = null;
        try (
                //open resources
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            //sanitize and input params
            if (queryArgs[0] != null) {
                for (int i = 0; i < queryArgs.length; i++) {
                    stmt.setString(i + 1, queryArgs[i]);
                }
            }
            //execute query
            boolean resultsExist = stmt.execute();
            if (resultsExist) {
                results = formatResults(stmt.getResultSet());
            }
        } catch (SQLException e) {
            exceptionCheck += e.getMessage();
        }
        if (!exceptionCheck.equals("")){
            throw new Exception("Oops, Something went wrong with the Database:\n" + exceptionCheck);
        }
        return results;
    }

    /**
     * Overloading for runQuery to allow for default params
     * @param query The query to be run
     * @return an ArrayList&lt;HashMap&gt; containing the query results
     */
    public static ArrayList<HashMap<String, String>> runQuery(String query) throws Exception{
        return runQuery(query, new String[] {null});
    }

    /**
     * Checks a query for a select clause
     * @param query A String containing an SQL query
     * @return True if the query contains a select clause, false otherwise
     */
    private static boolean checkQueryForSelect(String query) {
        if (query.toLowerCase().contains("select")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Builds a map object using the result set passed in through the parameters
     * @param resultSet the result set used to build the map
     * @return the map built from the result set entry
     * @throws SQLException
     */
    private static ArrayList<HashMap<String, String>> formatResults(ResultSet resultSet) throws SQLException{
        ArrayList<HashMap<String, String>> queryResults = new ArrayList<>();
        while (resultSet.next()) {
            queryResults.add(buildMap(resultSet));
        }
        return queryResults;
    }

    /**
     * Builds a HashMap with the provided result set row
     * @param resultSet the result row to be entered into the hashmap
     * @return A HashMap with the row entries keyed by the column names
     * @throws SQLException
     */
    private static HashMap<String,String> buildMap(ResultSet resultSet) throws SQLException {
        HashMap<String, String> resultRow = new HashMap<>();
        ArrayList<String> columnNames = getColumnNames(resultSet);
        for (String name : columnNames) {
            resultRow.put(name, resultSet.getString(name));
        }
        return resultRow;
    }

    /**
     * Builds an ArrayList of the names of the columns for a given result set
     * @param resultSet The result set to be parsed
     * @return a list of the column names
     * @throws SQLException
     */
    private static ArrayList<String> getColumnNames (ResultSet resultSet) throws SQLException{
        ResultSetMetaData metaData;
        ArrayList<String> columnNames = new ArrayList<>();
        metaData = resultSet.getMetaData();
        int n = metaData.getColumnCount();
        for (int i = 1; i <= n; i++) {
            columnNames.add(metaData.getColumnName(i));
        }
        return columnNames;
    }

    /**
     * Connects to the database
     * @return the database connection object
     * @throws SQLException if we are not able to connect
     */
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(ourDataBaseURL, USERNAME, PASSWORD);

    }
}