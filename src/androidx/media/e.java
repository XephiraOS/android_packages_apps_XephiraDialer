package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MediaBrowserServiceCompatApi26.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static Field f10527a;

    /* compiled from: MediaBrowserServiceCompatApi26.java */
    /* loaded from: classes.dex */
    public static class a extends androidx.media.c {
        public a(Context context, c cVar) {
            super(context, cVar);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            ((c) this.f10525a).e(str, new b(result), bundle);
        }
    }

    /* compiled from: MediaBrowserServiceCompatApi26.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public MediaBrowserService.Result f10528a;

        public b(MediaBrowserService.Result result) {
            this.f10528a = result;
        }

        public List<MediaBrowser.MediaItem> a(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        public void b(List<Parcel> list, int i10) {
            try {
                e.f10527a.setInt(this.f10528a, i10);
            } catch (IllegalAccessException e10) {
                Log.w("MBSCompatApi26", e10);
            }
            this.f10528a.sendResult(a(list));
        }
    }

    /* compiled from: MediaBrowserServiceCompatApi26.java */
    /* loaded from: classes.dex */
    public interface c extends d {
        void e(String str, b bVar, Bundle bundle);
    }

    static {
        try {
            Field declaredField = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            f10527a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e10) {
            Log.w("MBSCompatApi26", e10);
        }
    }

    public static Object a(Context context, c cVar) {
        return new a(context, cVar);
    }
}
