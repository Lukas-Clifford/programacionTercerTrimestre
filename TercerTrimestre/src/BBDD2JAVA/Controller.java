import java.sql.*;

public class Controller {

    Connection conn = null;
    // Custom Exception
    public class NotSelectQuery extends Exception{
        private NotSelectQuery(String msg){
            super(msg);
        }
    }

    // Starting and closing the connection
    public Controller (String user,String pass){

        try {

            // Check for Driver library
            Class.forName("com.mysql.cj.jdbc.Driver");


            // Making the connection
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/aucorsa?user=root",
                    user, pass
            );


        } catch (ClassNotFoundException | SQLException e){

            System.out.println("An error occurred when creating the controller: ");
            e.printStackTrace();

        }
    }

    public void closeConnection () {

        try{

            this.conn.close();


        }catch (SQLException e){

            System.out.println("An error occurred when closing the conection: ");
            e.printStackTrace();

        }

    }

    // Generic update for later use
    private void executeUpdate (String query) throws SQLException {

        Statement s = this.conn.createStatement();

        System.out.println("Lines updated: " + s.executeUpdate(query));

        s.close();

    }

    // Methods to insert into the 4 different tables
    public void insertBus(String register, String type, String license) {

        try {

            this.executeUpdate(
                    String.format(
                            "INSERT INTO bus VALUES ('%s', '%s', '%s')",
                            register,type,license
                    )
            );

        } catch (SQLException e) {

            System.out.println("An error occurred when inserting into table BUS: ");
            e.printStackTrace();

        }

    }

    public void insertDriver(int numDriver, String name, String surname) {

        try {

            this.executeUpdate(
                    String.format(
                            "INSERT INTO driver VALUES (%d, '%s', '%s')",
                            numDriver, name, surname
                    )
            );

        } catch (SQLException e) {

            System.out.println("An error occurred when inserting into table DRIVER: ");
            e.printStackTrace();

        }

    }

    public void insertPlace(int idPlace, String cp, String city, String site) {

        try {
            this.executeUpdate(
                    String.format(
                            "INSERT INTO place VALUES (%d, '%s', '%s', '%s')",
                            idPlace, cp, city, site
                    )
            );

        } catch (SQLException e) {

            System.out.println("An error occurred when inserting into table PLACE: ");
            e.printStackTrace();

        }

    }

    public void insertRoute(String register, int numDriver, int idPlace, String dayOfTheWeek) {

        try {
            this.executeUpdate(
                    String.format(
                            "INSERT INTO bdp VALUES ('%s', %d, %d, '%s')",
                            register, numDriver, idPlace, dayOfTheWeek
                    )
            );

        } catch (SQLException e) {

            System.out.println("An error occurred when inserting into table BDP: ");
            e.printStackTrace();

        }

    }

    // Specific actions that the exercise requires
    public void updateByDayOfWeek(int numDriver, String dayOfWeek){
        // "Update routes for day of the week"
        // this method changes only the numdriver of
        // routes that have that day of week

        try {

            this.executeUpdate(
                    String.format(
                            "UPDATE bdp SET numdriver = %d " +
                                    "WHERE day_of_week = '%s'",
                            numDriver, dayOfWeek
                    )
            );

        } catch (SQLException e) {

            System.out.println("An error occurred when updating the day of the week: ");
            e.printStackTrace();

        }

    }

    public void deleteRoute(String register, int numDriver, int idPlace){

        try {

            this.executeUpdate(
                    String.format(
                            "DELETE FROM bdp " +
                                    "WHERE register = '%s' AND numdriver = %d AND idplace = %d",
                            register, numDriver, idPlace
                    )
            );

        } catch (SQLException e) {

            System.out.println("An error occurred when deleting a route: ");
            e.printStackTrace();

        }

    }

    // A method that only accepts Select queries
    public void executeSelectQuery (String query) throws NotSelectQuery {
        if (!query.split(" ")[0].equalsIgnoreCase("SELECT"))
            throw new NotSelectQuery("Query does not start with SELECT");

        try {
            Statement s = this.conn.createStatement();

            ResultSet result = s.executeQuery(query);

            this.printQueryResultSet(result);

            result.close(); s.close();

        } catch (SQLException e) {

            System.out.println("An error occurred when executing a SELECT query: ");
            e.printStackTrace();

        }
    }

    private void printQueryResultSet (ResultSet rs) throws SQLException {
        int columnCount = rs.getMetaData().getColumnCount();
        String tab = " \t ";

        while (rs.next()) {
            System.out.print(rs.getRow() + tab);

            for (int colIndex = 1; colIndex <= columnCount; colIndex++)

                System.out.print( rs.getObject(colIndex) + tab);

            System.out.println();
        }

    }


}



