package com.coui.appcompat.privacypolicy;

import X8.c;
import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.coui.appcompat.theme.COUIThemeUtils;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: MultiFunctionSpan.kt */
/* loaded from: classes.dex */
public class MultiFunctionSpan extends ClickableSpan {
    public static final int ALPHA_PRESSED = 77;
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "MultiFunctionSpan";
    private final Context context;
    private boolean isPressed;

    /* compiled from: MultiFunctionSpan.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public MultiFunctionSpan(Context context) {
        i.f(context, "context");
        this.context = context;
    }

    public final boolean isPressed() {
        return this.isPressed;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View widget) {
        i.f(widget, "widget");
    }

    public final void setPressed(boolean z10) {
        this.isPressed = z10;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        i.f(textPaint, "textPaint");
        textPaint.setUnderlineText(false);
        int themeAttrColor = COUIThemeUtils.getThemeAttrColor(this.context, c.f4344C);
        if (this.isPressed) {
            themeAttrColor = B.a.w(themeAttrColor, 77);
        }
        textPaint.setColor(themeAttrColor);
    }
}
