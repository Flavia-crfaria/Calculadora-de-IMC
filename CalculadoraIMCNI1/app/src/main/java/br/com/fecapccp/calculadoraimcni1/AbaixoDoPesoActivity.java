package br.com.fecapccp.calculadoraimcni1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AbaixoDoPesoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abaixo_do_peso);

        TextView textViewResultado = findViewById(R.id.textViewResultado);
        TextView textViewMensagem = findViewById(R.id.textViewMensagem);
        Button buttonFecharFeedback = findViewById(R.id.buttonFecharFeedback);

        // Recebe os valores enviados pela Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            double peso = extras.getDouble("peso");
            double altura = extras.getDouble("altura");
            double imc = extras.getDouble("imc");
            String mensagem = "Mantenha uma alimentação equilibrada e saudável!";

            textViewResultado.setText(String.format("Peso: %.2f kg\nAltura: %.2f m\nIMC: %.2f\nClassificação: Abaixo do Peso", peso, altura, imc));
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
