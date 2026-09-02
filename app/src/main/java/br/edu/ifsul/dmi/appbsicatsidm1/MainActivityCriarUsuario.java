package br.edu.ifsul.dmi.appbsicatsidm1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityCriarUsuario extends AppCompatActivity {

    // declarar atributos para manipular a tela
    private EditText etCadastroEmail, etCadastroSenha, etCadastroRepeteSenha;
    private Button btCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_criar_usuario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etCadastroEmail = findViewById(R.id.editTextEmailCadastro);
        etCadastroSenha = findViewById(R.id.editTextPasswordCadastro);
        etCadastroRepeteSenha = findViewById(R.id.editTextRepetePasswordCadastro);
        btCadastro = findViewById(R.id.buttonCadastro);




        btCadastro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = etCadastroEmail.getText().toString();
                String senha = etCadastroSenha.getText().toString();
                String senhaRepetida = etCadastroRepeteSenha.getText().toString();

                if (email.isEmpty() || senha.isEmpty() || senhaRepetida.isEmpty()) {

                    etCadastroEmail.setError("Esse campo é obrigatório!");
                    etCadastroSenha.setError("Esse campo é obrigatório!");


                } else if (!senha.equals(senhaRepetida)) {

                    etCadastroRepeteSenha.setError("As senhas não são iguais!");

                } else {

                    Intent it = new Intent(
                            getApplicationContext(),
                            MainActivityEditarUsuario.class

                    );

                    it.putExtra("email", email);
                    startActivity(it);
                }
            }
        });



    }
}