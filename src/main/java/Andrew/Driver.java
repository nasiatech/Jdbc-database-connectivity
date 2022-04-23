package Andrew;

public class Driver{
    public static void main(String[] args) {
        JdbcCrud j = new JdbcCrud();
        j.createData("Nfon", "mypassword");
        j.readData();
        j.deleteData(1);
        j.updateUserName(23,"tatadrew");
    }
}