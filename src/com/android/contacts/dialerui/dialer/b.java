package com.android.contacts.dialerui.dialer;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.oplus.dialer.R;
import kotlin.Result;
import m9.q;

/* compiled from: BaseDialer.kt */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: l, reason: collision with root package name */
    public static final a f14803l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f14804a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup f14805b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14806c;

    /* renamed from: d, reason: collision with root package name */
    public ImageButton f14807d;

    /* renamed from: e, reason: collision with root package name */
    public int f14808e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14809f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14810g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14811h;

    /* renamed from: i, reason: collision with root package name */
    public RelativeLayout f14812i;

    /* renamed from: j, reason: collision with root package name */
    public A0.a f14813j;

    /* renamed from: k, reason: collision with root package name */
    public String f14814k;

    /* compiled from: BaseDialer.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public b(Fragment fragment, ViewGroup root, int i10) {
        kotlin.jvm.internal.i.f(fragment, "fragment");
        kotlin.jvm.internal.i.f(root, "root");
        this.f14804a = fragment;
        this.f14805b = root;
        this.f14806c = i10;
        this.f14807d = (ImageButton) root.findViewById(R.id.dial_hide);
        this.f14808e = -1;
        ViewGroup viewGroup = (ViewGroup) root.findViewById(R.id.switch_sim_layout);
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(new View.OnTouchListener() { // from class: com.android.contacts.dialerui.dialer.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean r10;
                    r10 = b.r(view, motionEvent);
                    return r10;
                }
            });
        }
    }

    public static final boolean r(View view, MotionEvent motionEvent) {
        if (H7.a.b()) {
            H7.b.b("BaseDialer", "touch: switch_sim_layout");
            return true;
        }
        return true;
    }

    public final void A(ImageView imageView, boolean z10) {
        if (imageView != null) {
            if (z10) {
                imageView.setImageResource(R.drawable.pb_ic_dial_wifi_call_sim2);
            } else {
                imageView.setImageResource(R.drawable.pb_ic_dial_dual_sim2);
            }
        }
    }

    public final void B(View view, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        kotlin.jvm.internal.i.d(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        float f10 = i10;
        if (layoutParams2.weight != f10) {
            layoutParams2.weight = f10;
            view.setLayoutParams(layoutParams2);
        }
    }

    public final void C(boolean z10) {
        this.f14811h = z10;
    }

    public void D() {
        if (H7.a.b()) {
            H7.b.b("BaseDialer", "show: " + getClass().getSimpleName());
        }
    }

    public final void E(int i10, boolean z10, boolean z11, boolean z12) {
        if (this.f14808e != i10) {
            if (H7.a.b()) {
                H7.b.b("BaseDialer", "dfltSlotId changed: " + this.f14808e + " -> " + i10);
            }
            s(i10);
            this.f14808e = i10;
        }
        if (this.f14809f != z10) {
            if (H7.a.b()) {
                H7.b.b("BaseDialer", "isSim1WifiCalling changed: " + this.f14809f + " -> " + z10);
            }
            t(z10);
            this.f14809f = z10;
        }
        if (this.f14810g != z11) {
            if (H7.a.b()) {
                H7.b.b("BaseDialer", "isSim2WifiCalling changed: " + this.f14810g + " -> " + z11);
            }
            u(z11);
            this.f14810g = z11;
        }
        if (this.f14811h != z12) {
            if (H7.a.b()) {
                H7.b.b("BaseDialer", "isUstVideoCall changed: " + this.f14811h + " -> " + z12);
            }
            v(z12);
            this.f14811h = z12;
        }
    }

    public final void F(Resources resources, int i10) {
        kotlin.jvm.internal.i.f(resources, "resources");
        if (j()) {
            if (this.f14812i == null) {
                this.f14812i = (RelativeLayout) this.f14805b.findViewById(R.id.single_sim_btn_view);
            }
            RelativeLayout relativeLayout = this.f14812i;
            if (relativeLayout != null) {
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.DP_56);
                if (i10 > dimensionPixelSize) {
                    i10 = dimensionPixelSize;
                }
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                kotlin.jvm.internal.i.d(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.height = i10;
                layoutParams2.width = i10;
                relativeLayout.setLayoutParams(layoutParams2);
            }
        }
    }

    public void b(String text) {
        kotlin.jvm.internal.i.f(text, "text");
        if (H7.a.b()) {
            H7.b.b("BaseDialer", "afterTextChanged: length: " + text.length());
        }
    }

    public int c() {
        if (H7.a.b()) {
            H7.b.b("BaseDialer", "getCurrentDialSlotId: " + this.f14808e);
        }
        return this.f14808e;
    }

    public final String d() {
        return this.f14814k;
    }

    public final int e() {
        return this.f14808e;
    }

    public final ImageButton f() {
        return this.f14807d;
    }

    public final Fragment g() {
        return this.f14804a;
    }

    public final ViewGroup h() {
        return this.f14805b;
    }

    public final int i() {
        return this.f14806c;
    }

    public boolean j() {
        return true;
    }

    public void k() {
        if (H7.a.b()) {
            H7.b.b("BaseDialer", "hide: " + getClass().getSimpleName());
        }
    }

    public final View l(ViewStub viewStub, int i10) {
        Object b10;
        View inflate;
        View view = null;
        try {
            Result.a aVar = Result.f34166a;
            if (viewStub == null) {
                inflate = this.f14805b.findViewById(i10);
            } else {
                inflate = viewStub.inflate();
            }
            view = inflate;
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("BaseDialer", "inflate: exception: " + d10);
        }
        if (H7.a.b()) {
            H7.b.b("BaseDialer", "inflate: stub: " + viewStub + ", " + view);
        }
        return view;
    }

    public void m(int i10, boolean z10, boolean z11, boolean z12) {
        this.f14808e = i10;
        this.f14809f = z10;
        this.f14810g = z11;
        this.f14811h = z12;
    }

    public boolean n() {
        return true;
    }

    public final boolean o() {
        return this.f14809f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (H7.a.b()) {
                H7.b.b("BaseDialer", "onClick: " + view.getId());
            }
            A0.a aVar = this.f14813j;
            if (aVar != null) {
                aVar.D0(view);
            }
        }
    }

    public final boolean p() {
        return this.f14810g;
    }

    public final boolean q() {
        return this.f14811h;
    }

    public final void w(ViewGroup root, int i10, int i11, int i12) {
        kotlin.jvm.internal.i.f(root, "root");
        View findViewById = root.findViewById(R.id.dial_btn_panel);
        if (findViewById != null) {
            B(findViewById, i10);
        }
        View findViewById2 = root.findViewById(R.id.switch_sim_layout);
        if (findViewById2 != null) {
            B(findViewById2, i11);
        }
        View findViewById3 = root.findViewById(R.id.dial_del);
        if (findViewById3 != null) {
            B(findViewById3, i12);
        }
    }

    public final void x(String str) {
        this.f14814k = str;
    }

    public final void y(A0.a aVar) {
        this.f14813j = aVar;
    }

    public final void z(ImageView imageView, boolean z10) {
        if (imageView != null) {
            if (z10) {
                imageView.setImageResource(R.drawable.pb_ic_dial_wifi_call_sim1);
            } else {
                imageView.setImageResource(R.drawable.pb_ic_dial_dual_sim1);
            }
        }
    }

    public void s(int i10) {
    }

    public void t(boolean z10) {
    }

    public void u(boolean z10) {
    }

    public void v(boolean z10) {
    }
}
