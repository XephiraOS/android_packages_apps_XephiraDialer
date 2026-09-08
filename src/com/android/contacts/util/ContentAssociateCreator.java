package com.android.contacts.util;

import android.content.Context;
import android.content.DialogInterface;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.android.contacts.util.A;
import com.coui.appcompat.autocomplete.COUIAutoCompletePopupWindow;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.util.h0;
import com.oplus.dialer.R;
import h1.C1074c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Regex;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.F;
import kotlinx.coroutines.InterfaceC1265l0;
import kotlinx.coroutines.J0;
import kotlinx.coroutines.S;
import v9.InterfaceC1637a;

/* compiled from: ContentAssociateCreator.kt */
/* loaded from: classes.dex */
public final class ContentAssociateCreator {

    /* renamed from: a, reason: collision with root package name */
    public final a f17528a;

    /* renamed from: b, reason: collision with root package name */
    public final m9.d f17529b;

    /* renamed from: c, reason: collision with root package name */
    public final E f17530c;

    /* renamed from: d, reason: collision with root package name */
    public final ExecutorCoroutineDispatcher f17531d;

    /* renamed from: e, reason: collision with root package name */
    public final long f17532e;

    /* renamed from: f, reason: collision with root package name */
    public final long f17533f;

    /* renamed from: g, reason: collision with root package name */
    public final int f17534g;

    /* renamed from: h, reason: collision with root package name */
    public final String f17535h;

    /* renamed from: i, reason: collision with root package name */
    public String f17536i;

    /* renamed from: j, reason: collision with root package name */
    public List<String> f17537j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f17538k;

    /* renamed from: l, reason: collision with root package name */
    public String f17539l;

    /* renamed from: m, reason: collision with root package name */
    public COUIAutoCompletePopupWindow f17540m;

    /* renamed from: n, reason: collision with root package name */
    public InterfaceC1265l0 f17541n;

    /* renamed from: o, reason: collision with root package name */
    public int f17542o;

    /* renamed from: p, reason: collision with root package name */
    public WeakReference<View> f17543p;

    /* renamed from: q, reason: collision with root package name */
    public final b f17544q;

    /* renamed from: r, reason: collision with root package name */
    public final A f17545r;

    /* renamed from: s, reason: collision with root package name */
    public androidx.appcompat.app.b f17546s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f17547t;

    /* renamed from: u, reason: collision with root package name */
    public int f17548u;

    /* compiled from: ContentAssociateCreator.kt */
    /* loaded from: classes.dex */
    public interface a {
        void t0(String str, String str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContentAssociateCreator(final Context contextArg, int i10, a clickListener) {
        m9.d b10;
        b bVar;
        kotlin.jvm.internal.i.f(contextArg, "contextArg");
        kotlin.jvm.internal.i.f(clickListener, "clickListener");
        this.f17528a = clickListener;
        b10 = kotlin.a.b(new InterfaceC1637a<WeakReference<Context>>() { // from class: com.android.contacts.util.ContentAssociateCreator$context$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public final WeakReference<Context> invoke() {
                return new WeakReference<>(contextArg);
            }
        });
        this.f17529b = b10;
        this.f17530c = F.b();
        this.f17531d = J0.b("ContentAssociateCreatorHandleThread");
        this.f17532e = 100L;
        this.f17533f = 250L;
        this.f17534g = 3;
        this.f17535h = "ContentAssociateCreator";
        this.f17537j = new ArrayList();
        Context context = n().get();
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (context != null) {
            bVar = new b(context, objArr2 == true ? 1 : 0, 2, objArr == true ? 1 : 0);
        } else {
            bVar = null;
        }
        this.f17544q = bVar;
        Context context2 = n().get();
        this.f17545r = context2 != null ? new A(context2) : null;
        this.f17548u = i10;
    }

    public static final void C(ContentAssociateCreator this$0, COUIAutoCompletePopupWindow this_apply, AdapterView adapterView, View view, int i10, long j10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(this_apply, "$this_apply");
        C1248i.d(this$0.f17530c, S.b(), null, new ContentAssociateCreator$showPopWindow$2$1$1(this$0, i10, null), 2, null);
        this_apply.dismiss();
    }

    public static final void E(ContentAssociateCreator this$0, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        com.android.contacts.framework.baseui.util.A.a(this$0.n().get(), 2000310, 200032805, h0.c0(this$0.f17536i, this$0.f17538k, true, this$0.f17542o), false);
        this$0.f17547t = true;
    }

    public static final void F(ContentAssociateCreator this$0, String lookupKey, String _id, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(lookupKey, "$lookupKey");
        kotlin.jvm.internal.i.f(_id, "$_id");
        this$0.f17528a.t0(lookupKey, _id);
        this$0.f17547t = true;
        com.android.contacts.framework.baseui.util.A.a(this$0.n().get(), 2000310, 200032805, h0.c0(this$0.f17536i, this$0.f17538k, false, this$0.f17542o), false);
    }

    public final void A(String str) {
        this.f17536i = str;
    }

    public final void B(List<A.b> list) {
        final COUIAutoCompletePopupWindow cOUIAutoCompletePopupWindow;
        H7.b.b(this.f17535h, "total " + list.size() + " to display");
        if (this.f17540m == null) {
            Context context = n().get();
            if (context != null) {
                cOUIAutoCompletePopupWindow = new COUIAutoCompletePopupWindow(context);
            } else {
                cOUIAutoCompletePopupWindow = null;
            }
            this.f17540m = cOUIAutoCompletePopupWindow;
            if (cOUIAutoCompletePopupWindow != null) {
                cOUIAutoCompletePopupWindow.setDismissTouchOutside(true);
                cOUIAutoCompletePopupWindow.setAdapter(this.f17544q);
                cOUIAutoCompletePopupWindow.setHeight(0);
                cOUIAutoCompletePopupWindow.setFocusable(false);
                cOUIAutoCompletePopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.android.contacts.util.j
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                        ContentAssociateCreator.C(ContentAssociateCreator.this, cOUIAutoCompletePopupWindow, adapterView, view, i10, j10);
                    }
                });
            }
        }
        b bVar = this.f17544q;
        if (bVar != null) {
            bVar.b(list);
            String str = this.f17539l;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            bVar.c(str);
            String str3 = this.f17536i;
            if (str3 != null) {
                str2 = str3;
            }
            bVar.d(str2);
            COUIAutoCompletePopupWindow cOUIAutoCompletePopupWindow2 = this.f17540m;
            if (cOUIAutoCompletePopupWindow2 != null) {
                int count = bVar.getCount();
                int i10 = this.f17534g;
                if (i10 <= count) {
                    count = i10;
                }
                cOUIAutoCompletePopupWindow2.setMaxLines(count);
                WeakReference<View> weakReference = this.f17543p;
                if (weakReference != null) {
                    cOUIAutoCompletePopupWindow2.show(weakReference.get());
                }
            }
        }
    }

    public final void D(final String str, final String str2) {
        COUIAlertDialogBuilder cOUIAlertDialogBuilder;
        Context context = n().get();
        androidx.appcompat.app.b bVar = null;
        if (context != null) {
            cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(context);
        } else {
            cOUIAlertDialogBuilder = null;
        }
        if (cOUIAlertDialogBuilder != null) {
            bVar = cOUIAlertDialogBuilder.setTitle(R.string.content_associate_pop_window_click_title).setMessage(R.string.content_associate_pop_window_click_message_R12).setPositiveButton(R.string.oplus_menu_edit, new DialogInterface.OnClickListener() { // from class: com.android.contacts.util.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    ContentAssociateCreator.F(ContentAssociateCreator.this, str, str2, dialogInterface, i10);
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.android.contacts.util.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    ContentAssociateCreator.E(ContentAssociateCreator.this, dialogInterface, i10);
                }
            }).show();
        }
        this.f17546s = bVar;
    }

    public final void G() {
        InterfaceC1265l0 d10;
        j();
        String str = this.f17539l;
        if (str != null && str.length() == 0) {
            H7.b.b(this.f17535h, "input is empty ,no need to query , return");
        } else if (!this.f17547t) {
            d10 = C1248i.d(this.f17530c, this.f17531d, null, new ContentAssociateCreator$tryShowAssociateWindow$1(this, null), 2, null);
            this.f17541n = d10;
        } else {
            H7.b.b(this.f17535h, "has covered contact, will not show tip again");
        }
    }

    public final void j() {
        InterfaceC1265l0 interfaceC1265l0 = this.f17541n;
        if (interfaceC1265l0 != null) {
            InterfaceC1265l0.a.a(interfaceC1265l0, null, 1, null);
        }
    }

    public final void k() {
        COUIAutoCompletePopupWindow cOUIAutoCompletePopupWindow = this.f17540m;
        if (cOUIAutoCompletePopupWindow != null) {
            cOUIAutoCompletePopupWindow.dismiss();
        }
    }

    public final void l() {
        COUIAutoCompletePopupWindow cOUIAutoCompletePopupWindow;
        androidx.appcompat.app.b bVar;
        androidx.appcompat.app.b bVar2 = this.f17546s;
        if (bVar2 != null && true == bVar2.isShowing() && (bVar = this.f17546s) != null) {
            bVar.dismiss();
        }
        COUIAutoCompletePopupWindow cOUIAutoCompletePopupWindow2 = this.f17540m;
        if (cOUIAutoCompletePopupWindow2 != null && cOUIAutoCompletePopupWindow2.isShowing() && (cOUIAutoCompletePopupWindow = this.f17540m) != null) {
            cOUIAutoCompletePopupWindow.dismiss();
        }
        this.f17531d.close();
        F.d(this.f17530c, null, 1, null);
    }

    public final List<String> m() {
        return this.f17537j;
    }

    public final WeakReference<Context> n() {
        return (WeakReference) this.f17529b.getValue();
    }

    public final String o() {
        return this.f17539l;
    }

    public final String p() {
        return this.f17536i;
    }

    public final long q() {
        return this.f17532e;
    }

    public final E r() {
        return this.f17530c;
    }

    public final String s() {
        return this.f17535h;
    }

    public final long t() {
        return this.f17533f;
    }

    public final boolean u() {
        COUIAutoCompletePopupWindow cOUIAutoCompletePopupWindow = this.f17540m;
        if (cOUIAutoCompletePopupWindow == null || !cOUIAutoCompletePopupWindow.isShowing()) {
            return false;
        }
        return true;
    }

    public final void v(List<String> value) {
        kotlin.jvm.internal.i.f(value, "value");
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.f17537j.iterator();
        while (it.hasNext()) {
            sb.append(it.next() + ",");
        }
        H7.b.b(this.f17535h, "contain account type : " + ((Object) sb));
        this.f17537j = value;
    }

    public final void w(View view) {
        this.f17543p = new WeakReference<>(view);
    }

    public final void x(int i10) {
        this.f17542o = i10;
    }

    public final void y(boolean z10) {
        this.f17538k = z10;
    }

    public final void z(String str) {
        if (kotlin.jvm.internal.i.b(this.f17536i, "vnd.android.cursor.item/phone_v2")) {
            if (str != null) {
                str = new Regex("[()\\-. ]").b(str, "");
            } else {
                str = null;
            }
        }
        this.f17539l = str;
    }

    /* compiled from: ContentAssociateCreator.kt */
    /* loaded from: classes.dex */
    public static final class b extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final Context f17549a;

        /* renamed from: b, reason: collision with root package name */
        public List<A.b> f17550b;

        /* renamed from: c, reason: collision with root package name */
        public final String f17551c;

        /* renamed from: d, reason: collision with root package name */
        public String f17552d;

        /* renamed from: e, reason: collision with root package name */
        public String f17553e;

        public b(Context context, List<A.b> data) {
            kotlin.jvm.internal.i.f(context, "context");
            kotlin.jvm.internal.i.f(data, "data");
            this.f17549a = context;
            this.f17550b = data;
            this.f17551c = "PopWindowAdapter";
            this.f17552d = "";
            this.f17553e = "";
        }

        public final String a(String str) {
            String formatNumber = PhoneNumberUtils.formatNumber(str, C1074c.b(this.f17549a.getApplicationContext()));
            if (formatNumber != null && formatNumber.length() != 0) {
                kotlin.jvm.internal.i.e(formatNumber, "{\n                result\n            }");
                return formatNumber;
            }
            return str;
        }

        public final void b(List<A.b> data) {
            kotlin.jvm.internal.i.f(data, "data");
            this.f17550b = data;
        }

        public final void c(String str) {
            kotlin.jvm.internal.i.f(str, "str");
            this.f17552d = str;
        }

        public final void d(String str) {
            kotlin.jvm.internal.i.f(str, "<set-?>");
            this.f17553e = str;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f17550b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return this.f17550b.get(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:75:0x015d, code lost:
        
            if (r1.equals("vnd.android.cursor.item/email_v2") == false) goto L71;
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00f3  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0105  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x019a  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01a2 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:5:0x001c, B:7:0x0020, B:12:0x004d, B:14:0x005d, B:16:0x006c, B:18:0x0074, B:20:0x0083, B:22:0x008d, B:24:0x0093, B:26:0x009d, B:28:0x00b4, B:31:0x00fb, B:35:0x0129, B:42:0x015f, B:45:0x0185, B:49:0x0190, B:54:0x019d, B:55:0x01a2, B:59:0x01ae, B:62:0x01b5, B:63:0x013f, B:68:0x017c, B:69:0x0146, B:73:0x0152, B:74:0x0156, B:76:0x0108, B:77:0x010c, B:81:0x0119, B:84:0x0124, B:85:0x00f4, B:86:0x00dc, B:88:0x007b, B:89:0x0069, B:90:0x004a, B:91:0x0044, B:92:0x01b9), top: B:4:0x001c }] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0156 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:5:0x001c, B:7:0x0020, B:12:0x004d, B:14:0x005d, B:16:0x006c, B:18:0x0074, B:20:0x0083, B:22:0x008d, B:24:0x0093, B:26:0x009d, B:28:0x00b4, B:31:0x00fb, B:35:0x0129, B:42:0x015f, B:45:0x0185, B:49:0x0190, B:54:0x019d, B:55:0x01a2, B:59:0x01ae, B:62:0x01b5, B:63:0x013f, B:68:0x017c, B:69:0x0146, B:73:0x0152, B:74:0x0156, B:76:0x0108, B:77:0x010c, B:81:0x0119, B:84:0x0124, B:85:0x00f4, B:86:0x00dc, B:88:0x007b, B:89:0x0069, B:90:0x004a, B:91:0x0044, B:92:0x01b9), top: B:4:0x001c }] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x010c A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:5:0x001c, B:7:0x0020, B:12:0x004d, B:14:0x005d, B:16:0x006c, B:18:0x0074, B:20:0x0083, B:22:0x008d, B:24:0x0093, B:26:0x009d, B:28:0x00b4, B:31:0x00fb, B:35:0x0129, B:42:0x015f, B:45:0x0185, B:49:0x0190, B:54:0x019d, B:55:0x01a2, B:59:0x01ae, B:62:0x01b5, B:63:0x013f, B:68:0x017c, B:69:0x0146, B:73:0x0152, B:74:0x0156, B:76:0x0108, B:77:0x010c, B:81:0x0119, B:84:0x0124, B:85:0x00f4, B:86:0x00dc, B:88:0x007b, B:89:0x0069, B:90:0x004a, B:91:0x0044, B:92:0x01b9), top: B:4:0x001c }] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x00f4 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:5:0x001c, B:7:0x0020, B:12:0x004d, B:14:0x005d, B:16:0x006c, B:18:0x0074, B:20:0x0083, B:22:0x008d, B:24:0x0093, B:26:0x009d, B:28:0x00b4, B:31:0x00fb, B:35:0x0129, B:42:0x015f, B:45:0x0185, B:49:0x0190, B:54:0x019d, B:55:0x01a2, B:59:0x01ae, B:62:0x01b5, B:63:0x013f, B:68:0x017c, B:69:0x0146, B:73:0x0152, B:74:0x0156, B:76:0x0108, B:77:0x010c, B:81:0x0119, B:84:0x0124, B:85:0x00f4, B:86:0x00dc, B:88:0x007b, B:89:0x0069, B:90:0x004a, B:91:0x0044, B:92:0x01b9), top: B:4:0x001c }] */
        @Override // android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.view.View getView(int r20, android.view.View r21, android.view.ViewGroup r22) {
            /*
                Method dump skipped, instructions count: 498
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.util.ContentAssociateCreator.b.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        public /* synthetic */ b(Context context, List list, int i10, kotlin.jvm.internal.f fVar) {
            this(context, (i10 & 2) != 0 ? new ArrayList() : list);
        }
    }
}
