package day2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTest {
    public static void main(String[] args){
        try {
            Class clazz = Class.forName("day2.ReflectTest");
            Constructor ct = clazz.getDeclaredConstructor(String.class);
            ct.setAccessible(true);
            Object object = ct.newInstance("年后");
            Method method = clazz.getDeclaredMethod("getName");
            method.setAccessible(true);
            method.invoke(object);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
