package ukim.finki.mk.kosharkaskafederacija.exceptions;

public class DelegationDoesNotExistException extends RuntimeException{
    public DelegationDoesNotExistException(Long id){
        super(String.format("Delegation with id %d was not found",id));
    }
}
