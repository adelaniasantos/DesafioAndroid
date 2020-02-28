package com.digitalhouse.digitalhousefoods.views.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.digitalhouse.digitalhousefoods.R;
import com.digitalhouse.digitalhousefoods.helper.Helper;
import com.google.android.material.textfield.TextInputLayout;

public class RegistroActivity extends AppCompatActivity {
    private Button botaoRegister;
    private TextInputLayout registerName;
    private TextInputLayout registerEmail;
    private TextInputLayout registerPassword;
    private TextInputLayout registerConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Register");

        initViews();

        botaoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastraNovoUsuario();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, LoginActivity.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }

    private void initViews() {
        botaoRegister = findViewById(R.id.buttonRegister);
        registerName = findViewById(R.id.textNomeRegister);
        registerEmail = findViewById(R.id.textEmailRegister);
        registerPassword = findViewById(R.id.textPasswordRegister);
        registerConfirmPassword = findViewById(R.id.textPasswordRegister);

    }

    private void cadastraNovoUsuario() {
        String nome = registerName.getEditText().getText().toString();
        String email = registerEmail.getEditText().getText().toString();
        String senha = registerPassword.getEditText().getText().toString();
        String senhaConfirmacao = registerConfirmPassword.getEditText().getText().toString();

        if(validaCampos(nome, email, senha, senhaConfirmacao)){
            notificacao("Cadastro Realizado com Sucesso!");
            startActivity(new Intent(RegistroActivity.this, MainActivity.class));
            finishAffinity();
        }
    }

    private boolean validaCampos(String nomeCompleto, String email, String senha, String senhaConfirmacao) {
        if (Helper.isEmptyString(nomeCompleto) || Helper.isEmptyString(email)
                || Helper.isEmptyString(senha) || Helper.isEmptyString(senhaConfirmacao))
            notificacao("Por favor, preencha todos os campos");
        else if (!Helper.nomeValido(nomeCompleto))
            notificacao("Por favor, preencha o nome completo para cadastrar-se");
        else if (!Helper.usuarioValido(email))
            notificacao("Por favor, insira um e-mail válido");
        else if (Helper.senhaValida(senha)) {
            if (!Helper.senhaIguais(senha, senhaConfirmacao))
                notificacao("Os dados inseridos nos campos Senha e Confirme sua senha, devem ser iguais. Tente novamente.");
            else
                return true;
        } else
            notificacao("A senha deve conter pelo menos 6 caracteres, uma letra maiuscula e minuscula, um número e um caracter especial.");

        return false;
    }

    protected void notificacao(String sMensagem) {
        String textoNotificacao = sMensagem;
        Toast toast = Toast.makeText(getApplicationContext(), textoNotificacao, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(this, LoginActivity.class));
        finishAffinity();
        return;
    }
}
