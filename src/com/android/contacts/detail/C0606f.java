package com.android.contacts.detail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.provider.CallLog;
import android.telephony.PhoneNumberUtils;
import android.telephony.SubscriptionInfo;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import com.android.contacts.ContactLoader;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.summary.AutoCallSummaryTipManager;
import com.android.contacts.detail.C0606f;
import com.android.contacts.detail.CallDetailActivityFragment;
import com.android.contacts.detail.i0;
import com.android.contacts.framework.baseui.calllog.CallRecordingsCache;
import com.android.contacts.util.C0703d;
import com.android.contacts.util.InterfaceC0702c;
import com.customize.contacts.activities.MoreCallLogActivity;
import com.customize.contacts.mediaplayer.RecordPlayerPresenter;
import com.customize.contacts.util.C0799j;
import com.customize.contacts.util.C0801l;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.AppMetaFeatures;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import h1.C1073b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

/* compiled from: CallDetailFragment.java */
/* renamed from: com.android.contacts.detail.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0606f extends z0 {

    /* renamed from: W0, reason: collision with root package name */
    public int f14586W0;

    /* renamed from: Z0, reason: collision with root package name */
    public PhoneCallDetails[] f14589Z0;

    /* renamed from: T0, reason: collision with root package name */
    public ContentObserver f14583T0 = null;

    /* renamed from: U0, reason: collision with root package name */
    public final InterfaceC0702c f14584U0 = C0703d.c();

    /* renamed from: V0, reason: collision with root package name */
    public final HashMap<Integer, SubscriptionInfo> f14585V0 = new HashMap<>();

    /* renamed from: X0, reason: collision with root package name */
    public String[] f14587X0 = null;

    /* renamed from: Y0, reason: collision with root package name */
    public String[] f14588Y0 = null;

    /* renamed from: a1, reason: collision with root package name */
    public boolean f14590a1 = false;

    /* renamed from: b1, reason: collision with root package name */
    public c f14591b1 = null;

    /* renamed from: c1, reason: collision with root package name */
    public final BroadcastReceiver f14592c1 = new a();

    /* compiled from: CallDetailFragment.java */
    /* renamed from: com.android.contacts.detail.f$a */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ContactLoader.Result result;
            String action = intent.getAction();
            H7.b.b("CallDetailFragment", "onReceive action : " + action);
            if (TextUtils.equals("com.oplus.contacts.action_SIM_ABSENT", action) && (result = C0606f.this.f14744d) != null && result.f0() && C0606f.this.getActivity() != null) {
                C0606f.this.getActivity().finish();
            }
        }
    }

    /* compiled from: CallDetailFragment.java */
    /* renamed from: com.android.contacts.detail.f$b */
    /* loaded from: classes.dex */
    public class b extends ContentObserver {
        public b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            C0606f.this.E3();
        }
    }

    /* compiled from: CallDetailFragment.java */
    /* renamed from: com.android.contacts.detail.f$c */
    /* loaded from: classes.dex */
    public static class c extends com.android.contacts.util.D<Void, Void, PhoneCallDetails[], C0606f> {

        /* renamed from: b, reason: collision with root package name */
        public final CancellationSignal f14595b;

        public static /* synthetic */ boolean i(PhoneCallDetails phoneCallDetails) {
            return !C0801l.o(phoneCallDetails.f13169c);
        }

        public void e() {
            cancel(true);
            CancellationSignal cancellationSignal = this.f14595b;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
            }
        }

        @Override // com.android.contacts.util.D
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public PhoneCallDetails[] a(C0606f c0606f, Void... voidArr) {
            if (c0606f == null || !c0606f.isAdded() || c0606f.f14766o.size() <= 0) {
                return null;
            }
            c0606f.x3();
            return h(c0606f);
        }

        public final void g(C0606f c0606f, List<String> list, List<String> list2) {
            String str;
            Iterator<i0.f> it = c0606f.f14766o.iterator();
            while (it.hasNext()) {
                i0.f next = it.next();
                if (!TextUtils.isEmpty(next.f14618h)) {
                    String d10 = U7.f.d(next.f14618h);
                    if (!TextUtils.isEmpty(d10)) {
                        if (TextUtils.isEmpty(next.f14612E)) {
                            str = c0606f.f14733V;
                        } else {
                            str = next.f14612E;
                        }
                        String formatNumberToE164 = PhoneNumberUtils.formatNumberToE164(d10, str);
                        list.add(d10);
                        if (H7.a.b()) {
                            H7.b.b("CallDetailFragment", "UpdateContactDetailsTask: number = " + H7.a.d(d10));
                        }
                        if (!TextUtils.isEmpty(formatNumberToE164)) {
                            if (!list2.contains(formatNumberToE164)) {
                                list2.add(formatNumberToE164);
                                if (H7.a.b()) {
                                    H7.b.b("CallDetailFragment", "UpdateContactDetailsTask: normalizedNumber = " + H7.a.d(formatNumberToE164));
                                }
                            }
                        } else if (!list2.contains(d10)) {
                            list2.add(d10);
                        }
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final PhoneCallDetails[] h(C0606f c0606f) {
            Uri uri;
            Cursor cursor;
            String str;
            int i10;
            int i11;
            Context context = c0606f.getContext();
            Cursor cursor2 = null;
            if (context == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (isCancelled()) {
                return null;
            }
            g(c0606f, arrayList, arrayList2);
            if (arrayList.size() <= 0) {
                return null;
            }
            int i12 = 0;
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            String[] strArr2 = (String[]) arrayList2.toArray(new String[0]);
            c0606f.f14588Y0 = strArr;
            c0606f.f14587X0 = strArr2;
            String str2 = "(number IN (" + U7.f.a(strArr) + ")) OR (" + BreenoCallContract.BaseColumns.NORMALIZED_NUMBER + " IN (" + U7.f.a(strArr2) + "))";
            if (!AppMetaFeatures.b()) {
                uri = CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL;
            } else {
                uri = R0.b.f3176j;
            }
            Uri.Builder appendQueryParameter = uri.buildUpon().appendQueryParameter("limit", String.valueOf(3));
            try {
                try {
                    cursor = G7.c.f(context.getContentResolver(), appendQueryParameter.build(), MoreCallLogActivity.O1(), str2, null, "date DESC", this.f14595b);
                    if (cursor != null) {
                        try {
                            int count = cursor.getCount();
                            if (H7.a.b()) {
                                H7.b.b("CallDetailFragment", "UpdateContactDetailsTask: numCalls = " + count);
                            }
                            if (count <= 0) {
                                com.oplus.foundation.util.io.e.a(cursor);
                                return null;
                            }
                            if (count > 3) {
                                count = 3;
                            }
                            PhoneCallDetails[] phoneCallDetailsArr = new PhoneCallDetails[count];
                            cursor.moveToFirst();
                            int columnIndex = cursor.getColumnIndex("virtual_call_id");
                            int i13 = 0;
                            while (i13 < count) {
                                if (isCancelled()) {
                                    com.oplus.foundation.util.io.e.a(cursor);
                                    return null;
                                }
                                String string = cursor.getString(1);
                                String string2 = cursor.getString(8);
                                long j10 = cursor.getLong(i12);
                                long j11 = cursor.getLong(2);
                                long j12 = cursor.getLong(3);
                                int i14 = cursor.getInt(4);
                                int i15 = cursor.getInt(6);
                                int i16 = cursor.getInt(5);
                                int i17 = cursor.getInt(7);
                                if (AppMetaFeatures.b()) {
                                    str = cursor.getString(9);
                                } else {
                                    str = null;
                                }
                                if (H7.a.b()) {
                                    H7.b.b("CallDetailFragment", "UpdateContactDetailsTask: call_log_mapping is : " + str);
                                }
                                if (c0606f.f14586W0 > 1) {
                                    SubscriptionInfo subscriptionInfo = (SubscriptionInfo) c0606f.f14585V0.get(Integer.valueOf(i17));
                                    if (subscriptionInfo != null) {
                                        i11 = subscriptionInfo.getSimSlotIndex();
                                    } else {
                                        i11 = -1;
                                    }
                                    i10 = -1;
                                    phoneCallDetailsArr[i13] = new PhoneCallDetails(string, string2, i14, j11, j12, "", null, i16, j10, i17, i15, i11, str, false);
                                } else {
                                    i10 = -1;
                                    phoneCallDetailsArr[i13] = new PhoneCallDetails(string, string2, i14, j11, j12, null, null, i16, j10, -1, i15, -1, str, false);
                                }
                                if (C0801l.q(i15)) {
                                    phoneCallDetailsArr[i13].f13180n = PhoneNumberUtils.isEmergencyNumber(string);
                                }
                                if (columnIndex != i10) {
                                    phoneCallDetailsArr[i13].f13183q = cursor.getString(columnIndex);
                                }
                                if (!cursor.isLast()) {
                                    cursor.moveToNext();
                                }
                                i13++;
                                i12 = 0;
                            }
                            if (CommonFeatureOption.o(context)) {
                                c0606f.U1(count);
                            }
                            com.oplus.foundation.util.io.e.a(cursor);
                            return phoneCallDetailsArr;
                        } catch (Exception e10) {
                            e = e10;
                            H7.b.c("CallDetailFragment", "exception = " + e);
                            com.oplus.foundation.util.io.e.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = appendQueryParameter;
                    com.oplus.foundation.util.io.e.a(cursor2);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                com.oplus.foundation.util.io.e.a(cursor2);
                throw th;
            }
            com.oplus.foundation.util.io.e.a(cursor);
            return null;
        }

        @Override // com.android.contacts.util.D
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void b(C0606f c0606f, PhoneCallDetails[] phoneCallDetailsArr) {
            H7.b.e("CallDetailFragment", "UpdateContactDetailsTask: onPostExecute");
            if (c0606f == null || !c0606f.isAdded() || isCancelled()) {
                return;
            }
            boolean z10 = false;
            if (phoneCallDetailsArr == null) {
                c0606f.f14702E0 = false;
            } else {
                c0606f.f14702E0 = true;
                c0606f.f14589Z0 = phoneCallDetailsArr;
            }
            k(c0606f, phoneCallDetailsArr);
            if (c0606f.f14586W0 > 1) {
                z10 = true;
            }
            c0606f.c3(z10);
            c0606f.Q1();
            H7.b.e("CallDetailFragment", "UpdateContactDetailsTask: mHasCallLog = " + c0606f.f14702E0);
        }

        public final void k(C0606f c0606f, PhoneCallDetails[] phoneCallDetailsArr) {
            if (c0606f.f14702E0 && !c0606f.f14590a1) {
                Optional findFirst = Arrays.stream(phoneCallDetailsArr).filter(new Predicate() { // from class: com.android.contacts.detail.g
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        boolean i10;
                        i10 = C0606f.c.i((PhoneCallDetails) obj);
                        return i10;
                    }
                }).findFirst();
                if (findFirst.isPresent()) {
                    c0606f.U2(C1073b.a(((PhoneCallDetails) findFirst.get()).f13167a.toString()));
                    return;
                } else {
                    c0606f.U2(null);
                    return;
                }
            }
            c0606f.U2(null);
        }

        public c(C0606f c0606f) {
            super(c0606f);
            this.f14595b = new CancellationSignal();
        }
    }

    private void B3() {
        try {
            X.a b10 = X.a.b(requireActivity());
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.oplus.contacts.action_SIM_ABSENT");
            b10.c(this.f14592c1, intentFilter);
        } catch (Exception e10) {
            H7.b.c("CallDetailFragment", "register local broadcast error" + e10);
        }
    }

    private void C3() {
        try {
            X.a.b(requireActivity()).e(this.f14592c1);
        } catch (Exception e10) {
            H7.b.c("CallDetailFragment", "unregister local receiver error" + e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z3(String str) {
        H7.b.b("CallDetailFragment", "onCallRecordChange updateData");
        if (AppMetaFeatures.b()) {
            CallRecordingsCache.f15754a.s();
        }
        E3();
    }

    public final void A3() {
        try {
            this.f14583T0 = new b(new Handler(Looper.getMainLooper()));
            this.f14738a.getContentResolver().registerContentObserver(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, false, this.f14583T0);
        } catch (Exception e10) {
            H7.b.c("CallDetailFragment", "registerCallLogObserver " + e10);
        }
    }

    public final void D3() {
        try {
            if (this.f14583T0 != null) {
                this.f14738a.getContentResolver().unregisterContentObserver(this.f14583T0);
            }
        } catch (Exception e10) {
            H7.b.c("CallDetailFragment", "unregisterCallLogObserver " + e10);
        }
    }

    public final void E3() {
        CopyOnWriteArrayList<i0.f> copyOnWriteArrayList = this.f14766o;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            if (CommonFeatureOption.j()) {
                c cVar = this.f14591b1;
                if (cVar != null) {
                    cVar.e();
                }
                c cVar2 = new c();
                this.f14591b1 = cVar2;
                this.f14584U0.a(CallDetailActivityFragment.Tasks.UPDATE_PHONE_CALL_DETAILS, cVar2, new Void[0]);
                return;
            }
            return;
        }
        if (this.f14702E0) {
            this.f14702E0 = false;
            U2(null);
            Q1();
        }
    }

    @Override // com.android.contacts.detail.z0
    public void T1() {
        String[] strArr;
        String str;
        if (this.f14702E0 && this.f14766o != null) {
            String[] strArr2 = this.f14587X0;
            if ((strArr2 != null && strArr2.length > 0) || ((strArr = this.f14588Y0) != null && strArr.length > 0)) {
                if (getActivity() != null) {
                    str = getActivity().getResources().getString(R.string.recentCallsIconLabel);
                } else {
                    str = null;
                }
                if (!this.f14700D0) {
                    M1();
                }
                this.f14711J.add(new i0.i(str, new View.OnClickListener() { // from class: com.android.contacts.detail.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        C0606f.this.y3(view);
                    }
                }));
                PhoneCallDetails[] phoneCallDetailsArr = this.f14589Z0;
                if (phoneCallDetailsArr != null) {
                    for (PhoneCallDetails phoneCallDetails : phoneCallDetailsArr) {
                        i0.d dVar = new i0.d();
                        dVar.f14606e = "vnd.android.cursor.item/custom_calllog";
                        dVar.f14607f = phoneCallDetails;
                        this.f14713K.add(dVar);
                    }
                    w3(this.f14713K);
                }
                if (this.f14700D0) {
                    M1();
                }
            }
        }
    }

    @Override // com.android.contacts.detail.z0
    public void W2(Uri uri, ContactLoader.Result result) {
        super.W2(uri, result);
        E3();
    }

    @Override // com.android.contacts.detail.z0
    public void d3() {
        AutoCallSummaryTipManager autoCallSummaryTipManager;
        this.f14711J.clear();
        if (((Boolean) w2().first).booleanValue()) {
            this.f14711J.add(new i0.j());
        } else {
            boolean x22 = x2();
            if (H7.a.b()) {
                H7.b.b("CallDetailFragment", "isUserProfile: " + x22 + ", isSimContact: " + this.f14590a1);
            }
            if (!x22 && !this.f14590a1 && (autoCallSummaryTipManager = this.f14718M0) != null && autoCallSummaryTipManager.isShowCallSummaryTip()) {
                this.f14711J.add(new i0.e());
            }
        }
        this.f14711J.add(new i0.g());
        e3();
    }

    @Override // com.android.contacts.detail.z0, androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 888 && i11 == 20) {
            b2();
        }
    }

    @Override // com.android.contacts.detail.z0, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        Intent t12;
        super.onCreate(bundle);
        boolean z10 = true;
        Z2(true);
        try {
            if (getParentFragment() != null && (t12 = ((DetailActivityFragment) getParentFragment()).t1()) != null) {
                bundle2 = t12.getExtras();
            } else {
                bundle2 = null;
            }
            if (bundle2 != null) {
                if (bundle2.getParcelable("sim_contacts_info") == null) {
                    z10 = false;
                }
                this.f14590a1 = z10;
            }
        } catch (Exception e10) {
            H7.b.b("CallDetailFragment", "number not exit" + e10);
        }
        A3();
        B3();
        this.f14694A0.I0(new RecordPlayerPresenter.a() { // from class: com.android.contacts.detail.d
            @Override // com.customize.contacts.mediaplayer.RecordPlayerPresenter.a
            public final void a(String str) {
                C0606f.this.z3(str);
            }
        });
    }

    @Override // com.android.contacts.detail.z0, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.f14591b1;
        if (cVar != null) {
            cVar.e();
        }
        D3();
        C3();
    }

    @Override // com.android.contacts.detail.z0, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        C0799j.c(F7.b.e(this.f14738a));
        C0799j.d(DateFormat.getTimeFormat(this.f14738a));
        E3();
    }

    public final void w3(ArrayList<i0.d> arrayList) {
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f14711J.add(arrayList.get(i10));
        }
        arrayList.clear();
    }

    public final void x3() {
        int size;
        if (B3.a.i()) {
            List<SubscriptionInfo> e10 = com.customize.contacts.util.b0.e(this.f14738a);
            if (e10.isEmpty()) {
                size = 0;
            } else {
                size = e10.size();
            }
            this.f14586W0 = size;
            H7.b.h("CallDetailFragment", "getInsertedSimInfoList(): mSimCount = " + this.f14586W0);
            if (this.f14586W0 > 1) {
                this.f14585V0.clear();
                for (int i10 = 0; i10 < e10.size(); i10++) {
                    SubscriptionInfo subscriptionInfo = e10.get(i10);
                    this.f14585V0.put(Integer.valueOf(subscriptionInfo.getSubscriptionId()), subscriptionInfo);
                }
                return;
            }
            return;
        }
        this.f14586W0 = com.customize.contacts.util.b0.T(this.f14738a) ? 1 : 0;
        H7.b.h("CallDetailFragment", "getInsertedSimInfoList(): mSimCount = " + this.f14586W0);
    }

    public final /* synthetic */ void y3(View view) {
        com.customize.contacts.util.h0.d(this.f14738a, "click_item", "all");
        S7.b.b(this, i0.o(this.f14738a, this.f14588Y0, this.f14587X0), 888, R.string.activity_not_found);
    }
}
