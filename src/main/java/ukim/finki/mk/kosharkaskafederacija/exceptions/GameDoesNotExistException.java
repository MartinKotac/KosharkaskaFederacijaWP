package ukim.finki.mk.kosharkaskafederacija.exceptions;

public class GameDoesNotExistException extends RuntimeException{
    public GameDoesNotExistException(Long id){
        super(String.format("Game with id %d was not found",id));
    }
}
