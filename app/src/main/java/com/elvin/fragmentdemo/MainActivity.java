package com.elvin.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.elvin.fragmentdemo.fragments.FirstFragment;
import com.elvin.fragmentdemo.fragments.SecondFragment;
import com.elvin.fragmentdemo.fragments.SumFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnFragment, btnSumFragment;
    boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnFragment = findViewById(R.id.btnFragment);
        this.btnSumFragment = findViewById(R.id.btnSumFragment);
        this.btnFragment.setOnClickListener(this);
        this.btnSumFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (v.getId()) {
            case R.id.btnFragment:
                fragment = status ? new FirstFragment() : new SecondFragment();
                btnFragment.setText(String.format("Load %s Fragment", status ? "First" : "Second"));
                status = !status;
                break;
            case R.id.btnSumFragment:
                fragment = new SumFragment();
                break;
        }

        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.commit();
    }
}
