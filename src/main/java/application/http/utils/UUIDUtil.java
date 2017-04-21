package application.http.utils;

import java.util.UUID;

/**
 * Created by J on 4/21/2017.
 */
public class UUIDUtil {
    public static String getUUID15() {

        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return String.format("%015d", hashCodeV);
    }
}
