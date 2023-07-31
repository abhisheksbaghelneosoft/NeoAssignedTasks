package com.practice.dynamic_db_change.contexts;

import com.practice.dynamic_db_change.constants.DBTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class DBContextHolder {
    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();
    public static void setCurrentDb(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }
    public static DBTypeEnum getCurrentDb() {
        return contextHolder.get();
    }
    public static void clear() {
        contextHolder.remove();
    }
}

