package N3;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.util.C;
import com.oplus.dialer.R;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: GroupListAdapter.kt */
/* loaded from: classes3.dex */
public class d extends RecyclerView.Adapter<RecyclerView.B> {

    /* renamed from: l, reason: collision with root package name */
    public static final a f2308l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f2309a;

    /* renamed from: b, reason: collision with root package name */
    public Cursor f2310b;

    /* renamed from: c, reason: collision with root package name */
    public final c f2311c;

    /* renamed from: d, reason: collision with root package name */
    public final b f2312d;

    /* renamed from: e, reason: collision with root package name */
    public int f2313e;

    /* renamed from: f, reason: collision with root package name */
    public HashSet<Long> f2314f;

    /* renamed from: g, reason: collision with root package name */
    public int f2315g;

    /* renamed from: h, reason: collision with root package name */
    public HashMap<Long, Integer> f2316h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2317i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2318j;

    /* renamed from: k, reason: collision with root package name */
    public final ContentObserver f2319k;

    /* compiled from: GroupListAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: GroupListAdapter.kt */
    /* loaded from: classes3.dex */
    public interface b {
        void onItemClick(View view, int i10);
    }

    /* compiled from: GroupListAdapter.kt */
    /* loaded from: classes3.dex */
    public interface c {
        void onContentChanged();
    }

    /* compiled from: GroupListAdapter.kt */
    /* renamed from: N3.d$d, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0048d extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f2320a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f2321b;

        /* renamed from: c, reason: collision with root package name */
        public final CheckBox f2322c;

        /* renamed from: d, reason: collision with root package name */
        public final View f2323d;

        /* renamed from: e, reason: collision with root package name */
        public final RelativeLayout f2324e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0048d(View view) {
            super(view);
            kotlin.jvm.internal.i.f(view, "view");
            View findViewById = view.findViewById(R.id.name);
            kotlin.jvm.internal.i.d(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.f2320a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.label);
            kotlin.jvm.internal.i.d(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.f2321b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.check_box);
            kotlin.jvm.internal.i.d(findViewById3, "null cannot be cast to non-null type android.widget.CheckBox");
            this.f2322c = (CheckBox) findViewById3;
            this.f2323d = view.findViewById(R.id.bottom_divider);
            this.f2324e = (RelativeLayout) view.findViewById(R.id.group_list_layout);
        }

        public final View e() {
            return this.f2323d;
        }

        public final CheckBox f() {
            return this.f2322c;
        }

        public final RelativeLayout g() {
            return this.f2324e;
        }

        public final TextView h() {
            return this.f2321b;
        }

        public final TextView i() {
            return this.f2320a;
        }
    }

    /* compiled from: GroupListAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class e extends ContentObserver {
        public e(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            d.this.p();
        }
    }

    public d(Context context, Cursor cursor, c contentChangeListener, b itemClickListener) {
        kotlin.jvm.internal.i.f(contentChangeListener, "contentChangeListener");
        kotlin.jvm.internal.i.f(itemClickListener, "itemClickListener");
        this.f2309a = context;
        this.f2310b = cursor;
        this.f2311c = contentChangeListener;
        this.f2312d = itemClickListener;
        this.f2314f = new HashSet<>();
        this.f2319k = new e(new Handler(Looper.getMainLooper()));
    }

    public static final void j(d this$0, int i10, View it) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        b bVar = this$0.f2312d;
        kotlin.jvm.internal.i.e(it, "it");
        bVar.onItemClick(it, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        if (this.f2317i) {
            if (H7.a.b()) {
                H7.b.e("GroupListAdapter", "---onContentChanged return---");
            }
            s(true);
            return;
        }
        this.f2311c.onContentChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Cursor cursor = this.f2310b;
        if (cursor != null) {
            return cursor.getCount();
        }
        return 0;
    }

    public void i(C0048d holder, Context context, Cursor cursor, final int i10) {
        kotlin.jvm.internal.i.f(holder, "holder");
        kotlin.jvm.internal.i.f(cursor, "cursor");
        holder.itemView.setTag(R.id.group_list_item_position, Integer.valueOf(i10));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: N3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.j(d.this, i10, view);
            }
        });
        long j10 = cursor.getLong(0);
        boolean z10 = true;
        String string = cursor.getString(1);
        if (!TextUtils.isEmpty(string)) {
            holder.i().setText(string);
        }
        if (3 == this.f2313e) {
            holder.f().setVisibility(0);
        } else {
            holder.f().setVisibility(8);
        }
        if (cursor.isLast()) {
            View e10 = holder.e();
            if (e10 != null) {
                e10.setVisibility(8);
            }
        } else {
            View e11 = holder.e();
            if (e11 != null) {
                e11.setVisibility(0);
            }
        }
        int count = cursor.getCount();
        if (i10 >= 0 && i10 < count) {
            int i11 = cursor.getInt(2);
            if (i11 <= 0) {
                holder.h().setText(Z3.g.c(context, 0));
                r(holder.g(), false);
                H7.b.e("GroupListAdapter", "bindView(), the memberCount is invalidate, the memberCount is 0");
            } else {
                holder.h().setText(Z3.g.c(context, i11));
                r(holder.g(), true);
            }
            CheckBox f10 = holder.f();
            if (!this.f2314f.contains(Long.valueOf(j10))) {
                z10 = false;
            }
            f10.setChecked(z10);
            if (holder.f().getVisibility() == 0) {
                C.b(holder.itemView, holder.f().isChecked());
                return;
            } else {
                if (holder.f().getVisibility() == 8) {
                    C.b(holder.itemView, false);
                    return;
                }
                return;
            }
        }
        H7.b.i("GroupListAdapter", "bindView(), cursor position is invalidate, position = " + i10 + " cursor count is " + cursor.getCount());
    }

    public final void k(Cursor cursor) {
        if (kotlin.jvm.internal.i.b(this.f2310b, cursor)) {
            return;
        }
        Cursor cursor2 = this.f2310b;
        this.f2310b = cursor;
        if (cursor2 != null) {
            cursor2.unregisterContentObserver(this.f2319k);
        }
        Cursor cursor3 = this.f2310b;
        if (cursor3 != null) {
            cursor3.registerContentObserver(this.f2319k);
        }
        notifyDataSetChanged();
    }

    public final Cursor l() {
        return this.f2310b;
    }

    public int m() {
        if (this.f2315g < 0) {
            this.f2315g = 0;
        }
        return this.f2315g;
    }

    public HashSet<Long> n() {
        return this.f2314f;
    }

    public boolean o() {
        return this.f2318j;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.B r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.i.f(r4, r0)
            boolean r0 = r4 instanceof N3.d.C0048d
            if (r0 == 0) goto L52
            android.database.Cursor r0 = r3.f2310b
            r1 = 0
            if (r0 == 0) goto L25
            boolean r2 = r0.isClosed()
            if (r2 != 0) goto L15
            goto L16
        L15:
            r0 = r1
        L16:
            if (r0 == 0) goto L25
            r0.moveToPosition(r5)
            N3.d$d r4 = (N3.d.C0048d) r4
            android.content.Context r2 = r3.f2309a
            r3.i(r4, r2, r0, r5)
            m9.q r4 = m9.q.f35511a
            goto L26
        L25:
            r4 = r1
        L26:
            if (r4 != 0) goto L52
            android.database.Cursor r3 = r3.f2310b
            if (r3 == 0) goto L34
            boolean r4 = r3.isClosed()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)
        L34:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "cursor = "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = " isClosed = "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r3 = r4.toString()
            java.lang.String r4 = "GroupListAdapter"
            H7.b.c(r4, r3)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.d.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$B, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.B onCreateViewHolder(ViewGroup parent, int i10) {
        kotlin.jvm.internal.i.f(parent, "parent");
        View inflate = LayoutInflater.from(this.f2309a).inflate(R.layout.group_list_item, (ViewGroup) null, false);
        kotlin.jvm.internal.i.e(inflate, "from(context).inflate(R.…p_list_item, null, false)");
        return new C0048d(inflate);
    }

    public void q(boolean z10) {
        int i10;
        long j10;
        this.f2314f.clear();
        Cursor cursor = this.f2310b;
        int i11 = 0;
        if (cursor != null) {
            i10 = cursor.getCount();
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            return;
        }
        if (z10) {
            Cursor cursor2 = this.f2310b;
            if (cursor2 != null) {
                cursor2.moveToPosition(-1);
            }
            while (true) {
                Cursor cursor3 = this.f2310b;
                if (cursor3 == null || !cursor3.moveToNext()) {
                    break;
                }
                HashSet<Long> hashSet = this.f2314f;
                Cursor cursor4 = this.f2310b;
                if (cursor4 != null) {
                    j10 = cursor4.getLong(0);
                } else {
                    j10 = 0;
                }
                hashSet.add(Long.valueOf(j10));
            }
        }
        if (z10) {
            i11 = i10;
        }
        this.f2315g = i11;
        notifyDataSetChanged();
    }

    public final void r(RelativeLayout relativeLayout, boolean z10) {
        if (H7.a.b()) {
            H7.b.b("GroupListAdapter", "setGroupItemViewEnabled enabled = " + z10);
        }
        if (relativeLayout == null) {
            return;
        }
        if (z10) {
            relativeLayout.setEnabled(true);
            relativeLayout.setAlpha(1.0f);
        } else {
            relativeLayout.setEnabled(false);
            relativeLayout.setAlpha(0.3f);
        }
    }

    public void s(boolean z10) {
        this.f2318j = z10;
    }

    public void t() {
        this.f2313e = 3;
    }

    public void u(boolean z10) {
        this.f2317i = z10;
    }

    public void v(long j10, boolean z10, long j11) {
        if (0 == j11) {
            return;
        }
        if (z10) {
            if (!this.f2314f.contains(Long.valueOf(j10))) {
                this.f2314f.add(Long.valueOf(j10));
                this.f2315g += (int) j11;
            }
        } else if (this.f2314f.contains(Long.valueOf(j10))) {
            this.f2314f.remove(Long.valueOf(j10));
            this.f2315g -= (int) j11;
        }
        notifyDataSetChanged();
    }

    public void w(Cursor cursor) {
        if (cursor != null) {
            int count = cursor.getCount();
            int i10 = 0;
            if (count <= 0) {
                this.f2314f.clear();
                this.f2315g = 0;
                return;
            }
            if (H7.a.b()) {
                H7.b.b("GroupListAdapter", "count = " + count);
            }
            if (this.f2316h == null) {
                this.f2316h = new HashMap<>(count);
            }
            HashSet hashSet = new HashSet();
            if (this.f2314f.size() > 0) {
                cursor.moveToPosition(-1);
                int i11 = 0;
                while (cursor.moveToNext()) {
                    long j10 = cursor.getLong(0);
                    int i12 = cursor.getInt(2);
                    if (this.f2314f.contains(Long.valueOf(j10))) {
                        hashSet.add(Long.valueOf(j10));
                        i11 += i12;
                    }
                }
                i10 = i11;
            }
            this.f2314f.clear();
            this.f2314f.addAll(hashSet);
            hashSet.clear();
            this.f2315g = i10;
        }
    }
}
