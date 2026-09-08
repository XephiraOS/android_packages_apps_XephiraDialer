package com.heytap.accessory.file;

import android.os.Handler;
import android.os.HandlerThread;
import com.heytap.accessory.file.FileTransfer;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: CallingAgentInfo.java */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public FileTransfer.EventListener f25327a;

    /* renamed from: b, reason: collision with root package name */
    public FileTransfer.c f25328b;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f25329c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f25330d;

    /* renamed from: e, reason: collision with root package name */
    public ConcurrentHashMap<Long, ConcurrentHashMap<Integer, a>> f25331e;

    /* compiled from: CallingAgentInfo.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f25332a;

        /* renamed from: b, reason: collision with root package name */
        public int f25333b;

        /* renamed from: c, reason: collision with root package name */
        public String f25334c;

        /* renamed from: d, reason: collision with root package name */
        public String f25335d;
    }

    public h(FileTransfer.EventListener eventListener, HandlerThread handlerThread, Handler handler, FileTransfer.c cVar, ConcurrentHashMap<Long, ConcurrentHashMap<Integer, a>> concurrentHashMap) {
        this.f25327a = eventListener;
        this.f25329c = handlerThread;
        this.f25330d = handler;
        this.f25331e = concurrentHashMap;
        this.f25328b = cVar;
    }

    public FileTransfer.EventListener a() {
        return this.f25327a;
    }

    public void b(FileTransfer.EventListener eventListener) {
        this.f25327a = eventListener;
    }

    public void c(FileTransfer.c cVar) {
        this.f25328b = cVar;
    }

    public Handler d() {
        return this.f25330d;
    }

    public HandlerThread e() {
        return this.f25329c;
    }

    public FileTransfer.c f() {
        return this.f25328b;
    }

    public ConcurrentHashMap<Long, ConcurrentHashMap<Integer, a>> g() {
        return this.f25331e;
    }
}
