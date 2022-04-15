package com.example.springbootmysql.models.enums;

public enum CPStatus {
    DECLINED,
    CREATED,
    // Status is active when CP was sent to CPPR and waits CPPR's response
    ONAPPROVING,
    // This status indicate that CP is available to choose
    APPROVED,
    SELECTED,
    PARTIALLYSELECTED
}
