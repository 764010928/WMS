package crazysheep.io.scanner.net.Entity;

/**
 * Created by Bing on 2016/12/8.
 */

public class LoginEntity {

    /**
     * success : true
     * errCode : null
     * errMsg : null
     * data : {"token":"30fa38c3fa3808017d123eda70aae234"}
     */

    private boolean success;
    private Object errCode;
    private Object errMsg;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getErrCode() {
        return errCode;
    }

    public void setErrCode(Object errCode) {
        this.errCode = errCode;
    }

    public Object getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(Object errMsg) {
        this.errMsg = errMsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * token : 30fa38c3fa3808017d123eda70aae234
         */

        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    @Override
    public String toString() {
        return "success:"+success+" errCode"+errCode+" errMsg"+errMsg+" ";
    }
}
