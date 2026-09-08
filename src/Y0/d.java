package y0;

import a4.C0421a;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.ContactsApplication;
import com.android.contacts.calllog.I;
import com.android.contacts.detail.CallDetailUnfamiliarNumberFragment;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.framework.baseui.util.LocationUtils;
import com.android.contacts.util.D;
import com.android.incallui.OplusNumberMarkUtils;
import com.android.incallui.OplusPhoneCapabilities;
import com.customize.contacts.util.BlackListUtils;
import com.customize.contacts.util.C0797h;
import com.customize.contacts.util.C0802m;
import com.customize.contacts.util.b0;
import com.customize.contacts.util.h0;
import com.customize.contacts.util.k0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CallPresenter.java */
/* loaded from: classes.dex */
public class d implements InterfaceC1700b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f38108a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public c f38109b;

    /* renamed from: c, reason: collision with root package name */
    public I f38110c;

    /* compiled from: CallPresenter.java */
    /* loaded from: classes.dex */
    public class a extends D<Void, Void, String, CallDetailUnfamiliarNumberFragment> {

        /* renamed from: b, reason: collision with root package name */
        public String f38111b;

        /* renamed from: c, reason: collision with root package name */
        public String f38112c;

        /* renamed from: d, reason: collision with root package name */
        public int f38113d;

        /* renamed from: e, reason: collision with root package name */
        public int f38114e;

        /* renamed from: f, reason: collision with root package name */
        public InterfaceC1699a f38115f;

        public a(String str, String str2, int i10, int i11, InterfaceC1699a interfaceC1699a, CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment) {
            super(callDetailUnfamiliarNumberFragment);
            this.f38111b = str;
            this.f38112c = str2;
            this.f38115f = interfaceC1699a;
            this.f38113d = i10;
            this.f38114e = i11;
        }

        @Override // com.android.contacts.util.D
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment, Void... voidArr) {
            if (callDetailUnfamiliarNumberFragment != null && callDetailUnfamiliarNumberFragment.isAdded()) {
                try {
                    String r10 = d.this.r(ContactsApplication.h(), this.f38111b, this.f38112c, this.f38113d, this.f38114e);
                    synchronized (d.this.f38108a) {
                        d.this.f38108a.notifyAll();
                    }
                    return r10;
                } catch (Throwable th) {
                    synchronized (d.this.f38108a) {
                        d.this.f38108a.notifyAll();
                        throw th;
                    }
                }
            }
            return "";
        }

        @Override // com.android.contacts.util.D
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment, String str) {
            if (callDetailUnfamiliarNumberFragment != null && callDetailUnfamiliarNumberFragment.isAdded()) {
                this.f38115f.a(str);
            }
        }
    }

    /* compiled from: CallPresenter.java */
    /* loaded from: classes.dex */
    public class b extends D<Void, Void, Map<String, Boolean>, CallDetailUnfamiliarNumberFragment> {

        /* renamed from: b, reason: collision with root package name */
        public String f38117b;

        public b(String str, CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment) {
            super(callDetailUnfamiliarNumberFragment);
            this.f38117b = str;
        }

        @Override // com.android.contacts.util.D
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public HashMap<String, Boolean> a(CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment, Void... voidArr) {
            if (callDetailUnfamiliarNumberFragment == null || !callDetailUnfamiliarNumberFragment.isAdded() || TextUtils.isEmpty(this.f38117b)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f38117b);
            return BlackListUtils.d(callDetailUnfamiliarNumberFragment.getActivity(), arrayList);
        }

        public void e() {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }

        @Override // com.android.contacts.util.D
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment, Map<String, Boolean> map) {
            if (callDetailUnfamiliarNumberFragment != null && callDetailUnfamiliarNumberFragment.isAdded() && map != null) {
                boolean booleanValue = map.get("isBlackList").booleanValue();
                boolean booleanValue2 = map.get("isWhiteList").booleanValue();
                if (H7.a.b()) {
                    H7.b.b("CallPresenter", "isAddedInBlackList = " + booleanValue + ", isAddedInWhiteList = " + booleanValue2);
                }
                d.this.f38109b.B0(booleanValue, booleanValue2);
            }
        }
    }

    public d(c cVar, I i10) {
        this.f38109b = cVar;
        this.f38110c = i10;
        cVar.d0(this);
    }

    @Override // y0.InterfaceC1700b
    public void a(String str) {
        q(str, false, false);
    }

    @Override // y0.InterfaceC1700b
    public void b(String str, CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment) {
        new b(str, callDetailUnfamiliarNumberFragment).e();
    }

    @Override // y0.InterfaceC1700b
    public void c(String str) {
        q(str, true, false);
    }

    @Override // y0.InterfaceC1700b
    public void d(String str, String str2, Context context) {
        if (str != null) {
            Intent intent = new Intent(C0421a.f6395a, this.f38110c.c(str));
            intent.putExtra("countryiso", str2);
            intent.putExtra("dialer_from", "detail");
            C0802m.a(context, intent);
        } else {
            H7.b.b("CallPresenter", "the number is null ,we will not place the call,it is meaningless ");
        }
        A.a(ContactsApplication.h(), 2000305, 200030061, h0.b0(context), false);
    }

    @Override // y0.InterfaceC1700b
    public void e(String str) {
        if (I.b(str)) {
            if (!TextUtils.isEmpty(str) && (str.startsWith("*72") || str.startsWith("*90") || str.startsWith("*92") || str.startsWith("*68") || str.startsWith("*74"))) {
                str = str.substring(3);
            }
            this.f38109b.L0(new Intent("android.intent.action.SENDTO", Uri.fromParts("sms", str, null)));
            return;
        }
        this.f38109b.L0(new Intent("android.intent.action.SENDTO", Uri.fromParts("sms", str, null)));
    }

    @Override // y0.InterfaceC1700b
    public void f(int i10, String str, String str2) {
        Intent intent = new Intent(k0.f22137a, ContactsContract.Contacts.CONTENT_URI);
        intent.putExtra("email", str);
        intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, str2);
        intent.putExtra("from_sms", true);
        intent.putExtra("destroy_previous_activity", true);
        intent.setFlags(OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE);
        this.f38109b.f(i10, intent);
        A.a(ContactsApplication.h(), 2000310, 200030063, null, false);
    }

    @Override // y0.InterfaceC1700b
    public void g(String str, String str2, int i10, int i11, CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment, InterfaceC1699a interfaceC1699a) {
        C0797h.a(ContactsApplication.h(), new a(str, str2, i10, i11, interfaceC1699a, callDetailUnfamiliarNumberFragment), this.f38108a);
    }

    @Override // y0.InterfaceC1700b
    public void h(String str) {
        q(str, true, true);
    }

    @Override // y0.InterfaceC1700b
    public void i(int i10, String str, String str2, String str3) {
        Intent intent = new Intent(k0.f22137a, ContactsContract.Contacts.CONTENT_URI);
        intent.putExtra("phone", str);
        intent.putExtra("name", str2);
        intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, str3);
        intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_CONTACTS_FLAG_UNFAMILIAR_NUMBER, str);
        intent.putExtra("destroy_previous_activity", true);
        intent.setFlags(OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE);
        if (C0637b.h()) {
            intent.putExtra("edit_page_start_source", 3);
        }
        this.f38109b.f(i10, intent);
        A.a(ContactsApplication.h(), 2000310, 200030063, null, false);
    }

    @Override // y0.InterfaceC1700b
    public void j(int i10, String str) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
        intent.setType("vnd.android.cursor.item/contact");
        intent.putExtra("email", str);
        intent.putExtra("destroy_previous_activity", true);
        intent.putExtra("from_sms", true);
        intent.putExtra(R0.c.f3183a, true);
        intent.setFlags(OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE);
        this.f38109b.f(i10, intent);
    }

    @Override // y0.InterfaceC1700b
    public void k(String str) {
        q(str, false, true);
    }

    @Override // y0.InterfaceC1700b
    public void l(String str) {
        this.f38109b.L0(new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", str, null)));
    }

    @Override // y0.InterfaceC1700b
    public void m(String str, String str2, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(C0421a.f6395a, Uri.fromParts("tel", str, null));
        intent.putExtra("android.telecom.extra.START_CALL_WITH_VIDEO_STATE", 3);
        intent.putExtra("countryiso", str2);
        intent.putExtra("dialer_from", "detail");
        C0802m.a(context, intent);
        A.a(ContactsApplication.h(), 2000319, 200030175, h0.b0(context), false);
    }

    @Override // y0.InterfaceC1700b
    public void n(int i10, String str) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
        intent.setType("vnd.android.cursor.item/contact");
        intent.putExtra("phone", str);
        intent.putExtra("destroy_previous_activity", true);
        intent.putExtra(R0.c.f3183a, true);
        intent.setFlags(OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE);
        if (C0637b.h()) {
            intent.putExtra("edit_page_start_source", 3);
        }
        this.f38109b.f(i10, intent);
    }

    public final void q(String str, boolean z10, boolean z11) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (z10) {
            BlackListUtils.o(P7.a.f2962b, 0L, arrayList, z11, false, false);
        } else {
            BlackListUtils.p(P7.a.f2962b, 0L, arrayList, z11, false);
        }
    }

    public String r(Context context, String str, String str2, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return LocationUtils.j(context, str, str2, i11, b0.e0(context, i10));
    }
}
