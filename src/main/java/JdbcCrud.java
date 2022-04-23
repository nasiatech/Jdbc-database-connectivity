import java.sql.SQLException;

public class JdbcCrud extends Conn {

    public void createData(String username, String password){
        conn = Conn.createConnection();
        final String QUERY = "INSERT into users (username, password)  values  (" +username+ "," + password+ ";";
        try {
            conn.createStatement().executeUpdate(QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //working readData
    public void readData(){
        final String QUERY = "SELECT * from users";
        conn = Conn.createConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(QUERY);

            System.out.println("===================================================");
            System.out.println("Data Received");
            System.out.println("===================================================");
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("userid") + " UserName: " +rs.getString("username") + "UserPassword: "+rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void updateUserName(int userId, String userName){

        final String query = "UPDATE users set username = " + userName +  "where userid = " +userId + "; ";
        try {
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate(query);
            stmt.close();
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