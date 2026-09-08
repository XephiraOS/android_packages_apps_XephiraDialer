package com.customize.contacts.strengthenservice;

import H7.b;
import M7.a;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.oplus.foundation.util.feature.CommonFeatureOption;

/* loaded from: classes3.dex */
public class VisibilityProvider extends ContentProvider {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        boolean z10;
        Bundle bundle2 = new Bundle();
        b.e("VisibilityProvider", "method = " + str);
        if ("getVisibilityAttr".equals(str)) {
            boolean h10 = a.h(getContext().getApplicationContext(), "com.android.settings", "strengthenService", "true");
            if (h10 && CommonFeatureOption.j()) {
                z10 = 1;
            } else {
                z10 = 0;
            }
            b.e("VisibilityProvider", "isStrengthenVersion = " + h10 + ", isVisible = " + z10);
            bundle2.putInt("com.oplus.settings.item_visible", z10 ^ 1);
        }
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
