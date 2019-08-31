package com.ice.smartmash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class Main2Activity extends AppCompatActivity {
    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference TEXT,TEXT1,TEXT2,TEXT3,TEXT4,TEXT5,TEXT6;
    private static final String TAG = "LEDs Control";
    public Button button1,Switch2,button2,Switch1;
    public String Value,Value1,Value2,Value3;
    private TextView textView,textView1,textView2,textView3,textView4,textView5,textView6;
    public EditText editText1,editText2;
    MyAlertDialog objMyAlertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        firebaseDatabase = FirebaseDatabase.getInstance();

        TEXT1 = firebaseDatabase.getReference("SendTemp");
        TEXT2 = firebaseDatabase.getReference("SendHum");
        TEXT3 = firebaseDatabase.getReference("SendTemp");
        TEXT4 = firebaseDatabase.getReference("SendHum");



        button1 = (Button)findViewById(R.id.button4);
        button2 = (Button)findViewById(R.id.button5);

        editText1 = (EditText)findViewById(R.id.editText4);
        editText2 = (EditText)findViewById(R.id.editText3);


        TEXT1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //  Value2 = dataSnapshot.getValue(Integer.class)
                Value = editText1.getText().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        TEXT2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Value1 = editText2.getText().toString();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    try {
                        Value = editText1.getText().toString().trim();
                        Value1 = editText2.getText().toString().trim();
                        if (Value.equals("") || Value1.equals("")) {

                            objMyAlertDialog = new MyAlertDialog();
                            objMyAlertDialog.HavespaceDialog(Main2Activity.this);
                        } else {


                            TEXT1.child("SendTemp").setValue(Value);
                            TEXT2.child("SendHum").setValue(Value1);

                        }


                    } catch (Exception e) {
                    }

            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText(" ");
                editText2.setText(" ");

            }

        });
        textView1 = (TextView)findViewById(R.id.textView24);
        TEXT3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                String tx3 = String.valueOf(map.get("SendTemp"));
                textView1.setText(tx3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        textView2 = (TextView)findViewById(R.id.textView28);
        TEXT4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                String tx3 = String.valueOf(map.get("SendHum"));
                textView2.setText(tx3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Switch1 = (Button)findViewById(R.id.button6);
        Switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);

            }
        });

        Switch2 = (Button)findViewById(R.id.button3);
        Switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
