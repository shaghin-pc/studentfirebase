package com.shagi.student;

public class constructor {

    String name,roll,ad_no,clg;

    public constructor() {
    }

    public constructor(String name, String roll, String ad_no, String clg) {
        this.name = name;
        this.roll = roll;
        this.ad_no = ad_no;
        this.clg = clg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getAd_no() {
        return ad_no;
    }

    public void setAd_no(String ad_no) {
        this.ad_no = ad_no;
    }

    public String getClg() {
        return clg;
    }

    public void setClg(String clg) {
        this.clg = clg;
    }
}
