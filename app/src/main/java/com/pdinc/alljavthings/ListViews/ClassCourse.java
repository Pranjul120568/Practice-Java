package com.pdinc.alljavthings.ListViews;

public class ClassCourse {
    private String name, instructor; private int batchStrength;
    public ClassCourse(String name, String instructor, int batchStrength) {
        this.name = name;
        this.instructor = instructor; this.batchStrength = batchStrength;
    }
    public String getName() {
        return name;
    }
    public String getInstructor() {
        return instructor;
    }
    public int getBatchStrength() {
        return batchStrength;
    }
};