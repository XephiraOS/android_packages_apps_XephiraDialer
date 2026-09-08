package com.android.contacts.group;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.oplus.dialer.R;

/* compiled from: GroupListItemWithHeaderView.java */
/* loaded from: classes.dex */
public final class k extends RelativeLayout implements AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public final View f16688a;

    public k(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.group_browse_list_item, (ViewGroup) this, true);
        this.f16688a = findViewById(R.id.group_list_header);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        if (this.f16688a.getVisibility() == 0) {
            rect.top += this.f16688a.getBottom();
        }
    }
}
