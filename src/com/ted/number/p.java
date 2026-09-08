package com.ted.number;

import android.os.Environment;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.coui.appcompat.snackbar.COUISnackBar;
import com.customize.contacts.util.C0792c;
import com.oplus.dialer.R;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.function.Consumer;

/* compiled from: DownloadSecretResultListener.kt */
/* loaded from: classes4.dex */
public final class p implements Consumer<String> {

    /* renamed from: c, reason: collision with root package name */
    public static final a f29686c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f29687a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<BasicActivity> f29688b;

    /* compiled from: DownloadSecretResultListener.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public p(BasicActivity activity, boolean z10) {
        kotlin.jvm.internal.i.f(activity, "activity");
        this.f29687a = z10;
        this.f29688b = new WeakReference<>(activity);
    }

    public static final void c(BasicActivity basicActivity, String str, View view) {
        DocumentHelper.f29569a.b(basicActivity, str);
    }

    @Override // java.util.function.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void accept(final String str) {
        final BasicActivity basicActivity = this.f29688b.get();
        if (basicActivity != null && C0792c.c(basicActivity)) {
            if (str == null) {
                com.oplus.foundation.util.ui.c.c(basicActivity, basicActivity.getString(R.string.fail_to_save_and_please_retry));
                return;
            }
            if (this.f29687a) {
                kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.f34245a;
                String string = basicActivity.getString(R.string.saved_to_device_storage);
                kotlin.jvm.internal.i.e(string, "activity.getString(R.str….saved_to_device_storage)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Environment.DIRECTORY_DOCUMENTS}, 1));
                kotlin.jvm.internal.i.e(format, "format(...)");
                com.oplus.foundation.util.ui.c.c(basicActivity, format);
                return;
            }
            CoordinatorLayout m02 = basicActivity.m0();
            if (m02 != null) {
                COUISnackBar make = COUISnackBar.make(m02, basicActivity.getString(R.string.saved_to_file_manager), 2000);
                kotlin.jvm.internal.i.e(make, "make(\n                  …IME\n                    )");
                make.setOnAction(R.string.to_view, new View.OnClickListener() { // from class: com.ted.number.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        p.c(BasicActivity.this, str, view);
                    }
                });
                make.show();
                return;
            }
            H7.b.c("DownloadSecretResultListener", "coordinatorLayout is null");
            return;
        }
        H7.b.i("DownloadSecretResultListener", "activity invalid ");
    }
}
