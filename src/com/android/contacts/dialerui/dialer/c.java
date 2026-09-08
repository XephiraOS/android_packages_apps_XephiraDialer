package com.android.contacts.dialerui.dialer;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.customize.contacts.util.b0;
import com.customize.contacts.widget.FeedbackRelativeLayout;
import com.oplus.dialer.R;

/* compiled from: DefaultDualSimDialer.kt */
/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: r, reason: collision with root package name */
    public static final a f14815r = new a(null);

    /* renamed from: m, reason: collision with root package name */
    public ImageView f14816m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f14817n;

    /* renamed from: o, reason: collision with root package name */
    public ImageView f14818o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f14819p;

    /* renamed from: q, reason: collision with root package name */
    public ViewGroup f14820q;

    /* compiled from: DefaultDualSimDialer.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Fragment fragment, ViewGroup root, int i10) {
        super(fragment, root, i10);
        kotlin.jvm.internal.i.f(fragment, "fragment");
        kotlin.jvm.internal.i.f(root, "root");
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void D() {
        super.D();
        ViewGroup viewGroup = this.f14820q;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        H();
    }

    public final void G(boolean z10, boolean z11) {
        z(this.f14816m, z10);
        A(this.f14818o, z11);
    }

    public final void H() {
        String str;
        TextView textView = this.f14817n;
        String str2 = null;
        if (textView != null) {
            String B10 = b0.B();
            textView.setText(B10);
            Resources resources = textView.getResources();
            if (resources != null) {
                str = resources.getString(R.string.oplus_use_sim_x_to_call, B10);
            } else {
                str = null;
            }
            textView.setContentDescription(str);
        }
        TextView textView2 = this.f14819p;
        if (textView2 != null) {
            String E10 = b0.E();
            textView2.setText(E10);
            Resources resources2 = textView2.getResources();
            if (resources2 != null) {
                str2 = resources2.getString(R.string.oplus_use_sim_x_to_call, E10);
            }
            textView2.setContentDescription(str2);
        }
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public boolean j() {
        return false;
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void k() {
        super.k();
        ViewGroup viewGroup = this.f14820q;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void m(int i10, boolean z10, boolean z11, boolean z12) {
        View l10;
        super.m(i10, z10, z11, z12);
        if (this.f14820q == null && (l10 = l((ViewStub) h().findViewById(R.id.dual_sim_layout), R.id.dual_sim_view)) != null) {
            ViewGroup viewGroup = (ViewGroup) l10.findViewById(R.id.dual_sim_view);
            if (viewGroup != null) {
                kotlin.jvm.internal.i.e(viewGroup, "findViewById<ViewGroup>(R.id.dual_sim_view)");
                FeedbackRelativeLayout feedbackRelativeLayout = (FeedbackRelativeLayout) viewGroup.findViewById(R.id.sim1_dial_btn);
                if (feedbackRelativeLayout != null) {
                    kotlin.jvm.internal.i.e(feedbackRelativeLayout, "findViewById<FeedbackRel…yout>(R.id.sim1_dial_btn)");
                    this.f14816m = (ImageView) feedbackRelativeLayout.findViewById(R.id.sim1_btn);
                    this.f14817n = (TextView) feedbackRelativeLayout.findViewById(R.id.sim1_name);
                    feedbackRelativeLayout.setOnClickListener(this);
                }
                FeedbackRelativeLayout feedbackRelativeLayout2 = (FeedbackRelativeLayout) viewGroup.findViewById(R.id.sim2_dial_btn);
                if (feedbackRelativeLayout2 != null) {
                    kotlin.jvm.internal.i.e(feedbackRelativeLayout2, "findViewById<FeedbackRel…yout>(R.id.sim2_dial_btn)");
                    this.f14818o = (ImageView) feedbackRelativeLayout2.findViewById(R.id.sim2_btn);
                    this.f14819p = (TextView) feedbackRelativeLayout2.findViewById(R.id.sim2_name);
                    feedbackRelativeLayout2.setOnClickListener(this);
                }
            } else {
                viewGroup = null;
            }
            this.f14820q = viewGroup;
        }
        G(z10, z11);
        w(h(), 222, 53, 53);
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void t(boolean z10) {
        z(this.f14816m, z10);
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void u(boolean z10) {
        A(this.f14818o, z10);
    }
}
