package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.service.media.MediaBrowserService;
import androidx.media.b;

/* compiled from: MediaBrowserServiceCompatApi23.java */
/* loaded from: classes.dex */
public class c extends b.C0130b {
    public c(Context context, d dVar) {
        super(context, dVar);
    }

    @Override // android.service.media.MediaBrowserService
    public void onLoadItem(String str, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
        ((d) this.f10525a).b(str, new b.c<>(result));
    }
}
