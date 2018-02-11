package com.homeautomation.deltaha;

import android.support.v4.app.Fragment;

/**
 * Created by andrew on 2/10/18.
 */

public class MonitorListActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new MonitorListFragment();
    }
}
