package com.example.sozlukuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private VeritabaniYardimcisi vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vt=new VeritabaniYardimcisi(this);

       /*
         //INSERT iŞLEMLERİ
        new Kelimelerdao().kelimeEkle(vt,"door","kapı");
        new Kelimelerdao().kelimeEkle(vt,"pencil","kalem");
        new Kelimelerdao().kelimeEkle(vt,"window","pencere");
        new Kelimelerdao().kelimeEkle(vt,"sea","deniz");
        new Kelimelerdao().kelimeEkle(vt,"table","masa");*/

      // new Kelimelerdao().kelimeSil(vt,4);  // DELETE
      // new Kelimelerdao().kelimeGuncelle(vt,3,"windowxxxxx","pencerexxxx");  //UPDATE

        //veri sayar
        int sonuc=new Kelimelerdao().sayiKontrol(vt);
        Log.e("veri sayısı: ",String.valueOf(sonuc));
        //ilgili kelimeyi getirir
        Kelimeler kelime=new Kelimelerdao().kelimeGetir(vt,5);
        Log.e("Kelime: ",kelime.getKelime_id()+" - "+kelime.getIngilizce()+" - "+kelime.getTurkce());

        //tüm veriler ekrana gelir
        ArrayList<Kelimeler> gelenKelimelerListesi=new Kelimelerdao().tumkelimeler(vt);
        for (Kelimeler k: gelenKelimelerListesi){
            Log.e(String.valueOf(k.getKelime_id()),k.getIngilizce()+" - "+k.getTurkce());
        }

        //kelime Arama yapılır
        ArrayList<Kelimeler> gelenKelimelerListara=new Kelimelerdao().kelimeArama(vt,"p");
        for (Kelimeler k: gelenKelimelerListara){
            Log.e(String.valueOf(k.getKelime_id()),k.getIngilizce()+" - "+k.getTurkce());
        }
    }
}
