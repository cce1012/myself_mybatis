package com.cce.proxy;

import com.cce.cfg.Mapper;
import com.cce.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    private Map<String,Mapper> mappers;
    private Connection conn;

    public
    MapperProxy(Map<String,Mapper> mappers,Connection conn) {
        this.mappers=mappers;
        this.conn=conn;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名
        String methodName = method.getName();
        //2.获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        //3.组合key
        String key=className+"."+methodName;
        //4.获取Mapper对象
        Mapper mapper = mappers.get(key);
        if (mapper==null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //调用工具类查询所有
        return new Executor().selectList(mapper,conn);
    }
}
