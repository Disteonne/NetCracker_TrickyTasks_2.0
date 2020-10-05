package TaskTwo;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Guess {
    //private String[] array={"Cracker","Hello","Rick","Spock"};
    Path path = Paths.get("");
    private String s = path.toAbsolutePath().toString() + "\\src\\main\\resources";
    ;
    private File fileActions = new File(s + "\\actions.txt");
    private String name;
    private ArrayList<String> words = new ArrayList<>();
    private FileReader fileReader;
    private ArrayList<Character> guessWord;
    private String result = "";
    private File copyFile = new File(s + "\\copyFile.txt");

    private void initList(){
        try {
            File fileReader = new File(s + "\\TextWords");
            Scanner scanner = new Scanner(fileReader);
            String str;
            String[] splitFile;
            while (scanner.hasNext()) {
                splitFile = scanner.nextLine().split(" ");
                for (String s : splitFile
                ) {
                    words.add(s);
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
    }
    public void guessTheWordOne(){
        initList();
        try {
            System.out.println("Enter 'start' to get started and 'exit' to end");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileActions));
            System.out.println("Enter your name,please: ");
            name = new Scanner(System.in).nextLine();
            bufferedWriter.write(name);

            int a = 0;
            int b = words.size();
            int random_index = a + (int) Math.random() * b;
            //String guess=words.get(random_index);
            char[] randomWordToCharArray = words.get(random_index).toCharArray();
            guessWord = new ArrayList<>(randomWordToCharArray.length);
            for (int i = 0; i < randomWordToCharArray.length; i++) {
                guessWord.add('_');
            }
            System.out.println("Enter character: ");
            String str = "";
            byte i = 1;
            //while ((str = new Scanner(System.in).nextLine()) != "exit" ) {
            for (int k =0;; k++) {
            boolean flagLost=true;
            //while (flagLost){
                 str=new Scanner(System.in).nextLine();
                if(str.equals("exit")){
                    bufferedWriter.close();
                    break;
                }
                //(str = new Scanner(System.in).nextLine()) != "exit" &&
                else if (str.equals("new start")) {
                    System.out.println(name+" finished the game. New start!");
                    bufferedWriter.write(name+" finished the game.New start!");
                    bufferedWriter.close();
                    guessTheWordOne();
                }
                else {
                    char[] addWord = str.toCharArray();
                    if (addWord.length > 1) {
                        break;
                    }
                    //String choice=new Scanner(System.in).nextLine();
                    else {
                        boolean flag = false;
                        System.out.println("Key in one character or your guess word: " + addWord[0]);
                        bufferedWriter.write("Key in one character or your guess word: " + addWord[0] + "\n");
                        for (int j = 0; j < randomWordToCharArray.length; j++) {
                            if (randomWordToCharArray[j] == addWord[0]) {
                                guessWord.remove(j);
                                guessWord.add(j, addWord[0]);
                                randomWordToCharArray[j] = '_';
                                for (Character c : guessWord
                                ) {
                                    result += c;
                                }
                                System.out.println("Trial " + i + ": " + result);
                                bufferedWriter.write("Trial " + i + ": " + result + "\n");
                                result = "";
                                if (i == randomWordToCharArray.length) {
                                    System.out.println("You are win!");
                                    bufferedWriter.write(name + " won!");
                                    bufferedWriter.close();
                                    break;
                                    //System.out.println(" 'new start' OR 'exit' ");
                                }
                                flag = true;
                                break;
                            }
                        }
                        if (flag == false) {
                            System.out.println("You lost");
                            bufferedWriter.write(name + " lost");
                            bufferedWriter.close();
                            flagLost=true;
                            break;
                        }
                        i++;
                    }
                }
            }
                //}
                //}
            } catch(IOException ex){
                ex.getStackTrace();
            }


        }

        public static void main (String[]args) throws IOException {
            Guess guess = new Guess();
            guess.guessTheWordOne();
        }
    }

