package G7;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: DbUtils.java */
/* loaded from: classes3.dex */
public class a {
    public static ContentProviderResult[] a(Context context, String str, ArrayList<ContentProviderOperation> arrayList) {
        ContentProviderResult[] contentProviderResultArr = null;
        if (TextUtils.isEmpty(str) || arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            contentProviderResultArr = context.getContentResolver().applyBatch(str, arrayList);
            H7.b.b("DbUtils", "applyBatch operations size :" + arrayList.size() + ", take: [" + (System.currentTimeMillis() - currentTimeMillis) + "] ms.");
            Thread.sleep(50L);
            return contentProviderResultArr;
        } catch (Exception e10) {
            H7.b.c("DbUtils", "applyContentProviderOperation Exception : " + e10);
            return contentProviderResultArr;
        }
    }

    public static ContentProviderResult[] b(Context context, String str, ArrayList<ArrayList<ContentProviderOperation>> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList.size() == 1) {
                return a(context, str, arrayList.get(0));
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<ArrayList<ContentProviderOperation>> it = arrayList.iterator();
            while (it.hasNext()) {
                ContentProviderResult[] a10 = a(context, str, it.next());
                if (a10 != null && a10.length > 0) {
                    Collections.addAll(arrayList2, a10);
                }
            }
            int size = arrayList2.size();
            ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
            for (int i10 = 0; i10 < size; i10++) {
                contentProviderResultArr[i10] = (ContentProviderResult) arrayList2.get(i10);
            }
            return contentProviderResultArr;
        }
        return null;
    }

    public static ContentProviderResult[] c(Context context, String str, ArrayList<ContentProviderOperation> arrayList, int i10) {
        return b(context, str, f(arrayList, i10));
    }

    public static String d(List<Long> list) {
        if (list.isEmpty()) {
            return "(0)";
        }
        StringBuilder sb = new StringBuilder("(");
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().longValue());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }

    public static String e(List<String> list) {
        if (list.isEmpty()) {
            return "('0')";
        }
        StringBuilder sb = new StringBuilder("(");
        for (String str : list) {
            sb.append("'");
            sb.append(str);
            sb.append("'");
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }

    public static ArrayList<ArrayList<ContentProviderOperation>> f(ArrayList<ContentProviderOperation> arrayList, int i10) {
        boolean z10;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList.size() < i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            ArrayList<ArrayList<ContentProviderOperation>> arrayList2 = new ArrayList<>();
            if (z10) {
                arrayList2.add(arrayList);
            } else {
                ArrayList<ContentProviderOperation> arrayList3 = new ArrayList<>();
                arrayList2.add(arrayList3);
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ContentProviderOperation contentProviderOperation = arrayList.get(i11);
                    if (arrayList3.size() < i10) {
                        arrayList3.add(contentProviderOperation);
                    } else {
                        arrayList3 = new ArrayList<>();
                        arrayList2.add(arrayList3);
                        arrayList3.add(contentProviderOperation);
                    }
                }
            }
            return arrayList2;
        }
        return null;
    }
}
