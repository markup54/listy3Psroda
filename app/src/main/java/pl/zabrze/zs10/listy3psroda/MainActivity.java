package pl.zabrze.zs10.listy3psroda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Produkt> wszystkieProdukty = new ArrayList<>();
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wszystkieProdukty.add(new Produkt("niezbadan planeta",200));
        wszystkieProdukty.add(new Produkt("poszukiwanie planety x",120));
        wszystkieProdukty.add(new Produkt("sowy",50));
        wszystkieProdukty.add(new Produkt("maszyna Turinga",130));
        listView = findViewById(R.id.listView2);
        ArrayAdapter<Produkt> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                wszystkieProdukty
        );
        listView.setAdapter(adapter);

    }
}