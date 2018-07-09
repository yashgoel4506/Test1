package question2;

/**
 * Please implement Dynamic Array Interface
 * 
 * @author
 *
 */
public class MyCollection implements DynamicArray {
	// Uncomment commented section

	/**
	 * You can declare local/global variables as per your requirement
	 */
	@SuppressWarnings("unused")
	private String[] numArray;
	
	public MyCollection(int arraySize){
		numArray = new String[arraySize];
	}

	public int search(String searchingNum) {
		// TODO Auto-generated method stub
		int index=0;
		int flag=0;
		for(int searchIndex=0; searchIndex<numArray.length; searchIndex++)
		{
			if(numArray[searchIndex].equals(searchingNum))
			{
				index=searchIndex;
				flag=1;
			}
		}
		if(flag==0)
			return -1;
		else
			return index;
	}

	public boolean add(String numberToAdd) {
		// TODO Auto-generated method stub
		int index= search(numberToAdd);
		if(index!=-1)
			return false;
		int flag=0;
		for(int i=0; i<numArray.length; i++)
		{
			if(numArray[i].equals(null))
				flag=1;
		}
		
		if(index==-1 && flag==1)
		{
		for(int i=0; i<numArray.length; i++)
		{
			if(numArray[i].equals(null))
			{
				numArray[i]=numberToAdd;
				break;
			}
		}
		}
		if(flag==0)
		{
			int len = numArray.length;
			doubleCapacity();
			numArray[len]=numberToAdd;
			flag=1;
		}
		
		return true;
	}

	public void doubleCapacity() {
		// TODO Auto-generated method stub
		int len = numArray.length;
		String[] tempArray = new String[2*len];
		for(int i=0; i<len; i++)
			tempArray[i]=numArray[i];
		numArray=tempArray;

	}

	public boolean remove(String numberToRemove) {
		// TODO Auto-generated method stub
		int index= search(numberToRemove);
		if(index==-1)
			return false;
		int i;
		for(i=index+1; i<numArray.length-1; i++)
		{
			numArray[i-1]=numArray[i];
		}
		numArray[i-1]=null;
		
		return true;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0; i<numArray.length; i++) {
			if(numArray[i]!=null)
				count++;
		}
		return count;
	}

	public String[] rotate(int n) {
		// TODO Auto-generated method stub
		for(int i=0; i<n; i++)
		{
			String temp = numArray[0];
			int j;
			for(j=1; j<numArray.length; j++)
			{
				numArray[j-1]=numArray[j];
			}
			numArray[j-1]=temp;
		}
		return numArray;
	}

}
