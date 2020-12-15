import java.util.Scanner;

class Main {
 public static void main(String[] args) {
  
   Scanner sc = new Scanner(System.in);

   //controls whether the chat bot is still talking
   boolean keepRunning = true;

   //inital chat bot message
   System.out.println("Hello!");

   //a loop that keeps reading in what the user types in
   //it then prints out a response from the chat bot
   while(keepRunning) {

     String userSaid = sc.nextLine();
     String response = getResponse(userSaid);

     System.out.println(response);
     if (response.equals("Have a nice day, or not. I don't really care.\n\nEND OF CHAT")){
       keepRunning=false;// Part 4 (A), ends loop when user says bye or goodbye
     }
   }
 }

 //method that determines what the chat bot says
 //based on the users input
 public static String getResponse(String userInput) { //PART A
 

    
   if(userInput.equals("")){
     return "Please save me from depression I am so lonely, say something!";//Part C- if the user types no characters
     //Part B (1) If the user types two keywords, the output is whatever code for any of the specific keywords comes first in the program
   }
   userInput= userInput.toLowerCase(); //Part B (2) Switches all inputs to lower case letters to fit the index down below (everything lowercase)
  String accumulator= "";

  for(int i=0;i<userInput.length();i++){
    if (userInput.substring(i,i+1).compareTo("a")>=0 && userInput.substring(i,i+1).compareTo("z")<=0){
      accumulator+=userInput.substring(i,i+1);
    }
    if (userInput.substring(i,i+1).equals(" ")){
       accumulator+=userInput.substring(i,i+1);
    }
  }
  userInput=accumulator;//PART FOUR (B) uses a loop to extract any characters that are not part of the alphabet or a space to make the program run smoother
   if(hasKeyword(userInput,"bye") || hasKeyword(userInput,"goodbye")){
     return "Have a nice day, or not. I don't really care.\n\nEND OF CHAT";//Part FOUR (A)

   }
   if(hasKeyword(userInput,"hi")||hasKeyword(userInput,"hey")||hasKeyword(userInput,"sup") || hasKeyword(userInput,"hello")){//part 3 
     return "How ya doin'?";
   }
  
   int a= userInput.indexOf("clamp");
   if (a!=-1){
     return "Put 'em in the clamps!";
   }
  
   if(hasKeyword(userInput,"bojack")){//part 3
    
     return "Bojack Horseman is an amazing show!";
   }
 
   if (hasKeyword(userInput,"sports")||hasKeyword(userInput,"basketball") || hasKeyword(userInput,"baseball") || hasKeyword(userInput,"football")){ //part3
     return "Did you mention sports? I love playing sports and so does my creator!";
   }
    if (hasKeyword(userInput,"television")||hasKeyword(userInput,"show") || hasKeyword(userInput,"TV")){ //part3
     return "My favorite TV show is Breaking Bad. What's yours?";
   }
    if (hasKeyword(userInput,"movie")||hasKeyword(userInput,"theatre") || hasKeyword(userInput,"comedy") || hasKeyword(userInput,"comedies")){ //part3
     return "I love movies, especially Marvel movies, and my favorite genre are comedies. What's your favorite movie or genre?";
   }

   int f= userInput.indexOf("do you ");
     if(f!=-1){
       String after= userInput.substring(f+7);
       return "Maybe I "+after+", maybe I don't.";
     }
  
   return getRandomResponse() ;  //Calling method for part D & E (if none of they keywords are found)
   }
 public static String getRandomResponse(){// Part D & E
 String a= "Uhhh, what?";
 String b= "Go on.";
 String c= "And how do you feel about that?";
 String d= "Please stop talking.";
 String e= "That's what the government wants you to think";
 String f= "k";
 String g="I honestly don't care.";
 int ran= (int)(Math.random()*7+1);
 if (ran==1){
   return a;
 }
 if (ran==2){
   return b;
 }
 if (ran==3){
   return c;
 }
 if (ran==4){
   return d;
 }
 if (ran==5){
   return e;
 }
 if(ran==6){
   return f;
 }
 return g;
 }

public static boolean hasKeyword(String message, String keyword) {//PART 3

   //pad beginning and end of keyword and message with spaces, put in lowercase
message = (" " + message + " ").toLowerCase();
keyword = (" " + keyword + " ").toLowerCase();

   int pos = message.indexOf(keyword);
   return pos >= 0;
}

}
 

