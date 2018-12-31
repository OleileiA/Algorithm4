package _1_基础.实验题;

/*
* 编写一个程序从输入接受一个文件的名称
*
* 打印该文件下的所有文件并且利用递归的方式在所有子文件下列出子文件内所有文件（缩进）
*
* 提示：利用队列，参考java.io.File
* */

import _1_基础.队列.LinkedQueue;

import java.io.File;
import java.util.Queue;

public class FileList {

    private String s = "";

    private LinkedQueue<String> linkedQueue = new LinkedQueue<String>();

    public void showList(String str) {


        File file = new File(str);
        if (file.isDirectory()) {
            linkedQueue.enqueue(s + file.getName());
            s += "|---";
            String [] strings = file.list();
            for (int i = 0; i < strings.length; i++) {
                showList(file.getAbsolutePath() + "/" + strings[i]);
            }
            s = s.substring(0, s.length() - 4);
        } else {
            linkedQueue.enqueue(s + file.getName());
        }
    }

    public static void main(String[] args) {
        FileList fileList = new FileList();
        fileList.showList("/Users/cyw/Desktop/learnByself/2018/算法4/src/main/java/_1_基础");
        while (!fileList.linkedQueue.isEmpty()) {
            System.out.println(fileList.linkedQueue.dequeue());
        }
    }

}
