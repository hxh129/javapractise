package day2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    private String name;

    private ReflectTest(String name) {
        this.name = name;
    }

    private String getName() {

        System.out.println(name);
        return name;
    }

}
class B{
    public static void main(String[] args){
        try {
            Class clazz = Class.forName("day2.ReflectTest");
            Constructor constructor =clazz.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            ReflectTest reflectTest = (ReflectTest) constructor.newInstance("test");
           Method method = clazz.getDeclaredMethod("getName");
           method.setAccessible(true);
           method.invoke(reflectTest,null);

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
