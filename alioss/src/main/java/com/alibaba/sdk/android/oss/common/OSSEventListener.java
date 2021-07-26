package com.alibaba.sdk.android.oss.common;

import okhttp3.EventListener;

public class OSSEventListener {

    static private EventListener.Factory factory = null;

    static public void setFactory(EventListener.Factory f) {
        factory = f;
    }

    static public EventListener.Factory getFactory() {
        return factory;
    }

}
