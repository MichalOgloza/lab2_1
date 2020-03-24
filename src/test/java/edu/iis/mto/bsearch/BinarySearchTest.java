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
        multiSeq = new int[] {2, 4, 7, 19, 25, 37, 93, 198, 512};
        binarySearch = BinarySearch.create();
    }

    @Test
    void OneElementInSeqKeyIsPresentTest()
    {
        int key = 7;
        SearchResult searchResult = binarySearch.search(key, singleSeq);
        assertTrue(searchResult.isFound());
        assertEquals(key, singleSeq[searchResult.getPosition()]);
    }

    @Test
    void OneElementInSeqKeyIsAbsentTest()
    {
        int key = 3;
        SearchResult searchResult = binarySearch.search(key, singleSeq);
        assertFalse(searchResult.isFound());
        assertEquals(NOT_FOUND, searchResult.getPosition());
    }

    @Test
    void MultipleElementSeqKeyIsPresentAtFirstPositionTest()
    {
        int key = 2;
        SearchResult searchResult = binarySearch.search(key, multiSeq);
        assertTrue(searchResult.isFound());
        assertEquals(key, multiSeq[searchResult.getPosition()]);
    }

    @Test
    void MultipleElementSeqKeyIsPresentAtLastPositionTest()
    {
        int key = 512;
        SearchResult searchResult = binarySearch.search(key, multiSeq);
        assertTrue(searchResult.isFound());
        assertEquals(key, multiSeq[searchResult.getPosition()]);
    }

    @Test
    void MultipleElementSeqKeyIsPresentAtCentralPositionTest()
    {
        int key = 25;
        SearchResult searchResult = binarySearch.search(key, multiSeq);
        assertTrue(searchResult.isFound());
        assertEquals(key, multiSeq[searchResult.getPosition()]);
    }

    @Test
    void MultipleElementSeqKeyIsAbsentTest()
    {
        int key = 22;
        SearchResult searchResult = binarySearch.search(key, multiSeq);
        assertFalse(searchResult.isFound());
        assertEquals(NOT_FOUND, searchResult.getPosition());
    }

    @Test
    void EmptySeqTest()
    {
        int key = 0;
        int [] emptySeq = new int[0];
        assertThrows(IllegalArgumentException.class, () -> binarySearch.search(key, emptySeq));
    }
}