package com.android.contacts.framework.baseui.util;

import android.graphics.drawable.Drawable;
import com.coui.appcompat.poplist.PopupListItem;
import java.util.ArrayList;

/* compiled from: PopupListItemBuilder.kt */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f15956a = new q();

    public static final PopupListItem a(String str) {
        return e(str, false, false, 0, null, null, 0, null, null, null, 0, 2046, null);
    }

    public static final PopupListItem b(String str, boolean z10, boolean z11) {
        return e(str, z10, z11, 0, null, null, 0, null, null, null, 0, 2040, null);
    }

    public static final PopupListItem c(String str, boolean z10, boolean z11, int i10, String str2) {
        return e(str, z10, z11, i10, str2, null, 0, null, null, null, 0, 2016, null);
    }

    public static final PopupListItem d(String str, boolean z10, boolean z11, int i10, String str2, Drawable drawable, int i11, ArrayList<PopupListItem> arrayList, String str3, Drawable drawable2, int i12) {
        PopupListItem.Builder builder = new PopupListItem.Builder();
        builder.reset();
        builder.setTitle(str);
        builder.setIsEnable(z10);
        builder.setIsChecked(z11);
        builder.setRedDotAmount(i10);
        builder.setDescription(str2);
        builder.setIcon(drawable);
        builder.setForceTint(i11);
        builder.setSubMenuItemList(arrayList);
        builder.setRedDotText(str3);
        builder.setStateIcon(drawable2);
        builder.setGroupId(i12);
        PopupListItem build = builder.build();
        kotlin.jvm.internal.i.e(build, "builder.build()");
        return build;
    }

    public static /* synthetic */ PopupListItem e(String str, boolean z10, boolean z11, int i10, String str2, Drawable drawable, int i11, ArrayList arrayList, String str3, Drawable drawable2, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = null;
        }
        if ((i13 & 2) != 0) {
            z10 = true;
        }
        if ((i13 & 4) != 0) {
            z11 = false;
        }
        if ((i13 & 8) != 0) {
            i10 = -1;
        }
        if ((i13 & 16) != 0) {
            str2 = null;
        }
        if ((i13 & 32) != 0) {
            drawable = null;
        }
        if ((i13 & 64) != 0) {
            i11 = 7;
        }
        if ((i13 & 128) != 0) {
            arrayList = null;
        }
        if ((i13 & 256) != 0) {
            str3 = null;
        }
        if ((i13 & 512) != 0) {
            drawable2 = null;
        }
        if ((i13 & 1024) != 0) {
            i12 = -1;
        }
        return d(str, z10, z11, i10, str2, drawable, i11, arrayList, str3, drawable2, i12);
    }
}
