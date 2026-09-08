package com.coui.appcompat.emptypage;

import X8.h;
import X8.j;
import X8.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coui.appcompat.button.COUIButton;
import com.coui.appcompat.emptypage.COUIEmptyStatusPage;
import com.oplus.anim.EffectiveAnimationView;
import kotlin.jvm.internal.i;

/* compiled from: COUIEmptyStatusPage.kt */
/* loaded from: classes.dex */
public final class COUIEmptyStatusPage extends LinearLayout {
    private COUIButton mButton;
    private Context mContext;
    private EffectiveAnimationView mImage;
    private TextView mMessage;
    private OnButtonClickListener mOnButtonClickListener;
    private TextView mSecondMessage;
    private int mStyle;

    /* compiled from: COUIEmptyStatusPage.kt */
    /* loaded from: classes.dex */
    public interface OnButtonClickListener {
        void onBottomButtonClick();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIEmptyStatusPage(Context context) {
        this(context, null);
        i.f(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(COUIEmptyStatusPage this$0, View view) {
        i.f(this$0, "this$0");
        OnButtonClickListener onButtonClickListener = this$0.mOnButtonClickListener;
        if (onButtonClickListener != null) {
            onButtonClickListener.onBottomButtonClick();
        }
    }

    public final void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(j.f4972c, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(h.f4899P);
        i.e(findViewById, "inflate.findViewById(R.id.image)");
        this.mImage = (EffectiveAnimationView) findViewById;
        View findViewById2 = inflate.findViewById(h.f4905V);
        i.e(findViewById2, "inflate.findViewById(R.id.message)");
        this.mMessage = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(h.f4951u0);
        i.e(findViewById3, "inflate.findViewById(R.id.second_message)");
        this.mSecondMessage = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(h.f4922g);
        i.e(findViewById4, "inflate.findViewById(R.id.btn)");
        COUIButton cOUIButton = (COUIButton) findViewById4;
        this.mButton = cOUIButton;
        if (cOUIButton == null) {
            i.q("mButton");
            cOUIButton = null;
        }
        cOUIButton.setOnClickListener(new View.OnClickListener() { // from class: x3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUIEmptyStatusPage.init$lambda$0(COUIEmptyStatusPage.this, view);
            }
        });
    }

    public final void playAnimation() {
        EffectiveAnimationView effectiveAnimationView = this.mImage;
        if (effectiveAnimationView == null) {
            i.q("mImage");
            effectiveAnimationView = null;
        }
        effectiveAnimationView.playAnimation();
    }

    public final void setAnimation(int i10) {
        EffectiveAnimationView effectiveAnimationView = this.mImage;
        if (effectiveAnimationView == null) {
            i.q("mImage");
            effectiveAnimationView = null;
        }
        effectiveAnimationView.setAnimation(i10);
    }

    public final void setButtonListener(OnButtonClickListener listener) {
        i.f(listener, "listener");
        this.mOnButtonClickListener = listener;
    }

    public final void setButtonText(String buttonText) {
        i.f(buttonText, "buttonText");
        COUIButton cOUIButton = this.mButton;
        if (cOUIButton == null) {
            i.q("mButton");
            cOUIButton = null;
        }
        cOUIButton.setText(buttonText);
    }

    public final void setButtonVisibility(int i10) {
        COUIButton cOUIButton = this.mButton;
        if (cOUIButton == null) {
            i.q("mButton");
            cOUIButton = null;
        }
        cOUIButton.setVisibility(i10);
    }

    public final void setImageBitmap(Bitmap bitmap) {
        i.f(bitmap, "bitmap");
        EffectiveAnimationView effectiveAnimationView = this.mImage;
        if (effectiveAnimationView == null) {
            i.q("mImage");
            effectiveAnimationView = null;
        }
        effectiveAnimationView.setImageBitmap(bitmap);
    }

    public final void setImageDrawable(Drawable drawable) {
        i.f(drawable, "drawable");
        EffectiveAnimationView effectiveAnimationView = this.mImage;
        if (effectiveAnimationView == null) {
            i.q("mImage");
            effectiveAnimationView = null;
        }
        effectiveAnimationView.setImageDrawable(drawable);
    }

    public final void setImageResoure(int i10) {
        EffectiveAnimationView effectiveAnimationView = this.mImage;
        if (effectiveAnimationView == null) {
            i.q("mImage");
            effectiveAnimationView = null;
        }
        effectiveAnimationView.setImageResource(i10);
    }

    public final void setMessage(String content) {
        i.f(content, "content");
        TextView textView = this.mMessage;
        if (textView == null) {
            i.q("mMessage");
            textView = null;
        }
        textView.setText(content);
    }

    public final void setSecondMessage(String secondMessage) {
        i.f(secondMessage, "secondMessage");
        TextView textView = this.mSecondMessage;
        if (textView == null) {
            i.q("mSecondMessage");
            textView = null;
        }
        textView.setText(secondMessage);
    }

    public final void setSecondMessageVisibility(int i10) {
        TextView textView = this.mSecondMessage;
        if (textView == null) {
            i.q("mSecondMessage");
            textView = null;
        }
        textView.setVisibility(i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIEmptyStatusPage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }

    public final void setAnimation(String assetName) {
        i.f(assetName, "assetName");
        EffectiveAnimationView effectiveAnimationView = this.mImage;
        if (effectiveAnimationView == null) {
            i.q("mImage");
            effectiveAnimationView = null;
        }
        effectiveAnimationView.setAnimation(assetName);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIEmptyStatusPage(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.mContext = context;
        this.mStyle = (attributeSet == null || attributeSet.getStyleAttribute() == 0) ? i10 : attributeSet.getStyleAttribute();
        init();
        Context context2 = this.mContext;
        i.c(context2);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, o.f5367n1, i10, 0);
        String string = obtainStyledAttributes.getString(o.f5391q1);
        String string2 = obtainStyledAttributes.getString(o.f5383p1);
        String string3 = obtainStyledAttributes.getString(o.f5375o1);
        COUIButton cOUIButton = null;
        if (string != null) {
            TextView textView = this.mMessage;
            if (textView == null) {
                i.q("mMessage");
                textView = null;
            }
            textView.setText(string);
        }
        if (string2 != null) {
            TextView textView2 = this.mSecondMessage;
            if (textView2 == null) {
                i.q("mSecondMessage");
                textView2 = null;
            }
            textView2.setText(string2);
        }
        if (string3 != null) {
            COUIButton cOUIButton2 = this.mButton;
            if (cOUIButton2 == null) {
                i.q("mButton");
            } else {
                cOUIButton = cOUIButton2;
            }
            cOUIButton.setText(string3);
        }
        obtainStyledAttributes.recycle();
    }
}
