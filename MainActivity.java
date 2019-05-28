package in.suriya.timestableapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;

    public void generatetimestable(int timetable){

        ArrayList<String> timetablecontent = new ArrayList<String>();
        for (int i=1;i<10;i++){
            timetablecontent.add(Integer.toString(i*timetable));
        }
        ArrayAdapter<String>adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,timetablecontent);
        timesTableListView.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timestableseekbar = (SeekBar)findViewById(R.id.timesTableSeekBar);
         timesTableListView = (ListView)findViewById(R.id.timesTableListView);

        timestableseekbar.setMax(20);
        timestableseekbar.setProgress(10);

        timestableseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1;
                int timesTable;

                if (progress<min){

                    timesTable=min;
                    timestableseekbar.setProgress(min);
                }else {
                    timesTable =progress;
                }

                generatetimestable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generatetimestable(10);
    }
}
