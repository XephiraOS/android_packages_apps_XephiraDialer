package com.coui.appcompat.statement;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.coui.appcompat.contextutil.COUIContextUtil;

/* compiled from: COUIStatementClickableSpan.kt */
/* loaded from: classes.dex */
public class COUIStatementClickableSpan extends ClickableSpan {
    public static final int ALPHA_PRESSED = 77;
    public static final Companion Companion = new Companion(null);
    private boolean isPressed;
    private final int textColor;

    /* compiled from: COUIStatementClickableSpan.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public COUIStatementClickableSpan(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        this.textColor = COUIContextUtil.getAttrColor(context, X8.c.f4344C);
    }

    public final boolean isPressed() {
        return this.isPressed;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View widget) {
        kotlin.jvm.internal.i.f(widget, "widget");
        if (widget instanceof TextView) {
            ((TextView) widget).setHighlightColor(0);
        }
    }

    public final void setPressed(boolean z10) {
        this.isPressed = z10;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        kotlin.jvm.internal.i.f(ds, "ds");
        boolean z10 = this.isPressed;
        int i10 = this.textColor;
        if (z10) {
            i10 = B.a.w(i10, 77);
        }
        ds.setColor(i10);
    }
}
