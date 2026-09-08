package com.coui.appcompat.searchhistory;

import X8.n;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.N;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.searchhistory.COUIFlowLayout;
import com.coui.appcompat.textview.COUITextView;
import java.util.List;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: COUISearchHistoryView.kt */
/* loaded from: classes.dex */
public class COUISearchHistoryView extends ConstraintLayout {
    private static final float ALPHA_VALUE_MAX = 1.0f;
    private static final float ALPHA_VALUE_MIN = 0.0f;
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_MAX_ROW_UNFOLDED = 8;
    private static final long SEARCH_VIEW_DISAPPEAR_DURATION = 300;
    private final AppCompatImageView deleteIcon;
    private final COUIFlowLayout flowContainer;
    private int maxRowFolded;
    private final COUITextView title;
    private final RelativeLayout titleBar;

    /* compiled from: COUISearchHistoryView.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUISearchHistoryView(Context context) {
        this(context, null, 0, 0, 14, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    private final void doDeleteAnimation() {
        ObjectAnimator doDeleteAnimation$lambda$12 = ObjectAnimator.ofFloat(this, (Property<COUISearchHistoryView, Float>) View.ALPHA, 1.0f, 0.0f);
        doDeleteAnimation$lambda$12.setInterpolator(new COUIMoveEaseInterpolator());
        doDeleteAnimation$lambda$12.setDuration(SEARCH_VIEW_DISAPPEAR_DURATION);
        kotlin.jvm.internal.i.e(doDeleteAnimation$lambda$12, "doDeleteAnimation$lambda$12");
        doDeleteAnimation$lambda$12.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.searchhistory.COUISearchHistoryView$doDeleteAnimation$lambda$12$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                kotlin.jvm.internal.i.f(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                kotlin.jvm.internal.i.f(animator, "animator");
                COUISearchHistoryView.this.getFlowContainer().clearAll();
                COUISearchHistoryView.this.removeAllViews();
                COUISearchHistoryView.this.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                kotlin.jvm.internal.i.f(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                kotlin.jvm.internal.i.f(animator, "animator");
            }
        });
        doDeleteAnimation$lambda$12.start();
    }

    private final void ensureViews() {
        boolean f10;
        boolean f11;
        f10 = SequencesKt___SequencesKt.f(N.b(this), this.titleBar);
        if (!f10) {
            addView(this.titleBar);
        }
        f11 = SequencesKt___SequencesKt.f(N.b(this), this.flowContainer);
        if (!f11) {
            addView(this.flowContainer);
        }
    }

    private final int getDeleteIconMarginEnd() {
        return getDimenPx(this, Z8.c.f6000U);
    }

    private final int getDimenPx(View view, int i10) {
        return view.getContext().getResources().getDimensionPixelSize(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnDeleteClickListener$lambda$10(COUISearchHistoryView this$0, View.OnClickListener onClickListener, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(onClickListener, "$onClickListener");
        this$0.doDeleteAnimation();
        onClickListener.onClick(view);
    }

    public final void clearAll() {
        this.flowContainer.clearAll();
    }

    public final COUIFlowLayout getCOUIFlowLayout() {
        return this.flowContainer;
    }

    public final AppCompatImageView getDeleteIcon() {
        return this.deleteIcon;
    }

    public final COUIFlowLayout getFlowContainer() {
        return this.flowContainer;
    }

    public final int getMaxRowFolded() {
        return this.maxRowFolded;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AppCompatImageView appCompatImageView = this.deleteIcon;
        ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginEnd(getDeleteIconMarginEnd());
            appCompatImageView.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public final void setDeleteIconDescription(CharSequence charSequence) {
        this.deleteIcon.setContentDescription(charSequence);
    }

    public final void setExpandState(boolean z10) {
        this.flowContainer.setExpand(z10);
    }

    public final void setExpandable(boolean z10) {
        this.flowContainer.setExpandable(z10);
    }

    public final void setItems(List<? extends COUIFlowLayout.IItem> items) {
        kotlin.jvm.internal.i.f(items, "items");
        ensureViews();
        this.flowContainer.setItems(items);
    }

    public final void setMaxRowFolded(int i10) {
        this.maxRowFolded = i10;
        this.flowContainer.setMaxRowFolded(i10);
    }

    public final void setOnDeleteClickListener(final View.OnClickListener onClickListener) {
        kotlin.jvm.internal.i.f(onClickListener, "onClickListener");
        this.deleteIcon.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.searchhistory.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUISearchHistoryView.setOnDeleteClickListener$lambda$10(COUISearchHistoryView.this, onClickListener, view);
            }
        });
    }

    public final void setOnItemClickListener(COUIFlowLayout.OnItemClickListener onItemClickListener) {
        kotlin.jvm.internal.i.f(onItemClickListener, "onItemClickListener");
        this.flowContainer.setOnItemClickListener(onItemClickListener);
    }

    public final void setTitle(CharSequence content) {
        kotlin.jvm.internal.i.f(content, "content");
        this.title.setText(content);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUISearchHistoryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    public final void setTitle(int i10) {
        this.title.setText(i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUISearchHistoryView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    public /* synthetic */ COUISearchHistoryView(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUISearchHistoryView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.i.f(context, "context");
        this.maxRowFolded = Integer.MAX_VALUE;
        COUITextView cOUITextView = new COUITextView(context);
        cOUITextView.setId(Z8.e.f6086H);
        cOUITextView.setTextAppearance(n.f5053y);
        cOUITextView.setTextColor(COUIContextUtil.getAttrColor(context, X8.c.f4348G));
        cOUITextView.setTextAlignment(4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(20);
        cOUITextView.setLayoutParams(layoutParams);
        this.title = cOUITextView;
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        appCompatImageView.setId(Z8.e.f6084G);
        appCompatImageView.setImageResource(Z8.d.f6062e);
        appCompatImageView.setBackgroundResource(Z8.d.f6061d);
        int i12 = Z8.c.f6001V;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getDimenPx(appCompatImageView, i12), getDimenPx(appCompatImageView, i12));
        layoutParams2.addRule(21);
        layoutParams2.setMarginEnd(getDeleteIconMarginEnd());
        appCompatImageView.setLayoutParams(layoutParams2);
        this.deleteIcon = appCompatImageView;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        int i13 = Z8.e.f6088I;
        relativeLayout.setId(i13);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-1, -2);
        relativeLayout.setGravity(16);
        layoutParams3.topToTop = 0;
        relativeLayout.setLayoutParams(layoutParams3);
        relativeLayout.setClipChildren(false);
        relativeLayout.setClipToPadding(false);
        int i14 = Z8.c.f6013d0;
        relativeLayout.setPadding(0, getDimenPx(relativeLayout, i14), 0, getDimenPx(relativeLayout, i14));
        this.titleBar = relativeLayout;
        COUIFlowLayout cOUIFlowLayout = new COUIFlowLayout(context, null, 0, 0, 14, null);
        cOUIFlowLayout.setMaxRowUnfolded(8);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams4.topToBottom = i13;
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = getDimenPx(cOUIFlowLayout, Z8.c.f6004Y);
        cOUIFlowLayout.setLayoutParams(layoutParams4);
        this.flowContainer = cOUIFlowLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Z8.i.f6219Y, i10, i11);
        setExpandable(obtainStyledAttributes.getBoolean(Z8.i.f6222a0, true));
        CharSequence string = obtainStyledAttributes.getString(Z8.i.f6226c0);
        if (string == null) {
            string = new String();
        } else {
            kotlin.jvm.internal.i.e(string, "getString(R.styleable.CO…ryView_title) ?: String()");
        }
        setTitle(string);
        setDeleteIconDescription(obtainStyledAttributes.getString(Z8.i.f6220Z));
        setMaxRowFolded(obtainStyledAttributes.getInteger(Z8.i.f6224b0, Integer.MAX_VALUE));
        obtainStyledAttributes.recycle();
        setClipChildren(false);
        setClipToPadding(false);
        setPaddingRelative(getDimenPx(this, Z8.c.f6009b0), getDimenPx(this, Z8.c.f6011c0), getDimenPx(this, Z8.c.f6007a0), getDimenPx(this, Z8.c.f6005Z));
        cOUIFlowLayout.setItemSpacing(getDimenPx(cOUIFlowLayout, Z8.c.f6002W));
        cOUIFlowLayout.setLineSpacing(getDimenPx(cOUIFlowLayout, Z8.c.f6003X));
        relativeLayout.addView(cOUITextView);
        relativeLayout.addView(appCompatImageView);
        addView(relativeLayout);
        addView(cOUIFlowLayout);
    }
}
