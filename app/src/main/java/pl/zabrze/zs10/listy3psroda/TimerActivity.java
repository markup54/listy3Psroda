package pl.zabrze.zs10.listy3psroda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TimerActivity extends AppCompatActivity {
    private Button buttonStart, buttonStop, buttonZapisz, buttonReset;
    private TextView textViewCzas;
    private ListView listViewCzas;
    private boolean uruchomiony;
    private int sekundy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        textViewCzas = findViewById(R.id.textView5);
        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        buttonZapisz = findViewById(R.id.buttonZapisz);
        buttonReset = findViewById(R.id.buttonReset);
        listViewCzas = findViewById(R.id.listViewCzasy);
        ArrayList<String> czasy = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                czasy
        );
        listViewCzas.setAdapter(adapter);
        buttonZapisz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String czas = wyswietlCZas(sekundy);
                        czasy.add(czas);
                        adapter.notifyDataSetChanged();
                    }
                }
        );
        listViewCzas.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        czasy.remove(i);
                        adapter.notifyDataSetChanged();
                    }
                }
        );
        buttonStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        uruchomiony = true;
                    }
                }
        );
        buttonStop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        uruchomiony = false;
                    }
                }
        );
        buttonReset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sekundy = 0;
                        wyswietlCZas(0);
                    }
                }
        );
        starTimer();
    }
    private void starTimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(uruchomiony)
                    sekundy++;
                wyswietlCZas(sekundy);
                handler.postDelayed(this,1000);
            }
        });

    }
    private String wyswietlCZas(int sek){
        int sekundy = sek%60;
        int minuty = (sek/60)%60;
        int godziny = sek/3600;
        textViewCzas.setText(String.format("%02d:%02d:%02d",godziny,minuty,sekundy));
        return String.format("%02d:%02d:%02d",godziny,minuty,sekundy);
    }
}