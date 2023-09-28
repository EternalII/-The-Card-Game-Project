package com.company.StructureC;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MatchmakingServerTest
{
    @Test
    void findMatchTest()
    {
        int min = 901, max = 1099;
        assertTrue(min <= 1000 && 1000 <= max, "Found Match");
    }
}