package br.edu.ifsul.dmi.appbsicatsidm1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityEditarUsuario extends AppCompatActivity {

    private EditText etEmailEditado, etNovaSenha, etRepetirNovaSenha;
    private Button btExcluir, btSalvarEditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_editar_usuario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent it = getIntent();
        String email = it.getStringExtra("email");
        TextView emailExibido = findViewById(R.id.TextViewEmailExibido);
        emailExibido.setText(email);

        etEmailEditado = findViewById(R.id.editTextEmailEditar);
        etNovaSenha = findViewById(R.id.editTextPasswordEditar);
        etRepetirNovaSenha = findViewById(R.id.editTextPasswordRepetirEditar);
        btExcluir = findViewById(R.id.buttonExcluir);
        btSalvarEditar = findViewById(R.id.buttonSalvar);

        btSalvarEditar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = etEmailEditado.getText().toString();
                String senha = etNovaSenha.getText().toString();
                String senhaRepetida = etRepetirNovaSenha.getText().toString();

                if (email.isEmpty() || senha.isEmpty() || senhaRepetida.isEmpty()) {

                    etEmailEditado.setError("Esse campo é obrigatório!");
                    etRepetirNovaSenha.setError("Esse campo é obrigatório!");


                } else if (!senha.equals(senhaRepetida)) {

                    etRepetirNovaSenha.setError("As senhas não são iguais!");

                } else {

                    // exibir infos com toast
                    Toast.makeText(
                            getApplicationContext(),
                            email +" - "+ senha,
                            Toast.LENGTH_LONG).show();
                    // resetar valores da tela
                    etEmailEditado.setText("");
                    etNovaSenha.setText("");
                    etRepetirNovaSenha.setText("");
                }
            }
        });

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Exclusão de Registro");
        alerta.setMessage("Você realmente deseja apagar sua conta?");
        alerta.setNegativeButton("Não", null);
        alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent it = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                );
                startActivity(it);
            }
        });

        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerta.show();
            }
        });




    }
}