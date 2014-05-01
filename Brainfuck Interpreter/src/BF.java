import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
/**
 * Interprets Brainf**k source from std in or a file.
 * 
 * @author Mike Neurohr
 */
public class BF{
	private static int pointer;//memory pointer
	private static int codeIndex;//instruction number
	private static final int INITIAL_SIZE= 1000;//initial size of memory
	private static final String instChars= "[]<>,.+-";//valid code characters
 
	/**
	 * The main program. Holds the input loop and error-handling.
	 * 
	 * @param args 0: Source file    others: ignored
	 */
	public static void main(String[] args){
		BufferedReader source;
		try{
			if(args.length == 0){//if no file specified
				source= new BufferedReader(new InputStreamReader(System.in));
			}else{
				source= new BufferedReader(new FileReader(args[0]));
			}
			char instruction;
 
			//holds the cleaned up code
			StringBuilder code= new StringBuilder();
 
			//count for loop syntax errors
			int bCnt= 0;
 
			//read whole source in
			for(instruction= (char)source.read(); source.ready(); instruction=
					(char)source.read()){
				//remove extra characters
				if(instChars.contains(instruction + "")){
					//add the instruction to the clean code
					code.append(instruction);
					if(instruction == '[') bCnt++;
					if(instruction == ']') bCnt--;
				}
			}
			if(bCnt != 0){//if there is a bracket with no match
				System.err.println("Error: Uneven brackets.");
				return;
			}
 
			//set up input for ,
			BufferedReader input=
					new BufferedReader(new InputStreamReader(System.in));
			//set up memory
			ArrayList<Integer> memory= new ArrayList<Integer>(INITIAL_SIZE);
			memory.add(new Integer(0));
 
			pointer= 0; //initialize pointer
			//loop through the cleaned up code and execute
			for(codeIndex= 0;codeIndex < code.length();codeIndex++){
				instruction= code.charAt(codeIndex);
				switch(instruction){
				case '+':
					memory.set(pointer, memory.get(pointer) + 1);
					break;
				case '-':
					memory.set(pointer, memory.get(pointer) - 1);
					break;
				case '.':
					System.out.print((char)memory.get(pointer).intValue());
					break;
				case ',':
					input(memory, input);
					break;
				case '[':
					if(memory.get(pointer) == 0){
						//skip the code inside the loop
						jumpForward(code);
					}
					//if the loop can continue...
					//we don't need to check other things
					break;
				case ']':
					if(memory.get(pointer) != 0){
						//go back to the corresponding [ to check
						jumpBack(code);
					}
					//if the loop should stop...
					//we don't need to check other things
					break;
				case '>':
					pointer++;
					//gets rid of NullPointerExceptions
					while(pointer + 1 > memory.size()) memory.add(0);
					break;
				case '<':
					if(--pointer < 0){
						//can't do it
						System.err.println("Pointer out of range (negative).");
						return;
					}
				default:
					//No other characters left after the cleaning
				}
			}
		}catch(FileNotFoundException e){
			System.err.println("Error opening file: " + args[0] + ".");
		}catch(IOException e){
			System.err.println("Error on input.");
		}
	}
 
	public static void jumpBack(StringBuilder code){
		//initial count for the bracket we're on
		int bracketCnt= 1;
		//count brackets until the corresponding [
		while(codeIndex >= 0 && bracketCnt != 0){
			codeIndex--;
			char inst= code.charAt(codeIndex);
			if(inst == '[') bracketCnt--;
			if(inst == ']') bracketCnt++;
		}
		//"- 1" to offset the next "codeIndex++".
		codeIndex= codeIndex - 1;
	}
 
	public static void jumpForward(StringBuilder code){
		//initial count for the bracket we're on
		int bracketCnt= 1;
		//count brackets until the corresponding ]
		while(codeIndex < code.length() && bracketCnt != 0){
			codeIndex++;
			char inst= code.charAt(codeIndex);
			if(inst == ']') bracketCnt--;
			if(inst == '[') bracketCnt++;
		}
	}
 
	public static void input(ArrayList<Integer> mem, BufferedReader input)
			throws IOException{
		int val;
		//read until something comes in other than return chars
		for(val= input.read(); val == 10 || val == 13; val= input.read());
		mem.set(pointer, new Integer(val));
 	}
}