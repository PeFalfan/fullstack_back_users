package cl.duoc.fullstack_back_users.core.exceptions;

public class BadRequestException extends Exception{
    public BadRequestException(String msg){
        super(msg);
    }
}
