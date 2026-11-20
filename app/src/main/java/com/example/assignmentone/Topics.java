package com.example.assignmentone;

/**
 * Shared lookup tables for the four topics, in the same order as res/values/arrays.xml.
 */
final class Topics {

    static final int[] BUTTON_IDS = {
            R.id.buttonFacilities, R.id.buttonEvents, R.id.buttonClubs, R.id.buttonSupport
    };

    static final int[] LABEL_IDS = {
            R.string.label_facilities, R.string.label_events,
            R.string.label_clubs, R.string.label_support
    };

    static final int COUNT = BUTTON_IDS.length;

    private Topics() {
    }
}
