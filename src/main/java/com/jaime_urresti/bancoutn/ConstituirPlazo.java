package com.jaime_urresti.bancoutn;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.jaime_urresti.bancoutn.databinding.FragmentConstituirPlazoBinding;


public class ConstituirPlazo extends Fragment {

       private FragmentConstituirPlazoBinding binding;

       private String[] monedas = {"PESOS" , "DOLARES" , "EUROS" };



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("ON CREATE CONSTITUIR");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

     binding = FragmentConstituirPlazoBinding.inflate(inflater,container,false);
        System.out.println("ON CREATE VIEW");
     return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState){
      super.onViewCreated(view,saveInstanceState);

        MainActivity main = (MainActivity) getActivity();

      binding.simularButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                main.getPlazo().setNombre(binding.editTextTextPersonName.getText().toString());
                main.getPlazo().setApellido(binding.editTextTextPersonLastName.getText().toString());
                main.getPlazo().setMoneda(binding.spinnerMoneda.getSelectedItem().toString());
                main.cambiarToolbar("Simular plazo fijo");
                NavHostFragment.findNavController(ConstituirPlazo.this).navigate(R.id.action_constituirPlazo_to_simularPlazo);

            }
        });


        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(getActivity().getApplicationContext(),
                  R.layout.item_spinner, monedas );

        adapter.setDropDownViewResource(R.layout.spinner_dropdownn_item);
        binding.spinnerMoneda.setAdapter(adapter);


        if(main.getPlazo().isHabilitado()){
            binding.buttonConstituir.setEnabled(true);
            binding.buttonConstituir.setBackgroundColor(Color.blue(1));
            binding.buttonConstituir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String mensaje =  "tu plazo de fijo de " + main.getPlazo().getCapital()
                            +" " +main.getPlazo().getMoneda()
                            +  " por " + main.getPlazo().getDias() + " dias ha sido constituido!";
                    String titulo = "Felicidades "  + main.getPlazo().getNombre() + " "
                                       + main.getPlazo().getApellido() + "!";
                    alerta(mensaje,titulo);
                }
            });


        }else{

            binding.buttonConstituir.setEnabled(false);
            binding.buttonConstituir.setBackgroundColor(Color.GRAY);


        }



    }

               public void alerta(String cadena, String titulo) {

                   try{
                       AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());

                       builder.setTitle(titulo);
                       builder.setMessage(cadena);

                       builder.setPositiveButton("Joya maestro",null);
                   builder.create();
                   builder.show();
               }catch (Exception e){
                       System.out.println(e.getMessage());
                   }

    }

}