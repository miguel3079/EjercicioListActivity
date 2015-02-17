package listactivity.miguel.com.ejerciciolistactivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends ListActivity {
    private TextView text;
    private List<String> listValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.mainText);

        listValues = Arrays.asList(getResources().getStringArray(R.array.lista));

        // initiate the listadapter
        ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this,
                R.layout.row_layout, R.id.listText, listValues);

        // assign the list adapter
        setListAdapter(myAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    //Click en los item del list
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);

        String selectedItem = (String) getListView().getItemAtPosition(position);


        //String selectedItem = (String) getListAdapter().getItem(position);

        text.setText("You clicked " + selectedItem + " at position " + position);

        //Seleccionar de la lista
        if (position == 0) {
            Intent intent = new Intent(this, Intents_Act_01.class);
            startActivity(intent);
        }else if(position == 1) {
            Intent intent2 = new Intent(this, Intents_Act_02.class);
            startActivity(intent2);

        }else if(position == 2) {
        Intent intent2 = new Intent(this, Intents_Act_03.class);
        startActivity(intent2);
        }else if(position == 8) {
            Intent intent2 = new Intent(this, Notificaciones.class);
            startActivity(intent2);
        }
        else if(position == 3) {
            Intent intent2 = new Intent(this, intent_implicitos.class);
            startActivity(intent2);
        }
        else if(position == 6) {
            Intent intent2 = new Intent(this, Actividad9Fragments.class);
            startActivity(intent2);
        }
        else if(position == 7) {
            Intent intent2 = new Intent(this, DialogoConProgress.class);
            startActivity(intent2);
        }

    }
}
