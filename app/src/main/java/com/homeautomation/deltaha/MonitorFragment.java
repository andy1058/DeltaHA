package com.homeautomation.deltaha;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

/**
 * Created by andrew on 2/10/18.
 */

public class MonitorFragment extends Fragment {

    private Monitor mMonitor;
    private Switch mCheckbox;
    private static final String ARG_MONITOR_ID = "monitor_id";

    public static MonitorFragment newInstance(String monitorId){
        Bundle args = new Bundle();
        args.putString(ARG_MONITOR_ID, monitorId);
        MonitorFragment fragment = new MonitorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String monitorID = (String) getArguments().getString(ARG_MONITOR_ID);
        mMonitor = MonitorList.get(getActivity()).getMonitor(monitorID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_monitor, container, false);

        mCheckbox = (Switch) v.findViewById(R.id.on_off_toggle);
        mCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton switchview, boolean isChecked) {
                mMonitor.setState("true");
            }
        });

        return v;
    }


}
