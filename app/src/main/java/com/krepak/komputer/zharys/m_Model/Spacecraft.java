package com.krepak.komputer.zharys.m_Model;

public class Spacecraft {

    String name,propellant,description;
    String opiszhan;
    String fotka;
    String webka;


    public Spacecraft() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWebka(){
        return webka;
    }
    public void setWebka(String webka){
        this.webka = webka;
    }



    public String getFotka(){
        return fotka;
    }
    public void setFotka(String fotka){
        this.fotka = fotka;
    }

    public String getOpiszhan(){
        return opiszhan;
    }
    public void setOpiszhan(String opiszhan){
        this.opiszhan = opiszhan;
    }


    public String getPropellant() {
        return propellant;
    }

    public void setPropellant(String propellant) {
        this.propellant = propellant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
