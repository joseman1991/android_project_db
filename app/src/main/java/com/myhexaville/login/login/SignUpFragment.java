package com.myhexaville.login.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.myhexaville.login.DB.YR_MV_SQLiteAction_Usuarios;
import com.myhexaville.login.DB.YR_MV_Usuarios;
import com.myhexaville.login.R;

public class SignUpFragment extends Fragment implements OnSignUpListener{

    private EditText yr_mv_txtCorreo, yr_mv_txtClave,yr_mv_txtClave2;


    private static final String TAG = "SignUpFragment";
    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_signup, container, false);


        yr_mv_txtCorreo = (EditText) inflate.findViewById(R.id.correo);
        yr_mv_txtClave = (EditText) inflate.findViewById(R.id.clave);
        yr_mv_txtClave2 = (EditText) inflate.findViewById(R.id.clave2);

        return inflate;
    }

    @Override
    public void signUp() {
        String correo, clave,clave2;
        YR_MV_SQLiteAction_Usuarios yr_mv_sqLiteAction_usuarios= new YR_MV_SQLiteAction_Usuarios(getActivity());
        correo=yr_mv_txtCorreo.getText().toString();
        clave=yr_mv_txtClave.getText().toString();
        clave2=yr_mv_txtClave2.getText().toString();

        try {
            if(clave.equals(clave2)){
                YR_MV_Usuarios yr_mv_usuarios= new YR_MV_Usuarios();
                yr_mv_usuarios.setCorreo(correo);
                yr_mv_usuarios.setCorreo(clave);
                yr_mv_sqLiteAction_usuarios.insertarUsuario(yr_mv_usuarios);
                Toast.makeText(getContext(), "Usuario Registrado "+correo, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getContext(), "Clave de confirmación no coincide", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception ex){
            Toast.makeText(getContext(), "Ocurrió un problema "+ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
