package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.android.incallui.OplusPhoneCapabilities;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder.java */
/* loaded from: classes.dex */
public final class n implements Iterable<Intent> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<Intent> f9393a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final Context f9394b;

    /* compiled from: TaskStackBuilder.java */
    /* loaded from: classes.dex */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    public n(Context context) {
        this.f9394b = context;
    }

    public static n g(Context context) {
        return new n(context);
    }

    public n a(Intent intent) {
        this.f9393a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n c(Activity activity) {
        Intent intent;
        if (activity instanceof a) {
            intent = ((a) activity).getSupportParentActivityIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = g.a(activity);
        }
        if (intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                component = intent.resolveActivity(this.f9394b.getPackageManager());
            }
            e(component);
            a(intent);
        }
        return this;
    }

    public n e(ComponentName componentName) {
        int size = this.f9393a.size();
        try {
            Intent b10 = g.b(this.f9394b, componentName);
            while (b10 != null) {
                this.f9393a.add(size, b10);
                b10 = g.b(this.f9394b, b10.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e10);
        }
    }

    public void h() {
        i(null);
    }

    public void i(Bundle bundle) {
        if (!this.f9393a.isEmpty()) {
            Intent[] intentArr = (Intent[]) this.f9393a.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!androidx.core.content.b.j(this.f9394b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
                this.f9394b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f9393a.iterator();
    }
}
