package win.prashant.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    String aa [] = {"india","iran","iraq", "pakistan","paki"};
    RatingBar rat;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // is use to find widget by id
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        rat = findViewById(R.id.ratingBar);
        btn = findViewById(R.id.button);


        ArrayAdapter<String>arrayAdapter= new ArrayAdapter<>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,aa);
        autoCompleteTextView.setAdapter(arrayAdapter);

        //to search from 1 char  we need to input 1
        autoCompleteTextView.setThreshold(1);

        multiAutoCompleteTextView.setAdapter(arrayAdapter);
        multiAutoCompleteTextView.setThreshold(1);

        // generate new value token
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float aa = rat.getRating();
                Toast.makeText(getApplicationContext(),""+aa,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
