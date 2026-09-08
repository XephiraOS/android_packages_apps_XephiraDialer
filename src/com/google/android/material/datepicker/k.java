package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.K;
import androidx.core.view.X;
import androidx.core.view.z;
import androidx.fragment.app.B;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import e4.C0977c;
import e4.C0979e;
import f.C0991a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import m4.ViewOnTouchListenerC1332a;
import u4.C1606b;

/* compiled from: MaterialDatePicker.java */
/* loaded from: classes3.dex */
public final class k<S> extends DialogInterfaceOnCancelListenerC0472c {

    /* renamed from: J, reason: collision with root package name */
    public static final Object f23221J = "CONFIRM_BUTTON_TAG";

    /* renamed from: K, reason: collision with root package name */
    public static final Object f23222K = "CANCEL_BUTTON_TAG";

    /* renamed from: L, reason: collision with root package name */
    public static final Object f23223L = "TOGGLE_BUTTON_TAG";

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f23224A;

    /* renamed from: B, reason: collision with root package name */
    public TextView f23225B;

    /* renamed from: C, reason: collision with root package name */
    public TextView f23226C;

    /* renamed from: D, reason: collision with root package name */
    public CheckableImageButton f23227D;

    /* renamed from: E, reason: collision with root package name */
    public x4.i f23228E;

    /* renamed from: F, reason: collision with root package name */
    public Button f23229F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f23230G;

    /* renamed from: H, reason: collision with root package name */
    public CharSequence f23231H;

    /* renamed from: I, reason: collision with root package name */
    public CharSequence f23232I;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<l<? super S>> f23233a = new LinkedHashSet<>();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<View.OnClickListener> f23234b = new LinkedHashSet<>();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<DialogInterface.OnCancelListener> f23235c = new LinkedHashSet<>();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<DialogInterface.OnDismissListener> f23236d = new LinkedHashSet<>();

    /* renamed from: e, reason: collision with root package name */
    public int f23237e;

    /* renamed from: f, reason: collision with root package name */
    public DateSelector<S> f23238f;

    /* renamed from: g, reason: collision with root package name */
    public q<S> f23239g;

    /* renamed from: h, reason: collision with root package name */
    public CalendarConstraints f23240h;

    /* renamed from: i, reason: collision with root package name */
    public DayViewDecorator f23241i;

    /* renamed from: j, reason: collision with root package name */
    public MaterialCalendar<S> f23242j;

    /* renamed from: k, reason: collision with root package name */
    public int f23243k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f23244l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f23245m;

    /* renamed from: n, reason: collision with root package name */
    public int f23246n;

    /* renamed from: o, reason: collision with root package name */
    public int f23247o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f23248p;

    /* renamed from: q, reason: collision with root package name */
    public int f23249q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f23250r;

    /* renamed from: x, reason: collision with root package name */
    public int f23251x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f23252y;

    /* renamed from: z, reason: collision with root package name */
    public int f23253z;

    /* compiled from: MaterialDatePicker.java */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = k.this.f23233a.iterator();
            while (it.hasNext()) {
                ((l) it.next()).a(k.this.o1());
            }
            k.this.dismiss();
        }
    }

    /* compiled from: MaterialDatePicker.java */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = k.this.f23234b.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            k.this.dismiss();
        }
    }

    /* compiled from: MaterialDatePicker.java */
    /* loaded from: classes3.dex */
    public class c implements z {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23256a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f23257b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f23258c;

        public c(int i10, View view, int i11) {
            this.f23256a = i10;
            this.f23257b = view;
            this.f23258c = i11;
        }

        @Override // androidx.core.view.z
        public X onApplyWindowInsets(View view, X x10) {
            int i10 = x10.f(X.k.f()).f208b;
            if (this.f23256a >= 0) {
                this.f23257b.getLayoutParams().height = this.f23256a + i10;
                View view2 = this.f23257b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f23257b;
            view3.setPadding(view3.getPaddingLeft(), this.f23258c + i10, this.f23257b.getPaddingRight(), this.f23257b.getPaddingBottom());
            return x10;
        }
    }

    /* compiled from: MaterialDatePicker.java */
    /* loaded from: classes3.dex */
    public class d extends p<S> {
        public d() {
        }

        @Override // com.google.android.material.datepicker.p
        public void a() {
            k.this.f23229F.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.p
        public void b(S s10) {
            k kVar = k.this;
            kVar.x1(kVar.m1());
            k.this.f23229F.setEnabled(k.this.j1().Z());
        }
    }

    public static Drawable h1(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, C0991a.b(context, e4.f.f30828e));
        stateListDrawable.addState(new int[0], C0991a.b(context, e4.f.f30829f));
        return stateListDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateSelector<S> j1() {
        if (this.f23238f == null) {
            this.f23238f = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f23238f;
    }

    public static CharSequence k1(CharSequence charSequence) {
        if (charSequence != null) {
            String[] split = TextUtils.split(String.valueOf(charSequence), "\n");
            if (split.length > 1) {
                return split[0];
            }
            return charSequence;
        }
        return null;
    }

    public static int n1(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(C0979e.f30797m0);
        int i10 = Month.h().f23162d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(C0979e.f30801o0) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(C0979e.f30809s0));
    }

    public static boolean r1(Context context) {
        return v1(context, R.attr.windowFullscreen);
    }

    public static boolean t1(Context context) {
        return v1(context, C0977c.f30676k0);
    }

    public static boolean v1(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(C1606b.d(context, C0977c.f30639K, MaterialCalendar.class.getCanonicalName()), new int[]{i10});
        boolean z10 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z10;
    }

    private void y1() {
        CharSequence charSequence;
        TextView textView = this.f23225B;
        if (this.f23246n == 1 && s1()) {
            charSequence = this.f23232I;
        } else {
            charSequence = this.f23231H;
        }
        textView.setText(charSequence);
    }

    public final void i1(Window window) {
        if (this.f23230G) {
            return;
        }
        View findViewById = requireView().findViewById(e4.g.f30880i);
        EdgeToEdgeUtils.applyEdgeToEdge(window, true, ViewUtils.getBackgroundColor(findViewById), null);
        K.z0(findViewById, new c(findViewById.getLayoutParams().height, findViewById, findViewById.getPaddingTop()));
        this.f23230G = true;
    }

    public final String l1() {
        return j1().T(requireContext());
    }

    public String m1() {
        return j1().l(getContext());
    }

    public final S o1() {
        return j1().g0();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f23235c.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f23237e = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f23238f = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f23240h = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f23241i = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f23243k = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f23244l = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f23246n = bundle.getInt("INPUT_MODE_KEY");
        this.f23247o = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f23248p = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f23249q = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f23250r = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.f23251x = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f23252y = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.f23253z = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f23224A = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence charSequence = this.f23244l;
        if (charSequence == null) {
            charSequence = requireContext().getResources().getText(this.f23243k);
        }
        this.f23231H = charSequence;
        this.f23232I = k1(charSequence);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), p1(requireContext()));
        Context context = dialog.getContext();
        this.f23245m = r1(context);
        int i10 = C0977c.f30639K;
        int i11 = e4.l.f31009K;
        this.f23228E = new x4.i(context, null, i10, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, e4.m.f31378e5, i10, i11);
        int color = obtainStyledAttributes.getColor(e4.m.f31389f5, 0);
        obtainStyledAttributes.recycle();
        this.f23228E.initializeElevationOverlay(context);
        this.f23228E.setFillColor(ColorStateList.valueOf(color));
        this.f23228E.setElevation(K.r(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10;
        if (this.f23245m) {
            i10 = e4.i.f30916B;
        } else {
            i10 = e4.i.f30915A;
        }
        View inflate = layoutInflater.inflate(i10, viewGroup);
        Context context = inflate.getContext();
        DayViewDecorator dayViewDecorator = this.f23241i;
        if (dayViewDecorator != null) {
            dayViewDecorator.m(context);
        }
        if (this.f23245m) {
            inflate.findViewById(e4.g.f30838A).setLayoutParams(new LinearLayout.LayoutParams(n1(context), -2));
        } else {
            inflate.findViewById(e4.g.f30839B).setLayoutParams(new LinearLayout.LayoutParams(n1(context), -1));
        }
        TextView textView = (TextView) inflate.findViewById(e4.g.f30845H);
        this.f23226C = textView;
        K.l0(textView, 1);
        this.f23227D = (CheckableImageButton) inflate.findViewById(e4.g.f30846I);
        this.f23225B = (TextView) inflate.findViewById(e4.g.f30850M);
        q1(context);
        this.f23229F = (Button) inflate.findViewById(e4.g.f30870d);
        if (j1().Z()) {
            this.f23229F.setEnabled(true);
        } else {
            this.f23229F.setEnabled(false);
        }
        this.f23229F.setTag(f23221J);
        CharSequence charSequence = this.f23248p;
        if (charSequence != null) {
            this.f23229F.setText(charSequence);
        } else {
            int i11 = this.f23247o;
            if (i11 != 0) {
                this.f23229F.setText(i11);
            }
        }
        CharSequence charSequence2 = this.f23250r;
        if (charSequence2 != null) {
            this.f23229F.setContentDescription(charSequence2);
        } else if (this.f23249q != 0) {
            this.f23229F.setContentDescription(getContext().getResources().getText(this.f23249q));
        }
        this.f23229F.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(e4.g.f30864a);
        button.setTag(f23222K);
        CharSequence charSequence3 = this.f23252y;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i12 = this.f23251x;
            if (i12 != 0) {
                button.setText(i12);
            }
        }
        CharSequence charSequence4 = this.f23224A;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.f23253z != 0) {
            button.setContentDescription(getContext().getResources().getText(this.f23253z));
        }
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f23236d.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        Month p12;
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f23237e);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f23238f);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.f23240h);
        MaterialCalendar<S> materialCalendar = this.f23242j;
        if (materialCalendar == null) {
            p12 = null;
        } else {
            p12 = materialCalendar.p1();
        }
        if (p12 != null) {
            bVar.b(p12.f23164f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f23241i);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f23243k);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f23244l);
        bundle.putInt("INPUT_MODE_KEY", this.f23246n);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f23247o);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f23248p);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f23249q);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f23250r);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f23251x);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f23252y);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f23253z);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f23224A);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f23245m) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f23228E);
            i1(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(C0979e.f30805q0);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f23228E, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new ViewOnTouchListenerC1332a(requireDialog(), rect));
        }
        w1();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onStop() {
        this.f23239g.d1();
        super.onStop();
    }

    public final int p1(Context context) {
        int i10 = this.f23237e;
        if (i10 != 0) {
            return i10;
        }
        return j1().V(context);
    }

    public final void q1(Context context) {
        boolean z10;
        this.f23227D.setTag(f23223L);
        this.f23227D.setImageDrawable(h1(context));
        CheckableImageButton checkableImageButton = this.f23227D;
        if (this.f23246n != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        checkableImageButton.setChecked(z10);
        K.j0(this.f23227D, null);
        z1(this.f23227D);
        this.f23227D.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.this.u1(view);
            }
        });
    }

    public final boolean s1() {
        if (getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ void u1(View view) {
        this.f23229F.setEnabled(j1().Z());
        this.f23227D.toggle();
        int i10 = 1;
        if (this.f23246n == 1) {
            i10 = 0;
        }
        this.f23246n = i10;
        z1(this.f23227D);
        w1();
    }

    public final void w1() {
        int p12 = p1(requireContext());
        m u12 = MaterialCalendar.u1(j1(), p12, this.f23240h, this.f23241i);
        this.f23242j = u12;
        if (this.f23246n == 1) {
            u12 = m.e1(j1(), p12, this.f23240h);
        }
        this.f23239g = u12;
        y1();
        x1(m1());
        B p10 = getChildFragmentManager().p();
        p10.s(e4.g.f30838A, this.f23239g);
        p10.k();
        this.f23239g.c1(new d());
    }

    public void x1(String str) {
        this.f23226C.setContentDescription(l1());
        this.f23226C.setText(str);
    }

    public final void z1(CheckableImageButton checkableImageButton) {
        String string;
        if (this.f23246n == 1) {
            string = checkableImageButton.getContext().getString(e4.k.f30967T);
        } else {
            string = checkableImageButton.getContext().getString(e4.k.f30969V);
        }
        this.f23227D.setContentDescription(string);
    }
}
