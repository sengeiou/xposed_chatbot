package com.ut.mini;

import com.ut.mini.module.appstatus.UTAppStatusMonitor;
import java.util.Map;

class UTPvidHelper {
    private static final String UTBG = "utbg";
    private static final String UTPVID = "utpvid";
    private static final String UTPVID_B = "utpvid-b";
    private static long mUTPvid;
    private static long mUTPvidB;

    UTPvidHelper() {
    }

    public static void pageAppear() {
        synchronized (UTPvidHelper.class) {
            mUTPvid++;
        }
    }

    public static Map<String, String> processPagePvid(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        synchronized (UTPvidHelper.class) {
            map.put(UTPVID, "" + mUTPvid);
            map.put(UTPVID_B, "" + mUTPvidB);
            mUTPvidB = mUTPvid;
        }
        return map;
    }

    public static Map<String, String> processH5PagePvid(int i, Map<String, String> map) {
        if (i != 2001) {
            return map;
        }
        if (map == null) {
            return null;
        }
        synchronized (UTPvidHelper.class) {
            mUTPvid++;
            map.put(UTPVID, "" + mUTPvid);
            map.put(UTPVID_B, "" + mUTPvidB);
            mUTPvidB = mUTPvid;
        }
        return map;
    }

    public static Map<String, String> processOtherPvid(int i, Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (!(i == 19999 || i == 1010 || UTAppStatusMonitor.getInstance().isInForeground())) {
            map.put(UTBG, "1");
        }
        if (i == 2001) {
            return map;
        }
        synchronized (UTPvidHelper.class) {
            if (i != 19999) {
                try {
                    map.put(UTPVID, "" + mUTPvid);
                    map.remove(UTPVID_B);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                map.remove(UTPVID);
                map.remove(UTPVID_B);
            }
        }
        return map;
    }
}
