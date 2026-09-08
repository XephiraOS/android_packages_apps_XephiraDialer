package com.oplus.coreapp.appfeature;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AppFeatureCache.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final List<c> f28113a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final List<c> f28114b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static final List<c> f28115c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f28116d = Uri.parse("content://com.oplus.customize.coreapp.configmanager.configprovider.AppFeatureProvider").buildUpon().appendPath("app_feature").build();

    /* renamed from: e, reason: collision with root package name */
    public static boolean f28117e = false;

    /* renamed from: f, reason: collision with root package name */
    public static AppFeatureProviderUtils.CACHE_MODE f28118f;

    /* renamed from: g, reason: collision with root package name */
    public static AppFeatureProviderUtils.CACHE_MODE f28119g;

    /* renamed from: h, reason: collision with root package name */
    public static AppFeatureProviderUtils.CACHE_MODE f28120h;

    /* compiled from: AppFeatureCache.java */
    /* renamed from: com.oplus.coreapp.appfeature.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0260a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28121a;

        static {
            int[] iArr = new int[AppFeatureProviderUtils.FeatureID.values().length];
            f28121a = iArr;
            try {
                iArr[AppFeatureProviderUtils.FeatureID.STATIC_COMPONENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28121a[AppFeatureProviderUtils.FeatureID.DYNAMIC_SIMSLOT_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28121a[AppFeatureProviderUtils.FeatureID.DYNAMIC_SIMSLOT_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: AppFeatureCache.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f28122a = new a();
    }

    /* compiled from: AppFeatureCache.java */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Integer f28123a;

        /* renamed from: b, reason: collision with root package name */
        public String f28124b;

        /* renamed from: c, reason: collision with root package name */
        public String f28125c;

        /* renamed from: d, reason: collision with root package name */
        public String f28126d;

        public String a() {
            return this.f28124b;
        }

        public Integer b() {
            return this.f28123a;
        }

        public String c() {
            return this.f28126d;
        }

        public String d() {
            return this.f28125c;
        }

        public String toString() {
            return "AppFeatureData{_id='" + this.f28123a + "'featureName='" + this.f28124b + "', parameters='" + this.f28125c + "', jasonStr='" + this.f28126d + "'}";
        }
    }

    static {
        AppFeatureProviderUtils.CACHE_MODE cache_mode = AppFeatureProviderUtils.CACHE_MODE.CACHE_AND_DB;
        f28118f = cache_mode;
        f28119g = cache_mode;
        f28120h = cache_mode;
    }

    public static AppFeatureProviderUtils.CACHE_MODE a(AppFeatureProviderUtils.FeatureID featureID) {
        int i10 = C0260a.f28121a[featureID.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return f28120h;
                }
                throw new IllegalArgumentException("getListFromSlot simSlot is not support");
            }
            return f28119g;
        }
        return f28118f;
    }

    public static a d() {
        return b.f28122a;
    }

    public Cursor b(AppFeatureProviderUtils.FeatureID featureID, String str) {
        if (g(f28113a)) {
            return null;
        }
        return c(e(featureID), str);
    }

    public final Cursor c(List<c> list, String str) {
        MatrixCursor f10 = f();
        synchronized (a.class) {
            try {
                for (c cVar : list) {
                    if (cVar != null && cVar.a() != null && cVar.a().equals(str)) {
                        f10.addRow(new Object[]{cVar.b(), cVar.a(), cVar.d(), cVar.c()});
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (f10.getCount() == 0) {
            f10.close();
            return null;
        }
        return f10;
    }

    public final List<c> e(AppFeatureProviderUtils.FeatureID featureID) {
        int i10 = C0260a.f28121a[featureID.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return f28115c;
                }
                throw new IllegalArgumentException("getListFromSlot simSlot is not support");
            }
            return f28114b;
        }
        return f28113a;
    }

    public final MatrixCursor f() {
        return new MatrixCursor(new String[]{BreenoCallContract.BaseColumns._ID, "featurename", "parameters", "lists"});
    }

    public final boolean g(List list) {
        if (list != null && list.size() == 0) {
            return true;
        }
        return false;
    }
}
