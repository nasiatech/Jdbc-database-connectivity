package Andrew;

import java.sql.SQLException;

public class JdbcCrud extends Conn {


    public void createData(String username, String password){

        conn = Conn.createConnection();
        final String QUERY = "INSERT into users (username, password)  values (?, ?)";
        try {
            System.out.println("=======================================================");
            System.out.println("Inserting");
            System.out.println("=======================================================\n");
            stmt1 = conn.prepareStatement(QUERY);
            stmt1.setString(1,username);
            stmt1.setString(2, password);
            int result = stmt1.executeUpdate();
            if(result >= 1){
                System.out.println("Insertion successful");
                System.out.println("did "+result +" Insertions");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //working readData
    public void readData(){
        final String QUERY = "SELECT * from users";
        try {
            stmt = conn.createStatement();
            System.out.println("Executing Read Operation");
            rs = stmt.executeQuery(QUERY);

            System.out.println("\n\n===================================================");
            System.out.println("Data Received");
            System.out.println("===================================================\n\n");
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("userid") + " UserName: " +rs.getString("username") + "UserPassword: "+rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void updateUserName(int id, String username){
        conn = Conn.createConnection();
        try {
            final String query = "UPDATE users  SET username=? where userid=?";
            stmt1 = conn.prepareStatement(query);
            stmt1.setString(1,username);
            stmt1.setInt(2, id);
            System.out.println("\n\n============================================================");
            System.out.println("Updating Username");
            System.out.println("============================================================\n");
            int rs = stmt1.executeUpdate();
            if(rs>=1){
                System.out.println("Succesfully updated username");
            }
            stmt1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteData(int Id){
        final String QUERY = "DELETE from users where userid = " + Id +";";
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}