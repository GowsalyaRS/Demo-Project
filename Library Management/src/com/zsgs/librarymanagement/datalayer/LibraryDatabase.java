package com.zsgs.librarymanagement.datalayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.zsgs.librarymanagement.model.Admin;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.HistoryOfBooks;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.model.User;

public class LibraryDatabase 
{
    private static LibraryDatabase libraryDatabase;
	private Library library ;
	private Map<Integer,Book> bookList = new LinkedHashMap();
	private Map <String,User> userList = new LinkedHashMap<>();
	private Map <String,ArrayList<HistoryOfBooks>> historyList = new HashMap<>();
	private Map <Integer,Admin> adminList = new HashMap<>();
	public static LibraryDatabase getInstance() 
	{
		if (libraryDatabase == null) 
		{
			libraryDatabase = new LibraryDatabase();
		}
		return libraryDatabase;
	}
	public Library getLibrary() 
	{
		return library;
	}
    public Library insertLibrary(Library librarys) 
	{
        library = librarys;
		this.library.setId(10234);
		return library;
    }
	public void storeBook(Book book,int bookCount) 
	{
		bookList.put(book.getId(),book);
		for(int i=0;i<bookCount;i++)
		{
			Book book2 = new Book(book.getBookName(),book.getAuthorName(),book.getEdition(),book.getPublication(),book.getVolume());
			bookList.put(book2.getId(), book2);
		}
	}
	public Map<Integer,Book> book() 
	{
		return bookList;
	}
	public Map<String,User> viewUserList ()
	{
        return userList;
	}
	public void addUser(User user) 
	{
	    userList.put(user.getEmail(),user);
	}
    public  Map <String,ArrayList<HistoryOfBooks>> addHistory() 
	{
        return historyList;
    }
    public Map<Integer,Admin> viewAdmin() 
	{
        return adminList;
    }  
}
