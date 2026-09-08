package z0;

import F0.c;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.android.contacts.ContactsApplication;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.api.numberidentify.interfaces.IMarkerData;
import com.android.contacts.framework.api.numberidentify.interfaces.IRecognitionNumber;
import com.android.contacts.framework.baseui.util.A;
import com.android.incallui.OplusNumberMarkUtils;
import com.android.incallui.OplusSpecialNumberUtils;
import com.coui.appcompat.scrollbar.COUIScrollBar;
import com.customize.contacts.util.BlackListUtils;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.ted.number.ui.ErrorRecoveryActivity;
import com.ted.number.ui.MarkDialogActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: TedPresenter.java */
/* renamed from: z0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1725e implements InterfaceC1721a {

    /* renamed from: f, reason: collision with root package name */
    public static final Map<Integer, Pair<String, String>> f38253f = Collections.synchronizedMap(new HashMap());

    /* renamed from: g, reason: collision with root package name */
    public static volatile String f38254g = null;

    /* renamed from: a, reason: collision with root package name */
    public C1723c f38255a;

    /* renamed from: b, reason: collision with root package name */
    public IRecognitionNumber f38256b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC1724d f38257c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f38258d = true;

    /* renamed from: e, reason: collision with root package name */
    public C1722b f38259e;

    /* compiled from: TedPresenter.java */
    /* renamed from: z0.e$a */
    /* loaded from: classes.dex */
    public class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f38260a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f38261b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f38262c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f38263d;

        public a(String str, boolean z10, long j10, boolean z11) {
            this.f38260a = str;
            this.f38261b = z10;
            this.f38262c = j10;
            this.f38263d = z11;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            C1725e c1725e = C1725e.this;
            c1725e.f38259e = c1725e.u(this.f38260a);
            if (this.f38261b) {
                C1725e.t();
                C1725e.this.s(this.f38260a, this.f38262c, this.f38263d);
                return null;
            }
            return null;
        }

        public void b() {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            C1725e.this.f38257c.z0();
        }
    }

    public C1725e(InterfaceC1724d interfaceC1724d) {
        this.f38257c = interfaceC1724d;
        interfaceC1724d.r(this);
    }

    public static boolean r(String str) {
        if (!"cmcc".equals(str) && !"ct".equals(str) && !"cu".equals(str)) {
            return false;
        }
        return true;
    }

    public static void t() {
        try {
            if (FeatureUtil.O()) {
                String languageTag = Locale.getDefault().toLanguageTag();
                if (!TextUtils.equals(f38254g, languageTag)) {
                    synchronized (f38253f) {
                        try {
                            if (!TextUtils.equals(f38254g, languageTag)) {
                                Bundle q10 = E0.b.q();
                                if (q10 != null) {
                                    for (String str : q10.keySet()) {
                                        String[] stringArray = q10.getStringArray(str);
                                        if (stringArray != null && stringArray.length > 1) {
                                            f38253f.put(Integer.valueOf(str), Pair.create(stringArray[0], stringArray[1]));
                                        }
                                    }
                                }
                                f38254g = languageTag;
                            }
                        } finally {
                        }
                    }
                }
            }
        } catch (Throwable th) {
            H7.b.c("TedPresenter", "preloadNumberSupplierNameNumber : " + th);
        }
    }

    @Override // z0.InterfaceC1721a
    public boolean a() {
        IRecognitionNumber iRecognitionNumber = this.f38256b;
        if (iRecognitionNumber != null) {
            return iRecognitionNumber.a();
        }
        return false;
    }

    @Override // z0.InterfaceC1721a
    public IRecognitionNumber b() {
        return this.f38256b;
    }

    @Override // z0.InterfaceC1721a
    public int c() {
        IRecognitionNumber iRecognitionNumber = this.f38256b;
        if (iRecognitionNumber != null) {
            return iRecognitionNumber.c();
        }
        return 0;
    }

    @Override // z0.InterfaceC1721a
    public IMarkerData d() {
        IRecognitionNumber iRecognitionNumber = this.f38256b;
        if (iRecognitionNumber != null) {
            return iRecognitionNumber.B();
        }
        return null;
    }

    @Override // z0.InterfaceC1721a
    public void e(int i10, String str) {
        int i11;
        H7.b.e("TedPresenter", "correction: mRecognitionNumber = ");
        IRecognitionNumber iRecognitionNumber = this.f38256b;
        if (iRecognitionNumber == null) {
            return;
        }
        if (iRecognitionNumber.B() != null) {
            i11 = this.f38256b.B().u();
        } else {
            i11 = -1;
        }
        Intent intent = new Intent(ContactsApplication.h(), (Class<?>) ErrorRecoveryActivity.class);
        intent.putExtra("recognition_name", this.f38256b.getName());
        intent.putExtra("unknown_number", str);
        intent.putExtra("mark_type", i11);
        intent.putExtra("number_supplier_type", this.f38256b.c());
        this.f38257c.f(i10, intent);
    }

    @Override // z0.InterfaceC1721a
    public void f(IRecognitionNumber iRecognitionNumber) {
        this.f38256b = iRecognitionNumber;
    }

    @Override // z0.InterfaceC1721a
    public Pair<String, String> g(int i10) {
        return f38253f.get(Integer.valueOf(i10));
    }

    @Override // z0.InterfaceC1721a
    public void h(String str, long j10, boolean z10, boolean z11) {
        new a(str, z10, j10, z11).b();
    }

    @Override // z0.InterfaceC1721a
    public void i(int i10, String str, int i11) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        HashMap<String, Boolean> d10 = BlackListUtils.d(ContactsApplication.h(), arrayList);
        boolean booleanValue = d10.get("isBlackList").booleanValue();
        boolean booleanValue2 = d10.get("isWhiteList").booleanValue();
        bundle.putString("number", str);
        bundle.putInt(OplusNumberMarkUtils.OplusContact.OPLUS_MARK_CONTACTS_CALL_TYPE, i11);
        bundle.putBoolean("isInBlackList", booleanValue);
        bundle.putBoolean("isInWhiteList", booleanValue2);
        intent.putExtras(bundle);
        intent.setClass(ContactsApplication.h(), MarkDialogActivity.class);
        this.f38257c.f(i10, intent);
        A.a(ContactsApplication.h(), 2000318, 200030199, null, false);
    }

    @Override // z0.InterfaceC1721a
    public boolean j() {
        C1723c c1723c;
        C1722b c1722b = this.f38259e;
        if ((c1722b != null && c1722b.f38246b < 0) || ((c1723c = this.f38255a) != null && !TextUtils.isEmpty(c1723c.f38247a))) {
            return true;
        }
        return false;
    }

    @Override // z0.InterfaceC1721a
    public C1723c k() {
        return this.f38255a;
    }

    @Override // z0.InterfaceC1721a
    public C1722b l() {
        return this.f38259e;
    }

    public final C1723c q() {
        IRecognitionNumber iRecognitionNumber = this.f38256b;
        if (H7.a.b()) {
            H7.b.b("TedPresenter", "allInfoItem is ");
        }
        if (iRecognitionNumber != null) {
            C1723c c1723c = new C1723c();
            c1723c.f38247a = iRecognitionNumber.getName();
            if (H7.a.b()) {
                H7.b.e("TedPresenter", "tedRecName is ");
            }
            if (!TextUtils.isEmpty(c1723c.f38247a)) {
                c1723c.f38248b = iRecognitionNumber.c0();
                c1723c.f38249c = iRecognitionNumber.o0();
                c1723c.f38251e = iRecognitionNumber.getAddress();
                c1723c.f38252f = iRecognitionNumber.S();
                c1723c.f38250d = iRecognitionNumber.r();
                return c1723c;
            }
            return null;
        }
        return null;
    }

    public final void s(String str, long j10, boolean z10) {
        if (H7.a.b()) {
            H7.b.b("TedPresenter", "mIsFirstInPage is " + this.f38258d + " mTedNumberManager.isServiceNumber(mNum) is " + E0.b.y(str) + " isGetCache is " + z10);
        }
        if (this.f38258d && E0.b.y(str) && z10) {
            this.f38258d = false;
            this.f38256b = E0.b.h(str);
        } else {
            c.a l10 = new c.a().h(str).l(Integer.valueOf(D7.c.q(ContactsApplication.h(), Integer.valueOf((int) j10))));
            if (!z10) {
                l10.g(Boolean.TRUE).m(Long.valueOf(COUIScrollBar.SCROLLER_FADE_TIMEOUT)).d(Integer.valueOf(E0.b.k()));
            } else {
                l10.g(Boolean.TRUE).m(Long.valueOf(COUIScrollBar.SCROLLER_FADE_TIMEOUT));
            }
            IRecognitionNumber B10 = E0.b.B(l10.a());
            this.f38256b = B10;
            if (B10 != null && !r(B10.e()) && !this.f38256b.equals(E0.b.h(str))) {
                E0.b.E(str, this.f38256b);
            }
        }
        this.f38255a = q();
    }

    public final C1722b u(String str) {
        String[] strArr = {BreenoCallContract.BaseColumns._ID, "number", OplusSpecialNumberUtils.OplusSpecialNumColumns.CN_NAME};
        String str2 = "number = '" + str + "'";
        C1722b c1722b = new C1722b("", 0L);
        Cursor cursor = null;
        try {
            cursor = G7.c.e(ContactsApplication.h().getContentResolver(), R0.d.f3230q, strArr, str2, null, null);
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                c1722b.f38245a = cursor.getString(2);
                c1722b.f38246b = 0 - cursor.getInt(0);
            }
            return c1722b;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
