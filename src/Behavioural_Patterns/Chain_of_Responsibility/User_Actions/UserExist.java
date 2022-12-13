package Behavioural_Patterns.Chain_of_Responsibility.User_Actions;

import Behavioural_Patterns.Chain_of_Responsibility.Server_Actions.Server;

public class UserExist extends UserActions {
    public UserExist(Server server) {
        this.server = server;
    }

    private Server server;

    @Override
    public boolean checkUser(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
}
