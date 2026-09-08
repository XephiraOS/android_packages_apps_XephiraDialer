package com.oua.ocr.bc;

import java.util.function.Consumer;
import java.util.regex.Pattern;

/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
class Blacklist {
    static Pattern re_Negative = Pattern.compile("(統編|统一|統一|编号|編號|旗下|简称|支持|頒發|时间|listed|your|head|cert\\.?|\\bstock\\b|认证号|著名|q[0-9\\s\\:]{5,}|股票|纳税|纳税人|识别号|代码|iso|\\brom\\b|税號)", 66);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$contains$0(BCard bCard, BBox bBox) {
        if (bBox.fields.size() == bCard.use_gt && Regex.find_all(bBox.text, re_Negative).size() > 0) {
            bBox.fields.add(new String[]{"Other", bBox.text});
        }
    }

    public void contains(final BCard bCard) {
        bCard.bboxes.forEach(new Consumer() { // from class: com.oua.ocr.bc.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Blacklist.lambda$contains$0(BCard.this, (BBox) obj);
            }
        });
    }
}
