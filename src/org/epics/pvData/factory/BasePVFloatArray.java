/**
 * Copyright - See the COPYRIGHT that is included with this distribution.
 * EPICS JavaIOC is distributed subject to a Software License Agreement found
 * in file LICENSE that is included with this distribution.
 */
package org.epics.pvData.factory;

import org.epics.pvData.pv.Array;
import org.epics.pvData.pv.FloatArrayData;
import org.epics.pvData.pv.MessageType;
import org.epics.pvData.pv.PVFloatArray;
import org.epics.pvData.pv.PVStructure;


/**
 * Base class for implementing PVFloatArray.
 * @author mrk
 *
 */
public class BasePVFloatArray extends AbstractPVArray implements PVFloatArray
{
    protected float[] value;
    protected FloatArrayData floatArrayData = new FloatArrayData();
    
    /**
     * Constructor.
     * @param parent The parent.
     * @param array The Introspection interface.
     */    
    public BasePVFloatArray(PVStructure parent,Array array)
    {
        super(parent,array);
        value = new float[capacity];
    }
    /* (non-Javadoc)
     * @see org.epics.pvData.factory.AbstractPVField#toString(int)
     */
    public String toString(int indentLevel) {
        return convert.getString(this, indentLevel)
        + super.toString(indentLevel);
    }
    /* (non-Javadoc)
     * @see org.epics.pvData.factory.AbstractPVArray#setCapacity(int)
     */
    public void setCapacity(int len) {
        if(!capacityMutable) {
            super.message("not capacityMutable", MessageType.error);
            return;
        }
        if(length>len) length = len;
        float[]newarray = new float[len];
        if(length>0) System.arraycopy(value,0,newarray,0,length);
        value = newarray;
        capacity = len;
    }
    /* (non-Javadoc)
     * @see org.epics.pvData.pv.PVFloatArray#get(int, int, org.epics.pvData.pv.FloatArrayData)
     */
    public int get(int offset, int len, FloatArrayData data) {
        int n = len;
        if(offset+len > length) n = length - offset;
        data.data = value;
        data.offset = offset;
        return n;         
    }
    /* (non-Javadoc)
     * @see org.epics.pvData.pv.PVFloatArray#put(int, int, float[], int)
     */
    public int put(int offset, int len, float[]from, int fromOffset) {
        if(!super.isMutable()) {
            super.message("not isMutable", MessageType.error);
            return 0;
        }
        if(offset+len > length) {
            int newlength = offset + len;
            if(newlength>capacity) {
                setCapacity(newlength);
                newlength = capacity;
                len = newlength - offset;
                if(len<=0) return 0;
            }
            length = newlength;
        }
        System.arraycopy(from,fromOffset,value,offset,len);
        super.postPut();
        return len;      
    }
}