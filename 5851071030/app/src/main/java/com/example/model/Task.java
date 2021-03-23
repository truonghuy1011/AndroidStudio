package com.example.model;

public class Task {
    private int ID;
    private String idTask;
    private String nameTask;
    private String producerTask;
    private int priceTask;

    public Task(int ID, String idTask, String nameTask, String producerTask, int priceTask) {
        this.ID = ID;
        this.idTask = idTask;
        this.nameTask = nameTask;
        this.producerTask = producerTask;
        this.priceTask = priceTask;
    }

    public Task() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIdTask() {
        return idTask;
    }

    public void setIdTask(String idTask) {
        this.idTask = idTask;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getProducerTask() {
        return producerTask;
    }

    public void setProducerTask(String producerTask) {
        this.producerTask = producerTask;
    }

    public int getPriceTask() {
        return priceTask;
    }

    public void setPriceTask(int priceTask) {
        this.priceTask = priceTask;
    }
}
