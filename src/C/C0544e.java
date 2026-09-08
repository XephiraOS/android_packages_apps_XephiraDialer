package c;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: ActivityResultContracts.kt */
/* renamed from: c.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0544e extends AbstractC0540a<IntentSenderRequest, ActivityResult> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f12679a = new a(null);

    /* compiled from: ActivityResultContracts.kt */
    /* renamed from: c.e$a */
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
    public Intent a(Context context, IntentSenderRequest input) {
        i.f(context, "context");
        i.f(input, "input");
        Intent putExtra = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", input);
        i.e(putExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
        return putExtra;
    }

    @Override // c.AbstractC0540a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ActivityResult c(int i10, Intent intent) {
        return new ActivityResult(i10, intent);
    }
}
