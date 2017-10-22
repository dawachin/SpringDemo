package com.example.demo.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ScheduleForm {

    @NotNull
    @Size(min =1, max = 10)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
