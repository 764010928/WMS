package crazysheep.io.scanner.net.Entity;

import java.util.List;

/**
 * Created by Bing on 2016/12/9.
 */

public class GoodsEntity {


    /**
     * success : true
     * errCode : null
     * errMsg : null
     * data : {"total":84,"data":[{"id":2955,"code":"A052001","barcode":"","name":"万向轮拉杆箱时尚箱套20寸","shortname":"箱套20","brand":"张小盒","typeName":"拉杆箱"},{"id":2959,"code":"A052003","barcode":"","name":"时尚万向轮拉杆箱/旅行登机箱 七彩波点-灿烂20寸","shortname":"七彩波点-灿烂20","brand":"张小盒","typeName":"拉杆箱"},{"id":2962,"code":"A052004","barcode":"","name":"时尚万向轮拉杆箱/旅行登机箱 七彩波点-相遇20寸","shortname":"七彩波点-相遇20","brand":"张小盒","typeName":"拉杆箱"},{"id":2965,"code":"A052005","barcode":"","name":"时尚万向轮拉杆箱/旅行登机箱 七彩波点-美好20寸","shortname":"七彩波点-美好20","brand":"张小盒","typeName":"拉杆箱"},{"id":2968,"code":"A052006","barcode":"","name":"时尚万向轮拉杆箱/旅行登机箱 星际旅行20寸","shortname":"星际旅行20","brand":"张小盒","typeName":"拉杆箱"},{"id":2971,"code":"A052007","barcode":"6956108 976539","name":"时尚万向轮拉杆箱/旅行登机箱 星际空间20寸","shortname":"星际空间20","brand":"张小盒","typeName":"拉杆箱"},{"id":2974,"code":"A052008","barcode":"6956108 924325","name":"时尚万向轮拉杆箱/旅行登机箱 自由旋律20寸","shortname":"自由旋律20","brand":"张小盒","typeName":"拉杆箱"},{"id":2977,"code":"A052009","barcode":"","name":"时尚万向轮拉杆箱/旅行登机箱 盒子世界20寸","shortname":"盒子世界20","brand":"张小盒","typeName":"拉杆箱"},{"id":2980,"code":"A052010","barcode":"","name":"时尚万向轮拉杆箱/旅行登机箱 招财猫20寸","shortname":"招财猫20","brand":"张小盒","typeName":"拉杆箱"},{"id":2983,"code":"A052011","barcode":"6956108 978984","name":"时尚万向轮拉杆箱/旅行登机箱 盒子印象20寸","shortname":"盒子印象20","brand":"张小盒","typeName":"拉杆箱"},{"id":2986,"code":"A052012","barcode":"6956108 978441","name":"时尚万向轮拉杆箱/旅行登机箱 加薪英雄20寸","shortname":"加薪英雄20","brand":"张小盒","typeName":"拉杆箱"},{"id":2989,"code":"A052013","barcode":"","name":"时尚万向轮拉杆箱/旅行登机箱 天然呆20寸","shortname":"天然呆20","brand":"张小盒","typeName":"拉杆箱"},{"id":3060,"code":"A010056","barcode":"","name":"2015新款 佛罗伦萨先锋银色镜面方圆形防UV太阳镜 ","shortname":"佛罗伦萨先锋银色方圆形太阳镜 ","brand":"Ross&Brown","typeName":"太阳镜"},{"id":3061,"code":"A010057","barcode":"","name":"2015新款 佛罗伦萨时尚绿色镜面防UV复古太阳镜","shortname":"佛罗伦萨时尚绿色复古太阳镜","brand":"Ross&Brown","typeName":"太阳镜"},{"id":3062,"code":"A010058","barcode":"","name":"2015新款 佛罗伦萨玳瑁色方圆形镜框板材复古太阳","shortname":"佛罗伦萨玳瑁色方圆形复古太阳镜","brand":"Ross&Brown","typeName":"太阳镜"},{"id":3063,"code":"A010059","barcode":"","name":"2015新款 佛罗伦萨蓝色镜面方圆形镜框板材防UV太","shortname":"佛罗伦萨蓝色面方圆形太阳镜","brand":"Ross&Brown","typeName":"太阳镜"},{"id":3064,"code":"A010060","barcode":"","name":"2015新款 佛罗伦萨黑色半透明镜框防UV太阳镜efFQQe ","shortname":"佛罗伦萨黑色半透明太阳镜","brand":"Ross&Brown","typeName":"太阳镜"},{"id":3065,"code":"A010061","barcode":"","name":"2015新款 米兰系列前卫绿色镜面防UV太阳镜街拍同款 ","shortname":"米兰前卫绿色太阳镜 ","brand":"Ross&Brown","typeName":"太阳镜"},{"id":3066,"code":"A010062","barcode":"","name":"2015新款 米兰系列红色个性镜面防UV太阳镜街拍同","shortname":"米兰红色太阳镜","brand":"Ross&Brown","typeName":"太阳镜"},{"id":3067,"code":"A010063","barcode":"","name":"2015新款 米兰系列宝蓝色时尚镜面防UV太阳镜街拍同","shortname":"米兰蓝色时尚太阳镜","brand":"Ross&Brown","typeName":"太阳镜"}],"pageSize":20,"page":1}
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
         * total : 84
         * data : [{"id":2955,"code":"A052001","barcode":"","name":"万向轮拉杆箱时尚箱套20寸","shortname":"箱套20","brand":"张小盒","typeName":"拉杆箱"},{"id":2959,"code":"A052003","barcode":"","name":"时尚万向轮拉杆箱/旅行登机箱 七彩波点-灿烂20寸","shortname":"七彩波点-灿烂20","brand":"张小盒","typeName":"拉杆箱"},{"id":2962,"code":"A052004","barcode":"","name":"时尚万向轮拉杆箱/旅行登机箱 七彩波点-相遇20寸","shortname":"七彩波点-相遇20","brand":"张小盒","typeName":"拉杆箱"},{"id":2965,"code":"A052005","barcode":"","name":"时尚万向轮拉杆箱/旅行登机箱 七彩波点-美好20寸","shortname":"七彩波点-美好20","brand":"张小盒","typeName":"拉杆箱"},{"id":2968,"code":"A052006","barcode":"","name":"时尚万向轮拉杆箱/旅行登机箱 星际旅行20寸","shortname":"星际旅行20","brand":"张小盒","typeName":"拉杆箱"},{"id":2971,"code":"A052007","barcode":"6956108 976539","name":"时尚万向轮拉杆箱/旅行登机箱 星际空间20寸","shortname":"星际空间20","brand":"张小盒","typeName":"拉杆箱"},{"id":2974,"code":"A052008","barcode":"6956108 924325","name":"时尚万向轮拉杆箱/旅行登机箱 自由旋律20寸","shortname":"自由旋律20","brand":"张小盒","typeName":"拉杆箱"},{"id":2977,"code":"A052009","barcode":"","name":"时尚万向轮拉杆箱/旅行登机箱 盒子世界20寸","shortname":"盒子世界20","brand":"张小盒","typeName":"拉杆箱"},{"id":2980,"code":"A052010","barcode":"","name":"时尚万向轮拉杆箱/旅行登机箱 招财猫20寸","shortname":"招财猫20","brand":"张小盒","typeName":"拉杆箱"},{"id":2983,"code":"A052011","barcode":"6956108 978984","name":"时尚万向轮拉杆箱/旅行登机箱 盒子印象20寸","shortname":"盒子印象20","brand":"张小盒","typeName":"拉杆箱"},{"id":2986,"code":"A052012","barcode":"6956108 978441","name":"时尚万向轮拉杆箱/旅行登机箱 加薪英雄20寸","shortname":"加薪英雄20","brand":"张小盒","typeName":"拉杆箱"},{"id":2989,"code":"A052013","barcode":"","name":"时尚万向轮拉杆箱/旅行登机箱 天然呆20寸","shortname":"天然呆20","brand":"张小盒","typeName":"拉杆箱"},{"id":3060,"code":"A010056","barcode":"","name":"2015新款 佛罗伦萨先锋银色镜面方圆形防UV太阳镜 ","shortname":"佛罗伦萨先锋银色方圆形太阳镜 ","brand":"Ross&Brown","typeName":"太阳镜"},{"id":3061,"code":"A010057","barcode":"","name":"2015新款 佛罗伦萨时尚绿色镜面防UV复古太阳镜","shortname":"佛罗伦萨时尚绿色复古太阳镜","brand":"Ross&Brown","typeName":"太阳镜"},{"id":3062,"code":"A010058","barcode":"","name":"2015新款 佛罗伦萨玳瑁色方圆形镜框板材复古太阳","shortname":"佛罗伦萨玳瑁色方圆形复古太阳镜","brand":"Ross&Brown","typeName":"太阳镜"},{"id":3063,"code":"A010059","barcode":"","name":"2015新款 佛罗伦萨蓝色镜面方圆形镜框板材防UV太","shortname":"佛罗伦萨蓝色面方圆形太阳镜","brand":"Ross&Brown","typeName":"太阳镜"},{"id":3064,"code":"A010060","barcode":"","name":"2015新款 佛罗伦萨黑色半透明镜框防UV太阳镜efFQQe ","shortname":"佛罗伦萨黑色半透明太阳镜","brand":"Ross&Brown","typeName":"太阳镜"},{"id":3065,"code":"A010061","barcode":"","name":"2015新款 米兰系列前卫绿色镜面防UV太阳镜街拍同款 ","shortname":"米兰前卫绿色太阳镜 ","brand":"Ross&Brown","typeName":"太阳镜"},{"id":3066,"code":"A010062","barcode":"","name":"2015新款 米兰系列红色个性镜面防UV太阳镜街拍同","shortname":"米兰红色太阳镜","brand":"Ross&Brown","typeName":"太阳镜"},{"id":3067,"code":"A010063","barcode":"","name":"2015新款 米兰系列宝蓝色时尚镜面防UV太阳镜街拍同","shortname":"米兰蓝色时尚太阳镜","brand":"Ross&Brown","typeName":"太阳镜"}]
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
             * id : 2955
             * code : A052001
             * barcode :
             * name : 万向轮拉杆箱时尚箱套20寸
             * shortname : 箱套20
             * brand : 张小盒
             * typeName : 拉杆箱
             */

            private int id;
            private String code;
            private String barcode;
            private String name;
            private String shortname;
            private String brand;
            private String typeName;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getBarcode() {
                return barcode;
            }

            public void setBarcode(String barcode) {
                this.barcode = barcode;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getShortname() {
                return shortname;
            }

            public void setShortname(String shortname) {
                this.shortname = shortname;
            }

            public String getBrand() {
                return brand;
            }

            public void setBrand(String brand) {
                this.brand = brand;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }
        }
    }
}
