package login;

public class UnknownLoginPasswordException extends Exception {
    UnknownLoginPasswordException() {
        super("Missing Login or Password.");
    }
}