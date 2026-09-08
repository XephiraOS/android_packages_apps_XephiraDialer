package q6;

import S8.o;
import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.TextView;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.oplus.blacklistapp.BlackListAppUtil;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.r;
import com.oplus.utils.AnimationAnimationListenerC0842c;
import com.oplus.utils.C0845f;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0849j;
import com.oplus.utils.Q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ServiceBlackListAdapter.java */
/* renamed from: q6.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1491d extends AbstractRunnableC1488a {

    /* renamed from: A, reason: collision with root package name */
    public final o f36168A;

    /* renamed from: B, reason: collision with root package name */
    public f f36169B;

    /* renamed from: a, reason: collision with root package name */
    public boolean f36170a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f36171b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f36172c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, e> f36173d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedList<C0344d> f36174e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, Q> f36175f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap<C0845f, Boolean> f36176g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f36177h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f36178i;

    /* renamed from: j, reason: collision with root package name */
    public Thread f36179j;

    /* renamed from: k, reason: collision with root package name */
    public Context f36180k;

    /* renamed from: l, reason: collision with root package name */
    public Uri f36181l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f36182m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f36183n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f36184o;

    /* renamed from: p, reason: collision with root package name */
    public int f36185p;

    /* renamed from: q, reason: collision with root package name */
    public Handler f36186q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f36187r;

    /* renamed from: x, reason: collision with root package name */
    public ConcurrentHashMap<Long, C0845f> f36188x;

    /* renamed from: y, reason: collision with root package name */
    public V6.f f36189y;

    /* renamed from: z, reason: collision with root package name */
    public int f36190z;

    /* compiled from: ServiceBlackListAdapter.java */
    /* renamed from: q6.d$b */
    /* loaded from: classes3.dex */
    public static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<C1491d> f36194a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1491d c1491d = this.f36194a.get();
            if (c1491d == null) {
                return;
            }
            int i10 = message.what;
            if (i10 == 1) {
                c1491d.u("handleMessage REDRAW");
                c1491d.notifyDataSetChanged();
            } else if (i10 == 2) {
                c1491d.v();
            }
        }

        public b(C1491d c1491d) {
            this.f36194a = new WeakReference<>(c1491d);
        }
    }

    /* compiled from: ServiceBlackListAdapter.java */
    /* renamed from: q6.d$c */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public COUIRoundImageView f36195a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f36196b;

        /* renamed from: c, reason: collision with root package name */
        public CheckBox f36197c;

        /* renamed from: d, reason: collision with root package name */
        public COUICardListSelectedItemLayout f36198d;

        /* renamed from: e, reason: collision with root package name */
        public View f36199e;
    }

    /* compiled from: ServiceBlackListAdapter.java */
    /* renamed from: q6.d$d, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0344d {

        /* renamed from: a, reason: collision with root package name */
        public String f36200a;

        /* renamed from: b, reason: collision with root package name */
        public String f36201b;

        /* renamed from: c, reason: collision with root package name */
        public long f36202c;

        /* renamed from: d, reason: collision with root package name */
        public long f36203d;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof C0344d)) {
                return false;
            }
            C0344d c0344d = (C0344d) obj;
            if (TextUtils.equals(this.f36200a, c0344d.f36200a) && TextUtils.equals(this.f36201b, c0344d.f36201b) && this.f36202c == c0344d.f36202c && this.f36203d == c0344d.f36203d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            String str = this.f36201b;
            int i10 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i11 = (hashCode + 31) * 31;
            String str2 = this.f36200a;
            if (str2 != null) {
                i10 = str2.hashCode();
            }
            return i11 + i10;
        }
    }

    /* compiled from: ServiceBlackListAdapter.java */
    /* renamed from: q6.d$e */
    /* loaded from: classes3.dex */
    public static final class e {

        /* renamed from: f, reason: collision with root package name */
        public static final e f36204f = new e();

        /* renamed from: a, reason: collision with root package name */
        public String f36205a;

        /* renamed from: b, reason: collision with root package name */
        public long f36206b;

        /* renamed from: c, reason: collision with root package name */
        public String f36207c;

        /* renamed from: d, reason: collision with root package name */
        public String f36208d;

        /* renamed from: e, reason: collision with root package name */
        public int f36209e;

        public String toString() {
            return "mNumber:" + C0846g.f(this.f36205a) + " mId:" + this.f36206b + " shopId:" + this.f36207c + " mSource:" + this.f36208d + " mIsInBlack:" + this.f36209e;
        }
    }

    /* compiled from: ServiceBlackListAdapter.java */
    /* renamed from: q6.d$f */
    /* loaded from: classes3.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public int f36210a;

        /* renamed from: b, reason: collision with root package name */
        public int f36211b;

        /* renamed from: c, reason: collision with root package name */
        public int f36212c;

        /* renamed from: d, reason: collision with root package name */
        public int f36213d;

        /* renamed from: e, reason: collision with root package name */
        public int f36214e;

        /* renamed from: f, reason: collision with root package name */
        public int f36215f;

        /* renamed from: g, reason: collision with root package name */
        public int f36216g;

        public void a(Cursor cursor) {
            this.f36210a = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
            this.f36211b = cursor.getColumnIndex("name");
            this.f36212c = cursor.getColumnIndex("number");
            this.f36213d = cursor.getColumnIndex("shop_id");
            this.f36214e = cursor.getColumnIndex("is_in_black");
            this.f36215f = cursor.getColumnIndex("logo");
            this.f36216g = cursor.getColumnIndex("source");
        }

        public f() {
            this.f36210a = -1;
            this.f36211b = -1;
            this.f36212c = -1;
            this.f36213d = -1;
            this.f36214e = -1;
            this.f36215f = -1;
            this.f36216g = -1;
        }
    }

    public C1491d(Context context, Uri uri, int i10, int i11, o oVar) {
        super(context, r.f27453h, null);
        this.f36170a = false;
        this.f36171b = false;
        this.f36172c = true;
        this.f36176g = new HashMap<>();
        this.f36178i = true;
        this.f36182m = false;
        this.f36183n = false;
        this.f36184o = false;
        this.f36185p = 1;
        this.f36186q = new b();
        this.f36187r = true;
        this.f36188x = new ConcurrentHashMap<>();
        this.f36169B = null;
        this.f36180k = context;
        this.f36173d = new HashMap<>();
        this.f36174e = new LinkedList<>();
        this.f36175f = new HashMap<>();
        this.f36181l = uri;
        this.f36185p = i10;
        this.f36190z = i11;
        this.f36189y = V6.f.b(context);
        this.f36168A = oVar;
        u("uri:" + C0846g.h(uri));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str) {
        C0846g.i("ServiceBlackListAdapter", str);
    }

    @Override // com.oplus.blacklistapp.f
    public int a(ArrayList<C0845f> arrayList, int i10) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<C0845f> it = arrayList.iterator();
            while (it.hasNext()) {
                C0845f next = it.next();
                if (next != null && (next instanceof Q)) {
                    arrayList2.add(((Q) next).f29086e);
                }
            }
            if (i10 == 1) {
                C0849j.y(this.f36180k.getApplicationContext(), arrayList2, false);
            }
            try {
                ArrayList<ContentProviderOperation> arrayList3 = new ArrayList<>();
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    C0845f c0845f = arrayList.get(i11);
                    if (c0845f instanceof Q) {
                        Q q10 = (Q) c0845f;
                        ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(this.f36181l);
                        String str = q10.f29086e;
                        String str2 = q10.f29087f;
                        new ContentValues().put("is_in_black", (Integer) 0);
                        newUpdate.withValue("is_in_black", 0).withSelection("shop_id = ? and source = ?", new String[]{str, str2});
                        arrayList3.add(newUpdate.build());
                        if (arrayList3.size() > 50) {
                            try {
                                this.f36180k.getContentResolver().applyBatch("com.suntek.mway.rcs.app.service.chatbots", arrayList3);
                            } catch (Exception e10) {
                                Log.e("ServiceBlackListAdapter", "" + e10);
                            }
                            arrayList3.clear();
                        }
                    }
                }
                try {
                    this.f36180k.getContentResolver().applyBatch("com.suntek.mway.rcs.app.service.chatbots", arrayList3);
                } catch (Exception e11) {
                    Log.e("ServiceBlackListAdapter", "" + e11);
                }
                return 1;
            } catch (Exception e12) {
                Log.e("ServiceBlackListAdapter", "" + e12);
            }
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.f36182m;
    }

    @Override // q6.AbstractRunnableC1488a
    public C0845f b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        Q q10 = new Q();
        try {
            long j10 = cursor.getLong(cursor.getColumnIndexOrThrow(BreenoCallContract.BaseColumns._ID));
            cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String string = cursor.getString(cursor.getColumnIndexOrThrow("number"));
            String string2 = cursor.getString(cursor.getColumnIndexOrThrow("shop_id"));
            int i10 = cursor.getInt(cursor.getColumnIndexOrThrow("is_in_black"));
            String string3 = cursor.getString(cursor.getColumnIndexOrThrow("source"));
            q10.f29136a = j10;
            q10.f29138c = string;
            q10.f29086e = string2;
            q10.f29088g = i10;
            q10.f29087f = string3;
            return q10;
        } catch (Exception e10) {
            Log.e("ServiceBlackListAdapter", "buildBlacklistItemDeleteInfo error" + e10);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.widget.CursorAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void bindView(android.view.View r16, android.content.Context r17, android.database.Cursor r18) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.C1491d.bindView(android.view.View, android.content.Context, android.database.Cursor):void");
    }

    @Override // q6.AbstractRunnableC1488a
    public void c() {
        synchronized (this.f36175f) {
            this.f36175f.clear();
        }
    }

    @Override // android.widget.CursorAdapter
    public void changeCursor(Cursor cursor) {
        super.changeCursor(cursor);
        this.f36169B = null;
    }

    @Override // q6.AbstractRunnableC1488a
    public void d() {
        synchronized (this.f36173d) {
            this.f36173d.clear();
        }
    }

    @Override // q6.AbstractRunnableC1488a
    public HashMap<C0845f, Boolean> e() {
        return this.f36176g;
    }

    @Override // q6.AbstractRunnableC1488a
    public boolean f() {
        return this.f36183n;
    }

    @Override // q6.AbstractRunnableC1488a
    public void g() {
        this.f36182m = true;
        this.f36186q.sendEmptyMessage(1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i10) {
        return COUICardListHelper.getPositionInGroup(((Cursor) getItem(i10)).getCount(), i10);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 5;
    }

    @Override // q6.AbstractRunnableC1488a
    public void h(boolean z10) {
        this.f36183n = z10;
    }

    @Override // q6.AbstractRunnableC1488a
    public void i(boolean z10) {
        this.f36184o = z10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        if (this.f36178i) {
            return false;
        }
        return super.isEmpty();
    }

    @Override // q6.AbstractRunnableC1488a
    public void j(boolean z10) {
        this.f36178i = z10;
    }

    @Override // q6.AbstractRunnableC1488a
    public void k(ConcurrentHashMap<Long, C0845f> concurrentHashMap) {
        this.f36188x = concurrentHashMap;
    }

    @Override // q6.AbstractRunnableC1488a
    public void l(boolean z10) {
        this.f36187r = z10;
    }

    @Override // q6.AbstractRunnableC1488a
    public void m() {
        this.f36186q.removeMessages(2);
        this.f36177h = true;
        Thread thread = this.f36179j;
        if (thread != null) {
            thread.interrupt();
            this.f36179j = null;
        }
    }

    @Override // android.widget.ResourceCursorAdapter, android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        int i10;
        View newView = super.newView(context, cursor, viewGroup);
        c cVar = new c();
        cVar.f36196b = (TextView) newView.findViewById(p.f27352O);
        cVar.f36197c = (CheckBox) newView.findViewById(p.f27370X);
        cVar.f36198d = (COUICardListSelectedItemLayout) newView.findViewById(p.f27364U);
        cVar.f36195a = (COUIRoundImageView) newView.findViewById(p.f27358R);
        View findViewById = newView.findViewById(p.f27384e);
        cVar.f36199e = findViewById;
        if (findViewById != null) {
            if (cursor.isLast()) {
                i10 = 8;
            } else {
                i10 = 0;
            }
            findViewById.setVisibility(i10);
        }
        if (this.f36190z != 1) {
            cVar.f36195a.setVisibility(8);
        } else {
            cVar.f36195a.setVisibility(0);
        }
        COUICardListHelper.setItemCardBackground(cVar.f36198d, getItemViewType(cursor.getPosition()));
        newView.setTag(cVar);
        return newView;
    }

    public final void r(boolean z10, CheckBox checkBox) {
        a aVar = new a(z10, checkBox);
        if (z10) {
            if (!BlackListAppUtil.f26245b) {
                AnimationAnimationListenerC0842c.l(this.f36180k, null, 0).r(false, aVar, checkBox);
                return;
            } else {
                AnimationAnimationListenerC0842c.j(this.f36180k, null, 0).r(false, aVar, checkBox);
                return;
            }
        }
        if (!BlackListAppUtil.f26245b) {
            AnimationAnimationListenerC0842c.m(this.f36180k, null, 8).r(false, aVar, checkBox);
        } else {
            AnimationAnimationListenerC0842c.k(this.f36180k, null, 8).r(false, aVar, checkBox);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!this.f36177h && this.f36184o) {
            synchronized (this.f36174e) {
                if (!this.f36174e.isEmpty()) {
                    this.f36174e.removeFirst();
                } else {
                    try {
                        this.f36174e.wait(1000L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    public final /* synthetic */ void s(int i10, long j10, View view) {
        o oVar = this.f36168A;
        if (oVar != null) {
            oVar.onItemClick(null, view, i10, j10);
        }
    }

    public final /* synthetic */ boolean t(int i10, long j10, View view) {
        o oVar = this.f36168A;
        if (oVar != null) {
            return oVar.onItemLongClick(null, view, i10, j10);
        }
        return false;
    }

    public void v() {
        this.f36177h = false;
        if (this.f36179j != null) {
            return;
        }
        Thread thread = new Thread(this, "blacklist_callerId");
        this.f36179j = thread;
        thread.setPriority(1);
        this.f36179j.start();
    }

    /* compiled from: ServiceBlackListAdapter.java */
    /* renamed from: q6.d$a */
    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f36191a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CheckBox f36192b;

        public a(boolean z10, CheckBox checkBox) {
            this.f36191a = z10;
            this.f36192b = checkBox;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            C1491d c1491d = C1491d.this;
            c1491d.f36171b = false;
            if (!this.f36191a) {
                c1491d.f36187r = true;
                this.f36192b.setChecked(false);
                this.f36192b.setVisibility(8);
            } else {
                c1491d.f36187r = false;
                this.f36192b.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            C1491d.this.f36171b = true;
            this.f36192b.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
