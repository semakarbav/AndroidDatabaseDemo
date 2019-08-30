package com.example.sozlukuygulama;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VeritabaniYardimcisi extends SQLiteOpenHelper {
    public VeritabaniYardimcisi(Context context) {
        super(context ,"sozluk" ,null ,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE kelimeler (\n" +
                "\t kelime_id \tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t ingilizce \tTEXT,\n" +
                "\t turkce \tTEXT\n" +
                ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS kelimeler");
        onCreate(sqLiteDatabase);

    }
}
