package crazysheep.io.scanner.net.Entity;

import java.util.List;

/**
 * Created by Bing on 2017/1/6.
 */

public class RuKuDetailEntity {

    /**
     * success : true
     * errCode :
     * errMsg :
     * data : {"code":"IN_111","operators":[{}],"from":"fromTODO","to":"toTODO","taskId":0,"products":[{"productCode":"1234567890","actualCount":1,"name":"测试","expectedCount":5}]}
     */

    private boolean success;
    private String errCode;
    private String errMsg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * code : IN_111
         * operators : [{}]
         * from : fromTODO
         * to : toTODO
         * taskId : 0
         * products : [{"productCode":"1234567890","actualCount":1,"name":"测试","expectedCount":5}]
         */

        private String code;
        private String from;
        private String to;
        private int taskId;
        private String statusName;

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        private List<OperatorsBean> operators;
        private List<ProductsBean> products;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public List<OperatorsBean> getOperators() {
            return operators;
        }

        public void setOperators(List<OperatorsBean> operators) {
            this.operators = operators;
        }

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class OperatorsBean {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ProductsBean {
            /**
             * productCode : 1234567890
             * actualCount : 1
             * name : 测试
             * expectedCount : 5
             */

            private String productCode;
            private int actualCount;
            private String name;
            private int expectedCount;

            public String getProductCode() {
                return productCode;
            }

            public void setProductCode(String productCode) {
                this.productCode = productCode;
            }

            public int getActualCount() {
                return actualCount;
            }

            public void setActualCount(int actualCount) {
                this.actualCount = actualCount;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getExpectedCount() {
                return expectedCount;
            }

            public void setExpectedCount(int expectedCount) {
                this.expectedCount = expectedCount;
            }
        }
    }
}
