import android.app.Notification
import android.content.Context
import android.content.Intent
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import java.io.ByteArrayOutputStream


class NotificationService : NotificationListenerService() {

    var context: Context? = null

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }


    override fun onNotificationPosted(sbn: StatusBarNotification) {
        val pack = sbn.packageName
        var ticker = ""
        if (sbn.notification.tickerText != null) {
            ticker = sbn.notification.tickerText.toString()
        }
        val extras = sbn.notification.extras
        val title = extras.getString("android.title")
        val text = extras.getCharSequence("android.text").toString()
        val id1 = extras.getInt(Notification.EXTRA_SMALL_ICON)
        val id = sbn.notification.largeIcon
        Log.i("Package", pack)
        Log.i("Ticker", ticker)
        Log.i("Title", title!!)
        Log.i("Text", text)
        val msgrcv = Intent("Msg")
        msgrcv.putExtra("package", pack)
        msgrcv.putExtra("ticker", ticker)
        msgrcv.putExtra("title", title)
        msgrcv.putExtra("text", text)
        if (id != null) {
            val stream = ByteArrayOutputStream()
            //id.compress(Bitmap.CompressFormat.PNG, 100, stream);
            val byteArray = stream.toByteArray()
            msgrcv.putExtra("icon", byteArray)
        }
        context?.let { LocalBroadcastManager.getInstance(it).sendBroadcast(msgrcv) }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        Log.i("Msg", "Notification Removed")
    }
}
