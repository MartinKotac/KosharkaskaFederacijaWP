package ukim.finki.mk.kosharkaskafederacija.exceptions;

public class CoachDoesNotExistException extends RuntimeException{
    public CoachDoesNotExistException(Long id){
        super(String.format("Coach with id %d was not found",id));
    }

}
