package com.example.contactmanagerapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Repository {

    private final ContactsDAO contactsDAO;
    ExecutorService executor;
    Handler handler;

    public Repository(Application application) {

        ContactsDatabase contactsDatabase = ContactsDatabase.getInstance(application);
        this.contactsDAO = contactsDatabase.getContactDao();

        this.executor = Executors.newSingleThreadExecutor();
        this.handler = new Handler(Looper.getMainLooper());

    }


    //DAO methods being executed through the repository
    public void addContact(Contacts contacts){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactsDAO.insert(contacts);
            }
        });
    }

    public void deleteContact(Contacts contacts){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactsDAO.delete(contacts);
            }
        });

    }

    public LiveData<List<Contacts>> getAllContacts(){

        return contactsDAO.getAllContacts();
    }
}
