package com.krepak.komputer.zharys;

import android.app.Dialog;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.krepak.komputer.zharys.m_FireBase.FirebaseHelper;
import com.krepak.komputer.zharys.m_Model.Spacecraft;
import com.krepak.komputer.zharys.m_UI.CustomAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<Spacecraft> spacecrafts=new ArrayList<>();
    DatabaseReference db;
    FirebaseDatabase databazzhanym;
    FirebaseHelper helper;
    public static CustomAdapter adapter;
    ListView lv;
    EditText nameEditTxt,propTxt,descTxt;
    EditText opisEditTxt;
    ImageView kartinkaEdit;
    EditText webEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ArrayList<Spacecraft> spacecrafts=new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lv = (ListView) findViewById(R.id.lv);
        db= FirebaseDatabase.getInstance().getReference();
        helper=new FirebaseHelper(db);
        databazzhanym = FirebaseDatabase.getInstance();
        db = databazzhanym.getReference("Spacecraft");
        db.keepSynced(true);
        ArrayList<Spacecraft> arrr=helper.retrieve();
        adapter=new CustomAdapter(this,arrr);
        lv.setAdapter(adapter);


//TODO продолжение плюхи для админа
        //в админской панели надо разкомментировать слеудующее
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                displayInputDialog();
//            }
//        });
    }




    private void fetchData(DataSnapshot dataSnapshot)
    {
        spacecrafts.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            Spacecraft spacecraft=ds.getValue(Spacecraft.class);
            spacecrafts.add(spacecraft);
        }
    }

    private void displayInputDialog()
    {
        Dialog d=new Dialog(this);
        d.setTitle("Сохранено в твою файрбазу битч");
        d.setContentView(R.layout.input_dialog);

        nameEditTxt= (EditText) d.findViewById(R.id.nameEditText);
        propTxt= (EditText) d.findViewById(R.id.propellantEditText);
        descTxt= (EditText) d.findViewById(R.id.descEditText);
        opisEditTxt= (EditText) d.findViewById(R.id.opisEdutid);
        //todo tak nado
        kartinkaEdit= (ImageView) d.findViewById(R.id.fotkazhanymsol);
        //todo webka ushin
        webEdit= (EditText) d.findViewById(R.id.ssilkasuchka);


        Button saveBtn = (Button) d.findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //prinmayu datu tut
                String name=nameEditTxt.getText().toString();
                String propellant=propTxt.getText().toString();
                String desc=descTxt.getText().toString();
                String opiska=opisEditTxt.getText().toString();
                String fotkazhan=kartinkaEdit.getDrawable().toString();
                String webkassil=webEdit.getText().toString();

                Spacecraft s=new Spacecraft();
                s.setName(name);
                s.setPropellant(propellant);
                s.setDescription(desc);
                s.setOpiszhan(opiska);
                s.setFotka(fotkazhan);
                s.setWebka(webkassil);



                //todo poprav


                //чекает на д
                if(name != null && name.length()>0)
                {
                    //сохраняет
                    if(helper.save(s))
                    {
                        //если сохранено то очищает места ввода
                        nameEditTxt.setText("");
                        propTxt.setText("");
                        descTxt.setText("");

                        opisEditTxt.setText("");

                       // kartinkaEdit.setImageResource("");


                        adapter=new CustomAdapter(MainActivity.this,helper.retrieve());
                        lv.setAdapter(adapter);
                    }


                }else
                {
                    Toast.makeText(MainActivity.this, "Вы не ввели название", Toast.LENGTH_SHORT).show();
                }
            }
        });
        d.show();
    }
}