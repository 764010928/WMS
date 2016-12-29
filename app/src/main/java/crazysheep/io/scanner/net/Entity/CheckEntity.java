package crazysheep.io.scanner.net.Entity;

/**
 * Created by Bing on 2016/12/23.
 */

public class CheckEntity {

    /**
     * success : false
     * errCode : not-founds
     * errMsg : Target product null doesn't exist
     * data : null
     */

    private boolean success;
    private String errCode;
    private String errMsg;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
