package S3;

import R3.e;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.FileProvider;
import com.android.contacts.ContactLoader;
import com.android.contacts.framework.baseui.util.A;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.oplus.dialer.R;
import java.io.File;

/* compiled from: QrcodeShareManager.java */
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public String f3471a;

    /* renamed from: b, reason: collision with root package name */
    public Context f3472b;

    /* renamed from: c, reason: collision with root package name */
    public long f3473c;

    /* renamed from: d, reason: collision with root package name */
    public ContactLoader.Result f3474d;

    public n(long j10, Context context, ContactLoader.Result result) {
        this.f3473c = j10;
        this.f3472b = context;
        this.f3474d = result;
    }

    public static n a(long j10, Context context, ContactLoader.Result result) {
        return new n(j10, context, result);
    }

    public String b() {
        long j10 = this.f3473c;
        if (j10 == 0) {
            H7.b.b("QrcodeShareManager", "rawContactId is null");
            return null;
        }
        e.a aVar = new e.a(null, j10);
        R3.e eVar = new R3.e();
        eVar.b();
        ContactLoader.Result result = this.f3474d;
        if (result != null && result.g0()) {
            this.f3471a = eVar.d(ContactsContract.RawContactsEntity.PROFILE_CONTENT_URI, this.f3472b, aVar, this.f3474d);
        } else {
            this.f3471a = eVar.d(ContactsContract.RawContactsEntity.CONTENT_URI, this.f3472b, aVar, this.f3474d);
        }
        return this.f3471a;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.File c(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S3.n.c(android.content.Context):java.io.File");
    }

    public void d() {
        File c10 = c(this.f3472b);
        if (c10 == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("send_entrance", this.f3472b.getPackageName());
        Uri h10 = FileProvider.h(this.f3472b, "com.oplus.dialer.files", c10);
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", h10);
        try {
            this.f3472b.startActivity(Intent.createChooser(intent, this.f3472b.getText(R.string.share_via)));
            com.android.contacts.framework.api.infocollection.a.c();
        } catch (Exception e10) {
            H7.b.c("QrcodeShareManager", "e=" + e10);
        }
    }

    public boolean e() {
        String b10 = b();
        if (!TextUtils.isEmpty(b10) && !"MECARD:".equals(b10)) {
            return true;
        }
        return false;
    }

    public void f(Context context) {
        int i10;
        if (context == null) {
            return;
        }
        Bitmap a10 = l.a(context, b(), context.getResources().getDimensionPixelSize(R.dimen.DP_190), context.getColor(android.R.color.black));
        if (a10 == null) {
            com.oplus.foundation.util.ui.c.d(context, R.string.share_account_error);
            return;
        }
        A.a(context, 2000324, 200032401, null, false);
        ContactLoader.Result result = this.f3474d;
        if (result != null && result.g0()) {
            i10 = R.string.my_qr_code;
        } else {
            i10 = R.string.contact_quick_response_code;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.qrcode_share_item, (ViewGroup) null, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.qr_img);
        boolean e10 = com.android.contacts.framework.baseui.util.o.e(context);
        imageView.setImageBitmap(a10);
        if (e10) {
            imageView.setForceDarkAllowed(false);
        }
        new COUIAlertDialogBuilder(context).setTitle(i10).setView(inflate).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }
}
