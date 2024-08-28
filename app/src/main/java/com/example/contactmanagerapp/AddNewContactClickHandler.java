package com.example.contactmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {

    Contacts contacts;
    Context context;

    MyViewModel myViewModel;

    public AddNewContactClickHandler(Contacts contacts, Context context, MyViewModel myViewModel) {
        this.contacts = contacts;
        this.context = context;
        this.myViewModel = myViewModel;
    }

    public void addContactBtnClicked(View view){

        Log.v("contact", contacts.getName()+" "+contacts.getEmail()+" "+contacts.getNum());

        if(contacts.getName() == null || contacts.getEmail() == null || contacts.getNum() == null){
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        }else{

            Intent i = new Intent(context, MainActivity.class);
//            i.putExtra("name", contacts.getName());
//            i.putExtra("email", contacts.getEmail());
//            i.putExtra("num", contacts.getNum());

            Contacts c = new Contacts(contacts.getName(), contacts.getEmail(), contacts.getNum());

            myViewModel.addContact(c);

            context.startActivity(i);

        }
    }
}
