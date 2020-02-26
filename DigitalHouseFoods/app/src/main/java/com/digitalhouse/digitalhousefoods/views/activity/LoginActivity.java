package com.digitalhouse.digitalhousefoods.views.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.digitalhouse.digitalhousefoods.R;
import com.digitalhouse.digitalhousefoods.helper.Helper;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private Button botaoLogin;
    private Button botaoRegister;
    private TextInputLayout loginUsuario;
    private TextInputLayout loginSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validaCampos()) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finishAffinity();
                }
            }
        });

        botaoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
                finishAffinity();
           }
        });

    }

    private void initViews() {
        loginUsuario = findViewById(R.id.textEmail);
        loginSenha = findViewById(R.id.textPassword);
        botaoRegister = findViewById(R.id.buttonRegister);
        botaoLogin = findViewById(R.id.buttonLogIn);
    }

    private boolean validaCampos(){
        String usuario = loginUsuario.getEditText().getText().toString();
        String senha = loginSenha.getEditText().getText().toString();

        if (Helper.isEmptyString(usuario) || Helper.isEmptyString(senha))
            notificacao( "Por favor, preencha todos os campos");
        else if (!Helper.usuarioValido(usuario) || !Helper.senhaValida(senha))
            notificacao( "Usuário ou senha não atendem as regras, por favor, tente novamente");
        else
            return true;

        return false;
    }

    protected void notificacao (String sMensagem){
        Toast toast = Toast.makeText(getApplicationContext(), sMensagem,  Toast.LENGTH_LONG);
        toast.show();
    }

}
