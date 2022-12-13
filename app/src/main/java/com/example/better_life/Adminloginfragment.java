package com.example.better_life;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class Adminloginfragment extends Fragment {
FirebaseAuth Fat;
FirebaseFirestore ffs;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adminloginfragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText name=view.findViewById(R.id.name);
        EditText password =view.findViewById(R.id.adminpassword);

        Button bt=view.findViewById(R.id.adminloginbut);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String adminname=name.getText().toString().trim();
                String adminpassword=password.getText().toString().trim();
                if(TextUtils.isEmpty(adminname)){
                    name.setError("name is required");
                    return;

                }
                if (adminname.length()<4){
                    name.setError("name must be more than 4 character");
                    return;
                }
                if (TextUtils.isEmpty(adminpassword)){
                    password.setError("It's required");

                }
                //////////////
                Fat=FirebaseAuth.getInstance();
                ffs=FirebaseFirestore.getInstance();
                DocumentReference dr=ffs.collection("Admin").document(adminname);
                dr.addSnapshotListener  (new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                        String dpassword=value.getString("password");
                       if(adminpassword.equals(dpassword)){
                            Toast.makeText(getActivity(), "Logged in Successfully.", Toast.LENGTH_SHORT) .show();
                            Intent in =new Intent(getActivity(),Adminmainpage.class);
                            startActivity(in);

                        }
                        else {
                            Toast.makeText(getActivity(), "Password or user name is wrong", Toast.LENGTH_SHORT) .show();


                        }

                    }

                });

                //////////

            }

        });

      ////////
    }
}