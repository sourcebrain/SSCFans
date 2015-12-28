package sourcebrain.com.sscfans.util;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import sourcebrain.com.sscfans.R;


public class Util {

    /*
     * Check network connection
     */
    public static boolean hasConnection(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager != null) {
            NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();
            if(networkInfos != null) {
                for (int i = 0; i < networkInfos.length; i++) {
                    if(networkInfos[i].getState() == NetworkInfo.State.CONNECTED) {
                        return  true;
                    }
                }
            }
        }
        return false;
    }

    /*
     * Show network not available Alert
     */
    public static void showNetWorkNotAvaialabe(final Context context) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(R.string.alert_error);
        alertDialog.setMessage(R.string.connection_error);
        alertDialog.setCancelable(false);
        alertDialog.setNeutralButton(R.string.button_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ((Activity)context).finish();
            }
        });
        alertDialog.show();
    }

}
