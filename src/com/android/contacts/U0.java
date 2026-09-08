package com.android.contacts;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.contacts.calllog.CallTypeIconsView;
import com.android.contacts.dialpad.HighLightNumber;
import com.android.contacts.dialpad.view.HighLightView;
import com.oplus.dialer.R;

/* compiled from: PhoneCallDetailsView.java */
/* loaded from: classes.dex */
public final class U0 {

    /* renamed from: a, reason: collision with root package name */
    public final HighLightView f13217a;

    /* renamed from: b, reason: collision with root package name */
    public final CallTypeIconsView f13218b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f13219c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f13220d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f13221e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f13222f;

    /* renamed from: g, reason: collision with root package name */
    public final HighLightNumber f13223g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f13224h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f13225i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f13226j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f13227k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f13228l;

    public U0(HighLightView highLightView, CallTypeIconsView callTypeIconsView, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, HighLightNumber highLightNumber, TextView textView2, TextView textView3, ImageView imageView4, ImageView imageView5, ImageView imageView6) {
        this.f13217a = highLightView;
        this.f13218b = callTypeIconsView;
        this.f13219c = imageView;
        this.f13220d = imageView2;
        this.f13221e = imageView3;
        this.f13222f = textView;
        this.f13223g = highLightNumber;
        this.f13224h = textView2;
        this.f13225i = textView3;
        this.f13226j = imageView4;
        this.f13227k = imageView5;
        this.f13228l = imageView6;
    }

    public static U0 a(View view) {
        return new U0((HighLightView) view.findViewById(R.id.name), (CallTypeIconsView) view.findViewById(R.id.call_type_icons), (ImageView) view.findViewById(R.id.slot_id), (ImageView) view.findViewById(R.id.hd), (ImageView) view.findViewById(R.id.breeno_icon), (TextView) view.findViewById(R.id.breeno_text), (HighLightNumber) view.findViewById(R.id.number), (TextView) view.findViewById(R.id.detail_home_or_lab), (TextView) view.findViewById(R.id.phone_flag), (ImageView) view.findViewById(R.id.volte_vowifi_call), (ImageView) view.findViewById(R.id.breeno_summary_icon), (ImageView) view.findViewById(R.id.call_recording));
    }
}
