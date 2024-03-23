package com.zsgs.librarymanagement.librarysetup;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Library;
public class LibrarySetupModel 
{
    private Library library ;
    private LibrarySetupView librarySetupView;

    LibrarySetupModel(LibrarySetupView librarySetupView) 
	{
		this.librarySetupView = librarySetupView;
	}
    public void   setup() 
	{
        if (library == null ) {
			librarySetupView.initiateSetup();
		} else {
			librarySetupView.onSetupComplete();
		}
	}
    public void createLibrary(Library library2) 
    {
        if (library2.getName().length() <3  || library2.getName().length() > 50) 
		{
			librarySetupView.showAlert("Enter valid name");
			return;
		}
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(library2.getEmail());
        if(!matcher.matches())
        {
            librarySetupView.showAlert(" email is Invalid");
            return;
        }
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
        matcher = ptrn.matcher(""+library2.getPhoneNo());
        if(!matcher.matches())
        {
            librarySetupView.showAlert(" Phone no is Invalid");
            return;
        }
		this.library = LibraryDatabase.getInstance().insertLibrary(library2);		
		librarySetupView.onSetupComplete(library2);
    }
}
