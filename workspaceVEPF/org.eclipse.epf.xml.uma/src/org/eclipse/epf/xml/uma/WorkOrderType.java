/**
 * <copyright>
 * </copyright>
 *
 * $Id: WorkOrderType.java,v 1.3 2007/06/05 21:14:59 klow Exp $
 */
package org.eclipse.epf.xml.uma;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Work Order Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Represents a relationship between two Breakdown Element in which one Breakdown Element depends on the start or finish of another Breakdown Element in order to begin or end. This enumeration defines the different types of Work Order relationships available in UMA and is used to provide values for Work Order's linkType attribute.
 * <!-- end-model-doc -->
 * @see org.eclipse.epf.xml.uma.UmaPackage#getWorkOrderType()
 * @model
 * @generated
 */
public final class WorkOrderType extends AbstractEnumerator {
	/**
	 * The '<em><b>Finish To Start</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Finish To Start</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FINISH_TO_START_LITERAL
	 * @model name="finishToStart"
	 * @generated
	 * @ordered
	 */
	public static final int FINISH_TO_START = 0;

	/**
	 * The '<em><b>Finish To Finish</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Finish To Finish</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FINISH_TO_FINISH_LITERAL
	 * @model name="finishToFinish"
	 * @generated
	 * @ordered
	 */
	public static final int FINISH_TO_FINISH = 1;

	/**
	 * The '<em><b>Start To Start</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Start To Start</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #START_TO_START_LITERAL
	 * @model name="startToStart"
	 * @generated
	 * @ordered
	 */
	public static final int START_TO_START = 2;

	/**
	 * The '<em><b>Start To Finish</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Start To Finish</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #START_TO_FINISH_LITERAL
	 * @model name="startToFinish"
	 * @generated
	 * @ordered
	 */
	public static final int START_TO_FINISH = 3;

	/**
	 * The '<em><b>Finish To Start</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FINISH_TO_START
	 * @generated
	 * @ordered
	 */
	public static final WorkOrderType FINISH_TO_START_LITERAL = new WorkOrderType(FINISH_TO_START, "finishToStart", "finishToStart");

	/**
	 * The '<em><b>Finish To Finish</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FINISH_TO_FINISH
	 * @generated
	 * @ordered
	 */
	public static final WorkOrderType FINISH_TO_FINISH_LITERAL = new WorkOrderType(FINISH_TO_FINISH, "finishToFinish", "finishToFinish");

	/**
	 * The '<em><b>Start To Start</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_TO_START
	 * @generated
	 * @ordered
	 */
	public static final WorkOrderType START_TO_START_LITERAL = new WorkOrderType(START_TO_START, "startToStart", "startToStart");

	/**
	 * The '<em><b>Start To Finish</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_TO_FINISH
	 * @generated
	 * @ordered
	 */
	public static final WorkOrderType START_TO_FINISH_LITERAL = new WorkOrderType(START_TO_FINISH, "startToFinish", "startToFinish");

	/**
	 * An array of all the '<em><b>Work Order Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final WorkOrderType[] VALUES_ARRAY =
		new WorkOrderType[] {
			FINISH_TO_START_LITERAL,
			FINISH_TO_FINISH_LITERAL,
			START_TO_START_LITERAL,
			START_TO_FINISH_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Work Order Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Work Order Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WorkOrderType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WorkOrderType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Work Order Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WorkOrderType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WorkOrderType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Work Order Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WorkOrderType get(int value) {
		switch (value) {
			case FINISH_TO_START: return FINISH_TO_START_LITERAL;
			case FINISH_TO_FINISH: return FINISH_TO_FINISH_LITERAL;
			case START_TO_START: return START_TO_START_LITERAL;
			case START_TO_FINISH: return START_TO_FINISH_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private WorkOrderType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WorkOrderType
