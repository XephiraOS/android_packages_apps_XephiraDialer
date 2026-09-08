package w0;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.HashMap;

/* compiled from: ICustUst.kt */
/* loaded from: classes.dex */
public interface i {
    void A(Context context);

    HashMap<String, Boolean> B(Context context, String str);

    void C(Context context, String str, j<Void> jVar);

    void D(Context context, PhoneAccountHandle phoneAccountHandle, Bundle bundle);

    void E(Context context, ImageView imageView, long j10, Integer num);

    void F();

    void G(Context context);

    void H(Context context, String str, Uri uri);

    void I(String str, Context context, j<Boolean> jVar);

    boolean J(Intent intent, Context context, PhoneAccountHandle phoneAccountHandle);

    void K();

    boolean L(Bundle bundle);

    void a(HashMap<String, Boolean> hashMap, Context context, View view, ImageView imageView);

    Intent b(String str, String str2);

    void c(ImageView imageView, ImageView imageView2, int i10, boolean z10);

    void d();

    boolean e(String str);

    void f();

    boolean g(Context context, String str);

    void h(Context context, PhoneAccountHandle phoneAccountHandle, boolean z10);

    void i(Context context, PhoneAccountHandle phoneAccountHandle);

    void init(Context context);

    boolean j();

    boolean k(Context context);

    boolean l(Context context, ViewGroup viewGroup);

    BroadcastReceiver m();

    String n(Bundle bundle);

    void o(Context context);

    String p(Context context, String[] strArr);

    boolean q();

    void r(Activity activity, boolean z10, int i10);

    boolean s();

    void t(Context context, PhoneAccountHandle phoneAccountHandle, boolean z10, boolean z11);

    void u(HashMap<String, Boolean> hashMap, Context context, View view, ImageView imageView);

    boolean v(Context context, String str);

    boolean w(Context context, View view);

    boolean x(Context context, String str);

    String y(Context context);

    void z(Bundle bundle, j<Bitmap> jVar);
}
