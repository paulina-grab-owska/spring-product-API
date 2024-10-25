package com.example.gpc_p.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/////////////////////////////// Klasa reprezentująca produkt //////////////////////////////

@XmlRootElement(name = "Product")
public class Product {
    private int id;
    private String name;
    private String category;
    private String partNumberNR;
    private String companyName;
    private boolean active;

    /////////////////// Gettery i settery ///////////////////


    ///////  Pobranie identyfikatora produktu   ///////
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    ///////  Pobranie nazwy produktu   ///////
    @XmlElement(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    ///////  Pobranie kategorii produktu   ///////
    @XmlElement(name = "Category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    ///////  Pobranie numeru patrii produktu   ///////
    @XmlElement(name = "PartNumberNR")
    public String getPartNumberNR() {
        return partNumberNR;
    }

    public void setPartNumberNR(String partNumberNR) {
        this.partNumberNR = partNumberNR;
    }


    ///////  Pobranie nazwy firmy produktu   ///////
    @XmlElement(name = "CompanyName")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    ///////  Sprawdzenie czy produkt jest aktywny   ///////
    @XmlElement(name = "Active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}