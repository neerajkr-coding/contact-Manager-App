package com.example.contactmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    Repository repository;

    //Live Data
    LiveData<List<Contacts>> allContacts;
    public LiveData<List<Contacts>> getAllContacts(){
        allContacts = repository.getAllContacts();
        return allContacts;
    }

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public void addContact(Contacts contacts){
        repository.addContact(contacts);
    }

    public void deleteContact(Contacts contacts){
        repository.deleteContact(contacts);
    }


}
