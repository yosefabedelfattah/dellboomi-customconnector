/**
 * ModuleMetadataForLogicApp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts;

public class ModuleMetadataForLogicApp  implements java.io.Serializable {
    private java.lang.String moduleApiCode;

    private java.lang.String moduleDescr;

    private org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.FieldMetadataForLogicApp[] moduleFieldsForLogicApps;

    private java.lang.String moduleId;

    public ModuleMetadataForLogicApp() {
    }

    public ModuleMetadataForLogicApp(
           java.lang.String moduleApiCode,
           java.lang.String moduleDescr,
           org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.FieldMetadataForLogicApp[] moduleFieldsForLogicApps,
           java.lang.String moduleId) {
           this.moduleApiCode = moduleApiCode;
           this.moduleDescr = moduleDescr;
           this.moduleFieldsForLogicApps = moduleFieldsForLogicApps;
           this.moduleId = moduleId;
    }


    /**
     * Gets the moduleApiCode value for this ModuleMetadataForLogicApp.
     * 
     * @return moduleApiCode
     */
    public java.lang.String getModuleApiCode() {
        return moduleApiCode;
    }


    /**
     * Sets the moduleApiCode value for this ModuleMetadataForLogicApp.
     * 
     * @param moduleApiCode
     */
    public void setModuleApiCode(java.lang.String moduleApiCode) {
        this.moduleApiCode = moduleApiCode;
    }


    /**
     * Gets the moduleDescr value for this ModuleMetadataForLogicApp.
     * 
     * @return moduleDescr
     */
    public java.lang.String getModuleDescr() {
        return moduleDescr;
    }


    /**
     * Sets the moduleDescr value for this ModuleMetadataForLogicApp.
     * 
     * @param moduleDescr
     */
    public void setModuleDescr(java.lang.String moduleDescr) {
        this.moduleDescr = moduleDescr;
    }


    /**
     * Gets the moduleFieldsForLogicApps value for this ModuleMetadataForLogicApp.
     * 
     * @return moduleFieldsForLogicApps
     */
    public org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.FieldMetadataForLogicApp[] getModuleFieldsForLogicApps() {
        return moduleFieldsForLogicApps;
    }


    /**
     * Sets the moduleFieldsForLogicApps value for this ModuleMetadataForLogicApp.
     * 
     * @param moduleFieldsForLogicApps
     */
    public void setModuleFieldsForLogicApps(org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.FieldMetadataForLogicApp[] moduleFieldsForLogicApps) {
        this.moduleFieldsForLogicApps = moduleFieldsForLogicApps;
    }


    /**
     * Gets the moduleId value for this ModuleMetadataForLogicApp.
     * 
     * @return moduleId
     */
    public java.lang.String getModuleId() {
        return moduleId;
    }


    /**
     * Sets the moduleId value for this ModuleMetadataForLogicApp.
     * 
     * @param moduleId
     */
    public void setModuleId(java.lang.String moduleId) {
        this.moduleId = moduleId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModuleMetadataForLogicApp)) return false;
        ModuleMetadataForLogicApp other = (ModuleMetadataForLogicApp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.moduleApiCode==null && other.getModuleApiCode()==null) || 
             (this.moduleApiCode!=null &&
              this.moduleApiCode.equals(other.getModuleApiCode()))) &&
            ((this.moduleDescr==null && other.getModuleDescr()==null) || 
             (this.moduleDescr!=null &&
              this.moduleDescr.equals(other.getModuleDescr()))) &&
            ((this.moduleFieldsForLogicApps==null && other.getModuleFieldsForLogicApps()==null) || 
             (this.moduleFieldsForLogicApps!=null &&
              java.util.Arrays.equals(this.moduleFieldsForLogicApps, other.getModuleFieldsForLogicApps()))) &&
            ((this.moduleId==null && other.getModuleId()==null) || 
             (this.moduleId!=null &&
              this.moduleId.equals(other.getModuleId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getModuleApiCode() != null) {
            _hashCode += getModuleApiCode().hashCode();
        }
        if (getModuleDescr() != null) {
            _hashCode += getModuleDescr().hashCode();
        }
        if (getModuleFieldsForLogicApps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getModuleFieldsForLogicApps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getModuleFieldsForLogicApps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getModuleId() != null) {
            _hashCode += getModuleId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModuleMetadataForLogicApp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Astea.AO.Interfaces.Contracts", "ModuleMetadataForLogicApp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleApiCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Astea.AO.Interfaces.Contracts", "ModuleApiCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleDescr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Astea.AO.Interfaces.Contracts", "ModuleDescr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleFieldsForLogicApps");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Astea.AO.Interfaces.Contracts", "ModuleFieldsForLogicApps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Astea.AO.Interfaces.Contracts", "FieldMetadataForLogicApp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Astea.AO.Interfaces.Contracts", "FieldMetadataForLogicApp"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Astea.AO.Interfaces.Contracts", "ModuleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
