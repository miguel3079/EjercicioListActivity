package listactivity.miguel.com.ejerciciolistactivity;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;


public class intent_implicitos extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_implicitos);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intent_implicitos, menu);
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
    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {

            throw new RuntimeException("URLEncoder.encode() failed for " + s);
        }
    }


    public void onClickMapa(View v) {

        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://www.google.es/maps/place/Universidad+Europea+de+Madrid/@40.373061,-3.918825,17z/data=!3m1!4b1!4m2!3m1!1s0xd419031a94d45e5:0x375a8b6ca7a1dc4c?hl=es"));
        startActivity(intent);
    }

    public void onClickLlamada(View v) {

        Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                Uri.parse("tel:+902232350")); //
        startActivity(i);
    }
    public void CompartirTwitter(View v){
        if(isNetworkAvailable()) {
            String tweetUrl =
                    String.format("https://twitter.com/intent/tweet?text=%s&url=%s&hashtags=%s",
                            urlEncode(getString(R.string.twittertextoinvitar)), urlEncode(getString(R.string.Linkglobalapk)), urlEncode("QIZITMONSTER"));
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl));



            List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
            for (ResolveInfo info : matches) {
                if (info.activityInfo.packageName.toLowerCase().startsWith("com.twitter")) {
                    intent.setPackage(info.activityInfo.packageName);
                }
            }

            startActivity(intent);

        } else{
            Toast.makeText(this,
                    "No hay internet",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public boolean isNetworkAvailable() {
        return true;
    }
}
