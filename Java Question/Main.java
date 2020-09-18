public class Main {
	public static void main(String[] args) {
		ArrayList myList = new ArrayList(8,9,0,2);
	}
}

class ArrayList {
	int[] list = {};

	// Initiate array list with the initial arguments
	// Since we don't know how many elements the user will want the initial array to have we use REST parameters in the constructor to dynamically populate the array list
	ArrayList(int ...item) {
		// New array list is created to be populated with initial values
		int newList[] = new int[item.length];

		for(int i = 0; i < item.length; i++) {
			newList[i] = item[i];
		}

		// New array is then stored into the list array
		list = newList;
	}

	int get(int index) {
		return list[index];
	}

	void append(int value) {
		// Create a new array of size list.length + 1
		int newList[] = new int[list.length + 1];

		// Insert the elements from the old list array into the new array
		// Insert all the elements till the list.length index, then add the new value at list.length + 1
		for(int i = 0; i < list.length; i++) {
			newList[i] = list[i];
		}

		newList[list.length] = value;

		list = newList;
	}

	void delete(int index) {
		// If the array is empty or the index is not in the array range then do nothing
		if((index < 0) || (index >= list.length) || (list.length == 0)) {
			return;
		}

		// Create a new array list the size of list - 1
		int newList[] = new int[list.length - 1];

		// Copy the elements except for the index from the original list to the new list
		for(int i = 0, k = 0; i < list.length; i++) {
			// If the index is the removal element index
			if(i == index) {
				continue;
			}

			// If the index is not the removal element index
			newList[k++] = list[i];
		}

		list = newList;
	}

	// Method to add new value at the given index
	// The implication of this will make it so users will dynamically add new values at any index they choose. 
	void set(int index, int value) {
		// If index is not in the array range then do nothing
		if((index < 0) || (index >= list.length)) {
			return;
		}

		// Create a new array of size list.length + 1
		int newList[] = new int[list.length + 1];

		// We add values from the old list to the new list until we reach the index
		for(int i = 0; i < index; i++) {
			newList[i] = list[i];
		}

		// At index we add the new value
		newList[index] = value;

		// After the index point we add the rest of the values from the old list to the new list
		for(int i = index + 1; i <= list.length; i++) {
			newList[i] = list[i - 1];
		}

		// We save newList to the list property of the class
		list = newList;
	}
}