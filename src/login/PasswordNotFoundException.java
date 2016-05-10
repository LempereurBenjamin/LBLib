package login;

public class PasswordNotFoundException extends Exception {
    PasswordNotFoundException() {
        super("Password wrong.");
    }
}
