package com.example.tony.ejemplocrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

public class AdministrarCrudDB extends SQLiteOpenHelper {
    private static final String MI_BASE_DE_DATOS = "administracion.db";
    private static final int DATABASE_VERSION = 1;

    // Sentencia SQL para la creación de una tabla
    private static final String TABLA_CONTACTOS = "CREATE TABLE contactos" +
            "(dni INT PRIMARY KEY, nombre TEXT, ciudad TEXT, telefono INT)";

    public AdministrarCrudDB(Context context, String s, Object o, int i) {
        super(context, MI_BASE_DE_DATOS, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // aqui creamos las tablas
        db.execSQL(TABLA_CONTACTOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS contactos");
        onCreate(db);

    }

    public void insertar_contactos(String dni, String nombre, String ciudad, String telefono) {
        ContentValues registro = new ContentValues();
        registro.put("dni", dni);
        registro.put("nombre", nombre);
        registro.put("ciudad", ciudad);
        registro.put("telefono", telefono);
        this.getWritableDatabase().insertOrThrow("contactos", "", registro);

    }

    public void eliminar_contactos(String dnconsultai) {
        int i = this.getWritableDatabase().delete("contactos", "dni=´" + dnconsultai + "'", null);
        if(i == 1 ){


        }


    }

        public void modificar_contactos(String dniConsulta, String nombre, String ciudad, String telefono) {
        this.getWritableDatabase().execSQL
                ("UPDATE contactos SET nombre='" + nombre + "' " +
                        ", ciudad='" + ciudad + "' " +
                        ", telefono='" + telefono + "' " +
                        "WHERE dni='" + dniConsulta + "'");
    }


}