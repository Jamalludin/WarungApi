package com.warung.makmi.warungapi.common;

public class StatusCode {

    public static final String SERVICE_NOT_FOUND = "0000";

    //for status proccess db or system info start with 00
    public static final String SAVE_SUCCESS = "0010";
    public static final String SAVE_DATA_EXIST = "0011";

    public static final String UPDATE_FAILED = "0012";
    public static final String UPDATE_SUCCESS = "0013";

    public static final String DELETE_SUCCESS = "0014";
    public static final String DELETE_FAILED = "0015";

    public static final String UPLOAD_FAILED = "0016";
    public static final String UPLOAD_SUCCESS = "0017";

    public static final String CONNECTION_FAILED = "0018";
    public static final String SYSTEM_EXCEPTION = "0019";
    public static final String DB_EXCEPTION = "0020";
    public static final String DATA_NOT_FOUND = "0021";
    public static final String DATA_EXCEED_LIMIT = "0022";
    public static final String ILLEGAL_ACCESS = "0023";

    //common operation
    public static final String LOGIN_SUCCESS = "1101";
    public static final String LOGIN_FAILED = "1102";
    public static final String PASSWORD_OR_USER_NOT_REGISTERED = "1103";
    public static final String MAIL_NOT_FOUND = "1202";
    public static final String PASSWORD_NOT_VALID = "1106";
    public static final String TOKEN_NOT_VALID = "1107";
    public static final String USER_EXIST = "1104";
    public static final String MAIL_EXIST = "1201";
    public static final String USERNAME_EXIST = "1203";
    public static final String SESSION_EXPIRED = "1105";

    public static final String INPUT_NOT_VALID = "1111";
    public static final String OPERATION_COMPLETE = "1112";
    public static final String OPERATION_FAILED = "1113";

    public static final String SECRET_CODE = "SECRET_CODE";
    public static final String TOTP_URL = "TOTP_URL";

    private String value;

    public StatusCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
