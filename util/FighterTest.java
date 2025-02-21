import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

class FighterTest {

    @Test
    @DisplayName("Random testcase")
    void randomTest() {
        String inputFile = "util/input.txt";
        String outputFile = "util/output.txt";
        try (BufferedReader inReader = new BufferedReader(new FileReader(inputFile));
                BufferedReader outReader = new BufferedReader(new FileReader(outputFile))) {
            String inLine, outLine, className;
            Fighter obj;
            while ((inLine = inReader.readLine()) != null && (outLine = outReader.readLine()) != null) {
                String nextOutLine = outReader.readLine();
                String[] nums = inLine.split(",");
                int hp = Integer.parseInt(nums[0]);
                int wp = Integer.parseInt(nums[1]);
                int ground = Integer.parseInt(nums[2]);
                if (hp % 2 == 0) {
                    obj = new Paladin(hp, wp);
                    className = "Paladin";
                } else if (hp % 3 == 0) {
                    obj = new Knight(hp, wp);
                    className = "Knight";
                } else {
                    obj = new Warrior(hp, wp);
                    className = "Warrior";
                }
                Battle.GROUND = ground;
                String yourResult = String.format("hp=%d ; wp=%d ; ground=%d\n%s %.2f", hp, wp, ground, className,
                        obj.getCombatScore());
                String myResult = String.format("%s\n%s", outLine, nextOutLine);
                Assertions.assertEquals(myResult, yourResult);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}