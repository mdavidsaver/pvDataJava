/**
 * Copyright - See the COPYRIGHT that is included with this distribution.
 * EPICS pvData is distributed subject to a Software License Agreement found
 * in file LICENSE that is included with this distribution.
 */
package org.epics.pvdata.misc;



/**
 * The scan priorities for a record instance that is event or periodically scanned.
 * @author mrk
 *
 */
public enum ThreadPriority {
    /**
     * Lowest priority.
     */
    lowest,
    /**
     * Lower priority.
     */
    lower,
    /**
     * Low priority.
     */
    low,
    /**
     * Middle priority.
     */
    middle,
    /**
     * High priority. 
     */
    high,
    /**
     * Higher priority.
     */
    higher,
    /**
     * Highest priority.
     */
    highest;
    
    /**
     * Get the java priority corresponding to each ScanPriority.
     */
    public static final int[] javaPriority = {
        Thread.MIN_PRIORITY,
        Thread.MIN_PRIORITY + 1,
        Thread.NORM_PRIORITY - 1,
        Thread.NORM_PRIORITY,
        Thread.NORM_PRIORITY + 1,
        Thread.MAX_PRIORITY - 1,
        Thread.MAX_PRIORITY};
    
    /**
     * Get the Java priority for this ScanPriority.
     * 
     * @return The java priority
     */
    public int getJavaPriority() {
        return javaPriority[ordinal()];
    }
    /**
     * Get the javaPriority for a given scanPriority.
     *
     * @param threadPriority the threadPriority
     * @return the java priority
     */
    public static int getJavaPriority(ThreadPriority threadPriority) {
        return threadPriority.getJavaPriority();
    }
}
