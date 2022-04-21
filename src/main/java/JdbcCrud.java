import java.sql.SQLException;

public class JdbcCrud extends Conn {

    public void createData(){

    }
    public void readData(){
        final String QUERY = "SELECT * from users";
        conn = Conn.createConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(QUERY);
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void updateData(){
        final String QUERY = "";

    }

    public void deleteData(){
        final String QUERY = "";

    }

}