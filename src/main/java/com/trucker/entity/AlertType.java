package com.trucker.entity;

public enum AlertType  {

    HIGH("HIGH", 1) , MEDIUM("MEDIUM", 2), LOW("LOW", 3);
    private String name;
    private  int id;

    AlertType(String high, int i) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
