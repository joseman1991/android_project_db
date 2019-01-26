package com.myhexaville.login.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.myhexaville.login.DB.YR_MV_SQLiteAction_Usuarios;
import com.myhexaville.login.DB.YR_MV_Usuarios;
import com.myhexaville.login.MenuActivity;
import com.myhexaville.login.R;

public class LoginFragment extends Fragment implements OnLoginListener{
    private static final String TAG = "LoginFragment";

    private EditText yr_mv_txtCorreo, yr_mv_txtClave;


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_login, container, false);
        yr_mv_txtCorreo = (EditText) inflate.findViewById(R.id.lg_correo);
        yr_mv_txtClave = (EditText) inflate.findViewById(R.id.lg_clave);

        inflate.findViewById(R.id.forgot_password).setOnClickListener(v ->
                Toast.makeText(getContext(), "Forgot password clicked", Toast.LENGTH_SHORT).show());
        return inflate;
    }

    @Override
    public void login() {
        try {
            String correo, clave,clave2;
            correo=yr_mv_txtCorreo.getText().toString();
            clave=yr_mv_txtClave.getText().toString();
            if(correo.equals("")||clave.equals("")){
                Toast.makeText(getContext(), "Campos está vacíos", Toast.LENGTH_SHORT).show();
            }else{
                YR_MV_SQLiteAction_Usuarios yr_mv_sqLiteAction_usuarios= new YR_MV_SQLiteAction_Usuarios(getActivity());
                YR_MV_Usuarios yr_mv_usuarios= new YR_MV_Usuarios();
                YR_MV_Usuarios yr_mv_usuarios1= new YR_MV_Usuarios();
                yr_mv_usuarios.setCorreo(correo);
                yr_mv_usuarios.setClave(clave);
                yr_mv_usuarios1=yr_mv_sqLiteAction_usuarios.login(yr_mv_usuarios);
                if(yr_mv_usuarios1!=null){
                    Toast.makeText(getContext(), "Login", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Error de datos", Toast.LENGTH_SHORT).show();
                }

                  Intent i = new Intent(getActivity(), MenuActivity.class);
                  startActivity(i);


            }


        }catch (Exception ex){
            Toast.makeText(getContext(),ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
