package z2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.AppSettingsUtils;
import com.android.incallui.Log;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.WearInfoQueryUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: OplusInCallPolicyQuery.java */
/* renamed from: z2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1731b {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f38272d = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE};

    /* renamed from: e, reason: collision with root package name */
    public static final C1731b f38273e = new C1731b();

    /* renamed from: a, reason: collision with root package name */
    public final k f38274a = new k();

    /* renamed from: b, reason: collision with root package name */
    public final i f38275b;

    /* renamed from: c, reason: collision with root package name */
    public final d f38276c;

    /* compiled from: OplusInCallPolicyQuery.java */
    /* renamed from: z2.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0384b<T extends c> implements f {

        /* renamed from: b, reason: collision with root package name */
        public final List<g> f38278b = new CopyOnWriteArrayList();

        /* renamed from: c, reason: collision with root package name */
        public int f38279c = 1;

        /* renamed from: a, reason: collision with root package name */
        public T f38277a = f();

        @Override // z2.C1731b.f
        public int a() {
            return this.f38279c;
        }

        @Override // z2.C1731b.f
        public final void b(Context context, g gVar) {
            if (!h.b(a())) {
                m(context);
            }
            c(gVar);
        }

        @Override // z2.C1731b.f
        public void c(g gVar) {
            if (gVar == null) {
                return;
            }
            int a10 = a();
            if (a10 != 1) {
                if (a10 != 2) {
                    if (a10 != 3) {
                        return;
                    }
                    gVar.onQueryPolicyComplete();
                    return;
                } else {
                    Log.d(g(), "setQueryPolicyCallback: Query has started and please wait");
                    e(gVar);
                    return;
                }
            }
            Log.d(g(), "setQueryPolicyCallback: Query not start or occur exception");
        }

        public final void e(g gVar) {
            if (gVar == null) {
                return;
            }
            this.f38278b.add(gVar);
        }

        public abstract T f();

        public abstract String g();

        @Override // z2.C1731b.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public c d() {
            return this.f38277a.clone();
        }

        public void i() {
            Log.d(g(), "onQueryQueryPolicyDataComplete: started");
            try {
                Iterator<g> it = this.f38278b.iterator();
                while (it.hasNext()) {
                    it.next().onQueryPolicyComplete();
                }
            } catch (Exception e10) {
                Log.d(g(), "onQueryQueryPolicyDataComplete: " + e10);
            }
            Log.d(g(), "onQueryQueryPolicyDataComplete: end");
            j();
        }

        public void j() {
            if (!this.f38278b.isEmpty()) {
                this.f38278b.clear();
            }
        }

        public void k() {
            l(1);
            j();
        }

        public void l(int i10) {
            if (Log.sOplusDebug) {
                Log.d(g(), "setQueryState: " + i10);
            }
            this.f38279c = i10;
        }

        public abstract boolean m(Context context);
    }

    /* compiled from: OplusInCallPolicyQuery.java */
    /* renamed from: z2.b$c */
    /* loaded from: classes.dex */
    public static class c implements Cloneable {
        /* renamed from: a */
        public c clone() {
            throw null;
        }
    }

    /* compiled from: OplusInCallPolicyQuery.java */
    /* renamed from: z2.b$d */
    /* loaded from: classes.dex */
    public static class d extends AbstractC0384b<e> {
        @Override // z2.C1731b.AbstractC0384b
        public String g() {
            return "LastCallPolicy";
        }

        @Override // z2.C1731b.AbstractC0384b
        public void k() {
            super.k();
            ((e) this.f38277a).f38280a = 0L;
        }

        @Override // z2.C1731b.AbstractC0384b
        public boolean m(Context context) {
            k();
            if (context == null) {
                Log.d(g(), "queryLastCallTimeByNumber, context is null...");
                return false;
            }
            Log.d(g(), "startQueryPolicyData: ");
            l(2);
            T t10 = this.f38277a;
            ((e) t10).f38280a = OplusPhoneUtils.queryCallTimeByNumber(context, ((e) t10).f38281b);
            l(3);
            i();
            return true;
        }

        @Override // z2.C1731b.AbstractC0384b
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public e f() {
            return new e();
        }

        public final void p(String str) {
            ((e) this.f38277a).f38281b = str;
        }

        public d() {
        }
    }

    /* compiled from: OplusInCallPolicyQuery.java */
    /* renamed from: z2.b$e */
    /* loaded from: classes.dex */
    public static class e extends c {

        /* renamed from: a, reason: collision with root package name */
        public long f38280a;

        /* renamed from: b, reason: collision with root package name */
        public String f38281b;

        @Override // z2.C1731b.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public e clone() {
            e eVar = new e();
            eVar.f38280a = this.f38280a;
            eVar.f38281b = this.f38281b;
            return eVar;
        }
    }

    /* compiled from: OplusInCallPolicyQuery.java */
    /* renamed from: z2.b$f */
    /* loaded from: classes.dex */
    public interface f {
        int a();

        void b(Context context, g gVar);

        void c(g gVar);

        <T> T d();
    }

    /* compiled from: OplusInCallPolicyQuery.java */
    /* renamed from: z2.b$g */
    /* loaded from: classes.dex */
    public interface g {
        void onQueryPolicyComplete();
    }

    /* compiled from: OplusInCallPolicyQuery.java */
    /* renamed from: z2.b$h */
    /* loaded from: classes.dex */
    public static class h {
        public static boolean a(int i10) {
            if (1 == i10) {
                return true;
            }
            return false;
        }

        public static boolean b(int i10) {
            if (2 == i10) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: OplusInCallPolicyQuery.java */
    /* renamed from: z2.b$i */
    /* loaded from: classes.dex */
    public static class i extends AbstractC0384b<j> {

        /* renamed from: d, reason: collision with root package name */
        public static final Uri f38282d = Uri.parse("content://com.oplus.smartdrive.data.DataProvider/ride_mode_settings");

        /* renamed from: e, reason: collision with root package name */
        public static final String[] f38283e = {"ride_mode_switch", "ride_mode_allow_calls_from", "ride_mode_repeat_ringing", "ride_mode_auto_reply_sms", "ride_mode_auto_reply_sms_msg"};

        @Override // z2.C1731b.AbstractC0384b
        public String g() {
            return "RideModePolicy";
        }

        @Override // z2.C1731b.AbstractC0384b
        public void k() {
            super.k();
            T t10 = this.f38277a;
            ((j) t10).f38284a = false;
            ((j) t10).f38285b = 1;
            ((j) t10).f38286c = false;
            ((j) t10).f38287d = false;
            ((j) t10).f38288e = null;
        }

        @Override // z2.C1731b.AbstractC0384b
        public boolean m(Context context) {
            k();
            if (context == null) {
                K2.a.d(g(), "queryRideModePolicyFromDatabase, context is null...");
                return false;
            }
            l(2);
            boolean q10 = q(context);
            if (q10) {
                l(3);
                i();
            }
            return q10;
        }

        @Override // z2.C1731b.AbstractC0384b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public j f() {
            return new j();
        }

        public final boolean o(Cursor cursor, String str) {
            if (cursor == null || cursor.getInt(cursor.getColumnIndex(str)) != 1) {
                return false;
            }
            return true;
        }

        public final boolean p(Context context, String str) {
            if (AppSettingsUtils.systemGetInt(context, str, -1) == 1) {
                return true;
            }
            return false;
        }

        public final boolean q(Context context) {
            boolean z10;
            int systemGetInt = AppSettingsUtils.systemGetInt(context, "smartdrive.ride_mode_settings.ride_mode_switch", -1);
            if (systemGetInt == -1) {
                return r(context);
            }
            j jVar = (j) this.f38277a;
            if (systemGetInt == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            jVar.f38284a = z10;
            K2.a.e(g(), "queryRideModePolicyFromSettings mRideModeSwitch is " + ((j) this.f38277a).f38284a);
            T t10 = this.f38277a;
            if (((j) t10).f38284a) {
                ((j) t10).f38285b = AppSettingsUtils.systemGetInt(context, "smartdrive.ride_mode_settings.ride_mode_allow_calls_from", -1);
                ((j) this.f38277a).f38286c = p(context, "smartdrive.ride_mode_settings.ride_mode_repeat_ringing");
                ((j) this.f38277a).f38287d = p(context, "smartdrive.ride_mode_settings.ride_mode_auto_reply_sms");
                ((j) this.f38277a).f38288e = AppSettingsUtils.systemGetString(context, "smartdrive.ride_mode_settings.ride_mode_auto_reply_sms_msg");
                K2.a.e(g(), "queryRideModePolicyFromSettings mRideModeSwitch is open: " + toString());
            }
            return true;
        }

        public final boolean r(Context context) {
            try {
                try {
                    try {
                        if (Log.sDebug) {
                            K2.a.d(g(), "queryRideModePolicyFromDatabase begin...");
                        }
                        Cursor query = context.getContentResolver().query(f38282d, f38283e, null, null, null);
                        if (Log.sDebug) {
                            K2.a.d(g(), "queryRideModePolicyFromDatabase end...");
                        }
                        if (query != null && query.moveToFirst()) {
                            ((j) this.f38277a).f38284a = o(query, "ride_mode_switch");
                            if (!((j) this.f38277a).f38284a) {
                                if (Log.sDebug) {
                                    K2.a.d(g(), "queryRideModePolicyFromDatabase mRideModeSwitch is closed");
                                }
                            } else {
                                int columnIndex = query.getColumnIndex("ride_mode_allow_calls_from");
                                if (columnIndex > -1) {
                                    ((j) this.f38277a).f38285b = query.getInt(columnIndex);
                                }
                                ((j) this.f38277a).f38286c = o(query, "ride_mode_repeat_ringing");
                                ((j) this.f38277a).f38287d = o(query, "ride_mode_auto_reply_sms");
                                int columnIndex2 = query.getColumnIndex("ride_mode_auto_reply_sms_msg");
                                if (columnIndex2 > -1) {
                                    ((j) this.f38277a).f38288e = query.getString(columnIndex2);
                                }
                                if (Log.sDebug) {
                                    K2.a.d(g(), "queryRideModePolicyFromDatabase mRideModeSwitch is open: " + toString());
                                }
                            }
                        }
                        OplusPhoneUtils.closeSafty(query);
                        return true;
                    } catch (SQLiteException e10) {
                        k();
                        Log.e(g(), "Catch a SQLiteException when query: ", (Exception) e10);
                        OplusPhoneUtils.closeSafty(null);
                        return false;
                    }
                } catch (Exception e11) {
                    k();
                    Log.e(g(), "Catch a Exception when query: ", e11);
                    OplusPhoneUtils.closeSafty(null);
                    return false;
                }
            } catch (Throwable th) {
                OplusPhoneUtils.closeSafty(null);
                throw th;
            }
        }

        public String toString() {
            return "mRideModeSwitch = " + ((j) this.f38277a).f38284a + "  mAllowCallsFrom = " + ((j) this.f38277a).f38285b + "  mAllowRepeatRing = " + ((j) this.f38277a).f38286c + "  mAutoReplySms = " + ((j) this.f38277a).f38287d + "  mAutoReplySmsMsg = " + ((j) this.f38277a).f38288e;
        }

        public i() {
        }
    }

    /* compiled from: OplusInCallPolicyQuery.java */
    /* renamed from: z2.b$j */
    /* loaded from: classes.dex */
    public static class j extends c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f38284a;

        /* renamed from: b, reason: collision with root package name */
        public int f38285b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f38286c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f38287d;

        /* renamed from: e, reason: collision with root package name */
        public String f38288e;

        @Override // z2.C1731b.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j clone() {
            j jVar = new j();
            jVar.f38284a = this.f38284a;
            jVar.f38285b = this.f38285b;
            jVar.f38286c = this.f38286c;
            jVar.f38287d = this.f38287d;
            jVar.f38288e = this.f38288e;
            return jVar;
        }
    }

    /* compiled from: OplusInCallPolicyQuery.java */
    /* renamed from: z2.b$k */
    /* loaded from: classes.dex */
    public static class k extends AbstractC0384b<l> {

        /* renamed from: d, reason: collision with root package name */
        public static final Uri f38289d = Uri.parse("content://com.oplus.smartdrive.data.DataProvider/smart_drive_settings");

        /* renamed from: e, reason: collision with root package name */
        public static final Uri f38290e = Uri.parse("content://com.oplus.ocar.smartdrive.data.DataProvider/smart_drive_settings");

        /* renamed from: f, reason: collision with root package name */
        public static final String[] f38291f = {"smart_drive_switch", "allow_calls_from", "voice_broadcast_calls", "calling_auto_handsfree", "repeat_ringing", "auto_reply_sms", "auto_reply_sms_msg"};

        @Override // z2.C1731b.AbstractC0384b, z2.C1731b.f
        public /* bridge */ /* synthetic */ int a() {
            return super.a();
        }

        @Override // z2.C1731b.AbstractC0384b, z2.C1731b.f
        public /* bridge */ /* synthetic */ void c(g gVar) {
            super.c(gVar);
        }

        @Override // z2.C1731b.AbstractC0384b
        public String g() {
            return "SmartDrivePolicy";
        }

        @Override // z2.C1731b.AbstractC0384b
        /* renamed from: h */
        public /* bridge */ /* synthetic */ c d() {
            return super.d();
        }

        @Override // z2.C1731b.AbstractC0384b
        public void k() {
            super.k();
            T t10 = this.f38277a;
            ((l) t10).f38292a = false;
            ((l) t10).f38293b = 1;
            ((l) t10).f38294c = false;
            ((l) t10).f38297f = false;
            ((l) t10).f38298g = false;
            ((l) t10).f38295d = false;
            ((l) t10).f38296e = null;
            ((l) t10).f38299h = false;
        }

        @Override // z2.C1731b.AbstractC0384b
        public boolean m(Context context) {
            k();
            if (context == null) {
                K2.a.e(g(), "querySmartDriveFromDataBases, context is null...");
                return false;
            }
            l(2);
            boolean q10 = q(context);
            if (q10) {
                l(3);
                i();
            }
            return q10;
        }

        @Override // z2.C1731b.AbstractC0384b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public l f() {
            return new l();
        }

        public final boolean o(Cursor cursor, String str) {
            if (cursor == null || cursor.getInt(cursor.getColumnIndex(str)) != 1) {
                return false;
            }
            return true;
        }

        public final boolean p(Context context, String str) {
            if (AppSettingsUtils.systemGetInt(context, str, -1) == 1) {
                return true;
            }
            return false;
        }

        public boolean q(Context context) {
            boolean z10;
            int systemGetInt;
            if (OplusFeatureOption.FEATURE_DRIVE_MODE) {
                if (AppSettingsUtils.systemGetInt(context, "ocar.smartdrive.smart_drive_settings.smart_drive_switch", -1) != 1 || !OplusPhoneUtils.isOcarDriveMode(context)) {
                    return true;
                }
                K2.a.e(g(), "queryOcarSmartDriveByUri");
                return r(context, f38290e);
            }
            int systemGetInt2 = AppSettingsUtils.systemGetInt(context, "smartdrive.smart_drive_settings.smart_drive_switch", -1);
            if (systemGetInt2 == -1) {
                K2.a.e(g(), "querySmartDriveByUri");
                return r(context, f38289d);
            }
            l lVar = (l) this.f38277a;
            if (systemGetInt2 == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            lVar.f38292a = z10;
            K2.a.e(g(), "querySmartDriveFromSettings mSmartDriveSwich is " + systemGetInt2);
            if (((l) this.f38277a).f38292a) {
                boolean bluetoothAvailable = OplusPhoneUtils.getBluetoothAvailable();
                l lVar2 = (l) this.f38277a;
                if (bluetoothAvailable) {
                    systemGetInt = 1;
                } else {
                    systemGetInt = AppSettingsUtils.systemGetInt(context, "smartdrive.smart_drive_settings.allow_calls_from", -1);
                }
                lVar2.f38293b = systemGetInt;
                ((l) this.f38277a).f38297f = p(context, "smartdrive.smart_drive_settings.voice_broadcast_calls");
                ((l) this.f38277a).f38294c = p(context, "smartdrive.smart_drive_settings.repeat_ringing");
                ((l) this.f38277a).f38298g = p(context, "smartdrive.smart_drive_settings.calling_auto_handsfree");
                ((l) this.f38277a).f38295d = p(context, "smartdrive.smart_drive_settings.auto_reply_sms");
                ((l) this.f38277a).f38296e = AppSettingsUtils.systemGetString(context, "smartdrive.smart_drive_settings.auto_reply_sms_msg");
                K2.a.e(g(), "querySmartDriveFromSettings mSmartDriveSwich is open: " + toString());
            }
            return true;
        }

        public final boolean r(Context context, Uri uri) {
            try {
                try {
                    try {
                        if (Log.sDebug) {
                            K2.a.e(g(), "querySmartDriveFromDataBases begin...");
                        }
                        ((l) this.f38277a).f38299h = OplusPhoneUtils.hasSpeechAssistPermission(context);
                        Cursor query = context.getContentResolver().query(uri, f38291f, null, null, null);
                        if (Log.sDebug) {
                            K2.a.e(g(), "querySmartDriveFromDataBases end...");
                        }
                        if (query != null && query.moveToFirst()) {
                            ((l) this.f38277a).f38292a = o(query, "smart_drive_switch");
                            if (!((l) this.f38277a).f38292a) {
                                if (Log.sDebug) {
                                    K2.a.e(g(), "querySmartDriveFromDataBases mSmartDriveSwich is closed");
                                }
                            } else {
                                boolean bluetoothAvailable = OplusPhoneUtils.getBluetoothAvailable();
                                int columnIndex = query.getColumnIndex("allow_calls_from");
                                if (bluetoothAvailable) {
                                    ((l) this.f38277a).f38293b = 1;
                                } else if (columnIndex > -1) {
                                    ((l) this.f38277a).f38293b = query.getInt(columnIndex);
                                }
                                ((l) this.f38277a).f38297f = o(query, "voice_broadcast_calls");
                                ((l) this.f38277a).f38294c = o(query, "repeat_ringing");
                                ((l) this.f38277a).f38298g = o(query, "calling_auto_handsfree");
                                ((l) this.f38277a).f38295d = o(query, "auto_reply_sms");
                                int columnIndex2 = query.getColumnIndex("auto_reply_sms_msg");
                                if (columnIndex2 > -1) {
                                    ((l) this.f38277a).f38296e = query.getString(columnIndex2);
                                }
                                if (Log.sDebug) {
                                    K2.a.e(g(), "querySmartDriveFromDataBases mSmartDriveSwich is open: " + toString());
                                }
                            }
                        }
                        OplusPhoneUtils.closeSafty(query);
                        return true;
                    } catch (SQLiteException e10) {
                        k();
                        Log.e(g(), "Catch a SQLiteException when query: ", (Exception) e10);
                        OplusPhoneUtils.closeSafty(null);
                        return false;
                    }
                } catch (Exception e11) {
                    k();
                    Log.e(g(), "Catch a Exception when query: ", e11);
                    OplusPhoneUtils.closeSafty(null);
                    return false;
                }
            } catch (Throwable th) {
                OplusPhoneUtils.closeSafty(null);
                throw th;
            }
        }

        public String toString() {
            return "mDriveSwitch = " + ((l) this.f38277a).f38292a + "  mAllowCallsFrom = " + ((l) this.f38277a).f38293b + "  mAllowRepeatRing = " + ((l) this.f38277a).f38294c + "  mVoiceBroadcastCalls = " + ((l) this.f38277a).f38297f + "  mAutoSpeakerWhenAccept = " + ((l) this.f38277a).f38298g + "  mAutoReplySms = " + ((l) this.f38277a).f38295d + "  mReplySmsMsg = " + ((l) this.f38277a).f38296e + "  mHasSpeechAssistPermission = " + ((l) this.f38277a).f38299h;
        }
    }

    /* compiled from: OplusInCallPolicyQuery.java */
    /* renamed from: z2.b$l */
    /* loaded from: classes.dex */
    public static class l extends c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f38292a;

        /* renamed from: b, reason: collision with root package name */
        public int f38293b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f38294c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f38295d;

        /* renamed from: e, reason: collision with root package name */
        public String f38296e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f38297f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f38298g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f38299h;

        @Override // z2.C1731b.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public l clone() {
            l lVar = new l();
            lVar.f38292a = this.f38292a;
            lVar.f38293b = this.f38293b;
            lVar.f38294c = this.f38294c;
            lVar.f38295d = this.f38295d;
            lVar.f38296e = this.f38296e;
            lVar.f38297f = this.f38297f;
            lVar.f38298g = this.f38298g;
            lVar.f38299h = this.f38299h;
            return lVar;
        }
    }

    public C1731b() {
        this.f38275b = new i();
        this.f38276c = new d();
    }

    public static C1731b d() {
        return f38273e;
    }

    public void b(final Context context, final String str) {
        C2.b.a().execute(new Runnable() { // from class: z2.a
            @Override // java.lang.Runnable
            public final void run() {
                C1731b.this.g(context, str);
            }
        });
        WearInfoQueryUtils.INSTANCE.queryHideIncomingCallUiByWear(context);
    }

    public void c() {
        Log.d("OplusInCallPolicyQuery", "clearCallback...");
        this.f38274a.j();
        this.f38275b.j();
        this.f38276c.j();
    }

    public f e(int i10) {
        return f(i10, null);
    }

    public f f(int i10, String str) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    Log.d("OplusInCallPolicyQuery", "getQueryPolicy not init this type policy");
                    return null;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.f38276c.p(str);
                }
                return this.f38276c;
            }
            return this.f38275b;
        }
        return this.f38274a;
    }

    public final /* synthetic */ void g(Context context, String str) {
        Log.d("OplusInCallPolicyQuery", "asyncQueryPolicyForIncoming:");
        e(1).b(context, null);
        e(2).b(context, null);
        f(3, str).b(context, null);
    }
}
