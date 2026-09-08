package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.C0448c;

/* compiled from: TextViewOnReceiveContentListener.java */
/* loaded from: classes.dex */
public final class l {
    public static CharSequence a(Context context, ClipData.Item item, int i10) {
        if ((i10 & 1) != 0) {
            CharSequence coerceToText = item.coerceToText(context);
            if (coerceToText instanceof Spanned) {
                return coerceToText.toString();
            }
            return coerceToText;
        }
        return item.coerceToStyledText(context);
    }

    public static void c(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    public C0448c b(View view, C0448c c0448c) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + c0448c);
        }
        if (c0448c.c() == 2) {
            return c0448c;
        }
        ClipData a10 = c0448c.a();
        int b10 = c0448c.b();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z10 = false;
        for (int i10 = 0; i10 < a10.getItemCount(); i10++) {
            CharSequence a11 = a(context, a10.getItemAt(i10), b10);
            if (a11 != null) {
                if (!z10) {
                    c(editable, a11);
                    z10 = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), a11);
                }
            }
        }
        return null;
    }
}
