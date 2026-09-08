package com.coui.appcompat.tagview;

import X8.e;
import X8.f;
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
import android.widget.ImageView;
import android.widget.TextView;
import com.coui.appcompat.contextutil.COUIContextUtil;
import kotlin.jvm.internal.i;

/* compiled from: COUITagView.kt */
/* loaded from: classes3.dex */
public final class COUITagView extends COUITagBackgroundView {
    private ImageView imageView;
    private ImageView leftImageView;
    private Context mContext;
    private int style;
    private COUITagBackgroundView tagBackground;
    private TextView tagView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUITagView(Context context) {
        this(context, null);
        i.f(context, "context");
    }

    public final void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(j.f4987r, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(h.f4957x0);
        i.e(findViewById, "inflate.findViewById(R.id.tagBackground)");
        this.tagBackground = (COUITagBackgroundView) findViewById;
        View findViewById2 = inflate.findViewById(h.f4961z0);
        i.e(findViewById2, "inflate.findViewById(R.id.tagLeftImageView)");
        this.leftImageView = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(h.f4959y0);
        i.e(findViewById3, "inflate.findViewById(R.id.tagImageView)");
        this.imageView = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(h.f4875A0);
        i.e(findViewById4, "inflate.findViewById(R.id.tagTextView)");
        this.tagView = (TextView) findViewById4;
    }

    public final void setImageBitmap(Bitmap bitmap) {
        i.f(bitmap, "bitmap");
        ImageView imageView = this.imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            i.q("imageView");
            imageView = null;
        }
        imageView.setImageBitmap(bitmap);
        ImageView imageView3 = this.imageView;
        if (imageView3 == null) {
            i.q("imageView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setVisibility(0);
    }

    public final void setImageDrawable(Drawable drawable) {
        i.f(drawable, "drawable");
        ImageView imageView = this.imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            i.q("imageView");
            imageView = null;
        }
        imageView.setImageDrawable(drawable);
        ImageView imageView3 = this.imageView;
        if (imageView3 == null) {
            i.q("imageView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setVisibility(0);
    }

    public final void setImageResoure(int i10) {
        ImageView imageView = this.imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            i.q("imageView");
            imageView = null;
        }
        imageView.setImageResource(i10);
        ImageView imageView3 = this.imageView;
        if (imageView3 == null) {
            i.q("imageView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setVisibility(0);
    }

    public final void setLeftImageBitmap(Bitmap bitmap) {
        i.f(bitmap, "bitmap");
        ImageView imageView = this.leftImageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            i.q("leftImageView");
            imageView = null;
        }
        imageView.setImageBitmap(bitmap);
        ImageView imageView3 = this.leftImageView;
        if (imageView3 == null) {
            i.q("leftImageView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setVisibility(0);
    }

    public final void setLeftImageDrawable(Drawable drawable) {
        i.f(drawable, "drawable");
        ImageView imageView = this.leftImageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            i.q("leftImageView");
            imageView = null;
        }
        imageView.setImageDrawable(drawable);
        ImageView imageView3 = this.leftImageView;
        if (imageView3 == null) {
            i.q("leftImageView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setVisibility(0);
    }

    public final void setLeftImageResoure(int i10) {
        ImageView imageView = this.leftImageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            i.q("leftImageView");
            imageView = null;
        }
        imageView.setImageResource(i10);
        ImageView imageView3 = this.leftImageView;
        if (imageView3 == null) {
            i.q("leftImageView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setVisibility(0);
    }

    public final void setTagText(String tagText) {
        i.f(tagText, "tagText");
        TextView textView = this.tagView;
        TextView textView2 = null;
        if (textView == null) {
            i.q("tagView");
            textView = null;
        }
        textView.setText(tagText);
        TextView textView3 = this.tagView;
        if (textView3 == null) {
            i.q("tagView");
        } else {
            textView2 = textView3;
        }
        textView2.setVisibility(0);
    }

    public final void setTagTextColor(int i10) {
        TextView textView = this.tagView;
        if (textView == null) {
            i.q("tagView");
            textView = null;
        }
        textView.setTextColor(i10);
    }

    public final void setTagTextSize(int i10) {
        TextView textView = this.tagView;
        if (textView == null) {
            i.q("tagView");
            textView = null;
        }
        textView.setTextSize(0, i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUITagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUITagView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.mContext = context;
        this.style = (attributeSet == null || attributeSet.getStyleAttribute() == 0) ? i10 : attributeSet.getStyleAttribute();
        init();
        Context context2 = this.mContext;
        i.c(context2);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, o.f5181P5, i10, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(o.f5205S5);
        int color = obtainStyledAttributes.getColor(o.f5213T5, 0);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(o.f5189Q5);
        int color2 = obtainStyledAttributes.getColor(o.f5197R5, 0);
        String string = obtainStyledAttributes.getString(o.f5221U5);
        int color3 = obtainStyledAttributes.getColor(o.f5229V5, COUIContextUtil.getColor(this.mContext, e.f4446l));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(o.f5237W5, context.getResources().getDimensionPixelSize(f.f4709i1));
        TextView textView = null;
        if (drawable != null) {
            if (color != 0) {
                drawable.setTint(color);
            }
            ImageView imageView = this.leftImageView;
            if (imageView == null) {
                i.q("leftImageView");
                imageView = null;
            }
            imageView.setImageDrawable(drawable);
        } else {
            ImageView imageView2 = this.leftImageView;
            if (imageView2 == null) {
                i.q("leftImageView");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
        }
        if (drawable2 != null) {
            if (color2 != 0) {
                drawable2.setTint(color2);
            }
            ImageView imageView3 = this.imageView;
            if (imageView3 == null) {
                i.q("imageView");
                imageView3 = null;
            }
            imageView3.setImageDrawable(drawable2);
        } else {
            ImageView imageView4 = this.imageView;
            if (imageView4 == null) {
                i.q("imageView");
                imageView4 = null;
            }
            imageView4.setVisibility(8);
        }
        if (string != null) {
            TextView textView2 = this.tagView;
            if (textView2 == null) {
                i.q("tagView");
                textView2 = null;
            }
            textView2.setText(string);
        } else {
            TextView textView3 = this.tagView;
            if (textView3 == null) {
                i.q("tagView");
                textView3 = null;
            }
            textView3.setVisibility(8);
        }
        TextView textView4 = this.tagView;
        if (textView4 == null) {
            i.q("tagView");
            textView4 = null;
        }
        textView4.setTextColor(color3);
        TextView textView5 = this.tagView;
        if (textView5 == null) {
            i.q("tagView");
        } else {
            textView = textView5;
        }
        textView.setTextSize(0, dimensionPixelSize);
        obtainStyledAttributes.recycle();
    }
}
