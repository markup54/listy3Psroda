package pl.zabrze.zs10.listy3psroda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ZgadywanieActivity extends AppCompatActivity {
    private Button buttonPodpowiedz, buttonZgadywanie;
    private EditText editText;
    private Integer wylosowanaLiczba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zgadywanie);
        wylosowanaLiczba = (int)(Math.random()*100)+1;
        buttonPodpowiedz = findViewById(R.id.button3);
        buttonZgadywanie = findViewById(R.id.button2);
        editText = findViewById(R.id.editTextTextPersonName);
        buttonZgadywanie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer liczba = Integer.valueOf(editText.getText().toString());
                        if(liczba == wylosowanaLiczba){
                            Toast.makeText(ZgadywanieActivity.this, "Gratulacje", Toast.LENGTH_SHORT).show();
                        }
                        else if(liczba<wylosowanaLiczba){
                            Toast.makeText(ZgadywanieActivity.this, "Wpisano za mało", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ZgadywanieActivity.this, "Wpisano za dużo", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        buttonPodpowiedz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ZgadywanieActivity.this,
                                "Wylosowano "+wylosowanaLiczba.toString(),
                                        Toast.LENGTH_SHORT)
                                .show();
                    }
                }
        );
    }
}