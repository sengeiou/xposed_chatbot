package com.coloros.mcssdk.mode;

import android.text.TextUtils;

public class AppMessage extends Message {
    int balanceTime;
    String content;
    int distinctBycontent = 0;
    long endDate;
    int forcedDelivery = 0;
    String rule;
    long startDate;
    String timeRanges = "08:00-22:00";
    String title;

    public int getBalanceTime() {
        return this.balanceTime;
    }

    public String getContent() {
        return this.content;
    }

    public int getDistinctBycontent() {
        return this.distinctBycontent;
    }

    public long getEndDate() {
        return this.endDate;
    }

    public int getForcedDelivery() {
        return this.forcedDelivery;
    }

    public String getRule() {
        return this.rule;
    }

    public long getStartDate() {
        return this.startDate;
    }

    public String getTimeRanges() {
        return this.timeRanges;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return 4098;
    }

    public void setBalanceTime(int i) {
        this.balanceTime = i;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDistinctBycontent(int i) {
        this.distinctBycontent = i;
    }

    public void setEndDate(long j) {
        this.endDate = j;
    }

    public void setForcedDelivery(int i) {
        this.forcedDelivery = i;
    }

    public void setRule(String str) {
        this.rule = str;
    }

    public void setStartDate(long j) {
        this.startDate = j;
    }

    public void setTimeRanges(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.timeRanges = str;
        }
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("messageID:" + this.messageID);
        sb.append(",taskID:" + this.taskID);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",balanceTime:" + this.balanceTime);
        sb.append(",startTime:" + this.startDate);
        sb.append(",endTime:" + this.endDate);
        sb.append(",balanceTime:" + this.balanceTime);
        sb.append(",timeRanges:" + this.timeRanges);
        sb.append(",forcedDelivery:" + this.forcedDelivery);
        sb.append(",distinctBycontent:" + this.distinctBycontent);
        return sb.toString();
    }
}
