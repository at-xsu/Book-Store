package ie.atu.testersxd;

import ie.atu.serialize.*;

public class BookSerializerTester2 {

	public static void main(String[] args) {
		// create the BookSerializer object
		BookSerializer bs = new BookSerializer();
		// use the deserialize books method
		bs.deserializeBooks();
		// view stuff in books arraylist
		bs.list();
	}
}
