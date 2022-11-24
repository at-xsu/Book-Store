package ie.atu.serialize;

import ie.atu.book.Book;


import java.io.*;
import java.util.*;
import javax.swing.*;

public class BookSerializer {
	private ArrayList<Book> books;
	private final String FILENAME = "books.bin";
	
	public BookSerializer() {
		books = new ArrayList<Book>();
	}
	
	public void add() {
		Book tmpBook = new Book();
		
		tmpBook.read();
		
		books.add(tmpBook);
	}
	public void delete() {
		// Call view() to find, display, & return the book to delete
		Book tempBook = view();

		// If the book != null, i.e. it was found then...
		if(tempBook != null)
			// ...remove it from books
			books.remove(tempBook);
		
	}
	public void edit() {
		// Call view() to find, display, & return the book to edit
		Book tempBook = view();

		// If the book != null, i.e. it was found then...
		if(tempBook != null) {
			// get it's index
			int index=books.indexOf(tempBook);
			// read in a new book and...
			tempBook.read();
			// reset the object in books
			books.set(index, tempBook);
		}
	
	}
	public Book view() {
		// Read the number of the book to be viewed from the user
		String numberAsString="";
		int bookToView=0;
		try {
			numberAsString = JOptionPane.showInputDialog(null, "Enter Library Number of Book:");
			        
			// Attempt to convert the String to an Int
			bookToView = Integer.parseInt(numberAsString);
		}
		catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, numberAsString + " is not a valid number.");
		}

		// for every Book object in books
		for(Book tmpBook:books) {
			// if it's number equals the number of the bookToView
			if(tmpBook.getLibraryNumber() == bookToView){
				// display it and...
		 		JOptionPane.showMessageDialog(null, tmpBook);
		 		// return it
		 		return tmpBook;
		 	}
		}
		return null;
	}
	public void serializeBooks() {
		try {
			// create a FileOutputStream object
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			// connect it to a ObjectOutputStream object
			ObjectOutputStream outputStream = new ObjectOutputStream(fileStream);
			// write to the file
			outputStream.writeObject(books);
			// close the file output stream
			outputStream.close();
		}
		catch(FileNotFoundException fNFE) {
			System.out.println("Cannot create file to store books. ");
			
		}
		catch (IOException iOE) {
			System.out.println("Cannot write to " + FILENAME + ". ");
		}
		catch (Exception e) {
			System.out.println("There was an error! ");
		}
	}
	public void deserializeBooks() {
		try {
			// create a FileInputStream object
			FileInputStream fileStream = new FileInputStream(FILENAME);
			// connect
			ObjectInputStream inputStream = new ObjectInputStream(fileStream);
			// write to the file
			books = (ArrayList)inputStream.readObject();
			// close the file output stream
			inputStream.close();
		}
		catch(FileNotFoundException fNFE) {
			System.out.println("Cannot open file to read books from. ");
		}
		catch (IOException iOE) {
			System.out.println("Cannot read from " + FILENAME + ". ");
		}
		catch (Exception e) {
			System.out.println("There was an error! ");
		}
	}
	public void list() {
		String booksToList="";
		
		for (Book tmpBook : books) {
			booksToList+=tmpBook;
			booksToList+="\n";
		}
		System.out.println(booksToList);
	}
}
