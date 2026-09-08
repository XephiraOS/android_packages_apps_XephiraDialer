package com.coui.appcompat.completeview;

import Z8.e;
import Z8.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.coui.appcompat.grid.COUIPercentWidthLinearLayout;
import com.oplus.anim.EffectiveAnimationView;
import kotlin.a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: COUICompleteStateView.kt */
/* loaded from: classes.dex */
public final class COUICompleteStateView extends COUIPercentWidthLinearLayout {
    public static final int COMPLETE_TYPE_DEFAULT = 0;
    public static final int COMPLETE_TYPE_FAILED = 2;
    public static final int COMPLETE_TYPE_SUCCESS = 1;
    public static final int COMPLETE_TYPE_WAIT = 3;
    public static final Companion Companion = new Companion(null);
    private final d animView$delegate;
    private boolean autoPlay;
    private int completeType;
    private final int failedAnimRes;
    private int rawAnimRes;
    private final d subTitle$delegate;
    private String subtitleText;
    private final int successAnimRes;
    private final d title$delegate;
    private String titleText;
    private final int waitAnimRes;

    /* compiled from: COUICompleteStateView.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUICompleteStateView(Context context) {
        this(context, null, 0, 0, 14, null);
        i.f(context, "context");
    }

    private final EffectiveAnimationView getAnimView() {
        Object value = this.animView$delegate.getValue();
        i.e(value, "<get-animView>(...)");
        return (EffectiveAnimationView) value;
    }

    private final TextView getSubTitle() {
        Object value = this.subTitle$delegate.getValue();
        i.e(value, "<get-subTitle>(...)");
        return (TextView) value;
    }

    private final TextView getTitle() {
        Object value = this.title$delegate.getValue();
        i.e(value, "<get-title>(...)");
        return (TextView) value;
    }

    private final void updateAnimRes(int i10) {
        if (i10 > 0) {
            this.rawAnimRes = i10;
        }
    }

    public final EffectiveAnimationView getAnimationView() {
        return getAnimView();
    }

    public final boolean getAutoPlay() {
        return this.autoPlay;
    }

    public final int getCompleteType() {
        return this.completeType;
    }

    public final String getSubtitleText() {
        return this.subtitleText;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && getAnimView().getVisibility() != 4) {
            playAnimatorRes();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getAnimView().isAnimating()) {
            getAnimView().cancelAnimation();
        }
    }

    public final void playAnimatorRes() {
        if (getAnimView().isAnimating()) {
            getAnimView().cancelAnimation();
        }
        if (this.rawAnimRes > 0) {
            getAnimView().setAnimation(this.rawAnimRes);
            getAnimView().playAnimation();
        }
    }

    public final void setAutoPlay(boolean z10) {
        this.autoPlay = z10;
    }

    public final void setCompleteType(int i10) {
        if (i10 == this.completeType) {
            return;
        }
        this.completeType = i10;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    updateAnimRes(this.waitAnimRes);
                }
            } else {
                updateAnimRes(this.failedAnimRes);
            }
        } else {
            updateAnimRes(this.successAnimRes);
        }
        requestLayout();
    }

    public final void setSubtitle(int i10) {
        boolean z10;
        TextView subTitle = getSubTitle();
        subTitle.setText(i10);
        CharSequence text = subTitle.getText();
        int i11 = 0;
        if (text != null && text.length() != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!(!z10)) {
            i11 = 8;
        }
        subTitle.setVisibility(i11);
    }

    public final void setSubtitleText(String str) {
        this.subtitleText = str;
    }

    public final void setTitleText(int i10) {
        boolean z10;
        TextView title = getTitle();
        title.setText(i10);
        CharSequence text = title.getText();
        int i11 = 0;
        if (text != null && text.length() != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!(!z10)) {
            i11 = 8;
        }
        title.setVisibility(i11);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUICompleteStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUICompleteStateView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        i.f(context, "context");
    }

    public /* synthetic */ COUICompleteStateView(Context context, AttributeSet attributeSet, int i10, int i11, int i12, f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUICompleteStateView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        d b10;
        d b11;
        d b12;
        i.f(context, "context");
        this.successAnimRes = g.f6192b;
        this.failedAnimRes = g.f6191a;
        this.waitAnimRes = g.f6193c;
        b10 = a.b(new InterfaceC1637a<TextView>() { // from class: com.coui.appcompat.completeview.COUICompleteStateView$title$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final TextView invoke() {
                return (TextView) COUICompleteStateView.this.findViewById(e.f6139q);
            }
        });
        this.title$delegate = b10;
        b11 = a.b(new InterfaceC1637a<TextView>() { // from class: com.coui.appcompat.completeview.COUICompleteStateView$subTitle$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final TextView invoke() {
                return (TextView) COUICompleteStateView.this.findViewById(e.f6137p);
            }
        });
        this.subTitle$delegate = b11;
        b12 = a.b(new InterfaceC1637a<EffectiveAnimationView>() { // from class: com.coui.appcompat.completeview.COUICompleteStateView$animView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final EffectiveAnimationView invoke() {
                return (EffectiveAnimationView) COUICompleteStateView.this.findViewById(e.f6135o);
            }
        });
        this.animView$delegate = b12;
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        LayoutInflater.from(context).inflate(Z8.f.f6173i, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Z8.i.f6236m, i10, i11);
        this.autoPlay = obtainStyledAttributes.getBoolean(Z8.i.f6237n, true);
        this.titleText = obtainStyledAttributes.getString(Z8.i.f6241r);
        this.subtitleText = obtainStyledAttributes.getString(Z8.i.f6240q);
        int resourceId = obtainStyledAttributes.getResourceId(Z8.i.f6238o, 0);
        if (resourceId > 0) {
            updateAnimRes(resourceId);
        } else {
            setCompleteType(obtainStyledAttributes.getInteger(Z8.i.f6239p, 0));
        }
        obtainStyledAttributes.recycle();
        getTitle().setText(this.titleText);
        getSubTitle().setText(this.subtitleText);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
    }
}
