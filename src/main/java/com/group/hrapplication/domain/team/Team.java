package com.group.hrapplication.domain.team;

import jakarta.persistence.*;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 255, name = "team_name")
    private String teamName;

    @Column(nullable = true, name = "manager_id")
    private Long managerId;

    @Column(nullable = true, name = "manager_name")
    private String managerName;



    protected Team() {}

    public Team(String teamName, Long managerId) {
        this.teamName = teamName;
        this.managerId = managerId;
    }

    public Team(String teamName) {
        this.teamName = teamName;
        this.managerId = null;
    }



    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public Long getManagerId() {
        return managerId;
    }

    public String getManagerName() {
        return managerName;
    }
}
