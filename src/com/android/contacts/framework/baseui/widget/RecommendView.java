package com.android.contacts.framework.baseui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.contacts.framework.baseui.util.r;

/* compiled from: RecommendView.kt */
/* loaded from: classes.dex */
public final class RecommendView extends FrameLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    public static final a f16090d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public T0.b f16091a;

    /* renamed from: b, reason: collision with root package name */
    public View.OnClickListener f16092b;

    /* renamed from: c, reason: collision with root package name */
    public View.OnClickListener f16093c;

    /* compiled from: RecommendView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    public static final void c(RecommendView this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        T0.b bVar = this$0.f16091a;
        if (bVar == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            bVar = null;
        }
        bVar.f3697d.requestLayout();
    }

    public static final boolean d(View view, MotionEvent motionEvent) {
        return true;
    }

    public final void e(int i10, int i11, int i12, int i13) {
        T0.b bVar = this.f16091a;
        T0.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            bVar = null;
        }
        bVar.f3700g.setImageResource(i10);
        T0.b bVar3 = this.f16091a;
        if (bVar3 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            bVar3 = null;
        }
        bVar3.f3698e.setText(i11);
        T0.b bVar4 = this.f16091a;
        if (bVar4 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            bVar4 = null;
        }
        bVar4.f3696c.setText(i12);
        T0.b bVar5 = this.f16091a;
        if (bVar5 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
        } else {
            bVar2 = bVar5;
        }
        bVar2.f3699f.setText(i13);
    }

    @Override // android.view.View
    public void forceLayout() {
        super.forceLayout();
        T0.b bVar = this.f16091a;
        if (bVar != null) {
            if (bVar == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                bVar = null;
            }
            bVar.f3697d.forceLayout();
        }
    }

    public final View.OnClickListener getActionClickListener() {
        return this.f16092b;
    }

    public final View.OnClickListener getDismissClickListener() {
        return this.f16093c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        View.OnClickListener onClickListener;
        kotlin.jvm.internal.i.f(v10, "v");
        int id = v10.getId();
        if (id == N0.i.f1925c) {
            View.OnClickListener onClickListener2 = this.f16092b;
            if (onClickListener2 != null) {
                onClickListener2.onClick(v10);
                return;
            }
            return;
        }
        if (id == N0.i.f1935m && (onClickListener = this.f16093c) != null) {
            onClickListener.onClick(v10);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        T0.b a10 = T0.b.a(this);
        kotlin.jvm.internal.i.e(a10, "bind(this)");
        this.f16091a = a10;
        T0.b bVar = null;
        if (a10 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            a10 = null;
        }
        a10.f3699f.setOnClickListener(this);
        T0.b bVar2 = this.f16091a;
        if (bVar2 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            bVar2 = null;
        }
        bVar2.f3696c.setOnClickListener(this);
        Context context = getContext();
        T0.b bVar3 = this.f16091a;
        if (bVar3 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
        } else {
            bVar = bVar3;
        }
        r.e(context, bVar.f3702i);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        T0.b bVar = this.f16091a;
        if (bVar != null) {
            T0.b bVar2 = null;
            if (bVar == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                bVar = null;
            }
            if (bVar.f3697d.isInLayout()) {
                H7.b.e("RecommendView", "requestLayout when isInLayout");
                post(new Runnable() { // from class: com.android.contacts.framework.baseui.widget.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecommendView.c(RecommendView.this);
                    }
                });
                return;
            }
            T0.b bVar3 = this.f16091a;
            if (bVar3 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
            } else {
                bVar2 = bVar3;
            }
            bVar2.f3697d.requestLayout();
        }
    }

    public final void setActionClickListener(View.OnClickListener onClickListener) {
        this.f16092b = onClickListener;
    }

    public final void setDismissClickListener(View.OnClickListener onClickListener) {
        this.f16093c = onClickListener;
    }

    public final void setEditMode(boolean z10) {
        T0.b bVar = null;
        if (z10) {
            T0.b bVar2 = this.f16091a;
            if (bVar2 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                bVar2 = null;
            }
            bVar2.f3700g.setAlpha(0.6f);
            T0.b bVar3 = this.f16091a;
            if (bVar3 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                bVar3 = null;
            }
            TextView textView = bVar3.f3696c;
            Context context = getContext();
            int i10 = N0.e.f1855d;
            textView.setTextColor(context.getColor(i10));
            T0.b bVar4 = this.f16091a;
            if (bVar4 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                bVar4 = null;
            }
            bVar4.f3699f.setTextColor(getContext().getColor(i10));
            setOnTouchListener(new View.OnTouchListener() { // from class: com.android.contacts.framework.baseui.widget.l
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean d10;
                    d10 = RecommendView.d(view, motionEvent);
                    return d10;
                }
            });
        } else {
            T0.b bVar5 = this.f16091a;
            if (bVar5 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                bVar5 = null;
            }
            bVar5.f3700g.setAlpha(1.0f);
            T0.b bVar6 = this.f16091a;
            if (bVar6 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                bVar6 = null;
            }
            bVar6.f3696c.setTextColor(r.a(getContext()));
            T0.b bVar7 = this.f16091a;
            if (bVar7 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                bVar7 = null;
            }
            bVar7.f3699f.setTextColor(r.a(getContext()));
            setOnTouchListener(null);
        }
        T0.b bVar8 = this.f16091a;
        if (bVar8 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            bVar8 = null;
        }
        bVar8.f3696c.setEnabled(!z10);
        T0.b bVar9 = this.f16091a;
        if (bVar9 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            bVar9 = null;
        }
        bVar9.f3699f.setEnabled(!z10);
        T0.b bVar10 = this.f16091a;
        if (bVar10 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
        } else {
            bVar = bVar10;
        }
        bVar.f3698e.setEnabled(!z10);
    }

    public /* synthetic */ RecommendView(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.i.f(context, "context");
    }
}
