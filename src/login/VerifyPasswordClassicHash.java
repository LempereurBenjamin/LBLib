package login;

import java.util.Hashtable;

public class VerifyPasswordClassicHash extends VerifyPasswordClassic {
    private final Hashtable _table;

    public VerifyPasswordClassicHash() {
        this._table = null;
    }

    public VerifyPasswordClassicHash(Hashtable _table, String log, String pass) throws InvalidLoginPasswordException, UnknownLoginPasswordException, PasswordNotFoundException {
        this._table = _table;
        Verify(log, pass);
    }

    @Override
    String findPwd(String l) throws InvalidLoginPasswordException, UnknownLoginPasswordException, PasswordNotFoundException {
        String pass;

        if(_table.containsKey(l)) {
            pass = (String)_table.get(l);
        }
        else {
            throw new PasswordNotFoundException();
        }

        return pass;
    }
}
