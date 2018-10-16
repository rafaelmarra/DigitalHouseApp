package dh.com.digitalhouseapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonLogin = findViewById(R.id.buttonLogin);
        TextView register = findViewById(R.id.txtRegister);
        final TextInputEditText txtEmail = findViewById(R.id.txtEmail);
        final TextInputEditText txtPassword = findViewById(R.id.txtPassword);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager loginManager = new LoginManager();

                Intent intent = new Intent(v.getContext(), HomeActivity.class);
                Bundle bundle = new Bundle();

                String email = txtEmail.getText().toString();
                Toast invalido = Toast.makeText(LoginActivity.this, "Seu animal", Toast.LENGTH_SHORT);

                if (loginManager.getSenhaPorUsuario(email) == null){
                    invalido.show();
                }else if(!(loginManager.getSenhaPorUsuario(email).equals(txtPassword.getText().toString()))){
                    invalido.show();
                }
                else{
                    bundle.putString("email", email);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
