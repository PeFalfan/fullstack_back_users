package cl.duoc.fullstack_back_users.core.exceptions;

public class EmailAlreadyRegisteredException extends Exception {
    public EmailAlreadyRegisteredException(String msg) {
        super(msg);
    }
}
