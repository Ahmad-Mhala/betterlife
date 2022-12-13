package com.example.better_life;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class userdataforadmin extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<model> datalist;
    FirebaseFirestore db;
    adapterforadminhistory adapter;
    FirebaseAuth fAuth= FirebaseAuth.getInstance();
//    public String userID = fAuth.getCurrentUser().getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdataforadmin);

        recyclerView=(RecyclerView)findViewById(R.id.rec_viewadm);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<>();

        adapter=new adapterforadminhistory(datalist);
        recyclerView.setAdapter(adapter);

        db=FirebaseFirestore.getInstance();

        db.collection("Donation details").orderBy("timestamp", Query.Direction.DESCENDING).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            model obj=d.toObject(model.class);
                            //datalist.add(obj);
                        //    String Userid = (String) d.get("userid");
                            //(Userid.equals(userID)) {
                                datalist.add(obj);
                           // }
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}