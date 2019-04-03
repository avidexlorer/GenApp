package com.grafixartist.gallery;

/**
 * Created by myles on 15/02/2019.
 */

public class Apprentice {

    private String Name;
    private String Company;
    private String Description;
    private int Thumbnail;

    public Apprentice() {
    }

    public Apprentice(String name, String company, String description, int thumbnail) {
        Name = name;
        Company = company;
        Description = description;
        Thumbnail = thumbnail;
    }

    public String getName() {
        return Name;
    }

    public String getCompany() {
        return Company;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
