package com.example.tony.ejemplocrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText et1, et2, et3, et4;
    private Button alta, baja, modificacion, consulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // proviene del layout, son los campos de texto
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        alta = (Button) findViewById(R.id.button);
        baja = (Button) findViewById(R.id.button3);
        modificacion = (Button) findViewById(R.id.button4);
        consulta = (Button) findViewById(R.id.button2);


//CRUD (create(crear), read(leer), update(actualizar/modificar), delete(eliminar/borrar))
        //metodo para dar el alta
        alta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdministrarCrudDB admin = new AdministrarCrudDB(getApplicationContext(),

                "administracion", null, 1);

                SQLiteDatabase bd = admin.getWritableDatabase();

                String dni    = et1.getText().toString();
                String nombre = et2.getText().toString();
                String ciudad = et3.getText().toString();
                String numero = et4.getText().toString();

                ContentValues registro = new ContentValues();

                registro.put("dni", dni);
                registro.put("nombre", nombre);
                registro.put("ciudad", ciudad);
                registro.put("numero", numero);

                // los inserto en la base de datos
                bd.insert("usuario", null, registro);

                bd.close();

                // ponemos los campos a vacío para insertar el siguiente usuario
                et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");

                Toast.makeText(getApplicationContext(), "Datos del usuario cargados", Toast.LENGTH_SHORT).show();

            }
        });

        //metodo para dar de baja
        baja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdministrarCrudDB admin = new AdministrarCrudDB(getApplicationContext(),

                        "administracion", null, 1);

                SQLiteDatabase bd = admin.getWritableDatabase();

                String dni = et1.getText().toString();

                // aquí borro la base de datos del usuario por el dni
                int cant = bd.delete("usuario", "dni=" + dni, null);

                bd.close();

                et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");

                if (cant == 1)

                    Toast.makeText(getApplicationContext(), "Usuario eliminado",

                            Toast.LENGTH_SHORT).show();

                else

                    Toast.makeText(getApplicationContext(), "No existe usuario",

                            Toast.LENGTH_SHORT).show();
            }
        });
        //metodo para modificar
        modificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdministrarCrudDB admin = new AdministrarCrudDB(getApplicationContext(),

                        "administracion", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();

                String dni    = et1.getText().toString();
                String nombre = et2.getText().toString();
                String ciudad = et3.getText().toString();
                String numero = et4.getText().toString();

                ContentValues registro = new ContentValues();

                // actualizamos con los nuevos datos, la información cambiada
                registro.put("nombre", nombre);
                registro.put("ciudad", ciudad);
                registro.put("numero", numero);

                int cant = bd.update("usuario", registro, "dni=" + dni, null);

                bd.close();

                if (cant == 1)

                    Toast.makeText(getApplicationContext(), "Datos modificados con éxito", Toast.LENGTH_SHORT)

                            .show();

                else

                    Toast.makeText(getApplicationContext(), "No existe usuario",

                            Toast.LENGTH_SHORT).show();
            }
        });


        //metodo para la consulta
    consulta.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AdministrarCrudDB admin = new AdministrarCrudDB(getApplicationContext(),

                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String dni = et1.getText().toString();

        Cursor fila = bd.rawQuery(

                "select nombre, ciudad, numero from usuario where dni=" + dni, null);

        if (fila.moveToFirst()) {

            et2.setText(fila.getString(1));
            et3.setText(fila.getString(2));
            et4.setText(fila.getString(3));

        } else

            Toast.makeText(getApplicationContext(), "No existe ningún usuario con ese dni",

                    Toast.LENGTH_SHORT).show();

        bd.close();


    }
});

    }
}
