package com.example.tictactoe.OnlineMode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tictactoe.R;
import com.example.tictactoe.OnlineAdapter.onlinePlayerListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class onlineListOfOnlinePlayer extends AppCompatActivity {

    //firebase reference
    FirebaseDatabase db;
    DatabaseReference reference;
    DatabaseReference reference1;

    //String
    String olistofplayerarray[];
    ArrayList<String> olistofplayer = new ArrayList<>();
    ArrayList<String> olistofplayer1 = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    List<String> fruitsList;
    List<String> fruitsList1;
    String apid = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olist_of_online_player);

        // getting the firebase reference
        db = FirebaseDatabase.getInstance();
        reference = db.getReference("Player");
        reference1 = db.getReference("Player");

        //Getting the apid using bundles
        Bundle b = getIntent().getExtras();
        apid = b.getString("Apid");

        //recycler view
        fruitsList = new ArrayList<String>();
        fruitsList1 = new ArrayList<String>();
        recyclerView = findViewById(R.id.fruit_recycler);
        recyclerView1 = findViewById(R.id.recyclerview2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView1.setHasFixedSize(true);

        //Listener ondatachanged
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                recyclerView.removeAllViewsInLayout();
                fruitsList.clear();
                for (DataSnapshot StatusSnapshot : snapshot.getChildren()) {
                    String s = String.valueOf(StatusSnapshot.child("status").getValue());

                    if (s.equals("online")) {
                        if (s != null) {
                            olistofplayer.add(StatusSnapshot.getKey());
                            fruitsList.add(StatusSnapshot.getKey());
                        }
                        Log.d("aaabbbb", "id: " + fruitsList);

                    }
                }

                Log.d("aaa", "id: " + olistofplayer);

                onlinePlayerListAdapter adapter = new onlinePlayerListAdapter(fruitsList, apid, new onlinePlayerListAdapter.ClickListener() {
                    @Override
                    public void onItemClick(int position, View v) {
                        // Toast.makeText(oListOfOnlinePlayer.this,"click on item: "+fruitsList.get(position),Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(onlineListOfOnlinePlayer.this, WaitingForOpponent.class);
                        intent.putExtra("opponent", fruitsList.get(position));
                        intent.putExtra("Apid", apid);
                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(int position, View v) {

                    }
                });
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(onlineListOfOnlinePlayer.this, "Can't get the List of online.", Toast.LENGTH_SHORT).show();
            }
        });


        //listener for acceptance for invite
        reference1.child(apid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                recyclerView1.removeAllViewsInLayout();
                fruitsList1.clear();
                String s = String.valueOf(snapshot.child("invite").getValue());
                Log.d("arif1", "arif: " + s); //log


                if (s != null && s.equals("null") == false && s.isEmpty() == false) {
                    olistofplayer1.add(s);
                    fruitsList1.add(s);
                }
                Log.d("invite", "id: " + olistofplayer1);

                onlinePlayerListAdapter adapter1 = new onlinePlayerListAdapter(fruitsList1, apid, new onlinePlayerListAdapter.ClickListener() {
                    @Override
                    public void onItemClick(int position, View v) {
                        Toast.makeText(onlineListOfOnlinePlayer.this, "click on item: " + fruitsList1.get(position), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(onlineListOfOnlinePlayer.this, AcceptanceOfInvite.class);
                        intent.putExtra("opponent", fruitsList1.get(position));
                        intent.putExtra("Apid", apid);
                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(int position, View v) {

                    }
                });
                recyclerView1.setAdapter(adapter1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(onlineListOfOnlinePlayer.this, "Can't get the List of online.", Toast.LENGTH_SHORT).show();
            }
        });


    }


}