package login;

interface Verify {
    boolean isOk() throws InvalidLoginPasswordException, UnknownLoginPasswordException, PasswordNotFoundException;
}