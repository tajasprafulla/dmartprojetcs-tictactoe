package com.example.tictactoe.OnlineMode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.tictactoe.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AcceptanceOfInvite extends AppCompatActivity {

    //String variable
    private String opid="";
    private String gameId="";
    private String apid = "";
    private String accepted = "accepted";

    private String requeststatus_checker = "";
    private final String turn = "O";

    //Checking integer
    int checker = 0;



    //Firebase references
    FirebaseDatabase db;
    DatabaseReference reference,ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceptance);
        //getting the opponent id
        Bundle b = getIntent().getExtras();
        opid = b.getString("opponent");
        apid = b.getString("Apid");
        Log.d("opid","hello"+opid);

        db = FirebaseDatabase.getInstance();
        reference = db.getReference("Player");
        reference.child(apid).child("opid").setValue(opid);
        //reference.child(apid).child("gameId").setValue(gameId);
        reference.child(opid).child("requeststatus").setValue("accepted");
        //Another reference
        ref = db.getReference("Player").child(apid);


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                requeststatus_checker= String.valueOf(snapshot.child("requeststatus").getValue());
                Log.d("nameofr","hello"+requeststatus_checker);
                if(requeststatus_checker.equalsIgnoreCase(accepted) )
                {
                    checker = 1;


                }
                if(checker == 1)
                {
                    gameId = String.valueOf(snapshot.child("gameId").getValue());
                    Intent i = new Intent(AcceptanceOfInvite.this, startGameActivity.class);
                    i.putExtra("gameid",gameId);
                    i.putExtra("Apid",apid);
                    i.putExtra("Opid",opid);
                    i.putExtra("turn",turn);
                    startActivity(i);
                    finish();
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}