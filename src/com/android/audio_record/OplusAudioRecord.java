package com.android.audio_record;

import A2.j;
import A2.k;
import A2.z;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.BaseColumns;
import android.provider.ContactsContract;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TypefaceSpan;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.android.audio_record.OplusAudioRecord;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.CallTimer;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.InCallActivity;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusCallButtonFragment;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusInCallActivity;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUserActionStatistics;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.oplus.forceenable.OplusForceEnableDialogActivity;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.internal_dependency.AddOnSdkDepends;
import com.internal_dependency.InternalSdkDepends;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.callrecorder.aidl.CallRecordParam;
import com.oplus.callrecorder.aidl.ICallRecord;
import com.oplus.callrecorder.aidl.ICallRecordCallback;
import com.oplus.media.OplusRecorder;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.i;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.n;
import m9.q;
import n0.C1361m;
import v9.InterfaceC1637a;

/* compiled from: OplusAudioRecord.kt */
/* loaded from: classes.dex */
public final class OplusAudioRecord implements Q5.b, InCallPresenter.InCallStateListener, InCallPresenter.IncomingCallListener, k.a {

    /* renamed from: H, reason: collision with root package name */
    public static final c f12953H = new c(null);

    /* renamed from: I, reason: collision with root package name */
    public static final Pattern f12954I = Pattern.compile("[\\\\/:*?\"<>|]");

    /* renamed from: J, reason: collision with root package name */
    public static final m9.d<OplusAudioRecord> f12955J;

    /* renamed from: A, reason: collision with root package name */
    public boolean f12956A;

    /* renamed from: B, reason: collision with root package name */
    public Boolean f12957B;

    /* renamed from: C, reason: collision with root package name */
    public ICallRecord f12958C;

    /* renamed from: D, reason: collision with root package name */
    public androidx.appcompat.app.b f12959D;

    /* renamed from: E, reason: collision with root package name */
    public final ServiceConnection f12960E = new f();

    /* renamed from: F, reason: collision with root package name */
    public final ICallRecordCallback f12961F = new ICallRecordCallback.Stub() { // from class: com.android.audio_record.OplusAudioRecord$mICallRecordCallback$1
        @Override // com.oplus.callrecorder.aidl.ICallRecordCallback
        public void I1(int i10, int i11, String arg2, String arg3) {
            i.f(arg2, "arg2");
            i.f(arg3, "arg3");
            OplusAudioRecord.this.i0("notify");
        }

        @Override // com.oplus.callrecorder.aidl.ICallRecordCallback
        public void O6(String recordPath) {
            i.f(recordPath, "recordPath");
            OplusAudioRecord.this.i0("stopRecordCompleted" + recordPath);
            OplusAudioRecord.d dVar = new OplusAudioRecord.d();
            dVar.c(recordPath);
            OplusAudioRecord.this.l0(105, true, dVar);
        }

        @Override // com.oplus.callrecorder.aidl.ICallRecordCallback
        public void i4(int i10) {
            OplusAudioRecord.this.i0("callRecordError type:" + i10);
            OplusAudioRecord.this.y0(i10);
            OplusAudioRecord.this.l0(106, true, null);
        }

        @Override // com.oplus.callrecorder.aidl.ICallRecordCallback
        public void u4(String recordPath) {
            i.f(recordPath, "recordPath");
            OplusAudioRecord.this.i0("startRecordCompleted");
            OplusAudioRecord.this.L0();
            OplusAudioRecord.this.Q0();
        }
    };

    /* renamed from: G, reason: collision with root package name */
    public final Handler f12962G = new e(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    public Context f12963a;

    /* renamed from: b, reason: collision with root package name */
    public float f12964b;

    /* renamed from: c, reason: collision with root package name */
    public Call f12965c;

    /* renamed from: d, reason: collision with root package name */
    public CallTimer f12966d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f12967e;

    /* renamed from: f, reason: collision with root package name */
    public long f12968f;

    /* renamed from: g, reason: collision with root package name */
    public String f12969g;

    /* renamed from: h, reason: collision with root package name */
    public String f12970h;

    /* renamed from: i, reason: collision with root package name */
    public int f12971i;

    /* renamed from: j, reason: collision with root package name */
    public Q5.c f12972j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12973k;

    /* renamed from: l, reason: collision with root package name */
    public Handler f12974l;

    /* renamed from: m, reason: collision with root package name */
    public String f12975m;

    /* renamed from: n, reason: collision with root package name */
    public String f12976n;

    /* renamed from: o, reason: collision with root package name */
    public String f12977o;

    /* renamed from: p, reason: collision with root package name */
    public long f12978p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12979q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12980r;

    /* renamed from: x, reason: collision with root package name */
    public String f12981x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f12982y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f12983z;

    /* compiled from: OplusAudioRecord.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f12985a;

        /* renamed from: b, reason: collision with root package name */
        public String f12986b;

        /* renamed from: c, reason: collision with root package name */
        public String f12987c;

        /* renamed from: d, reason: collision with root package name */
        public String f12988d;

        public final String a() {
            return this.f12986b;
        }

        public final String b() {
            return this.f12985a;
        }

        public final String c() {
            return this.f12987c;
        }

        public final String d() {
            return this.f12988d;
        }

        public final void e(String str) {
            this.f12986b = str;
        }

        public final void f(String str) {
            this.f12985a = str;
        }

        public final void g(String str) {
            this.f12987c = str;
        }

        public final void h(String str) {
            this.f12988d = str;
        }

        public String toString() {
            return "CallLogRecord{mNumber='" + D2.g.l(this.f12985a) + "', mCallLogMapping='" + this.f12986b + "', mPath='" + D2.g.o(this.f12987c) + "', secRecord='" + this.f12988d + "'}";
        }
    }

    /* compiled from: OplusAudioRecord.kt */
    /* loaded from: classes.dex */
    public static final class b implements BaseColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final b f12989a = new b();

        /* renamed from: b, reason: collision with root package name */
        public static final Uri f12990b;

        /* renamed from: c, reason: collision with root package name */
        public static final Uri f12991c;

        static {
            Uri parse = Uri.parse("content://com.oplus.contacts.CallRecordingProvider");
            i.e(parse, "parse(\"content://$AUTHORITY\")");
            f12990b = parse;
            Uri withAppendedPath = Uri.withAppendedPath(parse, "call_recording");
            i.e(withAppendedPath, "withAppendedPath(AUTHORITY_URI, CALL_RECORD_TABLE)");
            f12991c = withAppendedPath;
        }

        public final Uri a() {
            return f12991c;
        }
    }

    /* compiled from: OplusAudioRecord.kt */
    /* loaded from: classes.dex */
    public static final class c {
        public c() {
        }

        public final OplusAudioRecord a() {
            return (OplusAudioRecord) OplusAudioRecord.f12955J.getValue();
        }

        public final String b(String str) {
            boolean v10;
            int i10;
            boolean z10;
            String replaceAll = OplusAudioRecord.f12954I.matcher(str).replaceAll("");
            i.e(replaceAll, "m.replaceAll(\"\")");
            int length = replaceAll.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                if (!z11) {
                    i10 = i11;
                } else {
                    i10 = length;
                }
                if (i.g(replaceAll.charAt(i10), 32) <= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z11) {
                    if (!z10) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else {
                    if (!z10) {
                        break;
                    }
                    length--;
                }
            }
            String b10 = new Regex("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]|[\t]").b(replaceAll.subSequence(i11, length + 1).toString(), "");
            v10 = n.v(b10, ".", false, 2, null);
            if (v10) {
                Log.i("OplusAudioRecord", "specialCharactersFilter target start with .");
                return new Regex("\\.").c(b10, "-");
            }
            return b10;
        }

        public /* synthetic */ c(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: OplusAudioRecord.kt */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public Object f12992a;

        /* renamed from: b, reason: collision with root package name */
        public int f12993b;

        public final Object a() {
            return this.f12992a;
        }

        public final int b() {
            return this.f12993b;
        }

        public final void c(Object obj) {
            this.f12992a = obj;
        }

        public final void d(int i10) {
            this.f12993b = i10;
        }
    }

    /* compiled from: OplusAudioRecord.kt */
    /* loaded from: classes.dex */
    public static final class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            i.f(msg, "msg");
            if (msg.what == 102) {
                OplusAudioRecord.this.i0("receive EVENT_QUIT_WORK_THREAD");
                OplusAudioRecord.this.m0();
            }
        }
    }

    /* compiled from: OplusAudioRecord.kt */
    /* loaded from: classes.dex */
    public static final class f implements ServiceConnection {
        public f() {
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            i.f(componentName, "componentName");
            OplusAudioRecord.this.i0("onBindingDied");
            OplusAudioRecord.this.l0(104, true, null);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            i.f(componentName, "componentName");
            i.f(iBinder, "iBinder");
            OplusAudioRecord.this.i0("onServiceConnected");
            OplusAudioRecord.this.f12958C = ICallRecord.Stub.N7(iBinder);
            try {
                ICallRecord iCallRecord = OplusAudioRecord.this.f12958C;
                if (iCallRecord != null) {
                    iCallRecord.T0(OplusAudioRecord.this.f12961F);
                }
                CallRecordParam W10 = OplusAudioRecord.this.W();
                ICallRecord iCallRecord2 = OplusAudioRecord.this.f12958C;
                if (iCallRecord2 != null) {
                    iCallRecord2.G7(W10);
                }
            } catch (RemoteException e10) {
                OplusAudioRecord.this.i0(e10.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            i.f(componentName, "componentName");
            OplusAudioRecord.this.i0("onServiceDisconnected");
            OplusAudioRecord.this.l0(104, true, null);
        }
    }

    /* compiled from: OplusAudioRecord.kt */
    /* loaded from: classes.dex */
    public static final class g extends Handler {
        public g(Looper looper) {
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            i.f(msg, "msg");
            String str = null;
            switch (msg.what) {
                case 100:
                    OplusAudioRecord oplusAudioRecord = OplusAudioRecord.this;
                    Object obj = msg.obj;
                    i.d(obj, "null cannot be cast to non-null type com.android.audio_record.OplusAudioRecord.WorkerArgs");
                    oplusAudioRecord.H0((d) obj);
                    OplusAudioRecord.this.Q0();
                    return;
                case 101:
                    if (hasMessages(100)) {
                        removeMessages(100);
                    }
                    OplusAudioRecord.this.O0();
                    OplusAudioRecord.this.u0(3);
                    OplusAudioRecord.this.Q0();
                    return;
                case 102:
                default:
                    return;
                case 103:
                    OplusAudioRecord.this.G0();
                    return;
                case 104:
                    OplusAudioRecord.this.o0();
                    OplusAudioRecord.this.f12958C = null;
                    return;
                case 105:
                    Object obj2 = msg.obj;
                    i.d(obj2, "null cannot be cast to non-null type com.android.audio_record.OplusAudioRecord.WorkerArgs");
                    Object a10 = ((d) obj2).a();
                    if (a10 instanceof String) {
                        str = (String) a10;
                    }
                    if (OplusAudioRecord.this.f12963a != null) {
                        OplusAudioRecord oplusAudioRecord2 = OplusAudioRecord.this;
                        Boolean hasReadStoragePermission = OplusPhoneUtils.hasReadStoragePermission(oplusAudioRecord2.f12963a);
                        oplusAudioRecord2.i0("record path" + str + ", checkSelfPermission" + hasReadStoragePermission);
                        if (!TextUtils.isEmpty(str)) {
                            i.e(hasReadStoragePermission, "hasReadStoragePermission");
                            if (hasReadStoragePermission.booleanValue()) {
                                oplusAudioRecord2.g0(oplusAudioRecord2.f12963a, oplusAudioRecord2.V(str));
                            }
                        }
                        oplusAudioRecord2.P0();
                        return;
                    }
                    return;
                case 106:
                    OplusAudioRecord.this.o0();
                    OplusAudioRecord.this.P0();
                    return;
                case 107:
                    if (!OplusFeatureOption.FEATURE_RECORD_FOR_THIRD_PARTY) {
                        OplusAudioRecord.this.t0();
                    }
                    OplusAudioRecord.this.s0();
                    return;
            }
        }
    }

    static {
        m9.d<OplusAudioRecord> a10;
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<OplusAudioRecord>() { // from class: com.android.audio_record.OplusAudioRecord$Companion$sInstance$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final OplusAudioRecord invoke() {
                return new OplusAudioRecord();
            }
        });
        f12955J = a10;
    }

    public static final void B0(OplusAudioRecord this$0, Context context, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        this$0.F0(context);
    }

    public static final void D0(DialogInterface dialogInterface) {
        Log.d("OplusAudioRecord", "permissionSettingsDialog onDismiss");
    }

    public static final void I0(OplusAudioRecord this$0, Intent intent) {
        Boolean bool;
        i.f(this$0, "this$0");
        i.f(intent, "$intent");
        Context context = this$0.f12963a;
        if (context != null) {
            bool = Boolean.valueOf(context.bindService(intent, this$0.f12960E, 1));
        } else {
            bool = null;
        }
        this$0.f12957B = bool;
        if (i.b(bool, Boolean.FALSE)) {
            this$0.o0();
        }
    }

    public static final void J0(OplusAudioRecord this$0) {
        i.f(this$0, "this$0");
        this$0.K0();
    }

    public static final void M0(final OplusAudioRecord this$0) {
        i.f(this$0, "this$0");
        this$0.f12968f = SystemClock.elapsedRealtime() - 20;
        if (this$0.f12966d == null) {
            if (this$0.f12967e == null) {
                this$0.f12967e = new Runnable() { // from class: n0.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        OplusAudioRecord.N0(OplusAudioRecord.this);
                    }
                };
            }
            this$0.f12966d = new CallTimer(this$0.f12967e);
        }
        Log.d("OplusAudioRecord", "startRecordTimer: ");
        CallTimer callTimer = this$0.f12966d;
        if (callTimer != null) {
            callTimer.start(1000L);
        }
    }

    public static final void N0(OplusAudioRecord this$0) {
        i.f(this$0, "this$0");
        this$0.T0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0() {
        Context context;
        this.f12958C = null;
        try {
            try {
                try {
                    if (i.b(this.f12957B, Boolean.TRUE) && (context = this.f12963a) != null) {
                        context.unbindService(this.f12960E);
                    }
                } catch (RemoteException e10) {
                    i0(e10.getMessage());
                }
            } catch (IllegalArgumentException e11) {
                i0(e11.getMessage());
            }
        } finally {
            this.f12957B = Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0() {
        if (z.b()) {
            S0();
        } else {
            this.f12962G.post(new Runnable() { // from class: n0.k
                @Override // java.lang.Runnable
                public final void run() {
                    OplusAudioRecord.R0(OplusAudioRecord.this);
                }
            });
        }
    }

    public static final void R0(OplusAudioRecord this$0) {
        i.f(this$0, "this$0");
        this$0.S0();
    }

    public static final void h0(Context context, a aVar, OplusAudioRecord this$0) {
        i.f(this$0, "this$0");
        if (context != null && aVar != null && Integer.parseInt(String.valueOf(aVar.d())) >= 1) {
            try {
                this$0.f12980r = true;
                ContentValues contentValues = new ContentValues();
                contentValues.put("number", aVar.b());
                contentValues.put("call_log_mapping", aVar.a());
                contentValues.put(Constants.MessagerConstants.PATH_KEY, aVar.c());
                contentValues.put("sec_record", aVar.d());
                this$0.i0("insertCallLogRecord insertUri: " + D2.g.o(context.getContentResolver().insert(b.f12989a.a(), contentValues)));
                return;
            } catch (RuntimeException e10) {
                Log.e("OplusAudioRecord", "insert error " + e10.getMessage());
                return;
            }
        }
        this$0.i0("insertCallLogRecord context is null  return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(String str) {
        if (Log.sDebug) {
            Log.d("OplusAudioRecord", str);
        }
    }

    public static final void x0(OplusAudioRecord this$0, int i10) {
        i.f(this$0, "this$0");
        this$0.i0("showAudioRecordDialog main post = " + i10);
        OplusPhoneUtils.showRecordDialog(this$0.f12963a, i10);
    }

    public static final void z0(Ref$IntRef msg) {
        i.f(msg, "$msg");
        Toast c10 = A2.b.b().c(msg.element, 1);
        if (c10 != null) {
            c10.show();
        }
    }

    public final void A0(final Context context) {
        int J10;
        int J11;
        int J12;
        int J13;
        if (context == null) {
            return;
        }
        Log.d("OplusAudioRecord", "permissionSettingsDialog show");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder append = spannableStringBuilder.append((CharSequence) context.getString(n0.n.f35559n)).append((CharSequence) "\n").append((CharSequence) "\n");
        int i10 = n0.n.f35561p;
        SpannableStringBuilder append2 = append.append((CharSequence) context.getString(i10)).append((CharSequence) "\n").append((CharSequence) context.getString(n0.n.f35556k)).append((CharSequence) "\n").append((CharSequence) "\n");
        int i11 = n0.n.f35549d;
        append2.append((CharSequence) context.getString(i11)).append((CharSequence) "\n").append((CharSequence) context.getString(n0.n.f35560o));
        TypefaceSpan typefaceSpan = new TypefaceSpan(Typeface.create(COUIChangeTextUtil.MEDIUM_FONT, 0));
        String spannableStringBuilder2 = spannableStringBuilder.toString();
        i.e(spannableStringBuilder2, "spannableString.toString()");
        String string = context.getString(i10);
        i.e(string, "context.getString(R.string.storage_space)");
        J10 = StringsKt__StringsKt.J(spannableStringBuilder2, string, 0, false, 6, null);
        String spannableStringBuilder3 = spannableStringBuilder.toString();
        i.e(spannableStringBuilder3, "spannableString.toString()");
        String string2 = context.getString(i10);
        i.e(string2, "context.getString(R.string.storage_space)");
        J11 = StringsKt__StringsKt.J(spannableStringBuilder3, string2, 0, false, 6, null);
        spannableStringBuilder.setSpan(typefaceSpan, J10, J11 + context.getString(i10).length(), 17);
        TypefaceSpan typefaceSpan2 = new TypefaceSpan(Typeface.create(COUIChangeTextUtil.MEDIUM_FONT, 0));
        String spannableStringBuilder4 = spannableStringBuilder.toString();
        i.e(spannableStringBuilder4, "spannableString.toString()");
        String string3 = context.getString(i11);
        i.e(string3, "context.getString(R.string.microphone)");
        J12 = StringsKt__StringsKt.J(spannableStringBuilder4, string3, 0, false, 6, null);
        String spannableStringBuilder5 = spannableStringBuilder.toString();
        i.e(spannableStringBuilder5, "spannableString.toString()");
        String string4 = context.getString(i11);
        i.e(string4, "context.getString(R.string.microphone)");
        J13 = StringsKt__StringsKt.J(spannableStringBuilder5, string4, 0, false, 6, null);
        spannableStringBuilder.setSpan(typefaceSpan2, J12, J13 + context.getString(i11).length(), 17);
        String string5 = context.getString(n0.n.f35555j);
        i.e(string5, "context.getString(R.string.permission_open)");
        androidx.appcompat.app.b create = new COUIAlertDialogBuilder(context).setTitle((CharSequence) string5).setMessage((CharSequence) spannableStringBuilder).setPositiveButton((CharSequence) context.getString(n0.n.f35547b), new DialogInterface.OnClickListener() { // from class: n0.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                OplusAudioRecord.B0(OplusAudioRecord.this, context, dialogInterface, i12);
            }
        }).setNegativeButton((CharSequence) context.getString(n0.n.f35548c), new DialogInterface.OnClickListener() { // from class: n0.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                OplusAudioRecord.C0(dialogInterface, i12);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: n0.d
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                OplusAudioRecord.D0(dialogInterface);
            }
        }).create();
        this.f12959D = create;
        if (create != null) {
            create.show();
        }
        InCallPresenter inCallPresenter = InCallPresenter.getInstance();
        i.d(inCallPresenter, "null cannot be cast to non-null type com.android.incallui.OplusInCallPresenter");
        ((OplusInCallPresenter) inCallPresenter).OplusMonitorActivityStatusClean();
    }

    public final void E0(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) RecordPermissionActivity.class);
            intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            OplusPhoneUtils.startSafeActivity(context, intent);
        }
    }

    public final void F0(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:com.oplus.callrecorder"));
        r0(context);
        OplusPhoneUtils.startSafeActivity(context, intent);
    }

    public final void G0() {
        Boolean bool;
        if (!OplusPhoneUtils.hasReadStoragePermission(this.f12963a).booleanValue()) {
            E0(this.f12963a);
            o0();
            return;
        }
        if (this.f12958C == null) {
            i0("bindService");
            final Intent intent = new Intent("oplus.intent.action.CallRecord");
            intent.setPackage("com.oplus.callrecorder");
            if (!z.b()) {
                Context context = this.f12963a;
                if (context != null) {
                    bool = Boolean.valueOf(context.bindService(intent, this.f12960E, 1));
                } else {
                    bool = null;
                }
                this.f12957B = bool;
                if (i.b(bool, Boolean.FALSE)) {
                    o0();
                    return;
                }
                return;
            }
            Handler handler = this.f12974l;
            if (handler != null) {
                handler.post(new Runnable() { // from class: n0.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        OplusAudioRecord.I0(OplusAudioRecord.this, intent);
                    }
                });
                return;
            }
            return;
        }
        if (!z.b()) {
            K0();
            return;
        }
        Handler handler2 = this.f12974l;
        if (handler2 != null) {
            handler2.post(new Runnable() { // from class: n0.j
                @Override // java.lang.Runnable
                public final void run() {
                    OplusAudioRecord.J0(OplusAudioRecord.this);
                }
            });
        }
    }

    public final void H0(d dVar) {
        String str;
        if (dVar == null) {
            return;
        }
        Object a10 = dVar.a();
        if (a10 instanceof String) {
            str = (String) a10;
        } else {
            str = null;
        }
        int b10 = dVar.b();
        i0("startRecord callName = " + D2.g.o(str) + " state = " + this.f12971i + ">>" + b10);
        if (this.f12971i == 2) {
            i0("startRecord already recording now return");
            return;
        }
        u0(b10);
        if (this.f12971i != 2) {
            i0("startRecord current is not  active state return");
            return;
        }
        if (!TextUtils.isEmpty(b0(this.f12963a)) && !TextUtils.isEmpty(d0(str))) {
            this.f12977o = this.f12975m;
            l0(103, true, dVar);
        } else {
            i0("storage is full!");
            u0(0);
        }
    }

    public final void K0() {
        CallRecordParam W10 = W();
        try {
            ICallRecord iCallRecord = this.f12958C;
            if (iCallRecord != null) {
                iCallRecord.G7(W10);
            }
            i0("mICallRecord");
            L0();
            Q0();
        } catch (RemoteException e10) {
            i0(e10.getMessage());
        }
    }

    public final void L0() {
        this.f12962G.post(new Runnable() { // from class: n0.f
            @Override // java.lang.Runnable
            public final void run() {
                OplusAudioRecord.M0(OplusAudioRecord.this);
            }
        });
    }

    public final void O0() {
        if (this.f12971i != 2) {
            u0(0);
            return;
        }
        u0(0);
        ICallRecord iCallRecord = this.f12958C;
        if (iCallRecord != null && iCallRecord != null) {
            try {
                iCallRecord.q3();
            } catch (RemoteException e10) {
                i0(e10.getMessage());
            }
        }
        R();
        Q0();
        i2.b.a(this.f12963a);
    }

    public final void R() {
        CallTimer callTimer = this.f12966d;
        if (callTimer != null) {
            if (callTimer != null) {
                callTimer.cancel();
            }
            this.f12966d = null;
        }
        this.f12969g = null;
        this.f12970h = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean S(android.content.Context r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            com.internal_dependency.AddOnSdkDepends$Companion r1 = com.internal_dependency.AddOnSdkDepends.Companion     // Catch: java.lang.RuntimeException -> L42
            com.internal_dependency.AddOnSdkDepends r2 = r1.getSInstance()     // Catch: java.lang.RuntimeException -> L42
            java.lang.String r2 = r2.getInternalSdState(r6)     // Catch: java.lang.RuntimeException -> L42
            java.lang.String r3 = "mounted"
            boolean r2 = kotlin.jvm.internal.i.b(r2, r3)     // Catch: java.lang.RuntimeException -> L42
            if (r2 == 0) goto L5e
            com.internal_dependency.AddOnSdkDepends r1 = r1.getSInstance()     // Catch: java.lang.RuntimeException -> L42
            java.io.File r1 = r1.getInternalSdDirectory(r6)     // Catch: java.lang.RuntimeException -> L42
            if (r1 == 0) goto L5e
            android.os.StatFs r2 = new android.os.StatFs     // Catch: java.lang.RuntimeException -> L42
            java.lang.String r1 = r1.getAbsolutePath()     // Catch: java.lang.RuntimeException -> L42
            r2.<init>(r1)     // Catch: java.lang.RuntimeException -> L42
            long r1 = r2.getAvailableBytes()     // Catch: java.lang.RuntimeException -> L42
            r3 = 52428800(0x3200000, double:2.5903269E-316)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L5e
            r1 = 1
            boolean r2 = r5.f12982y     // Catch: java.lang.RuntimeException -> L3d
            if (r2 == 0) goto L40
            com.android.incallui.OplusPhoneUtils.setRecordSdcardSwitch(r6, r0)     // Catch: java.lang.RuntimeException -> L3d
            goto L40
        L3d:
            r6 = move-exception
            r0 = r1
            goto L43
        L40:
            r0 = r1
            goto L5e
        L42:
            r6 = move-exception
        L43:
            java.lang.String r1 = "Exception in checkStorageStateValidByType MOBILE_STORAGE_TYPE!"
            r5.i0(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Exception: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            java.lang.String r1 = "OplusAudioRecord"
            com.android.incallui.Log.d(r1, r6)
        L5e:
            if (r0 != 0) goto L80
            boolean r6 = r5.f12982y
            if (r6 == 0) goto L69
            r6 = 4
            r5.w0(r6)
            goto L80
        L69:
            boolean r6 = r5.f12956A
            if (r6 == 0) goto L72
            r6 = 5
            r5.w0(r6)
            goto L80
        L72:
            boolean r6 = r5.f12983z
            if (r6 == 0) goto L7b
            r6 = 7
            r5.w0(r6)
            goto L80
        L7b:
            r6 = 11
            r5.w0(r6)
        L80:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "checkStorageStateValidByType valid is: "
            r6.append(r1)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.i0(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.audio_record.OplusAudioRecord.S(android.content.Context):boolean");
    }

    public final void S0() {
        if (this.f12972j != null) {
            i0("updateRecordButtonReal" + this.f12971i);
            Q5.c cVar = this.f12972j;
            if (cVar != null) {
                cVar.updateAudioRecordButton();
                return;
            }
            return;
        }
        Log.d("OplusAudioRecord", "updateRecordButton.. mAudioRecordUpdateUI is null");
    }

    public void T() {
        this.f12978p = -1L;
        this.f12977o = "";
        this.f12981x = "";
        this.f12979q = false;
        this.f12980r = false;
        c();
    }

    public final void T0() {
        OplusInCallActivity oplusInCallActivity;
        OplusCallButtonFragment callButtonFragment;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f12968f;
        this.f12969g = D2.b.a(this.f12963a, elapsedRealtime / 1000);
        this.f12970h = OplusPhoneUtils.formatDuration(elapsedRealtime);
        InCallActivity activity = InCallPresenter.getInstance().getActivity();
        if (activity instanceof OplusInCallActivity) {
            oplusInCallActivity = (OplusInCallActivity) activity;
        } else {
            oplusInCallActivity = null;
        }
        if (oplusInCallActivity != null && (callButtonFragment = oplusInCallActivity.getCallButtonFragment()) != null) {
            callButtonFragment.updateRecordText();
        }
    }

    public final PendingIntent U(Context context, long j10, String str, String str2) {
        Intent Z9;
        if (context == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (j10 > 0) {
            Z9 = new Intent("com.oppo.contacts.VIEW_CONTACTS", ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, j10));
            Z9.setComponent(new ComponentName("com.oplus.dialer", "com.android.contacts.activities.CallDetailActivity"));
            bundle.putString("contact_number", str);
            bundle.putBoolean("up_down_animation", false);
            bundle.putString("countryiso", str2);
            Z9.putExtras(bundle);
        } else if (!TextUtils.isEmpty(str)) {
            Z9 = new Intent("android.intent.action.VIEW");
            bundle.putString("number", str);
            Z9.setComponent(new ComponentName("com.oplus.dialer", "com.android.contacts.activities.CallDetailActivity"));
            bundle.putString("contact_number", str);
            bundle.putBoolean("up_down_animation", false);
            bundle.putString("countryiso", str2);
            Z9.putExtras(bundle);
        } else {
            Z9 = Z(context);
        }
        if (Z9 == null) {
            return null;
        }
        Z9.setFlags(524288);
        Z9.setFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(context, 0, Z9, 201326592);
        i.e(activity, "getActivity(\n           ….FLAG_IMMUTABLE\n        )");
        return activity;
    }

    public final a V(String str) {
        a aVar = new a();
        aVar.f(this.f12975m);
        aVar.e(this.f12976n);
        aVar.g(str);
        aVar.h(f0(str));
        return aVar;
    }

    public final CallRecordParam W() {
        CallRecordParam callRecordParam = new CallRecordParam();
        callRecordParam.m(d0(D2.b.f(this.f12963a, this.f12965c)));
        callRecordParam.k(String.valueOf(b0(this.f12963a)));
        callRecordParam.h(1);
        callRecordParam.i(64000);
        callRecordParam.j(OplusRecorder.NWAV_BYTES_P_SEC);
        callRecordParam.p(".mp3");
        return callRecordParam;
    }

    public final String X(Context context) {
        File internalSdDirectory;
        if (Log.sDebug) {
            i0("getDirPathByType type");
        }
        if (context == null || !S(context) || (internalSdDirectory = AddOnSdkDepends.Companion.getSInstance().getInternalSdDirectory(context)) == null) {
            return null;
        }
        return internalSdDirectory.getPath();
    }

    public final Handler Y() {
        HandlerThread handlerThread = new HandlerThread("in_call_record");
        handlerThread.setPriority(10);
        handlerThread.start();
        return new g(handlerThread.getLooper());
    }

    public final Intent Z(Context context) {
        String str;
        File file;
        boolean z10;
        String str2;
        if (context == null) {
            return null;
        }
        String str3 = OplusPhoneUtils.AUDIO_RECORD_APK_PACKAGE;
        if (OplusPhoneUtils.isApkInstalled(context, str3)) {
            boolean z11 = OplusFeatureOption.OPLUS_VERSION_EXP;
            if (z11 && (!z11 || n2.n.b(context, str3))) {
                Intent intent = new Intent(context, (Class<?>) OplusForceEnableDialogActivity.class);
                intent.putExtra("dialog_id", 4);
                return intent;
            }
            Intent intent2 = new Intent("oplus.intent.action.BROWSE_FILE");
            intent2.putExtra("package", context.getPackageName());
            intent2.setComponent(new ComponentName(str3, "oppo.multimedia.soundrecorder.filebrowser.BrowseFile"));
            return intent2;
        }
        String str4 = context.getString(n0.n.f35550e) + File.separator;
        AddOnSdkDepends.Companion companion = AddOnSdkDepends.Companion;
        if (companion.getSInstance().getInternalSdDirectory(context) != null) {
            StringBuilder sb = new StringBuilder();
            File internalSdDirectory = companion.getSInstance().getInternalSdDirectory(context);
            if (internalSdDirectory != null) {
                str2 = internalSdDirectory.getPath();
            } else {
                str2 = null;
            }
            sb.append(str2);
            sb.append(str4);
            str = sb.toString();
        } else {
            str = null;
        }
        if (str == null) {
            file = null;
        } else {
            file = new File(str);
        }
        boolean z12 = false;
        if (file != null && file.exists()) {
            z10 = true;
        } else {
            z10 = false;
        }
        Log.d("OplusAudioRecord", "check internal dir: isDirPathExist = " + z10);
        if (!z10 || file == null) {
            return null;
        }
        int i10 = n0.n.f35546a;
        ApplicationInfo a10 = n2.n.a(context, context.getString(i10));
        if (a10 != null && a10.enabled) {
            z12 = true;
        }
        if (OplusPhoneUtils.isApkInstalled(context, context.getString(i10)) && z12) {
            Intent intent3 = new Intent("oplus.intent.action.filemanager.BROWSER_FILE");
            intent3.setPackage(context.getString(i10));
            intent3.putExtra("CurrentDir", file.getAbsolutePath());
            return intent3;
        }
        Uri parse = Uri.parse("content://com.android.externalstorage.documents/document/primary:Music%2fRecordings%2fCall Recordings");
        Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent4.addCategory("android.intent.category.OPENABLE");
        intent4.setType("*/*");
        intent4.putExtra("android.provider.extra.INITIAL_URI", parse);
        return intent4;
    }

    @Override // Q5.b
    public Boolean a() {
        PackageManager packageManager;
        boolean z10;
        boolean z11;
        Context context = this.f12963a;
        boolean z12 = true;
        if (context != null && (packageManager = context.getPackageManager()) != null) {
            if (packageManager.checkPermission("android.permission.RECORD_AUDIO", "com.oplus.callrecorder") == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (packageManager.checkPermission("android.permission.READ_MEDIA_AUDIO", "com.oplus.callrecorder") == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            long longVersionCode = packageManager.getPackageInfo("com.oplus.callrecorder", PackageManager.PackageInfoFlags.of(0L)).getLongVersionCode();
            int i10 = packageManager.getApplicationInfo("com.oplus.callrecorder", PackageManager.ApplicationInfoFlags.of(128L)).targetSdkVersion;
            i0("AuidoPermission longVersionCode=" + longVersionCode + " targetSdkVersion=" + i10 + " recordPermission=" + z10 + " mediaPermission=" + z11);
            if (14000000 <= longVersionCode && longVersionCode < 14001002 && i10 >= 34 && (!z10 || !z11)) {
                z12 = false;
            }
        }
        return Boolean.valueOf(z12);
    }

    public final Call a0(InCallPresenter.InCallState inCallState, CallList callList) {
        if (inCallState == InCallPresenter.InCallState.INCOMING) {
            return callList.getIncomingCall();
        }
        if (inCallState == InCallPresenter.InCallState.OUTGOING) {
            return callList.getOutgoingCall();
        }
        if (inCallState == InCallPresenter.InCallState.PENDING_OUTGOING) {
            return callList.getPendingOutgoingCall();
        }
        if (inCallState == InCallPresenter.InCallState.INCALL) {
            return callList.getActiveOrBackgroundCall();
        }
        return null;
    }

    @Override // Q5.b
    public boolean b() {
        boolean n02;
        if (Log.sDebug) {
            Log.d("OplusAudioRecord", "recordClick");
        }
        Call call = this.f12965c;
        Context context = this.f12963a;
        boolean z10 = false;
        if (call != null && context != null) {
            this.f12982y = false;
            this.f12983z = false;
            this.f12956A = false;
            int state = getState();
            boolean z11 = true;
            if (state != 0) {
                if (state != 1) {
                    if (state == 2) {
                        i(true, false);
                    }
                } else {
                    u0(3);
                    Q0();
                }
                z11 = false;
            } else {
                if (!Call.State.isConnectingOrDialing(call.getState()) && !call.isCdmaDialing() && call.getState() != 8) {
                    n02 = n0(D2.b.f(context, this.f12965c), 2, true);
                } else {
                    n02 = n0(D2.b.f(context, this.f12965c), 1, true);
                }
                z11 = n02;
                z10 = true;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("click_audio_record", String.valueOf(z10));
            OplusPhoneUserActionStatistics.onCommon(context, OplusPhoneUserActionStatistics.TAG_AUTO_RECORD, OplusPhoneUserActionStatistics.CLICK_RECORD_BUTTON, hashMap);
            return z11;
        }
        if (Log.sDebug) {
            Log.d("OplusAudioRecord", "recordClick call or context is null!");
        }
        return false;
    }

    public final String b0(Context context) {
        if (context == null) {
            return null;
        }
        String X10 = X(context);
        i0(D2.g.o(X10));
        if (X10 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(X10);
        sb.append(context.getString(n0.n.f35550e));
        String str = File.separator;
        sb.append(str);
        String sb2 = sb.toString();
        if (OplusFeatureOption.FEATURE_SEND_CALL_RECORD_PATH) {
            sb2 = X(context) + context.getString(n0.n.f35551f) + str;
        }
        File file = new File(sb2);
        if (!file.exists()) {
            try {
                if (!file.mkdirs()) {
                    i0("path is not exist!");
                    return null;
                }
            } catch (RuntimeException e10) {
                Log.w("OplusAudioRecord", "mkdirs catch exception : " + e10.getMessage());
            }
        }
        return sb2;
    }

    @Override // Q5.b
    public void c() {
        i0("dismissPermissionDialog");
        androidx.appcompat.app.b bVar = this.f12959D;
        if (bVar != null) {
            bVar.dismiss();
        }
        this.f12959D = null;
    }

    @Override // Q5.b
    public void d() {
        l0(107, false, null);
    }

    public final String d0(String str) {
        String format = new SimpleDateFormat("yyMMddHHmm").format(new Date());
        if (str != null) {
            try {
                str = f12953H.b(str);
                if (str.length() > 50) {
                    String substring = str.substring(0, 50);
                    i.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    str = substring;
                }
            } catch (PatternSyntaxException unused) {
                Log.w("OplusAudioRecord", "getRecordCallName catch Exception occurs in StringFilter!");
            }
        }
        i0("[factoryName]callName = " + D2.g.o(str));
        i0("[factoryName]mDateTime = " + D2.g.o(format));
        if (str != null && !TextUtils.isEmpty(str)) {
            format = str + '-' + format;
        } else {
            i.e(format, "{\n            dateTime\n        }");
        }
        i0("create name:" + D2.g.o(format));
        return format;
    }

    @Override // Q5.b
    public void e(Q5.c cVar) {
        this.f12972j = cVar;
        if (Log.sDebug) {
            Log.d("OplusAudioRecord", "setAudioRecordUpdateUI " + cVar + "  mAudioRecordUpdateUI = " + this.f12972j);
        }
    }

    @Override // Q5.b
    public String f() {
        String str;
        if (TextUtils.isEmpty(this.f12970h)) {
            return this.f12969g;
        }
        if (this.f12963a != null) {
            StringBuilder sb = new StringBuilder();
            Context context = this.f12963a;
            if (context != null) {
                str = context.getString(n0.n.f35553h);
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(this.f12970h);
            this.f12970h = sb.toString();
        }
        return this.f12970h;
    }

    public final String f0(String str) {
        int i10;
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            try {
                mediaPlayer.setDataSource(str);
                mediaPlayer.prepare();
                i10 = mediaPlayer.getDuration() / 1000;
            } catch (IllegalStateException e10) {
                Log.e("OplusAudioRecord", "getRecordSec: " + e10.getMessage());
                mediaPlayer.release();
                i10 = 0;
                return String.valueOf(i10);
            } catch (Exception e11) {
                Log.e("OplusAudioRecord", "getRecordSec: " + e11.getMessage());
                mediaPlayer.release();
                i10 = 0;
                return String.valueOf(i10);
            }
            return String.valueOf(i10);
        } finally {
            mediaPlayer.release();
        }
    }

    @Override // Q5.b
    public boolean g() {
        return this.f12973k;
    }

    public final void g0(final Context context, final a aVar) {
        C2.b.a().execute(new Runnable() { // from class: n0.e
            @Override // java.lang.Runnable
            public final void run() {
                OplusAudioRecord.h0(context, aVar, this);
            }
        });
    }

    @Override // Q5.b
    public int getState() {
        return this.f12971i;
    }

    @Override // Q5.b
    public String h() {
        return this.f12969g;
    }

    @Override // Q5.b
    public void i(boolean z10, boolean z11) {
        i0("Posting stop record");
        d dVar = new d();
        dVar.d(1);
        this.f12979q = !z11;
        l0(101, false, dVar);
    }

    @Override // Q5.b
    public void init(Context context) {
        DisplayMetrics displayMetrics;
        Resources resources;
        i.f(context, "context");
        this.f12963a = context;
        if (context != null && (resources = context.getResources()) != null) {
            displayMetrics = resources.getDisplayMetrics();
        } else {
            displayMetrics = null;
        }
        i.c(displayMetrics);
        this.f12964b = displayMetrics.density;
        InCallPresenter.getInstance().addListener(this);
        InCallPresenter.getInstance().addIncomingCallListener(this);
        j.J().m(this);
    }

    @Override // Q5.b
    public void j() {
        boolean z10;
        Call call = this.f12965c;
        if (call != null) {
            int state = getState();
            int recordStatus = call.getRecordStatus();
            if (D2.b.f(this.f12963a, call) != null && state == 0 && recordStatus == 0 && call.shouldAutoRecord()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if ((Call.State.isConnectingOrDialing(call.getState()) || Call.State.isRing(call.getState())) && z10) {
                v0(true, false);
            }
        }
    }

    public final void j0(Context context, long j10, String str, String str2) {
        if (context == null) {
            return;
        }
        PendingIntent U10 = U(context, j10, str, str2);
        if (U10 == null) {
            Log.d("OplusAudioRecord", "notificationRecorder pendingIntent = null");
            return;
        }
        D2.c.b(context, "call_record", context.getString(n0.n.f35553h), 4);
        Notification.Builder builder = new Notification.Builder(context, "call_record");
        builder.setOngoing(false);
        builder.setContentTitle(context.getString(n0.n.f35558m));
        builder.setContentText(context.getString(n0.n.f35557l));
        builder.setAutoCancel(true);
        builder.setSmallIcon(C1361m.f35545a);
        builder.setContentIntent(U10);
        try {
            Notification build = builder.build();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            notificationManager.cancel(24);
            notificationManager.notify(24, build);
        } catch (AndroidRuntimeException e10) {
            Log.d("OplusAudioRecord", "notification record: " + e10.getMessage());
        } catch (RuntimeException e11) {
            Log.d("OplusAudioRecord", "notification record: " + e11.getMessage());
        }
    }

    @Override // Q5.b
    public boolean k() {
        boolean z10;
        boolean z11;
        Call incomingCall = CallList.getInstance().getIncomingCall();
        if (CallList.getInstance().getActiveOrBackgroundCall() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (incomingCall != null && incomingCall.shouldAutoRecord() && !incomingCall.isCdmaDialing()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 || z11 || this.f12971i == 0) {
            return false;
        }
        return true;
    }

    public final void l0(int i10, boolean z10, d dVar) {
        Message message;
        synchronized (this) {
            try {
                if (this.f12974l == null && z10) {
                    this.f12974l = Y();
                }
                Handler handler = this.f12974l;
                if (handler == null) {
                    i0("Message skipped because there is no handler  messageCode = " + i10);
                    q qVar = q.f35511a;
                } else {
                    if (handler != null) {
                        message = handler.obtainMessage(i10, dVar);
                    } else {
                        message = null;
                    }
                    Handler handler2 = this.f12974l;
                    if (handler2 != null) {
                        handler2.sendMessageDelayed(message, 0L);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m0() {
        if (this.f12974l == null) {
            return;
        }
        i0("quitWorkThread");
        Handler handler = this.f12974l;
        if (handler != null) {
            handler.getLooper().quitSafely();
        }
        this.f12974l = null;
    }

    public final boolean n0(String str, int i10, boolean z10) {
        String valueOf;
        i0("Posting start record.");
        if (i.b(v0(false, z10), Boolean.TRUE)) {
            return false;
        }
        d dVar = new d();
        dVar.c(str);
        dVar.d(i10);
        q0();
        l0(100, true, dVar);
        Call call = this.f12965c;
        if (call != null) {
            this.f12975m = call.getNumber();
            this.f12978p = call.getContactInfo().person_id;
            this.f12981x = InternalSdkDepends.Companion.getSInstance().getCurrentCountryIso(this.f12963a);
            long connectTimeMillis = call.getConnectTimeMillis();
            long creationTimeMillis = call.getCreationTimeMillis();
            if (connectTimeMillis != 0 && connectTimeMillis < creationTimeMillis) {
                valueOf = String.valueOf(connectTimeMillis);
            } else {
                valueOf = String.valueOf(creationTimeMillis);
            }
            this.f12976n = valueOf;
        }
        return true;
    }

    public final void o0() {
        u0(3);
        Q0();
    }

    @Override // com.android.incallui.InCallPresenter.IncomingCallListener
    public void onIncomingCall(InCallPresenter.InCallState oldState, InCallPresenter.InCallState newState, Call call) {
        i.f(oldState, "oldState");
        i.f(newState, "newState");
        i.f(call, "call");
        CallList callList = CallList.getInstance();
        i.e(callList, "getInstance()");
        onStateChange(oldState, newState, callList);
    }

    @Override // A2.k.a
    public void onQueryCustomRecordComplete(String number, ContactInfoCache.ContactCacheEntry entry) {
        i.f(number, "number");
        i.f(entry, "entry");
        p0(this.f12965c);
    }

    @Override // com.android.incallui.InCallPresenter.InCallStateListener
    public void onStateChange(InCallPresenter.InCallState oldState, InCallPresenter.InCallState newState, CallList callList) {
        i.f(oldState, "oldState");
        i.f(newState, "newState");
        i.f(callList, "callList");
        i0("onStateChange newState = " + newState);
        Call a02 = a0(newState, callList);
        this.f12965c = a02;
        p0(a02);
        if (newState == InCallPresenter.InCallState.NO_CALLS) {
            c();
        }
    }

    public final void p0(Call call) {
        boolean z10;
        boolean z11;
        boolean z12;
        Context context = this.f12963a;
        i0("refreshRecordState primaryCall = " + call + " context = " + context);
        if (call != null && context != null) {
            int state = getState();
            int recordStatus = call.getRecordStatus();
            String f10 = D2.b.f(context, call);
            if (Log.sDebug) {
                Log.d("OplusAudioRecord", "refreshRecordState autoRecordStatus = " + state + " callRecordStatus = " + recordStatus);
            }
            if (state == 1 && recordStatus != 1) {
                Log.d("OplusAudioRecord", "autoRecordStatus is pending, but callRecordStatus is not pending!");
                u0(0);
                state = 0;
            }
            if (!Call.State.isConnectingOrDialing(call.getState()) && !Call.State.isRing(call.getState())) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (f10 != null && state == 0 && recordStatus == 0 && call.shouldAutoRecord()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (f10 != null && state == 1 && call.getRecordStatus() == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z10 && z11) {
                n0(f10, 1, false);
                this.f12982y = false;
                this.f12983z = false;
                this.f12956A = false;
            } else if (z12 && call.getState() == 3 && !call.isCdmaDialing() && call.getFakeState() == 0) {
                if (call.shouldAutoRecord()) {
                    this.f12973k = true;
                }
                A2.c.d().i();
                n0(f10, 2, false);
            }
            Q0();
        }
    }

    public final void q0() {
        i0("removeQuitWorkThreadMsg");
        if (this.f12962G.hasMessages(102)) {
            this.f12962G.removeMessages(102);
        }
    }

    public final void r0(Context context) {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            Object systemService = context.getSystemService("keyguard");
            i.d(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
            KeyguardManager keyguardManager = (KeyguardManager) systemService;
            if (keyguardManager != null && keyguardManager.isKeyguardSecure()) {
                OplusPhoneUtils.dismissKeyguard();
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        if (Result.d(b10) != null) {
            Log.d("OplusAudioRecord", "requestKeyguard fail");
        }
    }

    public final void s0() {
        i0("sendQuitWorkThreadMsg");
        q0();
        this.f12962G.sendEmptyMessageDelayed(102, 10000L);
    }

    public final void t0() {
        Log.d("OplusAudioRecord", "mPersonId:" + this.f12978p + " mRecordNumber:" + D2.g.o(this.f12977o) + " mCountryIso:" + D2.g.o(this.f12981x) + " mIsRecorded:" + this.f12980r + " mNeedShowNotification:" + this.f12979q);
        if (this.f12980r && this.f12979q) {
            j0(this.f12963a, this.f12978p, this.f12977o, this.f12981x);
        }
        T();
    }

    public final void u0(int i10) {
        int i11;
        i0("set audio record state = " + i10);
        synchronized (this) {
            try {
                Call call = this.f12965c;
                if (call != null && call != null) {
                    call.setRecordStatus(i10);
                }
                if (i10 == 3) {
                    i11 = 0;
                } else {
                    i11 = i10;
                }
                this.f12971i = i11;
                if (i10 == 0) {
                    this.f12973k = false;
                }
                q qVar = q.f35511a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Boolean v0(boolean z10, boolean z11) {
        Call call = this.f12965c;
        androidx.appcompat.app.b bVar = this.f12959D;
        if (bVar != null && bVar.isShowing()) {
            return Boolean.TRUE;
        }
        Boolean a10 = a();
        Boolean bool = Boolean.FALSE;
        if (i.b(a10, bool)) {
            if (((call != null && call.getState() == 4) || (call != null && call.getState() == 6)) && !z10 && !z11) {
                return Boolean.TRUE;
            }
            A0(InCallPresenter.getInstance().getActivity());
            return Boolean.TRUE;
        }
        return bool;
    }

    public final void w0(final int i10) {
        if (this.f12963a == null) {
            i0("showAudioRecordDialog mContext is null");
            return;
        }
        if (z.b()) {
            i0("showAudioRecordDialog on the main = " + i10);
            OplusPhoneUtils.showRecordDialog(this.f12963a, i10);
            return;
        }
        this.f12962G.post(new Runnable() { // from class: n0.h
            @Override // java.lang.Runnable
            public final void run() {
                OplusAudioRecord.x0(OplusAudioRecord.this, i10);
            }
        });
    }

    public final void y0(int i10) {
        if (i10 == 4 && i10 == 6 && i10 == 3) {
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            int i11 = n0.n.f35554i;
            ref$IntRef.element = i11;
            if (i10 != 3) {
                if (i10 == 4 || i10 == 6) {
                    ref$IntRef.element = n0.n.f35552g;
                }
            } else {
                ref$IntRef.element = i11;
            }
            if (z.b()) {
                Toast c10 = A2.b.b().c(ref$IntRef.element, 1);
                if (c10 != null) {
                    c10.show();
                    return;
                }
                return;
            }
            this.f12962G.post(new Runnable() { // from class: n0.g
                @Override // java.lang.Runnable
                public final void run() {
                    OplusAudioRecord.z0(Ref$IntRef.this);
                }
            });
        }
    }

    public static final void C0(DialogInterface dialogInterface, int i10) {
    }
}
