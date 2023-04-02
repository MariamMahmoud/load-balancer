package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution sol = new Solution();
    @Test
    void testAddServer() {
        int response = sol.addServer("1");
        assertNotNull(response);
        assertTrue(response <= 9);
    }

    @Test
    void testPoolLimitReached() {
        for(int i=0 ; i < 11; i++) {
            sol.addServer(Integer.toString(i));
        }
        assertThrows(IllegalArgumentException.class, () -> sol.addServer("11"));
    }

    @Test
    void testNotUniqueAddress() {
        sol.addServer("11");
        assertThrows(IllegalArgumentException.class, () -> sol.addServer("11"));
    }

    @Test
    void testGetServer() {
        sol.addServer("1");
        sol.addServer("2");
        sol.addServer("3");

        String response = sol.getServer();
        assertNotNull(response);
        assertTrue(response.equals("1") || response.equals("2") || response.equals("3") );
    }

    @Test
    void testGetServerExists() {
        assertThrows(IllegalArgumentException.class, () -> sol.getServer());
    }
}