package com.ali.telescope.internal.report;

import com.ali.telescope.util.TelescopeLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.SymbolExpUtil;

public class ProtocolConstants {
    public static short EVENT_ACTIVITY_CREATE = 257;
    public static short EVENT_ACTIVITY_DESOTRY = 262;
    public static short EVENT_ACTIVITY_OPEN_PREF = 516;
    public static short EVENT_ACTIVITY_PAGE_LOAD_FINISH = 264;
    public static short EVENT_ACTIVITY_PAGE_OPEN = 263;
    public static short EVENT_ACTIVITY_PAUSE = 260;
    public static short EVENT_ACTIVITY_RESUME = 259;
    public static short EVENT_ACTIVITY_START = 258;
    public static short EVENT_ACTIVITY_STOP = 261;
    public static short EVENT_ALARM_BG_LEAK = 779;
    public static short EVENT_ALARM_BG_SET = 778;
    public static short EVENT_APP_BACKGROUND = 4;
    public static short EVENT_APP_FOREGROUND = 3;
    public static short EVENT_APP_START_UP_BEGIN = 1;
    public static short EVENT_APP_START_UP_END = 2;
    public static short EVENT_BACKGROUND_ACTION = 776;
    public static short EVENT_BITMAP_MEMORY = 771;
    public static short EVENT_COMPONENT_TRACE = 773;
    public static short EVENT_CPU = 514;
    public static short EVENT_FD_OVERFLOW = 777;
    public static short EVENT_FPS = 513;
    public static short EVENT_LAUNCH_TASK_END = 6;
    public static short EVENT_LAUNCH_TASK_START = 5;
    public static short EVENT_MAINTHREAD_BLOCK = 780;
    public static short EVENT_MAINTHREAD_IO = 774;
    public static short EVENT_MEMORY = 515;
    public static short EVENT_MEMORY_LEAK = 769;
    public static short EVENT_ONLINE_ACTIVITY_LOAD = 1028;
    public static short EVENT_ONLINE_ANR = 1034;
    public static short EVENT_ONLINE_BLOCK_OR_CLOSE_GUARD = 1027;
    public static short EVENT_ONLINE_BOOT_FINISH = 1025;
    public static short EVENT_ONLINE_BOOT_PERFORMANCE = 1037;
    public static short EVENT_ONLINE_CREATE_PERFORMANCE_REPORT = 1038;
    public static short EVENT_ONLINE_GOTO_SLEEP = 1031;
    public static short EVENT_ONLINE_MEMORY_LEAK = 1026;
    public static short EVENT_ONLINE_MEMORY_PROBLEM = 1033;
    public static short EVENT_ONLINE_RESOURCE_BITMAP = 1029;
    public static short EVENT_ONLINE_RESOURCE_CLEANER = 1030;
    public static short EVENT_ONLINE_THREAD_IO_TIMES = 1032;
    public static short EVENT_ONLINE_THREAD_POOL_PROBLEM = 1035;
    public static short EVENT_ONLINE_WHITE_SCREEN = 1036;
    public static short EVENT_RESOURCE_LEAK = 775;
    public static short EVENT_TRACE = 770;
    public static short EVENT_VIEW_HIERARCHY = 772;
    public static String PROTOCAL_ACTIVITY_CREATE = "actCreate page:u4:u1*,pageHashCode:u4:u1*";
    public static String PROTOCAL_ACTIVITY_DESTORY = "actDestory page:u4:u1*,pageHashCode:u4:u1*";
    public static String PROTOCAL_ACTIVITY_OPEN_PREF = "viewOpenPref time:u8,viewOpenPrefArr:u4:array:u4[page_name=u4:u1*|page_load_time=u4|page_stay_time=u4|page_start_stamp=u8]";
    public static String PROTOCAL_ACTIVITY_PAGE_LOAD_FINISH = "pageLoadFinish time:u8,page:u4:u1*,pageHashCode:u4:u1*,totalPss:u4,nativePss:u4,dalvikPss:u4,cpuUsageOfApp:u2,cpuUsageOfDevice:u2";
    public static String PROTOCAL_ACTIVITY_PAGE_OPEN = "pageOpen page:u4:u1*,pageHashCode:u4:u1*,totalPss:u4,nativePss:u4,dalvikPss:u4,cpuUsageOfApp:u2,cpuUsageOfDevice:u2";
    public static String PROTOCAL_ACTIVITY_PAUSE = "actPause page:u4:u1*,pageHashCode:u4:u1*";
    public static String PROTOCAL_ACTIVITY_RESUME = "actResume page:u4:u1*,pageHashCode:u4:u1*";
    public static String PROTOCAL_ACTIVITY_START = "actStart page:u4:u1*,pageHashCode:u4:u1*";
    public static String PROTOCAL_ACTIVITY_STOP = "actStop page:u4:u1*,pageHashCode:u4:u1*";
    public static String PROTOCAL_ALARM_BG_LEAK = "alarmBgLeak detail:u4:json";
    public static String PROTOCAL_ALARM_BG_SET = "alarmBgSet detail:u4:json";
    public static String PROTOCAL_APP_BACKGROUD = "background";
    public static String PROTOCAL_APP_FOREGROUND = "foreground";
    public static String PROTOCAL_APP_START_UP_BEGIN = "startupBegin";
    public static String PROTOCAL_APP_START_UP_END = "startupEnd time:u8,bootType:u1,startTimeStamp:u8,boot1Duration:u8,totalPss:u4,nativePss:u4,dalvikPss:u4,cpuUsageOfApp:u2,cpuUsageOfDevice:u2";
    public static String PROTOCAL_BACKGROUND_ACTION = "backGroundAction detail:u4:json";
    public static String PROTOCAL_BITMAP_MEMORY = "bitmapMemory detail:u4:json";
    public static String PROTOCAL_COMPONENT_TRACE = "componentTrace detail:u4:json";
    public static String PROTOCAL_CPU = "cpu time:u8,cpuUsageOfApp:u2,cpuUsageOfDevice:u2";
    public static String PROTOCAL_FD_OVERFLOW = "fdOverflow detail:u4:json";
    public static String PROTOCAL_FPS = "fps fps:u2,page:u4:u1*,pageHashCode:u4:u1*,dragFlingCount:u2,frameCount:u2,frameDuration:u4,badFrameCount:u2,badFrameDuration:u4";
    public static String PROTOCAL_LAUNCH_TASK_END = "runtimeTaskEnd taskName:u4:u1*";
    public static String PROTOCAL_LAUNCH_TASK_START = "runtimeTaskBegin taskName:u4:u1*";
    public static String PROTOCAL_MAINTHREAD_BLOCK = "mainThreadBlock detail:u4:json";
    public static String PROTOCAL_MAINTHREAD_IO = "mainThreadIO detail:u4:json";
    public static String PROTOCAL_MEMORY = "memory time:u8,totalPss:u4,nativePss:u4,dalvikPss:u4";
    public static String PROTOCAL_MEMORY_LEAK = "memoryLeak detail:u4:json";
    public static String PROTOCAL_ONLINE_ACTIVITY_LOAD = "activityload activityName:u4:u1*,CpuCore:u4:u1*,APILevel:u4:u1*,IsLowMemroy:u4:u1*,MemoryLevel:u4:u1*,onCreate:u4:u1*,firstCreate:u4:u1*,isHotLauncher:u4:u1*,Info:u4:u1*,StayTime:u8,JankTime:u8,IdleTime:u8,FrameTime:u8,JankCount:u8,FrameCount:u8,DeviceMem:u8,BadCountOne:u8,BadCountTwo:u8,BadCountThree:u8,BadCountFour:u8,BadCountFive:u8,BadCountSix:u8,BadCountSeven:u8,BadCountEight:u8,BadCountNine:u8,BadCountTen:u8,BadCountEleven:u8,BadCountTwelve:u8,loadTime:u8,EnterIdleTime:u8,CpuMaxFreq:u8,DeviceAvailMem:u8,TotalUsedMem:u8,RemainMem:u8,NativeHeapSize:u8,JavaHeapSize:u8,SysCpuPercent:u8,PidCpuPercent:u8,SysLoadAvg:u8,RuntimeThread:u8,RunningThread:u8,ActivityScore:u8,DeviceScore:u8,SysScore:u8,PidScore:u8,RunningProgress:u8,RunningService:u8,StartActivityTime:u8,LoadSmUsedTime:u8,LoadSmCount:u8,LoadBadSmCount:u8,LoadBadSmUsedTime:u8,OpenFileCount:u8,TotalTx:u8,TotalRx:u8";
    public static String PROTOCAL_ONLINE_ANR = "anr fileName:u4:u1*,stack:u4:u1*,activityname:u4:u1*,CpuCore:u4:u1*,APILevel:u4:u1*,IsLowMemroy:u4:u1*,MemoryLevel:u4:u1*,Info:u4:u1*,DeviceMem:u8,CpuMaxFreq:u8,TotalUsedMem:u8,SysCpuPercent:u8,PidCpuPercent:u8,SysLoadAvg:u8,RuntimeThread:u8,RunningThread:u8,DeviceScore:u8,SysScore:u8,PidScore:u8,RunningProgress:u8,RunningService:u8";
    public static String PROTOCAL_ONLINE_BLOCK_OR_CLOSE_GUARD = "BlockOrCloseGuard activityName:u4:u1*,threadName:u4:u1*,typeString:u4:u1*,stacks:u4:u1*,type:u8,size:u8";
    public static String PROTOCAL_ONLINE_BOOT_FINISH = "LaunchAll isFirstInstall:u4:u1*,CpuCore:u4:u1*,APILevel:u4:u1*,IsLowMemory:u4:u1*,MemoryLevel:u4:u1*,BootType:u4:u1*,Info:u4:u1*,BootTotalTime:u8,loadTime:u8,BlockingGCCount:u8,CpuMaxFreq:u8,DeviceMem:u8,DeviceAvailMem:u8,TotalUsedMem:u8,RemainMem:u8,NativeHeapSize:u8,JavaHeapSize:u8,SysCpuPercent:u8,PidCpuPercent:u8,IOWaitTime:u8,SysLoadAvg:u8,RuntimeThread:u8,RunningThread:u8,DeviceScore:u8,SysScore:u8,PidScore:u8,RunningProgress:u8,RunningService:u8,PidPrepareTime:u8,AdvTime:u8";
    public static String PROTOCAL_ONLINE_BOOT_PERFORMANCE = "BootPerformance MemoryLevel:u4:u1*,BootType:u4:u1*,InBootStep:u4:u1*,TaskName:u4:u1*,DeviceMem:u8,DeviceAvailMem:u8,TotalUsedMem:u8,RemainMem:u8,NativeHeapSize:u8,JavaHeapSize:u8,SysCpuPercent:u8,PidCpuPercent:u8,SysLoadAvg:u8,ThreadCount:u8,DeviceScore:u8,SysScore:u8,PidScore:u8,RunningProgress:u8,RunningService:u8,PercentInBoot:u8,PercentInPid:u8,PercentInSystem:u8,PercentInDevice:u8,TaskUsedTime:u8,TaskCpuTime:u8";
    public static String PROTOCAL_ONLINE_CREATE_PERFORMANCE_REPORT = "";
    public static String PROTOCAL_ONLINE_GOTO_SLEEP = "OnGotoSleep CpuCore:u4:u1*,APILevel:u4:u1*,CpuUser:u4:u1*,Info:u4:u1*,DeviceTotalAvailMem:u8,DeviceMem:u8,CpuMaxFreq:u8,DeviceAvailMem:u8,TotalUsedMem:u8,RemainMem:u8,NativeHeapSize:u8,JavaHeapSize:u8,DeviceScore:u8,SysScore:u8,PidScore:u8,MaxCpuSys:u8,MaxCpuDev:u8,CpuSys:u8,CpuDev:u8,IsThread:u8";
    public static String PROTOCAL_ONLINE_MEMORY_LEAK = "activityLeak activityName:u4:u1*,chain:u4:u1*,leakSize:u8";
    public static String PROTOCAL_ONLINE_MEMORY_PROBLEM = "OnMemoryProblem APILevel:u4:u1*,ActivityName:u4:u1*,Info:u4:u1*,MemoryLevel:u4:u1*,Activitys:u4:u1*,Threads:u4:u1*,MemoryType:u4:u1*,DeviceMem:u8,TotalUsedMem:u8,DeviceScore:u8,SysScore:u8,PidScore:u8,RuntimeThread:u8,RunningThread:u8,OtherSo:u8,OtherJar:u8,OtherApk:u8,OtherTtf:u8,OtherDex:u8,OtherOat:u8,OtherArt:u8,OtherMap:u8,OtherAshmem:u8";
    public static String PROTOCAL_ONLINE_RESOURCE_BITMAP = "BitmapStatic APILevel:u4:u1*,activityName:u4:u1*,Info:u4:u1*,DeviceMem:u8,DeviceTotalAvailMem:u8,DeviceAvailMem:u8,TotalUsedMem:u8,RemainMem:u8,NativeHeapSize:u8,JavaHeapSize:u8,DeviceScore:u8,SysScore:u8,PidScore:u8,BitmapCount:u8,Bitmap565Count:u8,Bitmap8888Count:u8,BitmapByte:u8,Bitmap1M:u8,Bitmap2M:u8,Bitmap4M:u8,Bitmap6M:u8,Bitmap8M:u8,Bitmap10M:u8,Bitmap12M:u8,Bitmap15M:u8,Bitmap20M:u8,SizeScreen:u8,Size2Screen:u8,SizeHashScreen:u8,Size14Screen:u8";
    public static String PROTOCAL_ONLINE_RESOURCE_CLEANER = "CleanerStatic APILevel:u4:u1*,activityName:u4:u1*,Info:u4:u1*,ClassName:u4:u1*,DeviceMem:u8,DeviceTotalAvailMem:u8,DeviceAvailMem:u8,TotalUsedMem:u8,RemainMem:u8,NativeHeapSize:u8,JavaHeapSize:u8,DeviceScore:u8,SysScore:u8,PidScore:u8,ClassCount:u8";
    public static String PROTOCAL_ONLINE_THREAD_IO_TIMES = "ThreadIoTimes Thread:u4:u1*,Info:u4:u1*,DeviceScore:u8,SysScore:u8,PidScore:u8,RWTimes:u8,RTimes:u8,WTimes:u8,NetTimes:u8,nice:u8,ioWaitCount:u8,ioWaitTime:u8";
    public static String PROTOCAL_ONLINE_THREAD_POOL_PROBLEM = "ThreadPoolProblem activityName:u4:u1*,CpuCore:u4:u1*,APILevel:u4:u1*,IsLowMemroy:u4:u1*,MemoryLevel:u4:u1*,Info:u4:u1*,QueueThread:u4:u1*,PoolThread:u4:u1*,PoolThreadDetail:u4:u1*,QueueSize:u8,CoreSize:u8,MaxSize:u8,ActiveCount:u8,CompletedCount:u8,ThreadSize:u8,DeviceMem:u8,CpuMaxFreq:u8,DeviceAvailMem:u8,DeviceTotalAvailMem:u8,TotalUsedMem:u8,RemainMem:u8,NativeHeapSize:u8,JavaHeapSize:u8,SysCpuPercent:u8,PidCpuPercent:u8,SysLoadAvg:u8,RuntimeThread:u8,RunningThread:u8,DeviceScore:u8,SysScore:u8,PidScore:u8,RunningProgress:u8,RunningService:u8";
    public static String PROTOCAL_ONLINE_WHITE_SCREEN = "WhiteScreen activityName:u4:u1*,CpuCore:u4:u1*,APILevel:u4:u1*,IsLowMemroy:u4:u1*,MemoryLevel:u4:u1*,WidthPercent:u8,HeightPercent:u8,UseTime:u8,DeviceMem:u8,CpuMaxFreq:u8,DeviceAvailMem:u8,TotalUsedMem:u8,RemainMem:u8,NativeHeapSize:u8,JavaHeapSize:u8,SysCpuPercent:u8,PidCpuPercent:u8,SysLoadAvg:u8,RuntimeThread:u8,RunningThread:u8,DeviceScore:u8,SysScore:u8,PidScore:u8,RunningProgress:u8,RunningService:u8";
    public static String PROTOCAL_RESOURCE_LEAK = "resourceLeak detail:u4:u1*";
    public static String PROTOCAL_TRACE = "trace detail:u4:json";
    public static String PROTOCAL_VIEW_HIERARCHY = "viewHierarchy detail:u4:json";

    public static HashMap<String, String> getTypeDescriptor() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Integer.toString(EVENT_APP_START_UP_BEGIN), PROTOCAL_APP_START_UP_BEGIN);
        hashMap.put(Integer.toString(EVENT_APP_START_UP_END), PROTOCAL_APP_START_UP_END);
        hashMap.put(Integer.toString(EVENT_APP_FOREGROUND), PROTOCAL_APP_FOREGROUND);
        hashMap.put(Integer.toString(EVENT_APP_BACKGROUND), PROTOCAL_APP_BACKGROUD);
        hashMap.put(Integer.toString(EVENT_LAUNCH_TASK_START), PROTOCAL_LAUNCH_TASK_START);
        hashMap.put(Integer.toString(EVENT_LAUNCH_TASK_END), PROTOCAL_LAUNCH_TASK_END);
        hashMap.put(Integer.toString(EVENT_ACTIVITY_CREATE), PROTOCAL_ACTIVITY_CREATE);
        hashMap.put(Integer.toString(EVENT_ACTIVITY_RESUME), PROTOCAL_ACTIVITY_RESUME);
        hashMap.put(Integer.toString(EVENT_ACTIVITY_PAUSE), PROTOCAL_ACTIVITY_PAUSE);
        hashMap.put(Integer.toString(EVENT_ACTIVITY_START), PROTOCAL_ACTIVITY_START);
        hashMap.put(Integer.toString(EVENT_ACTIVITY_STOP), PROTOCAL_ACTIVITY_STOP);
        hashMap.put(Integer.toString(EVENT_ACTIVITY_DESOTRY), PROTOCAL_ACTIVITY_DESTORY);
        hashMap.put(Integer.toString(EVENT_ACTIVITY_PAGE_OPEN), PROTOCAL_ACTIVITY_PAGE_OPEN);
        hashMap.put(Integer.toString(EVENT_ACTIVITY_PAGE_LOAD_FINISH), PROTOCAL_ACTIVITY_PAGE_LOAD_FINISH);
        hashMap.put(Integer.toString(EVENT_FPS), PROTOCAL_FPS);
        hashMap.put(Integer.toString(EVENT_CPU), PROTOCAL_CPU);
        hashMap.put(Integer.toString(EVENT_MEMORY), PROTOCAL_MEMORY);
        hashMap.put(Integer.toString(EVENT_ACTIVITY_OPEN_PREF), PROTOCAL_ACTIVITY_OPEN_PREF);
        hashMap.put(Integer.toString(EVENT_MEMORY_LEAK), PROTOCAL_MEMORY_LEAK);
        hashMap.put(Integer.toString(EVENT_TRACE), PROTOCAL_TRACE);
        hashMap.put(Integer.toString(EVENT_BITMAP_MEMORY), PROTOCAL_BITMAP_MEMORY);
        hashMap.put(Integer.toString(EVENT_VIEW_HIERARCHY), PROTOCAL_VIEW_HIERARCHY);
        hashMap.put(Integer.toString(EVENT_COMPONENT_TRACE), PROTOCAL_COMPONENT_TRACE);
        hashMap.put(Integer.toString(EVENT_MAINTHREAD_IO), PROTOCAL_MAINTHREAD_IO);
        hashMap.put(Integer.toString(EVENT_RESOURCE_LEAK), PROTOCAL_RESOURCE_LEAK);
        hashMap.put(Integer.toString(EVENT_BACKGROUND_ACTION), PROTOCAL_BACKGROUND_ACTION);
        hashMap.put(Integer.toString(EVENT_FD_OVERFLOW), PROTOCAL_FD_OVERFLOW);
        hashMap.put(Integer.toString(EVENT_ALARM_BG_SET), PROTOCAL_ALARM_BG_SET);
        hashMap.put(Integer.toString(EVENT_ALARM_BG_LEAK), PROTOCAL_ALARM_BG_LEAK);
        hashMap.put(Integer.toString(EVENT_MAINTHREAD_BLOCK), PROTOCAL_MAINTHREAD_BLOCK);
        hashMap.put(Integer.toString(EVENT_ONLINE_BOOT_FINISH), PROTOCAL_ONLINE_BOOT_FINISH);
        hashMap.put(Integer.toString(EVENT_ONLINE_MEMORY_LEAK), PROTOCAL_ONLINE_MEMORY_LEAK);
        hashMap.put(Integer.toString(EVENT_ONLINE_BLOCK_OR_CLOSE_GUARD), PROTOCAL_ONLINE_BLOCK_OR_CLOSE_GUARD);
        hashMap.put(Integer.toString(EVENT_ONLINE_ACTIVITY_LOAD), PROTOCAL_ONLINE_ACTIVITY_LOAD);
        hashMap.put(Integer.toString(EVENT_ONLINE_RESOURCE_BITMAP), PROTOCAL_ONLINE_RESOURCE_BITMAP);
        hashMap.put(Integer.toString(EVENT_ONLINE_RESOURCE_CLEANER), PROTOCAL_ONLINE_RESOURCE_CLEANER);
        hashMap.put(Integer.toString(EVENT_ONLINE_GOTO_SLEEP), PROTOCAL_ONLINE_GOTO_SLEEP);
        hashMap.put(Integer.toString(EVENT_ONLINE_THREAD_IO_TIMES), PROTOCAL_ONLINE_THREAD_IO_TIMES);
        hashMap.put(Integer.toString(EVENT_ONLINE_MEMORY_PROBLEM), PROTOCAL_ONLINE_MEMORY_PROBLEM);
        hashMap.put(Integer.toString(EVENT_ONLINE_ANR), PROTOCAL_ONLINE_ANR);
        hashMap.put(Integer.toString(EVENT_ONLINE_THREAD_POOL_PROBLEM), PROTOCAL_ONLINE_THREAD_POOL_PROBLEM);
        hashMap.put(Integer.toString(EVENT_ONLINE_WHITE_SCREEN), PROTOCAL_ONLINE_WHITE_SCREEN);
        hashMap.put(Integer.toString(EVENT_ONLINE_BOOT_PERFORMANCE), PROTOCAL_ONLINE_BOOT_PERFORMANCE);
        hashMap.put(Integer.toString(EVENT_ONLINE_CREATE_PERFORMANCE_REPORT), PROTOCAL_ONLINE_CREATE_PERFORMANCE_REPORT);
        return hashMap;
    }

    public static void getDocTypeDescriptor() {
        ArrayList<Map.Entry> arrayList = new ArrayList<>(getTypeDescriptor().entrySet());
        Collections.sort(arrayList, new Comparator() {
            public int compare(Object obj, Object obj2) {
                return Integer.valueOf((String) ((Map.Entry) obj).getKey()).compareTo(Integer.valueOf((String) ((Map.Entry) obj2).getKey()));
            }
        });
        TelescopeLog.i("ProtocolConstants", "*type-descriptors");
        for (Map.Entry entry : arrayList) {
            TelescopeLog.i("ProtocolConstants", String.format("0x%04X", new Object[]{Integer.valueOf((String) entry.getKey())}) + SymbolExpUtil.SYMBOL_EQUAL + entry.getValue());
        }
        TelescopeLog.i("ProtocolConstants", "*end");
    }
}
