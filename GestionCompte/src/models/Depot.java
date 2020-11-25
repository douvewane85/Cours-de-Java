/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author user
 */
public class Depot {
    private int id;
    private double mnt;
    private LocalDate createAt;

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public Depot() {
    }

    public Depot(double mnt) {
        this.mnt = mnt;
        this.createAt=LocalDate.now();
    }

    public Depot(int id, double mnt, LocalDate createAt) {
        this.id = id;
        this.mnt = mnt;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMnt() {
        return mnt;
    }

    public void setMnt(double mnt) {
        this.mnt = mnt;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

}
