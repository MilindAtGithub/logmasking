package com.milind.logmasking.logmasking.logging;

import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class MyLogFactory {

    private static Map<String, LogAdapter> loggerMapCache = new HashMap<String, LogAdapter>();

    public static Logger getLogger(Class cls) {
        synchronized (loggerMapCache) {
            if (!loggerMapCache.containsKey(cls.getName())) {
                loggerMapCache.put(cls.getName(), new LogAdapter(cls));
            }
            return loggerMapCache.get(cls.getName());
        }
    }
}
