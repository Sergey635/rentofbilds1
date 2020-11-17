package edu.ale.rentofbilds.forms;

import java.time.LocalDate;

public class ClientForm {
    private String id = " ";
    private String name = " ";
    private String gender = " ";
    private String adres = " ";
    private String phone = " ";
    private String birthday = " ";
    private String description = " ";
    private String created_at = " ";
    private String modified_at = " ";

    public ClientForm() {
    }

    public ClientForm(String name, String adres, String phone
            , String birthday, String description) {
        this.name = name;
        this.adres = adres;
        this.phone = phone;
        this.birthday = birthday;
        this.description = description;
    }

    public ClientForm(String name, String gender, String adres, String phone, String birthday, String description) {
        this.name = name;
        this.gender = gender;
        this.adres = adres;
        this.phone = phone;
        this.birthday = birthday;
        this.description = description;
    }

    public ClientForm(String id, String name, String gender, String adres, String phone, String birthday, String description, String created_at, String modified_at) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.adres = adres;
        this.phone = phone;
        this.birthday = birthday;
        this.description = description;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getModified_at() {
        return modified_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ClientForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", adres='" + adres + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthday + '\'' +
                ", description='" + description + '\'' +
                ", created_at='" + created_at + '\'' +
                ", modified_at='" + modified_at + '\'' +
                '}';
    }
}
