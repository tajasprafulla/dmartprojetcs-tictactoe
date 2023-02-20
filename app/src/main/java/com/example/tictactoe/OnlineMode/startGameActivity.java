package com.example.tictactoe.OnlineMode;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tictactoe.R;
import com.example.tictactoe.ModelClass.playeronline2;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class startGameActivity extends AppCompatActivity {
    //firebase reference
    FirebaseDatabase db;
    DatabaseReference reference, ref;
    //button
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, generate, generate2;


    int checkers = 0, count = 0;
    String turner;
    String i = "1";
    int whoPlayedFirst = 0;

    //textview

    EditText t1, t2, e1;
    //Strings
    String gameId = "";

    String reset = "";
    String apid = "";
    String opid = "";

    String turn = "";
    ArrayList<String> newmap = new ArrayList<>();
    HashMap<String, String> map;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //binding the button
        //disable all the button
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        e1 = findViewById(R.id.answer_edit);
        generate = findViewById(R.id.generate);
        generate2 = findViewById(R.id.generate2);
        //binding the textview
        t1 = findViewById(R.id.textview2);
        t2 = findViewById(R.id.textview3);


        Bundle b = getIntent().getExtras();
        opid = b.getString("Opid");
        apid = b.getString("Apid");
        gameId = b.getString("gameid");
        turn = b.getString("turn");
        Log.d("gameid", "Value is: " + gameId);
        generate2.setEnabled(false);

        db = FirebaseDatabase.getInstance();
        reference = db.getReference("Games");


        ref = db.getReference("Player");
        newmap.add(0, "f");
        newmap.add(1, "");
        for (int j = 2; j < 11; j++) {
            newmap.add(j, "");
        }


        turner = apid;

        playeronline2 p = new playeronline2(map, i, turner, reset);
        reference.child(gameId).setValue(p);
        disableButton();
        map = new HashMap();

        b1.setOnClickListener(view -> {

            i = "1";
            if (b1.getText().toString().isEmpty()) {
                disableButton();

                if (apid.equals(turner)) {
                    turner = opid;
                    database(i);
                    whoPlayedFirst = 1;
                    turnchecker(b1);
                }
                count++;
                check();
            }

        });
        b2.setOnClickListener(view -> {
            // map.put(2,turn);
            i = "2";
            whoPlayedFirst = 1;
            if (b2.getText().toString().isEmpty()) {
                disableButton();

                if (apid.equals(turner)) {
                    turner = opid;
                    database(i);
                    whoPlayedFirst = 1;

                    //database2(i);
                    turnchecker(b2);
                }
                count++;
                check();


            }
        });
        b3.setOnClickListener(view -> {
            // map.put(3,turn);
            i = "3";
            whoPlayedFirst = 1;
            if (b3.getText().toString().isEmpty()) {
                disableButton();

                count++;
                check();
                if (apid.equals(turner)) {
                    turner = opid;
                    database(i);
                    whoPlayedFirst = 1;

                    //database2(i);
                    turnchecker(b3);
                }

                count++;
                check();
            }
        });
        b4.setOnClickListener(view -> {
            i = "4";
            whoPlayedFirst = 1;
            if (b4.getText().toString().isEmpty()) {
                disableButton();

                if (apid.equals(turner)) {
                    turner = opid;
                    database(i);
                    whoPlayedFirst = 1;

                    //database2(i);
                    turnchecker(b4);
                }
                count++;
                check();

            }
        });
        b5.setOnClickListener(view -> {
            // map.put(5,turn);
            i = "5";
            whoPlayedFirst = 1;
            if (b5.getText().toString().isEmpty()) {
                disableButton();

                if (apid.equals(turner)) {
                    turner = opid;
                    database(i);
                    whoPlayedFirst = 1;

                    //database2(i);
                    turnchecker(b5);
                    //disableButton2();
                    //database("1");
                }

                count++;
                check();

            }
        });
        b6.setOnClickListener(view -> {
            //map.put(6,turn);
            i = "6";
            whoPlayedFirst = 1;
            if (b6.getText().toString().isEmpty()) {
                disableButton();

                if (apid.equals(turner)) {
                    turner = opid;
                    database(i);
                    whoPlayedFirst = 1;

                    //database2(i);
                    turnchecker(b6);
                    //disableButton2();
                    //database("1");
                }

                count++;
                check();
            }
        });
        b7.setOnClickListener(view -> {
            // map.put(7,turn);
            i = "7";
            whoPlayedFirst = 1;
            if (b7.getText().toString().isEmpty()) {
                disableButton();


                if (apid.equals(turner)) {
                    turner = opid;
                    database(i);
                    whoPlayedFirst = 1;

                    //database2(i);
                    turnchecker(b7);
                    //disableButton2();
                    //database("1");
                }

                count++;
                check();

            }
        });
        b8.setOnClickListener(view -> {
            //map.put(8,turn);
            i = "8";
            whoPlayedFirst = 1;
            if (b8.getText().toString().isEmpty()) {
                disableButton();


                if (apid.equals(turner)) {
                    turner = opid;
                    database(i);
                    whoPlayedFirst = 1;

                    //database2(i);
                    turnchecker(b8);
                    //disableButton2();
                    //database("1");
                }
                count++;
                check();

            }
        });
        b9.setOnClickListener(view -> {
            //  map.put(9,turn);
            i = "9";
            whoPlayedFirst = 1;
            if (b9.getText().toString().isEmpty()) {
                disableButton();


                if (apid.equals(turner)) {
                    turner = opid;
                    database(i);
                    whoPlayedFirst = 1;

                    //database2(i);
                    turnchecker(b9);
                    //disableButton2();
                    //database("1");
                }
                count++;
                check();

            }
        });
        generate2.setOnClickListener(view -> {
            e1.setText("");
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");
            resetUi();
        });

        generate.setOnClickListener(view -> {

        });

        reference.child(gameId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("LTIC", "OnDatachangeCalled");
                //reference.setValue(p);
                //newmap = (ArrayList<String>) snapshot.child("map").getValue();
                // Object value  = snapshot.child("map").child("1").getValue();
                i = (String) snapshot.child("i").getValue();
                //pid = (String) snapshot.child(turner).getValue();

                if (i != null) {
                    Object value = snapshot.child("map").child(i).getValue();

                    if (value != null) {
                        newmap.set(Integer.parseInt(i), value.toString());
                        count++;
                        check();

                    }
                    Log.d("valueofi", "Value is: " + value);
                    //Log.d("valueofi", "Value is: " + i);
                    Log.d("valueofi", "Value is: " + newmap);
                }

                display();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("LTIC", "OnDatachangeCalled :: onCancelled");

            }
        });


        //exit code
        generate.setOnClickListener(view -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(startGameActivity.this);
            builder1.setTitle("Exit!");
            builder1.setMessage("Want to leave the game?");
            builder1.setCancelable(false);
            builder1.setPositiveButton("YES", (dialogInterface, i) -> {

                Intent intent = new Intent(startGameActivity.this, onlineLoginActivity.class);
                startActivity(intent);

            });
            builder1.setNegativeButton("NO", (dialogInterface, i) -> {

            });
            builder1.show();

        });


    }


    private void turnchecker(Button b4) {
        b4.setText(turn);
        b4.setEnabled(false);

    }

    //For inserting the map values in firebase realtime database
    private void database(String s) {

        map.put(s, turn);
        if (checkers == 0) {

            playeronline2 p = new playeronline2(map, i, turner, reset);
            reference.child(gameId).setValue(p);
        } else {
            Log.d("StartActivity", "database ::else");
        }


    }


    //For setting text into the buttons
    private void display() {
        Log.d("LTIC", "display:: newMap" + newmap.size());
        if (newmap != null && newmap.size() > 0) {


            b1.setText(newmap.get(1));
            b2.setText(newmap.get(2));
            b3.setText(newmap.get(3));
            b4.setText(newmap.get(4));
            b5.setText(newmap.get(5));
            b6.setText(newmap.get(6));
            b7.setText(newmap.get(7));
            b8.setText(newmap.get(8));
            b9.setText(newmap.get(9));
            check();
        }


    }

    //For checking the turns
    private void disableButton() {

        reference.child(gameId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                turner = String.valueOf(snapshot.child("turner").getValue());
                Log.d("turner", "Value is: " + turner);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ref.child(apid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                apid = String.valueOf(snapshot.child("apid").getValue());
                opid = String.valueOf(snapshot.child("opid").getValue());
                Log.d("turner", "apiid: " + apid);
                Log.d("turner", "opid: " + opid);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    //for disabling the back button
    @Override
    public void onBackPressed() {

    }

    //Main logic of checking the winning and draw condition
    private void check() {
        //String and integer variable
        int result = 0;
        String answer = "";
        String b11 = "", b12 = "", b13 = "", b14 = "", b15 = "", b16 = "", b17 = "", b18 = "", b19 = "";


        b11 = b1.getText().toString();
        b12 = b2.getText().toString();
        b13 = b3.getText().toString();
        b14 = b4.getText().toString();
        b15 = b5.getText().toString();
        b16 = b6.getText().toString();
        b17 = b7.getText().toString();
        b18 = b8.getText().toString();
        b19 = b9.getText().toString();


        if (b11.equals("X") && b12.equals("X") && b13.equals("X")) {

            answer = getString(R.string.xwinner);
            result = 1;

        }
        if (b11.equals("O") && b12.equals("O") && b13.equals("O")) {

            answer = getString(R.string.owinner);
            result = 1;

        }
        if (b14.equals("O") && b15.equals("O") && b16.equals("O")) {

            answer = getString(R.string.owinner);
            result = 1;

        }
        if (b14.equals("X") && b15.equals("X") && b16.equals("X")) {

            answer = getString(R.string.xwinner);
            result = 1;

        }
        if (b17.equals("X") && b18.equals("X") && b19.equals("X")) {

            answer = getString(R.string.xwinner);
            result = 1;

        }
        if (b17.equals("O") && b18.equals("O") && b19.equals("O")) {

            answer = getString(R.string.owinner);
            result = 1;

        }
        if (b11.equals("X") && b14.equals("X") && b17.equals("X")) {

            answer = getString(R.string.xwinner);
            result = 1;

        }
        if (b11.equals("O") && b14.equals("O") && b17.equals("O")) {

            answer = getString(R.string.owinner);
            result = 1;
        }

        if (b12.equals("X") && b15.equals("X") && b18.equals("X")) {

            answer = getString(R.string.xwinner);
            result = 1;

        }

        if (b12.equals("O") && b15.equals("O") && b18.equals("O")) {

            answer = getString(R.string.owinner);
            result = 1;

        }

        if (b13.equals("X") && b16.equals("X") && b19.equals("X")) {

            answer = getString(R.string.xwinner);
            result = 1;

        }
        if (b13.equals("O") && b16.equals("O") && b19.equals("O")) {

            answer = getString(R.string.owinner);
            result = 1;

        }

        if (b11.equals("X") && b15.equals("X") && b19.equals("X")) {

            answer = getString(R.string.xwinner);
            result = 1;

        }

        if (b11.equals("O") && b15.equals("O") && b19.equals("O")) {

            answer = getString(R.string.owinner);
            result = 1;

        }

        if (b13.equals("X") && b15.equals("X") && b17.equals("X")) {

            answer = getString(R.string.xwinner);
            result = 1;

        }

        if (b13.equals("O") && b15.equals("O") && b17.equals("O")) {

            answer = getString(R.string.owinner);
            result = 1;

        }

        if (!b11.isEmpty() && result == 0 && !b12.isEmpty() && !b13.isEmpty() && !b14.isEmpty() && !b15.isEmpty() && !b16.isEmpty() && !b17.isEmpty() && !b18.isEmpty() && !b19.isEmpty()) {

            e1.setText("Draw!!!PlayAgain");
            generate2.setEnabled(true);
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            reference.child(gameId).child("reset").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String r = (String) snapshot.getValue();
                    Log.d("string r", "Something" + r);
                    if (!r.isEmpty()) {
                        resetUi();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
        if (result == 1) {
            e1.setText(answer);
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            generate2.setEnabled(true);
            reference.child(gameId).child("reset").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String r = (String) snapshot.getValue();
                    Log.d("string r", "Something" + r);
                    if (!r.isEmpty()) {
                        resetUi();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }


    //For resetting the game again
    private void resetUi() {
        //resetting the game
        reference.child(gameId).child("map").setValue("");
        reference.child(gameId).child("turner").setValue("");
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);

    }


}
