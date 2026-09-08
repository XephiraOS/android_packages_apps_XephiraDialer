package com.android.contacts.editor;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ListAdapter;
import com.coui.appcompat.dialog.adapter.COUIListDialogAdapter;
import com.customize.contacts.util.h0;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: PhotoActionPopup.java */
/* loaded from: classes.dex */
public class B {

    /* compiled from: PhotoActionPopup.java */
    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f15074a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f15075b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f15076c;

        public a(ArrayList arrayList, d dVar, Context context) {
            this.f15074a = arrayList;
            this.f15075b = dVar;
            this.f15076c = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            int a10;
            dialogInterface.dismiss();
            int i11 = 4;
            if (-2 == i10) {
                a10 = 4;
            } else {
                a10 = ((c) this.f15074a.get(i10)).a();
            }
            HashMap hashMap = new HashMap();
            if (a10 != 0) {
                if (a10 != 1) {
                    if (a10 != 2) {
                        if (a10 == 3) {
                            h0.T(this.f15076c, 2, "add_way", "delete");
                            this.f15075b.g();
                        }
                        hashMap.put("view_position", Integer.valueOf(i11));
                        com.android.contacts.framework.baseui.util.A.a(this.f15076c, 2000311, 200030178, hashMap, false);
                        B.b(this.f15076c, i10);
                    }
                    h0.T(this.f15076c, 2, "add_way", "photo");
                    this.f15075b.a();
                } else {
                    h0.T(this.f15076c, 2, "add_way", "camera");
                    this.f15075b.f();
                }
            } else {
                this.f15075b.b();
            }
            i11 = a10;
            hashMap.put("view_position", Integer.valueOf(i11));
            com.android.contacts.framework.baseui.util.A.a(this.f15076c, 2000311, 200030178, hashMap, false);
            B.b(this.f15076c, i10);
        }
    }

    /* compiled from: PhotoActionPopup.java */
    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f15077a;

        public b(Context context) {
            this.f15077a = context;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            HashMap hashMap = new HashMap();
            hashMap.put("view_position", 4);
            com.android.contacts.framework.baseui.util.A.a(this.f15077a, 2000311, 200030178, hashMap, false);
        }
    }

    /* compiled from: PhotoActionPopup.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f15078a;

        /* renamed from: b, reason: collision with root package name */
        public final String f15079b;

        public c(int i10, String str) {
            this.f15078a = i10;
            this.f15079b = str;
        }

        public int a() {
            return this.f15078a;
        }

        public String toString() {
            return this.f15079b;
        }
    }

    /* compiled from: PhotoActionPopup.java */
    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();

        void f();

        void g();
    }

    public static void b(Context context, int i10) {
        if (i10 == 0) {
            h0.E(context, "camera");
        } else if (i10 == 1) {
            h0.E(context, "photo");
        }
    }

    public static Dialog c(Context context, View view, d dVar, int i10) {
        int[] iArr;
        ArrayList arrayList = new ArrayList(5);
        if (i10 == 3 || i10 == 1) {
            arrayList.add(new c(0, context.getString(R.string.use_photo_as_primary)));
        }
        if (i10 == 0 || i10 == 3 || i10 == 2) {
            arrayList.add(new c(1, context.getString(R.string.oplus_contact_edit_photo_from_camera)));
        }
        if (i10 == 0 || i10 == 3 || i10 == 2) {
            arrayList.add(new c(2, context.getString(R.string.oplus_contact_edit_photo_from_picture)));
        }
        if (i10 == 2 || i10 == 3) {
            arrayList.add(new c(3, context.getString(R.string.delete_photo)));
        }
        int size = arrayList.size();
        U0.b bVar = new U0.b(context, 2132083073);
        HashMap hashMap = new HashMap();
        hashMap.put("detail_has_photo", Boolean.TRUE);
        com.android.contacts.framework.baseui.util.A.a(context, 2000311, 200030177, hashMap, false);
        String[] strArr = new String[size];
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = ((c) arrayList.get(i11)).toString();
        }
        a aVar = new a(arrayList, dVar, context);
        if (size == 2) {
            iArr = new int[]{R.style.DialogButtonStyle, R.style.DialogButtonStyle};
        } else {
            iArr = new int[]{R.style.DialogButtonStyle, R.style.DialogButtonStyle, R.style.DialogButtonWarningStyle};
        }
        bVar.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) aVar).setAdapter((ListAdapter) new COUIListDialogAdapter(context, strArr, iArr), (DialogInterface.OnClickListener) aVar).setOnCancelListener(new b(context));
        return bVar.show();
    }
}
