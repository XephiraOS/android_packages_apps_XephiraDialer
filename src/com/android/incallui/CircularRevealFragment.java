package com.android.incallui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Outline;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import com.android.incallui.util.MaterialColorMapUtils$MaterialPalette;
import com.oapm.perftest.PerfTest;

/* loaded from: classes.dex */
public class CircularRevealFragment extends Fragment {
    static final String TAG = "CircularRevealFragment";
    private boolean mAnimationStarted;
    private OnCircularRevealCompleteListener mListener;
    private Point mTouchPoint;

    /* loaded from: classes.dex */
    public interface OnCircularRevealCompleteListener {
        void onCircularRevealComplete(FragmentManager fragmentManager);
    }

    public CircularRevealFragment() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator getRevealAnimator(Point point) {
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        View decorView = activity.getWindow().getDecorView();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point2 = new Point();
        defaultDisplay.getSize(point2);
        int i10 = point2.x / 2;
        int i11 = point2.y / 2;
        if (point != null) {
            i10 = point.x;
            i11 = point.y;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(decorView, i10, i11, 0.0f, Math.max(r0, r2));
        createCircularReveal.setDuration(getResources().getInteger(R.integer.reveal_animation_duration));
        return createCircularReveal;
    }

    @Deprecated
    public static void startCircularReveal(FragmentManager fragmentManager, Point point, OnCircularRevealCompleteListener onCircularRevealCompleteListener) {
        if (fragmentManager.findFragmentByTag(TAG) == null) {
            fragmentManager.beginTransaction().add(R.id.fl_screen_background, new CircularRevealFragment(point, onCircularRevealCompleteListener), TAG).commitAllowingStateLoss();
        } else {
            Log.w(TAG, "An instance of CircularRevealFragment already exists");
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.outgoing_call_animation, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        PerfTest.leakWatch(this);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.mAnimationStarted) {
            startOutgoingAnimation(InCallPresenter.getInstance().getThemeColors());
        }
        this.mAnimationStarted = true;
    }

    public void startOutgoingAnimation(MaterialColorMapUtils$MaterialPalette materialColorMapUtils$MaterialPalette) {
        Activity activity = getActivity();
        if (activity == null) {
            Log.w(this, "Asked to do outgoing call animation when not attached");
            return;
        }
        final View decorView = activity.getWindow().getDecorView();
        decorView.setOutlineProvider(new ViewOutlineProvider() { // from class: com.android.incallui.CircularRevealFragment.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setOval(-1, -1, 0, 0);
            }
        });
        decorView.setClipToOutline(true);
        if (materialColorMapUtils$MaterialPalette != null) {
            decorView.findViewById(R.id.outgoing_call_animation_circle).setBackgroundColor(materialColorMapUtils$MaterialPalette.f19174a);
            activity.getWindow().setStatusBarColor(materialColorMapUtils$MaterialPalette.f19175b);
        }
        decorView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.android.incallui.CircularRevealFragment.2
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                }
                CircularRevealFragment circularRevealFragment = CircularRevealFragment.this;
                Animator revealAnimator = circularRevealFragment.getRevealAnimator(circularRevealFragment.mTouchPoint);
                if (revealAnimator == null) {
                    return false;
                }
                revealAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.android.incallui.CircularRevealFragment.2.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        decorView.setClipToOutline(false);
                        if (CircularRevealFragment.this.mListener != null) {
                            CircularRevealFragment.this.mListener.onCircularRevealComplete(CircularRevealFragment.this.getFragmentManager());
                        }
                    }
                });
                revealAnimator.start();
                return false;
            }
        });
    }

    public CircularRevealFragment(Point point, OnCircularRevealCompleteListener onCircularRevealCompleteListener) {
        this.mTouchPoint = point;
        this.mListener = onCircularRevealCompleteListener;
    }
}
