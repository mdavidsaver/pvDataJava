/**
 * Copyright - See the COPYRIGHT that is included with this distribution.
 * EPICS pvData is distributed subject to a Software License Agreement found
 * in file LICENSE that is included with this distribution.
 */
package org.epics.pvdata.pv;

/**
 * Get/put int data.
 * Since Java does not support unsigned the actual arguments are signed.
 * Code that calls methods of the class is responsible for integer overflow problems.
 * @author mrk
 *
 */
public interface PVUInt extends PVScalar{
    /**
     * Get the <i>int</i> value stored in the field.
     *
     * @return the int value of field
     */
    int get();

    /**
     * Put the <i>int</i> value into the field.
     * If the field is immutable a message is generated and the field not modified.
     *
     * @param value the new value
     */
    void put(int value);
}
