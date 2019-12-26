package com.shagi.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class viewstudent extends AppCompatActivity {

    EditText e1,e2,e3,e4;
    Button b1;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstudent);

        reference= FirebaseDatabase.getInstance().getReference().child("Students");

        e1=(EditText)findViewById(R.id.searchVal);
        e2=(EditText)findViewById(R.id.name);
        e3=(EditText)findViewById(R.id.admission);
        e4=(EditText)findViewById(R.id.college);
        b1=(Button)findViewById(R.id.Bsearch);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String admision=e1.getText().toString();
                Query query=reference.orderByChild("ad_no").equalTo(admision);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot studentdatasnapshot:dataSnapshot.getChildren())
                        {
                            constructor studentModel=studentdatasnapshot.getValue(constructor.class);
                            String nme=studentModel.name;
                            String roll=studentModel.roll;
                            String coll=studentModel.clg;

                            e2.setText(nme);
                            e3.setText(roll);
                            e4.setText(coll);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
