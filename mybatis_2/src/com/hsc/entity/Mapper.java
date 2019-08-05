package com.hsc.entity;

/**
 * Mapper: 存储的是DAO里的Mapper.xml的mapper的信息，
 * 包含：namespace,id,resultType和SQL语句
 */
public class Mapper {
    private String namespace;
    private String id;
    private String resultType;
    private String sql;

    public Mapper() {
    }

    public Mapper(String namespace, String id, String resultType, String sql) {
        this.namespace = namespace;
        this.id = id;
        this.resultType = resultType;
        this.sql = sql;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
