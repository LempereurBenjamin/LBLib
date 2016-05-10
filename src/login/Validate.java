package login;

abstract class Validate {
    String _caracteresValides;

    Validate() {
        this._caracteresValides = null;
    }

    boolean isValid(String s) {
        boolean test = false;
        for(char ch: s.toCharArray()) {
            for(char verif: _caracteresValides.toCharArray()) {
                if(ch == verif) {
                    test = true;
                    break;
                }
            }
            if(!test) {
                return false;
            }
            else {
                test = false;
            }
        }
        return true;
    }
}
