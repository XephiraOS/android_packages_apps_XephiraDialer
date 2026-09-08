package com.android.contacts.framework.baseui.util;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.scheduler.ThreadUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import p9.InterfaceC1470d;
import v9.InterfaceC1637a;

/* compiled from: LocationUtils.kt */
/* loaded from: classes.dex */
public final class LocationUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final LocationUtils f15852a = new LocationUtils();

    /* renamed from: b, reason: collision with root package name */
    public static final String f15853b;

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f15854c;

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f15855d;

    /* renamed from: e, reason: collision with root package name */
    public static final m9.d f15856e;

    /* renamed from: f, reason: collision with root package name */
    public static String f15857f;

    /* renamed from: g, reason: collision with root package name */
    public static final List<a> f15858g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f15859h;

    /* compiled from: LocationUtils.kt */
    @InterfaceC1470d(c = "com.android.contacts.framework.baseui.util.LocationUtils$1", f = "LocationUtils.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.framework.baseui.util.LocationUtils$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
        int label;

        public AnonymousClass1(kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                P7.a.f2961a.a().getContentResolver().registerContentObserver(Settings.System.getUriFor("phone_area_inquire_language_and_data_version"), true, LocationUtils.f15859h);
                return m9.q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
        }
    }

    /* compiled from: LocationUtils.kt */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str);
    }

    /* compiled from: LocationUtils.kt */
    /* loaded from: classes.dex */
    public static final class b extends ContentObserver {
        public b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            LocationUtils.f15857f = LocationUtils.c();
            H7.b.e("LocationUtils", "versionSettingsContentObserver = " + LocationUtils.g());
            Iterator it = LocationUtils.f15858g.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(LocationUtils.g());
            }
        }
    }

    static {
        m9.d a10;
        String i10 = com.android.contacts.framework.api.appstore.appinfo.a.i();
        f15853b = i10;
        Uri parse = Uri.parse("content://" + i10 + "/phoneno");
        kotlin.jvm.internal.i.e(parse, "parse(\"content://$AUTHOR…NO_AREA_INQUIRE/phoneno\")");
        f15854c = parse;
        f15855d = Uri.parse("content://" + i10 + "/phone_numbers");
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.framework.baseui.util.LocationUtils$supportSettingVersion$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(M7.a.h(P7.a.f2961a.a(), "com.oplus.phonenoareainquire", "support_setting_version", "true"));
            }
        });
        f15856e = a10;
        f15857f = m();
        f15858g = new ArrayList();
        f15859h = new b(ThreadUtilsKt.a());
        C1248i.d(C1241e0.f34422a, S.b(), null, new AnonymousClass1(null), 2, null);
    }

    public static final /* synthetic */ String c() {
        return m();
    }

    public static final void e(a listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        f15858g.add(listener);
    }

    public static final Uri f() {
        Uri.Builder buildUpon = f15855d.buildUpon();
        buildUpon.appendQueryParameter("is_need_carrier_name", "true");
        Uri build = buildUpon.build();
        kotlin.jvm.internal.i.e(build, "builder.build()");
        return build;
    }

    public static final String g() {
        return f15857f;
    }

    public static final Uri h(String str) {
        Uri.Builder buildUpon = Uri.withAppendedPath(f15854c, str).buildUpon();
        buildUpon.appendQueryParameter("is_need_carrier_name", "true");
        Uri build = buildUpon.build();
        kotlin.jvm.internal.i.e(build, "builder.build()");
        return build;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0037, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0058, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        if (r8 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
    
        if (r8 != null) goto L16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String i(android.content.Context r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.i.f(r8, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r1 = 0
            if (r0 == 0) goto Ld
            return r1
        Ld:
            android.net.Uri r3 = h(r9)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            if (r8 == 0) goto L35
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            if (r9 == 0) goto L35
            java.lang.String r9 = "cityname"
            int r9 = r8.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            java.lang.String r1 = r8.getString(r9)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            goto L35
        L30:
            r9 = move-exception
            r1 = r8
            goto L59
        L33:
            r9 = move-exception
            goto L3f
        L35:
            if (r8 == 0) goto L58
        L37:
            r8.close()
            goto L58
        L3b:
            r9 = move-exception
            goto L59
        L3d:
            r9 = move-exception
            r8 = r1
        L3f:
            java.lang.String r0 = "LocationUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30
            r2.<init>()     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "query location Exception: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L30
            r2.append(r9)     // Catch: java.lang.Throwable -> L30
            java.lang.String r9 = r2.toString()     // Catch: java.lang.Throwable -> L30
            H7.b.c(r0, r9)     // Catch: java.lang.Throwable -> L30
            if (r8 == 0) goto L58
            goto L37
        L58:
            return r1
        L59:
            if (r1 == 0) goto L5e
            r1.close()
        L5e:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.baseui.util.LocationUtils.i(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String j(android.content.Context r8, java.lang.String r9, java.lang.String r10, int r11, boolean r12) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.i.f(r8, r0)
            r0 = 0
            android.net.Uri r9 = h(r9)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            boolean r1 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            if (r1 == 0) goto L20
            C7.c r10 = C7.c.b(r8)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            java.lang.String r10 = r10.a()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            goto L20
        L19:
            r8 = move-exception
            goto Lb5
        L1c:
            r8 = move-exception
            r9 = r0
            goto L97
        L20:
            android.net.Uri$Builder r9 = r9.buildUpon()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            java.lang.String r1 = "countryiso"
            android.net.Uri$Builder r9 = r9.appendQueryParameter(r1, r10)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            android.net.Uri r9 = r9.build()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            java.lang.String r10 = "uri.buildUpon().appendQu…iso\", countryIso).build()"
            kotlin.jvm.internal.i.e(r9, r10)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            android.net.Uri$Builder r9 = r9.buildUpon()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            java.lang.String r10 = "is_roam"
            r1 = 1
            if (r11 != r1) goto L41
            java.lang.String r11 = "true"
            goto L43
        L41:
            java.lang.String r11 = "false"
        L43:
            android.net.Uri$Builder r9 = r9.appendQueryParameter(r10, r11)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            android.net.Uri r9 = r9.build()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            java.lang.String r10 = "uri.buildUpon().appendQu…g()\n            ).build()"
            kotlin.jvm.internal.i.e(r9, r10)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            android.net.Uri$Builder r9 = r9.buildUpon()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            java.lang.String r10 = "is_domestic_sim"
            java.lang.String r11 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            android.net.Uri$Builder r9 = r9.appendQueryParameter(r10, r11)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            android.net.Uri r2 = r9.build()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            java.lang.String r9 = "uri.buildUpon().appendQu…icSim.toString()).build()"
            kotlin.jvm.internal.i.e(r2, r9)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            r5 = 0
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            if (r8 == 0) goto L91
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8c
            if (r9 == 0) goto L91
            java.lang.String r9 = "cityname"
            int r9 = r8.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8c
            java.lang.String r0 = r8.getString(r9)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8c
            goto L91
        L88:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Lb5
        L8c:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L97
        L91:
            if (r8 == 0) goto Lb2
            r8.close()
            goto Lb2
        L97:
            java.lang.String r10 = "LocationUtils"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb3
            r11.<init>()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r12 = "query location Exception: "
            r11.append(r12)     // Catch: java.lang.Throwable -> Lb3
            r11.append(r8)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r8 = r11.toString()     // Catch: java.lang.Throwable -> Lb3
            H7.b.c(r10, r8)     // Catch: java.lang.Throwable -> Lb3
            if (r9 == 0) goto Lb2
            r9.close()
        Lb2:
            return r0
        Lb3:
            r8 = move-exception
            r0 = r9
        Lb5:
            if (r0 == 0) goto Lba
            r0.close()
        Lba:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.baseui.util.LocationUtils.j(android.content.Context, java.lang.String, java.lang.String, int, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0098, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
    
        if (r8 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.HashMap<java.lang.String, java.lang.String> k(android.content.ContentResolver r9, java.util.ArrayList<java.lang.String> r10, java.util.HashMap<java.lang.String, java.lang.String> r11) {
        /*
            java.lang.String r0 = "resolver"
            kotlin.jvm.internal.i.f(r9, r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            if (r10 == 0) goto L9f
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto L14
            goto L9f
        L14:
            int r1 = r10.size()
            int r1 = r1 * 2
            java.lang.String[] r6 = new java.lang.String[r1]
            int r1 = r10.size()
            r2 = 0
            r3 = r2
        L22:
            r8 = 0
            if (r2 >= r1) goto L43
            java.lang.Object r4 = r10.get(r2)
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r3 + 1
            r6[r3] = r4
            if (r11 == 0) goto L3c
            int r3 = r3 + 2
            java.lang.Object r4 = r11.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r6[r5] = r4
            goto L40
        L3c:
            int r3 = r3 + 2
            r6[r5] = r8
        L40:
            int r2 = r2 + 1
            goto L22
        L43:
            android.net.Uri r3 = f()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r5 = 0
            r7 = 0
            r4 = 0
            r2 = r9
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r8 == 0) goto L79
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r9 == 0) goto L79
            java.lang.String r9 = "number"
            int r9 = r8.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r10 = "cityname"
            int r10 = r8.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
        L63:
            java.lang.String r11 = r8.getString(r9)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r1 = r8.getString(r10)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r0.put(r11, r1)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            boolean r11 = r8.moveToNext()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r11 != 0) goto L63
            goto L79
        L75:
            r9 = move-exception
            goto L99
        L77:
            r9 = move-exception
            goto L7f
        L79:
            if (r8 == 0) goto L98
        L7b:
            r8.close()
            goto L98
        L7f:
            java.lang.String r10 = "LocationUtils"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75
            r11.<init>()     // Catch: java.lang.Throwable -> L75
            java.lang.String r1 = "getPhoneLocations : e = "
            r11.append(r1)     // Catch: java.lang.Throwable -> L75
            r11.append(r9)     // Catch: java.lang.Throwable -> L75
            java.lang.String r9 = r11.toString()     // Catch: java.lang.Throwable -> L75
            H7.b.c(r10, r9)     // Catch: java.lang.Throwable -> L75
            if (r8 == 0) goto L98
            goto L7b
        L98:
            return r0
        L99:
            if (r8 == 0) goto L9e
            r8.close()
        L9e:
            throw r9
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.baseui.util.LocationUtils.k(android.content.ContentResolver, java.util.ArrayList, java.util.HashMap):java.util.HashMap");
    }

    public static final boolean l() {
        return ((Boolean) f15856e.getValue()).booleanValue();
    }

    public static final String m() {
        String string = Settings.System.getString(P7.a.f2961a.a().getContentResolver(), "phone_area_inquire_language_and_data_version");
        if (string == null) {
            return "-1,-1," + OsUtils.f28275a.b();
        }
        return string + "," + OsUtils.f28275a.b();
    }

    public static final void n(a listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        f15858g.remove(listener);
    }
}
