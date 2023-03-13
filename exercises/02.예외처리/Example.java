/**
 * 예외 전파 샘플
 */
public class Example {
    Library1 library = new Library1();
    public Library1 getLibrary() {
        return library;
    }

    public static void main(final String[] args) {
        try{
            final Example example = new Example(); 
            example.getLibrary().getMessage(100);             
        }catch(final Exception e){
            e.printStackTrace();
        }
        
    }

    /**
     * Library1
     */
    public class Library1 {
        public void getMessage(int indexOfMessage) throws Exception {
            try{
                String msg = new Library2().getMessage(indexOfMessage);
                System.out.println("msg: " + msg);
            }catch(java.lang.ArrayIndexOutOfBoundsException e){
                throw new Exception("심각한 예외:", e);
            }
        }    
    }

    /**
     * Library2
     */
    public class Library2 {    
        
        String[] messages = {
            "I am 18 years old.", 
            "Maybe, I am a man.", 
            "Today is Friday. is it right?",
            "Here is U.S."
        };

        public String getMessage(int indexOfMessage){            
            //Occur RnutimeException : java.lang.ArrayIndexOutOfBoundsException
            return messages[indexOfMessage];
        }
    }
}
