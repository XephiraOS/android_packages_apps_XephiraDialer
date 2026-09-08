package com.oua.util;

import android.os.Debug;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

/* loaded from: classes4.dex */
public class MemoryMonitor {
    private Handler handler;
    private static MemoryMonitor memoryMonitor = new MemoryMonitor();
    private static final String TAG = MemoryMonitor.class.getName();
    public Map<String, List<Long>> memoryData = new HashMap();
    String[] SUMMARY_KEYS = {"summary.java-heap", "summary.native-heap", "summary.total-pss"};

    public static MemoryMonitor currentInstance() {
        return memoryMonitor;
    }

    public static Map<String, Long> getMemoryUsage() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        return (Map) memoryInfo.getMemoryStats().entrySet().stream().collect(Collectors.toMap(new n(), new Function() { // from class: com.oua.util.v
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Long lambda$getMemoryUsage$5;
                lambda$getMemoryUsage$5 = MemoryMonitor.lambda$getMemoryUsage$5((Map.Entry) obj);
                return lambda$getMemoryUsage$5;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$checkMemoryUsage$7(String str) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkMemoryUsage$8(Map.Entry entry) {
        this.memoryData.computeIfAbsent((String) entry.getKey(), new Function() { // from class: com.oua.util.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                List lambda$checkMemoryUsage$7;
                lambda$checkMemoryUsage$7 = MemoryMonitor.lambda$checkMemoryUsage$7((String) obj);
                return lambda$checkMemoryUsage$7;
            }
        }).add((Long) entry.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$getMemoryUsage$5(Map.Entry entry) {
        return Long.valueOf((String) entry.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$mergeMemoryData$2(Map map, Map.Entry entry) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection) entry.getValue());
        arrayList.addAll((Collection) map.get(entry.getKey()));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$parseMemoryData$3(long j10, Long l10) {
        if (l10 == null) {
            return 0.0d;
        }
        return l10.longValue() - j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DoubleSummaryStatistics lambda$parseMemoryData$4(Map.Entry entry) {
        final long j10;
        List list = (List) entry.getValue();
        if (!list.isEmpty()) {
            j10 = ((Long) list.get(0)).longValue();
        } else {
            j10 = 0;
        }
        return ((List) entry.getValue()).stream().mapToDouble(new ToDoubleFunction() { // from class: com.oua.util.s
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                double lambda$parseMemoryData$3;
                lambda$parseMemoryData$3 = MemoryMonitor.lambda$parseMemoryData$3(j10, (Long) obj);
                return lambda$parseMemoryData$3;
            }
        }).summaryStatistics();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$toSummaryString$0(Map.Entry entry) {
        return ((DoubleSummaryStatistics) entry.getValue()).getMin() - ((DoubleSummaryStatistics) entry.getValue()).getMax();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$toSummaryString$1(Map.Entry entry) {
        DoubleSummaryStatistics doubleSummaryStatistics = (DoubleSummaryStatistics) entry.getValue();
        DebugConfig.logd(TAG, String.format("memory summary %s: %s", entry.getKey(), ((DoubleSummaryStatistics) entry.getValue()).toString()));
        return String.format("%s:%.2fM -> %.2fM", entry.getKey(), Double.valueOf(doubleSummaryStatistics.getMin() / 1024.0d), Double.valueOf(doubleSummaryStatistics.getMax() / 1024.0d));
    }

    public static Map<String, List<Long>> mergeMemoryData(Map<String, List<Long>> map, final Map<String, List<Long>> map2) {
        return (Map) map.entrySet().stream().collect(Collectors.toMap(new n(), new Function() { // from class: com.oua.util.r
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                List lambda$mergeMemoryData$2;
                lambda$mergeMemoryData$2 = MemoryMonitor.lambda$mergeMemoryData$2(map2, (Map.Entry) obj);
                return lambda$mergeMemoryData$2;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCheckMemoryUsage, reason: merged with bridge method [inline-methods] */
    public void lambda$onCheckMemoryUsage$6() {
        if (this.handler != null) {
            checkMemoryUsage();
            this.handler.postDelayed(new Runnable() { // from class: com.oua.util.t
                @Override // java.lang.Runnable
                public final void run() {
                    MemoryMonitor.this.lambda$onCheckMemoryUsage$6();
                }
            }, 1L);
        }
    }

    public static Map<String, DoubleSummaryStatistics> parseMemoryData(Map<String, List<Long>> map) {
        return (Map) map.entrySet().stream().collect(Collectors.toMap(new n(), new Function() { // from class: com.oua.util.o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DoubleSummaryStatistics lambda$parseMemoryData$4;
                lambda$parseMemoryData$4 = MemoryMonitor.lambda$parseMemoryData$4((Map.Entry) obj);
                return lambda$parseMemoryData$4;
            }
        }));
    }

    public static MemoryMonitor startMonitor() {
        MemoryMonitor memoryMonitor2 = new MemoryMonitor();
        memoryMonitor = memoryMonitor2;
        memoryMonitor2.start();
        return memoryMonitor;
    }

    public static String toSummaryString(Map<String, DoubleSummaryStatistics> map) {
        return toSummaryString(map, map.size());
    }

    public void checkMemoryUsage() {
        getMemoryUsage().entrySet().forEach(new Consumer() { // from class: com.oua.util.u
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                MemoryMonitor.this.lambda$checkMemoryUsage$8((Map.Entry) obj);
            }
        });
    }

    public void start() {
        this.memoryData.clear();
        this.handler = new Handler();
        lambda$onCheckMemoryUsage$6();
    }

    public void stop() {
        this.handler = null;
    }

    public static String toSummaryString(Map<String, DoubleSummaryStatistics> map, int i10) {
        return (String) map.entrySet().stream().sorted(Comparator.comparingDouble(new ToDoubleFunction() { // from class: com.oua.util.p
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                double lambda$toSummaryString$0;
                lambda$toSummaryString$0 = MemoryMonitor.lambda$toSummaryString$0((Map.Entry) obj);
                return lambda$toSummaryString$0;
            }
        })).limit(i10).map(new Function() { // from class: com.oua.util.q
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                String lambda$toSummaryString$1;
                lambda$toSummaryString$1 = MemoryMonitor.lambda$toSummaryString$1((Map.Entry) obj);
                return lambda$toSummaryString$1;
            }
        }).collect(Collectors.joining("\n"));
    }
}
