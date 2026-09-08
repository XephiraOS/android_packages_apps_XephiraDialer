package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: SavedStateHandle.kt */
/* loaded from: classes.dex */
public final class D {

    /* renamed from: f, reason: collision with root package name */
    public static final a f10237f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final Class<? extends Object>[] f10238g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f10239a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, a.c> f10240b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f10241c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, kotlinx.coroutines.flow.i<Object>> f10242d;

    /* renamed from: e, reason: collision with root package name */
    public final a.c f10243e;

    /* compiled from: SavedStateHandle.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final D a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new D();
                }
                HashMap hashMap = new HashMap();
                for (String key : bundle2.keySet()) {
                    kotlin.jvm.internal.i.e(key, "key");
                    hashMap.put(key, bundle2.get(key));
                }
                return new D(hashMap);
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList != null && parcelableArrayList2 != null && parcelableArrayList.size() == parcelableArrayList2.size()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int size = parcelableArrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj = parcelableArrayList.get(i10);
                    kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlin.String");
                    linkedHashMap.put((String) obj, parcelableArrayList2.get(i10));
                }
                return new D(linkedHashMap);
            }
            throw new IllegalStateException("Invalid bundle passed as restored state".toString());
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : D.f10238g) {
                kotlin.jvm.internal.i.c(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public D(Map<String, ? extends Object> initialState) {
        kotlin.jvm.internal.i.f(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f10239a = linkedHashMap;
        this.f10240b = new LinkedHashMap();
        this.f10241c = new LinkedHashMap();
        this.f10242d = new LinkedHashMap();
        this.f10243e = new a.c() { // from class: androidx.lifecycle.C
            @Override // androidx.savedstate.a.c
            public final Bundle saveState() {
                Bundle d10;
                d10 = D.d(D.this);
                return d10;
            }
        };
        linkedHashMap.putAll(initialState);
    }

    public static final Bundle d(D this$0) {
        Map l10;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        l10 = kotlin.collections.E.l(this$0.f10240b);
        for (Map.Entry entry : l10.entrySet()) {
            this$0.e((String) entry.getKey(), ((a.c) entry.getValue()).saveState());
        }
        Set<String> keySet = this$0.f10239a.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : keySet) {
            arrayList.add(str);
            arrayList2.add(this$0.f10239a.get(str));
        }
        return F.c.a(m9.g.a("keys", arrayList), m9.g.a("values", arrayList2));
    }

    public final a.c c() {
        return this.f10243e;
    }

    public final <T> void e(String key, T t10) {
        v vVar;
        kotlin.jvm.internal.i.f(key, "key");
        if (f10237f.b(t10)) {
            Object obj = this.f10241c.get(key);
            if (obj instanceof v) {
                vVar = (v) obj;
            } else {
                vVar = null;
            }
            if (vVar != null) {
                vVar.o(t10);
            } else {
                this.f10239a.put(key, t10);
            }
            kotlinx.coroutines.flow.i<Object> iVar = this.f10242d.get(key);
            if (iVar != null) {
                iVar.setValue(t10);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't put value with type ");
        kotlin.jvm.internal.i.c(t10);
        sb.append(t10.getClass());
        sb.append(" into saved state");
        throw new IllegalArgumentException(sb.toString());
    }

    public D() {
        this.f10239a = new LinkedHashMap();
        this.f10240b = new LinkedHashMap();
        this.f10241c = new LinkedHashMap();
        this.f10242d = new LinkedHashMap();
        this.f10243e = new a.c() { // from class: androidx.lifecycle.C
            @Override // androidx.savedstate.a.c
            public final Bundle saveState() {
                Bundle d10;
                d10 = D.d(D.this);
                return d10;
            }
        };
    }
}
