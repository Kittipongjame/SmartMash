package com.ice.smartmash;

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

public class Main3Activity extends AppCompatActivity {
    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference SW1,SW2,SW3,SW4,SW5,SW6;
    private static final String TAG = "LEDs Control";
    public Button button1,Switch1,button2,Switch2,Switch3,Switch4,Switch5;
    public Integer Value1,Value2,Value3,Value4,Value_refer1,Value_refer2,Value_refer3,Value_refer4,Value_refer5;
//    private TextView textView,textView1,textView2,textView3,textView4,textView5,textView6;
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
                Intent intent = new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(intent);

            }
        });

    }
}
