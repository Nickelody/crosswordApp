package com.omen273.crossLingo

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NotEnoughWordsInstrumentedTest : ChoseTopicsToastTest() {

    @Test
    fun notEnoughWordsInstrumentedTest() {
        choseTopicsImpl(
            "notEnoughWords.json", getContext().getString(
                R.string.not_enough_words,
                ChooseTopicsActivity.CROSSWORD_SIZE
            )
        )
    }
}