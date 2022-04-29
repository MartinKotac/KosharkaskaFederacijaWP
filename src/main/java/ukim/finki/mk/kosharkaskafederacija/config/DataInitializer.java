package ukim.finki.mk.kosharkaskafederacija.config;

import org.springframework.stereotype.Component;
import ukim.finki.mk.kosharkaskafederacija.service.*;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final PlayerService playerService;
    private final TeamService teamService;
    private final CoachService coachService;
    private final DelegationService delegationService;
    private final RefereeService refereeService;

    public DataInitializer(PlayerService playerService, TeamService teamService, CoachService coachService, DelegationService delegationService, RefereeService refereeService) {
        this.playerService = playerService;
        this.teamService = teamService;
        this.coachService = coachService;
        this.delegationService = delegationService;
        this.refereeService = refereeService;
    }


    @PostConstruct
    public void initData(){
        refereeService.create(1);
        refereeService.create(1);
        refereeService.create(2);
        refereeService.create(2);

        delegationService.create(1);
        delegationService.create(1);
        delegationService.create(2);
        delegationService.create(2);

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
