package login;

public class InvalidLoginPasswordException extends Exception {
    public InvalidLoginPasswordException() {
        super("Login ou mot de passe mal formé");
    }
}
