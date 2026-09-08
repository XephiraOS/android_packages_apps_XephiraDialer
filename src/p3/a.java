package P3;

import android.content.Context;
import android.database.Cursor;
import android.database.MergeCursor;
import android.net.Uri;

/* compiled from: ContactsCursorLoader.java */
/* loaded from: classes3.dex */
public class a extends W.b {

    /* renamed from: x, reason: collision with root package name */
    public boolean f2885x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f2886y;

    public a(Context context) {
        super(context);
        this.f2885x = false;
        this.f2886y = false;
    }

    @Override // W.b, W.a
    /* renamed from: N */
    public Cursor I() {
        try {
            return super.I();
        } catch (Exception e10) {
            MergeCursor mergeCursor = new MergeCursor(new Cursor[1]);
            H7.b.c("ContactsLoader", "ContactsLoader loadInBackground error " + e10);
            return mergeCursor;
        }
    }

    public boolean U() {
        return this.f2886y;
    }

    public void V(boolean z10) {
        this.f2886y = z10;
    }

    public void W(boolean z10) {
        this.f2885x = z10;
    }

    @Override // W.c
    public void p() {
        if (this.f2885x) {
            H7.b.e("ContactsLoader", "---onContentChanged return---");
            V(true);
        } else {
            super.p();
        }
    }

    public a(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context, uri, strArr, str, strArr2, str2);
        this.f2885x = false;
        this.f2886y = false;
    }
}
