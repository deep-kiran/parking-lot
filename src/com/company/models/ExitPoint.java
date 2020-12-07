package com.company.models;

import com.company.models.actors.Admin;

public class ExitPoint extends Gate{
    String exitPointNumber;

    public String getExitPointNumber() {
        return exitPointNumber;
    }

    public ExitPoint setExitPointNumber(String exitPointNumber) {
        this.exitPointNumber = exitPointNumber;
        return this;
    }

}
