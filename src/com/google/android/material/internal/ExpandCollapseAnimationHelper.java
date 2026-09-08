package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import f4.C1001b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ExpandCollapseAnimationHelper {
    private ValueAnimator.AnimatorUpdateListener additionalUpdateListener;
    private final View collapsedView;
    private int collapsedViewOffsetY;
    private long duration;
    private final View expandedView;
    private int expandedViewOffsetY;
    private final List<AnimatorListenerAdapter> listeners = new ArrayList();
    private final List<View> endAnchoredViews = new ArrayList();

    public ExpandCollapseAnimationHelper(View view, View view2) {
        this.collapsedView = view;
        this.expandedView = view2;
    }

    private void addListeners(Animator animator, List<AnimatorListenerAdapter> list) {
        Iterator<AnimatorListenerAdapter> it = list.iterator();
        while (it.hasNext()) {
            animator.addListener(it.next());
        }
    }

    private AnimatorSet getAnimatorSet(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(getExpandCollapseAnimator(z10), getExpandedViewChildrenAlphaAnimator(z10), getEndAnchoredViewsTranslateAnimator(z10));
        return animatorSet;
    }

    private Animator getEndAnchoredViewsTranslateAnimator(boolean z10) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat((this.expandedView.getLeft() - this.collapsedView.getLeft()) + (this.collapsedView.getRight() - this.expandedView.getRight()), 0.0f);
        ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(this.endAnchoredViews));
        ofFloat.setDuration(this.duration);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z10, C1001b.f31703b));
        return ofFloat;
    }

    private Animator getExpandCollapseAnimator(boolean z10) {
        Rect calculateRectFromBounds = ViewUtils.calculateRectFromBounds(this.collapsedView, this.collapsedViewOffsetY);
        Rect calculateRectFromBounds2 = ViewUtils.calculateRectFromBounds(this.expandedView, this.expandedViewOffsetY);
        final Rect rect = new Rect(calculateRectFromBounds);
        ValueAnimator ofObject = ValueAnimator.ofObject(new RectEvaluator(rect), calculateRectFromBounds, calculateRectFromBounds2);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ExpandCollapseAnimationHelper.this.lambda$getExpandCollapseAnimator$0(rect, valueAnimator);
            }
        });
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.additionalUpdateListener;
        if (animatorUpdateListener != null) {
            ofObject.addUpdateListener(animatorUpdateListener);
        }
        ofObject.setDuration(this.duration);
        ofObject.setInterpolator(ReversableAnimatedValueInterpolator.of(z10, C1001b.f31703b));
        return ofObject;
    }

    private Animator getExpandedViewChildrenAlphaAnimator(boolean z10) {
        List<View> children = ViewUtils.getChildren(this.expandedView);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(children));
        ofFloat.setDuration(this.duration);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z10, C1001b.f31702a));
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getExpandCollapseAnimator$0(Rect rect, ValueAnimator valueAnimator) {
        ViewUtils.setBoundsFromRect(this.expandedView, rect);
    }

    public ExpandCollapseAnimationHelper addEndAnchoredViews(View... viewArr) {
        Collections.addAll(this.endAnchoredViews, viewArr);
        return this;
    }

    public ExpandCollapseAnimationHelper addListener(AnimatorListenerAdapter animatorListenerAdapter) {
        this.listeners.add(animatorListenerAdapter);
        return this;
    }

    public Animator getCollapseAnimator() {
        AnimatorSet animatorSet = getAnimatorSet(false);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.internal.ExpandCollapseAnimationHelper.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ExpandCollapseAnimationHelper.this.expandedView.setVisibility(8);
            }
        });
        addListeners(animatorSet, this.listeners);
        return animatorSet;
    }

    public Animator getExpandAnimator() {
        AnimatorSet animatorSet = getAnimatorSet(true);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.internal.ExpandCollapseAnimationHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ExpandCollapseAnimationHelper.this.expandedView.setVisibility(0);
            }
        });
        addListeners(animatorSet, this.listeners);
        return animatorSet;
    }

    public ExpandCollapseAnimationHelper setAdditionalUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.additionalUpdateListener = animatorUpdateListener;
        return this;
    }

    public ExpandCollapseAnimationHelper setCollapsedViewOffsetY(int i10) {
        this.collapsedViewOffsetY = i10;
        return this;
    }

    public ExpandCollapseAnimationHelper setDuration(long j10) {
        this.duration = j10;
        return this;
    }

    public ExpandCollapseAnimationHelper setExpandedViewOffsetY(int i10) {
        this.expandedViewOffsetY = i10;
        return this;
    }

    public ExpandCollapseAnimationHelper addEndAnchoredViews(Collection<View> collection) {
        this.endAnchoredViews.addAll(collection);
        return this;
    }
}
