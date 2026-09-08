package com.android.contacts.scenecard;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import com.oplus.foundation.util.feature.FeatureUtil;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: SceneCardManager.kt */
/* renamed from: com.android.contacts.scenecard.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0670d {

    /* renamed from: a, reason: collision with root package name */
    public static final C0670d f17264a = new C0670d();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Integer, Class<SceneDialtactsFragment>> f17265b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map<Integer, C0669c> f17266c;

    /* renamed from: d, reason: collision with root package name */
    public static Context f17267d;

    /* renamed from: e, reason: collision with root package name */
    public static final Map<Integer, Parcelable> f17268e;

    /* compiled from: SceneCardManager.kt */
    /* renamed from: com.android.contacts.scenecard.d$a */
    /* loaded from: classes.dex */
    public static final class a extends androidx.fragment.app.l<C0669c> implements androidx.lifecycle.N {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ContextThemeWrapper f17269f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ C0669c f17270g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ContextThemeWrapper contextThemeWrapper, C0669c c0669c, Handler handler) {
            super(contextThemeWrapper, handler, 0);
            this.f17269f = contextThemeWrapper;
            this.f17270g = c0669c;
        }

        @Override // androidx.fragment.app.l, androidx.fragment.app.i
        public View c(int i10) {
            View b10 = this.f17270g.b();
            if (b10 != null) {
                return b10.findViewById(i10);
            }
            return null;
        }

        @Override // androidx.lifecycle.N
        public androidx.lifecycle.M getViewModelStore() {
            return new androidx.lifecycle.M();
        }

        @Override // androidx.fragment.app.l
        public LayoutInflater j() {
            LayoutInflater cloneInContext = LayoutInflater.from(this.f17269f).cloneInContext(this.f17269f);
            kotlin.jvm.internal.i.e(cloneInContext, "from(contextThemeWrapper…text(contextThemeWrapper)");
            return cloneInContext;
        }

        @Override // androidx.fragment.app.l
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public C0669c i() {
            return this.f17270g;
        }
    }

    static {
        int i10;
        Map<Integer, Class<SceneDialtactsFragment>> b10;
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            i10 = 777770051;
        } else {
            i10 = 777770031;
        }
        b10 = kotlin.collections.D.b(m9.g.a(Integer.valueOf(i10), SceneDialtactsFragment.class));
        f17265b = b10;
        f17266c = new LinkedHashMap();
        f17268e = new LinkedHashMap();
    }

    public final void a() {
        f17268e.clear();
    }

    public final void b(int i10) {
        f17268e.remove(Integer.valueOf(i10));
    }

    public final void c(Configuration newConfiguration) {
        kotlin.jvm.internal.i.f(newConfiguration, "newConfiguration");
        for (Map.Entry<Integer, C0669c> entry : f17266c.entrySet()) {
            H7.b.e("SceneCardManager", "configurationChange cardId " + entry.getKey());
            if (FeatureUtil.S()) {
                f17264a.e(entry.getKey().intValue());
            } else {
                androidx.fragment.app.j a10 = entry.getValue().a();
                if (a10 != null) {
                    a10.d(newConfiguration);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        if (r0 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(int r9) {
        /*
            r8 = this;
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "createCard "
            r8.append(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r0 = "SceneCardManager"
            H7.b.e(r0, r8)
            java.util.Map<java.lang.Integer, java.lang.Class<com.android.contacts.scenecard.SceneDialtactsFragment>> r8 = com.android.contacts.scenecard.C0670d.f17265b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            java.lang.Object r8 = r8.get(r1)
            java.lang.Class r8 = (java.lang.Class) r8
            if (r8 != 0) goto L39
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "sceneCardFragmentClassMap is not exist "
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            H7.b.c(r0, r8)
            return
        L39:
            android.content.Context r0 = com.android.contacts.scenecard.C0670d.f17267d
            r1 = 0
            if (r0 == 0) goto L53
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L53
            android.content.res.Configuration r0 = r0.getConfiguration()
            if (r0 == 0) goto L53
            int r2 = r0.uiMode
            r2 = r2 & (-49)
            r2 = r2 | 16
            r0.uiMode = r2
            goto L54
        L53:
            r0 = r1
        L54:
            if (r0 == 0) goto L62
            android.content.Context r2 = com.android.contacts.scenecard.C0670d.f17267d
            if (r2 == 0) goto L5f
            android.content.Context r0 = r2.createConfigurationContext(r0)
            goto L60
        L5f:
            r0 = r1
        L60:
            if (r0 != 0) goto L64
        L62:
            android.content.Context r0 = com.android.contacts.scenecard.C0670d.f17267d
        L64:
            android.view.ContextThemeWrapper r2 = new android.view.ContextThemeWrapper
            r3 = 2132083491(0x7f150323, float:1.9807126E38)
            r2.<init>(r0, r3)
            java.util.Map<java.lang.Integer, com.android.contacts.scenecard.c> r0 = com.android.contacts.scenecard.C0670d.f17266c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            com.android.contacts.scenecard.c r4 = new com.android.contacts.scenecard.c
            r4.<init>()
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r2)
            r6 = 2131624542(0x7f0e025e, float:1.8876267E38)
            r7 = 0
            android.view.View r5 = r5.inflate(r6, r1, r7)
            r4.d(r5)
            android.os.Handler r5 = new android.os.Handler
            r5.<init>()
            com.android.contacts.scenecard.d$a r6 = new com.android.contacts.scenecard.d$a
            r6.<init>(r2, r4, r5)
            androidx.fragment.app.j r2 = androidx.fragment.app.j.b(r6)
            java.lang.String r5 = "contextThemeWrapper = Co…delStore()\n            })"
            kotlin.jvm.internal.i.e(r2, r5)
            r4.c(r2)
            r2.a(r1)
            java.util.Map<java.lang.Integer, android.os.Parcelable> r1 = com.android.contacts.scenecard.C0670d.f17268e
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Object r9 = r1.get(r9)
            android.os.Parcelable r9 = (android.os.Parcelable) r9
            if (r9 == 0) goto Lb1
            r2.q(r9)
            goto Lc9
        Lb1:
            androidx.fragment.app.FragmentManager r9 = r2.n()
            androidx.fragment.app.B r9 = r9.p()
            java.lang.Object r8 = r8.newInstance()
            androidx.fragment.app.Fragment r8 = (androidx.fragment.app.Fragment) r8
            r1 = 2131428866(0x7f0b0602, float:1.8479389E38)
            androidx.fragment.app.B r8 = r9.s(r1, r8)
            r8.k()
        Lc9:
            r2.f()
            r2.c()
            r0.put(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.scenecard.C0670d.d(int):void");
    }

    public final void e(int i10) {
        androidx.fragment.app.j jVar;
        H7.b.e("SceneCardManager", "destroyCard " + i10);
        Map<Integer, C0669c> map = f17266c;
        C0669c c0669c = map.get(Integer.valueOf(i10));
        if (c0669c != null) {
            jVar = c0669c.a();
        } else {
            jVar = null;
        }
        if (jVar == null) {
            H7.b.c("SceneCardManager", "destroyCard controller not exist " + i10);
            return;
        }
        jVar.h();
        jVar.g();
        map.remove(Integer.valueOf(i10));
    }

    public final View f(int i10) {
        C0669c c0669c = f17266c.get(Integer.valueOf(i10));
        if (c0669c != null) {
            androidx.fragment.app.j a10 = c0669c.a();
            if (a10 != null) {
                a10.j();
            }
            return c0669c.b();
        }
        return null;
    }

    public final void g(Context context) {
        H7.b.e("SceneCardManager", "init");
        f17267d = context;
    }

    public final void h(int i10) {
        androidx.fragment.app.j jVar;
        H7.b.e("SceneCardManager", "pauseCard " + i10);
        C0669c c0669c = f17266c.get(Integer.valueOf(i10));
        if (c0669c != null) {
            jVar = c0669c.a();
        } else {
            jVar = null;
        }
        if (jVar == null) {
            H7.b.c("SceneCardManager", "pauseCard controller not exist " + i10);
            return;
        }
        jVar.i();
        Parcelable r10 = jVar.r();
        if (r10 == null) {
            f17268e.remove(Integer.valueOf(i10));
        } else {
            f17268e.put(Integer.valueOf(i10), r10);
        }
        jVar.l();
    }

    public final void i(int i10) {
        androidx.fragment.app.j jVar;
        H7.b.e("SceneCardManager", "resumeCard " + i10);
        Map<Integer, C0669c> map = f17266c;
        if (map.get(Integer.valueOf(i10)) == null) {
            H7.b.e("SceneCardManager", "resumeCard " + i10 + " not exist try to create");
            d(i10);
        }
        C0669c c0669c = map.get(Integer.valueOf(i10));
        if (c0669c != null) {
            jVar = c0669c.a();
        } else {
            jVar = null;
        }
        if (jVar == null) {
            H7.b.i("SceneCardManager", "resumeCard controller not exist " + i10);
            return;
        }
        jVar.m();
        jVar.k();
        jVar.j();
    }
}
