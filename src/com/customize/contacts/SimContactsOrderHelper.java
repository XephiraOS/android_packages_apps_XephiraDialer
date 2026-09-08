package com.customize.contacts;

import U7.f;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.util.C0805p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class SimContactsOrderHelper {

    /* renamed from: b, reason: collision with root package name */
    public static CopyOnWriteArrayList<SimContactInfo> f20095b;

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f20094a = Pattern.compile(",");

    /* renamed from: c, reason: collision with root package name */
    public static Comparator<SimContactOrderInfo> f20096c = new a();

    /* loaded from: classes3.dex */
    public static class SimContactOrderInfo extends SimContactInfo {

        /* renamed from: i, reason: collision with root package name */
        public char f20097i;

        /* renamed from: j, reason: collision with root package name */
        public int f20098j;

        /* renamed from: k, reason: collision with root package name */
        public String f20099k;

        /* renamed from: l, reason: collision with root package name */
        public int f20100l;
    }

    /* loaded from: classes3.dex */
    public class a implements Comparator<SimContactOrderInfo> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(SimContactOrderInfo simContactOrderInfo, SimContactOrderInfo simContactOrderInfo2) {
            if (H7.a.b()) {
                H7.b.b("OppoSimContactsOrderHelper", "compare : arg0.mBucketPrimary = " + simContactOrderInfo.f20100l + ", arg1.mBucketPrimary = " + simContactOrderInfo2.f20100l);
            }
            int i10 = simContactOrderInfo.f20100l;
            int i11 = simContactOrderInfo2.f20100l;
            if (i10 != i11) {
                if (i10 <= i11) {
                    return -1;
                }
                return 1;
            }
            if (simContactOrderInfo.getName() == null) {
                return -1;
            }
            if (simContactOrderInfo2.getName() == null) {
                return 1;
            }
            int compareTo = simContactOrderInfo.getName().compareTo(simContactOrderInfo2.getName());
            if (H7.a.b()) {
                H7.b.b("OppoSimContactsOrderHelper", "result = " + compareTo);
            }
            return compareTo;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends CursorWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final Cursor f20101a;

        /* renamed from: b, reason: collision with root package name */
        public int f20102b;

        /* renamed from: c, reason: collision with root package name */
        public int[] f20103c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f20104d;

        /* renamed from: e, reason: collision with root package name */
        public List<SimContactOrderInfo> f20105e;

        public b(Cursor cursor, int[] iArr, List<SimContactOrderInfo> list) {
            super(cursor);
            this.f20102b = 0;
            this.f20104d = false;
            this.f20101a = cursor;
            this.f20103c = iArr;
            this.f20105e = list;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            char c10 = '@';
            String str = null;
            int i10 = 0;
            int i11 = 0;
            for (SimContactOrderInfo simContactOrderInfo : this.f20105e) {
                if (c10 == simContactOrderInfo.f20097i) {
                    i11++;
                    if (TextUtils.equals(str, simContactOrderInfo.f20099k)) {
                        i10++;
                    } else {
                        if (i10 > 0) {
                            arrayList.add(str);
                            arrayList2.add(Integer.valueOf(i10));
                        }
                        i10 = 1;
                    }
                } else {
                    if (i10 > 0) {
                        arrayList.add(str);
                        arrayList2.add(Integer.valueOf(i10));
                    }
                    if (i11 > 0) {
                        arrayList3.add(Character.valueOf(c10));
                        arrayList4.add(Integer.valueOf(i11));
                        String obj = arrayList.toString();
                        bundle.putStringArray(c10 + "titles", SimContactsOrderHelper.f20094a.split(f.f(obj.substring(1, obj.length() - 1))));
                        String obj2 = arrayList2.toString();
                        String[] split = SimContactsOrderHelper.f20094a.split(f.f(obj2.substring(1, obj2.length() - 1)));
                        int[] iArr = new int[split.length];
                        for (int i12 = 0; i12 < split.length; i12++) {
                            iArr[i12] = Integer.parseInt(split[i12]);
                        }
                        bundle.putIntArray(c10 + "counts", iArr);
                        arrayList.clear();
                        arrayList2.clear();
                    }
                    i10 = 1;
                    i11 = 1;
                }
                c10 = simContactOrderInfo.f20097i;
                str = simContactOrderInfo.f20099k;
            }
            if (i10 > 0) {
                arrayList.add(str);
                arrayList2.add(Integer.valueOf(i10));
            }
            if (i11 > 0) {
                arrayList3.add(Character.valueOf(c10));
                arrayList4.add(Integer.valueOf(i11));
                String obj3 = arrayList.toString();
                bundle.putStringArray(c10 + "titles", SimContactsOrderHelper.f20094a.split(f.f(obj3.substring(1, obj3.length() - 1))));
                String obj4 = arrayList2.toString();
                String[] split2 = SimContactsOrderHelper.f20094a.split(f.f(obj4.substring(1, obj4.length() - 1)));
                int[] iArr2 = new int[split2.length];
                for (int i13 = 0; i13 < split2.length; i13++) {
                    iArr2[i13] = Integer.parseInt(split2[i13]);
                }
                bundle.putIntArray(c10 + "counts", iArr2);
                arrayList.clear();
                arrayList2.clear();
            }
            String obj5 = arrayList3.toString();
            bundle.putStringArray("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES", SimContactsOrderHelper.f20094a.split(f.f(obj5.substring(1, obj5.length() - 1))));
            String obj6 = arrayList4.toString();
            String[] split3 = SimContactsOrderHelper.f20094a.split(f.f(obj6.substring(1, obj6.length() - 1)));
            int[] iArr3 = new int[split3.length];
            for (int i14 = 0; i14 < split3.length; i14++) {
                iArr3[i14] = Integer.parseInt(split3[i14]);
            }
            bundle.putIntArray("android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS", iArr3);
            return bundle;
        }

        public int c() {
            int[] iArr;
            int i10 = this.f20102b;
            if (-1 != i10 && (iArr = this.f20103c) != null && i10 < iArr.length) {
                return iArr[i10];
            }
            return i10;
        }

        @Override // android.database.CursorWrapper, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f20101a.close();
            List<SimContactOrderInfo> list = this.f20105e;
            if (list != null) {
                list.clear();
            }
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public int getPosition() {
            return this.f20102b;
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public boolean isClosed() {
            if (this.f20104d) {
                return true;
            }
            return super.isClosed();
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public boolean move(int i10) {
            int i11 = this.f20102b;
            this.f20102b = i10 + i11;
            try {
                boolean moveToPosition = this.f20101a.moveToPosition(c());
                if (!moveToPosition) {
                    this.f20102b = i11;
                }
                return moveToPosition;
            } catch (Exception e10) {
                H7.b.c("OppoSimContactsOrderHelper", "Exception e: " + e10);
                this.f20102b = i11;
                return false;
            }
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public boolean moveToFirst() {
            int i10 = this.f20102b;
            this.f20102b = 0;
            try {
                boolean moveToPosition = this.f20101a.moveToPosition(c());
                if (!moveToPosition) {
                    this.f20102b = i10;
                }
                return moveToPosition;
            } catch (Exception e10) {
                H7.b.c("OppoSimContactsOrderHelper", "Exception e: " + e10);
                this.f20102b = i10;
                return false;
            }
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public boolean moveToLast() {
            int i10 = this.f20102b;
            this.f20102b = getCount() - 1;
            try {
                boolean moveToPosition = this.f20101a.moveToPosition(c());
                if (!moveToPosition) {
                    this.f20102b = i10;
                }
                return moveToPosition;
            } catch (Exception e10) {
                H7.b.c("OppoSimContactsOrderHelper", "Exception e: " + e10);
                this.f20102b = i10;
                return false;
            }
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public boolean moveToNext() {
            int i10 = this.f20102b;
            this.f20102b = i10 + 1;
            try {
                boolean moveToPosition = this.f20101a.moveToPosition(c());
                if (!moveToPosition) {
                    this.f20102b = i10;
                }
                return moveToPosition;
            } catch (Exception e10) {
                H7.b.c("OppoSimContactsOrderHelper", "Exception e: " + e10);
                this.f20102b = i10;
                return false;
            }
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public boolean moveToPosition(int i10) {
            int i11 = this.f20102b;
            this.f20102b = i10;
            try {
                boolean moveToPosition = this.f20101a.moveToPosition(c());
                if (!moveToPosition && -1 != this.f20102b) {
                    this.f20102b = i11;
                }
                return moveToPosition;
            } catch (Exception e10) {
                H7.b.c("OppoSimContactsOrderHelper", "Exception e: " + e10);
                this.f20102b = i11;
                return false;
            }
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public boolean moveToPrevious() {
            int i10 = this.f20102b;
            this.f20102b = i10 - 1;
            try {
                boolean moveToPosition = this.f20101a.moveToPosition(c());
                if (!moveToPosition) {
                    this.f20102b = i10;
                }
                return moveToPosition;
            } catch (Exception e10) {
                H7.b.c("OppoSimContactsOrderHelper", "Exception e: " + e10);
                this.f20102b = i10;
                return false;
            }
        }
    }

    public static CopyOnWriteArrayList<SimContactInfo> b() {
        if (f20095b == null) {
            f20095b = new CopyOnWriteArrayList<>();
        }
        return f20095b;
    }

    public static Cursor c(Cursor cursor) {
        int i10;
        String str;
        int i11;
        if (cursor == null) {
            return cursor;
        }
        int columnIndex = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
        int columnIndex2 = cursor.getColumnIndex("name");
        int columnIndex3 = cursor.getColumnIndex("number");
        int columnIndex4 = cursor.getColumnIndex("additionalNumber");
        int columnIndex5 = cursor.getColumnIndex("emails");
        if (-1 != columnIndex && -1 != columnIndex2 && -1 != columnIndex3 && -1 != columnIndex4 && -1 != columnIndex5) {
            C0805p e10 = C0805p.e();
            ArrayList arrayList = new ArrayList();
            cursor.moveToPosition(-1);
            while (true) {
                i10 = 0;
                if (!cursor.moveToNext()) {
                    break;
                }
                SimContactOrderInfo simContactOrderInfo = new SimContactOrderInfo();
                simContactOrderInfo.f15821a = cursor.getLong(columnIndex);
                simContactOrderInfo.f15824d = cursor.getString(columnIndex2);
                simContactOrderInfo.f15825e = cursor.getString(columnIndex3);
                simContactOrderInfo.f15827g = cursor.getString(columnIndex4);
                simContactOrderInfo.f15828h = cursor.getString(columnIndex5);
                simContactOrderInfo.f20098j = cursor.getPosition();
                if (!TextUtils.isEmpty(simContactOrderInfo.f15824d)) {
                    i11 = e10.c(simContactOrderInfo.f15824d, false);
                    str = e10.d(i11);
                } else {
                    str = "";
                    i11 = 0;
                }
                if (TextUtils.isEmpty(str)) {
                    i11 = e10.c(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, false);
                    str = e10.d(i11);
                }
                char[] charArray = str.toCharArray();
                if (charArray != null && charArray.length > 0) {
                    simContactOrderInfo.f20097i = charArray[0];
                }
                if (H7.a.b()) {
                    H7.b.b("OppoSimContactsOrderHelper", "phonebookBucketPrimary = " + i11);
                }
                simContactOrderInfo.f20100l = i11;
                if (!TextUtils.isEmpty(simContactOrderInfo.f15824d)) {
                    simContactOrderInfo.f20099k = simContactOrderInfo.f15824d.substring(0, 1).toUpperCase();
                } else if (!TextUtils.isEmpty(simContactOrderInfo.f15825e)) {
                    simContactOrderInfo.f20099k = simContactOrderInfo.f15825e.substring(0, 1).toUpperCase();
                } else if (!TextUtils.isEmpty(simContactOrderInfo.f15827g)) {
                    simContactOrderInfo.f20099k = simContactOrderInfo.f15827g.substring(0, 1).toUpperCase();
                } else if (!TextUtils.isEmpty(simContactOrderInfo.f15828h)) {
                    simContactOrderInfo.f20099k = simContactOrderInfo.f15828h.substring(0, 1).toUpperCase();
                } else {
                    simContactOrderInfo.f20099k = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
                }
                arrayList.add(simContactOrderInfo);
            }
            Collections.sort(arrayList, f20096c);
            int[] iArr = new int[cursor.getCount()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                iArr[i10] = ((SimContactOrderInfo) it.next()).f20098j;
                i10++;
            }
            d(arrayList);
            return new b(cursor, iArr, arrayList);
        }
        return new b(cursor, null, null);
    }

    public static void d(ArrayList<SimContactOrderInfo> arrayList) {
        if (f20095b == null) {
            f20095b = new CopyOnWriteArrayList<>();
        }
        f20095b.clear();
        f20095b.addAll(arrayList);
    }
}
