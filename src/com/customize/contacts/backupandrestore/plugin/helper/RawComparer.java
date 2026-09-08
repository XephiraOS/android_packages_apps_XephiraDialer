package com.customize.contacts.backupandrestore.plugin.helper;

import H7.a;
import H7.b;
import android.text.TextUtils;
import com.android.contacts.framework.vcard.VCardEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class RawComparer {
    private static final int CONTAINED = 0;
    private static final int EMAILS_DIFFERENT = 4;
    private static final int EVENTS_DIFFERENT = 8;
    private static final int IMS_DIFFERENT = 7;
    private static final int LEN_4 = 4;
    private static final int LEN_5 = 5;
    private static final int NAME_DIFFERENT = 1;
    private static final int NICK_NAME_DIFFERENT = 2;
    private static final int NOTES_DIFFERENT = 10;
    private static final int ORGANIZATIONS_DIFFERENT = 6;
    private static final int PHONES_DIFFERENT = 3;
    private static final int POSTALS_DIFFERENT = 5;
    private static final int RELATIONS_DIFFERENT = 11;
    private static final String TAG = "RawComparer";
    private static final int WEBSITES_DIFFERENT = 9;

    public static boolean contains(List<? extends VCardEntry.g> list, List<? extends VCardEntry.g> list2) {
        int i10;
        int i11;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (list2 != null) {
            i11 = list2.size();
        } else {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return true;
        }
        if (i10 < i11) {
            return false;
        }
        if (i11 == 0) {
            return true;
        }
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (VCardEntry.g gVar : list) {
                String b10 = gVar.b();
                if (b10 != null) {
                    hashMap.put(b10, gVar);
                }
            }
        }
        Iterator<? extends VCardEntry.g> it = list2.iterator();
        while (it.hasNext()) {
            String b11 = it.next().b();
            if (b11 != null && !hashMap.containsKey(b11)) {
                return false;
            }
        }
        return true;
    }

    private static int getCompareResult(VCardEntry vCardEntry, VCardEntry vCardEntry2) {
        if (isTotallyDifferentStructuredName(vCardEntry.S(), vCardEntry2.S())) {
            return 1;
        }
        if (!contains(vCardEntry.W(), vCardEntry2.W())) {
            return 3;
        }
        if (!contains(vCardEntry.O(), vCardEntry2.O())) {
            return 4;
        }
        if (!contains(vCardEntry.Y(), vCardEntry2.Y())) {
            return 5;
        }
        if (!contains(vCardEntry.V(), vCardEntry2.V())) {
            return 6;
        }
        VCardEntry.c K10 = vCardEntry2.K();
        if (K10 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(K10);
            if (!contains(vCardEntry.L(), arrayList)) {
                return 8;
            }
        }
        if (!contains(vCardEntry.c0(), vCardEntry2.c0())) {
            return 9;
        }
        if (!contains(vCardEntry.U(), vCardEntry2.U())) {
            return 10;
        }
        return 0;
    }

    private static int getProtocol(String str, int i10) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e10) {
            b.c(TAG, "exception: " + e10);
            return i10;
        }
    }

    public static int getRawCompareResult(VCardEntry vCardEntry, VCardEntry vCardEntry2) {
        int compareResult = getCompareResult(vCardEntry, vCardEntry2);
        if (compareResult != 0) {
            return compareResult;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        parseFromAndroidCustomData(vCardEntry2, arrayList, arrayList2, arrayList3, arrayList4);
        if (!contains(vCardEntry.T(), arrayList2)) {
            return 2;
        }
        if (!contains(vCardEntry.Q(), arrayList3)) {
            return 7;
        }
        if (!contains(vCardEntry.L(), arrayList4)) {
            return 8;
        }
        if (!contains(vCardEntry.a0(), arrayList)) {
            return 11;
        }
        return 0;
    }

    public static boolean isSameRawEntity(VCardEntry vCardEntry, VCardEntry vCardEntry2) {
        boolean z10;
        int rawCompareResult = getRawCompareResult(vCardEntry, vCardEntry2);
        if (rawCompareResult == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        b.b(TAG, "isSameRawEntity: " + z10 + ", " + rawCompareResult);
        if (!z10 && a.b()) {
            b.b(TAG, "different:");
            b.b(TAG, "localEntity: " + vCardEntry);
            b.b(TAG, "vcardEntry: " + vCardEntry2);
        }
        return z10;
    }

    private static boolean isTotallyDifferentStructuredName(VCardEntry.m mVar, VCardEntry.m mVar2) {
        if (mVar == null) {
            if (mVar2 == null) {
                return false;
            }
            return true;
        }
        if (mVar2 == null) {
            return true;
        }
        if (TextUtils.equals(mVar.D(), mVar2.D()) && TextUtils.equals(mVar.B(), mVar2.B()) && TextUtils.equals(mVar.E(), mVar2.E()) && TextUtils.equals(mVar.F(), mVar2.F()) && TextUtils.equals(mVar.G(), mVar2.G())) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00f5 A[Catch: all -> 0x00ee, TryCatch #0 {all -> 0x00ee, blocks: (B:51:0x00dd, B:55:0x00e9, B:58:0x00f5, B:60:0x0101, B:61:0x0107), top: B:50:0x00dd }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseFromAndroidCustomData(com.android.contacts.framework.vcard.VCardEntry r18, java.util.List<com.android.contacts.framework.vcard.VCardEntry.t> r19, java.util.List<com.android.contacts.framework.vcard.VCardEntry.n> r20, java.util.List<com.android.contacts.framework.vcard.VCardEntry.j> r21, java.util.List<com.android.contacts.framework.vcard.VCardEntry.d> r22) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.backupandrestore.plugin.helper.RawComparer.parseFromAndroidCustomData(com.android.contacts.framework.vcard.VCardEntry, java.util.List, java.util.List, java.util.List, java.util.List):void");
    }
}
