package com.android.contacts.model;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class AccountType {

    /* renamed from: j, reason: collision with root package name */
    public static Comparator<com.android.contacts.model.c> f16943j = new a();

    /* renamed from: c, reason: collision with root package name */
    public String f16946c;

    /* renamed from: d, reason: collision with root package name */
    public String f16947d;

    /* renamed from: e, reason: collision with root package name */
    public int f16948e;

    /* renamed from: f, reason: collision with root package name */
    public int f16949f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16950g;

    /* renamed from: a, reason: collision with root package name */
    public String f16944a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f16945b = null;

    /* renamed from: h, reason: collision with root package name */
    public CopyOnWriteArrayList<com.android.contacts.model.c> f16951h = new CopyOnWriteArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    public HashMap<String, com.android.contacts.model.c> f16952i = Maps.f();

    /* loaded from: classes.dex */
    public static class DefinitionException extends Exception {
        public DefinitionException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public class a implements Comparator<com.android.contacts.model.c> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.android.contacts.model.c cVar, com.android.contacts.model.c cVar2) {
            return cVar.f17009h - cVar2.f17009h;
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f16960a;

        /* renamed from: b, reason: collision with root package name */
        public int f16961b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f16962c;

        /* renamed from: d, reason: collision with root package name */
        public int f16963d = -1;

        /* renamed from: e, reason: collision with root package name */
        public String f16964e;

        public c(int i10, int i11) {
            this.f16960a = i10;
            this.f16961b = i11;
        }

        public c a(String str) {
            this.f16964e = str;
            return this;
        }

        public c b(boolean z10) {
            this.f16962c = z10;
            return this;
        }

        public c c(int i10) {
            this.f16963d = i10;
            return this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c) || ((c) obj).f16960a != this.f16960a) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f16960a;
        }

        public String toString() {
            return getClass().getSimpleName() + " rawValue=" + this.f16960a + " labelRes=" + this.f16961b + " secondary=" + this.f16962c + " specificMax=" + this.f16963d + " customColumn=" + this.f16964e;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends c {

        /* renamed from: f, reason: collision with root package name */
        public boolean f16965f;

        public d(int i10, int i11) {
            super(i10, i11);
        }

        public boolean d() {
            return this.f16965f;
        }

        public d e(boolean z10) {
            this.f16965f = z10;
            return this;
        }

        @Override // com.android.contacts.model.AccountType.c
        public String toString() {
            return super.toString() + " mYearOptional=" + this.f16965f;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        CharSequence a(Context context, ContentValues contentValues);
    }

    public static CharSequence k(Context context, String str, int i10, String str2) {
        if (i10 != -1 && str != null) {
            return context.getPackageManager().getText(str, i10, null);
        }
        if (i10 != -1) {
            return context.getText(i10);
        }
        return str2;
    }

    public com.android.contacts.model.c a(com.android.contacts.model.c cVar) {
        String str = cVar.f17004c;
        if (str != null) {
            if (this.f16952i.get(str) == null) {
                cVar.f17003b = this.f16946c;
                this.f16951h.add(cVar);
                this.f16952i.put(cVar.f17004c, cVar);
                return cVar;
            }
            throw new DefinitionException("mime type '" + cVar.f17004c + "' is already registered");
        }
        throw new DefinitionException("null is not a valid mime type");
    }

    public abstract boolean b();

    public n1.d c() {
        return n1.d.a(this.f16944a, this.f16945b);
    }

    public String d() {
        return null;
    }

    public Drawable e(Context context) {
        int i10 = this.f16948e;
        if (i10 != -1 && this.f16947d != null) {
            return context.getPackageManager().getDrawable(this.f16947d, this.f16949f, null);
        }
        if (i10 == -1) {
            return null;
        }
        return context.getDrawable(this.f16949f);
    }

    public CharSequence f(Context context) {
        return k(context, this.f16947d, this.f16948e, this.f16944a);
    }

    public String g() {
        return null;
    }

    public List<String> h() {
        return new ArrayList();
    }

    public String i() {
        return null;
    }

    public com.android.contacts.model.c j(String str) {
        return this.f16952i.get(str);
    }

    public CopyOnWriteArrayList<com.android.contacts.model.c> l() {
        Collections.sort(this.f16951h, f16943j);
        return this.f16951h;
    }

    public String m() {
        return null;
    }

    public boolean n() {
        return true;
    }

    public boolean o() {
        return false;
    }

    public abstract boolean p();

    public final boolean q() {
        return this.f16950g;
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public String f16953a;

        /* renamed from: b, reason: collision with root package name */
        public int f16954b;

        /* renamed from: c, reason: collision with root package name */
        public int f16955c;

        /* renamed from: d, reason: collision with root package name */
        public int f16956d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f16957e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f16958f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f16959g;

        public b(String str, int i10) {
            this.f16953a = str;
            this.f16954b = i10;
        }

        public b a(boolean z10) {
            this.f16959g = z10;
            return this;
        }

        public b b(boolean z10) {
            this.f16957e = z10;
            return this;
        }

        public b c(boolean z10) {
            this.f16958f = z10;
            return this;
        }

        public String toString() {
            return b.class.getSimpleName() + ": column=" + this.f16953a + " titleRes=" + this.f16954b + " inputType=" + this.f16955c + " minLines=" + this.f16956d + " optional=" + this.f16957e + " shortForm=" + this.f16958f + " longForm=" + this.f16959g;
        }

        public b(String str, int i10, int i11) {
            this(str, i10);
            this.f16955c = i11;
        }
    }
}
