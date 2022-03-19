package ukim.finki.mk.kosharkaskafederacija.exceptions;

public class TeamDoesNotExistException extends RuntimeException {
    public TeamDoesNotExistException(String name){
        super(String.format("Team with id %s was not found",name));
    }
}
