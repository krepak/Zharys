package com.krepak.komputer.zharys.m_UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
//import android.widget.ImageView;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.krepak.komputer.zharys.DetailActivity;
import com.krepak.komputer.zharys.R;
import com.krepak.komputer.zharys.m_Model.Spacecraft;

//import org.w3c.dom.Text;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<Spacecraft> spacecrafts;
    public CustomAdapter(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }
    public void setData(ArrayList<Spacecraft> spacecrafts){
        this.spacecrafts=spacecrafts;
        notifyDataSetChanged();
        //запустить сетДата только тогда, когда дата с файрбейса подгрузится
    }

    @Override
    public int getCount() {
        return spacecrafts.size();
    }

    @Override
    public Object getItem(int pos) {
        return spacecrafts.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.model,viewGroup,false);

        }
        TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);
        TextView propTxt= (TextView) convertView.findViewById(R.id.propellantTxt);
        TextView descTxt= (TextView) convertView.findViewById(R.id.descTxt);
        TextView opisTxt= (TextView) convertView.findViewById(R.id.opiskaTxt);
        ImageView fotoTxt= (ImageView) convertView.findViewById(R.id.fotoelement);
        TextView vhenshresTxt= (TextView) convertView.findViewById(R.id.ssikaskritaya);




        //todo eta nado dlyavivoda opisaniya na xlm file

        final Spacecraft s= spacecrafts.get(position);

        //todo for nauka
        //you are need to write like this

        nameTxt.setText(s.getName());
        propTxt.setText(s.getPropellant());
        descTxt.setText(s.getDescription());
        opisTxt.setText(s.getOpiszhan());
        vhenshresTxt.setText(s.getWebka());

        Glide.with(c)
                .load(s.getFotka())
                .into(fotoTxt);




        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //я так понял что при открывании дитейл активити с подробностями о соревновании
                //отображаются именно эти данные
                //OPEN DETAIL
                openDetailActivity(s.getName(),s.getDescription(),s.getPropellant(),s.getOpiszhan(),s.getFotka(),s.getWebka());
            }
        });
        return convertView;
    }
    //OPEN DETAIL ACTIVITY

    //тут я кажется должен передать инфу на дитейл активити
    private void openDetailActivity(String...details)
    {
        Intent i=new Intent(c,DetailActivity.class);
        i.putExtra("NAME_KEY",details[0]);
        i.putExtra("DESC_KEY",details[1]);
        i.putExtra("PROP_KEY",details[2]);
        i.putExtra("OPIS_KEY",details[3]);
        i.putExtra("FOTO_KEY",details[4]);
        i.putExtra("SSIL_KEY",details[5]);
        c.startActivity(i);
    }
}














