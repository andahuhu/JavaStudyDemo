package itjinxun.Jdbc.dao.impl;

import itjinxun.Jdbc.annt.Column;
import itjinxun.Jdbc.annt.Table;
import itjinxun.Jdbc.dao.MySqlDao;
import itjinxun.Jdbc.dao.base.BaseDao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MySqlDaoImpl<T> extends BaseDao implements MySqlDao<T> {
    @Override
    public List<T> queryList(T t) {
        List<T> resultList = new ArrayList<>();
        try {
            Connection conn = super.getConn();
            Class clazz = t.getClass();
            String tableName = "";
            Table table = (Table)clazz.getAnnotation(Table.class);
            if (table != null) {
                tableName = table.value();
                if("".equals(tableName)){
                    tableName = clazz.getSimpleName();
                }
            }else{
                tableName = clazz.getSimpleName();
            }
            //列名
            Set<String> columnNames = new HashSet<>();
            //where条件
            Map<String,String> whereMap = new HashMap<>();

            for (Field field : clazz.getDeclaredFields()) {
                Boolean isSelect = true;
                String condition = "=";
                String columnName = "";

                Column column = field.getAnnotation(Column.class);
                if(column == null){
                    columnName = field.getName();
                }else{
                    isSelect = column.select();
                    condition = column.condition();
                    columnName = column.value();
                    if ("".equals(columnName)) {
                        columnName = field.getName();
                    }
                }
                if(isSelect){
                    columnNames.add(columnName);
                }
                String methodName = "get"+String.valueOf(field.getName().charAt(0)).toUpperCase()
                        +field.getName().substring(1);
                Method method = clazz.getMethod(methodName);
                Object value = method.invoke(t);
                if(value != null){
                    whereMap.put(columnName,condition);
                }
            }

            //根据实际情况组装SQL
            StringBuilder sql = new StringBuilder();
            sql.append("select ");
            int index = 0;
            for (String columnName : columnNames) {
                if(index == 0){
                    sql.append(columnName);
                }else{
                    sql.append(", "+columnName);
                }
                index++;
            }
            sql.append(" from ");
            sql.append(tableName);
            sql.append(" where 1=1 ");
            for (String key : whereMap.keySet()) {
                sql.append(" and ");
                sql.append(key);
                sql.append(" "+whereMap.get(key));
                sql.append(" ?");
            }

            PreparedStatement ps = conn.prepareStatement(sql.toString());
            index = 0;
            for (Field field : clazz.getDeclaredFields()) {
                //查询条件传参
                String methodName = "get"+String.valueOf(field.getName().charAt(0)).toUpperCase()
                        +field.getName().substring(1);
                Method method = clazz.getMethod(methodName);
                Object value = method.invoke(t);
                if(value != null){
                    ps.setObject(++index,value);
                }
            }
            //获取查询结果
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Object item = t.getClass().newInstance();
                for (Field field : clazz.getDeclaredFields()) {
                    Boolean isSelect = true;
                    String columnName = "";

                    Column column = field.getAnnotation(Column.class);
                    if(column == null){
                        columnName = field.getName();
                    }else{
                        isSelect = column.select();
                        columnName = column.value();
                        if ("".equals(columnName)) {
                            columnName = field.getName();
                        }
                    }
                    if(isSelect){
                        Object obj = resultSet.getObject(columnName);
                        String methodName = "set"+String.valueOf(field.getName().charAt(0)).toUpperCase()
                                +field.getName().substring(1);
                        Method method = clazz.getMethod(methodName,field.getType());
                        if(Long.class.getName().equals(obj.getClass().getName())){
                            //整形
                            obj = field.getType().getConstructor(String.class).newInstance(obj.toString());
                        }else if(Date.class.getName().equals(obj.getClass().getName())){
                            //日期类型
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            obj = sdf.parse(obj.toString());
                        }else if(Double.class.getName().equals(obj.getClass().getName())){
                            //浮点型
                        }else if(String.class.getName().equals(obj.getClass().getName())){
                            //字符串
                        }
                        method.invoke(item,obj);
                    }
                }
                resultList.add((T) item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
