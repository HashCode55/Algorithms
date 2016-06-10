class repeatEle{
	public static void main(String args[]){
		int arr[] = {1, 2, 3, 1, 3, 6, 6};
		boolean hardCode = false;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else if(arr[i] == 0)
				hardCode = true;
			else
				System.out.println(arr[i]);	
		}
		if(hardCode)
			System.out.println(0);
	}
}