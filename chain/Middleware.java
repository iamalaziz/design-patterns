package chain;

/**
 * The Middleware class represents a middleware component in the chain of
 * responsibility.
 */
public abstract class Middleware {
    private Middleware next;

    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    /**
     * The method for setting the next middleware in the chain.
     * Subclasses will implement this method with concrete checks.
     */
    public abstract boolean check(String email, String password);

    /**
     * Checks the next middleware in the chain, if it exists.
     * If there is no next middleware, the check passes by default.
     */
    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }

        return next.check(email, password);
    }
}
