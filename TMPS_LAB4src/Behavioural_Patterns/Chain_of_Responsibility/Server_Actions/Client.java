package Behavioural_Patterns.Chain_of_Responsibility.Server_Actions;

import Behavioural_Patterns.Chain_of_Responsibility.User_Actions.ExpiredAction;
import Behavioural_Patterns.Chain_of_Responsibility.User_Actions.UserActions;
import Behavioural_Patterns.Chain_of_Responsibility.User_Actions.UserExist;
import Behavioural_Patterns.Chain_of_Responsibility.User_Actions.UserRole;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Server server;

    public static void startClient(){
        server = new Server();
        server.SignIn("seller@example.com", "seller_pass");
        server.SignIn("customer@example.com", "customer_pass");

        UserActions userActions = UserActions.doNext(
                new ExpiredAction(2),
                new UserExist(server),
                new UserRole()
        );
        server.setUserActions(userActions);
    }
}
