package com.customize.contacts.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.android.contacts.ContactSaveService;
import com.android.contacts.detail.i0;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import com.android.contacts.framework.baseui.util.q;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.customize.contacts.util.h0;
import com.customize.contacts.widget.i;
import com.oplus.dialer.R;
import java.util.ArrayList;

/* compiled from: DetailPopupWindowHelper.java */
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final Context f22578a;

    /* renamed from: b, reason: collision with root package name */
    public COUIPopupListWindow f22579b;

    /* renamed from: c, reason: collision with root package name */
    public View f22580c;

    /* renamed from: g, reason: collision with root package name */
    public boolean f22584g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f22585h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f22586i;

    /* renamed from: j, reason: collision with root package name */
    public SimContactInfo f22587j;

    /* renamed from: o, reason: collision with root package name */
    public a f22592o;

    /* renamed from: d, reason: collision with root package name */
    public long f22581d = -1;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<String> f22582e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<String> f22583f = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    public i0.f f22588k = null;

    /* renamed from: l, reason: collision with root package name */
    public boolean f22589l = false;

    /* renamed from: m, reason: collision with root package name */
    public int f22590m = -1;

    /* renamed from: n, reason: collision with root package name */
    public boolean f22591n = false;

    /* compiled from: DetailPopupWindowHelper.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a(b bVar);
    }

    /* compiled from: DetailPopupWindowHelper.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f22593a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22594b;

        public b(int i10, int i11) {
            this.f22593a = i10;
            this.f22594b = i11;
        }
    }

    public i(Context context) {
        this.f22592o = null;
        this.f22578a = context;
        this.f22592o = new a() { // from class: com.customize.contacts.widget.g
            @Override // com.customize.contacts.widget.i.a
            public final void a(i.b bVar) {
                i.this.j(bVar);
            }
        };
    }

    public static /* synthetic */ void k(ArrayList arrayList, a aVar, COUIPopupListWindow cOUIPopupListWindow, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 >= 0 && i10 < arrayList.size()) {
            aVar.a((b) arrayList.get(i10));
        }
        cOUIPopupListWindow.dismiss();
    }

    public static COUIPopupListWindow w(View view, int i10, int i11, final ArrayList<b> arrayList, final a aVar, boolean z10) {
        int i12;
        Object parent;
        view.performHapticFeedback(0);
        ArrayList arrayList2 = new ArrayList();
        Context context = view.getContext();
        final COUIPopupListWindow cOUIPopupListWindow = new COUIPopupListWindow(context);
        if (z10 && (parent = view.getParent()) != null) {
            View view2 = (View) parent;
            i12 = view.getTop();
            view = view2;
        } else {
            i12 = 0;
        }
        cOUIPopupListWindow.setAnchorView(view);
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            arrayList2.add(q.a(context.getString(arrayList.get(i13).f22594b)));
        }
        cOUIPopupListWindow.setItemList(arrayList2);
        cOUIPopupListWindow.setDismissTouchOutside(true);
        if (aVar != null) {
            cOUIPopupListWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.customize.contacts.widget.h
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view3, int i14, long j10) {
                    i.k(arrayList, aVar, cOUIPopupListWindow, adapterView, view3, i14, j10);
                }
            });
        }
        cOUIPopupListWindow.show(view, i10, i12 + i11);
        return cOUIPopupListWindow;
    }

    public final void c(ArrayList<String> arrayList) {
        this.f22578a.startService(ContactSaveService.h(this.f22578a, arrayList, this.f22591n));
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(int r9) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.widget.i.d(int):void");
    }

    public ArrayList<b> e() {
        boolean z10;
        ArrayList<b> arrayList = new ArrayList<>();
        i0.f fVar = (i0.f) this.f22580c.getTag();
        this.f22588k = fVar;
        String str = fVar.f14621k;
        if ("vnd.android.cursor.item/phone_v2".equals(str)) {
            z10 = this.f22585h;
        } else if ("vnd.android.cursor.item/email_v2".equals(str)) {
            z10 = this.f22586i;
        } else {
            z10 = true;
        }
        if (H7.a.b()) {
            H7.b.b("DetailPopupWindowHelper", "mIsUniqueNumber = " + this.f22585h + " ,mIsUniqueEmail = " + this.f22586i + " ,selectedMimeType = " + str);
        }
        if (this.f22588k.f14626p) {
            if ("vnd.android.cursor.item/phone_v2".equals(str) && this.f22587j == null && !this.f22589l) {
                arrayList.add(new b(R.id.set_default_number_or_email, R.string.context_menu_cancel_default_phone));
            } else if ("vnd.android.cursor.item/email_v2".equals(str)) {
                arrayList.add(new b(R.id.set_default_number_or_email, R.string.context_menu_cancel_default_email));
            }
        } else if (!z10) {
            if ("vnd.android.cursor.item/phone_v2".equals(str) && this.f22587j == null && !this.f22589l) {
                arrayList.add(new b(R.id.set_default_number_or_email, R.string.context_menu_make_default_phone));
            } else if ("vnd.android.cursor.item/email_v2".equals(str)) {
                arrayList.add(new b(R.id.set_default_number_or_email, R.string.context_menu_make_default_email));
            }
        }
        arrayList.add(new b(R.id.copy_text, R.string.copy_text));
        return arrayList;
    }

    public final String f() {
        i0.f fVar = this.f22588k;
        if (fVar == null) {
            return null;
        }
        String str = fVar.f14618h;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("vnd.android.cursor.item/phone_v2".equals(this.f22588k.f14621k)) {
            return U7.f.g(str.toString());
        }
        return str.toString();
    }

    public final String g() {
        i0.f fVar = this.f22588k;
        if (fVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(fVar.f14617g)) {
            return "phoneNumber";
        }
        return this.f22588k.f14617g;
    }

    public void h() {
        COUIPopupListWindow cOUIPopupListWindow = this.f22579b;
        if (cOUIPopupListWindow != null) {
            cOUIPopupListWindow.dismiss();
        }
    }

    public boolean i() {
        COUIPopupListWindow cOUIPopupListWindow = this.f22579b;
        if (cOUIPopupListWindow != null) {
            return cOUIPopupListWindow.isShowing();
        }
        return false;
    }

    public final /* synthetic */ void j(b bVar) {
        d(bVar.f22593a);
    }

    public void l(long j10) {
        this.f22581d = j10;
    }

    public final void m(long j10) {
        this.f22578a.startService(ContactSaveService.l(this.f22578a, j10));
    }

    public void n(ArrayList<String> arrayList) {
        this.f22583f = arrayList;
    }

    public void o(ArrayList<String> arrayList) {
        this.f22582e = arrayList;
    }

    public void p(boolean z10) {
        this.f22586i = z10;
    }

    public void q(boolean z10) {
        this.f22585h = z10;
    }

    public void r(boolean z10) {
        this.f22591n = z10;
    }

    public void s(SimContactInfo simContactInfo) {
        this.f22587j = simContactInfo;
    }

    public void t(boolean z10) {
        this.f22589l = z10;
    }

    public void u(int i10) {
        this.f22590m = i10;
    }

    public void v(View view, int i10, int i11, boolean z10) {
        ArrayList<b> e10;
        i0.f fVar = this.f22588k;
        if (fVar != null) {
            if ("vnd.android.cursor.item/phone_v2".equals(fVar.f14621k)) {
                h0.u(this.f22578a, "number");
            } else if ("vnd.android.cursor.item/email_v2".equals(this.f22588k.f14621k)) {
                h0.u(this.f22578a, "email");
            }
        }
        if (z10) {
            e10 = new ArrayList<>();
            e10.add(new b(R.id.copy_text, R.string.copy_text));
        } else {
            e10 = e();
        }
        ArrayList<b> arrayList = e10;
        this.f22584g = z10;
        h();
        this.f22579b = w(view, i10, i11, arrayList, this.f22592o, false);
    }

    public void x(View view) {
        this.f22580c = view;
    }
}
