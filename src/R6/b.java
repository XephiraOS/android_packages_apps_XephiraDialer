package r6;

import V6.b;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.blacklistapp.BlackListAppUtil;
import com.oplus.blacklistapp.activities.BlockedCallLogAndSmsListActivity;
import com.oplus.utils.AnimationAnimationListenerC0842c;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0849j;
import com.oplus.utils.C0863y;
import com.oplus.utils.StatisticsUtils;
import com.oplus.utils.X;
import com.oplus.widget.CallTypeIconsView;
import h9.C1087a;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.Set;

/* compiled from: BlockedCallsListAdapter.java */
/* loaded from: classes3.dex */
public class b extends ResourceCursorAdapter implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    /* renamed from: A, reason: collision with root package name */
    public int f36299A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f36300B;

    /* renamed from: C, reason: collision with root package name */
    public final b.InterfaceC0076b f36301C;

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0348b f36302a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f36303b;

    /* renamed from: c, reason: collision with root package name */
    public DateFormat f36304c;

    /* renamed from: d, reason: collision with root package name */
    public DateFormat f36305d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f36306e;

    /* renamed from: f, reason: collision with root package name */
    public Context f36307f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f36308g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f36309h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f36310i;

    /* renamed from: j, reason: collision with root package name */
    public int f36311j;

    /* renamed from: k, reason: collision with root package name */
    public long f36312k;

    /* renamed from: l, reason: collision with root package name */
    public long f36313l;

    /* renamed from: m, reason: collision with root package name */
    public V6.b f36314m;

    /* renamed from: n, reason: collision with root package name */
    public C1087a f36315n;

    /* renamed from: o, reason: collision with root package name */
    public Time f36316o;

    /* renamed from: p, reason: collision with root package name */
    public String f36317p;

    /* renamed from: q, reason: collision with root package name */
    public HashMap<String, String> f36318q;

    /* renamed from: r, reason: collision with root package name */
    public w f36319r;

    /* renamed from: x, reason: collision with root package name */
    public int f36320x;

    /* renamed from: y, reason: collision with root package name */
    public Set<String> f36321y;

    /* renamed from: z, reason: collision with root package name */
    public BlockedCallLogAndSmsListActivity.g f36322z;

    /* compiled from: BlockedCallsListAdapter.java */
    /* renamed from: r6.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0348b {
        void h();

        void onItemClick(View view, int i10);
    }

    /* compiled from: BlockedCallsListAdapter.java */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public View f36327a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f36328b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f36329c;

        /* renamed from: d, reason: collision with root package name */
        public CallTypeIconsView f36330d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f36331e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f36332f;

        /* renamed from: g, reason: collision with root package name */
        public TextView f36333g;

        /* renamed from: h, reason: collision with root package name */
        public TextView f36334h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f36335i;

        /* renamed from: j, reason: collision with root package name */
        public CheckBox f36336j;

        /* renamed from: k, reason: collision with root package name */
        public View f36337k;

        /* renamed from: l, reason: collision with root package name */
        public ImageView f36338l;

        /* renamed from: m, reason: collision with root package name */
        public View f36339m;

        public static c a(View view) {
            c cVar = new c();
            cVar.f36327a = view.findViewById(com.oplus.blacklistapp.p.f27413s0);
            cVar.f36328b = (ImageView) view.findViewById(com.oplus.blacklistapp.p.f27325A0);
            cVar.f36329c = (TextView) view.findViewById(com.oplus.blacklistapp.p.f27381c0);
            cVar.f36330d = (CallTypeIconsView) view.findViewById(com.oplus.blacklistapp.p.f27396k);
            cVar.f36331e = (ImageView) view.findViewById(com.oplus.blacklistapp.p.f27333E0);
            cVar.f36332f = (ImageView) view.findViewById(com.oplus.blacklistapp.p.f27346L);
            cVar.f36333g = (TextView) view.findViewById(com.oplus.blacklistapp.p.f27399l0);
            cVar.f36334h = (TextView) view.findViewById(com.oplus.blacklistapp.p.f27409q0);
            cVar.f36335i = (TextView) view.findViewById(com.oplus.blacklistapp.p.f27394j);
            cVar.f36336j = (CheckBox) view.findViewById(com.oplus.blacklistapp.p.f27370X);
            cVar.f36337k = view.findViewById(com.oplus.blacklistapp.p.f27398l);
            cVar.f36338l = (ImageView) view.findViewById(com.oplus.blacklistapp.p.f27371X0);
            cVar.f36339m = view.findViewById(com.oplus.blacklistapp.p.f27390h);
            return cVar;
        }
    }

    public b(Context context, C1087a c1087a, InterfaceC0348b interfaceC0348b) {
        super(context, com.oplus.blacklistapp.r.f27454i, null);
        this.f36303b = false;
        this.f36306e = true;
        this.f36308g = false;
        this.f36309h = true;
        this.f36310i = false;
        this.f36311j = 0;
        this.f36318q = new HashMap<>();
        this.f36321y = G6.b.a();
        this.f36299A = 0;
        this.f36300B = false;
        b.InterfaceC0076b interfaceC0076b = new b.InterfaceC0076b() { // from class: r6.a
            @Override // V6.b.InterfaceC0076b
            public final void a() {
                b.this.s();
            }
        };
        this.f36301C = interfaceC0076b;
        this.f36307f = context;
        this.f36315n = c1087a;
        this.f36314m = new V6.b(this.f36307f, new V6.c(context), this.f36315n, interfaceC0076b);
        this.f36316o = new Time();
        this.f36319r = new w(this.f36307f);
        this.f36320x = this.f36307f.getColor(com.oplus.blacklistapp.m.f27275c);
        this.f36302a = interfaceC0348b;
    }

    public static boolean f(CharSequence charSequence) {
        if (!l7.b.o()) {
            if (TextUtils.isEmpty(charSequence) || charSequence.equals(OplusPhoneUtils.DeviceState.INVALID_STATUS) || charSequence.equals("-2") || charSequence.equals("-3")) {
                return false;
            }
            return true;
        }
        if (TextUtils.isEmpty(charSequence) || charSequence.equals(OplusPhoneUtils.DeviceState.INVALID_STATUS) || charSequence.equals("-2") || charSequence.equals("-3") || r(charSequence)) {
            return false;
        }
        return true;
    }

    public static boolean q(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, OplusPhoneUtils.DeviceState.INVALID_STATUS) && !TextUtils.equals(charSequence, "-2") && !TextUtils.equals(charSequence, "-3")) {
            return false;
        }
        return true;
    }

    public static boolean r(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, "-100") && !TextUtils.equals(charSequence, "-101") && !TextUtils.equals(charSequence, "-102")) {
            return false;
        }
        return true;
    }

    public void A(Set<String> set) {
        this.f36321y = set;
    }

    public final void B(long j10, ImageView imageView, long j11, long j12) {
        Context context;
        if (imageView != null && (context = this.f36307f) != null) {
            if (j10 == j11) {
                Drawable drawable = context.getDrawable(com.oplus.blacklistapp.o.f27304g);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                imageView.setImageDrawable(drawable);
            } else if (j10 == j12) {
                Drawable drawable2 = context.getDrawable(com.oplus.blacklistapp.o.f27305h);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                imageView.setImageDrawable(drawable2);
            }
        }
    }

    public void C(DateFormat dateFormat) {
        this.f36304c = dateFormat;
    }

    public void D(boolean z10) {
        V6.b bVar = this.f36314m;
        if (bVar == null) {
            return;
        }
        bVar.m(z10);
    }

    public void E() {
        V6.b bVar = this.f36314m;
        if (bVar == null) {
            return;
        }
        bVar.o();
    }

    public void F(HashMap<String, String> hashMap, int i10, long j10, long j11) {
        this.f36318q = hashMap;
        this.f36311j = i10;
        this.f36312k = j10;
        this.f36313l = j11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x05e7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x06ca  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x069b  */
    /* JADX WARN: Type inference failed for: r0v115, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v50, types: [int] */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v68 */
    @Override // android.widget.CursorAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void bindView(android.view.View r32, android.content.Context r33, android.database.Cursor r34) {
        /*
            Method dump skipped, instructions count: 1786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.b.bindView(android.view.View, android.content.Context, android.database.Cursor):void");
    }

    public final CharSequence e(CharSequence charSequence, int i10) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i10), 0, charSequence.length(), 18);
        return spannableString;
    }

    public void g(int i10) {
        if (this.f36299A != 0 && i10 == 0 && this.f36300B) {
            if (C0846g.c()) {
                C0846g.i("BlockedCallsListAdapter", "changeScrollState:notifyDataSetChanged");
            }
            notifyDataSetChanged();
            this.f36300B = false;
        }
        this.f36299A = i10;
    }

    public final void h(boolean z10, CheckBox checkBox, View view) {
        a aVar = new a(z10, checkBox, view);
        if (z10) {
            if (!BlackListAppUtil.f26245b) {
                AnimationAnimationListenerC0842c.l(this.f36307f, null, 0).r(false, aVar, checkBox);
                return;
            } else {
                AnimationAnimationListenerC0842c.j(this.f36307f, null, 0).r(false, aVar, checkBox);
                return;
            }
        }
        if (!BlackListAppUtil.f26245b) {
            AnimationAnimationListenerC0842c.m(this.f36307f, null, 8).r(false, aVar, checkBox);
        } else {
            AnimationAnimationListenerC0842c.k(this.f36307f, null, 8).r(false, aVar, checkBox);
        }
    }

    public final String i(long j10) {
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = currentTimeMillis - j10;
        this.f36316o.set(currentTimeMillis);
        this.f36317p = this.f36304c.format(Long.valueOf(j10));
        Time time = this.f36316o;
        long j12 = (time.hour * 3600000) + (time.minute * 60000) + (time.second * 1000);
        if (j11 < 0) {
            return this.f36305d.format(Long.valueOf(j10));
        }
        if (j11 < j12) {
            return "-";
        }
        if (j11 < j12 + 86400000) {
            Context context = this.f36307f;
            if (context != null) {
                return String.valueOf(context.getResources().getString(com.oplus.blacklistapp.u.f27704v3));
            }
            return "";
        }
        return this.f36305d.format(Long.valueOf(j10));
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        if (this.f36306e) {
            return false;
        }
        return super.isEmpty();
    }

    public final V6.a j(Cursor cursor) {
        V6.a aVar = new V6.a();
        aVar.f4011b = X.c(cursor.getString(8));
        aVar.f4017h = cursor.getLong(10);
        aVar.f4018i = X.c(cursor.getString(14));
        aVar.f4019j = cursor.getLong(3);
        aVar.f4020k = cursor.getInt(13);
        return aVar;
    }

    public final String k(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return " " + str2;
        }
        return str;
    }

    public final String l(V6.a aVar, String str, String str2) {
        Uri uri = aVar.f4011b;
        if (!TextUtils.isEmpty(aVar.f4012c)) {
            str2 = aVar.f4012c;
        }
        if (l7.b.d() && uri == null && this.f36315n.j(str)) {
            str2 = this.f36315n.g(str);
        }
        if (TextUtils.isEmpty(str2) && aVar.f4023n) {
            return this.f36307f.getResources().getString(com.oplus.blacklistapp.u.f27711x0);
        }
        return str2;
    }

    public String m(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return context.getResources().getString(com.oplus.blacklistapp.u.f27634h3);
        }
        if (str.equals(OplusPhoneUtils.DeviceState.INVALID_STATUS)) {
            return context.getResources().getString(com.oplus.blacklistapp.u.f27634h3);
        }
        if (str.equals("-2")) {
            return context.getResources().getString(com.oplus.blacklistapp.u.f27693t2);
        }
        if (str.equals("-3")) {
            return context.getResources().getString(com.oplus.blacklistapp.u.f27663n2);
        }
        if (l7.b.o()) {
            if (str.equals("-100")) {
                return context.getResources().getString(com.oplus.blacklistapp.u.f27655m);
            }
            if (str.equals("-101")) {
                return context.getResources().getString(com.oplus.blacklistapp.u.f27639i3);
            }
            if (str.equals("-102")) {
                return context.getResources().getString(com.oplus.blacklistapp.u.f27668o2);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str2;
    }

    public void n(View view, int i10) {
        if (!p()) {
            ((BlockedCallLogAndSmsListActivity) this.f36307f).O0();
            ((BlockedCallLogAndSmsListActivity) this.f36307f).Q1();
            ((BlockedCallLogAndSmsListActivity) this.f36307f).K1("long_press");
        }
        this.f36302a.onItemClick(view, i10);
    }

    @Override // android.widget.ResourceCursorAdapter, android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(com.oplus.blacklistapp.p.f27392i, c.a(newView));
        return newView;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void o() {
        V6.b bVar = this.f36314m;
        if (bVar == null) {
            return;
        }
        bVar.k();
    }

    @Override // android.widget.CursorAdapter
    public void onContentChanged() {
        this.f36302a.h();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        Intent b10;
        if (p()) {
            this.f36302a.onItemClick(view, i10);
            return;
        }
        z zVar = (z) view.getTag();
        if (zVar != null && (b10 = zVar.b(this.f36307f)) != null) {
            String d10 = C0863y.d(b10, "matched_number");
            boolean f10 = f(d10);
            if (!f10 && ((!l7.b.o() || !r(d10)) && (!l7.b.f() || !q(d10)))) {
                Log.e("BlockedCallsListAdapter", "Cannot jump to the contact details page, canCall: " + f10);
                return;
            }
            StatisticsUtils.d(this.f36307f, "calllog_detail");
            b10.putExtra("is_from_block_list", true);
            C0849j.A(this.f36307f, b10);
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        if (p()) {
            return false;
        }
        w(false);
        try {
            n(view, i10);
        } catch (Exception unused) {
            w(true);
        }
        return true;
    }

    public boolean p() {
        return this.f36308g;
    }

    public final /* synthetic */ void s() {
        if (this.f36299A == 0) {
            notifyDataSetChanged();
        } else {
            this.f36300B = true;
        }
        if (C0846g.c()) {
            C0846g.i("BlockedCallsListAdapter", "onContactInfoChanged, mNeedPostponeDataChanged = " + this.f36300B + ",mCurrentScrollState = " + this.f36299A);
        }
    }

    public void t(boolean z10) {
        this.f36303b = z10;
    }

    public void u(boolean z10) {
        this.f36308g = z10;
    }

    public void v(DateFormat dateFormat) {
        this.f36305d = dateFormat;
    }

    public final void w(boolean z10) {
        BlockedCallLogAndSmsListActivity.g gVar = this.f36322z;
        if (gVar != null) {
            gVar.k(z10);
        }
    }

    public void x(boolean z10) {
        this.f36310i = z10;
    }

    public void y(boolean z10) {
        this.f36306e = z10;
    }

    public void z(BlockedCallLogAndSmsListActivity.g gVar) {
        this.f36322z = gVar;
    }

    /* compiled from: BlockedCallsListAdapter.java */
    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f36323a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CheckBox f36324b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f36325c;

        public a(boolean z10, CheckBox checkBox, View view) {
            this.f36323a = z10;
            this.f36324b = checkBox;
            this.f36325c = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b bVar = b.this;
            bVar.f36303b = false;
            if (!this.f36323a) {
                bVar.f36309h = true;
                this.f36324b.setVisibility(8);
                this.f36325c.setVisibility(0);
            } else {
                bVar.f36309h = false;
                this.f36324b.setVisibility(0);
            }
            if (b.this.f36310i) {
                b.this.f36310i = false;
                b.this.onContentChanged();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.f36303b = true;
            this.f36324b.setVisibility(0);
            if (this.f36323a) {
                this.f36325c.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
