package crazysheep.io.scanner.net.Entity;

import java.util.List;

/**
 * Created by Bing on 2016/12/22.
 */

public class CheckListEntity {

    /**
     * success : true
     * errCode : null
     * errMsg : null
     * data : {"total":1,"data":[{"code":"IC_20161222141035918","createTime":"2016-12-22 14:10:45","actualCount":0,"typeName":"全局盘点","statusName":"新建","creatorName":"admin","expectedCount":5,"taskId":4}],"pageSize":20,"page":1}
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
         * data : [{"code":"IC_20161222141035918","createTime":"2016-12-22 14:10:45","actualCount":0,"typeName":"全局盘点","statusName":"新建","creatorName":"admin","expectedCount":5,"taskId":4}]
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
             * code : IC_20161222141035918
             * createTime : 2016-12-22 14:10:45
             * actualCount : 0
             * typeName : 全局盘点
             * statusName : 新建
             * creatorName : admin
             * expectedCount : 5
             * taskId : 4
             */

            private String code;
            private String createTime;
            private int actualCount;
            private String typeName;
            private String statusName;
            private String creatorName;
            private int expectedCount;
            private int taskId;
            private String finishTime;

            public String getFinishTime() {
                return finishTime;
            }

            public void setFinishTime(String finishTime) {
                this.finishTime = finishTime;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getActualCount() {
                return actualCount;
            }

            public void setActualCount(int actualCount) {
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

            public int getExpectedCount() {
                return expectedCount;
            }

            public void setExpectedCount(int expectedCount) {
                this.expectedCount = expectedCount;
            }

            public int getTaskId() {
                return taskId;
            }

            public void setTaskId(int taskId) {
                this.taskId = taskId;
            }
        }
    }
}
