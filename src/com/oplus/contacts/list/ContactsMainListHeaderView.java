package com.oplus.contacts.list;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.q;
import com.android.contacts.framework.baseui.util.r;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.oplus.contacts.list.ContactsMainListHeaderView;
import com.oplus.dialer.R;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.F;
import kotlinx.coroutines.G0;
import kotlinx.coroutines.S;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.n;
import x0.AbstractC1669g;

/* compiled from: ContactsMainListHeaderView.kt */
/* loaded from: classes3.dex */
public final class ContactsMainListHeaderView extends LinearLayout implements InterfaceC0492o {

    /* renamed from: g, reason: collision with root package name */
    public static final a f27835g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    public static String[] f27836h = {"data15", "data1"};

    /* renamed from: a, reason: collision with root package name */
    public E f27837a;

    /* renamed from: b, reason: collision with root package name */
    public final i<c> f27838b;

    /* renamed from: c, reason: collision with root package name */
    public final q f27839c;

    /* renamed from: d, reason: collision with root package name */
    public AbstractC1669g f27840d;

    /* renamed from: e, reason: collision with root package name */
    public b f27841e;

    /* renamed from: f, reason: collision with root package name */
    public final ContactsMainListHeaderView$contactsMainListReceiver$1 f27842f;

    /* compiled from: ContactsMainListHeaderView.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: ContactsMainListHeaderView.kt */
    /* loaded from: classes3.dex */
    public interface b {
        void O0();

        void R();
    }

    /* compiled from: ContactsMainListHeaderView.kt */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f27843a;

        /* renamed from: b, reason: collision with root package name */
        public int f27844b;

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            this(false, 0 == true ? 1 : 0, 3, null);
        }

        public static /* synthetic */ c b(c cVar, boolean z10, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z10 = cVar.f27843a;
            }
            if ((i11 & 2) != 0) {
                i10 = cVar.f27844b;
            }
            return cVar.a(z10, i10);
        }

        public final c a(boolean z10, int i10) {
            return new c(z10, i10);
        }

        public final int c() {
            return this.f27844b;
        }

        public final boolean d() {
            return this.f27843a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f27843a == cVar.f27843a && this.f27844b == cVar.f27844b) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z10 = this.f27843a;
            ?? r02 = z10;
            if (z10) {
                r02 = 1;
            }
            return (r02 * 31) + Integer.hashCode(this.f27844b);
        }

        public String toString() {
            return "ProfileIconLoad(visible=" + this.f27843a + ", iconChangeIndex=" + this.f27844b + ")";
        }

        public c(boolean z10, int i10) {
            this.f27843a = z10;
            this.f27844b = i10;
        }

        public /* synthetic */ c(boolean z10, int i10, int i11, kotlin.jvm.internal.f fVar) {
            this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? 0 : i10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.oplus.contacts.list.ContactsMainListHeaderView$contactsMainListReceiver$1] */
    public ContactsMainListHeaderView(Context context, AttributeSet attr) {
        super(context, attr);
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(attr, "attr");
        this.f27838b = n.a(new c(false, 0 == true ? 1 : 0, 3, null));
        this.f27839c = new q(this);
        this.f27842f = new BroadcastReceiver() { // from class: com.oplus.contacts.list.ContactsMainListHeaderView$contactsMainListReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                String str;
                i iVar;
                Object value;
                ContactsMainListHeaderView.c cVar;
                if (intent != null) {
                    str = intent.getAction();
                } else {
                    str = null;
                }
                if (str != null && str.hashCode() == 1460229579 && str.equals("profile_lookup_uri_update")) {
                    iVar = ContactsMainListHeaderView.this.f27838b;
                    do {
                        value = iVar.getValue();
                        cVar = (ContactsMainListHeaderView.c) value;
                    } while (!iVar.c(value, ContactsMainListHeaderView.c.b(cVar, false, cVar.c() + 1, 1, null)));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E getViewScope() {
        if (this.f27837a == null) {
            this.f27837a = F.a(G0.b(null, 1, null).r(S.c().i0()));
        }
        return this.f27837a;
    }

    public static final void j(ContactsMainListHeaderView this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        b bVar = this$0.f27841e;
        if (bVar != null) {
            bVar.O0();
        }
    }

    public static final void k(ContactsMainListHeaderView this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        b bVar = this$0.f27841e;
        if (bVar != null) {
            bVar.R();
        }
    }

    private final void l() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("profile_lookup_uri_update");
        X.a.b(getContext()).c(this.f27842f, intentFilter);
    }

    public static final boolean m(View view, MotionEvent motionEvent) {
        return true;
    }

    public static final boolean n(View view, MotionEvent motionEvent) {
        return true;
    }

    private final void q() {
        X.a.b(getContext()).e(this.f27842f);
    }

    public final b getHeaderItemClickListener() {
        return this.f27841e;
    }

    @Override // androidx.lifecycle.InterfaceC0492o
    public Lifecycle getLifecycle() {
        return this.f27839c;
    }

    public final void h() {
        AbstractC1669g abstractC1669g = this.f27840d;
        AbstractC1669g abstractC1669g2 = null;
        if (abstractC1669g == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            abstractC1669g = null;
        }
        abstractC1669g.f37710J.setBackgroundResource(R.drawable.coui_preference_bg_selector);
        AbstractC1669g abstractC1669g3 = this.f27840d;
        if (abstractC1669g3 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
        } else {
            abstractC1669g2 = abstractC1669g3;
        }
        abstractC1669g2.f37707G.setBackgroundResource(R.drawable.coui_preference_bg_selector);
    }

    public final void i() {
        E viewScope = getViewScope();
        if (viewScope != null) {
            C1248i.d(viewScope, null, null, new ContactsMainListHeaderView$observeProfileIcon$1(this, null), 3, null);
        }
    }

    public final void o() {
        AbstractC1669g abstractC1669g = this.f27840d;
        if (abstractC1669g == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            abstractC1669g = null;
        }
        abstractC1669g.f37707G.setBackgroundColor(r.b(getContext()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f27839c.n(Lifecycle.State.CREATED);
        i();
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f27839c.n(Lifecycle.State.DESTROYED);
        E viewScope = getViewScope();
        if (viewScope != null) {
            F.d(viewScope, null, 1, null);
        }
        this.f27837a = null;
        q();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        AbstractC1669g i12 = AbstractC1669g.i1(this);
        kotlin.jvm.internal.i.e(i12, "bind(this)");
        this.f27840d = i12;
        AbstractC1669g abstractC1669g = null;
        if (i12 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            i12 = null;
        }
        i12.f37710J.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.contacts.list.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactsMainListHeaderView.j(ContactsMainListHeaderView.this, view);
            }
        });
        AbstractC1669g abstractC1669g2 = this.f27840d;
        if (abstractC1669g2 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
        } else {
            abstractC1669g = abstractC1669g2;
        }
        abstractC1669g.f37707G.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.contacts.list.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactsMainListHeaderView.k(ContactsMainListHeaderView.this, view);
            }
        });
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (i10 == 0) {
            this.f27839c.i(Lifecycle.Event.ON_START);
            this.f27839c.i(Lifecycle.Event.ON_RESUME);
        } else {
            this.f27839c.i(Lifecycle.Event.ON_PAUSE);
            this.f27839c.i(Lifecycle.Event.ON_STOP);
        }
    }

    public final void p() {
        AbstractC1669g abstractC1669g = this.f27840d;
        if (abstractC1669g == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            abstractC1669g = null;
        }
        abstractC1669g.f37710J.setBackgroundColor(r.b(getContext()));
    }

    public final void r(boolean z10) {
        int i10;
        c value;
        AbstractC1669g abstractC1669g = this.f27840d;
        if (abstractC1669g == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            abstractC1669g = null;
        }
        COUIRoundImageView cOUIRoundImageView = abstractC1669g.f37708H;
        kotlin.jvm.internal.i.e(cOUIRoundImageView, "viewBinding.myGroupIcon");
        int i11 = 8;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        cOUIRoundImageView.setVisibility(i10);
        AbstractC1669g abstractC1669g2 = this.f27840d;
        if (abstractC1669g2 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            abstractC1669g2 = null;
        }
        COUIRoundImageView cOUIRoundImageView2 = abstractC1669g2.f37711K;
        kotlin.jvm.internal.i.e(cOUIRoundImageView2, "viewBinding.myProfileIcon");
        if (z10) {
            i11 = 0;
        }
        cOUIRoundImageView2.setVisibility(i11);
        i<c> iVar = this.f27838b;
        do {
            value = iVar.getValue();
        } while (!iVar.c(value, c.b(value, z10, 0, 2, null)));
    }

    public final void setEditMode(boolean z10) {
        AbstractC1669g abstractC1669g = this.f27840d;
        AbstractC1669g abstractC1669g2 = null;
        if (abstractC1669g == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            abstractC1669g = null;
        }
        abstractC1669g.k1(Boolean.valueOf(z10));
        if (z10) {
            AbstractC1669g abstractC1669g3 = this.f27840d;
            if (abstractC1669g3 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                abstractC1669g3 = null;
            }
            abstractC1669g3.f37707G.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.contacts.list.b
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean m10;
                    m10 = ContactsMainListHeaderView.m(view, motionEvent);
                    return m10;
                }
            });
            AbstractC1669g abstractC1669g4 = this.f27840d;
            if (abstractC1669g4 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
            } else {
                abstractC1669g2 = abstractC1669g4;
            }
            abstractC1669g2.f37710J.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.contacts.list.c
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean n10;
                    n10 = ContactsMainListHeaderView.n(view, motionEvent);
                    return n10;
                }
            });
            return;
        }
        AbstractC1669g abstractC1669g5 = this.f27840d;
        if (abstractC1669g5 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            abstractC1669g5 = null;
        }
        abstractC1669g5.f37707G.setOnTouchListener(null);
        AbstractC1669g abstractC1669g6 = this.f27840d;
        if (abstractC1669g6 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            abstractC1669g6 = null;
        }
        abstractC1669g6.f37710J.setOnTouchListener(null);
    }

    public final void setHeaderItemClickListener(b bVar) {
        this.f27841e = bVar;
    }
}
