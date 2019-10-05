package com.ice.smartmash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

public class Main4Activity extends AppCompatActivity {
    Pinview pinview;
    static int pass;
    String pin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        pinview = (Pinview)findViewById(R.id.pinview);
        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                //Toast.makeText(getApplicationContext(),pinview.getValue(),Toast.LENGTH_SHORT).show();
                pin = pinview.getValue();
                pass = Integer.parseInt(pin);


                // Add this following code.. it works
                if (pass == 54321) {
                    Toast.makeText(getApplicationContext(),"Password Pass",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Main4Activity.this,Main5Activity.class);
                    startActivity(intent);
                    finish();
                    closeKeyboard();
                }
                else {

                    Toast toast = Toast.makeText (getApplicationContext() , "Password Fail", Toast.LENGTH_LONG );
                    toast.show ();

                    closeKeyboard();
                }
            }
        });


    }
    private void  closeKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}
