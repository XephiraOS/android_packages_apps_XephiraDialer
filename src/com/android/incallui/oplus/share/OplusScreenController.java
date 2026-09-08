package com.android.incallui.oplus.share;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.PowerManager;
import android.view.Display;
import com.android.incallui.Log;
import com.android.incallui.OplusInCallApp;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: OplusScreenController.kt */
/* loaded from: classes.dex */
public final class OplusScreenController {

    /* renamed from: g, reason: collision with root package name */
    public static final a f19073g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    public static final d<OplusScreenController> f19074h;

    /* renamed from: a, reason: collision with root package name */
    public final Context f19075a;

    /* renamed from: b, reason: collision with root package name */
    public final DisplayManager f19076b;

    /* renamed from: c, reason: collision with root package name */
    public PowerManager f19077c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f19078d;

    /* renamed from: e, reason: collision with root package name */
    public HashSet<b> f19079e;

    /* renamed from: f, reason: collision with root package name */
    public final DisplayManager.DisplayListener f19080f;

    /* compiled from: OplusScreenController.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final OplusScreenController a() {
            return (OplusScreenController) OplusScreenController.f19074h.getValue();
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: OplusScreenController.kt */
    /* loaded from: classes.dex */
    public interface b {
        void onScreenStateChange(boolean z10);
    }

    static {
        d<OplusScreenController> a10;
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<OplusScreenController>() { // from class: com.android.incallui.oplus.share.OplusScreenController$Companion$sInstance$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final OplusScreenController invoke() {
                Context defaultDisplayUiContext = OplusInCallApp.getDefaultDisplayUiContext();
                i.e(defaultDisplayUiContext, "getDefaultDisplayUiContext()");
                return new OplusScreenController(defaultDisplayUiContext, null);
            }
        });
        f19074h = a10;
    }

    public /* synthetic */ OplusScreenController(Context context, f fVar) {
        this(context);
    }

    public static final OplusScreenController e() {
        return f19073g.a();
    }

    public final void d(b screenLister) {
        i.f(screenLister, "screenLister");
        if (!this.f19079e.contains(screenLister)) {
            f("add register " + screenLister);
            this.f19079e.add(screenLister);
        }
    }

    public final void f(String str) {
        if (Log.sDebug) {
            Log.d("OplusScreenController", str);
        }
    }

    public final void g() {
        Iterator<b> it = this.f19079e.iterator();
        while (it.hasNext()) {
            b mListenerSet = it.next();
            i.e(mListenerSet, "mListenerSet");
            b bVar = mListenerSet;
            f("notifyScreenStateChange " + bVar);
            bVar.onScreenStateChange(this.f19078d);
        }
    }

    public final void h(b screenLister) {
        i.f(screenLister, "screenLister");
        if (this.f19079e.contains(screenLister)) {
            f("remove register " + screenLister);
            this.f19079e.remove(screenLister);
        }
    }

    public final void i() {
        Display[] displays = this.f19076b.getDisplays();
        if (displays != null) {
            for (Display display : displays) {
                if (display.getState() == 2) {
                    this.f19078d = true;
                    return;
                }
            }
            f("Screens all off");
            this.f19078d = false;
            return;
        }
        f("No displays found");
        this.f19078d = false;
    }

    public OplusScreenController(Context context) {
        this.f19075a = context;
        Object systemService = context.getSystemService("display");
        i.d(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        DisplayManager displayManager = (DisplayManager) systemService;
        this.f19076b = displayManager;
        Object systemService2 = context.getSystemService("power");
        i.d(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
        this.f19077c = (PowerManager) systemService2;
        this.f19079e = new HashSet<>();
        c cVar = new c();
        this.f19080f = cVar;
        displayManager.registerDisplayListener(cVar, null);
        this.f19078d = this.f19077c.isScreenOn();
    }

    /* compiled from: OplusScreenController.kt */
    /* loaded from: classes.dex */
    public static final class c implements DisplayManager.DisplayListener {
        public c() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i10) {
            OplusScreenController.this.i();
            OplusScreenController.this.g();
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i10) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i10) {
        }
    }
}
