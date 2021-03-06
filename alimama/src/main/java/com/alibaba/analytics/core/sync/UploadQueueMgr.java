package com.alibaba.analytics.core.sync;

import com.alibaba.analytics.utils.Logger;
import com.alibaba.analytics.utils.TaskExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;

public class UploadQueueMgr implements Runnable {
    public static final String MSGTYPE_INTERVAL = "i";
    public static final String MSGTYPE_REALTIME = "r";
    private static UploadQueueMgr mUploadQueueMgr = new UploadQueueMgr();
    private static BlockingQueue<String> queueCache = new LinkedBlockingQueue();
    private boolean isRunning = false;

    public static UploadQueueMgr getInstance() {
        return mUploadQueueMgr;
    }

    public synchronized void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            TaskExecutor.getInstance().schedule((ScheduledFuture) null, getInstance(), 0);
        }
    }

    public void run() {
        while (this.isRunning) {
            try {
                String take = queueCache.take();
                Logger.d("", "take queueCache size", Integer.valueOf(queueCache.size()));
                if (MSGTYPE_INTERVAL.equals(take)) {
                    UploadLogFromDB.getInstance().upload();
                } else if (MSGTYPE_REALTIME.equals(take)) {
                    UploadLogFromCache.getInstance().upload();
                }
            } catch (Throwable th) {
                Logger.d("", th);
            }
        }
    }

    public void add(String str) {
        if (!queueCache.contains(str)) {
            try {
                queueCache.put(str);
                Logger.d("", "queueCache put", str, "queueCache size", Integer.valueOf(queueCache.size()));
            } catch (Exception e) {
                Logger.d("", e);
            }
        } else {
            Logger.d("", "queueCache contains", str);
        }
    }
}
