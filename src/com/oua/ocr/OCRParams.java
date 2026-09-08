package com.oua.ocr;

import com.oua.util.Transform;

/* loaded from: classes4.dex */
public class OCRParams {
    public boolean detectTextArea = false;
    public int textAreaShortEdge = 1024;
    public int detectShortEdge = 950;
    public boolean detectDirection = true;
    public Transform.PaddingOption detectorPaddingOptoin = Transform.PaddingOption.PadBottomRight;
    public float detectorTextThreshold = 0.4f;
    public float detectorLinkThreshold = 0.4f;
    public float detectorHighTextThreshold = 0.7f;
    public int detectorBlockSizeThreshold = 10;
    public boolean splitLongBox = true;
    public int longBoxRatioThold = 7;
    public int longBoxSplitOverlapFactor = 0;
    public float recognizerProbTholdCV = 0.5f;
    public float recognizerProbThold = 0.15f;
    public int recognizerBatch = 1;
    public int recognizerDirectionCheckCount = 0;
    public int recognizerDirectionRatioUpper = 10;
    public int recognizerDirectionRatioLower = 3;
}
