package com.fortiate.parser.field;

public interface CompoundField extends Field {

    void setValue(int fieldId, String value);

    String getValue(int fieldId);

    void setValue(int fieldId, int subFieldId, String value);

    String getValue(int fieldId, int subFieldId);

    void setField(int fieldId, Field field);

    Field getField(int fieldId);

    void setField(int fieldId, int subFieldId, Field subField);

    Field getField(int fieldId, int subFieldId);

}
