package day3.retention;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class TestSourceAnnotation {

    public static final int STATUS_OPEN = 1;
    public static final int STATUS_CLOSE = 2;

    private static int sStatus = STATUS_OPEN;


    private TestSourceAnnotation() {
    }


    // 定义适用于参数的注解，限定取值范围为{STATUS_OPEN, STATUS_CLOSE}
    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.PARAMETER)
    @IntDef({STATUS_OPEN, STATUS_CLOSE})

    public @interface Status {
    }

    enum StausEnum {
        STAUSA,
        StatusB;

    }

    /**
     * 定义方法并使用@Status限定参数的取值
     *
     * @param status
     */
    public static void setStatus(StausEnum status) {
        if (status.equals(StausEnum.STAUSA)) {
            sStatus = STATUS_OPEN;
        } else if (status.equals(StausEnum.StatusB)) {
            sStatus = STATUS_CLOSE;
        }
    }

    public static int getStatus() {
        return sStatus;
    }


    public static String getStatusDesc() {
        if (sStatus == STATUS_OPEN) {
            return "打开状态";
        } else {
            return "关闭状态";
        }
    }
    public static void createFile(){

//        String path= "f:\\yuchao\\测试";//所创建文件的路径
//
//        File f = new File(path);
//
//        if(!f.exists()){
//
//            f.mkdirs();//创建目录
//        }

        String fileName = "abc.txt";//文件名及类型

        File file = new File( fileName);

        if(!file.exists()){

            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) {
        TestSourceAnnotation.setStatus(StausEnum.StatusB);
        System.out.println(getStatusDesc());
//        createFile();
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(new File("abc.txt"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str = "";
        Map<String,String> map = new LinkedHashMap<String,String>();
        String value = null,key = null;
        int i = 0;
        assert br != null;
        while((str=br.readLine())!=null) {
            System.out.println(str);
            if(str.contains("=")) {
                i++;
                if(null != value && null != key) {
                    map.put(key,value);
                }
                key = str.substring(0,str.indexOf("="));
                value = str.substring(str.indexOf("=")+1,str.length());
                if(i == 3) {
                    map.put(key,value);
                } else {
                    continue;
                }
            }
            value += str;
        }
        System.out.println(map);
    }

}

