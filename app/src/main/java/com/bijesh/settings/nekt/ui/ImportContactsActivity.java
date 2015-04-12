package com.bijesh.settings.nekt.ui;

import android.app.Dialog;
import android.content.DialogInterface;
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
import android.widget.Toast;


import com.bijesh.settings.R;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by Bijesh on 11-04-2015.
 */
public class ImportContactsActivity extends FragmentActivity {

    private static final String TAG = ImportContactsActivity.class.getCanonicalName();
    private TextView mTxtViewHeader;
    private Button mBtnSkip;
    MaterialDialog mMaterialDialog;


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
        setListeners();
    }

    public void init(View v) {
        mMaterialDialog = new MaterialDialog(this);

//        Toast.makeText(getApplicationContext(), "Initializes successfully.", Toast.LENGTH_SHORT).show();
    }

    private void setListeners(){
        mBtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Log.d(TAG,"show dialog");
//              showBasicNoTitle();
                show(v);
            }
        });
    }


    public void show(View v) {
        init(v);
        if (mMaterialDialog != null) {
            String title  = "<font color='#2f928e'>One Address! </font>";
//            txtHeader.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            mMaterialDialog.setTitle("Thank you!")
                    .setMessage(
                            "We are importing your contacts to your dropbox. It will take sometime. Meanwhile, please " +
                                    "import other networks contacts to get awesome experience"
                    )
                            //mMaterialDialog.setBackgroundResource(R.drawable.background);
                    .setPositiveButton(
                            "Okay, Got it", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mMaterialDialog.dismiss();
//                                    Toast.makeText(ImportContactsActivity.this, "Ok", Toast.LENGTH_LONG).show();

                                }
                            }
                    )
//                    .setNegativeButton(
//                            "CANCLE", new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    mMaterialDialog.dismiss();
//                                    Toast.makeText(ImportContactsActivity.this, "Cancle", Toast.LENGTH_LONG).show();
//                                }
//                            }
//                    )
                    .setCanceledOnTouchOutside(false)
                            // You can change the message anytime.
                            // mMaterialDialog.setTitle("提示");
                    .setOnDismissListener(
                            new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
//                                    Toast.makeText(ImportContactsActivity.this, "onDismiss", Toast.LENGTH_SHORT).show();
                                }
                            }
                    )
                    .show();
            // You can change the message anytime.
            // mMaterialDialog.setMessage("嗨！这是一个 MaterialDialog. 它非常方便使用，你只需将它实例化，这个美观的对话框便会自动地显示出来。它简洁小巧，完全遵照 Google 2014 年发布的 Material Design 风格，希望你能喜欢它！^ ^");
        } else {
//            Toast.makeText(getApplicationContext(), "You should init firstly!", Toast.LENGTH_SHORT).show();
        }
    }


//    private void showBasicNoTitle() {
//        new MaterialDialog.Builder(this)
//                .content("App want to share location")
//                .positiveText("agree")
//                .negativeText("disagree")
//                .show();
//    }

}
