import java.io.File;
public class DeleteFileJavaDemo
{
   public static void main(String[] args)
   {	
      try{
         //Specify the file name and path
    	 File file = new File("D:\\mynewfile.txt");
         /*the delete() method returns true if the file is
          * deleted successfully else it returns false
          */
    	 if(file.delete()){
    	    System.out.println(file.getName() + " is deleted!");
         }else{
    	    System.out.println("Delete failed: File didn't delete");
    	  }
       }catch(Exception e){
           System.out.println("Exception occurred");
    	   e.printStackTrace();
    	}
    }
}