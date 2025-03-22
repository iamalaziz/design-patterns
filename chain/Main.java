package chain;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Demo class. Everything comes together here.
 */
public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    /**
     * Initiate the chain and set the server to the first link.
     */
    public static void init() {
        server = new Server();
        server.register("admin@google.com", "1234");
        server.register("adam@google.com", "4321");

        Middleware middleware = Middleware.link(
                new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware());

        server.setMiddleware(middleware);
    }

    public static void main(String[] args) {
        init();

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = null;
            try {
                email = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.print("Input password: ");
            String password = null;
            try {
                password = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            success = server.logIn(email, password);
        } while (!success);
    }
}
