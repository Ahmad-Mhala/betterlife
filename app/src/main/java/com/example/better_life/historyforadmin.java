package com.example.better_life;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.Date;

public class historyforadmin extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookref = db.collection("Donation details");
    public static final String TAG = "TAG";
    private TextView textViewData;
    FirebaseAuth fAuth;

    private FirebaseFirestore cloudstorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historyforadmin);
        fAuth= FirebaseAuth.getInstance();
        textViewData=findViewById(R.id.dataadmin);

        loadNotes();
    }

    public void loadNotes() {
        this.cloudstorage = FirebaseFirestore.getInstance();
        this.fAuth=FirebaseAuth.getInstance();
        notebookref.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            String data="";

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                //  Log.d(TAG, document.getId() + " => " + document.getData());//
                                //if (document.contains("name") && document.contains("description") && document.contains("type") && document.contains("userid")) {
                                        String f=document.getId();
                                String name = (String) document.get("name");
                                String type = (String) document.get("type");
                                String description = (String) document.get("description");
                                // String Userid = (String) document.get("userid");
                                //      String userID = fAuth.getCurrentUser().getUid();
                             //     String ts = ((Timestamp) document.get("timestamp")).toString();
                                //String dateandtime=String.valueOf(ts);
                                //  String dateandtime=String.valueOf(ts.toDate());
                                //String dateandtime = ts.toString();
                                //Date da=new Date(document.get());
                             //   String date=ts.toString();
                                String id=(String) document.get("userid");
                                String phonenumber=(String) document.get("phone");
//                                Timestamp dat= (Timestamp) document.get("timestamp");
                                //////////////
                                //////////////

                                data += "Name: " + name + "\nUser Type: " + type + "\nDescription: " + description+"\nphone number: "+phonenumber+"\nuser ID "+id+"\ndonation ID"+f+"\n\n\n";
                                //data += "Name: " + name + "\nUser Type: " + type + "\nDescription: " + description + "\n";

                                textViewData.setText(data);

                            }
                        }}
                    // textViewData.setText(data);



                });
    }
}