package com.digitalhouse.digitalhousefoods.views;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digitalhouse.digitalhousefoods.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardapioFragment extends Fragment {


    public CardapioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cardapio, container, false);
    }

}
