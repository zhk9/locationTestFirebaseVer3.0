package com.example.user.locationtestfirebase;

import android.content.Context;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class NotificationService extends NotificationListenerService {
    private static final String TAG = TrackingService.class.getSimpleName();
   Context context;

    @Override

    public void onCreate() {

        super.onCreate();
        context = getApplicationContext();

    }
    @Override

    public void onNotificationPosted(StatusBarNotification sbn) {


        String pack = sbn.getPackageName();

        String text = "";
        String title = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            Bundle extras = extras = sbn.getNotification().extras;
        //    text = extras.getCharSequence("android.text").toString();
         //   title = extras.getString("android.title");

        }
        String date = String.valueOf(android.text.format.DateFormat.format("dd-MM-yyyy HH:mm:ss", new java.util.Date()));
        String noti = date + "\t" + pack   + "\n";
        try {
            File data7 = new File("notification.txt");
            FileOutputStream fos = openFileOutput("notification.txt", Context.MODE_APPEND);
            fos.write((noti).getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Log.i("Package",pack);
     //   Log.i("Title",title);
     //   Log.i("Text",text);

    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        String pack = sbn.getPackageName();
        String date = String.valueOf(android.text.format.DateFormat.format("dd-MM-yyyy HH:mm:ss", new java.util.Date()));
        String noti = date + "\t" + pack   + "\n";
        try {
            File data7 = new File("notificationrem.txt");
            FileOutputStream fos = openFileOutput("notificationrem.txt", Context.MODE_APPEND);
            fos.write((noti).getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Log.i("Msg","Notification was removed");
    }


}
