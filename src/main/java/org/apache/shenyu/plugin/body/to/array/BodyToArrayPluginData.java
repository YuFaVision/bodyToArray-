package org.apache.shenyu.plugin.body.to.array;

import java.io.Serializable;

public class BodyToArrayPluginData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String convertType;

    private String fieldName;

    private Boolean enabled;

    public String getConvertType() {
        return convertType;
    }

    public void setConvertType(String convertType) {
        this.convertType = convertType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
