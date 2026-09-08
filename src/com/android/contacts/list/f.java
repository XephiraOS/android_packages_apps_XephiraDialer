package com.android.contacts.list;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.text.TextPaint;
import android.text.TextUtils;
import com.oplus.dialer.R;
import org.opencv.imgcodecs.Imgcodecs;

/* compiled from: ShortcutIntentBuilder.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f16917g = {"display_name", "photo_id"};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f16918h = {"display_name", "photo_id", "data1", "data2", "data3"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f16919i = {"data15"};

    /* renamed from: a, reason: collision with root package name */
    public final c f16920a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f16921b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16922c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16923d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16924e;

    /* renamed from: f, reason: collision with root package name */
    public int f16925f;

    /* compiled from: ShortcutIntentBuilder.java */
    /* loaded from: classes.dex */
    public final class a extends b {
        public a(Uri uri) {
            super(uri);
        }

        @Override // com.android.contacts.list.f.b
        public void b() {
            Cursor cursor = null;
            try {
                try {
                    cursor = f.this.f16921b.getContentResolver().query(this.f16927a, f.f16917g, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        this.f16929c = cursor.getString(0);
                        this.f16931e = cursor.getLong(1);
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception e10) {
                    H7.b.c("ShortcutIntentBuilder", "Exception e: " + e10);
                    if (cursor == null) {
                        return;
                    }
                }
                cursor.close();
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r42) {
            f.this.h(this.f16927a, this.f16928b, this.f16929c, this.f16930d);
        }
    }

    /* compiled from: ShortcutIntentBuilder.java */
    /* loaded from: classes.dex */
    public abstract class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public Uri f16927a;

        /* renamed from: b, reason: collision with root package name */
        public String f16928b;

        /* renamed from: c, reason: collision with root package name */
        public String f16929c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f16930d;

        /* renamed from: e, reason: collision with root package name */
        public long f16931e;

        public b(Uri uri) {
            this.f16927a = uri;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            this.f16928b = f.this.f16921b.getContentResolver().getType(this.f16927a);
            b();
            c();
            return null;
        }

        public abstract void b();

        public final void c() {
            if (this.f16931e == 0) {
                return;
            }
            Cursor cursor = null;
            try {
                try {
                    cursor = f.this.f16921b.getContentResolver().query(ContactsContract.Data.CONTENT_URI, f.f16919i, "_id=?", new String[]{String.valueOf(this.f16931e)}, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        this.f16930d = cursor.getBlob(0);
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception e10) {
                    H7.b.c("ShortcutIntentBuilder", "Exception e: " + e10);
                    if (cursor == null) {
                        return;
                    }
                }
                cursor.close();
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    /* compiled from: ShortcutIntentBuilder.java */
    /* loaded from: classes.dex */
    public interface c {
        void D(Uri uri, Intent intent);
    }

    /* compiled from: ShortcutIntentBuilder.java */
    /* loaded from: classes.dex */
    public final class d extends b {

        /* renamed from: g, reason: collision with root package name */
        public final String f16933g;

        /* renamed from: h, reason: collision with root package name */
        public String f16934h;

        /* renamed from: i, reason: collision with root package name */
        public int f16935i;

        /* renamed from: j, reason: collision with root package name */
        public String f16936j;

        public d(Uri uri, String str) {
            super(uri);
            this.f16933g = str;
        }

        @Override // com.android.contacts.list.f.b
        public void b() {
            Cursor cursor = null;
            try {
                try {
                    cursor = f.this.f16921b.getContentResolver().query(this.f16927a, f.f16918h, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        this.f16929c = cursor.getString(0);
                        this.f16931e = cursor.getLong(1);
                        this.f16934h = cursor.getString(2);
                        this.f16935i = cursor.getInt(3);
                        this.f16936j = cursor.getString(4);
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception e10) {
                    H7.b.c("ShortcutIntentBuilder", "Exception e: " + e10);
                    if (cursor == null) {
                        return;
                    }
                }
                cursor.close();
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r92) {
            f.this.j(this.f16927a, this.f16929c, this.f16930d, this.f16934h, this.f16935i, this.f16936j, this.f16933g);
        }
    }

    public f(Context context, c cVar) {
        this.f16921b = context;
        this.f16920a = cVar;
        Resources resources = context.getResources();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.f16925f = 0;
        this.f16925f = activityManager.getLauncherLargeIconSize();
        this.f16922c = activityManager.getLauncherLargeIconDensity();
        this.f16923d = resources.getDimensionPixelOffset(R.dimen.DP_1);
        this.f16924e = context.getColor(android.R.color.darker_gray);
    }

    public void g(Uri uri) {
        new a(uri).execute(new Void[0]);
    }

    public final void h(Uri uri, String str, String str2, byte[] bArr) {
        Bitmap n10 = n(bArr);
        Intent intent = new Intent("android.provider.action.QUICK_CONTACT");
        intent.addFlags(268468224);
        intent.putExtra("com.android.launcher.intent.extra.shortcut.INGORE_LAUNCH_ANIMATION", true);
        intent.setDataAndType(uri, str);
        intent.putExtra("android.provider.extra.MODE", 3);
        intent.putExtra("android.provider.extra.EXCLUDE_MIMES", (String[]) null);
        Bitmap m10 = m(n10);
        Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.ICON", m10);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        if (TextUtils.isEmpty(str2)) {
            intent2.putExtra("android.intent.extra.shortcut.NAME", this.f16921b.getResources().getString(R.string.missing_name));
        } else {
            intent2.putExtra("android.intent.extra.shortcut.NAME", str2);
        }
        this.f16920a.D(uri, intent2);
    }

    public void i(Uri uri, String str) {
        new d(uri, str).execute(new Void[0]);
    }

    public final void j(Uri uri, String str, byte[] bArr, String str2, int i10, String str3, String str4) {
        Uri fromParts;
        Bitmap l10;
        Bitmap n10 = n(bArr);
        if ("android.intent.action.CALL".equals(str4)) {
            fromParts = Uri.fromParts("tel", str2, null);
            l10 = l(n10, i10, str3, R.drawable.pb_ic_call);
        } else {
            fromParts = Uri.fromParts("smsto", str2, null);
            l10 = l(n10, i10, str3, R.drawable.pb_ic_menu_sms);
        }
        Intent intent = new Intent(str4, fromParts);
        intent.setFlags(67108864);
        Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.ICON", l10);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        this.f16920a.D(uri, intent2);
    }

    public final void k(Canvas canvas, Rect rect) {
        Paint paint = new Paint();
        paint.setColor(this.f16924e);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f16923d * 2);
        canvas.drawRect(rect, paint);
    }

    public final Bitmap l(Bitmap bitmap, int i10, String str, int i11) {
        int i12;
        Paint paint;
        Rect rect;
        Resources resources = this.f16921b.getResources();
        float f10 = resources.getDisplayMetrics().density;
        Drawable drawableForDensity = resources.getDrawableForDensity(i11, this.f16922c, null);
        Bitmap c10 = I7.a.c(drawableForDensity, drawableForDensity.getIntrinsicHeight());
        int i13 = this.f16925f;
        Bitmap createBitmap = Bitmap.createBitmap(i13, i13, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint2 = new Paint();
        paint2.setDither(true);
        paint2.setFilterBitmap(true);
        Rect rect2 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i14 = this.f16925f;
        Rect rect3 = new Rect(0, 0, i14, i14);
        canvas.drawBitmap(bitmap, rect2, rect3, paint2);
        k(canvas, rect3);
        CharSequence typeLabel = ContactsContract.CommonDataKinds.Phone.getTypeLabel(resources, i10, str);
        if (typeLabel != null) {
            TextPaint textPaint = new TextPaint(Imgcodecs.IMWRITE_TIFF_XDPI);
            textPaint.setTextSize(resources.getDimension(R.dimen.DP_12));
            textPaint.setColor(this.f16921b.getColor(android.R.color.white));
            textPaint.setShadowLayer(4.0f, 0.0f, 2.0f, this.f16921b.getColor(android.R.color.black));
            Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
            Paint paint3 = new Paint();
            paint3.setColor(this.f16924e);
            paint3.setStyle(Paint.Style.FILL);
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.DP_1);
            int i15 = (fontMetricsInt.descent - fontMetricsInt.ascent) + (dimensionPixelOffset * 2);
            int i16 = this.f16923d;
            int i17 = this.f16925f;
            paint = paint2;
            rect3.set(i16, i17 - i15, i17 - i16, i17 - i16);
            canvas.drawRect(rect3, paint3);
            CharSequence ellipsize = TextUtils.ellipsize(typeLabel, textPaint, this.f16925f - (this.f16923d * 2.0f), TextUtils.TruncateAt.END);
            float measureText = textPaint.measureText(ellipsize, 0, ellipsize.length());
            int length = ellipsize.length();
            int i18 = this.f16925f;
            float f11 = (i18 - fontMetricsInt.descent) - dimensionPixelOffset;
            rect = rect3;
            i12 = 0;
            canvas.drawText(ellipsize, 0, length, (i18 - measureText) / 2.0f, f11, textPaint);
        } else {
            i12 = 0;
            paint = paint2;
            rect = rect3;
        }
        rect2.set(i12, i12, c10.getWidth(), c10.getHeight());
        int width = createBitmap.getWidth();
        rect.set(width - ((int) (20 * f10)), -1, width, (int) (19 * f10));
        int i19 = this.f16923d;
        rect.offset(-i19, i19);
        canvas.drawBitmap(c10, rect2, rect, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public final Bitmap m(Bitmap bitmap) {
        int i10 = this.f16925f;
        Bitmap createBitmap = Bitmap.createBitmap(i10, i10, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i11 = this.f16925f;
        Rect rect2 = new Rect(0, 0, i11, i11);
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        k(canvas, rect2);
        Drawable drawableForDensity = this.f16921b.getResources().getDrawableForDensity(R.drawable.pb_dr_quickcontact_badge_overlay_dark, this.f16922c);
        drawableForDensity.setBounds(rect2);
        drawableForDensity.draw(canvas);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public final Bitmap n(byte[] bArr) {
        if (bArr != null) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, null);
        }
        Drawable drawableForDensity = this.f16921b.getResources().getDrawableForDensity(R.drawable.pb_ic_default_photo, this.f16922c, null);
        return I7.a.c(drawableForDensity, drawableForDensity.getIntrinsicHeight());
    }
}
