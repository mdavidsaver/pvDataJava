/**
 * Copyright - See the COPYRIGHT that is included with this distribution.
 * EPICS pvData is distributed subject to a Software License Agreement found
 * in file LICENSE that is included with this distribution.
 */
package org.epics.pvdata.factory;

import org.epics.pvdata.pv.PVScalarArray;
import org.epics.pvdata.pv.ScalarArray;

/**
 * Abstract base class for any PVArray field.
 * Any code that implements a PVArray field for an IOC database should extend this class.
 * @author mrk
 *
 */
public abstract class AbstractPVScalarArray extends AbstractPVArray implements PVScalarArray{
	/**Constructor that derived classes must call.
	 * @param array The reflection interface.
	 */
	protected AbstractPVScalarArray(ScalarArray array) {
        super(array);
    }
    /* (non-Javadoc)
     * @see org.epics.pvdata.pv.PVArray#getArray()
     */
    @Override
    public ScalarArray getScalarArray() {
        return (ScalarArray)getField();
    }
    
	
}
