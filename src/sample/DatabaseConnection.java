package sample.DatabaseTest;
import java.sql.*;

class DatabaseConnection {

    private static DatabaseConnection jdbcConnect = new DatabaseConnection();
    Connection connect = null;
    static String url = "jdbc:sqlite:AccountData.db";

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        return jdbcConnect;
    }

    public boolean deleteUser(int id) {
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection(url);;
            connect.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connect.createStatement();
            String sql = "DELETE from USERS where ID="+id+";";
            stmt.executeUpdate(sql);

            stmt.close();
            connect.commit();
            connect.close();
        } catch ( Exception e ) {
            System.out.println("Somethings Wrong With Update the User");
            return false;
        }
        System.out.println("Records delete successfully");
        return true;
    }

    public boolean addUser(User user){
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection(url);;
            connect.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connect.createStatement();
            String sql = "INSERT INTO users (ID,USERNAME,FIRSTNAME,LASTNAME,PASSWORD) " +
                    "VALUES ("+user.id+", '"+user.username+"','"+user.firstName+"', '"+user.lastName+"', '"+user.password+"' );";
            stmt.executeUpdate(sql);

            stmt.close();
            connect.commit();
            connect.close();
        } catch ( Exception e ) {
            System.out.println("Somethings Wrong With Insert the User");
            return false;
        }
        System.out.println("Records created successfully");
        return true;
    }



    public boolean updateUser(User user){
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection(url);;
            connect.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connect.createStatement();
            String sql = "UPDATE USERS set username = "+user.username+" where ID="+user.id+";";
            stmt.executeUpdate(sql);

            sql = "UPDATE USERS set username = "+user.firstName+" where ID="+user.id+";";
            stmt.executeUpdate(sql);

            sql = "UPDATE USERS set username = "+user.lastName+" where ID="+user.id+";";
            stmt.executeUpdate(sql);

            sql = "UPDATE USERS set username = "+user.password+" where ID="+user.id+";";
            stmt.executeUpdate(sql);

            stmt.close();
            connect.commit();
            connect.close();
        } catch ( Exception e ) {
            System.out.println("Somethings Wrong With Update the User");
            return false;
        }
        System.out.println("Records update successfully");
        return true;
    }

    public void viewUsersTable(){
        try{
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection(url);;
            connect.setAutoCommit(false);
            System.out.println("Opened database successfully");

            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM USERS;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String firstName = rs.getString("firstName");
                String lastName  = rs.getString("lastName");
                String password = rs.getString("password");
                System.out.println( "ID = " + id );
                System.out.println( "userName = " + username );
                System.out.println( "firstName = " + firstName );
                System.out.println( "lastName = " + lastName );
                System.out.println( "SALARY = " + password );
                System.out.println();
            }
            rs.close();
            stmt.close();
            connect.close();
        }catch(SQLException | ClassNotFoundException e)
        {
        System.out.println("Something went wrong with the viewUserTable Function");
        }
}
}

