package com.healthacta.common.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TableOperation {
    CREATE(1),
    READ(2),
    UPDATE(3),
    DELETE(4),
    UNKNOWN(100);

    private final int value;

    private TableOperation(int val) {
        this.value = val;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static TableOperation fromValue(int val) {
        for (TableOperation op : TableOperation.values()) {
            if (op.value == val) {
                return op;
            }
        }
        return UNKNOWN;
    }
}
