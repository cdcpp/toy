
public class forTest {

	public static void main(String[] args) {
		
		int count; 
		int c;     
		int r;     
		int [][] arr = new int[5][5];
		int cut=0;  
		
		int i=0;  
		
		for(count=5;count>0;count-=2) {
			
			for(c=0;c<count;c++) {
				arr[cut][cut+c] = i;
				i++;
			}
			
			for(r=1;r<count;r++) {
				arr[r][5-cut-1] = i;
				i++;
			}
			
		}
		
		
		
}// main end
	
} // class end
