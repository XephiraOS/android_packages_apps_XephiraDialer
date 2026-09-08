package r6;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.android.incallui.OplusNumberMarkUtils;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0849j;
import com.oplus.utils.C0855p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import v6.C1629c;

/* compiled from: CallPresenter.java */
/* loaded from: classes3.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f36495a = {BreenoCallContract.BaseColumns._ID, "number", OplusAutoRedialNotificationUI.TYPE};

    public static String f() {
        if (l7.b.o()) {
            return " and (type=20 OR type=21 OR type=22 OR type=28 OR type=29 OR type=30 OR type=23 OR type=24 OR type=25 OR type=26 OR type=27 OR type=56 OR type=49 OR type=50 OR type=51 OR type=52 OR type=53 OR type < 0)";
        }
        return " and (type=20 OR type=21 OR type=22 OR type=23 OR type=24 OR type=25 OR type=26 OR type=27 OR type=56 OR type=49 OR type=50 OR type=51 OR type=52 OR type=53 OR type < 0)";
    }

    public static /* synthetic */ void g(Context context, String str) {
        Intent intent = new Intent(str);
        intent.setPackage("com.android.server.telecom");
        context.sendBroadcast(intent);
    }

    public static void i(final Context context) {
        F6.a.h().forEach(new Consumer() { // from class: r6.u
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                v.g(context, (String) obj);
            }
        });
    }

    public static void j(Context context) {
        try {
            String L10 = F6.e.L();
            if (z6.b.c(context, 1, L10, 0) > 0) {
                Intent intent = new Intent(F6.a.g());
                intent.setPackage(C1629c.f37419e);
                context.sendBroadcast(intent);
                z6.b.i(context, 1, L10, 0);
            }
        } catch (Exception e10) {
            Log.e("CallPresenter", "sendBroadcastCancelInterceptCallsNotification error " + e10);
        }
    }

    public final boolean b(Context context, ArrayList<String> arrayList) {
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(C0855p.a.f29171a);
            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(next.trim())) {
                ContentValues contentValues = new ContentValues(4);
                contentValues.put("number", next);
                contentValues.put(OplusNumberMarkUtils.OplusBlacklist.BLOCK_TYPE, (Integer) 0);
                contentValues.put(OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE, "2");
                newInsert.withValues(contentValues);
                arrayList2.add(newInsert.build());
                if (C0846g.c()) {
                    Log.d("CallPresenter", "phoneNumber = " + C0846g.f(next));
                }
            }
        }
        try {
            if (context.getContentResolver().applyBatch(com.oplus.blacklist.database.a.f26232a, arrayList2) == null) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            Log.e("CallPresenter", "e = " + e10);
            return false;
        }
    }

    public void c(Context context, ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList.size() <= 500) {
                b(context, arrayList);
                C0849j.x(context.getApplicationContext(), arrayList, false, false, false, 0);
                return;
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i10 = 0;
            while (i10 < arrayList.size()) {
                int i11 = i10 + 500;
                arrayList2.addAll(arrayList.subList(i10, Math.min(arrayList.size(), i11)));
                b(context, arrayList2);
                i10 = i11;
            }
            C0849j.x(context.getApplicationContext(), arrayList, false, false, false, 0);
        }
    }

    public void d(Context context, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList.size() <= 500) {
                b(context, arrayList);
                C0849j.x(context.getApplicationContext(), arrayList, false, false, false, 0);
                return;
            }
            ArrayList<String> arrayList3 = new ArrayList<>();
            int i10 = 0;
            while (i10 < arrayList.size()) {
                int i11 = i10 + 500;
                arrayList3.addAll(arrayList.subList(i10, Math.min(arrayList.size(), i11)));
                b(context, arrayList3);
                i10 = i11;
            }
            C0849j.x(context.getApplicationContext(), arrayList, false, false, false, 0);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:12|13|(1:52)(3:19|(1:21)(1:51)|22)|23|(1:25)|26|(1:30)|31|(1:33)|(1:35)|36|(4:41|42|43|44)|45|46|47|48|42|43|44) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(android.content.Context r18, java.util.Set<java.lang.String> r19, int r20) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.v.e(android.content.Context, java.util.Set, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x015a, code lost:
    
        if (r3.moveToFirst() != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x015c, code lost:
    
        r1.clear();
        r4 = r3.getInt(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0167, code lost:
    
        if (r4 >= 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0169, code lost:
    
        r4 = java.lang.Math.abs(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0171, code lost:
    
        if (r6.w.b(r4) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0173, code lost:
    
        r1.put(com.android.incallui.OplusAutoRedialNotificationUI.TYPE, (java.lang.Integer) 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0190, code lost:
    
        r1.put("hasRecog", (java.lang.Integer) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x019f, code lost:
    
        if (r0.size() >= 500) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01a5, code lost:
    
        if (r3.isLast() == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01a8, code lost:
    
        r0.add(android.content.ContentProviderOperation.newUpdate(android.provider.CallLog.Calls.CONTENT_URI).withSelection(r2.toString(), new java.lang.String[]{r3.getString(0), r3.getString(1)}).withValues(r1).build());
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0201, code lost:
    
        if (r3.moveToNext() != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01ce, code lost:
    
        r4 = android.content.ContentProviderOperation.newUpdate(android.provider.CallLog.Calls.CONTENT_URI);
        r4.withSelection(r2.toString(), new java.lang.String[]{r3.getString(0), r3.getString(1)});
        r4.withValues(r1);
        r0.add(r4.build());
        r17.getContentResolver().applyBatch("call_log", r0);
        r0.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0181, code lost:
    
        r1.put(com.android.incallui.OplusAutoRedialNotificationUI.TYPE, java.lang.Integer.valueOf(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0189, code lost:
    
        r1.put(com.android.incallui.OplusAutoRedialNotificationUI.TYPE, (java.lang.Integer) 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0203, code lost:
    
        if (r3 != null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0205, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0220, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x021d, code lost:
    
        if (r3 == null) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean h(android.content.Context r17, java.util.Set<java.lang.String> r18, int r19) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.v.h(android.content.Context, java.util.Set, int):boolean");
    }
}
