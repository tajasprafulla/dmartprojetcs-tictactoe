package com.example.tictactoe.OnlineMode;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tictactoe.R;
import com.example.tictactoe.ModelClass.onlineLoginModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class onlineLoginActivity extends AppCompatActivity {


    //String variables
    private String name = "";
    private String phonenumber = "";
    private String status= "";
    private String apid = "";
    private String opid = "" ;
    private String gameId = "";
    private String requeststatus="";



    //Widgets for validation
    Button save;
    EditText PhoneInput, NameInput;
    boolean isAllFieldsChecked = false;

    //Firebase references
    FirebaseDatabase db;
    DatabaseReference reference,ref;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_login_start);
        //Finding view by ids
        NameInput = findViewById(R.id.NameInput);
        PhoneInput = findViewById(R.id.PhoneInput);
        save = findViewById(R.id.moveahead);


        //Firebase instances
        db = FirebaseDatabase.getInstance();
        reference = db.getReference("Player");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAllFieldsChecked = CheckAllFields();

                if(isAllFieldsChecked == true)
                {
                    insertIntoRealtime();
                }



            }
        });
    }


    //Inserting data into the realtime database
    private void insertIntoRealtime() {
        //Setting the string variables
        name = NameInput.getText().toString();
        phonenumber = PhoneInput.getText().toString();
        apid = name+phonenumber;
        status = "online";

        onlineLoginModel onlineloginmodel = new onlineLoginModel(status,apid,opid,gameId,requeststatus);
        reference.child(apid).setValue(onlineloginmodel);

        //Handler
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextactivity();
            }
        }, 1000);


    }

    private void nextactivity() {
        Intent i = new Intent(onlineLoginActivity.this, onlineListOfOnlinePlayer.class);
        i.putExtra("Apid",apid);
        startActivity(i);
    }


    //Validation function
    private boolean CheckAllFields() {
        if (NameInput.length() == 0) {
            NameInput.setError("Name is required");
            return false;
        } else if (NameInput.length() < 3) {
            NameInput.setError("Name must be minimum 3 characters");
            return false;
        }

        if (PhoneInput.length() == 0) {
            PhoneInput.setError("Phone Number is required");
            return false;
        } else if (PhoneInput.length() > 10 || PhoneInput.length() < 10) {
            PhoneInput.setError("Phone Number must be 10 Digits");
            return false;
        }
        // after all validation return true.
        return true;

    }
}