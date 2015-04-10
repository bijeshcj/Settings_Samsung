package com.bijesh.settings;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bijesh.settings.adapters.SettingsAdapter;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();
    private RecyclerView mRecyclerView;
    private SettingsAdapter mSettingsAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> mDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_settings);
        initComponents();
    }

    private void initComponents(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        populateDataSet();

        mSettingsAdapter = new SettingsAdapter(mDataSet);
        mRecyclerView.setAdapter(mSettingsAdapter);
    }

    private void populateDataSet(){
        mDataSet = new ArrayList<>();
        mDataSet.add("Wireless and networks");
        mDataSet.add("Wi-Fi");
        mDataSet.add("Bluetooth");
        mDataSet.add("Data usage");
        mDataSet.add("More settings");

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
