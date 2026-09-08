package E3;

import F0.c;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.widget.TextView;
import com.android.contacts.framework.api.numberidentify.interfaces.IRecognitionNumber;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: CallLogNumberNAFCLoader.kt */
/* loaded from: classes3.dex */
public final class o implements Handler.Callback {

    /* renamed from: h, reason: collision with root package name */
    public static final a f636h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f637a;

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<String, c> f638b;

    /* renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap<TextView, String> f639c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f640d;

    /* renamed from: e, reason: collision with root package name */
    public b f641e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f642f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f643g;

    /* compiled from: CallLogNumberNAFCLoader.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: CallLogNumberNAFCLoader.kt */
    /* loaded from: classes3.dex */
    public final class b extends HandlerThread implements Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList<String> f644a;

        /* renamed from: b, reason: collision with root package name */
        public Handler f645b;

        public b() {
            super("NumberNationalAntiFraudLoader");
            this.f644a = com.google.common.collect.n.f();
        }

        public final void a() {
            boolean z10;
            o oVar = o.this;
            ArrayList<String> mNumbers = this.f644a;
            kotlin.jvm.internal.i.e(mNumbers, "mNumbers");
            oVar.f(mNumbers);
            int size = this.f644a.size();
            if (size == 0) {
                return;
            }
            for (int i10 = 0; i10 < size; i10++) {
                String number = this.f644a.get(i10);
                IRecognitionNumber B10 = E0.b.B(new c.a().h(number).d(Integer.valueOf(E0.a.a())).a());
                if (B10 != null && B10.a()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                o oVar2 = o.this;
                kotlin.jvm.internal.i.e(number, "number");
                oVar2.b(number, z10);
            }
            this.f644a.clear();
        }

        public final void b() {
            if (this.f645b == null) {
                this.f645b = new Handler(getLooper(), this);
            }
            Handler handler = this.f645b;
            if (handler != null) {
                handler.sendEmptyMessage(1);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            if (msg.what == 1) {
                a();
                o.this.f640d.sendEmptyMessage(2);
            }
            return true;
        }
    }

    /* compiled from: CallLogNumberNAFCLoader.kt */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: c, reason: collision with root package name */
        public static final a f647c = new a(null);

        /* renamed from: a, reason: collision with root package name */
        public int f648a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f649b;

        /* compiled from: CallLogNumberNAFCLoader.kt */
        /* loaded from: classes3.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        public final boolean a() {
            return this.f649b;
        }

        public final int b() {
            return this.f648a;
        }

        public final void c(boolean z10) {
            this.f649b = z10;
        }

        public final void d(int i10) {
            this.f648a = i10;
        }
    }

    public o(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        this.f637a = context;
        this.f638b = new ConcurrentHashMap<>();
        this.f639c = new ConcurrentHashMap<>();
        this.f640d = new Handler(this);
    }

    public final void b(String number, boolean z10) {
        kotlin.jvm.internal.i.f(number, "number");
        if (this.f643g) {
            return;
        }
        c cVar = this.f638b.get(number);
        if (cVar == null) {
            cVar = new c();
        }
        cVar.d(2);
        cVar.c(z10);
        this.f638b.put(number, cVar);
    }

    public final void c() {
        this.f638b.clear();
    }

    public final boolean d(TextView view, String number) {
        kotlin.jvm.internal.i.f(view, "view");
        kotlin.jvm.internal.i.f(number, "number");
        c cVar = this.f638b.get(number);
        if (cVar == null) {
            cVar = new c();
            this.f638b.putIfAbsent(number, cVar);
        } else if (cVar.b() == 2) {
            k(view, cVar.a());
            return true;
        }
        cVar.d(0);
        return false;
    }

    public final void e(TextView view, String str) {
        kotlin.jvm.internal.i.f(view, "view");
        if (str != null && str.length() != 0) {
            if (d(view, str)) {
                this.f639c.remove(view);
                return;
            }
            this.f639c.put(view, str);
            if (!this.f643g) {
                i();
                return;
            }
            return;
        }
        view.setText("");
        view.setVisibility(8);
    }

    public final void f(ArrayList<String> numbers) {
        kotlin.jvm.internal.i.f(numbers, "numbers");
        numbers.clear();
        for (String str : this.f639c.values()) {
            c cVar = this.f638b.get(str);
            if (cVar != null && cVar.b() == 0) {
                cVar.d(1);
                numbers.add(str);
            }
        }
    }

    public final void g() {
        this.f643g = true;
    }

    public final void h() {
        Iterator<TextView> it = this.f639c.keySet().iterator();
        while (it.hasNext()) {
            TextView next = it.next();
            kotlin.jvm.internal.i.e(next, "iterator.next()");
            TextView textView = next;
            String str = this.f639c.get(textView);
            if (str != null && d(textView, str)) {
                it.remove();
            }
        }
        if (!this.f639c.isEmpty()) {
            i();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        kotlin.jvm.internal.i.f(msg, "msg");
        int i10 = msg.what;
        if (i10 != 1) {
            if (i10 != 2) {
                return false;
            }
            if (!this.f643g) {
                h();
            }
            return true;
        }
        this.f642f = false;
        if (!this.f643g) {
            if (this.f641e == null) {
                b bVar = new b();
                this.f641e = bVar;
                bVar.start();
            }
            b bVar2 = this.f641e;
            if (bVar2 != null) {
                bVar2.b();
            }
        }
        return true;
    }

    public final void i() {
        if (!this.f642f) {
            this.f642f = true;
            this.f640d.sendEmptyMessage(1);
        }
    }

    public final void j() {
        this.f643g = false;
        if (!this.f639c.isEmpty()) {
            i();
        }
    }

    public final void k(TextView flagView, boolean z10) {
        String str;
        int i10;
        kotlin.jvm.internal.i.f(flagView, "flagView");
        if (z10) {
            str = this.f637a.getString(R.string.nafc_fraud_number);
        } else {
            str = "";
        }
        flagView.setText(str);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        flagView.setVisibility(i10);
    }

    public final void l() {
        g();
        b bVar = this.f641e;
        if (bVar != null) {
            bVar.quitSafely();
        }
        this.f641e = null;
        this.f639c.clear();
    }
}
