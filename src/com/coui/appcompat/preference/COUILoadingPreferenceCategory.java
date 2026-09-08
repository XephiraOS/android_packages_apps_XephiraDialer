package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import b9.C0537g;
import b9.C0539i;
import b9.l;
import com.coui.appcompat.progressbar.COUICompProgressIndicator;

/* loaded from: classes.dex */
public class COUILoadingPreferenceCategory extends COUIPreferenceCategory {
    private static final String TAG = "LoadingCategory";
    private String mLoadingText;
    private TextView mLoadingTextView;
    private LoadingType mLoadingType;
    private COUICompProgressIndicator mLoadingView;
    private int mWidgetLayoutAfterLoading;
    private int mWidgetLayoutBeforeLoading;

    /* renamed from: com.coui.appcompat.preference.COUILoadingPreferenceCategory$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$coui$appcompat$preference$COUILoadingPreferenceCategory$LoadingType;

        static {
            int[] iArr = new int[LoadingType.values().length];
            $SwitchMap$com$coui$appcompat$preference$COUILoadingPreferenceCategory$LoadingType = iArr;
            try {
                iArr[LoadingType.BEFORE_LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$coui$appcompat$preference$COUILoadingPreferenceCategory$LoadingType[LoadingType.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$coui$appcompat$preference$COUILoadingPreferenceCategory$LoadingType[LoadingType.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$coui$appcompat$preference$COUILoadingPreferenceCategory$LoadingType[LoadingType.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$coui$appcompat$preference$COUILoadingPreferenceCategory$LoadingType[LoadingType.AFTER_LOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum LoadingType {
        LOADING,
        PAUSE,
        INVISIBLE,
        AFTER_LOADING,
        BEFORE_LOADING
    }

    public COUILoadingPreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLoadingType = LoadingType.LOADING;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f12578Q, 0, 0);
        this.mWidgetLayoutAfterLoading = obtainStyledAttributes.getResourceId(l.f12580R, 0);
        this.mWidgetLayoutBeforeLoading = obtainStyledAttributes.getResourceId(l.f12582S, 0);
        this.mLoadingText = obtainStyledAttributes.getString(l.f12584T);
        obtainStyledAttributes.recycle();
        if (this.mWidgetLayoutBeforeLoading != 0) {
            this.mLoadingType = LoadingType.BEFORE_LOADING;
        }
    }

    public LoadingType getLoadingType() {
        return this.mLoadingType;
    }

    public void hideLoading() {
        LoadingType loadingType = this.mLoadingType;
        if (loadingType == LoadingType.AFTER_LOADING) {
            Log.e(TAG, "It is no longer loading state");
            return;
        }
        LoadingType loadingType2 = LoadingType.INVISIBLE;
        if (loadingType != loadingType2) {
            this.mLoadingType = loadingType2;
            notifyChanged();
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceCategory, androidx.preference.PreferenceCategory, androidx.preference.Preference
    public void onBindViewHolder(androidx.preference.l lVar) {
        int i10 = AnonymousClass1.$SwitchMap$com$coui$appcompat$preference$COUILoadingPreferenceCategory$LoadingType[this.mLoadingType.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 == 5) {
                            setWidgetLayoutRes(this.mWidgetLayoutAfterLoading);
                            super.onBindViewHolder(lVar);
                            return;
                        }
                        return;
                    }
                    COUICompProgressIndicator cOUICompProgressIndicator = this.mLoadingView;
                    if (cOUICompProgressIndicator != null) {
                        cOUICompProgressIndicator.setVisibility(8);
                        return;
                    }
                    return;
                }
                COUICompProgressIndicator cOUICompProgressIndicator2 = this.mLoadingView;
                if (cOUICompProgressIndicator2 != null) {
                    cOUICompProgressIndicator2.setVisibility(0);
                    this.mLoadingView.getAnimationView().pauseAnimation();
                    return;
                }
                return;
            }
            setWidgetLayoutRes(C0539i.f12505g);
            super.onBindViewHolder(lVar);
            this.mLoadingView = (COUICompProgressIndicator) getWidgetLayout().findViewById(C0537g.f12477f);
            this.mLoadingTextView = (TextView) getWidgetLayout().findViewById(C0537g.f12464M);
            this.mLoadingView.setVisibility(0);
            if (this.mLoadingView.getAnimationView() != null) {
                this.mLoadingView.getAnimationView().playAnimation();
            }
            if (!TextUtils.isEmpty(this.mLoadingText)) {
                this.mLoadingTextView.setText(this.mLoadingText);
                this.mLoadingTextView.setVisibility(0);
                return;
            } else {
                this.mLoadingTextView.setVisibility(8);
                return;
            }
        }
        setWidgetLayoutRes(this.mWidgetLayoutBeforeLoading);
        super.onBindViewHolder(lVar);
    }

    public void pauseLoading() {
        LoadingType loadingType = this.mLoadingType;
        if (loadingType == LoadingType.AFTER_LOADING) {
            Log.e(TAG, "It is no longer loading state");
            return;
        }
        LoadingType loadingType2 = LoadingType.PAUSE;
        if (loadingType != loadingType2) {
            this.mLoadingType = loadingType2;
            notifyChanged();
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceCategory
    public boolean rightTextfixSecondaryColor() {
        return true;
    }

    public void setLoadingText(String str) {
        if (!TextUtils.equals(this.mLoadingText, str)) {
            this.mLoadingText = str;
            notifyChanged();
        }
    }

    public void setShowAfterView() {
        setShowAfterView(this.mWidgetLayoutAfterLoading);
    }

    public void startLoading() {
        LoadingType loadingType = this.mLoadingType;
        LoadingType loadingType2 = LoadingType.LOADING;
        if (loadingType != loadingType2) {
            this.mLoadingType = loadingType2;
            notifyChanged();
        }
    }

    public void setShowAfterView(int i10) {
        this.mWidgetLayoutAfterLoading = i10;
        this.mLoadingType = LoadingType.AFTER_LOADING;
        notifyChanged();
    }
}
