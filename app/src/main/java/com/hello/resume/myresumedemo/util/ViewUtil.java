//package com.hello.resume.myresumedemo.util;
//
//import android.app.AlertDialog;
//import android.content.Context;
//import android.text.Editable;
//import android.text.TextUtils;
//import android.text.TextWatcher;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.EditText;
//import android.widget.ListView;
//
//import com.bsoft.mhealthd.myapplication.R;
//
//import java.util.ArrayList;
//
//public class ViewUtil {
//
//    public static ArrayList<String> sortData ;
//    public static AlertDialog dialog ;
//    public static ArrayAdapter<String> adapter;
//
//    /**
//     *  edittext 设置点击事件 弹出对话框进行listview的筛选
//     *   Feature #90055 Android端增加拼音码过滤录入功能
//     * @param context
//     * @param targetView
//     * @param datas
//     */
//    public static void showChooseDialog(final Context context , final EditText targetView, final ArrayList<String> datas){
//        View view = View.inflate(context, R.layout.dialog_allergy_choose, null);
//        dialog = new AlertDialog.Builder(context).setMessage("请选择").setView(view).create();
//
//        EditText editText = (EditText) view.findViewById(R.id.edittext);
//        final ListView listview = (ListView) view.findViewById(R.id.listview);
//
//        sortData = datas ;
//        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_activated_1, sortData);
//        listview.setAdapter(adapter);
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                targetView.setText(sortData.get(arg2));
//                dialog.dismiss();
//            }
//        });
//
//        editText.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable arg0) {
//                String value = arg0.toString();
//                if(TextUtils.isEmpty(value)){
//                    sortData = datas ;
//                }else{
//                    sortData = new ArrayList<String>();
//                    for(String item : datas){
//                        if(item.contains(value) || PinYinUtil.getPinYinHeadChar(item).toLowerCase().contains(value.toLowerCase())){
//                            sortData.add(item);
//                        }
//                    }
//                }
//                adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_activated_1, sortData);
//                listview.setAdapter(adapter);
////				adapter.notifyDataSetChanged();
//            }
//        });
//        dialog.show();
//    }
//}
