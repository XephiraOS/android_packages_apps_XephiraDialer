package com.coui.appcompat.card;

import android.R;
import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.l;
import b9.C0532b;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: COUICardButtonPreference.kt */
/* loaded from: classes.dex */
public final class COUICardButtonPreference extends COUIPressFeedbackJumpPreference {
    public static final float CARD_BUTTON_TEXT_SIZE_NORMAL = 12.0f;
    public static final float CARD_BUTTON_TEXT_SIZE_SMALL = 10.0f;
    public static final Companion Companion = new Companion(null);

    /* compiled from: COUICardButtonPreference.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUICardButtonPreference(Context context) {
        this(context, null, 0, 0, 14, null);
        i.f(context, "context");
    }

    private final int getAvailableWidth(TextView textView) {
        return (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
    }

    private final boolean isOverFlowed(TextView textView) {
        TextPaint paint = textView.getPaint();
        i.e(paint, "paint");
        if (paint.measureText(textView.getText().toString()) > getAvailableWidth(textView)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(COUICardButtonPreference this$0, TextView title) {
        i.f(this$0, "this$0");
        i.f(title, "$title");
        if (this$0.isOverFlowed(title)) {
            title.setTextSize(10.0f);
        } else {
            title.setTextSize(12.0f);
        }
    }

    @Override // com.coui.appcompat.card.COUIPressFeedbackJumpPreference, com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l holder) {
        i.f(holder, "holder");
        super.onBindViewHolder(holder);
        COUIDarkModeUtil.setForceDarkAllow(holder.itemView, false);
        View e10 = holder.e(R.id.title);
        i.d(e10, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView = (TextView) e10;
        textView.post(new Runnable() { // from class: com.coui.appcompat.card.b
            @Override // java.lang.Runnable
            public final void run() {
                COUICardButtonPreference.onBindViewHolder$lambda$0(COUICardButtonPreference.this, textView);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUICardButtonPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUICardButtonPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        i.f(context, "context");
    }

    public /* synthetic */ COUICardButtonPreference(Context context, AttributeSet attributeSet, int i10, int i11, int i12, f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? C0532b.f12347f : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUICardButtonPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        i.f(context, "context");
        setLayoutResource(Z8.f.f6165a);
    }
}
