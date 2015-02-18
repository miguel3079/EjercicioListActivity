package listactivity.miguel.com.ejerciciolistactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }
    private IntentFilter myFilter;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        String myParam = intent.getExtras().getString("mensaje");
        Toast.makeText(context, myParam, Toast.LENGTH_SHORT).show();

    }

}
