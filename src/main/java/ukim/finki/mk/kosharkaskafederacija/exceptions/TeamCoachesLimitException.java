package ukim.finki.mk.kosharkaskafederacija.exceptions;

public class TeamCoachesLimitException extends RuntimeException{
    public TeamCoachesLimitException(String name){
        super(String.format("Team %s already has the needed coaches",name));
    }
}
