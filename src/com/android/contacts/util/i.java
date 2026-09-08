package com.android.contacts.util;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.h0;
import com.oplus.dialer.R;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import r0.C1501d;

/* compiled from: ContactPhotoUtils.java */
/* loaded from: classes.dex */
public class i {

    /* compiled from: ContactPhotoUtils.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f17568a = false;

        /* renamed from: b, reason: collision with root package name */
        public Intent f17569b = null;

        /* renamed from: c, reason: collision with root package name */
        public ResolveInfo f17570c = null;

        /* renamed from: d, reason: collision with root package name */
        public Uri f17571d = null;
    }

    public static void a(Intent intent, int i10) {
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", i10);
        intent.putExtra("outputY", i10);
    }

    public static void b(Intent intent, Uri uri) {
        intent.putExtra("output", uri);
        intent.addFlags(3);
        intent.setClipData(ClipData.newRawUri("output", uri));
    }

    public static void c(Context context, boolean z10, androidx.activity.result.b<String> bVar, f1.c cVar) {
        if (context != null) {
            String str = C1501d.f36274c;
            if (com.android.contacts.framework.baseui.util.l.d(context, str)) {
                com.android.contacts.framework.baseui.util.l.f(context, str, null, 0);
                return;
            }
            try {
                if (w.k(context, "android.permission.CAMERA")) {
                    h0.y(context, "camera", z10);
                    cVar.onGranted();
                } else {
                    bVar.a("android.permission.CAMERA");
                }
            } catch (ActivityNotFoundException e10) {
                H7.b.c("ContactPhotoUtils", "" + e10);
                com.oplus.foundation.util.ui.c.c(context, context.getString(R.string.activity_not_found));
            }
        }
    }

    public static byte[] d(Bitmap bitmap) {
        return I7.a.a(bitmap, 819200);
    }

    public static byte[] e(Bitmap bitmap, float f10, float f11) {
        float f12;
        int i10;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i11 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
        options.inJustDecodeBounds = false;
        int i12 = options.outWidth;
        int i13 = options.outHeight;
        if (i12 >= i13) {
            float f13 = i12;
            if (f13 > f10) {
                f12 = f13 / f10;
                i10 = (int) f12;
            }
            i10 = 1;
        } else {
            float f14 = i13;
            if (f14 > f11) {
                f12 = f14 / f11;
                i10 = (int) f12;
            }
            i10 = 1;
        }
        if (i10 > 1) {
            i11 = i10;
        }
        options.inSampleSize = i11;
        Bitmap decodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, options);
        if (decodeStream == null) {
            return null;
        }
        return d(decodeStream);
    }

    public static Uri f(Context context) {
        return FileProvider.h(context, "com.oplus.dialer.files", new File(t(context, "ContactPhoto-" + System.currentTimeMillis() + ".jpg")));
    }

    public static Uri g(Context context) {
        return FileProvider.h(context, "com.oplus.dialer.files", new File(t(context, h())));
    }

    public static String h() {
        Date date = new Date(System.currentTimeMillis());
        return "ContactPhoto-" + new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss", Locale.US).format(date) + "-cropped.jpg";
    }

    public static Uri i(Context context) {
        return FileProvider.h(context, "com.oplus.dialer.files", new File(t(context, k())));
    }

    public static Uri j(Context context) {
        return FileProvider.h(context, "com.oplus.dialer.files", new File(t(context, "ContactPhoto-" + System.currentTimeMillis() + "-omoji.png")));
    }

    public static String k() {
        Date date = new Date(System.currentTimeMillis());
        return "ContactPhoto-" + new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss", Locale.US).format(date) + ".jpg";
    }

    public static Intent l(Uri uri, Uri uri2) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        b(intent, uri2);
        a(intent, 650);
        return intent;
    }

    public static Intent m() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        return intent;
    }

    public static Intent n(Context context, Uri uri) {
        Intent o10 = o(context, uri);
        if (P7.c.b(o10, context, true) != null) {
            return o10;
        }
        return m();
    }

    public static Intent o(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
        intent.setType("image/*");
        intent.putExtra("open_from_dialog", true);
        b(intent, uri);
        if (P7.c.f(context, C0811w.c(context), false)) {
            intent.setPackage(C0811w.c(context));
        }
        return intent;
    }

    public static Intent p(Uri uri) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE", (Uri) null);
        b(intent, uri);
        return intent;
    }

    public static void q(Context context, Intent intent, Uri uri) {
        if (intent != null && intent.getData() != null) {
            u(context, intent.getData(), uri, false);
        }
    }

    public static a r(Context context, Intent intent, int i10, Uri uri, Uri uri2) {
        Uri uri3;
        boolean z10;
        a aVar = new a();
        if (i10 != -1) {
            h0.X(context);
            aVar.f17568a = true;
            return aVar;
        }
        if (intent != null && intent.getData() != null) {
            uri3 = intent.getData();
            z10 = false;
        } else {
            uri3 = uri;
            z10 = true;
        }
        if (z10) {
            uri = uri3;
        } else {
            try {
                if (!u(context, uri3, uri, false)) {
                    aVar.f17568a = true;
                    return aVar;
                }
            } catch (SecurityException unused) {
                if (Log.isLoggable("ContactPhotoUtils", 3)) {
                    H7.b.b("ContactPhotoUtils", "Did not have read-access to uri : " + uri3);
                }
                aVar.f17568a = true;
                return aVar;
            }
        }
        Intent l10 = l(uri, uri2);
        ResolveInfo b10 = P7.c.b(l10, context, false);
        if (b10 != null) {
            l10.setPackage(b10.activityInfo.packageName);
            aVar.f17570c = b10;
            aVar.f17571d = uri2;
            aVar.f17569b = l10;
        } else {
            aVar.f17571d = uri;
        }
        return aVar;
    }

    public static boolean s(Uri uri) {
        if ("file".equals(uri.getScheme())) {
            try {
                return !new File(uri.getPath()).getCanonicalFile().getCanonicalPath().startsWith("/storage/");
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public static String t(Context context, String str) {
        File cacheDir = context.getCacheDir();
        cacheDir.mkdirs();
        return new File(cacheDir, str).getAbsolutePath();
    }

    public static boolean u(Context context, Uri uri, Uri uri2, boolean z10) {
        if (uri == null || uri2 == null || s(uri)) {
            return false;
        }
        try {
            try {
                FileOutputStream createOutputStream = context.getContentResolver().openAssetFileDescriptor(uri2, "rw").createOutputStream();
                try {
                    InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                    try {
                        byte[] bArr = new byte[16384];
                        int i10 = 0;
                        while (true) {
                            int read = openInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            createOutputStream.write(bArr, 0, read);
                            i10 += read;
                        }
                        if (Log.isLoggable("ContactPhotoUtils", 2)) {
                            H7.b.h("ContactPhotoUtils", "Wrote " + i10 + " bytes for photo " + uri.toString());
                        }
                        openInputStream.close();
                        if (createOutputStream != null) {
                            createOutputStream.close();
                        }
                        if (z10) {
                            context.getContentResolver().delete(uri, null, null);
                            return true;
                        }
                        return true;
                    } finally {
                    }
                } catch (Throwable th) {
                    if (createOutputStream != null) {
                        try {
                            createOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException | IllegalStateException | NullPointerException | SecurityException e10) {
                H7.b.c("ContactPhotoUtils", "Failed to write photo: " + uri.toString() + " because: " + e10);
                if (z10) {
                    context.getContentResolver().delete(uri, null, null);
                }
                return false;
            }
        } catch (Throwable th3) {
            if (z10) {
                context.getContentResolver().delete(uri, null, null);
            }
            throw th3;
        }
    }
}
