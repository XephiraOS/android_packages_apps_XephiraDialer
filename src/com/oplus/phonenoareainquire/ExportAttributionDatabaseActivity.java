package com.oplus.phonenoareainquire;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.oplus.os.OplusUsbEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: classes3.dex */
public class ExportAttributionDatabaseActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f28786a = PhoneNumberAreaApplication.f28829a;

    /* renamed from: b, reason: collision with root package name */
    public static String f28787b;

    /* renamed from: c, reason: collision with root package name */
    public static String f28788c;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f28789a;

        public a(String str) {
            this.f28789a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ExportAttributionDatabaseActivity exportAttributionDatabaseActivity = ExportAttributionDatabaseActivity.this;
            boolean b10 = exportAttributionDatabaseActivity.b(this.f28789a, exportAttributionDatabaseActivity.c(), "inquirenoarea.db");
            ExportAttributionDatabaseActivity exportAttributionDatabaseActivity2 = ExportAttributionDatabaseActivity.this;
            boolean b11 = exportAttributionDatabaseActivity2.b(PhoneNoInquireProvider.f28792B, exportAttributionDatabaseActivity2.c(), "PhoneNumberData_3_1_0.dat");
            ExportAttributionDatabaseActivity exportAttributionDatabaseActivity3 = ExportAttributionDatabaseActivity.this;
            boolean b12 = exportAttributionDatabaseActivity3.b(PhoneNoInquireProvider.f28793C, exportAttributionDatabaseActivity3.c(), "ExtendNumber.dat");
            if (b10 && b11 && b12) {
                Toast.makeText(ExportAttributionDatabaseActivity.this, j.f28863c, 0).show();
            } else {
                Toast.makeText(ExportAttributionDatabaseActivity.this, j.f28862b, 0).show();
            }
        }
    }

    public static File d(Context context) {
        f(context);
        if (f28788c == null) {
            return null;
        }
        return new File(f28788c);
    }

    public static File e(Context context) {
        f(context);
        if (f28787b == null) {
            return null;
        }
        return new File(f28787b);
    }

    public boolean b(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            if (new File(str).exists()) {
                FileInputStream fileInputStream = new FileInputStream(str);
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str2 + "/" + str3));
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        fileInputStream.close();
                        return true;
                    }
                }
            } else {
                if (!f28786a) {
                    return false;
                }
                Log.d("ExportDbActivity", "exists");
                return false;
            }
        } catch (Exception e10) {
            Log.e("ExportDbActivity", "Exception: " + e10);
            return false;
        }
    }

    public final String c() {
        File d10;
        String str = null;
        if ("mounted".equals(OplusUsbEnvironment.getInternalSdState(this))) {
            File e10 = e(this);
            if (e10 != null) {
                str = e10.toString() + "/Attribution";
            }
        } else if ("mounted".equals(OplusUsbEnvironment.getExternalSdState(this)) && (d10 = d(this)) != null) {
            str = d10.toString() + "/Attribution";
        }
        if (str != null) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.f28860a);
        Button button = (Button) findViewById(g.f28858a);
        String absolutePath = getBaseContext().getDatabasePath("inquirenoarea.db").getAbsolutePath();
        if (button != null) {
            button.setOnClickListener(new a(absolutePath));
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public static void f(Context context) {
    }
}
