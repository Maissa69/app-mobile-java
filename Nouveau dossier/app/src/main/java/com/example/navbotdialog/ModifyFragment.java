package com.example.navbotdialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class ModifyFragment extends Fragment {



    public ModifyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_modify, container, false);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modify, container, false);

        // Tu ajoute les fonctions pour recupere les donees modifiers dans cette class
        return view;
    }
}