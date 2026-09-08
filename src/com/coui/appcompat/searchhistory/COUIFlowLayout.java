package com.coui.appcompat.searchhistory;

import a9.l;
import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.N;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.chip.COUIChip;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.searchhistory.COUIFlowLayout;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import e4.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.E;
import kotlin.collections.o;
import kotlin.collections.p;
import kotlin.collections.t;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: COUIFlowLayout.kt */
/* loaded from: classes.dex */
public class COUIFlowLayout extends ViewGroup {
    private static final float ALPHA_VALUE_MAX = 1.0f;
    private static final float ALPHA_VALUE_MIN = 0.0f;
    public static final Companion Companion = new Companion(null);
    private static final long EXPAND_BUTTON_APPEAR_DURATION = 250;
    private static final long HIDDEN_VIEWS_APPEAR_DELAY = 100;
    private static final long HIDDEN_VIEWS_APPEAR_DURATION = 400;
    private static final long HIDDEN_VIEWS_DISAPPEAR_DURATION = 300;
    private static final String PROPERTY_EXPAND_BUTTON_ALPHA = "expand_button_alpha";
    private static final String PROPERTY_FOLD_BUTTON_ALPHA = "fold_button_alpha";
    private static final String TAG = "COUIFlowLayout";
    private View expandButton;
    private View.OnClickListener expandOnClickListener;
    private boolean expandable;
    private int expandedStateHeight;
    private View foldButton;
    private View foldLineRemovedChip;
    private View.OnClickListener foldOnClickListener;
    private int foldedStateHeight;
    private boolean isExpand;
    private final LinkedHashMap<Integer, IItem> itemCache;
    private int itemSpacing;
    private int lineSpacing;
    private final List<Line> lines;
    private int maxRowFolded;
    private int maxRowUnfolded;
    private OnItemClickListener onItemClickListener;
    private final ConcurrentLinkedQueue<ValueAnimator> runningAnimators;
    private float tempHiddenViewsAlphaFlg;
    private float tempVisibleViewsAlphaFlg;

    /* compiled from: COUIFlowLayout.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: COUIFlowLayout.kt */
    /* loaded from: classes.dex */
    public interface IItem {
        String getContent();
    }

    /* compiled from: COUIFlowLayout.kt */
    /* loaded from: classes.dex */
    public static class Item implements IItem {
        private final String displayContent;

        public Item(String displayContent) {
            kotlin.jvm.internal.i.f(displayContent, "displayContent");
            this.displayContent = displayContent;
        }

        @Override // com.coui.appcompat.searchhistory.COUIFlowLayout.IItem
        public String getContent() {
            return this.displayContent;
        }

        public final String getDisplayContent() {
            return this.displayContent;
        }
    }

    /* compiled from: COUIFlowLayout.kt */
    /* loaded from: classes.dex */
    public static final class Line {
        private int height;
        private final int horizontalSpace;
        private final int maxWidth;
        private View removedView;
        private int usedWidth;
        private final List<View> views = new ArrayList();

        public Line(int i10, int i11) {
            this.maxWidth = i10;
            this.horizontalSpace = i11;
        }

        private final void layoutRemovedView(int i10, int i11, int i12) {
            View view = this.removedView;
            if (view != null) {
                view.layout(i10, i11, view.getMeasuredWidth() + i10, i12);
            }
        }

        public final void addView(View view) {
            kotlin.jvm.internal.i.f(view, "view");
            int size = this.views.size();
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (size == 0) {
                this.usedWidth = Math.min(measuredWidth, this.maxWidth);
                this.height = measuredHeight;
            } else {
                this.usedWidth += measuredWidth + this.horizontalSpace;
                this.height = Integer.max(measuredHeight, this.height);
            }
            this.views.add(view);
        }

        public final boolean canAdd(View view) {
            kotlin.jvm.internal.i.f(view, "view");
            if (this.views.size() == 0) {
                return true;
            }
            if (this.usedWidth + this.horizontalSpace + view.getMeasuredWidth() <= this.maxWidth) {
                return true;
            }
            return false;
        }

        public final int getHeight() {
            return this.height;
        }

        public final View getRemovedView() {
            return this.removedView;
        }

        public final int getUsedWidth() {
            return this.usedWidth;
        }

        public final List<View> getViews() {
            return this.views;
        }

        public final void layout(int i10, int i11, int i12, boolean z10) {
            int e10;
            int e11;
            for (View view : this.views) {
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                e10 = B9.i.e(i11, i12);
                int i13 = i10 + measuredWidth;
                e11 = B9.i.e(measuredHeight + e10, i12);
                if (z10) {
                    int i14 = this.maxWidth;
                    view.layout(i14 - i13, e10, i14 - i10, e11);
                } else {
                    view.layout(i10, e10, i13, e11);
                }
                if (view instanceof ImageView) {
                    layoutRemovedView(i10, e10, e11);
                }
                i10 += measuredWidth + this.horizontalSpace;
            }
        }

        public final void removeView(View view) {
            kotlin.jvm.internal.i.f(view, "view");
            if (this.views.size() == 0 || !this.views.contains(view)) {
                return;
            }
            this.usedWidth -= view.getMeasuredWidth() + this.horizontalSpace;
            this.views.remove(view);
        }

        public final void setHeight(int i10) {
            this.height = i10;
        }

        public final void setRemovedView(View view) {
            this.removedView = view;
        }

        public final void setUsedWidth(int i10) {
            this.usedWidth = i10;
        }
    }

    /* compiled from: COUIFlowLayout.kt */
    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onItemClick(IItem iItem);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIFlowLayout(Context context) {
        this(context, null, 0, 0, 14, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    private final boolean almostEquals(float f10, int i10) {
        if (f10 - i10 < 0.001d) {
            return true;
        }
        return false;
    }

    private final int calculateLinesHeight(List<Line> list) {
        Iterator<T> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((Line) it.next()).getHeight();
        }
        return i10 + (this.lineSpacing * (list.size() - 1));
    }

    private final void cancelAnimation() {
        stopAnimationRunning();
    }

    private final void doExpandAnimation() {
        if (isAnimationRunning()) {
            stopAnimationRunning();
        } else {
            this.tempHiddenViewsAlphaFlg = -1.0f;
            this.tempVisibleViewsAlphaFlg = -1.0f;
            stopAnimationRunning();
        }
        float f10 = this.tempVisibleViewsAlphaFlg;
        float f11 = 0.0f;
        if (f10 < 0.0f) {
            f10 = 1.0f;
        }
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(PROPERTY_EXPAND_BUTTON_ALPHA, f10, 0.0f);
        float f12 = this.tempHiddenViewsAlphaFlg;
        if (f12 >= 0.0f) {
            f11 = f12;
        }
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(PROPERTY_FOLD_BUTTON_ALPHA, f11, 1.0f);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(ofFloat2);
        valueAnimator.setInterpolator(new COUIMoveEaseInterpolator());
        valueAnimator.setDuration(HIDDEN_VIEWS_APPEAR_DURATION);
        valueAnimator.setStartDelay(100L);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchhistory.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUIFlowLayout.doExpandAnimation$lambda$22$lambda$21(COUIFlowLayout.this, valueAnimator2);
            }
        });
        valueAnimator.start();
        this.runningAnimators.add(valueAnimator);
        ValueAnimator valueAnimator2 = new ValueAnimator();
        valueAnimator2.setValues(ofFloat);
        valueAnimator2.setInterpolator(new COUIMoveEaseInterpolator());
        valueAnimator2.setDuration(EXPAND_BUTTON_APPEAR_DURATION);
        valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchhistory.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                COUIFlowLayout.doExpandAnimation$lambda$25$lambda$23(COUIFlowLayout.this, valueAnimator3);
            }
        });
        valueAnimator2.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.searchhistory.COUIFlowLayout$doExpandAnimation$lambda$25$$inlined$doOnStart$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                kotlin.jvm.internal.i.f(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                kotlin.jvm.internal.i.f(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                kotlin.jvm.internal.i.f(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                kotlin.jvm.internal.i.f(animator, "animator");
                COUIFlowLayout.this.setExpand(true);
            }
        });
        valueAnimator2.start();
        this.runningAnimators.add(valueAnimator2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doExpandAnimation$lambda$22$lambda$21(COUIFlowLayout this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue(PROPERTY_FOLD_BUTTON_ALPHA);
        kotlin.jvm.internal.i.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.tempHiddenViewsAlphaFlg = floatValue;
        this$0.setHiddenViewsAlpha(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doExpandAnimation$lambda$25$lambda$23(COUIFlowLayout this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue(PROPERTY_EXPAND_BUTTON_ALPHA);
        kotlin.jvm.internal.i.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.tempVisibleViewsAlphaFlg = floatValue;
        this$0.setVisibleViewsAlpha(floatValue);
    }

    private final void doFoldAnimation() {
        if (isAnimationRunning()) {
            stopAnimationRunning();
        } else {
            this.tempHiddenViewsAlphaFlg = -1.0f;
            this.tempVisibleViewsAlphaFlg = -1.0f;
            stopAnimationRunning();
        }
        float f10 = this.tempVisibleViewsAlphaFlg;
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        float f11 = 1.0f;
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(PROPERTY_EXPAND_BUTTON_ALPHA, f10, 1.0f);
        float f12 = this.tempHiddenViewsAlphaFlg;
        if (f12 >= 0.0f) {
            f11 = f12;
        }
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(PROPERTY_FOLD_BUTTON_ALPHA, f11, 0.0f);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(ofFloat, ofFloat2);
        valueAnimator.setInterpolator(new COUIMoveEaseInterpolator());
        valueAnimator.setDuration(HIDDEN_VIEWS_DISAPPEAR_DURATION);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchhistory.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUIFlowLayout.doFoldAnimation$lambda$28$lambda$26(COUIFlowLayout.this, valueAnimator2);
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.searchhistory.COUIFlowLayout$doFoldAnimation$lambda$28$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                kotlin.jvm.internal.i.f(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                kotlin.jvm.internal.i.f(animator, "animator");
                COUIFlowLayout.this.setExpand(false);
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
        valueAnimator.start();
        this.runningAnimators.add(valueAnimator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doFoldAnimation$lambda$28$lambda$26(COUIFlowLayout this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue(PROPERTY_FOLD_BUTTON_ALPHA);
        kotlin.jvm.internal.i.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.tempHiddenViewsAlphaFlg = ((Float) animatedValue).floatValue();
        Object animatedValue2 = valueAnimator.getAnimatedValue(PROPERTY_EXPAND_BUTTON_ALPHA);
        kotlin.jvm.internal.i.d(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        this$0.tempVisibleViewsAlphaFlg = ((Float) animatedValue2).floatValue();
        this$0.setHiddenViewsAlpha(this$0.tempHiddenViewsAlphaFlg);
        this$0.setVisibleViewsAlpha(this$0.tempVisibleViewsAlphaFlg);
    }

    private final void ensureAndExpandButton() {
        Object F10;
        Object E10;
        Object F11;
        ArrayList arrayList = new ArrayList(this.lines);
        int size = arrayList.size();
        int i10 = this.maxRowFolded;
        if (size < i10 - 1) {
            return;
        }
        Line line = (Line) arrayList.get(i10 - 1);
        F10 = CollectionsKt___CollectionsKt.F(line.getViews());
        View view = (View) F10;
        if (view != null && !line.canAdd(this.foldButton)) {
            line.removeView(view);
            line.setRemovedView(view);
            this.foldLineRemovedChip = view;
        }
        line.addView(this.expandButton);
        if (this.isExpand) {
            E10 = CollectionsKt___CollectionsKt.E(arrayList);
            Line line2 = (Line) E10;
            F11 = CollectionsKt___CollectionsKt.F(line2.getViews());
            View view2 = (View) F11;
            if (view2 != null && !line2.canAdd(this.expandButton)) {
                line2.removeView(view2);
            }
            line2.addView(this.foldButton);
        }
    }

    private final void fillChildInLines(int i10, int i11) {
        this.lines.clear();
        this.foldLineRemovedChip = null;
        int size = (View.MeasureSpec.getSize(i10) - getPaddingLeft()) - getPaddingRight();
        Line line = new Line(size, this.itemSpacing);
        this.lines.add(line);
        measureChild(this.expandButton, i10, i11);
        measureChild(this.foldButton, i10, i11);
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View view = getChildAt(i12);
            if (!(view instanceof ImageView)) {
                if (z10) {
                    kotlin.jvm.internal.i.e(view, "view");
                    updateAlphaAndVisibility(view, 0.0f);
                } else {
                    measureChild(view, i10, i11);
                    kotlin.jvm.internal.i.e(view, "view");
                    if (line.canAdd(view)) {
                        line.addView(view);
                    } else if (this.lines.size() >= getMaxRow()) {
                        updateAlphaAndVisibility(view, 0.0f);
                        z10 = true;
                    } else {
                        line = new Line(size, this.itemSpacing);
                        line.addView(view);
                        this.lines.add(line);
                    }
                }
            }
        }
    }

    private final COUIPressFeedbackImageView getBaseExpandButton() {
        Context context = getContext();
        kotlin.jvm.internal.i.e(context, "context");
        COUIPressFeedbackImageView cOUIPressFeedbackImageView = new COUIPressFeedbackImageView(context);
        cOUIPressFeedbackImageView.setScaleType(ImageView.ScaleType.CENTER);
        TypedArray obtainStyledAttributes = cOUIPressFeedbackImageView.getContext().obtainStyledAttributes(l.f6693A, m.f31528s1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(m.f31167L1, 0);
        cOUIPressFeedbackImageView.setLayoutParams(new ViewGroup.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        obtainStyledAttributes.recycle();
        COUIDarkModeUtil.setForceDarkAllow(cOUIPressFeedbackImageView, false);
        return cOUIPressFeedbackImageView;
    }

    private final COUIChip getChip() {
        View inflate = View.inflate(getContext(), Z8.f.f6178n, null);
        kotlin.jvm.internal.i.d(inflate, "null cannot be cast to non-null type com.coui.appcompat.chip.COUIChip");
        COUIChip cOUIChip = (COUIChip) inflate;
        COUIChangeTextUtil.adaptFontSize(cOUIChip, 4);
        cOUIChip.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.searchhistory.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUIFlowLayout.getChip$lambda$39$lambda$38(COUIFlowLayout.this, view);
            }
        });
        return cOUIChip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getChip$lambda$39$lambda$38(COUIFlowLayout this$0, View view) {
        OnItemClickListener onItemClickListener;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        IItem iItem = this$0.itemCache.get(Integer.valueOf(view.getId()));
        if (iItem != null && (onItemClickListener = this$0.onItemClickListener) != null) {
            onItemClickListener.onItemClick(iItem);
        }
    }

    private final int getContainerLayoutHeight() {
        if (this.isExpand) {
            return this.expandedStateHeight;
        }
        return this.foldedStateHeight;
    }

    private final COUIPressFeedbackImageView getExpandButton() {
        COUIPressFeedbackImageView baseExpandButton = getBaseExpandButton();
        baseExpandButton.setImageResource(Z8.d.f6059b);
        baseExpandButton.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.searchhistory.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUIFlowLayout.getExpandButton$lambda$18$lambda$17(COUIFlowLayout.this, view);
            }
        });
        return baseExpandButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExpandButton$lambda$18$lambda$17(COUIFlowLayout this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.doExpandAnimation();
        View.OnClickListener onClickListener = this$0.expandOnClickListener;
        if (onClickListener != null && onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    private final float getExpandButtonAlpha() {
        if (this.isExpand) {
            return 0.0f;
        }
        return 1.0f;
    }

    private final int getExpandedStateHeight() {
        return calculateLinesHeight(this.lines) + getPaddingTop() + getPaddingBottom();
    }

    private final COUIPressFeedbackImageView getFoldButton() {
        COUIPressFeedbackImageView baseExpandButton = getBaseExpandButton();
        baseExpandButton.setImageResource(Z8.d.f6060c);
        baseExpandButton.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.searchhistory.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUIFlowLayout.getFoldButton$lambda$20$lambda$19(COUIFlowLayout.this, view);
            }
        });
        return baseExpandButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFoldButton$lambda$20$lambda$19(COUIFlowLayout this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.doFoldAnimation();
        View.OnClickListener onClickListener = this$0.foldOnClickListener;
        if (onClickListener != null && onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    private final float getFoldButtonAlpha() {
        if (this.isExpand) {
            return 1.0f;
        }
        return 0.0f;
    }

    private final int getFoldedStateHeight() {
        List<Line> list = this.lines;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                o.o();
            }
            if (i10 < this.maxRowFolded) {
                arrayList.add(obj);
            }
            i10 = i11;
        }
        return calculateLinesHeight(arrayList) + getPaddingTop() + getPaddingBottom();
    }

    private final int getMaxRow() {
        if (this.isExpand) {
            return this.maxRowUnfolded;
        }
        return this.maxRowFolded;
    }

    private final boolean isAnimationRunning() {
        ConcurrentLinkedQueue<ValueAnimator> concurrentLinkedQueue = this.runningAnimators;
        if ((concurrentLinkedQueue instanceof Collection) && concurrentLinkedQueue.isEmpty()) {
            return false;
        }
        Iterator<T> it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            if (((ValueAnimator) it.next()).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private final boolean isNeedExpandButton(int i10) {
        int measuredWidth;
        int size = (View.MeasureSpec.getSize(i10) - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (!(childAt instanceof ImageView)) {
                if (i11 == 0) {
                    i12 = Math.min(childAt.getMeasuredWidth(), size);
                    i13++;
                } else {
                    if (childAt.getMeasuredWidth() + i12 + this.itemSpacing > size) {
                        i13++;
                        i11 = 0;
                        i12 = 0;
                    }
                    if (i11 == 0) {
                        measuredWidth = Math.min(childAt.getMeasuredWidth(), size);
                    } else {
                        measuredWidth = childAt.getMeasuredWidth() + this.itemSpacing;
                    }
                    i12 += measuredWidth;
                }
                i11++;
                if (i13 > this.maxRowFolded) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void setHiddenViewsAlpha(float f10) {
        updateAlphaAndVisibility(this.foldButton, f10);
        Iterator<T> it = getHiddenChips().iterator();
        while (it.hasNext()) {
            updateAlphaAndVisibility((View) it.next(), f10);
        }
        View view = this.foldLineRemovedChip;
        if (view != null) {
            updateAlphaAndVisibility(view, f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnItemClickListener$lambda$16$lambda$15(COUIFlowLayout this$0, View view, OnItemClickListener onItemClickListener, View view2) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(view, "$view");
        kotlin.jvm.internal.i.f(onItemClickListener, "$onItemClickListener");
        IItem iItem = this$0.itemCache.get(Integer.valueOf(((COUIChip) view).getId()));
        if (iItem != null) {
            onItemClickListener.onItemClick(iItem);
        }
    }

    private final void setVisibleViewsAlpha(float f10) {
        updateAlphaAndVisibility(this.expandButton, f10);
        Iterator<T> it = getVisibleChips().iterator();
        while (it.hasNext()) {
            updateAlphaAndVisibility((View) it.next(), 1.0f);
        }
    }

    private final void stopAnimationRunning() {
        ConcurrentLinkedQueue<ValueAnimator> concurrentLinkedQueue = this.runningAnimators;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        while (true) {
            ValueAnimator poll = this.runningAnimators.poll();
            if (poll == null) {
                return;
            } else {
                poll.cancel();
            }
        }
    }

    private final void updateAlphaAndVisibility(View view, float f10) {
        int i10 = 0;
        if (almostEquals(f10, 0)) {
            i10 = 4;
        }
        view.setVisibility(i10);
        view.setAlpha(f10);
    }

    private final void updateVisibleStateForChild() {
        updateAlphaAndVisibility(this.foldButton, getFoldButtonAlpha());
        updateAlphaAndVisibility(this.expandButton, getExpandButtonAlpha());
        Iterator<T> it = getVisibleChips().iterator();
        while (it.hasNext()) {
            updateAlphaAndVisibility((View) it.next(), 1.0f);
        }
        Iterator<T> it2 = getHiddenChips().iterator();
        while (it2.hasNext()) {
            updateAlphaAndVisibility((View) it2.next(), getFoldButtonAlpha());
        }
        View view = this.foldLineRemovedChip;
        if (view != null) {
            updateAlphaAndVisibility(view, getFoldButtonAlpha());
        }
    }

    public final void clearAll() {
        this.lines.clear();
        this.foldLineRemovedChip = null;
        removeAllViews();
        this.itemCache.clear();
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View child, long j10) {
        kotlin.jvm.internal.i.f(canvas, "canvas");
        kotlin.jvm.internal.i.f(child, "child");
        if (child.getTop() < getContainerLayoutHeight() && child.getHeight() != 0) {
            return super.drawChild(canvas, child, j10);
        }
        return false;
    }

    public final boolean getExpandable() {
        return this.expandable;
    }

    public final List<View> getHiddenChips() {
        List<Line> list = this.lines;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                o.o();
            }
            if (i10 >= this.maxRowFolded) {
                arrayList.add(obj);
            }
            i10 = i11;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            t.r(arrayList2, ((Line) it.next()).getViews());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (!(((View) obj2) instanceof ImageView)) {
                arrayList3.add(obj2);
            }
        }
        return arrayList3;
    }

    public final int getItemSpacing() {
        return this.itemSpacing;
    }

    public final int getLineSpacing() {
        return this.lineSpacing;
    }

    public final int getMaxRowFolded() {
        return this.maxRowFolded;
    }

    public final int getMaxRowUnfolded() {
        return this.maxRowUnfolded;
    }

    public final List<View> getVisibleChips() {
        List<Line> list = this.lines;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            t.r(arrayList, ((Line) it.next()).getViews());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            View view = (View) obj;
            if (!getHiddenChips().contains(view) && !(view instanceof ImageView)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public final boolean isExpand() {
        return this.isExpand;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        kotlin.sequences.e h10;
        int paddingTop = getPaddingTop();
        boolean z11 = true;
        if (getLayoutDirection() != 1) {
            z11 = false;
        }
        for (Line line : this.lines) {
            line.layout(getPaddingStart(), paddingTop, getContainerLayoutHeight(), z11);
            paddingTop += line.getHeight() + this.lineSpacing;
        }
        h10 = SequencesKt___SequencesKt.h(N.b(this), new v9.l<View, Boolean>() { // from class: com.coui.appcompat.searchhistory.COUIFlowLayout$onLayout$2
            {
                super(1);
            }

            @Override // v9.l
            public final Boolean invoke(View child) {
                List list;
                boolean z12;
                View view;
                kotlin.jvm.internal.i.f(child, "child");
                list = COUIFlowLayout.this.lines;
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    t.r(arrayList, ((COUIFlowLayout.Line) it.next()).getViews());
                }
                if (!arrayList.contains(child)) {
                    view = COUIFlowLayout.this.foldLineRemovedChip;
                    if (!kotlin.jvm.internal.i.b(child, view)) {
                        z12 = true;
                        return Boolean.valueOf(z12);
                    }
                }
                z12 = false;
                return Boolean.valueOf(z12);
            }
        });
        Iterator it = h10.iterator();
        while (it.hasNext()) {
            ((View) it.next()).layout(0, 0, 0, 0);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        if (this.itemCache.isEmpty()) {
            setMeasuredDimension(View.MeasureSpec.getSize(i10), View.MeasureSpec.makeMeasureSpec(0, mode));
            return;
        }
        fillChildInLines(i10, i11);
        this.expandedStateHeight = getExpandedStateHeight();
        this.foldedStateHeight = getFoldedStateHeight();
        if (isNeedExpandButton(i10) && this.expandable) {
            ensureAndExpandButton();
        }
        if (!isAnimationRunning()) {
            updateVisibleStateForChild();
        }
        setMeasuredDimension(i10, View.MeasureSpec.makeMeasureSpec(getContainerLayoutHeight(), mode));
    }

    public final void setExpand(boolean z10) {
        this.isExpand = z10;
        requestLayout();
    }

    public final void setExpandOnClickListener(View.OnClickListener clickListener) {
        kotlin.jvm.internal.i.f(clickListener, "clickListener");
        this.expandOnClickListener = clickListener;
    }

    public final void setExpandable(boolean z10) {
        this.expandable = z10;
    }

    public final void setFoldOnClickListener(View.OnClickListener clickListener) {
        kotlin.jvm.internal.i.f(clickListener, "clickListener");
        this.foldOnClickListener = clickListener;
    }

    public final void setItemSpacing(int i10) {
        this.itemSpacing = i10;
    }

    public final void setItems(List<? extends IItem> items) {
        int p10;
        kotlin.jvm.internal.i.f(items, "items");
        this.itemCache.clear();
        LinkedHashMap<Integer, IItem> linkedHashMap = this.itemCache;
        List<? extends IItem> list = items;
        p10 = p.p(list, 10);
        ArrayList arrayList = new ArrayList(p10);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m9.g.a(Integer.valueOf(View.generateViewId()), (IItem) it.next()));
        }
        E.h(linkedHashMap, arrayList);
        removeAllViews();
        this.expandButton = getExpandButton();
        this.foldButton = getFoldButton();
        for (Map.Entry<Integer, IItem> entry : this.itemCache.entrySet()) {
            COUIChip chip = getChip();
            chip.setId(entry.getKey().intValue());
            chip.setText(entry.getValue().getContent());
            addView(chip);
        }
        addView(this.expandButton);
        addView(this.foldButton);
    }

    public final void setLineSpacing(int i10) {
        this.lineSpacing = i10;
    }

    public final void setMaxRowFolded(int i10) {
        this.maxRowFolded = i10;
    }

    public final void setMaxRowUnfolded(int i10) {
        this.maxRowUnfolded = i10;
    }

    public final void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        kotlin.jvm.internal.i.f(onItemClickListener, "onItemClickListener");
        for (final View view : N.b(this)) {
            if ((view instanceof COUIChip) && view.getVisibility() == 0) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.searchhistory.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        COUIFlowLayout.setOnItemClickListener$lambda$16$lambda$15(COUIFlowLayout.this, view, onItemClickListener, view2);
                    }
                });
            }
        }
        this.onItemClickListener = onItemClickListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIFlowLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    public /* synthetic */ COUIFlowLayout(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIFlowLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.i.f(context, "context");
        this.itemCache = new LinkedHashMap<>();
        this.lines = new ArrayList();
        this.runningAnimators = new ConcurrentLinkedQueue<>();
        this.expandButton = getExpandButton();
        this.foldButton = getFoldButton();
        this.tempHiddenViewsAlphaFlg = -1.0f;
        this.tempVisibleViewsAlphaFlg = -1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Z8.i.f6199E, i10, i11);
        this.maxRowFolded = obtainStyledAttributes.getInteger(Z8.i.f6203I, Integer.MAX_VALUE);
        this.maxRowUnfolded = obtainStyledAttributes.getInteger(Z8.i.f6204J, Integer.MAX_VALUE);
        this.lineSpacing = obtainStyledAttributes.getDimensionPixelOffset(Z8.i.f6202H, 0);
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelOffset(Z8.i.f6201G, 0);
        this.expandable = obtainStyledAttributes.getBoolean(Z8.i.f6200F, true);
        obtainStyledAttributes.recycle();
        if (this.expandable) {
            return;
        }
        this.maxRowUnfolded = this.maxRowFolded;
    }
}
