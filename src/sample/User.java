package sample;
import java.lang.*;

public class User {
    int id;
    String username;
    String firstName;
    String lastName;
    String password;

    User(int id,String username,String firstName, String lastName, String password){
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

}
