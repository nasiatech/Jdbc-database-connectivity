package Gills;

public class Driver {
	public static void main(String[] args) {
        JdbcCrud data = new JdbcCrud();
        data.createData(122, 21, "Mark");
        data.readData();
        
    }
}
