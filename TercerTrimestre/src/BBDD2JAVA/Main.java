import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {


    public static void main(String[] args) {

        Controller controller = new Controller(getProperty("user"),getProperty("pass"));


        insertValues(controller);

        update(controller);

        deleteRoute(controller);

        querys(controller);

        controller.closeConnection();

    }
    
    private static String getProperty(String propertyName) {

        String propertyValue = "";

        try {

            Properties properties = new Properties();

            properties.load(new FileInputStream("src/data.properties"));

            propertyValue = properties.getProperty(propertyName);


        } catch (IOException e) {e.printStackTrace();}

        return propertyValue;
    }

    private static void querys(Controller controller) {
        try {

            int numdriver = 111;
            System.out.println("Driver data from numdriver : " + numdriver);

            controller.executeSelectQuery(
                "SELECT numdriver, name, surname " +
                    "FROM driver " +
                    "WHERE numdriver = " + numdriver
            );

            System.out.println();


            String city = "'Estepona'";
            System.out.println("Day of the week from city : " + city);

            controller.executeSelectQuery(
                "SELECT day_of_week " +
                    "FROM bdp " +
                    "JOIN place USING(idplace) " +
                    "WHERE place.city = " + city
            );

            System.out.println();


            String register = "'B002'";
            System.out.println("Drivers that drive bus with register: " + register);

            controller.executeSelectQuery(
                "SELECT numdriver, name, surname " +
                    "FROM driver " +
                    "JOIN bdp USING (numdriver) " +
                    "JOIN bus USING (register) " +
                    "WHERE register = " + register
            );





        } catch (Controller.NotSelectQuery e) {
            e.printStackTrace();
        }
    }



    private static void deleteRoute(Controller controller) {

        controller.deleteRoute("B009",109,9);

    }



    private static void update(Controller controller) {

        controller.updateByDayOfWeek(111,"Monday");

    }



    private static void insertValues(Controller controller) {

        controller.insertBus("B012","Escolar", "LIC011");

        controller.insertDriver(111, "Arnold","Schwarzenegger");

        controller.insertPlace(11,"29680", "Estepona", "Reloj");

        controller.insertRoute("B012", 111, 11, "Sunday");

    }


}