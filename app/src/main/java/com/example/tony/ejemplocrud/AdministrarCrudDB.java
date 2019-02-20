package com.example.tony.ejemplocrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class AdministrarCrudDB extends SQLiteOpenHelper {

    public AdministrarCrudDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // aqui creamos las tablas
        db.execSQL("create table usuario(dni integer primary key, nombre text, cuidad text, telefono integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists usuario");
        db.execSQL("create table usuario(dni integer primary key, nombre text, cuidad text, telefono integer)");


    }


}
