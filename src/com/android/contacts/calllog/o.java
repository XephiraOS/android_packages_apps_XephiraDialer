package com.android.contacts.calllog;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.contacts.U0;
import com.oplus.dialer.R;

/* compiled from: CallLogListItemView.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final View f14008a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f14009b;

    /* renamed from: c, reason: collision with root package name */
    public final U0 f14010c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f14011d;

    /* renamed from: e, reason: collision with root package name */
    public final CheckBox f14012e;

    /* renamed from: f, reason: collision with root package name */
    public final View f14013f;

    /* renamed from: g, reason: collision with root package name */
    public final View f14014g;

    public o(View view, View view2, ImageView imageView, CheckBox checkBox, U0 u02, TextView textView, View view3) {
        this.f14013f = view;
        this.f14008a = view2;
        this.f14009b = imageView;
        this.f14012e = checkBox;
        this.f14010c = u02;
        this.f14011d = textView;
        this.f14014g = view3;
    }

    public static o a(View view) {
        return new o(view.findViewById(R.id.callog_delete), view.findViewById(R.id.primary_action_view), (ImageView) view.findViewById(R.id.secondary_action_icon), (CheckBox) view.findViewById(R.id.check_box), U0.a(view), (TextView) view.findViewById(R.id.call_time), view.findViewById(R.id.bottom_divider));
    }
}
