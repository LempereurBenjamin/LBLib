package login;

import java.util.Objects;

abstract class VerifyPasswordClassic extends Validate implements Verify {
    private String _login;
    private String _password;

    VerifyPasswordClassic() {
        buildCaracteresValides();
    }

    private String buildCaracteresValides() {
        String _caracteresValidesTempo;
        _caracteresValidesTempo = ".";
        _caracteresValidesTempo += "_";

        for(int i = 48; i <= 57; i++) {
            _caracteresValidesTempo += Character.toString ((char) i);
        }

        for(int i = 65; i <= 90; i++) {
            _caracteresValidesTempo += Character.toString ((char) i);
        }

        for(int i = 97; i <= 122; i++) {
            _caracteresValidesTempo += Character.toString ((char) i);
        }

        _caracteresValides = _caracteresValidesTempo;
        return _caracteresValidesTempo;
    }

    boolean Verify(String l, String p) throws UnknownLoginPasswordException, InvalidLoginPasswordException, PasswordNotFoundException {
        if(Objects.equals(l, "") || Objects.equals(p, "")) {
            throw new UnknownLoginPasswordException();
        }
        else {
            if(!isValid(l) || !isValid(p)) {
                throw new InvalidLoginPasswordException();
            }
            else {
                _login = l;
                _password = p;
                if(!isOk()) {
                    throw new PasswordNotFoundException();
                }
                System.out.println("Bienvenue " + _login + " !");
                return true;
            }
        }
    }

    @Override
    public boolean isOk() throws InvalidLoginPasswordException, UnknownLoginPasswordException, PasswordNotFoundException {
        String _passwordTrue;

        _passwordTrue = findPwd(_login);

        return Objects.equals(_passwordTrue, _password);
    }

    abstract String findPwd(String l) throws InvalidLoginPasswordException, UnknownLoginPasswordException, PasswordNotFoundException;
}
