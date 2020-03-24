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
}