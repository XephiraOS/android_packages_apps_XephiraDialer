package com.coui.appcompat.lockview;

import android.content.Context;
import android.util.Log;
import com.coui.appcompat.lockview.COUILockPatternView;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUILockPatternUtils {
    private static final int COLUMNS = 3;
    private static final boolean DEBUG = false;
    private static final int ROWS = 3;
    private static final String TAG = "COUILockPatternUtils";
    private static final String UTF_8 = "UTF-8";
    private final Context mContext;

    public COUILockPatternUtils(Context context) {
        this.mContext = context;
    }

    public static String patternToString(List<COUILockPatternView.Cell> list) {
        if (list == null) {
            return "";
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i10 = 0; i10 < size; i10++) {
            COUILockPatternView.Cell cell = list.get(i10);
            bArr[i10] = (byte) ((cell.getRow() * 3) + cell.getColumn() + 49);
        }
        try {
            return new String(bArr, UTF_8);
        } catch (UnsupportedEncodingException e10) {
            Log.e(TAG, "patternToString e:" + e10.getMessage());
            e10.printStackTrace();
            return null;
        }
    }

    public static List<COUILockPatternView.Cell> stringToPattern(String str) {
        byte[] bArr = null;
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            bArr = str.getBytes(UTF_8);
        } catch (UnsupportedEncodingException e10) {
            Log.e(TAG, "stringToPattern e:" + e10.getMessage());
            e10.printStackTrace();
        }
        for (byte b10 : bArr) {
            byte b11 = (byte) (b10 - 49);
            arrayList.add(COUILockPatternView.Cell.of(b11 / 3, b11 % 3));
        }
        return arrayList;
    }
}
