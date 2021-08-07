package ru.netology.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RadioTest {
    Radio radio = new Radio();
    @Test
    void nextChannel() {

           radio.setCurrentStation(0);
            radio.turnNextRadioStation();
            int expected = 1;
            int actual = radio.getCurrentStation();
            assertEquals(expected, actual);
        }

    @Test
    void turnPreviousStation() {
        radio.setMaxStation(9);
        radio.setMinStation(0);
        radio.setCurrentStation(9);
        radio.turnPreviousRadioStation();
        int expected = (8);
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void turnNextIfCurrentIsLastStation() {
        radio.setMaxStation(9);
        radio.setMinStation(0);
        radio.setCurrentStation(9);
        radio.turnNextRadioStation();
        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void nextChannelafterlast() {
        radio.setMaxStation(9);
        radio.setMinStation(0);
        radio.setCurrentStation(0);
        radio.turnPreviousRadioStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }


    @Test
    void channelchoices() {
        radio.chooseCurrentRadioStation(4);
        radio.setMaxVolume(9);
        radio.setMinVolume(0);
        int expected = 4;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }


    @Test
    void turnUpVolume() {
        radio.setMaxVolume(10);
        radio.setMinVolume(0);
        radio.setCurrentVolume(5);
        radio.turnUpVolume();
        int expected = 6;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void turnDownVolume() {
        radio.setMaxVolume(10);
        radio.setMinVolume(0);
        radio.setCurrentVolume(4);
        radio.turnDownVolume();
        int expected = 3;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void turnUpVolumeIsMax() {
        radio.setMaxVolume(10);
        radio.setMinVolume(0);
        radio.setCurrentVolume(10);
        radio.turnUpVolume();
        int expected = 10;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void turnDownVolumeIsMin() {
        radio.setMinVolume(0);
        radio.setMaxVolume(10);
        radio.setCurrentVolume(0);
        radio.turnDownVolume();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCurrentVolumeHighMax() {
        radio.setMinVolume(0);
        radio.setMaxVolume(10);
        radio.setCurrentVolume(11);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldCurrentVolumeBelowMin() {
        radio.setMinVolume(0);
        radio.setMaxVolume(10);
        radio.setCurrentVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }
}
