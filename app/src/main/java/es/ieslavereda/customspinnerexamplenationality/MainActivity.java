package es.ieslavereda.customspinnerexamplenationality;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonAdd;
    private EditText name;
    private EditText surname;
    private ImageView icon;
    private ImageView image;
    private Spinner spinner;
    private TextView nationality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nationality = findViewById(R.id.nationality);
        spinner = findViewById(R.id.spinner);
        image = findViewById(R.id.image);
        icon = findViewById(R.id.icon);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        buttonAdd = findViewById(R.id.buttonAdd);



//        spinner.setAdapter(new ArrayAdapter<>(
//                this, android.R.layout.simple_spinner_item,
//                Nacion.values()
//        ));

        spinner.setAdapter(new MyOwnAdapter<>(this,R.layout.custom_spinner_item,
                Nacion.values()));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                image.setImageResource(((Listable)adapterView.getSelectedItem()).getDrawableImage());
                icon.setImageResource(((Listable)adapterView.getSelectedItem()).getDrawableSymbol());
                nationality.setText(((Listable)adapterView.getSelectedItem()).getDescription());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}