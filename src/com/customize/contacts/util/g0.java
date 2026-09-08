package com.customize.contacts.util;

import com.customize.contacts.widget.TouchSearchView;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: SpellBarUtils.java */
/* loaded from: classes3.dex */
public class g0 {
    public static void a(TouchSearchView touchSearchView, String[] strArr, int[] iArr) {
        if (touchSearchView != null && !K.e()) {
            if (strArr != null && strArr.length != 0 && iArr != null && iArr.length != 0 && strArr.length == iArr.length) {
                if (H7.a.b()) {
                    H7.b.b("ContactsUtils", "setSmartShowMode, the sections is " + Arrays.toString(strArr) + ", the sectionCount is " + Arrays.toString(iArr));
                }
                if (strArr.length > 0) {
                    int length = strArr.length;
                    String[] strArr2 = new String[length];
                    int[] iArr2 = new int[length];
                    HashSet hashSet = new HashSet();
                    boolean z10 = true;
                    int i10 = 0;
                    for (int i11 = 0; i11 < strArr.length; i11++) {
                        String str = strArr[i11];
                        if (str != " " && !hashSet.contains(str)) {
                            strArr2[i10] = strArr[i11];
                            iArr2[i10] = iArr[i11];
                            hashSet.add(strArr[i11]);
                            i10++;
                        }
                        if (z10 && !R0.b.f3170d.matcher(strArr[i11]).matches()) {
                            z10 = false;
                        }
                    }
                    if (z10 && K.b()) {
                        strArr2 = TouchSearchView.getDefaultTouchKeys();
                        iArr2 = TouchSearchView.f22463O0;
                    } else if (i10 < length) {
                        if (i10 == 0) {
                            touchSearchView.L(null, null);
                            return;
                        }
                        String[] strArr3 = new String[i10];
                        int[] iArr3 = new int[i10];
                        for (int i12 = 0; i12 < i10; i12++) {
                            strArr3[i12] = strArr2[i12];
                            iArr3[i12] = iArr2[i12];
                        }
                        strArr2 = strArr3;
                        iArr2 = iArr3;
                    }
                    if (H7.a.b()) {
                        H7.b.b("ContactsUtils", "setSmartShowMode,AT LAST , the sections is " + Arrays.toString(strArr2) + ", the sectionCount is " + Arrays.toString(iArr2));
                    }
                    touchSearchView.L(strArr2, iArr2);
                    return;
                }
                return;
            }
            if (K.b()) {
                touchSearchView.L(TouchSearchView.getDefaultTouchKeys(), TouchSearchView.f22463O0);
            } else {
                touchSearchView.L(null, null);
            }
        }
    }
}
