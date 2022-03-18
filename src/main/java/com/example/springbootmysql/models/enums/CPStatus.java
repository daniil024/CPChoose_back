package com.example.springbootmysql.models.enums;

public enum CPStatus {
    CREATED,
    ONAPPROVING,
    // This status indicate that CP is available to choose
    APPROVED,
    SELECTED,
    PARTIALLYSELECTED
}
