package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void OneElementInSeqKeyIsPresentTest()
    {
        int key = 7;
        int [] seq = new int[] {7};
        BinarySearch binarySearch = BinarySearch.create();
        SearchResult searchResult = binarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(key, seq[searchResult.getPosition()]);
    }
}