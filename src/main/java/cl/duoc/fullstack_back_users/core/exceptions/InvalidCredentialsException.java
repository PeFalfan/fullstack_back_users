package cl.duoc.fullstack_back_users.core.exceptions;

public class InvalidCredentialsException extends Exception{
    public InvalidCredentialsException(String msg){
        super(msg);
    }
}
