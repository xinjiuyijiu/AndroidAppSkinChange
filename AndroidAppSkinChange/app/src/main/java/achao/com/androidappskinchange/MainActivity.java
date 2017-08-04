package achao.com.androidappskinchange;

import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import achao.com.androidappskinchange.core.BaseSkinActivity;

public class MainActivity extends BaseSkinActivity {
    Button change;
    ImageView bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        change = (Button) findViewById(R.id.change);
        bg = (ImageView) findViewById(R.id.bg);
        //int id = getResources().getIdentifier("skin_sidai", "drawable", getPackageName());
        //Log.d("skin", "skin_id===" + id);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = pluginResources.getIdentifier("skin_woailuo", "drawable", "achao.com.skinplugin");
                Drawable drawable = pluginResources.getDrawable(id);
                        //ResourcesCompat.getDrawable(pluginResources, id, null);
                bg.setImageDrawable(drawable);
                Log.d("skin", "skin_id===" + id);
            }
        });
    }
}
