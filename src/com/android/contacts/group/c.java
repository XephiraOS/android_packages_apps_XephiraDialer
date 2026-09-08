package com.android.contacts.group;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.model.AccountType;
import com.android.contacts.util.C;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.customize.contacts.util.AnimationAnimationListenerC0813y;
import com.customize.contacts.util.G;
import com.oplus.dialer.R;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.text.n;
import n1.AbstractC1362a;

/* compiled from: GroupBrowseListAdapter.kt */
/* loaded from: classes.dex */
public final class c extends RecyclerView.Adapter<C0169c> {

    /* renamed from: k, reason: collision with root package name */
    public static final a f16646k = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public Context f16647a;

    /* renamed from: b, reason: collision with root package name */
    public List<j> f16648b;

    /* renamed from: c, reason: collision with root package name */
    public G f16649c;

    /* renamed from: d, reason: collision with root package name */
    public AbstractC1362a f16650d;

    /* renamed from: e, reason: collision with root package name */
    public Uri f16651e;

    /* renamed from: f, reason: collision with root package name */
    public String f16652f;

    /* renamed from: g, reason: collision with root package name */
    public View.OnTouchListener f16653g = new View.OnTouchListener() { // from class: com.android.contacts.group.b
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            boolean r10;
            r10 = c.r(view, motionEvent);
            return r10;
        }
    };

    /* renamed from: h, reason: collision with root package name */
    public boolean f16654h = true;

    /* renamed from: i, reason: collision with root package name */
    public int f16655i;

    /* renamed from: j, reason: collision with root package name */
    public b f16656j;

    /* compiled from: GroupBrowseListAdapter.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final Uri a(long j10) {
            Uri withAppendedId = ContentUris.withAppendedId(ContactsContract.Groups.CONTENT_URI, j10);
            kotlin.jvm.internal.i.e(withAppendedId, "withAppendedId(ContactsC…ups.CONTENT_URI, groupId)");
            return withAppendedId;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: GroupBrowseListAdapter.kt */
    /* loaded from: classes.dex */
    public interface b {
        void m0(View view);
    }

    /* compiled from: GroupBrowseListAdapter.kt */
    /* renamed from: com.android.contacts.group.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0169c extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public TextView f16657a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f16658b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f16659c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f16660d;

        /* renamed from: e, reason: collision with root package name */
        public View f16661e;

        /* renamed from: f, reason: collision with root package name */
        public CheckBox f16662f;

        /* renamed from: g, reason: collision with root package name */
        public ImageView f16663g;

        /* renamed from: h, reason: collision with root package name */
        public View f16664h;

        /* renamed from: i, reason: collision with root package name */
        public View f16665i;

        /* renamed from: j, reason: collision with root package name */
        public int f16666j;

        /* renamed from: k, reason: collision with root package name */
        public String f16667k;

        /* renamed from: l, reason: collision with root package name */
        public long f16668l;

        /* renamed from: m, reason: collision with root package name */
        public Uri f16669m;

        /* renamed from: n, reason: collision with root package name */
        public int f16670n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0169c(View view) {
            super(view);
            TextView textView;
            TextView textView2;
            kotlin.jvm.internal.i.f(view, "view");
            this.f16670n = -1;
            this.f16661e = view.findViewById(R.id.group_list_header);
            View findViewById = view.findViewById(R.id.account_type);
            if (findViewById instanceof TextView) {
                textView = (TextView) findViewById;
            } else {
                textView = null;
            }
            this.f16657a = textView;
            View findViewById2 = view.findViewById(R.id.account_name);
            if (findViewById2 instanceof TextView) {
                textView2 = (TextView) findViewById2;
            } else {
                textView2 = null;
            }
            this.f16658b = textView2;
            View findViewById3 = view.findViewById(R.id.label);
            kotlin.jvm.internal.i.d(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView3 = (TextView) findViewById3;
            this.f16659c = textView3;
            textView3.setTextDirection(5);
            View findViewById4 = view.findViewById(R.id.count);
            kotlin.jvm.internal.i.d(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
            this.f16660d = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.listview_scrollchoice_checkbox);
            this.f16662f = findViewById5 instanceof CheckBox ? (CheckBox) findViewById5 : null;
            View findViewById6 = view.findViewById(R.id.jump_button);
            kotlin.jvm.internal.i.d(findViewById6, "null cannot be cast to non-null type android.widget.ImageView");
            this.f16663g = (ImageView) findViewById6;
            View findViewById7 = view.findViewById(R.id.group_detail);
            kotlin.jvm.internal.i.c(findViewById7);
            this.f16664h = findViewById7;
            this.f16665i = view.findViewById(R.id.bottom_divider);
        }

        public final View e() {
            return this.f16661e;
        }

        public final TextView f() {
            return this.f16658b;
        }

        public final TextView g() {
            return this.f16657a;
        }

        public final String h() {
            return this.f16667k;
        }

        public final View i() {
            return this.f16665i;
        }

        public final CheckBox j() {
            return this.f16662f;
        }

        public final View k() {
            return this.f16664h;
        }

        public final long l() {
            return this.f16668l;
        }

        public final TextView m() {
            return this.f16660d;
        }

        public final String n() {
            return this.f16659c.getText().toString();
        }

        public final TextView o() {
            return this.f16659c;
        }

        public final ImageView p() {
            return this.f16663g;
        }

        public final int q() {
            return this.f16666j;
        }

        public final Uri r() {
            return this.f16669m;
        }

        public final void s(String str) {
            this.f16667k = str;
        }

        public final void t(long j10) {
            this.f16668l = j10;
        }

        public final void u(int i10) {
            this.f16666j = i10;
        }

        public final void v(Uri uri) {
            this.f16669m = uri;
        }

        public final void w(int i10) {
            this.f16670n = i10;
        }
    }

    /* compiled from: GroupBrowseListAdapter.kt */
    /* loaded from: classes.dex */
    public static final class d implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0169c f16671a;

        public d(C0169c c0169c) {
            this.f16671a = c0169c;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            ImageView p10 = this.f16671a.p();
            if (p10 != null) {
                p10.setVisibility(8);
            }
            CheckBox j10 = this.f16671a.j();
            if (j10 != null) {
                j10.setVisibility(0);
            }
        }
    }

    /* compiled from: GroupBrowseListAdapter.kt */
    /* loaded from: classes.dex */
    public static final class e implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0169c f16672a;

        public e(C0169c c0169c) {
            this.f16672a = c0169c;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            ImageView p10 = this.f16672a.p();
            if (p10 != null) {
                p10.setVisibility(0);
            }
            CheckBox j10 = this.f16672a.j();
            if (j10 != null) {
                j10.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            ImageView p10 = this.f16672a.p();
            if (p10 != null) {
                p10.setVisibility(8);
            }
            CheckBox j10 = this.f16672a.j();
            if (j10 != null) {
                j10.setVisibility(0);
            }
        }
    }

    public c(Context context, List<j> list) {
        this.f16647a = context;
        this.f16648b = list;
        this.f16650d = AbstractC1362a.h(context);
    }

    public static final void l(c this$0, View view, View view2) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(view, "$view");
        this$0.q(view);
    }

    public static final boolean r(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<j> list = this.f16648b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        j jVar;
        List<j> list = this.f16648b;
        if (list != null) {
            jVar = list.get(i10);
        } else {
            jVar = null;
        }
        if (jVar == null) {
            return 2;
        }
        if (jVar.g() && jVar.h()) {
            return 4;
        }
        if (jVar.g()) {
            return 1;
        }
        if (!jVar.h()) {
            return 2;
        }
        return 3;
    }

    public final void i(j jVar, C0169c c0169c) {
        AccountType accountType;
        Object b10;
        String k10;
        AbstractC1362a abstractC1362a = this.f16650d;
        CharSequence charSequence = null;
        if (abstractC1362a != null) {
            accountType = abstractC1362a.c(jVar.b(), jVar.c());
        } else {
            accountType = null;
        }
        if (kotlin.jvm.internal.i.b(jVar.a(), R0.a.f3165a)) {
            TextView g10 = c0169c.g();
            if (g10 != null) {
                g10.setText(R.string.locale_tablet);
            }
            TextView f10 = c0169c.f();
            if (f10 != null) {
                f10.setVisibility(8);
                return;
            }
            return;
        }
        TextView g11 = c0169c.g();
        if (g11 != null) {
            try {
                Result.a aVar = Result.f34166a;
                if (accountType != null) {
                    charSequence = accountType.f(this.f16647a);
                }
                String lowerCase = String.valueOf(charSequence).toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.i.e(lowerCase, "toLowerCase(...)");
                k10 = n.k(lowerCase);
                b10 = Result.b(k10);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            String b11 = jVar.b();
            if (Result.f(b10)) {
                b10 = b11;
            }
            g11.setText((CharSequence) b10);
        }
        TextView f11 = c0169c.f();
        if (f11 != null) {
            f11.setVisibility(0);
        }
        TextView f12 = c0169c.f();
        if (f12 != null) {
            f12.setText(jVar.a());
        }
    }

    public final C0169c j(int i10) {
        C0169c c0169c = new C0169c(new k(this.f16647a));
        k(c0169c.k());
        c0169c.w(i10);
        c0169c.k().setTag(c0169c);
        if (i10 != 1 && i10 != 2) {
            View i11 = c0169c.i();
            if (i11 != null) {
                i11.setVisibility(8);
            }
        } else {
            View i12 = c0169c.i();
            if (i12 != null) {
                i12.setVisibility(0);
            }
        }
        COUICardListHelper.setItemCardBackground(c0169c.k(), i10);
        return c0169c;
    }

    public final void k(final View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.group.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.l(c.this, view, view2);
            }
        });
    }

    public final Uri m() {
        return this.f16651e;
    }

    public final String n() {
        return this.f16652f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C0169c holder, int i10) {
        j jVar;
        kotlin.jvm.internal.i.f(holder, "holder");
        List<j> list = this.f16648b;
        G g10 = null;
        if (list != null) {
            jVar = list.get(i10);
        } else {
            jVar = null;
        }
        kotlin.jvm.internal.i.c(jVar);
        if (jVar.g()) {
            i(jVar, holder);
            View e10 = holder.e();
            if (e10 != null) {
                e10.setVisibility(0);
            }
        } else {
            View e11 = holder.e();
            if (e11 != null) {
                e11.setVisibility(8);
            }
        }
        View e12 = holder.e();
        if (e12 != null) {
            e12.setOnTouchListener(this.f16653g);
        }
        Uri a10 = f16646k.a(jVar.d());
        String c10 = Z3.g.c(this.f16647a, jVar.e());
        holder.v(a10);
        String f10 = jVar.f();
        if (!TextUtils.isEmpty(f10)) {
            holder.o().setText(f10);
        }
        holder.m().setText(c10);
        holder.u(jVar.e());
        holder.t(jVar.d());
        G g11 = this.f16649c;
        if (g11 == null) {
            kotlin.jvm.internal.i.q("editModeHandler");
            g11 = null;
        }
        if (g11.g()) {
            CheckBox j10 = holder.j();
            if (j10 != null && j10.getVisibility() == 0) {
                ImageView p10 = holder.p();
                if (p10 != null) {
                    p10.setVisibility(8);
                }
                CheckBox j11 = holder.j();
                if (j11 != null) {
                    j11.setVisibility(0);
                }
            } else if (this.f16654h) {
                d dVar = new d(holder);
                ImageView p11 = holder.p();
                if (p11 != null) {
                    p11.setVisibility(8);
                }
                AnimationAnimationListenerC0813y.i(this.f16647a, null, 0).u(false, dVar, holder.j());
            } else {
                ImageView p12 = holder.p();
                if (p12 != null) {
                    p12.setVisibility(8);
                }
                CheckBox j12 = holder.j();
                if (j12 != null) {
                    j12.setVisibility(0);
                }
            }
            CheckBox j13 = holder.j();
            if (j13 != null) {
                j13.setTag(jVar);
            }
            G g12 = this.f16649c;
            if (g12 == null) {
                kotlin.jvm.internal.i.q("editModeHandler");
            } else {
                g10 = g12;
            }
            boolean f11 = g10.f(jVar.d());
            CheckBox j14 = holder.j();
            if (j14 != null) {
                j14.setChecked(f11);
            }
            C.b(holder.k(), f11);
            return;
        }
        CheckBox j15 = holder.j();
        if (j15 != null && j15.getVisibility() == 0) {
            if (this.f16654h) {
                AnimationAnimationListenerC0813y.n(this.f16647a, null, 8).u(false, new e(holder), holder.j());
            } else {
                ImageView p13 = holder.p();
                if (p13 != null) {
                    p13.setVisibility(0);
                }
                CheckBox j16 = holder.j();
                if (j16 != null) {
                    j16.setVisibility(8);
                }
            }
        } else {
            ImageView p14 = holder.p();
            if (p14 != null) {
                p14.setVisibility(0);
            }
            CheckBox j17 = holder.j();
            if (j17 != null) {
                j17.setVisibility(8);
            }
        }
        CheckBox j18 = holder.j();
        if (j18 != null) {
            j18.setChecked(false);
        }
        C.b(holder.k(), false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0169c onCreateViewHolder(ViewGroup parent, int i10) {
        kotlin.jvm.internal.i.f(parent, "parent");
        if (i10 != 1) {
            if (i10 != 3) {
                if (i10 != 4) {
                    return j(2);
                }
                return j(4);
            }
            return j(3);
        }
        return j(1);
    }

    public final void q(View view) {
        b bVar = this.f16656j;
        if (bVar != null) {
            bVar.m0(view);
        }
    }

    public final void s(G handler) {
        kotlin.jvm.internal.i.f(handler, "handler");
        this.f16649c = handler;
    }

    public final void t(List<j> list) {
        kotlin.jvm.internal.i.f(list, "list");
        this.f16648b = list;
        if (this.f16651e == null && (!list.isEmpty())) {
            j jVar = list.get(0);
            this.f16651e = f16646k.a(jVar.d());
            this.f16652f = jVar.f();
        }
    }

    public final void u(b listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        this.f16656j = listener;
    }

    public final void v(Uri uri) {
        this.f16651e = uri;
    }

    public final void w(String str) {
        this.f16652f = str;
    }

    public final void x(boolean z10) {
        this.f16654h = z10;
    }

    public final void y(Integer num) {
        if (num != null) {
            this.f16655i = num.intValue();
        }
    }
}
