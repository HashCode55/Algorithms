public class Problem92{
	public static void main(String args[]){
		//start time 
		final double START_TIME = System.currentTimeMillis();
		recursiveSolKicker(8);
		System.out.println(count);
		//time elapsed
		//time ellapsed
		System.out.println("took " + 
			(((double)(System.currentTimeMillis()-START_TIME)/1000))
				+ " seconds");
	}
	public static void recursiveSolKicker(int n){
		String num = "";
		//to not include the zero in the starting 
		for(int i = 1; i <= 9; i++){
			recursiveSol(n-1, num+""+i);
		}
	}
	static int count = 0;
	public static void recursiveSol(int n, String num){
		if(n<0)
			return;
		int res = squaredSum(num);
		if(res == 1) count+=res;
		String k = "";
		for(int i = 0; i <= 9; i++){
			if(n>0)
				recursiveSol(n-1, num+""+i);
		}
	}
	//10000000
	public static int squaredSum(String num){
		int len = num.length() - 1;
		int sum = 0;
		while(sum!=89 && sum!= 1){
			len=num.length()-1;
			for(int i = len; i>=0; i--){
				int k = num.charAt(i) - '0';
				sum+=k*k;
			}
			num=sum + "";
			if(sum==1)
				break;
			if(sum==89)
				break;
			sum=0;
		}

		if(sum==89) return 1;
		else return 0;
	}

	//////Helper Functions//////
	public static void print(String n){
		System.out.println(n);
	}
	public static void print(int n){
		System.out.println(n);
	}	
}