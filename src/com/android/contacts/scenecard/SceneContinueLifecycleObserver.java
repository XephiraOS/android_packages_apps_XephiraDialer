package com.android.contacts.scenecard;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Bundle;
import android.provider.Settings;
import androidx.lifecycle.InterfaceC0480c;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import com.android.contacts.Q0;
import com.coui.appcompat.baseview.util.FoldSettingsHelper;
import com.heytap.accessory.constant.FastPairConstants;
import kotlin.Pair;

/* compiled from: SceneContinueLifecycleObserver.kt */
/* loaded from: classes.dex */
public final class SceneContinueLifecycleObserver implements InterfaceC0480c {

    /* renamed from: h, reason: collision with root package name */
    public static final a f17139h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f17140a;

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC0667a f17141b;

    /* renamed from: c, reason: collision with root package name */
    public Lifecycle f17142c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f17143d;

    /* renamed from: e, reason: collision with root package name */
    public long f17144e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f17145f;

    /* renamed from: g, reason: collision with root package name */
    public final b f17146g;

    /* compiled from: SceneContinueLifecycleObserver.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SceneContinueLifecycleObserver.kt */
    /* loaded from: classes.dex */
    public static final class b extends ContentObserver {
        public b() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            Lifecycle.State state;
            Boolean bool;
            boolean h10 = SceneContinueLifecycleObserver.this.h();
            Lifecycle lifecycle = SceneContinueLifecycleObserver.this.f17142c;
            if (lifecycle != null) {
                state = lifecycle.b();
            } else {
                state = null;
            }
            H7.b.e("SceneContinueController", "currentState : " + state + ", started: " + SceneContinueLifecycleObserver.this.f17143d + " ,isUnfold : " + h10 + " ,disableContinue : " + SceneContinueLifecycleObserver.this.f17145f);
            if (!h10 || SceneContinueLifecycleObserver.this.f17145f) {
                return;
            }
            if (SceneContinueLifecycleObserver.this.f17143d || System.currentTimeMillis() - SceneContinueLifecycleObserver.this.f17144e < 200) {
                InterfaceC0667a interfaceC0667a = SceneContinueLifecycleObserver.this.f17141b;
                if (interfaceC0667a == null || !interfaceC0667a.p()) {
                    InterfaceC0667a interfaceC0667a2 = SceneContinueLifecycleObserver.this.f17141b;
                    if (interfaceC0667a2 == null || !interfaceC0667a2.G()) {
                        InterfaceC0667a interfaceC0667a3 = SceneContinueLifecycleObserver.this.f17141b;
                        if (interfaceC0667a3 != null) {
                            bool = Boolean.valueOf(interfaceC0667a3.i());
                        } else {
                            bool = null;
                        }
                        Q0.e(bool);
                        H7.b.e("SceneContinueController", "isDialpadShow " + bool);
                        SceneContinueLifecycleObserver.j(SceneContinueLifecycleObserver.this, false, null, 3, null);
                        return;
                    }
                    H7.b.e("SceneContinueController", "isShowingSystemPermissionDialog");
                    SceneContinueLifecycleObserver.j(SceneContinueLifecycleObserver.this, true, null, 2, null);
                    return;
                }
                H7.b.e("SceneContinueController", "isShowingAppSetPermissionDialog");
                SceneContinueLifecycleObserver.j(SceneContinueLifecycleObserver.this, false, 6, 1, null);
            }
        }
    }

    public SceneContinueLifecycleObserver(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        this.f17140a = context;
        this.f17146g = new b();
    }

    public static /* synthetic */ void j(SceneContinueLifecycleObserver sceneContinueLifecycleObserver, boolean z10, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            num = null;
        }
        sceneContinueLifecycleObserver.i(z10, num);
    }

    public final void g() {
        this.f17145f = true;
    }

    public final boolean h() {
        if (Settings.Global.getInt(this.f17140a.getContentResolver(), FoldSettingsHelper.SYSTEM_FOLDING_MODE_KEY, 1) == 1) {
            return true;
        }
        return false;
    }

    public final void i(boolean z10, Integer num) {
        Pair b10 = C0672f.b(C0672f.f17272a, this.f17140a, 0, num, 0, 8, null);
        Intent intent = (Intent) b10.a();
        Bundle bundle = (Bundle) b10.b();
        if (z10) {
            intent.addFlags(FastPairConstants.PAIR_TYPE_BLE_IN_PAIR);
        }
        this.f17140a.startActivity(intent, bundle);
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onCreate(InterfaceC0492o owner) {
        InterfaceC0667a interfaceC0667a;
        kotlin.jvm.internal.i.f(owner, "owner");
        super.onCreate(owner);
        H7.b.e("SceneContinueController", "onCreate");
        this.f17140a.getContentResolver().registerContentObserver(Settings.Global.getUriFor(FoldSettingsHelper.SYSTEM_FOLDING_MODE_KEY), false, this.f17146g);
        if (owner instanceof InterfaceC0667a) {
            interfaceC0667a = (InterfaceC0667a) owner;
        } else {
            interfaceC0667a = null;
        }
        this.f17141b = interfaceC0667a;
        this.f17142c = owner.getLifecycle();
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onDestroy(InterfaceC0492o owner) {
        kotlin.jvm.internal.i.f(owner, "owner");
        super.onDestroy(owner);
        H7.b.e("SceneContinueController", "onStop");
        this.f17140a.getContentResolver().unregisterContentObserver(this.f17146g);
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onPause(InterfaceC0492o owner) {
        kotlin.jvm.internal.i.f(owner, "owner");
        super.onPause(owner);
        H7.b.e("SceneContinueController", "onPause");
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onResume(InterfaceC0492o owner) {
        kotlin.jvm.internal.i.f(owner, "owner");
        super.onResume(owner);
        this.f17145f = false;
        H7.b.e("SceneContinueController", "onResume");
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onStart(InterfaceC0492o owner) {
        kotlin.jvm.internal.i.f(owner, "owner");
        super.onStart(owner);
        this.f17143d = true;
        H7.b.e("SceneContinueController", "onStart");
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onStop(InterfaceC0492o owner) {
        kotlin.jvm.internal.i.f(owner, "owner");
        super.onStop(owner);
        H7.b.e("SceneContinueController", "onStop");
        this.f17144e = System.currentTimeMillis();
        this.f17143d = false;
    }
}
