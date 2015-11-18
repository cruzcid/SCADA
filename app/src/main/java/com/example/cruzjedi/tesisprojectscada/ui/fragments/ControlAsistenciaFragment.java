package com.example.cruzjedi.tesisprojectscada.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cruzjedi.tesisprojectscada.R;
import com.example.cruzjedi.tesisprojectscada.domain.DatosSalon;
import com.example.cruzjedi.tesisprojectscada.io.model.ScadaApiAdapter;
import com.example.cruzjedi.tesisprojectscada.io.model.ScadaDatosSalonResponse;
import com.example.cruzjedi.tesisprojectscada.ui.fragments.adapter.ScadaDatosSalonAdapter;
import com.example.cruzjedi.tesisprojectscada.ui.fragments.spinneractivities.SpinnerActivity3;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by cruzjedi on 5/11/15.
 */
public class ControlAsistenciaFragment extends Fragment implements Callback<ScadaDatosSalonResponse>{


    private String txtSalon, txtPiso, txtEdificio, spinersText;
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private RecyclerView mScadaDatosSalonList;
    private ScadaDatosSalonAdapter adapter;
    private TextView txtVwShowRoom;
    private View root;
    private FloatingActionButton fab;
    DatosSalon datosSalon;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ScadaDatosSalonAdapter(getActivity());//getActivity() para los fragmentos
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_control_asistencia, container, false);
        mScadaDatosSalonList = (RecyclerView) root.findViewById(R.id.scada_datos_salon_list);
        setupDatosSalonList();
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtVwShowRoom = (TextView) root.findViewById(R.id.txt_show_room);
        handleSpiners();
        handleFloatingActionButton();
        datosSalon = new DatosSalon(txtEdificio, txtPiso, txtSalon);
    }

    @Override
    public void onResume() {
        super.onResume();
        handleTextViews();
        ScadaApiAdapter.getApiService().getScadaDatosSalon(this);

    }

    private void handleFloatingActionButton() {
        fab = (FloatingActionButton) root.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Informacion Enviada", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //Toast.makeText(MainActivity.this, "Has seleccionado" +
                //      String.valueOf(spinner1.getSelectedItem()), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void handleTextViews() {
        txtSalon = spinner1.getSelectedItem().toString();
        txtPiso = spinner4.getSelectedItem().toString();
        txtEdificio = spinner3.getSelectedItem().toString();
        spinersText = txtEdificio + txtPiso + txtSalon;
        txtVwShowRoom.setText(spinersText);
    }

    private void handleSpiners() {
        //spinner1 = (Spinner) spinner1.findViewById(R.id.id_salones_spinner); Format for normal Activities
        spinner1 = (Spinner) root.findViewById(R.id.id_salones_spinner);//Format root.findView... for fragments
        spinner2 = (Spinner) root.findViewById(R.id.id_profes_spinner);
        spinner3 = (Spinner) root.findViewById(R.id.id_edificios_spinner);
        spinner4 = (Spinner) root.findViewById(R.id.id_pisos_spinner);

        spinner1.setOnItemSelectedListener(new SpinnerActivitySalon()); //Salones
        spinner2.setOnItemSelectedListener(new SpinnerActivity3()); //Profes
        spinner3.setOnItemSelectedListener(new SpinnerActivityEdificios()); //Edificios
        spinner4.setOnItemSelectedListener(new SpinnerActivityPiso()); //Pisos

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.salon_array, android.R.layout.simple_spinner_item);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.profesores_array, android.R.layout.simple_spinner_item);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.edificio_array, android.R.layout.simple_spinner_item);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.piso_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);


    }

    private void setupDatosSalonList() {
        mScadaDatosSalonList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mScadaDatosSalonList.setAdapter(adapter);
    }

    @Override
    public void success(ScadaDatosSalonResponse scadaDatosSalonResponse, Response response) {

        adapter.addAll(scadaDatosSalonResponse.getResultadoSalon());

    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }

    public class SpinnerActivitySalon extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            Toast.makeText(parent.getContext(),
                    "Salon : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();
            datosSalon.setSalon(parent.getItemAtPosition(pos).toString());
            txtSalon = parent.getItemAtPosition(pos).toString();
            spinersText = txtEdificio + txtPiso + txtSalon;
            txtVwShowRoom.setText(spinersText);

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    }

    public class SpinnerActivityEdificios extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            Toast.makeText(parent.getContext(),
                    "Edificio : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();
            datosSalon.setEdificio(parent.getItemAtPosition(pos).toString());
            txtEdificio = parent.getItemAtPosition(pos).toString();
            spinersText = txtEdificio + txtPiso + txtSalon;
            txtVwShowRoom.setText(spinersText);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
    }

    public class SpinnerActivityPiso extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            Toast.makeText(parent.getContext(),
                    "Piso : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();
            datosSalon.setPiso(parent.getItemAtPosition(pos).toString());
            txtPiso = parent.getItemAtPosition(pos).toString();
            spinersText = txtEdificio + txtPiso + txtSalon;
            txtVwShowRoom.setText(spinersText);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
    }
}

/*

import java.util.Calendar;
import java.util.Date;

Calcula la hora
* String dia,hora,minuto,horaenviar;
                int horat;



                Calendar cal1=Calendar.getInstance();

                hora=Integer.toString(cal1.get(Calendar.HOUR));
                minuto=Integer.toString(cal1.get(Calendar.MINUTE));
                horat=Integer.parseInt(hora + minuto);
                horaenviar=Integer.toString(horat);
                textView.setText(horaenviar);
*
*
* */
