package cn.morooi.mybatis.cfg;

/**
 * 用于封装执行的 SQL 语句和结果类型的全限定类名
 */

public class Mapper {
    private String queryString; // SQL 语句
    private String resultType; // 类名


    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
