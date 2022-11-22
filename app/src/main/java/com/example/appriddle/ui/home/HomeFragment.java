package com.example.appriddle.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.appriddle.MainActivity;
import com.example.appriddle.R;

import com.example.appriddle.SplashActivity;
import com.example.appriddle.SudokuActivity;
import com.example.appriddle.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    Button btnDificultad;
    Button btnPartida;
    int ctn =0;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        btnDificultad = root.findViewById(R.id.btnDificultad);
        btnDificultad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ctn==0){
                    btnDificultad.setText(R.string.dificultadMedia);
                    ctn+=1;
                }else if(ctn==1){
                    btnDificultad.setText(R.string.dificultadExperto);
                    ctn+=1;
                }else if(ctn==2){
                    btnDificultad.setText(R.string.dificultadDios);
                    ctn+=1;
                }else if(ctn==3){
                    btnDificultad.setText(R.string.dificultadFacil);
                    ctn=0;
                }
            }

        });

        btnPartida= root.findViewById(R.id.btnPartida);
        btnPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              View v = inflater.inflate(R.layout.fragment_home,container,false);

              Intent intent = new Intent(getActivity(),SudokuActivity.class);
              startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}