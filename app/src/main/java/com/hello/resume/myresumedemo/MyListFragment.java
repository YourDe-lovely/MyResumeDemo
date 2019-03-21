package com.hello.resume.myresumedemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hello.resume.myresumedemo.adapter.ListFragmentAdapter;

public class MyListFragment extends Fragment {

    private RecyclerView mRecyclerView ;
    private String mTab ;
    @SuppressLint("ValidFragment")
    public MyListFragment(String tab){
        super();
        mTab = tab ;
    }

    public MyListFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_mylist , container , false);
        return mRecyclerView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter(new ListFragmentAdapter(getActivity(),mTab));
    }
}
