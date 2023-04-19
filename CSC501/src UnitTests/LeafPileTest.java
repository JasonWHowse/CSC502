import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LeafPileTest {

    @Test
    public void test1(){//Blank Array
        Ground[][] input = {{}};
        int solution = 0;
        test(input, solution);
    }

    @Test
    public void test2(){//Grass only 1 item
        Ground[][] input = {{Ground.GRASS}};
        int solution = 0;
        test(input, solution);
    }

    @Test
    public void test3(){//Grass only 1 line
        Ground[][] input = {{Ground.GRASS, Ground.GRASS, Ground.GRASS}};
        int solution = 0;
        test(input, solution);
    }

    @Test
    public void test4(){//Leaf 1 item only
        Ground[][] input = {{Ground.LEAF}};
        int solution = 1;
        test(input, solution);
    }

    @Test
    public void test5(){//1 Line leaves and grass
        Ground[][] input = {{Ground.GRASS, Ground.LEAF, Ground.GRASS, Ground.LEAF,Ground.LEAF,Ground.LEAF,Ground.GRASS}};
        int solution = 3;
        test(input, solution);
    }

    @Test
    public void test6(){//Multi Line Grass Only Jagged
        Ground[][] input = {
                {Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS},
                {Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS},
                {Ground.GRASS, Ground.GRASS, Ground.GRASS},
                {Ground.GRASS},
                {Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS}
        };
        int solution = 0;
        test(input, solution);
    }

    @Test
    public void test7(){//Multi Line Grass Only Jagged
        Ground[][] input = {
                {Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF},
                {Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF},
                {Ground.LEAF, Ground.LEAF, Ground.LEAF},
                {Ground.LEAF},
                {Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF}
        };
        int solution = 21;
        test(input, solution);
    }

    @Test
    public void test8(){/*
    Jagged Multi Pile with entanglement 8s are false leaf pile locations and *s are true leaf pile locations
            8.888..8....*********.****.....****.
            8.8.8..8...**.......***..*....**.*
            8.888..8...**....8.......*....**.
            8.8....8.........8..******....**..8
            8888...88888888888..************
            ....................******.....***.
            .888.......**********....***.***
            .888.888.......*...............********
            .888.......*********************...
    */
        Ground[][] input = {
                {Ground.LEAF, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS },
                {Ground.LEAF, Ground.GRASS, Ground.LEAF, Ground.GRASS, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.LEAF },
                {Ground.LEAF, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.GRASS },
                {Ground.LEAF, Ground.GRASS, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.LEAF },
                {Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF },
                {Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS },
                {Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF },
                {Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF },
                {Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.LEAF, Ground.GRASS, Ground.GRASS, Ground.GRASS }
        };
        int solution = 106;
        test(input, solution);
    }

    @Test
    public void test9(){//Document Test
        Ground[][] input = {
                {Ground.GRASS ,Ground.LEAF ,Ground.LEAF ,Ground.LEAF },
                {Ground.GRASS ,Ground.GRASS ,Ground.GRASS ,Ground.GRASS },
                {Ground.GRASS ,Ground.LEAF ,Ground.LEAF ,Ground.LEAF },
                {Ground.LEAF ,Ground.GRASS ,Ground.LEAF ,Ground.GRASS }
        };
        int solution = 4;
        test(input, solution);
    }

    @Test
    public void test10(){//Document Test
        Ground[][] input = {
                {Ground.GRASS ,Ground.LEAF ,Ground.LEAF },
                {Ground.LEAF ,Ground.GRASS ,Ground.GRASS },
                {Ground.LEAF ,Ground.GRASS ,Ground.LEAF },
                {Ground.GRASS ,Ground.LEAF ,Ground.LEAF },
                {Ground.LEAF ,Ground.LEAF ,Ground.LEAF }
        };
        int solution = 6;
        test(input, solution);
    }

    @Test
    public void test11(){//Document Test
        Ground[][] input =
                {
                        {Ground.GRASS ,Ground.GRASS ,Ground.GRASS ,Ground.GRASS ,Ground.LEAF ,Ground.GRASS ,Ground.GRASS ,Ground.GRASS ,Ground.LEAF ,Ground.GRASS },
                        {Ground.LEAF ,Ground.LEAF ,Ground.GRASS ,Ground.GRASS ,Ground.LEAF ,Ground.GRASS ,Ground.LEAF ,Ground.LEAF ,Ground.LEAF ,Ground.GRASS },
                        {Ground.GRASS ,Ground.GRASS ,Ground.GRASS ,Ground.GRASS ,Ground.LEAF ,Ground.GRASS ,Ground.GRASS ,Ground.LEAF ,Ground.GRASS ,Ground.LEAF },
                        {Ground.LEAF ,Ground.GRASS ,Ground.LEAF ,Ground.LEAF ,Ground.GRASS ,Ground.GRASS ,Ground.LEAF ,Ground.LEAF ,Ground.LEAF ,Ground.LEAF },
                        {Ground.GRASS ,Ground.GRASS ,Ground.GRASS ,Ground.LEAF ,Ground.GRASS ,Ground.GRASS ,Ground.LEAF ,Ground.LEAF ,Ground.GRASS ,Ground.LEAF }
                };
        int solution = 13;
        test(input, solution);
    }

    private void test(Ground[][] input, int solution){
        assertEquals(solution, LeafPile.largestLeafPileUnitTest(input));
    }
}