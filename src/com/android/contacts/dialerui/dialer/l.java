package com.android.contacts.dialerui.dialer;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.q;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.customize.contacts.util.a0;
import com.customize.contacts.util.b0;
import com.customize.contacts.widget.FeedbackRelativeLayout;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: SwitchableDualSimDialer.kt */
/* loaded from: classes.dex */
public final class l extends b {

    /* renamed from: D, reason: collision with root package name */
    public static final a f14842D = new a(null);

    /* renamed from: A, reason: collision with root package name */
    public boolean f14843A;

    /* renamed from: B, reason: collision with root package name */
    public int f14844B;

    /* renamed from: C, reason: collision with root package name */
    public COUIPopupListWindow f14845C;

    /* renamed from: m, reason: collision with root package name */
    public View f14846m;

    /* renamed from: n, reason: collision with root package name */
    public ImageButton f14847n;

    /* renamed from: o, reason: collision with root package name */
    public ImageButton f14848o;

    /* renamed from: p, reason: collision with root package name */
    public ImageButton f14849p;

    /* renamed from: q, reason: collision with root package name */
    public ImageButton f14850q;

    /* renamed from: r, reason: collision with root package name */
    public ImageButton f14851r;

    /* renamed from: x, reason: collision with root package name */
    public a0 f14852x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f14853y;

    /* renamed from: z, reason: collision with root package name */
    public ViewGroup f14854z;

    /* compiled from: SwitchableDualSimDialer.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Fragment fragment, ViewGroup root, int i10) {
        super(fragment, root, i10);
        kotlin.jvm.internal.i.f(fragment, "fragment");
        kotlin.jvm.internal.i.f(root, "root");
        this.f14853y = true;
        this.f14844B = -1;
    }

    public static final void R(l this$0, View view) {
        a0 a0Var;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        boolean b10 = M7.c.b(this$0.g().getActivity());
        if (H7.a.b()) {
            H7.b.b("SwitchableDualSimDialer", "talkBackOpen: " + b10);
        }
        if (b10 && (a0Var = this$0.f14852x) != null) {
            kotlin.jvm.internal.i.c(a0Var);
            if (!a0Var.g() && view.getVisibility() != 8) {
                this$0.a0(false, 1);
            }
        }
    }

    public static final boolean S(l this$0, ImageButton prompt, View view, MotionEvent event) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(prompt, "$prompt");
        kotlin.jvm.internal.i.f(event, "event");
        if (event.getAction() == 0) {
            a0 a0Var = this$0.f14852x;
            if (a0Var != null) {
                if ((a0Var != null && a0Var.g()) || prompt.getVisibility() == 8) {
                    return false;
                }
                a0 a0Var2 = this$0.f14852x;
                if (a0Var2 != null) {
                    a0Var2.h();
                }
            }
        } else if (event.getAction() == 1 || event.getAction() == 3) {
            a0 a0Var3 = this$0.f14852x;
            if ((a0Var3 != null && a0Var3.g()) || prompt.getVisibility() == 8) {
                return false;
            }
            this$0.a0(true, 1);
        }
        return true;
    }

    public static final void T(l this$0, View view) {
        a0 a0Var;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        boolean b10 = M7.c.b(this$0.g().getActivity());
        if (H7.a.b()) {
            H7.b.b("SwitchableDualSimDialer", "talkBackOpen: " + b10);
        }
        if (b10 && (a0Var = this$0.f14852x) != null) {
            kotlin.jvm.internal.i.c(a0Var);
            if (!a0Var.g() && view.getVisibility() != 8) {
                this$0.a0(false, 0);
            }
        }
    }

    public static final boolean U(l this$0, ImageButton prompt, View view, MotionEvent event) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(prompt, "$prompt");
        kotlin.jvm.internal.i.f(event, "event");
        if (event.getAction() == 0) {
            a0 a0Var = this$0.f14852x;
            if (a0Var != null) {
                if ((a0Var != null && a0Var.g()) || prompt.getVisibility() == 8) {
                    return false;
                }
                a0 a0Var2 = this$0.f14852x;
                if (a0Var2 != null) {
                    a0Var2.h();
                }
            }
        } else if (event.getAction() == 1 || event.getAction() == 3) {
            a0 a0Var3 = this$0.f14852x;
            if ((a0Var3 != null && a0Var3.g()) || prompt.getVisibility() == 8) {
                return false;
            }
            this$0.a0(true, 0);
        }
        return true;
    }

    public static final void b0(COUIPopupListWindow this_apply, boolean z10, l this$0, AdapterView adapterView, View view, int i10, long j10) {
        kotlin.jvm.internal.i.f(this_apply, "$this_apply");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (this_apply.isShowing()) {
            this_apply.dismiss();
        }
        if (this_apply.getItemList().get(i10).isChecked()) {
            if (H7.a.b()) {
                H7.b.b("SwitchableDualSimDialer", "user's choose sim has not changed, no need refresh.");
            }
        } else if (z10) {
            this$0.d0(i10);
        } else {
            this$0.e0(i10);
        }
    }

    public static final void c0(boolean z10, l this$0) {
        a0 a0Var;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (z10 && (a0Var = this$0.f14852x) != null) {
            a0Var.i();
        }
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void D() {
        super.D();
        ViewGroup viewGroup = this.f14854z;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        V();
        String d10 = d();
        if (d10 == null) {
            d10 = "";
        }
        i0(d10);
    }

    public final void M() {
        this.f14843A = false;
        this.f14844B = -1;
    }

    public final void N(ViewGroup viewGroup, int i10) {
        Q(viewGroup, i10);
        O(viewGroup);
        P();
        w(viewGroup, 1, 1, 1);
    }

    public final void O(ViewGroup viewGroup) {
        View l10;
        float f10;
        if (this.f14854z == null && (l10 = l((ViewStub) viewGroup.findViewById(R.id.single_sim_layout), R.id.single_sim_view)) != null) {
            Resources resources = l10.getResources();
            FeedbackRelativeLayout feedbackRelativeLayout = (FeedbackRelativeLayout) l10.findViewById(R.id.single_sim_view);
            ImageButton imageButton = null;
            if (feedbackRelativeLayout != null) {
                feedbackRelativeLayout.setVisibility(0);
                if (resources != null) {
                    f10 = resources.getDimensionPixelSize(R.dimen.DP_28);
                } else {
                    f10 = 0.0f;
                }
                feedbackRelativeLayout.setRadius(f10);
                feedbackRelativeLayout.setOnClickListener(this);
                ImageButton imageButton2 = (ImageButton) feedbackRelativeLayout.findViewById(R.id.sim_dial_btn);
                if (imageButton2 != null) {
                    imageButton2.setVisibility(8);
                }
                ImageButton imageButton3 = (ImageButton) feedbackRelativeLayout.findViewById(R.id.single_sim1_dial_btn);
                if (imageButton3 != null) {
                    kotlin.jvm.internal.i.e(imageButton3, "findViewById<ImageButton….id.single_sim1_dial_btn)");
                    imageButton3.setOnClickListener(this);
                } else {
                    imageButton3 = null;
                }
                this.f14850q = imageButton3;
                ImageButton imageButton4 = (ImageButton) feedbackRelativeLayout.findViewById(R.id.single_sim2_dial_btn);
                if (imageButton4 != null) {
                    kotlin.jvm.internal.i.e(imageButton4, "findViewById<ImageButton….id.single_sim2_dial_btn)");
                    imageButton4.setOnClickListener(this);
                    imageButton = imageButton4;
                }
                this.f14851r = imageButton;
            } else {
                feedbackRelativeLayout = null;
            }
            this.f14854z = feedbackRelativeLayout;
        }
    }

    public final void P() {
        if (this.f14850q != null && this.f14851r != null && this.f14847n != null && this.f14848o != null && this.f14849p != null && this.f14852x == null) {
            ImageButton imageButton = this.f14850q;
            kotlin.jvm.internal.i.c(imageButton);
            ImageButton imageButton2 = this.f14851r;
            kotlin.jvm.internal.i.c(imageButton2);
            ImageButton imageButton3 = this.f14847n;
            kotlin.jvm.internal.i.c(imageButton3);
            ImageButton imageButton4 = this.f14848o;
            kotlin.jvm.internal.i.c(imageButton4);
            ImageButton imageButton5 = this.f14849p;
            kotlin.jvm.internal.i.c(imageButton5);
            a0 a0Var = new a0(imageButton, imageButton2, imageButton3, imageButton4, imageButton5);
            a0Var.f();
            this.f14852x = a0Var;
        }
    }

    public final void Q(ViewGroup viewGroup, int i10) {
        View view;
        ImageButton imageButton;
        final ImageButton imageButton2;
        final ImageButton imageButton3;
        if (this.f14846m == null) {
            View l10 = l((ViewStub) viewGroup.findViewById(R.id.sim_switcher_stub), R.id.sim_switcher);
            ImageButton imageButton4 = null;
            if (l10 != null) {
                view = l10.findViewById(R.id.sim_switcher);
            } else {
                view = null;
            }
            this.f14846m = view;
            if (view != null && (imageButton = (ImageButton) view.findViewById(R.id.switch_bg)) != null) {
                imageButton.setVisibility(0);
            } else {
                imageButton = null;
            }
            this.f14849p = imageButton;
            if (imageButton != null) {
                imageButton.setImportantForAccessibility(2);
            }
            View view2 = this.f14846m;
            if (view2 != null && (imageButton2 = (ImageButton) view2.findViewById(R.id.sim1_prompt)) != null) {
                imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.dialerui.dialer.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        l.R(l.this, view3);
                    }
                });
                imageButton2.setOnTouchListener(new View.OnTouchListener() { // from class: com.android.contacts.dialerui.dialer.g
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view3, MotionEvent motionEvent) {
                        boolean S10;
                        S10 = l.S(l.this, imageButton2, view3, motionEvent);
                        return S10;
                    }
                });
            } else {
                imageButton2 = null;
            }
            this.f14847n = imageButton2;
            View view3 = this.f14846m;
            if (view3 != null && (imageButton3 = (ImageButton) view3.findViewById(R.id.sim2_prompt)) != null) {
                imageButton3.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.dialerui.dialer.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        l.T(l.this, view4);
                    }
                });
                imageButton3.setOnTouchListener(new View.OnTouchListener() { // from class: com.android.contacts.dialerui.dialer.i
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view4, MotionEvent motionEvent) {
                        boolean U10;
                        U10 = l.U(l.this, imageButton3, view4, motionEvent);
                        return U10;
                    }
                });
                imageButton4 = imageButton3;
            }
            this.f14848o = imageButton4;
            W(i10);
        }
        Z();
    }

    public final void V() {
        Resources resources;
        String str;
        Resources resources2;
        ImageButton imageButton = this.f14850q;
        String str2 = null;
        if (imageButton != null) {
            ViewGroup viewGroup = this.f14854z;
            if (viewGroup != null && (resources2 = viewGroup.getResources()) != null) {
                str = resources2.getString(R.string.oplus_use_sim_x_to_call, b0.B());
            } else {
                str = null;
            }
            imageButton.setContentDescription(str);
        }
        ImageButton imageButton2 = this.f14851r;
        if (imageButton2 != null) {
            ViewGroup viewGroup2 = this.f14854z;
            if (viewGroup2 != null && (resources = viewGroup2.getResources()) != null) {
                str2 = resources.getString(R.string.oplus_use_sim_x_to_call, b0.E());
            }
            imageButton2.setContentDescription(str2);
        }
    }

    public final void W(int i10) {
        if (i10 != 0) {
            if (i10 == 1) {
                ImageButton imageButton = this.f14847n;
                if (imageButton != null) {
                    imageButton.setVisibility(8);
                }
                ImageButton imageButton2 = this.f14848o;
                if (imageButton2 != null) {
                    imageButton2.setAlpha(1.0f);
                }
                ImageButton imageButton3 = this.f14848o;
                if (imageButton3 != null) {
                    imageButton3.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        ImageButton imageButton4 = this.f14847n;
        if (imageButton4 != null) {
            imageButton4.setAlpha(1.0f);
        }
        ImageButton imageButton5 = this.f14847n;
        if (imageButton5 != null) {
            imageButton5.setVisibility(0);
        }
        ImageButton imageButton6 = this.f14848o;
        if (imageButton6 != null) {
            imageButton6.setVisibility(8);
        }
    }

    public final void X(boolean z10) {
        ImageButton imageButton = this.f14851r;
        if (imageButton != null) {
            imageButton.setVisibility(8);
        }
        ImageButton imageButton2 = this.f14850q;
        if (imageButton2 != null) {
            if (z10) {
                imageButton2.setImageResource(R.drawable.pb_ic_dial_wifi_call_sim1);
            } else {
                imageButton2.setImageResource(R.drawable.pb_ic_dial_call_sim1);
            }
            imageButton2.setAlpha(1.0f);
            imageButton2.setVisibility(0);
        }
    }

    public final void Y(boolean z10) {
        ImageButton imageButton = this.f14850q;
        if (imageButton != null) {
            imageButton.setVisibility(8);
        }
        ImageButton imageButton2 = this.f14851r;
        if (imageButton2 != null) {
            if (z10) {
                imageButton2.setImageResource(R.drawable.pb_ic_dial_wifi_call_sim2);
            } else {
                imageButton2.setImageResource(R.drawable.pb_ic_dial_call_sim2);
            }
            imageButton2.setAlpha(1.0f);
            imageButton2.setVisibility(0);
        }
    }

    public final void Z() {
        int i10;
        View view = this.f14846m;
        int i11 = 0;
        if (view != null) {
            if (this.f14853y) {
                i10 = 8;
            } else {
                i10 = 0;
            }
            view.setVisibility(i10);
        }
        ImageButton f10 = f();
        if (f10 != null) {
            if (!this.f14853y) {
                i11 = 8;
            }
            f10.setVisibility(i11);
        }
    }

    public final void a0(final boolean z10, int i10) {
        boolean z11;
        boolean z12;
        FragmentActivity activity = g().getActivity();
        if (activity != null) {
            ArrayList arrayList = new ArrayList();
            String str = "\u202a" + b0.C();
            String str2 = "\u202a" + b0.F();
            String B10 = b0.B();
            if (i10 != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            arrayList.add(q.e(B10, true, z11, -1, str, activity.getDrawable(R.drawable.pb_ic_sim1_prompt), 6, null, null, null, 0, 1920, null));
            String E10 = b0.E();
            if (i10 != 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            arrayList.add(q.e(E10, true, z12, -1, str2, activity.getDrawable(R.drawable.pb_ic_sim2_prompt), 6, null, null, null, 0, 1920, null));
            final COUIPopupListWindow cOUIPopupListWindow = new COUIPopupListWindow(activity);
            cOUIPopupListWindow.setItemList(arrayList);
            cOUIPopupListWindow.setDismissTouchOutside(true);
            cOUIPopupListWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.android.contacts.dialerui.dialer.j
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                    l.b0(COUIPopupListWindow.this, z10, this, adapterView, view, i11, j10);
                }
            });
            cOUIPopupListWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.android.contacts.dialerui.dialer.k
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    l.c0(z10, this);
                }
            });
            this.f14845C = cOUIPopupListWindow;
            cOUIPopupListWindow.show(this.f14849p);
            Z3.j.b(cOUIPopupListWindow);
        }
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void b(String text) {
        kotlin.jvm.internal.i.f(text, "text");
        super.b(text);
        boolean isEmpty = TextUtils.isEmpty(text);
        this.f14853y = isEmpty;
        if (isEmpty) {
            M();
        }
        int c10 = c();
        h0(c10);
        if (H7.a.b()) {
            H7.b.b("SwitchableDualSimDialer", "afterTextChanged: " + this.f14853y + ", " + this.f14843A + ", " + this.f14844B + ", " + c10);
        }
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public int c() {
        if (this.f14843A) {
            return this.f14844B;
        }
        return e();
    }

    public final void d0(int i10) {
        String str;
        f0(i10);
        if (i10 == 0) {
            a0 a0Var = this.f14852x;
            if (a0Var != null) {
                a0Var.k();
            }
        } else {
            a0 a0Var2 = this.f14852x;
            if (a0Var2 != null) {
                a0Var2.j();
            }
        }
        HashMap hashMap = new HashMap();
        int e10 = e() + 1;
        if (i10 == 0) {
            str = OplusPhoneUtils.DeviceState.INVALID_STATUS;
        } else {
            str = "-2";
        }
        hashMap.put("simid_after", e10 + str);
        A.a(g().getActivity(), 2000304, 200031601, hashMap, false);
    }

    public final void e0(int i10) {
        String str;
        f0(i10);
        if (i10 == 0) {
            ImageButton imageButton = this.f14847n;
            if (imageButton != null) {
                imageButton.setAlpha(1.0f);
                imageButton.setVisibility(0);
            }
            ImageButton imageButton2 = this.f14848o;
            if (imageButton2 != null) {
                imageButton2.setVisibility(8);
            }
            ImageButton imageButton3 = this.f14850q;
            if (imageButton3 != null) {
                imageButton3.setAlpha(1.0f);
                imageButton3.setVisibility(0);
            }
            ImageButton imageButton4 = this.f14851r;
            if (imageButton4 != null) {
                imageButton4.setVisibility(8);
            }
        } else {
            ImageButton imageButton5 = this.f14847n;
            if (imageButton5 != null) {
                imageButton5.setVisibility(8);
            }
            ImageButton imageButton6 = this.f14848o;
            if (imageButton6 != null) {
                imageButton6.setAlpha(1.0f);
                imageButton6.setVisibility(0);
            }
            ImageButton imageButton7 = this.f14850q;
            if (imageButton7 != null) {
                imageButton7.setVisibility(8);
            }
            ImageButton imageButton8 = this.f14851r;
            if (imageButton8 != null) {
                imageButton8.setAlpha(1.0f);
                imageButton8.setVisibility(0);
            }
        }
        FragmentActivity activity = g().getActivity();
        if (activity != null) {
            HashMap hashMap = new HashMap();
            if (i10 == 0) {
                str = OplusPhoneUtils.DeviceState.INVALID_STATUS;
            } else {
                str = "-2";
            }
            hashMap.put("simid_after", (e() + 1) + str);
            A.a(activity.getApplicationContext(), 2000304, 200031601, hashMap, false);
        }
    }

    public final void f0(int i10) {
        this.f14843A = true;
        this.f14844B = i10;
    }

    public final void g0(int i10, boolean z10, boolean z11) {
        if (i10 == 0) {
            X(z10);
        } else {
            Y(z11);
        }
    }

    public final void h0(int i10) {
        Z();
        g0(i10, o(), p());
        if (!this.f14853y) {
            ImageButton imageButton = this.f14850q;
            if (imageButton != null && imageButton.getVisibility() == 0) {
                W(0);
                return;
            }
            ImageButton imageButton2 = this.f14851r;
            if (imageButton2 != null && imageButton2.getVisibility() == 0) {
                W(1);
            }
        }
    }

    public final void i0(String str) {
        b(str);
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void k() {
        super.k();
        ViewGroup viewGroup = this.f14854z;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        View view = this.f14846m;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageButton imageButton = this.f14850q;
        if (imageButton != null) {
            imageButton.setVisibility(8);
        }
        ImageButton imageButton2 = this.f14851r;
        if (imageButton2 != null) {
            imageButton2.setVisibility(8);
        }
        M();
        COUIPopupListWindow cOUIPopupListWindow = this.f14845C;
        if (cOUIPopupListWindow != null && cOUIPopupListWindow.isShowing()) {
            COUIPopupListWindow cOUIPopupListWindow2 = this.f14845C;
            if (cOUIPopupListWindow2 != null) {
                cOUIPopupListWindow2.dismiss();
            }
            this.f14845C = null;
        }
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void m(int i10, boolean z10, boolean z11, boolean z12) {
        super.m(i10, z10, z11, z12);
        N(h(), i10);
        g0(i10, z10, z11);
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public boolean n() {
        return this.f14853y;
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void s(int i10) {
        h0(i10);
    }
}
