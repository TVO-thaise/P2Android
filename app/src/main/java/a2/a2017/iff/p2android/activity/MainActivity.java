package a2.a2017.iff.p2android.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import a2.a2017.iff.p2android.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button serieBT = (Button) findViewById(R.id.bt_series);

        serieBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SerieActivity.class);
                startActivity(intent);

            }
        });

    }

    private Context getContext(){
        return this;
    }
}
