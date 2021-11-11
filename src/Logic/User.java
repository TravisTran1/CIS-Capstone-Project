package Logic;

/**
 * @author Travis Tran
 * @version 2020.10.14
 * A user in the database
 *
 * TT: created constructor
 * TT: created getters for every field in the Users table
 */

public class User {
    private boolean subscriber;
    private boolean admin;
    private String username;
    private int password;
    private String email;
    private String fullName;

    public User(boolean subscriber, boolean admin, String username, int password, String email, String fullName){
        this.subscriber = subscriber;
        this.admin = admin;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }

    public boolean getSubscriber(){
        return subscriber;
    }

    public boolean getAdmin(){
        return admin;
    }

    public String getUsername(){
        return username;
    }

    public int getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public String getFullName(){
        return fullName;
    }
}
