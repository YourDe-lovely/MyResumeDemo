package com.hello.resume.myresumedemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hello.resume.myresumedemo.R;

public class ListFragmentAdapter extends RecyclerView.Adapter<ListFragmentAdapter.ViewHolder> {


    private Context mContext ;
    private String mTab ;

    public ListFragmentAdapter(Context context,String tab){
        mContext = context ;
        mTab = tab ;
    }

    @NonNull
    @Override
    public ListFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_listfragment,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListFragmentAdapter.ViewHolder holder, int position) {
        holder.textView.setText(mTab+position);
    }

    @Override
    public int getItemCount() {
        return 40;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView textView ;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

}
