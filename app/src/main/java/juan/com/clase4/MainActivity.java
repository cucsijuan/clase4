package juan.com.clase4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment relojArgentina = relojFragment.newInstance("Buenos Aires", -3);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft =  fm.beginTransaction();
        ft.add(R.id.contenedorDeFragment1,relojArgentina);
        ft.commit();
        
    }
}
