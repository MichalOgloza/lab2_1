package edu.iis.mto.bsearch;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private static final int NOT_FOUND = -1;
    private static int [] singleSeq;
    private static int [] multiSeq;
    private static BinarySearch binarySearch;

    @BeforeAll
    static void init()
    {
        singleSeq = new int[] {7};
        multiSeq = new int[] {-23, -4, 0, 7, 25, 37, 93, 198, 512};
        binarySearch = BinarySearch.create();
    }

    @Test
    void oneElementInSeqKeyIsPresentTest()
    {
        int key = 7;
        SearchResult searchResult = binarySearch.search(key, singleSeq);
        assertTrue(searchResult.isFound());
        assertEquals(key, singleSeq[searchResult.getPosition()]);
    }

    @Test
    void oneElementInSeqKeyIsAbsentTest()
    {
        int key = -3;
        SearchResult searchResult = binarySearch.search(key, singleSeq);
        assertFalse(searchResult.isFound());
        assertEquals(NOT_FOUND, searchResult.getPosition());
    }

    @Test
    void multipleElementSeqKeyIsPresentAtFirstPositionTest()
    {
        int key = -23;
        SearchResult searchResult = binarySearch.search(key, multiSeq);
        assertTrue(searchResult.isFound());
        assertEquals(key, multiSeq[searchResult.getPosition()]);
    }

    @Test
    void multipleElementSeqKeyIsPresentAtLastPositionTest()
    {
        int key = 512;
        SearchResult searchResult = binarySearch.search(key, multiSeq);
        assertTrue(searchResult.isFound());
        assertEquals(key, multiSeq[searchResult.getPosition()]);
    }

    @Test
    void multipleElementSeqKeyIsPresentAtCentralPositionTest()
    {
        int key = 25;
        SearchResult searchResult = binarySearch.search(key, multiSeq);
        assertTrue(searchResult.isFound());
        assertEquals(key, multiSeq[searchResult.getPosition()]);
    }

    @Test
    void multipleElementSeqKeyIsAbsentTest()
    {
        int key = 23;
        SearchResult searchResult = binarySearch.search(key, multiSeq);
        assertFalse(searchResult.isFound());
        assertEquals(NOT_FOUND, searchResult.getPosition());
    }

    @Test
    void emptySeqTest()
    {
        int key = 0;
        int [] emptySeq = new int[0];
        assertThrows(IllegalArgumentException.class, () -> binarySearch.search(key, emptySeq));
    }

    @Test
    void nullSeqTest()
    {
        int key = 0;
        assertThrows(NullPointerException.class, () -> binarySearch.search(key, null));
    }

    @Test
    void lowerThanMinimumSeqValueTest()
    {
        int key = -300;
        SearchResult searchResult = binarySearch.search(key, multiSeq);
        assertFalse(searchResult.isFound());
        assertEquals(NOT_FOUND, searchResult.getPosition());
    }

    @Test
    void higherThanMaximumSeqValueTest()
    {
        int key = 1002;
        SearchResult searchResult = binarySearch.search(key, multiSeq);
        assertFalse(searchResult.isFound());
        assertEquals(NOT_FOUND, searchResult.getPosition());
    }

    // Result of this test should be failed
    @Test
    void descendingSeqOrderTestFAILED()
    {
        int key = -12;
        int [] descSeq = new int[] {97, 43, 21, 5, 4, 0, -3, -12, -60};
        SearchResult searchResult = binarySearch.search(key, descSeq);
        assertTrue(searchResult.isFound());
        assertEquals(key, descSeq[searchResult.getPosition()]);
    }

    @Test
    void duplicatesInSeqTest()
    {
        int key = 7;
        int centralIndex = 3;
        int [] dupSeq = new int[] {1, 3, 7, 7, 7, 7, 10};
        SearchResult searchResult = binarySearch.search(key, dupSeq);
        assertTrue(searchResult.isFound());
        assertEquals(centralIndex, searchResult.getPosition());
    }



}