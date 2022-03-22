package ukim.finki.mk.kosharkaskafederacija.exceptions;

public class TeamCoachesLimitException extends RuntimeException{
    public TeamCoachesLimitException(Long id){
        super(String.format("Team with %d already has the needed coaches",id));
    }
}
