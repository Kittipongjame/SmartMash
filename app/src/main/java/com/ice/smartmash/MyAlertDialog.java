package com.ice.smartmash;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class MyAlertDialog {

AlertDialog.Builder objAlertDialog,objAlertDialog2;

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

    public void EnterdoneDialog(Context context){

        objAlertDialog2 = new AlertDialog.Builder(context);
        objAlertDialog2.setIcon(R.drawable.done);
        objAlertDialog2.setTitle("Done");
        objAlertDialog2.setMessage("The value you "+"\n"+" set has been completed. ");
        objAlertDialog2.setCancelable(false);
        objAlertDialog2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });objAlertDialog2.show();
    }

}
