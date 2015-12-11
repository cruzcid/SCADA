package com.example.cruzjedi.tesisprojectscada.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cruzjedi.tesisprojectscada.R;
import com.example.cruzjedi.tesisprojectscada.domain.DatosSalon;
import com.example.cruzjedi.tesisprojectscada.domain.Fecha;
import com.example.cruzjedi.tesisprojectscada.domain.ObtenerHora;
import com.example.cruzjedi.tesisprojectscada.io.model.ScadaApiAdapter;
import com.example.cruzjedi.tesisprojectscada.io.model.ScadaDatosSalonResponse;
import com.example.cruzjedi.tesisprojectscada.ui.fragments.adapter.ScadaDatosSalonAdapter;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by cruzjedi on 5/11/15.
 */
public class MuestraHorarioFragment extends Fragment implements Callback<ScadaDatosSalonResponse>{

    /*
    *@param spinersTextSalon   Texto info de "salon" recuperado por los spinners
    *@param spinner1 Despliega Salones Arreglo
    *@param spinner3 Despliega pisos Arreglo
    *@param spinner4 Despliega edificios Arreglo
     */
    private String txtSalon, txtPiso, txtEdificio, spinersTextSalon, idmateria,idprofesor, periodo, fechaCadena, grupo;
    private Spinner spinner1;
    private Spinner spinner3;
    private Spinner spinner4;
    private RecyclerView mScadaDatosSalonList;
    private ScadaDatosSalonAdapter adapter;
    private TextView txtVwShowRoom;
    private View root;
    private Button btnConsultar;
    private ObtenerHora currentHora;
    private Fecha fechaClass;
    private DatosSalon datosSalon;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ScadaDatosSalonAdapter(getActivity());//getActivity() para los fragmentos
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_muestra_horario, container, false);
        mScadaDatosSalonList = (RecyclerView) root.findViewById(R.id.rv_fmmuestrahorario);
        setupDatosSalonList();

        //Recieve Data from MainActivity
        return root;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtVwShowRoom = (TextView) root.findViewById(R.id.txt_fmmuestrahorario_show_room);
        handleSpiners();
        handleButtons();
        datosSalon = new DatosSalon(txtEdificio, txtPiso, txtSalon);
    }
    @Override
    public void onResume() {
        super.onResume();
        handleTextViews();
        //ScadaApiAdapter.getApiService().getScadaDatosSalon(this);
        //spinersTextSalon
    }
    private void handleButtons(){
        fechaClass = new Fecha();
        currentHora = new ObtenerHora();
        fechaCadena = fechaClass.getYearMonthDay(); //Obtenemos fecha formato 2015-12-22
        btnConsultar = (Button) root.findViewById(R.id.btn_fmmuestrahorario_consultar);
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Hace la peticion Retrofit android.
                //ScadaApiAdapter.getApiService().getScadaDatosSalon(new Callback<ScadaDatosSalonResponse>() {
                //currentHora.getDiaSemana(),Integer.toString(currentHora.horaYminuto())
                ScadaApiAdapter.getSalonDatosPostHorario(spinersTextSalon,
                        currentHora.getDiaSemana(),Integer.toString(currentHora.getHoraYminuto()) , new Callback<ScadaDatosSalonResponse>() {

                            @Override
                            public void success(ScadaDatosSalonResponse scadaDatosSalonResponse, Response response) {
                                adapter.addAll(scadaDatosSalonResponse.getResultadoSalon());
                                //txtVwShowRoom.setText("success");
                                /*txtVwShowRoom.setText(":D Dia: "
                                + currentHora.getDia()+"\nHora: "
                                + currentHora.getHora());*/
                                //txtVwShowRoom.setText( scadaDatosSalonResponse.getResultadoSalon().get(0).getMateria());
                                idmateria = scadaDatosSalonResponse.getResultadoSalon().get(0).getIdMateria();
                                idprofesor = scadaDatosSalonResponse.getResultadoSalon().get(0).getIdProfesor();
                                grupo = scadaDatosSalonResponse.getResultadoSalon().get(0).getGrupo();
                                periodo = "2016-1";

                                txtVwShowRoom.setText("->" + spinersTextSalon +"<-");
                                //txtVwShowRoom.setText();

                                Log.i("idmateria", idmateria);
                                Log.i("idprofesor",idprofesor);
                                Log.i("grupo",grupo);
                                Log.i("fecha",fechaCadena);
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                error.printStackTrace();
                                txtVwShowRoom.setText("Fail");
                            }
                        });
            }
        });
    }
    private void handleTextViews() {
        txtSalon = spinner1.getSelectedItem().toString();
        txtPiso = spinner4.getSelectedItem().toString();
        txtEdificio = spinner3.getSelectedItem().toString();
        spinersTextSalon = txtEdificio + txtPiso + txtSalon;
        txtVwShowRoom.setText(spinersTextSalon);
    }
    private void handleSpiners() {
        //spinner1 = (Spinner) spinner1.findViewById(R.id.id_salones_spinner); Format for normal Activities
        spinner1 = (Spinner) root.findViewById(R.id.id_fmmuestrahorario_salones_spinner);//Format root.findView... for fragments
        spinner3 = (Spinner) root.findViewById(R.id.id_fmmuestrahorario_edificios_spinner);
        spinner4 = (Spinner) root.findViewById(R.id.id_fmmuestrahorario_pisos_spinner);

        spinner1.setOnItemSelectedListener(new SpinnerActivitySalon()); //Salones
        spinner3.setOnItemSelectedListener(new SpinnerActivityEdificios()); //Edificios
        spinner4.setOnItemSelectedListener(new SpinnerActivityPiso()); //Pisos

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.salon_array, android.R.layout.simple_spinner_item);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.edificio_array, android.R.layout.simple_spinner_item);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.piso_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);

    }
    private void setupDatosSalonList() {
        mScadaDatosSalonList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mScadaDatosSalonList.setAdapter(adapter);
    }
    @Override
    public void success(ScadaDatosSalonResponse scadaDatosSalonResponse, Response response) {
        //adapter.addAll(scadaDatosSalonResponse.getResultadoSalon());
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
            spinersTextSalon = txtEdificio + txtPiso + txtSalon;
            txtVwShowRoom.setText(spinersTextSalon);
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
            spinersTextSalon = txtEdificio + txtPiso + txtSalon;
            txtVwShowRoom.setText(spinersTextSalon);
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
            spinersTextSalon = txtEdificio + txtPiso + txtSalon;
            txtVwShowRoom.setText(spinersTextSalon);
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
    }
}