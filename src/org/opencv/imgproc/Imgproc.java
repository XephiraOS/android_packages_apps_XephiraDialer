package org.opencv.imgproc;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfInt4;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.RotatedRect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.core.TermCriteria;
import org.opencv.utils.Converters;

/* loaded from: classes4.dex */
public class Imgproc {
    public static final int ADAPTIVE_THRESH_GAUSSIAN_C = 1;
    public static final int ADAPTIVE_THRESH_MEAN_C = 0;
    public static final int CCL_DEFAULT = -1;
    public static final int CCL_GRANA = 1;
    public static final int CCL_WU = 0;
    public static final int CC_STAT_AREA = 4;
    public static final int CC_STAT_HEIGHT = 3;
    public static final int CC_STAT_LEFT = 0;
    public static final int CC_STAT_MAX = 5;
    public static final int CC_STAT_TOP = 1;
    public static final int CC_STAT_WIDTH = 2;
    public static final int CHAIN_APPROX_NONE = 1;
    public static final int CHAIN_APPROX_SIMPLE = 2;
    public static final int CHAIN_APPROX_TC89_KCOS = 4;
    public static final int CHAIN_APPROX_TC89_L1 = 3;
    public static final int COLORMAP_AUTUMN = 0;
    public static final int COLORMAP_BONE = 1;
    public static final int COLORMAP_CIVIDIS = 17;
    public static final int COLORMAP_COOL = 8;
    public static final int COLORMAP_HOT = 11;
    public static final int COLORMAP_HSV = 9;
    public static final int COLORMAP_INFERNO = 14;
    public static final int COLORMAP_JET = 2;
    public static final int COLORMAP_MAGMA = 13;
    public static final int COLORMAP_OCEAN = 5;
    public static final int COLORMAP_PARULA = 12;
    public static final int COLORMAP_PINK = 10;
    public static final int COLORMAP_PLASMA = 15;
    public static final int COLORMAP_RAINBOW = 4;
    public static final int COLORMAP_SPRING = 7;
    public static final int COLORMAP_SUMMER = 6;
    public static final int COLORMAP_TURBO = 20;
    public static final int COLORMAP_TWILIGHT = 18;
    public static final int COLORMAP_TWILIGHT_SHIFTED = 19;
    public static final int COLORMAP_VIRIDIS = 16;
    public static final int COLORMAP_WINTER = 3;
    public static final int COLOR_BGR2BGR555 = 22;
    public static final int COLOR_BGR2BGR565 = 12;
    public static final int COLOR_BGR2BGRA = 0;
    public static final int COLOR_BGR2GRAY = 6;
    public static final int COLOR_BGR2HLS = 52;
    public static final int COLOR_BGR2HLS_FULL = 68;
    public static final int COLOR_BGR2HSV = 40;
    public static final int COLOR_BGR2HSV_FULL = 66;
    public static final int COLOR_BGR2Lab = 44;
    public static final int COLOR_BGR2Luv = 50;
    public static final int COLOR_BGR2RGB = 4;
    public static final int COLOR_BGR2RGBA = 2;
    public static final int COLOR_BGR2XYZ = 32;
    public static final int COLOR_BGR2YCrCb = 36;
    public static final int COLOR_BGR2YUV = 82;
    public static final int COLOR_BGR2YUV_I420 = 128;
    public static final int COLOR_BGR2YUV_IYUV = 128;
    public static final int COLOR_BGR2YUV_YV12 = 132;
    public static final int COLOR_BGR5552BGR = 24;
    public static final int COLOR_BGR5552BGRA = 28;
    public static final int COLOR_BGR5552GRAY = 31;
    public static final int COLOR_BGR5552RGB = 25;
    public static final int COLOR_BGR5552RGBA = 29;
    public static final int COLOR_BGR5652BGR = 14;
    public static final int COLOR_BGR5652BGRA = 18;
    public static final int COLOR_BGR5652GRAY = 21;
    public static final int COLOR_BGR5652RGB = 15;
    public static final int COLOR_BGR5652RGBA = 19;
    public static final int COLOR_BGRA2BGR = 1;
    public static final int COLOR_BGRA2BGR555 = 26;
    public static final int COLOR_BGRA2BGR565 = 16;
    public static final int COLOR_BGRA2GRAY = 10;
    public static final int COLOR_BGRA2RGB = 3;
    public static final int COLOR_BGRA2RGBA = 5;
    public static final int COLOR_BGRA2YUV_I420 = 130;
    public static final int COLOR_BGRA2YUV_IYUV = 130;
    public static final int COLOR_BGRA2YUV_YV12 = 134;
    public static final int COLOR_BayerBG2BGR = 46;
    public static final int COLOR_BayerBG2BGRA = 139;
    public static final int COLOR_BayerBG2BGR_EA = 135;
    public static final int COLOR_BayerBG2BGR_VNG = 62;
    public static final int COLOR_BayerBG2GRAY = 86;
    public static final int COLOR_BayerBG2RGB = 48;
    public static final int COLOR_BayerBG2RGBA = 141;
    public static final int COLOR_BayerBG2RGB_EA = 137;
    public static final int COLOR_BayerBG2RGB_VNG = 64;
    public static final int COLOR_BayerGB2BGR = 47;
    public static final int COLOR_BayerGB2BGRA = 140;
    public static final int COLOR_BayerGB2BGR_EA = 136;
    public static final int COLOR_BayerGB2BGR_VNG = 63;
    public static final int COLOR_BayerGB2GRAY = 87;
    public static final int COLOR_BayerGB2RGB = 49;
    public static final int COLOR_BayerGB2RGBA = 142;
    public static final int COLOR_BayerGB2RGB_EA = 138;
    public static final int COLOR_BayerGB2RGB_VNG = 65;
    public static final int COLOR_BayerGR2BGR = 49;
    public static final int COLOR_BayerGR2BGRA = 142;
    public static final int COLOR_BayerGR2BGR_EA = 138;
    public static final int COLOR_BayerGR2BGR_VNG = 65;
    public static final int COLOR_BayerGR2GRAY = 89;
    public static final int COLOR_BayerGR2RGB = 47;
    public static final int COLOR_BayerGR2RGBA = 140;
    public static final int COLOR_BayerGR2RGB_EA = 136;
    public static final int COLOR_BayerGR2RGB_VNG = 63;
    public static final int COLOR_BayerRG2BGR = 48;
    public static final int COLOR_BayerRG2BGRA = 141;
    public static final int COLOR_BayerRG2BGR_EA = 137;
    public static final int COLOR_BayerRG2BGR_VNG = 64;
    public static final int COLOR_BayerRG2GRAY = 88;
    public static final int COLOR_BayerRG2RGB = 46;
    public static final int COLOR_BayerRG2RGBA = 139;
    public static final int COLOR_BayerRG2RGB_EA = 135;
    public static final int COLOR_BayerRG2RGB_VNG = 62;
    public static final int COLOR_COLORCVT_MAX = 143;
    public static final int COLOR_GRAY2BGR = 8;
    public static final int COLOR_GRAY2BGR555 = 30;
    public static final int COLOR_GRAY2BGR565 = 20;
    public static final int COLOR_GRAY2BGRA = 9;
    public static final int COLOR_GRAY2RGB = 8;
    public static final int COLOR_GRAY2RGBA = 9;
    public static final int COLOR_HLS2BGR = 60;
    public static final int COLOR_HLS2BGR_FULL = 72;
    public static final int COLOR_HLS2RGB = 61;
    public static final int COLOR_HLS2RGB_FULL = 73;
    public static final int COLOR_HSV2BGR = 54;
    public static final int COLOR_HSV2BGR_FULL = 70;
    public static final int COLOR_HSV2RGB = 55;
    public static final int COLOR_HSV2RGB_FULL = 71;
    public static final int COLOR_LBGR2Lab = 74;
    public static final int COLOR_LBGR2Luv = 76;
    public static final int COLOR_LRGB2Lab = 75;
    public static final int COLOR_LRGB2Luv = 77;
    public static final int COLOR_Lab2BGR = 56;
    public static final int COLOR_Lab2LBGR = 78;
    public static final int COLOR_Lab2LRGB = 79;
    public static final int COLOR_Lab2RGB = 57;
    public static final int COLOR_Luv2BGR = 58;
    public static final int COLOR_Luv2LBGR = 80;
    public static final int COLOR_Luv2LRGB = 81;
    public static final int COLOR_Luv2RGB = 59;
    public static final int COLOR_RGB2BGR = 4;
    public static final int COLOR_RGB2BGR555 = 23;
    public static final int COLOR_RGB2BGR565 = 13;
    public static final int COLOR_RGB2BGRA = 2;
    public static final int COLOR_RGB2GRAY = 7;
    public static final int COLOR_RGB2HLS = 53;
    public static final int COLOR_RGB2HLS_FULL = 69;
    public static final int COLOR_RGB2HSV = 41;
    public static final int COLOR_RGB2HSV_FULL = 67;
    public static final int COLOR_RGB2Lab = 45;
    public static final int COLOR_RGB2Luv = 51;
    public static final int COLOR_RGB2RGBA = 0;
    public static final int COLOR_RGB2XYZ = 33;
    public static final int COLOR_RGB2YCrCb = 37;
    public static final int COLOR_RGB2YUV = 83;
    public static final int COLOR_RGB2YUV_I420 = 127;
    public static final int COLOR_RGB2YUV_IYUV = 127;
    public static final int COLOR_RGB2YUV_YV12 = 131;
    public static final int COLOR_RGBA2BGR = 3;
    public static final int COLOR_RGBA2BGR555 = 27;
    public static final int COLOR_RGBA2BGR565 = 17;
    public static final int COLOR_RGBA2BGRA = 5;
    public static final int COLOR_RGBA2GRAY = 11;
    public static final int COLOR_RGBA2RGB = 1;
    public static final int COLOR_RGBA2YUV_I420 = 129;
    public static final int COLOR_RGBA2YUV_IYUV = 129;
    public static final int COLOR_RGBA2YUV_YV12 = 133;
    public static final int COLOR_RGBA2mRGBA = 125;
    public static final int COLOR_XYZ2BGR = 34;
    public static final int COLOR_XYZ2RGB = 35;
    public static final int COLOR_YCrCb2BGR = 38;
    public static final int COLOR_YCrCb2RGB = 39;
    public static final int COLOR_YUV2BGR = 84;
    public static final int COLOR_YUV2BGRA_I420 = 105;
    public static final int COLOR_YUV2BGRA_IYUV = 105;
    public static final int COLOR_YUV2BGRA_NV12 = 95;
    public static final int COLOR_YUV2BGRA_NV21 = 97;
    public static final int COLOR_YUV2BGRA_UYNV = 112;
    public static final int COLOR_YUV2BGRA_UYVY = 112;
    public static final int COLOR_YUV2BGRA_Y422 = 112;
    public static final int COLOR_YUV2BGRA_YUNV = 120;
    public static final int COLOR_YUV2BGRA_YUY2 = 120;
    public static final int COLOR_YUV2BGRA_YUYV = 120;
    public static final int COLOR_YUV2BGRA_YV12 = 103;
    public static final int COLOR_YUV2BGRA_YVYU = 122;
    public static final int COLOR_YUV2BGR_I420 = 101;
    public static final int COLOR_YUV2BGR_IYUV = 101;
    public static final int COLOR_YUV2BGR_NV12 = 91;
    public static final int COLOR_YUV2BGR_NV21 = 93;
    public static final int COLOR_YUV2BGR_UYNV = 108;
    public static final int COLOR_YUV2BGR_UYVY = 108;
    public static final int COLOR_YUV2BGR_Y422 = 108;
    public static final int COLOR_YUV2BGR_YUNV = 116;
    public static final int COLOR_YUV2BGR_YUY2 = 116;
    public static final int COLOR_YUV2BGR_YUYV = 116;
    public static final int COLOR_YUV2BGR_YV12 = 99;
    public static final int COLOR_YUV2BGR_YVYU = 118;
    public static final int COLOR_YUV2GRAY_420 = 106;
    public static final int COLOR_YUV2GRAY_I420 = 106;
    public static final int COLOR_YUV2GRAY_IYUV = 106;
    public static final int COLOR_YUV2GRAY_NV12 = 106;
    public static final int COLOR_YUV2GRAY_NV21 = 106;
    public static final int COLOR_YUV2GRAY_UYNV = 123;
    public static final int COLOR_YUV2GRAY_UYVY = 123;
    public static final int COLOR_YUV2GRAY_Y422 = 123;
    public static final int COLOR_YUV2GRAY_YUNV = 124;
    public static final int COLOR_YUV2GRAY_YUY2 = 124;
    public static final int COLOR_YUV2GRAY_YUYV = 124;
    public static final int COLOR_YUV2GRAY_YV12 = 106;
    public static final int COLOR_YUV2GRAY_YVYU = 124;
    public static final int COLOR_YUV2RGB = 85;
    public static final int COLOR_YUV2RGBA_I420 = 104;
    public static final int COLOR_YUV2RGBA_IYUV = 104;
    public static final int COLOR_YUV2RGBA_NV12 = 94;
    public static final int COLOR_YUV2RGBA_NV21 = 96;
    public static final int COLOR_YUV2RGBA_UYNV = 111;
    public static final int COLOR_YUV2RGBA_UYVY = 111;
    public static final int COLOR_YUV2RGBA_Y422 = 111;
    public static final int COLOR_YUV2RGBA_YUNV = 119;
    public static final int COLOR_YUV2RGBA_YUY2 = 119;
    public static final int COLOR_YUV2RGBA_YUYV = 119;
    public static final int COLOR_YUV2RGBA_YV12 = 102;
    public static final int COLOR_YUV2RGBA_YVYU = 121;
    public static final int COLOR_YUV2RGB_I420 = 100;
    public static final int COLOR_YUV2RGB_IYUV = 100;
    public static final int COLOR_YUV2RGB_NV12 = 90;
    public static final int COLOR_YUV2RGB_NV21 = 92;
    public static final int COLOR_YUV2RGB_UYNV = 107;
    public static final int COLOR_YUV2RGB_UYVY = 107;
    public static final int COLOR_YUV2RGB_Y422 = 107;
    public static final int COLOR_YUV2RGB_YUNV = 115;
    public static final int COLOR_YUV2RGB_YUY2 = 115;
    public static final int COLOR_YUV2RGB_YUYV = 115;
    public static final int COLOR_YUV2RGB_YV12 = 98;
    public static final int COLOR_YUV2RGB_YVYU = 117;
    public static final int COLOR_YUV420p2BGR = 99;
    public static final int COLOR_YUV420p2BGRA = 103;
    public static final int COLOR_YUV420p2GRAY = 106;
    public static final int COLOR_YUV420p2RGB = 98;
    public static final int COLOR_YUV420p2RGBA = 102;
    public static final int COLOR_YUV420sp2BGR = 93;
    public static final int COLOR_YUV420sp2BGRA = 97;
    public static final int COLOR_YUV420sp2GRAY = 106;
    public static final int COLOR_YUV420sp2RGB = 92;
    public static final int COLOR_YUV420sp2RGBA = 96;
    public static final int COLOR_mRGBA2RGBA = 126;
    public static final int CONTOURS_MATCH_I1 = 1;
    public static final int CONTOURS_MATCH_I2 = 2;
    public static final int CONTOURS_MATCH_I3 = 3;
    public static final int CV_BILATERAL = 4;
    public static final int CV_BLUR = 1;
    public static final int CV_BLUR_NO_SCALE = 0;
    public static final int CV_CANNY_L2_GRADIENT = Integer.MIN_VALUE;
    private static final int CV_CHAIN_APPROX_NONE = 1;
    private static final int CV_CHAIN_APPROX_SIMPLE = 2;
    private static final int CV_CHAIN_APPROX_TC89_KCOS = 4;
    private static final int CV_CHAIN_APPROX_TC89_L1 = 3;
    public static final int CV_CHAIN_CODE = 0;
    public static final int CV_CLOCKWISE = 1;
    public static final int CV_COMP_BHATTACHARYYA = 3;
    public static final int CV_COMP_CHISQR = 1;
    public static final int CV_COMP_CHISQR_ALT = 4;
    public static final int CV_COMP_CORREL = 0;
    public static final int CV_COMP_HELLINGER = 3;
    public static final int CV_COMP_INTERSECT = 2;
    public static final int CV_COMP_KL_DIV = 5;
    public static final int CV_CONTOURS_MATCH_I1 = 1;
    public static final int CV_CONTOURS_MATCH_I2 = 2;
    public static final int CV_CONTOURS_MATCH_I3 = 3;
    public static final int CV_COUNTER_CLOCKWISE = 2;
    public static final int CV_DIST_C = 3;
    public static final int CV_DIST_FAIR = 5;
    public static final int CV_DIST_HUBER = 7;
    public static final int CV_DIST_L1 = 1;
    public static final int CV_DIST_L12 = 4;
    public static final int CV_DIST_L2 = 2;
    public static final int CV_DIST_LABEL_CCOMP = 0;
    public static final int CV_DIST_LABEL_PIXEL = 1;
    public static final int CV_DIST_MASK_3 = 3;
    public static final int CV_DIST_MASK_5 = 5;
    public static final int CV_DIST_MASK_PRECISE = 0;
    public static final int CV_DIST_USER = -1;
    public static final int CV_DIST_WELSCH = 6;
    public static final int CV_GAUSSIAN = 2;
    public static final int CV_GAUSSIAN_5x5 = 7;
    public static final int CV_HOUGH_GRADIENT = 3;
    public static final int CV_HOUGH_MULTI_SCALE = 2;
    public static final int CV_HOUGH_PROBABILISTIC = 1;
    public static final int CV_HOUGH_STANDARD = 0;
    private static final int CV_INTER_AREA = 3;
    private static final int CV_INTER_CUBIC = 2;
    private static final int CV_INTER_LANCZOS4 = 4;
    private static final int CV_INTER_LINEAR = 1;
    private static final int CV_INTER_NN = 0;
    public static final int CV_LINK_RUNS = 5;
    public static final int CV_MAX_SOBEL_KSIZE = 7;
    public static final int CV_MEDIAN = 3;
    private static final int CV_MOP_BLACKHAT = 6;
    private static final int CV_MOP_CLOSE = 3;
    private static final int CV_MOP_DILATE = 1;
    private static final int CV_MOP_ERODE = 0;
    private static final int CV_MOP_GRADIENT = 4;
    private static final int CV_MOP_OPEN = 2;
    private static final int CV_MOP_TOPHAT = 5;
    public static final int CV_POLY_APPROX_DP = 0;
    private static final int CV_RETR_CCOMP = 2;
    private static final int CV_RETR_EXTERNAL = 0;
    private static final int CV_RETR_FLOODFILL = 4;
    private static final int CV_RETR_LIST = 1;
    private static final int CV_RETR_TREE = 3;
    public static final int CV_RGBA2mRGBA = 125;
    public static final int CV_SCHARR = -1;
    public static final int CV_SHAPE_CROSS = 1;
    public static final int CV_SHAPE_CUSTOM = 100;
    public static final int CV_SHAPE_ELLIPSE = 2;
    public static final int CV_SHAPE_RECT = 0;
    private static final int CV_THRESH_BINARY = 0;
    private static final int CV_THRESH_BINARY_INV = 1;
    private static final int CV_THRESH_MASK = 7;
    private static final int CV_THRESH_OTSU = 8;
    private static final int CV_THRESH_TOZERO = 3;
    private static final int CV_THRESH_TOZERO_INV = 4;
    private static final int CV_THRESH_TRIANGLE = 16;
    private static final int CV_THRESH_TRUNC = 2;
    public static final int CV_WARP_FILL_OUTLIERS = 8;
    public static final int CV_WARP_INVERSE_MAP = 16;
    public static final int CV_mRGBA2RGBA = 126;
    public static final int DIST_C = 3;
    public static final int DIST_FAIR = 5;
    public static final int DIST_HUBER = 7;
    public static final int DIST_L1 = 1;
    public static final int DIST_L12 = 4;
    public static final int DIST_L2 = 2;
    public static final int DIST_LABEL_CCOMP = 0;
    public static final int DIST_LABEL_PIXEL = 1;
    public static final int DIST_MASK_3 = 3;
    public static final int DIST_MASK_5 = 5;
    public static final int DIST_MASK_PRECISE = 0;
    public static final int DIST_USER = -1;
    public static final int DIST_WELSCH = 6;
    public static final int FILLED = -1;
    public static final int FILTER_SCHARR = -1;
    public static final int FLOODFILL_FIXED_RANGE = 65536;
    public static final int FLOODFILL_MASK_ONLY = 131072;
    public static final int FONT_HERSHEY_COMPLEX = 3;
    public static final int FONT_HERSHEY_COMPLEX_SMALL = 5;
    public static final int FONT_HERSHEY_DUPLEX = 2;
    public static final int FONT_HERSHEY_PLAIN = 1;
    public static final int FONT_HERSHEY_SCRIPT_COMPLEX = 7;
    public static final int FONT_HERSHEY_SCRIPT_SIMPLEX = 6;
    public static final int FONT_HERSHEY_SIMPLEX = 0;
    public static final int FONT_HERSHEY_TRIPLEX = 4;
    public static final int FONT_ITALIC = 16;
    public static final int GC_BGD = 0;
    public static final int GC_EVAL = 2;
    public static final int GC_EVAL_FREEZE_MODEL = 3;
    public static final int GC_FGD = 1;
    public static final int GC_INIT_WITH_MASK = 1;
    public static final int GC_INIT_WITH_RECT = 0;
    public static final int GC_PR_BGD = 2;
    public static final int GC_PR_FGD = 3;
    public static final int HISTCMP_BHATTACHARYYA = 3;
    public static final int HISTCMP_CHISQR = 1;
    public static final int HISTCMP_CHISQR_ALT = 4;
    public static final int HISTCMP_CORREL = 0;
    public static final int HISTCMP_HELLINGER = 3;
    public static final int HISTCMP_INTERSECT = 2;
    public static final int HISTCMP_KL_DIV = 5;
    public static final int HOUGH_GRADIENT = 3;
    public static final int HOUGH_GRADIENT_ALT = 4;
    public static final int HOUGH_MULTI_SCALE = 2;
    public static final int HOUGH_PROBABILISTIC = 1;
    public static final int HOUGH_STANDARD = 0;
    public static final int INTERSECT_FULL = 2;
    public static final int INTERSECT_NONE = 0;
    public static final int INTERSECT_PARTIAL = 1;
    public static final int INTER_AREA = 3;
    public static final int INTER_BITS = 5;
    public static final int INTER_BITS2 = 10;
    public static final int INTER_CUBIC = 2;
    public static final int INTER_LANCZOS4 = 4;
    public static final int INTER_LINEAR = 1;
    public static final int INTER_LINEAR_EXACT = 5;
    public static final int INTER_MAX = 7;
    public static final int INTER_NEAREST = 0;
    public static final int INTER_TAB_SIZE = 32;
    public static final int INTER_TAB_SIZE2 = 1024;
    private static final int IPL_BORDER_CONSTANT = 0;
    private static final int IPL_BORDER_REFLECT = 2;
    private static final int IPL_BORDER_REFLECT_101 = 4;
    private static final int IPL_BORDER_REPLICATE = 1;
    private static final int IPL_BORDER_TRANSPARENT = 5;
    private static final int IPL_BORDER_WRAP = 3;
    public static final int LINE_4 = 4;
    public static final int LINE_8 = 8;
    public static final int LINE_AA = 16;
    public static final int LSD_REFINE_ADV = 2;
    public static final int LSD_REFINE_NONE = 0;
    public static final int LSD_REFINE_STD = 1;
    public static final int MARKER_CROSS = 0;
    public static final int MARKER_DIAMOND = 3;
    public static final int MARKER_SQUARE = 4;
    public static final int MARKER_STAR = 2;
    public static final int MARKER_TILTED_CROSS = 1;
    public static final int MARKER_TRIANGLE_DOWN = 6;
    public static final int MARKER_TRIANGLE_UP = 5;
    public static final int MORPH_BLACKHAT = 6;
    public static final int MORPH_CLOSE = 3;
    public static final int MORPH_CROSS = 1;
    public static final int MORPH_DILATE = 1;
    public static final int MORPH_ELLIPSE = 2;
    public static final int MORPH_ERODE = 0;
    public static final int MORPH_GRADIENT = 4;
    public static final int MORPH_HITMISS = 7;
    public static final int MORPH_OPEN = 2;
    public static final int MORPH_RECT = 0;
    public static final int MORPH_TOPHAT = 5;
    public static final int RETR_CCOMP = 2;
    public static final int RETR_EXTERNAL = 0;
    public static final int RETR_FLOODFILL = 4;
    public static final int RETR_LIST = 1;
    public static final int RETR_TREE = 3;
    public static final int THRESH_BINARY = 0;
    public static final int THRESH_BINARY_INV = 1;
    public static final int THRESH_MASK = 7;
    public static final int THRESH_OTSU = 8;
    public static final int THRESH_TOZERO = 3;
    public static final int THRESH_TOZERO_INV = 4;
    public static final int THRESH_TRIANGLE = 16;
    public static final int THRESH_TRUNC = 2;
    public static final int TM_CCOEFF = 4;
    public static final int TM_CCOEFF_NORMED = 5;
    public static final int TM_CCORR = 2;
    public static final int TM_CCORR_NORMED = 3;
    public static final int TM_SQDIFF = 0;
    public static final int TM_SQDIFF_NORMED = 1;
    public static final int WARP_FILL_OUTLIERS = 8;
    public static final int WARP_INVERSE_MAP = 16;
    public static final int WARP_POLAR_LINEAR = 0;
    public static final int WARP_POLAR_LOG = 256;

    public static void Canny(Mat mat, Mat mat2, Mat mat3, double d10, double d11, boolean z10) {
        Canny_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d10, d11, z10);
    }

    private static native void Canny_0(long j10, long j11, long j12, double d10, double d11, boolean z10);

    private static native void Canny_1(long j10, long j11, long j12, double d10, double d11);

    private static native void Canny_2(long j10, long j11, double d10, double d11, int i10, boolean z10);

    private static native void Canny_3(long j10, long j11, double d10, double d11, int i10);

    private static native void Canny_4(long j10, long j11, double d10, double d11);

    public static float EMD(Mat mat, Mat mat2, int i10, Mat mat3, Mat mat4) {
        return EMD_0(mat.nativeObj, mat2.nativeObj, i10, mat3.nativeObj, mat4.nativeObj);
    }

    private static native float EMD_0(long j10, long j11, int i10, long j12, long j13);

    private static native float EMD_1(long j10, long j11, int i10, long j12);

    private static native float EMD_3(long j10, long j11, int i10);

    public static void GaussianBlur(Mat mat, Mat mat2, Size size, double d10, double d11, int i10) {
        GaussianBlur_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, d10, d11, i10);
    }

    private static native void GaussianBlur_0(long j10, long j11, double d10, double d11, double d12, double d13, int i10);

    private static native void GaussianBlur_1(long j10, long j11, double d10, double d11, double d12, double d13);

    private static native void GaussianBlur_2(long j10, long j11, double d10, double d11, double d12);

    public static void HoughCircles(Mat mat, Mat mat2, int i10, double d10, double d11, double d12, double d13, int i11, int i12) {
        HoughCircles_0(mat.nativeObj, mat2.nativeObj, i10, d10, d11, d12, d13, i11, i12);
    }

    private static native void HoughCircles_0(long j10, long j11, int i10, double d10, double d11, double d12, double d13, int i11, int i12);

    private static native void HoughCircles_1(long j10, long j11, int i10, double d10, double d11, double d12, double d13, int i11);

    private static native void HoughCircles_2(long j10, long j11, int i10, double d10, double d11, double d12, double d13);

    private static native void HoughCircles_3(long j10, long j11, int i10, double d10, double d11, double d12);

    private static native void HoughCircles_4(long j10, long j11, int i10, double d10, double d11);

    public static void HoughLines(Mat mat, Mat mat2, double d10, double d11, int i10, double d12, double d13, double d14, double d15) {
        HoughLines_0(mat.nativeObj, mat2.nativeObj, d10, d11, i10, d12, d13, d14, d15);
    }

    public static void HoughLinesP(Mat mat, Mat mat2, double d10, double d11, int i10, double d12, double d13) {
        HoughLinesP_0(mat.nativeObj, mat2.nativeObj, d10, d11, i10, d12, d13);
    }

    private static native void HoughLinesP_0(long j10, long j11, double d10, double d11, int i10, double d12, double d13);

    private static native void HoughLinesP_1(long j10, long j11, double d10, double d11, int i10, double d12);

    private static native void HoughLinesP_2(long j10, long j11, double d10, double d11, int i10);

    public static void HoughLinesPointSet(Mat mat, Mat mat2, int i10, int i11, double d10, double d11, double d12, double d13, double d14, double d15) {
        HoughLinesPointSet_0(mat.nativeObj, mat2.nativeObj, i10, i11, d10, d11, d12, d13, d14, d15);
    }

    private static native void HoughLinesPointSet_0(long j10, long j11, int i10, int i11, double d10, double d11, double d12, double d13, double d14, double d15);

    private static native void HoughLines_0(long j10, long j11, double d10, double d11, int i10, double d12, double d13, double d14, double d15);

    private static native void HoughLines_1(long j10, long j11, double d10, double d11, int i10, double d12, double d13, double d14);

    private static native void HoughLines_2(long j10, long j11, double d10, double d11, int i10, double d12, double d13);

    private static native void HoughLines_3(long j10, long j11, double d10, double d11, int i10, double d12);

    private static native void HoughLines_4(long j10, long j11, double d10, double d11, int i10);

    public static void HuMoments(Moments moments, Mat mat) {
        HuMoments_0(moments.m00, moments.m10, moments.m01, moments.m20, moments.m11, moments.m02, moments.m30, moments.m21, moments.m12, moments.m03, mat.nativeObj);
    }

    private static native void HuMoments_0(double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19, long j10);

    public static void Laplacian(Mat mat, Mat mat2, int i10, int i11, double d10, double d11, int i12) {
        Laplacian_0(mat.nativeObj, mat2.nativeObj, i10, i11, d10, d11, i12);
    }

    private static native void Laplacian_0(long j10, long j11, int i10, int i11, double d10, double d11, int i12);

    private static native void Laplacian_1(long j10, long j11, int i10, int i11, double d10, double d11);

    private static native void Laplacian_2(long j10, long j11, int i10, int i11, double d10);

    private static native void Laplacian_3(long j10, long j11, int i10, int i11);

    private static native void Laplacian_4(long j10, long j11, int i10);

    public static void Scharr(Mat mat, Mat mat2, int i10, int i11, int i12, double d10, double d11, int i13) {
        Scharr_0(mat.nativeObj, mat2.nativeObj, i10, i11, i12, d10, d11, i13);
    }

    private static native void Scharr_0(long j10, long j11, int i10, int i11, int i12, double d10, double d11, int i13);

    private static native void Scharr_1(long j10, long j11, int i10, int i11, int i12, double d10, double d11);

    private static native void Scharr_2(long j10, long j11, int i10, int i11, int i12, double d10);

    private static native void Scharr_3(long j10, long j11, int i10, int i11, int i12);

    public static void Sobel(Mat mat, Mat mat2, int i10, int i11, int i12, int i13, double d10, double d11, int i14) {
        Sobel_0(mat.nativeObj, mat2.nativeObj, i10, i11, i12, i13, d10, d11, i14);
    }

    private static native void Sobel_0(long j10, long j11, int i10, int i11, int i12, int i13, double d10, double d11, int i14);

    private static native void Sobel_1(long j10, long j11, int i10, int i11, int i12, int i13, double d10, double d11);

    private static native void Sobel_2(long j10, long j11, int i10, int i11, int i12, int i13, double d10);

    private static native void Sobel_3(long j10, long j11, int i10, int i11, int i12, int i13);

    private static native void Sobel_4(long j10, long j11, int i10, int i11, int i12);

    public static void accumulate(Mat mat, Mat mat2, Mat mat3) {
        accumulate_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void accumulateProduct(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        accumulateProduct_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    private static native void accumulateProduct_0(long j10, long j11, long j12, long j13);

    private static native void accumulateProduct_1(long j10, long j11, long j12);

    public static void accumulateSquare(Mat mat, Mat mat2, Mat mat3) {
        accumulateSquare_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void accumulateSquare_0(long j10, long j11, long j12);

    private static native void accumulateSquare_1(long j10, long j11);

    public static void accumulateWeighted(Mat mat, Mat mat2, double d10, Mat mat3) {
        accumulateWeighted_0(mat.nativeObj, mat2.nativeObj, d10, mat3.nativeObj);
    }

    private static native void accumulateWeighted_0(long j10, long j11, double d10, long j12);

    private static native void accumulateWeighted_1(long j10, long j11, double d10);

    private static native void accumulate_0(long j10, long j11, long j12);

    private static native void accumulate_1(long j10, long j11);

    public static void adaptiveThreshold(Mat mat, Mat mat2, double d10, int i10, int i11, int i12, double d11) {
        adaptiveThreshold_0(mat.nativeObj, mat2.nativeObj, d10, i10, i11, i12, d11);
    }

    private static native void adaptiveThreshold_0(long j10, long j11, double d10, int i10, int i11, int i12, double d11);

    public static void applyColorMap(Mat mat, Mat mat2, Mat mat3) {
        applyColorMap_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void applyColorMap_0(long j10, long j11, long j12);

    private static native void applyColorMap_1(long j10, long j11, int i10);

    public static void approxPolyDP(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, double d10, boolean z10) {
        approxPolyDP_0(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, d10, z10);
    }

    private static native void approxPolyDP_0(long j10, long j11, double d10, boolean z10);

    public static double arcLength(MatOfPoint2f matOfPoint2f, boolean z10) {
        return arcLength_0(matOfPoint2f.nativeObj, z10);
    }

    private static native double arcLength_0(long j10, boolean z10);

    public static void arrowedLine(Mat mat, Point point, Point point2, Scalar scalar, int i10, int i11, int i12, double d10) {
        long j10 = mat.nativeObj;
        double d11 = point.f35882x;
        double d12 = point.f35883y;
        double d13 = point2.f35882x;
        double d14 = point2.f35883y;
        double[] dArr = scalar.val;
        arrowedLine_0(j10, d11, d12, d13, d14, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11, i12, d10);
    }

    private static native void arrowedLine_0(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, int i10, int i11, int i12, double d18);

    private static native void arrowedLine_1(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, int i10, int i11, int i12);

    private static native void arrowedLine_2(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, int i10, int i11);

    private static native void arrowedLine_3(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, int i10);

    private static native void arrowedLine_4(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17);

    public static void bilateralFilter(Mat mat, Mat mat2, int i10, double d10, double d11, int i11) {
        bilateralFilter_0(mat.nativeObj, mat2.nativeObj, i10, d10, d11, i11);
    }

    private static native void bilateralFilter_0(long j10, long j11, int i10, double d10, double d11, int i11);

    private static native void bilateralFilter_1(long j10, long j11, int i10, double d10, double d11);

    public static void blur(Mat mat, Mat mat2, Size size, Point point, int i10) {
        blur_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, point.f35882x, point.f35883y, i10);
    }

    private static native void blur_0(long j10, long j11, double d10, double d11, double d12, double d13, int i10);

    private static native void blur_1(long j10, long j11, double d10, double d11, double d12, double d13);

    private static native void blur_2(long j10, long j11, double d10, double d11);

    public static Rect boundingRect(Mat mat) {
        return new Rect(boundingRect_0(mat.nativeObj));
    }

    private static native double[] boundingRect_0(long j10);

    public static void boxFilter(Mat mat, Mat mat2, int i10, Size size, Point point, boolean z10, int i11) {
        boxFilter_0(mat.nativeObj, mat2.nativeObj, i10, size.width, size.height, point.f35882x, point.f35883y, z10, i11);
    }

    private static native void boxFilter_0(long j10, long j11, int i10, double d10, double d11, double d12, double d13, boolean z10, int i11);

    private static native void boxFilter_1(long j10, long j11, int i10, double d10, double d11, double d12, double d13, boolean z10);

    private static native void boxFilter_2(long j10, long j11, int i10, double d10, double d11, double d12, double d13);

    private static native void boxFilter_3(long j10, long j11, int i10, double d10, double d11);

    public static void boxPoints(RotatedRect rotatedRect, Mat mat) {
        Point point = rotatedRect.center;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        Size size = rotatedRect.size;
        boxPoints_0(d10, d11, size.width, size.height, rotatedRect.angle, mat.nativeObj);
    }

    private static native void boxPoints_0(double d10, double d11, double d12, double d13, double d14, long j10);

    public static void calcBackProject(List<Mat> list, MatOfInt matOfInt, Mat mat, Mat mat2, MatOfFloat matOfFloat, double d10) {
        calcBackProject_0(Converters.vector_Mat_to_Mat(list).nativeObj, matOfInt.nativeObj, mat.nativeObj, mat2.nativeObj, matOfFloat.nativeObj, d10);
    }

    private static native void calcBackProject_0(long j10, long j11, long j12, long j13, long j14, double d10);

    public static void calcHist(List<Mat> list, MatOfInt matOfInt, Mat mat, Mat mat2, MatOfInt matOfInt2, MatOfFloat matOfFloat, boolean z10) {
        calcHist_0(Converters.vector_Mat_to_Mat(list).nativeObj, matOfInt.nativeObj, mat.nativeObj, mat2.nativeObj, matOfInt2.nativeObj, matOfFloat.nativeObj, z10);
    }

    private static native void calcHist_0(long j10, long j11, long j12, long j13, long j14, long j15, boolean z10);

    private static native void calcHist_1(long j10, long j11, long j12, long j13, long j14, long j15);

    public static void circle(Mat mat, Point point, int i10, Scalar scalar, int i11, int i12, int i13) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr = scalar.val;
        circle_0(j10, d10, d11, i10, dArr[0], dArr[1], dArr[2], dArr[3], i11, i12, i13);
    }

    private static native void circle_0(long j10, double d10, double d11, int i10, double d12, double d13, double d14, double d15, int i11, int i12, int i13);

    private static native void circle_1(long j10, double d10, double d11, int i10, double d12, double d13, double d14, double d15, int i11, int i12);

    private static native void circle_2(long j10, double d10, double d11, int i10, double d12, double d13, double d14, double d15, int i11);

    private static native void circle_3(long j10, double d10, double d11, int i10, double d12, double d13, double d14, double d15);

    public static boolean clipLine(Rect rect, Point point, Point point2) {
        double[] dArr = new double[2];
        double[] dArr2 = new double[2];
        boolean clipLine_0 = clipLine_0(rect.f35887x, rect.f35888y, rect.width, rect.height, point.f35882x, point.f35883y, dArr, point2.f35882x, point2.f35883y, dArr2);
        point.f35882x = dArr[0];
        point.f35883y = dArr[1];
        point2.f35882x = dArr2[0];
        point2.f35883y = dArr2[1];
        return clipLine_0;
    }

    private static native boolean clipLine_0(int i10, int i11, int i12, int i13, double d10, double d11, double[] dArr, double d12, double d13, double[] dArr2);

    public static double compareHist(Mat mat, Mat mat2, int i10) {
        return compareHist_0(mat.nativeObj, mat2.nativeObj, i10);
    }

    private static native double compareHist_0(long j10, long j11, int i10);

    public static int connectedComponents(Mat mat, Mat mat2, int i10, int i11) {
        return connectedComponents_0(mat.nativeObj, mat2.nativeObj, i10, i11);
    }

    public static int connectedComponentsWithAlgorithm(Mat mat, Mat mat2, int i10, int i11, int i12) {
        return connectedComponentsWithAlgorithm_0(mat.nativeObj, mat2.nativeObj, i10, i11, i12);
    }

    private static native int connectedComponentsWithAlgorithm_0(long j10, long j11, int i10, int i11, int i12);

    public static int connectedComponentsWithStats(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i10, int i11) {
        return connectedComponentsWithStats_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i10, i11);
    }

    public static int connectedComponentsWithStatsWithAlgorithm(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i10, int i11, int i12) {
        return connectedComponentsWithStatsWithAlgorithm_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i10, i11, i12);
    }

    private static native int connectedComponentsWithStatsWithAlgorithm_0(long j10, long j11, long j12, long j13, int i10, int i11, int i12);

    private static native int connectedComponentsWithStats_0(long j10, long j11, long j12, long j13, int i10, int i11);

    private static native int connectedComponentsWithStats_1(long j10, long j11, long j12, long j13, int i10);

    private static native int connectedComponentsWithStats_2(long j10, long j11, long j12, long j13);

    private static native int connectedComponents_0(long j10, long j11, int i10, int i11);

    private static native int connectedComponents_1(long j10, long j11, int i10);

    private static native int connectedComponents_2(long j10, long j11);

    public static double contourArea(Mat mat, boolean z10) {
        return contourArea_0(mat.nativeObj, z10);
    }

    private static native double contourArea_0(long j10, boolean z10);

    private static native double contourArea_1(long j10);

    public static void convertMaps(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i10, boolean z10) {
        convertMaps_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i10, z10);
    }

    private static native void convertMaps_0(long j10, long j11, long j12, long j13, int i10, boolean z10);

    private static native void convertMaps_1(long j10, long j11, long j12, long j13, int i10);

    public static void convexHull(MatOfPoint matOfPoint, MatOfInt matOfInt, boolean z10) {
        convexHull_0(matOfPoint.nativeObj, matOfInt.nativeObj, z10);
    }

    private static native void convexHull_0(long j10, long j11, boolean z10);

    private static native void convexHull_2(long j10, long j11);

    public static void convexityDefects(MatOfPoint matOfPoint, MatOfInt matOfInt, MatOfInt4 matOfInt4) {
        convexityDefects_0(matOfPoint.nativeObj, matOfInt.nativeObj, matOfInt4.nativeObj);
    }

    private static native void convexityDefects_0(long j10, long j11, long j12);

    public static void cornerEigenValsAndVecs(Mat mat, Mat mat2, int i10, int i11, int i12) {
        cornerEigenValsAndVecs_0(mat.nativeObj, mat2.nativeObj, i10, i11, i12);
    }

    private static native void cornerEigenValsAndVecs_0(long j10, long j11, int i10, int i11, int i12);

    private static native void cornerEigenValsAndVecs_1(long j10, long j11, int i10, int i11);

    public static void cornerHarris(Mat mat, Mat mat2, int i10, int i11, double d10, int i12) {
        cornerHarris_0(mat.nativeObj, mat2.nativeObj, i10, i11, d10, i12);
    }

    private static native void cornerHarris_0(long j10, long j11, int i10, int i11, double d10, int i12);

    private static native void cornerHarris_1(long j10, long j11, int i10, int i11, double d10);

    public static void cornerMinEigenVal(Mat mat, Mat mat2, int i10, int i11, int i12) {
        cornerMinEigenVal_0(mat.nativeObj, mat2.nativeObj, i10, i11, i12);
    }

    private static native void cornerMinEigenVal_0(long j10, long j11, int i10, int i11, int i12);

    private static native void cornerMinEigenVal_1(long j10, long j11, int i10, int i11);

    private static native void cornerMinEigenVal_2(long j10, long j11, int i10);

    public static void cornerSubPix(Mat mat, Mat mat2, Size size, Size size2, TermCriteria termCriteria) {
        cornerSubPix_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, size2.width, size2.height, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    private static native void cornerSubPix_0(long j10, long j11, double d10, double d11, double d12, double d13, int i10, int i11, double d14);

    public static CLAHE createCLAHE(double d10, Size size) {
        return CLAHE.__fromPtr__(createCLAHE_0(d10, size.width, size.height));
    }

    private static native long createCLAHE_0(double d10, double d11, double d12);

    private static native long createCLAHE_1(double d10);

    private static native long createCLAHE_2();

    public static GeneralizedHoughBallard createGeneralizedHoughBallard() {
        return GeneralizedHoughBallard.__fromPtr__(createGeneralizedHoughBallard_0());
    }

    private static native long createGeneralizedHoughBallard_0();

    public static GeneralizedHoughGuil createGeneralizedHoughGuil() {
        return GeneralizedHoughGuil.__fromPtr__(createGeneralizedHoughGuil_0());
    }

    private static native long createGeneralizedHoughGuil_0();

    public static void createHanningWindow(Mat mat, Size size, int i10) {
        createHanningWindow_0(mat.nativeObj, size.width, size.height, i10);
    }

    private static native void createHanningWindow_0(long j10, double d10, double d11, int i10);

    public static LineSegmentDetector createLineSegmentDetector(int i10, double d10, double d11, double d12, double d13, double d14, double d15, int i11) {
        return LineSegmentDetector.__fromPtr__(createLineSegmentDetector_0(i10, d10, d11, d12, d13, d14, d15, i11));
    }

    private static native long createLineSegmentDetector_0(int i10, double d10, double d11, double d12, double d13, double d14, double d15, int i11);

    private static native long createLineSegmentDetector_1(int i10, double d10, double d11, double d12, double d13, double d14, double d15);

    private static native long createLineSegmentDetector_2(int i10, double d10, double d11, double d12, double d13, double d14);

    private static native long createLineSegmentDetector_3(int i10, double d10, double d11, double d12, double d13);

    private static native long createLineSegmentDetector_4(int i10, double d10, double d11, double d12);

    private static native long createLineSegmentDetector_5(int i10, double d10, double d11);

    private static native long createLineSegmentDetector_6(int i10, double d10);

    private static native long createLineSegmentDetector_7(int i10);

    private static native long createLineSegmentDetector_8();

    public static void cvtColor(Mat mat, Mat mat2, int i10, int i11) {
        cvtColor_0(mat.nativeObj, mat2.nativeObj, i10, i11);
    }

    public static void cvtColorTwoPlane(Mat mat, Mat mat2, Mat mat3, int i10) {
        cvtColorTwoPlane_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i10);
    }

    private static native void cvtColorTwoPlane_0(long j10, long j11, long j12, int i10);

    private static native void cvtColor_0(long j10, long j11, int i10, int i11);

    private static native void cvtColor_1(long j10, long j11, int i10);

    public static void demosaicing(Mat mat, Mat mat2, int i10, int i11) {
        demosaicing_0(mat.nativeObj, mat2.nativeObj, i10, i11);
    }

    private static native void demosaicing_0(long j10, long j11, int i10, int i11);

    private static native void demosaicing_1(long j10, long j11, int i10);

    public static void dilate(Mat mat, Mat mat2, Mat mat3, Point point, int i10, int i11, Scalar scalar) {
        long j10 = mat.nativeObj;
        long j11 = mat2.nativeObj;
        long j12 = mat3.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr = scalar.val;
        dilate_0(j10, j11, j12, d10, d11, i10, i11, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    private static native void dilate_0(long j10, long j11, long j12, double d10, double d11, int i10, int i11, double d12, double d13, double d14, double d15);

    private static native void dilate_1(long j10, long j11, long j12, double d10, double d11, int i10, int i11);

    private static native void dilate_2(long j10, long j11, long j12, double d10, double d11, int i10);

    private static native void dilate_3(long j10, long j11, long j12, double d10, double d11);

    private static native void dilate_4(long j10, long j11, long j12);

    public static void distanceTransform(Mat mat, Mat mat2, int i10, int i11, int i12) {
        distanceTransform_0(mat.nativeObj, mat2.nativeObj, i10, i11, i12);
    }

    public static void distanceTransformWithLabels(Mat mat, Mat mat2, Mat mat3, int i10, int i11, int i12) {
        distanceTransformWithLabels_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i10, i11, i12);
    }

    private static native void distanceTransformWithLabels_0(long j10, long j11, long j12, int i10, int i11, int i12);

    private static native void distanceTransformWithLabels_1(long j10, long j11, long j12, int i10, int i11);

    private static native void distanceTransform_0(long j10, long j11, int i10, int i11, int i12);

    private static native void distanceTransform_1(long j10, long j11, int i10, int i11);

    public static void drawContours(Mat mat, List<MatOfPoint> list, int i10, Scalar scalar, int i11, int i12, Mat mat2, int i13, Point point) {
        Mat vector_vector_Point_to_Mat = Converters.vector_vector_Point_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j10 = mat.nativeObj;
        long j11 = vector_vector_Point_to_Mat.nativeObj;
        double[] dArr = scalar.val;
        drawContours_0(j10, j11, i10, dArr[0], dArr[1], dArr[2], dArr[3], i11, i12, mat2.nativeObj, i13, point.f35882x, point.f35883y);
    }

    private static native void drawContours_0(long j10, long j11, int i10, double d10, double d11, double d12, double d13, int i11, int i12, long j12, int i13, double d14, double d15);

    private static native void drawContours_1(long j10, long j11, int i10, double d10, double d11, double d12, double d13, int i11, int i12, long j12, int i13);

    private static native void drawContours_2(long j10, long j11, int i10, double d10, double d11, double d12, double d13, int i11, int i12, long j12);

    private static native void drawContours_3(long j10, long j11, int i10, double d10, double d11, double d12, double d13, int i11, int i12);

    private static native void drawContours_4(long j10, long j11, int i10, double d10, double d11, double d12, double d13, int i11);

    private static native void drawContours_5(long j10, long j11, int i10, double d10, double d11, double d12, double d13);

    public static void drawMarker(Mat mat, Point point, Scalar scalar, int i10, int i11, int i12, int i13) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr = scalar.val;
        drawMarker_0(j10, d10, d11, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11, i12, i13);
    }

    private static native void drawMarker_0(long j10, double d10, double d11, double d12, double d13, double d14, double d15, int i10, int i11, int i12, int i13);

    private static native void drawMarker_1(long j10, double d10, double d11, double d12, double d13, double d14, double d15, int i10, int i11, int i12);

    private static native void drawMarker_2(long j10, double d10, double d11, double d12, double d13, double d14, double d15, int i10, int i11);

    private static native void drawMarker_3(long j10, double d10, double d11, double d12, double d13, double d14, double d15, int i10);

    private static native void drawMarker_4(long j10, double d10, double d11, double d12, double d13, double d14, double d15);

    public static void ellipse(Mat mat, Point point, Size size, double d10, double d11, double d12, Scalar scalar, int i10, int i11, int i12) {
        long j10 = mat.nativeObj;
        double d13 = point.f35882x;
        double d14 = point.f35883y;
        double d15 = size.width;
        double d16 = size.height;
        double[] dArr = scalar.val;
        ellipse_0(j10, d13, d14, d15, d16, d10, d11, d12, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11, i12);
    }

    public static void ellipse2Poly(Point point, Size size, int i10, int i11, int i12, int i13, MatOfPoint matOfPoint) {
        ellipse2Poly_0(point.f35882x, point.f35883y, size.width, size.height, i10, i11, i12, i13, matOfPoint.nativeObj);
    }

    private static native void ellipse2Poly_0(double d10, double d11, double d12, double d13, int i10, int i11, int i12, int i13, long j10);

    private static native void ellipse_0(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19, double d20, int i10, int i11, int i12);

    private static native void ellipse_1(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19, double d20, int i10, int i11);

    private static native void ellipse_2(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19, double d20, int i10);

    private static native void ellipse_3(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19, double d20);

    private static native void ellipse_4(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, int i10, int i11);

    private static native void ellipse_5(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, int i10);

    private static native void ellipse_6(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18);

    public static void equalizeHist(Mat mat, Mat mat2) {
        equalizeHist_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void equalizeHist_0(long j10, long j11);

    public static void erode(Mat mat, Mat mat2, Mat mat3, Point point, int i10, int i11, Scalar scalar) {
        long j10 = mat.nativeObj;
        long j11 = mat2.nativeObj;
        long j12 = mat3.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr = scalar.val;
        erode_0(j10, j11, j12, d10, d11, i10, i11, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    private static native void erode_0(long j10, long j11, long j12, double d10, double d11, int i10, int i11, double d12, double d13, double d14, double d15);

    private static native void erode_1(long j10, long j11, long j12, double d10, double d11, int i10, int i11);

    private static native void erode_2(long j10, long j11, long j12, double d10, double d11, int i10);

    private static native void erode_3(long j10, long j11, long j12, double d10, double d11);

    private static native void erode_4(long j10, long j11, long j12);

    public static void fillConvexPoly(Mat mat, MatOfPoint matOfPoint, Scalar scalar, int i10, int i11) {
        long j10 = mat.nativeObj;
        long j11 = matOfPoint.nativeObj;
        double[] dArr = scalar.val;
        fillConvexPoly_0(j10, j11, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11);
    }

    private static native void fillConvexPoly_0(long j10, long j11, double d10, double d11, double d12, double d13, int i10, int i11);

    private static native void fillConvexPoly_1(long j10, long j11, double d10, double d11, double d12, double d13, int i10);

    private static native void fillConvexPoly_2(long j10, long j11, double d10, double d11, double d12, double d13);

    public static void fillPoly(Mat mat, List<MatOfPoint> list, Scalar scalar, int i10, int i11, Point point) {
        Mat vector_vector_Point_to_Mat = Converters.vector_vector_Point_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j10 = mat.nativeObj;
        long j11 = vector_vector_Point_to_Mat.nativeObj;
        double[] dArr = scalar.val;
        fillPoly_0(j10, j11, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11, point.f35882x, point.f35883y);
    }

    private static native void fillPoly_0(long j10, long j11, double d10, double d11, double d12, double d13, int i10, int i11, double d14, double d15);

    private static native void fillPoly_1(long j10, long j11, double d10, double d11, double d12, double d13, int i10, int i11);

    private static native void fillPoly_2(long j10, long j11, double d10, double d11, double d12, double d13, int i10);

    private static native void fillPoly_3(long j10, long j11, double d10, double d11, double d12, double d13);

    public static void filter2D(Mat mat, Mat mat2, int i10, Mat mat3, Point point, double d10, int i11) {
        filter2D_0(mat.nativeObj, mat2.nativeObj, i10, mat3.nativeObj, point.f35882x, point.f35883y, d10, i11);
    }

    private static native void filter2D_0(long j10, long j11, int i10, long j12, double d10, double d11, double d12, int i11);

    private static native void filter2D_1(long j10, long j11, int i10, long j12, double d10, double d11, double d12);

    private static native void filter2D_2(long j10, long j11, int i10, long j12, double d10, double d11);

    private static native void filter2D_3(long j10, long j11, int i10, long j12);

    public static void findContours(Mat mat, List<MatOfPoint> list, Mat mat2, int i10, int i11, Point point) {
        Mat mat3 = new Mat();
        findContours_0(mat.nativeObj, mat3.nativeObj, mat2.nativeObj, i10, i11, point.f35882x, point.f35883y);
        Converters.Mat_to_vector_vector_Point(mat3, list);
        mat3.release();
    }

    private static native void findContours_0(long j10, long j11, long j12, int i10, int i11, double d10, double d11);

    private static native void findContours_1(long j10, long j11, long j12, int i10, int i11);

    public static RotatedRect fitEllipse(MatOfPoint2f matOfPoint2f) {
        return new RotatedRect(fitEllipse_0(matOfPoint2f.nativeObj));
    }

    public static RotatedRect fitEllipseAMS(Mat mat) {
        return new RotatedRect(fitEllipseAMS_0(mat.nativeObj));
    }

    private static native double[] fitEllipseAMS_0(long j10);

    public static RotatedRect fitEllipseDirect(Mat mat) {
        return new RotatedRect(fitEllipseDirect_0(mat.nativeObj));
    }

    private static native double[] fitEllipseDirect_0(long j10);

    private static native double[] fitEllipse_0(long j10);

    public static void fitLine(Mat mat, Mat mat2, int i10, double d10, double d11, double d12) {
        fitLine_0(mat.nativeObj, mat2.nativeObj, i10, d10, d11, d12);
    }

    private static native void fitLine_0(long j10, long j11, int i10, double d10, double d11, double d12);

    public static int floodFill(Mat mat, Mat mat2, Point point, Scalar scalar, Rect rect, Scalar scalar2, Scalar scalar3, int i10) {
        double[] dArr = new double[4];
        long j10 = mat.nativeObj;
        long j11 = mat2.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr2 = scalar.val;
        double d12 = dArr2[0];
        double d13 = dArr2[1];
        double d14 = dArr2[2];
        double d15 = dArr2[3];
        double[] dArr3 = scalar2.val;
        double d16 = dArr3[0];
        double d17 = dArr3[1];
        double d18 = dArr3[2];
        double d19 = dArr3[3];
        double[] dArr4 = scalar3.val;
        int floodFill_0 = floodFill_0(j10, j11, d10, d11, d12, d13, d14, d15, dArr, d16, d17, d18, d19, dArr4[0], dArr4[1], dArr4[2], dArr4[3], i10);
        if (rect != null) {
            rect.f35887x = (int) dArr[0];
            rect.f35888y = (int) dArr[1];
            rect.width = (int) dArr[2];
            rect.height = (int) dArr[3];
        }
        return floodFill_0;
    }

    private static native int floodFill_0(long j10, long j11, double d10, double d11, double d12, double d13, double d14, double d15, double[] dArr, double d16, double d17, double d18, double d19, double d20, double d21, double d22, double d23, int i10);

    private static native int floodFill_1(long j10, long j11, double d10, double d11, double d12, double d13, double d14, double d15, double[] dArr, double d16, double d17, double d18, double d19, double d20, double d21, double d22, double d23);

    private static native int floodFill_2(long j10, long j11, double d10, double d11, double d12, double d13, double d14, double d15, double[] dArr, double d16, double d17, double d18, double d19);

    private static native int floodFill_3(long j10, long j11, double d10, double d11, double d12, double d13, double d14, double d15, double[] dArr);

    private static native int floodFill_4(long j10, long j11, double d10, double d11, double d12, double d13, double d14, double d15);

    public static Mat getAffineTransform(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2) {
        return new Mat(getAffineTransform_0(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj));
    }

    private static native long getAffineTransform_0(long j10, long j11);

    public static void getDerivKernels(Mat mat, Mat mat2, int i10, int i11, int i12, boolean z10, int i13) {
        getDerivKernels_0(mat.nativeObj, mat2.nativeObj, i10, i11, i12, z10, i13);
    }

    private static native void getDerivKernels_0(long j10, long j11, int i10, int i11, int i12, boolean z10, int i13);

    private static native void getDerivKernels_1(long j10, long j11, int i10, int i11, int i12, boolean z10);

    private static native void getDerivKernels_2(long j10, long j11, int i10, int i11, int i12);

    public static double getFontScaleFromHeight(int i10, int i11, int i12) {
        return getFontScaleFromHeight_0(i10, i11, i12);
    }

    private static native double getFontScaleFromHeight_0(int i10, int i11, int i12);

    private static native double getFontScaleFromHeight_1(int i10, int i11);

    public static Mat getGaborKernel(Size size, double d10, double d11, double d12, double d13, double d14, int i10) {
        return new Mat(getGaborKernel_0(size.width, size.height, d10, d11, d12, d13, d14, i10));
    }

    private static native long getGaborKernel_0(double d10, double d11, double d12, double d13, double d14, double d15, double d16, int i10);

    private static native long getGaborKernel_1(double d10, double d11, double d12, double d13, double d14, double d15, double d16);

    private static native long getGaborKernel_2(double d10, double d11, double d12, double d13, double d14, double d15);

    public static Mat getGaussianKernel(int i10, double d10, int i11) {
        return new Mat(getGaussianKernel_0(i10, d10, i11));
    }

    private static native long getGaussianKernel_0(int i10, double d10, int i11);

    private static native long getGaussianKernel_1(int i10, double d10);

    public static Mat getPerspectiveTransform(Mat mat, Mat mat2, int i10) {
        return new Mat(getPerspectiveTransform_0(mat.nativeObj, mat2.nativeObj, i10));
    }

    private static native long getPerspectiveTransform_0(long j10, long j11, int i10);

    private static native long getPerspectiveTransform_1(long j10, long j11);

    public static void getRectSubPix(Mat mat, Size size, Point point, Mat mat2, int i10) {
        getRectSubPix_0(mat.nativeObj, size.width, size.height, point.f35882x, point.f35883y, mat2.nativeObj, i10);
    }

    private static native void getRectSubPix_0(long j10, double d10, double d11, double d12, double d13, long j11, int i10);

    private static native void getRectSubPix_1(long j10, double d10, double d11, double d12, double d13, long j11);

    public static Mat getRotationMatrix2D(Point point, double d10, double d11) {
        return new Mat(getRotationMatrix2D_0(point.f35882x, point.f35883y, d10, d11));
    }

    private static native long getRotationMatrix2D_0(double d10, double d11, double d12, double d13);

    public static Mat getStructuringElement(int i10, Size size, Point point) {
        return new Mat(getStructuringElement_0(i10, size.width, size.height, point.f35882x, point.f35883y));
    }

    private static native long getStructuringElement_0(int i10, double d10, double d11, double d12, double d13);

    private static native long getStructuringElement_1(int i10, double d10, double d11);

    public static Size getTextSize(String str, int i10, double d10, int i11, int[] iArr) {
        if (iArr != null && iArr.length != 1) {
            throw new IllegalArgumentException("'baseLine' must be 'int[1]' or 'null'.");
        }
        return new Size(n_getTextSize(str, i10, d10, i11, iArr));
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i10, double d10, double d11, Mat mat2, int i11, int i12, boolean z10, double d12) {
        goodFeaturesToTrack_0(mat.nativeObj, matOfPoint.nativeObj, i10, d10, d11, mat2.nativeObj, i11, i12, z10, d12);
    }

    private static native void goodFeaturesToTrack_0(long j10, long j11, int i10, double d10, double d11, long j12, int i11, int i12, boolean z10, double d12);

    private static native void goodFeaturesToTrack_1(long j10, long j11, int i10, double d10, double d11, long j12, int i11, int i12, boolean z10);

    private static native void goodFeaturesToTrack_2(long j10, long j11, int i10, double d10, double d11, long j12, int i11, int i12);

    private static native void goodFeaturesToTrack_3(long j10, long j11, int i10, double d10, double d11, long j12, int i11, boolean z10, double d12);

    private static native void goodFeaturesToTrack_4(long j10, long j11, int i10, double d10, double d11, long j12, int i11, boolean z10);

    private static native void goodFeaturesToTrack_5(long j10, long j11, int i10, double d10, double d11, long j12, int i11);

    private static native void goodFeaturesToTrack_6(long j10, long j11, int i10, double d10, double d11, long j12);

    private static native void goodFeaturesToTrack_7(long j10, long j11, int i10, double d10, double d11);

    public static void grabCut(Mat mat, Mat mat2, Rect rect, Mat mat3, Mat mat4, int i10, int i11) {
        grabCut_0(mat.nativeObj, mat2.nativeObj, rect.f35887x, rect.f35888y, rect.width, rect.height, mat3.nativeObj, mat4.nativeObj, i10, i11);
    }

    private static native void grabCut_0(long j10, long j11, int i10, int i11, int i12, int i13, long j12, long j13, int i14, int i15);

    private static native void grabCut_1(long j10, long j11, int i10, int i11, int i12, int i13, long j12, long j13, int i14);

    public static void integral(Mat mat, Mat mat2, int i10) {
        integral_0(mat.nativeObj, mat2.nativeObj, i10);
    }

    public static void integral2(Mat mat, Mat mat2, Mat mat3, int i10, int i11) {
        integral2_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i10, i11);
    }

    private static native void integral2_0(long j10, long j11, long j12, int i10, int i11);

    private static native void integral2_1(long j10, long j11, long j12, int i10);

    private static native void integral2_2(long j10, long j11, long j12);

    public static void integral3(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i10, int i11) {
        integral3_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i10, i11);
    }

    private static native void integral3_0(long j10, long j11, long j12, long j13, int i10, int i11);

    private static native void integral3_1(long j10, long j11, long j12, long j13, int i10);

    private static native void integral3_2(long j10, long j11, long j12, long j13);

    private static native void integral_0(long j10, long j11, int i10);

    private static native void integral_1(long j10, long j11);

    public static float intersectConvexConvex(Mat mat, Mat mat2, Mat mat3, boolean z10) {
        return intersectConvexConvex_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, z10);
    }

    private static native float intersectConvexConvex_0(long j10, long j11, long j12, boolean z10);

    private static native float intersectConvexConvex_1(long j10, long j11, long j12);

    public static void invertAffineTransform(Mat mat, Mat mat2) {
        invertAffineTransform_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void invertAffineTransform_0(long j10, long j11);

    public static boolean isContourConvex(MatOfPoint matOfPoint) {
        return isContourConvex_0(matOfPoint.nativeObj);
    }

    private static native boolean isContourConvex_0(long j10);

    public static void line(Mat mat, Point point, Point point2, Scalar scalar, int i10, int i11, int i12) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double d12 = point2.f35882x;
        double d13 = point2.f35883y;
        double[] dArr = scalar.val;
        line_0(j10, d10, d11, d12, d13, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11, i12);
    }

    private static native void line_0(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, int i10, int i11, int i12);

    private static native void line_1(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, int i10, int i11);

    private static native void line_2(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, int i10);

    private static native void line_3(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17);

    @Deprecated
    public static void linearPolar(Mat mat, Mat mat2, Point point, double d10, int i10) {
        linearPolar_0(mat.nativeObj, mat2.nativeObj, point.f35882x, point.f35883y, d10, i10);
    }

    private static native void linearPolar_0(long j10, long j11, double d10, double d11, double d12, int i10);

    @Deprecated
    public static void logPolar(Mat mat, Mat mat2, Point point, double d10, int i10) {
        logPolar_0(mat.nativeObj, mat2.nativeObj, point.f35882x, point.f35883y, d10, i10);
    }

    private static native void logPolar_0(long j10, long j11, double d10, double d11, double d12, int i10);

    public static double matchShapes(Mat mat, Mat mat2, int i10, double d10) {
        return matchShapes_0(mat.nativeObj, mat2.nativeObj, i10, d10);
    }

    private static native double matchShapes_0(long j10, long j11, int i10, double d10);

    public static void matchTemplate(Mat mat, Mat mat2, Mat mat3, int i10, Mat mat4) {
        matchTemplate_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i10, mat4.nativeObj);
    }

    private static native void matchTemplate_0(long j10, long j11, long j12, int i10, long j13);

    private static native void matchTemplate_1(long j10, long j11, long j12, int i10);

    public static void medianBlur(Mat mat, Mat mat2, int i10) {
        medianBlur_0(mat.nativeObj, mat2.nativeObj, i10);
    }

    private static native void medianBlur_0(long j10, long j11, int i10);

    public static RotatedRect minAreaRect(MatOfPoint2f matOfPoint2f) {
        return new RotatedRect(minAreaRect_0(matOfPoint2f.nativeObj));
    }

    private static native double[] minAreaRect_0(long j10);

    public static void minEnclosingCircle(MatOfPoint2f matOfPoint2f, Point point, float[] fArr) {
        double[] dArr = new double[2];
        double[] dArr2 = new double[1];
        minEnclosingCircle_0(matOfPoint2f.nativeObj, dArr, dArr2);
        if (point != null) {
            point.f35882x = dArr[0];
            point.f35883y = dArr[1];
        }
        if (fArr != null) {
            fArr[0] = (float) dArr2[0];
        }
    }

    private static native void minEnclosingCircle_0(long j10, double[] dArr, double[] dArr2);

    public static double minEnclosingTriangle(Mat mat, Mat mat2) {
        return minEnclosingTriangle_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native double minEnclosingTriangle_0(long j10, long j11);

    public static Moments moments(Mat mat, boolean z10) {
        return new Moments(moments_0(mat.nativeObj, z10));
    }

    private static native double[] moments_0(long j10, boolean z10);

    private static native double[] moments_1(long j10);

    public static void morphologyEx(Mat mat, Mat mat2, int i10, Mat mat3, Point point, int i11, int i12, Scalar scalar) {
        long j10 = mat.nativeObj;
        long j11 = mat2.nativeObj;
        long j12 = mat3.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr = scalar.val;
        morphologyEx_0(j10, j11, i10, j12, d10, d11, i11, i12, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    private static native void morphologyEx_0(long j10, long j11, int i10, long j12, double d10, double d11, int i11, int i12, double d12, double d13, double d14, double d15);

    private static native void morphologyEx_1(long j10, long j11, int i10, long j12, double d10, double d11, int i11, int i12);

    private static native void morphologyEx_2(long j10, long j11, int i10, long j12, double d10, double d11, int i11);

    private static native void morphologyEx_3(long j10, long j11, int i10, long j12, double d10, double d11);

    private static native void morphologyEx_4(long j10, long j11, int i10, long j12);

    private static native double[] n_getTextSize(String str, int i10, double d10, int i11, int[] iArr);

    public static Point phaseCorrelate(Mat mat, Mat mat2, Mat mat3, double[] dArr) {
        double[] dArr2 = new double[1];
        Point point = new Point(phaseCorrelate_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, dArr2));
        if (dArr != null) {
            dArr[0] = dArr2[0];
        }
        return point;
    }

    private static native double[] phaseCorrelate_0(long j10, long j11, long j12, double[] dArr);

    private static native double[] phaseCorrelate_1(long j10, long j11, long j12);

    private static native double[] phaseCorrelate_2(long j10, long j11);

    public static double pointPolygonTest(MatOfPoint2f matOfPoint2f, Point point, boolean z10) {
        return pointPolygonTest_0(matOfPoint2f.nativeObj, point.f35882x, point.f35883y, z10);
    }

    private static native double pointPolygonTest_0(long j10, double d10, double d11, boolean z10);

    public static void polylines(Mat mat, List<MatOfPoint> list, boolean z10, Scalar scalar, int i10, int i11, int i12) {
        Mat vector_vector_Point_to_Mat = Converters.vector_vector_Point_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j10 = mat.nativeObj;
        long j11 = vector_vector_Point_to_Mat.nativeObj;
        double[] dArr = scalar.val;
        polylines_0(j10, j11, z10, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11, i12);
    }

    private static native void polylines_0(long j10, long j11, boolean z10, double d10, double d11, double d12, double d13, int i10, int i11, int i12);

    private static native void polylines_1(long j10, long j11, boolean z10, double d10, double d11, double d12, double d13, int i10, int i11);

    private static native void polylines_2(long j10, long j11, boolean z10, double d10, double d11, double d12, double d13, int i10);

    private static native void polylines_3(long j10, long j11, boolean z10, double d10, double d11, double d12, double d13);

    public static void preCornerDetect(Mat mat, Mat mat2, int i10, int i11) {
        preCornerDetect_0(mat.nativeObj, mat2.nativeObj, i10, i11);
    }

    private static native void preCornerDetect_0(long j10, long j11, int i10, int i11);

    private static native void preCornerDetect_1(long j10, long j11, int i10);

    public static void putText(Mat mat, String str, Point point, int i10, double d10, Scalar scalar, int i11, int i12, boolean z10) {
        long j10 = mat.nativeObj;
        double d11 = point.f35882x;
        double d12 = point.f35883y;
        double[] dArr = scalar.val;
        putText_0(j10, str, d11, d12, i10, d10, dArr[0], dArr[1], dArr[2], dArr[3], i11, i12, z10);
    }

    private static native void putText_0(long j10, String str, double d10, double d11, int i10, double d12, double d13, double d14, double d15, double d16, int i11, int i12, boolean z10);

    private static native void putText_1(long j10, String str, double d10, double d11, int i10, double d12, double d13, double d14, double d15, double d16, int i11, int i12);

    private static native void putText_2(long j10, String str, double d10, double d11, int i10, double d12, double d13, double d14, double d15, double d16, int i11);

    private static native void putText_3(long j10, String str, double d10, double d11, int i10, double d12, double d13, double d14, double d15, double d16);

    public static void pyrDown(Mat mat, Mat mat2, Size size, int i10) {
        pyrDown_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, i10);
    }

    private static native void pyrDown_0(long j10, long j11, double d10, double d11, int i10);

    private static native void pyrDown_1(long j10, long j11, double d10, double d11);

    private static native void pyrDown_2(long j10, long j11);

    public static void pyrMeanShiftFiltering(Mat mat, Mat mat2, double d10, double d11, int i10, TermCriteria termCriteria) {
        pyrMeanShiftFiltering_0(mat.nativeObj, mat2.nativeObj, d10, d11, i10, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    private static native void pyrMeanShiftFiltering_0(long j10, long j11, double d10, double d11, int i10, int i11, int i12, double d12);

    private static native void pyrMeanShiftFiltering_1(long j10, long j11, double d10, double d11, int i10);

    private static native void pyrMeanShiftFiltering_2(long j10, long j11, double d10, double d11);

    public static void pyrUp(Mat mat, Mat mat2, Size size, int i10) {
        pyrUp_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, i10);
    }

    private static native void pyrUp_0(long j10, long j11, double d10, double d11, int i10);

    private static native void pyrUp_1(long j10, long j11, double d10, double d11);

    private static native void pyrUp_2(long j10, long j11);

    public static void rectangle(Mat mat, Point point, Point point2, Scalar scalar, int i10, int i11, int i12) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double d12 = point2.f35882x;
        double d13 = point2.f35883y;
        double[] dArr = scalar.val;
        rectangle_0(j10, d10, d11, d12, d13, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11, i12);
    }

    private static native void rectangle_0(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, int i10, int i11, int i12);

    private static native void rectangle_1(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, int i10, int i11);

    private static native void rectangle_2(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, int i10);

    private static native void rectangle_3(long j10, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17);

    private static native void rectangle_4(long j10, int i10, int i11, int i12, int i13, double d10, double d11, double d12, double d13, int i14, int i15, int i16);

    private static native void rectangle_5(long j10, int i10, int i11, int i12, int i13, double d10, double d11, double d12, double d13, int i14, int i15);

    private static native void rectangle_6(long j10, int i10, int i11, int i12, int i13, double d10, double d11, double d12, double d13, int i14);

    private static native void rectangle_7(long j10, int i10, int i11, int i12, int i13, double d10, double d11, double d12, double d13);

    public static void remap(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i10, int i11, Scalar scalar) {
        long j10 = mat.nativeObj;
        long j11 = mat2.nativeObj;
        long j12 = mat3.nativeObj;
        long j13 = mat4.nativeObj;
        double[] dArr = scalar.val;
        remap_0(j10, j11, j12, j13, i10, i11, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    private static native void remap_0(long j10, long j11, long j12, long j13, int i10, int i11, double d10, double d11, double d12, double d13);

    private static native void remap_1(long j10, long j11, long j12, long j13, int i10, int i11);

    private static native void remap_2(long j10, long j11, long j12, long j13, int i10);

    public static void resize(Mat mat, Mat mat2, Size size, double d10, double d11, int i10) {
        resize_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, d10, d11, i10);
    }

    private static native void resize_0(long j10, long j11, double d10, double d11, double d12, double d13, int i10);

    private static native void resize_1(long j10, long j11, double d10, double d11, double d12, double d13);

    private static native void resize_2(long j10, long j11, double d10, double d11, double d12);

    private static native void resize_3(long j10, long j11, double d10, double d11);

    public static int rotatedRectangleIntersection(RotatedRect rotatedRect, RotatedRect rotatedRect2, Mat mat) {
        Point point = rotatedRect.center;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        Size size = rotatedRect.size;
        double d12 = size.width;
        double d13 = size.height;
        double d14 = rotatedRect.angle;
        Point point2 = rotatedRect2.center;
        double d15 = point2.f35882x;
        double d16 = point2.f35883y;
        Size size2 = rotatedRect2.size;
        return rotatedRectangleIntersection_0(d10, d11, d12, d13, d14, d15, d16, size2.width, size2.height, rotatedRect2.angle, mat.nativeObj);
    }

    private static native int rotatedRectangleIntersection_0(double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19, long j10);

    public static void sepFilter2D(Mat mat, Mat mat2, int i10, Mat mat3, Mat mat4, Point point, double d10, int i11) {
        sepFilter2D_0(mat.nativeObj, mat2.nativeObj, i10, mat3.nativeObj, mat4.nativeObj, point.f35882x, point.f35883y, d10, i11);
    }

    private static native void sepFilter2D_0(long j10, long j11, int i10, long j12, long j13, double d10, double d11, double d12, int i11);

    private static native void sepFilter2D_1(long j10, long j11, int i10, long j12, long j13, double d10, double d11, double d12);

    private static native void sepFilter2D_2(long j10, long j11, int i10, long j12, long j13, double d10, double d11);

    private static native void sepFilter2D_3(long j10, long j11, int i10, long j12, long j13);

    public static void spatialGradient(Mat mat, Mat mat2, Mat mat3, int i10, int i11) {
        spatialGradient_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i10, i11);
    }

    private static native void spatialGradient_0(long j10, long j11, long j12, int i10, int i11);

    private static native void spatialGradient_1(long j10, long j11, long j12, int i10);

    private static native void spatialGradient_2(long j10, long j11, long j12);

    public static void sqrBoxFilter(Mat mat, Mat mat2, int i10, Size size, Point point, boolean z10, int i11) {
        sqrBoxFilter_0(mat.nativeObj, mat2.nativeObj, i10, size.width, size.height, point.f35882x, point.f35883y, z10, i11);
    }

    private static native void sqrBoxFilter_0(long j10, long j11, int i10, double d10, double d11, double d12, double d13, boolean z10, int i11);

    private static native void sqrBoxFilter_1(long j10, long j11, int i10, double d10, double d11, double d12, double d13, boolean z10);

    private static native void sqrBoxFilter_2(long j10, long j11, int i10, double d10, double d11, double d12, double d13);

    private static native void sqrBoxFilter_3(long j10, long j11, int i10, double d10, double d11);

    public static double threshold(Mat mat, Mat mat2, double d10, double d11, int i10) {
        return threshold_0(mat.nativeObj, mat2.nativeObj, d10, d11, i10);
    }

    private static native double threshold_0(long j10, long j11, double d10, double d11, int i10);

    public static void warpAffine(Mat mat, Mat mat2, Mat mat3, Size size, int i10, int i11, Scalar scalar) {
        long j10 = mat.nativeObj;
        long j11 = mat2.nativeObj;
        long j12 = mat3.nativeObj;
        double d10 = size.width;
        double d11 = size.height;
        double[] dArr = scalar.val;
        warpAffine_0(j10, j11, j12, d10, d11, i10, i11, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    private static native void warpAffine_0(long j10, long j11, long j12, double d10, double d11, int i10, int i11, double d12, double d13, double d14, double d15);

    private static native void warpAffine_1(long j10, long j11, long j12, double d10, double d11, int i10, int i11);

    private static native void warpAffine_2(long j10, long j11, long j12, double d10, double d11, int i10);

    private static native void warpAffine_3(long j10, long j11, long j12, double d10, double d11);

    public static void warpPerspective(Mat mat, Mat mat2, Mat mat3, Size size, int i10, int i11, Scalar scalar) {
        long j10 = mat.nativeObj;
        long j11 = mat2.nativeObj;
        long j12 = mat3.nativeObj;
        double d10 = size.width;
        double d11 = size.height;
        double[] dArr = scalar.val;
        warpPerspective_0(j10, j11, j12, d10, d11, i10, i11, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    private static native void warpPerspective_0(long j10, long j11, long j12, double d10, double d11, int i10, int i11, double d12, double d13, double d14, double d15);

    private static native void warpPerspective_1(long j10, long j11, long j12, double d10, double d11, int i10, int i11);

    private static native void warpPerspective_2(long j10, long j11, long j12, double d10, double d11, int i10);

    private static native void warpPerspective_3(long j10, long j11, long j12, double d10, double d11);

    public static void warpPolar(Mat mat, Mat mat2, Size size, Point point, double d10, int i10) {
        warpPolar_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, point.f35882x, point.f35883y, d10, i10);
    }

    private static native void warpPolar_0(long j10, long j11, double d10, double d11, double d12, double d13, double d14, int i10);

    public static void watershed(Mat mat, Mat mat2) {
        watershed_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void watershed_0(long j10, long j11);

    public static void Canny(Mat mat, Mat mat2, Mat mat3, double d10, double d11) {
        Canny_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d10, d11);
    }

    public static float EMD(Mat mat, Mat mat2, int i10, Mat mat3) {
        return EMD_1(mat.nativeObj, mat2.nativeObj, i10, mat3.nativeObj);
    }

    public static void GaussianBlur(Mat mat, Mat mat2, Size size, double d10, double d11) {
        GaussianBlur_1(mat.nativeObj, mat2.nativeObj, size.width, size.height, d10, d11);
    }

    public static void HoughCircles(Mat mat, Mat mat2, int i10, double d10, double d11, double d12, double d13, int i11) {
        HoughCircles_1(mat.nativeObj, mat2.nativeObj, i10, d10, d11, d12, d13, i11);
    }

    public static void HoughLines(Mat mat, Mat mat2, double d10, double d11, int i10, double d12, double d13, double d14) {
        HoughLines_1(mat.nativeObj, mat2.nativeObj, d10, d11, i10, d12, d13, d14);
    }

    public static void HoughLinesP(Mat mat, Mat mat2, double d10, double d11, int i10, double d12) {
        HoughLinesP_1(mat.nativeObj, mat2.nativeObj, d10, d11, i10, d12);
    }

    public static void Laplacian(Mat mat, Mat mat2, int i10, int i11, double d10, double d11) {
        Laplacian_1(mat.nativeObj, mat2.nativeObj, i10, i11, d10, d11);
    }

    public static void Scharr(Mat mat, Mat mat2, int i10, int i11, int i12, double d10, double d11) {
        Scharr_1(mat.nativeObj, mat2.nativeObj, i10, i11, i12, d10, d11);
    }

    public static void Sobel(Mat mat, Mat mat2, int i10, int i11, int i12, int i13, double d10, double d11) {
        Sobel_1(mat.nativeObj, mat2.nativeObj, i10, i11, i12, i13, d10, d11);
    }

    public static void accumulate(Mat mat, Mat mat2) {
        accumulate_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void accumulateProduct(Mat mat, Mat mat2, Mat mat3) {
        accumulateProduct_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void accumulateSquare(Mat mat, Mat mat2) {
        accumulateSquare_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void accumulateWeighted(Mat mat, Mat mat2, double d10) {
        accumulateWeighted_1(mat.nativeObj, mat2.nativeObj, d10);
    }

    public static void applyColorMap(Mat mat, Mat mat2, int i10) {
        applyColorMap_1(mat.nativeObj, mat2.nativeObj, i10);
    }

    public static void arrowedLine(Mat mat, Point point, Point point2, Scalar scalar, int i10, int i11, int i12) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double d12 = point2.f35882x;
        double d13 = point2.f35883y;
        double[] dArr = scalar.val;
        arrowedLine_1(j10, d10, d11, d12, d13, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11, i12);
    }

    public static void bilateralFilter(Mat mat, Mat mat2, int i10, double d10, double d11) {
        bilateralFilter_1(mat.nativeObj, mat2.nativeObj, i10, d10, d11);
    }

    public static void blur(Mat mat, Mat mat2, Size size, Point point) {
        blur_1(mat.nativeObj, mat2.nativeObj, size.width, size.height, point.f35882x, point.f35883y);
    }

    public static void boxFilter(Mat mat, Mat mat2, int i10, Size size, Point point, boolean z10) {
        boxFilter_1(mat.nativeObj, mat2.nativeObj, i10, size.width, size.height, point.f35882x, point.f35883y, z10);
    }

    public static void circle(Mat mat, Point point, int i10, Scalar scalar, int i11, int i12) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr = scalar.val;
        circle_1(j10, d10, d11, i10, dArr[0], dArr[1], dArr[2], dArr[3], i11, i12);
    }

    public static int connectedComponents(Mat mat, Mat mat2, int i10) {
        return connectedComponents_1(mat.nativeObj, mat2.nativeObj, i10);
    }

    public static int connectedComponentsWithStats(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i10) {
        return connectedComponentsWithStats_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i10);
    }

    public static double contourArea(Mat mat) {
        return contourArea_1(mat.nativeObj);
    }

    public static void convertMaps(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i10) {
        convertMaps_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i10);
    }

    public static void convexHull(MatOfPoint matOfPoint, MatOfInt matOfInt) {
        convexHull_2(matOfPoint.nativeObj, matOfInt.nativeObj);
    }

    public static void cornerEigenValsAndVecs(Mat mat, Mat mat2, int i10, int i11) {
        cornerEigenValsAndVecs_1(mat.nativeObj, mat2.nativeObj, i10, i11);
    }

    public static void cornerHarris(Mat mat, Mat mat2, int i10, int i11, double d10) {
        cornerHarris_1(mat.nativeObj, mat2.nativeObj, i10, i11, d10);
    }

    public static void cornerMinEigenVal(Mat mat, Mat mat2, int i10, int i11) {
        cornerMinEigenVal_1(mat.nativeObj, mat2.nativeObj, i10, i11);
    }

    public static CLAHE createCLAHE(double d10) {
        return CLAHE.__fromPtr__(createCLAHE_1(d10));
    }

    public static LineSegmentDetector createLineSegmentDetector(int i10, double d10, double d11, double d12, double d13, double d14, double d15) {
        return LineSegmentDetector.__fromPtr__(createLineSegmentDetector_1(i10, d10, d11, d12, d13, d14, d15));
    }

    public static void cvtColor(Mat mat, Mat mat2, int i10) {
        cvtColor_1(mat.nativeObj, mat2.nativeObj, i10);
    }

    public static void demosaicing(Mat mat, Mat mat2, int i10) {
        demosaicing_1(mat.nativeObj, mat2.nativeObj, i10);
    }

    public static void dilate(Mat mat, Mat mat2, Mat mat3, Point point, int i10, int i11) {
        dilate_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.f35882x, point.f35883y, i10, i11);
    }

    public static void distanceTransform(Mat mat, Mat mat2, int i10, int i11) {
        distanceTransform_1(mat.nativeObj, mat2.nativeObj, i10, i11);
    }

    public static void distanceTransformWithLabels(Mat mat, Mat mat2, Mat mat3, int i10, int i11) {
        distanceTransformWithLabels_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i10, i11);
    }

    public static void drawMarker(Mat mat, Point point, Scalar scalar, int i10, int i11, int i12) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr = scalar.val;
        drawMarker_1(j10, d10, d11, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11, i12);
    }

    public static void ellipse(Mat mat, Point point, Size size, double d10, double d11, double d12, Scalar scalar, int i10, int i11) {
        long j10 = mat.nativeObj;
        double d13 = point.f35882x;
        double d14 = point.f35883y;
        double d15 = size.width;
        double d16 = size.height;
        double[] dArr = scalar.val;
        ellipse_1(j10, d13, d14, d15, d16, d10, d11, d12, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11);
    }

    public static void erode(Mat mat, Mat mat2, Mat mat3, Point point, int i10, int i11) {
        erode_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.f35882x, point.f35883y, i10, i11);
    }

    public static void fillConvexPoly(Mat mat, MatOfPoint matOfPoint, Scalar scalar, int i10) {
        long j10 = mat.nativeObj;
        long j11 = matOfPoint.nativeObj;
        double[] dArr = scalar.val;
        fillConvexPoly_1(j10, j11, dArr[0], dArr[1], dArr[2], dArr[3], i10);
    }

    public static void filter2D(Mat mat, Mat mat2, int i10, Mat mat3, Point point, double d10) {
        filter2D_1(mat.nativeObj, mat2.nativeObj, i10, mat3.nativeObj, point.f35882x, point.f35883y, d10);
    }

    public static void getDerivKernels(Mat mat, Mat mat2, int i10, int i11, int i12, boolean z10) {
        getDerivKernels_1(mat.nativeObj, mat2.nativeObj, i10, i11, i12, z10);
    }

    public static double getFontScaleFromHeight(int i10, int i11) {
        return getFontScaleFromHeight_1(i10, i11);
    }

    public static Mat getGaborKernel(Size size, double d10, double d11, double d12, double d13, double d14) {
        return new Mat(getGaborKernel_1(size.width, size.height, d10, d11, d12, d13, d14));
    }

    public static Mat getGaussianKernel(int i10, double d10) {
        return new Mat(getGaussianKernel_1(i10, d10));
    }

    public static Mat getPerspectiveTransform(Mat mat, Mat mat2) {
        return new Mat(getPerspectiveTransform_1(mat.nativeObj, mat2.nativeObj));
    }

    public static void getRectSubPix(Mat mat, Size size, Point point, Mat mat2) {
        getRectSubPix_1(mat.nativeObj, size.width, size.height, point.f35882x, point.f35883y, mat2.nativeObj);
    }

    public static Mat getStructuringElement(int i10, Size size) {
        return new Mat(getStructuringElement_1(i10, size.width, size.height));
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i10, double d10, double d11, Mat mat2, int i11, int i12, boolean z10) {
        goodFeaturesToTrack_1(mat.nativeObj, matOfPoint.nativeObj, i10, d10, d11, mat2.nativeObj, i11, i12, z10);
    }

    public static void grabCut(Mat mat, Mat mat2, Rect rect, Mat mat3, Mat mat4, int i10) {
        grabCut_1(mat.nativeObj, mat2.nativeObj, rect.f35887x, rect.f35888y, rect.width, rect.height, mat3.nativeObj, mat4.nativeObj, i10);
    }

    public static void integral(Mat mat, Mat mat2) {
        integral_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void integral2(Mat mat, Mat mat2, Mat mat3, int i10) {
        integral2_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i10);
    }

    public static void integral3(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i10) {
        integral3_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i10);
    }

    public static float intersectConvexConvex(Mat mat, Mat mat2, Mat mat3) {
        return intersectConvexConvex_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void line(Mat mat, Point point, Point point2, Scalar scalar, int i10, int i11) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double d12 = point2.f35882x;
        double d13 = point2.f35883y;
        double[] dArr = scalar.val;
        line_1(j10, d10, d11, d12, d13, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11);
    }

    public static void matchTemplate(Mat mat, Mat mat2, Mat mat3, int i10) {
        matchTemplate_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i10);
    }

    public static Moments moments(Mat mat) {
        return new Moments(moments_1(mat.nativeObj));
    }

    public static void morphologyEx(Mat mat, Mat mat2, int i10, Mat mat3, Point point, int i11, int i12) {
        morphologyEx_1(mat.nativeObj, mat2.nativeObj, i10, mat3.nativeObj, point.f35882x, point.f35883y, i11, i12);
    }

    public static void preCornerDetect(Mat mat, Mat mat2, int i10) {
        preCornerDetect_1(mat.nativeObj, mat2.nativeObj, i10);
    }

    public static void putText(Mat mat, String str, Point point, int i10, double d10, Scalar scalar, int i11, int i12) {
        long j10 = mat.nativeObj;
        double d11 = point.f35882x;
        double d12 = point.f35883y;
        double[] dArr = scalar.val;
        putText_1(j10, str, d11, d12, i10, d10, dArr[0], dArr[1], dArr[2], dArr[3], i11, i12);
    }

    public static void pyrDown(Mat mat, Mat mat2, Size size) {
        pyrDown_1(mat.nativeObj, mat2.nativeObj, size.width, size.height);
    }

    public static void pyrMeanShiftFiltering(Mat mat, Mat mat2, double d10, double d11, int i10) {
        pyrMeanShiftFiltering_1(mat.nativeObj, mat2.nativeObj, d10, d11, i10);
    }

    public static void pyrUp(Mat mat, Mat mat2, Size size) {
        pyrUp_1(mat.nativeObj, mat2.nativeObj, size.width, size.height);
    }

    public static void rectangle(Mat mat, Point point, Point point2, Scalar scalar, int i10, int i11) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double d12 = point2.f35882x;
        double d13 = point2.f35883y;
        double[] dArr = scalar.val;
        rectangle_1(j10, d10, d11, d12, d13, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11);
    }

    public static void remap(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i10, int i11) {
        remap_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i10, i11);
    }

    public static void resize(Mat mat, Mat mat2, Size size, double d10, double d11) {
        resize_1(mat.nativeObj, mat2.nativeObj, size.width, size.height, d10, d11);
    }

    public static void sepFilter2D(Mat mat, Mat mat2, int i10, Mat mat3, Mat mat4, Point point, double d10) {
        sepFilter2D_1(mat.nativeObj, mat2.nativeObj, i10, mat3.nativeObj, mat4.nativeObj, point.f35882x, point.f35883y, d10);
    }

    public static void spatialGradient(Mat mat, Mat mat2, Mat mat3, int i10) {
        spatialGradient_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i10);
    }

    public static void sqrBoxFilter(Mat mat, Mat mat2, int i10, Size size, Point point, boolean z10) {
        sqrBoxFilter_1(mat.nativeObj, mat2.nativeObj, i10, size.width, size.height, point.f35882x, point.f35883y, z10);
    }

    public static void warpAffine(Mat mat, Mat mat2, Mat mat3, Size size, int i10, int i11) {
        warpAffine_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, i10, i11);
    }

    public static void warpPerspective(Mat mat, Mat mat2, Mat mat3, Size size, int i10, int i11) {
        warpPerspective_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, i10, i11);
    }

    public static void Canny(Mat mat, Mat mat2, double d10, double d11, int i10, boolean z10) {
        Canny_2(mat.nativeObj, mat2.nativeObj, d10, d11, i10, z10);
    }

    public static float EMD(Mat mat, Mat mat2, int i10) {
        return EMD_3(mat.nativeObj, mat2.nativeObj, i10);
    }

    public static void GaussianBlur(Mat mat, Mat mat2, Size size, double d10) {
        GaussianBlur_2(mat.nativeObj, mat2.nativeObj, size.width, size.height, d10);
    }

    public static void HoughCircles(Mat mat, Mat mat2, int i10, double d10, double d11, double d12, double d13) {
        HoughCircles_2(mat.nativeObj, mat2.nativeObj, i10, d10, d11, d12, d13);
    }

    public static void HoughLines(Mat mat, Mat mat2, double d10, double d11, int i10, double d12, double d13) {
        HoughLines_2(mat.nativeObj, mat2.nativeObj, d10, d11, i10, d12, d13);
    }

    public static void HoughLinesP(Mat mat, Mat mat2, double d10, double d11, int i10) {
        HoughLinesP_2(mat.nativeObj, mat2.nativeObj, d10, d11, i10);
    }

    public static void Laplacian(Mat mat, Mat mat2, int i10, int i11, double d10) {
        Laplacian_2(mat.nativeObj, mat2.nativeObj, i10, i11, d10);
    }

    public static void Scharr(Mat mat, Mat mat2, int i10, int i11, int i12, double d10) {
        Scharr_2(mat.nativeObj, mat2.nativeObj, i10, i11, i12, d10);
    }

    public static void Sobel(Mat mat, Mat mat2, int i10, int i11, int i12, int i13, double d10) {
        Sobel_2(mat.nativeObj, mat2.nativeObj, i10, i11, i12, i13, d10);
    }

    public static void arrowedLine(Mat mat, Point point, Point point2, Scalar scalar, int i10, int i11) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double d12 = point2.f35882x;
        double d13 = point2.f35883y;
        double[] dArr = scalar.val;
        arrowedLine_2(j10, d10, d11, d12, d13, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11);
    }

    public static void blur(Mat mat, Mat mat2, Size size) {
        blur_2(mat.nativeObj, mat2.nativeObj, size.width, size.height);
    }

    public static void boxFilter(Mat mat, Mat mat2, int i10, Size size, Point point) {
        boxFilter_2(mat.nativeObj, mat2.nativeObj, i10, size.width, size.height, point.f35882x, point.f35883y);
    }

    public static void calcHist(List<Mat> list, MatOfInt matOfInt, Mat mat, Mat mat2, MatOfInt matOfInt2, MatOfFloat matOfFloat) {
        calcHist_1(Converters.vector_Mat_to_Mat(list).nativeObj, matOfInt.nativeObj, mat.nativeObj, mat2.nativeObj, matOfInt2.nativeObj, matOfFloat.nativeObj);
    }

    public static void circle(Mat mat, Point point, int i10, Scalar scalar, int i11) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr = scalar.val;
        circle_2(j10, d10, d11, i10, dArr[0], dArr[1], dArr[2], dArr[3], i11);
    }

    public static int connectedComponents(Mat mat, Mat mat2) {
        return connectedComponents_2(mat.nativeObj, mat2.nativeObj);
    }

    public static int connectedComponentsWithStats(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        return connectedComponentsWithStats_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void cornerMinEigenVal(Mat mat, Mat mat2, int i10) {
        cornerMinEigenVal_2(mat.nativeObj, mat2.nativeObj, i10);
    }

    public static CLAHE createCLAHE() {
        return CLAHE.__fromPtr__(createCLAHE_2());
    }

    public static LineSegmentDetector createLineSegmentDetector(int i10, double d10, double d11, double d12, double d13, double d14) {
        return LineSegmentDetector.__fromPtr__(createLineSegmentDetector_2(i10, d10, d11, d12, d13, d14));
    }

    public static void dilate(Mat mat, Mat mat2, Mat mat3, Point point, int i10) {
        dilate_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.f35882x, point.f35883y, i10);
    }

    public static void drawMarker(Mat mat, Point point, Scalar scalar, int i10, int i11) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr = scalar.val;
        drawMarker_2(j10, d10, d11, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11);
    }

    public static void ellipse(Mat mat, Point point, Size size, double d10, double d11, double d12, Scalar scalar, int i10) {
        long j10 = mat.nativeObj;
        double d13 = point.f35882x;
        double d14 = point.f35883y;
        double d15 = size.width;
        double d16 = size.height;
        double[] dArr = scalar.val;
        ellipse_2(j10, d13, d14, d15, d16, d10, d11, d12, dArr[0], dArr[1], dArr[2], dArr[3], i10);
    }

    public static void erode(Mat mat, Mat mat2, Mat mat3, Point point, int i10) {
        erode_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.f35882x, point.f35883y, i10);
    }

    public static void fillConvexPoly(Mat mat, MatOfPoint matOfPoint, Scalar scalar) {
        long j10 = mat.nativeObj;
        long j11 = matOfPoint.nativeObj;
        double[] dArr = scalar.val;
        fillConvexPoly_2(j10, j11, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static void filter2D(Mat mat, Mat mat2, int i10, Mat mat3, Point point) {
        filter2D_2(mat.nativeObj, mat2.nativeObj, i10, mat3.nativeObj, point.f35882x, point.f35883y);
    }

    public static void getDerivKernels(Mat mat, Mat mat2, int i10, int i11, int i12) {
        getDerivKernels_2(mat.nativeObj, mat2.nativeObj, i10, i11, i12);
    }

    public static Mat getGaborKernel(Size size, double d10, double d11, double d12, double d13) {
        return new Mat(getGaborKernel_2(size.width, size.height, d10, d11, d12, d13));
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i10, double d10, double d11, Mat mat2, int i11, int i12) {
        goodFeaturesToTrack_2(mat.nativeObj, matOfPoint.nativeObj, i10, d10, d11, mat2.nativeObj, i11, i12);
    }

    public static void integral2(Mat mat, Mat mat2, Mat mat3) {
        integral2_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void integral3(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        integral3_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void line(Mat mat, Point point, Point point2, Scalar scalar, int i10) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double d12 = point2.f35882x;
        double d13 = point2.f35883y;
        double[] dArr = scalar.val;
        line_2(j10, d10, d11, d12, d13, dArr[0], dArr[1], dArr[2], dArr[3], i10);
    }

    public static void morphologyEx(Mat mat, Mat mat2, int i10, Mat mat3, Point point, int i11) {
        morphologyEx_2(mat.nativeObj, mat2.nativeObj, i10, mat3.nativeObj, point.f35882x, point.f35883y, i11);
    }

    public static void putText(Mat mat, String str, Point point, int i10, double d10, Scalar scalar, int i11) {
        long j10 = mat.nativeObj;
        double d11 = point.f35882x;
        double d12 = point.f35883y;
        double[] dArr = scalar.val;
        putText_2(j10, str, d11, d12, i10, d10, dArr[0], dArr[1], dArr[2], dArr[3], i11);
    }

    public static void pyrDown(Mat mat, Mat mat2) {
        pyrDown_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void pyrMeanShiftFiltering(Mat mat, Mat mat2, double d10, double d11) {
        pyrMeanShiftFiltering_2(mat.nativeObj, mat2.nativeObj, d10, d11);
    }

    public static void pyrUp(Mat mat, Mat mat2) {
        pyrUp_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void rectangle(Mat mat, Point point, Point point2, Scalar scalar, int i10) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double d12 = point2.f35882x;
        double d13 = point2.f35883y;
        double[] dArr = scalar.val;
        rectangle_2(j10, d10, d11, d12, d13, dArr[0], dArr[1], dArr[2], dArr[3], i10);
    }

    public static void remap(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i10) {
        remap_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i10);
    }

    public static void resize(Mat mat, Mat mat2, Size size, double d10) {
        resize_2(mat.nativeObj, mat2.nativeObj, size.width, size.height, d10);
    }

    public static void sepFilter2D(Mat mat, Mat mat2, int i10, Mat mat3, Mat mat4, Point point) {
        sepFilter2D_2(mat.nativeObj, mat2.nativeObj, i10, mat3.nativeObj, mat4.nativeObj, point.f35882x, point.f35883y);
    }

    public static void spatialGradient(Mat mat, Mat mat2, Mat mat3) {
        spatialGradient_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void sqrBoxFilter(Mat mat, Mat mat2, int i10, Size size, Point point) {
        sqrBoxFilter_2(mat.nativeObj, mat2.nativeObj, i10, size.width, size.height, point.f35882x, point.f35883y);
    }

    public static void warpAffine(Mat mat, Mat mat2, Mat mat3, Size size, int i10) {
        warpAffine_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, i10);
    }

    public static void warpPerspective(Mat mat, Mat mat2, Mat mat3, Size size, int i10) {
        warpPerspective_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, i10);
    }

    public static void Canny(Mat mat, Mat mat2, double d10, double d11, int i10) {
        Canny_3(mat.nativeObj, mat2.nativeObj, d10, d11, i10);
    }

    public static void HoughCircles(Mat mat, Mat mat2, int i10, double d10, double d11, double d12) {
        HoughCircles_3(mat.nativeObj, mat2.nativeObj, i10, d10, d11, d12);
    }

    public static void HoughLines(Mat mat, Mat mat2, double d10, double d11, int i10, double d12) {
        HoughLines_3(mat.nativeObj, mat2.nativeObj, d10, d11, i10, d12);
    }

    public static void Laplacian(Mat mat, Mat mat2, int i10, int i11) {
        Laplacian_3(mat.nativeObj, mat2.nativeObj, i10, i11);
    }

    public static void Scharr(Mat mat, Mat mat2, int i10, int i11, int i12) {
        Scharr_3(mat.nativeObj, mat2.nativeObj, i10, i11, i12);
    }

    public static void Sobel(Mat mat, Mat mat2, int i10, int i11, int i12, int i13) {
        Sobel_3(mat.nativeObj, mat2.nativeObj, i10, i11, i12, i13);
    }

    public static void arrowedLine(Mat mat, Point point, Point point2, Scalar scalar, int i10) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double d12 = point2.f35882x;
        double d13 = point2.f35883y;
        double[] dArr = scalar.val;
        arrowedLine_3(j10, d10, d11, d12, d13, dArr[0], dArr[1], dArr[2], dArr[3], i10);
    }

    public static void boxFilter(Mat mat, Mat mat2, int i10, Size size) {
        boxFilter_3(mat.nativeObj, mat2.nativeObj, i10, size.width, size.height);
    }

    public static void circle(Mat mat, Point point, int i10, Scalar scalar) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr = scalar.val;
        circle_3(j10, d10, d11, i10, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static LineSegmentDetector createLineSegmentDetector(int i10, double d10, double d11, double d12, double d13) {
        return LineSegmentDetector.__fromPtr__(createLineSegmentDetector_3(i10, d10, d11, d12, d13));
    }

    public static void dilate(Mat mat, Mat mat2, Mat mat3, Point point) {
        dilate_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.f35882x, point.f35883y);
    }

    public static void drawContours(Mat mat, List<MatOfPoint> list, int i10, Scalar scalar, int i11, int i12, Mat mat2, int i13) {
        Mat vector_vector_Point_to_Mat = Converters.vector_vector_Point_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j10 = mat.nativeObj;
        long j11 = vector_vector_Point_to_Mat.nativeObj;
        double[] dArr = scalar.val;
        drawContours_1(j10, j11, i10, dArr[0], dArr[1], dArr[2], dArr[3], i11, i12, mat2.nativeObj, i13);
    }

    public static void drawMarker(Mat mat, Point point, Scalar scalar, int i10) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr = scalar.val;
        drawMarker_3(j10, d10, d11, dArr[0], dArr[1], dArr[2], dArr[3], i10);
    }

    public static void ellipse(Mat mat, Point point, Size size, double d10, double d11, double d12, Scalar scalar) {
        long j10 = mat.nativeObj;
        double d13 = point.f35882x;
        double d14 = point.f35883y;
        double d15 = size.width;
        double d16 = size.height;
        double[] dArr = scalar.val;
        ellipse_3(j10, d13, d14, d15, d16, d10, d11, d12, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static void erode(Mat mat, Mat mat2, Mat mat3, Point point) {
        erode_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.f35882x, point.f35883y);
    }

    public static void fillPoly(Mat mat, List<MatOfPoint> list, Scalar scalar, int i10, int i11) {
        Mat vector_vector_Point_to_Mat = Converters.vector_vector_Point_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j10 = mat.nativeObj;
        long j11 = vector_vector_Point_to_Mat.nativeObj;
        double[] dArr = scalar.val;
        fillPoly_1(j10, j11, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11);
    }

    public static void filter2D(Mat mat, Mat mat2, int i10, Mat mat3) {
        filter2D_3(mat.nativeObj, mat2.nativeObj, i10, mat3.nativeObj);
    }

    public static int floodFill(Mat mat, Mat mat2, Point point, Scalar scalar, Rect rect, Scalar scalar2, Scalar scalar3) {
        double[] dArr = new double[4];
        long j10 = mat.nativeObj;
        long j11 = mat2.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr2 = scalar.val;
        double d12 = dArr2[0];
        double d13 = dArr2[1];
        double d14 = dArr2[2];
        double d15 = dArr2[3];
        double[] dArr3 = scalar2.val;
        double d16 = dArr3[0];
        double d17 = dArr3[1];
        double d18 = dArr3[2];
        double d19 = dArr3[3];
        double[] dArr4 = scalar3.val;
        int floodFill_1 = floodFill_1(j10, j11, d10, d11, d12, d13, d14, d15, dArr, d16, d17, d18, d19, dArr4[0], dArr4[1], dArr4[2], dArr4[3]);
        if (rect != null) {
            rect.f35887x = (int) dArr[0];
            rect.f35888y = (int) dArr[1];
            rect.width = (int) dArr[2];
            rect.height = (int) dArr[3];
        }
        return floodFill_1;
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i10, double d10, double d11, Mat mat2, int i11, boolean z10, double d12) {
        goodFeaturesToTrack_3(mat.nativeObj, matOfPoint.nativeObj, i10, d10, d11, mat2.nativeObj, i11, z10, d12);
    }

    public static void line(Mat mat, Point point, Point point2, Scalar scalar) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double d12 = point2.f35882x;
        double d13 = point2.f35883y;
        double[] dArr = scalar.val;
        line_3(j10, d10, d11, d12, d13, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static void morphologyEx(Mat mat, Mat mat2, int i10, Mat mat3, Point point) {
        morphologyEx_3(mat.nativeObj, mat2.nativeObj, i10, mat3.nativeObj, point.f35882x, point.f35883y);
    }

    public static Point phaseCorrelate(Mat mat, Mat mat2, Mat mat3) {
        return new Point(phaseCorrelate_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj));
    }

    public static void polylines(Mat mat, List<MatOfPoint> list, boolean z10, Scalar scalar, int i10, int i11) {
        Mat vector_vector_Point_to_Mat = Converters.vector_vector_Point_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j10 = mat.nativeObj;
        long j11 = vector_vector_Point_to_Mat.nativeObj;
        double[] dArr = scalar.val;
        polylines_1(j10, j11, z10, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11);
    }

    public static void putText(Mat mat, String str, Point point, int i10, double d10, Scalar scalar) {
        long j10 = mat.nativeObj;
        double d11 = point.f35882x;
        double d12 = point.f35883y;
        double[] dArr = scalar.val;
        putText_3(j10, str, d11, d12, i10, d10, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static void rectangle(Mat mat, Point point, Point point2, Scalar scalar) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double d12 = point2.f35882x;
        double d13 = point2.f35883y;
        double[] dArr = scalar.val;
        rectangle_3(j10, d10, d11, d12, d13, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static void resize(Mat mat, Mat mat2, Size size) {
        resize_3(mat.nativeObj, mat2.nativeObj, size.width, size.height);
    }

    public static void sepFilter2D(Mat mat, Mat mat2, int i10, Mat mat3, Mat mat4) {
        sepFilter2D_3(mat.nativeObj, mat2.nativeObj, i10, mat3.nativeObj, mat4.nativeObj);
    }

    public static void sqrBoxFilter(Mat mat, Mat mat2, int i10, Size size) {
        sqrBoxFilter_3(mat.nativeObj, mat2.nativeObj, i10, size.width, size.height);
    }

    public static void warpAffine(Mat mat, Mat mat2, Mat mat3, Size size) {
        warpAffine_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height);
    }

    public static void warpPerspective(Mat mat, Mat mat2, Mat mat3, Size size) {
        warpPerspective_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height);
    }

    public static void Canny(Mat mat, Mat mat2, double d10, double d11) {
        Canny_4(mat.nativeObj, mat2.nativeObj, d10, d11);
    }

    public static void HoughCircles(Mat mat, Mat mat2, int i10, double d10, double d11) {
        HoughCircles_4(mat.nativeObj, mat2.nativeObj, i10, d10, d11);
    }

    public static void HoughLines(Mat mat, Mat mat2, double d10, double d11, int i10) {
        HoughLines_4(mat.nativeObj, mat2.nativeObj, d10, d11, i10);
    }

    public static void Laplacian(Mat mat, Mat mat2, int i10) {
        Laplacian_4(mat.nativeObj, mat2.nativeObj, i10);
    }

    public static void Sobel(Mat mat, Mat mat2, int i10, int i11, int i12) {
        Sobel_4(mat.nativeObj, mat2.nativeObj, i10, i11, i12);
    }

    public static void arrowedLine(Mat mat, Point point, Point point2, Scalar scalar) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double d12 = point2.f35882x;
        double d13 = point2.f35883y;
        double[] dArr = scalar.val;
        arrowedLine_4(j10, d10, d11, d12, d13, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static LineSegmentDetector createLineSegmentDetector(int i10, double d10, double d11, double d12) {
        return LineSegmentDetector.__fromPtr__(createLineSegmentDetector_4(i10, d10, d11, d12));
    }

    public static void dilate(Mat mat, Mat mat2, Mat mat3) {
        dilate_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void drawMarker(Mat mat, Point point, Scalar scalar) {
        long j10 = mat.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr = scalar.val;
        drawMarker_4(j10, d10, d11, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static void ellipse(Mat mat, RotatedRect rotatedRect, Scalar scalar, int i10, int i11) {
        long j10 = mat.nativeObj;
        Point point = rotatedRect.center;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        Size size = rotatedRect.size;
        double d12 = size.width;
        double d13 = size.height;
        double d14 = rotatedRect.angle;
        double[] dArr = scalar.val;
        ellipse_4(j10, d10, d11, d12, d13, d14, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11);
    }

    public static void erode(Mat mat, Mat mat2, Mat mat3) {
        erode_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void findContours(Mat mat, List<MatOfPoint> list, Mat mat2, int i10, int i11) {
        Mat mat3 = new Mat();
        findContours_1(mat.nativeObj, mat3.nativeObj, mat2.nativeObj, i10, i11);
        Converters.Mat_to_vector_vector_Point(mat3, list);
        mat3.release();
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i10, double d10, double d11, Mat mat2, int i11, boolean z10) {
        goodFeaturesToTrack_4(mat.nativeObj, matOfPoint.nativeObj, i10, d10, d11, mat2.nativeObj, i11, z10);
    }

    public static void morphologyEx(Mat mat, Mat mat2, int i10, Mat mat3) {
        morphologyEx_4(mat.nativeObj, mat2.nativeObj, i10, mat3.nativeObj);
    }

    public static Point phaseCorrelate(Mat mat, Mat mat2) {
        return new Point(phaseCorrelate_2(mat.nativeObj, mat2.nativeObj));
    }

    public static void rectangle(Mat mat, Rect rect, Scalar scalar, int i10, int i11, int i12) {
        long j10 = mat.nativeObj;
        int i13 = rect.f35887x;
        int i14 = rect.f35888y;
        int i15 = rect.width;
        int i16 = rect.height;
        double[] dArr = scalar.val;
        rectangle_4(j10, i13, i14, i15, i16, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11, i12);
    }

    public static LineSegmentDetector createLineSegmentDetector(int i10, double d10, double d11) {
        return LineSegmentDetector.__fromPtr__(createLineSegmentDetector_5(i10, d10, d11));
    }

    public static void ellipse(Mat mat, RotatedRect rotatedRect, Scalar scalar, int i10) {
        long j10 = mat.nativeObj;
        Point point = rotatedRect.center;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        Size size = rotatedRect.size;
        double d12 = size.width;
        double d13 = size.height;
        double d14 = rotatedRect.angle;
        double[] dArr = scalar.val;
        ellipse_5(j10, d10, d11, d12, d13, d14, dArr[0], dArr[1], dArr[2], dArr[3], i10);
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i10, double d10, double d11, Mat mat2, int i11) {
        goodFeaturesToTrack_5(mat.nativeObj, matOfPoint.nativeObj, i10, d10, d11, mat2.nativeObj, i11);
    }

    public static void rectangle(Mat mat, Rect rect, Scalar scalar, int i10, int i11) {
        long j10 = mat.nativeObj;
        int i12 = rect.f35887x;
        int i13 = rect.f35888y;
        int i14 = rect.width;
        int i15 = rect.height;
        double[] dArr = scalar.val;
        rectangle_5(j10, i12, i13, i14, i15, dArr[0], dArr[1], dArr[2], dArr[3], i10, i11);
    }

    public static LineSegmentDetector createLineSegmentDetector(int i10, double d10) {
        return LineSegmentDetector.__fromPtr__(createLineSegmentDetector_6(i10, d10));
    }

    public static void drawContours(Mat mat, List<MatOfPoint> list, int i10, Scalar scalar, int i11, int i12, Mat mat2) {
        Mat vector_vector_Point_to_Mat = Converters.vector_vector_Point_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j10 = mat.nativeObj;
        long j11 = vector_vector_Point_to_Mat.nativeObj;
        double[] dArr = scalar.val;
        drawContours_2(j10, j11, i10, dArr[0], dArr[1], dArr[2], dArr[3], i11, i12, mat2.nativeObj);
    }

    public static void ellipse(Mat mat, RotatedRect rotatedRect, Scalar scalar) {
        long j10 = mat.nativeObj;
        Point point = rotatedRect.center;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        Size size = rotatedRect.size;
        double d12 = size.width;
        double d13 = size.height;
        double d14 = rotatedRect.angle;
        double[] dArr = scalar.val;
        ellipse_6(j10, d10, d11, d12, d13, d14, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static void fillPoly(Mat mat, List<MatOfPoint> list, Scalar scalar, int i10) {
        Mat vector_vector_Point_to_Mat = Converters.vector_vector_Point_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j10 = mat.nativeObj;
        long j11 = vector_vector_Point_to_Mat.nativeObj;
        double[] dArr = scalar.val;
        fillPoly_2(j10, j11, dArr[0], dArr[1], dArr[2], dArr[3], i10);
    }

    public static int floodFill(Mat mat, Mat mat2, Point point, Scalar scalar, Rect rect, Scalar scalar2) {
        double[] dArr = new double[4];
        long j10 = mat.nativeObj;
        long j11 = mat2.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr2 = scalar.val;
        double d12 = dArr2[0];
        double d13 = dArr2[1];
        double d14 = dArr2[2];
        double d15 = dArr2[3];
        double[] dArr3 = scalar2.val;
        int floodFill_2 = floodFill_2(j10, j11, d10, d11, d12, d13, d14, d15, dArr, dArr3[0], dArr3[1], dArr3[2], dArr3[3]);
        if (rect != null) {
            rect.f35887x = (int) dArr[0];
            rect.f35888y = (int) dArr[1];
            rect.width = (int) dArr[2];
            rect.height = (int) dArr[3];
        }
        return floodFill_2;
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i10, double d10, double d11, Mat mat2) {
        goodFeaturesToTrack_6(mat.nativeObj, matOfPoint.nativeObj, i10, d10, d11, mat2.nativeObj);
    }

    public static void polylines(Mat mat, List<MatOfPoint> list, boolean z10, Scalar scalar, int i10) {
        Mat vector_vector_Point_to_Mat = Converters.vector_vector_Point_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j10 = mat.nativeObj;
        long j11 = vector_vector_Point_to_Mat.nativeObj;
        double[] dArr = scalar.val;
        polylines_2(j10, j11, z10, dArr[0], dArr[1], dArr[2], dArr[3], i10);
    }

    public static void rectangle(Mat mat, Rect rect, Scalar scalar, int i10) {
        long j10 = mat.nativeObj;
        int i11 = rect.f35887x;
        int i12 = rect.f35888y;
        int i13 = rect.width;
        int i14 = rect.height;
        double[] dArr = scalar.val;
        rectangle_6(j10, i11, i12, i13, i14, dArr[0], dArr[1], dArr[2], dArr[3], i10);
    }

    public static LineSegmentDetector createLineSegmentDetector(int i10) {
        return LineSegmentDetector.__fromPtr__(createLineSegmentDetector_7(i10));
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i10, double d10, double d11) {
        goodFeaturesToTrack_7(mat.nativeObj, matOfPoint.nativeObj, i10, d10, d11);
    }

    public static void rectangle(Mat mat, Rect rect, Scalar scalar) {
        long j10 = mat.nativeObj;
        int i10 = rect.f35887x;
        int i11 = rect.f35888y;
        int i12 = rect.width;
        int i13 = rect.height;
        double[] dArr = scalar.val;
        rectangle_7(j10, i10, i11, i12, i13, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static LineSegmentDetector createLineSegmentDetector() {
        return LineSegmentDetector.__fromPtr__(createLineSegmentDetector_8());
    }

    public static void drawContours(Mat mat, List<MatOfPoint> list, int i10, Scalar scalar, int i11, int i12) {
        Mat vector_vector_Point_to_Mat = Converters.vector_vector_Point_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j10 = mat.nativeObj;
        long j11 = vector_vector_Point_to_Mat.nativeObj;
        double[] dArr = scalar.val;
        drawContours_3(j10, j11, i10, dArr[0], dArr[1], dArr[2], dArr[3], i11, i12);
    }

    public static void fillPoly(Mat mat, List<MatOfPoint> list, Scalar scalar) {
        Mat vector_vector_Point_to_Mat = Converters.vector_vector_Point_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j10 = mat.nativeObj;
        long j11 = vector_vector_Point_to_Mat.nativeObj;
        double[] dArr = scalar.val;
        fillPoly_3(j10, j11, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static int floodFill(Mat mat, Mat mat2, Point point, Scalar scalar, Rect rect) {
        double[] dArr = new double[4];
        long j10 = mat.nativeObj;
        long j11 = mat2.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr2 = scalar.val;
        int floodFill_3 = floodFill_3(j10, j11, d10, d11, dArr2[0], dArr2[1], dArr2[2], dArr2[3], dArr);
        if (rect != null) {
            rect.f35887x = (int) dArr[0];
            rect.f35888y = (int) dArr[1];
            rect.width = (int) dArr[2];
            rect.height = (int) dArr[3];
        }
        return floodFill_3;
    }

    public static void polylines(Mat mat, List<MatOfPoint> list, boolean z10, Scalar scalar) {
        Mat vector_vector_Point_to_Mat = Converters.vector_vector_Point_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j10 = mat.nativeObj;
        long j11 = vector_vector_Point_to_Mat.nativeObj;
        double[] dArr = scalar.val;
        polylines_3(j10, j11, z10, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static void drawContours(Mat mat, List<MatOfPoint> list, int i10, Scalar scalar, int i11) {
        Mat vector_vector_Point_to_Mat = Converters.vector_vector_Point_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j10 = mat.nativeObj;
        long j11 = vector_vector_Point_to_Mat.nativeObj;
        double[] dArr = scalar.val;
        drawContours_4(j10, j11, i10, dArr[0], dArr[1], dArr[2], dArr[3], i11);
    }

    public static int floodFill(Mat mat, Mat mat2, Point point, Scalar scalar) {
        long j10 = mat.nativeObj;
        long j11 = mat2.nativeObj;
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double[] dArr = scalar.val;
        return floodFill_4(j10, j11, d10, d11, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static void drawContours(Mat mat, List<MatOfPoint> list, int i10, Scalar scalar) {
        Mat vector_vector_Point_to_Mat = Converters.vector_vector_Point_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j10 = mat.nativeObj;
        long j11 = vector_vector_Point_to_Mat.nativeObj;
        double[] dArr = scalar.val;
        drawContours_5(j10, j11, i10, dArr[0], dArr[1], dArr[2], dArr[3]);
    }
}
