package i6;

import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: DefaultEffectiveNetworkFetcher.java */
/* renamed from: i6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1103b implements e {
    @Override // i6.e
    public c a(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new C1102a(httpURLConnection);
    }
}
