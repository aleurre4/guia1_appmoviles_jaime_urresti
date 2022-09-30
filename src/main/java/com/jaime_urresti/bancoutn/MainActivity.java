package com.jaime_urresti.bancoutn;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.jaime_urresti.bancoutn.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Plazo plazo;

    public Plazo getPlazo() {
        return plazo;
    }

    public interface OnBackPressedListener{
        void onBackPressed();
    }
    private OnBackPressedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        plazo = new Plazo();
        setContentView(view);



    }
    @Override
    public void onBackPressed() {
        if(listener != null)  listener.onBackPressed();
        super.onBackPressed();
    }

    public void setOnBackPressedListener(OnBackPressedListener listener){
        this.listener = listener;
    }



    public void cambiarToolbar(String valor){
       binding.toolbar.setTitle(valor);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}