package designPatterns;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author zhoukx
 * @ClassName: Singleton
 * @description: 单例模式
 * @date 2021/5/24
 */
public class Singleton {

    // 防止重排序
    private static volatile Singleton singleton;

    // 私有构造方法（不防反射）
    private Singleton(){

    }

    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    // 枚举法，防反射，不支持懒加载
    enum SingletonEnum {
        INSTANCE;
        public SingletonEnum getInstance(){
            return INSTANCE;
        }
    }

}
