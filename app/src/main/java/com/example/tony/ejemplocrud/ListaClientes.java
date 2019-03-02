package com.example.tony.ejemplocrud;


import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaClientes extends Fragment {
    private EditText et1, et2, et3, et4;
    AdministrarCrudDB crud;
    ListView lista;
    ArrayAdapter<String> adaptador;
    ArrayList<String> datos = new ArrayList<>();

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_lista_clientes, container, false);
        crud = new AdministrarCrudDB(getContext(), "",null, 1 );
        //datos[0] = String.valueOf((EditText)vista.findViewById(R.id.tvtDNI));
        //datos[1] = String.valueOf((EditText)vista.findViewById(R.id.tvtNOMBRE));
        //datos[2] = String.valueOf((EditText)vista.findViewById(R.id.tvtCiudad));
        //datos[3] = String.valueOf((EditText)vista.findViewById(R.id.tvtTelefono));
        lista = (ListView)vista.findViewById(R.id.listaClientes);


        //lista.setAdapter(adaptador);

        AdministrarCrudDB admin = new AdministrarCrudDB(getContext(),

                "administracion.db", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();

        Cursor fila = bd.rawQuery("select * from contactos" , null);
        //adaptador = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, datos);

      /* if (fila != null) {
            while(fila.moveToFirst()){
                adaptador.add("DNI ="+fila.getString(0)  +" \n" + "NOMBRE   ="+fila.getString(1)
                     +" \n"+ "CIUDAD ="     + fila.getString(2) +" \n" + "TELEFONO ="+fila.getString(3)
                     +" \n");

                lista.setAdapter(adaptador);

                fila.close();
                bd.close();
            }

        }else

            Toast.makeText(getContext(), "No existe ningún usuario",

                    Toast.LENGTH_SHORT).show();*/
        if(fila.moveToFirst()){
            do{
                datos.add("DNI ="+fila.getString(0)  +" \n" + "NOMBRE   ="+fila.getString(1)
                        +" \n"+ "CIUDAD ="     + fila.getString(2) +" \n" + "TELEFONO ="+fila.getString(3)
                        +" \n");
            }while(fila.moveToNext());
        }
        bd.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, datos);
        lista.setAdapter(adapter);


        return vista;
    }

}
