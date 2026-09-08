package com.customize.contacts.manager;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.CallLog;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.contacts.framework.api.numberidentify.interfaces.IMarkerData;
import com.android.contacts.framework.api.numberidentify.interfaces.IRecognitionNumber;
import com.android.contacts.framework.baseui.util.LocationUtils;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.C0801l;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import w0.C1641a;

/* compiled from: CallLogDataCacheManager.kt */
/* renamed from: com.customize.contacts.manager.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0786a {

    /* renamed from: c, reason: collision with root package name */
    public static final C0203a f21521c = new C0203a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final C0786a f21522d = new C0786a();

    /* renamed from: a, reason: collision with root package name */
    public Handler f21523a;

    /* renamed from: b, reason: collision with root package name */
    public CancellationSignal f21524b;

    /* compiled from: CallLogDataCacheManager.kt */
    /* renamed from: com.customize.contacts.manager.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0203a {
        public C0203a() {
        }

        public final C0786a a() {
            return C0786a.f21522d;
        }

        public /* synthetic */ C0203a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: CallLogDataCacheManager.kt */
    /* renamed from: com.customize.contacts.manager.a$b */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f21525a;

        /* renamed from: b, reason: collision with root package name */
        public int f21526b;

        public b(int i10, int i11) {
            this.f21525a = i10;
            this.f21526b = i11;
        }

        public final int a() {
            return this.f21525a;
        }

        public final int b() {
            return this.f21526b;
        }

        public final void c(int i10) {
            this.f21525a = i10;
        }

        public final void d(int i10) {
            this.f21526b = i10;
        }

        public /* synthetic */ b(int i10, int i11, int i12, kotlin.jvm.internal.f fVar) {
            this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 0 : i11);
        }
    }

    /* compiled from: CallLogDataCacheManager.kt */
    /* renamed from: com.customize.contacts.manager.a$c */
    /* loaded from: classes3.dex */
    public static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public com.android.contacts.calllog.A f21527a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Looper looper) {
            super(looper);
            kotlin.jvm.internal.i.f(looper, "looper");
        }

        /* JADX WARN: Code restructure failed: missing block: B:81:0x0270, code lost:
        
            r12 = r2;
            r2 = r6;
            r6 = r3;
            r27 = r8;
            r8 = r1;
            r28 = r9;
            r9 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0288, code lost:
        
            if ((!r2.isEmpty()) == false) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x028a, code lost:
        
            G7.c.b(P7.a.f2961a.a().getContentResolver(), "call_log", r2);
            H7.b.e(r28, "cacheCallLogData updateContacts size = " + r2.size());
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x02ad, code lost:
        
            i(r5, r6, r12, r20);
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x02b1, code lost:
        
            if (r9 == (-1)) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x02b3, code lost:
        
            h(r8, r27);
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x02b6, code lost:
        
            R7.d.j(P7.a.f2961a.a().getSharedPreferences("callLog_update", 0), "update_call_log", 0);
            H7.b.e(r28, "cacheCallLogData done: in cache count: " + r14.a() + ", query count: " + r14.b());
            r0 = m9.q.f35511a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x02ee, code lost:
        
            kotlin.io.a.a(r11, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(android.os.CancellationSignal r30) {
            /*
                Method dump skipped, instructions count: 763
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.manager.C0786a.c.a(android.os.CancellationSignal):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(CancellationSignal cancellationSignal) {
            Cursor c10;
            String string;
            String str;
            String str2;
            String str3;
            int i10;
            Object obj;
            if ((cancellationSignal == null || !cancellationSignal.isCanceled()) && (c10 = c()) != null) {
                Throwable th = null;
                Object[] objArr = 0;
                if (cancellationSignal != null) {
                    try {
                        if (cancellationSignal.isCanceled()) {
                            kotlin.io.a.a(c10, null);
                            return;
                        }
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            kotlin.io.a.a(c10, th2);
                            throw th3;
                        }
                    }
                }
                H7.b.b("CallLogDataCacheManager", "cacheContactsData: Calllog count: " + c10.getCount());
                if (c10.getCount() <= 0) {
                    kotlin.io.a.a(c10, null);
                    return;
                }
                D b10 = C.f21496e.b(P7.a.f2961a.a(), cancellationSignal);
                if (cancellationSignal != null && cancellationSignal.isCanceled()) {
                    kotlin.io.a.a(c10, null);
                    return;
                }
                int i11 = 0;
                b bVar = new b(i11, i11, 3, objArr == true ? 1 : 0);
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                String str4 = "";
                Object obj2 = "";
                int i12 = 0;
                Object[] objArr2 = false;
                while (c10.moveToNext() && (string = c10.getString(9)) != null && !string.equals(str4)) {
                    if (cancellationSignal != null && cancellationSignal.isCanceled()) {
                        if (!arrayList.isEmpty()) {
                            G7.c.b(P7.a.f2961a.a().getContentResolver(), "call_log", arrayList);
                        }
                        kotlin.io.a.a(c10, th);
                        return;
                    }
                    if (string.equals(obj2)) {
                        str = "call_log";
                        str2 = "cacheContactsData updateContacts size = ";
                        str3 = str4;
                        i10 = i12;
                    } else {
                        if (TextUtils.isEmpty(c10.getString(8))) {
                            String string2 = c10.getString(1);
                            kotlin.jvm.internal.i.e(string2, "cursor.getString(CallLogQuery.NUMBER)");
                            String string3 = c10.getString(16);
                            kotlin.jvm.internal.i.e(string3, "cursor.getString(CallLogQuery.COUNTRY_ISO_INDEX)");
                            obj = string;
                            str = "call_log";
                            str2 = "cacheContactsData updateContacts size = ";
                            str3 = str4;
                            g(string2, string3, string, arrayList, b10, bVar);
                        } else {
                            obj = string;
                            str = "call_log";
                            str2 = "cacheContactsData updateContacts size = ";
                            str3 = str4;
                        }
                        i10 = i12 + 1;
                        obj2 = obj;
                    }
                    if ((objArr2 == false && i10 >= 20) || (objArr2 != false && i10 >= 200)) {
                        if (!arrayList.isEmpty()) {
                            G7.c.b(P7.a.f2961a.a().getContentResolver(), str, arrayList);
                            H7.b.e("CallLogDataCacheManager", str2 + arrayList.size());
                        }
                        arrayList.clear();
                        objArr2 = true;
                        str4 = str3;
                        th = null;
                        i12 = 0;
                    } else {
                        i12 = i10;
                        str4 = str3;
                        th = null;
                    }
                }
                if (!arrayList.isEmpty()) {
                    G7.c.b(P7.a.f2961a.a().getContentResolver(), "call_log", arrayList);
                    H7.b.e("CallLogDataCacheManager", "cacheContactsData updateContacts size = " + arrayList.size());
                }
                R7.d.j(P7.a.f2961a.a().getSharedPreferences("callLog_update", 0), "update_contacts", 0);
                H7.b.e("CallLogDataCacheManager", "cacheContactsData done: in cache count: " + bVar.a() + ", query count: " + bVar.b());
                m9.q qVar = m9.q.f35511a;
                kotlin.io.a.a(c10, null);
            }
        }

        public final Cursor c() {
            try {
                Result.a aVar = Result.f34166a;
                return P7.a.f2961a.a().getContentResolver().query(com.android.contacts.calllog.r.n(), com.android.contacts.framework.baseui.calllog.d.a(), C0801l.f(), null, null);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
                if (d10 != null) {
                    H7.b.c("CallLogDataCacheManager", "getCallLogCursor e: " + d10);
                    return null;
                }
                return null;
            }
        }

        public final com.android.contacts.calllog.y d(String str, String str2, String str3, D d10) {
            Object obj;
            List<C> b10 = d10.b();
            if (b10 != null && !b10.isEmpty()) {
                if (d10.a() && !TextUtils.isEmpty(str3)) {
                    if (!d10.c().contains(PhoneNumberUtils.toCallerIDMinMatch(str3))) {
                        return com.android.contacts.calllog.y.f14054B;
                    }
                }
                Iterator<T> it = d10.b().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        C c10 = (C) obj;
                        if (kotlin.jvm.internal.i.b(str2, c10.d())) {
                            if (kotlin.jvm.internal.i.b(str3, c10.e()) && str3.length() >= 7) {
                                break;
                            }
                            if (TextUtils.isEmpty(c10.e()) || TextUtils.isEmpty(str3)) {
                                if (kotlin.jvm.internal.i.b(str, c10.f()) && !TextUtils.isEmpty(str)) {
                                    break;
                                }
                            }
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                return f((C) obj);
            }
            return com.android.contacts.calllog.y.f14054B;
        }

        public final com.android.contacts.calllog.A e() {
            com.android.contacts.calllog.A a10 = this.f21527a;
            if (a10 == null) {
                com.android.contacts.calllog.A a11 = new com.android.contacts.calllog.A(P7.a.f2961a.a(), null);
                this.f21527a = a11;
                return a11;
            }
            return a10;
        }

        public final com.android.contacts.calllog.y f(C c10) {
            String str;
            String str2;
            long j10;
            String str3 = null;
            if (c10 == null) {
                return null;
            }
            com.android.contacts.calllog.y yVar = new com.android.contacts.calllog.y();
            C0787b c11 = c10.c();
            if (c11 != null) {
                str = c11.c();
            } else {
                str = null;
            }
            yVar.f14058c = str;
            C0787b c12 = c10.c();
            if (c12 != null) {
                str2 = c12.b();
            } else {
                str2 = null;
            }
            if (str2 != null) {
                C0787b c13 = c10.c();
                if (c13 != null) {
                    str3 = c13.b();
                }
                yVar.f14057b = Uri.parse(str3);
            }
            C0787b c14 = c10.c();
            if (c14 != null) {
                j10 = c14.d();
            } else {
                j10 = -1;
            }
            yVar.f14066k = j10;
            return yVar;
        }

        public final boolean g(String str, String str2, String str3, ArrayList<ContentProviderOperation> arrayList, D d10, b bVar) {
            Uri uri;
            Object b10;
            System.currentTimeMillis();
            com.android.contacts.calllog.y d11 = d(str, str2, str3, d10);
            boolean z10 = false;
            if (d11 == com.android.contacts.calllog.y.f14054B) {
                return false;
            }
            if (d11 == null) {
                d11 = e().j(str, str2, null, -1L);
                bVar.d(bVar.b() + 1);
            } else {
                bVar.c(bVar.a() + 1);
            }
            if (d11 != null) {
                uri = d11.f14057b;
            } else {
                uri = null;
            }
            if (uri == null) {
                return false;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", d11.f14058c);
            try {
                Result.a aVar = Result.f34166a;
                if (FeatureOption.o() && C1641a.n(d11.f14057b)) {
                    z10 = true;
                }
                b10 = Result.b(Boolean.valueOf(z10));
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d12 = Result.d(b10);
            if (d12 != null) {
                H7.b.c("CallLogDataCacheManager", "isNeedUpdateCallLogDatabase error: " + d12);
            }
            Boolean bool = Boolean.FALSE;
            if (Result.f(b10)) {
                b10 = bool;
            }
            if (!((Boolean) b10).booleanValue()) {
                contentValues.put("lookup_uri", U7.g.c(d11.f14057b));
            }
            contentValues.put("photo_id", Long.valueOf(d11.f14066k));
            ContentProviderOperation build = ContentProviderOperation.newUpdate(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL).withValues(contentValues).withSelection("normalized_number=?", new String[]{str3}).build();
            kotlin.jvm.internal.i.e(build, "newUpdate(CallLog.Calls.…                 .build()");
            arrayList.add(build);
            return true;
        }

        public final void h(HashMap<String, F0.c> hashMap, CancellationSignal cancellationSignal) {
            Integer num;
            int i10;
            boolean z10;
            if (!B3.a.u()) {
                H7.b.e("CallLogDataCacheManager", "updateIdentify isNumberRecognitionEnable is false");
                return;
            }
            H7.b.e("CallLogDataCacheManager", "updateIdentify identifyNumbers size = " + hashMap.size());
            if (!hashMap.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (String str : hashMap.keySet()) {
                    if (cancellationSignal != null && cancellationSignal.isCanceled()) {
                        return;
                    }
                    IRecognitionNumber B10 = E0.b.B(hashMap.get(str));
                    if (B10 != null) {
                        String name = B10.getName();
                        if (TextUtils.isEmpty(name)) {
                            IMarkerData B11 = B10.B();
                            if (B11 != null) {
                                num = Integer.valueOf(B11.u());
                            } else {
                                num = null;
                            }
                            String s10 = E0.b.s(P7.a.f2961a.a(), B10.B());
                            if (!TextUtils.isEmpty(s10) && num != null) {
                                IMarkerData B12 = B10.B();
                                if (B12 != null) {
                                    i10 = B12.j0();
                                } else {
                                    i10 = 0;
                                }
                                IMarkerData B13 = B10.B();
                                if (B13 != null) {
                                    z10 = B13.a0();
                                } else {
                                    z10 = false;
                                }
                                ContentProviderOperation build = ContentProviderOperation.newUpdate(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL).withValue("identify_name", E0.b.l(new F0.a(null, s10, num.intValue(), i10, z10))).withSelection("normalized_number=?", new String[]{str}).build();
                                kotlin.jvm.internal.i.e(build, "newUpdate(CallLog.Calls.…                 .build()");
                                arrayList.add(build);
                            }
                        } else {
                            ContentProviderOperation build2 = ContentProviderOperation.newUpdate(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL).withValue("identify_name", E0.b.l(new F0.a(name, null, 0, 0, false))).withSelection("normalized_number=?", new String[]{str}).build();
                            kotlin.jvm.internal.i.e(build2, "newUpdate(CallLog.Calls.…                 .build()");
                            arrayList.add(build2);
                        }
                    } else {
                        H7.b.e("CallLogDataCacheManager", "updateIdentify queryNumberInfo is null ");
                    }
                }
                if (true ^ arrayList.isEmpty()) {
                    G7.c.b(P7.a.f2961a.a().getContentResolver(), "call_log", arrayList);
                    H7.b.e("CallLogDataCacheManager", "updateIdentify operationsList size = " + arrayList.size());
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            int i10 = msg.what;
            CancellationSignal cancellationSignal = null;
            if (i10 != 1) {
                if (i10 == 2) {
                    Object obj = msg.obj;
                    if (obj instanceof CancellationSignal) {
                        cancellationSignal = (CancellationSignal) obj;
                    }
                    b(cancellationSignal);
                    return;
                }
                return;
            }
            Object obj2 = msg.obj;
            if (obj2 instanceof CancellationSignal) {
                cancellationSignal = (CancellationSignal) obj2;
            }
            a(cancellationSignal);
        }

        public final void i(ArrayList<String> arrayList, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str) {
            H7.b.e("CallLogDataCacheManager", "updateLocation numbers size = " + arrayList.size());
            if (!arrayList.isEmpty()) {
                ContentResolver contentResolver = P7.a.f2961a.a().getContentResolver();
                kotlin.jvm.internal.i.e(contentResolver, "ContextGetter.context.contentResolver");
                HashMap<String, String> k10 = LocationUtils.k(contentResolver, arrayList, hashMap);
                H7.b.e("CallLogDataCacheManager", "updateLocation locations size = " + k10.size());
                ArrayList arrayList2 = new ArrayList();
                for (String str2 : k10.keySet()) {
                    ContentProviderOperation.Builder withSelection = ContentProviderOperation.newUpdate(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL).withValue("geocoded_location", k10.get(str2)).withSelection("normalized_number=?", new String[]{hashMap2.get(str2)});
                    kotlin.jvm.internal.i.e(withSelection, "newUpdate(CallLog.Calls.…rrayOf(normalizedNumber))");
                    if (LocationUtils.l() && CommonOSPublicFeature.e()) {
                        withSelection.withValue("oplus_data1", new Q0.a(str).c());
                    }
                    arrayList2.add(withSelection.build());
                }
                if (!arrayList2.isEmpty()) {
                    G7.c.b(P7.a.f2961a.a().getContentResolver(), "call_log", arrayList2);
                    H7.b.e("CallLogDataCacheManager", "updateLocation operationsList size = " + arrayList2.size());
                }
            }
        }
    }

    public static final C0786a j() {
        return f21521c.a();
    }

    public final void b() {
        Handler i10 = i();
        i10.removeMessages(1);
        i10.removeMessages(2);
        CancellationSignal cancellationSignal = this.f21524b;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        k(i10, 1, 500L);
        H7.b.e("CallLogDataCacheManager", "callLogRestoreCompleted");
    }

    public final void c() {
        SharedPreferences sharedPreferences = P7.a.f2961a.a().getSharedPreferences("callLog_update", 0);
        R7.d.j(sharedPreferences, "update_contacts", 0);
        R7.d.j(sharedPreferences, "update_call_log", 1);
        H7.b.e("CallLogDataCacheManager", "callLogRestoreStarted");
    }

    public final void d() {
        SharedPreferences sharedPreferences = P7.a.f2961a.a().getSharedPreferences("callLog_update", 0);
        int e10 = R7.d.e(sharedPreferences, "update_call_log", 0);
        int e11 = R7.d.e(sharedPreferences, "update_contacts", 0);
        H7.b.e("CallLogDataCacheManager", "checkCacheData updateCallLog = " + e10 + ";updateContacts = " + e11);
        if (e10 == 1) {
            if (e11 == 1) {
                R7.d.j(sharedPreferences, "update_contacts", 0);
            }
            Handler i10 = i();
            i10.removeMessages(1);
            i10.removeMessages(2);
            k(i10, 1, 0L);
            return;
        }
        if (e11 == 1) {
            Handler i11 = i();
            i11.removeMessages(2);
            k(i11, 2, 0L);
        }
    }

    public final void e() {
        Handler i10 = i();
        i10.removeMessages(2);
        if (!i10.hasMessages(1)) {
            k(i10, 2, 500L);
        }
        H7.b.e("CallLogDataCacheManager", "contactsImportCompleted");
    }

    public final void f() {
        R7.d.j(P7.a.f2961a.a().getSharedPreferences("callLog_update", 0), "update_contacts", 1);
        H7.b.e("CallLogDataCacheManager", "contactsImportStarted");
    }

    public final void g() {
        Handler i10 = i();
        i10.removeMessages(2);
        if (!i10.hasMessages(1)) {
            k(i10, 2, 500L);
        }
        H7.b.e("CallLogDataCacheManager", "contactsRestoreCompleted");
    }

    public final void h() {
        R7.d.j(P7.a.f2961a.a().getSharedPreferences("callLog_update", 0), "update_contacts", 1);
        H7.b.e("CallLogDataCacheManager", "contactsRestoreStarted");
    }

    public final synchronized Handler i() {
        Handler handler;
        handler = this.f21523a;
        if (handler == null) {
            HandlerThread handlerThread = new HandlerThread("update_call_log");
            handlerThread.start();
            Looper looper = handlerThread.getLooper();
            kotlin.jvm.internal.i.e(looper, "thread.looper");
            c cVar = new c(looper);
            this.f21523a = cVar;
            handler = cVar;
        }
        return handler;
    }

    public final synchronized void k(Handler handler, int i10, long j10) {
        Message obtainMessage = handler.obtainMessage(i10);
        kotlin.jvm.internal.i.e(obtainMessage, "handler.obtainMessage(what)");
        CancellationSignal cancellationSignal = new CancellationSignal();
        this.f21524b = cancellationSignal;
        obtainMessage.obj = cancellationSignal;
        handler.sendMessageDelayed(obtainMessage, j10);
    }
}
