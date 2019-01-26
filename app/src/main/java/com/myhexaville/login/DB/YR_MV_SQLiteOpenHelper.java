package com.myhexaville.login.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class YR_MV_SQLiteOpenHelper extends SQLiteOpenHelper
{
    private Context context;
    public YR_MV_SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Toast.makeText(context, getDatabaseName() , Toast.LENGTH_SHORT).show();

        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase myBase)
    {
        Toast.makeText(context, "acas", Toast.LENGTH_SHORT).show();

        if(myBase.isReadOnly()){
            myBase=getWritableDatabase();
            Toast.makeText(context, "aquis" +getDatabaseName(), Toast.LENGTH_SHORT).show();

        }
        try {

            //myBase.execSQL("insert into perfiles values(1,'Adminisitrasor');");
          //  myBase.execSQL("insert into perfiles values(2,'Cliente');");

            myBase.execSQL("create table if not exists usuario(idusuario INTEGER primary key, correo TEXT not null unique ,clave TEXT not null, idperfil INTEGER not null default 2);");
        }catch (SQLiteException e){
            Toast.makeText(context,  e.getMessage(), Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    }
}
