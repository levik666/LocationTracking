package com.epam.locationtracking.entity;

public enum  SocialType {
    TWITTER (""),
    DATABASE ("SimpleMongoRepository");

    private String type;

    SocialType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
