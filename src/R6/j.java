package r6;

import V6.b;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.coui.appcompat.reddot.COUIHintRedDot;
import com.oplus.blacklistapp.BlackListAppUtil;
import com.oplus.blacklistapp.activities.BlockedCallLogAndSmsListActivity;
import com.oplus.utils.AnimationAnimationListenerC0842c;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0849j;
import com.oplus.utils.C0856q;
import h9.C1087a;
import java.util.HashSet;
import r6.x;

/* compiled from: BlockedSmsListAdapter.java */
/* loaded from: classes3.dex */
public class j extends CursorAdapter implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final LayoutInflater f36393a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f36394b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f36395c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f36396d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f36397e;

    /* renamed from: f, reason: collision with root package name */
    public HashSet<Long> f36398f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f36399g;

    /* renamed from: h, reason: collision with root package name */
    public V6.f f36400h;

    /* renamed from: i, reason: collision with root package name */
    public V6.c f36401i;

    /* renamed from: j, reason: collision with root package name */
    public V6.b f36402j;

    /* renamed from: k, reason: collision with root package name */
    public C1087a f36403k;

    /* renamed from: l, reason: collision with root package name */
    public c f36404l;

    /* renamed from: m, reason: collision with root package name */
    public Context f36405m;

    /* renamed from: n, reason: collision with root package name */
    public BlockedCallLogAndSmsListActivity.g f36406n;

    /* renamed from: o, reason: collision with root package name */
    public final int f36407o;

    /* renamed from: p, reason: collision with root package name */
    public int f36408p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f36409q;

    /* renamed from: r, reason: collision with root package name */
    public x.a f36410r;

    /* renamed from: x, reason: collision with root package name */
    public final b.InterfaceC0076b f36411x;

    /* compiled from: BlockedSmsListAdapter.java */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public TextView f36416a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f36417b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f36418c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f36419d;

        /* renamed from: e, reason: collision with root package name */
        public CheckBox f36420e;

        /* renamed from: f, reason: collision with root package name */
        public FrameLayout f36421f;

        /* renamed from: g, reason: collision with root package name */
        public COUIHintRedDot f36422g;

        /* renamed from: h, reason: collision with root package name */
        public COUIRoundImageView f36423h;

        /* renamed from: i, reason: collision with root package name */
        public y f36424i;

        /* renamed from: j, reason: collision with root package name */
        public View f36425j;

        public static b a(View view) {
            b bVar = new b();
            bVar.f36418c = (TextView) view.findViewById(com.oplus.blacklistapp.p.f27340I);
            bVar.f36416a = (TextView) view.findViewById(com.oplus.blacklistapp.p.f27343J0);
            bVar.f36417b = (TextView) view.findViewById(com.oplus.blacklistapp.p.f27332E);
            bVar.f36424i = new y(bVar.f36416a, bVar.f36417b);
            bVar.f36419d = (TextView) view.findViewById(com.oplus.blacklistapp.p.f27420w);
            bVar.f36420e = (CheckBox) view.findViewById(com.oplus.blacklistapp.p.f27370X);
            bVar.f36421f = (FrameLayout) view.findViewById(com.oplus.blacklistapp.p.f27404o);
            COUIRoundImageView cOUIRoundImageView = (COUIRoundImageView) view.findViewById(com.oplus.blacklistapp.p.f27411r0);
            bVar.f36423h = cOUIRoundImageView;
            cOUIRoundImageView.setHasBorder(false);
            COUIHintRedDot cOUIHintRedDot = (COUIHintRedDot) view.findViewById(com.oplus.blacklistapp.p.f27367V0);
            bVar.f36422g = cOUIHintRedDot;
            cOUIHintRedDot.setPointMode(2);
            bVar.f36425j = view.findViewById(com.oplus.blacklistapp.p.f27390h);
            return bVar;
        }
    }

    /* compiled from: BlockedSmsListAdapter.java */
    /* loaded from: classes3.dex */
    public interface c {
        void onItemClick(View view, int i10);

        void x0();
    }

    public j(Context context, C1087a c1087a, c cVar) {
        super(context, (Cursor) null, false);
        this.f36394b = false;
        this.f36395c = true;
        this.f36396d = false;
        this.f36397e = false;
        this.f36398f = new HashSet<>();
        this.f36408p = 0;
        this.f36409q = false;
        this.f36410r = null;
        b.InterfaceC0076b interfaceC0076b = new b.InterfaceC0076b() { // from class: r6.i
            @Override // V6.b.InterfaceC0076b
            public final void a() {
                j.this.l();
            }
        };
        this.f36411x = interfaceC0076b;
        this.f36405m = context;
        this.f36393a = LayoutInflater.from(context);
        this.f36399g = true;
        this.f36400h = V6.f.b(context);
        this.f36403k = c1087a;
        V6.c cVar2 = new V6.c(context);
        this.f36401i = cVar2;
        this.f36402j = new V6.b(this.f36405m, cVar2, this.f36403k, interfaceC0076b);
        this.f36404l = cVar;
        this.f36407o = C0849j.b(context, 41.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0130  */
    @Override // android.widget.CursorAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void bindView(android.view.View r27, android.content.Context r28, android.database.Cursor r29) {
        /*
            Method dump skipped, instructions count: 691
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.j.bindView(android.view.View, android.content.Context, android.database.Cursor):void");
    }

    @Override // android.widget.CursorAdapter
    public void changeCursor(Cursor cursor) {
        super.changeCursor(cursor);
        this.f36410r = null;
    }

    public void f(int i10) {
        if (this.f36408p != 0 && i10 == 0 && this.f36409q) {
            C0846g.i("BlockedSmsListAdapter", "changeScrollState:notifyDataSetChanged");
            notifyDataSetChanged();
            this.f36409q = false;
        }
        this.f36408p = i10;
    }

    public final void g(View view, boolean z10, CheckBox checkBox, View view2, TextView textView, y yVar) {
        a aVar = new a(z10, checkBox, view2);
        if (z10) {
            if (!BlackListAppUtil.f26245b) {
                AnimationAnimationListenerC0842c.l(this.f36405m, checkBox, 0).f(this.f36405m, false, aVar);
            } else {
                AnimationAnimationListenerC0842c.j(this.f36405m, checkBox, 0).f(this.f36405m, false, aVar);
            }
        } else if (!BlackListAppUtil.f26245b) {
            AnimationAnimationListenerC0842c.m(this.f36405m, checkBox, 8).n(this.f36405m, aVar);
        } else {
            AnimationAnimationListenerC0842c.k(this.f36405m, checkBox, 8).n(this.f36405m, aVar);
        }
        n(textView, yVar);
    }

    @Override // android.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = newView(this.f36405m, getCursor(), viewGroup);
        }
        if (getCursor().moveToPosition(i10)) {
            bindView(view, this.f36405m, getCursor());
        } else {
            Log.e("BlockedSmsListAdapter", "couldn't move cursor to position " + i10);
        }
        return view;
    }

    public final String h(V6.a aVar, String str) {
        String str2;
        Uri uri;
        if (C0856q.h(this.f36405m)) {
            str2 = C0856q.c(str);
        } else {
            str2 = str;
        }
        if (aVar != null) {
            uri = aVar.f4011b;
        } else {
            uri = null;
        }
        if (aVar != null && !TextUtils.isEmpty(aVar.f4012c)) {
            str2 = C0856q.b(this.f36405m, aVar.f4012c);
        }
        if (l7.b.d() && uri == null && this.f36403k.j(str)) {
            String g10 = this.f36403k.g(str);
            if (!TextUtils.isEmpty(g10)) {
                str2 = g10;
            }
        }
        if (I6.b.d() && I6.b.b(str)) {
            String a10 = I6.b.a(str);
            if (!TextUtils.isEmpty(a10)) {
                str2 = a10;
            }
        }
        if (TextUtils.isEmpty(str2) && aVar != null && aVar.f4023n) {
            return this.f36405m.getResources().getString(com.oplus.blacklistapp.u.f27711x0);
        }
        return str2;
    }

    public void i(View view, int i10) {
        if (!k()) {
            ((BlockedCallLogAndSmsListActivity) this.f36405m).O0();
            ((BlockedCallLogAndSmsListActivity) this.f36405m).Q1();
            ((BlockedCallLogAndSmsListActivity) this.f36405m).K1("long_press");
        }
        this.f36404l.onItemClick(view, i10);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i10) {
        return super.isEnabled(i10);
    }

    public void j() {
        V6.b bVar = this.f36402j;
        if (bVar == null) {
            return;
        }
        bVar.k();
    }

    public boolean k() {
        return this.f36394b;
    }

    public final /* synthetic */ void l() {
        if (this.f36408p == 0) {
            notifyDataSetChanged();
        } else {
            this.f36409q = true;
        }
        if (C0846g.c()) {
            C0846g.i("BlockedSmsListAdapter", "onContactInfoChanged, mNeedPostponeDataChanged = " + this.f36409q + ",mCurrentScrollState = " + this.f36408p);
        }
    }

    public void m() {
        notifyDataSetChanged();
        if (C0846g.c()) {
            Log.d("BlockedSmsListAdapter", "onConfigurationChanged");
        }
    }

    public final void n(View view, y yVar) {
        if (view.getVisibility() == 8) {
            return;
        }
        yVar.d(k());
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f36393a.inflate(com.oplus.blacklistapp.r.f27470y, viewGroup, false);
    }

    public void o(boolean z10) {
        this.f36396d = z10;
    }

    @Override // android.widget.CursorAdapter
    public void onContentChanged() {
        this.f36404l.x0();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        C0846g.i("BlockedSmsListAdapter", "onClick");
        this.f36404l.onItemClick(view, i10);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        C0846g.i("BlockedSmsListAdapter", "onLongClick");
        r(false);
        try {
            i(view, i10);
        } catch (Exception unused) {
            r(true);
        }
        return true;
    }

    public void p(HashSet<Long> hashSet) {
        if (hashSet == null) {
            this.f36398f = new HashSet<>();
        } else {
            this.f36398f = hashSet;
        }
    }

    public void q(boolean z10) {
        if (C0846g.c()) {
            Log.d("BlockedSmsListAdapter", "setChoiceMode");
        }
        this.f36394b = z10;
        if (!z10) {
            this.f36398f = new HashSet<>();
        }
    }

    public final void r(boolean z10) {
        BlockedCallLogAndSmsListActivity.g gVar = this.f36406n;
        if (gVar != null) {
            gVar.k(z10);
        }
    }

    public void s(boolean z10) {
        this.f36397e = z10;
    }

    public void t(boolean z10) {
        this.f36399g = z10;
    }

    public void u(BlockedCallLogAndSmsListActivity.g gVar) {
        this.f36406n = gVar;
    }

    public void v(boolean z10) {
        V6.b bVar = this.f36402j;
        if (bVar == null) {
            return;
        }
        bVar.m(z10);
    }

    public void w() {
        V6.b bVar = this.f36402j;
        if (bVar == null) {
            return;
        }
        bVar.o();
    }

    /* compiled from: BlockedSmsListAdapter.java */
    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f36412a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CheckBox f36413b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f36414c;

        public a(boolean z10, CheckBox checkBox, View view) {
            this.f36412a = z10;
            this.f36413b = checkBox;
            this.f36414c = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j.this.f36396d = false;
            if (!this.f36412a) {
                j.this.f36395c = true;
                this.f36413b.setChecked(false);
                this.f36414c.setVisibility(8);
                this.f36413b.setVisibility(8);
            } else {
                j.this.f36395c = false;
                this.f36413b.setVisibility(0);
            }
            if (j.this.f36397e) {
                j.this.f36397e = false;
                j.this.onContentChanged();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            j.this.f36396d = true;
            if (this.f36412a) {
                this.f36413b.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
