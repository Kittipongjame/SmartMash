package com.ice.smartmash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference TEXT,TEXT1,TEXT2,TEXT3,TEXT4,TEXT5,TEXT6,MODE;
    private static final String TAG = "LEDs Control";
    public Button Switch1,Switch2;
    public Integer Value,Value1,Value2,Value3,Value_refer1;
    private TextView textView,textView1,textView2,textView3,textView4,textView5,textView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase = FirebaseDatabase.getInstance();

        TEXT = firebaseDatabase.getReference();
        textView = (TextView)findViewById(R.id.textView16);
        TEXT.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                String tx1 = String.valueOf(map.get("Humidity"));
                textView.setText(tx1);

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        TEXT1 = firebaseDatabase.getReference();
        textView1 = (TextView)findViewById(R.id.textView8);
        TEXT1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                String tx2 = String.valueOf(map.get("Temperature"));
                textView1.setText(tx2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        TEXT2 = firebaseDatabase.getReference();
        textView2 = (TextView)findViewById(R.id.textView3);
        TEXT2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                String tx3 = String.valueOf(map.get("Ultrasonic"));
                textView2.setText(tx3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        /*----------------------------------------*/
        TEXT3 = firebaseDatabase.getReference("Status/Fans");
        textView3 = (TextView)findViewById(R.id.textView5);
        TEXT3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Map map = (Map) dataSnapshot.getValue();
                Value = dataSnapshot.getValue(Integer.class);
                if (Value==0){
                    textView3.setText("FANS ON");

                }else {
                    textView3.setText("FANS OFF");

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        TEXT4 = firebaseDatabase.getReference("Status/Pump");
        textView4 = (TextView)findViewById(R.id.textView12);
        TEXT4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Map map = (Map) dataSnapshot.getValue();
                Value1 = dataSnapshot.getValue(Integer.class);
                if (Value1==0){
                    textView4.setText("PUMP ON");

                }else {
                    textView4.setText("PUMP OFF");

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        TEXT5 = firebaseDatabase.getReference("Status/SolenoidValve");
        textView5 = (TextView)findViewById(R.id.textView14);
        TEXT5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Map map = (Map) dataSnapshot.getValue();
                Value2 = dataSnapshot.getValue(Integer.class);
                if (Value2==0){
                    textView5.setText("VALVE ON");

                }else {
                    textView5.setText("VALVE OFF");

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        TEXT6 = firebaseDatabase.getReference("Status/ice");
        textView6 = (TextView)findViewById(R.id.textView13);
        TEXT6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Map map = (Map) dataSnapshot.getValue();
                Value3 = dataSnapshot.getValue(Integer.class);
                if (Value3==0){
                    textView6.setText(" ON ");

                }else {
                    textView6.setText(" OFF ");

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Switch1 = (Button)findViewById(R.id.button2);
        Switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
               startActivity(intent);

            }
        });
        MODE = firebaseDatabase.getReference("Status/MODE");
        Switch2 = (Button) findViewById(R.id.button);
        MODE.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Value = dataSnapshot.getValue(Integer.class);
                Log.d(TAG, "Value is: " + Value);
                if (Value==1){
                    Switch2.setText("AUTO");
                    Switch2.setBackgroundResource(R.color.color_AUTO);
                    Value_refer1 = 0;

                }else {
                    Switch2.setText("MANUAL");
                    Switch2.setBackgroundResource(R.color.color_MANUAL);
                    Value_refer1 = 1;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        Switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MODE.setValue(Value_refer1);
            }
        });
    }
}
