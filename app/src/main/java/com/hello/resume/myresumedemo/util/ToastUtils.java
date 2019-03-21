package com.hello.resume.myresumedemo.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    private static ToastUtils toastUtils;
    private ToastUtils(){};

    private Toast toast ;

    public static ToastUtils getInstance() {
        if(toastUtils == null){
            toastUtils = new ToastUtils();
        }
        return toastUtils;
    }

    public void showMessage(Context context , String value) {
        if (toast != null) {
            toast.cancel();
        }

        toast = Toast.makeText(context, value, Toast.LENGTH_SHORT);
        toast.show();

    }


}
