package edu.iis.mto.bsearch;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

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
        assertEquals(-1, searchResult.getPosition());
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
}