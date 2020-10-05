package Tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Tests2 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("file.txt"));
        String name="diana";
        bufferedWriter.write('k');
        bufferedWriter.close();
    }
}
