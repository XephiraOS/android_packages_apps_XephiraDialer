package com.coui.appcompat.preference;

import X8.f;
import X8.g;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.core.view.K;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import b9.C0537g;
import b9.C0539i;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import e.h;

/* loaded from: classes.dex */
public abstract class COUIPreferenceWithAppbarFragment extends COUIPreferenceFragment {
    private int mDividerHeight;
    private RecyclerView mRecyclerView = null;
    private COUIToolbar mToolbar = null;

    private int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private View getStatusBarView() {
        ImageView imageView = new ImageView(getActivity());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, getStatusBarHeight(imageView.getContext())));
        return imageView;
    }

    public abstract String getTitle();

    public COUIToolbar getToolbar() {
        return this.mToolbar;
    }

    public boolean isCustomWindowBackground() {
        return false;
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g
    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) layoutInflater.inflate(C0539i.f12511m, viewGroup, false);
        cOUIRecyclerView.setEnablePointerDownAction(false);
        cOUIRecyclerView.setLayoutManager(onCreateLayoutManager());
        COUIDarkModeUtil.setForceDarkAllow(cOUIRecyclerView, false);
        return cOUIRecyclerView;
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        COUIToolbar cOUIToolbar = (COUIToolbar) view.findViewById(C0537g.f12465N);
        this.mToolbar = cOUIToolbar;
        if (cOUIToolbar == null) {
            return;
        }
        cOUIToolbar.setNavigationIcon(g.f4850c);
        this.mToolbar.setNavigationContentDescription(h.f30261a);
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FragmentActivity activity = COUIPreferenceWithAppbarFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        });
        this.mToolbar.setTitle(getTitle());
        this.mDividerHeight = getResources().getDimensionPixelSize(f.f4621W5);
        final AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(C0537g.f12473b);
        if (appBarLayout != null) {
            View statusBarView = getStatusBarView();
            appBarLayout.addView(statusBarView, 0, statusBarView.getLayoutParams());
            appBarLayout.setTouchscreenBlocksFocus(false);
        }
        RecyclerView listView = getListView();
        this.mRecyclerView = listView;
        if (listView != null) {
            K.y0(listView, true);
            this.mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    View findViewByPosition;
                    RecyclerView.o layoutManager = COUIPreferenceWithAppbarFragment.this.mRecyclerView.getLayoutManager();
                    if (layoutManager == null) {
                        findViewByPosition = null;
                    } else {
                        findViewByPosition = layoutManager.findViewByPosition(0);
                    }
                    if (findViewByPosition != null) {
                        int measuredHeight = appBarLayout.getMeasuredHeight() - COUIPreferenceWithAppbarFragment.this.mDividerHeight;
                        if (measuredHeight > 0) {
                            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) findViewByPosition.getLayoutParams();
                            ((ViewGroup.MarginLayoutParams) layoutParams).height = measuredHeight;
                            findViewByPosition.setLayoutParams(layoutParams);
                        }
                        COUIPreferenceWithAppbarFragment.this.mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
        if (getActivity() != null && !isCustomWindowBackground()) {
            getActivity().getWindow().setBackgroundDrawableResource(g.f4873z);
        }
    }
}
