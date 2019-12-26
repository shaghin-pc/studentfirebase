package com.shagi.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addstudent extends AppCompatActivity {

    EditText e1,e2,e3,e4;
    Button b1;
    String name,rollno,admission,college;
    constructor c1;
    ProgressBar p;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);
        c1=new constructor();

        e1=(EditText)findViewById(R.id.Ename);
        e2=(EditText)findViewById(R.id.Eroll_no);
        e3=(EditText)findViewById(R.id.Eadmission_no);
        e4=(EditText)findViewById(R.id.Ecollege);
        p=(ProgressBar)findViewById(R.id.p);
        b1=(Button)findViewById(R.id.Bsubmit);
        reference= FirebaseDatabase.getInstance().getReference().child("Students");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.setVisibility(View.VISIBLE);
                name=e1.getText().toString();
                rollno=e2.getText().toString();
                admission=e3.getText().toString();
                college=e4.getText().toString();

                c1.setName(name);
                c1.setRoll(rollno);
                c1.setAd_no(admission);
                c1.setClg(college);
                reference.push().setValue(c1);
                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");



            }
        });


    }
}
