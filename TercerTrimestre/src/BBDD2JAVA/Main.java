package BBDD2JAVA;


public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller("root","");


//        insertValues(controller);


//        update(controller);


//        deleteRoute(controller);


        querys(controller);


        controller.closeConnection();

    }

    private static void querys(Controller controller) {
        try {

            int numdriver = 111;
            System.out.println("Driver data from numdriver : " + numdriver);

            controller.executeSelectQuery(
                "SELECT numdriver, name, surname " +
                    "FROM Driver " +
                    "WHERE numdriver = " + numdriver
            );

            System.out.println();


            String city = "'Estepona'";
            System.out.println("Day of the week from city : " + city);

            controller.executeSelectQuery(
                "SELECT day_of_week " +
                    "FROM BDP " +
                    "JOIN Place USING(idplace) " +
                    "WHERE Place.city = " + city
            );

            System.out.println();


            String register = "'B002'";
            System.out.println("Drivers that drive bus with register: " + register);

            controller.executeSelectQuery(
                "SELECT numdriver, name, surname " +
                    "FROM Driver " +
                    "JOIN BDP USING (numdriver) " +
                    "JOIN Bus USING (register) " +
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

        controller.updateDayOfWeek(111,"Monday");

    }



    private static void insertValues(Controller controller) {

        controller.insertBus("B012","Escolar", "LIC011");

        controller.insertDriver(111, "Arnold","Schwarzenegger");

        controller.insertPlace(11,"29680", "Estepona", "Reloj");

        controller.insertRoute("B012", 111, 11, "Sunday");

    }


}