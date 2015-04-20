package com.bijesh.settings.nekt.ui;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;

/**
 * ImportContactsAsync downloads the contacts details from internet and updates the ui. Current ly asynctask in used,
 * but need to use volley library later.
 */
public class ImportContactsAsync extends AsyncTask<Void, Integer, Integer> {

    public static enum SocialNetwork {FACEBOOK, TWITTER, LINKED_IN, WHATSAPP, GMAIL, PHONE_BOOK};

    private ImportContactsListener mImportContactsListener = null;

    private SocialNetwork mNetworkToImport = null;

    /**
     * Interface definition for a callback to be invoked when Contacts have been imported from a Social network
     */
    public interface ImportContactsListener {
        /**
         * Called when the contacts importing is in progress
         *
         * @param progress The progress level of contacts imported.
         */
        public void onDownloadingContacts(SocialNetwork network, int progress);

        /**
         * Called when a view has been clicked.
         *
         * @param contacts     The array of Contacts imported
         */
        public void onImportCompleted(SocialNetwork network, String[] contacts);
    }

    /**
     * Initialize the Constructor with the network that you are going to import the contacts to .
     *
     * @param network The social network which the user want to import the contacts to .
     */
    public ImportContactsAsync(SocialNetwork network) {
        mNetworkToImport = network;
    }

    public void setOnImportedListener(ImportContactsListener importContactsListener) {
        mImportContactsListener = new WeakReference<ImportContactsListener>(importContactsListener).get();
    }

    @Override
    protected Integer doInBackground(Void... params) {
        int progress = 0;

        do {
            publishProgress(progress);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progress += 10;
        } while (progress < 100);

        return 100;
    }

    // this method is called when publis progress is called in do in background.
    // Update the Ui from this method using the progress value.
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        if (mImportContactsListener != null) {
            int progress = values[0];
            mImportContactsListener.onDownloadingContacts(mNetworkToImport, progress);
        }
    }

    @Override
    protected void onPostExecute(Integer completedProgress) {
        super.onPostExecute(completedProgress);

        if (mImportContactsListener != null) {
            if (completedProgress == 100) {
                // TODO : SEND THE CONTACTS INSTEAD OF THE NULL
                mImportContactsListener.onImportCompleted(mNetworkToImport, null);
            } else {
                mImportContactsListener.onImportCompleted(mNetworkToImport, null);
            }
        }
    }
}
