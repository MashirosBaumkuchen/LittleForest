package com.jascal.clare;

import java.security.PublicKey;

/**
 * @author No.47 create at 2017/9/1.
 */
public class Constant {
    /**
     * history of today
     *
     * @author No.47
     * create at 2017/9/1 10:02
     */
    public static final String HISTORY_OF_TODAY_URL = "http://api.juheapi.com/";
    public static final String HISTORY_OF_TODAY_ACTION = "/japi/toh";
    public static final String HISTORY_OF_TODAY_KEY = "eff36bdaeeb868a6b8057a34f32d1326";
    public static final String HISTORY_OF_TODAY_VERSION = "1.0";
    public static final String HISTORY_OF_TODAY_ERROR_CODE = "error_code";
    public static final int HISTORY_OF_TODAY_SUCCESS_CODE = 0;
    public static final String HISTORY_OF_TODAY_SUCCESS_RESULT = "result";
    public static final String HISTORY_OF_TODAY_REASON = "reason";

    /**
     * is debug or release
     *
     * @author No.47
     * create at 2017/9/5 10:42
     */
    public static final boolean DEBUG = false;
    public static final boolean RELEASE = true;
}
