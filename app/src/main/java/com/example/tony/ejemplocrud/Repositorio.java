package com.example.tony.ejemplocrud;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Repositorio {


    //nada de esto usaremos aun
    // para llave remota
    // if(usuario.equals()&& contrase.equals()){
    //getActivity.starActivity(pasar);
    // }
    //else {
    // Toast....getAplicaContext...(usuario o contraseña incorrectos    )
    // }


    // insert
    /*SQLiteDatabase sqLiteDatabase = sqLiteDBHelper.getWritableDatabase();
    ContentValues contentValues = new ContentValues();

    String categoryName = "Android";
    // Insert data into category table first.
    contentValues.put("category_name", categoryName);
    sqLiteDatabase.insert(SQLiteDBHelper.CATEGORY_TABLE_NAME, null, contentValues);
    */


    // UPDATE
    /*SQLiteDatabase sqLiteDatabase = sqLiteDBHelper.getWritableDatabase();
    ContentValues contentValues = new ContentValues();

    contentValues.put("price", 66);
    sqLiteDatabase.update(SQLiteDBHelper.BOOK_TABLE_NAME, contentValues, "title = ?", new String[]{"Learn Android In 21 Days."});
    *
    * */
 /*   public  void modificacionCOntactos(){

        AdministrarCrudDB admin = new AdministrarCrudDB(getApplicationContext(),

                "administracion.db", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();


        // actualizamos con los nuevos datos, la información cambiada
        registro.put("nombre", et2.getText().toString());
        registro.put("ciudad", et3.getText().toString());
        registro.put("numero", et4.getText().toString());


        int cant = bd.update("contactos", registro, "dni=" + et1.getText().toString(), null);

        bd.close();

        if (cant == 1) {

            Toast.makeText(getApplicationContext(),
                    "Datos de contacto con dni :  "+
                            et1.getText().toString()+ "  modificados con éxito",
                    Toast.LENGTH_SHORT).show();

        }else

            Toast.makeText(getApplicationContext(), "No existe contacto",

                    Toast.LENGTH_SHORT).show();
    }

*/
 /*
 * public  void altaContactos(){
        AdministrarCrudDB admin = new AdministrarCrudDB(getApplicationContext(),

                "administracion.db", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();
        if (bd != null){
            ContentValues registro = new ContentValues();

            registro.put("dni"   , et1.getText().toString());
            registro.put("nombre", et2.getText().toString());
            registro.put("ciudad", et3.getText().toString());
            registro.put("numero", et4.getText().toString());

            // los inserto en la base de datos
            bd.insert("contactos", null, registro);
            bd.close();
            Toast.makeText(getApplicationContext(), "Datos de contacto"
                    +"\n"
                    + et1.getText().toString() +"\n"
                    + et2.getText().toString() +"\n"
                    + et3.getText().toString() +"\n"
                    + et4.getText().toString() +"\n"
                    +"\n cargados", Toast.LENGTH_SHORT).show();
            // ponemos los campos a vacío para insertar el siguiente usuario

            et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");
        }
    }*/

    //DELETE
    /*
    *SQLiteDatabase sqLiteDatabase = sqLiteDBHelper.getWritableDatabase();
    sqLiteDatabase.delete(SQLiteDBHelper.BOOK_TABLE_NAME, " price = ?", new String[]{"99"});
    * */


    //Query
    /*SQLiteDatabase sqLiteDatabase = sqLiteDBHelper.getWritableDatabase();
    Cursor cursor = sqLiteDatabase.query(SQLiteDBHelper.BOOK_TABLE_NAME, null, null, null, null, null, null);
    * */
/*
*
* public void botones(View vista){
*
* switch(view.getId()){
*           case R.id.boton1:
*           break;
*
* /*public void eliminar_contactos(String dnconsultai) {
        this.getWritableDatabase().execSQL("DELETE contactos WHERE dni='"+dnconsultai+"'");
    }*/
/* }
*
* }
*public void eliminar_contactos(String dni) {
        this.getWritableDatabase().delete("contactos", "dni : ´" + dni + "'", null);
    }
* */
}
