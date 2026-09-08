package com.oplus.blacklistapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.BlockedNumberContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.TextView;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusNumberMarkUtils;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.oplus.blacklistapp.activities.CustomBlackListActivity;
import com.oplus.utils.AnimationAnimationListenerC0842c;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0845f;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0849j;
import com.oplus.utils.C0855p;
import h9.C1087a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import q6.AbstractRunnableC1488a;

/* compiled from: BlackAndWhiteListAdapter.java */
/* loaded from: classes3.dex */
public class d extends AbstractRunnableC1488a {

    /* renamed from: A, reason: collision with root package name */
    public int f27027A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f27028B;

    /* renamed from: C, reason: collision with root package name */
    public final S8.o f27029C;

    /* renamed from: a, reason: collision with root package name */
    public boolean f27030a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f27031b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f27032c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, f> f27033d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedList<h> f27034e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, C0845f> f27035f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap<C0845f, Boolean> f27036g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f27037h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f27038i;

    /* renamed from: j, reason: collision with root package name */
    public Thread f27039j;

    /* renamed from: k, reason: collision with root package name */
    public Context f27040k;

    /* renamed from: l, reason: collision with root package name */
    public Uri f27041l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f27042m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f27043n;

    /* renamed from: o, reason: collision with root package name */
    public C1087a f27044o;

    /* renamed from: p, reason: collision with root package name */
    public int f27045p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f27046q;

    /* renamed from: r, reason: collision with root package name */
    public int f27047r;

    /* renamed from: x, reason: collision with root package name */
    public Handler f27048x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f27049y;

    /* renamed from: z, reason: collision with root package name */
    public ConcurrentHashMap<Long, C0845f> f27050z;

    /* compiled from: BlackAndWhiteListAdapter.java */
    /* loaded from: classes3.dex */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* compiled from: BlackAndWhiteListAdapter.java */
    /* renamed from: com.oplus.blacklistapp.d$d, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0243d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<d> f27057a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar = this.f27057a.get();
            if (dVar == null) {
                return;
            }
            int i10 = message.what;
            if (i10 == 1) {
                dVar.x("handleMessage REDRAW");
                dVar.notifyDataSetChanged();
            } else if (i10 == 2) {
                dVar.B();
            }
        }

        public HandlerC0243d(d dVar) {
            this.f27057a = new WeakReference<>(dVar);
        }
    }

    /* compiled from: BlackAndWhiteListAdapter.java */
    /* loaded from: classes3.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public String f27058a;

        /* renamed from: b, reason: collision with root package name */
        public String f27059b;

        /* renamed from: c, reason: collision with root package name */
        public String f27060c;

        /* renamed from: d, reason: collision with root package name */
        public int f27061d;

        /* renamed from: e, reason: collision with root package name */
        public long f27062e;
    }

    /* compiled from: BlackAndWhiteListAdapter.java */
    /* loaded from: classes3.dex */
    public static final class f {

        /* renamed from: h, reason: collision with root package name */
        public static final f f27063h = new f();

        /* renamed from: a, reason: collision with root package name */
        public String f27064a;

        /* renamed from: b, reason: collision with root package name */
        public String f27065b;

        /* renamed from: c, reason: collision with root package name */
        public long f27066c;

        /* renamed from: d, reason: collision with root package name */
        public long f27067d;

        /* renamed from: f, reason: collision with root package name */
        public String f27069f;

        /* renamed from: e, reason: collision with root package name */
        public int f27068e = -1;

        /* renamed from: g, reason: collision with root package name */
        public boolean f27070g = false;
    }

    /* compiled from: BlackAndWhiteListAdapter.java */
    /* loaded from: classes3.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public TextView f27071a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f27072b;

        /* renamed from: c, reason: collision with root package name */
        public CheckBox f27073c;

        /* renamed from: d, reason: collision with root package name */
        public COUICardListSelectedItemLayout f27074d;

        /* renamed from: e, reason: collision with root package name */
        public View f27075e;

        /* renamed from: f, reason: collision with root package name */
        public View f27076f;

        /* renamed from: g, reason: collision with root package name */
        public TextView f27077g;

        /* renamed from: h, reason: collision with root package name */
        public View f27078h;
    }

    /* compiled from: BlackAndWhiteListAdapter.java */
    /* loaded from: classes3.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public String f27079a;

        /* renamed from: b, reason: collision with root package name */
        public String f27080b;

        /* renamed from: c, reason: collision with root package name */
        public long f27081c;

        /* renamed from: d, reason: collision with root package name */
        public long f27082d;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (TextUtils.equals(this.f27079a, hVar.f27079a) && TextUtils.equals(this.f27080b, hVar.f27080b) && this.f27081c == hVar.f27081c && this.f27082d == hVar.f27082d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            String str = this.f27080b;
            int i10 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i11 = (hashCode + 31) * 31;
            String str2 = this.f27079a;
            if (str2 != null) {
                i10 = str2.hashCode();
            }
            return i11 + i10;
        }
    }

    public d(Context context, Uri uri, int i10, int i11, boolean z10, S8.o oVar) {
        super(context, r.f27452g, null, z10);
        this.f27030a = false;
        this.f27031b = false;
        this.f27032c = true;
        this.f27036g = new HashMap<>();
        this.f27038i = true;
        this.f27042m = false;
        this.f27043n = false;
        this.f27045p = 0;
        this.f27046q = false;
        this.f27047r = 1;
        this.f27048x = new HandlerC0243d();
        this.f27049y = true;
        this.f27050z = new ConcurrentHashMap<>();
        this.f27028B = true;
        this.f27040k = context;
        this.f27044o = C1087a.e(context);
        this.f27033d = new HashMap<>();
        this.f27034e = new LinkedList<>();
        this.f27035f = new HashMap<>();
        this.f27041l = uri;
        this.f27047r = i10;
        this.f27045p = C0849j.b(context, 33.0f);
        this.f27027A = i11;
        this.f27028B = !C0844e.f29134b || this.f27047r == 2;
        this.f27029C = oVar;
        x("uri:" + C0846g.h(uri));
    }

    public static /* synthetic */ void u(Context context, g gVar) {
        if (l7.b.h(context)) {
            gVar.f27078h.setVisibility(0);
        }
    }

    public void A() {
        Context context = this.f27040k;
        if (context instanceof CustomBlackListActivity) {
            ((CustomBlackListActivity) context).v1();
        }
    }

    public void B() {
        this.f27037h = false;
        if (this.f27039j != null) {
            return;
        }
        Thread thread = new Thread(this, "blacklist_callerId");
        this.f27039j = thread;
        thread.setPriority(1);
        this.f27039j.start();
    }

    public final void C(h hVar, f fVar) {
        if (TextUtils.equals(hVar.f27080b, fVar.f27064a) && Long.compare(hVar.f27081c, fVar.f27066c) == 0 && Long.compare(hVar.f27082d, fVar.f27067d) == 0) {
            if (C0846g.c()) {
                x("same values not update!");
                return;
            }
            return;
        }
        Uri.Builder buildUpon = this.f27041l.buildUpon();
        buildUpon.appendQueryParameter("listMode", String.valueOf(this.f27047r));
        x("updateCallLog");
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", fVar.f27064a);
        contentValues.put("photo_id", Long.valueOf(fVar.f27066c));
        contentValues.put(OplusNumberMarkUtils.OplusBlacklist.CONTACTID, Long.valueOf(fVar.f27067d));
        try {
            int update = this.f27040k.getContentResolver().update(buildUpon.build(), contentValues, "number=?", new String[]{hVar.f27079a});
            x("count: " + update);
            if (update > 0) {
                A();
            }
        } catch (SQLiteDatabaseCorruptException e10) {
            Log.w("BlackAndWhiteAdapter", "Exception while updating call info" + e10);
        } catch (SQLiteDiskIOException e11) {
            Log.w("BlackAndWhiteAdapter", "Exception while updating call info" + e11);
        } catch (SQLiteFullException e12) {
            Log.w("BlackAndWhiteAdapter", "Exception while updating call info" + e12);
        } catch (Exception e13) {
            Log.w("BlackAndWhiteAdapter", "Exception while updating call info" + e13);
        }
    }

    @Override // com.oplus.blacklistapp.f
    public int a(ArrayList<C0845f> arrayList, int i10) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<C0845f> it = arrayList.iterator();
            while (it.hasNext()) {
                C0845f next = it.next();
                if (next != null && next.f29139d == 1) {
                    arrayList2.add(next.f29138c);
                }
            }
            if (i10 == 1) {
                C0849j.x(this.f27040k.getApplicationContext(), arrayList2, false, false, true, 0);
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList3 = new ArrayList();
                String str = arrayList.get(0).f29138c;
                int i11 = arrayList.get(0).f29139d;
                sb.append("(");
                sb.append("number");
                sb.append(" = '");
                sb.append(str);
                sb.append("' AND ");
                sb.append(OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE);
                sb.append(" = '");
                sb.append(i11);
                sb.append("')");
                if (C0844e.f29134b && this.f27047r == 1) {
                    arrayList3.add(DatabaseUtils.sqlEscapeString(str));
                }
                for (int i12 = 1; i12 < arrayList.size(); i12++) {
                    String str2 = arrayList.get(i12).f29138c;
                    int i13 = arrayList.get(i12).f29139d;
                    sb.append("OR (");
                    sb.append("number");
                    sb.append(" = '");
                    sb.append(str2);
                    sb.append("' AND ");
                    sb.append(OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE);
                    sb.append(" = '");
                    sb.append(i13);
                    sb.append("')");
                    if (C0844e.f29134b && this.f27047r == 1) {
                        arrayList3.add(DatabaseUtils.sqlEscapeString(str2));
                    }
                }
                int delete = this.f27040k.getContentResolver().delete(C0855p.a.f29171a, sb.toString(), null);
                if (C0844e.f29134b && this.f27047r == 1) {
                    return delete + this.f27040k.getContentResolver().delete(BlockedNumberContract.BlockedNumbers.CONTENT_URI, "original_number IN (" + TextUtils.join(",", arrayList3) + ")", null);
                }
                return delete;
            } catch (Exception e10) {
                Log.e("BlackAndWhiteAdapter", "" + e10);
            }
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.f27042m;
    }

    @Override // q6.AbstractRunnableC1488a
    public C0845f b(Cursor cursor) {
        long j10;
        String string;
        String str;
        int i10;
        if (cursor == null) {
            return null;
        }
        C0845f c0845f = new C0845f();
        try {
            if (C0844e.f29134b && this.f27047r == 1) {
                j10 = cursor.getInt(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
                str = cursor.getString(cursor.getColumnIndex("original_number"));
                i10 = this.f27047r;
                string = null;
            } else {
                j10 = cursor.getInt(cursor.getColumnIndexOrThrow(BreenoCallContract.BaseColumns._ID));
                String string2 = cursor.getString(cursor.getColumnIndexOrThrow("number"));
                string = cursor.getString(cursor.getColumnIndexOrThrow(OplusNumberMarkUtils.OplusBlacklist.CONTACTID));
                int i11 = cursor.getInt(cursor.getColumnIndexOrThrow(OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE));
                str = string2;
                i10 = i11;
            }
            c0845f.f29136a = j10;
            c0845f.f29137b = string;
            c0845f.f29138c = str;
            c0845f.f29139d = i10;
            return c0845f;
        } catch (Exception e10) {
            Log.e("BlackAndWhiteAdapter", "buildBlacklistItemDeleteInfo error", e10);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0127, code lost:
    
        if (java.lang.Long.compare(r10.f27067d, r8) != 0) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0306 A[Catch: Exception -> 0x030d, TryCatch #0 {Exception -> 0x030d, blocks: (B:71:0x0300, B:73:0x0306, B:103:0x0312, B:105:0x031e, B:106:0x0326, B:107:0x032d, B:109:0x0334, B:111:0x033e, B:113:0x0342, B:114:0x034d, B:116:0x0353, B:118:0x035f, B:119:0x0367, B:120:0x036f, B:122:0x0377), top: B:70:0x0300 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03ca  */
    @Override // android.widget.CursorAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void bindView(android.view.View r25, final android.content.Context r26, android.database.Cursor r27) {
        /*
            Method dump skipped, instructions count: 1077
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.d.bindView(android.view.View, android.content.Context, android.database.Cursor):void");
    }

    @Override // q6.AbstractRunnableC1488a
    public void c() {
        synchronized (this.f27035f) {
            this.f27035f.clear();
        }
    }

    @Override // q6.AbstractRunnableC1488a
    public void d() {
        synchronized (this.f27033d) {
            this.f27033d.clear();
        }
    }

    @Override // q6.AbstractRunnableC1488a
    public HashMap<C0845f, Boolean> e() {
        return this.f27036g;
    }

    @Override // q6.AbstractRunnableC1488a
    public boolean f() {
        return this.f27043n;
    }

    @Override // q6.AbstractRunnableC1488a
    public void g() {
        this.f27042m = true;
        this.f27048x.sendEmptyMessage(1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i10) {
        boolean z10;
        Cursor cursor = (Cursor) getItem(i10);
        int columnIndex = cursor.getColumnIndex(OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE);
        if (columnIndex == -1) {
            return COUICardListHelper.getPositionInGroup(cursor.getCount(), i10);
        }
        if (cursor.getCount() == 1) {
            return 4;
        }
        boolean z11 = false;
        if (cursor.isFirst()) {
            z10 = false;
            z11 = true;
        } else if (cursor.isLast()) {
            z10 = true;
        } else {
            z10 = false;
        }
        String string = cursor.getString(columnIndex);
        if (cursor.moveToPosition(i10 + 1) && !TextUtils.equals(string, cursor.getString(columnIndex))) {
            z10 = true;
        }
        if (cursor.moveToPosition(i10 - 1) && !TextUtils.equals(string, cursor.getString(columnIndex))) {
            z11 = true;
        }
        cursor.moveToPosition(i10);
        if (z11 && z10) {
            return 4;
        }
        if (z11) {
            return 1;
        }
        if (z10) {
            return 3;
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 5;
    }

    @Override // q6.AbstractRunnableC1488a
    public void h(boolean z10) {
        this.f27043n = z10;
    }

    @Override // q6.AbstractRunnableC1488a
    public void i(boolean z10) {
        this.f27046q = z10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        if (this.f27038i) {
            return false;
        }
        return super.isEmpty();
    }

    @Override // q6.AbstractRunnableC1488a
    public void j(boolean z10) {
        this.f27038i = z10;
    }

    @Override // q6.AbstractRunnableC1488a
    public void k(ConcurrentHashMap<Long, C0845f> concurrentHashMap) {
        this.f27050z = concurrentHashMap;
    }

    @Override // q6.AbstractRunnableC1488a
    public void l(boolean z10) {
        this.f27049y = z10;
    }

    @Override // q6.AbstractRunnableC1488a
    public void m() {
        this.f27048x.removeMessages(2);
        this.f27037h = true;
        Thread thread = this.f27039j;
        if (thread != null) {
            thread.interrupt();
            this.f27039j = null;
        }
    }

    @Override // android.widget.ResourceCursorAdapter, android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        g gVar = new g();
        gVar.f27072b = (TextView) newView.findViewById(p.f27352O);
        gVar.f27073c = (CheckBox) newView.findViewById(p.f27370X);
        gVar.f27071a = (TextView) newView.findViewById(p.f27354P);
        gVar.f27074d = (COUICardListSelectedItemLayout) newView.findViewById(p.f27364U);
        gVar.f27075e = newView.findViewById(p.f27366V);
        gVar.f27076f = newView.findViewById(p.f27390h);
        gVar.f27077g = (TextView) newView.findViewById(p.f27342J);
        gVar.f27078h = newView.findViewById(p.f27344K);
        gVar.f27071a.setOnClickListener(new a());
        gVar.f27071a.setOnLongClickListener(new b());
        int itemViewType = getItemViewType(cursor.getPosition());
        COUICardListHelper.setItemCardBackground(gVar.f27074d, itemViewType);
        int i10 = 0;
        boolean z10 = true;
        if (itemViewType != 1 && itemViewType != 2) {
            z10 = false;
        }
        View view = gVar.f27076f;
        if (view != null) {
            if (!z10) {
                i10 = 8;
            }
            view.setVisibility(i10);
        }
        gVar.f27074d.setTag(new e());
        newView.setTag(gVar);
        return newView;
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVar;
        while (!this.f27037h && this.f27046q) {
            synchronized (this.f27034e) {
                if (!this.f27034e.isEmpty()) {
                    hVar = this.f27034e.removeFirst();
                } else {
                    try {
                        this.f27034e.wait(1000L);
                    } catch (InterruptedException unused) {
                    }
                    hVar = null;
                }
            }
            if (this.f27027A != 1 && hVar != null) {
                y(hVar);
            }
        }
    }

    public final void s(boolean z10, CheckBox checkBox, Runnable runnable) {
        c cVar = new c(z10, checkBox, runnable);
        if (z10) {
            if (!BlackListAppUtil.f26245b) {
                AnimationAnimationListenerC0842c.l(this.f27040k, null, 0).r(false, cVar, checkBox);
                return;
            } else {
                AnimationAnimationListenerC0842c.j(this.f27040k, null, 0).r(false, cVar, checkBox);
                return;
            }
        }
        if (!BlackListAppUtil.f26245b) {
            AnimationAnimationListenerC0842c.m(this.f27040k, null, 8).r(false, cVar, checkBox);
        } else {
            AnimationAnimationListenerC0842c.k(this.f27040k, null, 8).r(false, cVar, checkBox);
        }
    }

    public final void t(String str, String str2, Long l10, Long l11) {
        h hVar = new h();
        hVar.f27079a = str;
        hVar.f27080b = str2;
        hVar.f27081c = l10.longValue();
        hVar.f27082d = l11.longValue();
        synchronized (this.f27034e) {
            try {
                if (!this.f27034e.contains(hVar)) {
                    this.f27034e.add(hVar);
                    this.f27034e.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        B();
    }

    public final /* synthetic */ void v(int i10, long j10, View view) {
        S8.o oVar = this.f27029C;
        if (oVar != null) {
            oVar.onItemClick(null, view, i10, j10);
        }
    }

    public final /* synthetic */ boolean w(int i10, long j10, View view) {
        S8.o oVar = this.f27029C;
        if (oVar != null) {
            return oVar.onItemLongClick(null, view, i10, j10);
        }
        return false;
    }

    public final void x(String str) {
        if (C0846g.c()) {
            Log.d("BlackAndWhiteAdapter", str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(com.oplus.blacklistapp.d.h r18) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.d.y(com.oplus.blacklistapp.d$h):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean z(java.lang.String r11, com.oplus.blacklistapp.d.f r12) {
        /*
            r10 = this;
            java.lang.String r0 = "number"
            java.lang.String r1 = "cn_name"
            java.lang.String r2 = "_id"
            java.lang.String[] r5 = new java.lang.String[]{r2, r0, r1}
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "number = '"
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = "'"
            r0.append(r11)
            java.lang.String r6 = r0.toString()
            r0 = 0
            r11 = 1
            r2 = 0
            r9 = 0
            android.content.Context r3 = r10.f27040k     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            android.content.Context r10 = r10.f27040k     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            android.net.Uri r4 = com.oplus.utils.C0848i.o(r10)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            if (r10 == 0) goto L5e
            int r3 = r10.getCount()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            if (r3 <= 0) goto L5e
            boolean r3 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            if (r3 == 0) goto L5e
            int r3 = r10.getInt(r2)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            int r3 = 0 - r3
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            r12.f27066c = r3     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            r3 = 2
            java.lang.String r3 = r10.getString(r3)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            r12.f27064a = r3     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            r12.f27070g = r11     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            goto L64
        L58:
            r11 = move-exception
            r9 = r10
            goto L91
        L5b:
            r3 = move-exception
            r9 = r10
            goto L6d
        L5e:
            r12.f27066c = r0     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            r12.f27064a = r9     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            r12.f27070g = r2     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
        L64:
            if (r10 == 0) goto L88
            r10.close()
            goto L88
        L6a:
            r11 = move-exception
            goto L91
        L6c:
            r3 = move-exception
        L6d:
            java.lang.String r10 = "BlackAndWhiteAdapter"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            r4.<init>()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r5 = "Exception:"
            r4.append(r5)     // Catch: java.lang.Throwable -> L6a
            r4.append(r3)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L6a
            android.util.Log.e(r10, r3)     // Catch: java.lang.Throwable -> L6a
            if (r9 == 0) goto L88
            r9.close()
        L88:
            long r3 = r12.f27066c
            int r10 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r10 == 0) goto L8f
            goto L90
        L8f:
            r11 = r2
        L90:
            return r11
        L91:
            if (r9 == 0) goto L96
            r9.close()
        L96:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.d.z(java.lang.String, com.oplus.blacklistapp.d$f):boolean");
    }

    /* compiled from: BlackAndWhiteListAdapter.java */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: BlackAndWhiteListAdapter.java */
    /* loaded from: classes3.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f27053a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CheckBox f27054b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f27055c;

        public c(boolean z10, CheckBox checkBox, Runnable runnable) {
            this.f27053a = z10;
            this.f27054b = checkBox;
            this.f27055c = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            d dVar = d.this;
            dVar.f27031b = false;
            if (!this.f27053a) {
                dVar.f27049y = true;
                this.f27054b.setChecked(false);
                this.f27054b.setVisibility(8);
            } else {
                dVar.f27049y = false;
                this.f27054b.setVisibility(0);
            }
            Runnable runnable = this.f27055c;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            d.this.f27031b = true;
            this.f27054b.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
