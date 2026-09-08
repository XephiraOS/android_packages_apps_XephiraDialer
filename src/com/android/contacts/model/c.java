package com.android.contacts.model;

import android.content.ContentValues;
import com.android.contacts.model.AccountType;
import com.google.common.collect.Iterators;
import com.oplus.dialer.R;
import java.text.SimpleDateFormat;
import java.util.List;

/* compiled from: DataKind.java */
/* loaded from: classes.dex */
public final class c implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final int f17002a;

    /* renamed from: b, reason: collision with root package name */
    public String f17003b;

    /* renamed from: c, reason: collision with root package name */
    public String f17004c;

    /* renamed from: d, reason: collision with root package name */
    public int f17005d;

    /* renamed from: e, reason: collision with root package name */
    public int f17006e;

    /* renamed from: f, reason: collision with root package name */
    public int f17007f;

    /* renamed from: g, reason: collision with root package name */
    public int f17008g;

    /* renamed from: h, reason: collision with root package name */
    public int f17009h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f17010i;

    /* renamed from: j, reason: collision with root package name */
    public AccountType.e f17011j;

    /* renamed from: k, reason: collision with root package name */
    public AccountType.e f17012k;

    /* renamed from: l, reason: collision with root package name */
    public AccountType.e f17013l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f17014m;

    /* renamed from: n, reason: collision with root package name */
    public String f17015n;

    /* renamed from: o, reason: collision with root package name */
    public int f17016o;

    /* renamed from: p, reason: collision with root package name */
    public List<AccountType.c> f17017p;

    /* renamed from: q, reason: collision with root package name */
    public List<AccountType.b> f17018q;

    /* renamed from: r, reason: collision with root package name */
    public ContentValues f17019r;

    /* renamed from: x, reason: collision with root package name */
    public SimpleDateFormat f17020x;

    /* renamed from: y, reason: collision with root package name */
    public SimpleDateFormat f17021y;

    public c() {
        this.f17014m = false;
        this.f17002a = R.layout.text_fields_editor_view;
    }

    public static String b(Iterable<?> iterable) {
        if (iterable == null) {
            return "(null)";
        }
        return Iterators.k(iterable.iterator());
    }

    public static String c(SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat == null) {
            return "(null)";
        }
        return simpleDateFormat.toPattern();
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public String toString() {
        return "DataKind: resPackageName=" + this.f17003b + " mimeType=" + this.f17004c + " titleRes=" + this.f17005d + " iconAltRes=" + this.f17007f + " iconAltDescriptionRes=" + this.f17008g + " weight=" + this.f17009h + " editable=" + this.f17010i + " actionHeader=" + this.f17011j + " actionAltHeader=" + this.f17012k + " actionBody=" + this.f17013l + " actionBodySocial=" + this.f17014m + " typeColumn=" + this.f17015n + " typeOverallMax=" + this.f17016o + " typeList=" + b(this.f17017p) + " fieldList=" + b(this.f17018q) + " defaultValues=" + this.f17019r + " editorLayoutResourceId=" + this.f17002a + " dateFormatWithoutYear=" + c(this.f17020x) + " dateFormatWithYear=" + c(this.f17021y);
    }

    public c(String str, int i10, int i11, boolean z10, int i12, int i13) {
        this.f17014m = false;
        this.f17004c = str;
        this.f17005d = i10;
        this.f17009h = i11;
        this.f17010i = z10;
        this.f17016o = -1;
        this.f17002a = i12;
        this.f17006e = i13;
    }
}
