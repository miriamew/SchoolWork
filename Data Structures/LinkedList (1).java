package k;
import java.util.Scanner;
public class LinkedList {
	public static int myList = -1;
	public static int maxLinks = 20;
	public static char[] data = new char[maxLinks];
	public static int[] pointers = new int[maxLinks]; //-99 means its the end
	public static int freeList=0; //where the linked list beings
	public static int myListLength = 0;
	public static void addlinkfront(char charToAdd) {
		System.out.println("Adding to front.");
		int pointToNewFront = freeList;
		freeList = pointers[freeList];
		data[pointToNewFront] = charToAdd;
		if(myListLength == 0) {
			pointers[pointToNewFront] =-99;
		}
		else{
			pointers[pointToNewFront] = myList;
		}
		 
		myList = pointToNewFront;
		myListLength ++;
	}
	
	public static void addlink() {
		Scanner input2=new Scanner(System.in);
		System.out.println("What char do you want to add?");
		char charToAdd = input2.next().charAt(0);
		System.out.println("press f for front, e for end");
		String option2 = input2.next();
		if (option2.equals("f")) {
			addlinkfront(charToAdd);
		}
		if (option2.equals("e")) {
			if(myListLength == 0) {
				addlinkfront(charToAdd);
			}
			else {
				System.out.println("Adding to end");
				int upto = pointers[myList];
				int last = 0;
				while (upto != -99) {
					if (pointers[upto] == -99) {
						last = upto;
					}
					upto = pointers[upto];
				}
				System.out.println("Last is" + data[last] + "   "+ pointers[last]);
				int newSpotPt = freeList;
				freeList = pointers[freeList];
				data[newSpotPt] = charToAdd;
				pointers[last] = newSpotPt;
				//myList = newSpotPt;
				pointers[newSpotPt] = -99;
				myListLength ++;
			}
		}
	}
	public static void deletelink() {
		System.out.println("Deleting");
		
		if(myListLength == 0) {
			System.out.println("No list yet");
		}
		else if(myListLength == 1) {
			int oldMyList = myList;
			myList = -1;
			myListLength--;
			data[oldMyList] = '-';
			int oldfreeList = freeList;
			pointers[oldMyList] = oldfreeList;
			freeList = oldMyList;
		}
		else {
			System.out.println("press f for front, e for end");
			Scanner input3=new Scanner(System.in);
			String option3 = input3.next();
			if (option3.equals("f")) {
				int oldpointer = freeList;
				freeList = myList;
				data[myList] = '-';
				int newfront = pointers[myList];
				pointers[myList] = oldpointer;
				myList = newfront;
				myListLength --;
			}
			if (option3.equals("e")) {
				int upto = pointers[myList];
				int last = 0;
				int index = myList;
				while (upto != -99) {
					if (pointers[upto] == -99) {
						last = upto;
						pointers[index] = -99;
						data[upto] = '-';
						int oldFreeList = freeList;
						freeList = upto;
						pointers[upto] = oldFreeList;
						break;
					}
					index = upto;
					upto = pointers[upto];
				}
				myListLength--;
			}
		}
	}
	public static void main(String[] args)
	{
		Boolean keepgoing = true;
		while (keepgoing) {
			System.out.println("Press 0 to set up empty arrays \n1 to add a link to the beginning or end of your linked list \n2 to delete a link from the beginning or end \n3 to change a value in your list \n4 to list the links in order"
					+ "\n5 to find the link with a certain value and return it's index"
					+ " \n6 to add a link in front of a given link \n7 to add a link after a given link \n8 to delete link before a link"
					+ " \n9 to delete a link after a given link \n10 to add a link between two specified values \n11 to delete a link between two specific values \n12 for debug print \n13 to quit the program ");
			Scanner input=new Scanner(System.in);
			String option = input.next();
			if (option.equals("0"))
			{
				for (int i=0 ; i< maxLinks; i++) {
					data[i] = '-';
					pointers[i] = i+1;
					
				}
				pointers[maxLinks - 1] = -99;
				myList = -1;
				myListLength = 0;
				freeList = 0;
				System.out.println("Initialization Successful");
			}
			else if (option.equals("1"))
			{
				addlink();
			}
			
			else if (option.equals("2"))
			{
				deletelink();
			}
			else if (option.equals("3"))
			{	
				if(myListLength == 0) {
					System.out.println("No list yet");
				}
				else{
				System.out.println("press a for changing all occurances, o for only the first");
				Scanner input3=new Scanner(System.in);
				String option3 = input3.next();
				if (option3.equals("a")) {
					System.out.println("What char do you want to change all occurances of?");
					Scanner find=new Scanner(System.in);
					char charToChange = find.next().charAt(0);
					System.out.println("Into what?");
					char charToBecome = find.next().charAt(0);
					int upto = myList;
					int index = myList;
					Boolean found = false;
					while (upto != -99) {
						if (data[upto] == charToChange) {
							data[upto] = charToBecome;
							found = true;
						}
						upto = pointers[upto];
						index = upto;
						
					}
					if (!found) {
						System.out.println("Not found");
					}
				}
				if (option3.equals("o")) {
					System.out.println("What char do you want to change one occurance of?");
					Scanner find=new Scanner(System.in);
					char charToChange = find.next().charAt(0);
					System.out.println("Into what?");
					char charToBecome = find.next().charAt(0);
					int upto = myList;
					int index = myList;
					Boolean found = false;
					while (upto != -99 && (!found)) {
						if (data[upto] == charToChange) {
							data[upto] = charToBecome;
							found = true;
						}
						upto = pointers[upto];
						index = upto;	
					}
					if (!found) {
						System.out.println("Not found");
					}
				}
				}}
			else if (option.equals("4"))
			{
				if(myListLength == 0) {
					System.out.println("No list yet");
				}
				else {
					int upto = pointers[myList];
					System.out.println(data[myList] + "   "+ pointers[myList]);
					while (upto != -99) {
						System.out.println(data[upto] + "   "+ pointers[upto]);
						upto = pointers[upto];
					}
				}	
			}
			else if (option.equals("5"))
			{
				if(myListLength == 0) {
					System.out.println("No list yet");
				}
				else {
				System.out.println("What char do you want to find?");
				Scanner find=new Scanner(System.in);
				char charToFind = find.next().charAt(0);
				int upto = myList;
				int index = myList;
				Boolean found = false;
				while (upto != -99) {
					if (data[upto] == charToFind) {
						System.out.println("Found! The location of " + data[upto] + " is "+ index);
						found = true;
					}
					upto = pointers[upto];
					index = upto;	
				}
				if (!found) {
					System.out.println("Not found");
				}
			}
			}
			else if (option.equals("7"))
			{
				if(myListLength == 0) {
					System.out.println("No list yet");
				}
				else {
				Scanner find=new Scanner(System.in);
				System.out.println("What char do you want to insert?");
				char charToinsert = find.next().charAt(0);
				System.out.println("What char do you want it to be in after?");
				char charinfront = find.next().charAt(0);
				int upto = myList;
				int index = myList;
				Boolean found = false;
				while (upto != -99) {
					if (data[upto] == charinfront) {
						int oldfreelist = freeList;
						freeList = pointers[freeList];
						data[oldfreelist]=charToinsert;
						pointers[oldfreelist] = pointers[upto];
						pointers[upto] = oldfreelist;
						found = true;
						myListLength++;
						break;
					}
					upto = pointers[upto];
					index = upto;
				}
				if (!found) {
					System.out.println("Not found");
				}
			}
			}
			else if (option.equals("6"))
			{
				if(myListLength == 0) {
					System.out.println("No list yet");
				}
				else {
				Scanner find=new Scanner(System.in);
				System.out.println("What char do you want to insert?");
				char charToinsert = find.next().charAt(0);
				System.out.println("What char do you want it to be before?");
				char charinfront = find.next().charAt(0);
				int upto = myList;
				int index = myList;
				Boolean found = false;
				while (upto != -99) {
					if (data[upto] == charinfront) {
						if(upto==myList) {
							int oldfreelist = freeList;
							freeList = pointers[freeList];
							data[oldfreelist]=charToinsert;
							pointers[oldfreelist] = myList;
							myList = oldfreelist;
							found = true;
							myListLength++;
							break;
						}
						else{
							int oldfreelist = freeList;
							freeList = pointers[freeList];
							data[oldfreelist]=charToinsert;
							pointers[oldfreelist] = pointers[index];
							pointers[index] = oldfreelist;
							found = true;
							myListLength++;
							break;
						}
						}
						
					index = upto;
					upto = pointers[upto];	
				}
				if (!found) {
					System.out.println("Not found");
				}
			}
			}
			else if (option.equals("9"))
			{	
				if(myListLength == 0) {
					System.out.println("No list yet");
				}
				else {
				Scanner find=new Scanner(System.in);
				System.out.println("What char do you want to delete the link after?");
				char chartodelete = find.next().charAt(0);
				int upto = myList;
				int index = myList;
				Boolean found = false;
				while (upto != -99) {
					if (data[upto] == chartodelete) {
						found = true;
						if (myListLength ==1) {
							System.out.println("only 1 link, cant delete the one after");
						}
						else
						{
						int nextlink = pointers[upto];
						if (pointers[upto] == -99) {
							System.out.println("No link after that link");
							break;
						}
						int oldfreelist = freeList;
						int oldpointer = pointers[upto];
						pointers[upto] = pointers[nextlink];
						data[nextlink] = '-';
						freeList = oldpointer;
						pointers[nextlink] = oldfreelist;
						myListLength--;
						break;
						}
					}
					index = upto;
					upto = pointers[upto];
				}
				if (!found) {
					System.out.println("Not found");
				}
				}
			}
			else if (option.equals("8"))
			{
				if(myListLength == 0) {
					System.out.println("No list yet");
				}
				else {
				Scanner find=new Scanner(System.in);
				System.out.println("What char do you want to delete the link before?");
				char chartodelete = find.next().charAt(0);
				if (chartodelete ==data[myList]) {
					System.out.println("first link, cant delete the one before");
				}
				else if (myListLength == 1) {
					System.out.println("Only one link in list");
				}
				else if (myListLength ==2) {
					if (data[pointers[myList]] == chartodelete) {
					int oldfreelist = freeList;
					int oldmylist = myList;	
					myList = pointers[myList];
					data[oldmylist] = '-';
					freeList = oldmylist;
					pointers[oldmylist] = oldfreelist;
					myListLength--;
					}
				}
				else {
				int firstindex = myList;
				int index = pointers[firstindex];
				int upto = pointers[index];
				Boolean found = false;
				while (upto != -99) {
					if (data[upto] == chartodelete) {
						found = true;
						int oldfreelist = freeList;
						int oldpointer = pointers[firstindex];
						pointers[firstindex] = pointers[index];
						data[index] = '-';
						freeList = oldpointer;
						pointers[index] = oldfreelist;
						myListLength--;
						break;
					}
					index = pointers[index];
					firstindex = pointers[firstindex];
					upto = pointers[upto];
				}
				firstindex = myList;
				index = pointers[firstindex];
				upto = pointers[index];
				while (upto != -99 && !found) {
					if (data[index] == chartodelete) {
						found = true;

						int oldfreelist = freeList;
						int oldpointer = myList;
						myList = pointers[firstindex];
						data[firstindex] = '-';
						freeList = oldpointer;
						pointers[firstindex] = oldfreelist;
						myListLength--;
					}
					index = pointers[index];
					firstindex = pointers[firstindex];
					upto = pointers[upto];
				}

				if (!found) {
					System.out.println("Not found");
				}}
			}}
			else if (option.equals("10"))
			{
				if(myListLength == 0) {
					System.out.println("No list yet");
				}
				else{
				Scanner find=new Scanner(System.in);
				System.out.println("What char do you want to insert?");
				char charToinsert = find.next().charAt(0);
				System.out.println("What char do you want it to be after?");
				char charinafter= find.next().charAt(0);
				System.out.println("What char do you want it to be before?");
				char charinfront = find.next().charAt(0);
				int upto =pointers[ myList];
				int index = myList;
				Boolean found = false;
				while (upto != -99) {
					if (data[upto] == charinfront && data[index] == charinafter) {
						int oldfreelist = freeList;
						freeList = pointers[freeList];
						data[oldfreelist]=charToinsert;
						pointers[oldfreelist] = pointers[index];
						pointers[index] = oldfreelist;
						found = true;
						myListLength++;
						break;
					}
					index = upto;
					upto = pointers[upto];
				}
				if (!found) {
					System.out.println("Not found");
				}
			}}
			else if (option.equals("11"))
			{
				if(myListLength == 0) {
					System.out.println("No list yet");
				}
				else if (myListLength ==1) {
					System.out.println("only 1 link");
				}
				else if (myListLength ==2) {
					System.out.println("only 2 links");
				}
				else {
				Scanner find=new Scanner(System.in);
				System.out.println("What char do you want to delete the link after?");
				char chardeleteafter = find.next().charAt(0);
				System.out.println("What char do you want to delete the link before?");
				char chardeletebefore = find.next().charAt(0);
				int firstindex = myList;
				int index = pointers[firstindex];
				int upto =pointers[index];
				
				Boolean found = false;
				while (upto != -99) {
					if (data[firstindex] == chardeleteafter && data[upto] == chardeletebefore) {
						found = true;
						int nextlink = pointers[firstindex];
						int oldfreelist = freeList;
						int oldpointer = pointers[firstindex];
						pointers[firstindex] = pointers[nextlink];
						data[nextlink] = '-';
						freeList = oldpointer;
						pointers[nextlink] = oldfreelist;
						myListLength--;
						break;		
					}
					firstindex = pointers[firstindex];
					index = pointers[index];
					upto = pointers[upto];
				}

				if (!found) {
					System.out.println("Not found");
				}
			}
				
			}
			else if (option.equals("12"))
			{
				for (int i=0;i<pointers.length;i++) {
					System.out.println(data[i] + "   "+ pointers[i]);
				}
				System.out.println( "myList   "+ myList);
				System.out.println("freeList   "+ freeList);
			}
			else if (option.equals("13"))
			{
				keepgoing = false;
			}
			else
			{
				System.out.println("Not a valid input");
			}
		}
	}
}