package com.bijesh.settings.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bijesh.settings.R;

import java.util.ArrayList;



/**
 * Created by Bijesh on 29-03-2015.
 *
 * References
 *
 * http://stackoverflow.com/questions/26448717/android-5-0-add-header-footer-to-a-recyclerview
 */
public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder> {

    private static final String TAG = SettingsAdapter.class.getCanonicalName();
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;
    private ArrayList<String> mDataSet;

    public SettingsAdapter(ArrayList<String> mDataSet){
        this.mDataSet = mDataSet;
    }

    @Override
    public SettingsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = null;
        if(viewType == 0){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_settings_row_header, viewGroup, false);
        }else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_settings_row, viewGroup, false);

        }
        SettingsViewHolder viewHolder = new SettingsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SettingsViewHolder settingsViewHolder, int viewType) {
        final String name = mDataSet.get(viewType);
        settingsViewHolder.textView.setText(mDataSet.get(viewType));

    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_HEADER;
        }else {
            return TYPE_FOOTER;
        }

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    class SettingsViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;

        public SettingsViewHolder(View itemView) {
            super(itemView);

                imageView = (ImageView) itemView.findViewById(R.id.image);
                textView = (TextView) itemView.findViewById(R.id.text);

        }

        public void add(int position,String item){
            mDataSet.add(position,item);
            notifyItemInserted(position);
        }

    }

}
