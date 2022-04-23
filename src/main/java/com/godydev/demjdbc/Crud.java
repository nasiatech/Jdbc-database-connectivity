package com.godydev.demjdbc;

import java.sql.SQLException;

public class Crud extends Connect{

    static final String Query = "SELECT Intern_Id,First_Name,Last_Name,Track FROM nasiaintern";

    public void insertData(){
        connect = Connect.createConnection();

        try {
            state = connect.createStatement();
            System.out.println("Inserting data in to data base");
            String sql ="INSERT INTO nasiaintern values(7,'Mbuh','Hilton','Project Manager')";
            state.executeUpdate(sql);
            }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void  readData(){
        connect = Connect.createConnection();
        try {
            System.out.println("Displaying Data from Database");
            String query = "select * from nasiaintern";
            state = connect.createStatement();
            rs = state.executeQuery(query);

            while (rs.next()){
                System.out.println(rs.getString("Last_Name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteData(){

        connect = Connect.createConnection();
        try {
            System.out.println("Deleting record from database");
            String del = "DELETE FROM nasiaintern " + "WHERE Intern_Id = 6";
            state = connect.createStatement();
            state.executeUpdate(del);
            rs = state.executeQuery(Query);

            while(rs.next()){
                //Displaying values
                System.out.println("Intern_Id: " + rs.getInt("Intern_Id"));
                System.out.println(", FirstName:" + rs.getString("First_Name"));
                System.out.println(", LastName: " + rs.getString("Last_Name"));
                System.out.println(", Track: " + rs.getString("Track"));
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public  void updateData(){

    }

}









/*package com.godydev.demjdbc;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.Statement;

public class Connect {
    public static void main(String[] args){
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nasiaintern", "root", "");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from nasiaintern");

            while (resultSet.next()) {

                System.out.println(resultSet.getString("track"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

 */
