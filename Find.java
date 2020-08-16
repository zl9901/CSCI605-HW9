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
        	System.out.print("�ļ�����:"+num);
        	System.out.print("�ܺ�ʱ:");
        	System.out.println(System.currentTimeMillis() - a);
        }
        if(args[2].equals("-length")) {
        	System.out.println(num);
        }
    }
   

    //�ǵݹ��÷�
    public static void scanDirNoRecursion(String path){
    	//��ʼ��linkedlist
    	LinkedList alist = new LinkedList();
        File afile = new File(path);
        File file[] = afile.listFiles();//����ֵ����ΪFile�������飬����ΪFile�������͵ľ���·��
        for (int i = 0; i < file.length; i++) {
            if (file[i].isDirectory()) {//��һ��Ŀ¼�򷵻�true��isFile()�����Ǽ���ļ��Ƿ����
                alist.add(file[i]);//�ѵ�һ���Ŀ¼ȫ����������
            	
            }else{
                System.out.println(file[i].getAbsolutePath());//����һ��Ŀ¼���ؾ���·��
                num++;
            }
        }
        File tmp;//�൱�ڼ�������һ���ļ����е����ݣ������Ľṹһ��
        while (!alist.isEmpty()) {
            tmp = (File)alist.removeFirst();//�׸�Ŀ¼(������ĵ�һ����¼ɾ��)��ע��ǿ������ת����File����
            if (tmp.isDirectory()) {//�ж��Ƿ�ΪĿ¼
                file = tmp.listFiles(); //Ŀ¼�µ��ļ��ŵ�������
                if (file == null)
                    continue;
                for (int i = 0; i < file.length; i++) {
                    if (file[i].isDirectory())
                        alist.add(file[i]);//�����Ŀ¼�����������������
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