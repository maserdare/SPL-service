/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author Mate
 */
public class Vozilo {
   String tip, model, status, godina;
   Integer broj_sasije;

    public Integer getBroj_sasije() {
        return broj_sasije;
    }

    public void setBroj_sasije(Integer broj_sasije) {
        this.broj_sasije = broj_sasije;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGodina() {
        return godina;
    }

    public void setGodina(String godina) {
        this.godina = godina;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
}
