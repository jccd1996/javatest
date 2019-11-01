package com.jccd.javatests.player;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {
    Dice dice;

    @Before
    public void setup(){
        dice = Mockito.mock(Dice.class);
    }

    @Test
    public void looses_when_dice_number_is_too_low() {
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice,3);
        assertFalse(player.play());
    }
    @Test
    public void win_when_dice_number_is_big() {
        Mockito.when(dice.roll()).thenReturn(4);

        Player player = new Player(dice,3);
        assertTrue(player.play());
    }
}