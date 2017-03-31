package com.example.user.app1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 26/03/2017.
 */

public class BancoDados extends SQLiteOpenHelper {


    public BancoDados(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /*public BancoDados(DBActivity dbActivity, String nomeDoBanco, int i) {
        super(dbActivity, , i);
    }*/

    @Override
    public void onCreate(SQLiteDatabase sqld){

        sqld.execSQL("CREATE TABLE usuarios ("
                + "id INTEGER PRIMARY KEY autoincrement,"
                + "tipo NOT NULL,"
                + "descricaoProduto NOT NULL,"
                + "local NOT NULL,"
                + "valorProduto NOT NULL,"
                + "data NOT NULL,"
                + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqld, int i, int i1){
        //TODO
    }
}
