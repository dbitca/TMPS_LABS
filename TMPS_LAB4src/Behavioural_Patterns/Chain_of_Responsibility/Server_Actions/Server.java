package Behavioural_Patterns.Chain_of_Responsibility.Server_Actions;

import Behavioural_Patterns.Chain_of_Responsibility.User_Actions.UserActions;

import java.util.HashMap;
import java.util.Map;

public class Server {
    private Map<String, String> users = new HashMap<>();
    private UserActions userActions;

    public void setUserActions(UserActions userActions){
        this.userActions = userActions;
    }

    public boolean LogIn(String email, String password){
        if (userActions.checkUser(email,password)){
            System.out.println("Log In Successful");
            return true;
        }
        return false;
    }

    public void SignIn(String email, String password){
        users.put(email, password);
    }

    public boolean hasEmail(String email){
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password){
        return users.get(email).equals(password);
    }
}
