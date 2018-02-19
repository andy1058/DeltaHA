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

        Monitor m1 = new Monitor("1", "Bedroom1", "true", "bedroom light");
        Monitor m2 = new Monitor("2", "Kitchen", "true", "kitchen light");
        Monitor m3 = new Monitor("3", "Porch", "true", "porch light");
        Monitor m4 = new Monitor("4", "DiningRoom", "true", "dining room light");
        Monitor m5 = new Monitor("5", "Basement", "true", "basement overhead light");
        Monitor m6 = new Monitor("6", "Floodlight", "true", "back flood light");
        Monitor m7 = new Monitor("7", "Bedroom2", "true", "second bedroom light");
        Monitor m8 = new Monitor("8", "LivingRoom", "true", "living room light");
        Monitor m9 = new Monitor("9", "Office", "true", "office light");



        mMonitors.add(m1);
        mMonitors.add(m2);
        mMonitors.add(m3);
        mMonitors.add(m4);
        mMonitors.add(m5);
        mMonitors.add(m6);
        mMonitors.add(m7);
        mMonitors.add(m8);
        mMonitors.add(m9);

    }

    public void addMonitor(Monitor newMonitor){
        mMonitors.add(newMonitor);

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
