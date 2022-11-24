package ie.atu.testersxd;

import ie.atu.serialize.*;

public class BookSerializerTester {

	public static void main(String[] args) {
		// create the BookSerializer object
		BookSerializer bs = new BookSerializer();
		// use it's add method twice
		bs.add();
		bs.add();
		// use the serialize books method
		bs.serializeBooks();
	}
}
