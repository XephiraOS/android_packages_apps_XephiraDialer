package G;

import G.g;
import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.coui.appcompat.lockview.COUINumericKeyboard;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import i0.C1089a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import p.C1422h;

/* compiled from: FontProvider.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final C1422h<c, ProviderInfo> f1039a = new C1422h<>(2);

    /* renamed from: b, reason: collision with root package name */
    public static final Comparator<byte[]> f1040b = new Comparator() { // from class: G.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int g10;
            g10 = d.g((byte[]) obj, (byte[]) obj2);
            return g10;
        }
    };

    /* compiled from: FontProvider.java */
    /* loaded from: classes.dex */
    public interface a {
        static a a(Context context, Uri uri) {
            return new b(context, uri);
        }

        Cursor b(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        void close();
    }

    /* compiled from: FontProvider.java */
    /* loaded from: classes.dex */
    public static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        public final ContentProviderClient f1041a;

        public b(Context context, Uri uri) {
            this.f1041a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // G.d.a
        public Cursor b(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f1041a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e10) {
                Log.w("FontsProvider", "Unable to query the content provider", e10);
                return null;
            }
        }

        @Override // G.d.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f1041a;
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
        }
    }

    /* compiled from: FontProvider.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f1042a;

        /* renamed from: b, reason: collision with root package name */
        public String f1043b;

        /* renamed from: c, reason: collision with root package name */
        public List<List<byte[]>> f1044c;

        public c(String str, String str2, List<List<byte[]>> list) {
            this.f1042a = str;
            this.f1043b = str2;
            this.f1044c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (Objects.equals(this.f1042a, cVar.f1042a) && Objects.equals(this.f1043b, cVar.f1043b) && Objects.equals(this.f1044c, cVar.f1044c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.f1042a, this.f1043b, this.f1044c);
        }
    }

    public static List<byte[]> b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    public static boolean c(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!Arrays.equals(list.get(i10), list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public static List<List<byte[]>> d(e eVar, Resources resources) {
        if (eVar.b() != null) {
            return eVar.b();
        }
        return A.e.c(resources, eVar.c());
    }

    public static g.a e(Context context, List<e> list, CancellationSignal cancellationSignal) {
        C1089a.a("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                e eVar = list.get(i10);
                ProviderInfo f10 = f(context.getPackageManager(), eVar, context.getResources());
                if (f10 == null) {
                    return g.a.b(1, null);
                }
                arrayList.add(h(context, eVar, f10.authority, cancellationSignal));
            }
            return g.a.a(0, arrayList);
        } finally {
            C1089a.b();
        }
    }

    public static ProviderInfo f(PackageManager packageManager, e eVar, Resources resources) {
        C1089a.a("FontProvider.getProvider");
        try {
            List<List<byte[]>> d10 = d(eVar, resources);
            c cVar = new c(eVar.e(), eVar.f(), d10);
            ProviderInfo providerInfo = f1039a.get(cVar);
            if (providerInfo != null) {
                return providerInfo;
            }
            String e10 = eVar.e();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(e10, 0);
            if (resolveContentProvider != null) {
                if (resolveContentProvider.packageName.equals(eVar.f())) {
                    List<byte[]> b10 = b(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                    Collections.sort(b10, f1040b);
                    for (int i10 = 0; i10 < d10.size(); i10++) {
                        ArrayList arrayList = new ArrayList(d10.get(i10));
                        Collections.sort(arrayList, f1040b);
                        if (c(b10, arrayList)) {
                            f1039a.put(cVar, resolveContentProvider);
                            return resolveContentProvider;
                        }
                    }
                    C1089a.b();
                    return null;
                }
                throw new PackageManager.NameNotFoundException("Found content provider " + e10 + ", but package was not " + eVar.f());
            }
            throw new PackageManager.NameNotFoundException("No package found for authority: " + e10);
        } finally {
            C1089a.b();
        }
    }

    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            byte b11 = bArr2[i10];
            if (b10 != b11) {
                return b10 - b11;
            }
        }
        return 0;
    }

    public static g.b[] h(Context context, e eVar, String str, CancellationSignal cancellationSignal) {
        int i10;
        int i11;
        ArrayList arrayList;
        Uri withAppendedId;
        int i12;
        boolean z10;
        C1089a.a("FontProvider.query");
        try {
            ArrayList arrayList2 = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            a a10 = a.a(context, build);
            Cursor cursor = null;
            try {
                String[] strArr = {BreenoCallContract.BaseColumns._ID, "file_id", "font_ttc_index", COUINumericKeyboard.FONT_VARIATION_SETTINGS, "font_weight", "font_italic", "result_code"};
                C1089a.a("ContentQueryWrapper.query");
                try {
                    cursor = a10.b(build, strArr, "query = ?", new String[]{eVar.g()}, null, cancellationSignal);
                    C1089a.b();
                    if (cursor != null && cursor.getCount() > 0) {
                        int columnIndex = cursor.getColumnIndex("result_code");
                        ArrayList arrayList3 = new ArrayList();
                        int columnIndex2 = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
                        int columnIndex3 = cursor.getColumnIndex("file_id");
                        int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursor.getColumnIndex("font_weight");
                        int columnIndex6 = cursor.getColumnIndex("font_italic");
                        while (cursor.moveToNext()) {
                            if (columnIndex != -1) {
                                i10 = cursor.getInt(columnIndex);
                            } else {
                                i10 = 0;
                            }
                            if (columnIndex4 != -1) {
                                i11 = cursor.getInt(columnIndex4);
                            } else {
                                i11 = 0;
                            }
                            if (columnIndex3 == -1) {
                                arrayList = arrayList3;
                                withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                            } else {
                                arrayList = arrayList3;
                                withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                            }
                            if (columnIndex5 != -1) {
                                i12 = cursor.getInt(columnIndex5);
                            } else {
                                i12 = VibrateUtils.STRENGTH_OFFSET;
                            }
                            if (columnIndex6 != -1) {
                                z10 = true;
                                if (cursor.getInt(columnIndex6) == 1) {
                                    g.b a11 = g.b.a(withAppendedId, i11, i12, z10, i10);
                                    arrayList3 = arrayList;
                                    arrayList3.add(a11);
                                }
                            }
                            z10 = false;
                            g.b a112 = g.b.a(withAppendedId, i11, i12, z10, i10);
                            arrayList3 = arrayList;
                            arrayList3.add(a112);
                        }
                        arrayList2 = arrayList3;
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    a10.close();
                    return (g.b[]) arrayList2.toArray(new g.b[0]);
                } finally {
                    C1089a.b();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                a10.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
