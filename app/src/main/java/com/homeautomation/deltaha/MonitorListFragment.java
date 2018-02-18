package com.homeautomation.deltaha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by andrew on 2/10/18.
 */

public class MonitorListFragment extends Fragment {
    private RecyclerView mMonitorRecyclerView;
    private MonitorAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_monitor_list, container, false);

        mMonitorRecyclerView = (RecyclerView) view.findViewById(R.id.monitor_recycler_view);
        mMonitorRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private class MonitorHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitleTextView;
        private TextView mStateTextView;
        private Monitor mMonitor;

        public MonitorHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_monitor, parent, false));

            mTitleTextView = (TextView) itemView.findViewById(R.id.monitor_title);
            mStateTextView = (TextView) itemView.findViewById(R.id.monitor_state);
            itemView.setOnClickListener(this);

        }

        public void bind(Monitor monitor){
            mMonitor = monitor;
            mTitleTextView.setText(mMonitor.getName());
            mStateTextView.setText(mMonitor.getState());
        }

        @Override
        public void onClick(View view) {
            //Toast.makeText(getActivity(), mMonitor.getName() + " clicked!", Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(getActivity(), MainActivity.class);
            Intent intent = MainActivity.newIntent(getActivity(), mMonitor.getId());
            startActivity(intent);

        }
    }

    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }

    private class MonitorAdapter extends RecyclerView.Adapter<MonitorHolder>{
        private List<Monitor> mMonitors;

        public MonitorAdapter(List<Monitor> monitors){
            mMonitors = monitors;
        }

        @Override
        public MonitorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new MonitorHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(MonitorHolder holder, int position) {
            Monitor monitor = mMonitors.get(position);
            holder.bind(monitor);
        }

        @Override
        public int getItemCount() {
            return mMonitors.size();
        }
    }

    private void updateUI(){
        MonitorList monitorList = MonitorList.get(getActivity());
        List<Monitor> monitors = monitorList.getMonitors();

        if (mAdapter == null){
            mAdapter = new MonitorAdapter(monitors);
            mMonitorRecyclerView.setAdapter(mAdapter);
        }
        else{
            mAdapter.notifyDataSetChanged();
        }

    }


}
