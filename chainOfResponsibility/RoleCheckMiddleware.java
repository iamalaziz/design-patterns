package chainOfResponsibility;

/**
 * RoleCheckMiddleware class is a concrete middleware class that checks
 * if the user is an admin or a regular user. It extends the Middleware class
 * and implements the check method.
 */
public class RoleCheckMiddleware extends Middleware {
    public boolean check(String email, String password) {
        if (email.equals("admin@google.com")) {
            System.out.println("Hello, Admin!");
            return true;
        }

        System.out.println("Hello, User!");
        return checkNext(email, password);
    }
}
