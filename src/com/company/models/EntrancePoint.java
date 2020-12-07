package com.company.models;

public class EntrancePoint extends Gate{
    String entranceNumber;

    public String getEntranceNumber() {
        return entranceNumber;
    }

    public EntrancePoint setEntranceNumber(String entranceNumber) {
        this.entranceNumber = entranceNumber;
        return this;
    }

}
