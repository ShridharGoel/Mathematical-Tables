package com.dsapps.mathematicaltables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    public void generateTable(int table)
    {
        List list=new ArrayList();
        for(int i=1;i<=10;i++)
        {
            list.add(i*table);
        }

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        listView.setAdapter(arrayAdapter);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar=(SeekBar) findViewById(R.id.seekBar);
        listView=(ListView) findViewById(R.id.tableList);

        seekBar.setMax(20);
        seekBar.setProgress(10);

        generateTable(10);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min=1;
                int table;

                if(i<min)
                {
                    table=min;
                    seekBar.setProgress(min);

                }
                else
                {
                    table=i;
                }

                generateTable(table);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        });

    }
}
