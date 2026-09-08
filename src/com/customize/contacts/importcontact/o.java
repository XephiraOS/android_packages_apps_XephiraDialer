package com.customize.contacts.importcontact;

import android.content.ContentProviderOperation;
import android.content.Context;
import com.android.contacts.framework.vcard.VCardEntry;
import com.android.contacts.framework.vcard.VCardUtils;
import java.util.ArrayList;

/* compiled from: LocalContactEntry.java */
/* loaded from: classes3.dex */
public class o extends com.android.contacts.framework.vcard.h {
    static final int MAX_BATCH_SIZE = 490;
    private static final int MAX_SIZE = 420;
    private static final int SLEEP_TIME = 150;
    private static final int STEP_TO_NOTIFY = 10;
    private static final String TAG = "LocalContactEntry";
    private int mBatchSize;
    protected final Context mContext;
    private boolean mIsBackground;
    private p mOnImportListener;
    private final ArrayList<ContentProviderOperation> mOperationList;
    private boolean mbCanceled;

    public o(Context context) {
        super(context.getContentResolver());
        this.mOperationList = new ArrayList<>();
        this.mbCanceled = false;
        this.mIsBackground = false;
        this.mBatchSize = 60;
        this.mContext = context;
    }

    private void applyPatch() {
        VCardUtils.A(0);
        applyBatch(this.mOperationList);
        this.mCounter = 0;
        this.mOperationList.clear();
    }

    private void onIncreaseImportedCountMsg(int i10) {
        p pVar = this.mOnImportListener;
        if (pVar != null) {
            pVar.c(i10);
        }
    }

    private void onIncreaseProgressMsg(int i10) {
        p pVar = this.mOnImportListener;
        if (pVar != null) {
            pVar.a(null, i10);
        }
    }

    public void onCancel() {
        this.mbCanceled = true;
    }

    @Override // com.android.contacts.framework.vcard.h, com.android.contacts.framework.vcard.k
    public void onEnd() {
        if (!this.mOperationList.isEmpty()) {
            applyPatch();
        }
    }

    @Override // com.android.contacts.framework.vcard.h, com.android.contacts.framework.vcard.k
    public void onEntryCreated(VCardEntry vCardEntry) {
        if (this.mbCanceled) {
            return;
        }
        if (this.mCounter % 10 == 0) {
            onIncreaseProgressMsg(10);
        }
        int size = this.mOperationList.size();
        f.b(vCardEntry);
        if (vCardEntry.R() + size < MAX_BATCH_SIZE) {
            this.mOperationList.addAll(vCardEntry.G(size));
        } else {
            applyPatch();
            this.mOperationList.addAll(vCardEntry.G(0));
        }
        this.mCounter++;
        if (this.mIsBackground) {
            try {
                Thread.sleep(150L);
            } catch (Exception e10) {
                H7.b.c(TAG, "Exception e: " + e10);
            }
        }
        H7.b.e(TAG, "IsBackround = " + this.mIsBackground + ", BatchSize = " + this.mBatchSize + ", Counter: " + this.mCounter + ", OperationList.size: " + this.mOperationList.size() + ", PhotoSize: " + VCardUtils.s());
        if (this.mOperationList.size() > MAX_SIZE || VCardUtils.s() > 262144 || this.mCounter >= this.mBatchSize) {
            applyPatch();
        }
        onIncreaseImportedCountMsg(1);
    }

    public void setImportListener(p pVar) {
        this.mOnImportListener = pVar;
    }

    public void setIsBackground(boolean z10) {
        int i10;
        this.mIsBackground = z10;
        if (z10) {
            i10 = 20;
        } else {
            i10 = 60;
        }
        this.mBatchSize = i10;
    }
}
