package com.hello.resume.myresumedemo.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class ActivityStartUtil {

    public static void startActivity(Context context , Class< ? extends Activity> clz){
        Intent intent = new Intent(context , clz);
        context.startActivity(intent);
    }
}
