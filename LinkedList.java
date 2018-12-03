// Sam Stein

// Implementation of a linked list
public class LinkedList {

	// Constructor
	public LinkedList() 
	{
		this.firstLink = null;
		this.length = 0;
	}

	public LinkedList(int item)
	{
		this.firstLink = new Link(item);
		this.length = 1;
	}

	// Properties
	Link firstLink;
	int length;


	// Methods

	// Add a new link to the end of the linked list
	public void addLink(int item)
	{
		if (this.firstLink == null) {
			this.firstLink = new Link(item);
			this.length++;
			return;
		}

		Link thisLink = this.firstLink;

		while (true) {
			
			if (thisLink.nextLink == null) {
				thisLink.nextLink = new Link(item);
				this.length++;
				break;
			}

			thisLink = thisLink.nextLink;
		}
	}

	// Insert a link at a specific location
	public void insertLinkAt(int location, int item)
	{
		// Make sure location is in bounds of the Linked List's range
		if (location < 0) {
			System.out.println("Cannot insert at a negative location");
			return;
		}

		if (location > this.length) {
			System.out.println("Cannot insert outside the length of the list");
			return;
		}

		Link newLink = new Link(item);
		// Insert at the beginning
		if (location == 0) {
			if (this.length == 0) {
				this.firstLink = new Link(item);
				this.length++;
				return;
			}

			newLink.nextLink = this.firstLink;
			this.firstLink = newLink;
			this.length++;
			return;
		}

		// Insert at the end which is just the addLink(int) method
		else if (location == this.length) {
			addLink(item);
			return;
		}

		Link thisLink = this.firstLink;
		Link previousLink = null;

		// Inserting somewhere between the beginning and the end
		for (int i = 0 ; i < location + 1 ; i++) {

			if (i == location) {
				newLink.nextLink = thisLink;
				previousLink.nextLink = newLink;
				this.length++;
				return;
			}

			previousLink = thisLink;
			thisLink = thisLink.nextLink;
		}
	}

	public void removeLinkAt(int location) 
	{
		// Don't try to remove from invalid locations
		if (location < 0) {
			System.out.println("Cannot remove a link at an invalid location");
			return;
		}
		else if (location > this.length) {
			System.out.println("Cannot remove a link outside the range of the list");
			return;
		}

		// Edge case at of removing first link, because of setting 'this.firstLink'
		if (location == 0) {
			this.firstLink = this.firstLink.nextLink;
			return;
		}

		Link previousLink = null;
		Link thisLink = this.firstLink;

		// Iteratively loop through until link is found and remove
		for (int i = 0 ; i < location + 1 ; i++) {

			if (i == location) {
				previousLink.nextLink = thisLink.nextLink;
				return;
			}

			previousLink = thisLink;
			thisLink = thisLink.nextLink;
		}
	}

	// Show the linked list
	public void displayList()
	{	
		if (this.length == 0) {
			System.out.println("Linked list is empty, nothing to display");
			return;
		}

		// Iterate through each link
		Link thisLink = this.firstLink;
		while (thisLink != null) {
			System.out.print(thisLink.item +" ");
			thisLink = thisLink.nextLink;
		}

		System.out.println();
	}

	// Main method, used just for testing purposes
	public static void main(String[] args) 
	{
		LinkedList linkedList = new LinkedList();
		linkedList.addLink(3);
		linkedList.addLink(7);
		linkedList.displayList();

		linkedList.insertLinkAt(1,10);
		linkedList.displayList();

		linkedList.addLink(27);
		linkedList.insertLinkAt(2,30);
		linkedList.displayList();

		linkedList.removeLinkAt(1);
		linkedList.displayList();
	}
}

// The individual links in the linked list
class Link
{
	// Constructor
	Link(int item) 
	{
		this.item = item;
		nextLink = null;
	}

	// Properties
	Link nextLink;
	int item;
}