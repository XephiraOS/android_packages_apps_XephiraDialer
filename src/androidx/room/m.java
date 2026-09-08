package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.room.RoomDatabase;
import b0.InterfaceC0514a;
import e0.h;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: DatabaseConfiguration.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final h.c f11336a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11337b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11338c;

    /* renamed from: d, reason: collision with root package name */
    public final RoomDatabase.c f11339d;

    /* renamed from: e, reason: collision with root package name */
    public final List<RoomDatabase.b> f11340e;

    /* renamed from: f, reason: collision with root package name */
    public final List<Object> f11341f;

    /* renamed from: g, reason: collision with root package name */
    public final List<InterfaceC0514a> f11342g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f11343h;

    /* renamed from: i, reason: collision with root package name */
    public final RoomDatabase.JournalMode f11344i;

    /* renamed from: j, reason: collision with root package name */
    public final Executor f11345j;

    /* renamed from: k, reason: collision with root package name */
    public final Executor f11346k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f11347l;

    /* renamed from: m, reason: collision with root package name */
    public final Intent f11348m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f11349n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f11350o;

    /* renamed from: p, reason: collision with root package name */
    public final Set<Integer> f11351p;

    /* renamed from: q, reason: collision with root package name */
    public final String f11352q;

    /* renamed from: r, reason: collision with root package name */
    public final File f11353r;

    /* renamed from: s, reason: collision with root package name */
    public final Callable<InputStream> f11354s;

    public m(Context context, String str, h.c cVar, RoomDatabase.c cVar2, List<RoomDatabase.b> list, boolean z10, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z11, boolean z12, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.d dVar, List<Object> list2, List<InterfaceC0514a> list3) {
        boolean z13;
        List<Object> list4;
        List<InterfaceC0514a> list5;
        this.f11336a = cVar;
        this.f11337b = context;
        this.f11338c = str;
        this.f11339d = cVar2;
        this.f11340e = list;
        this.f11343h = z10;
        this.f11344i = journalMode;
        this.f11345j = executor;
        this.f11346k = executor2;
        this.f11348m = intent;
        if (intent != null) {
            z13 = true;
        } else {
            z13 = false;
        }
        this.f11347l = z13;
        this.f11349n = z11;
        this.f11350o = z12;
        this.f11351p = set;
        this.f11352q = str2;
        this.f11353r = file;
        this.f11354s = callable;
        if (list2 == null) {
            list4 = Collections.emptyList();
        } else {
            list4 = list2;
        }
        this.f11341f = list4;
        if (list3 == null) {
            list5 = Collections.emptyList();
        } else {
            list5 = list3;
        }
        this.f11342g = list5;
    }

    public boolean a(int i10, int i11) {
        if ((i10 > i11 && this.f11350o) || !this.f11349n) {
            return false;
        }
        Set<Integer> set = this.f11351p;
        if (set != null && set.contains(Integer.valueOf(i10))) {
            return false;
        }
        return true;
    }
}
