package login;

public class UnknownLoginPasswordException extends Exception {
    UnknownLoginPasswordException() {
        super("Login ou mot de passe manquant");
    }
}