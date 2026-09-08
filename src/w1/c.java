package w1;

import com.customize.contacts.backupandrestore.plugin.ContactBackupPlugin;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: MimeHeader.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f37577b = {"X-Android-Attachment-StoreData"};

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f37578a = new ArrayList<>();

    /* compiled from: MimeHeader.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f37579a;

        /* renamed from: b, reason: collision with root package name */
        public final String f37580b;

        public a(String str, String str2) {
            this.f37579a = str;
            this.f37580b = str2;
        }

        public String toString() {
            return this.f37579a + "=" + this.f37580b;
        }
    }

    public static final boolean b(Object[] objArr, Object obj) {
        if (c(objArr, obj) >= 0) {
            return true;
        }
        return false;
    }

    public static final int c(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (objArr[i10].equals(obj)) {
                return i10;
            }
        }
        return -1;
    }

    public void a(String str, String str2) {
        this.f37578a.add(new a(str, str2));
    }

    public void d() {
        this.f37578a.clear();
    }

    public String e(String str) {
        String[] f10 = f(str);
        if (f10 == null) {
            return null;
        }
        return f10[0];
    }

    public String[] f(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = this.f37578a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f37579a.equalsIgnoreCase(str)) {
                arrayList.add(next.f37580b);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public void g(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = this.f37578a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f37579a.equalsIgnoreCase(str)) {
                arrayList.add(next);
            }
        }
        this.f37578a.removeAll(arrayList);
    }

    public void h(String str, String str2) {
        if (str != null && str2 != null) {
            g(str);
            a(str, str2);
        }
    }

    public void i(OutputStream outputStream) {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream), 1024);
        Iterator<a> it = this.f37578a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!b(f37577b, next.f37579a)) {
                bufferedWriter.write(next.f37579a + ": " + next.f37580b + ContactBackupPlugin.END_OF_LINE);
            }
        }
        bufferedWriter.flush();
    }

    public String toString() {
        ArrayList<a> arrayList = this.f37578a;
        if (arrayList == null) {
            return null;
        }
        return arrayList.toString();
    }
}
