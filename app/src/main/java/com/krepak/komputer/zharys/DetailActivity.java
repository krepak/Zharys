package com.krepak.komputer.zharys;

import android.content.Intent;
import android.os.Bundle;
//todo for admin - button for admin
//import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    TextView nameTxt,descTxt, propTxt,opisTxt;
    ImageView fotoTxt;
    TextView linkTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //TODO разкомментирую плюшку для админа
        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        nameTxt = (TextView) findViewById(R.id.nameDetailTxt);
        descTxt= (TextView) findViewById(R.id.descDetailTxt);
        propTxt = (TextView) findViewById(R.id.propellantDetailTxt);
        opisTxt = (TextView) findViewById(R.id.opisanidushka);
        fotoTxt = (ImageView) findViewById(R.id.fotochkavdetail);
        linkTxt = (TextView) findViewById(R.id.ssilkazhanymid);

        Intent i=this.getIntent();

        String name=i.getExtras().getString("NAME_KEY");
        String desc=i.getExtras().getString("DESC_KEY");
        String propellant=i.getExtras().getString("PROP_KEY");
        String opis=i.getExtras().getString("OPIS_KEY");
        String fffotka=i.getExtras().getString("FOTO_KEY");
        String sillkazhan=i.getExtras().getString("SSIL_KEY");

        nameTxt.setText(name);
        descTxt.setText(desc);
        propTxt.setText(propellant);
        opisTxt.setText(opis);
        linkTxt.setText(sillkazhan);

        Glide.with(this)
                .load(fffotka)
                .into(fotoTxt);

    }
    @Override
    public void onBackPressed() {
        finish();
    }

}