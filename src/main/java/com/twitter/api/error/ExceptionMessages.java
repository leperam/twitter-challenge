package com.twitter.api.error;

public enum ExceptionMessages {

    TWITTER_0001("Business Error ");
    ExceptionMessages(String description) {
        this.description = description;
    }

    private final String description;

    public String description() {
        return description;
    }

}
