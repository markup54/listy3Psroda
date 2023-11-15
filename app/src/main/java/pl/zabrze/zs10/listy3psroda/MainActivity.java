package pl.zabrze.zs10.listy3psroda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Produkt> wszystkieProdukty = new ArrayList<>();
    private ListView listView;
    private EditText editText;
    private EditText editTextCena;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wszystkieProdukty.add(new Produkt("niezbadan planeta",200));
        wszystkieProdukty.add(new Produkt("poszukiwanie planety x",120));
        wszystkieProdukty.add(new Produkt("sowy",50));
        wszystkieProdukty.add(new Produkt("maszyna Turinga",130));
        listView = findViewById(R.id.listView2);
        editText = findViewById(R.id.editText);
        editTextCena = findViewById(R.id.editTextNumberDecimal);
        button = findViewById(R.id.button);
        ArrayAdapter<Produkt> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                wszystkieProdukty
        );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(MainActivity.this,
                                String.valueOf(wszystkieProdukty.get(i).getCena()),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String p = editText.getText().toString();
                        int cena = Integer.valueOf(editTextCena.getText().toString());
                        wszystkieProdukty.add(new Produkt(p,cena));
                        adapter.notifyDataSetChanged();
                    }
                }
        );
    }
}