package com.oua.util;

import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.text.format.Formatter;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/* loaded from: classes4.dex */
public class SimpleMemoryMonitor {
    private static final String TAG = "com.oua.util.SimpleMemoryMonitor";
    private Handler handler;
    private long initialMemory = 0;
    private final Queue<Long> maxMemoryUsage = new PriorityQueue();
    private long memoryUsage;
    private int numOfPeak;

    public SimpleMemoryMonitor(int i10) {
        this.numOfPeak = i10;
    }

    private void checkMemoryUsage() {
        this.maxMemoryUsage.add(Long.valueOf((Runtime.getRuntime().totalMemory() + Debug.getNativeHeapAllocatedSize()) - Runtime.getRuntime().freeMemory()));
        if (this.maxMemoryUsage.size() > this.numOfPeak) {
            this.maxMemoryUsage.poll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCheckMemoryUsage() {
        checkMemoryUsage();
        Handler handler = this.handler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.oua.util.E
                @Override // java.lang.Runnable
                public final void run() {
                    SimpleMemoryMonitor.this.onCheckMemoryUsage();
                }
            }, 30L);
        }
    }

    public String getMemoryUsage(Context context) {
        return Formatter.formatShortFileSize(context, this.memoryUsage);
    }

    public void start() {
        this.initialMemory = (Runtime.getRuntime().totalMemory() + Debug.getNativeHeapAllocatedSize()) - Runtime.getRuntime().freeMemory();
        this.handler = new Handler();
        onCheckMemoryUsage();
    }

    public void stop() {
        this.handler = null;
        long j10 = 0;
        if (this.maxMemoryUsage.isEmpty()) {
            this.memoryUsage = 0L;
            return;
        }
        Iterator<Long> it = this.maxMemoryUsage.iterator();
        long j11 = 0;
        while (it.hasNext()) {
            j11 += it.next().longValue();
        }
        long size = j11 / this.maxMemoryUsage.size();
        long j12 = this.initialMemory;
        if (size - j12 >= 0) {
            j10 = size - j12;
        }
        this.memoryUsage = j10;
        this.maxMemoryUsage.clear();
    }
}
