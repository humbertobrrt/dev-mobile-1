package br.edu.ifsul.dmi.appbsicatsidm1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        // vincular objeto View com o elemento da tela
        Button btEntrar = findViewById(R.id.button);
        // evento de click
        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // declaro a Intent
                Intent it = new Intent(
                        getApplicationContext(),    // 1 - onde estou
                        MainActivityLogin.class     // 2 - para onde vou
                );
                // inicia a Intent
                startActivity(it);
            }
        });
        // botão cadastro com evento
        Button btCadastro = findViewById(R.id.button2);
        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // declaro a Intent
                Intent it = new Intent(
                        getApplicationContext(),    // 1 - onde estou
                        MainActivityTermoDePrivacidade.class     // 2 - para onde vou
                );
                // inicia a Intent
                startActivity(it);
            }
        });
    }
}