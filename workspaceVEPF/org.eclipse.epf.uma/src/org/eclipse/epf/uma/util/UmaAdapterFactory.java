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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.epf.uma.UmaPackage
 * @generated
 */
public class UmaAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UmaPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmaAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UmaPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UmaSwitch modelSwitch = new UmaSwitch() {
		public Object caseClassifier(Classifier object) {
			return createClassifierAdapter();
		}

		public Object caseType(Type object) {
			return createTypeAdapter();
		}

		public Object caseElement(Element object) {
			return createElementAdapter();
		}

		public Object caseNamedElement(NamedElement object) {
			return createNamedElementAdapter();
		}

		public Object casePackageableElement(PackageableElement object) {
			return createPackageableElementAdapter();
		}

		public Object casePackage(org.eclipse.epf.uma.Package object) {
			return createPackageAdapter();
		}

		public Object caseNamespace(Namespace object) {
			return createNamespaceAdapter();
		}

		public Object caseMethodElement(MethodElement object) {
			return createMethodElementAdapter();
		}

		public Object caseConstraint(Constraint object) {
			return createConstraintAdapter();
		}

		public Object caseMethodElementProperty(MethodElementProperty object) {
			return createMethodElementPropertyAdapter();
		}

		public Object caseContentElement(ContentElement object) {
			return createContentElementAdapter();
		}

		public Object caseDescribableElement(DescribableElement object) {
			return createDescribableElementAdapter();
		}

		public Object caseContentDescription(ContentDescription object) {
			return createContentDescriptionAdapter();
		}

		public Object caseSection(Section object) {
			return createSectionAdapter();
		}

		public Object caseRole(Role object) {
			return createRoleAdapter();
		}

		public Object caseWorkProduct(WorkProduct object) {
			return createWorkProductAdapter();
		}

		public Object caseTask(Task object) {
			return createTaskAdapter();
		}

		public Object caseWorkDefinition(WorkDefinition object) {
			return createWorkDefinitionAdapter();
		}

		public Object caseStep(Step object) {
			return createStepAdapter();
		}

		public Object caseGuidance(Guidance object) {
			return createGuidanceAdapter();
		}

		public Object caseArtifact(Artifact object) {
			return createArtifactAdapter();
		}

		public Object caseDeliverable(Deliverable object) {
			return createDeliverableAdapter();
		}

		public Object caseOutcome(Outcome object) {
			return createOutcomeAdapter();
		}

		public Object caseMethodPackage(MethodPackage object) {
			return createMethodPackageAdapter();
		}

		public Object caseContentPackage(ContentPackage object) {
			return createContentPackageAdapter();
		}

		public Object caseArtifactDescription(ArtifactDescription object) {
			return createArtifactDescriptionAdapter();
		}

		public Object caseWorkProductDescription(WorkProductDescription object) {
			return createWorkProductDescriptionAdapter();
		}

		public Object caseDeliverableDescription(DeliverableDescription object) {
			return createDeliverableDescriptionAdapter();
		}

		public Object caseRoleDescription(RoleDescription object) {
			return createRoleDescriptionAdapter();
		}

		public Object caseTaskDescription(TaskDescription object) {
			return createTaskDescriptionAdapter();
		}

		public Object caseGuidanceDescription(GuidanceDescription object) {
			return createGuidanceDescriptionAdapter();
		}

		public Object casePracticeDescription(PracticeDescription object) {
			return createPracticeDescriptionAdapter();
		}

		public Object casePoint(Point object) {
			return createPointAdapter();
		}

		public Object caseGraphElement(GraphElement object) {
			return createGraphElementAdapter();
		}

		public Object caseDiagramElement(DiagramElement object) {
			return createDiagramElementAdapter();
		}

		public Object caseDiagramLink(DiagramLink object) {
			return createDiagramLinkAdapter();
		}

		public Object caseGraphConnector(GraphConnector object) {
			return createGraphConnectorAdapter();
		}

		public Object caseSemanticModelBridge(SemanticModelBridge object) {
			return createSemanticModelBridgeAdapter();
		}

		public Object caseDimension(Dimension object) {
			return createDimensionAdapter();
		}

		public Object caseReference(Reference object) {
			return createReferenceAdapter();
		}

		public Object caseProperty(Property object) {
			return createPropertyAdapter();
		}

		public Object caseGraphEdge(GraphEdge object) {
			return createGraphEdgeAdapter();
		}

		public Object caseDiagram(Diagram object) {
			return createDiagramAdapter();
		}

		public Object caseGraphNode(GraphNode object) {
			return createGraphNodeAdapter();
		}

		public Object caseSimpleSemanticModelElement(
				SimpleSemanticModelElement object) {
			return createSimpleSemanticModelElementAdapter();
		}

		public Object caseUMASemanticModelBridge(UMASemanticModelBridge object) {
			return createUMASemanticModelBridgeAdapter();
		}

		public Object caseCoreSemanticModelBridge(CoreSemanticModelBridge object) {
			return createCoreSemanticModelBridgeAdapter();
		}

		public Object caseLeafElement(LeafElement object) {
			return createLeafElementAdapter();
		}

		public Object caseTextElement(TextElement object) {
			return createTextElementAdapter();
		}

		public Object caseImage(Image object) {
			return createImageAdapter();
		}

		public Object caseGraphicPrimitive(GraphicPrimitive object) {
			return createGraphicPrimitiveAdapter();
		}

		public Object casePolyline(Polyline object) {
			return createPolylineAdapter();
		}

		public Object caseEllipse(Ellipse object) {
			return createEllipseAdapter();
		}

		public Object caseWorkBreakdownElement(WorkBreakdownElement object) {
			return createWorkBreakdownElementAdapter();
		}

		public Object caseBreakdownElement(BreakdownElement object) {
			return createBreakdownElementAdapter();
		}

		public Object caseMilestone(Milestone object) {
			return createMilestoneAdapter();
		}

		public Object caseIteration(Iteration object) {
			return createIterationAdapter();
		}

		public Object casePhase(Phase object) {
			return createPhaseAdapter();
		}

		public Object caseTeamProfile(TeamProfile object) {
			return createTeamProfileAdapter();
		}

		public Object caseRoleDescriptor(RoleDescriptor object) {
			return createRoleDescriptorAdapter();
		}

		public Object caseWorkOrder(WorkOrder object) {
			return createWorkOrderAdapter();
		}

		public Object casePlanningData(PlanningData object) {
			return createPlanningDataAdapter();
		}

		public Object caseDescriptor(Descriptor object) {
			return createDescriptorAdapter();
		}

		public Object caseWorkProductDescriptor(WorkProductDescriptor object) {
			return createWorkProductDescriptorAdapter();
		}

		public Object caseTaskDescriptor(TaskDescriptor object) {
			return createTaskDescriptorAdapter();
		}

		public Object caseCompositeRole(CompositeRole object) {
			return createCompositeRoleAdapter();
		}

		public Object caseBreakdownElementDescription(
				BreakdownElementDescription object) {
			return createBreakdownElementDescriptionAdapter();
		}

		public Object caseActivityDescription(ActivityDescription object) {
			return createActivityDescriptionAdapter();
		}

		public Object caseDeliveryProcessDescription(
				DeliveryProcessDescription object) {
			return createDeliveryProcessDescriptionAdapter();
		}

		public Object caseProcessDescription(ProcessDescription object) {
			return createProcessDescriptionAdapter();
		}

		public Object caseDescriptorDescription(DescriptorDescription object) {
			return createDescriptorDescriptionAdapter();
		}

		public Object caseConcept(Concept object) {
			return createConceptAdapter();
		}

		public Object caseChecklist(Checklist object) {
			return createChecklistAdapter();
		}

		public Object caseExample(Example object) {
			return createExampleAdapter();
		}

		public Object caseGuideline(Guideline object) {
			return createGuidelineAdapter();
		}

		public Object caseReport(Report object) {
			return createReportAdapter();
		}

		public Object caseTemplate(Template object) {
			return createTemplateAdapter();
		}

		public Object caseSupportingMaterial(SupportingMaterial object) {
			return createSupportingMaterialAdapter();
		}

		public Object caseToolMentor(ToolMentor object) {
			return createToolMentorAdapter();
		}

		public Object caseWhitepaper(Whitepaper object) {
			return createWhitepaperAdapter();
		}

		public Object caseTermDefinition(TermDefinition object) {
			return createTermDefinitionAdapter();
		}

		public Object casePractice(Practice object) {
			return createPracticeAdapter();
		}

		public Object caseEstimationConsiderations(
				EstimationConsiderations object) {
			return createEstimationConsiderationsAdapter();
		}

		public Object caseReusableAsset(ReusableAsset object) {
			return createReusableAssetAdapter();
		}

		public Object caseState(State object) {
			return createStateAdapter();
		}

		public Object caseVertex(Vertex object) {
			return createVertexAdapter();
		}

		public Object caseRegion(Region object) {
			return createRegionAdapter();
		}

		public Object caseStateMachine(StateMachine object) {
			return createStateMachineAdapter();
		}

		public Object caseTransition(Transition object) {
			return createTransitionAdapter();
		}

		public Object casePseudoState(PseudoState object) {
			return createPseudoStateAdapter();
		}

		public Object caseDiscipline(Discipline object) {
			return createDisciplineAdapter();
		}

		public Object caseContentCategory(ContentCategory object) {
			return createContentCategoryAdapter();
		}

		public Object caseRoleSet(RoleSet object) {
			return createRoleSetAdapter();
		}

		public Object caseDomain(Domain object) {
			return createDomainAdapter();
		}

		public Object casePruebasLineas(PruebasLineas object) {
			return createPruebasLineasAdapter();
		}

		public Object caseWorkProductType(WorkProductType object) {
			return createWorkProductTypeAdapter();
		}

		public Object caseDisciplineGrouping(DisciplineGrouping object) {
			return createDisciplineGroupingAdapter();
		}

		public Object caseTool(Tool object) {
			return createToolAdapter();
		}

		public Object caseRoleSetGrouping(RoleSetGrouping object) {
			return createRoleSetGroupingAdapter();
		}

		public Object caseCustomCategory(CustomCategory object) {
			return createCustomCategoryAdapter();
		}

		public Object caseDeliveryProcess(DeliveryProcess object) {
			return createDeliveryProcessAdapter();
		}

		public Object caseProcess(org.eclipse.epf.uma.Process object) {
			return createProcessAdapter();
		}

		public Object caseCapabilityPattern(CapabilityPattern object) {
			return createCapabilityPatternAdapter();
		}

		public Object caseProcessPlanningTemplate(ProcessPlanningTemplate object) {
			return createProcessPlanningTemplateAdapter();
		}

		public Object caseRoadmap(Roadmap object) {
			return createRoadmapAdapter();
		}

		public Object caseProcessComponent(ProcessComponent object) {
			return createProcessComponentAdapter();
		}

		public Object caseProcessPackage(ProcessPackage object) {
			return createProcessPackageAdapter();
		}

		public Object caseProcessElement(ProcessElement object) {
			return createProcessElementAdapter();
		}

		public Object caseProcessComponentInterface(
				ProcessComponentInterface object) {
			return createProcessComponentInterfaceAdapter();
		}

		public Object caseProcessComponentDescriptor(
				ProcessComponentDescriptor object) {
			return createProcessComponentDescriptorAdapter();
		}

		public Object caseMethodPlugin(MethodPlugin object) {
			return createMethodPluginAdapter();
		}

		public Object caseLineProcess(LineProcess object) {
			return createLineProcessAdapter();
		}

		public Object caseProcessLinesPackage(ProcessLinesPackage object) {
			return createProcessLinesPackageAdapter();
		}

		public Object caseProcessLineElement(ProcessLineElement object) {
			return createProcessLineElementAdapter();
		}

		public Object caseProcessLineComponent(ProcessLineComponent object) {
			return createProcessLineComponentAdapter();
		}

		public Object caseProcessLineComponentPackage(
				ProcessLineComponentPackage object) {
			return createProcessLineComponentPackageAdapter();
		}

		public Object caseProcessLineComponentInterface(
				ProcessLineComponentInterface object) {
			return createProcessLineComponentInterfaceAdapter();
		}

		public Object caseCoreProcessPackage(CoreProcessPackage object) {
			return createCoreProcessPackageAdapter();
		}

		public Object caseTailoredProcess(TailoredProcess object) {
			return createTailoredProcessAdapter();
		}

		public Object caseTailoredProcessesPackage(
				TailoredProcessesPackage object) {
			return createTailoredProcessesPackageAdapter();
		}

		public Object caseTailoredProcessComponent(
				TailoredProcessComponent object) {
			return createTailoredProcessComponentAdapter();
		}

		public Object caseTailoredCoreProcessPackage(
				TailoredCoreProcessPackage object) {
			return createTailoredCoreProcessPackageAdapter();
		}

		public Object caseVariabilityElement(VariabilityElement object) {
			return createVariabilityElementAdapter();
		}

		public Object caseMethodUnit(MethodUnit object) {
			return createMethodUnitAdapter();
		}

		public Object caseMethodConfiguration(MethodConfiguration object) {
			return createMethodConfigurationAdapter();
		}

		public Object caseProcessFamily(ProcessFamily object) {
			return createProcessFamilyAdapter();
		}

		public Object caseMethodLibrary(MethodLibrary object) {
			return createMethodLibraryAdapter();
		}

		public Object caseVariability(Variability object) {
			return createVariabilityAdapter();
		}

		public Object caseVarElement(VarElement object) {
			return createVarElementAdapter();
		}

		public Object caseVarPoint(VarPoint object) {
			return createVarPointAdapter();
		}

		public Object casevpActivity(vpActivity object) {
			return createvpActivityAdapter();
		}

		public Object casevpPhase(vpPhase object) {
			return createvpPhaseAdapter();
		}

		public Object casevpIteration(vpIteration object) {
			return createvpIterationAdapter();
		}

		public Object casevpRoleDescriptor(vpRoleDescriptor object) {
			return createvpRoleDescriptorAdapter();
		}

		public Object casevpTaskDescriptor(vpTaskDescriptor object) {
			return createvpTaskDescriptorAdapter();
		}

		public Object casevpMilestone(vpMilestone object) {
			return createvpMilestoneAdapter();
		}

		public Object casevpTeamProfile(vpTeamProfile object) {
			return createvpTeamProfileAdapter();
		}

		public Object casevpWorkProductDescriptor(vpWorkProductDescriptor object) {
			return createvpWorkProductDescriptorAdapter();
		}

		public Object caseVariant(Variant object) {
			return createVariantAdapter();
		}

		public Object caseVarActivity(VarActivity object) {
			return createVarActivityAdapter();
		}

		public Object caseVarPhase(VarPhase object) {
			return createVarPhaseAdapter();
		}

		public Object caseVarIteration(VarIteration object) {
			return createVarIterationAdapter();
		}

		public Object caseVarRoleDescriptor(VarRoleDescriptor object) {
			return createVarRoleDescriptorAdapter();
		}

		public Object caseVarTaskDescriptor(VarTaskDescriptor object) {
			return createVarTaskDescriptorAdapter();
		}

		public Object caseVarMilestone(VarMilestone object) {
			return createVarMilestoneAdapter();
		}

		public Object caseVarTeamProfile(VarTeamProfile object) {
			return createVarTeamProfileAdapter();
		}

		public Object caseVarWorkProductDescriptor(
				VarWorkProductDescriptor object) {
			return createVarWorkProductDescriptorAdapter();
		}

		public Object caseActivity(Activity object) {
			return createActivityAdapter();
		}

		public Object caseProcAspect(ProcAspect object) {
			return createProcAspectAdapter();
		}

		public Object caseVariantsListPackage(VariantsListPackage object) {
			return createVariantsListPackageAdapter();
		}

		public Object caseVariantsPackage(VariantsPackage object) {
			return createVariantsPackageAdapter();
		}

		public Object caseVarPointsPackage(VarPointsPackage object) {
			return createVarPointsPackageAdapter();
		}

		public Object caseVariationsPackage(VariationsPackage object) {
			return createVariationsPackageAdapter();
		}

		public Object caseVariation(Variation object) {
			return createVariationAdapter();
		}

		public Object caseVariationType(VariationType object) {
			return createVariationTypeAdapter();
		}

		public Object caseOccupation(Occupation object) {
			return createOccupationAdapter();
		}

		public Object caseProcAdvice(ProcAdvice object) {
			return createProcAdviceAdapter();
		}

		public Object caseProcPointcut(ProcPointcut object) {
			return createProcPointcutAdapter();
		}

		public Object caseDependences(Dependences object) {
			return createDependencesAdapter();
		}

		public Object casevariant2varP(variant2varP object) {
			return createvariant2varPAdapter();
		}

		public Object casevariant2variant(variant2variant object) {
			return createvariant2variantAdapter();
		}

		public Object casevarp2variant(varp2variant object) {
			return createvarp2variantAdapter();
		}

		public Object casevarP2varP(varP2varP object) {
			return createvarP2varPAdapter();
		}

		public Object caseProcessLine(ProcessLine object) {
			return createProcessLineAdapter();
		}

		public Object caseOptative(Optative object) {
			return createOptativeAdapter();
		}

		public Object caseMandatory(Mandatory object) {
			return createMandatoryAdapter();
		}

		public Object caseOptional(Optional object) {
			return createOptionalAdapter();
		}

		public Object casevIteration(vIteration object) {
			return createvIterationAdapter();
		}

		public Object casevPhase(vPhase object) {
			return createvPhaseAdapter();
		}

		public Object casevActivity(vActivity object) {
			return createvActivityAdapter();
		}

		public Object defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter) modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Classifier
	 * @generated
	 */
	public Adapter createClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.PackageableElement <em>Packageable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.PackageableElement
	 * @generated
	 */
	public Adapter createPackageableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Package
	 * @generated
	 */
	public Adapter createPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Namespace
	 * @generated
	 */
	public Adapter createNamespaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.MethodElement <em>Method Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.MethodElement
	 * @generated
	 */
	public Adapter createMethodElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.MethodElementProperty <em>Method Element Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.MethodElementProperty
	 * @generated
	 */
	public Adapter createMethodElementPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ContentElement <em>Content Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ContentElement
	 * @generated
	 */
	public Adapter createContentElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.DescribableElement <em>Describable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.DescribableElement
	 * @generated
	 */
	public Adapter createDescribableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ContentDescription <em>Content Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ContentDescription
	 * @generated
	 */
	public Adapter createContentDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Section <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Section
	 * @generated
	 */
	public Adapter createSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Role
	 * @generated
	 */
	public Adapter createRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.WorkProduct <em>Work Product</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.WorkProduct
	 * @generated
	 */
	public Adapter createWorkProductAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Task
	 * @generated
	 */
	public Adapter createTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.WorkDefinition <em>Work Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.WorkDefinition
	 * @generated
	 */
	public Adapter createWorkDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Step <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Step
	 * @generated
	 */
	public Adapter createStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Guidance <em>Guidance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Guidance
	 * @generated
	 */
	public Adapter createGuidanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Artifact <em>Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Artifact
	 * @generated
	 */
	public Adapter createArtifactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Deliverable <em>Deliverable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Deliverable
	 * @generated
	 */
	public Adapter createDeliverableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Outcome <em>Outcome</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Outcome
	 * @generated
	 */
	public Adapter createOutcomeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.MethodPackage <em>Method Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.MethodPackage
	 * @generated
	 */
	public Adapter createMethodPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ContentPackage <em>Content Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ContentPackage
	 * @generated
	 */
	public Adapter createContentPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ArtifactDescription <em>Artifact Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ArtifactDescription
	 * @generated
	 */
	public Adapter createArtifactDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.WorkProductDescription <em>Work Product Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.WorkProductDescription
	 * @generated
	 */
	public Adapter createWorkProductDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.DeliverableDescription <em>Deliverable Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.DeliverableDescription
	 * @generated
	 */
	public Adapter createDeliverableDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.RoleDescription <em>Role Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.RoleDescription
	 * @generated
	 */
	public Adapter createRoleDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.TaskDescription <em>Task Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.TaskDescription
	 * @generated
	 */
	public Adapter createTaskDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.GuidanceDescription <em>Guidance Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.GuidanceDescription
	 * @generated
	 */
	public Adapter createGuidanceDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.PracticeDescription <em>Practice Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.PracticeDescription
	 * @generated
	 */
	public Adapter createPracticeDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Point
	 * @generated
	 */
	public Adapter createPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.GraphElement <em>Graph Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.GraphElement
	 * @generated
	 */
	public Adapter createGraphElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.DiagramElement <em>Diagram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.DiagramElement
	 * @generated
	 */
	public Adapter createDiagramElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.DiagramLink <em>Diagram Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.DiagramLink
	 * @generated
	 */
	public Adapter createDiagramLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.GraphConnector <em>Graph Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.GraphConnector
	 * @generated
	 */
	public Adapter createGraphConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.SemanticModelBridge <em>Semantic Model Bridge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.SemanticModelBridge
	 * @generated
	 */
	public Adapter createSemanticModelBridgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Dimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Dimension
	 * @generated
	 */
	public Adapter createDimensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Reference
	 * @generated
	 */
	public Adapter createReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.GraphEdge <em>Graph Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.GraphEdge
	 * @generated
	 */
	public Adapter createGraphEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Diagram
	 * @generated
	 */
	public Adapter createDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.GraphNode <em>Graph Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.GraphNode
	 * @generated
	 */
	public Adapter createGraphNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.SimpleSemanticModelElement <em>Simple Semantic Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.SimpleSemanticModelElement
	 * @generated
	 */
	public Adapter createSimpleSemanticModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.UMASemanticModelBridge <em>UMA Semantic Model Bridge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.UMASemanticModelBridge
	 * @generated
	 */
	public Adapter createUMASemanticModelBridgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.CoreSemanticModelBridge <em>Core Semantic Model Bridge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.CoreSemanticModelBridge
	 * @generated
	 */
	public Adapter createCoreSemanticModelBridgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.LeafElement <em>Leaf Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.LeafElement
	 * @generated
	 */
	public Adapter createLeafElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.TextElement <em>Text Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.TextElement
	 * @generated
	 */
	public Adapter createTextElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Image
	 * @generated
	 */
	public Adapter createImageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.GraphicPrimitive <em>Graphic Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.GraphicPrimitive
	 * @generated
	 */
	public Adapter createGraphicPrimitiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Polyline <em>Polyline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Polyline
	 * @generated
	 */
	public Adapter createPolylineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Ellipse <em>Ellipse</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Ellipse
	 * @generated
	 */
	public Adapter createEllipseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Activity
	 * @generated
	 */
	public Adapter createActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.WorkBreakdownElement <em>Work Breakdown Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.WorkBreakdownElement
	 * @generated
	 */
	public Adapter createWorkBreakdownElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.BreakdownElement <em>Breakdown Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.BreakdownElement
	 * @generated
	 */
	public Adapter createBreakdownElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Milestone <em>Milestone</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Milestone
	 * @generated
	 */
	public Adapter createMilestoneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Iteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Iteration
	 * @generated
	 */
	public Adapter createIterationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Phase <em>Phase</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Phase
	 * @generated
	 */
	public Adapter createPhaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.TeamProfile <em>Team Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.TeamProfile
	 * @generated
	 */
	public Adapter createTeamProfileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.RoleDescriptor <em>Role Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.RoleDescriptor
	 * @generated
	 */
	public Adapter createRoleDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.WorkOrder <em>Work Order</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.WorkOrder
	 * @generated
	 */
	public Adapter createWorkOrderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcessElement <em>Process Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcessElement
	 * @generated
	 */
	public Adapter createProcessElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.PlanningData <em>Planning Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.PlanningData
	 * @generated
	 */
	public Adapter createPlanningDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Descriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Descriptor
	 * @generated
	 */
	public Adapter createDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.TaskDescriptor <em>Task Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.TaskDescriptor
	 * @generated
	 */
	public Adapter createTaskDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.WorkProductDescriptor <em>Work Product Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.WorkProductDescriptor
	 * @generated
	 */
	public Adapter createWorkProductDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.CompositeRole <em>Composite Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.CompositeRole
	 * @generated
	 */
	public Adapter createCompositeRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.BreakdownElementDescription <em>Breakdown Element Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.BreakdownElementDescription
	 * @generated
	 */
	public Adapter createBreakdownElementDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ActivityDescription <em>Activity Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ActivityDescription
	 * @generated
	 */
	public Adapter createActivityDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.DeliveryProcessDescription <em>Delivery Process Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.DeliveryProcessDescription
	 * @generated
	 */
	public Adapter createDeliveryProcessDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcessDescription <em>Process Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcessDescription
	 * @generated
	 */
	public Adapter createProcessDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.DescriptorDescription <em>Descriptor Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.DescriptorDescription
	 * @generated
	 */
	public Adapter createDescriptorDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Concept <em>Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Concept
	 * @generated
	 */
	public Adapter createConceptAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Checklist <em>Checklist</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Checklist
	 * @generated
	 */
	public Adapter createChecklistAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Example <em>Example</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Example
	 * @generated
	 */
	public Adapter createExampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Guideline <em>Guideline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Guideline
	 * @generated
	 */
	public Adapter createGuidelineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.EstimationConsiderations <em>Estimation Considerations</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.EstimationConsiderations
	 * @generated
	 */
	public Adapter createEstimationConsiderationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Report <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Report
	 * @generated
	 */
	public Adapter createReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Template
	 * @generated
	 */
	public Adapter createTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.SupportingMaterial <em>Supporting Material</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.SupportingMaterial
	 * @generated
	 */
	public Adapter createSupportingMaterialAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ToolMentor <em>Tool Mentor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ToolMentor
	 * @generated
	 */
	public Adapter createToolMentorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Whitepaper <em>Whitepaper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Whitepaper
	 * @generated
	 */
	public Adapter createWhitepaperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.TermDefinition <em>Term Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.TermDefinition
	 * @generated
	 */
	public Adapter createTermDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Practice <em>Practice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Practice
	 * @generated
	 */
	public Adapter createPracticeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ReusableAsset <em>Reusable Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ReusableAsset
	 * @generated
	 */
	public Adapter createReusableAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Vertex <em>Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Vertex
	 * @generated
	 */
	public Adapter createVertexAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Region
	 * @generated
	 */
	public Adapter createRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.StateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.StateMachine
	 * @generated
	 */
	public Adapter createStateMachineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Transition
	 * @generated
	 */
	public Adapter createTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.PseudoState <em>Pseudo State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.PseudoState
	 * @generated
	 */
	public Adapter createPseudoStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Discipline <em>Discipline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Discipline
	 * @generated
	 */
	public Adapter createDisciplineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ContentCategory <em>Content Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ContentCategory
	 * @generated
	 */
	public Adapter createContentCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.RoleSet <em>Role Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.RoleSet
	 * @generated
	 */
	public Adapter createRoleSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Domain
	 * @generated
	 */
	public Adapter createDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.PruebasLineas <em>Pruebas Lineas</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.PruebasLineas
	 * @generated
	 */
	public Adapter createPruebasLineasAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.WorkProductType <em>Work Product Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.WorkProductType
	 * @generated
	 */
	public Adapter createWorkProductTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.DisciplineGrouping <em>Discipline Grouping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.DisciplineGrouping
	 * @generated
	 */
	public Adapter createDisciplineGroupingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Tool <em>Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Tool
	 * @generated
	 */
	public Adapter createToolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.RoleSetGrouping <em>Role Set Grouping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.RoleSetGrouping
	 * @generated
	 */
	public Adapter createRoleSetGroupingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.CustomCategory <em>Custom Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.CustomCategory
	 * @generated
	 */
	public Adapter createCustomCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.DeliveryProcess <em>Delivery Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.DeliveryProcess
	 * @generated
	 */
	public Adapter createDeliveryProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Process
	 * @generated
	 */
	public Adapter createProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.CapabilityPattern <em>Capability Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.CapabilityPattern
	 * @generated
	 */
	public Adapter createCapabilityPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcessPlanningTemplate <em>Process Planning Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcessPlanningTemplate
	 * @generated
	 */
	public Adapter createProcessPlanningTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Roadmap <em>Roadmap</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Roadmap
	 * @generated
	 */
	public Adapter createRoadmapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcessComponent <em>Process Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcessComponent
	 * @generated
	 */
	public Adapter createProcessComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcessPackage <em>Process Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcessPackage
	 * @generated
	 */
	public Adapter createProcessPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcessComponentInterface <em>Process Component Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcessComponentInterface
	 * @generated
	 */
	public Adapter createProcessComponentInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcessComponentDescriptor <em>Process Component Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcessComponentDescriptor
	 * @generated
	 */
	public Adapter createProcessComponentDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.MethodPlugin <em>Method Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.MethodPlugin
	 * @generated
	 */
	public Adapter createMethodPluginAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcessLinesPackage <em>Process Lines Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcessLinesPackage
	 * @generated
	 */
	public Adapter createProcessLinesPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcessLineElement <em>Process Line Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcessLineElement
	 * @generated
	 */
	public Adapter createProcessLineElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcessLineComponent <em>Process Line Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcessLineComponent
	 * @generated
	 */
	public Adapter createProcessLineComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcessLineComponentPackage <em>Process Line Component Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcessLineComponentPackage
	 * @generated
	 */
	public Adapter createProcessLineComponentPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcessLineComponentInterface <em>Process Line Component Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcessLineComponentInterface
	 * @generated
	 */
	public Adapter createProcessLineComponentInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.CoreProcessPackage <em>Core Process Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.CoreProcessPackage
	 * @generated
	 */
	public Adapter createCoreProcessPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.TailoredProcess <em>Tailored Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.TailoredProcess
	 * @generated
	 */
	public Adapter createTailoredProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.TailoredProcessesPackage <em>Tailored Processes Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.TailoredProcessesPackage
	 * @generated
	 */
	public Adapter createTailoredProcessesPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.TailoredProcessComponent <em>Tailored Process Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.TailoredProcessComponent
	 * @generated
	 */
	public Adapter createTailoredProcessComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.TailoredCoreProcessPackage <em>Tailored Core Process Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.TailoredCoreProcessPackage
	 * @generated
	 */
	public Adapter createTailoredCoreProcessPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VariationsPackage <em>Variations Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VariationsPackage
	 * @generated
	 */
	public Adapter createVariationsPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VariantsPackage <em>Variants Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VariantsPackage
	 * @generated
	 */
	public Adapter createVariantsPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VarPointsPackage <em>Var Points Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VarPointsPackage
	 * @generated
	 */
	public Adapter createVarPointsPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.LineProcess <em>Line Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.LineProcess
	 * @generated
	 */
	public Adapter createLineProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VariabilityElement <em>Variability Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VariabilityElement
	 * @generated
	 */
	public Adapter createVariabilityElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.MethodUnit <em>Method Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.MethodUnit
	 * @generated
	 */
	public Adapter createMethodUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.MethodConfiguration <em>Method Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.MethodConfiguration
	 * @generated
	 */
	public Adapter createMethodConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcessFamily <em>Process Family</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcessFamily
	 * @generated
	 */
	public Adapter createProcessFamilyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.MethodLibrary <em>Method Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.MethodLibrary
	 * @generated
	 */
	public Adapter createMethodLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Variability <em>Variability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Variability
	 * @generated
	 */
	public Adapter createVariabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VarElement <em>Var Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VarElement
	 * @generated
	 */
	public Adapter createVarElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VarPoint <em>Var Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VarPoint
	 * @generated
	 */
	public Adapter createVarPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Variant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Variant
	 * @generated
	 */
	public Adapter createVariantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VarActivity <em>Var Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VarActivity
	 * @generated
	 */
	public Adapter createVarActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VarPhase <em>Var Phase</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VarPhase
	 * @generated
	 */
	public Adapter createVarPhaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VarIteration <em>Var Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VarIteration
	 * @generated
	 */
	public Adapter createVarIterationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VarRoleDescriptor <em>Var Role Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VarRoleDescriptor
	 * @generated
	 */
	public Adapter createVarRoleDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VarTaskDescriptor <em>Var Task Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VarTaskDescriptor
	 * @generated
	 */
	public Adapter createVarTaskDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VarMilestone <em>Var Milestone</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VarMilestone
	 * @generated
	 */
	public Adapter createVarMilestoneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VarTeamProfile <em>Var Team Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VarTeamProfile
	 * @generated
	 */
	public Adapter createVarTeamProfileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VarWorkProductDescriptor <em>Var Work Product Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VarWorkProductDescriptor
	 * @generated
	 */
	public Adapter createVarWorkProductDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcAspect <em>Proc Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcAspect
	 * @generated
	 */
	public Adapter createProcAspectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VariantsListPackage <em>Variants List Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VariantsListPackage
	 * @generated
	 */
	public Adapter createVariantsListPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Variation <em>Variation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Variation
	 * @generated
	 */
	public Adapter createVariationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Occupation <em>Occupation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Occupation
	 * @generated
	 */
	public Adapter createOccupationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcAdvice <em>Proc Advice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcAdvice
	 * @generated
	 */
	public Adapter createProcAdviceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcPointcut <em>Proc Pointcut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcPointcut
	 * @generated
	 */
	public Adapter createProcPointcutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Dependences <em>Dependences</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Dependences
	 * @generated
	 */
	public Adapter createDependencesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.variant2varP <em>variant2var P</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.variant2varP
	 * @generated
	 */
	public Adapter createvariant2varPAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.variant2variant <em>variant2variant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.variant2variant
	 * @generated
	 */
	public Adapter createvariant2variantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.varp2variant <em>varp2variant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.varp2variant
	 * @generated
	 */
	public Adapter createvarp2variantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.varP2varP <em>var P2var P</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.varP2varP
	 * @generated
	 */
	public Adapter createvarP2varPAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.ProcessLine <em>Process Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.ProcessLine
	 * @generated
	 */
	public Adapter createProcessLineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.VariationType <em>Variation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.VariationType
	 * @generated
	 */
	public Adapter createVariationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Optative <em>Optative</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Optative
	 * @generated
	 */
	public Adapter createOptativeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Mandatory <em>Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Mandatory
	 * @generated
	 */
	public Adapter createMandatoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.Optional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.Optional
	 * @generated
	 */
	public Adapter createOptionalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.vpIteration <em>vp Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.vpIteration
	 * @generated
	 */
	public Adapter createvpIterationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.vpRoleDescriptor <em>vp Role Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.vpRoleDescriptor
	 * @generated
	 */
	public Adapter createvpRoleDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.vpTaskDescriptor <em>vp Task Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.vpTaskDescriptor
	 * @generated
	 */
	public Adapter createvpTaskDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.vpMilestone <em>vp Milestone</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.vpMilestone
	 * @generated
	 */
	public Adapter createvpMilestoneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.vpTeamProfile <em>vp Team Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.vpTeamProfile
	 * @generated
	 */
	public Adapter createvpTeamProfileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.vpWorkProductDescriptor <em>vp Work Product Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.vpWorkProductDescriptor
	 * @generated
	 */
	public Adapter createvpWorkProductDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.vIteration <em>vIteration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.vIteration
	 * @generated
	 */
	public Adapter createvIterationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.vPhase <em>vPhase</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.vPhase
	 * @generated
	 */
	public Adapter createvPhaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.vpPhase <em>vp Phase</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.vpPhase
	 * @generated
	 */
	public Adapter createvpPhaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.vActivity <em>vActivity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.vActivity
	 * @generated
	 */
	public Adapter createvActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epf.uma.vpActivity <em>vp Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epf.uma.vpActivity
	 * @generated
	 */
	public Adapter createvpActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //UmaAdapterFactory