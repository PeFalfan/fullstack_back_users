package cl.duoc.fullstack_back_users.core.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String msg){
        super(msg);
    }
}
