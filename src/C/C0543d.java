package c;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: ActivityResultContracts.kt */
/* renamed from: c.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0543d extends AbstractC0540a<Intent, ActivityResult> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f12678a = new a(null);

    /* compiled from: ActivityResultContracts.kt */
    /* renamed from: c.d$a */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @Override // c.AbstractC0540a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent input) {
        i.f(context, "context");
        i.f(input, "input");
        return input;
    }

    @Override // c.AbstractC0540a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ActivityResult c(int i10, Intent intent) {
        return new ActivityResult(i10, intent);
    }
}
