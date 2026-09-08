package com.coui.appcompat.searchview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.WindowInsets;
import androidx.appcompat.widget.SearchView;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class COUISearchView extends SearchView {
    private COUIHintAnimationLayout mCOUIHintAnimationLayout;
    private boolean mIsHintTextSize;
    private SearchView.SearchAutoComplete mSearchSrcTextView;

    public COUISearchView(Context context) {
        super(context);
        this.mIsHintTextSize = true;
    }

    private void changeTextSize(String str) {
        if (this.mSearchSrcTextView == null) {
            this.mSearchSrcTextView = getSearchAutoComplete();
        }
        if (str.isEmpty()) {
            this.mSearchSrcTextView.setTextSize(0, getContext().getResources().getDimensionPixelSize(X8.f.f4712i4));
            this.mIsHintTextSize = true;
        } else if (this.mIsHintTextSize) {
            this.mSearchSrcTextView.setTextSize(0, getContext().getResources().getDimensionPixelSize(X8.f.f4720j4));
            this.mIsHintTextSize = false;
        }
    }

    public COUIHintAnimationLayout getHintAnimationLayout() {
        return this.mCOUIHintAnimationLayout;
    }

    public SearchView.SearchAutoComplete getSearchAutoComplete() {
        SearchView.SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        if (searchAutoComplete == null) {
            try {
                Field declaredField = SearchView.class.getDeclaredField("mSearchSrcTextView");
                declaredField.setAccessible(true);
                SearchView.SearchAutoComplete searchAutoComplete2 = (SearchView.SearchAutoComplete) declaredField.get(this);
                this.mSearchSrcTextView = searchAutoComplete2;
                return searchAutoComplete2;
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }
        return searchAutoComplete;
    }

    /* loaded from: classes.dex */
    public static class COUISearchAutoComplete extends SearchView.SearchAutoComplete {
        private static final int VERSION_CODE_U = 34;
        private boolean mEnableNativeKeyPreIme;

        public COUISearchAutoComplete(Context context) {
            super(context);
            this.mEnableNativeKeyPreIme = false;
        }

        @Override // androidx.appcompat.widget.SearchView.SearchAutoComplete, android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
            WindowInsets rootWindowInsets;
            boolean onKeyPreIme = super.onKeyPreIme(i10, keyEvent);
            if (!this.mEnableNativeKeyPreIme && (rootWindowInsets = getRootView().getRootWindowInsets()) != null && !rootWindowInsets.isVisible(WindowInsets.Type.ime()) && i10 == 4) {
                return false;
            }
            return onKeyPreIme;
        }

        public void setEnableNativeKeyPreIme(boolean z10) {
            this.mEnableNativeKeyPreIme = z10;
        }

        public COUISearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mEnableNativeKeyPreIme = false;
        }

        public COUISearchAutoComplete(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.mEnableNativeKeyPreIme = false;
        }
    }

    public COUISearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsHintTextSize = true;
    }

    public COUISearchView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mIsHintTextSize = true;
        this.mCOUIHintAnimationLayout = (COUIHintAnimationLayout) findViewById(X8.h.f4941p0);
    }
}
