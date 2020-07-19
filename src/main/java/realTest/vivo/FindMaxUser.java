package realTest.vivo;

import java.io.*;
import java.util.*;

/**
 * @ClassName Mian1
 * @Description: 小v是公司的运维工程师，现有一个有关应用程序部署的任务如下：
 * 1、一台服务器的磁盘空间、内存是固定的，现在有N个应用程序要部署；
 * 2、每个应用程序所需要的磁盘、内存不同，每个应用程序允许访问的用户数也不同，且同一个应用程序不能在一台服务器上部署多个。
 * 对于一台服务器而言，如何组合部署应用程序能够使得单台服务器允许访问的用户数最多？
 * <p>
 * 输入描述:
 * 输入包括三个参数，空格分隔，分别表示服务器的磁盘大小、内存大小，以及应用程序列表；
 * 其中第三个参数即应用程序列表，表述方式为：多个应用程序信息之间用 '#' 分隔，每个应用程序的信息包括 ',' 分隔的部署所需磁盘空间、内存、允许访问的用户量三个数字；比如 50,20,2000 表示部署该应用程序需要50G磁盘空间，20G内存，允许访问的用户数是2000
 * <p>
 * 输出描述:
 * 单台服务器能承载的最大用户数
 * <p>
 * 输入例子1:
 * 15 10 5,1,1000#2,3,3000#5,2,15000#10,4,16000
 * <p>
 * 输出例子1:
 * 31000
 * <p>
 * 例子说明1:
 * 组合部署服务5,2,15000、10,4,16000  ，可以让单台服务器承载最大用户数31000
 * @Author UESTC-ZKX
 * @Date 2020/3/7
 **/
public class FindMaxUser {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        String[] input = inputStr.split(" ");
        int totalDisk = Integer.parseInt(input[0]);
        int totalMemory = Integer.parseInt(input[1]);
        List<Service> services = parseServices(input[2].split("#"));
        int output = solution(totalDisk, totalMemory, services);
        System.out.println(output);
    }

    private static int solution(int totalDisk, int totalMemory, List<Service> services) {

        // TODO Write your code here
        maxDisk = totalDisk;
        maxMemory = totalMemory;
        backtrack(services, 0);
        return maxValue;
    }

    private static int maxValue = 0;
    private static int curValue = 0;

    private static int curDisk = 0;
    private static int curMemory = 0;
    private static int maxDisk;
    private static int maxMemory;

    /**
     * 回溯
     *
     * @param services 服务器列表
     * @param index    当前服务器
     */
    private static void backtrack(List<Service> services, int index) {
        if (index >= services.size()) {
            if (curValue > maxValue) {
                maxValue = curValue;
            }
            return;
        }
        Service temp = services.get(index);
        backtrack(services, index + 1);
        if (curDisk + temp.getDisk() <= maxDisk && curMemory + temp.getMemory() <= maxMemory) {
            curDisk += temp.getDisk();
            curMemory += temp.getMemory();
            curValue += temp.getusers();
            backtrack(services, index + 1);
            // 回溯
            curDisk -= temp.getDisk();
            curMemory -= temp.getMemory();
            curValue -= temp.getusers();
        }
    }

    private static List<Service> parseServices(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new ArrayList<Service>(0);
        }
        List<Service> services = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            String[] serviceArr = strArr[i].split(",");
            int disk = Integer.parseInt(serviceArr[0]);
            int memory = Integer.parseInt(serviceArr[1]);
            int users = Integer.parseInt(serviceArr[2]);
            services.add(new Service(disk, memory, users));
        }
        return services;
    }

    static class Service {
        private int disk;

        private int memory;

        private int users;

        public Service(int disk, int memory, int users) {
            this.disk = disk;
            this.memory = memory;
            this.users = users;
        }

        public int getDisk() {
            return disk;
        }

        public void setDisk(int disk) {
            this.disk = disk;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public int getusers() {
            return users;
        }

        public void setusers(int users) {
            this.users = users;
        }
    }
}
