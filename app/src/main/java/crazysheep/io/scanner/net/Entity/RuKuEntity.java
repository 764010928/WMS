package crazysheep.io.scanner.net.Entity;

import java.util.List;

/**
 * Created by Bing on 2017/1/5.
 */

public class RuKuEntity {

    /**
     * success : true
     * errCode :
     * errMsg :
     * data : {"total":1,"data":[{"code":"IN_111","actualCount":null,"typeName":"采购入库","statusName":"未完成","creatorName":"creatorTODO","from":"fromTODO","expectedCount":5,"to":"toTODO","taskId":null}],"pageSize":20,"page":1}
     */

    private boolean success;
    private String errCode;
    private String errMsg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * total : 1
         * data : [{"code":"IN_111","actualCount":null,"typeName":"采购入库","statusName":"未完成","creatorName":"creatorTODO","from":"fromTODO","expectedCount":5,"to":"toTODO","taskId":null}]
         * pageSize : 20
         * page : 1
         */

        private int total;
        private int pageSize;
        private int page;
        private List<DataBean> data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * code : IN_111
             * actualCount : null
             * typeName : 采购入库
             * statusName : 未完成
             * creatorName : creatorTODO
             * from : fromTODO
             * expectedCount : 5
             * to : toTODO
             * taskId : null
             */

            private String code;
            private Integer actualCount;
            private String typeName;
            private String statusName;
            private String creatorName;
            private String from;
            private int expectedCount;
            private String to;
            private String taskId;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public Integer getActualCount() {
                return actualCount;
            }

            public void setActualCount(Integer actualCount) {
                this.actualCount = actualCount;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public String getStatusName() {
                return statusName;
            }

            public void setStatusName(String statusName) {
                this.statusName = statusName;
            }

            public String getCreatorName() {
                return creatorName;
            }

            public void setCreatorName(String creatorName) {
                this.creatorName = creatorName;
            }

            public String getFrom() {
                return from;
            }

            public void setFrom(String from) {
                this.from = from;
            }

            public int getExpectedCount() {
                return expectedCount;
            }

            public void setExpectedCount(int expectedCount) {
                this.expectedCount = expectedCount;
            }

            public String getTo() {
                return to;
            }

            public void setTo(String to) {
                this.to = to;
            }

            public String getTaskId() {
                return taskId;
            }

            public void setTaskId(String taskId) {
                this.taskId = taskId;
            }
        }
    }
}
