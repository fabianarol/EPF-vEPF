package org.eclipse.emf.codegen.ecore.templates.edit;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class ItemProvider_
{
  protected static String nl;
  public static synchronized ItemProvider_ create(String lineSeparator)
  {
    nl = lineSeparator;
    ItemProvider_ result = new ItemProvider_();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "//------------------------------------------------------------------------------" + NL + "// Copyright (c) 2005, 2006 IBM Corporation and others." + NL + "// All rights reserved. This program and the accompanying materials" + NL + "// are made available under the terms of the Eclipse Public License v1.0" + NL + "// which accompanies this distribution, and is available at" + NL + "// http://www.eclipse.org/legal/epl-v10.html" + NL + "//" + NL + "// Contributors:" + NL + "// IBM Corporation - initial implementation" + NL + "//------------------------------------------------------------------------------" + NL + "package ";
  protected final String TEXT_3 = ";" + NL + NL;
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * This is the item provider adapter for a {@link ";
  protected final String TEXT_5 = "} object." + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = NL + "\textends ";
  protected final String TEXT_7 = NL + "\timplements";
  protected final String TEXT_8 = "\t" + NL + "\t\t";
  protected final String TEXT_9 = ",";
  protected final String TEXT_10 = "\t\t" + NL + "{";
  protected final String TEXT_11 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_12 = " copyright = ";
  protected final String TEXT_13 = ";";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL + "\t/**" + NL + "\t * This constructs an instance from a factory and a notifier." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_16 = "(AdapterFactory adapterFactory)" + NL + "\t{" + NL + "\t\tsuper(adapterFactory);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * This returns the property descriptors for the adapted class." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_17 = NL + "\t@Override";
  protected final String TEXT_18 = NL + "\tpublic ";
  protected final String TEXT_19 = " getPropertyDescriptors(Object object)" + NL + "\t{" + NL + "\t\tif (itemPropertyDescriptors == null)" + NL + "\t\t{" + NL + "\t\t\tsuper.getPropertyDescriptors(object);" + NL;
  protected final String TEXT_20 = NL + "\t\t\tadd";
  protected final String TEXT_21 = "PropertyDescriptor(object);";
  protected final String TEXT_22 = NL + "\t\t}" + NL + "\t\treturn itemPropertyDescriptors;" + NL + "\t}" + NL;
  protected final String TEXT_23 = NL + "\t/**" + NL + "\t * This adds a property descriptor for the ";
  protected final String TEXT_24 = " feature." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void add";
  protected final String TEXT_25 = "PropertyDescriptor(Object object)" + NL + "\t{" + NL + "\t\titemPropertyDescriptors.add" + NL + "\t\t\t(createItemPropertyDescriptor" + NL + "\t\t\t\t(((";
  protected final String TEXT_26 = ")adapterFactory).getRootAdapterFactory()," + NL + "\t\t\t\t getResourceLocator()," + NL + "\t\t\t\t getString(\"_UI_";
  protected final String TEXT_27 = "_";
  protected final String TEXT_28 = "_feature\"),";
  protected final String TEXT_29 = NL + "\t\t\t\t getString(\"_UI_PropertyDescriptor_description\", \"_UI_";
  protected final String TEXT_30 = "_";
  protected final String TEXT_31 = "_feature\", \"_UI_";
  protected final String TEXT_32 = "_type\"),";
  protected final String TEXT_33 = NL + "\t\t\t\t getString(\"_UI_";
  protected final String TEXT_34 = "_";
  protected final String TEXT_35 = "_description\"),";
  protected final String TEXT_36 = NL + "\t\t\t\t ";
  protected final String TEXT_37 = "," + NL + "\t\t\t\t ";
  protected final String TEXT_38 = "," + NL + "\t\t\t\t ";
  protected final String TEXT_39 = "," + NL + "\t\t\t\t ";
  protected final String TEXT_40 = ",";
  protected final String TEXT_41 = NL + "\t\t\t\t null,";
  protected final String TEXT_42 = NL + "\t\t\t\t ";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = ",";
  protected final String TEXT_45 = NL + "\t\t\t\t null,";
  protected final String TEXT_46 = NL + "\t\t\t\t getString(\"";
  protected final String TEXT_47 = "\"),";
  protected final String TEXT_48 = NL + "\t\t\t\t null));";
  protected final String TEXT_49 = NL + "\t\t\t\t new String[] {";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\"";
  protected final String TEXT_51 = "\"";
  protected final String TEXT_52 = ",";
  protected final String TEXT_53 = NL + "\t\t\t\t }));";
  protected final String TEXT_54 = NL + "\t}" + NL;
  protected final String TEXT_55 = NL + "\t/**" + NL + "\t * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an" + NL + "\t * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or" + NL + "\t * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_56 = NL + "\t@Override";
  protected final String TEXT_57 = NL + "\tpublic ";
  protected final String TEXT_58 = " getChildrenFeatures(Object object)" + NL + "\t{" + NL + "\t\tif (childrenFeatures == null)" + NL + "\t\t{" + NL + "\t\t\tsuper.getChildrenFeatures(object);";
  protected final String TEXT_59 = NL + "\t\t\tchildrenFeatures.add(";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\t\t}" + NL + "\t\treturn childrenFeatures;" + NL + "\t}" + NL;
  protected final String TEXT_62 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_63 = NL + "\t@Override";
  protected final String TEXT_64 = NL + "\tprotected ";
  protected final String TEXT_65 = " getChildFeature(Object object, Object child)" + NL + "\t{" + NL + "\t\t// Check the type of the specified child object and return the proper feature to use for" + NL + "\t\t// adding (see {@link AddCommand}) it as a child." + NL + "" + NL + "\t\treturn super.getChildFeature(object, child);" + NL + "\t}" + NL;
  protected final String TEXT_66 = NL + "\t/**" + NL + "\t * This returns ";
  protected final String TEXT_67 = ".gif." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_68 = NL + "\t@Override";
  protected final String TEXT_69 = NL + "\tpublic Object getImage(Object object)" + NL + "\t{" + NL + "\t\treturn overlayImage(object, getResourceLocator().getImage(\"full/obj16/";
  protected final String TEXT_70 = "\"));";
  protected final String TEXT_71 = NL + "\t}" + NL;
  protected final String TEXT_72 = NL + "\t/**" + NL + "\t * This returns the label text for the adapted class." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_73 = NL + "\t@Override";
  protected final String TEXT_74 = NL + "\tpublic String getText(Object object)" + NL + "\t{";
  protected final String TEXT_75 = NL + "\t\t";
  protected final String TEXT_76 = "<?, ?>";
  protected final String TEXT_77 = " ";
  protected final String TEXT_78 = " = (";
  protected final String TEXT_79 = "<?, ?>";
  protected final String TEXT_80 = ")object;";
  protected final String TEXT_81 = NL + "\t\treturn \"\" + ";
  protected final String TEXT_82 = ".getKey() + \" -> \" + ";
  protected final String TEXT_83 = ".getValue();";
  protected final String TEXT_84 = NL + "\t\tString key = crop(\"\" + ";
  protected final String TEXT_85 = ".getKey());";
  protected final String TEXT_86 = NL + "\t\tString key = \"\" + ";
  protected final String TEXT_87 = ".getKey();";
  protected final String TEXT_88 = NL + "\t\tString value = crop(\"\" + ";
  protected final String TEXT_89 = ".getValue());";
  protected final String TEXT_90 = NL + "\t\tString value = \"\" + ";
  protected final String TEXT_91 = ".getValue();";
  protected final String TEXT_92 = NL + "\t\treturn key + \" -> \" + value;";
  protected final String TEXT_93 = NL + "\t\t";
  protected final String TEXT_94 = " ";
  protected final String TEXT_95 = " = (";
  protected final String TEXT_96 = ")object;" + NL + "\t\treturn getString(\"_UI_";
  protected final String TEXT_97 = "_type\") + \" \" + ";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = "();";
  protected final String TEXT_100 = NL + "\t\tString label = crop(((";
  protected final String TEXT_101 = ")object).";
  protected final String TEXT_102 = "());";
  protected final String TEXT_103 = NL + "\t\tString label = ((";
  protected final String TEXT_104 = ")object).";
  protected final String TEXT_105 = "();";
  protected final String TEXT_106 = NL + "\t\t";
  protected final String TEXT_107 = " labelValue = ((";
  protected final String TEXT_108 = ")object).eGet(";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + "\t\t";
  protected final String TEXT_111 = " labelValue = ((";
  protected final String TEXT_112 = ")object).";
  protected final String TEXT_113 = "();";
  protected final String TEXT_114 = NL + "\t\tString label = labelValue == null ? null : labelValue.toString();";
  protected final String TEXT_115 = NL + "\t\treturn label == null || label.length() == 0 ?" + NL + "\t\t\tgetString(\"_UI_";
  protected final String TEXT_116 = "_type\") :";
  protected final String TEXT_117 = NL + "\t\t\tgetString(\"_UI_";
  protected final String TEXT_118 = "_type\") + \" \" + label;";
  protected final String TEXT_119 = NL + "\t\treturn getString(\"_UI_";
  protected final String TEXT_120 = "_type\");";
  protected final String TEXT_121 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * This handles model notifications by calling {@link #updateChildren} to update any cached" + NL + "\t * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_122 = NL + "\t@Override";
  protected final String TEXT_123 = NL + "\tpublic void notifyChanged(Notification notification)" + NL + "\t{" + NL + "\t\tupdateChildren(notification);";
  protected final String TEXT_124 = NL + NL + "\t\tswitch (notification.getFeatureID(";
  protected final String TEXT_125 = ".class))" + NL + "\t\t{";
  protected final String TEXT_126 = NL + "\t\t\tcase ";
  protected final String TEXT_127 = ":";
  protected final String TEXT_128 = NL + "\t\t\t\tfireNotifyChanged(new ";
  protected final String TEXT_129 = "(notification, notification.getNotifier(), false, true));" + NL + "\t\t\t\treturn;";
  protected final String TEXT_130 = NL + "\t\t\tcase ";
  protected final String TEXT_131 = ":";
  protected final String TEXT_132 = NL + "\t\t\t\tfireNotifyChanged(new ";
  protected final String TEXT_133 = "(notification, notification.getNotifier(), true, false));" + NL + "\t\t\t\treturn;";
  protected final String TEXT_134 = NL + "\t\t\tcase ";
  protected final String TEXT_135 = ":";
  protected final String TEXT_136 = NL + "\t\t\t\tfireNotifyChanged(new ";
  protected final String TEXT_137 = "(notification, notification.getNotifier(), true, true));" + NL + "\t\t\t\treturn;";
  protected final String TEXT_138 = NL + "\t\t}";
  protected final String TEXT_139 = NL + "\t\tsuper.notifyChanged(notification);" + NL + "\t}" + NL;
  protected final String TEXT_140 = NL + "\t/**" + NL + "\t * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children" + NL + "\t * that can be created under this object." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_141 = NL + "\t@Override";
  protected final String TEXT_142 = NL + "\tprotected void collectNewChildDescriptors(";
  protected final String TEXT_143 = " newChildDescriptors, Object object)" + NL + "\t{" + NL + "\t\tsuper.collectNewChildDescriptors(newChildDescriptors, object);";
  protected final String TEXT_144 = NL + NL + "\t\tnewChildDescriptors.add" + NL + "\t\t\t(createChildParameter" + NL + "\t\t\t\t(";
  protected final String TEXT_145 = ",";
  protected final String TEXT_146 = NL + "\t\t\t\t ";
  protected final String TEXT_147 = ".create(";
  protected final String TEXT_148 = ")));";
  protected final String TEXT_149 = NL + "\t\t\t\t ";
  protected final String TEXT_150 = ".create";
  protected final String TEXT_151 = "()));";
  protected final String TEXT_152 = NL + NL + "\t\tnewChildDescriptors.add" + NL + "\t\t\t(createChildParameter" + NL + "\t\t\t\t(";
  protected final String TEXT_153 = "," + NL + "\t\t\t\t ";
  protected final String TEXT_154 = ".createEntry" + NL + "\t\t\t\t\t(";
  protected final String TEXT_155 = ",";
  protected final String TEXT_156 = NL + "\t\t\t\t\t ";
  protected final String TEXT_157 = ".create(";
  protected final String TEXT_158 = "))));";
  protected final String TEXT_159 = NL + "\t\t\t\t\t ";
  protected final String TEXT_160 = ".create";
  protected final String TEXT_161 = "())));";
  protected final String TEXT_162 = NL + NL + "\t\tnewChildDescriptors.add" + NL + "\t\t\t(createChildParameter" + NL + "\t\t\t\t(";
  protected final String TEXT_163 = "," + NL + "\t\t\t\t ";
  protected final String TEXT_164 = ".createEntry" + NL + "\t\t\t\t\t(";
  protected final String TEXT_165 = ",";
  protected final String TEXT_166 = NL + "\t\t\t\t\t ";
  protected final String TEXT_167 = ")));";
  protected final String TEXT_168 = NL + "\t\t\t\t\t ";
  protected final String TEXT_169 = ")));";
  protected final String TEXT_170 = NL + "\t\t\t\t\t ";
  protected final String TEXT_171 = ".createFromString(";
  protected final String TEXT_172 = ", ";
  protected final String TEXT_173 = "))));";
  protected final String TEXT_174 = " // TODO: ensure this is a valid literal value";
  protected final String TEXT_175 = NL + NL + "\t\tnewChildDescriptors.add" + NL + "\t\t\t(createChildParameter" + NL + "\t\t\t\t(";
  protected final String TEXT_176 = ",";
  protected final String TEXT_177 = NL + "\t\t\t\t ";
  protected final String TEXT_178 = ".create(";
  protected final String TEXT_179 = ")));";
  protected final String TEXT_180 = NL + "\t\t\t\t ";
  protected final String TEXT_181 = ".create";
  protected final String TEXT_182 = "()));";
  protected final String TEXT_183 = NL + NL + "\t\tnewChildDescriptors.add" + NL + "\t\t\t(createChildParameter" + NL + "\t\t\t\t(";
  protected final String TEXT_184 = ",";
  protected final String TEXT_185 = NL + "\t\t\t\t ";
  protected final String TEXT_186 = "));";
  protected final String TEXT_187 = NL + "\t\t\t\t ";
  protected final String TEXT_188 = "));";
  protected final String TEXT_189 = NL + "\t\t\t\t ";
  protected final String TEXT_190 = ".createFromString(";
  protected final String TEXT_191 = ", ";
  protected final String TEXT_192 = ")));";
  protected final String TEXT_193 = " // TODO: ensure this is a valid literal value";
  protected final String TEXT_194 = NL + "\t}" + NL;
  protected final String TEXT_195 = NL + "\t/**" + NL + "\t * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_196 = NL + "\t@Override";
  protected final String TEXT_197 = NL + "\tpublic String getCreateChildText(Object owner, Object feature, Object child, ";
  protected final String TEXT_198 = " selection)" + NL + "\t{" + NL + "\t\tObject childFeature = feature;" + NL + "\t\tObject childObject = child;" + NL;
  protected final String TEXT_199 = NL + "\t\tif (childFeature instanceof ";
  protected final String TEXT_200 = " && ";
  protected final String TEXT_201 = ".isFeatureMap((EStructuralFeature)childFeature))" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_202 = ".Entry entry = (FeatureMap.Entry)childObject;" + NL + "\t\t\tchildFeature = entry.getEStructuralFeature();" + NL + "\t\t\tchildObject = entry.getValue();" + NL + "\t\t}" + NL;
  protected final String TEXT_203 = NL + "\t\tboolean qualify =";
  protected final String TEXT_204 = NL + "\t\t\tchildFeature == ";
  protected final String TEXT_205 = NL + NL + "\t\tif (qualify)" + NL + "\t\t{" + NL + "\t\t\treturn getString" + NL + "\t\t\t\t(\"_UI_CreateChild_text2\",";
  protected final String TEXT_206 = NL + "\t\t\t\t new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });" + NL + "\t\t}" + NL + "\t\treturn super.getCreateChildText(owner, feature, child, selection);" + NL + "\t}" + NL;
  protected final String TEXT_207 = NL + "\t/**" + NL + "\t * This returns the icon image for {@link org.eclipse.emf.edit.command.CreateChildCommand}." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_208 = NL + "\t@Override";
  protected final String TEXT_209 = NL + "\tpublic Object getCreateChildImage(Object owner, Object feature, Object child, ";
  protected final String TEXT_210 = " selection)" + NL + "\t{" + NL + "\t\tif (feature instanceof ";
  protected final String TEXT_211 = " && ";
  protected final String TEXT_212 = ".isFeatureMap((";
  protected final String TEXT_213 = ")feature))" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_214 = ".Entry entry = (";
  protected final String TEXT_215 = ".Entry)child;" + NL + "\t\t\tfeature = entry.getEStructuralFeature();" + NL + "\t\t\tchild = entry.getValue();        " + NL + "\t\t}" + NL + "" + NL + "\t\tif (feature instanceof ";
  protected final String TEXT_216 = " && child instanceof ";
  protected final String TEXT_217 = ")" + NL + "\t\t{" + NL + "\t\t\tString name = \"full/obj16/\" + ((EObject)child).eClass().getName();";
  protected final String TEXT_218 = NL + NL + "\t\t\ttry" + NL + "\t\t\t{" + NL + "\t\t\t\treturn getResourceLocator().getImage(name);" + NL + "\t\t\t}" + NL + "\t\t\tcatch (Exception e)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_219 = ".INSTANCE.log(e);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\treturn super.getCreateChildImage(owner, feature, child, selection);" + NL + "\t}" + NL;
  protected final String TEXT_220 = NL + "\t/**" + NL + "\t * Return the resource locator for this item provider's resources." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_221 = NL + "\t@Override";
  protected final String TEXT_222 = NL + "\tpublic ResourceLocator getResourceLocator()" + NL + "\t{" + NL + "\t\treturn ";
  protected final String TEXT_223 = ".INSTANCE;" + NL + "\t}" + NL;
  protected final String TEXT_224 = NL + "}";
  protected final String TEXT_225 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
/**
 * <copyright>
 *
 * Copyright (c) 2002-2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 */

    GenClass genClass = (GenClass)argument; GenPackage genPackage = genClass.getGenPackage(); GenModel genModel=genPackage.getGenModel();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genPackage.getProviderPackageName());
    stringBuffer.append(TEXT_3);
    genModel.addImport("org.eclipse.emf.common.notify.AdapterFactory");
    genModel.addImport("org.eclipse.emf.common.notify.Notification");
    genModel.addImport("org.eclipse.emf.common.util.ResourceLocator");
    genModel.addImport("org.eclipse.emf.edit.provider.IEditingDomainItemProvider");
    genModel.addImport("org.eclipse.emf.edit.provider.IItemLabelProvider");
    genModel.addImport("org.eclipse.emf.edit.provider.IItemPropertySource");
    genModel.addImport("org.eclipse.emf.edit.provider.IStructuredItemContentProvider");
    genModel.addImport("org.eclipse.emf.edit.provider.ITreeItemContentProvider");
    String _List = genModel.getImportedName(genModel.useGenerics() ? "java.util.List<org.eclipse.emf.edit.provider.IItemPropertyDescriptor>" : "java.util.List");
    genModel.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genClass.getProviderClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genClass.getProviderBaseClassName() != null ? genClass.getProviderBaseClassName() : genModel.getImportedName("org.eclipse.emf.edit.provider.ItemProviderAdapter"));
    stringBuffer.append(TEXT_7);
    for (Iterator<String> i = genPackage.getProviderSupportedTypes().iterator(); i.hasNext(); ) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genModel.getImportedName(i.next()));
    if (i.hasNext()){
    stringBuffer.append(TEXT_9);
    }
    }
    stringBuffer.append(TEXT_10);
    if (genModel.hasCopyrightField()) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genModel.getCopyrightFieldLiteral());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genClass.getProviderClassName());
    stringBuffer.append(TEXT_16);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(_List);
    stringBuffer.append(TEXT_19);
    for (GenFeature genFeature : genClass.getPropertyFeatures()) { 
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    for (GenFeature genFeature : genClass.getPropertyFeatures()) { 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ComposeableAdapterFactory"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genFeature.getGenClass().getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genModel.getNonNLS());
    if (genFeature.getPropertyDescription() == null || genFeature.getPropertyDescription().length() == 0) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genFeature.getGenClass().getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genFeature.getGenClass().getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(genModel.getNonNLS(3));
    } else {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genFeature.getGenClass().getName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genModel.getNonNLS());
    }
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genFeature.getProperty() == GenPropertyKind.EDITABLE_LITERAL ? "true" : "false");
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genFeature.isPropertyMultiLine() ? "true" : "false");
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genFeature.isPropertySortChoices() ? "true" : "false");
    stringBuffer.append(TEXT_40);
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_41);
    } else {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ItemPropertyDescriptor"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genFeature.getPropertyImageName());
    stringBuffer.append(TEXT_44);
    }
    if (genFeature.getPropertyCategory() == null || genFeature.getPropertyCategory().length() == 0) {
    stringBuffer.append(TEXT_45);
    } else {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genModel.getPropertyCategoryKey(genFeature.getPropertyCategory()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genModel.getNonNLS());
    }
    if (genFeature.getPropertyFilterFlags().isEmpty()) {
    stringBuffer.append(TEXT_48);
    } else {
    stringBuffer.append(TEXT_49);
    for (Iterator<String> j = genFeature.getPropertyFilterFlags().iterator(); j.hasNext();) { String filterFlag = j.next();
    if (filterFlag != null && filterFlag.length() > 0) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(filterFlag);
    stringBuffer.append(TEXT_51);
    if (j.hasNext()) {
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(genModel.getNonNLS());
    }
    }
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    }
    if (!genClass.getChildrenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_55);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(genModel.getImportedName(genModel.useGenerics() ? "java.util.Collection<? extends org.eclipse.emf.ecore.EStructuralFeature>" : "java.util.Collection"));
    stringBuffer.append(TEXT_58);
    for (GenFeature genFeature : genClass.getChildrenFeatures()) { 
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(TEXT_61);
    if (!genClass.getChildrenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_62);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_65);
    }
    }
    if (genClass.isImage()) {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_67);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    if (genClass.isMapEntry()) {
    stringBuffer.append(TEXT_75);
    stringBuffer.append(genClass.getImportedInterfaceName());
    if (genModel.useGenerics()) {
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(genClass.getImportedInterfaceName());
    if (genModel.useGenerics()) {
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    if (!genClass.getMapEntryKeyFeature().isPropertyMultiLine() && !genClass.getMapEntryValueFeature().isPropertyMultiLine()) {
    stringBuffer.append(TEXT_81);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    } else {
    if (genClass.getMapEntryKeyFeature().isPropertyMultiLine()) {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(genModel.getNonNLS());
    }
    if (genClass.getMapEntryValueFeature().isPropertyMultiLine()) {
    stringBuffer.append(TEXT_88);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(genModel.getNonNLS());
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(genModel.getNonNLS());
    }
    } else if (genClass.getLabelFeature() != null) { GenFeature labelFeature = genClass.getLabelFeature();
    if (labelFeature.isPrimitiveType() && !labelFeature.getGenClass().isDynamic() && !labelFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(genClass.getLabelFeature().getGetAccessor());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    } else {
    if (labelFeature.isStringType() && !labelFeature.getGenClass().isDynamic() && !labelFeature.isSuppressedGetVisibility()) {
    if (labelFeature.isPropertyMultiLine()) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(labelFeature.getGetAccessor());
    stringBuffer.append(TEXT_102);
    } else {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(labelFeature.getGetAccessor());
    stringBuffer.append(TEXT_105);
    }
    } else {
    if (labelFeature.isSuppressedGetVisibility() || labelFeature.getGenClass().isDynamic()) {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(genModel.getImportedName("java.lang.Object"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(labelFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_109);
    } else {
    stringBuffer.append(TEXT_110);
    stringBuffer.append(labelFeature.getRawImportedType());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(labelFeature.getGetAccessor());
    stringBuffer.append(TEXT_113);
    }
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    }
    } else {
    stringBuffer.append(TEXT_119);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(genModel.getNonNLS());
    }
    stringBuffer.append(TEXT_121);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_122);
    }
    stringBuffer.append(TEXT_123);
    if (!genClass.getLabelNotifyFeatures().isEmpty() || !genClass.getContentNotifyFeatures().isEmpty() || !genClass.getLabelAndContentNotifyFeatures().isEmpty()) {
    stringBuffer.append(TEXT_124);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_125);
    if (!genClass.getLabelNotifyFeatures().isEmpty()) {
    for (GenFeature genFeature : genClass.getLabelNotifyFeatures()) { 
    stringBuffer.append(TEXT_126);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(TEXT_128);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
    stringBuffer.append(TEXT_129);
    }
    if (!genClass.getContentNotifyFeatures().isEmpty()) {
    for (GenFeature genFeature : genClass.getContentNotifyFeatures()) { 
    stringBuffer.append(TEXT_130);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
    stringBuffer.append(TEXT_133);
    }
    if (!genClass.getLabelAndContentNotifyFeatures().isEmpty()) {
    for (GenFeature genFeature : genClass.getLabelAndContentNotifyFeatures()) { 
    stringBuffer.append(TEXT_134);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
    stringBuffer.append(TEXT_137);
    }
    stringBuffer.append(TEXT_138);
    }
    stringBuffer.append(TEXT_139);
    if (genModel.isCreationCommands()) {
    stringBuffer.append(TEXT_140);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    stringBuffer.append(genModel.getImportedName(genModel.useGenerics() ? "java.util.Collection<java.lang.Object>" : "java.util.Collection"));
    stringBuffer.append(TEXT_143);
    for (GenFeature createFeature : genClass.getCrossPackageCreateChildFeatures()) { 
    for (GenClass createClass : genClass.getCrossPackageChildrenClasses(createFeature)) { 
    stringBuffer.append(TEXT_144);
    stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_145);
    if (createClass.isMapEntry()) { 
    stringBuffer.append(TEXT_146);
    stringBuffer.append(createClass.getGenPackage().getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(createClass.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_148);
    } else {
    stringBuffer.append(TEXT_149);
    stringBuffer.append(createClass.getGenPackage().getQualifiedFactoryInstanceAccessor());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(createClass.getName());
    stringBuffer.append(TEXT_151);
    }
    //ItemProvider/newChildDescriptorsCrossPackageFeature.override.javajetinc
    }
    }
    for (GenFeature createFeature : genClass.getCreateChildFeatures()) { 
    if (createFeature.isFeatureMapType()) {
    for (GenFeature delegatedFeature : createFeature.getDelegatedFeatures()) { 
    if (delegatedFeature.isReferenceType()) {
    for (GenClass createClass : genClass.getChildrenClasses(delegatedFeature)) { 
    stringBuffer.append(TEXT_152);
    stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(delegatedFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_155);
    if (createClass.isMapEntry()) { 
    stringBuffer.append(TEXT_156);
    stringBuffer.append(createClass.getGenPackage().getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_157);
    stringBuffer.append(createClass.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_158);
    } else {
    stringBuffer.append(TEXT_159);
    stringBuffer.append(createClass.getGenPackage().getQualifiedFactoryInstanceAccessor());
    stringBuffer.append(TEXT_160);
    stringBuffer.append(createClass.getName());
    stringBuffer.append(TEXT_161);
    }
    }
    //ItemProvider/newChildDescriptorsReferenceDelegatedFeature.override.javajetinc
    } else {
    stringBuffer.append(TEXT_162);
    stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(delegatedFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_165);
    if (delegatedFeature.isEnumBasedType()) {
    stringBuffer.append(TEXT_166);
    stringBuffer.append(delegatedFeature.getTypeGenEnum().getStaticValue(delegatedFeature.getEcoreFeature().getDefaultValueLiteral()));
    stringBuffer.append(TEXT_167);
    } else if (delegatedFeature.isStringBasedType()) {
    stringBuffer.append(TEXT_168);
    stringBuffer.append(delegatedFeature.getCreateChildValueLiteral());
    stringBuffer.append(TEXT_169);
    stringBuffer.append(genModel.getNonNLS());
    } else { String literal = delegatedFeature.getCreateChildValueLiteral(); GenDataType createDataType = delegatedFeature.getTypeGenDataType();
    stringBuffer.append(TEXT_170);
    stringBuffer.append(createDataType.getGenPackage().getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_171);
    stringBuffer.append(createDataType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(literal);
    stringBuffer.append(TEXT_173);
    if (literal != null) {
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_174);
    }
    }
    //ItemProvider/newChildDescriptorsAttributeDelegatedFeature.override.javajetinc
    }
    }
    } else if (createFeature.isReferenceType()) {
    for (GenClass createClass : genClass.getChildrenClasses(createFeature)) { 
    stringBuffer.append(TEXT_175);
    stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_176);
    if (createClass.isMapEntry()) { 
    stringBuffer.append(TEXT_177);
    stringBuffer.append(createClass.getGenPackage().getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_178);
    stringBuffer.append(createClass.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_179);
    } else {
    stringBuffer.append(TEXT_180);
    stringBuffer.append(createClass.getGenPackage().getQualifiedFactoryInstanceAccessor());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(createClass.getName());
    stringBuffer.append(TEXT_182);
    }
    }
    //ItemProvider/newChildDescriptorsReferenceFeature.override.javajetinc 
    } else {
    stringBuffer.append(TEXT_183);
    stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_184);
    if (createFeature.isEnumBasedType()) {
    stringBuffer.append(TEXT_185);
    stringBuffer.append(createFeature.getTypeGenEnum().getStaticValue(createFeature.getEcoreFeature().getDefaultValueLiteral()));
    stringBuffer.append(TEXT_186);
    } else if (createFeature.isStringBasedType()) {
    stringBuffer.append(TEXT_187);
    stringBuffer.append(createFeature.getCreateChildValueLiteral());
    stringBuffer.append(TEXT_188);
    stringBuffer.append(genModel.getNonNLS());
    } else { String literal = createFeature.getCreateChildValueLiteral(); GenDataType createDataType = createFeature.getTypeGenDataType();
    stringBuffer.append(TEXT_189);
    stringBuffer.append(createDataType.getGenPackage().getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(createDataType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(literal);
    stringBuffer.append(TEXT_192);
    if (literal != null) {
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_193);
    }
    }
    //ItemProvider/newChildDescriptorsAttributeFeature.override.javajetinc
    }
    }
    stringBuffer.append(TEXT_194);
    if (!genClass.getSharedClassCreateChildFeatures().isEmpty()) {
    stringBuffer.append(TEXT_195);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_196);
    }
    stringBuffer.append(TEXT_197);
    stringBuffer.append(genModel.getImportedName(genModel.useGenerics() ? "java.util.Collection<?>" : "java.util.Collection"));
    stringBuffer.append(TEXT_198);
    if (genClass.hasFeatureMapCreateChildFeatures()) {
    stringBuffer.append(TEXT_199);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_202);
    }
    stringBuffer.append(TEXT_203);
    for (Iterator<GenFeature> i = genClass.getSharedClassCreateChildFeatures().iterator(); i.hasNext();) { GenFeature createFeature = i.next();
    stringBuffer.append(TEXT_204);
    stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(i.hasNext() ? " ||" : ";");
    }
    stringBuffer.append(TEXT_205);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_206);
    }
    if (!genModel.isCreationIcons() && genClass.isModelRoot()) {
    stringBuffer.append(TEXT_207);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_208);
    }
    stringBuffer.append(TEXT_209);
    stringBuffer.append(genModel.getImportedName(genModel.useGenerics() ? "java.util.Collection<?>" : "java.util.Collection"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EReference"));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(genClass.getGenPackage().getImportedEditPluginClassName());
    stringBuffer.append(TEXT_219);
    }
    }
    stringBuffer.append(TEXT_220);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_221);
    }
    stringBuffer.append(TEXT_222);
    stringBuffer.append(genPackage.getImportedEditPluginClassName());
    stringBuffer.append(TEXT_223);
    stringBuffer.append(TEXT_224);
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_225);
    return stringBuffer.toString();
  }
}
