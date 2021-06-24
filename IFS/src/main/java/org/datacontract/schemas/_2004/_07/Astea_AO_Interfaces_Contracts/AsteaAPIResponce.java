/**
 * AsteaAPIResponce.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts;

public class AsteaAPIResponce  implements java.io.Serializable {
    private java.lang.String errorCode;

    private java.lang.String errrorDescription;

    private java.lang.String result;

    private java.lang.Boolean succceded;

    public AsteaAPIResponce() {
    }

    public AsteaAPIResponce(
           java.lang.String errorCode,
           java.lang.String errrorDescription,
           java.lang.String result,
           java.lang.Boolean succceded) {
           this.errorCode = errorCode;
           this.errrorDescription = errrorDescription;
           this.result = result;
           this.succceded = succceded;
    }


    /**
     * Gets the errorCode value for this AsteaAPIResponce.
     * 
     * @return errorCode
     */
    public java.lang.String getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this AsteaAPIResponce.
     * 
     * @param errorCode
     */
    public void setErrorCode(java.lang.String errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errrorDescription value for this AsteaAPIResponce.
     * 
     * @return errrorDescription
     */
    public java.lang.String getErrrorDescription() {
        return errrorDescription;
    }


    /**
     * Sets the errrorDescription value for this AsteaAPIResponce.
     * 
     * @param errrorDescription
     */
    public void setErrrorDescription(java.lang.String errrorDescription) {
        this.errrorDescription = errrorDescription;
    }


    /**
     * Gets the result value for this AsteaAPIResponce.
     * 
     * @return result
     */
    public java.lang.String getResult() {
        return result;
    }


    /**
     * Sets the result value for this AsteaAPIResponce.
     * 
     * @param result
     */
    public void setResult(java.lang.String result) {
        this.result = result;
    }


    /**
     * Gets the succceded value for this AsteaAPIResponce.
     * 
     * @return succceded
     */
    public java.lang.Boolean getSuccceded() {
        return succceded;
    }


    /**
     * Sets the succceded value for this AsteaAPIResponce.
     * 
     * @param succceded
     */
    public void setSuccceded(java.lang.Boolean succceded) {
        this.succceded = succceded;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AsteaAPIResponce)) return false;
        AsteaAPIResponce other = (AsteaAPIResponce) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errorCode==null && other.getErrorCode()==null) || 
             (this.errorCode!=null &&
              this.errorCode.equals(other.getErrorCode()))) &&
            ((this.errrorDescription==null && other.getErrrorDescription()==null) || 
             (this.errrorDescription!=null &&
              this.errrorDescription.equals(other.getErrrorDescription()))) &&
            ((this.result==null && other.getResult()==null) || 
             (this.result!=null &&
              this.result.equals(other.getResult()))) &&
            ((this.succceded==null && other.getSuccceded()==null) || 
             (this.succceded!=null &&
              this.succceded.equals(other.getSuccceded())));
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
        if (getErrorCode() != null) {
            _hashCode += getErrorCode().hashCode();
        }
        if (getErrrorDescription() != null) {
            _hashCode += getErrrorDescription().hashCode();
        }
        if (getResult() != null) {
            _hashCode += getResult().hashCode();
        }
        if (getSuccceded() != null) {
            _hashCode += getSuccceded().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AsteaAPIResponce.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Astea.AO.Interfaces.Contracts", "AsteaAPIResponce"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Astea.AO.Interfaces.Contracts", "ErrorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errrorDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Astea.AO.Interfaces.Contracts", "ErrrorDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Astea.AO.Interfaces.Contracts", "Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("succceded");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Astea.AO.Interfaces.Contracts", "Succceded"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
