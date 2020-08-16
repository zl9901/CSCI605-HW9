
public class PrimeAsFastAsPossible extends Thread{
	int GivenNumber=0;
	int num=0;

	final static int sizeTable[]={9,99,999,9999,9999,99999,999999,9999999};
	
	public PrimeAsFastAsPossible() {
		
	}
	
	public PrimeAsFastAsPossible(int GivenNumber,int num) {
		this.GivenNumber=GivenNumber;
		this.num=num;	

	}
	
	public static boolean isPrime(int n) {
		for(int index=2;index<n;index++) {
			if(n%index==0) {
				return false;
			}
		}
		return true;
	}
	
	public static int manyDigit(int n) {
		for(int j=1;j<sizeTable.length;j++) {
			if(n<sizeTable[j]) {
				return j+1;
			}
		}
		return 0;
	}
	
	public void run(){
		for(int index=GivenNumber/10*num-GivenNumber/10+1;index<=GivenNumber/10*num;index++) {
			if(index!=1) {
				if(isPrime(index)) {
					System.out.println(index);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int GivenNumber=Integer.parseInt(args[0]);
//		int digit=manyDigit(GivenNumber);
//		//System.out.println(digit);
//		for(int i=1;i<=10;i++) {
//			PrimeAsFastAsPossible hp=new PrimeAsFastAsPossible(GivenNumber,i);
//			hp.start();
//		}
		int n=991;
		if(isPrime(n)) {
			System.out.println(n);
		}
	}

}
