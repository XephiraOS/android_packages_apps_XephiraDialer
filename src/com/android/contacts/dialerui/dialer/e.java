package com.android.contacts.dialerui.dialer;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.dialerui.dialer.e;
import com.customize.contacts.widget.FeedbackLinearLayout;
import com.customize.contacts.widget.FeedbackRelativeLayout;
import com.oplus.dialer.R;
import w0.C1643c;

/* compiled from: SingleSimDialer.kt */
/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: m, reason: collision with root package name */
    public ImageButton f14824m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f14825n;

    /* renamed from: o, reason: collision with root package name */
    public FeedbackLinearLayout f14826o;

    /* renamed from: p, reason: collision with root package name */
    public ImageButton f14827p;

    /* renamed from: q, reason: collision with root package name */
    public w0.j<Boolean> f14828q;

    /* renamed from: r, reason: collision with root package name */
    public ViewGroup f14829r;

    /* compiled from: SingleSimDialer.kt */
    /* loaded from: classes.dex */
    public static final class a implements w0.j<Boolean> {
        public a() {
        }

        public static final void d(e this$0, Boolean bool, FragmentActivity it) {
            kotlin.jvm.internal.i.f(this$0, "this$0");
            kotlin.jvm.internal.i.f(it, "$it");
            if (this$0.g().isAdded()) {
                if (kotlin.jvm.internal.i.b(Boolean.TRUE, bool)) {
                    FeedbackLinearLayout feedbackLinearLayout = this$0.f14826o;
                    if (feedbackLinearLayout != null) {
                        feedbackLinearLayout.setBackground(it.getDrawable(R.drawable.pb_bg_sim_left));
                    }
                    FeedbackLinearLayout feedbackLinearLayout2 = this$0.f14826o;
                    if (feedbackLinearLayout2 != null) {
                        feedbackLinearLayout2.setColor(R.color.pb_color_theme_green);
                    }
                    ImageButton imageButton = this$0.f14827p;
                    if (imageButton != null) {
                        imageButton.setImageDrawable(it.getDrawable(R.drawable.pb_ic_ust_video_call_online));
                        return;
                    }
                    return;
                }
                this$0.K();
            }
        }

        @Override // w0.j
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(final Boolean bool) {
            final FragmentActivity activity = e.this.g().getActivity();
            if (activity != null) {
                final e eVar = e.this;
                activity.runOnUiThread(new Runnable() { // from class: com.android.contacts.dialerui.dialer.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.a.d(e.this, bool, activity);
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Fragment fragment, ViewGroup root, int i10, boolean z10) {
        super(fragment, root, i10);
        kotlin.jvm.internal.i.f(fragment, "fragment");
        kotlin.jvm.internal.i.f(root, "root");
        this.f14825n = z10;
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void D() {
        super.D();
        ViewGroup viewGroup = this.f14829r;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ImageButton imageButton = this.f14824m;
        if (imageButton != null) {
            imageButton.setVisibility(0);
        }
        if (this.f14825n) {
            M(q());
            String d10 = d();
            if (d10 == null) {
                d10 = "";
            }
            b(d10);
        }
    }

    public final void J(ViewGroup viewGroup) {
        View l10;
        float f10;
        if (this.f14826o == null && (l10 = l((ViewStub) viewGroup.findViewById(R.id.ust_rcs_video_stub), R.id.ust_video_view)) != null) {
            Resources resources = l10.getResources();
            FeedbackLinearLayout feedbackLinearLayout = (FeedbackLinearLayout) l10.findViewById(R.id.ust_video_view);
            if (feedbackLinearLayout != null) {
                kotlin.jvm.internal.i.e(feedbackLinearLayout, "findViewById<FeedbackLin…out>(R.id.ust_video_view)");
                if (resources != null) {
                    f10 = resources.getDimensionPixelSize(R.dimen.DP_23);
                } else {
                    f10 = 0.0f;
                }
                feedbackLinearLayout.setRadius(f10);
                feedbackLinearLayout.setColor(R.color.pb_color_video_call_background_offline);
                feedbackLinearLayout.setOnClickListener(this);
                this.f14827p = (ImageButton) feedbackLinearLayout.findViewById(R.id.rcs_video_call);
            } else {
                feedbackLinearLayout = null;
            }
            this.f14826o = feedbackLinearLayout;
        }
    }

    public final void K() {
        FragmentActivity activity = g().getActivity();
        if (activity != null && this.f14825n && q()) {
            FeedbackLinearLayout feedbackLinearLayout = this.f14826o;
            if (feedbackLinearLayout != null) {
                feedbackLinearLayout.setBackground(activity.getDrawable(R.drawable.pb_bg_ust_rcs_video_offline));
            }
            FeedbackLinearLayout feedbackLinearLayout2 = this.f14826o;
            if (feedbackLinearLayout2 != null) {
                feedbackLinearLayout2.setColor(R.color.pb_color_video_call_background_offline);
            }
            ImageButton imageButton = this.f14827p;
            if (imageButton != null) {
                imageButton.setImageDrawable(activity.getDrawable(R.drawable.pb_ic_ust_video_call_offline));
            }
        }
    }

    public final void L(boolean z10) {
        int i10;
        ImageButton imageButton = this.f14824m;
        if (imageButton != null) {
            imageButton.setVisibility(0);
            if (z10) {
                i10 = R.drawable.pb_ic_call_wifi;
            } else {
                i10 = R.drawable.pb_ic_dial_call;
            }
            imageButton.setImageResource(i10);
        }
    }

    public final void M(boolean z10) {
        int i10;
        if (this.f14825n) {
            K();
            FeedbackLinearLayout feedbackLinearLayout = this.f14826o;
            int i11 = 8;
            if (feedbackLinearLayout != null) {
                if (z10) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                feedbackLinearLayout.setVisibility(i10);
            }
            ImageButton f10 = f();
            if (f10 != null) {
                if (!z10) {
                    i11 = 0;
                }
                f10.setVisibility(i11);
            }
        }
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void b(String text) {
        kotlin.jvm.internal.i.f(text, "text");
        super.b(text);
        if (TextUtils.isEmpty(text) && this.f14825n) {
            K();
        }
        if (this.f14825n && C1643c.w()) {
            if (this.f14828q == null) {
                this.f14828q = new a();
            }
            C1643c.y(text, g().getActivity(), this.f14828q);
        }
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void k() {
        super.k();
        ViewGroup viewGroup = this.f14829r;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        ImageButton imageButton = this.f14824m;
        if (imageButton != null) {
            imageButton.setVisibility(8);
        }
        if (this.f14825n) {
            M(q());
        }
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void m(int i10, boolean z10, boolean z11, boolean z12) {
        View l10;
        float f10;
        String str;
        super.m(i10, z10, z11, z12);
        if (this.f14824m == null && (l10 = l((ViewStub) h().findViewById(R.id.single_sim_layout), R.id.single_sim_view)) != null) {
            Resources resources = l10.getResources();
            ImageButton imageButton = (ImageButton) l10.findViewById(R.id.sim_dial_btn);
            FeedbackRelativeLayout feedbackRelativeLayout = null;
            if (imageButton != null) {
                kotlin.jvm.internal.i.e(imageButton, "findViewById<ImageButton>(R.id.sim_dial_btn)");
                imageButton.setOnClickListener(this);
                if (resources != null) {
                    str = resources.getString(R.string.make_dial);
                } else {
                    str = null;
                }
                imageButton.setContentDescription(str);
            } else {
                imageButton = null;
            }
            this.f14824m = imageButton;
            FeedbackRelativeLayout feedbackRelativeLayout2 = (FeedbackRelativeLayout) l10.findViewById(R.id.single_sim_view);
            if (feedbackRelativeLayout2 != null) {
                kotlin.jvm.internal.i.e(feedbackRelativeLayout2, "findViewById<FeedbackRel…t?>(R.id.single_sim_view)");
                feedbackRelativeLayout2.setOnClickListener(this);
                if (resources != null) {
                    f10 = resources.getDimensionPixelSize(R.dimen.DP_28);
                } else {
                    f10 = 0.0f;
                }
                feedbackRelativeLayout2.setRadius(f10);
                feedbackRelativeLayout = feedbackRelativeLayout2;
            }
            this.f14829r = feedbackRelativeLayout;
        }
        L(z10);
        if (this.f14825n) {
            J(h());
            M(z12);
        }
        w(h(), 1, 1, 1);
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public boolean n() {
        if (this.f14825n && q()) {
            return false;
        }
        return super.n();
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void t(boolean z10) {
        super.t(z10);
        L(z10);
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void v(boolean z10) {
        if (this.f14825n) {
            C(z10);
            M(z10);
        }
    }
}
