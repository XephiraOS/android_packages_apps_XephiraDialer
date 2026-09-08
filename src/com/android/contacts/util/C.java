package com.android.contacts.util;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.android.contacts.framework.baseui.widget.CheckableConstraintLayout;
import com.android.contacts.framework.baseui.widget.SelectItemLayout;
import com.android.contacts.list.ContactListItemView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.customize.contacts.widget.CheckedRelativeLayout;
import com.oplus.dialer.R;

/* compiled from: ViewUtils.kt */
/* loaded from: classes.dex */
public final class C {

    /* renamed from: a, reason: collision with root package name */
    public static final C f17527a = new C();

    public static final TextView a(Context context, ListView listView) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(listView, "listView");
        TextView textView = new TextView(context);
        textView.setHeight(context.getResources().getDimensionPixelSize(R.dimen.DP_30));
        textView.setImportantForAccessibility(2);
        listView.addFooterView(textView);
        return textView;
    }

    public static final void b(View view, boolean z10) {
        if (view instanceof SelectItemLayout) {
            ((SelectItemLayout) view).setChecked(z10);
            return;
        }
        if (view instanceof ContactListItemView) {
            ((ContactListItemView) view).setChecked(z10);
            return;
        }
        if (view instanceof CheckedRelativeLayout) {
            ((CheckedRelativeLayout) view).setChecked(z10);
        } else if (view instanceof COUICardListSelectedItemLayout) {
            ((COUICardListSelectedItemLayout) view).setIsSelected(z10);
        } else if (view instanceof CheckableConstraintLayout) {
            ((CheckableConstraintLayout) view).setChecked(z10);
        }
    }

    public static final void c(Context context, View view, int i10) {
        if (view != null && context != null) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.large_toolbar_height) + context.getResources().getDimensionPixelSize(R.dimen.list_padding_top) + context.getResources().getDimensionPixelSize(R.dimen.divider_background_height);
            view.setPaddingRelative(0, dimensionPixelSize, 0, i10);
            if (view instanceof ListView) {
                ((ListView) view).smoothScrollByOffset(-dimensionPixelSize);
            }
        }
    }
}
