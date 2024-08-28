package com.example.contactmanagerapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts_table")
public class Contacts {

    @ColumnInfo(name = "contact_id")
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "contact_name")
    String name;

    @ColumnInfo(name = "contact_email")
    String email;

    @ColumnInfo(name = "contact_num")
    String num;

    public Contacts( String name, String email, String num) {
        this.name = name;
        this.email = email;
        this.num = num;
    }

    public Contacts(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum() { return num; }

    public void setNum(String num) { this.num = num; }
}
