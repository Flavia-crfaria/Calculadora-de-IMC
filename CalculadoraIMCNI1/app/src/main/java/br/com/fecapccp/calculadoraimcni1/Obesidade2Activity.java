package br.com.fecapccp.calculadoraimcni1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Obesidade2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obesidade2);

        TextView textViewResultado = findViewById(R.id.textViewResultado);
        TextView textViewMensagem = findViewById(R.id.textViewMensagem);
        Button buttonFecharFeedback = findViewById(R.id.buttonFecharFeedback);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            double peso = extras.getDouble("peso");
            double altura = extras.getDouble("altura");
            double imc = extras.getDouble("imc");
            String mensagem = "Cuide de sua saúde! Busque orientação médica.";

            textViewResultado.setText(String.format("Peso: %.2f kg\nAltura: %.2f m\nIMC: %.2f\nClassificação: Obesidade Grau 2", peso, altura, imc));
            textViewMensagem.setText(mensagem);
        }

        buttonFecharFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
