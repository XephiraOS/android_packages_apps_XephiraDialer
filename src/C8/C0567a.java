package c8;

import android.content.ContentResolver;
import android.database.sqlite.SQLiteException;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: AppFeatureUtils.kt */
/* renamed from: c8.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0567a extends AppFeatureProviderUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final C0155a f12862a = new C0155a(null);

    /* compiled from: AppFeatureUtils.kt */
    /* renamed from: c8.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0155a {
        public C0155a() {
        }

        public final String a(ContentResolver cr, String featureName, String defaultValue) {
            i.f(cr, "cr");
            i.f(featureName, "featureName");
            i.f(defaultValue, "defaultValue");
            try {
                String i10 = AppFeatureProviderUtils.i(cr, featureName, defaultValue);
                i.c(i10);
                return i10;
            } catch (SQLiteException unused) {
                return defaultValue;
            }
        }

        public final boolean b(ContentResolver cr, String featureName) {
            i.f(cr, "cr");
            i.f(featureName, "featureName");
            return AppFeatureProviderUtils.p(cr, featureName);
        }

        public /* synthetic */ C0155a(f fVar) {
            this();
        }
    }
}
