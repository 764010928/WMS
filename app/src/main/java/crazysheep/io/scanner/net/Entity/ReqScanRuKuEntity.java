package crazysheep.io.scanner.net.Entity;

/**
 * Created by Bing on 2017/1/6.
 */

public class ReqScanRuKuEntity {

    /**
     * productCode : 1234567890
     * code : IN_111
     * operatorId : 2
     * taskId : 111
     */

    private String productCode;
    private String code;
    private String operatorId;
    private String taskId;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
