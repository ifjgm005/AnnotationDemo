package com.demo.parse;

import com.demo.annotation.Column;
import com.demo.annotation.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by axes on 2019/10/12.
 */
public class Query {
    public static String query(Object bean) {

        //因为最后我们会返回sql语句，所以这里我们需要拼接sql语句
        StringBuilder sb = new StringBuilder();

        //首先获取 bean 类的 class，本例就是 Custome
        Class<?> beanClass = bean.getClass();

        //判断该 class 上是否有 table 注解
        boolean present = beanClass.isAnnotationPresent(Table.class);
        if (!present) {
            return "";
        }

        //获取该 class上 table 注解
        Table table = beanClass.getAnnotation(Table.class);

        //获取表名
        String tableName = table.value();
        sb.append("select * from")
                .append(" ")
                .append(tableName)
                .append(" ")

                //防止没有查询条件而报错
                .append("where 1=1");

        //获取类里面的所有字段
        Field[] fields = beanClass.getDeclaredFields();

        //遍历所有字段
        for (Field field : fields) {

            //判断字段上是否有Colomn 注解
            boolean fieldPresent = field.isAnnotationPresent(Column.class);

            //如果不存在，跳过这个字段继续下一个循环
            if (!fieldPresent) {
                continue;
            }

            //获取到 Column
            Column column = field.getAnnotation(Column.class);

            //获取 Column 的名称，如（user_name）
            String columnName = column.value();

            //获取字段的名称,如 useName
            String fieldName = field.getName();

            //通过该字段的get方法名
            String fieldGetName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);


            Object value = null;

            try {
                //获取到get方法
                Method method = beanClass.getMethod(fieldGetName);

                //反射调用该字段的get方法，获取到该字段的值
                value = method.invoke(bean);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            //如果不为空，则开始添加 and 语句
            if (value == null ||((value instanceof Integer)&& (Integer)value==0)) {
                continue;
            }

            //如果有值则添加 and 语句
            sb.append(" ")
                    .append("and").append(" ")
                    .append(columnName)

            ;

            //如果这个字段是int类型
            if (value instanceof Integer) {
                sb.append("=").append(value);
            } else if (value instanceof String) {

                //如果包含逗号，则是in查询
                if (((String) value).contains(",")) {
                    String[] values = ((String) value).split(",");

                    //添加 in 语句
                    sb.append(" ").append("in('");

                    //添加查询条件，并用逗号隔开
                    for (String item : values) {
                        sb.append(item).append(",");
                    }

                    //去除最后一个逗号
                    sb.deleteCharAt(sb.length() - 1);

                    sb.append("')");

                }

                //如果单个查询用 = 即可，但需要加入单引号
                else {


                    sb.append("='").append(value).append("'");
                }
            }


        }


        return sb.toString();
    }
}
