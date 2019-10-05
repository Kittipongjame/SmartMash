package com.ice.smartmash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main5Activity extends AppCompatActivity {
    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference MODE;
    private static final String TAG = "LEDs Control";
    public Button Switch1,Switch2;
    public ImageView imv1, imv2;
    public Integer Value,Value1,Value2,Value3,Value_refer1;
    private TextView textView,textView1,textView2,textView3,textView4,textView5,textView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        firebaseDatabase = FirebaseDatabase.getInstance();
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
        imv1 = (ImageView)findViewById(R.id.imageView6);
        imv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main5Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imv2 = (ImageView)findViewById(R.id.imageView7);
        imv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main5Activity.this,Main3Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
