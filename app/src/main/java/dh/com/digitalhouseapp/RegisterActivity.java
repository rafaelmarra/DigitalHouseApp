package dh.com.digitalhouseapp;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                finish();
            }
        });


    }
}
