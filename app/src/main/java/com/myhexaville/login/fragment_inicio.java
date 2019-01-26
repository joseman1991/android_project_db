package com.myhexaville.login;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;




public class fragment_inicio extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER




    private String lenguajeProgramacion[]=new String[]{"Java","PHP","Python","JavaScript","Ruby","C",
            "Go","Perl","Pascal"};

    private Integer[] imgid={
            R.drawable.java,
            R.drawable.php,
            R.drawable.python,
            R.drawable.javascript,
            R.drawable.ruby,
            R.drawable.c,
            R.drawable.go,
            R.drawable.perl,
            R.drawable.pascal
    };

    private ListView lista;



    public fragment_inicio() {



        // Required empty public constructor
    }




    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     .
     */
    // TODO: Rename and change types and number of parameters




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        // Inflate the layout for this fragment

        try {
            LenguajeListAdapter adapter=new LenguajeListAdapter(getActivity(),lenguajeProgramacion,imgid);

            lista=(ListView)view. findViewById(R.id.mi_lista);
            lista.setAdapter(adapter);
            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String Slecteditem= lenguajeProgramacion[+position];
                    Toast.makeText(getContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception w){
            Toast.makeText(getContext(),  ""+getActivity(), Toast.LENGTH_SHORT).show();
        }


        return view;
    }
}
