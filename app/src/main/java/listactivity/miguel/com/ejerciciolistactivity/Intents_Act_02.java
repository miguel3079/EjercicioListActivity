package listactivity.miguel.com.ejerciciolistactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Intents_Act_02 extends ActionBarActivity {
    static final int ACTIVITY_INTENTS_02 = 1;
    private static final String TAG = Intents_Act_02.class.getName() ;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents__act_02);
        boton = (Button)findViewById(R.id.button2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intensts__act_01, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onClick(View boton) {
        Intent intent = new Intent(this, Intents_Act_02_b.class);
        startActivityForResult(intent,
                ACTIVITY_INTENTS_02);

    }
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // nombreclase.class.getName()
        if (requestCode == ACTIVITY_INTENTS_02) {
            if (resultCode == RESULT_OK) {
                Log.d(TAG, "recibe el intents");
                String resultado = data.getStringExtra("edittext");
                Toast.makeText(this, resultado, Toast.LENGTH_LONG).show();
            }
        }
    }
}
