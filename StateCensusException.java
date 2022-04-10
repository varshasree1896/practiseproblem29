package com.blz.indiancensusanalyzer;

public class StateCensusException extends Exception {
    public String messege;

    public StateCensusException(String messege) {
        if(messege.contains("Invalid File Format")) {
            this.messege = com.blz.indiancensusanalyzer.ExceptionType.INVALID_FORMAT+ ":" + messege;
        }
    }

    @Override
    public String getMessage() {
        return messege;
    }
}