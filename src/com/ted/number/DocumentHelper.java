package com.ted.number;

import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import com.android.incallui.OplusPhoneCapabilities;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.util.function.Consumer;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import v9.InterfaceC1637a;

/* compiled from: DocumentHelper.kt */
/* loaded from: classes4.dex */
public final class DocumentHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final DocumentHelper f29569a = new DocumentHelper();

    public final void a(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("text/plain");
        intent.putExtra("android.provider.extra.INITIAL_URI", uri);
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        R7.b.f(context, intent, 0, null, 6, null);
    }

    public final void b(Context context, String filePath) {
        kotlin.jvm.internal.i.f(filePath, "filePath");
        if (com.android.contacts.framework.baseui.util.l.d(context, "com.coloros.filemanager")) {
            com.android.contacts.framework.baseui.util.l.f(context, "com.coloros.filemanager", null, 0);
            return;
        }
        File file = new File(filePath);
        try {
            Intent intent = new Intent();
            intent.setAction("oppo.filemanager.intent.action.BROWSER_FILE");
            intent.putExtra("CurrentDir", file.getParent());
            intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            if (context != null) {
                context.startActivity(intent);
            }
        } catch (ActivityNotFoundException e10) {
            H7.b.i("DocumentHelper", "openWithFileManager " + e10);
            a(context, Uri.fromFile(file));
        }
    }

    public final String c(Context context, String fileName, String text) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(fileName, "fileName");
        kotlin.jvm.internal.i.f(text, "text");
        Uri contentUri = MediaStore.Files.getContentUri("external_primary");
        ContentValues contentValues = new ContentValues();
        contentValues.put("relative_path", Environment.DIRECTORY_DOCUMENTS);
        contentValues.put("is_pending", (Integer) 1);
        contentValues.put("_display_name", fileName);
        Uri insert = context.getContentResolver().insert(contentUri, contentValues);
        if (insert == null) {
            return null;
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(context.getContentResolver().openOutputStream(insert, "w"), "utf-8"));
        try {
            bufferedWriter.write(text);
            bufferedWriter.flush();
            m9.q qVar = m9.q.f35511a;
            kotlin.io.a.a(bufferedWriter, null);
            contentValues.clear();
            contentValues.put("is_pending", (Integer) 0);
            context.getContentResolver().update(insert, contentValues, null, null);
            Cursor query = context.getContentResolver().query(insert, new String[]{"_data"}, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(0);
                        kotlin.io.a.a(query, null);
                        return string;
                    }
                    kotlin.io.a.a(query, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        kotlin.io.a.a(query, th);
                        throw th2;
                    }
                }
            }
            return null;
        } finally {
        }
    }

    public final void d(Context context, InterfaceC1637a<String> getFileNameFunc, String text, Consumer<String> resultListener) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(getFileNameFunc, "getFileNameFunc");
        kotlin.jvm.internal.i.f(text, "text");
        kotlin.jvm.internal.i.f(resultListener, "resultListener");
        C1248i.d(C1241e0.f34422a, S.b(), null, new DocumentHelper$saveTextToDocumentAsync$1(context, getFileNameFunc, text, resultListener, null), 2, null);
    }
}
