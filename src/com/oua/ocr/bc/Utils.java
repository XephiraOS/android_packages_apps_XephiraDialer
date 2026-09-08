package com.oua.ocr.bc;

import com.oua.ocr.ContactInfo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
public class Utils {
    static Boolean deleted = Boolean.FALSE;

    public static void FileWriter(String str, String str2, Boolean bool) {
        File file = new File(str);
        try {
            File file2 = new File(file.getParent());
            file2.mkdirs();
            if (!file2.exists()) {
                return;
            }
            if (!deleted.booleanValue()) {
                file.delete();
                deleted = Boolean.TRUE;
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            if (!file.isFile()) {
                return;
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, bool.booleanValue()));
            bufferedWriter.write(str2);
            bufferedWriter.close();
        } catch (IOException e10) {
            LogUtil.println("Exception occurred:");
            e10.printStackTrace();
        }
    }

    public static int PointToBBox(int i10, int i11, int[][] iArr) {
        int i12 = 100000000;
        int i13 = 0;
        while (i13 < 4) {
            int[] iArr2 = iArr[i13];
            int i14 = iArr2[0];
            int i15 = iArr2[1];
            i13++;
            int[] iArr3 = iArr[i13 % 4];
            i12 = Math.min(i12, PointToSegDist(i10, i11, i14, i15, iArr3[0], iArr3[1]));
        }
        return i12;
    }

    public static int PointToSegDist(int i10, int i11, int i12, int i13, int i14, int i15) {
        int i16 = i14 - i12;
        int i17 = i15 - i13;
        int i18 = ((i10 - i12) * i16) + ((i11 - i13) * i17);
        if (i18 <= 0) {
            return distance(i10, i11, i12, i13);
        }
        int i19 = (i16 * i16) + (i17 * i17);
        if (i18 >= i19) {
            return distance(i10, i11, i14, i15);
        }
        int i20 = i18 / i19;
        return distance(i10, i11, i12 + (i16 * i20), i13 + (i17 * i20));
    }

    public static String assemble(String str, int i10) {
        String str2;
        if (ContactInfo.CJK.contains(Integer.valueOf(i10))) {
            str2 = "(" + str + ")";
        } else {
            str2 = "(?:\\b|^)(" + str + ")(?:\\b|$)";
        }
        return str2.replace(" ", "\\s*").replace("\\.", ".").replace(".", "\\.");
    }

    public static float bboxCenterDistance(int[][] iArr, int[][] iArr2) {
        int i10 = iArr[0][0];
        int[] iArr3 = iArr[2];
        float f10 = (i10 + iArr3[0]) * 0.5f;
        float f11 = (r1[1] + iArr3[1]) * 0.5f;
        int i11 = iArr2[0][0];
        int[] iArr4 = iArr2[2];
        return distance(f10, f11, (i11 + iArr4[0]) * 0.5f, (r1[1] + iArr4[1]) * 0.5f);
    }

    public static float bboxCenterDistance2(int[][] iArr, int[][] iArr2) {
        int[] iArr3 = iArr[0];
        int i10 = iArr3[0];
        int[] iArr4 = iArr[2];
        float f10 = (i10 + iArr4[0]) * 0.5f;
        int i11 = iArr3[1];
        int i12 = iArr4[1];
        int i13 = iArr2[0][0];
        int[] iArr5 = iArr2[2];
        float f11 = (i13 + iArr5[0]) * 0.5f;
        float f12 = iArr[1][1] - i12;
        float f13 = (f11 - f10) / f12;
        float f14 = (((r7[1] + iArr5[1]) * 0.5f) - ((i11 + i12) * 0.5f)) / f12;
        return ((f13 * f13) / 100.0f) + ((f14 * f14) / 289.0f);
    }

    public static int bboxDistance(int[][] iArr, int[][] iArr2) {
        if (isOverlapping(iArr, iArr2).booleanValue()) {
            return 0;
        }
        int i10 = 100000000;
        for (int i11 = 0; i11 < 4; i11++) {
            int[] iArr3 = iArr[i11];
            i10 = Math.min(i10, PointToBBox(iArr3[0], iArr3[1], iArr2));
        }
        for (int i12 = 0; i12 < 4; i12++) {
            int[] iArr4 = iArr2[i12];
            i10 = Math.min(i10, PointToBBox(iArr4[0], iArr4[1], iArr));
        }
        return i10;
    }

    public static Boolean containsField(String str, ArrayList<String[]> arrayList) {
        String str2 = str.split("\\.")[0];
        Iterator<String[]> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next()[0].indexOf(str2) == 0) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static int distance(int i10, int i11, int i12, int i13) {
        int i14 = i10 - i12;
        int i15 = i11 - i13;
        return (int) Math.sqrt((i14 * i14) + (i15 * i15));
    }

    public static String extend(String str, String str2) {
        if (str.length() == 0) {
            return str2;
        }
        if (str2.length() == 0) {
            return str;
        }
        return str + "|" + str2;
    }

    public static Boolean isCJK(HashSet<Integer> hashSet) {
        Iterator<Integer> it = hashSet.iterator();
        while (it.hasNext()) {
            if (ContactInfo.CJK.contains(it.next())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static Boolean isOverlapping(int[][] iArr, int[][] iArr2) {
        boolean z10 = false;
        int[] iArr3 = iArr[0];
        int i10 = iArr3[0];
        int[] iArr4 = iArr2[2];
        if (i10 < iArr4[0]) {
            int[] iArr5 = iArr2[0];
            int i11 = iArr5[0];
            int[] iArr6 = iArr[2];
            if (i11 < iArr6[0] && iArr3[1] < iArr4[1] && iArr5[1] < iArr6[1]) {
                z10 = true;
            }
        }
        return Boolean.valueOf(z10);
    }

    public static float normalized_edit_distance(String str, String str2) {
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str2.toLowerCase();
        int length = lowerCase2.length() + 1;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = i10;
        }
        for (int i11 = 1; i11 <= lowerCase.length(); i11++) {
            iArr[0] = i11;
            int i12 = i11 - 1;
            int i13 = 1;
            int i14 = i12;
            while (i13 <= lowerCase2.length()) {
                int i15 = i13 - 1;
                int min = Math.min(iArr[i13], iArr[i15]) + 1;
                if (lowerCase.charAt(i12) != lowerCase2.charAt(i15)) {
                    i14++;
                }
                int min2 = Math.min(min, i14);
                int i16 = iArr[i13];
                iArr[i13] = min2;
                i13++;
                i14 = i16;
            }
        }
        return 1.0f - (iArr[lowerCase2.length()] / Math.max(lowerCase.length(), lowerCase2.length()));
    }

    public static String unaccent(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static float distance(float f10, float f11, float f12, float f13) {
        float f14 = f10 - f12;
        float f15 = f11 - f13;
        return (float) Math.sqrt((f14 * f14) + (f15 * f15));
    }
}
