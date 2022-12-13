package Behavioural_Patterns.Chain_of_Responsibility.User_Actions;

public class UserRole extends UserActions {
    @Override
    public boolean checkUser(String email, String password) {
        if (email.equals("seller@example.com")) {
            System.out.println("Hello, seller!");
            return true;
        }
        System.out.println("Hello, customer!");
        return checkNext(email, password);
    }
}
