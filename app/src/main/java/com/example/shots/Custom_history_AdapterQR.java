package com.example.shots;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Custom_history_AdapterQR extends RecyclerView.Adapter<Custom_history_AdapterQR.ContactHolder> {

    // List to store all the contact details
    private ArrayList<QRstructure> contactsList;
    private Context mContext;
    // Counstructor for the Class
    public Custom_history_AdapterQR(ArrayList<QRstructure> contactsList, Context context) {
        this.contactsList = contactsList;
        this.mContext = context;
    }
    // This method creates views for the RecyclerView by inflating the layout
    // Into the viewHolders which helps to display the items in the RecyclerView
    @Override
    public Custom_history_AdapterQR.ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.history_view_layout, parent, false);
        return new Custom_history_AdapterQR.ContactHolder(view);
    }
    @Override
    public int getItemCount() {
        return contactsList == null? 0: contactsList.size();
    }
    // This method is called when binding the data to the views being created in RecyclerView
    @Override
    public void onBindViewHolder(@NonNull Custom_history_AdapterQR.ContactHolder holder, final int position) {
        final QRstructure contact = contactsList.get(position);

        // Set the data to the views here
        holder.setContactBR(contact.getQR());
        holder.setContactDATE(contact.getDATE());
        // You can set click listners to indvidual items in the viewholder here
        // make sure you pass down the listner or make the Data members of the viewHolder public

    }
    // This is your ViewHolder class that helps to populate data to the view
    public class ContactHolder extends RecyclerView.ViewHolder {
        private TextView BR_view;
        private TextView DATE_view;

        public ContactHolder(View itemView) {
            super(itemView);
            BR_view = itemView.findViewById(R.id.histR);
            DATE_view = itemView.findViewById(R.id.histD);
        }

        public void setContactBR(String BR) {
            BR_view.setText(BR);
        }
        public void setContactDATE(String DATE) {
            DATE_view.setText(DATE);
        }
    }
}
