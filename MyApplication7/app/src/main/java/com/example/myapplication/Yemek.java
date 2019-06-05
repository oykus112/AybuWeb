package com.example.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class Yemek extends Fragment {

    TextView Tarih,Yemek1,Yemek2,Yemek3,Yemek4;


    public Yemek() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_yemek, container, false);

        Tarih=(TextView) v.findViewById(R.id.tarih);
        Yemek1=(TextView) v.findViewById(R.id.yemek1);
        Yemek2=(TextView) v.findViewById(R.id.yemek2);
        Yemek3=(TextView) v.findViewById(R.id.yemek3);
        Yemek4=(TextView) v.findViewById(R.id.yemek4);

        check();




        return v;

    }


    public void check () {
        Thread t = new Thread(new Runnable() {
            Document doc;
            int size;
            Elements elements;


            @Override
            public void run() {
                try {
                    doc = Jsoup.connect("https://aybu.edu.tr/sks/").get();

                    getActivity().runOnUiThread(new Runnable(){
                        @Override
                        public void run() {


                            elements = doc.getElementsByTag("td");
                            String[] yemek = new String[elements.size()];

                            for (int size = 0; size < elements.size(); size++) {
                                yemek[size] = elements.get(size).text();
                            }

                            Tarih.setText(""+yemek[2]);
                            System.out.println(""+yemek[2]);
                            Yemek1.setText(""+yemek[3]);
                            Yemek2.setText(""+yemek[4]);
                            Yemek3.setText(""+yemek[5]);
                            Yemek4.setText(""+yemek[6]);

                        }

                    });


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        });
        t.start();
    }

}
