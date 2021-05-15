import java.util.Scanner;
public class VCC {
    private static Scanner input;
    private static String message;
     private static String mappedKey;
     
     public static void main (String[]args){
        input= new Scanner(System.in);
        System.out.println("press : 1 to Encrypte or 2 to decrypte  ");
        int x = input.nextInt();
        input.nextLine();
        if ( x == 1) {
            System.out.println("encrypting");
             txtkey();
             cipherEncryption(message, mappedKey);
            
        } else if (x == 2){
            System.out.println("Decrypting");
                 txtkey();
             cipherDecryption(message, mappedKey);
        }
          else {
            System.out.println("invalide choice !!");
          }
        
     
        
     }

    private static void txtkey() {
       System.out.println("enter your text in alphabet !");
       String txt = input.nextLine();
       txt = txt.toUpperCase();
       
       
       System.out.println("enter your key in alphabet !");
        String key = input.nextLine();
        input.nextLine();
       key = key.toUpperCase();
       
       String keyMap = "";
       for (int i=0, j=0; i<txt.length();i++){
           if ( txt.charAt(i)== (char)32){
               keyMap+=(char)32;
           }
           else {
               if (j<key.length()){
                    keyMap+=key.charAt(j);
                    j++;
               }
               else{
                   j=0;
                   keyMap +=key.charAt(j);
                   j++;
                   
           
               }
           }
       }
       message = txt;
       mappedKey = keyMap;
       
        System.out.println("message = "+message);
        System.out.println("key = "+mappedKey);
    }

    private static void cipherEncryption(String message, String mappedKey) {
        int[][] table = createVigenereTable();
        String encryptedText="";
        for (int i=0; i< message.length(); i++){
             if (message.charAt(i) == (char)32 && mappedKey.charAt(i) == (char)32){
                encryptedText+=" ";
            } else {
                encryptedText +=(char)table[(int)message.charAt(i)-65][(int)mappedKey.charAt(i)-65];
                
            }
        }
        System.out.println("encrypted text :" +encryptedText );
       
    }

    private static int[][] createVigenereTable() {
       //26*26 alpha
        int[][] tableArr = new int[26][26];
        for ( int i=0; i<26 ; i++){
            for ( int j=0 ; j<26 ;j++){
                int x;
                if ((i+65)+j >90){
                    x=((i+65)+j)-26;
                    tableArr[i][j]=x;
                }else{
                   x=((i+65)+j); 
                   tableArr[i][j]=x;

                }
            }
        }
for (int i =0; i<26;i++){
    for (int j =0; j<26;j++){
        System.out.print((char)tableArr[i][j]+"");
    }
     System.out.println();
}
return tableArr;
    }

    private static void cipherDecryption(String message, String mappedKey) {
        int[][] table = createVigenereTable();
        String decryptedText="";
        for (int i=0; i<message.length();i++){
            if( message.charAt(i) == (char)32 && mappedKey.charAt(i) == (char)32){
                decryptedText += " ";
            }else {
                decryptedText += (char)(65 + itrCount((int)mappedKey.charAt(i), (int)message.charAt(i)));
            }
        }
       System.out.println("decrypted text = " +decryptedText);
    }

    private static int itrCount(int key, int txt) {
        int counter = 0;
        String result="";
        for (int i=0; i<26; i++){
            if(key+i >90){
                result +=(char)(key + (i-26));
            }else{
                result +=(char)(key+i);
            }
        }
       for (int i=0; i<result.length(); i++){
           if ( result.charAt(i)== txt){
               break;
           }else{
               counter++;
           }
           
       } 
      return counter; 
    }
}
     
    


