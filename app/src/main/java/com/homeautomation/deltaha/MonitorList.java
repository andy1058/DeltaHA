package com.homeautomation.deltaha;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 2/10/18.
 */

public class MonitorList {
    private static MonitorList sMonitorList;
    private List<Monitor> mMonitors;

    public static MonitorList get(Context context){
        if (sMonitorList == null){
            sMonitorList = new MonitorList(context);
        }
        return sMonitorList;
    }

    private MonitorList(Context context){
        mMonitors = new ArrayList<>();

        Monitor m1 = new Monitor("1", "bedroom1", "true", "bedroom light");
        Monitor m2 = new Monitor("2", "kitchen", "false", "kitchen light");
        Monitor m3 = new Monitor("3", "porch", "true", "porch light");

        mMonitors.add(m1);
        mMonitors.add(m2);
        mMonitors.add(m3);
    }

    public List<Monitor> getMonitors(){
        return mMonitors;
    }

    public Monitor getMonitor(String id){
        for (Monitor monitor : mMonitors){
            if (monitor.getId().equals(id)){
                return monitor;
            }
        }
        return null;
    }

}
