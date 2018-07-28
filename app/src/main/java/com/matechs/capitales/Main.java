package com.matechs.capitales;

/**
 * Created by giovannimacbookpro on 27/09/17.
 */

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Main extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spPais;
    Spinner spCapital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spPais = (Spinner) findViewById(R.id.sp_pais);
        spCapital = (Spinner) findViewById(R.id.sp_capital);
        loadSpinnerCapitales();
    }

    private void loadSpinnerCapitales() {

        // Crea un ArrayAdapter usando un string array y un  spinner default
        // layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.paises, android.R.layout.simple_spinner_item);
        // Especifica el diseño a utilizar cuando aparezca la lista de opciones
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // se aplica el adapatador al spinner
        this.spPais.setAdapter(adapter);

        // esta actividad implementa el AdapterView.OnItemSelectedListener
        this.spPais.setOnItemSelectedListener(this);
        this.spCapital.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
        switch (parent.getId()) {
            case R.id.sp_pais:

                // Recupera un array
                TypedArray arrayLocalidades = getResources().obtainTypedArray(
                        R.array.array_pais_capital);
                CharSequence[] localidades = arrayLocalidades.getTextArray(pos);
                arrayLocalidades.recycle();

                // Crea un ArrayAdapter utilizando la matriz de cadenas y un valor predeterminado
                // spinner layout
                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(
                        this, android.R.layout.simple_spinner_item,
                        android.R.id.text1, localidades);

                // especifica el diseño a utilizar cuando aparezca la lista de opciones
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // se aplica el adapatador al spinner
                this.spCapital.setAdapter(adapter);

                break;

            case R.id.sp_capital:

                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //Método de devolución de llamada a invocarse cuando la selección desaparezca de esta
        // vista. La selección puede desaparecer por ejemplo cuando
        // activado o cuando el adaptador se vacía.
    }

}