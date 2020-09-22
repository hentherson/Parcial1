package com.uac.parcial1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial1.R;

public class MainActivity extends AppCompatActivity {

    EditText empleado, salario, hrsExtras, vlrHrsExtras, pension, salud, salarioTotal;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empleado = findViewById(R.id.EmpleadoText);
        salario = findViewById(R.id.SalarioText);
        hrsExtras = findViewById(R.id.HorasExtrasText);
        vlrHrsExtras = findViewById(R.id.VlrHrExtText);
        pension = findViewById(R.id.PensionText);
        salud = findViewById(R.id.SaludText);
        salarioTotal = findViewById(R.id.SalarioTotalText);
        calcular = findViewById(R.id.CalcButton);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.SalarioAuto:
                salario.setText(""+980657);
                Toast.makeText(this, "Salario Mínimo autopopulado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.BorrarDatos:
                borrarDatos();
                Toast.makeText(this, "Datos Borrados", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /*void public clearAll() {

    }*/

    public void calcular() {
        int salarioBruto, sal, hrsExt, valHrsExt, penSal, salFinal;
        sal = Integer.parseInt(salario.getText().toString());
        hrsExt = Integer.parseInt(hrsExtras.getText().toString());
        valHrsExt = Integer.parseInt(vlrHrsExtras.getText().toString());

        salarioBruto = sal + (hrsExt * valHrsExt);

        penSal = (salarioBruto * 4)/100;

        pension.setText(""+penSal);
        salud.setText(""+penSal);

        salFinal = salarioBruto - (penSal * 2);

        salarioTotal.setText(""+salFinal);
    }

    public void borrarDatos() {
        empleado.setText("");
        salario.setText("");
        hrsExtras.setText("");
        vlrHrsExtras.setText("");
        pension.setText("");
        salud.setText("");
        salarioTotal.setText("");
    }
}