import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest(name = "base={0} wp={1} ground={2} score={3}" )
    @CsvSource({
            "6766,2,4,20298.00",
            "1,3,3,3.0",
            "1836311903,3,1,1046",
            "2,3,1,1003",
            "34,1,3,1009"
    })
    void Paladin_Test_1(int base, int wp, int ground, double score) {
        Battle.GROUND = ground;
        Fighter obj = new Paladin(base, wp);
        Assertions.assertEquals(score, obj.getCombatScore());
    }

    @ParameterizedTest(name = "base={0} wp={1} ground={2} score={3}" )
    @CsvSource({
            "10,1,-6,10.00",
            "100,1,0,100.00",
            "100,1,2,200.00",
            "100,1,4,100.00",
            "100,1,11,200.00",
            "100,2,12,10",
            "254,2,12,25.4",
            "5,2,12,0.5"
    })
    void Warrior_Test_1(int base, int wp, int ground, double score) {
        Battle.GROUND = ground;
        Fighter obj = new Warrior(base, wp);
        Assertions.assertEquals(score, obj.getCombatScore());
    }

    @ParameterizedTest(name = "base={0} wp={1} ground={2} score={3}" )
    @CsvSource({
            "12,1,0,24",
            "200,1,1,400",
            "200,1,2,200",
            "456,2,10,45.6",
            "220,1,16,440"
    })
    void Knight_Test_1(int base, int wp, int ground, double score) {
        Battle.GROUND = ground;
        Fighter obj = new Knight(base, wp);
        Assertions.assertEquals(score, obj.getCombatScore());
    }

    @ParameterizedTest(name = "real={0} img={1} score={2}" )
    @CsvSource({
            "12,34,36",
            "23,123,125",
            "490,890,1016"
    })
    void DeathEater_Test_1(int real, int img, double score) {
        DeathEater obj = new DeathEater(new Complex(real,img));
        Assertions.assertEquals(score, Math.round(obj.getCombatScore()));
    }
}