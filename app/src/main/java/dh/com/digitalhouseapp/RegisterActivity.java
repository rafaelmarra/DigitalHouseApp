package dh.com.digitalhouseapp;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout textImputName;
    private TextInputLayout textImputEmail;
    private TextInputLayout textImputPassword;
    private TextInputLayout textImputRepeatPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Register");

        textImputName = findViewById(R.id.txtRegisterName);
        textImputEmail = findViewById(R.id.txtRegisterEmail);
        textImputPassword = findViewById(R.id.txtRegisterPassword);
        textImputRepeatPassword = findViewById(R.id.txtRegisterConfirmPassword);

        Button btnRegistra = findViewById(R.id.btnRegistra);
        btnRegistra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (textImputName.getEditText().getText().toString().isEmpty() ||
                        textImputEmail.getEditText().getText().toString().isEmpty() ||
                        textImputPassword.getEditText().getText().toString().isEmpty() ||
                        textImputRepeatPassword.getEditText().getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Existem campos em branco!", Toast.LENGTH_LONG).show();

                } else if (textImputPassword.getEditText().getText() != textImputRepeatPassword.getEditText().getText()) {

                    Toast.makeText(getApplicationContext(), "As senhas não coincidem!", Toast.LENGTH_LONG).show();

                } else {

                    startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                    finish();
                }
            }
        });


    }
}
