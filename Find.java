import java.io.File;
import java.util.LinkedList;
public class Find {
 
 public static int num;
 
    public static void main(String[] args) {
        
        long a = System.currentTimeMillis();
        String path=args[0];
        num=0;
        
        /*
        for(int i=0;i<lists.length;i++){
         File file=new File(lists[i]);
         scanDirRecursion(file);
        */
        
        scanDirNoRecursion(path);
        
        if(args[1].equals("-date")) {
        	System.out.print("文件总数:"+num);
        	System.out.print("总耗时:");
        	System.out.println(System.currentTimeMillis() - a);
        }
        if(args[2].equals("-length")) {
        	System.out.println(num);
        }
    }
   

    //非递归用法
    public static void scanDirNoRecursion(String path){
    	//初始化linkedlist
    	LinkedList alist = new LinkedList();
        File afile = new File(path);
        File file[] = afile.listFiles();//返回值类型为File类型数组，内容为File数据类型的绝对路径
        for (int i = 0; i < file.length; i++) {
            if (file[i].isDirectory()) {//是一个目录则返回true，isFile()命令是检查文件是否存在
                alist.add(file[i]);//把第一层的目录全部放入链表
            	
            }else{
                System.out.println(file[i].getAbsolutePath());//不是一个目录返回绝对路径
                num++;
            }
        }
        File tmp;//相当于继续打开下一个文件夹中的内容，像树的结构一样
        while (!alist.isEmpty()) {
            tmp = (File)alist.removeFirst();//首个目录(把链表的第一个记录删除)，注意强制类型转换成File类型
            if (tmp.isDirectory()) {//判断是否为目录
                file = tmp.listFiles(); //目录下的文件放到数组中
                if (file == null)
                    continue;
                for (int i = 0; i < file.length; i++) {
                    if (file[i].isDirectory())
                        alist.add(file[i]);//如果是目录，则继续加入链表中
                    else{
                        System.out.println(file[i]);
                        num++;
                    }
                }
            } else {
                System.out.println(tmp);
                num++;
            }
        }
    }
}