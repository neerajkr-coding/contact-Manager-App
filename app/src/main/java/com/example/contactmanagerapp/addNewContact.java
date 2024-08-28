package com.example.contactmanagerapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.contactmanagerapp.databinding.ActivityAddNewContactBinding;

public class addNewContact extends AppCompatActivity {

    private ActivityAddNewContactBinding activityAddNewContactBinding;
    private AddNewContactClickHandler addNewContactClickHandler;
    private Contacts contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_new_contact);

        contacts = new Contacts();

        activityAddNewContactBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_contact);


        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        addNewContactClickHandler = new AddNewContactClickHandler(contacts, this, myViewModel);

        activityAddNewContactBinding.setContact(contacts);
        activityAddNewContactBinding.setClickHandler(addNewContactClickHandler);

    }
}
