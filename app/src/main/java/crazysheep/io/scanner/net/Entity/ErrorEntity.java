package crazysheep.io.scanner.net.Entity;

/**
 * Created by Bing on 2016/12/13.
 */

public class ErrorEntity {
    private String errorCode;
    private String errorMsg;

    public ErrorEntity(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
