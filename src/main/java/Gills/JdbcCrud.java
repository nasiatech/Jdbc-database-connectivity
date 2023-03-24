package Gills;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JdbcCrud extends Conn {

    public void createData(int cust_id, int age, String name){

         Conn.createConnection();
         connection = Conn.getConnection();
        final String QUERY = "INSERT into customers (cust_id, age, name)  values  (" + cust_id +"," +","+age +","+ name+")";
        try {
        PreparedStatement statement = connection.prepareStatement(QUERY);
        int result = statement.executeUpdate();
        if(result >= 1)
            System.out.println("insertion successful");
        }catch(SQLException sqlException) {
        	sqlException.printStackTrace();
        }
        }
    
    public void readData(){
        final String QUERY = "SELECT * from customers";
        try {
           Statement statement = connection.createStatement();
            System.out.println("Read from the database");
            ResultSet results = statement.executeQuery(QUERY);

            System.out.println("----Results from querying the database");
            while(results.next()){
                System.out.println("ID: "+results.getInt("cust_id") + " Age: " +results.getInt("age") + " Name: "+results.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteData(int id){
        final String QUERY = "DELETE from customers where cust_id = " + id +";";
        try {
        	Statement statement = connection.createStatement();
           statement.executeUpdate(QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }

}
}
