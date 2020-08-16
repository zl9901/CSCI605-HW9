import java.util.*;
public class ConsumerProducer extends Thread {
	String info;
	static int length;
	static int consumenum;
	static int producenum;
	static int emptyspace=1000;
	static private 	Vector aVector = new Vector();
	static int count=0;
	static int count1=0;
	public ConsumerProducer() {
		
	}
	
	public ConsumerProducer(String info,int length,int consumenum,int producenum) {
		this.info=info;
		this.length=length;
		this.consumenum=consumenum;
		this.producenum=producenum;
	}
	
	public void isProtected2() {
		synchronized ( aVector ){
			count1+=1;
			System.out.println("count1:"+count1);
			if(count1==500) System.exit(1);
			aVector.notifyAll();
			while(length-emptyspace>=consumenum) {
					System.out.println("consume "+consumenum+" items");
					emptyspace+=consumenum;
					if( emptyspace>=producenum ) {
						break;
					}
			}
				try {
					aVector.wait();
					isProtected2();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public void isProtected1() {
			synchronized ( aVector ){
				count+=1;
				System.out.println("count:"+count);
				if(count==500) System.exit(1);
				aVector.notifyAll();
				while(emptyspace>=producenum) {
						System.out.println("produce "+producenum+" items");
						emptyspace-=producenum;
						if(length-emptyspace>=consumenum) {
							break;
						}
//						System.out.println(emptyspace);
				}
					try {
						aVector.wait();
						isProtected1();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
	}


	public void run() {
		if(this.info.equals("producer")) {
			isProtected1();
		}else {
			isProtected2();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Vector aVector = new Vector();
		length=Integer.parseInt(args[0]);
		ConsumerProducer addc[]=new ConsumerProducer[1000];
		ConsumerProducer addp[]=new ConsumerProducer[1000];
		for(int index=0;index<1000;index++) {
			addc[index]=new ConsumerProducer("consumer",length,4,2);
			addp[index]=new ConsumerProducer("producer",length,4,2);
			addc[index].start();
			addp[index].start();
		}
	}
}
