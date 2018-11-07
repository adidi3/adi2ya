package com.example.adipe.adi2ya;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button a1, a2, a3;
    AlertDialog.Builder ad;
    LinearLayout l;
    CharSequence[] clr={"Red","Green","Blue"};
    int[] color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = (LinearLayout) findViewById(R.id.lll);
        a1 = (Button) findViewById(R.id.b1);
        a2 = (Button) findViewById(R.id.b2);
        a3 = (Button) findViewById(R.id.b3);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int eo= item.getItemId();
        if (eo==R.id.credse){
            Intent r= new Intent(this, cred.class);
            startActivity(r);}
        return super.onOptionsItemSelected(item);
    }



    public void b1(View view) {

        ad=new AlertDialog.Builder(this);
        LayoutInflater dialogInterface=this.getLayoutInflater();
        ad.setTitle("שינוי רקע, בחר צבע אחד");
        ad.setItems(clr, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i==0)
                    l.setBackgroundColor(Color.RED);
                if (i==2)
                    l.setBackgroundColor(Color.BLUE);
                if (i==1)
                    l.setBackgroundColor(Color.GREEN);
            }
        });
        ad.setNeutralButton("cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        ad.setPositiveButton("reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                l.setBackgroundColor(Color.WHITE);
            }
        });
        AlertDialog adb=ad.create();
        adb.show();
    }




    public void b2(View view) {
        ad=new AlertDialog.Builder(this);
        color= new int[]{0,0,0};
        //LayoutInflater dialogInterface=this.getLayoutInflater();
        ad.setTitle("שינוי רקע, בחירה מרובה");
        ad.setMultiChoiceItems(clr, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if (b)
                    if(color[i] == 0){
                        color[i]=255;
                    }
                    else if(color[i] == 255) {
                        color[i] = 0;
                    }
            }
        });
        
        ad.setNeutralButton("cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        ad.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                l.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
            });

            AlertDialog a = ad.create();
        a.show();


    }
    public void b3(View view) {
        l.setBackgroundColor(Color.WHITE);

    }

}

