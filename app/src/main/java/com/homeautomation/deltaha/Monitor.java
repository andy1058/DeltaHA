package com.homeautomation.deltaha;

import java.util.UUID;

/**
 * Created by andrew on 2/8/18.
 */

public class Monitor {

    String mDescription;
    String mId;
    String mName;
    String mState;

    public Monitor(){
        //empty
    }

    public Monitor(String id, String name, String state, String description){
        mId = id;
        mDescription = description;
        mState = state;
        mName = name;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
