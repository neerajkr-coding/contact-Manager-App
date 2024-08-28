package com.example.contactmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class MainActivityClickHandler {

    Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void FABClicked(View view){

        Intent i = new Intent(view.getContext(), addNewContact.class);
        context.startActivity(i);

    }
}
