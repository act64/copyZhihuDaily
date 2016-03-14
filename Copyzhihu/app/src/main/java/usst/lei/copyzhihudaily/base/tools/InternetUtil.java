package usst.lei.copyzhihudaily.base.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;

/**
 * Created by hchen on 2016/3/14.
 */
public class InternetUtil {

    public boolean hasInternet(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= 21) {
            Network[] netWorks = connectivityManager.getAllNetworks();
            for (int i = 0; i < netWorks.length; i++) {
                if (connectivityManager.getNetworkInfo(netWorks[i]) != null &&
                        connectivityManager.getNetworkInfo(netWorks[i]).isConnected()) {
                    return true;
                }
            }
        } else {
            NetworkInfo[] netWorks = connectivityManager.getAllNetworkInfo();
            for (int i = 0; i < netWorks.length; i++) {
                if (netWorks[i] != null &&
                        netWorks[i].isConnected()) {
                    return true;
                }
            }
        }
        return false;

    }

}
