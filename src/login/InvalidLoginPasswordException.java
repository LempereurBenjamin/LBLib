package login;

public class InvalidLoginPasswordException extends Exception {
    InvalidLoginPasswordException() {
        super("Login ou Password malformed.");
    }
}
