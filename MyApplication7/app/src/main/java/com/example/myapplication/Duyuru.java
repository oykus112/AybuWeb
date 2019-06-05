package com.example.myapplication;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class Duyuru extends Fragment {
    Button b1,b2,b3,b4,b5,b6;
    TextView url1,url2,url3,url4,url5,url6;


    public Duyuru() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_duyuru, container, false);
        b1=v.findViewById(R.id.url1_button);
        url1=v.findViewById(R.id.url1);
        b2=v.findViewById(R.id.url2_button);
        url2=v.findViewById(R.id.url2);
        b3=v.findViewById(R.id.url3_button);
        url3=v.findViewById(R.id.url3);
        b4=v.findViewById(R.id.url4_button);
        url4=v.findViewById(R.id.url4);
        b5=v.findViewById(R.id.url5_button);
        url5=v.findViewById(R.id.url5);
        b6=v.findViewById(R.id.url6_button);
        url6=v.findViewById(R.id.url6);

        pager();


        return v;
    }

    public void pager(){

        Thread t1 = new Thread(new Runnable() {
            Document doc;
            Element element;
            Elements elements;


            @Override
            public void run() {
                try {
                    doc = Jsoup.connect("https://aybu.edu.tr/muhendislik/bilgisayar/").get();



                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                            elements = doc.select("a[href]");
                            String[] Urls_subject = new String[elements.size()];
                            final String[] Urls = new String[elements.size()];

                            for (int size = 0; size < elements.size(); size++) {
                                Urls_subject[size] = elements.get(size).text();
                            }

                            for (int size = 0; size < elements.size(); size++) {
                                Urls[size] = elements.get(size).attr("abs:href");
                            }







                            System.out.println("budur:"+Urls[38]);
                            url1.setText(Urls_subject[38]);
                            url2.setText(Urls_subject[39]);
                            url3.setText(Urls_subject[40]);
                            url4.setText(Urls_subject[41]);
                            url5.setText(Urls_subject[42]);
                            url6.setText(Urls_subject[43]);


                            b1.setOnClickListener(new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    String url = ""+Urls[38]; Intent i = new Intent(Intent.ACTION_VIEW); i.setData(Uri.parse(url)); startActivity(i);
                                }
                            });
                            b2.setOnClickListener(new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    String url = ""+Urls[39]; Intent i = new Intent(Intent.ACTION_VIEW); i.setData(Uri.parse(url)); startActivity(i);
                                }
                            });
                            b3.setOnClickListener(new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    String url = ""+Urls[40]; Intent i = new Intent(Intent.ACTION_VIEW); i.setData(Uri.parse(url)); startActivity(i);
                                }
                            });
                            b4.setOnClickListener(new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    String url = ""+Urls[41]; Intent i = new Intent(Intent.ACTION_VIEW); i.setData(Uri.parse(url)); startActivity(i);
                                }
                            });
                            b5.setOnClickListener(new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    String url = ""+Urls[42]; Intent i = new Intent(Intent.ACTION_VIEW); i.setData(Uri.parse(url)); startActivity(i);
                                }
                            });
                            b6.setOnClickListener(new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    String url = ""+Urls[43]; Intent i = new Intent(Intent.ACTION_VIEW); i.setData(Uri.parse(url)); startActivity(i);
                                }
                            });





                        }



                    });




                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        });
        t1.start();

    }

}
