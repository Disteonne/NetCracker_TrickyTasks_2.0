package TaskTwo;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class GuessWords {
    private ArrayList<String> list=new ArrayList<>();
    Path path = Paths.get("");
    private String s = path.toAbsolutePath().toString() + "\\src\\main\\resources";
    private ArrayList<Character> guessWord=new ArrayList<>();
    private File actionsFile;

    void addWordsToList(){
        try {
            File fileReader = new File(s + "\\TextWords");
            Scanner scanner = new Scanner(fileReader);
            String[] splitFile;
            while (scanner.hasNext()) {
                splitFile = scanner.nextLine().split(" ");
                for (String s : splitFile
                ) {
                    list.add(s);
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
    }
    void startGame(){
        addWordsToList();
        //загадываем рандомное слово из списка
        int a = 0;
        int b = list.size();
        int random_index = a + (int) Math.random() * b;
        String randomWord=list.get(random_index);
        char[] randomWordToCharArray = randomWord.toCharArray();
        guessWord = new ArrayList<>(randomWordToCharArray.length);
        for (int i = 0; i < randomWordToCharArray.length; i++) {
            guessWord.add('_');
        }
        actionsFile = new File(s + "\\actions.txt");
        try (BufferedWriter buff=new BufferedWriter(new FileWriter(actionsFile))){

            //BufferedWriter buff=new BufferedWriter(new FileWriter(actionsFile));
            System.out.println("Input your name: ");
            buff.write(new Scanner(System.in).nextLine()+"\n");
            boolean flagLose=true;
            String result="";
            byte count=1;
            while (count!=randomWordToCharArray.length+1) {
                System.out.println("Input Character: ");
               String choice=new Scanner(System.in).nextLine();

                if(choice!="exit") {
                    char[] your_choice = choice.toCharArray();
                    if (your_choice.length > 1) {
                        System.out.println("Error");
                        break;
                    } else {
                        System.out.println("Key in one character or your guess word: " + your_choice[0]);
                        buff.write("Key in one character or your guess word: " + your_choice[0]);
                        for (int i = 0; i < randomWordToCharArray.length; i++) {
                            if (randomWordToCharArray[i] == your_choice[0]) {
                                guessWord.remove(i);
                                guessWord.add(i, your_choice[0]);
                                randomWordToCharArray[i] = '_';
                                for (Character c : guessWord
                                ) {
                                    result += c;
                                }
                                System.out.println("Trial " + count + ": " + result);
                                buff.write("Trial " + count + ": " + result + "\n");

                                if (result.equals(randomWord)) {
                                    System.out.println("You win!");
                                    buff.write("You win!\n");
                                    //scanner.close();
                                    break;
                                }
                                result = "";
                                flagLose = false;
                                break;
                            }
                        }
                        if (flagLose == true) {
                            System.out.println("You lost! :(");
                            buff.write("You lost! :( \n");
                            //scanner.close();
                            break;
                        }
                        count++;
                    }
                }else
                    break;
            }
        }catch (IOException e){
            System.out.println("error");
        }
    }

    public static void main(String[] args) {
        GuessWords guessWords=new GuessWords();
        guessWords.startGame();
    }
}
