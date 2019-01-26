package com.myhexaville.login.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.widget.Adapter;
import android.widget.Toast;

import com.myhexaville.login.ListItemAdapter;

public class YR_MV_SQLiteAction_Usuarios {

    private YR_MV_SQLiteOpenHelper yr_mv_sqLiteOpenHelper;
    private SQLiteDatabase yr_mv_baseDatos;

   private Context context;

    public YR_MV_SQLiteAction_Usuarios(Context context) {
        this.context=context;
    }

    public void insertarUsuario(YR_MV_Usuarios yr_mv_usuarios){
        try {
            yr_mv_sqLiteOpenHelper = new YR_MV_SQLiteOpenHelper(context,"bolso",null,1);
            yr_mv_baseDatos =  yr_mv_sqLiteOpenHelper.getWritableDatabase();
            ContentValues yr_mv_registro = new ContentValues();
            yr_mv_registro.put("idusario",1);
            yr_mv_registro.put("correo",yr_mv_usuarios.getCorreo());
            yr_mv_registro.put("clave",yr_mv_usuarios.getClave());
            yr_mv_registro.put("iperfil",1);
            yr_mv_baseDatos.insert("usuario",null,yr_mv_registro);
            yr_mv_baseDatos.close();
        }catch (SQLiteException e){
            Toast.makeText(context,  e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public YR_MV_Usuarios login(YR_MV_Usuarios yr_mv_usuarios){
        YR_MV_Usuarios yr_mv_usuarios1=null;
        try{
            yr_mv_sqLiteOpenHelper = new YR_MV_SQLiteOpenHelper(context,"bolso",null,1);
            yr_mv_baseDatos =  yr_mv_sqLiteOpenHelper.getWritableDatabase();
            String sql = "select * from usuario where correo=? and clave = ?";

            Cursor yr_mv_fila = yr_mv_baseDatos.rawQuery(sql ,new String [] {yr_mv_usuarios.getCorreo(),yr_mv_usuarios.getClave()});
            if (yr_mv_fila.moveToFirst())
            {
                yr_mv_usuarios1= new YR_MV_Usuarios();
                int i=0;
                yr_mv_usuarios1.setIdusuario(yr_mv_fila.getInt(i++));
                yr_mv_usuarios1.setCorreo(yr_mv_fila.getString(i++));
                yr_mv_usuarios1.setClave(yr_mv_fila.getString(i++));
                yr_mv_usuarios1.setIdperfil(yr_mv_fila.getInt(i++));
            }
            yr_mv_baseDatos.close();
        }catch (SQLiteException  e){
            Toast.makeText(context,  e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    return  yr_mv_usuarios1;
    }

    public YR_MV_Usuarios [] datos(){
        YR_MV_Usuarios[] yr_mv_usuarios= new YR_MV_Usuarios[100];
        try{
            yr_mv_sqLiteOpenHelper = new YR_MV_SQLiteOpenHelper(context,"bolso",null,1);
            yr_mv_baseDatos =  yr_mv_sqLiteOpenHelper.getWritableDatabase();
            String sql = "select idusuario, correo from usuario";
            Cursor yr_mv_fila = yr_mv_baseDatos.rawQuery(sql ,null);
            int j=0;
            Toast.makeText(context,  "Aqui " + sql, Toast.LENGTH_SHORT).show();

            if (yr_mv_fila.moveToFirst())
            {
                do{
                    Toast.makeText(context, "aca", Toast.LENGTH_SHORT).show();
                    YR_MV_Usuarios yr_mv_usuarios1= new YR_MV_Usuarios();
                    int i=0;
                    yr_mv_usuarios1.setIdusuario(yr_mv_fila.getInt(0));
                    yr_mv_usuarios1.setCorreo(yr_mv_fila.getString(1));
                    yr_mv_usuarios[j]=yr_mv_usuarios1;
                    j++;
                }while(yr_mv_fila.moveToNext());



            }
            yr_mv_baseDatos.close();
        }catch (SQLiteException  e){
            Toast.makeText(context,  e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return  yr_mv_usuarios;
    }

}
