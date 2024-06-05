package com.example.mostrardatos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText nombre, apellido, cedula, company, phone, mail;
    private Button enviarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.Nombre);
        apellido = findViewById(R.id.Apellido);
        cedula = findViewById(R.id.Cedula);
        company = findViewById(R.id.Company);
        phone = findViewById(R.id.Phone);
        mail = findViewById(R.id.Mail);
        enviarButton = findViewById(R.id.button4);

        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cedulaText = cedula.getText().toString();
                String phoneText = phone.getText().toString();
                String mailText = mail.getText().toString();

                if (!isValidCedula(cedulaText)) {
                    cedula.setError("La cédula debe contener solo números");
                    return;
                }

                if (!isValidPhone(phoneText)) {
                    phone.setError("El número de celular debe contener solo números");
                    return;
                }

                if (cedulaText.length() != 10) {
                    cedula.setError("La cédula debe tener 10 números");
                    return;
                }

                if (phoneText.length() != 10) {
                    phone.setError("El número de celular debe tener 10 números");
                    return;
                }

                if (!isValidEmail(mailText)) {
                    mail.setError("El correo electrónico no tiene un formato válido");
                    return;
                }
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("nombre", nombre.getText().toString());
                intent.putExtra("apellido", apellido.getText().toString());
                intent.putExtra("cedula", cedula.getText().toString());
                intent.putExtra("company", company.getText().toString());
                intent.putExtra("phone", phone.getText().toString());
                intent.putExtra("mail", mail.getText().toString());
                startActivity(intent);
            }
        });
    }

    private boolean isValidCedula(String cedula) {
        String cedulaPattern = "^[0-9]+$";
        return Pattern.matches(cedulaPattern, cedula);
    }

    private boolean isValidPhone(String phone) {
        String phonePattern = "^[0-9]+$";
        return Pattern.matches(phonePattern, phone);
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailPattern, email);
    }
}
