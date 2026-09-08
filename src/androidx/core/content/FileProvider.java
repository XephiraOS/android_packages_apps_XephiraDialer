package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.android.incallui.OplusPhoneCapabilities;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f9399e = {"_display_name", "_size"};

    /* renamed from: f, reason: collision with root package name */
    public static final File f9400f = new File("/");

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap<String, b> f9401g = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public final Object f9402a;

    /* renamed from: b, reason: collision with root package name */
    public String f9403b;

    /* renamed from: c, reason: collision with root package name */
    public b f9404c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9405d;

    /* loaded from: classes.dex */
    public static class a {
        public static File[] a(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        File a(Uri uri);

        Uri b(File file);
    }

    /* loaded from: classes.dex */
    public static class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public final String f9406a;

        /* renamed from: b, reason: collision with root package name */
        public final HashMap<String, File> f9407b = new HashMap<>();

        public c(String str) {
            this.f9406a = str;
        }

        @Override // androidx.core.content.FileProvider.b
        public File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f9407b.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (d(canonicalFile.getPath(), file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
                }
            }
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }

        @Override // androidx.core.content.FileProvider.b
        public Uri b(File file) {
            String substring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f9407b.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (d(canonicalPath, path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry != null) {
                    String path2 = entry.getValue().getPath();
                    if (path2.endsWith("/")) {
                        substring = canonicalPath.substring(path2.length());
                    } else {
                        substring = canonicalPath.substring(path2.length() + 1);
                    }
                    return new Uri.Builder().scheme("content").authority(this.f9406a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        public void c(String str, File file) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f9407b.put(str, file.getCanonicalFile());
                    return;
                } catch (IOException e10) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e10);
                }
            }
            throw new IllegalArgumentException("Name must not be empty");
        }

        public final boolean d(String str, String str2) {
            String k10 = FileProvider.k(str);
            String k11 = FileProvider.k(str2);
            if (!k10.equals(k11)) {
                if (!k10.startsWith(k11 + '/')) {
                    return false;
                }
            }
            return true;
        }
    }

    public FileProvider() {
        this(0);
    }

    public static File b(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    public static Object[] c(Object[] objArr, int i10) {
        Object[] objArr2 = new Object[i10];
        System.arraycopy(objArr, 0, objArr2, 0, i10);
        return objArr2;
    }

    public static String[] d(String[] strArr, int i10) {
        String[] strArr2 = new String[i10];
        System.arraycopy(strArr, 0, strArr2, 0, i10);
        return strArr2;
    }

    public static XmlResourceParser e(Context context, String str, ProviderInfo providerInfo, int i10) {
        if (providerInfo != null) {
            if (providerInfo.metaData == null && i10 != 0) {
                Bundle bundle = new Bundle(1);
                providerInfo.metaData = bundle;
                bundle.putInt("android.support.FILE_PROVIDER_PATHS", i10);
            }
            XmlResourceParser loadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
            if (loadXmlMetaData != null) {
                return loadXmlMetaData;
            }
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
    }

    public static b g(Context context, String str, int i10) {
        b bVar;
        HashMap<String, b> hashMap = f9401g;
        synchronized (hashMap) {
            try {
                bVar = hashMap.get(str);
                if (bVar == null) {
                    try {
                        try {
                            bVar = j(context, str, i10);
                            hashMap.put(str, bVar);
                        } catch (IOException e10) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e10);
                        }
                    } catch (XmlPullParserException e11) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e11);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public static Uri h(Context context, String str, File file) {
        return g(context, str, 0).b(file);
    }

    public static int i(String str) {
        if ("r".equals(str)) {
            return OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE;
        }
        if (!"w".equals(str) && !"wt".equals(str)) {
            if ("wa".equals(str)) {
                return 704643072;
            }
            if ("rw".equals(str)) {
                return 939524096;
            }
            if ("rwt".equals(str)) {
                return 1006632960;
            }
            throw new IllegalArgumentException("Invalid mode: " + str);
        }
        return 738197504;
    }

    public static b j(Context context, String str, int i10) {
        c cVar = new c(str);
        XmlResourceParser e10 = e(context, str, context.getPackageManager().resolveContentProvider(str, 128), i10);
        while (true) {
            int next = e10.next();
            if (next != 1) {
                if (next == 2) {
                    String name = e10.getName();
                    File file = null;
                    String attributeValue = e10.getAttributeValue(null, "name");
                    String attributeValue2 = e10.getAttributeValue(null, Constants.MessagerConstants.PATH_KEY);
                    if ("root-path".equals(name)) {
                        file = f9400f;
                    } else if ("files-path".equals(name)) {
                        file = context.getFilesDir();
                    } else if ("cache-path".equals(name)) {
                        file = context.getCacheDir();
                    } else if ("external-path".equals(name)) {
                        file = Environment.getExternalStorageDirectory();
                    } else if ("external-files-path".equals(name)) {
                        File[] g10 = androidx.core.content.b.g(context, null);
                        if (g10.length > 0) {
                            file = g10[0];
                        }
                    } else if ("external-cache-path".equals(name)) {
                        File[] f10 = androidx.core.content.b.f(context);
                        if (f10.length > 0) {
                            file = f10[0];
                        }
                    } else if ("external-media-path".equals(name)) {
                        File[] a10 = a.a(context);
                        if (a10.length > 0) {
                            file = a10[0];
                        }
                    }
                    if (file != null) {
                        cVar.c(attributeValue, b(file, attributeValue2));
                    }
                }
            } else {
                return cVar;
            }
        }
    }

    public static String k(String str) {
        if (str.length() > 0 && str.charAt(str.length() - 1) == '/') {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (!providerInfo.exported) {
            if (providerInfo.grantUriPermissions) {
                String str = providerInfo.authority.split(Constants.DataMigration.SPLIT_TAG)[0];
                synchronized (this.f9402a) {
                    this.f9403b = str;
                }
                HashMap<String, b> hashMap = f9401g;
                synchronized (hashMap) {
                    hashMap.remove(str);
                }
                return;
            }
            throw new SecurityException("Provider must grant uri permissions");
        }
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return f().a(uri).delete() ? 1 : 0;
    }

    public final b f() {
        b bVar;
        synchronized (this.f9402a) {
            try {
                I.c.c(this.f9403b, "mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
                if (this.f9404c == null) {
                    this.f9404c = g(getContext(), this.f9403b, this.f9405d);
                }
                bVar = this.f9404c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File a10 = f().a(uri);
        int lastIndexOf = a10.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a10.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
            return "application/octet-stream";
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public String getTypeAnonymous(Uri uri) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(f().a(uri), i(str));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i10;
        String str3;
        File a10 = f().a(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = f9399e;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i11 = 0;
        for (String str4 : strArr) {
            if ("_display_name".equals(str4)) {
                strArr3[i11] = "_display_name";
                i10 = i11 + 1;
                if (queryParameter == null) {
                    str3 = a10.getName();
                } else {
                    str3 = queryParameter;
                }
                objArr[i11] = str3;
            } else if ("_size".equals(str4)) {
                strArr3[i11] = "_size";
                i10 = i11 + 1;
                objArr[i11] = Long.valueOf(a10.length());
            }
            i11 = i10;
        }
        String[] d10 = d(strArr3, i11);
        Object[] c10 = c(objArr, i11);
        MatrixCursor matrixCursor = new MatrixCursor(d10, 1);
        matrixCursor.addRow(c10);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public FileProvider(int i10) {
        this.f9402a = new Object();
        this.f9405d = i10;
    }
}
