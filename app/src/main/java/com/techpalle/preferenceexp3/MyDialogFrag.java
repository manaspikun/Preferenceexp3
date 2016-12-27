package com.techpalle.sharedprefrencelistviewassignment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.techpalle.preferenceexp3.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogFrag extends android.support.v4.app.DialogFragment{


    public MyDialogFrag() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Error");
        builder.setMessage("Please fill all details");
        builder.setPositiveButton("OK", null);
        d = builder.create();
        return d;
    }
}

