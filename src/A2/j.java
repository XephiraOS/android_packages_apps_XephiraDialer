package A2;

import A2.A;
import A2.k;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.CallerInfo;
import com.android.incallui.CallerInfoAsyncQuery;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.ContactsAsyncHelper;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusPhoneUserActionStatistics;
import com.android.incallui.OplusPhoneUtils;
import com.google.common.collect.Maps;
import java.util.HashMap;
import z2.C1731b;

/* compiled from: OplusContactsInfoManager.java */
/* loaded from: classes.dex */
public class j extends k implements ContactsAsyncHelper.OnImageLoadCompleteListener {

    /* renamed from: k, reason: collision with root package name */
    public static j f128k;

    /* renamed from: h, reason: collision with root package name */
    public Context f131h;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap<String, ContactInfoCache.ContactCacheEntry> f129f = Maps.f();

    /* renamed from: g, reason: collision with root package name */
    public final HashMap<String, ContactInfoCache.ContactCacheEntry> f130g = Maps.f();

    /* renamed from: i, reason: collision with root package name */
    public e f132i = new e();

    /* renamed from: j, reason: collision with root package name */
    public Handler f133j = new a();

    /* compiled from: OplusContactsInfoManager.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    if (Log.sDebug) {
                        D2.g.e("OplusContactsInfoManager", "MSG_START_EARLY_QUERY_INFO message received...");
                    }
                    j.this.c0((String) message.obj, message.arg1);
                    return;
                case 1001:
                    A a10 = (A) message.obj;
                    ContactInfoCache.ContactCacheEntry I10 = j.this.I(a10.f93a);
                    Log.d("OplusContactsInfoManager", "MSG_QUERY_LOCATION_COMPLETE locationInfo = " + D2.g.o(a10.f95c));
                    if (I10 == null) {
                        return;
                    }
                    I10.locationQueryState = 4;
                    if (!TextUtils.isEmpty(a10.f95c)) {
                        I10.location = a10.f95c;
                        j.this.e(a10.f93a, I10, 4, false);
                        return;
                    } else {
                        if (I10.isIncomingCall) {
                            OplusPhoneUserActionStatistics.markNoAttribution(j.this.f131h, a10.f93a);
                            return;
                        }
                        return;
                    }
                case 1002:
                    Log.d("OplusContactsInfoManager", "MSM_CLEAR_RESOURCE recived....");
                    j.this.w();
                    return;
                case 1003:
                    String str = (String) message.obj;
                    ContactInfoCache.ContactCacheEntry I11 = j.this.I(str);
                    Log.d("OplusContactsInfoManager", "MSM_QUERY_CALL_LOG_COMPLETE entryInfo = " + I11);
                    if (I11 == null) {
                        return;
                    }
                    I11.callLogQueryState = 5;
                    j.this.e(str, I11, 5, false);
                    return;
                case 1004:
                    if (Log.sDebug) {
                        Log.d("OplusContactsInfoManager", "MSM_ADD_NEW_OUT_GOINGCALL_TIME_OUT message received...");
                    }
                    if (!OplusPhoneUtils.isTelephonyIdle(j.this.f131h)) {
                        Log.d("OplusContactsInfoManager", "MSM_ADD_NEW_OUT_GOINGCALL_TIME_OUT is not idle, return!");
                        return;
                    }
                    v oplusSelectPhoneAccountManager = InCallPresenter.getInstance().realInstance().getOplusSelectPhoneAccountManager();
                    if (!CallList.getInstance().hasAnyLiveCall()) {
                        if (oplusSelectPhoneAccountManager == null || oplusSelectPhoneAccountManager.i() == null) {
                            j.this.w();
                            return;
                        }
                        return;
                    }
                    return;
                case 1005:
                    String str2 = (String) message.obj;
                    ContactInfoCache.ContactCacheEntry I12 = j.this.I(str2);
                    if (I12 == null) {
                        Log.d("OplusContactsInfoManager", "MSG_QUERY_LOCATION_COMPLETE cacheEntryForRecord is null");
                        return;
                    }
                    Log.d("OplusContactsInfoManager", "MSG_QUERY_LOCATION_COMPLETE cacheEntryForRecord = " + I12.shouldAutoRecord);
                    I12.customRecordQueryState = 6;
                    j.this.e(str2, I12, 6, false);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: OplusContactsInfoManager.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f135a;

        public b(String str) {
            this.f135a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Log.sDebug) {
                D2.g.e("OplusContactsInfoManager", "getLocationByNumber begin... ");
            }
            OplusPhoneUtils.queryNumberAttribution(this.f135a, j.this.f131h);
            String numberLocation = OplusPhoneUtils.getNumberLocation(this.f135a, j.this.f131h);
            Message obtain = Message.obtain(j.this.f133j, 1001);
            A a10 = new A();
            a10.f93a = this.f135a;
            a10.f95c = numberLocation;
            obtain.obj = a10;
            j.this.f133j.sendMessage(obtain);
            if (Log.sDebug) {
                D2.g.e("OplusContactsInfoManager", "getLocationByNumber down, location is " + D2.g.o(numberLocation));
            }
        }
    }

    /* compiled from: OplusContactsInfoManager.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f137a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ContactInfoCache.ContactCacheEntry f138b;

        public c(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
            this.f137a = str;
            this.f138b = contactCacheEntry;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Log.sDebug) {
                D2.g.e("OplusContactsInfoManager", "queryAutoRecordNumber begin... ");
            }
            boolean j10 = i2.b.j(j.this.f131h, this.f137a);
            Message obtain = Message.obtain(j.this.f133j, 1005);
            this.f138b.shouldAutoRecord = j10;
            obtain.obj = this.f137a;
            j.this.f133j.sendMessage(obtain);
            if (Log.sDebug) {
                D2.g.e("OplusContactsInfoManager", "queryAutoRecordNumber end, isExist " + j10);
            }
        }
    }

    /* compiled from: OplusContactsInfoManager.java */
    /* loaded from: classes.dex */
    public class d implements CallerInfoAsyncQuery.OnQueryCompleteListener {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f140a;

        public d(boolean z10) {
            this.f140a = z10;
        }

        @Override // com.android.incallui.CallerInfoAsyncQuery.OnQueryCompleteListener
        public void onQueryComplete(int i10, Object obj, CallerInfo callerInfo) {
            if (callerInfo != null && obj != null) {
                String str = (String) obj;
                ContactInfoCache.ContactCacheEntry I10 = j.this.I(str);
                if (I10 == null) {
                    Log.d("OplusContactsInfoManager", "onQueryComplete  cacheEntry not find return");
                    return;
                }
                j jVar = j.this;
                jVar.t(jVar.f131h, I10, "query", callerInfo, 1, false);
                I10.contactQueryState = 2;
                if (Log.sDebug) {
                    Log.d("OplusContactsInfoManager", "onQueryComplete build entry complete  cacheEntry = " + I10);
                }
                if (I10.isShowFdnName) {
                    I10.name = I10.fdnName;
                    j.this.e(str, I10, 2, true);
                    return;
                }
                if (I10.omojiPhotoUri == null && (I10.displayPhotoUri == null || I10.photo != null)) {
                    if (Log.sDebug) {
                        D2.g.e("OplusContactsInfoManager", "Contact lookup. Local contact photo not found, query down!");
                    }
                    I10.contactQueryState = 3;
                    j.this.e(str, I10, 3, true);
                    return;
                }
                if (Log.sDebug) {
                    D2.g.e("OplusContactsInfoManager", "Contact lookup. Local contact found, starting image load");
                }
                j.this.e(str, I10, 2, true);
                ContactsAsyncHelper.startObtainPhotoAsync(0, j.this.f131h, callerInfo.contactDisplayPhotoUri, callerInfo.contactPhotoThumbnailUri, callerInfo.omojiPhotoUri, j.this, obj);
                return;
            }
            if (Log.sDebug) {
                Log.d("OplusContactsInfoManager", "onQueryComplete callerInfo or cookie is null");
            }
        }
    }

    /* compiled from: OplusContactsInfoManager.java */
    /* loaded from: classes.dex */
    public class e implements A.a {
        public e() {
        }

        @Override // A2.A.a
        public void a(A a10) {
            if (a10 == null) {
                D2.g.k("OplusContactsInfoManager", "yellowPageComplete info is null");
                return;
            }
            ContactInfoCache.ContactCacheEntry I10 = j.this.I(a10.f93a);
            if (Log.sDebug) {
                Log.d("OplusContactsInfoManager", "onQueryYellowPageComplete number = " + D2.g.l(a10.f93a));
            }
            if (I10 == null) {
                D2.g.k("OplusContactsInfoManager", "yellowPageComplete can not find info in cache return ");
                return;
            }
            j.C(I10.yellowPageInfo, a10);
            if (a10.f103k == 2 && (a10.f95c != null || a10.f97e != null)) {
                OplusPhoneUtils.sendSecureData(j.this.f131h, OplusPhoneUtils.TYPE_STRANGE_NUMBER, 1);
            }
            if (a10.f103k == 3) {
                I10.yellowPageQueryState = 3;
            } else {
                I10.yellowPageQueryState = 2;
            }
            j.this.e(a10.f93a, I10, I10.yellowPageQueryState, false);
        }
    }

    public static void A(ContactInfoCache.ContactCacheEntry contactCacheEntry, ContactInfoCache.ContactCacheEntry contactCacheEntry2) {
        if (contactCacheEntry2 != null && contactCacheEntry != null) {
            contactCacheEntry2.isWhiteListNumber = contactCacheEntry.isWhiteListNumber;
        }
    }

    public static void B(ContactInfoCache.ContactCacheEntry contactCacheEntry, ContactInfoCache.ContactCacheEntry contactCacheEntry2) {
        contactCacheEntry.contactQueryState = contactCacheEntry2.contactQueryState;
        contactCacheEntry.yellowPageQueryState = contactCacheEntry2.yellowPageQueryState;
        contactCacheEntry.locationQueryState = contactCacheEntry2.locationQueryState;
        contactCacheEntry.callLogQueryState = contactCacheEntry2.callLogQueryState;
        contactCacheEntry.customRecordQueryState = contactCacheEntry2.customRecordQueryState;
        contactCacheEntry.whiteListQueryState = contactCacheEntry2.whiteListQueryState;
    }

    public static void C(A a10, A a11) {
        D(a10, a11, true, true);
    }

    public static void D(A a10, A a11, boolean z10, boolean z11) {
        if (a10 != null && a11 != null) {
            if (z11) {
                a10.f97e = a11.f97e;
                a10.f98f = a11.f98f;
                a10.f99g = a11.f99g;
                a10.f100h = a11.f100h;
                a10.f96d = a11.f96d;
            }
            if (z10) {
                a10.f95c = a11.f95c;
                a10.f101i = a11.f101i;
            }
            a10.f102j = a11.f102j;
            a10.f107o = a11.f107o;
            a10.f105m = a11.f105m;
            a10.f106n = a11.f106n;
        }
    }

    public static synchronized j J() {
        j jVar;
        synchronized (j.class) {
            try {
                if (f128k == null) {
                    f128k = new j();
                }
                jVar = f128k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }

    public static void y(ContactInfoCache.ContactCacheEntry contactCacheEntry, ContactInfoCache.ContactCacheEntry contactCacheEntry2, boolean z10) {
        A a10;
        String str;
        if (Log.sDebug) {
            Log.d("OplusContactsInfoManager", "copycontactCacheEntry  src = " + contactCacheEntry);
        }
        if (contactCacheEntry != null && contactCacheEntry2 != null) {
            String str2 = contactCacheEntry.name;
            if (str2 != null) {
                contactCacheEntry2.name = str2;
            }
            long j10 = contactCacheEntry.person_id;
            if (j10 != -1) {
                contactCacheEntry2.person_id = j10;
                contactCacheEntry2.contactType = contactCacheEntry.contactType;
                contactCacheEntry2.isYellowPageNumber = false;
                contactCacheEntry2.starred = contactCacheEntry.starred;
            }
            Uri uri = contactCacheEntry.contactUri;
            if (uri != null) {
                contactCacheEntry2.contactUri = uri;
            }
            String str3 = contactCacheEntry.company;
            if (str3 != null) {
                contactCacheEntry2.company = str3;
            }
            String str4 = contactCacheEntry.title;
            if (str4 != null) {
                contactCacheEntry2.title = str4;
            }
            String str5 = contactCacheEntry.location;
            if (str5 != null) {
                contactCacheEntry2.location = str5;
            }
            Drawable drawable = contactCacheEntry.photo;
            if (drawable != null) {
                contactCacheEntry2.photo = drawable;
            }
            contactCacheEntry2.lookupKey = contactCacheEntry.lookupKey;
            long j11 = contactCacheEntry.lastCallTime;
            if (j11 != 0) {
                contactCacheEntry2.lastCallTime = j11;
            }
            Uri uri2 = contactCacheEntry.lookupUri;
            if (uri2 != null) {
                contactCacheEntry2.lookupUri = uri2;
            }
            if (z10 && TextUtils.isEmpty(contactCacheEntry2.name) && (str = (a10 = contactCacheEntry.yellowPageInfo).f95c) != null) {
                contactCacheEntry2.name = str;
                contactCacheEntry2.photo = a10.f101i;
            }
            contactCacheEntry2.shouldAutoRecord = contactCacheEntry.shouldAutoRecord;
            C(contactCacheEntry2.yellowPageInfo, contactCacheEntry.yellowPageInfo);
            contactCacheEntry2.isPenetratedIncomingCall = contactCacheEntry.isPenetratedIncomingCall;
            contactCacheEntry2.isInWhiteList = contactCacheEntry.isInWhiteList;
            contactCacheEntry2.contactQueryState = contactCacheEntry.contactQueryState;
            contactCacheEntry2.isShowFdnName = contactCacheEntry.isShowFdnName;
            contactCacheEntry2.fdnName = contactCacheEntry.fdnName;
            contactCacheEntry2.omojiPhoto = contactCacheEntry.omojiPhoto;
            contactCacheEntry2.omojiColor = contactCacheEntry.omojiColor;
            contactCacheEntry2.whiteListQueryState = contactCacheEntry.whiteListQueryState;
            contactCacheEntry2.isWhiteListNumber = contactCacheEntry.isWhiteListNumber;
            if (Log.sDebug) {
                Log.d("OplusContactsInfoManager", "copycontactCacheEntry copy down  dest = " + contactCacheEntry2);
                return;
            }
            return;
        }
        Log.d("OplusContactsInfoManager", "copycontactCacheEntry src or dest is null, cannot copy");
    }

    public static void z(ContactInfoCache.ContactCacheEntry contactCacheEntry, ContactInfoCache.ContactCacheEntry contactCacheEntry2) {
        if (contactCacheEntry2 != null && contactCacheEntry != null) {
            contactCacheEntry2.fdnName = contactCacheEntry.fdnName;
            contactCacheEntry2.name = contactCacheEntry.fdnName;
            contactCacheEntry2.isShowFdnName = contactCacheEntry.isShowFdnName;
            contactCacheEntry2.photo = null;
        }
    }

    public ContactInfoCache.ContactCacheEntry E(String str) {
        ContactInfoCache.ContactCacheEntry I10 = I(str);
        Log.v("OplusContactsInfoManager", "findInfoInCache cacheEntry = " + I10);
        return I10;
    }

    public ContactInfoCache.ContactCacheEntry F(String str, k.b bVar) {
        boolean z10;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.u(z10);
        if (bVar == null) {
            D2.g.k("OplusContactsInfoManager", "findInfoInCache callback is null, return");
            return null;
        }
        if (str == null) {
            D2.g.k("OplusContactsInfoManager", "findInfoInCache number is null, return");
            return null;
        }
        ContactInfoCache.ContactCacheEntry E10 = E(str);
        D2.g.k("OplusContactsInfoManager", "findInfoInCache  number = " + D2.g.l(str) + " cacheEntry = " + E10);
        if (E10 == null) {
            return null;
        }
        if (u(E10)) {
            return E10;
        }
        D2.g.k("OplusContactsInfoManager", "findInfoInCache not find complete add callBack ");
        a(str, bVar);
        return E10;
    }

    public ContactInfoCache.ContactCacheEntry G(String str) {
        HashMap<String, ContactInfoCache.ContactCacheEntry> hashMap;
        if (str != null && (hashMap = this.f130g) != null) {
            ContactInfoCache.ContactCacheEntry contactCacheEntry = hashMap.get(str);
            Log.d("OplusContactsInfoManager", "findInfoInMissedCallQueryCache cacheEntry = " + contactCacheEntry);
            return contactCacheEntry;
        }
        return null;
    }

    public void H(Call call, ContactInfoCache.ContactCacheEntry contactCacheEntry, k.b bVar) {
        boolean z10;
        Log.d("OplusContactsInfoManager", "findNumberInfo: contactInfo = " + contactCacheEntry);
        if (contactCacheEntry != null) {
            z10 = contactCacheEntry.isIncomingCall;
        } else {
            z10 = false;
        }
        String number = call.getNumber();
        x(number);
        ContactInfoCache.ContactCacheEntry F10 = F(number, bVar);
        if (F10 == null) {
            a(number, bVar);
            d0(number, call.getCustomContactUri(), call.getId(), z10);
        } else {
            y(F10, contactCacheEntry, true);
            B(contactCacheEntry, F10);
        }
    }

    public ContactInfoCache.ContactCacheEntry I(String str) {
        if (Log.sDebug) {
            Log.d("OplusContactsInfoManager", "getContactCacheEntryFromMap  key = " + D2.g.l(str));
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!TextUtils.isEmpty(str) && str.contains(" ")) {
            str = str.replace(" ", "");
        }
        if (!TextUtils.isEmpty(str) && str.contains("-")) {
            str = str.replace("-", "");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.f129f.get(str) != null) {
                return this.f129f.get(str);
            }
            String formatQueryNumber = OplusPhoneUtils.formatQueryNumber(str);
            if (!TextUtils.isEmpty(formatQueryNumber)) {
                return this.f129f.get(formatQueryNumber);
            }
        }
        return null;
    }

    public void K(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry, k.b bVar) {
        if (bVar != null) {
            a(str, bVar);
        }
        if (contactCacheEntry != null) {
            contactCacheEntry.locationQueryState = 1;
        }
        C2.b.a().execute(new b(str));
    }

    public e L() {
        return this.f132i;
    }

    public final boolean M(String str) {
        boolean z10;
        ContactInfoCache.ContactCacheEntry I10 = I(str);
        if (I10 != null && (I10.name != null || I10.yellowPageInfo.f95c != null)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d("OplusContactsInfoManager", "infoIsValid  isValid = " + z10 + "  number = " + D2.g.l(str));
        }
        return z10;
    }

    public void N(Context context) {
        this.f131h = context;
    }

    public final /* synthetic */ void P(final String str) {
        if (Log.sDebug) {
            D2.g.e("OplusContactsInfoManager", "startQueryFDNContactsName begin... ");
        }
        final String queryFdnName = OplusPhoneUtils.queryFdnName(this.f131h, str);
        if (Log.sDebug) {
            D2.g.e("OplusContactsInfoManager", "startQueryFDNContactsName end... ");
        }
        this.f133j.post(new Runnable() { // from class: A2.i
            @Override // java.lang.Runnable
            public final void run() {
                j.this.O(queryFdnName, str);
            }
        });
    }

    public final /* synthetic */ void R(final String str) {
        if (Log.sDebug) {
            D2.g.e("OplusContactsInfoManager", "startQueryWhiteList begin... ");
        }
        final boolean b10 = B2.a.b(this.f131h, str);
        if (Log.sDebug) {
            D2.g.e("OplusContactsInfoManager", "startQueryWhiteList end... ");
        }
        this.f133j.post(new Runnable() { // from class: A2.h
            @Override // java.lang.Runnable
            public final void run() {
                j.this.Q(b10, str);
            }
        });
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public final void O(String str, String str2) {
        Log.d("OplusContactsInfoManager", "onQueryFdnComplete fdnName = " + D2.g.o(str) + "; number = " + D2.g.l(str2));
        ContactInfoCache.ContactCacheEntry I10 = I(str2);
        if (I10 == null) {
            return;
        }
        I10.fdnQueryState = 2;
        if (!TextUtils.isEmpty(str)) {
            I10.isShowFdnName = true;
            I10.fdnName = str;
            I10.name = str;
            I10.photo = null;
        } else {
            I10.isShowFdnName = false;
        }
        e(str2, I10, I10.fdnQueryState, false);
    }

    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public void Q(boolean z10, String str) {
        Log.d("OplusContactsInfoManager", "onQueryWhiteListComplete isWhiteListNumber = " + z10 + "; number = " + D2.g.l(str));
        ContactInfoCache.ContactCacheEntry I10 = I(str);
        if (I10 == null) {
            return;
        }
        I10.whiteListQueryState = 7;
        I10.isWhiteListNumber = z10;
        e(str, I10, 7, false);
    }

    public void U(Call call, ContactInfoCache.ContactCacheEntry contactCacheEntry, k.b bVar) {
        V(call.getNumber(), contactCacheEntry, bVar);
    }

    public void V(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry, k.b bVar) {
        ContactInfoCache.ContactCacheEntry F10 = F(str, bVar);
        if (F10 == null) {
            ContactInfoCache.ContactCacheEntry contactCacheEntry2 = new ContactInfoCache.ContactCacheEntry();
            contactCacheEntry2.number = str;
            W(str, contactCacheEntry2);
            K(str, contactCacheEntry2, bVar);
        } else if (!TextUtils.isEmpty(F10.location)) {
            contactCacheEntry.location = F10.location;
        } else {
            int i10 = F10.locationQueryState;
            if (i10 == 1) {
                a(str, bVar);
            } else if (i10 == 0) {
                K(str, F10, bVar);
            }
        }
        if (Log.sDebug) {
            Log.d("OplusContactsInfoManager", "onlyFindNumberLocation end  number = " + D2.g.l(str) + "  info = " + F10);
        }
    }

    public final void W(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        if (Log.sDebug) {
            Log.d("OplusContactsInfoManager", "putContactCacheEntryToMap  key = " + D2.g.l(str) + " cacheEntry = " + contactCacheEntry);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty(str) && str.contains(" ")) {
            str = str.replace(" ", "");
        }
        if (!TextUtils.isEmpty(str) && str.contains("-")) {
            str = str.replace("-", "");
        }
        if (!TextUtils.isEmpty(str)) {
            this.f129f.put(str, contactCacheEntry);
        }
    }

    public void X(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry, k.b bVar) {
        String formatQueryNumber = OplusPhoneUtils.formatQueryNumber(str);
        if (bVar != null) {
            a(formatQueryNumber, bVar);
        }
        if (contactCacheEntry == null) {
            Log.d("OplusContactsInfoManager", "queryAutoRecordNumber, contactCacheEntry is null");
            return;
        }
        contactCacheEntry.customRecordQueryState = 1;
        if (!i2.b.k(this.f131h)) {
            contactCacheEntry.customRecordQueryState = 6;
            e(contactCacheEntry.number, contactCacheEntry, 6, false);
        } else {
            C2.b.a().execute(new c(formatQueryNumber, contactCacheEntry));
        }
    }

    public void Y() {
        if (this.f133j.hasMessages(1004)) {
            this.f133j.removeMessages(1004);
        }
    }

    public void Z() {
        if (this.f133j.hasMessages(1002)) {
            this.f133j.removeMessages(1002);
        }
    }

    public void a0() {
        if (!this.f133j.hasMessages(1002)) {
            Handler handler = this.f133j;
            handler.sendMessageDelayed(handler.obtainMessage(1002), 100L);
        }
    }

    public void b0(String str, int i10) {
        Message obtain = Message.obtain();
        obtain.what = 1000;
        obtain.obj = str;
        obtain.arg1 = i10;
        this.f133j.sendMessage(obtain);
    }

    public void c0(String str, int i10) {
        D2.g.k("OplusContactsInfoManager", "startEarlyQueryContactInfo numberAndUri = " + D2.g.l(str));
        if (str != null) {
            x(str);
            d0(str, null, "EARLY_QUERY", false);
            if (i10 == 0) {
                C1731b.d().b(this.f131h, str);
            }
            Y();
            this.f133j.sendEmptyMessageDelayed(1004, GrpcUtils.CREATE_CHANNEL_TIME_OUT);
            if (Log.sDebug) {
                D2.g.e("OplusContactsInfoManager", "startEarlyQueryContactInfo end");
            }
        }
    }

    public void d0(String str, Uri uri, String str2, boolean z10) {
        int i10;
        String formatQueryNumber = OplusPhoneUtils.formatQueryNumber(str);
        if (M(formatQueryNumber)) {
            if (Log.sDebug) {
                D2.g.e("OplusContactsInfoManager", "startQueryContactInfoAndYellowPage number = " + D2.g.l(formatQueryNumber) + "  info is in map return...");
                return;
            }
            return;
        }
        D2.g.k("OplusContactsInfoManager", "# # # # # #begin a new query# # # # # # number = " + D2.g.l(formatQueryNumber) + "  contactUri = " + D2.g.o(uri) + " callId = " + str2 + " isIncoming = " + z10);
        CallerInfo callerInfo = new CallerInfo();
        callerInfo.phoneNumber = formatQueryNumber;
        callerInfo.contactRefUri = uri;
        ContactInfoCache.ContactCacheEntry buildEntry = ContactInfoCache.getInstance(this.f131h).buildEntry(this.f131h, str2, callerInfo, 1, z10);
        W(formatQueryNumber, buildEntry);
        buildEntry.contactQueryState = 1;
        CallerInfoAsyncQuery.startQuery(-1, this.f131h, callerInfo, new d(false), formatQueryNumber);
        buildEntry.yellowPageQueryState = 1;
        y d10 = y.d();
        Context context = this.f131h;
        if (z10) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        d10.e(context, formatQueryNumber, i10, buildEntry.subId);
        if (OplusPhoneUtils.getDirectlyCallEnable(this.f131h)) {
            e0(formatQueryNumber);
        }
        buildEntry.whiteListQueryState = 1;
        f0(formatQueryNumber);
        if (z10) {
            D2.f.T(this.f131h, formatQueryNumber, buildEntry, this.f133j);
        }
        K(formatQueryNumber, buildEntry, null);
    }

    public final void e0(final String str) {
        D2.g.e("OplusContactsInfoManager", "startQueryFDNContactsName begin... ");
        C2.b.a().execute(new Runnable() { // from class: A2.g
            @Override // java.lang.Runnable
            public final void run() {
                j.this.P(str);
            }
        });
    }

    public void f0(final String str) {
        D2.g.e("OplusContactsInfoManager", "startQueryWhiteList");
        C2.b.a().execute(new Runnable() { // from class: A2.f
            @Override // java.lang.Runnable
            public final void run() {
                j.this.R(str);
            }
        });
    }

    @Override // com.android.incallui.ContactsAsyncHelper.OnImageLoadCompleteListener
    public void onImageLoadComplete(int i10, Drawable drawable, Bitmap bitmap, Object obj) {
        String str;
        if (Log.sDebug) {
            D2.g.k("OplusContactsInfoManager", " token = " + i10 + " photo =  photoIcon = " + bitmap);
        }
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            Log.d("OplusContactsInfoManager", "number is empty, return");
            return;
        }
        ContactInfoCache.ContactCacheEntry I10 = I(str);
        if (I10 == null) {
            Log.e(this, "Image Load received for empty search entry.");
            return;
        }
        I10.contactQueryState = 3;
        if (Log.sDebug) {
            Log.d(this, "setting photo for entry: ", I10);
        }
        if (I10.photo != null) {
            Log.d(this, "already has photo so return!!! ");
            return;
        }
        if (drawable != null) {
            Log.v(this, "direct drawable: ", drawable);
            I10.photo = drawable;
        } else if (bitmap != null) {
            Log.v(this, "photo icon: ", bitmap);
            I10.photo = new BitmapDrawable(this.f131h.getResources(), bitmap);
        } else {
            Log.v(this, "unknown photo");
            I10.photo = null;
        }
        e(str, I10, 3, true);
    }

    @Override // com.android.incallui.ContactsAsyncHelper.OnImageLoadCompleteListener
    public void onOmojiLoadComplete(int i10, Drawable drawable, Object obj) {
        String str;
        if (Log.sDebug) {
            D2.g.k("OplusContactsInfoManager", "onOmojiLoadComplete token = " + i10 + " photo = ");
        }
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            Log.d("OplusContactsInfoManager", "number is empty, return");
            return;
        }
        ContactInfoCache.ContactCacheEntry I10 = I(str);
        if (I10 == null) {
            Log.e(this, "Image Load received for empty search entry.");
            return;
        }
        I10.contactQueryState = 3;
        if (drawable != null) {
            Log.v(this, "direct drawable: ", drawable);
            I10.omojiPhoto = drawable;
        }
        e(str, I10, 3, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.android.incallui.ContactInfoCache.ContactCacheEntry t(android.content.Context r6, com.android.incallui.ContactInfoCache.ContactCacheEntry r7, java.lang.String r8, com.android.incallui.CallerInfo r9, int r10, boolean r11) {
        /*
            r5 = this;
            java.lang.String r5 = "OplusContactsInfoManager"
            if (r6 != 0) goto La
            java.lang.String r6 = "buildEntry: context is null"
            com.android.incallui.Log.d(r5, r6)
            return r7
        La:
            if (r9 != 0) goto L12
            java.lang.String r6 = "buildEntry: CallerInfo is null"
            com.android.incallui.Log.d(r5, r6)
            return r7
        L12:
            r0 = 0
            if (r7 != 0) goto L1b
            java.lang.String r6 = "buildEntry: ContactCacheEntry is null"
            com.android.incallui.Log.d(r5, r6)
            return r0
        L1b:
            com.android.incallui.ContactInfoCache.populateCacheEntry(r6, r9, r7, r10, r11)
            int r10 = r9.photoResource
            if (r10 == 0) goto L3d
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r10)     // Catch: java.lang.Exception -> L27
            goto L4d
        L27:
            r6 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "buildEntry: exception = "
            r10.append(r11)
            r10.append(r6)
            java.lang.String r6 = r10.toString()
            com.android.incallui.Log.d(r5, r6)
            goto L4c
        L3d:
            boolean r6 = r9.isCachedPhotoCurrent
            if (r6 == 0) goto L46
            android.graphics.drawable.Drawable r6 = r9.cachedPhoto
            if (r6 == 0) goto L46
            goto L4d
        L46:
            android.net.Uri r6 = r9.contactDisplayPhotoUri
            if (r6 == 0) goto L4c
            r7.displayPhotoUri = r6
        L4c:
            r6 = r0
        L4d:
            android.net.Uri r10 = r9.omojiPhotoUri
            r7.omojiPhotoUri = r10
            java.lang.String r10 = r9.omojiColor
            r7.omojiColor = r10
            java.lang.String r10 = r9.lookupKeyOrNull
            r1 = 0
            if (r10 == 0) goto L69
            long r3 = r9.contactIdOrZero
            int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r11 != 0) goto L62
            goto L69
        L62:
            android.net.Uri r5 = android.provider.ContactsContract.Contacts.getLookupUri(r3, r10)
            r7.lookupUri = r5
            goto L70
        L69:
            java.lang.String r10 = "lookup key is null or contact ID is 0. Don't create a lookup uri."
            com.android.incallui.Log.v(r5, r10)
            r7.lookupUri = r0
        L70:
            r7.photo = r6
            java.lang.String r5 = r9.lookupKeyOrNull
            r7.lookupKey = r5
            boolean r5 = r9.contactExists
            if (r5 == 0) goto L8d
            long r5 = r9.contactIdOrZero
            r7.person_id = r5
            boolean r5 = r9.mIsVipContact
            if (r5 == 0) goto L84
            r1 = 1
        L84:
            r7.contactType = r1
            boolean r5 = r9.starred
            r7.starred = r5
            r5 = 0
            r7.isYellowPageNumber = r5
        L8d:
            r7.callId = r8
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: A2.j.t(android.content.Context, com.android.incallui.ContactInfoCache$ContactCacheEntry, java.lang.String, com.android.incallui.CallerInfo, int, boolean):com.android.incallui.ContactInfoCache$ContactCacheEntry");
    }

    public final boolean u(ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        boolean z10 = false;
        if (contactCacheEntry == null) {
            return false;
        }
        int i10 = contactCacheEntry.contactQueryState;
        if (i10 != 3 || contactCacheEntry.yellowPageQueryState != 3 || contactCacheEntry.locationQueryState != 4 || contactCacheEntry.whiteListQueryState != 7 ? !(i10 != 3 || contactCacheEntry.person_id == -1 || contactCacheEntry.locationQueryState != 4 || contactCacheEntry.whiteListQueryState != 7 || (OplusPhoneUtils.getDirectlyCallEnable(this.f131h) && contactCacheEntry.fdnQueryState != 2)) : !(OplusPhoneUtils.getDirectlyCallEnable(this.f131h) && contactCacheEntry.fdnQueryState != 2)) {
            z10 = true;
        }
        if (Log.sDebug) {
            Log.d("OplusContactsInfoManager", "checkQueryComplete  isComplete = " + z10);
        }
        return z10;
    }

    public void v() {
        Log.d("OplusContactsInfoManager", "clearMissedCallQueryResource: ");
        HashMap<String, ContactInfoCache.ContactCacheEntry> hashMap = this.f130g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void w() {
        if (CallList.getInstance().hasAnyLiveCall()) {
            return;
        }
        if (Log.sDebug) {
            D2.g.e("OplusContactsInfoManager", "clearResource...");
        }
        b();
        for (String str : this.f129f.keySet()) {
            this.f130g.put(str, this.f129f.get(str));
        }
        this.f129f.clear();
        y.d().c();
        Z();
    }

    public final void x(String str) {
        if (InCallPresenter.getInstance().realInstance().getOplusSelectPhoneAccountManager().j() && u(I(str))) {
            w();
        }
    }
}
