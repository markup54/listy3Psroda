package pl.zabrze.zs10.listy3psroda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class WybierzZawodActivity extends AppCompatActivity {

    private RadioGroup radioGroup;

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wybierz_zawod);
        radioGroup  = findViewById(R.id.radioGroup);
        button = findViewById(R.id.button4);
        textView = findViewById(R.id.textView4);
        String opisy[] = new String[]{
                "programista to zawód dla wytrwałych, którzy lubią logiczne myślenie i długie godziny przed komputerem",
                "informatyk to zawód dla osób lubiących montaż komputera i sieci",
                "elektronik to zawód o zapachu cyny, bez lutownicy nie podchodź"
        };
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int idKlikniete = radioGroup.getCheckedRadioButtonId();
                        if(idKlikniete == R.id.radioButton){
                            textView.setText(opisy[0]);
                        }
                        else if(idKlikniete == R.id.radioButton2){
                            textView.setText(opisy[1]);
                        }
                        else{
                            textView.setText(opisy[2]);
                        }
                    }
                }
        );


    }
}