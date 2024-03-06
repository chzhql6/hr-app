package com.group.hrapplication.service.team;

import com.group.hrapplication.domain.team.Team;
import com.group.hrapplication.domain.team.TeamRepository;
import com.group.hrapplication.dto.team.request.TeamCreateRequest;
import com.group.hrapplication.dto.team.request.TeamInfoRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {this.teamRepository = teamRepository;}

    @Transactional
    public void saveTeam(TeamCreateRequest request){
        Team t = teamRepository.save(new Team(request.getTeamName()));
    }

    @Transactional
    public List<Team> findTeamInfo(TeamInfoRequest request){
        if(Objects.equals(request.getTeamName(), "All")){
            return teamRepository.findAll();
        }
        return teamRepository.findByTeamName(request.getTeamName());
    }




}
