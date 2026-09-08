package m1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.dialer.R;

/* compiled from: DirectoryListLoader.java */
/* loaded from: classes.dex */
public class C extends W.a<Cursor> {

    /* renamed from: t, reason: collision with root package name */
    public static final String[] f34820t = {BreenoCallContract.BaseColumns._ID, "directoryType", "displayName", "photoSupport"};

    /* renamed from: p, reason: collision with root package name */
    public final ContentObserver f34821p;

    /* renamed from: q, reason: collision with root package name */
    public int f34822q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f34823r;

    /* renamed from: s, reason: collision with root package name */
    public MatrixCursor f34824s;

    /* compiled from: DirectoryListLoader.java */
    /* loaded from: classes.dex */
    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            C.this.h();
        }
    }

    /* compiled from: DirectoryListLoader.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f34826a = ContactsContract.Directory.CONTENT_URI;

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f34827b = {BreenoCallContract.BaseColumns._ID, AFConstants.EXTRA_PACKAGE_NAME, "typeResourceId", "displayName", "photoSupport"};
    }

    public C(Context context) {
        super(context);
        this.f34821p = new a(new Handler());
    }

    public final Cursor L() {
        if (this.f34824s == null) {
            MatrixCursor matrixCursor = new MatrixCursor(f34820t);
            this.f34824s = matrixCursor;
            matrixCursor.addRow(new Object[]{0L, i().getString(R.string.contactsList), null, null});
            this.f34824s.addRow(new Object[]{1L, i().getString(R.string.local_invisible_directory), null, null});
        }
        return this.f34824s;
    }

    @Override // W.a
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public Cursor I() {
        String str;
        String str2;
        int i10 = this.f34822q;
        if (i10 == 0) {
            return L();
        }
        if (i10 != 1) {
            String str3 = " AND _id!=1";
            if (i10 != 2) {
                if (i10 == 3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("shortcutSupport IN (2, 1)");
                    if (this.f34823r) {
                        str3 = "";
                    }
                    sb.append(str3);
                    str = sb.toString();
                } else {
                    throw new RuntimeException("Unsupported directory search mode: " + this.f34822q);
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("shortcutSupport=2");
                if (this.f34823r) {
                    str3 = "";
                }
                sb2.append(str3);
                str = sb2.toString();
            }
        } else if (this.f34823r) {
            str = null;
        } else {
            str = "_id!=1";
        }
        String str4 = str;
        MatrixCursor matrixCursor = new MatrixCursor(f34820t);
        try {
            Cursor query = i().getContentResolver().query(b.f34826a, b.f34827b, str4, null, BreenoCallContract.BaseColumns._ID);
            if (query != null) {
                try {
                    PackageManager packageManager = i().getPackageManager();
                    while (query.moveToNext()) {
                        long j10 = query.getLong(0);
                        String string = query.getString(1);
                        int i11 = query.getInt(2);
                        if (!TextUtils.isEmpty(string) && i11 != 0) {
                            try {
                                str2 = packageManager.getResourcesForApplication(string).getString(i11);
                            } catch (Exception unused) {
                                H7.b.c("ContactEntryListAdapter", "Cannot obtain directory type from package: " + string);
                            }
                            matrixCursor.addRow(new Object[]{Long.valueOf(j10), str2, query.getString(3), Integer.valueOf(query.getInt(4))});
                        }
                        str2 = null;
                        matrixCursor.addRow(new Object[]{Long.valueOf(j10), str2, query.getString(3), Integer.valueOf(query.getInt(4))});
                    }
                } catch (Throwable th) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e10) {
            H7.b.c("ContactEntryListAdapter", "" + e10);
        }
        return matrixCursor;
    }

    public void N(int i10) {
        this.f34822q = i10;
    }

    public void O(boolean z10) {
        this.f34823r = z10;
    }

    @Override // W.c
    public void r() {
        z();
    }

    @Override // W.c
    public void s() {
        try {
            i().getContentResolver().registerContentObserver(ContactsContract.Directory.CONTENT_URI, false, this.f34821p);
            h();
        } catch (Exception e10) {
            H7.b.c("ContactEntryListAdapter", "onStartLoading: exception: " + e10);
        }
    }

    @Override // W.c
    public void t() {
        try {
            i().getContentResolver().unregisterContentObserver(this.f34821p);
        } catch (Exception e10) {
            H7.b.c("ContactEntryListAdapter", "unregisterContentObserver: " + e10);
        }
    }
}
