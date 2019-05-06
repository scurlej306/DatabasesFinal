import java.io.*;
import java.net.ResponseCache;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Insert {

    // establish connections to the database
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "";

    static final String USER = "";
    static final String PASSWORD = "";

    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    public static void insertEmployee(){
        //establish connection
        Connection conn = null;
        //2 ways to format the string
        //1. use Statement and + to a string
        //2. preparedstatement
        PreparedStatement ps = null;
        //format insert statement & send to mysql to execute
        //open connection
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            List<List<String>> records = new ArrayList<>();
            try (Scanner scan = new Scanner(new File ("./employee.csv"));){
                while (scan.hasNextLine()){
                    String text = scan.nextLine();
                    text = text.replaceAll("\"", "");
                    records.add(getRecordFromLine(text));
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }

            System.out.println("insert into the Employee table...");

            ps = conn.prepareStatement("USE techcompany;");
            ps.executeQuery();

            for (int i = 0; i < records.size(); i++){
                String insertTableSQL = "INSERT INTO employee (eid, first_name, last_name, store_num) VALUES (?, ?, ?, ?)";
                ps = conn.prepareStatement(insertTableSQL);
                try {
                    ps.setInt(1, Integer.parseInt(records.get(i).get(0)));
                } catch (NumberFormatException e){
                    ps.setInt(1, 1);
                }
                ps.setString(2, records.get(i).get(1));
                ps.setString(3, records.get(i).get(2));
                ps.setInt(4, Integer.parseInt(records.get(i).get(3)));

                System.out.println(ps);
                ps.executeUpdate();
            }
            ps.close();
            conn.close();
        }catch (SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void insertCustomer(){
        //establish connection
        Connection conn = null;
        //2 ways to format the string
        //1. use Statement and + to a string
        //2. preparedstatement
        PreparedStatement ps = null;
        //format insert statement & send to mysql to execute
        //open connection
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            List<List<String>> records = new ArrayList<>();
            try (Scanner scan = new Scanner(new File ("./customer.csv"));){
                while (scan.hasNextLine()){
                    String text = scan.nextLine();
                    text = text.replaceAll("\"", "");
                    records.add(getRecordFromLine(text));
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }

            System.out.println("insert into the Customer table...");

            ps = conn.prepareStatement("USE techcompany;");
            ps.executeQuery();

            for (int i = 0; i < records.size(); i++){
                String insertTableSQL = "INSERT INTO customer (cid, first_name, last_name, street, city, state, zip, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                ps = conn.prepareStatement(insertTableSQL);
                try{
                    ps.setInt(1, Integer.parseInt(records.get(i).get(0)));
                } catch (NumberFormatException e){
                    ps.setInt(1, 1);
                }
                ps.setString(2, records.get(i).get(1));
                ps.setString(3, records.get(i).get(2));
                ps.setString(4, records.get(i).get(3));
                ps.setString(5, records.get(i).get(4));
                ps.setString(6, records.get(i).get(5));
                ps.setString(7, records.get(i).get(6));
                ps.setString(8, records.get(i).get(7));
                ps.setString(9, records.get(i).get(8));

                System.out.println(ps);
                ps.executeUpdate();
            }
            ps.close();
            conn.close();
        }catch (SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void insertBackInv(){
        //establish connection
        Connection conn = null;
        //2 ways to format the string
        //1. use Statement and + to a string
        //2. preparedstatement
        PreparedStatement ps = null;
        //format insert statement & send to mysql to execute
        //open connection
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            List<List<String>> records = new ArrayList<>();
            try (Scanner scan = new Scanner(new File ("./boh.csv"));){
                while (scan.hasNextLine()){
                    String text = scan.nextLine();
                    text = text.replaceAll("\"", "");
                    records.add(getRecordFromLine(text));
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }

            System.out.println("insert into the Back_Inventory table...");

            ps = conn.prepareStatement("USE techcompany;");
            ps.executeQuery();

            for (int i = 0; i < records.size(); i++){
                String insertTableSQL = "INSERT INTO back_inventory (iid, name, quantity, unit_price) VALUES (?, ?, ?, ?)";
                ps = conn.prepareStatement(insertTableSQL);
                try{
                    ps.setInt(1, Integer.parseInt(records.get(i).get(0)));
                } catch (NumberFormatException e){
                    ps.setInt(1, 1);
                }
                ps.setString(2, records.get(i).get(1));
                ps.setInt(3, Integer.parseInt(records.get(i).get(2)));
                ps.setDouble(4, Double.parseDouble(records.get(i).get(3)));

                System.out.println(ps);
                ps.executeUpdate();
            }
            ps.close();
            conn.close();
        }catch (SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void insertFrontInv(){
        //establish connection
        Connection conn = null;
        //2 ways to format the string
        //1. use Statement and + to a string
        //2. preparedstatement
        PreparedStatement ps = null;
        //format insert statement & send to mysql to execute
        //open connection
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            List<List<String>> records = new ArrayList<>();
            try (Scanner scan = new Scanner(new File ("./foh.csv"));){
                while (scan.hasNextLine()){
                    String text = scan.nextLine();
                    text = text.replaceAll("\"", "");
                    records.add(getRecordFromLine(text));
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }

            System.out.println("insert into the Front_Inventory table...");

            ps = conn.prepareStatement("USE techcompany;");
            ps.executeQuery();

            for (int i = 0; i < records.size(); i++){
                String insertTableSQL = "INSERT INTO front_inventory (iid, name, quantity, unit_price) VALUES (?, ?, ?, ?)";
                ps = conn.prepareStatement(insertTableSQL);
                try{
                    ps.setInt(1, Integer.parseInt(records.get(i).get(0)));
                } catch (NumberFormatException e){
                    ps.setInt(1, 1);
                }
                ps.setString(2, records.get(i).get(1));
                ps.setInt(3, Integer.parseInt(records.get(i).get(2)));
                ps.setDouble(4, Double.parseDouble(records.get(i).get(3)));

                System.out.println(ps);
                ps.executeUpdate();
            }
            ps.close();
            conn.close();
        }catch (SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void insertSales(){
        //establish connection
        Connection conn = null;
        //2 ways to format the string
        //1. use Statement and + to a string
        //2. preparedstatement
        PreparedStatement ps = null;
        //format insert statement & send to mysql to execute
        //open connection
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            List<List<String>> records = new ArrayList<>();
            try (Scanner scan = new Scanner(new File ("./sales.csv"));){
                while (scan.hasNextLine()){
                    String text = scan.nextLine();
                    text = text.replaceAll("\"", "");
                    records.add(getRecordFromLine(text));
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }

            System.out.println("insert into the Sales table...");

            ps = conn.prepareStatement("USE techcompany;");
            ps.executeQuery();

            for (int i = 0; i < records.size(); i++){
                String getPriceSQL = "SELECT unit_price FROM front_inventory WHERE iid = ?";
                ps = conn.prepareStatement(getPriceSQL);
                ps.setInt(1, Integer.parseInt(records.get(i).get(2)));
                ResultSet rs = ps.executeQuery();
                String insertTableSQL = "INSERT INTO sales (sid, cid, iid, date, quantity_sold, sale_total, eid) VALUES (?, ?, ?, ?, ?, ?, ?)";
                ps = conn.prepareStatement(insertTableSQL);
                try{
                    ps.setInt(1, Integer.parseInt(records.get(i).get(0)));
                } catch (NumberFormatException e){
                    ps.setInt(1, 1);
                }
                ps.setInt(2, Integer.parseInt(records.get(i).get(1)));
                ps.setInt(3, Integer.parseInt(records.get(i).get(2)));
                ps.setString(4, records.get(i).get(3));
                ps.setInt(5, Integer.parseInt(records.get(i).get(4)));
                if (rs.next()) {
                    ps.setDouble(6, rs.getDouble("unit_price") * Double.parseDouble(records.get(i).get(4)));
                }
                ps.setInt(7, Integer.parseInt(records.get(i).get(6)));

                System.out.println(ps);
                ps.executeUpdate();
            }
            ps.close();
            conn.close();
        }catch (SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        insertCustomer();
        insertEmployee();
        insertBackInv();
        insertFrontInv();
        insertSales();
    }
}
