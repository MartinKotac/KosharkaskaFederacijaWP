package ukim.finki.mk.kosharkaskafederacija.config;

import org.springframework.stereotype.Component;
import ukim.finki.mk.kosharkaskafederacija.enumerations.CoachType;
import ukim.finki.mk.kosharkaskafederacija.service.CoachService;
import ukim.finki.mk.kosharkaskafederacija.service.PlayerService;
import ukim.finki.mk.kosharkaskafederacija.service.TeamService;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final PlayerService playerService;
    private final TeamService teamService;
    private final CoachService coachService;

    public DataInitializer(PlayerService playerService, TeamService teamService, CoachService coachService) {
        this.playerService = playerService;
        this.teamService = teamService;
        this.coachService = coachService;
    }


    @PostConstruct
    public void initData(){

//        playerService.create("Derick Rose",1,"PG",1L);
//        playerService.create("Steph Curry",30,"PG",2L);
//        playerService.create("DeMar Derozan",7,"PG",1L);
//        playerService.create("Klay Thompson",8,"PG",1L);
//        playerService.create("Zach Lavine",8,"PG",1L);
//        playerService.create("Jordan Poole",0,"PG",2L);
//
//
//        teamService.create("Bulls","NP","Nike","United Center");
//        teamService.create("Warriors","PP","Jordan","Oracle Arena");
//        teamService.create("Lakers","NP","TacoBell","Staples Center");
//
//        coachService.createForDataInitializer("Doc Rivers", CoachType.HEAD,1L);
//        coachService.createForDataInitializer("Frank Vogel", CoachType.HEAD,3L);


    }
}
