package Behavioural_Patterns.Chain_of_Responsibility.User_Actions;

public abstract class UserActions {
    private UserActions next;

    public static UserActions doNext(UserActions first, UserActions... chain) {
        UserActions head = first;
        for (UserActions nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

        public abstract boolean checkUser(String email, String password);

        protected boolean checkNext(String email, String password){
            if(next == null){
                return true;
            }
            return next.checkUser(email, password);
    }
}
