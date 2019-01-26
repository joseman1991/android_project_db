package com.myhexaville.login;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.myhexaville.login.DB.YR_MV_SQLiteAction_Usuarios;
import com.myhexaville.login.DB.YR_MV_Usuarios;


public class fragment_users extends Fragment {

    public fragment_users() {
        // Required empty public constructor
    }

    private ListView lista;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        try {
            YR_MV_SQLiteAction_Usuarios yr_mv_sqLiteAction_usuarios= new YR_MV_SQLiteAction_Usuarios(getActivity().getApplicationContext());
            YR_MV_Usuarios yr_mv_usuarios[] = yr_mv_sqLiteAction_usuarios.datos();
            ListItemAdapter listItemAdapter= new ListItemAdapter(getActivity(),yr_mv_usuarios);
            lista=(ListView)view. findViewById(R.id.mi_lista_user);
            lista.setAdapter(listItemAdapter);
        }catch (Exception e){
            Toast.makeText(getContext(),  e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return view;
    }


}
