package com.bijesh.settings.nekt.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.bijesh.settings.R;

/**
 * Created by Bijesh on 11-04-2015.
 */
public class ImportContactsActivity extends FragmentActivity {

    private static final String TAG = ImportContactsActivity.class.getCanonicalName();
    private TextView mTxtViewHeader;
    private Button mBtnSkip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_contacts);
        initComponents();
//        openTutorial();
        onCoachMark();
    }


    public void onCoachMark(){

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_coach_mark);
        dialog.setCanceledOnTouchOutside(true);
        //for dismissing anywhere you touch
        View masterView = dialog.findViewById(R.id.coach_mark_master_view);
        masterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                mBtnSkip.setVisibility(View.VISIBLE);
            }
        });
        dialog.show();
    }


    private void initComponents(){
        mTxtViewHeader = (TextView)findViewById(R.id.header_title);
        String styledText = "<font color='#2f928e'>Hey! Welcome to <b>Nekt</b> </font>";
        mTxtViewHeader.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
        mBtnSkip = (Button)findViewById(R.id.btnSkip);
        mBtnSkip.setVisibility(View.GONE);
//
    }
}
