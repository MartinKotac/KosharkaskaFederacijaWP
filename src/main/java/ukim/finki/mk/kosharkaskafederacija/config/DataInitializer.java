package ukim.finki.mk.kosharkaskafederacija.config;

import org.springframework.stereotype.Component;
import ukim.finki.mk.kosharkaskafederacija.enumerations.CoachType;
import ukim.finki.mk.kosharkaskafederacija.model.dto.CoachDto;
import ukim.finki.mk.kosharkaskafederacija.model.dto.PlayerDto;
import ukim.finki.mk.kosharkaskafederacija.model.dto.TeamDto;
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

        teamService.create(new TeamDto("Bulls","NP","Nike","United Center"));
        teamService.create(new TeamDto("Warriors","PP","Jordan","Oracle Arena"));
        teamService.create(new TeamDto("Lakers","NP","TacoBell","Staples Center"));
        teamService.create(new TeamDto("Vardar","NP","Vitaminka","Kale"));

//        playerService.create(new PlayerDto("Derick Rose",1,"PG",1L));
//        playerService.create(new PlayerDto("Steph Curry",30,"PG",2L));
//        playerService.create(new PlayerDto("DeMar Derozan",7,"PG",1L));
//        playerService.create(new PlayerDto("Klay Thompson",8,"PG",1L));
//        playerService.create(new PlayerDto("Zach Lavine",8,"PG",1L));
//        playerService.create(new PlayerDto("Jordan Poole",0,"PG",2L));
//        playerService.create(new PlayerDto("Lebrone James",6,"PG",3L));
//        playerService.create(new PlayerDto("Cyre Irving",0,"PG",3L));
//        playerService.create(new PlayerDto("Nikola Kostovski",3,"PG",4L));
//        playerService.create(new PlayerDto("Marko markovski",4,"PG",4L));

//        coachService.create(new CoachDto("Doc Rivers", CoachType.HEAD,1L));
//        coachService.create(new CoachDto("Frank Vogel", CoachType.ASSISTANT,1L));
//        coachService.create(new CoachDto("Doc Rivers", CoachType.HEAD,2L));
//        coachService.create(new CoachDto("Frank Vogel", CoachType.ASSISTANT,2L));
//        coachService.create(new CoachDto("Doc Rivers", CoachType.HEAD,3L));
//        coachService.create(new CoachDto("Frank Vogel", CoachType.ASSISTANT,3L));
//        coachService.create(new CoachDto("Doc Rivers", CoachType.HEAD,4L));
//        coachService.create(new CoachDto("Frank Vogel", CoachType.ASSISTANT,4L));


    }
}
