package com.customize.contacts.manager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseBooleanArray;
import com.customize.contacts.util.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import w0.C1643c;

/* compiled from: SimWifiStatusManager.kt */
/* loaded from: classes3.dex */
public final class B {

    /* renamed from: k, reason: collision with root package name */
    public static final a f21484k = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public c f21486b;

    /* renamed from: d, reason: collision with root package name */
    public b f21488d;

    /* renamed from: g, reason: collision with root package name */
    public boolean f21491g;

    /* renamed from: i, reason: collision with root package name */
    public Context f21493i;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21487c = true;

    /* renamed from: e, reason: collision with root package name */
    public SparseBooleanArray f21489e = new SparseBooleanArray();

    /* renamed from: f, reason: collision with root package name */
    public SparseBooleanArray f21490f = new SparseBooleanArray();

    /* renamed from: h, reason: collision with root package name */
    public final boolean f21492h = C1643c.w();

    /* renamed from: j, reason: collision with root package name */
    public int f21494j = Integer.MIN_VALUE;

    /* renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f21485a = N7.a.a();

    /* compiled from: SimWifiStatusManager.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SimWifiStatusManager.kt */
    /* loaded from: classes3.dex */
    public interface b {
        void y0(int i10, boolean z10, boolean z11, boolean z12, int i11);
    }

    /* compiled from: SimWifiStatusManager.kt */
    /* loaded from: classes3.dex */
    public final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ B f21495a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(B b10, Looper looper) {
            super(looper);
            kotlin.jvm.internal.i.f(looper, "looper");
            this.f21495a = b10;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleMessage(android.os.Message r11) {
            /*
                Method dump skipped, instructions count: 269
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.manager.B.c.handleMessage(android.os.Message):void");
        }
    }

    public B(Context context) {
        Looper mainLooper = Looper.getMainLooper();
        kotlin.jvm.internal.i.e(mainLooper, "getMainLooper()");
        this.f21486b = new c(this, mainLooper);
        this.f21493i = context;
    }

    public static final void k(B this$0, int i10, Context context, List simInfos) {
        int i11;
        int i12;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(simInfos, "$simInfos");
        c cVar = this$0.f21486b;
        kotlin.jvm.internal.i.c(cVar);
        Message obtainMessage = cVar.obtainMessage();
        kotlin.jvm.internal.i.e(obtainMessage, "mHandler!!.obtainMessage()");
        int i13 = 1;
        if (i10 < 2) {
            if (b0.C0(context, simInfos)) {
                i12 = 2;
            } else {
                i12 = 1;
            }
            obtainMessage.arg1 = i12;
            if (this$0.f21492h) {
                if (C1643c.u(context)) {
                    i13 = 2;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("VideoCallUseable", i13);
                obtainMessage.setData(bundle);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = simInfos.iterator();
            while (it.hasNext()) {
                b0.a aVar = (b0.a) it.next();
                if (aVar.f22051a == 0) {
                    arrayList.add(aVar);
                } else {
                    arrayList2.add(aVar);
                }
            }
            if (b0.C0(context, arrayList)) {
                i11 = 2;
            } else {
                i11 = 1;
            }
            obtainMessage.arg1 = i11;
            if (b0.C0(context, arrayList2)) {
                i13 = 2;
            }
            obtainMessage.arg2 = i13;
        }
        obtainMessage.obj = Integer.valueOf(i10);
        c cVar2 = this$0.f21486b;
        kotlin.jvm.internal.i.c(cVar2);
        cVar2.sendMessage(obtainMessage);
    }

    public final void j(final Context context, final int i10, final List<? extends b0.a> list) {
        if (context != null && !list.isEmpty()) {
            if (this.f21485a == null) {
                this.f21485a = N7.a.a();
            }
            if (this.f21486b == null) {
                Looper mainLooper = Looper.getMainLooper();
                kotlin.jvm.internal.i.e(mainLooper, "getMainLooper()");
                this.f21486b = new c(this, mainLooper);
            }
            this.f21491g = false;
            ThreadPoolExecutor threadPoolExecutor = this.f21485a;
            kotlin.jvm.internal.i.c(threadPoolExecutor);
            threadPoolExecutor.execute(new Runnable() { // from class: com.customize.contacts.manager.A
                @Override // java.lang.Runnable
                public final void run() {
                    B.k(B.this, i10, context, list);
                }
            });
        }
    }

    public final void l(Context context, int i10, List<? extends b0.a> list) {
        if (i10 == 0) {
            this.f21491g = true;
            this.f21489e.clear();
            this.f21490f.clear();
            ThreadPoolExecutor threadPoolExecutor = this.f21485a;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.shutdownNow();
            }
            this.f21485a = null;
            H7.b.b("SimWifiStatusManager", "no available sim");
            return;
        }
        if (context != null && !list.isEmpty()) {
            H7.b.b("SimWifiStatusManager", "checkWifiStatus availableSimCount : " + i10);
            j(context, i10, list);
            return;
        }
        H7.b.b("SimWifiStatusManager", "checkWifiStatus simInfos isEmpty!");
    }

    public final void m(b bVar) {
        this.f21488d = bVar;
    }

    public final void n() {
        this.f21489e.clear();
        this.f21487c = true;
        c cVar = this.f21486b;
        if (cVar != null) {
            cVar.removeCallbacksAndMessages(null);
        }
        ThreadPoolExecutor threadPoolExecutor = this.f21485a;
        if (threadPoolExecutor != null) {
            kotlin.jvm.internal.i.c(threadPoolExecutor);
            threadPoolExecutor.shutdown();
            this.f21485a = null;
        }
        p();
    }

    public final void o(Context context, boolean z10, int i10, List<? extends b0.a> simInfos, boolean z11) {
        boolean z12;
        boolean z13;
        int i11;
        boolean z14;
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(simInfos, "simInfos");
        H7.b.b("SimWifiStatusManager", "requestUpdateBottomView wifiCallingFeatureEnabled : " + z10 + "; availableSimCount : " + i10 + "; forceRefresh : " + z11);
        if (z10) {
            l(context.getApplicationContext(), i10, simInfos);
        }
        if (this.f21487c || z11) {
            if (z10) {
                z12 = this.f21489e.get(0);
                z13 = this.f21489e.get(1);
            } else {
                z12 = false;
                z13 = false;
            }
            if (!b0.B0(context.getApplicationContext())) {
                i11 = b0.k(context.getApplicationContext());
            } else {
                i11 = -1;
            }
            int i12 = i11;
            if (this.f21492h) {
                z14 = this.f21490f.get(0);
            } else {
                z14 = false;
            }
            if (this.f21494j == Integer.MIN_VALUE) {
                this.f21494j = i12;
            }
            H7.b.b("SimWifiStatusManager", "defaultSlotId:" + i12);
            q(i10, z12, z13, z14, i12);
        }
        this.f21487c = false;
    }

    public final void p() {
        this.f21488d = null;
    }

    public final void q(int i10, boolean z10, boolean z11, boolean z12, int i11) {
        b bVar = this.f21488d;
        if (bVar != null) {
            bVar.y0(i10, z10, z11, z12, i11);
        }
    }
}
