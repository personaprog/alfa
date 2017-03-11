package br.com.personaprog.appaprendeler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.personaprog.personapputils.PersonaActivity;

public class MainActivity extends PersonaActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
