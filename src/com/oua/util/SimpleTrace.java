package com.oua.util;

import com.oua.util.SimpleTrace;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

/* loaded from: classes4.dex */
public class SimpleTrace {
    private static SimpleTrace instance;
    private Section currentSection;
    private Stack<Section> sectionStack = new Stack<>();
    private TraceData traceData = new TraceData();
    private String TAG = SimpleTrace.class.getName();

    /* loaded from: classes4.dex */
    public static class Section {
        private String TAG;
        private long lastTime;
        private String name;
        private long startTime;
        TraceData traceData;

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvent(String str) {
            long j10 = this.lastTime;
            long currentTimeMillis = System.currentTimeMillis();
            this.lastTime = currentTimeMillis;
            addEvent(str, currentTimeMillis - j10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public TraceData end() {
            addEvent("total", System.currentTimeMillis() - this.startTime);
            return this.traceData;
        }

        private Section(String str, TraceData traceData, String str2) {
            this.name = str;
            this.traceData = traceData;
            traceData.addSection(str);
            long currentTimeMillis = System.currentTimeMillis();
            this.startTime = currentTimeMillis;
            this.lastTime = currentTimeMillis;
            this.TAG = str2;
        }

        private void addEvent(String str, long j10) {
            this.traceData.addEvent(this.name, str, j10);
            DebugConfig.logi(this.TAG, String.format("%s/%s, %d", this.name, str, Long.valueOf(j10)));
        }
    }

    /* loaded from: classes4.dex */
    public static class TraceData {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public Map<String, Map<String, List<Long>>> data = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvent(String str, String str2, long j10) {
            Map<String, List<Long>> map = this.data.get(str);
            if (map.containsKey(str2)) {
                map.get(str2).add(Long.valueOf(j10));
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j10));
            map.put(str2, arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSection(String str) {
            if (!this.data.containsKey(str)) {
                this.data.put(str, new HashMap());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Map lambda$parseResult$2(Map.Entry entry) {
            return parseSection((Map) entry.getValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ double lambda$parseSection$3(Long l10) {
            return l10.longValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ DoubleSummaryStatistics lambda$parseSection$4(Map.Entry entry) {
            return ((List) entry.getValue()).stream().mapToDouble(new ToDoubleFunction() { // from class: com.oua.util.J
                @Override // java.util.function.ToDoubleFunction
                public final double applyAsDouble(Object obj) {
                    double lambda$parseSection$3;
                    lambda$parseSection$3 = SimpleTrace.TraceData.lambda$parseSection$3((Long) obj);
                    return lambda$parseSection$3;
                }
            }).summaryStatistics();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ double lambda$toSummaryString$0(Map.Entry entry) {
            return -((DoubleSummaryStatistics) entry.getValue()).getAverage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$toSummaryString$1(Map.Entry entry) {
            DoubleSummaryStatistics doubleSummaryStatistics = (DoubleSummaryStatistics) entry.getValue();
            if (doubleSummaryStatistics.getCount() == 1) {
                return String.format("%s: %d", entry.getKey(), Integer.valueOf((int) doubleSummaryStatistics.getAverage()));
            }
            return String.format("%s: %d (%d -> %d)", entry.getKey(), Integer.valueOf((int) doubleSummaryStatistics.getAverage()), Integer.valueOf((int) doubleSummaryStatistics.getMin()), Integer.valueOf((int) doubleSummaryStatistics.getMax()));
        }

        public static Map<String, DoubleSummaryStatistics> parseSection(Map<String, List<Long>> map) {
            return (Map) map.entrySet().stream().collect(Collectors.toMap(new n(), new Function() { // from class: com.oua.util.I
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    DoubleSummaryStatistics lambda$parseSection$4;
                    lambda$parseSection$4 = SimpleTrace.TraceData.lambda$parseSection$4((Map.Entry) obj);
                    return lambda$parseSection$4;
                }
            }));
        }

        public static String toSummaryString(Map<String, DoubleSummaryStatistics> map) {
            return (String) map.entrySet().stream().sorted(Comparator.comparingDouble(new ToDoubleFunction() { // from class: com.oua.util.F
                @Override // java.util.function.ToDoubleFunction
                public final double applyAsDouble(Object obj) {
                    double lambda$toSummaryString$0;
                    lambda$toSummaryString$0 = SimpleTrace.TraceData.lambda$toSummaryString$0((Map.Entry) obj);
                    return lambda$toSummaryString$0;
                }
            })).map(new Function() { // from class: com.oua.util.G
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    String lambda$toSummaryString$1;
                    lambda$toSummaryString$1 = SimpleTrace.TraceData.lambda$toSummaryString$1((Map.Entry) obj);
                    return lambda$toSummaryString$1;
                }
            }).collect(Collectors.joining("\n"));
        }

        public String getSummaryString(String str) {
            return toSummaryString(parseSection(this.data.get(str)));
        }

        public Map<String, Map<String, DoubleSummaryStatistics>> parseResult() {
            return (Map) this.data.entrySet().stream().collect(Collectors.toMap(new n(), new Function() { // from class: com.oua.util.H
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Map lambda$parseResult$2;
                    lambda$parseResult$2 = SimpleTrace.TraceData.lambda$parseResult$2((Map.Entry) obj);
                    return lambda$parseResult$2;
                }
            }));
        }
    }

    private SimpleTrace() {
    }

    public static synchronized SimpleTrace getTrace() {
        SimpleTrace simpleTrace;
        synchronized (SimpleTrace.class) {
            try {
                if (instance == null) {
                    instance = new SimpleTrace();
                }
                simpleTrace = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return simpleTrace;
    }

    public void addEvent(String str) {
        try {
            this.currentSection.addEvent(str);
        } catch (Exception e10) {
            DebugConfig.logd(this.TAG, e10.toString());
        }
    }

    public void endSection(String str) {
        try {
            if (this.currentSection.name.equals(str)) {
                endSection();
            } else {
                DebugConfig.loge(this.TAG, String.format("currentSection %s not same as target section %s", this.currentSection, str, str));
            }
        } catch (Exception e10) {
            DebugConfig.logd(this.TAG, e10.toString());
        }
    }

    public String getCurrentSection(String str) {
        return this.currentSection.name;
    }

    public Map<String, List<Long>> getSectionData(String str) {
        return this.traceData.data.get(str);
    }

    public long getSectionRunTime(String str) {
        List<Long> sectionRunTimes = getSectionRunTimes(str);
        if (sectionRunTimes != null && !sectionRunTimes.isEmpty()) {
            return sectionRunTimes.get(0).longValue();
        }
        return 0L;
    }

    public List<Long> getSectionRunTimes(String str) {
        return getSectionData(str).get("total");
    }

    public TraceData getTraceData() {
        return this.traceData;
    }

    public void startSection(String str, String str2) {
        try {
            DebugConfig.logi(str2, String.format("%s/start", str));
            Section section = this.currentSection;
            if (section != null) {
                this.sectionStack.push(section);
            }
            TraceData traceData = this.traceData;
            if (str2 == null) {
                str2 = SimpleTrace.class.getName();
            }
            this.currentSection = new Section(str, traceData, str2);
        } catch (Exception e10) {
            DebugConfig.logd(this.TAG, e10.toString());
        }
    }

    private void endSection() {
        try {
            this.currentSection.end();
            this.currentSection = this.sectionStack.isEmpty() ? null : this.sectionStack.pop();
        } catch (Exception e10) {
            DebugConfig.logd(this.TAG, e10.toString());
        }
    }
}
