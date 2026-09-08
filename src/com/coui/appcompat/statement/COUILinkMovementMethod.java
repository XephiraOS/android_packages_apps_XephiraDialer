package com.coui.appcompat.statement;

import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* compiled from: COUILinkMovementMethod.kt */
/* loaded from: classes.dex */
public final class COUILinkMovementMethod extends LinkMovementMethod {
    public static final COUILinkMovementMethod INSTANCE = new COUILinkMovementMethod();
    private static COUIStatementClickableSpan clickableSpan;

    private COUILinkMovementMethod() {
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        COUIStatementClickableSpan cOUIStatementClickableSpan;
        boolean z10;
        boolean z11;
        kotlin.jvm.internal.i.f(widget, "widget");
        kotlin.jvm.internal.i.f(buffer, "buffer");
        kotlin.jvm.internal.i.f(event, "event");
        if (event.getAction() == 0) {
            int x10 = (int) event.getX();
            int y10 = (int) event.getY();
            int totalPaddingLeft = x10 - widget.getTotalPaddingLeft();
            int offsetForHorizontal = widget.getLayout().getOffsetForHorizontal(widget.getLayout().getLineForVertical((y10 - widget.getTotalPaddingTop()) + widget.getScrollY()), totalPaddingLeft + widget.getScrollX());
            COUIStatementClickableSpan[] links = (COUIStatementClickableSpan[]) buffer.getSpans(offsetForHorizontal, offsetForHorizontal, COUIStatementClickableSpan.class);
            if (clickableSpan == null) {
                kotlin.jvm.internal.i.e(links, "links");
                if (links.length == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    COUIStatementClickableSpan cOUIStatementClickableSpan2 = links[0];
                    cOUIStatementClickableSpan2.setPressed(true);
                    widget.invalidate();
                    clickableSpan = cOUIStatementClickableSpan2;
                }
            }
        } else if ((event.getAction() == 1 || event.getAction() == 3 || event.getAction() == 4) && (cOUIStatementClickableSpan = clickableSpan) != null) {
            cOUIStatementClickableSpan.setPressed(false);
            clickableSpan = null;
            widget.invalidate();
        }
        if (event.getAction() == 1) {
            int x11 = (int) event.getX();
            int y11 = (int) event.getY();
            int totalPaddingLeft2 = x11 - widget.getTotalPaddingLeft();
            int totalPaddingTop = y11 - widget.getTotalPaddingTop();
            int scrollX = totalPaddingLeft2 + widget.getScrollX();
            int scrollY = totalPaddingTop + widget.getScrollY();
            int offsetForHorizontal2 = widget.getLayout().getOffsetForHorizontal(widget.getLayout().getLineForVertical(scrollY), scrollX);
            ClickableSpan[] links2 = (ClickableSpan[]) buffer.getSpans(offsetForHorizontal2, offsetForHorizontal2, ClickableSpan.class);
            kotlin.jvm.internal.i.e(links2, "links");
            if (links2.length == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                ClickableSpan clickableSpan2 = links2[0];
                int spanStart = buffer.getSpanStart(clickableSpan2);
                int spanEnd = buffer.getSpanEnd(clickableSpan2);
                if (offsetForHorizontal2 >= spanStart && offsetForHorizontal2 <= spanEnd && scrollY <= widget.getMeasuredHeight() && scrollY >= 0) {
                    clickableSpan2.onClick(widget);
                } else {
                    Selection.removeSelection(buffer);
                }
                return true;
            }
            Selection.removeSelection(buffer);
        }
        return super.onTouchEvent(widget, buffer, event);
    }
}
