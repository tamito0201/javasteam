package pl.l7ssha.javasteam.csgo.serverstatus;

import java.util.Date;

// pl.l7ssha.javasteam.csgo.models
//
// Date created: 31 Mar 2018
// Author: Szymon 'l7ssha' Uglis

public class RequestInfo {
    private int version;
    private long timestamp;
    private Date time;

    public RequestInfo() { }

    public int getVersion() {
        return version;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Date getTime() {
        return time;
    }
}
