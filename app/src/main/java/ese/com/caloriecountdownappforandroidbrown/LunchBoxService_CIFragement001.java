package ese.com.caloriecountdownappforandroidbrown;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.app.PendingIntent;
import android.content.Context;

import java.util.Date;
import java.util.Calendar;

public class LunchBoxService_CIFragement001 extends Service
{

    private SpecialThreadCIF15 mSpecialThread;
    private NotificationManager mNotificationManager;
    private NotificationCompat.Builder mBuilder;
    private Date mBreakfastNotificationTime;

    private AlarmManager mAlarmManager;
    private PendingIntent alarmIntent;
    private Context goey;

    private int Hourx = 13;
    private int Minx = 30;

    private static final String ACTION_SET_LUNCH_NOTIFICATION = "ese.com.caloriecountdownappforandroid.action.LUNCH_NOTIFICATION";
    private static int REQUEST_CODE_NEW_DAY_LUNCH = 77;





    public LunchBoxService_CIFragement001()
    {

        mSpecialThread = null;

        goey = CCD_GUI_CD_CIF1.getAppContext();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = "lunch";
            String channel_id = "lunch";
            String channel_description = "This is a description";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(channel_id, name, importance);

            channel.setDescription(channel_description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after tohis

            mNotificationManager = (NotificationManager) goey.getSystemService(NotificationManager.class);
            mNotificationManager.createNotificationChannel(channel);
        }

        //mNotificationManager = (NotificationManager) goey.getSystemService(goey.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(goey,"Lunch")
                .setSmallIcon(R.drawable.ic_launcher2) // notification icon
                .setContentTitle("Update " + todaysTag()) // title for notification
                .setContentText("Update balance with Lunch items")// message for notification
                .setTicker("Lunch Notification")
                .setAutoCancel(false); // clear notification after click

        mBreakfastNotificationTime = new Date();


        mBuilder.setLights(Color.BLUE, 500, 500);
        long [] pattern = {500,500,500,500,500,500,500,500,500};
        mBuilder.setVibrate(pattern);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);




        mAlarmManager = (AlarmManager)goey.getSystemService(Context.ALARM_SERVICE);

        Intent i = new Intent(goey, LunchBoxService_CIFragement001.class);
        i.setAction(ACTION_SET_LUNCH_NOTIFICATION);

        alarmIntent = PendingIntent.getService(goey, REQUEST_CODE_NEW_DAY_LUNCH, i, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(alarmIntent);

        mNotificationManager.notify(0, mBuilder.build());





        //mAlarmManager = (AlarmManager)goey.getSystemService(Context.ALARM_SERVICE);

        //Intent i = new Intent(goey, BreakfastBoxService_CIFragement001.class);
        //i.setAction(ACTION_SET_BREAKFAST_NOTIFICATION);

        //alarmIntent = PendingIntent.getService(goey, REQUEST_CODE_NEW_DAY_BREAKFAST, i, PendingIntent.FLAG_UPDATE_CURRENT);

        //mNotificationManager.notify(0, mBuilder.build());
    }

    public LunchBoxService_CIFragement001(SpecialThreadCIF15 IN)
    {
        mSpecialThread = IN;
        goey = IN.goey;
        mAlarmManager = (AlarmManager)goey.getSystemService(Context.ALARM_SERVICE);
    }

    public LunchBoxService_CIFragement001(SpecialThreadCIF15 INSIDE, NotificationManager IN, NotificationCompat.Builder INPUT, Date notificationtime, PendingIntent pendingIntent)
    {
        mNotificationManager = IN;
        mBuilder = INPUT;
        mBreakfastNotificationTime = notificationtime;

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mBreakfastNotificationTime.getTime());


        Hourx = calendar.get(Calendar.HOUR);
        Minx = calendar.get(Calendar.MINUTE);


        mSpecialThread = INSIDE;

        goey = INSIDE.goey;

        mAlarmManager = (AlarmManager)goey.getSystemService(Context.ALARM_SERVICE);

        Intent i = new Intent(goey, LunchBoxService_CIFragement001.class);
        i.setAction(ACTION_SET_LUNCH_NOTIFICATION);

        alarmIntent = PendingIntent.getService(goey, REQUEST_CODE_NEW_DAY_LUNCH, i, PendingIntent.FLAG_UPDATE_CURRENT);

        //mNotificationManager.notify(0, mBuilder.build());

    }

    @Override
    public void onCreate()
    {
        super.onCreate();

        //setRepeating(mBreakfastNotificationTime);

        ///mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        // In this sample, we'll use the same text for the ticker and the expanded notification
        ///CharSequence text = "Notification Service Started";

        // The PendingIntent to launch our activity if the user selects this notification
        ///PendingIntent contentIntent = PendingIntent.getActivity(this, 8,
        ///        new Intent(this, CCD_GUI_CD_CIF1.class), 0);

        // Set the info for the views that show in the notification panel.


        ///mBuilder = new NotificationCompat.Builder(goey,"Breakfast")
        ///        .setSmallIcon(R.drawable.ic_launcher2) // notification icon
        ///        .setContentTitle("Update" + todaysTag()) // title for notification
        ///        .setContentText("Update balance with Breakfast items")// message for notification
        ///        .setTicker("Breakfast Notification")
        ///        .setAutoCancel(false); // clear notification after click

        ///mBreakfastNotificationTime = new Date();


        ///mBuilder.setLights(Color.BLUE, 500, 500);
        ///long [] pattern = {500,500,500,500,500,500,500,500,500};
        ///mBuilder.setVibrate(pattern);
        ///mBuilder.setDefaults(Notification.DEFAULT_SOUND);


        ///mAlarmManager = (AlarmManager)goey.getSystemService(Context.ALARM_SERVICE);

        //Intent i = new Intent(goey, BreakfastBoxService_CIFragement001.class);
        //i.setAction(ACTION_SET_BREAKFAST_NOTIFICATION);

        //alarmIntent = PendingIntent.getService(goey, REQUEST_CODE_NEW_DAY_BREAKFAST, i, PendingIntent.FLAG_UPDATE_CURRENT);
        ///mBuilder.setContentIntent(contentIntent);

        ///mNotificationManager.notify(0, mBuilder.build());
        // mNotificationManager.notify(0, mBuilder.build());
        android.util.Log.d("Noftify","We are in Repeating Daybreak Lunch");


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int start_id)
    {
        setRepeating(mBreakfastNotificationTime);
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void setRepeating(Date INrepeatTime)
    {
        //Set Schedule like repeating alarm here.

        ///mBreakfastNotificationTime = INrepeatTime;

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, Hourx);
        calendar.set(Calendar.MINUTE,Minx);

        mBreakfastNotificationTime.setTime(calendar.getTimeInMillis());

        long spacing = 86400000;

        ///calendar.setTimeInMillis(mBreakfastNotificationTime.getTime());

// With setInexactRepeating(), you have to use one of the AlarmManager interval
// constants--in this case, AlarmManager.INTERVAL_DAY.

        //mNotificationManager.notify(0, mBuilder.build());

        //mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, mBreakfastNotificationTime.getTime(), AlarmManager.INTERVAL_DAY, alarmIntent);
        //mAlarmManager.setExact(AlarmManager.RTC_WAKEUP, mBreakfastNotificationTime.getTime(), alarmIntent);
        mAlarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, mBreakfastNotificationTime.getTime(), 1000 * 86400, alarmIntent);

        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable r = new Runnable()
        {
            public void run()
            {
                mNotificationManager.notify(22, mBuilder.build());

                mBreakfastNotificationTime = setNextTime(mBreakfastNotificationTime,86430000);

                setRepeating(new Date());
            }
        };
        handler.postDelayed(r, spacing);



    }

    private void Breakfast_Notify(String title, String content, String description)
    {
        ;
    }

    private void Lunch_Notify(String title, String content, String description)
    {
        ;
    }

    private void Dinner_Notify(String title, String content, String description)
    {
        ;
    }


    private String todaysTag()
    {
        Calendar Greg = Calendar.getInstance();

        String year = new RoundingCIF13().IntToString(Greg.get(Calendar.YEAR));
        String month = new RoundingCIF13().IntToString(Greg.get(Calendar.MONTH)+1);
        String day = new RoundingCIF13().IntToString(Greg.get(Calendar.DAY_OF_MONTH));

        month = Americanize(month, Greg.get((Calendar.MONTH)+1));

        month = " " + month + " " + day;
        month = month + ",";
        month = month + year;

        return month;
    }

    private String Americanize(String month,int IN)
    {
        if(month == "0")month = " January";
        if(month == "1")month = " February";
        if(IN ==1){month = " February";}
        if(month == "2")month = " March";
        if(month == "3")month = " April";
        if(month == "4")month = " May";
        if(month == "5")month = " June";
        if(month == "6")month = " July";
        if(month == "7")month = " August";
        if(month == "8")month = " September";
        if(month == "9")month = " October";
        if(month == "10")month = " November";
        if(month == "11")month = " December";

        return month;

    }

    private Date setNextTime(Date IN, long extension)
    {
        long Out = IN.getTime();

        Out = Out + extension;

        Date Outdate = new Date();
        Outdate.setTime(Out);

        return Outdate;
    }
}
