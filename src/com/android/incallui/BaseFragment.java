package com.android.incallui;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import b2.InterfaceC0519a;
import com.android.incallui.Presenter;
import com.android.incallui.Ui;
import com.oapm.perftest.PerfTest;

/* loaded from: classes.dex */
public abstract class BaseFragment<T extends Presenter<U>, U extends Ui> extends Fragment implements Ui {
    private static final String KEY_FRAGMENT_HIDDEN = "key_fragment_hidden";
    protected boolean mDrawableInited = true;
    private T mPresenter = createPresenter();

    public abstract T createPresenter();

    public InterfaceC0519a getInCallFragmentManager() {
        if (getActivity() != null) {
            return ((InCallActivity) getActivity()).getInCallFragmentManager();
        }
        return null;
    }

    public T getPresenter() {
        return this.mPresenter;
    }

    public abstract U getUi();

    @Override // com.android.incallui.Ui
    public boolean getVisible() {
        View view = getView();
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mPresenter.onUiDestroy(getUi());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        PerfTest.leakWatch(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mPresenter.onUiReady(getUi());
    }

    public void releaseResources() {
    }
}
