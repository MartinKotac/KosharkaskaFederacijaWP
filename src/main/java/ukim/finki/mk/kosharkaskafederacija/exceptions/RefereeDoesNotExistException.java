package ukim.finki.mk.kosharkaskafederacija.exceptions;

import java.util.List;

public class RefereeDoesNotExistException extends RuntimeException{
    public RefereeDoesNotExistException(Long id){
        super(String.format("Referee with id %d was not found",id));
    }
}
