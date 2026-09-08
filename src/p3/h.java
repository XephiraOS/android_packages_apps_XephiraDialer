package P3;

import Z0.b;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.util.C;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.AnimationAnimationListenerC0813y;
import com.customize.contacts.util.M;
import com.customize.contacts.util.U;
import com.oplus.dialer.R;
import java.util.List;
import kotlin.collections.C1229j;
import kotlin.jvm.internal.i;

/* compiled from: ViewGroupAdapter.kt */
/* loaded from: classes3.dex */
public final class h extends RecyclerView.Adapter<RecyclerView.B> {

    /* renamed from: q, reason: collision with root package name */
    public static final a f2913q = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f2914a;

    /* renamed from: b, reason: collision with root package name */
    public final P3.c f2915b;

    /* renamed from: c, reason: collision with root package name */
    public final Z0.b f2916c;

    /* renamed from: d, reason: collision with root package name */
    public final M.d f2917d;

    /* renamed from: e, reason: collision with root package name */
    public Cursor f2918e;

    /* renamed from: f, reason: collision with root package name */
    public int f2919f;

    /* renamed from: g, reason: collision with root package name */
    public int f2920g;

    /* renamed from: h, reason: collision with root package name */
    public int f2921h;

    /* renamed from: i, reason: collision with root package name */
    public int f2922i;

    /* renamed from: j, reason: collision with root package name */
    public int f2923j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2924k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f2925l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2926m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2927n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2928o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2929p;

    /* compiled from: ViewGroupAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: ViewGroupAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class b extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f2930a;

        /* renamed from: b, reason: collision with root package name */
        public final ImageView f2931b;

        /* renamed from: c, reason: collision with root package name */
        public final CheckBox f2932c;

        /* renamed from: d, reason: collision with root package name */
        public final LinearLayout f2933d;

        /* renamed from: e, reason: collision with root package name */
        public final View f2934e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            i.f(view, "view");
            View findViewById = view.findViewById(R.id.name);
            i.d(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.f2930a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.photo);
            i.d(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
            this.f2931b = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.listview_scrollchoice_checkbox);
            i.d(findViewById3, "null cannot be cast to non-null type android.widget.CheckBox");
            this.f2932c = (CheckBox) findViewById3;
            this.f2933d = (LinearLayout) view.findViewById(R.id.name_and_number);
            this.f2934e = view.findViewById(R.id.bottom_divider);
        }

        public final ImageView a() {
            return this.f2931b;
        }

        public final View e() {
            return this.f2934e;
        }

        public final CheckBox f() {
            return this.f2932c;
        }

        public final LinearLayout g() {
            return this.f2933d;
        }

        public final TextView h() {
            return this.f2930a;
        }
    }

    /* compiled from: ViewGroupAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class c implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckBox f2935a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f2936b;

        public c(CheckBox checkBox, h hVar) {
            this.f2935a = checkBox;
            this.f2936b = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.f(animation, "animation");
            this.f2936b.f2927n = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            i.f(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            i.f(animation, "animation");
            this.f2935a.setVisibility(0);
        }
    }

    /* compiled from: ViewGroupAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class d implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckBox f2937a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f2938b;

        public d(CheckBox checkBox, h hVar) {
            this.f2937a = checkBox;
            this.f2938b = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.f(animation, "animation");
            this.f2938b.f2927n = false;
            this.f2937a.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            i.f(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            i.f(animation, "animation");
            this.f2937a.setVisibility(0);
        }
    }

    /* compiled from: ViewGroupAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class e implements M.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ M.d f2939a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2940b;

        public e(M.d dVar, int i10) {
            this.f2939a = dVar;
            this.f2940b = i10;
        }

        @Override // com.customize.contacts.util.M.e
        public void onClick(View view) {
            i.f(view, "view");
            this.f2939a.G0(view, this.f2940b, 0);
        }

        @Override // com.customize.contacts.util.M.e
        public void onLongClick(View view, int i10, int i11) {
            i.f(view, "view");
            if (C7.a.a()) {
                return;
            }
            this.f2939a.c0(view, this.f2940b, 0, i10, i11);
        }

        @Override // com.customize.contacts.util.M.e
        public boolean onTouch(View v10, MotionEvent event) {
            i.f(v10, "v");
            i.f(event, "event");
            this.f2939a.V0(v10, event);
            return false;
        }
    }

    public h(Context context, P3.c contactsManager, Z0.b photoManager, M.d pressListener) {
        i.f(contactsManager, "contactsManager");
        i.f(photoManager, "photoManager");
        i.f(pressListener, "pressListener");
        this.f2914a = context;
        this.f2915b = contactsManager;
        this.f2916c = photoManager;
        this.f2917d = pressListener;
        this.f2921h = -1;
        this.f2922i = -1;
        this.f2923j = -1;
        this.f2928o = true;
        if (context != null) {
            this.f2925l = context.getText(R.string.missing_name);
            this.f2919f = context.getResources().getDimensionPixelOffset(R.dimen.DP_19);
            this.f2920g = context.getResources().getDimensionPixelOffset(R.dimen.DP_19);
        }
        o(this.f2918e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Cursor cursor = this.f2918e;
        if (cursor != null) {
            return cursor.getCount();
        }
        return 0;
    }

    public final void h(View view, b bVar, long j10) {
        CheckBox f10 = bVar.f();
        IdRecord idRecord = null;
        boolean z10 = false;
        if (this.f2926m) {
            if (this.f2927n) {
                if (f10.getVisibility() != 0) {
                    AnimationAnimationListenerC0813y.i(this.f2914a, null, 0).u(false, new c(f10, this), f10);
                }
            } else {
                f10.setVisibility(0);
            }
            P3.c cVar = this.f2915b;
            if ((cVar.f2890b && !cVar.f(j10)) || cVar.e(j10)) {
                z10 = true;
            }
            f10.setChecked(z10);
            Object tag = f10.getTag();
            if (tag instanceof IdRecord) {
                idRecord = (IdRecord) tag;
            }
            if (idRecord == null) {
                f10.setTag(new IdRecord(j10));
            } else {
                idRecord.m(j10);
            }
            C.b(view, f10.isChecked());
            return;
        }
        if (this.f2927n) {
            if (f10.getVisibility() == 0) {
                AnimationAnimationListenerC0813y.n(this.f2914a, null, 8).u(false, new d(f10, this), f10);
            }
        } else {
            f10.setVisibility(8);
        }
        Object tag2 = f10.getTag();
        if (tag2 instanceof IdRecord) {
            idRecord = (IdRecord) tag2;
        }
        if (idRecord == null) {
            f10.setTag(new IdRecord(j10));
        } else {
            idRecord.m(j10);
        }
        f10.setChecked(false);
        C.b(view, false);
    }

    public final void i(TextView textView, Cursor cursor, int i10) {
        String str;
        if (i10 != -1) {
            if (cursor != null) {
                str = cursor.getString(i10);
            } else {
                str = null;
            }
            if (str == null) {
                str = String.valueOf(this.f2925l);
            }
            if (C0637b.h()) {
                str = C0637b.c(str);
            }
            textView.setText(str);
        }
    }

    public final void j(b bVar, int i10) {
        long j10;
        Cursor cursor = this.f2918e;
        if (cursor != null) {
            cursor.moveToPosition(i10);
        }
        i(bVar.h(), this.f2918e, this.f2923j);
        Cursor cursor2 = this.f2918e;
        if (cursor2 != null) {
            j10 = cursor2.getLong(this.f2921h);
        } else {
            j10 = -1;
        }
        boolean z10 = false;
        if (U.d()) {
            k(bVar.a(), this.f2918e, j10);
            bVar.a().setVisibility(0);
        } else {
            bVar.a().setVisibility(8);
        }
        View view = bVar.itemView;
        i.e(view, "viewHolder.itemView");
        h(view, bVar, j10);
        Cursor cursor3 = this.f2918e;
        if (cursor3 != null && cursor3.isLast()) {
            View e10 = bVar.e();
            if (e10 != null) {
                e10.setVisibility(8);
            }
        } else {
            View e11 = bVar.e();
            if (e11 != null) {
                e11.setVisibility(0);
            }
        }
        M.d dVar = this.f2917d;
        bVar.itemView.setTag(R.id.group_list_item_position, Integer.valueOf(i10));
        View view2 = bVar.itemView;
        if (!this.f2929p || this.f2926m) {
            z10 = true;
        }
        M.d(view2, z10, new e(dVar, i10));
    }

    public final void k(ImageView imageView, Cursor cursor, long j10) {
        long j11;
        b.c cVar;
        Drawable drawable;
        if (imageView != null) {
            Context context = this.f2914a;
            if (context != null) {
                drawable = context.getDrawable(R.drawable.pb_bg_transparent);
            } else {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
        }
        if (j10 == -1) {
            return;
        }
        if (cursor != null && !cursor.isNull(this.f2922i)) {
            j11 = cursor.getLong(this.f2922i);
        } else {
            j11 = 0;
        }
        if (j11 == 0) {
            cVar = n(cursor, this.f2923j, Long.valueOf(j10));
        } else {
            cVar = null;
        }
        this.f2916c.q(imageView, j11, false, false, cVar);
    }

    public final void l(Cursor cursor) {
        if (cursor != null) {
            q(false);
            o(cursor);
        }
        u(cursor);
        this.f2916c.t();
    }

    public final Cursor m() {
        return this.f2918e;
    }

    public final b.c n(Cursor cursor, int i10, Long l10) {
        String str;
        String str2 = null;
        if (cursor != null && !cursor.isNull(i10)) {
            str = cursor.getString(i10);
        } else {
            str = null;
        }
        if (l10 != null) {
            str2 = l10.toString();
        }
        return new b.c(str, str2, false);
    }

    public final void o(Cursor cursor) {
        int columnIndex;
        List list;
        String[] columnNames;
        if (H7.a.b()) {
            if (cursor != null && (columnNames = cursor.getColumnNames()) != null) {
                list = C1229j.K(columnNames);
            } else {
                list = null;
            }
            H7.b.b("ViewGroupAdapter", "resolveColumnIndexes : " + list);
        }
        if (cursor != null) {
            this.f2921h = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
            this.f2922i = cursor.getColumnIndex("photo_id");
            if (this.f2924k) {
                columnIndex = cursor.getColumnIndex("display_name_alt");
                if (columnIndex == -1) {
                    columnIndex = cursor.getColumnIndex("display_name");
                }
            } else {
                columnIndex = cursor.getColumnIndex("display_name");
            }
            this.f2923j = columnIndex;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
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
            boolean r0 = r4 instanceof P3.h.b
            if (r0 == 0) goto L4d
            android.database.Cursor r0 = r3.f2918e
            r1 = 0
            if (r0 == 0) goto L20
            boolean r2 = r0.isClosed()
            if (r2 != 0) goto L15
            goto L16
        L15:
            r0 = r1
        L16:
            if (r0 == 0) goto L20
            P3.h$b r4 = (P3.h.b) r4
            r3.j(r4, r5)
            m9.q r4 = m9.q.f35511a
            goto L21
        L20:
            r4 = r1
        L21:
            if (r4 != 0) goto L4d
            android.database.Cursor r3 = r3.f2918e
            if (r3 == 0) goto L2f
            boolean r4 = r3.isClosed()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)
        L2f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "cursor = "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = " isClosed = "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r3 = r4.toString()
            java.lang.String r4 = "ViewGroupAdapter"
            H7.b.c(r4, r3)
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.h.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$B, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.B onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        View inflate = LayoutInflater.from(this.f2914a).inflate(R.layout.view_group_list_item, parent, false);
        i.e(inflate, "from(context).inflate(R.…list_item, parent, false)");
        b bVar = new b(inflate);
        bVar.a().setScaleType(ImageView.ScaleType.CENTER_CROP);
        LinearLayout g10 = bVar.g();
        if (g10 != null) {
            g10.setPadding(0, this.f2919f, 0, this.f2920g);
        }
        return bVar;
    }

    public final void p(boolean z10) {
        this.f2924k = z10;
    }

    public final void q(boolean z10) {
        this.f2928o = z10;
    }

    public final void r(boolean z10) {
        this.f2926m = z10;
    }

    public final void s(boolean z10) {
        this.f2927n = z10;
    }

    public final void t(boolean z10) {
        this.f2929p = z10;
    }

    public final void u(Cursor cursor) {
        if (i.b(cursor, this.f2918e)) {
            return;
        }
        this.f2918e = cursor;
        notifyDataSetChanged();
    }
}
