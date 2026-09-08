package com.android.contacts.framework.vcard;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.net.Uri;
import java.util.ArrayList;

/* compiled from: VCardEntryCommitter.java */
/* loaded from: classes.dex */
public class h implements k {
    public static final String LOG_TAG = "vCard";
    private final ContentResolver mContentResolver;
    protected int mCounter;
    private final ArrayList<Uri> mCreatedUris = new ArrayList<>();
    private ArrayList<ContentProviderOperation> mOperationList;
    private long mTimeToCommit;

    public h(ContentResolver contentResolver) {
        this.mContentResolver = contentResolver;
    }

    public Uri applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        ContentProviderResult contentProviderResult;
        ContentProviderResult[] a10 = G7.c.a(this.mContentResolver, "com.android.contacts", arrayList);
        if (a10 != null && a10.length != 0 && (contentProviderResult = a10[0]) != null) {
            return contentProviderResult.uri;
        }
        return null;
    }

    public ArrayList<Uri> getCreatedUris() {
        return this.mCreatedUris;
    }

    @Override // com.android.contacts.framework.vcard.k
    public void onEnd() {
        ArrayList<ContentProviderOperation> arrayList = this.mOperationList;
        if (arrayList != null) {
            this.mCreatedUris.add(applyBatch(arrayList));
        }
        VCardUtils.A(0);
        if (e.n()) {
            H7.b.b(LOG_TAG, String.format("time to commit entries: %d ms", Long.valueOf(this.mTimeToCommit)));
        }
    }

    @Override // com.android.contacts.framework.vcard.k
    public void onEntryCreated(VCardEntry vCardEntry) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mOperationList = vCardEntry.H(this.mContentResolver, this.mOperationList);
        int i10 = this.mCounter + 1;
        this.mCounter = i10;
        if (i10 >= 20 || VCardUtils.s() > 262144) {
            this.mCreatedUris.add(applyBatch(this.mOperationList));
            this.mCounter = 0;
            VCardUtils.A(0);
            this.mOperationList = null;
        }
        this.mTimeToCommit += System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.android.contacts.framework.vcard.k
    public void onStart() {
    }
}
