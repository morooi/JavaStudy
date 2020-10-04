/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.fileDemo;

/*
 * File 类的判断和获取功能:
 *   public boolean isDirectory(): 测试此抽象路径名表示的 File 是否为目录
 *   public boolean isFile(): 测试此抽象路径名表示的 File 是否为文件
 *   public boolean exists(): 测试此抽象路径名表示的 File 是否存在
 *   public boolean canRead(): 判断是否可读
 *   public boolean canWrite(): 判断是否可写
 *   public boolean isHidden(): 判断是否隐藏
 *
 *   public String getAbsolutePath(): 返回此抽象路径名的绝对路径名字符串
 *   public String getPath(): 将此抽象路径名转换为路径名字符串
 *   public String getName(): 返回由此抽象路径名表示的文件或目录的名称
 *
 *   public String[] list(): 返回此抽象路径名表示的目录中的文件和目录的名称字符串数组
 *   public File[] listFiles(): 返回此抽象路径名表示的目录中的文件和目录的 File 对象数组
 *
 * File 类删除功能:
 *   public boolean delete(): 删除由此抽象路径名表示的文件和目录
 *   注意事项: 如果目录中有内容, 不能直接删除, 应该先删除目录中的内容再删除目录
 *
 * 补充: public boolean renameTo(File dest): 把文件重命名为指定的文件路径
 *   比如: file1.renameTo(file2) 为例:
 *      要想保证返回 ture, 需要 file1 在硬盘中是存在, 且 file2 不存在
 * */

import java.io.File;
import java.io.IOException;

public class FileDemo03 {
    public static void main(String[] args) throws IOException {
        // 创建一个 File 对象
        File file = new File("Part03/src/cn/morooi/fileDemo/test.txt");

        System.out.println(file.isDirectory()); // false
        System.out.println(file.isFile()); // true
        System.out.println(file.exists()); // true

        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getPath());
        System.out.println(file.getName());

        System.out.println("------------");
        File folder = new File("Part03/src/cn/morooi/fileDemo");
        String[] strArray = folder.list();
        for (String s : strArray) {
            System.out.println(s);
        }
        System.out.println("------------");
        File[] listFiles = folder.listFiles();
        for (File listFile : listFiles) {
//            System.out.println(listFile);
            if (listFile.isFile()){
                System.out.println(listFile);
            }
        }

        System.out.println("------------");
        File file1 = new File("Part03/src/cn/morooi/fileDemo/test.txt");
        System.out.println(file1.createNewFile());
        System.out.println(file1.delete());

    }
}
