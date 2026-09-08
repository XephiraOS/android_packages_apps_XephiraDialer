package A2;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.android.incallui.Log;
import com.android.incallui.OplusInCallApp;
import com.internal_dependency.InternalSdkDepends;

/* compiled from: KeyguardToast.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static volatile b f108c;

    /* renamed from: a, reason: collision with root package name */
    public Toast f109a = null;

    /* renamed from: b, reason: collision with root package name */
    public Context f110b = L1.c.b(OplusInCallApp.getAppContext(), 2010);

    public static b b() {
        if (f108c == null) {
            synchronized (b.class) {
                try {
                    if (f108c == null) {
                        f108c = new b();
                    }
                } finally {
                }
            }
        }
        return f108c;
    }

    public void a() {
        Toast toast = this.f109a;
        if (toast != null) {
            toast.cancel();
            this.f109a = null;
        }
    }

    public Toast c(int i10, int i11) {
        if (this.f110b == null) {
            this.f110b = OplusInCallApp.getAppContext();
        }
        return d(this.f110b.getString(i10), i11);
    }

    public Toast d(CharSequence charSequence, int i10) {
        LayoutInflater layoutInflater;
        int identifier;
        a();
        if (this.f110b != null && !TextUtils.isEmpty(charSequence)) {
            try {
                this.f109a = new Toast(this.f110b);
                layoutInflater = (LayoutInflater) this.f110b.getSystemService("layout_inflater");
                identifier = this.f110b.getResources().getIdentifier("transient_notification", "layout", "android");
            } catch (Exception e10) {
                Log.d("KeyguardToast", "new Toast catch error = " + e10.getMessage());
                this.f109a = null;
            }
            if (identifier > 0) {
                View inflate = layoutInflater.inflate(identifier, (ViewGroup) null);
                int identifier2 = this.f110b.getResources().getIdentifier("message", "id", "android");
                if (identifier2 > 0) {
                    TextView textView = (TextView) inflate.findViewById(identifier2);
                    textView.setText(charSequence);
                    textView.setGravity(17);
                    this.f109a.setView(inflate);
                    this.f109a.setDuration(i10);
                    InternalSdkDepends.getSInstance().setLayoutParamsForToast(this.f109a);
                    return this.f109a;
                }
            }
            this.f109a = Toast.makeText(this.f110b, charSequence, i10);
            InternalSdkDepends.getSInstance().setLayoutParamsForToast(this.f109a);
            return this.f109a;
        }
        Log.d("KeyguardToast", "makeText fail for context is null or text is empty!");
        return null;
    }
}
