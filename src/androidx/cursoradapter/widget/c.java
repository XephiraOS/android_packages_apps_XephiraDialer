package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ResourceCursorAdapter.java */
/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: a, reason: collision with root package name */
    public int f9575a;

    /* renamed from: b, reason: collision with root package name */
    public int f9576b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f9577c;

    @Deprecated
    public c(Context context, int i10, Cursor cursor, boolean z10) {
        super(context, cursor, z10);
        this.f9576b = i10;
        this.f9575a = i10;
        this.f9577c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.a
    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f9577c.inflate(this.f9576b, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.a
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f9577c.inflate(this.f9575a, viewGroup, false);
    }
}
