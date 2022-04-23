import java.sql.SQLException;

public class JdbcCrud extends Conn {

    public void createData(){

        conn = Conn.createConnection();
        final String QUERY = "INSERT into users (username, password)  values ('andrew', 'bblabla')";
        try {
            System.out.println("=======================================================");
            System.out.println("Inserting");
            System.out.println("=======================================================");
            int result = conn.createStatement().executeUpdate(QUERY);
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
        conn = Conn.createConnection();
        try {
            stmt = conn.createStatement();
            System.out.println("Executing ReadOperation");
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



    public void updateUserName(){

        final String query = "UPDATE users set username = 'myUsename' where userid = 2 ";
        try {
            stmt = conn.prepareStatement(query);
            System.out.println("============================================================");
            System.out.println("Updating Username");
            System.out.println("============================================================");
            int rs = stmt.executeUpdate(query);
            if(rs>=1){
                System.out.println("Succesfully updated username");
            }
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