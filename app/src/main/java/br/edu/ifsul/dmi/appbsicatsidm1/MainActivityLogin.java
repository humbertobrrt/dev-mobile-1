package br.edu.ifsul.dmi.appbsicatsidm1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityLogin extends AppCompatActivity {

    // declarar atributos para manipular a tela
    private EditText etEmail, etSenha;
    private Button btEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // vincular Objetos com Views da tela
        etEmail = findViewById(R.id.editTextTextEmailAddress);
        etSenha = findViewById(R.id.editTextTextPassword);
        btEntrar = findViewById(R.id.btTentaLogar);
        // evento de click
        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pegar a info da tela
                String email = etEmail.getText().toString();
                String senha = etSenha.getText().toString();
                // valida obrigatório
                if(email.isEmpty()|| senha.isEmpty()){
                    etEmail.setError("Email ou senha incorretos");
                    etSenha.setError("Email ou senha incorretos");
                    etEmail.requestFocus();
                    return;
                }

                // exibir a senha com Toast
                Toast.makeText(
                        getApplicationContext(),
                        email +" - "+ senha,
                        Toast.LENGTH_LONG).show();
                // resetar valores da tela
                etEmail.setText("");
                etSenha.setText("");
            }
        });
    }
}