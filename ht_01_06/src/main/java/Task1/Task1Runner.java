package Task1;

import Task1.DomenObject.People;

import java.sql.*;
import java.util.ArrayList;

public class Task1Runner {
    private static Connection connection;

    public static void main(String[] args) throws SQLException {
        createConnection();
        //createTablePeople();
        // CreatePeople createPeople = new CreatePeople();
        //insertPeopleToTable(createPeople.getPeopleArrayList());
//        printPeopleTable();
//        selectUniqueAdressFromPeopleTable();
countPeopleWithSameAge();


    }



    private static void countPeopleWithSameAge() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT age, COUNT (age) FROM people GROUP BY age");
        ResultSet rs = ps.executeQuery();
        System.out.println("Count ages: ");
        while (rs.next()){
            System.out.println( rs.getString(1)+" - "+rs.getInt(2));
        }
    }

    private static void selectUniqueAdressFromPeopleTable() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT adress FROM people GROUP BY adress HAVING COUNT (*)=1");
        ResultSet rs = ps.executeQuery();
        System.out.println("Unique adresses: ");
        while (rs.next()){
            System.out.print( rs.getString(1)+", ");
        }
    }

    private static void insertPeopleToTable(ArrayList<People> peopleArrayList) throws SQLException {

        PreparedStatement ps2 = connection.prepareStatement("INSERT INTO people (fio,adress,phone,age) VALUES (?,?,?,?);");
        for (People people : peopleArrayList) {
            ps2.setString(1, people.getFIO());
            ps2.setString(2, people.getAdress());
            ps2.setString(3, people.getPhone());
            ps2.setInt(4, people.getAge());
            ps2.executeUpdate();
        }
    }

    private static void printPeopleTable() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM people");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("fio: " + rs.getString(1) + " , adress: " + rs.getString(2) + " , phone: "
                    + rs.getString(3) + " , age: " + rs.getInt(4));
        }
    }

    private static void createTablePeople() throws SQLException {
        PreparedStatement ps2 = connection.prepareStatement("CREATE TABLE IF NOT EXISTS people \n" +
                "(\n" +
                "    fio varchar(30),\n" +
                "    adress varchar(30),\n" +
                "    phone varchar(20),\n" +
                "    age integer\n" +
                ");");
        System.out.println("Table is created.");
    }

    private static Connection createConnection() {

        connection = null;
        System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/people", "postgres",
                    "qwerty");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        System.out.println("PostgreSQL JDBC Driver Registered!");
        return connection;
    }


}
