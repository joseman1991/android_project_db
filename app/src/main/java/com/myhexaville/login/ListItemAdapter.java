package com.myhexaville.login;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myhexaville.login.DB.YR_MV_Usuarios;

public class ListItemAdapter extends ArrayAdapter<YR_MV_Usuarios> {

    private final Activity context;
    private final YR_MV_Usuarios[] itemname;
   // private final Integer[] integers;

    public ListItemAdapter(Activity context, YR_MV_Usuarios[] itemname) {
        super(context.getApplicationContext(), R.layout.fila_lista_user, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
       // this.integers=integers;
    }

    public View getView(int posicion, View view, ViewGroup parent){
      LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.fila_lista_user,null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.coreo_u);
        TextView etxDescripcion = (TextView) rowView.findViewById(R.id.clave_u);
        txtTitle.setText("Usuario "+itemname);



/*
        txtTitle.setText(itemname[posicion].getCorreo());
        etxDescripcion.setText("Correo "+itemname[posicion].getIdusuario());*/

        return rowView;
    }


}
