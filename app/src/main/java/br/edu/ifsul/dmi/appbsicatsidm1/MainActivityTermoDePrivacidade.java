package br.edu.ifsul.dmi.appbsicatsidm1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityTermoDePrivacidade extends AppCompatActivity {

    // componentes para manipular a tela
    private WebView wvTermo;
    private CheckBox chAceitar;
    private Button btAceitar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_termo_de_privacidade);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // vincular elementos de tela
        btAceitar = findViewById(R.id.button3);
        chAceitar = findViewById(R.id.checkBox);
        wvTermo = findViewById(R.id.webviewTermo);
        // configuração botão (não permite clicar = desabilitado)
        btAceitar.setEnabled(false);
        // exibir o arquivo index.html no WebView
        wvTermo.loadUrl("file:///android_asset/index.html");

        // configurar evento checkbox
        chAceitar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView,
                                         boolean isChecked) {
                btAceitar.setEnabled(isChecked);
            }
        });
        // evento no botão
        btAceitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // aqui voçês vão abrir para a outra tela! (exercício 2)
            }
        });
    }
}