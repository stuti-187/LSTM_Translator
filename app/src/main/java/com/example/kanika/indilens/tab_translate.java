package com.example.kanika.indilens;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class tab_translate extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_translate, container, false);

        final EditText engText = (EditText)rootView.findViewById(R.id.engText);
        final TextView hinText = (TextView)rootView.findViewById(R.id.hinText);
        Button transbtn = (Button)rootView.findViewById(R.id.transbtn);

        transbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hinText.setText(engText.getText().toString());
            }
        });


        return rootView;
    }

}
