package br.com.aula.text;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void calcular (View view){
        TextInputEditText campoNome = findViewById(R.id.textLayoutNome);
        TextInputEditText campoPeso = findViewById(R.id.textLayoutPeso);
        TextInputEditText campoAltura = findViewById(R.id.textLayoutAltura);

        TextView resultado1 = findViewById(R.id.textoResultado1);
        TextView resultado2 = findViewById(R.id.textoResultado2);

        String peso = campoPeso.getText().toString();
        String altura = campoAltura.getText().toString();

        Double numPeso = Double.parseDouble(peso);
        Double numAltura = Double.parseDouble(altura);
        Double numImc = numPeso/(numAltura*numAltura);

        String imc = String.valueOf(numImc);

        DecimalFormat df = new DecimalFormat(("#.##"));
        imc = df.format(numImc);

        resultado1.setText(imc);


    }

    public void limpar (View view){
        TextInputEditText campoNome = findViewById(R.id.textLayoutNome);
        TextInputEditText campoPeso = findViewById(R.id.textLayoutPeso);
        TextInputEditText campoAltura = findViewById(R.id.textLayoutAltura);

        TextView resultado1 = findViewById(R.id.textoResultado1);
        TextView resultado2 = findViewById(R.id.textoResultado2);

        campoNome.setText("");
        campoPeso.setText("");
        campoAltura.setText("");
        resultado1.setText("");
        resultado2.setText("");


    }

}