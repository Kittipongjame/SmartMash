package com.ice.smartmash;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class MyAlertDialog {

AlertDialog.Builder objAlertDialog;

    public void HavespaceDialog(Context context){

        objAlertDialog = new AlertDialog.Builder(context);
        objAlertDialog.setIcon(R.drawable.x);
        objAlertDialog.setTitle("Error !!");
        objAlertDialog.setMessage("Have space "+"\n"+" Please enter number ");
        objAlertDialog.setCancelable(false);
        objAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });objAlertDialog.show();
    }

}
