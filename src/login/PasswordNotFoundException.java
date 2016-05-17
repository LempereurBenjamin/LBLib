package login;

public class PasswordNotFoundException extends Exception {
    PasswordNotFoundException() {
        super("Mot de passe erroné");
    }
}
