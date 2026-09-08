package com.oua.util;

import android.util.Log;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/* loaded from: classes4.dex */
public class DebugConfig {
    public static int debugLevel = 4;
    public static String debugRoot = "/sdcard/oua/debug";

    public static boolean isLogDebug() {
        if (debugLevel <= 3) {
            return true;
        }
        return false;
    }

    public static boolean isLogInfo() {
        if (debugLevel <= 4) {
            return true;
        }
        return false;
    }

    public static boolean isLogVerbose() {
        if (debugLevel <= 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$logMemory$0(Map.Entry entry, Map.Entry entry2) {
        return Long.compare(((Long) entry2.getValue()).longValue(), ((Long) entry.getValue()).longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$logMemory$1(Map.Entry entry) {
        return (String) entry.getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$logMemory$2(Map.Entry entry) {
        return (Long) entry.getValue();
    }

    public static void logAndSaveBuf(String str, String str2, ByteBuffer byteBuffer) {
        if (isLogVerbose()) {
            Log.v(str, str2 + " " + byteBuffer.toString());
            BufferUtil.saveRawBuffer(byteBuffer, String.format("%s/%s.raw", debugRoot, str2));
        }
    }

    public static void logMemory(String str, String str2) {
        if (isLogDebug()) {
            if (MemoryMonitor.currentInstance() != null) {
                MemoryMonitor.currentInstance().checkMemoryUsage();
            }
            Map<String, Long> memoryUsage = MemoryMonitor.getMemoryUsage();
            Log.d(str, String.format("%s, %.2fM", str2, Double.valueOf(memoryUsage.get("summary.total-pss").longValue() / 1024.0d)));
            Log.d(str, String.format("%s, %s", str2, StringUtil.toString((Map) memoryUsage.entrySet().stream().sorted(new Comparator() { // from class: com.oua.util.j
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int lambda$logMemory$0;
                    lambda$logMemory$0 = DebugConfig.lambda$logMemory$0((Map.Entry) obj, (Map.Entry) obj2);
                    return lambda$logMemory$0;
                }
            }).limit(4L).collect(Collectors.toMap(new Function() { // from class: com.oua.util.k
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    String lambda$logMemory$1;
                    lambda$logMemory$1 = DebugConfig.lambda$logMemory$1((Map.Entry) obj);
                    return lambda$logMemory$1;
                }
            }, new Function() { // from class: com.oua.util.l
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Long lambda$logMemory$2;
                    lambda$logMemory$2 = DebugConfig.lambda$logMemory$2((Map.Entry) obj);
                    return lambda$logMemory$2;
                }
            })))));
        }
    }

    public static void logd(String str, String str2) {
        if (isLogDebug()) {
            Log.d(str, str2);
        }
    }

    public static void loge(String str, String str2) {
        Log.e(str, str2);
    }

    public static void logi(String str, String str2) {
        if (isLogInfo()) {
            Log.i(str, str2);
        }
    }

    public static void logv(String str, String str2) {
        if (isLogVerbose()) {
            Log.v(str, str2);
        }
    }

    public static void logw(String str, String str2) {
        Log.w(str, str2);
    }

    public static void setDebugLevel(int i10, String str) {
        debugLevel = i10;
        debugRoot = str;
        if (isLogVerbose() && str != null) {
            new File(str).mkdirs();
        }
    }

    public static void logd(String str, String str2, Object obj) {
        if (isLogDebug()) {
            try {
                Log.d(str, String.format("%s:%s", str2, StringUtil.toString(obj)));
            } catch (Exception e10) {
                Log.w(str, String.format("log %s error!  %s", str2, e10.toString()));
            }
        }
    }

    public static void logv(String str, String str2, Object obj) {
        if (isLogVerbose()) {
            try {
                Log.v(str, String.format("%s:%s", str2, StringUtil.toString(obj)));
            } catch (Exception e10) {
                Log.w(str, String.format("log %s error!  %s", str2, e10.toString()));
            }
        }
    }
}
