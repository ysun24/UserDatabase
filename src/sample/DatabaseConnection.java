package sample;
import java.sql.*;

class DatabaseConnection {

    private static DatabaseConnection jdbcConnect = new DatabaseConnection();
    Connection connect = null;
    static String url = "jdbc:sqlite:UserInfo.db";

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        return jdbcConnect;
    }

    public boolean addUser(User user) {
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println("Somethings Wrong With adding the User");
            return false;
        }
        System.out.println("Adding the User");
        viewUsersTable();
        return true;
    }

    public void viewUsersTable(){
        try{
        String query = "SELECT * FROM users";
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("ID");
            String username = rs.getString("Username");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            String password = rs.getString("Password");

            System.out.format("%s,%s,%s,%s,%s\n", id, username,firstName,lastName,password);
        }
        st.close();
        }catch(SQLException e)
        {
        System.out.println("Something went wrong with the viewUserTable Function");
        }
}
}

