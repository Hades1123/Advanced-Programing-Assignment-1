import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    @Test
    @DisplayName("Generate input")
    void generateTest(){
        String fileName = "util/input.txt";
        // hp wp ground
        try (PrintWriter out = new PrintWriter(fileName)) {
            for (int i = 0 ; i < 10000; ++ i){
                Random r = new Random();
                int hp = r.nextInt(10000);
                int wp = r.nextInt(3);
                int ground = (hp * 3 - 1000) / 2;
                out.printf("%d,%d,%d\n", hp, wp, ground);
            }
        }
        catch (Exception e) {
            System.out.println("T_T");
        }
    }

    @Test
    @DisplayName("Generate my output")
    void generateOutputTest(){
        String outputFile = "util/output.txt";
        String inputFile = "util/input.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(inputFile));
            PrintWriter out = new PrintWriter(new FileWriter(outputFile))) {
            String line, className;
            Fighter obj;
            while ((line = in.readLine()) != null) {
                String[] nums = line.split(",");
                int hp = Integer.parseInt(nums[0]);
                int wp = Integer.parseInt(nums[1]);
                int ground = Integer.parseInt(nums[2]);
                if (hp % 2 == 0){
                    obj  = new Paladin(hp, wp);
                    className = "Paladin";
                }
                else if (hp % 3 == 0){
                    obj  = new Knight(hp, wp);
                    className = "Knight";
                }
                else {
                    obj = new Warrior(hp, wp);
                    className = "Warrior";
                }
                Battle.GROUND = ground;
                String myResult = String.format("%s %.2f", className, obj.getCombatScore());
                out.println(myResult);
            }
        }
        catch (Exception e) {
            System.out.println("T_T");
        }
    }

    @Test
    @DisplayName("Random testcase")
    void randomTest(){
        String inputFile = "util/input.txt";
        String outputFile = "util/output.txt";
        try(BufferedReader inReader = new BufferedReader(new FileReader(inputFile));
        BufferedReader outReader = new BufferedReader(new FileReader(outputFile))) {
            String inLine, outLine, className;
            Fighter obj;
            while((inLine = inReader.readLine()) != null && (outLine = outReader.readLine()) != null){
                String[] nums = inLine.split(",");
                int hp = Integer.parseInt(nums[0]);
                int wp = Integer.parseInt(nums[1]);
                int ground = Integer.parseInt(nums[2]);
                if (hp % 2 == 0){
                    obj  = new Paladin(hp, wp);
                    className = "Paladin";
                }
                else if (hp % 3 == 0){
                    obj  = new Knight(hp, wp);
                    className = "Knight";
                }
                else {
                    obj = new Warrior(hp, wp);
                    className = "Warrior";
                }
                Battle.GROUND = ground;
                String yourResult = String.format("%s %.2f", className, obj.getCombatScore());
                Assertions.assertEquals(yourResult, outLine);
            }
        }
        catch (IOException e){
            System.out.println("T_T");
        }
    }
}