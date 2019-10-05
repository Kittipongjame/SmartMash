package com.ice.smartmash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Main3Activity extends AppCompatActivity {
    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference SW1,SW2,SW3,SW4,SW5,SW6,TEXT,TEXT1,TEXT2,TEXT3,TEXT4,TEXT5,TEXT6;
    private static final String TAG = "LEDs Control";
    public Button button1,Switch1,button2,Switch2,Switch3,Switch4,Switch5;
    public Integer Value,Value1,Value2,Value3,Value4,Value_refer1,Value_refer2,Value_refer3,Value_refer4,Value_refer5;
   private TextView textView,textView1,textView2,textView3,textView4,textView5,textView6;
//    public EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        firebaseDatabase = FirebaseDatabase.getInstance();

        SW1 =firebaseDatabase.getReference("Status/Fans");
        Switch1 = (Button)findViewById(R.id.button7);
        SW1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Value1 = dataSnapshot.getValue(Integer.class);
                Log.d(TAG, "Value is: " + Value1);
                if (Value1 == 0){
                    Switch1.setText("FANS ON");
                    Switch1.setBackgroundResource(R.color.color_ON);
                    Value_refer1 = 1;
                }else {
                    Switch1.setText("FANS OFF");
                    Switch1.setBackgroundResource(R.color.color_OFF);
                    Value_refer1 = 0;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        Switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SW1.setValue(Value_refer1);
            }
        });
        SW2 =firebaseDatabase.getReference("Status/Pump");
        Switch2 = (Button)findViewById(R.id.button8);
        SW2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Value2 = dataSnapshot.getValue(Integer.class);
                Log.d(TAG, "Value is: " + Value2);
                if (Value2 == 0){
                    Switch2.setText("PUMP ON");
                    Switch2.setBackgroundResource(R.color.color_ON);
                    Value_refer2 = 1;
                }else {
                    Switch2.setText("PUMP OFF");
                    Switch2.setBackgroundResource(R.color.color_OFF);
                    Value_refer2 = 0;
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
                SW2.setValue(Value_refer2);
            }
        });

        SW3 =firebaseDatabase.getReference("Status/SolenoidValve");
        Switch3 = (Button)findViewById(R.id.button10);
        SW3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Value3 = dataSnapshot.getValue(Integer.class);
                Log.d(TAG, "Value is: " + Value3);
                if (Value3 == 0){
                    Switch3.setText("VAVEL ON");
                    Switch3.setBackgroundResource(R.color.color_ON);
                    Value_refer3 = 1;
                }else {
                    Switch3.setText("VAVEL OFF");
                    Switch3.setBackgroundResource(R.color.color_OFF);
                    Value_refer3 = 0;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        Switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SW3.setValue(Value_refer3);
            }
        });

        SW4 =firebaseDatabase.getReference("Status/ice");
        Switch4 = (Button)findViewById(R.id.button11);
        SW4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Value4 = dataSnapshot.getValue(Integer.class);
                Log.d(TAG, "Value is: " + Value4);
                if (Value4 == 0){
                    Switch4.setText("TERMO ON");
                    Switch4.setBackgroundResource(R.color.color_ON);
                    Value_refer4 = 1;
                }else {
                    Switch4.setText("TERMO OFF");
                    Switch4.setBackgroundResource(R.color.color_OFF);
                    Value_refer4 = 0;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        Switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SW4.setValue(Value_refer4);
            }
        });
        Switch5 = (Button)findViewById(R.id.button12);
        Switch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this,Main5Activity.class);
                startActivity(intent);
                finish();
            }
        });

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
                    textView3.setTextColor(getColor(R.color.color_ON));

                }else {
                    textView3.setText("FANS OFF");
                    textView3.setTextColor(getColor(R.color.color_MANUAL));
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
                    textView4.setTextColor(getColor(R.color.color_ON));

                }else {
                    textView4.setText("PUMP OFF");
                    textView4.setTextColor(getColor(R.color.color_MANUAL));
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
                    textView5.setTextColor(getColor(R.color.color_ON));

                }else {
                    textView5.setText("VALVE OFF");
                    textView5.setTextColor(getColor(R.color.color_MANUAL));
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
                    textView6.setTextColor(getColor(R.color.color_ON));

                }else {
                    textView6.setText(" OFF ");
                    textView6.setTextColor(getColor(R.color.color_MANUAL));
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}
