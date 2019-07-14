package com.beyondcoding.java11.stream.advanced.sms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class SmsSummarizerTest {

    private SmsSummarizer summarizer = new SmsSummarizer();

    @Test
    void testHamSpamRatio() {
        String ratios = summarizer.getHamSpamRatio();
        Assertions.assertEquals("ham 86% spam 13%", ratios);
    }

    @Test
    void testMostUsedHamWord() {
        Optional<String> word = summarizer.getMostUsedHamWord();
        Assertions.assertTrue(word.isPresent());
        Assertions.assertEquals("to", word.get());
    }

    @Test
    void testMostUsedHamLetter() {
        Optional<String> letter = summarizer.getMostUsedHamLetter();
        Assertions.assertTrue(letter.isPresent());
        Assertions.assertEquals("e", letter.get());
    }

    @Test
    void testLongestSpamMessage() {
        int length = summarizer.getLengthOfLongestSpamMessage();
        Assertions.assertEquals(224, length);
    }

}