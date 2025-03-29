package br.com.fecapccp.calculadoraimcni1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CalculoIMCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imcactivity);

        EditText editTextPeso = findViewById(R.id.editTextPeso);
        EditText editTextAltura = findViewById(R.id.editTextAltura);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        Button buttonLimpar = findViewById(R.id.buttonLimpar);
        Button buttonFechar = findViewById(R.id.buttonFechar);

        buttonCalcular.setOnClickListener(v -> {
            try {
                double peso = Double.parseDouble(editTextPeso.getText().toString());
                double altura = Double.parseDouble(editTextAltura.getText().toString());
                double imc = peso / (altura * altura);

                Intent intent;

                if (imc < 18.5) {
                    intent = new Intent(CalculoIMCActivity.this, AbaixoDoPesoActivity.class);
                } else if (imc >= 18.5 && imc < 25) {
                    intent = new Intent(CalculoIMCActivity.this, PesoNormalActivity.class);
                } else if (imc >= 25 && imc < 30) {
                    intent = new Intent(CalculoIMCActivity.this, SobrepesoActivity.class);
                } else if (imc >= 30 && imc < 35) {
                    intent = new Intent(CalculoIMCActivity.this, Obesidade1Activity.class);
                } else if (imc >= 35 && imc < 40) {
                    intent = new Intent(CalculoIMCActivity.this, Obesidade2Activity.class);
                } else {
                    intent = new Intent(CalculoIMCActivity.this, Obesidade3Activity.class);
                }

                // Passa os valores para a próxima Activity
                intent.putExtra("peso", peso);
                intent.putExtra("altura", altura);
                intent.putExtra("imc", imc);
                startActivity(intent);

            } catch (NumberFormatException e) {
                Toast.makeText(CalculoIMCActivity.this, "Por favor, insira valores válidos!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonLimpar.setOnClickListener(v -> {
            editTextPeso.setText("");
            editTextAltura.setText("");
        });

        buttonFechar.setOnClickListener(v -> finish());
    }
}
