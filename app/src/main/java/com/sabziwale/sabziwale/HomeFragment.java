package com.sabziwale.sabziwale;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    VegetablesAdapter adapter;
    List<Vegetables>  vegetablesList;
    private ProgressDialog progressDialog;
    Button btncontinue;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        // TODO Oncreate starts here with current context as View or getContext

        recyclerView = view.findViewById(R.id.recyclerView1);
        btncontinue = view.findViewById(R.id.buttonContinue);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading Vegetables");
        progressDialog.show();


        vegetablesList = new ArrayList<>();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Vegetables");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists())
                {
                    for (DataSnapshot vegetableSnapshot : dataSnapshot.getChildren()){
                        Vegetables veg = vegetableSnapshot.getValue(Vegetables.class);
                        vegetablesList.add(veg);
                    }
                    adapter = new VegetablesAdapter(getContext(),vegetablesList);
                    recyclerView.setAdapter(adapter);

                }
                progressDialog.dismiss();
                btncontinue.setVisibility(View.VISIBLE);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();

            }
        });

        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),OrderConfirm.class);
                startActivity(intent);
            }
        });



        return view;
    }

}
