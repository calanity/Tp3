package com.example.a41587805.tp3;

import android.app.Dialog;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 41587805 on 21/6/2016.
 */

public class UserNameDialog extends DialogFragment {

    MainActivity ma;

    public UserNameDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_name_fragment, container);

        ma = (MainActivity) getActivity();
        final EditText userName = (EditText) view.findViewById(R.id.txt_your_name);
        userName.setText(ma.getUserName());

        Button b = (Button) view.findViewById(R.id.confirmar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Click","OK");
                ma.setUserName(userName.getText().toString());
                dismiss();
            }
        });
        getDialog().setTitle("Ingrese nombre de usuario");

        return view;
    }

}
