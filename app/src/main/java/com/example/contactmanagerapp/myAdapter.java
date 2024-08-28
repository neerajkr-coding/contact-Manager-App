package com.example.contactmanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactmanagerapp.databinding.ContactsItemBinding;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.contactVeiwHolder> {

    private ArrayList<Contacts> contactsArrayList;
    private MyViewModel myViewModel;

    public myAdapter(ArrayList<Contacts> contactsArrayList, MyViewModel myViewModel) {
        this.contactsArrayList = contactsArrayList;
        this.myViewModel = myViewModel;
    }

    public void setContactsArrayList(ArrayList<Contacts> contactsArrayList) {
        this.contactsArrayList = contactsArrayList;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public contactVeiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ContactsItemBinding contactsItemBinding = DataBindingUtil.inflate(LayoutInflater.from(
                parent.getContext()),
                R.layout.contacts_item,
                parent,
                false);

        return new contactVeiwHolder(contactsItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull contactVeiwHolder holder, int position) {

        Contacts currContact = contactsArrayList.get(position);

        holder.contactsItemBinding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.deleteContact(currContact);
            }
        });



        holder.contactsItemBinding.setContact(currContact);

    }

    @Override
    public int getItemCount() {

        if(contactsArrayList != null) return contactsArrayList.size();
        return 0;
    }


    //View Holder
    static class contactVeiwHolder extends RecyclerView.ViewHolder{
        private ContactsItemBinding contactsItemBinding;

        public contactVeiwHolder(@NonNull ContactsItemBinding contactsItemBinding) {
            super(contactsItemBinding.getRoot());
            this.contactsItemBinding = contactsItemBinding;
        }
    }

}
