package com.android.incallui.oplus.incomingfloatingwindow.presentation.utils;

import A.h;
import D2.k;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewRootImpl;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.incallui.OplusAnimationUtils;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.R;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.view.FloatingWindowView;
import com.android.internal.graphics.drawable.BackgroundBlurDrawable;
import com.android.oplus.brand.BrandCenter;
import com.internal_dependency.InternalSdkDepends;
import kotlin.jvm.internal.i;
import m9.q;
import q2.C1481a;
import v9.l;

/* compiled from: FloatingWindowBindingAdapterUtils.kt */
/* loaded from: classes.dex */
public final class FloatingWindowBindingAdapterUtilsKt {

    /* compiled from: FloatingWindowBindingAdapterUtils.kt */
    /* loaded from: classes.dex */
    public static final class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Float f18919a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Integer f18920b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Float f18921c;

        public a(Float f10, Integer num, Float f11) {
            this.f18919a = f10;
            this.f18920b = num;
            this.f18921c = f11;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (view != null) {
                FloatingWindowBindingAdapterUtilsKt.i(view, (int) this.f18919a.floatValue(), this.f18920b.intValue(), this.f18921c.floatValue());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (view != null) {
                view.removeOnAttachStateChangeListener(this);
            }
        }
    }

    /* compiled from: FloatingWindowBindingAdapterUtils.kt */
    /* loaded from: classes.dex */
    public static final class b extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Float f18922a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Float f18923b;

        public b(Float f10, Float f11) {
            this.f18922a = f10;
            this.f18923b = f11;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (view != null) {
                if (outline != null) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f18922a.floatValue());
                }
                if (outline != null) {
                    outline.offset(0, (int) this.f18923b.floatValue());
                }
            }
        }
    }

    public static final void A(TextView view, Integer num, Boolean bool) {
        i.f(view, "view");
        if (num != null && bool != null) {
            view.setTextColor(num.intValue());
        }
    }

    public static final void B(TextSwitcher view, String str, Boolean bool) {
        i.f(view, "view");
        TextView textView = null;
        if (i.b(bool, Boolean.FALSE)) {
            if (view.getMeasureAllChildren()) {
                View nextView = view.getNextView();
                if (nextView instanceof TextView) {
                    textView = (TextView) nextView;
                }
                if (textView != null) {
                    textView.setText(str);
                }
            }
            view.setCurrentText(str);
            return;
        }
        if (view.getMeasureAllChildren()) {
            View currentView = view.getCurrentView();
            if (currentView instanceof TextView) {
                textView = (TextView) currentView;
            }
            Animation outAnimation = view.getOutAnimation();
            if (outAnimation != null) {
                outAnimation.setAnimationListener(new c(textView, str));
            }
        }
        view.setText(str);
    }

    public static final void C(final View view, final q2.c cVar) {
        i.f(view, "view");
        view.setOnTouchListener(new f(view, true, cVar, new l<Integer, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.FloatingWindowBindingAdapterUtilsKt$setTopGravityGestureDetectorForButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Integer num) {
                q2.c cVar2 = q2.c.this;
                if (cVar2 != null) {
                    cVar2.h((q2.b) L.b.a(view, R.id.floatingWindowBtnBehavior), num);
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Integer num) {
                b(num);
                return q.f35511a;
            }
        }));
    }

    public static final void D(View view, final q2.c cVar) {
        i.f(view, "view");
        view.setOnTouchListener(new f(view, false, cVar, new l<Integer, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.FloatingWindowBindingAdapterUtilsKt$setTopGravityGestureDetectorForLayout$1
            {
                super(1);
            }

            public final void b(Integer num) {
                q2.c cVar2 = q2.c.this;
                if (cVar2 != null) {
                    cVar2.l();
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Integer num) {
                b(num);
                return q.f35511a;
            }
        }));
    }

    public static final void E(FloatingWindowView layout, q2.c cVar) {
        i.f(layout, "layout");
        layout.setUserActionListener(cVar);
    }

    public static final void F(FloatingWindowView view, C1481a c1481a) {
        i.f(view, "view");
        view.r(c1481a);
    }

    public static final Drawable G(int i10, Resources res, Resources.Theme theme) {
        i.f(res, "res");
        Drawable f10 = h.f(res, i10, theme);
        if (f10 != null) {
            f10.setBounds(0, 0, f10.getIntrinsicWidth(), f10.getIntrinsicHeight());
            return f10;
        }
        return null;
    }

    public static final void H(ConstraintLayout view, Boolean bool, Integer num, Integer num2) {
        i.f(view, "view");
        T5.a d10 = BrandCenter.f19187a.a().d();
        if (i.b(bool, Boolean.TRUE)) {
            if (d10 != null) {
                d10.v(view, num, num2);
            }
        } else if (d10 != null) {
            d10.m(view);
        }
    }

    public static final void a(ImageSwitcher view, com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a aVar, Boolean bool) {
        i.f(view, "view");
        if (aVar != null && bool != null) {
            com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a aVar2 = (com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a) L.b.b(view, aVar, R.id.floatingWindowBtnBehavior);
            ImageView imageView = null;
            if (i.b(aVar2, aVar)) {
                View currentView = view.getCurrentView();
                if (currentView instanceof ImageView) {
                    imageView = (ImageView) currentView;
                }
                if (imageView != null) {
                    imageView.setImageResource(aVar.a(bool.booleanValue()));
                    return;
                }
                return;
            }
            if (aVar2 != null) {
                view.setOutAnimation(view.getContext(), aVar2.e(aVar));
                view.setInAnimation(view.getContext(), aVar.d(aVar2));
            } else {
                view.setOutAnimation(null);
                view.setInAnimation(null);
            }
            view.setImageResource(aVar.a(bool.booleanValue()));
        }
    }

    public static final void b(View view, Integer num) {
        i.f(view, "view");
        if (num != null) {
            if (num.intValue() != view.getVisibility()) {
                if (num.intValue() == 8) {
                    OplusAnimationUtils.cardFold(view);
                } else {
                    view.setVisibility(num.intValue());
                }
            }
        }
    }

    public static final void c(View view, Boolean bool) {
        i.f(view, "view");
        if (!i.b(bool, Boolean.TRUE)) {
            return;
        }
        OplusAnimationUtils.cardFold(view);
    }

    public static final void d(View view) {
        i.f(view, "<this>");
        Drawable background = view.getBackground();
        if (!(background instanceof BackgroundBlurDrawable)) {
            return;
        }
        background.setVisible(false, false);
    }

    public static final BackgroundBlurDrawable e(ViewRootImpl viewRootImpl) {
        i.f(viewRootImpl, "viewRootImpl");
        Object b10 = k.b(viewRootImpl, "android.view.ViewRootImpl", "createBackgroundBlurDrawable", null, null);
        if (!(b10 instanceof BackgroundBlurDrawable)) {
            return null;
        }
        return (BackgroundBlurDrawable) b10;
    }

    public static final void f(View view, Boolean bool) {
        i.f(view, "view");
        if (!i.b(bool, Boolean.TRUE)) {
            return;
        }
        view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.floating_window_call_card_id_refresh));
    }

    public static final void g(View view, int i10) {
        i.f(view, "<this>");
        d(view);
        view.setBackgroundResource(i10);
    }

    public static final void h(View view, Drawable drawable, Boolean bool) {
        i.f(view, "view");
        if (drawable != null && bool != null) {
            view.setBackground(drawable);
        }
    }

    public static final void i(View view, int i10, int i11, float f10) {
        BackgroundBlurDrawable backgroundBlurDrawable;
        i.f(view, "<this>");
        if (OplusFeatureOption.VERSION_STORE) {
            view.setBackground(OplusInCallApp.getDefaultDisplayUiContext().getDrawable(R.drawable.floating_window_bg_default));
            return;
        }
        ViewRootImpl viewRootImpl = InternalSdkDepends.Companion.getSInstance().getViewRootImpl(view);
        if (viewRootImpl != null) {
            backgroundBlurDrawable = e(viewRootImpl);
        } else {
            backgroundBlurDrawable = null;
        }
        if (backgroundBlurDrawable != null) {
            k(backgroundBlurDrawable, i10);
            q(backgroundBlurDrawable, f10);
            n(backgroundBlurDrawable, i11);
            view.setBackground((Drawable) backgroundBlurDrawable);
        }
    }

    public static final void j(View view, Float f10, Integer num, Float f11, Boolean bool) {
        i.f(view, "view");
        if (f10 != null && num != null && f11 != null) {
            BackgroundBlurDrawable background = view.getBackground();
            if (background instanceof BackgroundBlurDrawable) {
                BackgroundBlurDrawable backgroundBlurDrawable = background;
                k(backgroundBlurDrawable, (int) f10.floatValue());
                n(backgroundBlurDrawable, num.intValue());
                q(backgroundBlurDrawable, f11.floatValue());
                return;
            }
            if (view.isAttachedToWindow()) {
                i(view, (int) f10.floatValue(), num.intValue(), f11.floatValue());
                return;
            }
            a aVar = new a(f10, num, f11);
            a aVar2 = (a) L.b.b(view, aVar, R.id.onAttachStateChangeListenerForBlurBackground);
            if (aVar2 != null) {
                view.removeOnAttachStateChangeListener(aVar2);
            }
            view.addOnAttachStateChangeListener(aVar);
        }
    }

    public static final void k(BackgroundBlurDrawable backgroundBlurDrawable, int i10) {
        i.f(backgroundBlurDrawable, "backgroundBlurDrawable");
        k.b(backgroundBlurDrawable, "com.android.internal.graphics.drawable.BackgroundBlurDrawable", "setBlurRadius", new Class[]{Integer.TYPE}, new Integer[]{Integer.valueOf(i10)});
    }

    public static final void l(final View view, final q2.c cVar) {
        i.f(view, "view");
        view.setOnTouchListener(new com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.b(view, true, cVar, new l<Integer, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.FloatingWindowBindingAdapterUtilsKt$setBottomGravityGestureDetectorForButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Integer num) {
                q2.c cVar2 = q2.c.this;
                if (cVar2 != null) {
                    cVar2.h((q2.b) L.b.a(view, R.id.floatingWindowBtnBehavior), num);
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Integer num) {
                b(num);
                return q.f35511a;
            }
        }));
    }

    public static final void m(View view, final q2.c cVar) {
        i.f(view, "view");
        view.setOnTouchListener(new com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.b(view, false, cVar, new l<Integer, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.FloatingWindowBindingAdapterUtilsKt$setBottomGravityGestureDetectorForLayout$1
            {
                super(1);
            }

            public final void b(Integer num) {
                q2.c cVar2 = q2.c.this;
                if (cVar2 != null) {
                    cVar2.l();
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Integer num) {
                b(num);
                return q.f35511a;
            }
        }));
    }

    public static final void n(BackgroundBlurDrawable backgroundBlurDrawable, int i10) {
        i.f(backgroundBlurDrawable, "backgroundBlurDrawable");
        k.b(backgroundBlurDrawable, "com.android.internal.graphics.drawable.BackgroundBlurDrawable", "setColor", new Class[]{Integer.TYPE}, new Integer[]{Integer.valueOf(i10)});
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r4 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        if (r5 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        if (r6 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0063, code lost:
    
        if (r7 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void o(android.widget.TextView r3, java.lang.Integer r4, java.lang.Integer r5, java.lang.Integer r6, java.lang.Integer r7, java.lang.Boolean r8) {
        /*
            java.lang.String r8 = "textView"
            kotlin.jvm.internal.i.f(r3, r8)
            if (r4 != 0) goto Le
            if (r5 != 0) goto Le
            if (r6 != 0) goto Le
            if (r7 != 0) goto Le
            return
        Le:
            android.graphics.drawable.Drawable[] r8 = r3.getCompoundDrawablesRelative()
            android.content.res.Resources r0 = r3.getResources()
            android.content.Context r1 = r3.getContext()
            android.content.res.Resources$Theme r1 = r1.getTheme()
            java.lang.String r2 = "res"
            if (r4 == 0) goto L2f
            int r4 = r4.intValue()
            kotlin.jvm.internal.i.e(r0, r2)
            android.graphics.drawable.Drawable r4 = G(r4, r0, r1)
            if (r4 != 0) goto L32
        L2f:
            r4 = 0
            r4 = r8[r4]
        L32:
            if (r5 == 0) goto L41
            int r5 = r5.intValue()
            kotlin.jvm.internal.i.e(r0, r2)
            android.graphics.drawable.Drawable r5 = G(r5, r0, r1)
            if (r5 != 0) goto L44
        L41:
            r5 = 1
            r5 = r8[r5]
        L44:
            if (r6 == 0) goto L53
            int r6 = r6.intValue()
            kotlin.jvm.internal.i.e(r0, r2)
            android.graphics.drawable.Drawable r6 = G(r6, r0, r1)
            if (r6 != 0) goto L56
        L53:
            r6 = 2
            r6 = r8[r6]
        L56:
            if (r7 == 0) goto L65
            int r7 = r7.intValue()
            kotlin.jvm.internal.i.e(r0, r2)
            android.graphics.drawable.Drawable r7 = G(r7, r0, r1)
            if (r7 != 0) goto L68
        L65:
            r7 = 3
            r7 = r8[r7]
        L68:
            r3.setCompoundDrawablesRelative(r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.FloatingWindowBindingAdapterUtilsKt.o(android.widget.TextView, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r4 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        if (r5 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        if (r6 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0063, code lost:
    
        if (r7 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void p(android.widget.TextView r3, java.lang.Integer r4, java.lang.Integer r5, java.lang.Integer r6, java.lang.Integer r7, java.lang.Boolean r8) {
        /*
            java.lang.String r8 = "textView"
            kotlin.jvm.internal.i.f(r3, r8)
            if (r4 != 0) goto Le
            if (r5 != 0) goto Le
            if (r6 != 0) goto Le
            if (r7 != 0) goto Le
            return
        Le:
            android.graphics.drawable.Drawable[] r8 = r3.getCompoundDrawables()
            android.content.res.Resources r0 = r3.getResources()
            android.content.Context r1 = r3.getContext()
            android.content.res.Resources$Theme r1 = r1.getTheme()
            java.lang.String r2 = "res"
            if (r4 == 0) goto L2f
            int r4 = r4.intValue()
            kotlin.jvm.internal.i.e(r0, r2)
            android.graphics.drawable.Drawable r4 = G(r4, r0, r1)
            if (r4 != 0) goto L32
        L2f:
            r4 = 0
            r4 = r8[r4]
        L32:
            if (r5 == 0) goto L41
            int r5 = r5.intValue()
            kotlin.jvm.internal.i.e(r0, r2)
            android.graphics.drawable.Drawable r5 = G(r5, r0, r1)
            if (r5 != 0) goto L44
        L41:
            r5 = 1
            r5 = r8[r5]
        L44:
            if (r6 == 0) goto L53
            int r6 = r6.intValue()
            kotlin.jvm.internal.i.e(r0, r2)
            android.graphics.drawable.Drawable r6 = G(r6, r0, r1)
            if (r6 != 0) goto L56
        L53:
            r6 = 2
            r6 = r8[r6]
        L56:
            if (r7 == 0) goto L65
            int r7 = r7.intValue()
            kotlin.jvm.internal.i.e(r0, r2)
            android.graphics.drawable.Drawable r7 = G(r7, r0, r1)
            if (r7 != 0) goto L68
        L65:
            r7 = 3
            r7 = r8[r7]
        L68:
            r3.setCompoundDrawablesWithIntrinsicBounds(r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.FloatingWindowBindingAdapterUtilsKt.p(android.widget.TextView, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Boolean):void");
    }

    public static final void q(BackgroundBlurDrawable backgroundBlurDrawable, float f10) {
        i.f(backgroundBlurDrawable, "backgroundBlurDrawable");
        k.b(backgroundBlurDrawable, "com.android.internal.graphics.drawable.BackgroundBlurDrawable", "setCornerRadius", new Class[]{Float.TYPE}, new Float[]{Float.valueOf(f10)});
    }

    public static final void r(View view, Integer num) {
        View findViewById;
        i.f(view, "view");
        if (num != null && (findViewById = view.findViewById(R.id.floating_view_default)) != null) {
            findViewById.setVisibility(num.intValue());
        }
    }

    public static final void s(View view, Integer num) {
        View findViewById;
        i.f(view, "view");
        if (num != null && (findViewById = view.findViewById(R.id.floating_view_drive_mode)) != null) {
            findViewById.setVisibility(num.intValue());
        }
    }

    public static final void t(View view, final q2.c cVar) {
        i.f(view, "view");
        view.setOnTouchListener(new f(view, true, cVar, new l<Integer, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.FloatingWindowBindingAdapterUtilsKt$setFloatingWindowVideoToVoiceBtnGestureDetector$1
            {
                super(1);
            }

            public final void b(Integer num) {
                q2.c cVar2 = q2.c.this;
                if (cVar2 != null) {
                    cVar2.k(num);
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Integer num) {
                b(num);
                return q.f35511a;
            }
        }));
    }

    public static final void u(ImageView view, Integer num, Boolean bool) {
        i.f(view, "view");
        if (num == null) {
            return;
        }
        view.setImageResource(num.intValue());
    }

    public static final void v(View view, Integer num) {
        View findViewById;
        i.f(view, "view");
        if (num != null && (findViewById = view.findViewById(R.id.floating_view_navi_landscape)) != null) {
            findViewById.setVisibility(num.intValue());
        }
    }

    public static final void w(View view, Integer num) {
        View findViewById;
        i.f(view, "view");
        if (num != null && (findViewById = view.findViewById(R.id.floating_view_navi_portrait)) != null) {
            findViewById.setVisibility(num.intValue());
        }
    }

    public static final void x(View view, View.OnAttachStateChangeListener onAttachStateChangeListener) {
        i.f(view, "view");
        View.OnAttachStateChangeListener onAttachStateChangeListener2 = (View.OnAttachStateChangeListener) L.b.b(view, onAttachStateChangeListener, R.id.onAttachStateChangeListener);
        if (i.b(onAttachStateChangeListener2, onAttachStateChangeListener)) {
            return;
        }
        if (onAttachStateChangeListener2 != null) {
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener2);
        }
        if (onAttachStateChangeListener != null) {
            view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            if (view.isAttachedToWindow()) {
                onAttachStateChangeListener.onViewAttachedToWindow(view);
            }
        }
    }

    public static final void y(View view, View.OnAttachStateChangeListener onAttachStateChangeListener) {
        i.f(view, "view");
        View.OnAttachStateChangeListener onAttachStateChangeListener2 = (View.OnAttachStateChangeListener) L.b.b(view, onAttachStateChangeListener, R.id.onAttachStateChangeListenerForViewModel);
        if (i.b(onAttachStateChangeListener2, onAttachStateChangeListener)) {
            return;
        }
        if (onAttachStateChangeListener2 != null) {
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener2);
        }
        if (onAttachStateChangeListener != null) {
            view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            if (view.isAttachedToWindow()) {
                onAttachStateChangeListener.onViewAttachedToWindow(view);
            }
        }
    }

    public static final void z(View view, Float f10, Float f11) {
        i.f(view, "view");
        if (f10 != null && f11 != null) {
            view.setOutlineProvider(new b(f10, f11));
        }
    }

    /* compiled from: FloatingWindowBindingAdapterUtils.kt */
    /* loaded from: classes.dex */
    public static final class c implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f18924a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f18925b;

        public c(TextView textView, String str) {
            this.f18924a = textView;
            this.f18925b = str;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            TextView textView = this.f18924a;
            if (textView != null) {
                textView.setText(this.f18925b);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
