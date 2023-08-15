package com.example.homework_3m_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainFragment extends Fragment {
    private TextView tv_counter;
    private Button btn_plus;
    private Button btn_minus;
    private int counter;
    private Button btn_send;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        counter = 0;
        btn_plus.setOnClickListener(v -> {
            counter++;
            tv_counter.setText(String.valueOf(counter));
        });
        btn_minus.setOnClickListener(v -> {
            counter--;
            tv_counter.setText(String.valueOf(counter));
        });
        btn_send.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("counter", String.valueOf(counter));
            SecondFragment secondFragment = new SecondFragment();
            secondFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    secondFragment).addToBackStack(null).commit();
        });
    }

    private void init() {
        tv_counter = requireActivity().findViewById(R.id.tv_counter);
        btn_plus = requireActivity().findViewById(R.id.btn_plus);
        btn_minus = requireActivity().findViewById(R.id.btn_minus);
        btn_send = requireActivity().findViewById(R.id.btn_send);

    }

}