package com.customize.contacts.simcontacts;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import com.customize.contacts.QuerySimContactsService;
import java.util.Arrays;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.F;
import kotlinx.coroutines.J0;

/* compiled from: SimStateReceiver.kt */
/* loaded from: classes3.dex */
public final class SimStateReceiver extends BroadcastReceiver {

    /* renamed from: c, reason: collision with root package name */
    public static final a f21798c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static boolean f21799d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f21800e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f21801f;

    /* renamed from: a, reason: collision with root package name */
    public final E f21802a = F.b();

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorCoroutineDispatcher f21803b = J0.b("SimStateReceiverSingleDispatcher");

    /* compiled from: SimStateReceiver.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final String a(Bundle bundle) {
            StringBuilder sb = new StringBuilder("Bundle[");
            if (bundle == null) {
                sb.append("null");
            } else {
                boolean z10 = true;
                for (String str : bundle.keySet()) {
                    if (!z10) {
                        sb.append(", ");
                    }
                    sb.append(str);
                    sb.append('=');
                    Object obj = bundle.get(str);
                    if (obj instanceof int[]) {
                        sb.append(Arrays.toString((int[]) obj));
                    } else if (obj instanceof byte[]) {
                        sb.append(Arrays.toString((byte[]) obj));
                    } else if (obj instanceof boolean[]) {
                        sb.append(Arrays.toString((boolean[]) obj));
                    } else if (obj instanceof short[]) {
                        sb.append(Arrays.toString((short[]) obj));
                    } else if (obj instanceof long[]) {
                        sb.append(Arrays.toString((long[]) obj));
                    } else if (obj instanceof float[]) {
                        sb.append(Arrays.toString((float[]) obj));
                    } else if (obj instanceof double[]) {
                        sb.append(Arrays.toString((double[]) obj));
                    } else {
                        boolean z11 = obj instanceof Object[];
                        if (z11) {
                            sb.append(Arrays.toString((String[]) obj));
                        } else if (z11) {
                            sb.append(Arrays.toString((CharSequence[]) obj));
                        } else if (z11) {
                            sb.append(Arrays.toString((Parcelable[]) obj));
                        } else if (obj instanceof Bundle) {
                            sb.append(a((Bundle) obj));
                        } else {
                            sb.append(obj);
                        }
                    }
                    z10 = false;
                }
            }
            sb.append("]");
            String sb2 = sb.toString();
            i.e(sb2, "out.toString()");
            return sb2;
        }

        public final String b(Intent intent) {
            if (intent == null) {
                return null;
            }
            return intent.toString() + " " + a(intent.getExtras());
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(android.content.Context r8, android.content.Intent r9, kotlin.coroutines.c<? super m9.q> r10) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.simcontacts.SimStateReceiver.c(android.content.Context, android.content.Intent, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:42|43)|(8:45|46|47|48|49|50|(3:52|(1:54)|55)|66)|72|49|50|(0)|66) */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0190, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0191, code lost:
    
        H7.b.c("SimStateReceiver", "Throw an exception while getSimStateGemini" + r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0185 A[Catch: all -> 0x0160, TRY_ENTER, TryCatch #1 {all -> 0x0160, blocks: (B:48:0x015c, B:50:0x017b, B:52:0x0185, B:54:0x018b, B:55:0x018c, B:69:0x0191), top: B:47:0x015c, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(android.content.Context r14, android.content.Intent r15) {
        /*
            Method dump skipped, instructions count: 619
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.simcontacts.SimStateReceiver.d(android.content.Context, android.content.Intent):void");
    }

    public final void e(Context context) {
        c cVar = new c(context);
        cVar.i(0);
        cVar.i(1);
    }

    public final void f(Context context, int i10, int i11) {
        c cVar = new c(context);
        if (i11 == 1) {
            cVar.n(i10);
        } else {
            cVar.i(i10);
        }
    }

    public final void g(Context context) {
        H7.b.b("SimStateReceiver", "setLoadAlarm");
        PendingIntent service = PendingIntent.getService(context, 0, new Intent(context, (Class<?>) QuerySimContactsService.class), 67108864);
        Object systemService = context.getSystemService("alarm");
        i.d(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        try {
            alarmManager.cancel(service);
            alarmManager.set(2, SystemClock.elapsedRealtime() + 120000, service);
        } catch (Exception e10) {
            H7.b.b("SimStateReceiver", "AlarmManager set failed: " + e10.getMessage());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        i.f(context, "context");
        if (intent != null && intent.getAction() != null) {
            C1248i.d(this.f21802a, this.f21803b, null, new SimStateReceiver$onReceive$1(context, this, intent, null), 2, null);
        }
    }
}
