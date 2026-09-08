package com.oplus.contacts.list;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import kotlin.jvm.internal.i;

/* compiled from: ContactsMainListItemDataBindingAdapter.kt */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f28021a = new g();

    public static final void a(TextView view, f fVar) {
        int i10;
        i.f(view, "view");
        if (fVar == null) {
            return;
        }
        if (fVar.t()) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        view.setVisibility(i10);
    }

    public static final void b(TextView view, Drawable drawable) {
        i.f(view, "view");
        if (!A7.a.a() && !COUIDarkModeUtil.isNightMode(view.getContext())) {
            view.setBackground(drawable);
        } else {
            view.setBackground(null);
        }
    }

    public static final void c(TextView view, f fVar) {
        i.f(view, "view");
        if (fVar == null) {
            return;
        }
        String g10 = fVar.g();
        if ((g10 == null || g10.length() == 0) && fVar.b() <= 0) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        view.setText(fVar.g());
        if (fVar.b() > 0) {
            view.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.b.e(view.getContext(), fVar.b()), (Drawable) null);
        } else {
            view.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
