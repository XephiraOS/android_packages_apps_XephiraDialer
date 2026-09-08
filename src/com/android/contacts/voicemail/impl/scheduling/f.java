package com.android.contacts.voicemail.impl.scheduling;

import android.content.Context;
import android.os.Bundle;
import com.android.contacts.voicemail.impl.scheduling.e;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import t1.C1580a;

/* compiled from: TaskQueue.java */
/* loaded from: classes.dex */
public class f implements Iterable<e> {

    /* renamed from: a, reason: collision with root package name */
    public final Queue<e> f18186a = new ArrayDeque();

    /* compiled from: TaskQueue.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final e f18187a;

        /* renamed from: b, reason: collision with root package name */
        public final Long f18188b;

        public a(e eVar, Long l10) {
            this.f18187a = eVar;
            this.f18188b = l10;
        }
    }

    public boolean a(e eVar) {
        e g10;
        if (eVar.getId().f18184a != -1) {
            if (eVar.getId().f18184a != -2 && (g10 = g(eVar.getId())) != null) {
                g10.b(eVar);
                H7.b.e("TaskQueue.add", "duplicated task added");
                return false;
            }
            this.f18186a.add(eVar);
            return true;
        }
        throw new AssertionError("Task id was not set to a valid value before adding.");
    }

    public void c(Context context, List<Bundle> list) {
        C1580a.e(this.f18186a.isEmpty());
        for (Bundle bundle : list) {
            e b10 = g.b(context, bundle);
            b10.onRestore(bundle);
            a(b10);
        }
    }

    public void clear() {
        this.f18186a.clear();
    }

    public a e(long j10) {
        Long l10 = null;
        for (e eVar : this.f18186a) {
            long d10 = eVar.d();
            if (d10 < j10) {
                return new a(eVar, 0L);
            }
            if (l10 == null || d10 < l10.longValue()) {
                l10 = Long.valueOf(d10);
            }
        }
        return new a(null, l10);
    }

    public e g(e.a aVar) {
        C1580a.c();
        for (e eVar : this.f18186a) {
            if (eVar.getId().equals(aVar)) {
                return eVar;
            }
        }
        return null;
    }

    public void h(e eVar) {
        this.f18186a.remove(eVar);
    }

    public List<Bundle> i() {
        ArrayList arrayList = new ArrayList(this.f18186a.size());
        Iterator<e> it = this.f18186a.iterator();
        while (it.hasNext()) {
            arrayList.add(g.c(it.next()));
        }
        return arrayList;
    }

    public boolean isEmpty() {
        return this.f18186a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<e> iterator() {
        return this.f18186a.iterator();
    }
}
