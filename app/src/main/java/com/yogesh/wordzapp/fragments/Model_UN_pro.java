package com.yogesh.wordzapp.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yogesh.wordzapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Model_UN_pro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Model_UN_pro extends Fragment {
    
    private Toolbar toolbar;
    private Typeface typeface;
    private TextView toolTitle;
   
    public static Model_UN_pro newInstance() {
        Model_UN_pro fragment = new Model_UN_pro();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public Model_UN_pro() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View RootView = inflater.inflate(R.layout.fragment_model__un_pro, container, false);

        toolbar = (Toolbar) RootView.findViewById(R.id.toolbar);
        //for crate home button
        final ActionBarActivity activity = (ActionBarActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("MODEL UN Procedure");
        toolbar.setTitleTextColor(getResources().getColor(R.color.text_pro));
        typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Gotham-Book.ttf");
        toolTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolTitle.setTypeface(typeface);

        
        return RootView;   
    }
    

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }
}
