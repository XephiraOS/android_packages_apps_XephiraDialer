package com.coui.appcompat.dialog;

import X8.f;
import X8.h;
import X8.n;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.oplus.anim.EffectiveAnimationView;

/* loaded from: classes.dex */
public class COUIRotatingDialogBuilder {
    private int mAnimationViewMaxSize;
    private boolean mBlurBackgroundWindow;
    private String mCancelButton;
    private DialogInterface.OnClickListener mCancelClickListener;
    private Context mContext;
    private String mDialogTitle;
    private DialogInterface.OnDismissListener mDismissListener;
    private String mFileName;
    private String mMessageText;
    private TextView mMessageView;
    private int mRawResource;
    private int mRepeatCount;
    private EffectiveAnimationView mRotatingAnimationView;
    private COUIAlertDialogBuilder mRotatingDialogBuilder;
    private DialogInterface.OnShowListener mShowListener;
    private int mStyle;

    public COUIRotatingDialogBuilder(Context context) {
        this(context, null);
    }

    private void addOnWindowAttachListener(androidx.appcompat.app.b bVar) {
        View decorView = bVar.getWindow().getDecorView();
        this.mRotatingAnimationView = (EffectiveAnimationView) decorView.findViewById(h.f4925h0);
        TextView textView = (TextView) decorView.findViewById(h.f4927i0);
        this.mMessageView = textView;
        String str = this.mMessageText;
        if (str != null) {
            textView.setText(str);
            COUIChangeTextUtil.adaptFontSize(this.mMessageView, 4);
        }
        EffectiveAnimationView effectiveAnimationView = this.mRotatingAnimationView;
        if (effectiveAnimationView != null) {
            int i10 = this.mRawResource;
            if (i10 != -1 && this.mFileName != null) {
                throw new IllegalArgumentException("mRawResource and mFileName cannot be used at the same time. Please use only one at once.");
            }
            if (i10 != -1) {
                effectiveAnimationView.setAnimation(i10);
                if (!hasButton()) {
                    setLayoutParamsMaxSize(this.mRotatingAnimationView);
                    return;
                }
                return;
            }
            String str2 = this.mFileName;
            if (str2 != null) {
                effectiveAnimationView.setAnimation(str2);
                if (!hasButton()) {
                    setLayoutParamsMaxSize(this.mRotatingAnimationView);
                }
            }
        }
    }

    private boolean hasButton() {
        if (this.mCancelButton != null) {
            return true;
        }
        return false;
    }

    public EffectiveAnimationView getAnimationView() {
        return this.mRotatingAnimationView;
    }

    public TextView getMessageView() {
        return this.mMessageView;
    }

    public COUIRotatingDialogBuilder setBlurBackgroundWindow(boolean z10) {
        this.mBlurBackgroundWindow = z10;
        return this;
    }

    public COUIRotatingDialogBuilder setCancelButton(int i10, DialogInterface.OnClickListener onClickListener) {
        setCancelButton(this.mContext.getString(i10), onClickListener);
        return this;
    }

    public COUIRotatingDialogBuilder setDialogTitle(int i10) {
        setDialogTitle(this.mContext.getString(i10));
        return this;
    }

    public COUIRotatingDialogBuilder setDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
        return this;
    }

    public COUIRotatingDialogBuilder setFileName(String str) {
        this.mFileName = str;
        return this;
    }

    public COUIRotatingDialogBuilder setLayoutParamsMaxSize(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i10 = this.mAnimationViewMaxSize;
        layoutParams.width = i10;
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
        return this;
    }

    @Deprecated
    public COUIRotatingDialogBuilder setLayoutParamsWrapContent(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        view.setLayoutParams(layoutParams);
        return this;
    }

    public COUIRotatingDialogBuilder setRawResource(int i10) {
        this.mRawResource = i10;
        return this;
    }

    public COUIRotatingDialogBuilder setRepeatCount(int i10) {
        this.mRepeatCount = i10;
        return this;
    }

    public COUIRotatingDialogBuilder setShowListener(DialogInterface.OnShowListener onShowListener) {
        this.mShowListener = onShowListener;
        return this;
    }

    public void setStyle(int i10) {
        this.mStyle = i10;
    }

    public androidx.appcompat.app.b show() {
        if (this.mRotatingDialogBuilder == null) {
            if (this.mStyle == 0) {
                if (this.mCancelButton == null) {
                    this.mStyle = n.f5035g;
                } else {
                    this.mStyle = n.f5036h;
                }
            }
            COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this.mContext, this.mStyle);
            this.mRotatingDialogBuilder = cOUIAlertDialogBuilder;
            String str = this.mCancelButton;
            if (str != null) {
                cOUIAlertDialogBuilder.setNegativeButton((CharSequence) str, this.mCancelClickListener);
            }
            String str2 = this.mDialogTitle;
            if (str2 != null) {
                this.mRotatingDialogBuilder.setTitle((CharSequence) str2);
            }
            this.mRotatingDialogBuilder.setBlurBackgroundDrawable(this.mBlurBackgroundWindow);
        }
        androidx.appcompat.app.b create = this.mRotatingDialogBuilder.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.coui.appcompat.dialog.COUIRotatingDialogBuilder.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                COUIRotatingDialogBuilder.this.mRotatingAnimationView.setRepeatCount(COUIRotatingDialogBuilder.this.mRepeatCount);
                COUIRotatingDialogBuilder.this.mRotatingAnimationView.playAnimation();
                if (COUIRotatingDialogBuilder.this.mShowListener != null) {
                    COUIRotatingDialogBuilder.this.mShowListener.onShow(dialogInterface);
                }
            }
        });
        create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.coui.appcompat.dialog.COUIRotatingDialogBuilder.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                COUIRotatingDialogBuilder.this.mRotatingAnimationView.pauseAnimation();
                if (COUIRotatingDialogBuilder.this.mDismissListener != null) {
                    COUIRotatingDialogBuilder.this.mDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        create.show();
        this.mRotatingDialogBuilder.updateViewAfterShown();
        addOnWindowAttachListener(create);
        return create;
    }

    public COUIRotatingDialogBuilder(Context context, String str) {
        this.mRepeatCount = -1;
        this.mRawResource = -1;
        this.mFileName = null;
        this.mStyle = 0;
        this.mBlurBackgroundWindow = false;
        this.mContext = context;
        this.mMessageText = str;
        this.mAnimationViewMaxSize = context.getResources().getDimensionPixelSize(f.f4550M4);
    }

    public COUIRotatingDialogBuilder setCancelButton(String str, DialogInterface.OnClickListener onClickListener) {
        this.mCancelButton = str;
        this.mCancelClickListener = onClickListener;
        return this;
    }

    public COUIRotatingDialogBuilder setDialogTitle(String str) {
        this.mDialogTitle = str;
        return this;
    }
}
