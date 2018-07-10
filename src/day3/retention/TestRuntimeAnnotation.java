package day3.retention;


import java.lang.reflect.*;
import java.util.Arrays;

@ClassInfo("测试用例")
public class TestRuntimeAnnotation {
    @FildInfo(111)
    private int id = 1001;

    @FildInfo({10086, 10000})
    private String fiedString = "fiedString";


    @MethodInfo(name = "mynameis", data = "data")
    private String getMethodInfo() {
        return TestRuntimeAnnotation.class.getSimpleName();
    }
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer();
        Class<?> cls = TestRuntimeAnnotation.class;
//        Constructor<?>[] constructors = cls.getConstructors();
//        Object oc = null;
//        try {
//            constructors[0].setAccessible(true);
//           oc = constructors[0].newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        // 获取指定类型的注解
        sb.append("Class注解：").append("\n");
        ClassInfo classInfo = cls.getAnnotation(ClassInfo.class);
        if (classInfo != null) {
            sb.append(Modifier.toString(cls.getModifiers())).append(" ")
                    .append(cls.getSimpleName()).append("\n");
            sb.append("注解值: ").append(classInfo.value()).append("\n\n");
        }

        sb.append("Field注解：").append("\n");
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            FildInfo fieldInfos = field.getAnnotation(FildInfo.class);
            if (fieldInfos != null) {
                sb.append(Modifier.toString(field.getModifiers())).append(" ")
                        .append(field.getType().getSimpleName()).append(" ")
                        .append(field.getName()).append("\n");
                sb.append("注解值: ").append(Arrays.toString(fieldInfos.value())).append("\n\n");
            }
        }

        sb.append("Method注解：").append("\n");
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
            if (methodInfo != null) {
                sb.append(Modifier.toString(method.getModifiers())).append(" ")
                        .append(method.getReturnType().getSimpleName()).append(" ")
                        .append(method.getName()).append("\n");
                sb.append("注解值: ").append("\n");
                sb.append("name: ").append(methodInfo.name()).append("\n");
                sb.append("data: ").append(methodInfo.data()).append("\n");
                sb.append("age: ").append(methodInfo.age()).append("\n");
            }
        }

        System.out.print(sb.toString());

    }
}
