package a2.a2017.iff.p2android.activity;


import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import a2.a2017.iff.p2android.adapter.ClickRecyclerViewListener;
import a2.a2017.iff.p2android.adapter.SerieAdapter;
import a2.a2017.iff.p2android.model.Serie;
import a2.a2017.iff.p2android.R;
import io.realm.Realm;

public class SerieActivity extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private List<Serie> getSeries(){
        return (List)realm.where(Serie.class).findAll();

    }

    public void onClick(Object object) {
        Serie serie = (Serie) object;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_Serie);

        recyclerView.setAdapter(new SerieAdapter(getSeries(),this,this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);

    }
}
