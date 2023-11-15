package pl.zabrze.zs10.listy3psroda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> wszystkieProdukty = new ArrayList<>();
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wszystkieProdukty.add("niezbadan planeta");
        wszystkieProdukty.add("poszukiwanie planety x");
        wszystkieProdukty.add("sowy");
        wszystkieProdukty.add("maszyna Turinga");
        listView = findViewById(R.id.listView2);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                wszystkieProdukty
        );
        listView.setAdapter(adapter);

    }
}