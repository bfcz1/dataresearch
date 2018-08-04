package com.me.model;


public class Item {

    private long id;
    private String company;
    private String project;
    private String batch;
    private String aidingways;
    private String assistance;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }


    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }


    public String getAidingways() {
        return aidingways;
    }

    public void setAidingways(String aidingways) {
        this.aidingways = aidingways;
    }


    public String getAssistance() {
        return assistance;
    }

    public void setAssistance(String assistance) {
        this.assistance = assistance;
    }

    public Item() {
    }

    public Item(long id, String company, String project, String batch, String aidingways, String assistance) {
        this.id = id;
        this.company = company;
        this.project = project;
        this.batch = batch;
        this.aidingways = aidingways;
        this.assistance = assistance;
    }
}
