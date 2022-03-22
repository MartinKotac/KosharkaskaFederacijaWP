package ukim.finki.mk.kosharkaskafederacija.exceptions;

public class PlayerDoesNotExistException extends RuntimeException{
    public PlayerDoesNotExistException(Long id){
        super(String.format("Player with id %d was not found",id));
    }
}
