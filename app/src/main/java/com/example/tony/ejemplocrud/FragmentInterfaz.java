package com.example.tony.ejemplocrud;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInterfaz extends Fragment {

    private EditText et1, et2, et3, et4;
    private Button alta, baja, modificacion, consulta, listado;
    AdministrarCrudDB crud;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View vista =inflater.inflate(R.layout.fragment_fragment_interfaz, container, false);
        // proviene del layout, son los campos de texto
        et1 = (EditText)vista.findViewById(R.id.editText1);
        et2 = (EditText)vista. findViewById(R.id.editText2);
        et3 = (EditText) vista.findViewById(R.id.editText3);
        et4 = (EditText) vista.findViewById(R.id.editText4);
        alta = (Button) vista.findViewById(R.id.button);
        baja = (Button) vista.findViewById(R.id.button3);
        modificacion = (Button)vista. findViewById(R.id.button4);
        consulta = (Button) vista.findViewById(R.id.button2);
        listado = (Button) vista.findViewById(R.id.bClientes);


        crud = new AdministrarCrudDB(getContext(), "",null, 1 );

//CRUD (create(crear), read(leer), update(actualizar/modificar), delete(eliminar/borrar))



        //metodo para dar el alta
        alta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    crud.insertar_contactos(et1.getText().toString(),
                            et2.getText().toString(),
                            et3.getText().toString(),
                            et4.getText().toString());
                    Toast.makeText(getContext(), "Datos de contacto"
                            +"\n"
                            + et1.getText().toString() +"\n"
                            + et2.getText().toString() +"\n"
                            + et3.getText().toString() +"\n"
                            + et4.getText().toString() +"\n"
                            +"\n cargados", Toast.LENGTH_SHORT).show();
                    // ponemos los campos a vacío para insertar el siguiente usuario

                    et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");
                }catch(SQLiteException e){

                    Toast.makeText(getContext(), "contacto ya existe", Toast.LENGTH_SHORT).show();
                }


            }    });
        //metodo para dar de baja
        baja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bajaDNI();
                //crud.eliminar_contactos(et1.getText().toString());
            }
        });
        //metodo para modificar
        modificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                crud.modificar_contactos(et1.getText().toString(),
                        et2.getText().toString(),
                        et3.getText().toString(),
                        et4.getText().toString());

                Toast.makeText(getContext(), "Datos de contacto"
                        +"\n"
                        + et1.getText().toString() +"\n"
                        + et2.getText().toString() +"\n"
                        + et3.getText().toString() +"\n"
                        + et4.getText().toString() +"\n"
                        +"\n modificados", Toast.LENGTH_SHORT).show();
                et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");


            }
        });
        //metodo para la consulta
        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { consultaDNI();

            }
        });

        listado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaClientes nuevoClientes = new ListaClientes();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,
                        nuevoClientes).addToBackStack(null).commit();

            }
        });


        return vista;
    }
    public  void bajaDNI(){
        String dniconsulta = et1.getText().toString();
        AdministrarCrudDB admin = new AdministrarCrudDB(getContext(),

                "administracion.db", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();

        // aquí borro la base de datos del usuario por el dni
        int cant = bd.delete("contactos", "dni=" +  dniconsulta, null);
        bd.close();

        if (cant == 1) {

            Toast.makeText(getContext(), "Contacto eliminado",

                    Toast.LENGTH_SHORT).show();

            et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");

        } else

            Toast.makeText(getContext(),
                    "No existe contacto con dni : " + dniconsulta,

                    Toast.LENGTH_SHORT).show();}



    public  void consultaDNI(){


        String dniconsulta = et1.getText().toString();
        AdministrarCrudDB admin = new AdministrarCrudDB(getContext(),

                "administracion.db", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();

        Cursor fila = bd.rawQuery("select * from contactos where dni = " + dniconsulta, null);
        et2.setText("");
        et3.setText("");
        et4.setText("");
        if (fila != null) {
            if(fila.moveToFirst()){
                et2.append(fila.getString(1));
                et3.append(fila.getString(2));
                et4.append(fila.getString(3));
                fila.close();
                bd.close();
            }
            else

                Toast.makeText(getContext(), "No existe ningún usuario con ese dni",

                        Toast.LENGTH_SHORT).show();

        }
    }

}
