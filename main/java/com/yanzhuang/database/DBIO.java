package com.yanzhuang.database;

import java.sql.ResultSet;

public interface DBIO 
{
     public abstract Object toObject(ResultSet rs);
}

