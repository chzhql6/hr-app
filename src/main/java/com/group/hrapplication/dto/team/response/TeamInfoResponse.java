package com.group.hrapplication.dto.team.response;

public class TeamInfoResponse {

    private String name;
    private String manager;
    private Long memberCount;

    public TeamInfoResponse(String name, String manager, Long memberCount) {
        this.name = name;
        this.manager = manager;
        this.memberCount = memberCount;
    }

    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }

    public Long getMemberCount() {
        return memberCount;
    }
}
