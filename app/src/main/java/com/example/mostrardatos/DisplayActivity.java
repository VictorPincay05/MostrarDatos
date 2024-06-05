package com.example.mostrardatos;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private TextView displayName, displaySurname, displayCedula, displayCompany, displayPhone, displayMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        displayName = findViewById(R.id.displayName);
        displaySurname = findViewById(R.id.displaySurname);
        displayCedula = findViewById(R.id.displayCedula);
        displayCompany = findViewById(R.id.displayCompany);
        displayPhone = findViewById(R.id.displayPhone);
        displayMail = findViewById(R.id.displayMail);

        Intent intent = getIntent();
        displayName.setText(intent.getStringExtra("nombre"));
        displaySurname.setText(intent.getStringExtra("apellido"));
        displayCedula.setText(intent.getStringExtra("cedula"));
        displayCompany.setText(intent.getStringExtra("company"));
        displayPhone.setText(intent.getStringExtra("phone"));
        displayMail.setText(intent.getStringExtra("mail"));
    }
}
