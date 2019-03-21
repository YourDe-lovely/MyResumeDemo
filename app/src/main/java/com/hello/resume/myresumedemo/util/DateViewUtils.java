package com.hello.resume.myresumedemo.util;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *   选择时间
 *   设置edittext的点击时间选择时间  并把结果赋值在edittext的tag
 */
public class DateViewUtils {


    public interface ChooseDataListener {
        void chooseData(Date date);
    }

    private static SimpleDateFormat mSdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void setDateChooseClickListener(final EditText editText, final Context context , final ChooseDataListener result){
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDiaglog(editText, context , result);
            }
        });
    }

    private static void showDatePickerDiaglog(final EditText timeView, Context context , final ChooseDataListener result) {
        Calendar cal = Calendar.getInstance();
        if (timeView.getTag() != null) {
            cal.setTime((Date) timeView.getTag());
        }

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
                updateDate(timeView, arg1, arg2 + 1, arg3,result);
            }
        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private static void updateDate(EditText dateText, int year, int month, int date, ChooseDataListener result) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, date);
        dateText.setText(mSdf.format(cal.getTime()));
        dateText.setTag(cal.getTime());
        result.chooseData(cal.getTime());
    }

}
