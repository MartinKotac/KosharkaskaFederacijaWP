package ukim.finki.mk.kosharkaskafederacija.exceptions;

public class TeamDoesNotExistException extends RuntimeException {
    public TeamDoesNotExistException(Long id){
        super(String.format("Team with id %d was not found",id));
    }
}
