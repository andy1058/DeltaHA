package com.homeautomation.deltaha;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {

    private static final String EXTRA_MONITOR_ID = "com.homeautomation.deltaha.monitor_id";

    public static Intent newIntent(Context packageContext, String monitorID){
        Intent intent = new Intent(packageContext, MainActivity.class);
        intent.putExtra(EXTRA_MONITOR_ID, monitorID);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        String monitorID = (String) getIntent().getStringExtra(EXTRA_MONITOR_ID);
        return MonitorFragment.newInstance(monitorID);
    }
}
