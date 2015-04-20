package com.bijesh.settings.nekt.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bijesh.settings.R;


import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by Bijesh on 11-04-2015.
 */
public class ImportContactsActivity extends FragmentActivity implements ImportContactsAsync.ImportContactsListener,
        View.OnClickListener {

    private static final String TAG = ImportContactsActivity.class.getCanonicalName();
    private TextView mTxtViewHeader;
    private Button mBtnSkip;
    MaterialDialog mMaterialDialog;

    private FrameLayout mImportFaceBookContacts = null;

    private TextIndicatedCircleProgressBar mImportFaceBookProgressBar = null;

    private FrameLayout mImportTwitterContacts = null;

    private TextIndicatedCircleProgressBar mImportTwitterProgressBar = null;

    private FrameLayout mImportLinkedInContacts = null;

    private TextIndicatedCircleProgressBar mImportLinkedInProgressBar = null;

    private FrameLayout mImportWhatsAppContacts = null;

    private TextIndicatedCircleProgressBar mImportWhatsAppProgressBar = null;

    private FrameLayout mImportGmailContacts = null;

    private TextIndicatedCircleProgressBar mImportGmailProgressBar = null;

    private FrameLayout mImportPhoneBookContacts = null;

    private TextIndicatedCircleProgressBar mImportPhoneBookProgressBar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_contacts);

        initComponents();
        initImportContactButtons();
//        openTutorial();
        onCoachMark();
    }


    public void onCoachMark() {

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


    private void initComponents() {
        mTxtViewHeader = (TextView) findViewById(R.id.header_title);
        String styledText = "<font color='#2f928e'>Hey! Welcome to <b>Nekt</b> </font>";
        mTxtViewHeader.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
        mBtnSkip = (Button) findViewById(R.id.btnSkip);
        mBtnSkip.setVisibility(View.GONE);
        setListeners();
    }

    public void init(View v) {
        mMaterialDialog = new MaterialDialog(this);

//        Toast.makeText(getApplicationContext(), "Initializes successfully.", Toast.LENGTH_SHORT).show();
    }

    private void setListeners() {
        mBtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "show dialog");
//              showBasicNoTitle();
                show(v);
            }
        });
    }


    public void show(View v) {
        init(v);
        if (mMaterialDialog != null) {
            String title = "<font color='#2f928e'>One Address! </font>";
//            txtHeader.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            mMaterialDialog.setTitle("Thank you!")
                    .setMessage(
                            "We are importing your contacts to your dropbox. It will take sometime. Meanwhile, please" +
                                    " " +
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
//                                    Toast.makeText(ImportContactsActivity.this, "onDismiss", Toast.LENGTH_SHORT)
// .show();
                                }
                            }
                    )
                    .show();
            // You can change the message anytime.
            // mMaterialDialog.setMessage("嗨！这是一个 MaterialDialog. 它非常方便使用，你只需将它实例化，这个美观的对话框便会自动地显示出来。它简洁小巧，完全遵照
            // Google 2014 年发布的 Material Design 风格，希望你能喜欢它！^ ^");
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

    private void initImportContactButtons() {
        mImportFaceBookContacts = (FrameLayout) findViewById(R.id.importContact_facebook);
        mImportFaceBookContacts.setOnClickListener(this);
        mImportFaceBookProgressBar = (TextIndicatedCircleProgressBar) mImportFaceBookContacts.findViewById(
                R.id.socialNetworkTitle_importProgressBar);

        mImportTwitterContacts = (FrameLayout) findViewById(R.id.importContact_twitter);
        mImportTwitterContacts.setOnClickListener(this);
        mImportTwitterProgressBar = (TextIndicatedCircleProgressBar) mImportTwitterContacts.findViewById(
                R.id.socialNetworkTitle_importProgressBar);

        mImportLinkedInContacts = (FrameLayout) findViewById(R.id.importContact_linkedIn);
        mImportLinkedInContacts.setOnClickListener(this);
        mImportLinkedInProgressBar = (TextIndicatedCircleProgressBar) mImportLinkedInContacts.findViewById(
                R.id.socialNetworkTitle_importProgressBar);

        mImportWhatsAppContacts = (FrameLayout) findViewById(R.id.importContact_whatsApp);
        mImportWhatsAppContacts.setOnClickListener(this);
        mImportWhatsAppProgressBar = (TextIndicatedCircleProgressBar) mImportWhatsAppContacts.findViewById(
                R.id.socialNetworkTitle_importProgressBar);

        mImportGmailContacts = (FrameLayout) findViewById(R.id.importContact_gmail);
        mImportGmailContacts.setOnClickListener(this);
        mImportGmailProgressBar = (TextIndicatedCircleProgressBar) mImportGmailContacts.findViewById(
                R.id.socialNetworkTitle_importProgressBar);

        mImportPhoneBookContacts = (FrameLayout) findViewById(R.id.importContact_phoneBook);
        mImportPhoneBookContacts.setOnClickListener(this);
        mImportPhoneBookProgressBar = (TextIndicatedCircleProgressBar) mImportPhoneBookContacts.findViewById(
                R.id.socialNetworkTitle_importProgressBar);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.importContact_facebook:
                ImportContactsAsync importFaceBookContacts = new ImportContactsAsync(
                        ImportContactsAsync.SocialNetwork.FACEBOOK);
                importFaceBookContacts.setOnImportedListener(this);
                importFaceBookContacts.execute();
                break;

            case R.id.importContact_twitter:
                ImportContactsAsync importTwitterContacts = new ImportContactsAsync(
                        ImportContactsAsync.SocialNetwork.TWITTER);
                importTwitterContacts.setOnImportedListener(this);
                importTwitterContacts.execute();
                break;

            case R.id.importContact_linkedIn:
                ImportContactsAsync importLinkedInContacts = new ImportContactsAsync(
                        ImportContactsAsync.SocialNetwork.LINKED_IN);
                importLinkedInContacts.setOnImportedListener(this);
                importLinkedInContacts.execute();
                break;

            case R.id.importContact_whatsApp:
                ImportContactsAsync importWhatsAppContacts = new ImportContactsAsync(
                        ImportContactsAsync.SocialNetwork.WHATSAPP);
                importWhatsAppContacts.setOnImportedListener(this);
                importWhatsAppContacts.execute();
                break;

            case R.id.importContact_gmail:
                ImportContactsAsync importGmailContacts = new ImportContactsAsync(
                        ImportContactsAsync.SocialNetwork.GMAIL);
                importGmailContacts.setOnImportedListener(this);
                importGmailContacts.execute();
                break;

            case R.id.importContact_phoneBook:
                ImportContactsAsync importPhoneBookContacts = new ImportContactsAsync(
                        ImportContactsAsync.SocialNetwork.PHONE_BOOK);
                importPhoneBookContacts.setOnImportedListener(this);
                importPhoneBookContacts.execute();
                break;

            default:
                break;
        }
    }


    private void showImportCompleted(View parent) {
        View frontView = (View) parent.findViewById(R.id.socialNetworkTitle_importProgressBar);
        View backView = (View) parent.findViewById(R.id.socialNetworkTitle_iv_importCompleted);

        FlipAnimation flipAnimation = new FlipAnimation(frontView, backView);

        // for reverse animation. below code is for reference if the reverse animation is needed.
        /*if (frontView.getVisibility() == View.GONE) {
            flipAnimation.reverse();
        }*/
        parent.startAnimation(flipAnimation);
    }

    @Override
    public void onDownloadingContacts(ImportContactsAsync.SocialNetwork network, int progress) {
        switch (network) {
            case FACEBOOK:
                mImportFaceBookProgressBar.setProgress(progress);
                break;

            case TWITTER:
                mImportTwitterProgressBar.setProgress(progress);
                break;

            case LINKED_IN:
                mImportLinkedInProgressBar.setProgress(progress);
                break;

            case WHATSAPP:
                mImportWhatsAppProgressBar.setProgress(progress);
                break;

            case GMAIL:
                mImportGmailProgressBar.setProgress(progress);
                break;

            case PHONE_BOOK:
                mImportPhoneBookProgressBar.setProgress(progress);
                break;
        }
    }

    @Override
    public void onImportCompleted(ImportContactsAsync.SocialNetwork network, String[] contacts) {
        switch (network) {
            case FACEBOOK:
                mImportFaceBookProgressBar.setProgress(100);
                showImportCompleted(mImportFaceBookContacts);
                break;

            case TWITTER:
                mImportTwitterProgressBar.setProgress(100);
                showImportCompleted(mImportTwitterContacts);
                break;

            case LINKED_IN:
                mImportLinkedInProgressBar.setProgress(100);
                showImportCompleted(mImportLinkedInContacts);
                break;

            case WHATSAPP:
                mImportWhatsAppProgressBar.setProgress(100);
                showImportCompleted(mImportWhatsAppContacts);
                break;

            case GMAIL:
                mImportGmailProgressBar.setProgress(100);
                showImportCompleted(mImportGmailContacts);
                break;

            case PHONE_BOOK:
                mImportPhoneBookProgressBar.setProgress(100);
                showImportCompleted(mImportPhoneBookContacts);
                break;
        }
    }

}
