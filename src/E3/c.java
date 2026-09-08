package E3;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.CheckBox;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.ViewOnClickListenerC0694u0;
import com.android.contacts.detail.CallLogDeleteHelper;
import com.android.contacts.detail.D;
import com.customize.contacts.util.C0797h;
import com.customize.contacts.util.C0807s;
import com.oplus.dialer.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/* compiled from: ActionModeHandler.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public boolean f524a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f525b = -1;

    /* renamed from: c, reason: collision with root package name */
    public final ViewOnClickListenerC0694u0 f526c;

    /* renamed from: d, reason: collision with root package name */
    public final com.android.contacts.calllog.k f527d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f528e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f529f;

    /* renamed from: g, reason: collision with root package name */
    public Cursor f530g;

    /* renamed from: h, reason: collision with root package name */
    public final HashMap<String, CheckBox> f531h;

    /* renamed from: i, reason: collision with root package name */
    public Dialog f532i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f533j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f534k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.appcompat.app.b f535l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f536m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f537n;

    /* renamed from: o, reason: collision with root package name */
    public int f538o;

    /* renamed from: p, reason: collision with root package name */
    public final Z3.h f539p;

    /* renamed from: q, reason: collision with root package name */
    public b f540q;

    /* renamed from: r, reason: collision with root package name */
    public final Map<String, Long> f541r;

    /* renamed from: s, reason: collision with root package name */
    public final ArrayList<Q0.b> f542s;

    /* compiled from: ActionModeHandler.java */
    /* loaded from: classes3.dex */
    public class a implements CallLogDeleteHelper.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f543a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f544b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f545c;

        public a(boolean z10, ArrayList arrayList, int i10) {
            this.f543a = z10;
            this.f544b = arrayList;
            this.f545c = i10;
        }

        @Override // com.android.contacts.detail.CallLogDeleteHelper.a
        public void a(Dialog dialog) {
            c.this.f532i = dialog;
            U0.n.b(c.this.f532i);
        }

        @Override // com.android.contacts.detail.CallLogDeleteHelper.a
        public void onClick(int i10, boolean z10) {
            int i11;
            if (this.f543a) {
                try {
                    Intent b10 = C0807s.b(c.this.f526c.getActivity());
                    if (b10 != null) {
                        ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = c.this.f526c;
                        if (z10) {
                            i11 = -1;
                        } else {
                            i11 = 1;
                        }
                        if (S7.b.b(viewOnClickListenerC0694u0, b10, i11, 0)) {
                            c.this.f542s.clear();
                            c.this.f542s.addAll(this.f544b);
                            c.this.f526c.S6(true);
                            return;
                        }
                        H7.b.i("ActionModeHandler", "start unlock activity failed!");
                    }
                } catch (Exception e10) {
                    H7.b.c("ActionModeHandler", "start to unlock exception: " + e10);
                }
            }
            c.this.s(this.f545c, z10, this.f544b);
            c.this.f527d.T1(true);
        }
    }

    /* compiled from: ActionModeHandler.java */
    /* loaded from: classes3.dex */
    public class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList<Q0.b> f547a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f548b;

        /* renamed from: c, reason: collision with root package name */
        public final ComponentActivity f549c;

        public b(ComponentActivity componentActivity, ArrayList<Q0.b> arrayList, boolean z10) {
            ArrayList<Q0.b> arrayList2 = new ArrayList<>();
            this.f547a = arrayList2;
            this.f548b = z10;
            this.f549c = componentActivity;
            arrayList2.addAll(arrayList);
            c.this.f525b = arrayList2.size();
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            try {
                try {
                    c cVar = c.this;
                    c.this.f526c.P3(CallLogDeleteHelper.f(this.f549c, this.f547a, this.f548b, new D(1, 2, cVar.u(cVar.f541r)), null));
                    c.this.f534k = true;
                    synchronized (c.this.f533j) {
                        c.this.f533j.notifyAll();
                    }
                } catch (Exception e10) {
                    H7.b.c("ActionModeHandler", "delete call log Exception: " + e10);
                    c.this.f534k = true;
                    synchronized (c.this.f533j) {
                        c.this.f533j.notifyAll();
                    }
                }
                c.this.f541r.clear();
                return null;
            } catch (Throwable th) {
                c.this.f534k = true;
                synchronized (c.this.f533j) {
                    c.this.f533j.notifyAll();
                    throw th;
                }
            }
        }

        public boolean b() {
            return c.this.f524a;
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r22) {
            if (c.this.f535l != null && c.this.f535l.isShowing()) {
                c.this.f535l.dismiss();
                c.this.f535l = null;
            }
            c.this.f524a = false;
            if (c.this.f527d != null) {
                c.this.f527d.K0();
                c.this.f527d.T1(false);
                c.this.f527d.F1(true);
                c.this.f527d.E();
            }
            B3.c.d().h();
            c.this.f526c.u1();
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            super.onCancelled();
            c.this.f524a = false;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            c.this.f524a = true;
        }
    }

    public c(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0, com.android.contacts.calllog.k kVar, Z3.h hVar) {
        HashMap<String, CheckBox> hashMap = new HashMap<>();
        this.f531h = hashMap;
        this.f532i = null;
        this.f533j = new Object();
        this.f534k = false;
        this.f535l = null;
        this.f536m = false;
        this.f537n = true;
        this.f540q = null;
        this.f541r = new HashMap();
        this.f542s = new ArrayList<>();
        if (viewOnClickListenerC0694u0 != null && kVar != null) {
            this.f526c = viewOnClickListenerC0694u0;
            this.f527d = kVar;
            kVar.C1(hashMap);
            this.f539p = hVar;
            return;
        }
        throw new IllegalArgumentException("ActionModeHandler() parameters can not be null!");
    }

    public boolean A() {
        return this.f528e;
    }

    public boolean B() {
        return this.f536m;
    }

    public final /* synthetic */ void C(String str, String str2, String str3, int i10, Q0.d dVar) {
        long a10 = dVar.a();
        String a11 = com.android.contacts.framework.baseui.calllog.c.a(str, str2, str3);
        if (i10 == 1) {
            this.f531h.put(a11, null);
            if (!this.f541r.containsKey(a11)) {
                this.f541r.put(a11, Long.valueOf(a10));
                return;
            }
            return;
        }
        this.f531h.remove(a11);
        this.f541r.remove(a11);
    }

    public final /* synthetic */ void D(final int i10, Q0.b bVar) {
        final String d10 = bVar.d();
        final String c10 = bVar.c();
        final String b10 = bVar.b();
        bVar.a().forEach(new Consumer() { // from class: E3.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                c.this.C(d10, c10, b10, i10, (Q0.d) obj);
            }
        });
    }

    public void E() {
        try {
            if (this.f536m) {
                G(2);
            } else {
                G(1);
            }
        } catch (Exception unused) {
        }
        if (this.f528e) {
            I();
        }
    }

    public void F() {
        if (this.f528e) {
            this.f531h.clear();
            this.f541r.clear();
            com.android.contacts.calllog.k kVar = this.f527d;
            if (kVar != null) {
                kVar.G1(false);
                this.f527d.notifyDataSetChanged();
            }
        }
        this.f528e = false;
        boolean Y42 = this.f526c.Y4();
        H7.b.b("ActionModeHandler", "isCallLogIntent = " + Y42);
        if (!Y42) {
            this.f526c.u7();
            if (!this.f537n) {
                this.f526c.n7();
            }
            this.f526c.o7();
        } else {
            this.f526c.n7();
        }
        Dialog dialog = this.f532i;
        if (dialog != null) {
            dialog.dismiss();
            this.f532i = null;
        }
        this.f539p.c();
        this.f536m = false;
    }

    public void G(final int i10) {
        List<Q0.b> o10;
        Cursor q10 = this.f527d.q();
        this.f530g = q10;
        if (q10 == null) {
            H7.b.e("ActionModeHandler", "setCheckBoxState mCheckBoxState is null or mCursor is null");
            return;
        }
        if (i10 == 1 || i10 == 2) {
            if (this.f527d.A()) {
                o10 = this.f527d.v();
            } else {
                o10 = this.f527d.o();
            }
            o10.forEach(new Consumer() { // from class: E3.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    c.this.D(i10, (Q0.b) obj);
                }
            });
        }
        if (this.f527d.w()) {
            H7.b.b("ActionModeHandler", "setCheckBoxState isAnimating and need to notifyChange after animation");
            this.f527d.L1(true);
        } else {
            this.f527d.notifyDataSetChanged();
        }
    }

    public void H(boolean z10) {
        this.f537n = z10;
    }

    public void I() {
        H7.b.b("ActionModeHandler", "updateActionBar---");
        int w10 = w();
        this.f538o = 0;
        this.f530g = this.f527d.q();
        this.f538o = this.f527d.getItemCount();
        if (H7.a.b()) {
            H7.b.b("ActionModeHandler", "updateActionBar---mAdapter: " + this.f527d + ", mTotalCount = " + this.f538o);
        }
        if (w10 == this.f538o) {
            this.f536m = true;
        } else {
            this.f536m = false;
        }
        H7.b.b("ActionModeHandler", "updateActionBar---mIsFirstUpdate: " + this.f529f + ", mIsMarkAll = " + this.f536m);
        this.f539p.d();
        q(w10);
    }

    public void J(Cursor cursor) {
        if (H7.a.b()) {
            H7.b.b("ActionModeHandler", "updateMarkState ------");
        }
        try {
            if (!this.f524a && cursor != null) {
                int position = cursor.getPosition();
                cursor.moveToPosition(-1);
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                while (cursor.moveToNext()) {
                    String string = cursor.getString(1);
                    String string2 = cursor.getString(9);
                    String string3 = cursor.getString(16);
                    long j10 = cursor.getLong(2);
                    String a10 = com.android.contacts.framework.baseui.calllog.c.a(string, string2, string3);
                    if (this.f531h.containsKey(a10)) {
                        hashMap.put(a10, this.f531h.get(a10));
                        if (!hashMap2.containsKey(a10)) {
                            hashMap2.put(a10, Long.valueOf(j10));
                        }
                    }
                }
                this.f531h.clear();
                this.f531h.putAll(hashMap);
                this.f541r.clear();
                this.f541r.putAll(hashMap2);
                cursor.moveToPosition(position);
            } else {
                this.f531h.clear();
                this.f541r.clear();
            }
            I();
        } catch (Exception e10) {
            H7.b.c("ActionModeHandler", "updateMarkState e = " + e10);
        }
    }

    public final void q(int i10) {
        H7.b.b("ActionModeHandler", "changeMenuBarStatus:: selectedCount: " + i10);
        if (i10 == 0) {
            this.f526c.p8(false);
        } else {
            this.f526c.p8(true);
        }
    }

    public void r(int i10, boolean z10) {
        s(i10, z10, this.f542s);
        this.f542s.clear();
    }

    public final void s(int i10, boolean z10, ArrayList<Q0.b> arrayList) {
        if (arrayList.isEmpty()) {
            H7.b.c("ActionModeHandler", "deleteCallLog: call logs is empty!");
            return;
        }
        FragmentActivity activity = this.f526c.getActivity();
        if (activity != null) {
            b bVar = this.f540q;
            if (bVar == null || !bVar.b()) {
                this.f534k = false;
                b bVar2 = new b(activity, arrayList, z10);
                this.f540q = bVar2;
                C0797h.a(null, bVar2, this.f533j);
                if (!this.f534k) {
                    this.f535l = U0.k.o(activity, activity.getString(R.string.mark_more_delete));
                }
            }
        }
    }

    public void t() {
        H7.b.b("ActionModeHandler", "enterActionMode");
        this.f528e = true;
        this.f529f = true;
        this.f539p.b();
        if (this.f527d != null) {
            H7.b.b("ActionModeHandler", "notifyDataSetChanged");
            this.f527d.notifyDataSetChanged();
        }
    }

    public String u(Map<String, Long> map) {
        Collection<Long> values = map.values();
        if (values.size() > 0) {
            Long[] lArr = (Long[]) map.values().toArray(new Long[values.size()]);
            Arrays.sort(lArr);
            StringBuilder sb = new StringBuilder();
            SimpleDateFormat simpleDateFormat = F7.b.f1009g;
            sb.append(simpleDateFormat.format(new Date(lArr[0].longValue())));
            sb.append("-");
            sb.append(simpleDateFormat.format(new Date(lArr[lArr.length - 1].longValue())));
            return sb.toString();
        }
        return "null";
    }

    public String v() {
        int w10 = w();
        ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = this.f526c;
        if (w10 == 0) {
            return viewOnClickListenerC0694u0.getString(R.string.select_item);
        }
        return viewOnClickListenerC0694u0.getString(R.string.select_items, Integer.valueOf(w10));
    }

    public final int w() {
        if (this.f524a) {
            return this.f525b;
        }
        return this.f531h.size();
    }

    public Map<String, Long> x() {
        return this.f541r;
    }

    public final int y() {
        return this.f538o;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (r6 != 1) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void z() {
        /*
            r13 = this;
            com.android.contacts.u0 r0 = r13.f526c
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
            boolean r1 = com.customize.contacts.util.C0792c.c(r0)
            java.lang.String r2 = "ActionModeHandler"
            if (r1 != 0) goto L14
            java.lang.String r13 = "handleDeleteCallLog: activity is not alive!"
            H7.b.i(r2, r13)
            return
        L14:
            java.util.HashMap<java.lang.String, android.widget.CheckBox> r1 = r13.f531h
            java.util.Set r1 = r1.keySet()
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L26
            java.lang.String r13 = "handleDeleteCallLog: no selected items!"
            H7.b.i(r2, r13)
            return
        L26:
            long r3 = java.lang.System.currentTimeMillis()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r1 = r1.iterator()
        L33:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L4b
            java.lang.Object r6 = r1.next()
            java.lang.String r6 = (java.lang.String) r6
            com.android.contacts.calllog.k r7 = r13.f527d
            Q0.b r6 = r7.p(r6)
            if (r6 == 0) goto L33
            r5.add(r6)
            goto L33
        L4b:
            java.util.HashMap<java.lang.String, android.widget.CheckBox> r1 = r13.f531h
            int r1 = r1.size()
            int r6 = r13.y()
            int r7 = r5.size()
            if (r1 != r6) goto L5f
            r8 = 1
            if (r6 == r8) goto L5f
            goto L60
        L5f:
            r8 = 0
        L60:
            long r9 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "handleDeleteCallLog: marked: "
            r11.append(r12)
            r11.append(r1)
            java.lang.String r12 = ", total: "
            r11.append(r12)
            r11.append(r6)
            java.lang.String r12 = ", count: "
            r11.append(r12)
            r11.append(r7)
            java.lang.String r12 = ", select all: "
            r11.append(r12)
            r11.append(r8)
            java.lang.String r12 = ", take: "
            r11.append(r12)
            long r9 = r9 - r3
            r11.append(r9)
            java.lang.String r3 = r11.toString()
            H7.b.e(r2, r3)
            if (r7 != 0) goto L9c
            return
        L9c:
            E3.c$a r2 = new E3.c$a
            r2.<init>(r8, r5, r6)
            com.android.contacts.detail.CallLogDeleteHelper.h(r0, r5, r1, r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: E3.c.z():void");
    }
}
