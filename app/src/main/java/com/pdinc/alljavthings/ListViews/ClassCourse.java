package com.pdinc.alljavthings.ListViews;

import java.util.ArrayList;

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

    public static ArrayList<ClassCourse> createBatches() {
        ArrayList<ClassCourse> cc = new ArrayList<ClassCourse>();
        cc.add(new ClassCourse("a","b",10));
        cc.add(new ClassCourse("sa","sa",12));
        cc.add(new ClassCourse("sa","sb",11));
        cc.add(new ClassCourse("sk","sa",14));
        cc.add(new ClassCourse("sn","sm",21));
        cc.add(new ClassCourse("st","sl",21));
        cc.add(new ClassCourse("sr","se",31));
        cc.add(new ClassCourse("sy","su",41));
        cc.add(new ClassCourse("su","sg",61));
        cc.add(new ClassCourse("si","sh",81));
        cc.add(new ClassCourse("sp","sk",91));

        return cc;
    }
}