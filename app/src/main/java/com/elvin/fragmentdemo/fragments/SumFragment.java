package com.elvin.fragmentdemo.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.elvin.fragmentdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SumFragment extends Fragment implements View.OnClickListener {

    private Button btnSum;
    private EditText etFirstNumber, etSecondNumber;


    public SumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sum, container, false);
        this.btnSum = view.findViewById(R.id.btnSum);
        this.etFirstNumber = view.findViewById(R.id.etFirstNumber);
        this.etSecondNumber = view.findViewById(R.id.etSecondNumber);
        this.btnSum.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int first = Integer.parseInt(etFirstNumber.getText().toString());
        int second = Integer.parseInt(etSecondNumber.getText().toString());

        Toast.makeText(getActivity(), "Sum is: " + (first + second), Toast.LENGTH_SHORT).show();
    }
}
