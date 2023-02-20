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

import java.util.UUID;

public class WaitingForOpponent extends AppCompatActivity {

    //String variables
    String opid="";
    String apid="";

    String gameId="";

    String requeststatus_checker = "";
    String accepted = "accepted";
    String turn = "X";

    //Firebase references

    FirebaseDatabase db;
    DatabaseReference reference,ref;

    //Integer
    int checker = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_for_opponent);
        //Getting the opid from intent
        Bundle b = getIntent().getExtras();
        opid = b.getString("opponent");
        //Toast.makeText(WaitingForOpponent.this,"In the waiting for opponent activity",Toast.LENGTH_LONG).show();

        //Setting up the gameId
        gameId = UUID.randomUUID().toString();
        //Setting the apid
        apid = b.getString("Apid");
        Log.d("apidget","hello"+apid);
        //Firebase instances
        db = FirebaseDatabase.getInstance();
        reference = db.getReference("Player");
        ref = db.getReference("Player");
        reference.child(opid).child("requeststatus").setValue("accepted");
        //Adding the invite
        reference.child(opid).child("invite").setValue(apid);
        reference.child(apid).child("gameId").setValue(gameId);
        reference.child(apid).child("opid").setValue(opid);
        reference.child(opid).child("gameId").setValue(gameId);

        //Toast.makeText(WaitingForOpponent.this,"Invite Successfully Sent, Wait for Acceptance",Toast.LENGTH_SHORT).show();


        //Firebase references
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                 requeststatus_checker= String.valueOf(snapshot.child(apid).child("requeststatus").getValue());
                Log.d("dmart","hello"+requeststatus_checker);
                if(requeststatus_checker.equals("accepted") ) {
                    checker = 1;
                    //Toast.makeText(WaitingForOpponent.this, "Inside the if loop", Toast.LENGTH_LONG).show();
                }
                if (checker == 1) {

                    Intent intent = new Intent(WaitingForOpponent.this, startGameActivity.class);
                    intent.putExtra("gameid",gameId);
                    intent.putExtra("Apid",apid);
                    intent.putExtra("Opid",opid);
                    intent.putExtra("turn",turn);
                    startActivity(intent);
                    finish();
                } else {
                   // Toast.makeText(WaitingForOpponent.this, " arrif Wait for the opponent", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}