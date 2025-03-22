package chain;

/**
 * UserExistsMiddleware class is a concrete middleware class that checks
 * if the user exists in the server. It extends the Middleware class and
 * implements the check method.
 */
public class UserExistsMiddleware extends Middleware {
    Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
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
