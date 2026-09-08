package com.ted.number.ui;

import U0.h;
import android.app.Activity;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import com.android.contacts.framework.baseui.util.A;
import com.coui.appcompat.edittext.COUIEditText;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.widget.p;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: MarkDialogManager.java */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f29807a;

    /* renamed from: b, reason: collision with root package name */
    public int f29808b;

    /* renamed from: c, reason: collision with root package name */
    public c f29809c;

    /* renamed from: d, reason: collision with root package name */
    public List<String> f29810d;

    /* renamed from: e, reason: collision with root package name */
    public List<String> f29811e;

    /* renamed from: f, reason: collision with root package name */
    public String f29812f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f29813g;

    /* compiled from: MarkDialogManager.java */
    /* renamed from: com.ted.number.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class AsyncTaskC0287a extends AsyncTask<String, Integer, List<String>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f29814a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f29815b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f29816c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f29817d;

        /* compiled from: MarkDialogManager.java */
        /* renamed from: com.ted.number.ui.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0288a implements p.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f29819a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p f29820b;

            public C0288a(List list, p pVar) {
                this.f29819a = list;
                this.f29820b = pVar;
            }

            @Override // com.customize.contacts.widget.p.a
            public void a(Object obj) {
                String str;
                Integer num = (Integer) obj;
                int intValue = num.intValue();
                if (intValue == this.f29819a.size() - 1) {
                    p pVar = this.f29820b;
                    pVar.l(a.this.m(pVar));
                } else if (a.this.f29811e != null && intValue >= 0 && intValue < a.this.f29811e.size()) {
                    AsyncTaskC0287a asyncTaskC0287a = AsyncTaskC0287a.this;
                    if (asyncTaskC0287a.f29817d) {
                        c cVar = a.this.f29809c;
                        String str2 = (String) a.this.f29811e.get(intValue);
                        if (intValue == 0) {
                            str = null;
                        } else {
                            str = (String) this.f29819a.get(intValue);
                        }
                        cVar.c(str2, str, 0);
                    } else {
                        a.this.f29809c.b((String) a.this.f29811e.get(intValue), 0);
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put("old_mark", Integer.valueOf(a.this.f29808b));
                hashMap.put("new_mark", num);
                A.a(a.this.f29807a, 2000318, 200030200, hashMap, false);
            }

            @Override // com.customize.contacts.widget.p.a
            public void b() {
                a.this.f29809c.a();
            }

            @Override // com.customize.contacts.widget.p.a
            public void c() {
                p pVar = this.f29820b;
                pVar.l(a.this.m(pVar));
                HashMap hashMap = new HashMap();
                hashMap.put("old_mark", Integer.valueOf(a.this.f29808b));
                hashMap.put("new_mark", -1);
                A.a(a.this.f29807a, 2000318, 200030200, hashMap, false);
            }
        }

        public AsyncTaskC0287a(int i10, String str, boolean z10, boolean z11) {
            this.f29814a = i10;
            this.f29815b = str;
            this.f29816c = z10;
            this.f29817d = z11;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<String> doInBackground(String... strArr) {
            int i10;
            String str;
            int i11;
            int i12;
            if (a.this.f29811e == null) {
                a.this.f29811e = new ArrayList();
            }
            a.this.f29811e.clear();
            List<String> g10 = E0.b.g();
            ArrayList arrayList = new ArrayList();
            String[] v10 = E0.b.v(a.this.f29807a);
            String[] stringArray = a.this.f29807a.getResources().getStringArray(R.array.ted_classic_cn_marks);
            if (g10 != null) {
                boolean z10 = -1;
                for (String str2 : g10) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            i12 = Integer.parseInt(str2);
                        } catch (NumberFormatException unused) {
                            i12 = -1;
                        }
                        if (i12 == 0) {
                            z10 = false;
                        }
                        if (i12 >= 0 && i12 < v10.length && (!FeatureOption.i() || i12 != 3)) {
                            if (B3.a.p()) {
                                if (i12 != 3 && i12 != 4) {
                                    arrayList.add(v10[i12]);
                                    a.this.f29811e.add(stringArray[i12]);
                                }
                            } else {
                                arrayList.add(v10[i12]);
                                a.this.f29811e.add(stringArray[i12]);
                            }
                        }
                    }
                }
                if (!z10 && a.this.f29811e.size() > 0) {
                    a.this.f29811e.remove(0);
                    a.this.f29811e.add(0, a.this.f29807a.getString(R.string.ted_no_mark));
                }
            }
            if (arrayList.size() > 0 && a.this.f29811e != null && a.this.f29811e.size() > 0) {
                if (this.f29814a == -1 || (FeatureOption.i() && this.f29814a == 3)) {
                    a.this.f29808b = -1;
                } else {
                    String str3 = this.f29815b;
                    if (this.f29814a == 7 && stringArray.length > 6) {
                        str = stringArray[6];
                    } else {
                        str = str3;
                    }
                    a aVar = a.this;
                    if (!TextUtils.isEmpty(str3) && this.f29816c) {
                        i11 = a.this.f29811e.indexOf(str);
                    } else {
                        i11 = -2;
                    }
                    aVar.f29808b = i11;
                }
                if (a.this.f29808b == 0 || a.this.f29808b == -2) {
                    arrayList.remove(0);
                    a.this.f29811e.remove(0);
                    a.this.f29808b = -2;
                }
                String string = a.this.f29807a.getString(R.string.manual_input);
                String str4 = this.f29815b;
                if (!TextUtils.isEmpty(str4)) {
                    for (int i13 = 0; i13 < stringArray.length; i13++) {
                        if (stringArray[i13].equals(this.f29815b)) {
                            str4 = v10[i13];
                        }
                    }
                }
                a.this.f29812f = str4;
                if (-1 == a.this.f29808b && !TextUtils.isEmpty(str4)) {
                    string = string + "：" + str4;
                    a.this.f29813g = true;
                }
                arrayList.add(string);
                a aVar2 = a.this;
                if (aVar2.f29808b != -1) {
                    i10 = a.this.f29808b;
                } else {
                    i10 = arrayList.size() - 1;
                }
                aVar2.f29808b = i10;
                a.this.f29810d = arrayList.subList(1, arrayList.size() - 1);
            }
            return arrayList;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List<String> list) {
            if (a.this.f29807a != null && !a.this.f29807a.isFinishing() && !a.this.f29807a.isDestroyed()) {
                if (list != null && list.size() != 0) {
                    p pVar = new p();
                    pVar.n(a.this.f29807a, a.this.f29807a.getResources().getString(R.string.oplus_mark_unknow_number_title), list, a.this.f29808b, 42, new C0288a(list, pVar));
                } else {
                    a.this.f29807a.finish();
                    H7.b.c("MarkDialogManager", "onPostExecute Exception: classifies = " + list);
                }
            }
        }
    }

    /* compiled from: MarkDialogManager.java */
    /* loaded from: classes4.dex */
    public class b implements Y0.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f29822a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f29823b;

        public b(h hVar, p pVar) {
            this.f29822a = hVar;
            this.f29823b = pVar;
        }

        @Override // Y0.a
        public void g() {
            String str;
            Editable text;
            COUIEditText j10 = this.f29822a.j();
            if (j10 != null && (text = j10.getText()) != null) {
                str = text.toString();
                if (TextUtils.equals(str, "疑似诈骗")) {
                    str = str + "\u200d";
                }
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
                if (a.this.f29810d != null && a.this.f29810d.contains(str)) {
                    com.oplus.foundation.util.ui.c.e(a.this.f29807a.getApplicationContext(), a.this.f29807a.getString(R.string.oplus_mark_type_exist));
                    this.f29823b.g();
                    this.f29822a.g();
                    return;
                } else {
                    a.this.f29809c.b(str, -1);
                    this.f29823b.g();
                    this.f29822a.g();
                    return;
                }
            }
            com.oplus.foundation.util.ui.c.e(a.this.f29807a, a.this.f29807a.getString(R.string.oplus_mark_type_empty));
            this.f29823b.g();
            this.f29822a.g();
        }

        @Override // Y0.a
        public void onCancel() {
            this.f29823b.k(false);
            this.f29822a.g();
        }
    }

    /* compiled from: MarkDialogManager.java */
    /* loaded from: classes4.dex */
    public interface c {
        void a();

        void b(String str, int i10);

        void c(String str, String str2, int i10);
    }

    public a(Activity activity) {
        this(activity, null);
    }

    public void l(c cVar) {
        this.f29809c = cVar;
    }

    public final androidx.appcompat.app.b m(p pVar) {
        String string;
        h hVar = new h();
        b bVar = new b(hVar, pVar);
        Activity activity = this.f29807a;
        View o10 = hVar.o(activity, R.layout.bottom_dialog_layout_with_edit_text, bVar, activity.getString(R.string.add_mark_type), this.f29807a.getString(R.string.cancel), this.f29807a.getString(R.string.dialog_ok));
        if (this.f29813g && !TextUtils.isEmpty(this.f29812f)) {
            string = this.f29812f;
        } else {
            string = this.f29807a.getString(R.string.input_mark_type);
        }
        hVar.k(o10, true, string, false);
        COUIEditText j10 = hVar.j();
        if (j10 != null) {
            j10.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
        }
        return hVar.h();
    }

    public void n(String str, boolean z10, boolean z11, int i10) {
        new AsyncTaskC0287a(i10, str, z11, z10).execute(new String[0]);
    }

    public a(Activity activity, c cVar) {
        this.f29808b = 0;
        this.f29813g = false;
        this.f29807a = activity;
        this.f29809c = cVar;
    }
}
