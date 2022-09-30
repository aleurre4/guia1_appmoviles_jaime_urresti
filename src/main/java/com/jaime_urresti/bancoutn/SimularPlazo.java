package com.jaime_urresti.bancoutn;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import com.jaime_urresti.bancoutn.databinding.FragmentConstituirPlazoBinding;
import com.jaime_urresti.bancoutn.databinding.FragmentSimularPlazoBinding;

import java.util.Objects;


public class SimularPlazo extends Fragment implements MainActivity.OnBackPressedListener{


    private FragmentSimularPlazoBinding binding;
    private boolean habilitado = false;
    private String moneda;
    private Double capital;
    private Double tna;
    private Double plazo;
    private Double interesGanado;
    private Double total = 0.0;
    private Double interesAnual;
    private Double tfa;

    public SimularPlazo() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        MainActivity main = (MainActivity) getActivity();
        main.setOnBackPressedListener(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSimularPlazoBinding.inflate(inflater,container,false);

        MainActivity main = (MainActivity) getActivity();
            binding.textSimulador.setText("Simulador de Plazo Fijo en " + main.getPlazo().getMoneda() );
        binding.textSeek.setText("   "+ binding.seekBar.getProgress() + "  Dias");
        binding.textSeek.setTextColor(Color.GRAY);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState){
        super.onViewCreated(view,saveInstanceState);


        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.textSeek.setText("   "+  i + "  Dias");
                binding.textSeek.setTextColor(Color.GRAY);
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.inputCapital.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                calcular();
                return false;
            }
        });
        binding.inputTasaEfectiva.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                calcular();
                return false;
            }
        });
        binding.inputTasaNominal.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                calcular();
                return false;
            }
        });



        binding.buttonConstituir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(habilitado){
                MainActivity main = (MainActivity) getActivity();
                main.onBackPressed();
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Completar todos los campos", Toast.LENGTH_LONG).show();

                }
            }
        });





    }


    @Override
    public void onBackPressed() {
        MainActivity main = (MainActivity) getActivity();
        main.cambiarToolbar("Constituir plazo fijo");
    }


    public void calcular(){
        MainActivity main = (MainActivity) getActivity();
      try {
          capital =  Double.parseDouble(binding.inputCapital.getText().toString());

          tna =  Double.parseDouble(binding.inputTasaNominal.getText().toString());
          tfa = Double.parseDouble(binding.inputTasaEfectiva.getText().toString());
         plazo = Double.valueOf(binding.seekBar.getProgress())/30 ;

          interesGanado =  capital * plazo * (tna/1200);
          interesAnual = capital * tfa/1000;


          total = 0.0;

          total= (capital+interesGanado);

          binding.textPlazo.setText("Plazo: " + binding.seekBar.getProgress() + " dias");
          binding.textCapital.setText("Capital: " + capital);
          binding.textIntereses.setText("Intereses ganados: " + interesGanado);
          binding.textTotal.setText("Monto total: " + total);
          binding.textAnual.setText("Monto total anual: " + (interesAnual+capital) );
          habilitado = true;
          main.getPlazo().setDias(binding.seekBar.getProgress());
          main.getPlazo().setCapital(capital);
          main.getPlazo().setHabilitado(true);


      }catch (Exception e){

          binding.textPlazo.setText("Plazo: " );
          binding.textCapital.setText("Capital: ");
          binding.textIntereses.setText("Intereses ganados: ");
          binding.textTotal.setText("Monto total: " );
          binding.textAnual.setText("Monto total anual:" );
          habilitado = false;
          main.getPlazo().setHabilitado(false);
      }


    }

}