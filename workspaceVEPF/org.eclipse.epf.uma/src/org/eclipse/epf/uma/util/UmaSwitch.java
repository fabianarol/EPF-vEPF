//------------------------------------------------------------------------------
// Copyright (c) 2005, 2006 IBM Corporation and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
// IBM Corporation - initial implementation
//------------------------------------------------------------------------------
package org.eclipse.epf.uma.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epf.uma.Activity;
import org.eclipse.epf.uma.ActivityDescription;
import org.eclipse.epf.uma.Artifact;
import org.eclipse.epf.uma.ArtifactDescription;
import org.eclipse.epf.uma.BreakdownElement;
import org.eclipse.epf.uma.BreakdownElementDescription;
import org.eclipse.epf.uma.CapabilityPattern;
import org.eclipse.epf.uma.Checklist;
import org.eclipse.epf.uma.Classifier;
import org.eclipse.epf.uma.CompositeRole;
import org.eclipse.epf.uma.Concept;
import org.eclipse.epf.uma.Constraint;
import org.eclipse.epf.uma.ContentCategory;
import org.eclipse.epf.uma.ContentDescription;
import org.eclipse.epf.uma.ContentElement;
import org.eclipse.epf.uma.ContentPackage;
import org.eclipse.epf.uma.CoreProcessPackage;
import org.eclipse.epf.uma.CoreProcess;
import org.eclipse.epf.uma.CoreSemanticModelBridge;
import org.eclipse.epf.uma.CustomCategory;
import org.eclipse.epf.uma.Deliverable;
import org.eclipse.epf.uma.DeliverableDescription;
import org.eclipse.epf.uma.DeliveryProcess;
import org.eclipse.epf.uma.DeliveryProcessDescription;
import org.eclipse.epf.uma.Dependences;
import org.eclipse.epf.uma.DescribableElement;
import org.eclipse.epf.uma.Descriptor;
import org.eclipse.epf.uma.DescriptorDescription;
import org.eclipse.epf.uma.Diagram;
import org.eclipse.epf.uma.DiagramElement;
import org.eclipse.epf.uma.DiagramLink;
import org.eclipse.epf.uma.Dimension;
import org.eclipse.epf.uma.Discipline;
import org.eclipse.epf.uma.DisciplineGrouping;
import org.eclipse.epf.uma.Domain;
import org.eclipse.epf.uma.Element;
import org.eclipse.epf.uma.Ellipse;
import org.eclipse.epf.uma.EstimationConsiderations;
import org.eclipse.epf.uma.Example;
import org.eclipse.epf.uma.GraphConnector;
import org.eclipse.epf.uma.GraphEdge;
import org.eclipse.epf.uma.GraphElement;
import org.eclipse.epf.uma.GraphNode;
import org.eclipse.epf.uma.GraphicPrimitive;
import org.eclipse.epf.uma.Guidance;
import org.eclipse.epf.uma.GuidanceDescription;
import org.eclipse.epf.uma.Guideline;
import org.eclipse.epf.uma.Image;
import org.eclipse.epf.uma.Iteration;
import org.eclipse.epf.uma.LeafElement;
import org.eclipse.epf.uma.LineProcess;
import org.eclipse.epf.uma.Mandatory;
import org.eclipse.epf.uma.MethodConfiguration;
import org.eclipse.epf.uma.MethodElement;
import org.eclipse.epf.uma.MethodElementProperty;
import org.eclipse.epf.uma.MethodLibrary;
import org.eclipse.epf.uma.MethodPackage;
import org.eclipse.epf.uma.MethodPlugin;
import org.eclipse.epf.uma.MethodUnit;
import org.eclipse.epf.uma.Milestone;
import org.eclipse.epf.uma.NamedElement;
import org.eclipse.epf.uma.Namespace;
import org.eclipse.epf.uma.Occupation;
import org.eclipse.epf.uma.Optative;
import org.eclipse.epf.uma.Optional;
import org.eclipse.epf.uma.Outcome;
import org.eclipse.epf.uma.PackageableElement;
import org.eclipse.epf.uma.Phase;
import org.eclipse.epf.uma.PlanningData;
import org.eclipse.epf.uma.Point;
import org.eclipse.epf.uma.Polyline;
import org.eclipse.epf.uma.Practice;
import org.eclipse.epf.uma.PracticeDescription;
import org.eclipse.epf.uma.ProcAdvice;
import org.eclipse.epf.uma.ProcAspect;
import org.eclipse.epf.uma.ProcPointcut;
import org.eclipse.epf.uma.ProcessComponent;
import org.eclipse.epf.uma.ProcessComponentDescriptor;
import org.eclipse.epf.uma.ProcessComponentInterface;
import org.eclipse.epf.uma.ProcessDescription;
import org.eclipse.epf.uma.ProcessElement;
import org.eclipse.epf.uma.ProcessFamily;
import org.eclipse.epf.uma.ProcessLine;
import org.eclipse.epf.uma.ProcessLineComponent;
import org.eclipse.epf.uma.ProcessLineComponentInterface;
import org.eclipse.epf.uma.ProcessLineComponentPackage;
import org.eclipse.epf.uma.ProcessLineInstance;
import org.eclipse.epf.uma.ProcessLineElement;
import org.eclipse.epf.uma.ProcessLinesPackage;
import org.eclipse.epf.uma.ProcessPackage;
import org.eclipse.epf.uma.ProcessPlanningTemplate;
import org.eclipse.epf.uma.Property;
import org.eclipse.epf.uma.PruebasLineas;
import org.eclipse.epf.uma.PseudoState;
import org.eclipse.epf.uma.Reference;
import org.eclipse.epf.uma.Region;
import org.eclipse.epf.uma.Report;
import org.eclipse.epf.uma.ReusableAsset;
import org.eclipse.epf.uma.Roadmap;
import org.eclipse.epf.uma.Role;
import org.eclipse.epf.uma.RoleDescription;
import org.eclipse.epf.uma.RoleDescriptor;
import org.eclipse.epf.uma.RoleSet;
import org.eclipse.epf.uma.RoleSetGrouping;
import org.eclipse.epf.uma.Section;
import org.eclipse.epf.uma.SemanticModelBridge;
import org.eclipse.epf.uma.SimpleSemanticModelElement;
import org.eclipse.epf.uma.State;
import org.eclipse.epf.uma.StateMachine;
import org.eclipse.epf.uma.Step;
import org.eclipse.epf.uma.SupportingMaterial;
import org.eclipse.epf.uma.TailoredCoreProcessPackage;
import org.eclipse.epf.uma.TailoredProcess;
import org.eclipse.epf.uma.TailoredProcessComponent;
import org.eclipse.epf.uma.TailoredProcessesPackage;
import org.eclipse.epf.uma.Task;
import org.eclipse.epf.uma.TaskDescription;
import org.eclipse.epf.uma.TaskDescriptor;
import org.eclipse.epf.uma.TeamProfile;
import org.eclipse.epf.uma.Template;
import org.eclipse.epf.uma.TermDefinition;
import org.eclipse.epf.uma.TextElement;
import org.eclipse.epf.uma.Tool;
import org.eclipse.epf.uma.ToolMentor;
import org.eclipse.epf.uma.Transition;
import org.eclipse.epf.uma.Type;
import org.eclipse.epf.uma.UMASemanticModelBridge;
import org.eclipse.epf.uma.UmaPackage;
import org.eclipse.epf.uma.VarActivity;
import org.eclipse.epf.uma.VarElement;
import org.eclipse.epf.uma.VarIteration;
import org.eclipse.epf.uma.VarMilestone;
import org.eclipse.epf.uma.VarPhase;
import org.eclipse.epf.uma.VarPoint;
import org.eclipse.epf.uma.VarPointsPackage;
import org.eclipse.epf.uma.VarRoleDescriptor;
import org.eclipse.epf.uma.VarTaskDescriptor;
import org.eclipse.epf.uma.VarTeamProfile;
import org.eclipse.epf.uma.VarWorkProductDescriptor;
import org.eclipse.epf.uma.Variability;
import org.eclipse.epf.uma.VariabilityElement;
import org.eclipse.epf.uma.Variant;
import org.eclipse.epf.uma.VariantsListPackage;
import org.eclipse.epf.uma.VariantsPackage;
import org.eclipse.epf.uma.Variation;
import org.eclipse.epf.uma.VariationType;
import org.eclipse.epf.uma.VariationsPackage;
import org.eclipse.epf.uma.Vertex;
import org.eclipse.epf.uma.Whitepaper;
import org.eclipse.epf.uma.WorkBreakdownElement;
import org.eclipse.epf.uma.WorkDefinition;
import org.eclipse.epf.uma.WorkOrder;
import org.eclipse.epf.uma.WorkProduct;
import org.eclipse.epf.uma.WorkProductDescription;
import org.eclipse.epf.uma.WorkProductDescriptor;
import org.eclipse.epf.uma.WorkProductType;

import org.eclipse.epf.uma.vActivity;
import org.eclipse.epf.uma.vIteration;
import org.eclipse.epf.uma.vPhase;
import org.eclipse.epf.uma.varP2varP;
import org.eclipse.epf.uma.variant2varP;
import org.eclipse.epf.uma.variant2variant;
import org.eclipse.epf.uma.varp2variant;
import org.eclipse.epf.uma.vpActivity;
import org.eclipse.epf.uma.vpIteration;
import org.eclipse.epf.uma.vpMilestone;
import org.eclipse.epf.uma.vpPhase;
import org.eclipse.epf.uma.vpRoleDescriptor;
import org.eclipse.epf.uma.vpTaskDescriptor;
import org.eclipse.epf.uma.vpTeamProfile;
import org.eclipse.epf.uma.vpWorkProductDescriptor;
import org.eclipse.epf.uma.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.epf.uma.UmaPackage
 * @generated
 */
public class UmaSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UmaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmaSwitch() {
		if (modelPackage == null) {
			modelPackage = UmaPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(
					(EClass) eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case UmaPackage.CLASSIFIER: {
			Classifier classifier = (Classifier) theEObject;
			Object result = caseClassifier(classifier);
			if (result == null)
				result = caseType(classifier);
			if (result == null)
				result = casePackageableElement(classifier);
			if (result == null)
				result = caseNamedElement(classifier);
			if (result == null)
				result = caseElement(classifier);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TYPE: {
			Type type = (Type) theEObject;
			Object result = caseType(type);
			if (result == null)
				result = casePackageableElement(type);
			if (result == null)
				result = caseNamedElement(type);
			if (result == null)
				result = caseElement(type);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.ELEMENT: {
			Element element = (Element) theEObject;
			Object result = caseElement(element);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.NAMED_ELEMENT: {
			NamedElement namedElement = (NamedElement) theEObject;
			Object result = caseNamedElement(namedElement);
			if (result == null)
				result = caseElement(namedElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PACKAGEABLE_ELEMENT: {
			PackageableElement packageableElement = (PackageableElement) theEObject;
			Object result = casePackageableElement(packageableElement);
			if (result == null)
				result = caseNamedElement(packageableElement);
			if (result == null)
				result = caseElement(packageableElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PACKAGE: {
			org.eclipse.epf.uma.Package package_ = (org.eclipse.epf.uma.Package) theEObject;
			Object result = casePackage(package_);
			if (result == null)
				result = caseNamespace(package_);
			if (result == null)
				result = casePackageableElement(package_);
			if (result == null)
				result = caseNamedElement(package_);
			if (result == null)
				result = caseElement(package_);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.NAMESPACE: {
			Namespace namespace = (Namespace) theEObject;
			Object result = caseNamespace(namespace);
			if (result == null)
				result = caseNamedElement(namespace);
			if (result == null)
				result = caseElement(namespace);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.METHOD_ELEMENT: {
			MethodElement methodElement = (MethodElement) theEObject;
			Object result = caseMethodElement(methodElement);
			if (result == null)
				result = casePackageableElement(methodElement);
			if (result == null)
				result = caseNamedElement(methodElement);
			if (result == null)
				result = caseElement(methodElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.CONSTRAINT: {
			Constraint constraint = (Constraint) theEObject;
			Object result = caseConstraint(constraint);
			if (result == null)
				result = caseMethodElement(constraint);
			if (result == null)
				result = casePackageableElement(constraint);
			if (result == null)
				result = caseNamedElement(constraint);
			if (result == null)
				result = caseElement(constraint);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.METHOD_ELEMENT_PROPERTY: {
			MethodElementProperty methodElementProperty = (MethodElementProperty) theEObject;
			Object result = caseMethodElementProperty(methodElementProperty);
			if (result == null)
				result = casePackageableElement(methodElementProperty);
			if (result == null)
				result = caseNamedElement(methodElementProperty);
			if (result == null)
				result = caseElement(methodElementProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.CONTENT_ELEMENT: {
			ContentElement contentElement = (ContentElement) theEObject;
			Object result = caseContentElement(contentElement);
			if (result == null)
				result = caseDescribableElement(contentElement);
			if (result == null)
				result = caseVariabilityElement(contentElement);
			if (result == null)
				result = caseMethodElement(contentElement);
			if (result == null)
				result = caseClassifier(contentElement);
			if (result == null)
				result = caseVariability(contentElement);
			if (result == null)
				result = casePackageableElement(contentElement);
			if (result == null)
				result = caseType(contentElement);
			if (result == null)
				result = caseNamedElement(contentElement);
			if (result == null)
				result = caseElement(contentElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DESCRIBABLE_ELEMENT: {
			DescribableElement describableElement = (DescribableElement) theEObject;
			Object result = caseDescribableElement(describableElement);
			if (result == null)
				result = caseMethodElement(describableElement);
			if (result == null)
				result = caseClassifier(describableElement);
			if (result == null)
				result = casePackageableElement(describableElement);
			if (result == null)
				result = caseType(describableElement);
			if (result == null)
				result = caseNamedElement(describableElement);
			if (result == null)
				result = caseElement(describableElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.CONTENT_DESCRIPTION: {
			ContentDescription contentDescription = (ContentDescription) theEObject;
			Object result = caseContentDescription(contentDescription);
			if (result == null)
				result = caseMethodUnit(contentDescription);
			if (result == null)
				result = caseMethodElement(contentDescription);
			if (result == null)
				result = casePackageableElement(contentDescription);
			if (result == null)
				result = caseNamedElement(contentDescription);
			if (result == null)
				result = caseElement(contentDescription);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.SECTION: {
			Section section = (Section) theEObject;
			Object result = caseSection(section);
			if (result == null)
				result = caseVariabilityElement(section);
			if (result == null)
				result = caseMethodElement(section);
			if (result == null)
				result = caseVariability(section);
			if (result == null)
				result = casePackageableElement(section);
			if (result == null)
				result = caseNamedElement(section);
			if (result == null)
				result = caseElement(section);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.ROLE: {
			Role role = (Role) theEObject;
			Object result = caseRole(role);
			if (result == null)
				result = caseContentElement(role);
			if (result == null)
				result = caseDescribableElement(role);
			if (result == null)
				result = caseVariabilityElement(role);
			if (result == null)
				result = caseMethodElement(role);
			if (result == null)
				result = caseClassifier(role);
			if (result == null)
				result = caseVariability(role);
			if (result == null)
				result = casePackageableElement(role);
			if (result == null)
				result = caseType(role);
			if (result == null)
				result = caseNamedElement(role);
			if (result == null)
				result = caseElement(role);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.WORK_PRODUCT: {
			WorkProduct workProduct = (WorkProduct) theEObject;
			Object result = caseWorkProduct(workProduct);
			if (result == null)
				result = caseContentElement(workProduct);
			if (result == null)
				result = caseDescribableElement(workProduct);
			if (result == null)
				result = caseVariabilityElement(workProduct);
			if (result == null)
				result = caseMethodElement(workProduct);
			if (result == null)
				result = caseClassifier(workProduct);
			if (result == null)
				result = caseVariability(workProduct);
			if (result == null)
				result = casePackageableElement(workProduct);
			if (result == null)
				result = caseType(workProduct);
			if (result == null)
				result = caseNamedElement(workProduct);
			if (result == null)
				result = caseElement(workProduct);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TASK: {
			Task task = (Task) theEObject;
			Object result = caseTask(task);
			if (result == null)
				result = caseContentElement(task);
			if (result == null)
				result = caseWorkDefinition(task);
			if (result == null)
				result = caseDescribableElement(task);
			if (result == null)
				result = caseVariabilityElement(task);
			if (result == null)
				result = caseMethodElement(task);
			if (result == null)
				result = caseClassifier(task);
			if (result == null)
				result = caseVariability(task);
			if (result == null)
				result = casePackageableElement(task);
			if (result == null)
				result = caseType(task);
			if (result == null)
				result = caseNamedElement(task);
			if (result == null)
				result = caseElement(task);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.WORK_DEFINITION: {
			WorkDefinition workDefinition = (WorkDefinition) theEObject;
			Object result = caseWorkDefinition(workDefinition);
			if (result == null)
				result = caseMethodElement(workDefinition);
			if (result == null)
				result = casePackageableElement(workDefinition);
			if (result == null)
				result = caseNamedElement(workDefinition);
			if (result == null)
				result = caseElement(workDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.STEP: {
			Step step = (Step) theEObject;
			Object result = caseStep(step);
			if (result == null)
				result = caseSection(step);
			if (result == null)
				result = caseWorkDefinition(step);
			if (result == null)
				result = caseVariabilityElement(step);
			if (result == null)
				result = caseMethodElement(step);
			if (result == null)
				result = caseVariability(step);
			if (result == null)
				result = casePackageableElement(step);
			if (result == null)
				result = caseNamedElement(step);
			if (result == null)
				result = caseElement(step);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.GUIDANCE: {
			Guidance guidance = (Guidance) theEObject;
			Object result = caseGuidance(guidance);
			if (result == null)
				result = caseContentElement(guidance);
			if (result == null)
				result = caseDescribableElement(guidance);
			if (result == null)
				result = caseVariabilityElement(guidance);
			if (result == null)
				result = caseMethodElement(guidance);
			if (result == null)
				result = caseClassifier(guidance);
			if (result == null)
				result = caseVariability(guidance);
			if (result == null)
				result = casePackageableElement(guidance);
			if (result == null)
				result = caseType(guidance);
			if (result == null)
				result = caseNamedElement(guidance);
			if (result == null)
				result = caseElement(guidance);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.ARTIFACT: {
			Artifact artifact = (Artifact) theEObject;
			Object result = caseArtifact(artifact);
			if (result == null)
				result = caseWorkProduct(artifact);
			if (result == null)
				result = caseContentElement(artifact);
			if (result == null)
				result = caseDescribableElement(artifact);
			if (result == null)
				result = caseVariabilityElement(artifact);
			if (result == null)
				result = caseMethodElement(artifact);
			if (result == null)
				result = caseClassifier(artifact);
			if (result == null)
				result = caseVariability(artifact);
			if (result == null)
				result = casePackageableElement(artifact);
			if (result == null)
				result = caseType(artifact);
			if (result == null)
				result = caseNamedElement(artifact);
			if (result == null)
				result = caseElement(artifact);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DELIVERABLE: {
			Deliverable deliverable = (Deliverable) theEObject;
			Object result = caseDeliverable(deliverable);
			if (result == null)
				result = caseWorkProduct(deliverable);
			if (result == null)
				result = caseContentElement(deliverable);
			if (result == null)
				result = caseDescribableElement(deliverable);
			if (result == null)
				result = caseVariabilityElement(deliverable);
			if (result == null)
				result = caseMethodElement(deliverable);
			if (result == null)
				result = caseClassifier(deliverable);
			if (result == null)
				result = caseVariability(deliverable);
			if (result == null)
				result = casePackageableElement(deliverable);
			if (result == null)
				result = caseType(deliverable);
			if (result == null)
				result = caseNamedElement(deliverable);
			if (result == null)
				result = caseElement(deliverable);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.OUTCOME: {
			Outcome outcome = (Outcome) theEObject;
			Object result = caseOutcome(outcome);
			if (result == null)
				result = caseWorkProduct(outcome);
			if (result == null)
				result = caseContentElement(outcome);
			if (result == null)
				result = caseDescribableElement(outcome);
			if (result == null)
				result = caseVariabilityElement(outcome);
			if (result == null)
				result = caseMethodElement(outcome);
			if (result == null)
				result = caseClassifier(outcome);
			if (result == null)
				result = caseVariability(outcome);
			if (result == null)
				result = casePackageableElement(outcome);
			if (result == null)
				result = caseType(outcome);
			if (result == null)
				result = caseNamedElement(outcome);
			if (result == null)
				result = caseElement(outcome);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.METHOD_PACKAGE: {
			MethodPackage methodPackage = (MethodPackage) theEObject;
			Object result = caseMethodPackage(methodPackage);
			if (result == null)
				result = caseMethodElement(methodPackage);
			if (result == null)
				result = casePackage(methodPackage);
			if (result == null)
				result = casePackageableElement(methodPackage);
			if (result == null)
				result = caseNamespace(methodPackage);
			if (result == null)
				result = caseNamedElement(methodPackage);
			if (result == null)
				result = caseElement(methodPackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.CONTENT_PACKAGE: {
			ContentPackage contentPackage = (ContentPackage) theEObject;
			Object result = caseContentPackage(contentPackage);
			if (result == null)
				result = caseMethodPackage(contentPackage);
			if (result == null)
				result = caseMethodElement(contentPackage);
			if (result == null)
				result = casePackage(contentPackage);
			if (result == null)
				result = casePackageableElement(contentPackage);
			if (result == null)
				result = caseNamespace(contentPackage);
			if (result == null)
				result = caseNamedElement(contentPackage);
			if (result == null)
				result = caseElement(contentPackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.ARTIFACT_DESCRIPTION: {
			ArtifactDescription artifactDescription = (ArtifactDescription) theEObject;
			Object result = caseArtifactDescription(artifactDescription);
			if (result == null)
				result = caseWorkProductDescription(artifactDescription);
			if (result == null)
				result = caseContentDescription(artifactDescription);
			if (result == null)
				result = caseMethodUnit(artifactDescription);
			if (result == null)
				result = caseMethodElement(artifactDescription);
			if (result == null)
				result = casePackageableElement(artifactDescription);
			if (result == null)
				result = caseNamedElement(artifactDescription);
			if (result == null)
				result = caseElement(artifactDescription);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.WORK_PRODUCT_DESCRIPTION: {
			WorkProductDescription workProductDescription = (WorkProductDescription) theEObject;
			Object result = caseWorkProductDescription(workProductDescription);
			if (result == null)
				result = caseContentDescription(workProductDescription);
			if (result == null)
				result = caseMethodUnit(workProductDescription);
			if (result == null)
				result = caseMethodElement(workProductDescription);
			if (result == null)
				result = casePackageableElement(workProductDescription);
			if (result == null)
				result = caseNamedElement(workProductDescription);
			if (result == null)
				result = caseElement(workProductDescription);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DELIVERABLE_DESCRIPTION: {
			DeliverableDescription deliverableDescription = (DeliverableDescription) theEObject;
			Object result = caseDeliverableDescription(deliverableDescription);
			if (result == null)
				result = caseWorkProductDescription(deliverableDescription);
			if (result == null)
				result = caseContentDescription(deliverableDescription);
			if (result == null)
				result = caseMethodUnit(deliverableDescription);
			if (result == null)
				result = caseMethodElement(deliverableDescription);
			if (result == null)
				result = casePackageableElement(deliverableDescription);
			if (result == null)
				result = caseNamedElement(deliverableDescription);
			if (result == null)
				result = caseElement(deliverableDescription);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.ROLE_DESCRIPTION: {
			RoleDescription roleDescription = (RoleDescription) theEObject;
			Object result = caseRoleDescription(roleDescription);
			if (result == null)
				result = caseContentDescription(roleDescription);
			if (result == null)
				result = caseMethodUnit(roleDescription);
			if (result == null)
				result = caseMethodElement(roleDescription);
			if (result == null)
				result = casePackageableElement(roleDescription);
			if (result == null)
				result = caseNamedElement(roleDescription);
			if (result == null)
				result = caseElement(roleDescription);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TASK_DESCRIPTION: {
			TaskDescription taskDescription = (TaskDescription) theEObject;
			Object result = caseTaskDescription(taskDescription);
			if (result == null)
				result = caseContentDescription(taskDescription);
			if (result == null)
				result = caseMethodUnit(taskDescription);
			if (result == null)
				result = caseMethodElement(taskDescription);
			if (result == null)
				result = casePackageableElement(taskDescription);
			if (result == null)
				result = caseNamedElement(taskDescription);
			if (result == null)
				result = caseElement(taskDescription);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.GUIDANCE_DESCRIPTION: {
			GuidanceDescription guidanceDescription = (GuidanceDescription) theEObject;
			Object result = caseGuidanceDescription(guidanceDescription);
			if (result == null)
				result = caseContentDescription(guidanceDescription);
			if (result == null)
				result = caseMethodUnit(guidanceDescription);
			if (result == null)
				result = caseMethodElement(guidanceDescription);
			if (result == null)
				result = casePackageableElement(guidanceDescription);
			if (result == null)
				result = caseNamedElement(guidanceDescription);
			if (result == null)
				result = caseElement(guidanceDescription);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PRACTICE_DESCRIPTION: {
			PracticeDescription practiceDescription = (PracticeDescription) theEObject;
			Object result = casePracticeDescription(practiceDescription);
			if (result == null)
				result = caseContentDescription(practiceDescription);
			if (result == null)
				result = caseMethodUnit(practiceDescription);
			if (result == null)
				result = caseMethodElement(practiceDescription);
			if (result == null)
				result = casePackageableElement(practiceDescription);
			if (result == null)
				result = caseNamedElement(practiceDescription);
			if (result == null)
				result = caseElement(practiceDescription);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.POINT: {
			Point point = (Point) theEObject;
			Object result = casePoint(point);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.GRAPH_ELEMENT: {
			GraphElement graphElement = (GraphElement) theEObject;
			Object result = caseGraphElement(graphElement);
			if (result == null)
				result = caseDiagramElement(graphElement);
			if (result == null)
				result = caseMethodElement(graphElement);
			if (result == null)
				result = casePackageableElement(graphElement);
			if (result == null)
				result = caseNamedElement(graphElement);
			if (result == null)
				result = caseElement(graphElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DIAGRAM_ELEMENT: {
			DiagramElement diagramElement = (DiagramElement) theEObject;
			Object result = caseDiagramElement(diagramElement);
			if (result == null)
				result = caseMethodElement(diagramElement);
			if (result == null)
				result = casePackageableElement(diagramElement);
			if (result == null)
				result = caseNamedElement(diagramElement);
			if (result == null)
				result = caseElement(diagramElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DIAGRAM_LINK: {
			DiagramLink diagramLink = (DiagramLink) theEObject;
			Object result = caseDiagramLink(diagramLink);
			if (result == null)
				result = caseDiagramElement(diagramLink);
			if (result == null)
				result = caseMethodElement(diagramLink);
			if (result == null)
				result = casePackageableElement(diagramLink);
			if (result == null)
				result = caseNamedElement(diagramLink);
			if (result == null)
				result = caseElement(diagramLink);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.GRAPH_CONNECTOR: {
			GraphConnector graphConnector = (GraphConnector) theEObject;
			Object result = caseGraphConnector(graphConnector);
			if (result == null)
				result = caseGraphElement(graphConnector);
			if (result == null)
				result = caseDiagramElement(graphConnector);
			if (result == null)
				result = caseMethodElement(graphConnector);
			if (result == null)
				result = casePackageableElement(graphConnector);
			if (result == null)
				result = caseNamedElement(graphConnector);
			if (result == null)
				result = caseElement(graphConnector);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.SEMANTIC_MODEL_BRIDGE: {
			SemanticModelBridge semanticModelBridge = (SemanticModelBridge) theEObject;
			Object result = caseSemanticModelBridge(semanticModelBridge);
			if (result == null)
				result = caseDiagramElement(semanticModelBridge);
			if (result == null)
				result = caseMethodElement(semanticModelBridge);
			if (result == null)
				result = casePackageableElement(semanticModelBridge);
			if (result == null)
				result = caseNamedElement(semanticModelBridge);
			if (result == null)
				result = caseElement(semanticModelBridge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DIMENSION: {
			Dimension dimension = (Dimension) theEObject;
			Object result = caseDimension(dimension);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.REFERENCE: {
			Reference reference = (Reference) theEObject;
			Object result = caseReference(reference);
			if (result == null)
				result = caseDiagramElement(reference);
			if (result == null)
				result = caseMethodElement(reference);
			if (result == null)
				result = casePackageableElement(reference);
			if (result == null)
				result = caseNamedElement(reference);
			if (result == null)
				result = caseElement(reference);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROPERTY: {
			Property property = (Property) theEObject;
			Object result = caseProperty(property);
			if (result == null)
				result = caseDiagramElement(property);
			if (result == null)
				result = caseMethodElement(property);
			if (result == null)
				result = casePackageableElement(property);
			if (result == null)
				result = caseNamedElement(property);
			if (result == null)
				result = caseElement(property);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.GRAPH_EDGE: {
			GraphEdge graphEdge = (GraphEdge) theEObject;
			Object result = caseGraphEdge(graphEdge);
			if (result == null)
				result = caseGraphElement(graphEdge);
			if (result == null)
				result = caseDiagramElement(graphEdge);
			if (result == null)
				result = caseMethodElement(graphEdge);
			if (result == null)
				result = casePackageableElement(graphEdge);
			if (result == null)
				result = caseNamedElement(graphEdge);
			if (result == null)
				result = caseElement(graphEdge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DIAGRAM: {
			Diagram diagram = (Diagram) theEObject;
			Object result = caseDiagram(diagram);
			if (result == null)
				result = caseGraphNode(diagram);
			if (result == null)
				result = caseGraphElement(diagram);
			if (result == null)
				result = caseDiagramElement(diagram);
			if (result == null)
				result = caseMethodElement(diagram);
			if (result == null)
				result = casePackageableElement(diagram);
			if (result == null)
				result = caseNamedElement(diagram);
			if (result == null)
				result = caseElement(diagram);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.GRAPH_NODE: {
			GraphNode graphNode = (GraphNode) theEObject;
			Object result = caseGraphNode(graphNode);
			if (result == null)
				result = caseGraphElement(graphNode);
			if (result == null)
				result = caseDiagramElement(graphNode);
			if (result == null)
				result = caseMethodElement(graphNode);
			if (result == null)
				result = casePackageableElement(graphNode);
			if (result == null)
				result = caseNamedElement(graphNode);
			if (result == null)
				result = caseElement(graphNode);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.SIMPLE_SEMANTIC_MODEL_ELEMENT: {
			SimpleSemanticModelElement simpleSemanticModelElement = (SimpleSemanticModelElement) theEObject;
			Object result = caseSimpleSemanticModelElement(simpleSemanticModelElement);
			if (result == null)
				result = caseSemanticModelBridge(simpleSemanticModelElement);
			if (result == null)
				result = caseDiagramElement(simpleSemanticModelElement);
			if (result == null)
				result = caseMethodElement(simpleSemanticModelElement);
			if (result == null)
				result = casePackageableElement(simpleSemanticModelElement);
			if (result == null)
				result = caseNamedElement(simpleSemanticModelElement);
			if (result == null)
				result = caseElement(simpleSemanticModelElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.UMA_SEMANTIC_MODEL_BRIDGE: {
			UMASemanticModelBridge umaSemanticModelBridge = (UMASemanticModelBridge) theEObject;
			Object result = caseUMASemanticModelBridge(umaSemanticModelBridge);
			if (result == null)
				result = caseSemanticModelBridge(umaSemanticModelBridge);
			if (result == null)
				result = caseDiagramElement(umaSemanticModelBridge);
			if (result == null)
				result = caseMethodElement(umaSemanticModelBridge);
			if (result == null)
				result = casePackageableElement(umaSemanticModelBridge);
			if (result == null)
				result = caseNamedElement(umaSemanticModelBridge);
			if (result == null)
				result = caseElement(umaSemanticModelBridge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.CORE_SEMANTIC_MODEL_BRIDGE: {
			CoreSemanticModelBridge coreSemanticModelBridge = (CoreSemanticModelBridge) theEObject;
			Object result = caseCoreSemanticModelBridge(coreSemanticModelBridge);
			if (result == null)
				result = caseSemanticModelBridge(coreSemanticModelBridge);
			if (result == null)
				result = caseDiagramElement(coreSemanticModelBridge);
			if (result == null)
				result = caseMethodElement(coreSemanticModelBridge);
			if (result == null)
				result = casePackageableElement(coreSemanticModelBridge);
			if (result == null)
				result = caseNamedElement(coreSemanticModelBridge);
			if (result == null)
				result = caseElement(coreSemanticModelBridge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.LEAF_ELEMENT: {
			LeafElement leafElement = (LeafElement) theEObject;
			Object result = caseLeafElement(leafElement);
			if (result == null)
				result = caseDiagramElement(leafElement);
			if (result == null)
				result = caseMethodElement(leafElement);
			if (result == null)
				result = casePackageableElement(leafElement);
			if (result == null)
				result = caseNamedElement(leafElement);
			if (result == null)
				result = caseElement(leafElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TEXT_ELEMENT: {
			TextElement textElement = (TextElement) theEObject;
			Object result = caseTextElement(textElement);
			if (result == null)
				result = caseLeafElement(textElement);
			if (result == null)
				result = caseDiagramElement(textElement);
			if (result == null)
				result = caseMethodElement(textElement);
			if (result == null)
				result = casePackageableElement(textElement);
			if (result == null)
				result = caseNamedElement(textElement);
			if (result == null)
				result = caseElement(textElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.IMAGE: {
			Image image = (Image) theEObject;
			Object result = caseImage(image);
			if (result == null)
				result = caseLeafElement(image);
			if (result == null)
				result = caseDiagramElement(image);
			if (result == null)
				result = caseMethodElement(image);
			if (result == null)
				result = casePackageableElement(image);
			if (result == null)
				result = caseNamedElement(image);
			if (result == null)
				result = caseElement(image);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.GRAPHIC_PRIMITIVE: {
			GraphicPrimitive graphicPrimitive = (GraphicPrimitive) theEObject;
			Object result = caseGraphicPrimitive(graphicPrimitive);
			if (result == null)
				result = caseLeafElement(graphicPrimitive);
			if (result == null)
				result = caseDiagramElement(graphicPrimitive);
			if (result == null)
				result = caseMethodElement(graphicPrimitive);
			if (result == null)
				result = casePackageableElement(graphicPrimitive);
			if (result == null)
				result = caseNamedElement(graphicPrimitive);
			if (result == null)
				result = caseElement(graphicPrimitive);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.POLYLINE: {
			Polyline polyline = (Polyline) theEObject;
			Object result = casePolyline(polyline);
			if (result == null)
				result = caseGraphicPrimitive(polyline);
			if (result == null)
				result = caseLeafElement(polyline);
			if (result == null)
				result = caseDiagramElement(polyline);
			if (result == null)
				result = caseMethodElement(polyline);
			if (result == null)
				result = casePackageableElement(polyline);
			if (result == null)
				result = caseNamedElement(polyline);
			if (result == null)
				result = caseElement(polyline);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.ELLIPSE: {
			Ellipse ellipse = (Ellipse) theEObject;
			Object result = caseEllipse(ellipse);
			if (result == null)
				result = caseGraphicPrimitive(ellipse);
			if (result == null)
				result = caseLeafElement(ellipse);
			if (result == null)
				result = caseDiagramElement(ellipse);
			if (result == null)
				result = caseMethodElement(ellipse);
			if (result == null)
				result = casePackageableElement(ellipse);
			if (result == null)
				result = caseNamedElement(ellipse);
			if (result == null)
				result = caseElement(ellipse);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.WORK_BREAKDOWN_ELEMENT: {
			WorkBreakdownElement workBreakdownElement = (WorkBreakdownElement) theEObject;
			Object result = caseWorkBreakdownElement(workBreakdownElement);
			if (result == null)
				result = caseBreakdownElement(workBreakdownElement);
			if (result == null)
				result = caseProcessElement(workBreakdownElement);
			if (result == null)
				result = caseDescribableElement(workBreakdownElement);
			if (result == null)
				result = caseMethodElement(workBreakdownElement);
			if (result == null)
				result = caseClassifier(workBreakdownElement);
			if (result == null)
				result = casePackageableElement(workBreakdownElement);
			if (result == null)
				result = caseType(workBreakdownElement);
			if (result == null)
				result = caseNamedElement(workBreakdownElement);
			if (result == null)
				result = caseElement(workBreakdownElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.BREAKDOWN_ELEMENT: {
			BreakdownElement breakdownElement = (BreakdownElement) theEObject;
			Object result = caseBreakdownElement(breakdownElement);
			if (result == null)
				result = caseProcessElement(breakdownElement);
			if (result == null)
				result = caseDescribableElement(breakdownElement);
			if (result == null)
				result = caseMethodElement(breakdownElement);
			if (result == null)
				result = caseClassifier(breakdownElement);
			if (result == null)
				result = casePackageableElement(breakdownElement);
			if (result == null)
				result = caseType(breakdownElement);
			if (result == null)
				result = caseNamedElement(breakdownElement);
			if (result == null)
				result = caseElement(breakdownElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.MILESTONE: {
			Milestone milestone = (Milestone) theEObject;
			Object result = caseMilestone(milestone);
			if (result == null)
				result = caseWorkBreakdownElement(milestone);
			if (result == null)
				result = caseBreakdownElement(milestone);
			if (result == null)
				result = caseProcessElement(milestone);
			if (result == null)
				result = caseDescribableElement(milestone);
			if (result == null)
				result = caseMethodElement(milestone);
			if (result == null)
				result = caseClassifier(milestone);
			if (result == null)
				result = casePackageableElement(milestone);
			if (result == null)
				result = caseType(milestone);
			if (result == null)
				result = caseNamedElement(milestone);
			if (result == null)
				result = caseElement(milestone);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.ITERATION: {
			Iteration iteration = (Iteration) theEObject;
			Object result = caseIteration(iteration);
			if (result == null)
				result = caseActivity(iteration);
			if (result == null)
				result = caseWorkBreakdownElement(iteration);
			if (result == null)
				result = caseVariabilityElement(iteration);
			if (result == null)
				result = caseWorkDefinition(iteration);
			if (result == null)
				result = caseBreakdownElement(iteration);
			if (result == null)
				result = caseMethodElement(iteration);
			if (result == null)
				result = caseVariability(iteration);
			if (result == null)
				result = caseProcessElement(iteration);
			if (result == null)
				result = casePackageableElement(iteration);
			if (result == null)
				result = caseDescribableElement(iteration);
			if (result == null)
				result = caseNamedElement(iteration);
			if (result == null)
				result = caseClassifier(iteration);
			if (result == null)
				result = caseElement(iteration);
			if (result == null)
				result = caseType(iteration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PHASE: {
			Phase phase = (Phase) theEObject;
			Object result = casePhase(phase);
			if (result == null)
				result = caseActivity(phase);
			if (result == null)
				result = caseWorkBreakdownElement(phase);
			if (result == null)
				result = caseVariabilityElement(phase);
			if (result == null)
				result = caseWorkDefinition(phase);
			if (result == null)
				result = caseBreakdownElement(phase);
			if (result == null)
				result = caseMethodElement(phase);
			if (result == null)
				result = caseVariability(phase);
			if (result == null)
				result = caseProcessElement(phase);
			if (result == null)
				result = casePackageableElement(phase);
			if (result == null)
				result = caseDescribableElement(phase);
			if (result == null)
				result = caseNamedElement(phase);
			if (result == null)
				result = caseClassifier(phase);
			if (result == null)
				result = caseElement(phase);
			if (result == null)
				result = caseType(phase);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TEAM_PROFILE: {
			TeamProfile teamProfile = (TeamProfile) theEObject;
			Object result = caseTeamProfile(teamProfile);
			if (result == null)
				result = caseBreakdownElement(teamProfile);
			if (result == null)
				result = caseProcessElement(teamProfile);
			if (result == null)
				result = caseDescribableElement(teamProfile);
			if (result == null)
				result = caseMethodElement(teamProfile);
			if (result == null)
				result = caseClassifier(teamProfile);
			if (result == null)
				result = casePackageableElement(teamProfile);
			if (result == null)
				result = caseType(teamProfile);
			if (result == null)
				result = caseNamedElement(teamProfile);
			if (result == null)
				result = caseElement(teamProfile);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.ROLE_DESCRIPTOR: {
			RoleDescriptor roleDescriptor = (RoleDescriptor) theEObject;
			Object result = caseRoleDescriptor(roleDescriptor);
			if (result == null)
				result = caseDescriptor(roleDescriptor);
			if (result == null)
				result = caseBreakdownElement(roleDescriptor);
			if (result == null)
				result = caseProcessElement(roleDescriptor);
			if (result == null)
				result = caseDescribableElement(roleDescriptor);
			if (result == null)
				result = caseMethodElement(roleDescriptor);
			if (result == null)
				result = caseClassifier(roleDescriptor);
			if (result == null)
				result = casePackageableElement(roleDescriptor);
			if (result == null)
				result = caseType(roleDescriptor);
			if (result == null)
				result = caseNamedElement(roleDescriptor);
			if (result == null)
				result = caseElement(roleDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.WORK_ORDER: {
			WorkOrder workOrder = (WorkOrder) theEObject;
			Object result = caseWorkOrder(workOrder);
			if (result == null)
				result = caseProcessElement(workOrder);
			if (result == null)
				result = caseDescribableElement(workOrder);
			if (result == null)
				result = caseMethodElement(workOrder);
			if (result == null)
				result = caseClassifier(workOrder);
			if (result == null)
				result = casePackageableElement(workOrder);
			if (result == null)
				result = caseType(workOrder);
			if (result == null)
				result = caseNamedElement(workOrder);
			if (result == null)
				result = caseElement(workOrder);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PLANNING_DATA: {
			PlanningData planningData = (PlanningData) theEObject;
			Object result = casePlanningData(planningData);
			if (result == null)
				result = caseProcessElement(planningData);
			if (result == null)
				result = caseDescribableElement(planningData);
			if (result == null)
				result = caseMethodElement(planningData);
			if (result == null)
				result = caseClassifier(planningData);
			if (result == null)
				result = casePackageableElement(planningData);
			if (result == null)
				result = caseType(planningData);
			if (result == null)
				result = caseNamedElement(planningData);
			if (result == null)
				result = caseElement(planningData);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DESCRIPTOR: {
			Descriptor descriptor = (Descriptor) theEObject;
			Object result = caseDescriptor(descriptor);
			if (result == null)
				result = caseBreakdownElement(descriptor);
			if (result == null)
				result = caseProcessElement(descriptor);
			if (result == null)
				result = caseDescribableElement(descriptor);
			if (result == null)
				result = caseMethodElement(descriptor);
			if (result == null)
				result = caseClassifier(descriptor);
			if (result == null)
				result = casePackageableElement(descriptor);
			if (result == null)
				result = caseType(descriptor);
			if (result == null)
				result = caseNamedElement(descriptor);
			if (result == null)
				result = caseElement(descriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.WORK_PRODUCT_DESCRIPTOR: {
			WorkProductDescriptor workProductDescriptor = (WorkProductDescriptor) theEObject;
			Object result = caseWorkProductDescriptor(workProductDescriptor);
			if (result == null)
				result = caseDescriptor(workProductDescriptor);
			if (result == null)
				result = caseBreakdownElement(workProductDescriptor);
			if (result == null)
				result = caseProcessElement(workProductDescriptor);
			if (result == null)
				result = caseDescribableElement(workProductDescriptor);
			if (result == null)
				result = caseMethodElement(workProductDescriptor);
			if (result == null)
				result = caseClassifier(workProductDescriptor);
			if (result == null)
				result = casePackageableElement(workProductDescriptor);
			if (result == null)
				result = caseType(workProductDescriptor);
			if (result == null)
				result = caseNamedElement(workProductDescriptor);
			if (result == null)
				result = caseElement(workProductDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TASK_DESCRIPTOR: {
			TaskDescriptor taskDescriptor = (TaskDescriptor) theEObject;
			Object result = caseTaskDescriptor(taskDescriptor);
			if (result == null)
				result = caseWorkBreakdownElement(taskDescriptor);
			if (result == null)
				result = caseDescriptor(taskDescriptor);
			if (result == null)
				result = caseBreakdownElement(taskDescriptor);
			if (result == null)
				result = caseProcessElement(taskDescriptor);
			if (result == null)
				result = caseDescribableElement(taskDescriptor);
			if (result == null)
				result = caseMethodElement(taskDescriptor);
			if (result == null)
				result = caseClassifier(taskDescriptor);
			if (result == null)
				result = casePackageableElement(taskDescriptor);
			if (result == null)
				result = caseType(taskDescriptor);
			if (result == null)
				result = caseNamedElement(taskDescriptor);
			if (result == null)
				result = caseElement(taskDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.COMPOSITE_ROLE: {
			CompositeRole compositeRole = (CompositeRole) theEObject;
			Object result = caseCompositeRole(compositeRole);
			if (result == null)
				result = caseRoleDescriptor(compositeRole);
			if (result == null)
				result = caseDescriptor(compositeRole);
			if (result == null)
				result = caseBreakdownElement(compositeRole);
			if (result == null)
				result = caseProcessElement(compositeRole);
			if (result == null)
				result = caseDescribableElement(compositeRole);
			if (result == null)
				result = caseMethodElement(compositeRole);
			if (result == null)
				result = caseClassifier(compositeRole);
			if (result == null)
				result = casePackageableElement(compositeRole);
			if (result == null)
				result = caseType(compositeRole);
			if (result == null)
				result = caseNamedElement(compositeRole);
			if (result == null)
				result = caseElement(compositeRole);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.BREAKDOWN_ELEMENT_DESCRIPTION: {
			BreakdownElementDescription breakdownElementDescription = (BreakdownElementDescription) theEObject;
			Object result = caseBreakdownElementDescription(breakdownElementDescription);
			if (result == null)
				result = caseContentDescription(breakdownElementDescription);
			if (result == null)
				result = caseMethodUnit(breakdownElementDescription);
			if (result == null)
				result = caseMethodElement(breakdownElementDescription);
			if (result == null)
				result = casePackageableElement(breakdownElementDescription);
			if (result == null)
				result = caseNamedElement(breakdownElementDescription);
			if (result == null)
				result = caseElement(breakdownElementDescription);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.ACTIVITY_DESCRIPTION: {
			ActivityDescription activityDescription = (ActivityDescription) theEObject;
			Object result = caseActivityDescription(activityDescription);
			if (result == null)
				result = caseBreakdownElementDescription(activityDescription);
			if (result == null)
				result = caseContentDescription(activityDescription);
			if (result == null)
				result = caseMethodUnit(activityDescription);
			if (result == null)
				result = caseMethodElement(activityDescription);
			if (result == null)
				result = casePackageableElement(activityDescription);
			if (result == null)
				result = caseNamedElement(activityDescription);
			if (result == null)
				result = caseElement(activityDescription);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DELIVERY_PROCESS_DESCRIPTION: {
			DeliveryProcessDescription deliveryProcessDescription = (DeliveryProcessDescription) theEObject;
			Object result = caseDeliveryProcessDescription(deliveryProcessDescription);
			if (result == null)
				result = caseProcessDescription(deliveryProcessDescription);
			if (result == null)
				result = caseActivityDescription(deliveryProcessDescription);
			if (result == null)
				result = caseBreakdownElementDescription(deliveryProcessDescription);
			if (result == null)
				result = caseContentDescription(deliveryProcessDescription);
			if (result == null)
				result = caseMethodUnit(deliveryProcessDescription);
			if (result == null)
				result = caseMethodElement(deliveryProcessDescription);
			if (result == null)
				result = casePackageableElement(deliveryProcessDescription);
			if (result == null)
				result = caseNamedElement(deliveryProcessDescription);
			if (result == null)
				result = caseElement(deliveryProcessDescription);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS_DESCRIPTION: {
			ProcessDescription processDescription = (ProcessDescription) theEObject;
			Object result = caseProcessDescription(processDescription);
			if (result == null)
				result = caseActivityDescription(processDescription);
			if (result == null)
				result = caseBreakdownElementDescription(processDescription);
			if (result == null)
				result = caseContentDescription(processDescription);
			if (result == null)
				result = caseMethodUnit(processDescription);
			if (result == null)
				result = caseMethodElement(processDescription);
			if (result == null)
				result = casePackageableElement(processDescription);
			if (result == null)
				result = caseNamedElement(processDescription);
			if (result == null)
				result = caseElement(processDescription);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DESCRIPTOR_DESCRIPTION: {
			DescriptorDescription descriptorDescription = (DescriptorDescription) theEObject;
			Object result = caseDescriptorDescription(descriptorDescription);
			if (result == null)
				result = caseBreakdownElementDescription(descriptorDescription);
			if (result == null)
				result = caseContentDescription(descriptorDescription);
			if (result == null)
				result = caseMethodUnit(descriptorDescription);
			if (result == null)
				result = caseMethodElement(descriptorDescription);
			if (result == null)
				result = casePackageableElement(descriptorDescription);
			if (result == null)
				result = caseNamedElement(descriptorDescription);
			if (result == null)
				result = caseElement(descriptorDescription);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.CONCEPT: {
			Concept concept = (Concept) theEObject;
			Object result = caseConcept(concept);
			if (result == null)
				result = caseGuidance(concept);
			if (result == null)
				result = caseContentElement(concept);
			if (result == null)
				result = caseDescribableElement(concept);
			if (result == null)
				result = caseVariabilityElement(concept);
			if (result == null)
				result = caseMethodElement(concept);
			if (result == null)
				result = caseClassifier(concept);
			if (result == null)
				result = caseVariability(concept);
			if (result == null)
				result = casePackageableElement(concept);
			if (result == null)
				result = caseType(concept);
			if (result == null)
				result = caseNamedElement(concept);
			if (result == null)
				result = caseElement(concept);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.CHECKLIST: {
			Checklist checklist = (Checklist) theEObject;
			Object result = caseChecklist(checklist);
			if (result == null)
				result = caseGuidance(checklist);
			if (result == null)
				result = caseContentElement(checklist);
			if (result == null)
				result = caseDescribableElement(checklist);
			if (result == null)
				result = caseVariabilityElement(checklist);
			if (result == null)
				result = caseMethodElement(checklist);
			if (result == null)
				result = caseClassifier(checklist);
			if (result == null)
				result = caseVariability(checklist);
			if (result == null)
				result = casePackageableElement(checklist);
			if (result == null)
				result = caseType(checklist);
			if (result == null)
				result = caseNamedElement(checklist);
			if (result == null)
				result = caseElement(checklist);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.EXAMPLE: {
			Example example = (Example) theEObject;
			Object result = caseExample(example);
			if (result == null)
				result = caseGuidance(example);
			if (result == null)
				result = caseContentElement(example);
			if (result == null)
				result = caseDescribableElement(example);
			if (result == null)
				result = caseVariabilityElement(example);
			if (result == null)
				result = caseMethodElement(example);
			if (result == null)
				result = caseClassifier(example);
			if (result == null)
				result = caseVariability(example);
			if (result == null)
				result = casePackageableElement(example);
			if (result == null)
				result = caseType(example);
			if (result == null)
				result = caseNamedElement(example);
			if (result == null)
				result = caseElement(example);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.GUIDELINE: {
			Guideline guideline = (Guideline) theEObject;
			Object result = caseGuideline(guideline);
			if (result == null)
				result = caseGuidance(guideline);
			if (result == null)
				result = caseContentElement(guideline);
			if (result == null)
				result = caseDescribableElement(guideline);
			if (result == null)
				result = caseVariabilityElement(guideline);
			if (result == null)
				result = caseMethodElement(guideline);
			if (result == null)
				result = caseClassifier(guideline);
			if (result == null)
				result = caseVariability(guideline);
			if (result == null)
				result = casePackageableElement(guideline);
			if (result == null)
				result = caseType(guideline);
			if (result == null)
				result = caseNamedElement(guideline);
			if (result == null)
				result = caseElement(guideline);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.REPORT: {
			Report report = (Report) theEObject;
			Object result = caseReport(report);
			if (result == null)
				result = caseGuidance(report);
			if (result == null)
				result = caseContentElement(report);
			if (result == null)
				result = caseDescribableElement(report);
			if (result == null)
				result = caseVariabilityElement(report);
			if (result == null)
				result = caseMethodElement(report);
			if (result == null)
				result = caseClassifier(report);
			if (result == null)
				result = caseVariability(report);
			if (result == null)
				result = casePackageableElement(report);
			if (result == null)
				result = caseType(report);
			if (result == null)
				result = caseNamedElement(report);
			if (result == null)
				result = caseElement(report);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TEMPLATE: {
			Template template = (Template) theEObject;
			Object result = caseTemplate(template);
			if (result == null)
				result = caseGuidance(template);
			if (result == null)
				result = caseContentElement(template);
			if (result == null)
				result = caseDescribableElement(template);
			if (result == null)
				result = caseVariabilityElement(template);
			if (result == null)
				result = caseMethodElement(template);
			if (result == null)
				result = caseClassifier(template);
			if (result == null)
				result = caseVariability(template);
			if (result == null)
				result = casePackageableElement(template);
			if (result == null)
				result = caseType(template);
			if (result == null)
				result = caseNamedElement(template);
			if (result == null)
				result = caseElement(template);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.SUPPORTING_MATERIAL: {
			SupportingMaterial supportingMaterial = (SupportingMaterial) theEObject;
			Object result = caseSupportingMaterial(supportingMaterial);
			if (result == null)
				result = caseGuidance(supportingMaterial);
			if (result == null)
				result = caseContentElement(supportingMaterial);
			if (result == null)
				result = caseDescribableElement(supportingMaterial);
			if (result == null)
				result = caseVariabilityElement(supportingMaterial);
			if (result == null)
				result = caseMethodElement(supportingMaterial);
			if (result == null)
				result = caseClassifier(supportingMaterial);
			if (result == null)
				result = caseVariability(supportingMaterial);
			if (result == null)
				result = casePackageableElement(supportingMaterial);
			if (result == null)
				result = caseType(supportingMaterial);
			if (result == null)
				result = caseNamedElement(supportingMaterial);
			if (result == null)
				result = caseElement(supportingMaterial);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TOOL_MENTOR: {
			ToolMentor toolMentor = (ToolMentor) theEObject;
			Object result = caseToolMentor(toolMentor);
			if (result == null)
				result = caseGuidance(toolMentor);
			if (result == null)
				result = caseContentElement(toolMentor);
			if (result == null)
				result = caseDescribableElement(toolMentor);
			if (result == null)
				result = caseVariabilityElement(toolMentor);
			if (result == null)
				result = caseMethodElement(toolMentor);
			if (result == null)
				result = caseClassifier(toolMentor);
			if (result == null)
				result = caseVariability(toolMentor);
			if (result == null)
				result = casePackageableElement(toolMentor);
			if (result == null)
				result = caseType(toolMentor);
			if (result == null)
				result = caseNamedElement(toolMentor);
			if (result == null)
				result = caseElement(toolMentor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.WHITEPAPER: {
			Whitepaper whitepaper = (Whitepaper) theEObject;
			Object result = caseWhitepaper(whitepaper);
			if (result == null)
				result = caseConcept(whitepaper);
			if (result == null)
				result = caseGuidance(whitepaper);
			if (result == null)
				result = caseContentElement(whitepaper);
			if (result == null)
				result = caseDescribableElement(whitepaper);
			if (result == null)
				result = caseVariabilityElement(whitepaper);
			if (result == null)
				result = caseMethodElement(whitepaper);
			if (result == null)
				result = caseClassifier(whitepaper);
			if (result == null)
				result = caseVariability(whitepaper);
			if (result == null)
				result = casePackageableElement(whitepaper);
			if (result == null)
				result = caseType(whitepaper);
			if (result == null)
				result = caseNamedElement(whitepaper);
			if (result == null)
				result = caseElement(whitepaper);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TERM_DEFINITION: {
			TermDefinition termDefinition = (TermDefinition) theEObject;
			Object result = caseTermDefinition(termDefinition);
			if (result == null)
				result = caseGuidance(termDefinition);
			if (result == null)
				result = caseContentElement(termDefinition);
			if (result == null)
				result = caseDescribableElement(termDefinition);
			if (result == null)
				result = caseVariabilityElement(termDefinition);
			if (result == null)
				result = caseMethodElement(termDefinition);
			if (result == null)
				result = caseClassifier(termDefinition);
			if (result == null)
				result = caseVariability(termDefinition);
			if (result == null)
				result = casePackageableElement(termDefinition);
			if (result == null)
				result = caseType(termDefinition);
			if (result == null)
				result = caseNamedElement(termDefinition);
			if (result == null)
				result = caseElement(termDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PRACTICE: {
			Practice practice = (Practice) theEObject;
			Object result = casePractice(practice);
			if (result == null)
				result = caseGuidance(practice);
			if (result == null)
				result = caseContentElement(practice);
			if (result == null)
				result = caseDescribableElement(practice);
			if (result == null)
				result = caseVariabilityElement(practice);
			if (result == null)
				result = caseMethodElement(practice);
			if (result == null)
				result = caseClassifier(practice);
			if (result == null)
				result = caseVariability(practice);
			if (result == null)
				result = casePackageableElement(practice);
			if (result == null)
				result = caseType(practice);
			if (result == null)
				result = caseNamedElement(practice);
			if (result == null)
				result = caseElement(practice);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.ESTIMATION_CONSIDERATIONS: {
			EstimationConsiderations estimationConsiderations = (EstimationConsiderations) theEObject;
			Object result = caseEstimationConsiderations(estimationConsiderations);
			if (result == null)
				result = caseGuidance(estimationConsiderations);
			if (result == null)
				result = caseContentElement(estimationConsiderations);
			if (result == null)
				result = caseDescribableElement(estimationConsiderations);
			if (result == null)
				result = caseVariabilityElement(estimationConsiderations);
			if (result == null)
				result = caseMethodElement(estimationConsiderations);
			if (result == null)
				result = caseClassifier(estimationConsiderations);
			if (result == null)
				result = caseVariability(estimationConsiderations);
			if (result == null)
				result = casePackageableElement(estimationConsiderations);
			if (result == null)
				result = caseType(estimationConsiderations);
			if (result == null)
				result = caseNamedElement(estimationConsiderations);
			if (result == null)
				result = caseElement(estimationConsiderations);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.REUSABLE_ASSET: {
			ReusableAsset reusableAsset = (ReusableAsset) theEObject;
			Object result = caseReusableAsset(reusableAsset);
			if (result == null)
				result = caseGuidance(reusableAsset);
			if (result == null)
				result = caseContentElement(reusableAsset);
			if (result == null)
				result = caseDescribableElement(reusableAsset);
			if (result == null)
				result = caseVariabilityElement(reusableAsset);
			if (result == null)
				result = caseMethodElement(reusableAsset);
			if (result == null)
				result = caseClassifier(reusableAsset);
			if (result == null)
				result = caseVariability(reusableAsset);
			if (result == null)
				result = casePackageableElement(reusableAsset);
			if (result == null)
				result = caseType(reusableAsset);
			if (result == null)
				result = caseNamedElement(reusableAsset);
			if (result == null)
				result = caseElement(reusableAsset);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.STATE: {
			State state = (State) theEObject;
			Object result = caseState(state);
			if (result == null)
				result = caseVertex(state);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VERTEX: {
			Vertex vertex = (Vertex) theEObject;
			Object result = caseVertex(vertex);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.REGION: {
			Region region = (Region) theEObject;
			Object result = caseRegion(region);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.STATE_MACHINE: {
			StateMachine stateMachine = (StateMachine) theEObject;
			Object result = caseStateMachine(stateMachine);
			if (result == null)
				result = caseWorkDefinition(stateMachine);
			if (result == null)
				result = caseMethodElement(stateMachine);
			if (result == null)
				result = casePackageableElement(stateMachine);
			if (result == null)
				result = caseNamedElement(stateMachine);
			if (result == null)
				result = caseElement(stateMachine);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TRANSITION: {
			Transition transition = (Transition) theEObject;
			Object result = caseTransition(transition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PSEUDO_STATE: {
			PseudoState pseudoState = (PseudoState) theEObject;
			Object result = casePseudoState(pseudoState);
			if (result == null)
				result = caseVertex(pseudoState);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DISCIPLINE: {
			Discipline discipline = (Discipline) theEObject;
			Object result = caseDiscipline(discipline);
			if (result == null)
				result = caseContentCategory(discipline);
			if (result == null)
				result = caseContentElement(discipline);
			if (result == null)
				result = caseDescribableElement(discipline);
			if (result == null)
				result = caseVariabilityElement(discipline);
			if (result == null)
				result = caseMethodElement(discipline);
			if (result == null)
				result = caseClassifier(discipline);
			if (result == null)
				result = caseVariability(discipline);
			if (result == null)
				result = casePackageableElement(discipline);
			if (result == null)
				result = caseType(discipline);
			if (result == null)
				result = caseNamedElement(discipline);
			if (result == null)
				result = caseElement(discipline);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.CONTENT_CATEGORY: {
			ContentCategory contentCategory = (ContentCategory) theEObject;
			Object result = caseContentCategory(contentCategory);
			if (result == null)
				result = caseContentElement(contentCategory);
			if (result == null)
				result = caseDescribableElement(contentCategory);
			if (result == null)
				result = caseVariabilityElement(contentCategory);
			if (result == null)
				result = caseMethodElement(contentCategory);
			if (result == null)
				result = caseClassifier(contentCategory);
			if (result == null)
				result = caseVariability(contentCategory);
			if (result == null)
				result = casePackageableElement(contentCategory);
			if (result == null)
				result = caseType(contentCategory);
			if (result == null)
				result = caseNamedElement(contentCategory);
			if (result == null)
				result = caseElement(contentCategory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.ROLE_SET: {
			RoleSet roleSet = (RoleSet) theEObject;
			Object result = caseRoleSet(roleSet);
			if (result == null)
				result = caseContentCategory(roleSet);
			if (result == null)
				result = caseContentElement(roleSet);
			if (result == null)
				result = caseDescribableElement(roleSet);
			if (result == null)
				result = caseVariabilityElement(roleSet);
			if (result == null)
				result = caseMethodElement(roleSet);
			if (result == null)
				result = caseClassifier(roleSet);
			if (result == null)
				result = caseVariability(roleSet);
			if (result == null)
				result = casePackageableElement(roleSet);
			if (result == null)
				result = caseType(roleSet);
			if (result == null)
				result = caseNamedElement(roleSet);
			if (result == null)
				result = caseElement(roleSet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DOMAIN: {
			Domain domain = (Domain) theEObject;
			Object result = caseDomain(domain);
			if (result == null)
				result = caseContentCategory(domain);
			if (result == null)
				result = caseContentElement(domain);
			if (result == null)
				result = caseDescribableElement(domain);
			if (result == null)
				result = caseVariabilityElement(domain);
			if (result == null)
				result = caseMethodElement(domain);
			if (result == null)
				result = caseClassifier(domain);
			if (result == null)
				result = caseVariability(domain);
			if (result == null)
				result = casePackageableElement(domain);
			if (result == null)
				result = caseType(domain);
			if (result == null)
				result = caseNamedElement(domain);
			if (result == null)
				result = caseElement(domain);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PRUEBAS_LINEAS: {
			PruebasLineas pruebasLineas = (PruebasLineas) theEObject;
			Object result = casePruebasLineas(pruebasLineas);
			if (result == null)
				result = caseContentCategory(pruebasLineas);
			if (result == null)
				result = caseContentElement(pruebasLineas);
			if (result == null)
				result = caseDescribableElement(pruebasLineas);
			if (result == null)
				result = caseVariabilityElement(pruebasLineas);
			if (result == null)
				result = caseMethodElement(pruebasLineas);
			if (result == null)
				result = caseClassifier(pruebasLineas);
			if (result == null)
				result = caseVariability(pruebasLineas);
			if (result == null)
				result = casePackageableElement(pruebasLineas);
			if (result == null)
				result = caseType(pruebasLineas);
			if (result == null)
				result = caseNamedElement(pruebasLineas);
			if (result == null)
				result = caseElement(pruebasLineas);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.WORK_PRODUCT_TYPE: {
			WorkProductType workProductType = (WorkProductType) theEObject;
			Object result = caseWorkProductType(workProductType);
			if (result == null)
				result = caseContentCategory(workProductType);
			if (result == null)
				result = caseContentElement(workProductType);
			if (result == null)
				result = caseDescribableElement(workProductType);
			if (result == null)
				result = caseVariabilityElement(workProductType);
			if (result == null)
				result = caseMethodElement(workProductType);
			if (result == null)
				result = caseClassifier(workProductType);
			if (result == null)
				result = caseVariability(workProductType);
			if (result == null)
				result = casePackageableElement(workProductType);
			if (result == null)
				result = caseType(workProductType);
			if (result == null)
				result = caseNamedElement(workProductType);
			if (result == null)
				result = caseElement(workProductType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DISCIPLINE_GROUPING: {
			DisciplineGrouping disciplineGrouping = (DisciplineGrouping) theEObject;
			Object result = caseDisciplineGrouping(disciplineGrouping);
			if (result == null)
				result = caseContentCategory(disciplineGrouping);
			if (result == null)
				result = caseContentElement(disciplineGrouping);
			if (result == null)
				result = caseDescribableElement(disciplineGrouping);
			if (result == null)
				result = caseVariabilityElement(disciplineGrouping);
			if (result == null)
				result = caseMethodElement(disciplineGrouping);
			if (result == null)
				result = caseClassifier(disciplineGrouping);
			if (result == null)
				result = caseVariability(disciplineGrouping);
			if (result == null)
				result = casePackageableElement(disciplineGrouping);
			if (result == null)
				result = caseType(disciplineGrouping);
			if (result == null)
				result = caseNamedElement(disciplineGrouping);
			if (result == null)
				result = caseElement(disciplineGrouping);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TOOL: {
			Tool tool = (Tool) theEObject;
			Object result = caseTool(tool);
			if (result == null)
				result = caseContentCategory(tool);
			if (result == null)
				result = caseContentElement(tool);
			if (result == null)
				result = caseDescribableElement(tool);
			if (result == null)
				result = caseVariabilityElement(tool);
			if (result == null)
				result = caseMethodElement(tool);
			if (result == null)
				result = caseClassifier(tool);
			if (result == null)
				result = caseVariability(tool);
			if (result == null)
				result = casePackageableElement(tool);
			if (result == null)
				result = caseType(tool);
			if (result == null)
				result = caseNamedElement(tool);
			if (result == null)
				result = caseElement(tool);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.ROLE_SET_GROUPING: {
			RoleSetGrouping roleSetGrouping = (RoleSetGrouping) theEObject;
			Object result = caseRoleSetGrouping(roleSetGrouping);
			if (result == null)
				result = caseContentCategory(roleSetGrouping);
			if (result == null)
				result = caseContentElement(roleSetGrouping);
			if (result == null)
				result = caseDescribableElement(roleSetGrouping);
			if (result == null)
				result = caseVariabilityElement(roleSetGrouping);
			if (result == null)
				result = caseMethodElement(roleSetGrouping);
			if (result == null)
				result = caseClassifier(roleSetGrouping);
			if (result == null)
				result = caseVariability(roleSetGrouping);
			if (result == null)
				result = casePackageableElement(roleSetGrouping);
			if (result == null)
				result = caseType(roleSetGrouping);
			if (result == null)
				result = caseNamedElement(roleSetGrouping);
			if (result == null)
				result = caseElement(roleSetGrouping);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.CUSTOM_CATEGORY: {
			CustomCategory customCategory = (CustomCategory) theEObject;
			Object result = caseCustomCategory(customCategory);
			if (result == null)
				result = caseContentCategory(customCategory);
			if (result == null)
				result = caseContentElement(customCategory);
			if (result == null)
				result = caseDescribableElement(customCategory);
			if (result == null)
				result = caseVariabilityElement(customCategory);
			if (result == null)
				result = caseMethodElement(customCategory);
			if (result == null)
				result = caseClassifier(customCategory);
			if (result == null)
				result = caseVariability(customCategory);
			if (result == null)
				result = casePackageableElement(customCategory);
			if (result == null)
				result = caseType(customCategory);
			if (result == null)
				result = caseNamedElement(customCategory);
			if (result == null)
				result = caseElement(customCategory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DELIVERY_PROCESS: {
			DeliveryProcess deliveryProcess = (DeliveryProcess) theEObject;
			Object result = caseDeliveryProcess(deliveryProcess);
			if (result == null)
				result = caseProcess(deliveryProcess);
			if (result == null)
				result = caseActivity(deliveryProcess);
			if (result == null)
				result = caseWorkBreakdownElement(deliveryProcess);
			if (result == null)
				result = caseVariabilityElement(deliveryProcess);
			if (result == null)
				result = caseWorkDefinition(deliveryProcess);
			if (result == null)
				result = caseBreakdownElement(deliveryProcess);
			if (result == null)
				result = caseMethodElement(deliveryProcess);
			if (result == null)
				result = caseVariability(deliveryProcess);
			if (result == null)
				result = caseProcessElement(deliveryProcess);
			if (result == null)
				result = casePackageableElement(deliveryProcess);
			if (result == null)
				result = caseDescribableElement(deliveryProcess);
			if (result == null)
				result = caseNamedElement(deliveryProcess);
			if (result == null)
				result = caseClassifier(deliveryProcess);
			if (result == null)
				result = caseElement(deliveryProcess);
			if (result == null)
				result = caseType(deliveryProcess);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS: {
			org.eclipse.epf.uma.Process process = (org.eclipse.epf.uma.Process) theEObject;
			Object result = caseProcess(process);
			if (result == null)
				result = caseActivity(process);
			if (result == null)
				result = caseWorkBreakdownElement(process);
			if (result == null)
				result = caseVariabilityElement(process);
			if (result == null)
				result = caseWorkDefinition(process);
			if (result == null)
				result = caseBreakdownElement(process);
			if (result == null)
				result = caseMethodElement(process);
			if (result == null)
				result = caseVariability(process);
			if (result == null)
				result = caseProcessElement(process);
			if (result == null)
				result = casePackageableElement(process);
			if (result == null)
				result = caseDescribableElement(process);
			if (result == null)
				result = caseNamedElement(process);
			if (result == null)
				result = caseClassifier(process);
			if (result == null)
				result = caseElement(process);
			if (result == null)
				result = caseType(process);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.CAPABILITY_PATTERN: {
			CapabilityPattern capabilityPattern = (CapabilityPattern) theEObject;
			Object result = caseCapabilityPattern(capabilityPattern);
			if (result == null)
				result = caseProcess(capabilityPattern);
			if (result == null)
				result = caseActivity(capabilityPattern);
			if (result == null)
				result = caseWorkBreakdownElement(capabilityPattern);
			if (result == null)
				result = caseVariabilityElement(capabilityPattern);
			if (result == null)
				result = caseWorkDefinition(capabilityPattern);
			if (result == null)
				result = caseBreakdownElement(capabilityPattern);
			if (result == null)
				result = caseMethodElement(capabilityPattern);
			if (result == null)
				result = caseVariability(capabilityPattern);
			if (result == null)
				result = caseProcessElement(capabilityPattern);
			if (result == null)
				result = casePackageableElement(capabilityPattern);
			if (result == null)
				result = caseDescribableElement(capabilityPattern);
			if (result == null)
				result = caseNamedElement(capabilityPattern);
			if (result == null)
				result = caseClassifier(capabilityPattern);
			if (result == null)
				result = caseElement(capabilityPattern);
			if (result == null)
				result = caseType(capabilityPattern);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS_PLANNING_TEMPLATE: {
			ProcessPlanningTemplate processPlanningTemplate = (ProcessPlanningTemplate) theEObject;
			Object result = caseProcessPlanningTemplate(processPlanningTemplate);
			if (result == null)
				result = caseProcess(processPlanningTemplate);
			if (result == null)
				result = caseActivity(processPlanningTemplate);
			if (result == null)
				result = caseWorkBreakdownElement(processPlanningTemplate);
			if (result == null)
				result = caseVariabilityElement(processPlanningTemplate);
			if (result == null)
				result = caseWorkDefinition(processPlanningTemplate);
			if (result == null)
				result = caseBreakdownElement(processPlanningTemplate);
			if (result == null)
				result = caseMethodElement(processPlanningTemplate);
			if (result == null)
				result = caseVariability(processPlanningTemplate);
			if (result == null)
				result = caseProcessElement(processPlanningTemplate);
			if (result == null)
				result = casePackageableElement(processPlanningTemplate);
			if (result == null)
				result = caseDescribableElement(processPlanningTemplate);
			if (result == null)
				result = caseNamedElement(processPlanningTemplate);
			if (result == null)
				result = caseClassifier(processPlanningTemplate);
			if (result == null)
				result = caseElement(processPlanningTemplate);
			if (result == null)
				result = caseType(processPlanningTemplate);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.ROADMAP: {
			Roadmap roadmap = (Roadmap) theEObject;
			Object result = caseRoadmap(roadmap);
			if (result == null)
				result = caseGuidance(roadmap);
			if (result == null)
				result = caseContentElement(roadmap);
			if (result == null)
				result = caseDescribableElement(roadmap);
			if (result == null)
				result = caseVariabilityElement(roadmap);
			if (result == null)
				result = caseMethodElement(roadmap);
			if (result == null)
				result = caseClassifier(roadmap);
			if (result == null)
				result = caseVariability(roadmap);
			if (result == null)
				result = casePackageableElement(roadmap);
			if (result == null)
				result = caseType(roadmap);
			if (result == null)
				result = caseNamedElement(roadmap);
			if (result == null)
				result = caseElement(roadmap);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS_COMPONENT: {
			ProcessComponent processComponent = (ProcessComponent) theEObject;
			Object result = caseProcessComponent(processComponent);
			if (result == null)
				result = caseProcessPackage(processComponent);
			if (result == null)
				result = caseMethodUnit(processComponent);
			if (result == null)
				result = caseMethodPackage(processComponent);
			if (result == null)
				result = caseMethodElement(processComponent);
			if (result == null)
				result = casePackage(processComponent);
			if (result == null)
				result = casePackageableElement(processComponent);
			if (result == null)
				result = caseNamespace(processComponent);
			if (result == null)
				result = caseNamedElement(processComponent);
			if (result == null)
				result = caseElement(processComponent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS_PACKAGE: {
			ProcessPackage processPackage = (ProcessPackage) theEObject;
			Object result = caseProcessPackage(processPackage);
			if (result == null)
				result = caseMethodPackage(processPackage);
			if (result == null)
				result = caseMethodElement(processPackage);
			if (result == null)
				result = casePackage(processPackage);
			if (result == null)
				result = casePackageableElement(processPackage);
			if (result == null)
				result = caseNamespace(processPackage);
			if (result == null)
				result = caseNamedElement(processPackage);
			if (result == null)
				result = caseElement(processPackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS_ELEMENT: {
			ProcessElement processElement = (ProcessElement) theEObject;
			Object result = caseProcessElement(processElement);
			if (result == null)
				result = caseDescribableElement(processElement);
			if (result == null)
				result = caseMethodElement(processElement);
			if (result == null)
				result = caseClassifier(processElement);
			if (result == null)
				result = casePackageableElement(processElement);
			if (result == null)
				result = caseType(processElement);
			if (result == null)
				result = caseNamedElement(processElement);
			if (result == null)
				result = caseElement(processElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS_COMPONENT_INTERFACE: {
			ProcessComponentInterface processComponentInterface = (ProcessComponentInterface) theEObject;
			Object result = caseProcessComponentInterface(processComponentInterface);
			if (result == null)
				result = caseBreakdownElement(processComponentInterface);
			if (result == null)
				result = caseProcessElement(processComponentInterface);
			if (result == null)
				result = caseDescribableElement(processComponentInterface);
			if (result == null)
				result = caseMethodElement(processComponentInterface);
			if (result == null)
				result = caseClassifier(processComponentInterface);
			if (result == null)
				result = casePackageableElement(processComponentInterface);
			if (result == null)
				result = caseType(processComponentInterface);
			if (result == null)
				result = caseNamedElement(processComponentInterface);
			if (result == null)
				result = caseElement(processComponentInterface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS_COMPONENT_DESCRIPTOR: {
			ProcessComponentDescriptor processComponentDescriptor = (ProcessComponentDescriptor) theEObject;
			Object result = caseProcessComponentDescriptor(processComponentDescriptor);
			if (result == null)
				result = caseDescriptor(processComponentDescriptor);
			if (result == null)
				result = caseBreakdownElement(processComponentDescriptor);
			if (result == null)
				result = caseProcessElement(processComponentDescriptor);
			if (result == null)
				result = caseDescribableElement(processComponentDescriptor);
			if (result == null)
				result = caseMethodElement(processComponentDescriptor);
			if (result == null)
				result = caseClassifier(processComponentDescriptor);
			if (result == null)
				result = casePackageableElement(processComponentDescriptor);
			if (result == null)
				result = caseType(processComponentDescriptor);
			if (result == null)
				result = caseNamedElement(processComponentDescriptor);
			if (result == null)
				result = caseElement(processComponentDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.METHOD_PLUGIN: {
			MethodPlugin methodPlugin = (MethodPlugin) theEObject;
			Object result = caseMethodPlugin(methodPlugin);
			if (result == null)
				result = caseMethodUnit(methodPlugin);
			if (result == null)
				result = casePackage(methodPlugin);
			if (result == null)
				result = caseMethodElement(methodPlugin);
			if (result == null)
				result = caseNamespace(methodPlugin);
			if (result == null)
				result = casePackageableElement(methodPlugin);
			if (result == null)
				result = caseNamedElement(methodPlugin);
			if (result == null)
				result = caseElement(methodPlugin);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.LINE_PROCESS: {
			LineProcess lineProcess = (LineProcess) theEObject;
			Object result = caseLineProcess(lineProcess);
			if (result == null)
				result = caseProcess(lineProcess);
			if (result == null)
				result = caseActivity(lineProcess);
			if (result == null)
				result = caseWorkBreakdownElement(lineProcess);
			if (result == null)
				result = caseVariabilityElement(lineProcess);
			if (result == null)
				result = caseWorkDefinition(lineProcess);
			if (result == null)
				result = caseBreakdownElement(lineProcess);
			if (result == null)
				result = caseMethodElement(lineProcess);
			if (result == null)
				result = caseVariability(lineProcess);
			if (result == null)
				result = caseProcessElement(lineProcess);
			if (result == null)
				result = casePackageableElement(lineProcess);
			if (result == null)
				result = caseDescribableElement(lineProcess);
			if (result == null)
				result = caseNamedElement(lineProcess);
			if (result == null)
				result = caseClassifier(lineProcess);
			if (result == null)
				result = caseElement(lineProcess);
			if (result == null)
				result = caseType(lineProcess);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS_LINES_PACKAGE: {
			ProcessLinesPackage processLinesPackage = (ProcessLinesPackage) theEObject;
			Object result = caseProcessLinesPackage(processLinesPackage);
			if (result == null)
				result = caseMethodPackage(processLinesPackage);
			if (result == null)
				result = caseMethodElement(processLinesPackage);
			if (result == null)
				result = casePackage(processLinesPackage);
			if (result == null)
				result = casePackageableElement(processLinesPackage);
			if (result == null)
				result = caseNamespace(processLinesPackage);
			if (result == null)
				result = caseNamedElement(processLinesPackage);
			if (result == null)
				result = caseElement(processLinesPackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS_LINE_ELEMENT: {
			ProcessLineElement processLineElement = (ProcessLineElement) theEObject;
			Object result = caseProcessLineElement(processLineElement);
			if (result == null)
				result = caseDescribableElement(processLineElement);
			if (result == null)
				result = caseMethodElement(processLineElement);
			if (result == null)
				result = caseClassifier(processLineElement);
			if (result == null)
				result = casePackageableElement(processLineElement);
			if (result == null)
				result = caseType(processLineElement);
			if (result == null)
				result = caseNamedElement(processLineElement);
			if (result == null)
				result = caseElement(processLineElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS_LINE_COMPONENT: {
			ProcessLineComponent processLineComponent = (ProcessLineComponent) theEObject;
			Object result = caseProcessLineComponent(processLineComponent);
			if (result == null)
				result = caseProcessLinesPackage(processLineComponent);
			if (result == null)
				result = caseMethodUnit(processLineComponent);
			if (result == null)
				result = caseMethodPlugin(processLineComponent);
			if (result == null)
				result = caseMethodPackage(processLineComponent);
			if (result == null)
				result = caseMethodElement(processLineComponent);
			if (result == null)
				result = casePackage(processLineComponent);
			if (result == null)
				result = casePackageableElement(processLineComponent);
			if (result == null)
				result = caseNamespace(processLineComponent);
			if (result == null)
				result = caseNamedElement(processLineComponent);
			if (result == null)
				result = caseElement(processLineComponent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS_LINE_COMPONENT_PACKAGE: {
			ProcessLineComponentPackage processLineComponentPackage = (ProcessLineComponentPackage) theEObject;
			Object result = caseProcessLineComponentPackage(processLineComponentPackage);
			if (result == null)
				result = caseMethodPackage(processLineComponentPackage);
			if (result == null)
				result = caseMethodElement(processLineComponentPackage);
			if (result == null)
				result = casePackage(processLineComponentPackage);
			if (result == null)
				result = casePackageableElement(processLineComponentPackage);
			if (result == null)
				result = caseNamespace(processLineComponentPackage);
			if (result == null)
				result = caseNamedElement(processLineComponentPackage);
			if (result == null)
				result = caseElement(processLineComponentPackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS_LINE_COMPONENT_INTERFACE: {
			ProcessLineComponentInterface processLineComponentInterface = (ProcessLineComponentInterface) theEObject;
			Object result = caseProcessLineComponentInterface(processLineComponentInterface);
			if (result == null)
				result = caseBreakdownElement(processLineComponentInterface);
			if (result == null)
				result = caseProcessElement(processLineComponentInterface);
			if (result == null)
				result = caseDescribableElement(processLineComponentInterface);
			if (result == null)
				result = caseMethodElement(processLineComponentInterface);
			if (result == null)
				result = caseClassifier(processLineComponentInterface);
			if (result == null)
				result = casePackageableElement(processLineComponentInterface);
			if (result == null)
				result = caseType(processLineComponentInterface);
			if (result == null)
				result = caseNamedElement(processLineComponentInterface);
			if (result == null)
				result = caseElement(processLineComponentInterface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.CORE_PROCESS_PACKAGE: {
			CoreProcessPackage coreProcessPackage = (CoreProcessPackage) theEObject;
			Object result = caseCoreProcessPackage(coreProcessPackage);
			if (result == null)
				result = caseMethodPackage(coreProcessPackage);
			if (result == null)
				result = caseProcessPackage(coreProcessPackage);
			if (result == null)
				result = caseMethodElement(coreProcessPackage);
			if (result == null)
				result = casePackage(coreProcessPackage);
			if (result == null)
				result = casePackageableElement(coreProcessPackage);
			if (result == null)
				result = caseNamespace(coreProcessPackage);
			if (result == null)
				result = caseNamedElement(coreProcessPackage);
			if (result == null)
				result = caseElement(coreProcessPackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TAILORED_PROCESS: {
			TailoredProcess tailoredProcess = (TailoredProcess) theEObject;
			Object result = caseTailoredProcess(tailoredProcess);
			if (result == null)
				result = caseProcess(tailoredProcess);
			if (result == null)
				result = caseActivity(tailoredProcess);
			if (result == null)
				result = caseWorkBreakdownElement(tailoredProcess);
			if (result == null)
				result = caseVariabilityElement(tailoredProcess);
			if (result == null)
				result = caseWorkDefinition(tailoredProcess);
			if (result == null)
				result = caseBreakdownElement(tailoredProcess);
			if (result == null)
				result = caseMethodElement(tailoredProcess);
			if (result == null)
				result = caseVariability(tailoredProcess);
			if (result == null)
				result = caseProcessElement(tailoredProcess);
			if (result == null)
				result = casePackageableElement(tailoredProcess);
			if (result == null)
				result = caseDescribableElement(tailoredProcess);
			if (result == null)
				result = caseNamedElement(tailoredProcess);
			if (result == null)
				result = caseClassifier(tailoredProcess);
			if (result == null)
				result = caseElement(tailoredProcess);
			if (result == null)
				result = caseType(tailoredProcess);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TAILORED_PROCESSES_PACKAGE: {
			TailoredProcessesPackage tailoredProcessesPackage = (TailoredProcessesPackage) theEObject;
			Object result = caseTailoredProcessesPackage(tailoredProcessesPackage);
			if (result == null)
				result = caseMethodPackage(tailoredProcessesPackage);
			if (result == null)
				result = caseMethodElement(tailoredProcessesPackage);
			if (result == null)
				result = casePackage(tailoredProcessesPackage);
			if (result == null)
				result = casePackageableElement(tailoredProcessesPackage);
			if (result == null)
				result = caseNamespace(tailoredProcessesPackage);
			if (result == null)
				result = caseNamedElement(tailoredProcessesPackage);
			if (result == null)
				result = caseElement(tailoredProcessesPackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TAILORED_PROCESS_COMPONENT: {
			TailoredProcessComponent tailoredProcessComponent = (TailoredProcessComponent) theEObject;
			Object result = caseTailoredProcessComponent(tailoredProcessComponent);
			if (result == null)
				result = caseTailoredProcessesPackage(tailoredProcessComponent);
			if (result == null)
				result = caseMethodUnit(tailoredProcessComponent);
			if (result == null)
				result = caseMethodPlugin(tailoredProcessComponent);
			if (result == null)
				result = caseMethodPackage(tailoredProcessComponent);
			if (result == null)
				result = caseMethodElement(tailoredProcessComponent);
			if (result == null)
				result = casePackage(tailoredProcessComponent);
			if (result == null)
				result = casePackageableElement(tailoredProcessComponent);
			if (result == null)
				result = caseNamespace(tailoredProcessComponent);
			if (result == null)
				result = caseNamedElement(tailoredProcessComponent);
			if (result == null)
				result = caseElement(tailoredProcessComponent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.TAILORED_CORE_PROCESS_PACKAGE: {
			TailoredCoreProcessPackage tailoredCoreProcessPackage = (TailoredCoreProcessPackage) theEObject;
			Object result = caseTailoredCoreProcessPackage(tailoredCoreProcessPackage);
			if (result == null)
				result = caseMethodPackage(tailoredCoreProcessPackage);
			if (result == null)
				result = caseProcessPackage(tailoredCoreProcessPackage);
			if (result == null)
				result = caseMethodElement(tailoredCoreProcessPackage);
			if (result == null)
				result = casePackage(tailoredCoreProcessPackage);
			if (result == null)
				result = casePackageableElement(tailoredCoreProcessPackage);
			if (result == null)
				result = caseNamespace(tailoredCoreProcessPackage);
			if (result == null)
				result = caseNamedElement(tailoredCoreProcessPackage);
			if (result == null)
				result = caseElement(tailoredCoreProcessPackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VARIABILITY_ELEMENT: {
			VariabilityElement variabilityElement = (VariabilityElement) theEObject;
			Object result = caseVariabilityElement(variabilityElement);
			if (result == null)
				result = caseMethodElement(variabilityElement);
			if (result == null)
				result = caseVariability(variabilityElement);
			if (result == null)
				result = casePackageableElement(variabilityElement);
			if (result == null)
				result = caseNamedElement(variabilityElement);
			if (result == null)
				result = caseElement(variabilityElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.METHOD_UNIT: {
			MethodUnit methodUnit = (MethodUnit) theEObject;
			Object result = caseMethodUnit(methodUnit);
			if (result == null)
				result = caseMethodElement(methodUnit);
			if (result == null)
				result = casePackageableElement(methodUnit);
			if (result == null)
				result = caseNamedElement(methodUnit);
			if (result == null)
				result = caseElement(methodUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.METHOD_CONFIGURATION: {
			MethodConfiguration methodConfiguration = (MethodConfiguration) theEObject;
			Object result = caseMethodConfiguration(methodConfiguration);
			if (result == null)
				result = caseMethodUnit(methodConfiguration);
			if (result == null)
				result = caseMethodElement(methodConfiguration);
			if (result == null)
				result = casePackageableElement(methodConfiguration);
			if (result == null)
				result = caseNamedElement(methodConfiguration);
			if (result == null)
				result = caseElement(methodConfiguration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS_FAMILY: {
			ProcessFamily processFamily = (ProcessFamily) theEObject;
			Object result = caseProcessFamily(processFamily);
			if (result == null)
				result = caseMethodConfiguration(processFamily);
			if (result == null)
				result = caseMethodUnit(processFamily);
			if (result == null)
				result = caseMethodElement(processFamily);
			if (result == null)
				result = casePackageableElement(processFamily);
			if (result == null)
				result = caseNamedElement(processFamily);
			if (result == null)
				result = caseElement(processFamily);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.METHOD_LIBRARY: {
			MethodLibrary methodLibrary = (MethodLibrary) theEObject;
			Object result = caseMethodLibrary(methodLibrary);
			if (result == null)
				result = caseMethodUnit(methodLibrary);
			if (result == null)
				result = casePackage(methodLibrary);
			if (result == null)
				result = caseMethodElement(methodLibrary);
			if (result == null)
				result = caseNamespace(methodLibrary);
			if (result == null)
				result = casePackageableElement(methodLibrary);
			if (result == null)
				result = caseNamedElement(methodLibrary);
			if (result == null)
				result = caseElement(methodLibrary);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VARIABILITY: {
			Variability variability = (Variability) theEObject;
			Object result = caseVariability(variability);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VAR_ELEMENT: {
			VarElement varElement = (VarElement) theEObject;
			Object result = caseVarElement(varElement);
			if (result == null)
				result = caseVariability(varElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VAR_POINT: {
			VarPoint varPoint = (VarPoint) theEObject;
			Object result = caseVarPoint(varPoint);
			if (result == null)
				result = caseVarElement(varPoint);
			if (result == null)
				result = caseVariability(varPoint);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VP_ACTIVITY: {
			vpActivity vpActivity = (vpActivity) theEObject;
			Object result = casevpActivity(vpActivity);
			if (result == null)
				result = caseActivity(vpActivity);
			if (result == null)
				result = caseVarPoint(vpActivity);
			if (result == null)
				result = caseWorkBreakdownElement(vpActivity);
			if (result == null)
				result = caseVariabilityElement(vpActivity);
			if (result == null)
				result = caseWorkDefinition(vpActivity);
			if (result == null)
				result = caseVarElement(vpActivity);
			if (result == null)
				result = caseBreakdownElement(vpActivity);
			if (result == null)
				result = caseMethodElement(vpActivity);
			if (result == null)
				result = caseVariability(vpActivity);
			if (result == null)
				result = caseProcessElement(vpActivity);
			if (result == null)
				result = casePackageableElement(vpActivity);
			if (result == null)
				result = caseDescribableElement(vpActivity);
			if (result == null)
				result = caseNamedElement(vpActivity);
			if (result == null)
				result = caseClassifier(vpActivity);
			if (result == null)
				result = caseElement(vpActivity);
			if (result == null)
				result = caseType(vpActivity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VP_PHASE: {
			vpPhase vpPhase = (vpPhase) theEObject;
			Object result = casevpPhase(vpPhase);
			if (result == null)
				result = casePhase(vpPhase);
			if (result == null)
				result = caseVarPoint(vpPhase);
			if (result == null)
				result = caseActivity(vpPhase);
			if (result == null)
				result = caseVarElement(vpPhase);
			if (result == null)
				result = caseWorkBreakdownElement(vpPhase);
			if (result == null)
				result = caseVariabilityElement(vpPhase);
			if (result == null)
				result = caseWorkDefinition(vpPhase);
			if (result == null)
				result = caseVariability(vpPhase);
			if (result == null)
				result = caseBreakdownElement(vpPhase);
			if (result == null)
				result = caseMethodElement(vpPhase);
			if (result == null)
				result = caseProcessElement(vpPhase);
			if (result == null)
				result = casePackageableElement(vpPhase);
			if (result == null)
				result = caseDescribableElement(vpPhase);
			if (result == null)
				result = caseNamedElement(vpPhase);
			if (result == null)
				result = caseClassifier(vpPhase);
			if (result == null)
				result = caseElement(vpPhase);
			if (result == null)
				result = caseType(vpPhase);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VP_ITERATION: {
			vpIteration vpIteration = (vpIteration) theEObject;
			Object result = casevpIteration(vpIteration);
			if (result == null)
				result = caseIteration(vpIteration);
			if (result == null)
				result = caseVarPoint(vpIteration);
			if (result == null)
				result = caseActivity(vpIteration);
			if (result == null)
				result = caseVarElement(vpIteration);
			if (result == null)
				result = caseWorkBreakdownElement(vpIteration);
			if (result == null)
				result = caseVariabilityElement(vpIteration);
			if (result == null)
				result = caseWorkDefinition(vpIteration);
			if (result == null)
				result = caseVariability(vpIteration);
			if (result == null)
				result = caseBreakdownElement(vpIteration);
			if (result == null)
				result = caseMethodElement(vpIteration);
			if (result == null)
				result = caseProcessElement(vpIteration);
			if (result == null)
				result = casePackageableElement(vpIteration);
			if (result == null)
				result = caseDescribableElement(vpIteration);
			if (result == null)
				result = caseNamedElement(vpIteration);
			if (result == null)
				result = caseClassifier(vpIteration);
			if (result == null)
				result = caseElement(vpIteration);
			if (result == null)
				result = caseType(vpIteration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VP_ROLE_DESCRIPTOR: {
			vpRoleDescriptor vpRoleDescriptor = (vpRoleDescriptor) theEObject;
			Object result = casevpRoleDescriptor(vpRoleDescriptor);
			if (result == null)
				result = caseRoleDescriptor(vpRoleDescriptor);
			if (result == null)
				result = caseVarPoint(vpRoleDescriptor);
			if (result == null)
				result = caseDescriptor(vpRoleDescriptor);
			if (result == null)
				result = caseVarElement(vpRoleDescriptor);
			if (result == null)
				result = caseBreakdownElement(vpRoleDescriptor);
			if (result == null)
				result = caseVariability(vpRoleDescriptor);
			if (result == null)
				result = caseProcessElement(vpRoleDescriptor);
			if (result == null)
				result = caseDescribableElement(vpRoleDescriptor);
			if (result == null)
				result = caseMethodElement(vpRoleDescriptor);
			if (result == null)
				result = caseClassifier(vpRoleDescriptor);
			if (result == null)
				result = casePackageableElement(vpRoleDescriptor);
			if (result == null)
				result = caseType(vpRoleDescriptor);
			if (result == null)
				result = caseNamedElement(vpRoleDescriptor);
			if (result == null)
				result = caseElement(vpRoleDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VP_TASK_DESCRIPTOR: {
			vpTaskDescriptor vpTaskDescriptor = (vpTaskDescriptor) theEObject;
			Object result = casevpTaskDescriptor(vpTaskDescriptor);
			if (result == null)
				result = caseTaskDescriptor(vpTaskDescriptor);
			if (result == null)
				result = caseVarPoint(vpTaskDescriptor);
			if (result == null)
				result = caseWorkBreakdownElement(vpTaskDescriptor);
			if (result == null)
				result = caseDescriptor(vpTaskDescriptor);
			if (result == null)
				result = caseVarElement(vpTaskDescriptor);
			if (result == null)
				result = caseBreakdownElement(vpTaskDescriptor);
			if (result == null)
				result = caseVariability(vpTaskDescriptor);
			if (result == null)
				result = caseProcessElement(vpTaskDescriptor);
			if (result == null)
				result = caseDescribableElement(vpTaskDescriptor);
			if (result == null)
				result = caseMethodElement(vpTaskDescriptor);
			if (result == null)
				result = caseClassifier(vpTaskDescriptor);
			if (result == null)
				result = casePackageableElement(vpTaskDescriptor);
			if (result == null)
				result = caseType(vpTaskDescriptor);
			if (result == null)
				result = caseNamedElement(vpTaskDescriptor);
			if (result == null)
				result = caseElement(vpTaskDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VP_MILESTONE: {
			vpMilestone vpMilestone = (vpMilestone) theEObject;
			Object result = casevpMilestone(vpMilestone);
			if (result == null)
				result = caseMilestone(vpMilestone);
			if (result == null)
				result = caseVarPoint(vpMilestone);
			if (result == null)
				result = caseWorkBreakdownElement(vpMilestone);
			if (result == null)
				result = caseVarElement(vpMilestone);
			if (result == null)
				result = caseBreakdownElement(vpMilestone);
			if (result == null)
				result = caseVariability(vpMilestone);
			if (result == null)
				result = caseProcessElement(vpMilestone);
			if (result == null)
				result = caseDescribableElement(vpMilestone);
			if (result == null)
				result = caseMethodElement(vpMilestone);
			if (result == null)
				result = caseClassifier(vpMilestone);
			if (result == null)
				result = casePackageableElement(vpMilestone);
			if (result == null)
				result = caseType(vpMilestone);
			if (result == null)
				result = caseNamedElement(vpMilestone);
			if (result == null)
				result = caseElement(vpMilestone);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VP_TEAM_PROFILE: {
			vpTeamProfile vpTeamProfile = (vpTeamProfile) theEObject;
			Object result = casevpTeamProfile(vpTeamProfile);
			if (result == null)
				result = caseTeamProfile(vpTeamProfile);
			if (result == null)
				result = caseVarPoint(vpTeamProfile);
			if (result == null)
				result = caseBreakdownElement(vpTeamProfile);
			if (result == null)
				result = caseVarElement(vpTeamProfile);
			if (result == null)
				result = caseProcessElement(vpTeamProfile);
			if (result == null)
				result = caseVariability(vpTeamProfile);
			if (result == null)
				result = caseDescribableElement(vpTeamProfile);
			if (result == null)
				result = caseMethodElement(vpTeamProfile);
			if (result == null)
				result = caseClassifier(vpTeamProfile);
			if (result == null)
				result = casePackageableElement(vpTeamProfile);
			if (result == null)
				result = caseType(vpTeamProfile);
			if (result == null)
				result = caseNamedElement(vpTeamProfile);
			if (result == null)
				result = caseElement(vpTeamProfile);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VP_WORK_PRODUCT_DESCRIPTOR: {
			vpWorkProductDescriptor vpWorkProductDescriptor = (vpWorkProductDescriptor) theEObject;
			Object result = casevpWorkProductDescriptor(vpWorkProductDescriptor);
			if (result == null)
				result = caseWorkProductDescriptor(vpWorkProductDescriptor);
			if (result == null)
				result = caseVarPoint(vpWorkProductDescriptor);
			if (result == null)
				result = caseDescriptor(vpWorkProductDescriptor);
			if (result == null)
				result = caseVarElement(vpWorkProductDescriptor);
			if (result == null)
				result = caseBreakdownElement(vpWorkProductDescriptor);
			if (result == null)
				result = caseVariability(vpWorkProductDescriptor);
			if (result == null)
				result = caseProcessElement(vpWorkProductDescriptor);
			if (result == null)
				result = caseDescribableElement(vpWorkProductDescriptor);
			if (result == null)
				result = caseMethodElement(vpWorkProductDescriptor);
			if (result == null)
				result = caseClassifier(vpWorkProductDescriptor);
			if (result == null)
				result = casePackageableElement(vpWorkProductDescriptor);
			if (result == null)
				result = caseType(vpWorkProductDescriptor);
			if (result == null)
				result = caseNamedElement(vpWorkProductDescriptor);
			if (result == null)
				result = caseElement(vpWorkProductDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VARIANT: {
			Variant variant = (Variant) theEObject;
			Object result = caseVariant(variant);
			if (result == null)
				result = caseVarElement(variant);
			if (result == null)
				result = caseVariability(variant);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VAR_ACTIVITY: {
			VarActivity varActivity = (VarActivity) theEObject;
			Object result = caseVarActivity(varActivity);
			if (result == null)
				result = caseActivity(varActivity);
			if (result == null)
				result = caseVariant(varActivity);
			if (result == null)
				result = caseWorkBreakdownElement(varActivity);
			if (result == null)
				result = caseVariabilityElement(varActivity);
			if (result == null)
				result = caseWorkDefinition(varActivity);
			if (result == null)
				result = caseVarElement(varActivity);
			if (result == null)
				result = caseBreakdownElement(varActivity);
			if (result == null)
				result = caseMethodElement(varActivity);
			if (result == null)
				result = caseVariability(varActivity);
			if (result == null)
				result = caseProcessElement(varActivity);
			if (result == null)
				result = casePackageableElement(varActivity);
			if (result == null)
				result = caseDescribableElement(varActivity);
			if (result == null)
				result = caseNamedElement(varActivity);
			if (result == null)
				result = caseClassifier(varActivity);
			if (result == null)
				result = caseElement(varActivity);
			if (result == null)
				result = caseType(varActivity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VAR_PHASE: {
			VarPhase varPhase = (VarPhase) theEObject;
			Object result = caseVarPhase(varPhase);
			if (result == null)
				result = casePhase(varPhase);
			if (result == null)
				result = caseVariant(varPhase);
			if (result == null)
				result = caseActivity(varPhase);
			if (result == null)
				result = caseVarElement(varPhase);
			if (result == null)
				result = caseWorkBreakdownElement(varPhase);
			if (result == null)
				result = caseVariabilityElement(varPhase);
			if (result == null)
				result = caseWorkDefinition(varPhase);
			if (result == null)
				result = caseVariability(varPhase);
			if (result == null)
				result = caseBreakdownElement(varPhase);
			if (result == null)
				result = caseMethodElement(varPhase);
			if (result == null)
				result = caseProcessElement(varPhase);
			if (result == null)
				result = casePackageableElement(varPhase);
			if (result == null)
				result = caseDescribableElement(varPhase);
			if (result == null)
				result = caseNamedElement(varPhase);
			if (result == null)
				result = caseClassifier(varPhase);
			if (result == null)
				result = caseElement(varPhase);
			if (result == null)
				result = caseType(varPhase);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VAR_ITERATION: {
			VarIteration varIteration = (VarIteration) theEObject;
			Object result = caseVarIteration(varIteration);
			if (result == null)
				result = caseIteration(varIteration);
			if (result == null)
				result = caseVariant(varIteration);
			if (result == null)
				result = caseActivity(varIteration);
			if (result == null)
				result = caseVarElement(varIteration);
			if (result == null)
				result = caseWorkBreakdownElement(varIteration);
			if (result == null)
				result = caseVariabilityElement(varIteration);
			if (result == null)
				result = caseWorkDefinition(varIteration);
			if (result == null)
				result = caseVariability(varIteration);
			if (result == null)
				result = caseBreakdownElement(varIteration);
			if (result == null)
				result = caseMethodElement(varIteration);
			if (result == null)
				result = caseProcessElement(varIteration);
			if (result == null)
				result = casePackageableElement(varIteration);
			if (result == null)
				result = caseDescribableElement(varIteration);
			if (result == null)
				result = caseNamedElement(varIteration);
			if (result == null)
				result = caseClassifier(varIteration);
			if (result == null)
				result = caseElement(varIteration);
			if (result == null)
				result = caseType(varIteration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VAR_ROLE_DESCRIPTOR: {
			VarRoleDescriptor varRoleDescriptor = (VarRoleDescriptor) theEObject;
			Object result = caseVarRoleDescriptor(varRoleDescriptor);
			if (result == null)
				result = caseRoleDescriptor(varRoleDescriptor);
			if (result == null)
				result = caseVariant(varRoleDescriptor);
			if (result == null)
				result = caseDescriptor(varRoleDescriptor);
			if (result == null)
				result = caseVarElement(varRoleDescriptor);
			if (result == null)
				result = caseBreakdownElement(varRoleDescriptor);
			if (result == null)
				result = caseVariability(varRoleDescriptor);
			if (result == null)
				result = caseProcessElement(varRoleDescriptor);
			if (result == null)
				result = caseDescribableElement(varRoleDescriptor);
			if (result == null)
				result = caseMethodElement(varRoleDescriptor);
			if (result == null)
				result = caseClassifier(varRoleDescriptor);
			if (result == null)
				result = casePackageableElement(varRoleDescriptor);
			if (result == null)
				result = caseType(varRoleDescriptor);
			if (result == null)
				result = caseNamedElement(varRoleDescriptor);
			if (result == null)
				result = caseElement(varRoleDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VAR_TASK_DESCRIPTOR: {
			VarTaskDescriptor varTaskDescriptor = (VarTaskDescriptor) theEObject;
			Object result = caseVarTaskDescriptor(varTaskDescriptor);
			if (result == null)
				result = caseTaskDescriptor(varTaskDescriptor);
			if (result == null)
				result = caseVariant(varTaskDescriptor);
			if (result == null)
				result = caseWorkBreakdownElement(varTaskDescriptor);
			if (result == null)
				result = caseDescriptor(varTaskDescriptor);
			if (result == null)
				result = caseVarElement(varTaskDescriptor);
			if (result == null)
				result = caseBreakdownElement(varTaskDescriptor);
			if (result == null)
				result = caseVariability(varTaskDescriptor);
			if (result == null)
				result = caseProcessElement(varTaskDescriptor);
			if (result == null)
				result = caseDescribableElement(varTaskDescriptor);
			if (result == null)
				result = caseMethodElement(varTaskDescriptor);
			if (result == null)
				result = caseClassifier(varTaskDescriptor);
			if (result == null)
				result = casePackageableElement(varTaskDescriptor);
			if (result == null)
				result = caseType(varTaskDescriptor);
			if (result == null)
				result = caseNamedElement(varTaskDescriptor);
			if (result == null)
				result = caseElement(varTaskDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VAR_MILESTONE: {
			VarMilestone varMilestone = (VarMilestone) theEObject;
			Object result = caseVarMilestone(varMilestone);
			if (result == null)
				result = caseMilestone(varMilestone);
			if (result == null)
				result = caseVariant(varMilestone);
			if (result == null)
				result = caseWorkBreakdownElement(varMilestone);
			if (result == null)
				result = caseVarElement(varMilestone);
			if (result == null)
				result = caseBreakdownElement(varMilestone);
			if (result == null)
				result = caseVariability(varMilestone);
			if (result == null)
				result = caseProcessElement(varMilestone);
			if (result == null)
				result = caseDescribableElement(varMilestone);
			if (result == null)
				result = caseMethodElement(varMilestone);
			if (result == null)
				result = caseClassifier(varMilestone);
			if (result == null)
				result = casePackageableElement(varMilestone);
			if (result == null)
				result = caseType(varMilestone);
			if (result == null)
				result = caseNamedElement(varMilestone);
			if (result == null)
				result = caseElement(varMilestone);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VAR_TEAM_PROFILE: {
			VarTeamProfile varTeamProfile = (VarTeamProfile) theEObject;
			Object result = caseVarTeamProfile(varTeamProfile);
			if (result == null)
				result = caseTeamProfile(varTeamProfile);
			if (result == null)
				result = caseVariant(varTeamProfile);
			if (result == null)
				result = caseBreakdownElement(varTeamProfile);
			if (result == null)
				result = caseVarElement(varTeamProfile);
			if (result == null)
				result = caseProcessElement(varTeamProfile);
			if (result == null)
				result = caseVariability(varTeamProfile);
			if (result == null)
				result = caseDescribableElement(varTeamProfile);
			if (result == null)
				result = caseMethodElement(varTeamProfile);
			if (result == null)
				result = caseClassifier(varTeamProfile);
			if (result == null)
				result = casePackageableElement(varTeamProfile);
			if (result == null)
				result = caseType(varTeamProfile);
			if (result == null)
				result = caseNamedElement(varTeamProfile);
			if (result == null)
				result = caseElement(varTeamProfile);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VAR_WORK_PRODUCT_DESCRIPTOR: {
			VarWorkProductDescriptor varWorkProductDescriptor = (VarWorkProductDescriptor) theEObject;
			Object result = caseVarWorkProductDescriptor(varWorkProductDescriptor);
			if (result == null)
				result = caseWorkProductDescriptor(varWorkProductDescriptor);
			if (result == null)
				result = caseVariant(varWorkProductDescriptor);
			if (result == null)
				result = caseDescriptor(varWorkProductDescriptor);
			if (result == null)
				result = caseVarElement(varWorkProductDescriptor);
			if (result == null)
				result = caseBreakdownElement(varWorkProductDescriptor);
			if (result == null)
				result = caseVariability(varWorkProductDescriptor);
			if (result == null)
				result = caseProcessElement(varWorkProductDescriptor);
			if (result == null)
				result = caseDescribableElement(varWorkProductDescriptor);
			if (result == null)
				result = caseMethodElement(varWorkProductDescriptor);
			if (result == null)
				result = caseClassifier(varWorkProductDescriptor);
			if (result == null)
				result = casePackageableElement(varWorkProductDescriptor);
			if (result == null)
				result = caseType(varWorkProductDescriptor);
			if (result == null)
				result = caseNamedElement(varWorkProductDescriptor);
			if (result == null)
				result = caseElement(varWorkProductDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.ACTIVITY: {
			Activity activity = (Activity) theEObject;
			Object result = caseActivity(activity);
			if (result == null)
				result = caseWorkBreakdownElement(activity);
			if (result == null)
				result = caseVariabilityElement(activity);
			if (result == null)
				result = caseWorkDefinition(activity);
			if (result == null)
				result = caseBreakdownElement(activity);
			if (result == null)
				result = caseMethodElement(activity);
			if (result == null)
				result = caseVariability(activity);
			if (result == null)
				result = caseProcessElement(activity);
			if (result == null)
				result = casePackageableElement(activity);
			if (result == null)
				result = caseDescribableElement(activity);
			if (result == null)
				result = caseNamedElement(activity);
			if (result == null)
				result = caseClassifier(activity);
			if (result == null)
				result = caseElement(activity);
			if (result == null)
				result = caseType(activity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROC_ASPECT: {
			ProcAspect procAspect = (ProcAspect) theEObject;
			Object result = caseProcAspect(procAspect);
			if (result == null)
				result = caseVarElement(procAspect);
			if (result == null)
				result = caseVariation(procAspect);
			if (result == null)
				result = caseVariability(procAspect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VARIANTS_LIST_PACKAGE: {
			VariantsListPackage variantsListPackage = (VariantsListPackage) theEObject;
			Object result = caseVariantsListPackage(variantsListPackage);
			if (result == null)
				result = caseContentCategory(variantsListPackage);
			if (result == null)
				result = caseContentElement(variantsListPackage);
			if (result == null)
				result = caseDescribableElement(variantsListPackage);
			if (result == null)
				result = caseVariabilityElement(variantsListPackage);
			if (result == null)
				result = caseMethodElement(variantsListPackage);
			if (result == null)
				result = caseClassifier(variantsListPackage);
			if (result == null)
				result = caseVariability(variantsListPackage);
			if (result == null)
				result = casePackageableElement(variantsListPackage);
			if (result == null)
				result = caseType(variantsListPackage);
			if (result == null)
				result = caseNamedElement(variantsListPackage);
			if (result == null)
				result = caseElement(variantsListPackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VARIANTS_PACKAGE: {
			VariantsPackage variantsPackage = (VariantsPackage) theEObject;
			Object result = caseVariantsPackage(variantsPackage);
			if (result == null)
				result = caseMethodPackage(variantsPackage);
			if (result == null)
				result = caseMethodElement(variantsPackage);
			if (result == null)
				result = casePackage(variantsPackage);
			if (result == null)
				result = casePackageableElement(variantsPackage);
			if (result == null)
				result = caseNamespace(variantsPackage);
			if (result == null)
				result = caseNamedElement(variantsPackage);
			if (result == null)
				result = caseElement(variantsPackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VAR_POINTS_PACKAGE: {
			VarPointsPackage varPointsPackage = (VarPointsPackage) theEObject;
			Object result = caseVarPointsPackage(varPointsPackage);
			if (result == null)
				result = caseMethodPackage(varPointsPackage);
			if (result == null)
				result = caseMethodElement(varPointsPackage);
			if (result == null)
				result = casePackage(varPointsPackage);
			if (result == null)
				result = casePackageableElement(varPointsPackage);
			if (result == null)
				result = caseNamespace(varPointsPackage);
			if (result == null)
				result = caseNamedElement(varPointsPackage);
			if (result == null)
				result = caseElement(varPointsPackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VARIATIONS_PACKAGE: {
			VariationsPackage variationsPackage = (VariationsPackage) theEObject;
			Object result = caseVariationsPackage(variationsPackage);
			if (result == null)
				result = caseMethodPackage(variationsPackage);
			if (result == null)
				result = caseMethodElement(variationsPackage);
			if (result == null)
				result = casePackage(variationsPackage);
			if (result == null)
				result = casePackageableElement(variationsPackage);
			if (result == null)
				result = caseNamespace(variationsPackage);
			if (result == null)
				result = caseNamedElement(variationsPackage);
			if (result == null)
				result = caseElement(variationsPackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VARIATION: {
			Variation variation = (Variation) theEObject;
			Object result = caseVariation(variation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VARIATION_TYPE: {
			VariationType variationType = (VariationType) theEObject;
			Object result = caseVariationType(variationType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.OCCUPATION: {
			Occupation occupation = (Occupation) theEObject;
			Object result = caseOccupation(occupation);
			if (result == null)
				result = caseVariation(occupation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROC_ADVICE: {
			ProcAdvice procAdvice = (ProcAdvice) theEObject;
			Object result = caseProcAdvice(procAdvice);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROC_POINTCUT: {
			ProcPointcut procPointcut = (ProcPointcut) theEObject;
			Object result = caseProcPointcut(procPointcut);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.DEPENDENCES: {
			Dependences dependences = (Dependences) theEObject;
			Object result = caseDependences(dependences);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VARIANT2VAR_P: {
			variant2varP variant2varP = (variant2varP) theEObject;
			Object result = casevariant2varP(variant2varP);
			if (result == null)
				result = caseDependences(variant2varP);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VARIANT2VARIANT: {
			variant2variant variant2variant = (variant2variant) theEObject;
			Object result = casevariant2variant(variant2variant);
			if (result == null)
				result = caseDependences(variant2variant);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VARP2VARIANT: {
			varp2variant varp2variant = (varp2variant) theEObject;
			Object result = casevarp2variant(varp2variant);
			if (result == null)
				result = caseDependences(varp2variant);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VAR_P2VAR_P: {
			varP2varP varP2varP = (varP2varP) theEObject;
			Object result = casevarP2varP(varP2varP);
			if (result == null)
				result = caseDependences(varP2varP);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.PROCESS_LINE: {
			ProcessLine processLine = (ProcessLine) theEObject;
			Object result = caseProcessLine(processLine);
			if (result == null)
				result = caseProcessPackage(processLine);
			if (result == null)
				result = caseMethodPackage(processLine);
			if (result == null)
				result = caseMethodElement(processLine);
			if (result == null)
				result = casePackage(processLine);
			if (result == null)
				result = casePackageableElement(processLine);
			if (result == null)
				result = caseNamespace(processLine);
			if (result == null)
				result = caseNamedElement(processLine);
			if (result == null)
				result = caseElement(processLine);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.OPTATIVE: {
			Optative optative = (Optative) theEObject;
			Object result = caseOptative(optative);
			if (result == null)
				result = caseVariationType(optative);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.MANDATORY: {
			Mandatory mandatory = (Mandatory) theEObject;
			Object result = caseMandatory(mandatory);
			if (result == null)
				result = caseVariationType(mandatory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.OPTIONAL: {
			Optional optional = (Optional) theEObject;
			Object result = caseOptional(optional);
			if (result == null)
				result = caseVariationType(optional);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VITERATION: {
			vIteration vIteration = (vIteration) theEObject;
			Object result = casevIteration(vIteration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VPHASE: {
			vPhase vPhase = (vPhase) theEObject;
			Object result = casevPhase(vPhase);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmaPackage.VACTIVITY: {
			vActivity vActivity = (vActivity) theEObject;
			Object result = casevActivity(vActivity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseClassifier(Classifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Packageable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Packageable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePackageableElement(PackageableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePackage(org.eclipse.epf.uma.Package object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNamespace(Namespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMethodElement(MethodElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Element Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Element Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMethodElementProperty(MethodElementProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Content Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Content Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseContentElement(ContentElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Describable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Describable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDescribableElement(DescribableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Content Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Content Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseContentDescription(ContentDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSection(Section object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRole(Role object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Work Product</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Work Product</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWorkProduct(WorkProduct object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTask(Task object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Work Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Work Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWorkDefinition(WorkDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStep(Step object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guidance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guidance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGuidance(Guidance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Artifact</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArtifact(Artifact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deliverable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deliverable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeliverable(Deliverable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Outcome</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Outcome</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOutcome(Outcome object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMethodPackage(MethodPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Content Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Content Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseContentPackage(ContentPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Artifact Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Artifact Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArtifactDescription(ArtifactDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Work Product Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Work Product Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWorkProductDescription(WorkProductDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deliverable Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deliverable Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeliverableDescription(DeliverableDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRoleDescription(RoleDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTaskDescription(TaskDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guidance Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guidance Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGuidanceDescription(GuidanceDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Practice Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Practice Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePracticeDescription(PracticeDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePoint(Point object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGraphElement(GraphElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDiagramElement(DiagramElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDiagramLink(DiagramLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGraphConnector(GraphConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantic Model Bridge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic Model Bridge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSemanticModelBridge(SemanticModelBridge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDimension(Dimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseReference(Reference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGraphEdge(GraphEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDiagram(Diagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGraphNode(GraphNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Semantic Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Semantic Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSimpleSemanticModelElement(
			SimpleSemanticModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UMA Semantic Model Bridge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UMA Semantic Model Bridge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUMASemanticModelBridge(UMASemanticModelBridge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Semantic Model Bridge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Semantic Model Bridge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCoreSemanticModelBridge(CoreSemanticModelBridge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Leaf Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Leaf Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLeafElement(LeafElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTextElement(TextElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseImage(Image object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphic Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphic Primitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGraphicPrimitive(GraphicPrimitive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Polyline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Polyline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePolyline(Polyline object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ellipse</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ellipse</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEllipse(Ellipse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseActivity(Activity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Work Breakdown Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Work Breakdown Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWorkBreakdownElement(WorkBreakdownElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Breakdown Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Breakdown Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBreakdownElement(BreakdownElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Milestone</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Milestone</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMilestone(Milestone object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iteration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iteration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIteration(Iteration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Phase</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Phase</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePhase(Phase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Team Profile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Team Profile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTeamProfile(TeamProfile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRoleDescriptor(RoleDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Work Order</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Work Order</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWorkOrder(WorkOrder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessElement(ProcessElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Planning Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Planning Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePlanningData(PlanningData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDescriptor(Descriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTaskDescriptor(TaskDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Work Product Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Work Product Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWorkProductDescriptor(WorkProductDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCompositeRole(CompositeRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Breakdown Element Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Breakdown Element Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBreakdownElementDescription(
			BreakdownElementDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseActivityDescription(ActivityDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delivery Process Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delivery Process Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeliveryProcessDescription(
			DeliveryProcessDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessDescription(ProcessDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descriptor Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptor Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDescriptorDescription(DescriptorDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConcept(Concept object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Checklist</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Checklist</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseChecklist(Checklist object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Example</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Example</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExample(Example object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guideline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guideline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGuideline(Guideline object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Estimation Considerations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Estimation Considerations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEstimationConsiderations(EstimationConsiderations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseReport(Report object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTemplate(Template object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Supporting Material</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Supporting Material</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSupportingMaterial(SupportingMaterial object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tool Mentor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tool Mentor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseToolMentor(ToolMentor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Whitepaper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Whitepaper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWhitepaper(Whitepaper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Term Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Term Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTermDefinition(TermDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Practice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Practice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePractice(Practice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reusable Asset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reusable Asset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseReusableAsset(ReusableAsset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseState(State object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vertex</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vertex</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVertex(Vertex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRegion(Region object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Machine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStateMachine(StateMachine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTransition(Transition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pseudo State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pseudo State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePseudoState(PseudoState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Discipline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Discipline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDiscipline(Discipline object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Content Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Content Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseContentCategory(ContentCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRoleSet(RoleSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDomain(Domain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pruebas Lineas</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pruebas Lineas</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePruebasLineas(PruebasLineas object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Work Product Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Work Product Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWorkProductType(WorkProductType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Discipline Grouping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Discipline Grouping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDisciplineGrouping(DisciplineGrouping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTool(Tool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role Set Grouping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role Set Grouping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRoleSetGrouping(RoleSetGrouping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCustomCategory(CustomCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delivery Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delivery Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeliveryProcess(DeliveryProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcess(org.eclipse.epf.uma.Process object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapabilityPattern(CapabilityPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Planning Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Planning Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessPlanningTemplate(ProcessPlanningTemplate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Roadmap</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Roadmap</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRoadmap(Roadmap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessComponent(ProcessComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessPackage(ProcessPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Component Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Component Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessComponentInterface(ProcessComponentInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Component Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Component Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessComponentDescriptor(
			ProcessComponentDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Plugin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Plugin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMethodPlugin(MethodPlugin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Lines Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Lines Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessLinesPackage(ProcessLinesPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Line Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Line Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessLineElement(ProcessLineElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Line Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Line Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessLineComponent(ProcessLineComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Line Component Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Line Component Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessLineComponentPackage(
			ProcessLineComponentPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Line Component Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Line Component Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessLineComponentInterface(
			ProcessLineComponentInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Process Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Process Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCoreProcessPackage(CoreProcessPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tailored Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tailored Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTailoredProcess(TailoredProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tailored Processes Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tailored Processes Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTailoredProcessesPackage(TailoredProcessesPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tailored Process Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tailored Process Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTailoredProcessComponent(TailoredProcessComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tailored Core Process Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tailored Core Process Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTailoredCoreProcessPackage(
			TailoredCoreProcessPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variations Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variations Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariationsPackage(VariationsPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variants Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variants Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariantsPackage(VariantsPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Points Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Points Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVarPointsPackage(VarPointsPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLineProcess(LineProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variability Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variability Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariabilityElement(VariabilityElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMethodUnit(MethodUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMethodConfiguration(MethodConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Family</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Family</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessFamily(ProcessFamily object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMethodLibrary(MethodLibrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariability(Variability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVarElement(VarElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVarPoint(VarPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariant(Variant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVarActivity(VarActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Phase</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Phase</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVarPhase(VarPhase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Iteration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Iteration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVarIteration(VarIteration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Role Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Role Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVarRoleDescriptor(VarRoleDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Task Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Task Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVarTaskDescriptor(VarTaskDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Milestone</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Milestone</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVarMilestone(VarMilestone object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Team Profile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Team Profile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVarTeamProfile(VarTeamProfile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Work Product Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Work Product Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVarWorkProductDescriptor(VarWorkProductDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proc Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proc Aspect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcAspect(ProcAspect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variants List Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variants List Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariantsListPackage(VariantsListPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariation(Variation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Occupation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Occupation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOccupation(Occupation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proc Advice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proc Advice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcAdvice(ProcAdvice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proc Pointcut</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proc Pointcut</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcPointcut(ProcPointcut object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependences</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependences</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDependences(Dependences object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant2var P</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant2var P</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevariant2varP(variant2varP object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant2variant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant2variant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevariant2variant(variant2variant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>varp2variant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>varp2variant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevarp2variant(varp2variant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>var P2var P</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>var P2var P</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevarP2varP(varP2varP object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Line</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Line</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessLine(ProcessLine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariationType(VariationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Optative</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Optative</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOptative(Optative object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mandatory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mandatory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMandatory(Mandatory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Optional</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Optional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOptional(Optional object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>vp Iteration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>vp Iteration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevpIteration(vpIteration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>vp Role Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>vp Role Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevpRoleDescriptor(vpRoleDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>vp Task Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>vp Task Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevpTaskDescriptor(vpTaskDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>vp Milestone</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>vp Milestone</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevpMilestone(vpMilestone object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>vp Team Profile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>vp Team Profile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevpTeamProfile(vpTeamProfile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>vp Work Product Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>vp Work Product Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevpWorkProductDescriptor(vpWorkProductDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>vIteration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>vIteration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevIteration(vIteration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>vPhase</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>vPhase</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevPhase(vPhase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>vp Phase</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>vp Phase</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevpPhase(vpPhase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>vActivity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>vActivity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevActivity(vActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>vp Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>vp Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casevpActivity(vpActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //UmaSwitch