package dh.com.digitalhouseapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout textImputName;
    private TextInputLayout textImputEmail;
    private TextInputLayout textImputPassword;
    private TextInputLayout textImputRepeatPassword;
    private Button btnRegistra;

    FirebaseAuth firebaseAuth;

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
        btnRegistra = findViewById(R.id.btnRegistra);

        firebaseAuth = FirebaseAuth.getInstance();

        btnRegistra.setOnClickListener(v -> {

            if (textImputName.getEditText().getText().toString().isEmpty() ||
                    textImputEmail.getEditText().getText().toString().isEmpty() ||
                    textImputPassword.getEditText().getText().toString().isEmpty() ||
                    textImputRepeatPassword.getEditText().getText().toString().isEmpty()) {

                Toast.makeText(getApplicationContext(), "Please fill in the required fields", Toast.LENGTH_LONG).show();

            } else if (!(textImputPassword.getEditText().getText().toString().equals(textImputRepeatPassword.getEditText().getText().toString()))) {

                Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_LONG).show();

            } else {

                firebaseAuth.createUserWithEmailAndPassword(textImputEmail.getEditText().getText().toString(), textImputPassword.getEditText().getText().toString())
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Welcome " + textImputName.getEditText().getText().toString() + "!", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });


    }
}
