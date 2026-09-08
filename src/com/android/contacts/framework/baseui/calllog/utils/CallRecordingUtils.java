package com.android.contacts.framework.baseui.calllog.utils;

import Q0.c;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.util.t;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.n;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: CallRecordingUtils.kt */
/* loaded from: classes.dex */
public final class CallRecordingUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final CallRecordingUtils f15793a = new CallRecordingUtils();

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f15794b = {BreenoCallContract.BaseColumns._ID, "_data"};

    /* compiled from: CallRecordingUtils.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f15795a;

        /* renamed from: b, reason: collision with root package name */
        public InterfaceC1637a<q> f15796b;

        /* renamed from: c, reason: collision with root package name */
        public HandlerThread f15797c;

        /* renamed from: d, reason: collision with root package name */
        public Handler f15798d;

        /* renamed from: e, reason: collision with root package name */
        public final int f15799e;

        /* compiled from: CallRecordingUtils.kt */
        /* renamed from: com.android.contacts.framework.baseui.calllog.utils.CallRecordingUtils$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0165a implements Handler.Callback {
            public C0165a() {
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message msg) {
                InterfaceC1637a<q> c10;
                i.f(msg, "msg");
                if (msg.what == a.this.f15799e && (c10 = a.this.c()) != null) {
                    c10.invoke();
                }
                H7.b.e("CallRecordingUtils", "InternalCountDownTimer: time out, quit.");
                a.this.b();
                return true;
            }
        }

        public a(long j10, InterfaceC1637a<q> completed) {
            i.f(completed, "completed");
            this.f15799e = 1;
            HandlerThread handlerThread = new HandlerThread("InternalCountDownTimer");
            this.f15797c = handlerThread;
            i.c(handlerThread);
            handlerThread.start();
            this.f15795a = j10;
            this.f15796b = completed;
        }

        public final synchronized void b() {
            Object b10;
            try {
                Result.a aVar = Result.f34166a;
                Handler handler = this.f15798d;
                Boolean bool = null;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    HandlerThread handlerThread = this.f15797c;
                    if (handlerThread != null) {
                        bool = Boolean.valueOf(handlerThread.quitSafely());
                    }
                }
                b10 = Result.b(bool);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.i("CallRecordingUtils", "InternalCountDownTimer: cancel: exception: " + d10);
            }
        }

        public final InterfaceC1637a<q> c() {
            return this.f15796b;
        }

        public final synchronized void d() {
            Object b10;
            HandlerThread handlerThread;
            Looper looper;
            Looper looper2;
            try {
                Result.a aVar = Result.f34166a;
                Boolean bool = null;
                if (this.f15798d == null && (handlerThread = this.f15797c) != null) {
                    if (handlerThread != null) {
                        looper = handlerThread.getLooper();
                    } else {
                        looper = null;
                    }
                    if (looper != null) {
                        HandlerThread handlerThread2 = this.f15797c;
                        if (handlerThread2 != null) {
                            looper2 = handlerThread2.getLooper();
                        } else {
                            looper2 = null;
                        }
                        i.c(looper2);
                        this.f15798d = new Handler(looper2, new C0165a());
                    }
                }
                Handler handler = this.f15798d;
                if (handler != null) {
                    H7.b.e("CallRecordingUtils", "InternalCountDownTimer: start: duration: " + this.f15795a);
                    bool = Boolean.valueOf(handler.sendEmptyMessageDelayed(this.f15799e, this.f15795a));
                }
                b10 = Result.b(bool);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.i("CallRecordingUtils", "InternalCountDownTimer: start: exception: " + d10);
            }
        }
    }

    /* compiled from: CallRecordingUtils.kt */
    /* loaded from: classes.dex */
    public static final class b implements androidx.activity.result.a<ActivityResult> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f15801a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f15802b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f15803c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f15804d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<androidx.activity.result.b<IntentSenderRequest>> f15805e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f15806f;

        public b(ComponentActivity componentActivity, t tVar, int i10, int i11, Ref$ObjectRef<androidx.activity.result.b<IntentSenderRequest>> ref$ObjectRef, a aVar) {
            this.f15801a = componentActivity;
            this.f15802b = tVar;
            this.f15803c = i10;
            this.f15804d = i11;
            this.f15805e = ref$ObjectRef;
            this.f15806f = aVar;
        }

        @Override // androidx.activity.result.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult result) {
            i.f(result, "result");
            int d10 = result.d();
            H7.b.e("CallRecordingUtils", "resultCode: " + d10 + ": state: " + this.f15801a.getLifecycle().b() + ", cancel timer.");
            if (d10 == -1) {
                this.f15802b.a(0, Integer.valueOf(this.f15803c), Integer.valueOf(this.f15804d));
            } else {
                this.f15802b.a(-2, Integer.valueOf(this.f15803c), Integer.valueOf(this.f15804d));
            }
            androidx.activity.result.b<IntentSenderRequest> bVar = this.f15805e.element;
            if (bVar != null) {
                bVar.c();
            }
            this.f15806f.b();
        }
    }

    public static final int a(Context context, List<Long> ids) {
        Object b10;
        i.f(context, "context");
        i.f(ids, "ids");
        int i10 = 0;
        try {
            Result.a aVar = Result.f34166a;
            i10 = context.getContentResolver().delete(com.android.contacts.framework.baseui.calllog.a.f15766a, "_id IN " + G7.a.d(ids), null);
            H7.b.e("CallRecordingUtils", "batchDeleteCallRecordingsByIds: size: " + ids.size() + ", count: " + i10);
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("CallRecordingUtils", "batchDeleteCallRecordingsByIds: exception: " + d10);
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int b(androidx.activity.ComponentActivity r12, java.util.ArrayList<java.lang.Long> r13, com.android.contacts.framework.baseui.util.t r14) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.baseui.calllog.utils.CallRecordingUtils.b(androidx.activity.ComponentActivity, java.util.ArrayList, com.android.contacts.framework.baseui.util.t):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01ce  */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.activity.result.b, T, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(androidx.activity.ComponentActivity r16, java.util.HashSet<java.lang.String> r17, final com.android.contacts.framework.baseui.util.t r18, final int r19, final int r20) {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.baseui.calllog.utils.CallRecordingUtils.c(androidx.activity.ComponentActivity, java.util.HashSet, com.android.contacts.framework.baseui.util.t, int, int):void");
    }

    public static final Set<Long> d(Context context) {
        Object b10;
        i.f(context, "context");
        HashSet hashSet = new HashSet();
        try {
            Result.a aVar = Result.f34166a;
            Iterator<T> it = c.f3102l.b(context, false).iterator();
            while (it.hasNext()) {
                hashSet.add(Long.valueOf(((c) it.next()).b()));
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("CallRecordingUtils", "getCallRecordingTimeStamps: exception: " + d10);
        }
        return hashSet;
    }

    public static final void e(Context context, String str) {
        String t10;
        String str2;
        String separator = File.separator;
        i.e(separator, "separator");
        t10 = n.t(str, separator, "%2f", false, 4, null);
        Uri parse = Uri.parse("content://com.android.externalstorage.documents/document/primary:" + t10);
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.provider.extra.INITIAL_URI", parse);
        boolean f10 = R7.b.f(context, intent, 0, null, 6, null);
        if (H7.a.b()) {
            if (parse != null) {
                str2 = parse.toString();
            } else {
                str2 = null;
            }
            H7.b.b("CallRecordingUtils", "tryViewWithDocumentUI: uri: " + str2 + ", " + f10);
        }
    }

    public static final void f(Context context, boolean z10, String filepath) {
        int O10;
        boolean y10;
        String str;
        i.f(context, "context");
        i.f(filepath, "filepath");
        String separator = File.separator;
        i.e(separator, "separator");
        O10 = StringsKt__StringsKt.O(filepath, separator, 0, false, 6, null);
        String substring = filepath.substring(O10 + 1);
        i.e(substring, "substring(...)");
        String substring2 = filepath.substring(0, O10);
        i.e(substring2, "substring(...)");
        String CALL_RECORDINGS_DIR_RELATIVE_PATH = com.android.contacts.framework.baseui.calllog.a.f15767b;
        i.e(CALL_RECORDINGS_DIR_RELATIVE_PATH, "CALL_RECORDINGS_DIR_RELATIVE_PATH");
        y10 = StringsKt__StringsKt.y(substring2, CALL_RECORDINGS_DIR_RELATIVE_PATH, false, 2, null);
        if (y10) {
            substring2 = CALL_RECORDINGS_DIR_RELATIVE_PATH + separator;
        }
        Intent intent = new Intent("oplus.intent.action.BROWSE_FILE");
        if (z10) {
            str = "com.oneplus.soundrecorder";
        } else {
            str = "com.coloros.soundrecorder";
        }
        intent.setPackage(str);
        intent.putExtra("source", "contacts");
        intent.putExtra("should_auto_find_file_name", substring);
        intent.putExtra("should_auto_find_file_path", substring2);
        boolean e10 = R7.b.e(context, intent, 0, null);
        if (H7.a.b()) {
            H7.b.b("CallRecordingUtils", "viewCallRecordingFile: filepath: " + filepath + ", name: " + substring + ", path: " + substring2 + ", " + e10);
        }
        if (!e10) {
            e(context, substring2);
        }
    }
}
