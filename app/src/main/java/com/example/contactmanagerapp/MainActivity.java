package com.example.contactmanagerapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactmanagerapp.databinding.ActivityAddNewContactBinding;
import com.example.contactmanagerapp.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Data Source
    private ContactsDatabase contactsDatabase;
    ArrayList<Contacts> contactsArrayList = new ArrayList<>();

    //Adapter
    private myAdapter myAdapter;

    //Binding
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handler = new MainActivityClickHandler(this);

        mainBinding.setClickHandler(handler);



        //RecyclerView
        RecyclerView recyclerView = mainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //adapter
        myAdapter = new myAdapter(contactsArrayList, new ViewModelProvider(this).get(MyViewModel.class));

        //Database
        contactsDatabase = ContactsDatabase.getInstance(this);

        //View Model
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        //adding data (for testing)
        Contacts c1 = new Contacts("Neeraj", "neerajkr600@gmail.com", "7011903243");
        myViewModel.addContact(c1);

        myViewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {

                contactsArrayList.clear();

                for(Contacts c: contacts){
                    Log.v("Tag", c.getName());
                    contactsArrayList.add(c);
                }


                myAdapter.notifyDataSetChanged();
            }
        });




        //Adding Adapter to the RecyclerView
        recyclerView.setAdapter(myAdapter);


    }
}