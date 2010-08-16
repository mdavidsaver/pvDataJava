/**
 * Copyright - See the COPYRIGHT that is included with this distribution.
 * EPICS JavaIOC is distributed subject to a Software License Agreement found
 * in file LICENSE that is included with this distribution.
 */
package org.epics.pvData.pv;

/**
 * get/put a boolean array.
 * The caller must be prepared to get/put the array in chunks.
 * The return argument is always the number of elements that were transfered.
 * It may be less than the number requested.
 * @author mrk
 *
 */
public interface PVBooleanArray extends PVScalarArray{
    /**
     * Get values from a <i>PVBooleanArray</i>
     * and put them into <i>boolean[]to</i>.
     * @param offset The offset to the first element to get.
     * @param length The maximum number of elements to transfer.
     * @param data The class containing the data and an offset into the data.
     * Get sets these values. The caller must do the actual data transfer.
     * @return The number of elements that can be transfered.
     * This is always less than or equal to length.
     * If the value is less then length then get should be called again.
     * If the return value is greater than 0 then data.data is
     * a reference to the array and data.offset is the offset into the
     * array.
     */
    int get(int offset, int length, BooleanArrayData data);
    /**
     * Put values into a <i>PVBooleanArray</i> from <i>boolean[]from</i>.
     * If the field is immutable a message is generated, the field is not modified and 0 is returned.
     * @param offset The offset to the first element to put.
     * @param length The maximum number of elements to transfer.
     * @param from The array from which to get the data.
     * @param fromOffset The offset into from.
     * @return The number of elements transfered.
     * This is always less than or equal to length.
     * If the value is less then put should be called again.
     */
    int put(int offset,int length, boolean[] from, int fromOffset);
    /**
     * Share the data from caller.
     * The capacity and length are taken from the array and this array is made immutable.
     * This should only be used to share immutable data.
     * @param from The data to share.
     */
    void shareData(boolean[] from);
    
}
