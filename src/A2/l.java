package A2;

import P2.a;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.Log;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.OplusPhoneUserActionStatistics;
import com.android.incallui.TelecomAdapter;

/* compiled from: OplusInCallAdapterExtProxy.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: b, reason: collision with root package name */
    public static l f148b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f149c = Log.sDebug;

    /* renamed from: a, reason: collision with root package name */
    public IBinder f150a;

    public static synchronized l d() {
        l lVar;
        synchronized (l.class) {
            try {
                if (f148b == null) {
                    f148b = new l();
                }
                lVar = f148b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    public final void a(int i10, Parcel parcel, Parcel parcel2, int i11) {
        boolean z10 = f149c;
        if (z10) {
            Log.d("OplusInCallAdapterExtProxy", "doTransact... code = " + i10);
        }
        IBinder iBinder = this.f150a;
        if (iBinder != null) {
            try {
                iBinder.transact(i10, parcel, parcel2, i11);
                return;
            } catch (RemoteException e10) {
                Log.e("OplusInCallAdapterExtProxy", e10.getMessage());
                OplusPhoneUserActionStatistics.addBindInteractError(OplusInCallApp.getAppContext(), OplusPhoneUserActionStatistics.USER_ACTION_BIND_REMOTE_ERROR, e10.getMessage());
                return;
            }
        }
        if (z10) {
            Log.d("OplusInCallAdapterExtProxy", "doTransact return mIBinder is empty");
        }
        OplusPhoneUserActionStatistics.addBindInteractError(OplusInCallApp.getAppContext(), OplusPhoneUserActionStatistics.USER_ACTION_BINDER_IS_NULL, String.valueOf(true));
    }

    public void b(String str) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.telecom.OplusInCallAdapterExt");
            obtain.writeString(str);
            a(107, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public String c(String str) {
        return k(1, str);
    }

    public boolean e(String str) {
        String k10 = k(3, str);
        if (Log.sDebug) {
            Log.d("OplusInCallAdapterExtProxy", "getIsCdmaDialing ... isDialing = " + k10);
        }
        if (k10 != null) {
            return Boolean.valueOf(k10).booleanValue();
        }
        return false;
    }

    public boolean f() {
        String k10 = k(5, "");
        if (Log.sDebug) {
            Log.d("OplusInCallAdapterExtProxy", "getIsHangUpFromHeadset ...  = " + k10);
        }
        if (k10 != null) {
            return Boolean.valueOf(k10).booleanValue();
        }
        return false;
    }

    public boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.d("OplusInCallAdapterExtProxy", "isWatch return false for address is empty!");
            return false;
        }
        String k10 = k(6, str);
        if (Log.sDebug) {
            Log.d("OplusInCallAdapterExtProxy", "isWatch ...  = " + k10);
        }
        if (k10 == null) {
            return false;
        }
        return Boolean.valueOf(k10).booleanValue();
    }

    public void h(String str, String str2, long j10, long j11, String str3, int i10, String str4, int i11) {
        if (f149c) {
            Log.d("OplusInCallAdapterExtProxy", "notifyMissedCallMessages... number = " + D2.g.l(str) + "  titleText = " + D2.g.o(str2) + "  date = " + j10 + "  personId = " + j11 + "  expandedText = " + D2.g.o(str3) + "  callType = " + i10 + "  markType = " + str4 + "  missedCount = " + i11);
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.telecom.OplusInCallAdapterExt");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeLong(j10);
            obtain.writeLong(j11);
            obtain.writeString(str3);
            obtain.writeInt(i10);
            obtain.writeString(str4);
            obtain.writeInt(i11);
            a(101, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void i(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        if (contactCacheEntry == null) {
            return;
        }
        Log.d("OplusInCallAdapterExtProxy", "notifyNumberInfoChanged number = " + D2.g.l(str) + "info = " + contactCacheEntry);
        a.C0054a c0054a = new a.C0054a();
        if (TextUtils.isEmpty(contactCacheEntry.name) && !TextUtils.isEmpty(contactCacheEntry.yellowPageInfo.f95c)) {
            c0054a.f2879a = contactCacheEntry.yellowPageInfo.f95c;
        } else {
            c0054a.f2879a = contactCacheEntry.name;
        }
        c0054a.f2880b = contactCacheEntry.person_id;
        c0054a.f2881c = contactCacheEntry.location;
        c0054a.f2882d = contactCacheEntry.lookupKey;
        A a10 = contactCacheEntry.yellowPageInfo;
        c0054a.f2883e = a10.f97e;
        c0054a.f2884f = a10.f99g;
        n(str, c0054a);
    }

    public void j(String str, boolean z10) {
        if (f149c) {
            Log.d("OplusInCallAdapterExtProxy", "oplusHoldClicked... callId = " + str + " checked = " + z10);
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.telecom.OplusInCallAdapterExt");
            obtain.writeString(str);
            obtain.writeBoolean(z10);
            a(105, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public String k(int i10, String str) {
        Log.d("OplusInCallAdapterExtProxy", "custom oplusInteractWithTelecomService...cmd = " + i10);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.telecom.OplusInCallAdapterExt");
            obtain.writeInt(i10);
            obtain.writeString(str);
            a(111, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            obtain.recycle();
            obtain2.recycle();
            Log.d("OplusInCallAdapterExtProxy", "custom oplusInteractWithTelecomService ret = " + readString);
            return readString;
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            throw th;
        }
    }

    public void l(String str, int i10, String str2) {
        if (f149c) {
            K2.a.b("OplusInCallAdapterExtProxy", "oplusStartRinging  callId = " + str + " type " + P2.a.a(i10) + "  from = " + str2);
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.telecom.OplusInCallAdapterExt");
            obtain.writeString(str);
            obtain.writeInt(i10);
            a(102, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void m(String str) {
        if (Log.sDebug) {
            Log.d("OplusInCallAdapterExtProxy", "registerVideoCallCallbackComplete  id = " + str);
        }
        if (!TextUtils.isEmpty(str)) {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.android.telecom.OplusInCallAdapterExt");
                obtain.writeString(str);
                a(104, obtain, null, 1);
            } finally {
                obtain.recycle();
            }
        }
    }

    public void n(String str, a.C0054a c0054a) {
        Log.d("OplusInCallAdapterExtProxy", "setContactAndYellowPageInfo... number = " + D2.g.l(str) + " info = " + c0054a);
        if (TextUtils.isEmpty(str) || c0054a == null) {
            return;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.telecom.OplusInCallAdapterExt");
            obtain.writeString(str);
            obtain.writeString(c0054a.f2879a);
            obtain.writeLong(c0054a.f2880b);
            obtain.writeString(c0054a.f2881c);
            obtain.writeString(c0054a.f2882d);
            obtain.writeString(c0054a.f2883e);
            obtain.writeInt(c0054a.f2884f);
            a(108, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void o(IBinder iBinder) {
        this.f150a = iBinder;
    }

    public void p(int i10) {
        Log.d("OplusInCallAdapterExtProxy", "custom setIncomingInterfaceType ret = " + i10);
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.telecom.OplusInCallAdapterExt");
            obtain.writeInt(i10);
            a(110, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void q(String str, String str2) {
        String telecommCallId = TelecomAdapter.getInstance().oplusTelecomAdapter().getTelecommCallId(str);
        if (Log.sDebug) {
            K2.a.b("OplusInCallAdapterExtProxy", "startRinging  teleCommCallId = " + telecommCallId + " from " + str2);
        }
        if (telecommCallId != null) {
            k(2, telecommCallId);
            return;
        }
        if (Log.sDebug) {
            K2.a.b("OplusInCallAdapterExtProxy", "startRinging  failed  by teleCommCallId is null ");
        }
        OplusPhoneUserActionStatistics.addNoIncomingRingAction(OplusInCallApp.getAppContext(), OplusPhoneUserActionStatistics.USER_ACTION_INCOMING_CALL_ID_NULL, str);
    }

    public boolean r(String str) {
        boolean z10;
        String c10 = c(str);
        if (c10 != null && ("4".equals(c10) || "11".equals(c10))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d("OplusInCallAdapterExtProxy", "telecomCallIsStillRinging  = " + z10 + "  teleCommCallId = " + str + " callState = " + c10);
        }
        return z10;
    }

    public void s(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.telecom.OplusInCallAdapterExt");
            obtain.writeString(str);
            obtain.writeString(str2);
            a(106, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
