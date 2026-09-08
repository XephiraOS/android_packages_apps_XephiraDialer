package com.coui.appcompat.privacypolicy;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import kotlin.jvm.internal.i;

/* compiled from: MultiFunctionSpan.kt */
/* loaded from: classes.dex */
public final class MultiMovementMethod extends LinkMovementMethod {
    private MultiFunctionSpan pressedSpan;

    private final MultiFunctionSpan getClickableSpan(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        boolean z10;
        int offsetForHorizontal = textView.getLayout().getOffsetForHorizontal(textView.getLayout().getLineForVertical((int) ((motionEvent.getY() - textView.getTotalPaddingTop()) + textView.getScrollY())), (int) ((motionEvent.getX() - textView.getTotalPaddingLeft()) + textView.getScrollX()));
        MultiFunctionSpan[] links = (MultiFunctionSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, MultiFunctionSpan.class);
        i.e(links, "links");
        if (links.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return links[0];
        }
        return null;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (textView != null && spannable != null && motionEvent != null) {
            int action = motionEvent.getAction();
            MultiFunctionSpan multiFunctionSpan = null;
            if (action != 0) {
                if (action != 2) {
                    MultiFunctionSpan multiFunctionSpan2 = this.pressedSpan;
                    if (multiFunctionSpan2 != null && multiFunctionSpan2 != null) {
                        multiFunctionSpan2.setPressed(false);
                    }
                    this.pressedSpan = null;
                } else {
                    MultiFunctionSpan clickableSpan = getClickableSpan(textView, spannable, motionEvent);
                    MultiFunctionSpan multiFunctionSpan3 = this.pressedSpan;
                    if (multiFunctionSpan3 != null && !i.b(multiFunctionSpan3, clickableSpan)) {
                        MultiFunctionSpan multiFunctionSpan4 = this.pressedSpan;
                        if (multiFunctionSpan4 != null) {
                            multiFunctionSpan4.setPressed(false);
                        }
                        this.pressedSpan = null;
                    }
                }
            } else {
                MultiFunctionSpan clickableSpan2 = getClickableSpan(textView, spannable, motionEvent);
                if (clickableSpan2 != null) {
                    clickableSpan2.setPressed(true);
                    multiFunctionSpan = clickableSpan2;
                }
                this.pressedSpan = multiFunctionSpan;
            }
            textView.invalidate();
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
